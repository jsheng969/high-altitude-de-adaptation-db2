package cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveypostreturnsymptoms;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.*;

/**
 * 对照组流调-退役后返回平原1月内症状 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlSurveyPostReturnSymptomsMapper extends BaseMapperX<ControlSurveyPostReturnSymptomsDO> {

    default PageResult<ControlSurveyPostReturnSymptomsDO> selectPage(ControlSurveyPostReturnSymptomsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyPostReturnSymptomsDO>()
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getFatigue, reqVO.getFatigue())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getFatigueDuration, reqVO.getFatigueDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWeakness, reqVO.getWeakness())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWeaknessDuration, reqVO.getWeaknessDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDrowsiness, reqVO.getDrowsiness())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDrowsinessDuration, reqVO.getDrowsinessDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDizzinessDuration, reqVO.getDizzinessDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getVertigo, reqVO.getVertigo())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getVertigoDuration, reqVO.getVertigoDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPoorConcentration, reqVO.getPoorConcentration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPoorConcentrationDuration, reqVO.getPoorConcentrationDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSlowReaction, reqVO.getSlowReaction())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSlowReactionDuration, reqVO.getSlowReactionDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getMemoryLoss, reqVO.getMemoryLoss())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getMemoryLossDuration, reqVO.getMemoryLossDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getInsomniaDuration, reqVO.getInsomniaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getNightmares, reqVO.getNightmares())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getNightmaresDuration, reqVO.getNightmaresDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSoreThroat, reqVO.getSoreThroat())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSoreThroatDuration, reqVO.getSoreThroatDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getCough, reqVO.getCough())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getCoughDuration, reqVO.getCoughDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPhlegm, reqVO.getPhlegm())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPhlegmDuration, reqVO.getPhlegmDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWheezing, reqVO.getWheezing())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWheezingDuration, reqVO.getWheezingDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getChestTightness, reqVO.getChestTightness())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getChestTightnessDuration, reqVO.getChestTightnessDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getChestPain, reqVO.getChestPain())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getChestPainDuration, reqVO.getChestPainDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPalpitations, reqVO.getPalpitations())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getPalpitationsDuration, reqVO.getPalpitationsDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getBradycardiaDuration, reqVO.getBradycardiaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getCyanosis, reqVO.getCyanosis())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getCyanosisDuration, reqVO.getCyanosisDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getBloodPressureFluctuation, reqVO.getBloodPressureFluctuation())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getBloodPressureFluctuationDuration, reqVO.getBloodPressureFluctuationDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSkinBleeding, reqVO.getSkinBleeding())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSkinBleedingDuration, reqVO.getSkinBleedingDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSkinBruising, reqVO.getSkinBruising())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getSkinBruisingDuration, reqVO.getSkinBruisingDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAnemia, reqVO.getAnemia())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAnemiaDuration, reqVO.getAnemiaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWeightLoss, reqVO.getWeightLoss())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getWeightLossDuration, reqVO.getWeightLossDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getIncreasedAppetite, reqVO.getIncreasedAppetite())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getIncreasedAppetiteDuration, reqVO.getIncreasedAppetiteDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAnorexia, reqVO.getAnorexia())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAnorexiaDuration, reqVO.getAnorexiaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getConstipation, reqVO.getConstipation())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getConstipationDuration, reqVO.getConstipationDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDiarrhea, reqVO.getDiarrhea())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getDiarrheaDuration, reqVO.getDiarrheaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAbdominalPain, reqVO.getAbdominalPain())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAbdominalPainDuration, reqVO.getAbdominalPainDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAbdominalDistension, reqVO.getAbdominalDistension())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getAbdominalDistensionDuration, reqVO.getAbdominalDistensionDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getJaundice, reqVO.getJaundice())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getJaundiceDuration, reqVO.getJaundiceDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getNumbness, reqVO.getNumbness())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getNumbnessDuration, reqVO.getNumbnessDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getLimbEdema, reqVO.getLimbEdema())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getLimbEdemaDuration, reqVO.getLimbEdemaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getFacialEdema, reqVO.getFacialEdema())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getFacialEdemaDuration, reqVO.getFacialEdemaDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getHairLoss, reqVO.getHairLoss())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getHairLossDuration, reqVO.getHairLossDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getIncreasedUrination, reqVO.getIncreasedUrination())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getIncreasedUrinationDuration, reqVO.getIncreasedUrinationDuration())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getOtherSymptoms, reqVO.getOtherSymptoms())
                .betweenIfPresent(ControlSurveyPostReturnSymptomsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlSurveyPostReturnSymptomsDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ControlSurveyPostReturnSymptomsDO::getId));
    }

}