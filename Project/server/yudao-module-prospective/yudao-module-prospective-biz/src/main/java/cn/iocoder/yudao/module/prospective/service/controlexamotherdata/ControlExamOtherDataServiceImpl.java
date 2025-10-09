package cn.iocoder.yudao.module.prospective.service.controlexamotherdata;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamotherdata.ControlExamOtherDataDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlexamotherdata.ControlExamOtherDataMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-其他数据 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlExamOtherDataServiceImpl implements ControlExamOtherDataService {

    @Resource
    private ControlExamOtherDataMapper controlExamOtherDataMapper;

    @Override
    public Long createControlExamOtherData(ControlExamOtherDataSaveReqVO createReqVO) {
        // 插入
        ControlExamOtherDataDO controlExamOtherData = BeanUtils.toBean(createReqVO, ControlExamOtherDataDO.class);
        controlExamOtherDataMapper.insert(controlExamOtherData);
        // 返回
        return controlExamOtherData.getId();
    }

    @Override
    public void updateControlExamOtherData(ControlExamOtherDataSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamOtherDataExists(updateReqVO.getId());
        // 更新
        ControlExamOtherDataDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamOtherDataDO.class);
        controlExamOtherDataMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamOtherData(Long id) {
        // 校验存在
        validateControlExamOtherDataExists(id);
        // 删除
        controlExamOtherDataMapper.deleteById(id);
    }

    private void validateControlExamOtherDataExists(Long id) {
        if (controlExamOtherDataMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_OTHER_DATA_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamOtherDataDO getControlExamOtherData(Long id) {
        return controlExamOtherDataMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamOtherDataDO> getControlExamOtherDataPage(ControlExamOtherDataPageReqVO pageReqVO) {
        return controlExamOtherDataMapper.selectPage(pageReqVO);
    }

}