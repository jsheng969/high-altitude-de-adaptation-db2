package cn.iocoder.yudao.module.review.dal.mysql.controlsurveypastdiseases;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveypastdiseases.ControlSurveyPastDiseasesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.*;

/**
 * 对照组流调-既往疾病 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlSurveyPastDiseasesMapper extends BaseMapperX<ControlSurveyPastDiseasesDO> {

    default PageResult<ControlSurveyPastDiseasesDO> selectPage(ControlSurveyPastDiseasesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyPastDiseasesDO>()
                .eqIfPresent(ControlSurveyPastDiseasesDO::getPersonId, reqVO.getPersonId())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease1Name, reqVO.getDisease1Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease1Diagnosed, reqVO.getDisease1Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease1DiagnosisDate, reqVO.getDisease1DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease1Hospitalized, reqVO.getDisease1Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease1Treated, reqVO.getDisease1Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease1TreatmentEffect, reqVO.getDisease1TreatmentEffect())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease2Name, reqVO.getDisease2Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease2Diagnosed, reqVO.getDisease2Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease2DiagnosisDate, reqVO.getDisease2DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease2Hospitalized, reqVO.getDisease2Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease2Treated, reqVO.getDisease2Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease2TreatmentEffect, reqVO.getDisease2TreatmentEffect())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease3Name, reqVO.getDisease3Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease3Diagnosed, reqVO.getDisease3Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease3DiagnosisDate, reqVO.getDisease3DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease3Hospitalized, reqVO.getDisease3Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease3Treated, reqVO.getDisease3Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease3TreatmentEffect, reqVO.getDisease3TreatmentEffect())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease4Name, reqVO.getDisease4Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease4Diagnosed, reqVO.getDisease4Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease4DiagnosisDate, reqVO.getDisease4DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease4Hospitalized, reqVO.getDisease4Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease4Treated, reqVO.getDisease4Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease4TreatmentEffect, reqVO.getDisease4TreatmentEffect())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease5Name, reqVO.getDisease5Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease5Diagnosed, reqVO.getDisease5Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease5DiagnosisDate, reqVO.getDisease5DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease5Hospitalized, reqVO.getDisease5Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease5Treated, reqVO.getDisease5Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease5TreatmentEffect, reqVO.getDisease5TreatmentEffect())
                .likeIfPresent(ControlSurveyPastDiseasesDO::getDisease6Name, reqVO.getDisease6Name())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease6Diagnosed, reqVO.getDisease6Diagnosed())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease6DiagnosisDate, reqVO.getDisease6DiagnosisDate())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease6Hospitalized, reqVO.getDisease6Hospitalized())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease6Treated, reqVO.getDisease6Treated())
                .eqIfPresent(ControlSurveyPastDiseasesDO::getDisease6TreatmentEffect, reqVO.getDisease6TreatmentEffect())
                .orderByDesc(ControlSurveyPastDiseasesDO::getId));
    }

}