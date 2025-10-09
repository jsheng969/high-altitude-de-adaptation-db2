package cn.iocoder.yudao.module.queueDB.service.fieldconfig;

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

    @Autowired
    private DynamicTableService dynamicTableService;

    @Override
    public Long createFieldConfig(FieldConfigSaveReqVO createReqVO) {
        // 插入
        FieldConfigDO fieldConfig = BeanUtils.toBean(createReqVO, FieldConfigDO.class);
        fieldConfigMapper.insert(fieldConfig);
        // 同步建表（可在单独场景触发）；这里触发一次同步，安全起见可以延后到管理员点击“同步建表”动作
        dynamicTableService.syncTable(fieldConfig.getModuleCode());
        // 返回
        return fieldConfig.getId();
    }

    @Override
    public void updateFieldConfig(FieldConfigSaveReqVO updateReqVO) {
        // 校验存在
        validateFieldConfigExists(updateReqVO.getId());
        // 更新
        FieldConfigDO updateObj = BeanUtils.toBean(updateReqVO, FieldConfigDO.class);
        fieldConfigMapper.updateById(updateObj);
        // 同步建表
        dynamicTableService.syncTable(updateObj.getModuleCode());
    }

    @Override
    public void deleteFieldConfig(Long id) {
        // 校验存在
        validateFieldConfigExists(id);
        // 删除
        fieldConfigMapper.deleteById(id);
    }

    private void validateFieldConfigExists(Long id) {
        if (fieldConfigMapper.selectById(id) == null) {
//            throw exception(FIELD_CONFIG_NOT_EXISTS);
        }
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
        List<FieldConfigDO> dos = fieldConfigMapper.selectByModuleCode(moduleCode);
        return dos;
    }
}