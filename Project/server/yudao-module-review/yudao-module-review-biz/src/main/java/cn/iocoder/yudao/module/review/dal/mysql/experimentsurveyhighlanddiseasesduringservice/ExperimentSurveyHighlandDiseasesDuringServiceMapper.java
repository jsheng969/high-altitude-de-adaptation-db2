package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlanddiseasesduringservice;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;

/**
 * 实验组流调-高原期间出现的疾病 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyHighlandDiseasesDuringServiceMapper extends BaseMapperX<ExperimentSurveyHighlandDiseasesDuringServiceDO> {

    default PageResult<ExperimentSurveyHighlandDiseasesDuringServiceDO> selectPage(ExperimentSurveyHighlandDiseasesDuringServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyHighlandDiseasesDuringServiceDO>()
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getPulmonaryHeartDisease, reqVO.getPulmonaryHeartDisease())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getLowerExtremityVenousThrombosis, reqVO.getLowerExtremityVenousThrombosis())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getArrhythmia, reqVO.getArrhythmia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getParoxysmalAuricularTachycardia, reqVO.getParoxysmalAuricularTachycardia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getAvBlock, reqVO.getAvBlock())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getVentricularTachycardia, reqVO.getVentricularTachycardia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases1, reqVO.getOtherDiseases1())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getTransientIschemicAttack, reqVO.getTransientIschemicAttack())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getCerebralInfarction, reqVO.getCerebralInfarction())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getCerebralHemorrhage, reqVO.getCerebralHemorrhage())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases2, reqVO.getOtherDiseases2())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getHyperlipidemia, reqVO.getHyperlipidemia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getGout, reqVO.getGout())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases3, reqVO.getOtherDiseases3())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getTumor, reqVO.getTumor())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDuringServiceDO::getOtherDiseases4, reqVO.getOtherDiseases4())
                .orderByDesc(ExperimentSurveyHighlandDiseasesDuringServiceDO::getId));
    }

}