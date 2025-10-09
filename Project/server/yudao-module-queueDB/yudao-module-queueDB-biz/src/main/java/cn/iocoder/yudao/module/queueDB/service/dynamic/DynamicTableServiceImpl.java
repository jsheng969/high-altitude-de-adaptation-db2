package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
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
            StringBuilder createSql = new StringBuilder("CREATE TABLE " + tableName + " (");
            createSql.append("id BIGINT PRIMARY KEY AUTO_INCREMENT,");

            for (FieldConfigDO field : fields) {
                createSql.append(buildColumnSql(field)).append(",");
            }
            createSql.append("create_time DATETIME DEFAULT CURRENT_TIMESTAMP,");
            createSql.append("update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP");
            createSql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");

            log.info("创建动态表 SQL：{}", createSql);
            jdbcTemplate.execute(createSql.toString());
        } else {
            for (FieldConfigDO field : fields) {
                if (!columnExists(tableName, field.getFieldName())) {
                    String alterSql = "ALTER TABLE " + tableName + " ADD COLUMN " + buildColumnSql(field) + ";";
                    log.info("添加新字段 SQL：{}", alterSql);
                    jdbcTemplate.execute(alterSql);
                }
            }
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
        sb.append(field.getFieldName()).append(" ");

        // 映射字段类型
        switch (field.getFieldType()) {
            case "input":
                sb.append("VARCHAR(").append(field.getFieldLength() != null ? field.getFieldLength() : 255).append(")");
                break;
            case "textarea":
                sb.append("TEXT");
                break;
            case "number":
                sb.append("INT");
                break;
            case "decimal":
                sb.append("DECIMAL(10,2)");
                break;
            case "select":
                sb.append("VARCHAR(100)");
                break;
            case "date":
                sb.append("DATE");
                break;
            default:
                sb.append("VARCHAR(255)");
                break;
        }

        if (Boolean.TRUE.equals(field.getIsRequired())) {
            sb.append(" NOT NULL");
        } else {
            sb.append(" NULL");
        }

        return sb.toString();
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
        createSql.append("id BIGINT PRIMARY KEY AUTO_INCREMENT,");

        for (FieldConfigDO field : fields) {
            createSql.append(buildColumnSql(field)).append(",");
        }

        createSql.append("create_time DATETIME DEFAULT CURRENT_TIMESTAMP,");
        createSql.append("update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP");
        createSql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");

        jdbcTemplate.execute(createSql.toString());
        log.info("✅ 创建动态表：{}", tableName);
    }

    private void syncExistingTable(String tableName, List<FieldConfigDO> fields) {
        // 获取现有列
        List<String> dbColumns = getTableColumns(tableName);

        // 配置中字段
        Set<String> configFields = fields.stream()
                .map(FieldConfigDO::getFieldName)
                .collect(Collectors.toSet());

        // 1️⃣ 添加新字段
        for (FieldConfigDO field : fields) {
            if (!dbColumns.contains(field.getFieldName())) {
                String sql = "ALTER TABLE " + tableName + " ADD COLUMN " + buildColumnSql(field);
                jdbcTemplate.execute(sql);
                log.info("🟢 添加新字段 [{}] 到表 [{}]", field.getFieldName(), tableName);
            }
        }

        // 2️⃣ 删除多余字段（除系统列）
        List<String> systemCols = Arrays.asList("id", "create_time", "update_time");
        for (String dbCol : dbColumns) {
            if (!systemCols.contains(dbCol) && !configFields.contains(dbCol)) {
                String sql = "ALTER TABLE " + tableName + " DROP COLUMN " + dbCol;
                jdbcTemplate.execute(sql);
                log.info("🔴 删除多余字段 [{}] 从表 [{}]", dbCol, tableName);
            }
        }
    }


    private List<String> getTableColumns(String tableName) {
        String sql = "SELECT column_name FROM information_schema.columns WHERE table_name = ?";
        return jdbcTemplate.queryForList(sql, String.class, tableName);
    }
}
