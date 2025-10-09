package cn.iocoder.yudao.module.prospective.service.experimentsurveyhighlanddiseasesduringservice;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyhighlanddiseasesduringservice.ProspectiveExperimentSurveyHighlandDiseasesDuringServiceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 抵达高原后有无新下疾病 Service 实现类
 *
 * @author 管理员
 */
@Service("prospectiveExperimentSurveyHighlandDiseasesDuringServiceServiceImpl")
@Validated
public class ExperimentSurveyHighlandDiseasesDuringServiceServiceImpl implements ExperimentSurveyHighlandDiseasesDuringServiceService {

    @Resource
    private ProspectiveExperimentSurveyHighlandDiseasesDuringServiceMapper prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper;

    @Override
    public Long createExperimentSurveyHighlandDiseasesDuringService(ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO createReqVO) {
        // 插入
        ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO experimentSurveyHighlandDiseasesDuringService = BeanUtils.toBean(createReqVO, ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO.class);
        prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.insert(experimentSurveyHighlandDiseasesDuringService);
        // 返回
        return experimentSurveyHighlandDiseasesDuringService.getId();
    }

    @Override
    public void updateExperimentSurveyHighlandDiseasesDuringService(ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesDuringServiceExists(updateReqVO.getId());
        // 更新
        ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO.class);
        prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyHighlandDiseasesDuringService(Long id) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesDuringServiceExists(id);
        // 删除
        prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.deleteById(id);
    }

    private void validateExperimentSurveyHighlandDiseasesDuringServiceExists(Long id) {
        if (prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_HIGHLAND_DISEASES_DURING_SERVICE_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO getExperimentSurveyHighlandDiseasesDuringService(Long id) {
        return prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> getExperimentSurveyHighlandDiseasesDuringServicePage(ExperimentSurveyHighlandDiseasesDuringServicePageReqVO pageReqVO) {
        return prospectiveExperimentSurveyHighlandDiseasesDuringServiceMapper.selectPage(pageReqVO);
    }

}