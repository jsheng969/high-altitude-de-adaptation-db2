package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveynewdiseasespostreturn;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.*;

/**
 * 实验组流调-返回平原后新发的疾病 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyNewDiseasesPostReturnMapper extends BaseMapperX<ExperimentSurveyNewDiseasesPostReturnDO> {

    default PageResult<ExperimentSurveyNewDiseasesPostReturnDO> selectPage(ExperimentSurveyNewDiseasesPostReturnPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyNewDiseasesPostReturnDO>()
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getPulmonaryHeartDisease, reqVO.getPulmonaryHeartDisease())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getLowerExtremityVenousThrombosis, reqVO.getLowerExtremityVenousThrombosis())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getArrhythmia, reqVO.getArrhythmia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getParoxysmalAuricularTachycardia, reqVO.getParoxysmalAuricularTachycardia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getAvBlock, reqVO.getAvBlock())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getVentricularTachycardia, reqVO.getVentricularTachycardia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getOtherDiseases1, reqVO.getOtherDiseases1())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getTransientIschemicAttack, reqVO.getTransientIschemicAttack())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getCerebralInfarction, reqVO.getCerebralInfarction())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getCerebralHemorrhage, reqVO.getCerebralHemorrhage())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getOtherDiseases2, reqVO.getOtherDiseases2())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getHyperlipidemia, reqVO.getHyperlipidemia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getGout, reqVO.getGout())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getOtherDiseases3, reqVO.getOtherDiseases3())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getTumor, reqVO.getTumor())
                .eqIfPresent(ExperimentSurveyNewDiseasesPostReturnDO::getOtherDiseases4, reqVO.getOtherDiseases4())
                .orderByDesc(ExperimentSurveyNewDiseasesPostReturnDO::getId));
    }

}