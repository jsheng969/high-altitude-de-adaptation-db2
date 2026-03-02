package cn.iocoder.yudao.module.queueDB.service.moduleconfig;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 动态模块配置表（支持三级结构） Service 接口
 *
 * @author 芋道源码
 */
public interface ModuleConfigService {

    /**
     * 创建动态模块配置表（支持三级结构）
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createModuleConfig(@Valid ModuleConfigSaveReqVO createReqVO);

    /**
     * 更新动态模块配置表（支持三级结构）
     *
     * @param updateReqVO 更新信息
     */
    void updateModuleConfig(@Valid ModuleConfigSaveReqVO updateReqVO);

    /**
     * 删除动态模块配置表（支持三级结构）
     *
     * @param id 编号
     */
    void deleteModuleConfig(Long id);

    /**
     * 获得动态模块配置表（支持三级结构）
     *
     * @param id 编号
     * @return 动态模块配置表（支持三级结构）
     */
    ModuleConfigDO getModuleConfig(Long id);

    /**
     * 获得模块配置详情（包含字段列表）
     */
    ModuleConfigDetailVO getModuleConfigDetail(Long id);
    /**
     * 获得动态模块配置表（支持三级结构）分页
     *
     * @param pageReqVO 分页查询
     * @return 动态模块配置表（支持三级结构）分页
     */
    PageResult<ModuleConfigDO> getModuleConfigPage(ModuleConfigPageReqVO pageReqVO);

    List<ModuleConfigDO> getModuleTree();

    /**
     * 获取模块树（包含字段统计）
     */
    List<ModuleConfigTreeVO> getModuleTreeWithStats();

    /**
     * 检查模块代码是否可用
     */
    boolean checkModuleCodeAvailable(String moduleCode);

    public List<ModuleWithFieldsRespVO> getModulesWithFields();

    /**
     * 获取模块树（包含字段）
     */
    List<ModuleConfigRespVO> getModuleTreeWithFields();

    List<ModuleConfigRespVO> getModuleTreeWithFields(String moduleCode);

    /**
     * 获取基础信息模块（一级模块）
     */
    List<ModuleConfigDO> getBaseModules();

    /**
     * 根据模块编码获取模块详情（包含子模块和字段）
     */
    ModuleConfigRespVO getModuleDetailByCode(String moduleCode);
}