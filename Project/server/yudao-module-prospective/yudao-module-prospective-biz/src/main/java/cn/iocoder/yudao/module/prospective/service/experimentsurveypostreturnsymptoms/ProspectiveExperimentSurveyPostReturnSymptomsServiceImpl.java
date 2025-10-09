package cn.iocoder.yudao.module.prospective.service.experimentsurveypostreturnsymptoms;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveypostreturnsymptoms.ProspectiveExperimentSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveypostreturnsymptoms.ProspectiveExperimentSurveyPostReturnSymptomsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-退役后返回平原1月内症状 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ProspectiveExperimentSurveyPostReturnSymptomsServiceImpl implements ProspectiveExperimentSurveyPostReturnSymptomsService {

    @Resource
    private ProspectiveExperimentSurveyPostReturnSymptomsMapper prospectiveExperimentSurveyPostReturnSymptomsMapper;

    @Override
    public Long createExperimentSurveyPostReturnSymptoms(ExperimentSurveyPostReturnSymptomsSaveReqVO createReqVO) {
        // 插入
        ProspectiveExperimentSurveyPostReturnSymptomsDO experimentSurveyPostReturnSymptoms = BeanUtils.toBean(createReqVO, ProspectiveExperimentSurveyPostReturnSymptomsDO.class);
        prospectiveExperimentSurveyPostReturnSymptomsMapper.insert(experimentSurveyPostReturnSymptoms);
        // 返回
        return experimentSurveyPostReturnSymptoms.getId();
    }

    @Override
    public void updateExperimentSurveyPostReturnSymptoms(ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyPostReturnSymptomsExists(updateReqVO.getId());
        // 更新
        ProspectiveExperimentSurveyPostReturnSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveExperimentSurveyPostReturnSymptomsDO.class);
        prospectiveExperimentSurveyPostReturnSymptomsMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyPostReturnSymptoms(Long id) {
        // 校验存在
        validateExperimentSurveyPostReturnSymptomsExists(id);
        // 删除
        prospectiveExperimentSurveyPostReturnSymptomsMapper.deleteById(id);
    }

    private void validateExperimentSurveyPostReturnSymptomsExists(Long id) {
        if (prospectiveExperimentSurveyPostReturnSymptomsMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveExperimentSurveyPostReturnSymptomsDO getExperimentSurveyPostReturnSymptoms(Long id) {
        return prospectiveExperimentSurveyPostReturnSymptomsMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveExperimentSurveyPostReturnSymptomsDO> getExperimentSurveyPostReturnSymptomsPage(ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO) {
        return prospectiveExperimentSurveyPostReturnSymptomsMapper.selectPage(pageReqVO);
    }

}