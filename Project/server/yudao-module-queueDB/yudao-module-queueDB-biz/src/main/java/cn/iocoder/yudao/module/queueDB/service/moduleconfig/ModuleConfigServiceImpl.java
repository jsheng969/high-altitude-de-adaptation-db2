package cn.iocoder.yudao.module.queueDB.service.moduleconfig;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig.ModuleConfigMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 动态模块配置表（支持三级结构） Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ModuleConfigServiceImpl implements ModuleConfigService {

    @Resource
    private ModuleConfigMapper moduleConfigMapper;

    @Override
    public Long createModuleConfig(ModuleConfigSaveReqVO createReqVO) {
        // 插入
        ModuleConfigDO moduleConfig = BeanUtils.toBean(createReqVO, ModuleConfigDO.class);
        moduleConfigMapper.insert(moduleConfig);
        // 返回
        return moduleConfig.getId();
    }

    @Override
    public void updateModuleConfig(ModuleConfigSaveReqVO updateReqVO) {
        // 校验存在
        validateModuleConfigExists(updateReqVO.getId());
        // 更新
        ModuleConfigDO updateObj = BeanUtils.toBean(updateReqVO, ModuleConfigDO.class);
        moduleConfigMapper.updateById(updateObj);
    }

    @Override
    public void deleteModuleConfig(Long id) {
        // 校验存在
        validateModuleConfigExists(id);
        // 删除
        moduleConfigMapper.deleteById(id);
    }

    private void validateModuleConfigExists(Long id) {
        if (moduleConfigMapper.selectById(id) == null) {
//            throw exception(MODULE_CONFIG_NOT_EXISTS);
        }
    }

    @Override
    public ModuleConfigDO getModuleConfig(Long id) {
        return moduleConfigMapper.selectById(id);
    }

    @Override
    public PageResult<ModuleConfigDO> getModuleConfigPage(ModuleConfigPageReqVO pageReqVO) {
        return moduleConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ModuleConfigDO> getChildren(String parentCode) {
        return moduleConfigMapper.selectByParentCode(parentCode);
    }

    @Override
    public List<ModuleConfigDO> getModuleTree() {
        List<ModuleConfigDO> all = moduleConfigMapper.selectAll();
        Map<Long, List<ModuleConfigDO>> grouped = all.stream()
                .filter(m -> m.getParentId() != null)
                .collect(Collectors.groupingBy(ModuleConfigDO::getParentId));

        // 组装树结构（仅供前端展示）
        List<ModuleConfigDO> roots = all.stream()
                .filter(m -> m.getParentId() == null)
                .sorted(Comparator.comparing(ModuleConfigDO::getOrderNo))
                .collect(Collectors.toList());

        buildTree(roots, grouped);
        return roots;
    }

    private void buildTree(List<ModuleConfigDO> nodes, Map<Long, List<ModuleConfigDO>> grouped) {
        for (ModuleConfigDO node : nodes) {
            List<ModuleConfigDO> children = grouped.get(node.getModuleCode());
            if (children != null && !children.isEmpty()) {
                buildTree(children, grouped);
            }
        }
    }

}