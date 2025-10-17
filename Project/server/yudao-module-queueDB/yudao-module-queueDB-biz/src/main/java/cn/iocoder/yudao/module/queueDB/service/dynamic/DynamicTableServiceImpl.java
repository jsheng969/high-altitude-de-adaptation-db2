package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
import cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig.ModuleConfigMapper;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
     */
    @Override
    public void createOrUpdateTable(String moduleCode) {
        // 1. 查询字段配置
        List<FieldConfigDO> fields = fieldConfigMapper.selectListByModuleCode(moduleCode);
        if (fields == null || fields.isEmpty()) {
            log.warn("模块 [{}] 未配置字段，跳过创建表", moduleCode);
            return;
        }

        // 2. 拼接表名（规则可自定义）
        String tableName = "dyn_" + moduleCode.toLowerCase();

        // 3. 判断表是否存在
        boolean exists = tableExists(tableName);

        // 4. 拼接建表或修改表 SQL
        if (!exists) {
            createNewTable(tableName, fields);
        } else {
            syncExistingTable(tableName, fields);
        }
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
     * 构造字段 SQL
     */
    private String buildColumnSql(FieldConfigDO field) {
        StringBuilder sb = new StringBuilder();
        sb.append(field.getFieldCode()).append(" ");

        // 映射字段类型到数据库类型
        String dataType = mapFieldTypeToDataType(field);
        sb.append(dataType);

        // 是否必填
        if (field.getIsRequired() != null && field.getIsRequired() == 1) {
            sb.append(" NOT NULL");
        } else {
            sb.append(" NULL");
        }

        // 注释
        String comment = field.getFieldLabel() != null ? field.getFieldLabel() : field.getFieldCode();
        sb.append(" COMMENT '").append(comment).append("'");

        return sb.toString();
    }

    /**
     * 映射字段类型到数据库类型
     */
    private String mapFieldTypeToDataType(FieldConfigDO field) {
        // 优先使用配置的数据库类型
        if (field.getDataType() != null && !field.getDataType().trim().isEmpty()) {
            switch (field.getDataType().toLowerCase()) {
                case "varchar":
                    return "VARCHAR(" + (field.getFieldLength() != null ? field.getFieldLength() : 255) + ")";
                case "text":
                    return "TEXT";
                case "int":
                    return "INT";
                case "bigint":
                    return "BIGINT";
                case "decimal":
                    return "DECIMAL(10,2)"; // 固定小数位数
                case "datetime":
                    return "DATETIME";
                case "date":
                    return "DATE";
                case "tinyint":
                    return "TINYINT";
            }
        }

        // 备用：根据字段类型映射
        switch (field.getFieldType()) {
            case "input":
                return "VARCHAR(" + (field.getFieldLength() != null ? field.getFieldLength() : 255) + ")";
            case "textarea":
                return "TEXT";
            case "number":
                return "INT";
            case "decimal":
                return "DECIMAL(10,2)"; // 固定小数位数
            case "select":
            case "checkbox":
                return "VARCHAR(100)";
            case "date":
                return "DATE";
            case "datetime":
                return "DATETIME";
            case "boolean":
                return "TINYINT";
            default:
                return "VARCHAR(255)";
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

    private void createNewTable(String tableName, List<FieldConfigDO> fields) {
        StringBuilder createSql = new StringBuilder("CREATE TABLE " + tableName + " (");

        // 添加系统字段
        createSql.append(SYSTEM_FIELDS_SQL);

        // 添加业务字段
        for (FieldConfigDO field : fields) {
            createSql.append(", ").append(buildColumnSql(field));
        }

        createSql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='动态表';");

        log.info("创建动态表 SQL：{}", createSql);
        jdbcTemplate.execute(createSql.toString());
        log.info("✅ 创建动态表：{}", tableName);
    }

    private void syncExistingTable(String tableName, List<FieldConfigDO> fields) {
        // 获取现有列
        List<String> dbColumns = getTableColumns(tableName);

        // 确保系统字段存在
        ensureSystemColumns(tableName, dbColumns);

        // 配置中字段
        Set<String> configFields = fields.stream()
                .map(FieldConfigDO::getFieldCode)
                .collect(Collectors.toSet());

        // 1️⃣ 添加新字段
        for (FieldConfigDO field : fields) {
            if (!dbColumns.contains(field.getFieldCode())) {
                String sql = "ALTER TABLE " + tableName + " ADD COLUMN " + buildColumnSql(field);
                jdbcTemplate.execute(sql);
                log.info("🟢 添加新字段 [{}] 到表 [{}]", field.getFieldCode(), tableName);
            }
        }

        // 2️⃣ 删除多余字段（除系统字段外）
        for (String dbCol : dbColumns) {
            if (!SYSTEM_COLUMNS.contains(dbCol) && !configFields.contains(dbCol)) {
                String sql = "ALTER TABLE " + tableName + " DROP COLUMN " + dbCol;
                jdbcTemplate.execute(sql);
                log.info("🔴 删除多余字段 [{}] 从表 [{}]", dbCol, tableName);
            }
        }
    }

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


    private List<String> getTableColumns(String tableName) {
        String sql = "SELECT column_name FROM information_schema.columns WHERE table_name = ?";
        return jdbcTemplate.queryForList(sql, String.class, tableName);
    }
}
