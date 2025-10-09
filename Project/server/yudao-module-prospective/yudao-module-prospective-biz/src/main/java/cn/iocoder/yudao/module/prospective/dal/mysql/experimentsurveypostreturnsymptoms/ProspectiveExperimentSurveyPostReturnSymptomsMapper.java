package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveypostreturnsymptoms;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveypostreturnsymptoms.ProspectiveExperimentSurveyPostReturnSymptomsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.*;

/**
 * 实验组流调-退役后返回平原1月内症状 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveExperimentSurveyPostReturnSymptomsMapper extends BaseMapperX<ProspectiveExperimentSurveyPostReturnSymptomsDO> {

    default PageResult<ProspectiveExperimentSurveyPostReturnSymptomsDO> selectPage(ExperimentSurveyPostReturnSymptomsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveExperimentSurveyPostReturnSymptomsDO>()
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getFatigue, reqVO.getFatigue())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getFatigueDuration, reqVO.getFatigueDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWeakness, reqVO.getWeakness())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWeaknessDuration, reqVO.getWeaknessDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDrowsiness, reqVO.getDrowsiness())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDrowsinessDuration, reqVO.getDrowsinessDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDizzinessDuration, reqVO.getDizzinessDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getVertigo, reqVO.getVertigo())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getVertigoDuration, reqVO.getVertigoDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPoorConcentration, reqVO.getPoorConcentration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPoorConcentrationDuration, reqVO.getPoorConcentrationDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSlowReaction, reqVO.getSlowReaction())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSlowReactionDuration, reqVO.getSlowReactionDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getMemoryLoss, reqVO.getMemoryLoss())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getMemoryLossDuration, reqVO.getMemoryLossDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getInsomniaDuration, reqVO.getInsomniaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getNightmares, reqVO.getNightmares())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getNightmaresDuration, reqVO.getNightmaresDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSoreThroat, reqVO.getSoreThroat())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSoreThroatDuration, reqVO.getSoreThroatDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getCough, reqVO.getCough())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getCoughDuration, reqVO.getCoughDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPhlegm, reqVO.getPhlegm())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPhlegmDuration, reqVO.getPhlegmDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWheezing, reqVO.getWheezing())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWheezingDuration, reqVO.getWheezingDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getChestTightness, reqVO.getChestTightness())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getChestTightnessDuration, reqVO.getChestTightnessDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getChestPain, reqVO.getChestPain())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getChestPainDuration, reqVO.getChestPainDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPalpitations, reqVO.getPalpitations())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getPalpitationsDuration, reqVO.getPalpitationsDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getBradycardiaDuration, reqVO.getBradycardiaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getCyanosis, reqVO.getCyanosis())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getCyanosisDuration, reqVO.getCyanosisDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getBloodPressureFluctuation, reqVO.getBloodPressureFluctuation())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getBloodPressureFluctuationDuration, reqVO.getBloodPressureFluctuationDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSkinBleeding, reqVO.getSkinBleeding())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSkinBleedingDuration, reqVO.getSkinBleedingDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSkinBruising, reqVO.getSkinBruising())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getSkinBruisingDuration, reqVO.getSkinBruisingDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAnemia, reqVO.getAnemia())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAnemiaDuration, reqVO.getAnemiaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWeightLoss, reqVO.getWeightLoss())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getWeightLossDuration, reqVO.getWeightLossDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getIncreasedAppetite, reqVO.getIncreasedAppetite())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getIncreasedAppetiteDuration, reqVO.getIncreasedAppetiteDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAnorexia, reqVO.getAnorexia())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAnorexiaDuration, reqVO.getAnorexiaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getConstipation, reqVO.getConstipation())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getConstipationDuration, reqVO.getConstipationDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDiarrhea, reqVO.getDiarrhea())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getDiarrheaDuration, reqVO.getDiarrheaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAbdominalPain, reqVO.getAbdominalPain())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAbdominalPainDuration, reqVO.getAbdominalPainDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAbdominalDistension, reqVO.getAbdominalDistension())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getAbdominalDistensionDuration, reqVO.getAbdominalDistensionDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getJaundice, reqVO.getJaundice())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getJaundiceDuration, reqVO.getJaundiceDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getNumbness, reqVO.getNumbness())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getNumbnessDuration, reqVO.getNumbnessDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getLimbEdema, reqVO.getLimbEdema())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getLimbEdemaDuration, reqVO.getLimbEdemaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getFacialEdema, reqVO.getFacialEdema())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getFacialEdemaDuration, reqVO.getFacialEdemaDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getHairLoss, reqVO.getHairLoss())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getHairLossDuration, reqVO.getHairLossDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getIncreasedUrination, reqVO.getIncreasedUrination())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getIncreasedUrinationDuration, reqVO.getIncreasedUrinationDuration())
                .eqIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getOtherSymptoms, reqVO.getOtherSymptoms())
                .betweenIfPresent(ProspectiveExperimentSurveyPostReturnSymptomsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProspectiveExperimentSurveyPostReturnSymptomsDO::getId));
    }

}