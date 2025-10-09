package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyplateauarrivalsymptoms;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.*;

/**
 * 抵达高原后症状记录 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyPlateauArrivalSymptomsMapper extends BaseMapperX<ExperimentSurveyPlateauArrivalSymptomsDO> {

    default PageResult<ExperimentSurveyPlateauArrivalSymptomsDO> selectPage(ExperimentSurveyPlateauArrivalSymptomsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyPlateauArrivalSymptomsDO>()
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getHeadache, reqVO.getHeadache())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getHeadacheDuration, reqVO.getHeadacheDuration())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getDigestiveSymptoms, reqVO.getDigestiveSymptoms())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getDigestiveSymptomsDuration, reqVO.getDigestiveSymptomsDuration())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getFatigue, reqVO.getFatigue())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getFatigueDuration, reqVO.getFatigueDuration())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getDizziness, reqVO.getDizziness())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getDizzinessDuration, reqVO.getDizzinessDuration())
                .eqIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getImpactOnDailyLife, reqVO.getImpactOnDailyLife())
                .betweenIfPresent(ExperimentSurveyPlateauArrivalSymptomsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyPlateauArrivalSymptomsDO::getId));
    }

}