package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyhighlanddiseasesduringservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;

/**
 * 抵达高原后有无新下疾病 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveExperimentSurveyHighlandDiseasesDuringServiceMapper extends BaseMapperX<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> {

    default PageResult<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> selectPage(ExperimentSurveyHighlandDiseasesDuringServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO>()
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getPulmonaryHeartDisease, reqVO.getPulmonaryHeartDisease())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getLowerExtremityVenousThrombosis, reqVO.getLowerExtremityVenousThrombosis())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getArrhythmia, reqVO.getArrhythmia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getParoxysmalAuricularTachycardia, reqVO.getParoxysmalAuricularTachycardia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getAvBlock, reqVO.getAvBlock())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getVentricularTachycardia, reqVO.getVentricularTachycardia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases11, reqVO.getOtherDiseases11())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getTransientIschemicAttack, reqVO.getTransientIschemicAttack())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getCerebralInfarction, reqVO.getCerebralInfarction())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getCerebralHemorrhage, reqVO.getCerebralHemorrhage())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases12, reqVO.getOtherDiseases12())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getHyperlipidemia, reqVO.getHyperlipidemia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getGout, reqVO.getGout())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases13, reqVO.getOtherDiseases13())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getTumor, reqVO.getTumor())
                .eqIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases14, reqVO.getOtherDiseases14())
                .betweenIfPresent(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO::getId));
    }

}