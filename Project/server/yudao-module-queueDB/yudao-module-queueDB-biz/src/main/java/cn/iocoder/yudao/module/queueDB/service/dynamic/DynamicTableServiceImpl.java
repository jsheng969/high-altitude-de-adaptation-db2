package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.hutool.db.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
import cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig.ModuleConfigMapper;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DynamicTableServiceImpl implements DynamicTableService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private FieldConfigMapper fieldConfigMapper;

    @Resource
    private ModuleConfigMapper moduleConfigMapper;

    @Resource
    private ExcelParseService excelParseService;

    // 系统字段定义
    private static final List<String> SYSTEM_COLUMNS = Arrays.asList(
            "id", "creator", "create_time", "updater", "update_time", "deleted", "tenant_id"
    );

    // 系统字段SQL模板
    private static final String SYSTEM_FIELDS_SQL =
            "id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键', " +
                    "creator VARCHAR(64) DEFAULT '' COMMENT '创建者', " +
                    "create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', " +
                    "updater VARCHAR(64) DEFAULT '' COMMENT '更新者', " +
                    "update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', " +
                    "deleted BIT(1) NOT NULL DEFAULT b'0' COMMENT '是否删除', " +
                    "tenant_id BIGINT NOT NULL DEFAULT '0' COMMENT '租户编号'";

    /**
     * 根据模块配置动态创建或修改表结构
     * 如果存在父级，则创建的表名为 dyn_+父级的modulecode，并统计所有子模块的字段
     */
    @Override
    public void createOrUpdateTable(String moduleCode) {
        try {
            // 1. 查询模块配置
            ModuleConfigDO module = moduleConfigMapper.selectOne(
                    new LambdaQueryWrapperX<ModuleConfigDO>()
                            .eq(ModuleConfigDO::getModuleCode, moduleCode));
            if (module == null) {
                log.warn("模块 [{}] 不存在，跳过创建表", moduleCode);
                return;
            }

            // 2. 确定表名
            String tableName;
            List<FieldConfigDO> allFields;

            if (module.getParentId() != null && module.getParentId() > 0) {
                // 如果有父级，使用父级的表名，并获取所有子模块字段
                ModuleConfigDO parentModule = moduleConfigMapper.selectById(module.getParentId());
                if (parentModule == null) {
                    log.warn("父级模块不存在，使用当前模块表名: {}", moduleCode);
                    tableName = "dyn_" + moduleCode.toLowerCase();
                    allFields = fieldConfigMapper.selectListByModuleCode(moduleCode);
                } else {
                    tableName = "dyn_" + parentModule.getModuleCode().toLowerCase();
                    // 获取父级模块下所有子模块的字段（包括父级自己）
                    allFields = getAllFieldsByParentModule(parentModule.getId(), parentModule.getModuleCode());
                }
            } else {
                // 没有父级，使用当前模块表名，并获取所有子模块字段
                tableName = "dyn_" + moduleCode.toLowerCase();
                allFields = getAllFieldsByParentModule(module.getId(), moduleCode);
            }

            if (allFields == null || allFields.isEmpty()) {
                log.warn("模块 [{}] 及其子模块未配置字段，跳过创建表", moduleCode);
                return;
            }

            // 3. 检查表是否存在，如果存在则删除
            boolean exists = tableExists(tableName);
            if (exists) {
                dropTableByModuleCode(moduleCode);
            }

            // 4. 创建新表
            createNewTable(tableName, allFields);

            // 5. 更新所有相关模块的表名
            updateTableNameForRelatedModules(module, tableName);

            log.info("成功创建表 [{}]，包含 {} 个字段", tableName, allFields.size());

        } catch (Exception e) {
            log.error("创建或更新表失败，模块: {}", moduleCode, e);
            throw new RuntimeException("创建表失败: " + e.getMessage(), e);
        }
    }

    /**
     * 根据父级模块ID获取所有字段（包括父级自己和所有子级的字段）
     */
    private List<FieldConfigDO> getAllFieldsByParentModule(Long parentId, String parentModuleCode) {
        List<FieldConfigDO> allFields = new ArrayList<>();

        // 1. 获取父级模块的所有子模块（包括父级自己）
        List<ModuleConfigDO> allModules = new ArrayList<>();

        // 添加父级模块
        ModuleConfigDO parentModule = moduleConfigMapper.selectById(parentId);
        if (parentModule != null) {
            allModules.add(parentModule);
        }

        // 添加所有子模块
        List<ModuleConfigDO> childModules = moduleConfigMapper.selectList(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getParentId, parentId));
        allModules.addAll(childModules);

        // 2. 收集所有模块的字段
        for (ModuleConfigDO module : allModules) {
            List<FieldConfigDO> moduleFields = fieldConfigMapper.selectListByModuleCode(module.getModuleCode());
            if (moduleFields != null && !moduleFields.isEmpty()) {
                allFields.addAll(moduleFields);
            }
        }

        // 3. 去重（基于字段标识）
        return allFields.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                FieldConfigDO::getFieldCode,
                                field -> field,
                                (existing, replacement) -> existing // 如果重复，保留现有的
                        ),
                        map -> new ArrayList<>(map.values())
                ));
    }

    /**
     * 删除表（根据模块码）
     */
    private void dropTableByModuleCode(String moduleCode) {
        ModuleConfigDO module = moduleConfigMapper.selectOne(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getModuleCode, moduleCode));
        if (module == null) {
            return;
        }

        String tableName;
        if (module.getParentId() != null && module.getParentId() > 0) {
            ModuleConfigDO parentModule = moduleConfigMapper.selectById(module.getParentId());
            tableName = parentModule != null ?
                    "dyn_" + parentModule.getModuleCode().toLowerCase() :
                    "dyn_" + moduleCode.toLowerCase();
        } else {
            tableName = "dyn_" + moduleCode.toLowerCase();
        }

        if (tableExists(tableName)) {
            String dropSql = "DROP TABLE " + tableName;
            log.info("删除动态表 SQL：{}", dropSql);
            jdbcTemplate.execute(dropSql);
            log.info("成功删除表: {}", tableName);
        }
    }

    /**
     * 更新相关模块的表名
     */
    private void updateTableNameForRelatedModules(ModuleConfigDO module, String tableName) {
        List<ModuleConfigDO> modulesToUpdate = new ArrayList<>();

        if (module.getParentId() != null && module.getParentId() > 0) {
            // 当前模块有父级，更新父级和所有兄弟模块
            ModuleConfigDO parentModule = moduleConfigMapper.selectById(module.getParentId());
            if (parentModule != null) {
                modulesToUpdate.add(parentModule);

                // 获取所有兄弟模块（包括自己）
                List<ModuleConfigDO> siblingModules = moduleConfigMapper.selectList(
                        new LambdaQueryWrapperX<ModuleConfigDO>()
                                .eq(ModuleConfigDO::getParentId, module.getParentId()));
                modulesToUpdate.addAll(siblingModules);
            }
        } else {
            // 当前模块是父级，更新自己和所有子模块
            modulesToUpdate.add(module);

            List<ModuleConfigDO> childModules = moduleConfigMapper.selectList(
                    new LambdaQueryWrapperX<ModuleConfigDO>()
                            .eq(ModuleConfigDO::getParentId, module.getId()));
            modulesToUpdate.addAll(childModules);
        }

        // 批量更新表名
        for (ModuleConfigDO moduleToUpdate : modulesToUpdate) {
            if (!tableName.equals(moduleToUpdate.getTableName())) {
                moduleToUpdate.setTableName(tableName);
                moduleConfigMapper.updateById(moduleToUpdate);
            }
        }

        log.info("更新了 {} 个模块的表名为: {}", modulesToUpdate.size(), tableName);
    }

    @Override
    public void dropTable(String moduleCode) {
        String tableName = "dyn_" + moduleCode.toLowerCase();
        if (tableExists(tableName)) {
            String dropSql = "DROP TABLE " + tableName;
            log.info("删除动态表 SQL：{}", dropSql);
            jdbcTemplate.execute(dropSql);
        }
    }

    /**
     * 判断表是否存在
     */
    private boolean tableExists(String tableName) {
        String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, tableName);
        return count != null && count > 0;
    }

    /**
     * 判断字段是否存在
     */
    private boolean columnExists(String tableName, String columnName) {
        String sql = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name = ? AND column_name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, tableName, columnName);
        return count != null && count > 0;
    }



    /**
     * 映射字段类型到数据库类型 - 修复版本
     */
    private String mapFieldTypeToDataType(FieldConfigDO field) {
        // 优先使用配置的数据库类型
        if (StringUtils.isNotBlank(field.getDataType())) {
            return buildDataTypeWithLength(field.getDataType(), field.getFieldLength());
        }

        // 根据字段类型映射
        switch (field.getFieldType()) {
            case "input":
            case "select":
            case "checkbox":
                return "VARCHAR(" + (field.getFieldLength() != null ? field.getFieldLength() : 255) + ")";
            case "textarea":
            case "richtext":
                return "TEXT";
            case "number":
            case "integer":
                return "INT";
            case "bigint":
                return "BIGINT";
            case "decimal":
            case "float":
                return "DECIMAL(10,2)";
            case "date":
                return "DATE";
            case "datetime":
                return "DATETIME";
            case "boolean":
            case "switch":
                return "TINYINT(1)";
            case "json":
                return "JSON";
            default:
                return "VARCHAR(255)";
        }
    }

    /**
     * 构建带长度的数据类型
     */
    private String buildDataTypeWithLength(String dataType, Integer fieldLength) {
        if (StringUtils.isBlank(dataType)) {
            return "VARCHAR(255)";
        }

        String upperType = dataType.toUpperCase();

        // 处理需要长度的数据类型
        if (upperType.startsWith("VARCHAR")) {
            return "VARCHAR(" + (fieldLength != null ? fieldLength : 255) + ")";
        } else if (upperType.startsWith("CHAR")) {
            return "CHAR(" + (fieldLength != null ? fieldLength : 1) + ")";
        } else if (upperType.startsWith("DECIMAL")) {
            // 对于 DECIMAL 类型，如果没有指定精度，使用默认值
            if (fieldLength != null) {
                return "DECIMAL(" + fieldLength + ",2)";
            } else {
                return "DECIMAL(10,2)";
            }
        } else if (upperType.startsWith("INT") && fieldLength != null) {
            // 处理 INT 类型的长度（如 INT(11)）
            return "INT(" + fieldLength + ")";
        } else if (upperType.startsWith("BIGINT") && fieldLength != null) {
            return "BIGINT(" + fieldLength + ")";
        }

        // 对于不需要长度或者长度不重要的类型，直接返回
        return upperType;
    }

    /**
     * 构建字段 SQL - 修复版本
     */
    private String buildColumnSql(FieldConfigDO field) {
        StringBuilder sb = new StringBuilder();

        // 使用字段标识作为列名，而不是字段类型
        String columnName = field.getFieldCode();

        // 检查是否是保留关键字，如果是则添加反引号
        if (isReservedKeyword(columnName)) {
            sb.append("`").append(columnName).append("` ");
        } else {
            sb.append(columnName).append(" ");
        }

        // 映射字段类型到数据库类型
        String dataType = mapFieldTypeToDataType(field);
        sb.append(dataType);

        // 是否必填
        if (field.getIsRequired() != null && field.getIsRequired() == 1) {
            sb.append(" NOT NULL");
        } else {
            sb.append(" NULL");
        }

        // 默认值处理
        String defaultValue = formatDefaultValue(field);
        if (StringUtils.isNotBlank(defaultValue)) {
            sb.append(" DEFAULT ").append(defaultValue);
        }

        // 注释
        String comment = StringUtils.isNotBlank(field.getFieldLabel()) ?
                field.getFieldLabel() : field.getFieldCode();
        sb.append(" COMMENT '").append(comment.replace("'", "''")).append("'");

        return sb.toString();
    }

    /**
     * 检查是否是 MySQL 保留关键字
     */
    private boolean isReservedKeyword(String word) {
        if (StringUtils.isBlank(word)) {
            return false;
        }

        Set<String> reservedKeywords = new HashSet<>(Arrays.asList(
                "select", "insert", "update", "delete", "create", "drop", "alter", "table",
                "varchar", "int", "integer", "bigint", "decimal", "float", "double", "date",
                "datetime", "timestamp", "text", "boolean", "primary", "key", "foreign",
                "references", "index", "unique", "default", "null", "not", "comment", "engine",
                "charset", "collate", "auto_increment", "current_timestamp", "on", "update"
        ));

        return reservedKeywords.contains(word.toLowerCase());
    }

    /**
     * 格式化默认值
     */
    private String formatDefaultValue(FieldConfigDO field) {
        // 根据字段类型设置合适的默认值
        switch (field.getFieldType()) {
            case "number":
            case "integer":
            case "bigint":
                return "0";
            case "decimal":
            case "float":
                return "0.0";
            case "boolean":
            case "switch":
                return "0";
            case "date":
                // 对于日期类型，可以使用 CURRENT_DATE 或者留空
                return null;
            case "datetime":
                // 对于日期时间类型，可以使用 CURRENT_TIMESTAMP 或者留空
                return null;
            default:
                // 文本类型通常不需要默认值
                return null;
        }
    }

    /**
     * 格式化默认值
     */
    private String formatDefaultValue(String fieldType, String defaultValue) {
        if (defaultValue == null || defaultValue.trim().isEmpty()) {
            return "";
        }

        switch (fieldType) {
            case "number":
            case "decimal":
            case "boolean":
                return defaultValue;
            case "date":
            case "datetime":
                if ("CURRENT_TIMESTAMP".equalsIgnoreCase(defaultValue)) {
                    return "CURRENT_TIMESTAMP";
                }
                return "'" + defaultValue + "'";
            default:
                return "'" + defaultValue + "'";
        }
    }

    @Override
    public void syncAllTables() {
        // 查询所有模块编码
        List<String> moduleCodes = fieldConfigMapper.selectDistinctModuleCodes();
        for (String moduleCode : moduleCodes) {
            syncTable(moduleCode);
        }
    }

    @Override
    public void syncTable(String moduleCode) {
        List<FieldConfigDO> fields = fieldConfigMapper.selectListByModuleCode(moduleCode);
        if (fields == null || fields.isEmpty()) {
            log.warn("模块 [{}] 未配置字段，跳过同步", moduleCode);
            return;
        }

        String tableName = "dyn_" + moduleCode.toLowerCase();
        boolean exists = tableExists(tableName);

        if (!exists) {
            createNewTable(tableName, fields);
        } else {
            syncExistingTable(tableName, fields);
        }
    }

    // ================= 辅助方法 =================

    /**
     * 确保系统字段存在
     */
    private void ensureSystemColumns(String tableName, List<String> dbColumns) {
        // 检查并添加缺失的系统字段
        if (!dbColumns.contains("creator")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN creator VARCHAR(64) DEFAULT '' COMMENT '创建者'");
        }
        if (!dbColumns.contains("updater")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN updater VARCHAR(64) DEFAULT '' COMMENT '更新者'");
        }
        if (!dbColumns.contains("deleted")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN deleted BIT(1) NOT NULL DEFAULT b'0' COMMENT '是否删除'");
        }
        if (!dbColumns.contains("tenant_id")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN tenant_id BIGINT NOT NULL DEFAULT '0' COMMENT '租户编号'");
        }

        // 对于 create_time 和 update_time，如果不存在则添加，但通常建表时就会有
        if (!dbColumns.contains("create_time")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'");
        }
        if (!dbColumns.contains("update_time")) {
            jdbcTemplate.execute("ALTER TABLE " + tableName + " ADD COLUMN update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExcelImportResultVO importExcel(ExcelImportReqDTO importReq) {
        ExcelImportResultVO resultVO = new ExcelImportResultVO();
        long startTime = System.currentTimeMillis();

        try {
            // 设置基础信息
            resultVO.setFileName(importReq.getFile().getOriginalFilename());

            // 设置关联字段
            String joinField = StringUtils.isNotBlank(importReq.getJoinField())
                    ? importReq.getJoinField() : "tjh";
            resultVO.setJoinField(joinField);

            log.info("使用关联字段: {}", joinField);

            // 1. 读取Excel
            List<Map<Integer, Object>> rawData = EasyExcel.read(importReq.getFile().getInputStream())
                    .sheet(0)
                    .headRowNumber(0)
                    .doReadSync();

            List<List<Object>> excelData = new ArrayList<>();
            for (Map<Integer, Object> rowMap : rawData) {
                List<Object> row = new ArrayList<>();
                int colIndex = 0;
                while (rowMap.containsKey(colIndex)) {
                    row.add(rowMap.getOrDefault(colIndex, null));
                    colIndex++;
                }
                excelData.add(row);
            }

            // 2. 解析字段配置
            List<String> fieldGroupRow = toStringList(excelData.get(0));    // 字段分组
            List<String> groupCodeRow = toStringList(excelData.get(1));     // 分组标识
            List<String> fieldNameRow = toStringList(excelData.get(2));     // 字段名称
            List<String> fieldCodeRow = toStringList(excelData.get(3));     // 字段标识
            List<String> fieldTypeRow = toStringList(excelData.get(4));     // 字段类型

            // 3. 检查并处理顶级模块
            String parentModuleCode = importReq.getModuleCode();

            // 如果模块已存在，先删除所有相关表和数据
            boolean parentModuleExists = moduleConfigMapper.existsByModuleCode(parentModuleCode) > 0;
            if (parentModuleExists) {
                log.info("顶级模块已存在，执行物理删除操作: {}", parentModuleCode);
                deleteModuleAndRelatedData(parentModuleCode);

                // 等待数据库操作完成
                Thread.sleep(100);

                boolean stillExists = moduleConfigMapper.existsByModuleCode(parentModuleCode) > 0;
                if (stillExists) {
                    throw new RuntimeException("模块删除后仍然存在: " + parentModuleCode);
                }
                log.info("成功删除原有模块及相关数据: {}", parentModuleCode);
            }

            // 4. 创建顶级模块（主表）- level = 1
            String mainTableName = "dyn_" + parentModuleCode.toLowerCase();
            ModuleConfigDO parentModule = new ModuleConfigDO();
            parentModule.setModuleCode(parentModuleCode);
            parentModule.setModuleName(importReq.getModuleName());
            parentModule.setModuleLevel(1);
            parentModule.setModuleType(importReq.getModuleType());
            parentModule.setGroupType(importReq.getGroupType());
            parentModule.setTableName(mainTableName);
            parentModule.setJoinField(joinField);

            moduleConfigMapper.insert(parentModule);
            log.info("成功创建主模块: {}, 关联字段: {}", parentModuleCode, joinField);

            // 5. 创建主表
            createMainTable(mainTableName, joinField);
            log.info("成功创建主表: {}, 关联字段: {}", mainTableName, joinField);

            // 6. 按分组整理字段
            Map<String, List<FieldConfigDO>> groupFieldMap = new LinkedHashMap<>();
            Map<String, ModuleConfigDO> groupModuleMap = new HashMap<>();
            Map<String, String> groupTableNameMap = new HashMap<>();

            List<FieldConfigDO> mainTableFields = new ArrayList<>();

            String defaultGroupCode = "default";
            String defaultGroupName = "默认分组";
            int maxColumns = fieldCodeRow.size();

            boolean hasJoinField = false;

            for (int col = 1; col < maxColumns; col++) {
                String fieldCode = fieldCodeRow.get(col);
                if (StringUtils.isBlank(fieldCode)) {
                    continue;
                }

                if (joinField.equalsIgnoreCase(fieldCode)) {
                    hasJoinField = true;
                }

                String groupCode = "";
                String groupName = "";

                if (groupCodeRow.size() > col) {
                    groupCode = StringUtils.trimToEmpty(groupCodeRow.get(col));
                }
                if (fieldGroupRow.size() > col) {
                    groupName = StringUtils.trimToEmpty(fieldGroupRow.get(col));
                }

                FieldConfigDO field = new FieldConfigDO();
                field.setFieldCode(fieldCode);
                field.setFieldLabel(fieldNameRow.get(col));
                field.setFieldType(fieldTypeRow.get(col));
                field.setFieldGroup(groupCode);
                field.setFieldGroupName(groupName);
                field.setIsRequired(joinField.equalsIgnoreCase(fieldCode) ? 1 : 0);
                field.setDisplayOrder(col);

                String dataType = mapExcelFieldTypeToDataType(fieldTypeRow.get(col));
                field.setDataType(dataType);

                if (StringUtils.isBlank(groupCode)) {
                    field.setModuleCode(parentModuleCode);
                    mainTableFields.add(field);
                    log.info("字段 [{}] 将放入主表", fieldCode);
                } else {
                    if (!groupModuleMap.containsKey(groupCode)) {
                        String groupModuleCode = parentModuleCode + "_" + groupCode;
                        String groupTableName = "dyn_" + parentModuleCode + "_" + groupCode.toLowerCase();

                        ModuleConfigDO groupModule = new ModuleConfigDO();
                        groupModule.setParentId(parentModule.getId());
                        groupModule.setModuleCode(groupModuleCode);
                        groupModule.setModuleName(StringUtils.isNotBlank(groupName) ? groupName : groupCode);
                        groupModule.setModuleLevel(2);
                        groupModule.setIsLeaf(1);
                        groupModule.setTableName(groupTableName);
                        groupModule.setGroupType(importReq.getGroupType());
                        groupModule.setJoinField(joinField);
                        moduleConfigMapper.insert(groupModule);

                        groupModuleMap.put(groupCode, groupModule);
                        groupTableNameMap.put(groupCode, groupTableName);

                        createSubTable(groupTableName, groupCode, joinField);
                        log.info("成功创建子表: {}, 关联字段: {}", groupTableName, joinField);
                    }

                    field.setModuleCode(groupModuleMap.get(groupCode).getModuleCode());
                    groupFieldMap.computeIfAbsent(groupCode, k -> new ArrayList<>()).add(field);
                    log.info("字段 [{}] 将放入子表 [{}]", fieldCode, groupCode);
                }
            }

            if (!hasJoinField) {
                throw new RuntimeException(String.format("Excel模板必须包含关联字段 [%s]", joinField));
            }

            // 7. 为主表添加字段
            for (FieldConfigDO field : mainTableFields) {
                try {
                    fieldConfigMapper.insert(field);
                    addColumnToTable(mainTableName, field);
                } catch (Exception e) {
                    String error = "主表字段插入失败: " + field.getFieldCode() + ", 错误: " + e.getMessage();
                    resultVO.addError(error);
                    log.error(error, e);
                }
            }

            // 8. 为子表添加字段
            int totalFields = mainTableFields.size();
            int successFields = mainTableFields.size();

            for (Map.Entry<String, List<FieldConfigDO>> entry : groupFieldMap.entrySet()) {
                String groupCode = entry.getKey();
                List<FieldConfigDO> fieldList = entry.getValue();
                String tableName = groupTableNameMap.get(groupCode);

                totalFields += fieldList.size();

                for (FieldConfigDO field : fieldList) {
                    try {
                        fieldConfigMapper.insert(field);
                        addColumnToTable(tableName, field);
                        successFields++;
                    } catch (Exception e) {
                        String error = "子表字段插入失败: " + field.getFieldCode() + ", 错误: " + e.getMessage();
                        resultVO.addError(error);
                        log.error(error, e);
                    }
                }
            }

            resultVO.setTotalFields(totalFields);
            resultVO.setSuccessFields(successFields);

            // 9. 插入数据
            int dataStartRow = 6;
            int totalDataRows = 0;
            int successDataRows = 0;
            int systemErrorCount = 0;  // 记录系统级错误数量

            // 用于去重，避免同一关联字段插入多次
            Set<String> processedJoinFieldValues = new HashSet<>();

            for (int rowIndex = dataStartRow; rowIndex < excelData.size(); rowIndex++) {
                List<Object> row = excelData.get(rowIndex);

                if (row.isEmpty() || isDescriptionRow(row) || row.stream().allMatch(Objects::isNull)) {
                    continue;
                }

                totalDataRows++;

                Map<String, Object> mainData = new HashMap<>();
                Map<String, Map<String, Object>> subTableDataMap = new HashMap<>();

                String joinFieldValue = null;
                boolean hasValidData = false;

                // 遍历所有列收集数据
                for (int col = 1; col < maxColumns; col++) {
                    if (col >= row.size()) break;

                    String fieldCode = (col < fieldCodeRow.size()) ? fieldCodeRow.get(col) : null;
                    String groupCode = (col < groupCodeRow.size()) ? StringUtils.trimToEmpty(groupCodeRow.get(col)) : "";

                    if (StringUtils.isBlank(fieldCode)) continue;

                    Object value = row.get(col);

                    if (joinField.equalsIgnoreCase(fieldCode)) {
                        joinFieldValue = value != null ? value.toString() : null;
                        if (StringUtils.isNotBlank(joinFieldValue)) {
                            hasValidData = true;
                        }
                    }

                    FieldConfigDO field = findFieldByCode(mainTableFields, groupFieldMap, groupCode, fieldCode);
                    if (field != null && value != null && StringUtils.isNotBlank(value.toString())) {
                        Object convertedValue = convertValueByType(field.getFieldType(), value);

                        if (StringUtils.isBlank(groupCode)) {
                            mainData.put(fieldCode, convertedValue);
                        } else {
                            subTableDataMap.computeIfAbsent(groupCode, k -> new HashMap<>())
                                    .put(fieldCode, convertedValue);
                        }
                        hasValidData = true;
                    }
                }

                // 关联字段不存在或为空，跳过该行数据（业务错误，不是系统错误）
                if (StringUtils.isBlank(joinFieldValue)) {
                    String error = "第" + (rowIndex + 1) + "行数据关联字段 [" + joinField + "] 为空，已跳过";
                    resultVO.addError(error);
                    log.warn(error);
                    continue;
                }

                // 检查关联字段是否重复（业务错误，不是系统错误）
                if (processedJoinFieldValues.contains(joinFieldValue)) {
                    String error = "第" + (rowIndex + 1) + "行数据关联字段 [" + joinField + "] 值重复: " + joinFieldValue + "，已跳过";
                    resultVO.addError(error);
                    log.warn(error);
                    continue;
                }

                // 检查是否有有效数据（业务错误，不是系统错误）
                if (!hasValidData) {
                    String error = "第" + (rowIndex + 1) + "行数据没有有效数据，已跳过";
                    resultVO.addError(error);
                    log.warn(error);
                    continue;
                }

                try {
                    // 插入主表数据
                    if (!mainData.isEmpty() || joinFieldValue != null) {
                        mainData.put(joinField, joinFieldValue);
                        insertIntoTable(mainTableName, mainData);
                    }

                    // 插入子表数据
                    for (Map.Entry<String, Map<String, Object>> entry : subTableDataMap.entrySet()) {
                        String groupCode = entry.getKey();
                        Map<String, Object> subData = entry.getValue();
                        String tableName = groupTableNameMap.get(groupCode);

                        if (tableName != null && !subData.isEmpty()) {
                            subData.put(joinField, joinFieldValue);
                            insertIntoTable(tableName, subData);
                        }
                    }

                    // 记录已处理的关联字段值
                    processedJoinFieldValues.add(joinFieldValue);
                    successDataRows++;

                } catch (Exception e) {
                    // 数据库插入异常，属于系统级错误
                    String error = "第" + (rowIndex + 1) + "行数据插入失败: " + e.getMessage();
                    resultVO.addError(error);
                    log.error(error, e);
                    systemErrorCount++;
                }
            }

            resultVO.setTotalRecords(totalDataRows);
            resultVO.setSuccessRecords(successDataRows);
            resultVO.setModuleCode(parentModuleCode);
            resultVO.setTableName(mainTableName);
            resultVO.setJoinField(joinField);

            long costTime = System.currentTimeMillis() - startTime;
            resultVO.setCostTime(costTime);

            // ===== 关键修改：根据实际情况设置 success 状态 =====

            // 1. 如果有系统级错误，设置为失败
            if (systemErrorCount > 0) {
                resultVO.setSuccess(false);
                resultVO.setMessage(String.format("导入失败：发生%d个系统错误，请查看详细错误信息", systemErrorCount));
            }
            // 2. 如果一条数据都没成功，但有数据行，也设置为失败
            else if (successDataRows == 0 && totalDataRows > 0) {
                resultVO.setSuccess(false);
                resultVO.setMessage(String.format("导入失败：共处理%d行数据，但全部失败。请检查数据格式。", totalDataRows));
            }
            // 3. 部分成功或全部成功，都设置为成功
            else if (successDataRows < totalDataRows) {
                resultVO.setSuccess(true);
                resultVO.setMessage(String.format("导入完成：共处理%d行数据，成功%d行，跳过%d行",
                        totalDataRows, successDataRows, totalDataRows - successDataRows));
            }
            // 4. 全部成功
            else {
                resultVO.setSuccess(true);
                resultVO.setMessage(String.format("导入成功：共%d个字段，%d条数据全部导入成功",
                        totalFields, totalDataRows));
            }

            log.info("Excel导入完成: {}, success={}, systemErrorCount={}",
                    resultVO.getMessage(), resultVO.getSuccess(), systemErrorCount);

        } catch (Exception e) {
            // 系统级异常才设置 success=false
            long costTime = System.currentTimeMillis() - startTime;
            resultVO.setCostTime(costTime);
            resultVO.setSuccess(false);
            resultVO.setMessage("导入失败: " + e.getMessage());
            resultVO.addError("系统异常: " + e.getMessage());
            log.error("Excel导入系统异常", e);
        }

        return resultVO;
    }

    /**
     * 增强的删除方法 - 确保物理删除所有相关数据
     */
    private void deleteModuleAndRelatedData(String moduleCode) {
        try {
            log.info("开始物理删除模块及相关数据: {}", moduleCode);

            // 1. 查询顶级模块（包含逻辑删除的记录）
            ModuleConfigDO parentModule = moduleConfigMapper.selectByModuleCodeIncludeDeleted(moduleCode);

            if (parentModule == null) {
                log.info("顶级模块不存在，无需删除: {}", moduleCode);
                return;
            }

            // 2. 获取关联字段名
            String joinField = parentModule.getJoinField();
            if (StringUtils.isBlank(joinField)) {
                joinField = "tjh"; // 默认值
            }

            // 3. 查询所有相关的子模块
            List<ModuleConfigDO> allRelatedModules = new ArrayList<>();
            allRelatedModules.add(parentModule);

            List<ModuleConfigDO> childModules = moduleConfigMapper.selectByParentIdIncludeDeleted(parentModule.getId());
            allRelatedModules.addAll(childModules);

            // 4. 收集所有要删除的表名
            List<String> tableNames = new ArrayList<>();
            tableNames.add(parentModule.getTableName());
            for (ModuleConfigDO child : childModules) {
                if (StringUtils.isNotBlank(child.getTableName())) {
                    tableNames.add(child.getTableName());
                }
            }

            // 5. 先删除所有相关的动态表
            for (String tableName : tableNames) {
                if (StringUtils.isNotBlank(tableName) && tableExists(tableName)) {
                    try {
                        // 先禁用外键检查
                        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0");

                        // 删除表
                        String dropSql = "DROP TABLE IF EXISTS " + tableName;
                        jdbcTemplate.execute(dropSql);
                        log.info("物理删除动态表: {}", tableName);

                        // 恢复外键检查
                        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1");
                    } catch (Exception e) {
                        log.warn("物理删除动态表失败: {}，错误: {}", tableName, e.getMessage());
                    }
                }
            }

            // 6. 物理删除所有相关模块的字段配置
            for (ModuleConfigDO module : allRelatedModules) {
                int deletedFields = fieldConfigMapper.physicallyDeleteByModuleCode(module.getModuleCode());
                log.info("物理删除模块 [{}] 的 {} 个字段配置", module.getModuleCode(), deletedFields);
            }

            // 7. 物理删除所有子模块
            if (!childModules.isEmpty()) {
                List<Long> childModuleIds = childModules.stream()
                        .map(ModuleConfigDO::getId)
                        .collect(Collectors.toList());
                int deletedChildModules = moduleConfigMapper.physicallyDeleteByIds(childModuleIds);
                log.info("物理删除 {} 个子模块", deletedChildModules);
            }

            // 8. 物理删除父级模块
            int deletedParent = moduleConfigMapper.physicallyDeleteById(parentModule.getId());
            log.info("物理删除父级模块: {} (影响行数: {})", parentModule.getModuleCode(), deletedParent);

            log.info("成功物理删除模块及相关数据: {}", moduleCode);

        } catch (Exception e) {
            log.error("物理删除模块及相关数据失败: {}", moduleCode, e);
            throw new RuntimeException("物理删除模块失败: " + e.getMessage(), e);
        }
    }

    /**
     * 插入数据到表（增强版）
     */
    private void insertIntoTable(String tableName, Map<String, Object> data) {
        if (data == null || data.isEmpty()) {
            log.warn("表 {} 没有数据可插入", tableName);
            return;
        }

        // 过滤掉值为null的字段
        Map<String, Object> filteredData = data.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (filteredData.isEmpty()) {
            log.warn("表 {} 过滤后没有有效数据", tableName);
            return;
        }

        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        sql.append(String.join(",", filteredData.keySet())).append(") VALUES (");
        sql.append(filteredData.keySet().stream().map(k -> "?").collect(Collectors.joining(","))).append(")");

        try {
            jdbcTemplate.update(sql.toString(), filteredData.values().toArray());
            log.debug("成功插入数据到表: {}, 字段数: {}", tableName, filteredData.size());
        } catch (Exception e) {
            log.error("插入数据失败, 表: {}, 数据: {}, SQL: {}", tableName, filteredData, sql, e);
            throw new RuntimeException("数据插入失败: " + e.getMessage(), e);
        }
    }

    /**
     * 添加列到表（检查列是否存在）
     */
    private void addColumnToTable(String tableName, FieldConfigDO field) {
        // 检查表是否存在
        if (!tableExists(tableName)) {
            log.error("表不存在: {}", tableName);
            throw new RuntimeException("表不存在: " + tableName);
        }

        // 检查列是否存在
        String checkSql = "SELECT COUNT(*) FROM information_schema.columns " +
                "WHERE table_name = ? AND column_name = ? AND table_schema = DATABASE()";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, tableName, field.getFieldCode());

        if (count == null || count == 0) {
            String sql = String.format(
                    "ALTER TABLE `%s` ADD COLUMN `%s` %s DEFAULT NULL COMMENT '%s'",
                    tableName,
                    field.getFieldCode(),
                    field.getDataType() != null ? field.getDataType() : "VARCHAR(255)",
                    field.getFieldLabel().replace("'", "\\'")
            );

            try {
                jdbcTemplate.execute(sql);
                log.debug("成功添加列 {}.{}", tableName, field.getFieldCode());
            } catch (Exception e) {
                log.error("添加列失败 {}.{}: {}", tableName, field.getFieldCode(), e.getMessage());
                throw new RuntimeException("添加列失败: " + e.getMessage());
            }
        } else {
            log.debug("列已存在，跳过添加: {}.{}", tableName, field.getFieldCode());
        }
    }

    /**
     * 判断是否是说明行（增强版）
     */
    private boolean isDescriptionRow(List<Object> row) {
        if (row == null || row.isEmpty() || row.get(0) == null) {
            return false;
        }
        String firstCell = row.get(0).toString();
        return firstCell.contains("↓↓↓") ||
                firstCell.contains("使用说明") ||
                firstCell.contains("说明") ||
                firstCell.startsWith("#") ||
                firstCell.startsWith("//");
    }

    /**
     * 创建主表（包含自定义关联字段）
     */
    private void createMainTable(String tableName, String joinField) {
        String sql = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (" +
                "`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键'," +
                "`" + joinField + "` VARCHAR(64) NOT NULL COMMENT '" + joinField + "（关联字段）'," +
                "`creator` VARCHAR(64) DEFAULT '' COMMENT '创建者'," +
                "`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'," +
                "`updater` VARCHAR(64) DEFAULT '' COMMENT '更新者'," +
                "`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'," +
                "`deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '是否删除'," +
                "`tenant_id` BIGINT NOT NULL DEFAULT '0' COMMENT '租户编号'," +
                "UNIQUE KEY `uk_" + joinField + "` (`" + joinField + "`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主表'";

        jdbcTemplate.execute(sql);
    }

    /**
     * 创建子表基础结构（包含自定义关联字段）
     */
    private void createSubTable(String tableName, String groupCode, String joinField) {
        String sql = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (" +
                "`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键'," +
                "`" + joinField + "` VARCHAR(64) NOT NULL COMMENT '" + joinField + "（关联字段）'," +
                "`creator` VARCHAR(64) DEFAULT '' COMMENT '创建者'," +
                "`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'," +
                "`updater` VARCHAR(64) DEFAULT '' COMMENT '更新者'," +
                "`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'," +
                "`deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '是否删除'," +
                "`tenant_id` BIGINT NOT NULL DEFAULT '0' COMMENT '租户编号'," +
                "INDEX `idx_" + joinField + "` (`" + joinField + "`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='子表_" + groupCode + "'";

        jdbcTemplate.execute(sql);
    }

    /**
     * 查找字段（增强版，支持主表和子表）
     */
    private FieldConfigDO findFieldByCode(List<FieldConfigDO> mainTableFields,
                                          Map<String, List<FieldConfigDO>> groupFieldMap,
                                          String groupCode, String fieldCode) {
        if (StringUtils.isBlank(groupCode)) {
            // 在主表中查找
            return mainTableFields.stream()
                    .filter(f -> f.getFieldCode().equals(fieldCode))
                    .findFirst()
                    .orElse(null);
        } else {
            // 在子表中查找
            List<FieldConfigDO> fields = groupFieldMap.get(groupCode);
            if (fields != null) {
                return fields.stream()
                        .filter(f -> f.getFieldCode().equals(fieldCode))
                        .findFirst()
                        .orElse(null);
            }
        }
        return null;
    }

    /**
     * 根据Excel字段类型映射到数据库类型
     */
    private String mapExcelFieldTypeToDataType(String excelFieldType) {
        if (excelFieldType == null) {
            return "VARCHAR(255)";
        }

        String lowerType = excelFieldType.toLowerCase();
        switch (lowerType) {
            case "int":
            case "integer":
                return "INT";
            case "bigint":
                return "BIGINT";
            case "decimal":
            case "float":
            case "double":
                return "DECIMAL(10,2)";
            case "date":
                return "DATE";
            case "datetime":
                return "DATETIME";
            case "text":
                return "TEXT";
            case "boolean":
            case "bool":
                return "TINYINT(1)";
            case "json":
                return "JSON";
            case "varchar":
            default:
                return "VARCHAR(255)";
        }
    }

    /**
     * 根据字段类型转换值
     */
    private Object convertValueByType(String fieldType, Object value) {
        if (value == null) {
            return null;
        }

        if (fieldType == null) {
            return value.toString();
        }

        String lowerType = fieldType.toLowerCase();
        try {
            switch (lowerType) {
                case "int":
                case "integer":
                    return value instanceof Number ? ((Number) value).intValue() :
                            Integer.parseInt(value.toString().trim());
                case "bigint":
                    return value instanceof Number ? ((Number) value).longValue() :
                            Long.parseLong(value.toString().trim());
                case "decimal":
                case "float":
                case "double":
                    return value instanceof Number ? ((Number) value).doubleValue() :
                            Double.parseDouble(value.toString().trim());
                case "boolean":
                case "bool":
                    if (value instanceof Boolean) {
                        return (Boolean) value ? 1 : 0;
                    }
                    String boolStr = value.toString().toLowerCase().trim();
                    return boolStr.equals("true") || boolStr.equals("1") || boolStr.equals("是") ? 1 : 0;
                default:
                    return value.toString().trim();
            }
        } catch (Exception e) {
            log.warn("值转换失败: {} -> {}, 使用字符串类型", value, fieldType);
            return value.toString();
        }
    }

    /**
     * 记录导入历史
     */
    private void recordImportHistory(ExcelImportReqDTO importReq, ExcelImportResultVO result) {
        ImportHistoryVO history = new ImportHistoryVO();
        history.setId(System.currentTimeMillis());
        history.setFileName(result.getFileName());
        history.setModuleCode(result.getModuleCode());
        history.setModuleName(importReq.getModuleName());
        history.setFieldCount(result.getTotalFields());
        history.setDataCount(result.getSuccessRecords());
        history.setSuccess(result.getSuccess());
        history.setErrorMessage(result.hasErrors() ?
                String.join("; ", result.getErrorMessages()) : "成功");
        history.setImportTime(result.getImportTime());
//        history.setCostTime(result.getCostTime());

        importHistory.add(0, history);

        // 限制历史记录数量
        if (importHistory.size() > 1000) {
            importHistory.remove(importHistory.size() - 1);
        }
    }

    private List<String> getTableColumns(String tableName) {
        String sql = "SELECT column_name FROM information_schema.columns WHERE table_name = ?";
        return jdbcTemplate.queryForList(sql, String.class, tableName);
    }

    // 导入历史记录（实际应该存数据库）
    private final List<ImportHistoryVO> importHistory = Collections.synchronizedList(new ArrayList<>());



    private List<String> toStringList(List<Object> row) {
        return row.stream().map(o -> o == null ? "" : o.toString()).collect(Collectors.toList());
    }

    private void createNewTable(String tableName, List<FieldConfigDO> fields) {
        StringBuilder sb = new StringBuilder("CREATE TABLE `").append(tableName).append("` (");
        sb.append("`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,");
        for (FieldConfigDO field : fields) {
            sb.append("`").append(field.getFieldCode()).append("` ")
                    .append(field.getDataType() != null ? field.getDataType() : "VARCHAR(255)")
                    .append(" DEFAULT NULL COMMENT '").append(field.getFieldLabel()).append("',");
        }
        sb.append("`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,");
        sb.append("`update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP");
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态表'");
        jdbcTemplate.execute(sb.toString());
    }

    private void syncExistingTable(String tableName, List<FieldConfigDO> fields) {
        List<String> existingColumns = jdbcTemplate.queryForList(
                "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE table_name = ? AND table_schema = DATABASE()",
                String.class, tableName);

        for (FieldConfigDO field : fields) {
            if (!existingColumns.contains(field.getFieldCode())) {
                String sql = String.format(
                        "ALTER TABLE `%s` ADD COLUMN `%s` %s DEFAULT NULL COMMENT '%s'",
                        tableName,
                        field.getFieldCode(),
                        field.getDataType() != null ? field.getDataType() : "VARCHAR(255)",
                        field.getFieldLabel()
                );
                jdbcTemplate.execute(sql);
            }
        }
    }

    /**
     * 增强的模块存在性检查
     */
    @Override
    public boolean checkModuleExists(String moduleCode) {
        try {
            return moduleConfigMapper.existsByModuleCode(moduleCode) > 0;
        } catch (Exception e) {
            log.error("检查模块存在性失败: {}", moduleCode, e);
            return false;
        }
    }

    @Override
    public PageResult<ImportHistoryVO> getImportHistory(Integer pageNo, Integer pageSize) {
        try {
            int currentPage = (pageNo == null || pageNo < 1) ? 1 : pageNo;
            int currentPageSize = (pageSize == null || pageSize < 1) ? 10 : pageSize;

            int total = importHistory.size();

            List<ImportHistoryVO> pageData = importHistory.stream()
                    .skip((long) (currentPage - 1) * currentPageSize)
                    .limit(currentPageSize)
                    .collect(Collectors.toList());

            // 使用反射设置数据（不推荐，但如果没有setter方法）
            PageResult<ImportHistoryVO> result = new PageResult<>();
            try {
                // 尝试通过反射设置结果
                Method setResultsMethod = result.getClass().getMethod("setResults", List.class);
                setResultsMethod.invoke(result, pageData);
            } catch (Exception e) {
                log.warn("无法通过反射设置 results，使用默认构造");
            }

            // 设置分页信息
            try {
                result.setPage(currentPage);
            } catch (Exception e) {
                log.debug("setPage 方法不存在");
            }

            try {
                result.setPageSize(currentPageSize);
            } catch (Exception e) {
                log.debug("setPageSize 方法不存在");
            }

            try {
                result.setTotal(total);
            } catch (Exception e) {
                log.debug("setTotal 方法不存在");
            }

            return result;

        } catch (Exception e) {
            log.error("获取导入历史失败", e);
            return new PageResult<>();
        }
    }

    @Override
    public CommonResult<String> deleteModule(String moduleCode) {
        try {
            // 1. 删除动态表
            this.dropTable(moduleCode);

            // 2. 逻辑删除字段配置
            fieldConfigMapper.deleteByModuleCode(moduleCode);

            // 3. 逻辑删除模块配置
            ModuleConfigDO updateDO = new ModuleConfigDO();
            updateDO.setDeleted(true);
            moduleConfigMapper.update(updateDO,
                    new LambdaQueryWrapperX<ModuleConfigDO>()
                            .eq(ModuleConfigDO::getModuleCode, moduleCode));

            log.info("删除模块成功: {}", moduleCode);
            return CommonResult.success("删除模块成功");
        } catch (Exception e) {
            log.error("删除模块失败", e);
            return CommonResult.error(500, "删除失败: " + e.getMessage());
        }
    }

    // ================= 私有方法 =================

    /**
     * 验证导入请求
     */
    private void validateImportRequest(ExcelImportReqDTO importReq) {
        if (importReq.getFile() == null || importReq.getFile().isEmpty()) {
            throw new RuntimeException("文件不能为空");
        }

        String fileName = importReq.getFile().getOriginalFilename();
        if (fileName == null || !fileName.toLowerCase().endsWith(".xlsx")) {
            throw new RuntimeException("只支持.xlsx格式的Excel文件");
        }

        if (importReq.getFile().getSize() > 10 * 1024 * 1024) {
            throw new RuntimeException("文件大小不能超过10MB");
        }
    }

    /**
     * 创建模块配置
     */
    private ModuleConfigDO createModuleConfig(ModuleConfigImportDTO importDTO) {
        ModuleConfigDO module = new ModuleConfigDO();
        module.setParentId(null); // 一级模块
        module.setModuleCode(importDTO.getModuleCode());
        module.setModuleName(importDTO.getModuleName());
        module.setTableName("dyn_" + importDTO.getModuleCode());
        module.setModuleLevel(1);
        module.setGroupType(importDTO.getGroupType());
        module.setModuleType(importDTO.getModuleType());
        module.setIsLeaf(1);
        module.setOrderNo(0);
        module.setStatus(1);
        module.setRemark(importDTO.getRemark());

        return module;
    }

    /**
     * 创建字段配置
     */
    private int createFieldConfigs(String moduleCode, List<FieldConfigImportDTO> fieldConfigs,
                                   List<String> errorMessages) {
        int successCount = 0;

        for (int i = 0; i < fieldConfigs.size(); i++) {
            FieldConfigImportDTO importDTO = fieldConfigs.get(i);
            try {
                // 检查字段标识是否重复
                if (fieldConfigMapper.existsByModuleCodeAndFieldCode(moduleCode, importDTO.getFieldCode())) {
                    throw new RuntimeException("字段标识已存在: " + importDTO.getFieldCode());
                }

                FieldConfigDO fieldConfig = new FieldConfigDO();
                fieldConfig.setModuleCode(moduleCode);
                fieldConfig.setFieldCode(importDTO.getFieldCode());
                fieldConfig.setFieldLabel(importDTO.getFieldLabel());
                fieldConfig.setFieldType(importDTO.getFieldType());
                fieldConfig.setDataType(importDTO.getDataType());
                fieldConfig.setFieldLength(importDTO.getFieldLength());
                fieldConfig.setIsRequired(importDTO.getIsRequired());
                fieldConfig.setDisplayOrder(importDTO.getDisplayOrder() != null ?
                        importDTO.getDisplayOrder() : i * 10);
                fieldConfig.setFieldGroup(importDTO.getFieldGroup());
                fieldConfig.setFieldGroupName(importDTO.getFieldGroupName());
                fieldConfig.setStatus(1);
                fieldConfig.setOrderNo(i);

                fieldConfigMapper.insert(fieldConfig);
                successCount++;

            } catch (Exception e) {
                String errorMsg = String.format("字段[%s]创建失败: %s",
                        importDTO.getFieldLabel(), e.getMessage());
                errorMessages.add(errorMsg);
                log.warn("字段配置创建失败: {}", errorMsg);
            }
        }

        return successCount;
    }

    /**
     * 导入数据到动态表
     */
    private int importData(String tableName, List<FieldConfigImportDTO> fieldConfigs,
                           List<ExcelDataRow> dataRows, List<String> errorMessages) {
        if (dataRows.isEmpty()) {
            return 0;
        }

        int successCount = 0;
        int batchSize = 100; // 批量插入大小
        List<String> batchSqls = new ArrayList<>();

        for (int i = 0; i < dataRows.size(); i++) {
            ExcelDataRow dataRow = dataRows.get(i);
            try {
                String sql = buildInsertSql(tableName, fieldConfigs, dataRow);
                batchSqls.add(sql);

                // 批量执行
                if (batchSqls.size() >= batchSize || i == dataRows.size() - 1) {
                    executeBatchInsert(batchSqls);
                    successCount += batchSqls.size();
                    batchSqls.clear();
                }

            } catch (Exception e) {
                String errorMsg = String.format("第%d行数据导入失败: %s",
                        dataRow.getRowIndex(), e.getMessage());
                errorMessages.add(errorMsg);
                log.warn("数据导入失败: {}", errorMsg);
            }
        }

        // 执行剩余的SQL
        if (!batchSqls.isEmpty()) {
            try {
                executeBatchInsert(batchSqls);
                successCount += batchSqls.size();
            } catch (Exception e) {
                log.error("批量插入失败", e);
            }
        }

        return successCount;
    }

    /**
     * 构建插入SQL
     */
    private String buildInsertSql(String tableName, List<FieldConfigImportDTO> fieldConfigs,
                                  ExcelDataRow dataRow) {
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder(" VALUES (");

        // 业务字段
        for (FieldConfigImportDTO fieldConfig : fieldConfigs) {
            String fieldCode = fieldConfig.getFieldCode();
            Object value = dataRow.get(fieldCode);

            sql.append(fieldCode).append(", ");

            if (value == null) {
                values.append("NULL, ");
            } else if (value instanceof Number) {
                values.append(value).append(", ");
            } else if (value instanceof Boolean) {
                values.append((Boolean) value ? "1, " : "0, ");
            } else {
                values.append("'").append(escapeSql(value.toString())).append("', ");
            }
        }

        // 系统字段
        sql.append("creator, create_time, updater, update_time, deleted, tenant_id)");
        values.append("'system', NOW(), 'system', NOW(), 0, 0)");

        return sql.toString() + values.toString();
    }

    /**
     * 执行批量插入
     */
    private void executeBatchInsert(List<String> sqls) {
        for (String sql : sqls) {
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                log.error("执行SQL失败: {}", sql, e);
                throw new RuntimeException("数据插入失败: " + e.getMessage(), e);
            }
        }
    }

    /**
     * 回滚模块
     */
    private void rollbackModule(String moduleCode) {
        try {
            // 删除字段配置
            fieldConfigMapper.deleteByModuleCode(moduleCode);
            // 删除模块配置
            moduleConfigMapper.delete(new LambdaQueryWrapperX<ModuleConfigDO>()
                    .eq(ModuleConfigDO::getModuleCode, moduleCode));
            log.info("模块回滚成功: {}", moduleCode);
        } catch (Exception e) {
            log.error("模块回滚失败: {}", moduleCode, e);
        }
    }

    /**
     * 记录导入历史
     */
    private void recordImportHistory(ExcelImportReqDTO importReq, ModuleConfigImportDTO moduleConfig,
                                     int fieldCount, int dataCount, boolean success, String errorMsg) {
        ImportHistoryVO history = new ImportHistoryVO();
        history.setId(System.currentTimeMillis());
        history.setFileName(importReq.getFile().getOriginalFilename());
        history.setModuleCode(moduleConfig != null ? moduleConfig.getModuleCode() : "");
        history.setModuleName(moduleConfig != null ? moduleConfig.getModuleName() : "");
        history.setFieldCount(fieldCount);
        history.setDataCount(dataCount);
        history.setSuccess(success);
        history.setErrorMessage(errorMsg);
        history.setImportTime(new Date());

        importHistory.add(0, history); // 添加到开头

        // 限制历史记录数量
        if (importHistory.size() > 1000) {
            importHistory.remove(importHistory.size() - 1);
        }
    }

    @Override
    public void downloadTemplate(HttpServletResponse response, String templateType) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(templateType, "UTF-8"));

            // 创建模板数据
            List<List<Object>> data = createTemplateData();

            // 直接写入数据，不使用head参数
            EasyExcel.write(response.getOutputStream())
                    .sheet("模板")
                    .doWrite(data);

            log.info("模板生成成功，总行数: {}", data.size());

        } catch (Exception e) {
            log.error("生成模板文件失败", e);
            throw new RuntimeException("生成模板失败", e);
        }
    }

    /**
     * 创建模板数据 - 横向结构，只用data
     * 分组标识为空的字段（包括tjh、patient_name、patient_age）放入主表
     * 分组标识不为空的字段（result、status）放入对应的子表
     */
    private List<List<Object>> createTemplateData() {
        List<List<Object>> data = new ArrayList<>();

        // 字段配置区域 - 横向结构
        // 第1行：字段分组（分组标识为空的单元格留空）
        data.add(Arrays.asList(
                "字段分组",                    // 第1列空
                "",                    // tjh 的分组为空
                "",                    // patient_name 的分组为空
                "",                    // patient_age 的分组为空
                "检查结果",             // heart_check 的分组
                "检查结果",             // liver_check 的分组
                "状态信息"              // check_status 的分组
        ));

        // 第2行：分组标识（分组标识为空的单元格留空）
        data.add(Arrays.asList(
                "分组标识",                    // 第1列空
                "",                    // tjh 的分组标识为空
                "",                    // patient_name 的分组标识为空
                "",                    // patient_age 的分组标识为空
                "result",              // heart_check 的分组标识
                "result",              // liver_check 的分组标识
                "status"               // check_status 的分组标识
        ));

        // 第3行：字段名称
        data.add(Arrays.asList(
                "字段名称",                    // 第1列空
                "体检号",               // tjh
                "患者姓名",             // patient_name
                "患者年龄",             // patient_age
                "心脏检查",             // heart_check
                "肝脏检查",             // liver_check
                "检查状态"              // check_status
        ));

        // 第4行：字段标识
        data.add(Arrays.asList(
                "字段标识",                    // 第1列空
                "tjh",                 // 体检号
                "patient_name",        // 患者姓名
                "patient_age",         // 患者年龄
                "heart_check",         // 心脏检查
                "liver_check",         // 肝脏检查
                "check_status"         // 检查状态
        ));

        // 第5行：字段类型
        data.add(Arrays.asList(
                "字段类型",                    // 第1列空
                "varchar",             // tjh
                "varchar",             // patient_name
                "int",                 // patient_age
                "varchar",             // heart_check
                "varchar",             // liver_check
                "varchar"              // check_status
        ));

        // 第6行：空行分隔
        data.add(Arrays.asList("", "", "", "", "", "", ""));

        // 第7行：数据区域标题
        data.add(Arrays.asList(
                "↓↓↓ 数据区域（从此行开始填写实际数据）↓↓↓",
                "", "", "", "", "", ""
        ));

        // 数据示例行（从第8行开始）
        // 第1列保持为空，数据从第2列开始对应各个字段
        data.add(Arrays.asList(
                "",                    // 第1列空
                "TJH001",              // tjh
                "张三",                // patient_name
                35,                    // patient_age
                "正常",                // heart_check
                "脂肪肝",              // liver_check
                "已完成"               // check_status
        ));

        data.add(Arrays.asList(
                "",                    // 第1列空
                "TJH002",              // tjh
                "李四",                // patient_name
                28,                    // patient_age
                "心律不齐",            // heart_check
                "正常",                // liver_check
                "进行中"               // check_status
        ));

        data.add(Arrays.asList(
                "",                    // 第1列空
                "TJH003",              // tjh
                "王五",                // patient_name
                42,                    // patient_age
                "正常",                // heart_check
                "正常",                // liver_check
                "已完成"               // check_status
        ));

        data.add(Arrays.asList(
                "",                    // 第1列空
                "TJH004",              // tjh
                "赵六",                // patient_name
                50,                    // patient_age
                "正常",                // heart_check
                "肝硬化",              // liver_check
                "已完成"               // check_status
        ));

        return data;
    }

    // ================= 查询 =================

    @Override
    public DynamicTableQueryRespDTO queryDynamicTables(DynamicTableQueryReqDTO reqDTO) {
        DynamicTableQueryRespDTO resp = new DynamicTableQueryRespDTO();

        try {
            // 1. 获取主表模块编码（从前端传入）
            String mainModuleCode = reqDTO.getMainModuleCode();
            if (StringUtils.isBlank(mainModuleCode)) {
                throw new RuntimeException("请指定主表模块编码");
            }

            // 2. 查询主表模块
            ModuleConfigDO mainModule = moduleConfigMapper.selectOne(
                    new LambdaQueryWrapperX<ModuleConfigDO>()
                            .eq(ModuleConfigDO::getModuleCode, mainModuleCode)
                            .eq(ModuleConfigDO::getStatus, 1)
            );

            if (mainModule == null) {
                throw new RuntimeException("未找到主表模块配置: " + mainModuleCode);
            }

            String mainTableName = mainModule.getTableName();
            String mainAlias = "main";
            String joinField = mainModule.getJoinField() != null ? mainModule.getJoinField() : "tjh";

            log.info("主表信息: code={}, table={}, joinField={}",
                    mainModuleCode, mainTableName, joinField);

            // 3. 获取所有选中的子模块
            List<String> selectedModules = reqDTO.getSelectedModules();
            if (selectedModules == null || selectedModules.isEmpty()) {
                throw new RuntimeException("请选择要查询的模块");
            }

            // 4. 构建查询SQL
            String sql = buildDynamicQuerySql(mainModule, selectedModules, reqDTO);
            String countSql = buildCountSql(sql);

            log.debug("执行查询SQL: {}", sql);
            log.debug("计数SQL: {}", countSql);

            // 5. 执行查询获取数据
            List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql);

            // 6. 获取总记录数
            Long total = 0L;
            try {
                Map<String, Object> countResult = jdbcTemplate.queryForMap(countSql);
                total = ((Number) countResult.get("total")).longValue();
            } catch (Exception e) {
                log.error("获取总记录数失败", e);
            }

            // 7. 处理查询结果，将字段名转换为前端需要的格式
            List<Map<String, Object>> processedList = processQueryResult(dataList, selectedModules);

            // 8. 获取字段显示配置
            List<FieldDisplayVO> displayedFields = getDisplayFieldsForModules(mainModule, selectedModules);

            // 9. 设置返回结果
            resp.setList(processedList);
            resp.setTotal(total);
            resp.setDisplayedFields(displayedFields);
            resp.setStatistics(calculateStatistics(processedList));

            log.info("查询完成: 共{}条记录, 字段配置{}个", total, displayedFields.size());

        } catch (Exception e) {
            log.error("动态表查询失败", e);
            throw new RuntimeException("查询失败: " + e.getMessage(), e);
        }

        return resp;
    }

    /**
     * 构建动态查询SQL
     */
    private String buildDynamicQuerySql(ModuleConfigDO mainModule, List<String> selectedModules,
                                        DynamicTableQueryReqDTO reqDTO) {
        StringBuilder sql = new StringBuilder();

        String mainTable = mainModule.getTableName();
        String mainAlias = "main";
        String joinField = mainModule.getJoinField() != null ? mainModule.getJoinField() : "tjh";

        // 1. 构建SELECT字段
        sql.append("SELECT ");

        // 添加主表所有字段
        List<FieldConfigDO> mainFields = fieldConfigMapper.selectListByModuleCode(mainModule.getModuleCode());
        for (FieldConfigDO field : mainFields) {
            if (field.getStatus() == 1) { // 只取启用状态的字段
                sql.append(mainAlias).append(".").append(field.getFieldCode())
                        .append(" AS ").append(field.getFieldCode()).append(", ");
            }
        }

        // 添加子表字段
        for (String moduleCode  : selectedModules) {
            if (moduleCode.equals(mainModule.getModuleCode())) {
                continue; // 跳过主表
            }

            ModuleConfigDO subModule = getModuleByCode(moduleCode);
            if (subModule == null || subModule.getTableName() == null) {
                log.warn("未找到子模块配置或表名为空: {}", moduleCode);
                continue;
            }

            // 检查是否有子模块（多级表头情况）
            List<ModuleConfigDO> subSubModules = getSubModulesByParentId(subModule.getId());

            if (subSubModules != null && !subSubModules.isEmpty()) {
                // 多级表头情况，使用子子模块
                for (ModuleConfigDO subSubModule : subSubModules) {
                    List<FieldConfigDO> subFields = fieldConfigMapper.selectListByModuleCode(subSubModule.getModuleCode());
                    for (FieldConfigDO field : subFields) {
                        if (field.getStatus() == 1) {
                            String alias = subSubModule.getTableName() + "_" + field.getFieldCode();
                            sql.append(subSubModule.getTableName()).append(".").append(field.getFieldCode())
                                    .append(" AS ").append(alias).append(", ");
                        }
                    }
                }
            } else {
                // 普通子模块
                List<FieldConfigDO> subFields = fieldConfigMapper.selectListByModuleCode(subModule.getModuleCode());
                for (FieldConfigDO field : subFields) {
                    if (field.getStatus() == 1) {
                        String alias = subModule.getTableName() + "_" + field.getFieldCode();
                        sql.append(subModule.getTableName()).append(".").append(field.getFieldCode())
                                .append(" AS ").append(alias).append(", ");
                    }
                }
            }
        }

        // 移除最后一个逗号和空格
        if (sql.length() > 7) { // "SELECT ".length() = 7
            sql.setLength(sql.length() - 2);
        }

        // 2. FROM主表
        sql.append(" FROM ").append(mainTable).append(" ").append(mainAlias);

        // 3. 构建LEFT JOIN子句
        for (String moduleCode : selectedModules) { // 注意：这里应该使用moduleCode，而不是moduleName
            if (moduleCode.equals(mainModule.getModuleCode())) {
                continue;
            }

            // 使用moduleCode查询
            ModuleConfigDO subModule = getModuleByCode(moduleCode);
            if (subModule == null || subModule.getTableName() == null) {
                log.warn("未找到子模块配置或表名为空: {}", moduleCode);
                continue;
            }

            // 检查是否有子模块（多级表头情况）
            List<ModuleConfigDO> subSubModules = getSubModulesByParentId(subModule.getId());

            if (subSubModules != null && !subSubModules.isEmpty()) {
                // 多级表头情况，分别JOIN每个子子模块
                for (ModuleConfigDO subSubModule : subSubModules) {
                    sql.append(" LEFT JOIN ").append(subSubModule.getTableName())
                            .append(" ON ").append(mainAlias).append(".").append(joinField)
                            .append(" = ").append(subSubModule.getTableName()).append(".").append(joinField);
                }
            } else {
                // 普通子模块
                sql.append(" LEFT JOIN ").append(subModule.getTableName())
                        .append(" ON ").append(mainAlias).append(".").append(joinField)
                        .append(" = ").append(subModule.getTableName()).append(".").append(joinField);
            }
        }

        // 4. 构建WHERE条件 - 只查询未删除的数据
        sql.append(" WHERE ").append(mainAlias).append(".deleted = 0");

        // 5. 添加额外的WHERE条件
        String whereClause = buildWhereClause(reqDTO.getConditions(), mainAlias, joinField);
        if (StringUtils.isNotBlank(whereClause)) {
            sql.append(" AND ").append(whereClause);
        }

        // 6. 添加ORDER BY（默认按主表ID排序）
        sql.append(" ORDER BY ").append(mainAlias).append(".id DESC");

        // 7. 添加分页
        if (reqDTO.getPageNo() != null && reqDTO.getPageSize() != null) {
            int offset = (reqDTO.getPageNo() - 1) * reqDTO.getPageSize();
            sql.append(" LIMIT ").append(offset).append(", ").append(reqDTO.getPageSize());
        }

        return sql.toString();
    }


    /**
     * 构建SELECT字段部分 - 从field_config获取字段配置
     */
    private String buildSelectFields(ModuleConfigDO mainModule, List<String> selectedModules, String mainAlias) {
        List<String> fields = new ArrayList<>();

        // 1. 添加主表的所有字段
        List<FieldConfigDO> mainFields = fieldConfigMapper.selectListByModuleCode(mainModule.getModuleCode());
        for (FieldConfigDO field : mainFields) {
            fields.add(mainAlias + "." + field.getFieldCode() + " AS " + field.getFieldCode());
        }

        // 2. 添加子表字段
        for (String moduleCode : selectedModules) {
            if (moduleCode.equals(mainModule.getModuleCode())) {
                continue; // 跳过主表
            }

            ModuleConfigDO subModule = getModuleByCode(moduleCode); // 使用moduleCode查询
            if (subModule == null) {
                log.warn("未找到子模块配置: {}", moduleCode);
                continue;
            }

            List<FieldConfigDO> moduleFields = fieldConfigMapper.selectListByModuleCode(subModule.getModuleCode());
            for (FieldConfigDO field : moduleFields) {
                // 使用表名_字段名作为别名，避免字段冲突
                String fieldAlias = subModule.getTableName() + "_" + field.getFieldCode();
                fields.add(subModule.getTableName() + "." + field.getFieldCode() + " AS " + fieldAlias);
            }
        }

        return String.join(", ", fields);
    }

    /**
     * 构建JOIN子句
     */
    private String buildJoinClauses(List<String> selectedModules, String mainAlias, String joinField) {
        StringBuilder joins = new StringBuilder();

        for (String moduleCode : selectedModules) {
            ModuleConfigDO module = getModuleByCode(moduleCode); // 使用moduleCode查询
            if (module == null) {
                continue;
            }

            // 默认关联字段，如果没有指定则使用"tjh"
            String actualJoinField = StringUtils.isNotBlank(joinField) ? joinField : "tjh";

            joins.append(" LEFT JOIN ").append(module.getTableName())
                    .append(" ON ").append(mainAlias).append(".").append(actualJoinField)
                    .append(" = ").append(module.getTableName()).append(".").append(actualJoinField);
        }

        return joins.toString();
    }

    /**
     * 构建WHERE条件
     */
    private String buildWhereClause(Map<String, Object> conditions, String mainAlias, String joinField) {
        if (conditions == null || conditions.isEmpty()) {
            return "";
        }

        List<String> whereConditions = new ArrayList<>();

        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            // 跳过分页参数和特殊字段
            if (field.equals("pageNo") || field.equals("pageSize") ||
                    field.equals("selectedModules") || field.equals("orderBy") ||
                    field.equals("orderDirection") || field.equals("joinAllTables") ||
                    field.equals("joinField")) {
                continue;
            }

            if (value == null || (value instanceof String && StringUtils.isBlank((String) value))) {
                continue;
            }

            // 处理主表字段（使用mainAlias）
            if (field.startsWith("main_")) {
                String actualField = field.substring(5); // 去掉"main_"前缀
                String condition = buildSingleCondition(mainAlias, actualField, value);
                if (condition != null) {
                    whereConditions.add(condition);
                }
            } else {
                // 暂时不支持子表字段的条件查询
                log.debug("暂不支持子表字段的条件查询: {}", field);
            }
        }

        // 默认只查询未删除的数据
        whereConditions.add(mainAlias + ".deleted = 0");

        return String.join(" AND ", whereConditions);
    }

    /**
     * 构建计数SQL
     */
    private String buildCountSql(String originalSql) {
        // 简单的COUNT查询
        return "SELECT COUNT(*) as total FROM (" + originalSql + ") as count_table";
    }

    /**
     * 执行动态查询
     */
    private List<Map<String, Object>> executeDynamicQuery(String sql, DynamicTableQueryReqDTO reqDTO) {
        try {
            log.debug("执行动态查询SQL: {}", sql);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            log.error("执行动态查询失败, SQL: {}", sql, e);
            throw new RuntimeException("查询执行失败: " + e.getMessage());
        }
    }

    /**
     * 获取总记录数
     */
    private Long getTotalCount(String countSql) {
        try {
            log.debug("执行计数SQL: {}", countSql);
            Map<String, Object> countResult = jdbcTemplate.queryForMap(countSql);
            return ((Number) countResult.get("total")).longValue();
        } catch (Exception e) {
            log.error("获取总记录数失败, SQL: {}", countSql, e);
            return 0L;
        }
    }

    /**
     * 处理查询结果，将字段名转换为前端需要的格式
     */
    private List<Map<String, Object>> processQueryResult(List<Map<String, Object>> dataList,
                                                         List<String> selectedModules) {
        if (dataList == null || dataList.isEmpty()) {
            return new ArrayList<>();
        }

        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> row : dataList) {
            Map<String, Object> processedRow = new LinkedHashMap<>();

            for (Map.Entry<String, Object> entry : row.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // 如果key包含下划线，可能需要转换格式
                if (key.contains("_")) {
                    // 保持原样，因为前端期望的是表名_字段名的格式
                    processedRow.put(key, value);
                } else {
                    // 主表字段保持原样
                    processedRow.put(key, value);
                }
            }

            result.add(processedRow);
        }

        return result;
    }

    /**
     * 获取字段显示配置 - 适配前端多级表头
     */
    private List<FieldDisplayVO> getDisplayFieldsForModules(ModuleConfigDO mainModule,
                                                            List<String> selectedModules) {
        List<FieldDisplayVO> result = new ArrayList<>();

        // 1. 添加主表字段作为"基础信息"组
        FieldDisplayVO mainDisplayVO = new FieldDisplayVO();
        mainDisplayVO.setGroupName("基础信息");

        List<FieldConfigDO> mainFields = fieldConfigMapper.selectListByModuleCode(mainModule.getModuleCode());
        List<FieldDisplayVO.FieldInfo> mainFieldInfos = mainFields.stream()
                .filter(field -> field.getStatus() == 1) // 只取启用状态的字段
                .map(field -> {
                    FieldDisplayVO.FieldInfo fieldInfo = new FieldDisplayVO.FieldInfo();
                    fieldInfo.setFieldCode(field.getFieldCode());
                    fieldInfo.setFieldLabel(field.getFieldLabel());
                    fieldInfo.setFieldType(field.getFieldType());
                    fieldInfo.setTableName(mainModule.getTableName());
                    fieldInfo.setProp(field.getFieldCode()); // 主表字段直接使用字段名
                    return fieldInfo;
                })
                .collect(Collectors.toList());

        mainDisplayVO.setFields(mainFieldInfos);
        result.add(mainDisplayVO);

        // 2. 添加选中的子模块字段
        for (String moduleCode : selectedModules) { // 使用moduleCode
            if (moduleCode.equals(mainModule.getModuleCode())) {
                continue;
            }

            ModuleConfigDO subModule = getModuleByCode(moduleCode); // 使用moduleCode查询
            if (subModule == null) {
                log.warn("未找到子模块配置: {}", moduleCode);
                continue;
            }

            // 检查是否有子模块（多级表头情况）
            List<ModuleConfigDO> subSubModules = getSubModulesByParentId(subModule.getId());

            if (subSubModules != null && !subSubModules.isEmpty()) {
                // 多级表头情况
                for (ModuleConfigDO subSubModule : subSubModules) {
                    FieldDisplayVO subDisplayVO = new FieldDisplayVO();
                    subDisplayVO.setGroupName(subSubModule.getModuleName());

                    List<FieldConfigDO> subFields = fieldConfigMapper.selectListByModuleCode(subSubModule.getModuleCode());
                    List<FieldDisplayVO.FieldInfo> fieldInfos = subFields.stream()
                            .filter(field -> field.getStatus() == 1)
                            .map(field -> {
                                FieldDisplayVO.FieldInfo fieldInfo = new FieldDisplayVO.FieldInfo();
                                fieldInfo.setFieldCode(field.getFieldCode());
                                fieldInfo.setFieldLabel(field.getFieldLabel());
                                fieldInfo.setFieldType(field.getFieldType());
                                fieldInfo.setTableName(subSubModule.getTableName());
                                // 使用表名_字段名作为prop
                                fieldInfo.setProp(subSubModule.getTableName() + "_" + field.getFieldCode());
                                return fieldInfo;
                            })
                            .collect(Collectors.toList());

                    subDisplayVO.setFields(fieldInfos);
                    result.add(subDisplayVO);
                }
            } else {
                // 普通子模块
                FieldDisplayVO subDisplayVO = new FieldDisplayVO();
                subDisplayVO.setGroupName(subModule.getModuleName());

                List<FieldConfigDO> subFields = fieldConfigMapper.selectListByModuleCode(subModule.getModuleCode());
                List<FieldDisplayVO.FieldInfo> fieldInfos = subFields.stream()
                        .filter(field -> field.getStatus() == 1)
                        .map(field -> {
                            FieldDisplayVO.FieldInfo fieldInfo = new FieldDisplayVO.FieldInfo();
                            fieldInfo.setFieldCode(field.getFieldCode());
                            fieldInfo.setFieldLabel(field.getFieldLabel());
                            fieldInfo.setFieldType(field.getFieldType());
                            fieldInfo.setTableName(subModule.getTableName());
                            // 使用表名_字段名作为prop
                            fieldInfo.setProp(subModule.getTableName() + "_" + field.getFieldCode());
                            return fieldInfo;
                        })
                        .collect(Collectors.toList());

                subDisplayVO.setFields(fieldInfos);
                result.add(subDisplayVO);
            }
        }

        return result;
    }

    /**
     * 根据父模块ID获取子模块列表
     */
    private List<ModuleConfigDO> getSubModulesByParentId(Long parentId) {
        if (parentId == null) {
            return null;
        }
        return moduleConfigMapper.selectList(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getParentId, parentId)
                        .eq(ModuleConfigDO::getIsLeaf, 1));
        // 如果有sortOrder字段，可以加上排序
        // .orderByAsc(ModuleConfigDO::getSortOrder));
    }

    /**
     * 根据模块名称获取模块配置
     */
    private ModuleConfigDO getModuleByName(String moduleName) {
        return moduleConfigMapper.selectOne(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getModuleName, moduleName)
                        .eq(ModuleConfigDO::getIsLeaf, 1));
    }

    /**
     * 根据模块编码获取模块配置
     */
    private ModuleConfigDO getModuleByCode(String moduleCode) {
        if (StringUtils.isBlank(moduleCode)) {
            return null;
        }
        return moduleConfigMapper.selectOne(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getModuleCode, moduleCode));
    }

    /**
     * 将字段配置转换为字段信息
     */
    private List<FieldDisplayVO.FieldInfo> convertToFieldInfo(List<FieldConfigDO> fields, String tableName) {
        if (fields == null || fields.isEmpty()) {
            return new ArrayList<>();
        }

        return fields.stream()
                .filter(field -> {
                    // 过滤掉关联字段和系统字段
                    if ("tjh".equals(field.getFieldCode())) return false;
                    if (field.getFieldCode().toLowerCase().endsWith("name")) return false;
                    if (field.getStatus() != 1) return false; // 只返回启用状态的字段
                    return true;
                })
                .map(field -> {
                    FieldDisplayVO.FieldInfo fieldInfo = new FieldDisplayVO.FieldInfo();
                    fieldInfo.setFieldCode(field.getFieldCode());
                    fieldInfo.setFieldLabel(field.getFieldLabel());
                    fieldInfo.setFieldType(field.getFieldType());
                    fieldInfo.setTableName(tableName);

                    // 生成唯一属性名：表名_字段名
                    String prop = tableName + "_" + field.getFieldCode();
                    fieldInfo.setProp(prop);

                    return fieldInfo;
                })
                .collect(Collectors.toList());
    }

    /**
     * 将字段配置转换为字段信息
     */
    private List<FieldDisplayVO.FieldInfo> convertToFieldInfo(List<FieldConfigDO> fields, String tableName, boolean isMainTable) {
        if (fields == null || fields.isEmpty()) {
            return new ArrayList<>();
        }

        return fields.stream()
                .filter(field -> !"tjh".equals(field.getFieldCode())) // 排除关联字段
                .map(field -> {
                    FieldDisplayVO.FieldInfo fieldInfo = new FieldDisplayVO.FieldInfo();
                    fieldInfo.setFieldCode(field.getFieldCode());
                    fieldInfo.setFieldLabel(field.getFieldLabel());
                    fieldInfo.setFieldType(field.getFieldType());
                    fieldInfo.setTableName(tableName);

                    // 生成唯一属性名：如果是主表字段，直接使用字段名；如果是子表字段，使用表名_字段名
                    String prop = isMainTable ? field.getFieldCode() : tableName + "_" + field.getFieldCode();
                    fieldInfo.setProp(prop);

                    return fieldInfo;
                })
                .collect(Collectors.toList());
    }

    /**
     * 根据字段名确定表别名
     */
    private String getTableAliasForField(String field) {
        // 简单的实现：如果字段包含表名前缀，使用该前缀
        if (field.contains("_")) {
            String[] parts = field.split("_");
            if (parts.length > 1) {
                return parts[0];
            }
        }
        return "main"; // 默认使用主表
    }

    /**
     * 构建单个查询条件
     */
    private String buildSingleCondition(String tableAlias, String field, Object value) {
        if (value == null) {
            return null;
        }

        String fullFieldName = tableAlias + "." + field;

        if (value instanceof String) {
            String strValue = ((String) value).trim();
            if (StringUtils.isNotBlank(strValue)) {
                return fullFieldName + " LIKE '%" + escapeSql(strValue) + "%'";
            }
        } else if (value instanceof Number) {
            return fullFieldName + " = " + value;
        } else if (value instanceof List) {
            List<?> listValue = (List<?>) value;
            if (!listValue.isEmpty()) {
                String inValues = listValue.stream()
                        .map(Object::toString)
                        .map(this::escapeSql)
                        .map(v -> "'" + v + "'")
                        .collect(Collectors.joining(","));
                return fullFieldName + " IN (" + inValues + ")";
            }
        }

        return null;
    }

    /**
     * SQL转义
     */
    private String escapeSql(String str) {
        if (str == null) return "";
        return str.replace("'", "''");
    }

    /**
     * 计算统计信息
     */
    private Map<String, Object> calculateStatistics(List<Map<String, Object>> dataList) {
        Map<String, Object> statistics = new HashMap<>();

        if (dataList == null || dataList.isEmpty()) {
            return statistics;
        }

        // 这里可以添加各种统计计算逻辑
        statistics.put("totalCount", dataList.size());
        statistics.put("queryTime", new Date());

        return statistics;
    }

    @Override
    public List<ModuleConfigDO> getQueryableModules() {
        // 查询所有叶子模块（即实际有表的模块）
        return moduleConfigMapper.selectList(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getIsLeaf, 1)
                        .isNotNull(ModuleConfigDO::getTableName)
                        .orderByAsc(ModuleConfigDO::getModuleName));
    }

    @Override
    public List<FieldDisplayVO> getModuleFields(List<String> moduleCodes) {
        if (moduleCodes == null || moduleCodes.isEmpty()) {
            return new ArrayList<>();
        }

        List<FieldDisplayVO> result = new ArrayList<>();

        for (String moduleCode : moduleCodes) {
            ModuleConfigDO module = getModuleByCode(moduleCode);
            if (module == null) {
                continue;
            }

            List<FieldConfigDO> fields = fieldConfigMapper.selectListByModuleCode(module.getModuleCode());

            FieldDisplayVO displayVO = new FieldDisplayVO();
            displayVO.setGroupName(module.getModuleName());
            displayVO.setFields(convertToFieldInfo(fields, module.getTableName(), false));

            result.add(displayVO);
        }

        return result;
    }

    /**
     * 递归获取所有子模块（包括多级）
     */
    private List<ModuleConfigDO> getAllChildModules(Long parentId) {
        if (parentId == null) {
            return new ArrayList<>();
        }

        List<ModuleConfigDO> result = new ArrayList<>();
        List<ModuleConfigDO> directChildren = moduleConfigMapper.selectList(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getParentId, parentId)
                        .eq(ModuleConfigDO::getStatus, 1));

        for (ModuleConfigDO child : directChildren) {
            result.add(child);
            // 递归获取孙模块
            result.addAll(getAllChildModules(child.getId()));
        }

        return result;
    }
}
