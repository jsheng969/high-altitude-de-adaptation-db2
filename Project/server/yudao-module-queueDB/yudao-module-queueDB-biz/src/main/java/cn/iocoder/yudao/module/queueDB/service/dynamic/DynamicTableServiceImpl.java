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

            // 1. 读取Excel
            List<Map<Integer, Object>> rawData = EasyExcel.read(importReq.getFile().getInputStream())
                    .sheet(0)
                    .headRowNumber(0)
                    .doReadSync();

            // 转成 List<List<Object>>
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

            // 2. 解析字段配置（从第1-5行）
            List<String> fieldGroupRow = toStringList(excelData.get(0));    // 第1行：字段分组
            List<String> groupCodeRow = toStringList(excelData.get(1));     // 第2行：分组标识
            List<String> fieldNameRow = toStringList(excelData.get(2));     // 第3行：字段名称
            List<String> fieldCodeRow = toStringList(excelData.get(3));     // 第4行：字段标识
            List<String> fieldTypeRow = toStringList(excelData.get(4));     // 第5行：字段类型

            // 3. 检查并处理顶级模块唯一性 - 增强检查
            String parentModuleCode = importReq.getModuleCode();

            // 双重检查：先检查是否存在，如果存在则删除
            boolean parentModuleExists = moduleConfigMapper.existsByModuleCode(parentModuleCode) > 0;
            if (parentModuleExists) {
                log.info("顶级模块已存在，执行删除操作: {}", parentModuleCode);
                deleteModuleAndRelatedData(parentModuleCode);

                // 删除后再次检查确认
                boolean stillExists = moduleConfigMapper.existsByModuleCode(parentModuleCode) > 0;
                if (stillExists) {
                    throw new RuntimeException("模块删除后仍然存在，可能存在数据库同步问题: " + parentModuleCode);
                }
            }

            // 4. 创建顶级模块（parent_id为null）
            ModuleConfigDO parentModule = new ModuleConfigDO();
            parentModule.setModuleCode(parentModuleCode);
            parentModule.setModuleName(importReq.getModuleName());
            parentModule.setModuleLevel(1);
            parentModule.setModuleType(importReq.getModuleType());
            parentModule.setGroupType(importReq.getGroupType());
            parentModule.setTableName("dyn_" + parentModuleCode.toLowerCase());

            // 插入前再次检查（防止并发问题）
            if (moduleConfigMapper.existsByModuleCode(parentModuleCode) > 0) {
                throw new RuntimeException("模块编码冲突，请稍后重试: " + parentModuleCode);
            }

            moduleConfigMapper.insert(parentModule);
            log.info("成功创建顶级模块: {}", parentModuleCode);

            // 设置模块信息到结果
            resultVO.setModuleCode(parentModule.getModuleCode());
            resultVO.setTableName(parentModule.getTableName());

            // 5. 按分组整理字段并创建子模块
            Map<String, List<FieldConfigDO>> groupFieldMap = new LinkedHashMap<>();
            Map<String, ModuleConfigDO> groupModuleMap = new HashMap<>();

// 添加默认分组（当分组信息为空时使用）
            String defaultGroupCode = "default";
            String defaultGroupName = "默认分组";

