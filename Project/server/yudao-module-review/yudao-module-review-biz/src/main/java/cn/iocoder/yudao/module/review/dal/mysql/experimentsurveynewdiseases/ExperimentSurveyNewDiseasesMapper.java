package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveynewdiseases;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.*;

/**
 * 实验组流调-新发的疾病 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyNewDiseasesMapper extends BaseMapperX<ExperimentSurveyNewDiseasesDO> {

    default PageResult<ExperimentSurveyNewDiseasesDO> selectPage(ExperimentSurveyNewDiseasesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyNewDiseasesDO>()
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getPersonId, reqVO.getPersonId())
                .likeIfPresent(ExperimentSurveyNewDiseasesDO::getNewDisease1Name, reqVO.getNewDisease1Name())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosed, reqVO.getDiagnosed())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosisDate, reqVO.getDiagnosisDate())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getHospitalized, reqVO.getHospitalized())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedication, reqVO.getMedication())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedicationEffect, reqVO.getMedicationEffect())
                .likeIfPresent(ExperimentSurveyNewDiseasesDO::getNewDisease2Name, reqVO.getNewDisease2Name())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosed2, reqVO.getDiagnosed2())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosisDate2, reqVO.getDiagnosisDate2())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getHospitalized2, reqVO.getHospitalized2())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedication2, reqVO.getMedication2())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedicationEffect2, reqVO.getMedicationEffect2())
                .likeIfPresent(ExperimentSurveyNewDiseasesDO::getNewDisease3Name, reqVO.getNewDisease3Name())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosed3, reqVO.getDiagnosed3())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosisDate3, reqVO.getDiagnosisDate3())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getHospitalized3, reqVO.getHospitalized3())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedication3, reqVO.getMedication3())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedicationEffect3, reqVO.getMedicationEffect3())
                .likeIfPresent(ExperimentSurveyNewDiseasesDO::getNewDisease4Name, reqVO.getNewDisease4Name())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosed4, reqVO.getDiagnosed4())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getDiagnosisDate4, reqVO.getDiagnosisDate4())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getHospitalized4, reqVO.getHospitalized4())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedication4, reqVO.getMedication4())
                .eqIfPresent(ExperimentSurveyNewDiseasesDO::getMedicationEffect4, reqVO.getMedicationEffect4())
                .orderByDesc(ExperimentSurveyNewDiseasesDO::getId));
    }

}