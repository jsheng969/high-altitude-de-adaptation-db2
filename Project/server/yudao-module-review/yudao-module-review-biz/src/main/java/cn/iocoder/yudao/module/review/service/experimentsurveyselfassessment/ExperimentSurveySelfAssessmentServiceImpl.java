package cn.iocoder.yudao.module.review.service.experimentsurveyselfassessment;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-自我评价 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveySelfAssessmentServiceImpl implements ExperimentSurveySelfAssessmentService {

    @Resource
    private ExperimentSurveySelfAssessmentMapper experimentSurveySelfAssessmentMapper;

    @Override
    public Long createExperimentSurveySelfAssessment(ExperimentSurveySelfAssessmentSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveySelfAssessmentDO experimentSurveySelfAssessment = BeanUtils.toBean(createReqVO, ExperimentSurveySelfAssessmentDO.class);
        experimentSurveySelfAssessmentMapper.insert(experimentSurveySelfAssessment);
        // 返回
        return experimentSurveySelfAssessment.getId();
    }

    @Override
    public void updateExperimentSurveySelfAssessment(ExperimentSurveySelfAssessmentSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveySelfAssessmentExists(updateReqVO.getId());
        // 更新
        ExperimentSurveySelfAssessmentDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySelfAssessmentDO.class);
        experimentSurveySelfAssessmentMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveySelfAssessmentByPersonId(ExperimentSurveySelfAssessmentSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveySelfAssessmentDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveySelfAssessmentDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveySelfAssessmentDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySelfAssessmentDO.class);
        experimentSurveySelfAssessmentMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveySelfAssessment(Long id) {
        // 校验存在
        validateExperimentSurveySelfAssessmentExists(id);
        // 删除
        experimentSurveySelfAssessmentMapper.deleteById(id);
    }

    private void validateExperimentSurveySelfAssessmentExists(Long id) {
        if (experimentSurveySelfAssessmentMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_SELF_ASSESSMENT_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveySelfAssessmentDO getExperimentSurveySelfAssessment(Long id) {
        return experimentSurveySelfAssessmentMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveySelfAssessmentDO> getExperimentSurveySelfAssessmentPage(ExperimentSurveySelfAssessmentPageReqVO pageReqVO) {
        return experimentSurveySelfAssessmentMapper.selectPage(pageReqVO);
    }

}