package cn.iocoder.yudao.module.queueDB.service.fieldconfig;

import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig.ModuleConfigMapper;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig.FieldConfigMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.queueDB.enums.ErrorCodeConstants.*;


/**
 * 动态字段配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class FieldConfigServiceImpl implements FieldConfigService {

    @Resource
    private FieldConfigMapper fieldConfigMapper;

    @Resource
    private ModuleConfigMapper moduleConfigMapper;

    @Resource
    private DynamicTableService dynamicTableService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createFieldConfig(FieldConfigSaveReqVO createReqVO) {
        // 验证模块存在
        validateModuleExists(createReqVO.getModuleCode());

        // 验证字段代码在模块内唯一
        validateFieldCodeUnique(createReqVO.getModuleCode(), createReqVO.getFieldCode());

        // 插入字段
        FieldConfigDO fieldConfig = BeanUtils.toBean(createReqVO, FieldConfigDO.class);
        fieldConfigMapper.insert(fieldConfig);

        // 同步表结构
        dynamicTableService.syncTable(fieldConfig.getModuleCode());

        return fieldConfig.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFieldConfig(FieldConfigSaveReqVO updateReqVO) {
        // 校验存在
        validateFieldConfigExists(updateReqVO.getId());

        // 更新
        FieldConfigDO updateObj = BeanUtils.toBean(updateReqVO, FieldConfigDO.class);
        fieldConfigMapper.updateById(updateObj);

        // 同步表结构
        dynamicTableService.syncTable(updateObj.getModuleCode());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFieldConfig(Long id) {
        // 校验存在
        validateFieldConfigExists(id);

        FieldConfigDO fieldConfig = fieldConfigMapper.selectById(id);

        // 删除
        fieldConfigMapper.deleteById(id);

        // 同步表结构
        dynamicTableService.syncTable(fieldConfig.getModuleCode());
    }

    @Override
    public FieldConfigDO getFieldConfig(Long id) {
        return fieldConfigMapper.selectById(id);
    }

    @Override
    public PageResult<FieldConfigDO> getFieldConfigPage(FieldConfigPageReqVO pageReqVO) {
        return fieldConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public List<FieldConfigDO> listByModuleCode(String moduleCode) {
        return fieldConfigMapper.selectByModuleCode(moduleCode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchCreateFieldConfig(List<FieldConfigSaveReqVO> createReqVOs) {
        if (createReqVOs.isEmpty()) {
            return;
        }

        String moduleCode = createReqVOs.get(0).getModuleCode();

        for (FieldConfigSaveReqVO reqVO : createReqVOs) {
            createFieldConfig(reqVO);
        }

        // 批量操作后一次性同步表结构
        dynamicTableService.syncTable(moduleCode);
    }

    @Override
    public List<FieldTypeOptionVO> getFieldTypeOptions() {
        List<FieldTypeOptionVO> options = new ArrayList<>();

        options.add(new FieldTypeOptionVO("input", "单行文本", "VARCHAR(255)"));
        options.add(new FieldTypeOptionVO("textarea", "多行文本", "TEXT"));
        options.add(new FieldTypeOptionVO("number", "数字", "INT"));
        options.add(new FieldTypeOptionVO("decimal", "小数", "DECIMAL(10,2)"));
        options.add(new FieldTypeOptionVO("select", "下拉选择", "VARCHAR(100)"));
        options.add(new FieldTypeOptionVO("checkbox", "多选框", "VARCHAR(500)"));
        options.add(new FieldTypeOptionVO("date", "日期", "DATE"));
        options.add(new FieldTypeOptionVO("datetime", "日期时间", "DATETIME"));
        options.add(new FieldTypeOptionVO("boolean", "布尔值", "TINYINT"));

        return options;
    }

    @Override
    public boolean checkFieldCodeAvailable(String moduleCode, String fieldCode) {
        if (moduleCode == null || fieldCode == null) {
            return false;
        }

        // 验证格式
        if (!fieldCode.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
            return false;
        }

        // 验证唯一性
        return !fieldConfigMapper.existsByModuleAndFieldCode(moduleCode, fieldCode);
    }

    // ========== 私有方法 ==========

    private void validateFieldConfigExists(Long id) {
        if (fieldConfigMapper.selectById(id) == null) {
            throw exception(FIELD_CONFIG_NOT_EXISTS);
        }
    }

    private void validateFieldCodeUnique(String moduleCode, String fieldCode) {
        if (fieldConfigMapper.existsByModuleAndFieldCode(moduleCode, fieldCode)) {
            throw exception(FIELD_CONFIG_CODE_EXISTS, fieldCode);
        }
    }

    private void validateModuleExists(String moduleCode) {
        ModuleConfigDO module = moduleConfigMapper.selectByCode(moduleCode);
        if (module == null) {
            throw exception(FIELD_CONFIG_MODULE_NOT_EXISTS);
        }
    }
}