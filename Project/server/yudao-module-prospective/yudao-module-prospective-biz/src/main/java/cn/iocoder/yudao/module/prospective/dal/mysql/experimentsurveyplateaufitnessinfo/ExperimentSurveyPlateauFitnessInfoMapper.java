package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyplateaufitnessinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.*;

/**
 * 高原体能信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyPlateauFitnessInfoMapper extends BaseMapperX<ExperimentSurveyPlateauFitnessInfoDO> {

    default PageResult<ExperimentSurveyPlateauFitnessInfoDO> selectPage(ExperimentSurveyPlateauFitnessInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyPlateauFitnessInfoDO>()
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getHasRegularTraining, reqVO.getHasRegularTraining())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getTrainingFrequency, reqVO.getTrainingFrequency())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getTrainingDuration, reqVO.getTrainingDuration())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getTrainingType, reqVO.getTrainingType())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getHasChestDiscomfort, reqVO.getHasChestDiscomfort())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getSymptomReliefAfterAdaptation, reqVO.getSymptomReliefAfterAdaptation())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getHasInsomnia, reqVO.getHasInsomnia())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getDailySleepHours, reqVO.getDailySleepHours())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getInsomniaImprovement, reqVO.getInsomniaImprovement())
                .eqIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getDietHabits, reqVO.getDietHabits())
                .betweenIfPresent(ExperimentSurveyPlateauFitnessInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyPlateauFitnessInfoDO::getId));
    }

}