// 确定最大列数（以字段标识行为准）
            int maxColumns = fieldCodeRow.size();

            log.info("解析到的列数 - 字段分组: {}, 分组标识: {}, 字段名称: {}, 字段标识: {}, 字段类型: {}",
                    fieldGroupRow.size(), groupCodeRow.size(), fieldNameRow.size(), fieldCodeRow.size(), fieldTypeRow.size());

            for (int col = 1; col < maxColumns; col++) {  // 从第2列开始（第1列是空列）
                // 跳过空列
                if (StringUtils.isBlank(fieldCodeRow.get(col))) {
                    continue;
                }

                // 安全处理分组信息 - 防止索引越界
                String groupCode = defaultGroupCode;
                String groupName = defaultGroupName;

                // 安全获取分组标识
                if (groupCodeRow.size() > col && StringUtils.isNotBlank(groupCodeRow.get(col))) {
                    groupCode = groupCodeRow.get(col);
                }

                // 安全获取字段分组
                if (fieldGroupRow.size() > col && StringUtils.isNotBlank(fieldGroupRow.get(col))) {
                    groupName = fieldGroupRow.get(col);
                }

                log.info("处理第{}列: 字段标识={}, 分组标识={}, 分组名称={}", col, fieldCodeRow.get(col), groupCode, groupName);

                // 为每个分组创建子模块（如果尚未创建）
                if (!groupModuleMap.containsKey(groupCode)) {
                    String groupModuleCode = groupCode.equals(defaultGroupCode) ?
                            parentModule.getModuleCode() : // 默认分组直接使用父模块code
                            parentModule.getModuleCode() + "_" + groupCode;

                    // 检查子模块是否已存在（防止并发问题）
                    if (moduleConfigMapper.existsByModuleCode(groupModuleCode) > 0) {
                        log.warn("子模块已存在，跳过创建: {}", groupModuleCode);
                        ModuleConfigDO existingModule = moduleConfigMapper.selectByModuleCode(groupModuleCode);
                        groupModuleMap.put(groupCode, existingModule);
                    } else {
                        ModuleConfigDO groupModule = new ModuleConfigDO();
                        groupModule.setParentId(parentModule.getId());
                        groupModule.setModuleCode(groupModuleCode);
                        groupModule.setModuleName(groupName);
                        groupModule.setModuleLevel(2);
                        groupModule.setIsLeaf(1);
                        groupModule.setTableName(parentModule.getTableName());
                        groupModule.setGroupType(importReq.getGroupType());
                        moduleConfigMapper.insert(groupModule);
                        groupModuleMap.put(groupCode, groupModule);
                        log.info("创建子模块: {}", groupModuleCode);
                    }
                }

                // 创建字段配置
                FieldConfigDO field = new FieldConfigDO();
                field.setFieldCode(fieldCodeRow.get(col));
                field.setFieldLabel(fieldNameRow.get(col));
                field.setFieldType(fieldTypeRow.get(col));
                field.setFieldGroup(groupCode);
                field.setFieldGroupName(groupName);
                field.setIsRequired(0);
                field.setDisplayOrder(col);

                // 设置module_code：使用分组对应的模块code
                field.setModuleCode(groupModuleMap.get(groupCode).getModuleCode());

                // 根据字段类型设置数据类型
                String dataType = mapExcelFieldTypeToDataType(fieldTypeRow.get(col));
                field.setDataType(dataType);

                groupFieldMap.computeIfAbsent(groupCode, k -> new ArrayList<>()).add(field);
            }

            // 6. 插入所有字段配置到数据库（先检查并处理重复字段）
            int totalFields = 0;
            int successFields = 0;
            for (List<FieldConfigDO> fieldList : groupFieldMap.values()) {
                totalFields += fieldList.size();
                for (FieldConfigDO field : fieldList) {
                    try {
                        // 检查字段是否已存在（包含逻辑删除的记录）
                        boolean fieldExists = fieldConfigMapper.checkFieldCodeExists(
                                field.getFieldCode(), field.getModuleCode()) > 0;

                        if (fieldExists) {
                            log.info("字段已存在，执行物理删除: {}.{}", field.getModuleCode(), field.getFieldCode());
                            // 使用 Mapper 物理删除字段
                            fieldConfigMapper.physicallyDeleteByModuleCodeAndFieldCode(
                                    field.getModuleCode(), field.getFieldCode());
                        }

                        // 插入新字段（使用 MyBatis-Plus 的 insert 方法）
                        fieldConfigMapper.insert(field);
                        successFields++;

                    } catch (Exception e) {
                        String error = "字段插入失败: " + field.getFieldCode() + ", 错误: " + e.getMessage();
                        resultVO.addError(error);
                        log.error(error, e);
                    }
                }
            }
            resultVO.setTotalFields(totalFields);
            resultVO.setSuccessFields(successFields);

            // 7. 收集所有字段用于创建单张表
            List<FieldConfigDO> allFieldsForTable = new ArrayList<>();
            for (List<FieldConfigDO> fieldList : groupFieldMap.values()) {
                allFieldsForTable.addAll(fieldList);
            }

            // 8. 创建或更新单张表（使用顶级模块的表名）
            createOrUpdateTable(parentModule.getModuleCode());

            // 9. 插入数据（从第7行开始，跳过表头和数据区域标题行）
            int dataStartRow = 6;
            int totalDataRows = 0;
            int successDataRows = 0;

            for (int rowIndex = dataStartRow; rowIndex < excelData.size(); rowIndex++) {
                List<Object> row = excelData.get(rowIndex);

                // 跳过空行和说明行
                if (row.isEmpty() || isDescriptionRow(row) || row.stream().allMatch(Objects::isNull)) {
                    continue;
                }

                totalDataRows++;
                Map<String, Object> rowData = new HashMap<>();

                // 遍历所有字段，从第2列开始（第1列是空列）
                for (int fieldIndex = 0; fieldIndex < allFieldsForTable.size(); fieldIndex++) {
                    FieldConfigDO field = allFieldsForTable.get(fieldIndex);
                    int excelColIndex = fieldIndex + 1;

                    Object value = (excelColIndex < row.size()) ? row.get(excelColIndex) : null;
                    rowData.put(field.getFieldCode(), convertValueByType(field.getFieldType(), value));
                }

                try {
                    insertIntoTable(parentModule.getTableName(), rowData);
                    successDataRows++;
                } catch (Exception e) {
                    String error = "第" + (rowIndex + 1) + "行数据插入失败: " + e.getMessage();
                    resultVO.addError(error);
                    log.error(error, e);
                }
            }

            // 设置数据记录数
            resultVO.setTotalRecords(totalDataRows);
            resultVO.setSuccessRecords(successDataRows);

            // 10. 设置最终结果
            long costTime = System.currentTimeMillis() - startTime;
            resultVO.setCostTime(costTime);
            resultVO.setSuccess(!resultVO.hasErrors());
            resultVO.setMessage(resultVO.getSuccessMessage());
            resultVO.setConfigMode("SINGLE_TABLE_WITH_GROUPS");

            // 记录导入历史
            recordImportHistory(importReq, resultVO);

            log.info("Excel导入完成: {}", resultVO.getSuccessMessage());

        } catch (Exception e) {
            long costTime = System.currentTimeMillis() - startTime;
            resultVO.setCostTime(costTime);
            resultVO.setSuccess(false);
            resultVO.setMessage("导入失败: " + e.getMessage());
            resultVO.addError("系统异常: " + e.getMessage());
            log.error("Excel导入异常", e);
        }

        return resultVO;
    }

    /**
     * 删除模块及相关数据 - 物理删除（使用 Mapper）
     */
    private void deleteModuleAndRelatedData(String moduleCode) {
        try {
            // 1. 查询顶级模块（包含逻辑删除的记录）
            ModuleConfigDO parentModule = moduleConfigMapper.selectByModuleCodeIncludeDeleted(moduleCode);

            if (parentModule == null) {
                log.info("顶级模块不存在，无需删除: {}", moduleCode);
                return;
            }

            log.info("开始物理删除模块及相关数据: {}", moduleCode);

            // 2. 查询所有相关的模块（包括逻辑删除的记录）
            List<ModuleConfigDO> allRelatedModules = new ArrayList<>();
            allRelatedModules.add(parentModule);

            // 查询所有子模块（包含逻辑删除的）
            List<ModuleConfigDO> childModules = moduleConfigMapper.selectByParentIdIncludeDeleted(parentModule.getId());
            allRelatedModules.addAll(childModules);

            // 3. 物理删除所有相关模块的字段配置
            for (ModuleConfigDO module : allRelatedModules) {
                int deletedFields = fieldConfigMapper.physicallyDeleteByModuleCode(module.getModuleCode());
                log.info("物理删除模块 [{}] 的 {} 个字段配置", module.getModuleCode(), deletedFields);
            }

            // 4. 物理删除所有子模块
            if (!childModules.isEmpty()) {
                // 收集子模块ID
                List<Long> childModuleIds = childModules.stream()
                        .map(ModuleConfigDO::getId)
                        .collect(Collectors.toList());

                // 使用批量删除
                int deletedChildModules = moduleConfigMapper.physicallyDeleteByIds(childModuleIds);
                log.info("物理删除 {} 个子模块", deletedChildModules);
            }

            // 5. 物理删除父级模块
            int deletedParent = moduleConfigMapper.physicallyDeleteById(parentModule.getId());
            log.info("物理删除父级模块: {} (影响行数: {})", parentModule.getModuleCode(), deletedParent);

            // 6. 物理删除对应的动态表（使用 JdbcTemplate，因为这是 DDL 操作）
            String tableName = "dyn_" + moduleCode.toLowerCase();
            if (tableExists(tableName)) {
                try {
                    jdbcTemplate.execute("DROP TABLE IF EXISTS " + tableName);
                    log.info("物理删除动态表: {}", tableName);
                } catch (Exception e) {
                    log.warn("物理删除动态表失败: {}，错误: {}", tableName, e.getMessage());
                }
            } else {
                log.info("动态表不存在，无需删除: {}", tableName);
            }

            log.info("成功物理删除模块及相关数据: {}", moduleCode);

        } catch (Exception e) {
            log.error("物理删除模块及相关数据失败: {}", moduleCode, e);
            throw new RuntimeException("物理删除模块失败: " + e.getMessage(), e);
        }
    }

    /**
     * 判断是否是说明行
     */
    private boolean isDescriptionRow(List<Object> row) {
        if (row.isEmpty() || row.get(0) == null) {
            return false;
        }
        String firstCell = row.get(0).toString();
        return firstCell.contains("↓↓↓") || firstCell.contains("使用说明");
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

    private void insertIntoTable(String tableName, Map<String, Object> data) {
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        sql.append(String.join(",", data.keySet())).append(") VALUES (");
        sql.append(data.keySet().stream().map(k -> "?").collect(Collectors.joining(","))).append(")");
        jdbcTemplate.update(sql.toString(), data.values().toArray());
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
     */
    private List<List<Object>> createTemplateData() {
        List<List<Object>> data = new ArrayList<>();

        // 字段配置区域 - 横向结构
        data.add(Arrays.asList("字段分组", "患者基本信息", "患者基本信息", "检查结果", "检查结果", "状态信息"));
        data.add(Arrays.asList("分组标识", "info", "info", "result", "result", "status"));
        data.add(Arrays.asList("字段名称", "患者姓名", "患者年龄", "心脏检查", "肝脏检查", "检查状态"));
        data.add(Arrays.asList("字段标识", "patient_name", "patient_age", "heart_check", "liver_check", "check_status"));
        data.add(Arrays.asList("字段类型", "varchar", "int", "varchar", "varchar", "varchar"));

        // 空行分隔
        data.add(Arrays.asList("", "", "", "", "", ""));

        // 数据区域标题
        data.add(Arrays.asList("↓↓↓ 数据区域（从此行开始填写实际数据）↓↓↓", "", "", "", "", ""));

        // 数据示例
        data.add(Arrays.asList("", "张三", 35, "正常", "脂肪肝", "已完成"));
        data.add(Arrays.asList("", "李四", 28, "心律不齐", "正常", "进行中"));
        data.add(Arrays.asList("", "王五", 42, "正常", "正常", "已完成"));
        data.add(Arrays.asList("", "赵六", 50, "正常", "肝硬化", "已完成"));

        // 空行
        data.add(Arrays.asList("", "", "", "", "", ""));

        // 使用说明
        data.add(Arrays.asList("↓↓↓ 使用说明 ↓↓↓", "", "", "", "", ""));
        data.add(Arrays.asList("1. 第1-5行：字段配置表头，请勿修改结构", "", "", "", "", ""));
        data.add(Arrays.asList("2. 字段分组：字段所属分组（中文）", "", "", "", "", ""));
        data.add(Arrays.asList("3. 分组标识：分组英文标识", "", "", "", "", ""));
        data.add(Arrays.asList("4. 字段名称：字段显示名称（中文）", "", "", "", "", ""));
        data.add(Arrays.asList("5. 字段标识：数据库字段名（英文）", "", "", "", "", ""));
        data.add(Arrays.asList("6. 字段类型：varchar/int/decimal/date等", "", "", "", "", ""));
        data.add(Arrays.asList("7. 第7行开始：填写实际数据", "", "", "", "", ""));
        data.add(Arrays.asList("8. 数据列必须与表头列对应", "", "", "", "", ""));

        return data;
    }

    // ================= 查询 =================
    // 在 DynamicTableServiceImpl.java 中添加以下方法

    @Override
    public DynamicTableQueryRespDTO queryDynamicTables(DynamicTableQueryReqDTO reqDTO) {
        DynamicTableQueryRespDTO resp = new DynamicTableQueryRespDTO();

        try {
            // 1. 构建查询SQL
            String sql = buildDynamicQuerySql(reqDTO);
            String countSql = buildCountSql(sql);

            // 2. 执行查询获取数据
            List<Map<String, Object>> dataList = executeDynamicQuery(sql, reqDTO);

            // 3. 获取总记录数
            Long total = getTotalCount(countSql);

            // 4. 获取字段显示配置
            List<FieldDisplayVO> displayedFields = getDisplayFieldsForModules(reqDTO.getSelectedModules());

            // 5. 设置返回结果
            resp.setList(dataList);
            resp.setTotal(total);
            resp.setDisplayedFields(displayedFields);
            resp.setStatistics(calculateStatistics(dataList));

        } catch (Exception e) {
            log.error("动态表查询失败", e);
            throw new RuntimeException("查询失败: " + e.getMessage());
        }

        return resp;
    }

    /**
     * 构建动态查询SQL
     */
    private String buildDynamicQuerySql(DynamicTableQueryReqDTO reqDTO) {
        StringBuilder sql = new StringBuilder();
        List<String> selectedModules = reqDTO.getSelectedModules();

        if (selectedModules == null || selectedModules.isEmpty()) {
            throw new RuntimeException("请选择要查询的模块");
        }

        // 1. 确定主表（dyn_basic_info）
        String mainTable = "dyn_basic_info";

        // 2. 构建SELECT字段
        sql.append("SELECT ");
        sql.append(buildSelectFields(selectedModules));
        sql.append(" FROM ").append(mainTable).append(" main ");

        // 3. 构建LEFT JOIN
        sql.append(buildJoinClauses(selectedModules, mainTable, reqDTO.getJoinField()));

        // 4. 构建WHERE条件
        String whereClause = buildWhereClause(reqDTO.getConditions());
        if (StringUtils.isNotBlank(whereClause)) {
            sql.append(" WHERE ").append(whereClause);
        }

        // 5. 构建ORDER BY
        if (StringUtils.isNotBlank(reqDTO.getOrderBy())) {
            sql.append(" ORDER BY ").append(reqDTO.getOrderBy());
            if (StringUtils.isNotBlank(reqDTO.getOrderDirection())) {
                sql.append(" ").append(reqDTO.getOrderDirection());
            }
        }

        // 6. 构建分页
        if (reqDTO.getPageNo() != null && reqDTO.getPageSize() != null) {
            sql.append(" LIMIT ").append((reqDTO.getPageNo() - 1) * reqDTO.getPageSize())
                    .append(", ").append(reqDTO.getPageSize());
        }

        log.debug("动态查询SQL: {}", sql);
        return sql.toString();
    }

    /**
     * 构建SELECT字段部分
     */
    private String buildSelectFields(List<String> selectedModules) {
        List<String> fields = new ArrayList<>();

        // 基础信息表字段
        fields.add("main.tjh");
        fields.add("main.name");
        fields.add("main.id_number");

        // 动态添加其他表的字段
        for (String moduleName : selectedModules) {
            ModuleConfigDO module = getModuleByName(moduleName);
            if (module == null || "基础信息".equals(moduleName)) {
                continue; // 跳过基础信息表，已经在main表中
            }

            List<FieldConfigDO> moduleFields = fieldConfigMapper.selectListByModuleCode(module.getModuleCode());
            for (FieldConfigDO field : moduleFields) {
                // 使用表别名避免字段冲突
                String fieldAlias = module.getTableName() + "_" + field.getFieldCode();
                fields.add(module.getTableName() + "." + field.getFieldCode() + " AS " + fieldAlias);
            }
        }

        return String.join(", ", fields);
    }

    /**
     * 构建JOIN子句
     */
    private String buildJoinClauses(List<String> selectedModules, String mainTable, String joinField) {
        StringBuilder joins = new StringBuilder();

        for (String moduleName : selectedModules) {
            ModuleConfigDO module = getModuleByName(moduleName);
            if (module == null || "基础信息".equals(moduleName)) {
                continue; // 跳过基础信息表
            }

            joins.append(" LEFT JOIN ").append(module.getTableName())
                    .append(" ON main.").append(joinField)
                    .append(" = ").append(module.getTableName()).append(".").append(joinField);
        }

        return joins.toString();
    }

    /**
     * 构建WHERE条件
     */
    private String buildWhereClause(Map<String, Object> conditions) {
        if (conditions == null || conditions.isEmpty()) {
            return "";
        }

        List<String> whereConditions = new ArrayList<>();

        // 定义要排除的字段（分页字段和其他非表字段）
        Set<String> excludedFields = new HashSet<>(Arrays.asList(
                "pageNo", "pageSize","group", "selectedModules", "orderBy",
                "orderDirection", "joinAllTables", "joinField"
        ));

        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            // 跳过排除的字段
            if (excludedFields.contains(field)) {
                continue;
            }

            if (value == null || StringUtils.isBlank(value.toString())) {
                continue;
            }

            // 根据字段名确定表别名
            String tableAlias = getTableAliasForField(field);
            String condition = buildSingleCondition(tableAlias, field, value);
            if (StringUtils.isNotBlank(condition)) {
                whereConditions.add(condition);
            }
        }

        return String.join(" AND ", whereConditions);
    }

    /**
     * 构建计数SQL
     */
    private String buildCountSql(String originalSql) {
        // 从原始SQL中移除ORDER BY和LIMIT子句，然后包装成COUNT查询
        String countSql = originalSql
                .replaceAll("ORDER BY.*?(?=LIMIT|$)", "") // 移除ORDER BY
                .replaceAll("LIMIT.*", ""); // 移除LIMIT

        // 如果包含GROUP BY，需要特殊处理
        if (countSql.toUpperCase().contains("GROUP BY")) {
            return "SELECT COUNT(*) as total FROM (" + countSql + ") as count_table";
        } else {
            // 简单的COUNT查询
            return "SELECT COUNT(*) as total FROM (" + countSql + ") as count_table";
        }
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
     * 根据模块名称获取字段显示配置
     */
    private List<FieldDisplayVO> getDisplayFieldsForModules(List<String> moduleNames) {
        if (moduleNames == null || moduleNames.isEmpty()) {
            return new ArrayList<>();
        }

        List<FieldDisplayVO> result = new ArrayList<>();

        for (String moduleName : moduleNames) {
            // 根据模块名称获取模块配置
            ModuleConfigDO module = getModuleByName(moduleName);
            if (module == null) {
                continue;
            }

            // 获取该模块的所有字段
            List<FieldConfigDO> fields = fieldConfigMapper.selectListByModuleCode(module.getModuleCode());

            FieldDisplayVO displayVO = new FieldDisplayVO();
            displayVO.setGroupName(module.getModuleName());
            displayVO.setFields(convertToFieldInfo(fields, module.getTableName()));

            result.add(displayVO);
        }

        return result;
    }

    /**
     * 将字段配置转换为字段信息
     */
    private List<FieldDisplayVO.FieldInfo> convertToFieldInfo(List<FieldConfigDO> fields, String tableName) {
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
                    fieldInfo.setProp(tableName + "_" + field.getFieldCode()); // 生成唯一属性名
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

        String fieldName = field;
        // 如果字段名包含表别名，移除表别名部分
        if (field.contains("_")) {
            String[] parts = field.split("_");
            if (parts.length > 1) {
                fieldName = parts[1];
            }
        }

        String fullFieldName = tableAlias + "." + fieldName;

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

    /**
     * 根据模块名称获取模块配置
     */
    private ModuleConfigDO getModuleByName(String moduleName) {
        return moduleConfigMapper.selectOne(
                new LambdaQueryWrapperX<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getModuleName, moduleName));
//                        .eq(ModuleConfigDO::getIsLeaf, 1));
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
    public List<FieldDisplayVO> getModuleFields(List<String> moduleNames) {
        return getDisplayFieldsForModules(moduleNames);
    }
}
