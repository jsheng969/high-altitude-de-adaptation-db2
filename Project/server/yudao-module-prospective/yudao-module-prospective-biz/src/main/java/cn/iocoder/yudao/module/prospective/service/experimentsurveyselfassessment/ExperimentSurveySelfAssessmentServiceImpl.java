package cn.iocoder.yudao.module.prospective.service.experimentsurveyselfassessment;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyselfassessment.ProspectiveExperimentSurveySelfAssessmentMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyselfassessment.ProspectiveExperimentSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 自我评价 Service 实现类
 *
 * @author 管理员
 */
@Service("prospectiveExperimentSurveySelfAssessmentServiceImpl")
@Validated
public class ExperimentSurveySelfAssessmentServiceImpl implements ExperimentSurveySelfAssessmentService {

    @Resource
    private ProspectiveExperimentSurveySelfAssessmentMapper prospectiveExperimentSurveySelfAssessmentMapper;

    @Override
    public Long createExperimentSurveySelfAssessment(ExperimentSurveySelfAssessmentSaveReqVO createReqVO) {
        // 插入
        ProspectiveExperimentSurveySelfAssessmentDO experimentSurveySelfAssessment = BeanUtils.toBean(createReqVO, ProspectiveExperimentSurveySelfAssessmentDO.class);
        prospectiveExperimentSurveySelfAssessmentMapper.insert(experimentSurveySelfAssessment);
        // 返回
        return experimentSurveySelfAssessment.getId();
    }

    @Override
    public void updateExperimentSurveySelfAssessment(ExperimentSurveySelfAssessmentSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveySelfAssessmentExists(updateReqVO.getId());
        // 更新
        ProspectiveExperimentSurveySelfAssessmentDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveExperimentSurveySelfAssessmentDO.class);
        prospectiveExperimentSurveySelfAssessmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveySelfAssessment(Long id) {
        // 校验存在
        validateExperimentSurveySelfAssessmentExists(id);
        // 删除
        prospectiveExperimentSurveySelfAssessmentMapper.deleteById(id);
    }

    private void validateExperimentSurveySelfAssessmentExists(Long id) {
        if (prospectiveExperimentSurveySelfAssessmentMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_SELF_ASSESSMENT_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveExperimentSurveySelfAssessmentDO getExperimentSurveySelfAssessment(Long id) {
        return prospectiveExperimentSurveySelfAssessmentMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveExperimentSurveySelfAssessmentDO> getExperimentSurveySelfAssessmentPage(ExperimentSurveySelfAssessmentPageReqVO pageReqVO) {
        return prospectiveExperimentSurveySelfAssessmentMapper.selectPage(pageReqVO);
    }

}