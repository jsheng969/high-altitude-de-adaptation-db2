package cn.iocoder.yudao.module.queueDB.service.moduleconfig;

import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.FieldConfigRespVO;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import static cn.iocoder.yudao.module.queueDB.enums.ErrorCodeConstants.*;

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

    @Resource
    private FieldConfigMapper fieldConfigMapper;

    @Resource
    private DynamicTableService dynamicTableService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createModuleConfig(ModuleConfigSaveReqVO createReqVO) {
        // 验证模块代码唯一性
        validateModuleCodeUnique(createReqVO.getModuleCode());

        // 验证父模块是否存在
        if (createReqVO.getParentId() != null) {
            validateParentModuleExists(createReqVO.getParentId());
        }

        // 插入模块
        ModuleConfigDO moduleConfig = BeanUtils.toBean(createReqVO, ModuleConfigDO.class);
        moduleConfigMapper.insert(moduleConfig);

        // 如果是叶子节点且指定了表名，创建动态表
        if (moduleConfig.getIsLeaf() == 1 && createReqVO.getTableName() != null) {
            dynamicTableService.createOrUpdateTable(moduleConfig.getModuleCode());
        }

        return moduleConfig.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateModuleConfig(ModuleConfigSaveReqVO updateReqVO) {
        // 验证存在
        validateModuleConfigExists(updateReqVO.getId());

        // 验证模块代码唯一性（排除自身）
        validateModuleCodeUnique(updateReqVO.getId(), updateReqVO.getModuleCode());

        // 验证父模块是否存在
        if (updateReqVO.getParentId() != null) {
            validateParentModuleExists(updateReqVO.getParentId());
            // 防止设置自己为父模块
            if (updateReqVO.getParentId().equals(updateReqVO.getId())) {
                throw exception(MODULE_CONFIG_PARENT_SELF);
            }
        }

        // 更新模块
        ModuleConfigDO updateObj = BeanUtils.toBean(updateReqVO, ModuleConfigDO.class);
        moduleConfigMapper.updateById(updateObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteModuleConfig(Long id) {
        // 验证存在
        validateModuleConfigExists(id);

        ModuleConfigDO module = moduleConfigMapper.selectById(id);

        // 验证是否有子模块
        if (moduleConfigMapper.hasChildren(id)) {
            throw exception(MODULE_CONFIG_HAS_CHILDREN);
        }

        // 验证是否有字段
        if (fieldConfigMapper.countByModuleCode(module.getModuleCode()) > 0) {
            throw exception(MODULE_CONFIG_HAS_FIELDS);
        }

        // 删除模块
        moduleConfigMapper.deleteById(id);
    }

    @Override
    public ModuleConfigDO getModuleConfig(Long id) {
        return moduleConfigMapper.selectById(id);
    }

    @Override
    public ModuleConfigDetailVO getModuleConfigDetail(Long id) {
        ModuleConfigDO module = moduleConfigMapper.selectById(id);
        if (module == null) {
            throw exception(MODULE_CONFIG_NOT_EXISTS);
        }

        ModuleConfigDetailVO detailVO = BeanUtils.toBean(module, ModuleConfigDetailVO.class);

        // 获取模块下的字段列表
        List<FieldConfigDO> fields = fieldConfigMapper.selectByModuleCode(module.getModuleCode());
        detailVO.setFields(BeanUtils.toBean(fields, FieldConfigRespVO.class));

        return detailVO;
    }

    @Override
    public PageResult<ModuleConfigDO> getModuleConfigPage(ModuleConfigPageReqVO pageReqVO) {
        return moduleConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ModuleConfigDO> getModuleTree() {
        List<ModuleConfigDO> allModules = moduleConfigMapper.selectAll();
        Map<Long, List<ModuleConfigDO>> groupedByParent = allModules.stream()
                .filter(m -> m.getParentId() != null)
                .collect(Collectors.groupingBy(ModuleConfigDO::getParentId));

        // 构建树形结构
        List<ModuleConfigDO> roots = allModules.stream()
                .filter(m -> m.getParentId() == null)
                .sorted(Comparator.comparing(ModuleConfigDO::getOrderNo))
                .collect(Collectors.toList());

        return buildModuleTree(roots, groupedByParent);
    }

    @Override
    public List<ModuleConfigTreeVO> getModuleTreeWithStats() {
        List<ModuleConfigDO> allModules = moduleConfigMapper.selectAll();
        Map<Long, List<ModuleConfigDO>> groupedByParent = allModules.stream()
                .filter(m -> m.getParentId() != null)
                .collect(Collectors.groupingBy(ModuleConfigDO::getParentId));

        // 获取每个模块的字段数量
        Map<String, Long> fieldCountMap = fieldConfigMapper.selectFieldCountByModule().stream()
                .collect(Collectors.toMap(
                        map -> (String) map.get("module_code"),
                        map -> (Long) map.get("field_count")
                ));

        // 构建树形结构
        List<ModuleConfigDO> roots = allModules.stream()
                .filter(m -> m.getParentId() == null)
                .sorted(Comparator.comparing(ModuleConfigDO::getOrderNo))
                .collect(Collectors.toList());

        return buildModuleTreeWithStats(roots, groupedByParent, fieldCountMap);
    }

    @Override
    public boolean checkModuleCodeAvailable(String moduleCode) {
        if (moduleCode == null || moduleCode.trim().isEmpty()) {
            return false;
        }

        // 验证格式
        if (!moduleCode.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
            return false;
        }

        // 验证唯一性
        return !moduleConfigMapper.existsByCode(moduleCode);
    }

    // ========== 私有方法 ==========

    private void validateModuleCodeUnique(String moduleCode) {
        if (moduleCode == null || moduleCode.trim().isEmpty()) {
            throw exception(MODULE_CONFIG_CODE_NOT_BLANK);
        }

        if (moduleConfigMapper.existsByCode(moduleCode)) {
            throw exception(MODULE_CONFIG_CODE_EXISTS, moduleCode);
        }
    }

    private void validateModuleCodeUnique(Long id, String moduleCode) {
        if (moduleCode == null || moduleCode.trim().isEmpty()) {
            throw exception(MODULE_CONFIG_CODE_NOT_BLANK);
        }

        ModuleConfigDO existing = moduleConfigMapper.selectByCode(moduleCode);
        if (existing != null && !existing.getId().equals(id)) {
            throw exception(MODULE_CONFIG_CODE_EXISTS, moduleCode);
        }
    }

    private void validateParentModuleExists(Long parentId) {
        if (parentId == null) {
            return;
        }

        ModuleConfigDO parent = moduleConfigMapper.selectById(parentId);
        if (parent == null) {
            throw exception(MODULE_CONFIG_NOT_EXISTS);
        }
    }

    private void validateModuleConfigExists(Long id) {
        if (moduleConfigMapper.selectById(id) == null) {
            throw exception(MODULE_CONFIG_NOT_EXISTS);
        }
    }

    private List<ModuleConfigDO> buildModuleTree(List<ModuleConfigDO> nodes,
                                                 Map<Long, List<ModuleConfigDO>> grouped) {
        List<ModuleConfigDO> result = new ArrayList<>();

        for (ModuleConfigDO node : nodes) {
            ModuleConfigDO treeNode = BeanUtils.toBean(node, ModuleConfigDO.class);

            // 递归构建子节点
            List<ModuleConfigDO> children = grouped.get(node.getId());
            if (children != null && !children.isEmpty()) {
                treeNode.setChildren(buildModuleTree(children, grouped));
            }

            result.add(treeNode);
        }

        return result;
    }

    private List<ModuleConfigTreeVO> buildModuleTreeWithStats(List<ModuleConfigDO> nodes,
                                                              Map<Long, List<ModuleConfigDO>> grouped,
                                                              Map<String, Long> fieldCountMap) {
        List<ModuleConfigTreeVO> collect = nodes.stream().map(node -> {
            ModuleConfigTreeVO treeVO = BeanUtils.toBean(node, ModuleConfigTreeVO.class);

            // 设置字段数量
            treeVO.setFieldCount(fieldCountMap.getOrDefault(node.getModuleCode(), 0L));

            // 递归构建子节点
            List<ModuleConfigDO> children = grouped.get(node.getId());
            if (children != null && !children.isEmpty()) {
                treeVO.setChildren(buildModuleTreeWithStats(children, grouped, fieldCountMap));
            }

            return treeVO;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ModuleWithFieldsRespVO> getModulesWithFields() {
        // 查询所有启用的模块
        List<ModuleConfigDO> modules = moduleConfigMapper.selectList(
                new LambdaQueryWrapper<ModuleConfigDO>().eq(ModuleConfigDO::getStatus, 1)
        );

        // 查询所有启用的字段
        List<FieldConfigDO> fields = fieldConfigMapper.selectList(
                new LambdaQueryWrapper<FieldConfigDO>().eq(FieldConfigDO::getStatus, 1)
        );

        // 按模块分组字段
        Map<String, List<FieldConfigDO>> fieldMap = fields.stream()
                .collect(Collectors.groupingBy(FieldConfigDO::getModuleCode));

        // 封装返回
        return modules.stream().map(module -> {
            ModuleWithFieldsRespVO vo = new ModuleWithFieldsRespVO();
            vo.setId(module.getId());
            vo.setName(module.getModuleName());

            List<FieldWithLabelRespVO> fieldList = fieldMap.getOrDefault(module.getId(), Collections.emptyList())
                    .stream()
                    .map(f -> new FieldWithLabelRespVO(f.getId(), f.getFieldLabel(), f.getFieldName()))
                    .collect(Collectors.toList());
            vo.setFields(fieldList);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ModuleConfigRespVO> getModuleTreeWithFields() {
        // 查询所有启用的模块
        List<ModuleConfigDO> allModules = moduleConfigMapper.selectList(
                new LambdaQueryWrapper<ModuleConfigDO>()
                        .eq(ModuleConfigDO::getStatus, 1)
                        .orderByAsc(ModuleConfigDO::getOrderNo)
        );

        // 查询所有启用的字段
        List<FieldConfigDO> allFields = fieldConfigMapper.selectList(
                new LambdaQueryWrapper<FieldConfigDO>()
                        .eq(FieldConfigDO::getStatus, 1)
                        .orderByAsc(FieldConfigDO::getOrderNo)
        );

        // 按模块编码分组字段
        Map<String, List<FieldConfigDO>> fieldMap = allFields.stream()
                .collect(Collectors.groupingBy(FieldConfigDO::getModuleCode));

        // 按父ID分组模块
        Map<Long, List<ModuleConfigDO>> groupedByParent = allModules.stream()
                .filter(module -> module.getParentId() != null)
                .collect(Collectors.groupingBy(ModuleConfigDO::getParentId));

        // 获取根模块（parent_id为null）
        List<ModuleConfigDO> rootModules = allModules.stream()
                .filter(module -> module.getParentId() == null)
                .sorted(Comparator.comparing(ModuleConfigDO::getOrderNo))
                .collect(Collectors.toList());

        // 构建包含字段的模块树
        return buildModuleTreeWithFields(rootModules, groupedByParent, fieldMap);
    }

    @Override
    public List<ModuleConfigDO> getBaseModules() {
        // 查询所有一级模块（parent_id为null）且启用的
        return moduleConfigMapper.selectList(
                new LambdaQueryWrapper<ModuleConfigDO>()
                        .isNull(ModuleConfigDO::getParentId)
                        .eq(ModuleConfigDO::getStatus, 1)
                        .orderByAsc(ModuleConfigDO::getOrderNo)
        );
    }

    /**
     * 构建包含字段的模块树
     */
    private List<ModuleConfigRespVO> buildModuleTreeWithFields(List<ModuleConfigDO> nodes,
                                                               Map<Long, List<ModuleConfigDO>> groupedByParent,
                                                               Map<String, List<FieldConfigDO>> fieldMap) {
        List<ModuleConfigRespVO> result = new ArrayList<>();

        for (ModuleConfigDO node : nodes) {
            ModuleConfigRespVO treeNode = BeanUtils.toBean(node, ModuleConfigRespVO.class);

            // 设置字段
            List<FieldConfigDO> fields = fieldMap.get(node.getModuleCode());
            if (fields != null && !fields.isEmpty()) {
                List<FieldConfigRespVO> fieldVOs = BeanUtils.toBean(fields, FieldConfigRespVO.class);
                treeNode.setFields(fieldVOs);
            }

            // 递归构建子节点
            List<ModuleConfigDO> children = groupedByParent.get(node.getId());
            if (children != null && !children.isEmpty()) {
                List<ModuleConfigRespVO> childNodes = buildModuleTreeWithFields(children, groupedByParent, fieldMap);
                treeNode.setChildren(childNodes);
            }

            result.add(treeNode);
        }

        return result;
    }

    @Override
    public ModuleConfigRespVO getModuleDetailByCode(String moduleCode) {
        // 查询模块基本信息
        ModuleConfigDO module = moduleConfigMapper.selectByCode(moduleCode);
        if (module == null) {
            throw exception(MODULE_CONFIG_NOT_EXISTS);
        }

        ModuleConfigRespVO result = BeanUtils.toBean(module, ModuleConfigRespVO.class);

        // 查询模块字段
        List<FieldConfigDO> fields = fieldConfigMapper.selectByModuleCode(moduleCode);
        if (fields != null && !fields.isEmpty()) {
            List<FieldConfigRespVO> fieldVOs = BeanUtils.toBean(fields, FieldConfigRespVO.class);
            result.setFields(fieldVOs);
        }

        // 查询子模块
        List<ModuleConfigDO> children = moduleConfigMapper.selectByParentId(module.getId());
        if (children != null && !children.isEmpty()) {
            List<ModuleConfigRespVO> childVOs = BeanUtils.toBean(children, ModuleConfigRespVO.class);
            result.setChildren(childVOs);
        }

        return result;
    }
}