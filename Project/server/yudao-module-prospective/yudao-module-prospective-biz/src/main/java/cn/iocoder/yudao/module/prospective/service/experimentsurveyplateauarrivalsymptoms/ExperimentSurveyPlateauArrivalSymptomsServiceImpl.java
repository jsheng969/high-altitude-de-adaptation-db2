package cn.iocoder.yudao.module.prospective.service.experimentsurveyplateauarrivalsymptoms;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 抵达高原后症状记录 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyPlateauArrivalSymptomsServiceImpl implements ExperimentSurveyPlateauArrivalSymptomsService {

    @Resource
    private ExperimentSurveyPlateauArrivalSymptomsMapper experimentSurveyPlateauArrivalSymptomsMapper;

    @Override
    public Long createExperimentSurveyPlateauArrivalSymptoms(ExperimentSurveyPlateauArrivalSymptomsSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyPlateauArrivalSymptomsDO experimentSurveyPlateauArrivalSymptoms = BeanUtils.toBean(createReqVO, ExperimentSurveyPlateauArrivalSymptomsDO.class);
        experimentSurveyPlateauArrivalSymptomsMapper.insert(experimentSurveyPlateauArrivalSymptoms);
        // 返回
        return experimentSurveyPlateauArrivalSymptoms.getId();
    }

    @Override
    public void updateExperimentSurveyPlateauArrivalSymptoms(ExperimentSurveyPlateauArrivalSymptomsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyPlateauArrivalSymptomsExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyPlateauArrivalSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPlateauArrivalSymptomsDO.class);
        experimentSurveyPlateauArrivalSymptomsMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyPlateauArrivalSymptoms(Long id) {
        // 校验存在
        validateExperimentSurveyPlateauArrivalSymptomsExists(id);
        // 删除
        experimentSurveyPlateauArrivalSymptomsMapper.deleteById(id);
    }

    private void validateExperimentSurveyPlateauArrivalSymptomsExists(Long id) {
        if (experimentSurveyPlateauArrivalSymptomsMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_PLATEAU_ARRIVAL_SYMPTOMS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyPlateauArrivalSymptomsDO getExperimentSurveyPlateauArrivalSymptoms(Long id) {
        return experimentSurveyPlateauArrivalSymptomsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyPlateauArrivalSymptomsDO> getExperimentSurveyPlateauArrivalSymptomsPage(ExperimentSurveyPlateauArrivalSymptomsPageReqVO pageReqVO) {
        return experimentSurveyPlateauArrivalSymptomsMapper.selectPage(pageReqVO);
    }

}