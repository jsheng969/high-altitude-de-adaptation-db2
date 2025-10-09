package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlanddiseases;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.*;

/**
 * 实验组流调-高原疾病诊断 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyHighlandDiseasesMapper extends BaseMapperX<ExperimentSurveyHighlandDiseasesDO> {

    default PageResult<ExperimentSurveyHighlandDiseasesDO> selectPage(ExperimentSurveyHighlandDiseasesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyHighlandDiseasesDO>()
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getAcuteHighlandReaction, reqVO.getAcuteHighlandReaction())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getHighlandPulmonaryEdema, reqVO.getHighlandPulmonaryEdema())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getHighlandCerebralEdema, reqVO.getHighlandCerebralEdema())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getHighlandHeartDisease, reqVO.getHighlandHeartDisease())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getHighlandPolycythemia, reqVO.getHighlandPolycythemia())
                .eqIfPresent(ExperimentSurveyHighlandDiseasesDO::getOtherDiseases, reqVO.getOtherDiseases())
                .orderByDesc(ExperimentSurveyHighlandDiseasesDO::getId));
    }

}