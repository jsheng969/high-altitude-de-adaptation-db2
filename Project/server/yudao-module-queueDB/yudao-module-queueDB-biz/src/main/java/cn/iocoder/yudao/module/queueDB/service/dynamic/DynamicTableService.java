package cn.iocoder.yudao.module.queueDB.service.dynamic;

/**
 * 动态表建表/同步服务（骨架）
 * 该服务负责：
 *  - 根据 moduleConfig + field_config 生成建表/alter table SQL
 *  - 建表前进行安全性校验（表名、列名白名单）
 *  - 更新 table_registry 记录结构 hash 等
 */
public interface DynamicTableService {
    /**
     * 根据模块编码创建或更新表结构
     * @param moduleCode 模块编码
     */
    void createOrUpdateTable(String moduleCode);

    /**
     * 删除模块对应的表
     * @param moduleCode 模块编码
     */
    void dropTable(String moduleCode);

    /**
     * 同步所有模块对应的表结构（自动创建或更新）
     */
    void syncAllTables();

    /**
     * 同步指定模块对应的表结构（自动创建或更新）
     * @param moduleCode 模块编码
     */
    void syncTable(String moduleCode);
}
