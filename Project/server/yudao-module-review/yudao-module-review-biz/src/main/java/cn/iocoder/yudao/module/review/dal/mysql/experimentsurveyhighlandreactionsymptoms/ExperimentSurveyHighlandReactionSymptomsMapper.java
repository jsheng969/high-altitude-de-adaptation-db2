package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlandreactionsymptoms;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.*;

/**
 * 实验组流调-高原反应症状 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyHighlandReactionSymptomsMapper extends BaseMapperX<ExperimentSurveyHighlandReactionSymptomsDO> {

    default PageResult<ExperimentSurveyHighlandReactionSymptomsDO> selectPage(ExperimentSurveyHighlandReactionSymptomsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyHighlandReactionSymptomsDO>()
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getHeadache, reqVO.getHeadache())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getVomiting, reqVO.getVomiting())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getNausea, reqVO.getNausea())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getPalpitations, reqVO.getPalpitations())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getPoorAppetite, reqVO.getPoorAppetite())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getChestTightness, reqVO.getChestTightness())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getBlurredVision, reqVO.getBlurredVision())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getShortnessOfBreath, reqVO.getShortnessOfBreath())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getAbdominalBloating, reqVO.getAbdominalBloating())
                .eqIfPresent(ExperimentSurveyHighlandReactionSymptomsDO::getDiarrhea, reqVO.getDiarrhea())
                .orderByDesc(ExperimentSurveyHighlandReactionSymptomsDO::getId));
    }

}