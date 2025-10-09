package cn.iocoder.yudao.module.review.service.controlsurveyselfassessment;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyselfassessment.ControlSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlsurveyselfassessment.ControlSurveySelfAssessmentMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-自我评价 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlSurveySelfAssessmentServiceImpl implements ControlSurveySelfAssessmentService {

    @Resource
    private ControlSurveySelfAssessmentMapper controlSurveySelfAssessmentMapper;

    @Override
    public Long createControlSurveySelfAssessment(ControlSurveySelfAssessmentSaveReqVO createReqVO) {
        // 插入
        ControlSurveySelfAssessmentDO controlSurveySelfAssessment = BeanUtils.toBean(createReqVO, ControlSurveySelfAssessmentDO.class);
        controlSurveySelfAssessmentMapper.insert(controlSurveySelfAssessment);
        // 返回
        return controlSurveySelfAssessment.getId();
    }

    @Override
    public void updateControlSurveySelfAssessment(ControlSurveySelfAssessmentSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveySelfAssessmentExists(updateReqVO.getId());
        // 更新
        ControlSurveySelfAssessmentDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveySelfAssessmentDO.class);
        controlSurveySelfAssessmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveySelfAssessment(Long id) {
        // 校验存在
        validateControlSurveySelfAssessmentExists(id);
        // 删除
        controlSurveySelfAssessmentMapper.deleteById(id);
    }

    private void validateControlSurveySelfAssessmentExists(Long id) {
        if (controlSurveySelfAssessmentMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_SELF_ASSESSMENT_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveySelfAssessmentDO getControlSurveySelfAssessment(Long id) {
        return controlSurveySelfAssessmentMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveySelfAssessmentDO> getControlSurveySelfAssessmentPage(ControlSurveySelfAssessmentPageReqVO pageReqVO) {
        return controlSurveySelfAssessmentMapper.selectPage(pageReqVO);
    }

}