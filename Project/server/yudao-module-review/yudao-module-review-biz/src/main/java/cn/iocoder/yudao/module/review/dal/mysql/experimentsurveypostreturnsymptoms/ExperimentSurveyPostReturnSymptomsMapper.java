package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveypostreturnsymptoms;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.*;

/**
 * 实验组流调-退役后返回平原1月内症状 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyPostReturnSymptomsMapper extends BaseMapperX<ExperimentSurveyPostReturnSymptomsDO> {

    default PageResult<ExperimentSurveyPostReturnSymptomsDO> selectPage(ExperimentSurveyPostReturnSymptomsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyPostReturnSymptomsDO>()
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getFatigue, reqVO.getFatigue())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getDrowsiness, reqVO.getDrowsiness())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getVertigo, reqVO.getVertigo())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getPoorConcentration, reqVO.getPoorConcentration())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getSlowReaction, reqVO.getSlowReaction())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getMemoryLoss, reqVO.getMemoryLoss())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getInsomnia, reqVO.getInsomnia())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getNightmares, reqVO.getNightmares())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getChestPain, reqVO.getChestPain())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getPalpitations, reqVO.getPalpitations())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getCyanosis, reqVO.getCyanosis())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getBloodPressureFluctuation, reqVO.getBloodPressureFluctuation())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getSkinBleeding, reqVO.getSkinBleeding())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getSkinBruising, reqVO.getSkinBruising())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getAnemia, reqVO.getAnemia())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getSoreThroat, reqVO.getSoreThroat())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getCough, reqVO.getCough())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getPhlegm, reqVO.getPhlegm())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getWheezing, reqVO.getWheezing())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getChestTightness, reqVO.getChestTightness())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getWeightLoss, reqVO.getWeightLoss())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getIncreasedAppetite, reqVO.getIncreasedAppetite())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getAnorexia, reqVO.getAnorexia())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getConstipation, reqVO.getConstipation())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getDiarrhea, reqVO.getDiarrhea())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getAbdominalPain, reqVO.getAbdominalPain())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getJaundice, reqVO.getJaundice())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getNumbness, reqVO.getNumbness())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getLimbEdema, reqVO.getLimbEdema())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getFacialEdema, reqVO.getFacialEdema())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getHairLoss, reqVO.getHairLoss())
                .eqIfPresent(ExperimentSurveyPostReturnSymptomsDO::getIncreasedUrination, reqVO.getIncreasedUrination())
                .orderByDesc(ExperimentSurveyPostReturnSymptomsDO::getId));
    }

}