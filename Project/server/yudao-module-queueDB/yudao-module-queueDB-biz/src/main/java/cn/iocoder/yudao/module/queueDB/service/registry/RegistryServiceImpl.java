package cn.iocoder.yudao.module.queueDB.service.registry;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.registry.RegistryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.queueDB.dal.mysql.registry.RegistryMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.queueDB.enums.ErrorCodeConstants.*;

/**
 * 动态表注册 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class RegistryServiceImpl implements RegistryService {

    @Resource
    private RegistryMapper registryMapper;

    @Override
    public Long createRegistry(RegistrySaveReqVO createReqVO) {
        // 插入
        RegistryDO registry = BeanUtils.toBean(createReqVO, RegistryDO.class);
        registryMapper.insert(registry);
        // 返回
        return registry.getId();
    }

    @Override
    public void updateRegistry(RegistrySaveReqVO updateReqVO) {
        // 校验存在
        validateRegistryExists(updateReqVO.getId());
        // 更新
        RegistryDO updateObj = BeanUtils.toBean(updateReqVO, RegistryDO.class);
        registryMapper.updateById(updateObj);
    }

    @Override
    public void deleteRegistry(Long id) {
        // 校验存在
        validateRegistryExists(id);
        // 删除
        registryMapper.deleteById(id);
    }

    private void validateRegistryExists(Long id) {
        if (registryMapper.selectById(id) == null) {
            throw exception(REGISTRY_NOT_EXISTS);
        }
    }

    @Override
    public RegistryDO getRegistry(Long id) {
        return registryMapper.selectById(id);
    }

    @Override
    public PageResult<RegistryDO> getRegistryPage(RegistryPageReqVO pageReqVO) {
        return registryMapper.selectPage(pageReqVO);
    }

    @Override
    public void registerTable(String tableName, String moduleCode, String nodeType, int fieldCount, String description) {
        RegistryDO exist = registryMapper.selectByTableName(tableName);
        if (exist != null) {
            exist.setStatus(1);
            exist.setUpdateTime(LocalDateTime.now());
            registryMapper.updateById(exist);
        } else {
            RegistryDO registry = new RegistryDO();
            registry.setTableName(tableName);
            registry.setModuleCode(moduleCode);
            registry.setNodeType(nodeType);
            registry.setFieldCount(fieldCount);
            registry.setDescription(description);
            registry.setStatus(1);
            registry.setCreateTime(LocalDateTime.now());
            registry.setUpdateTime(LocalDateTime.now());
            registryMapper.insert(registry);
        }
    }

    @Override
    public void markDeleted(String tableName) {
        RegistryDO exist = registryMapper.selectByTableName(tableName);
        if (exist != null) {
            exist.setStatus(2);
            exist.setUpdateTime(LocalDateTime.now());
            registryMapper.updateById(exist);
        }
    }

    @Override
    public List<RegistryDO> listAll() {
        return registryMapper.selectList(null);
    }

}