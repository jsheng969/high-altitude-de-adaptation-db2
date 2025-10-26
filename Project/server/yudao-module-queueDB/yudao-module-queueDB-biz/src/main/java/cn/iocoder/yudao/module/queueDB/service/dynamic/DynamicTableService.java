package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.hutool.db.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.ExcelImportReqDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelImportResultVO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ImportHistoryVO;

import javax.servlet.http.HttpServletResponse;

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

    /**
     * 导入Excel文件创建模块和字段配置
     */
    ExcelImportResultVO importExcel(ExcelImportReqDTO importReq);

    /**
     * 下载导入模板
     */
    void downloadTemplate(HttpServletResponse response, String templateType);

    /**
     * 检查模块编码是否已存在
     */
    boolean checkModuleExists(String moduleCode);

    /**
     * 获取导入历史
     */
    PageResult<ImportHistoryVO> getImportHistory(Integer pageNo, Integer pageSize);

    /**
     * 删除模块及相关数据
     */
    CommonResult<String> deleteModule(String moduleCode);
}
