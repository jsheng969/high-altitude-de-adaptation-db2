package cn.iocoder.yudao.module.queueDB.service.registry;

import java.util.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.registry.RegistryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 动态表注册 Service 接口
 *
 * @author 管理员
 */
public interface RegistryService {

    /**
     * 创建动态表注册
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRegistry(@Valid RegistrySaveReqVO createReqVO);

    /**
     * 更新动态表注册
     *
     * @param updateReqVO 更新信息
     */
    void updateRegistry(@Valid RegistrySaveReqVO updateReqVO);

    /**
     * 删除动态表注册
     *
     * @param id 编号
     */
    void deleteRegistry(Long id);

    /**
     * 获得动态表注册
     *
     * @param id 编号
     * @return 动态表注册
     */
    RegistryDO getRegistry(Long id);

    /**
     * 获得动态表注册分页
     *
     * @param pageReqVO 分页查询
     * @return 动态表注册分页
     */
    PageResult<RegistryDO> getRegistryPage(RegistryPageReqVO pageReqVO);

    void registerTable(String tableName, String moduleCode, String nodeType, int fieldCount, String description);
    void markDeleted(String tableName);
    List<RegistryDO> listAll();
}