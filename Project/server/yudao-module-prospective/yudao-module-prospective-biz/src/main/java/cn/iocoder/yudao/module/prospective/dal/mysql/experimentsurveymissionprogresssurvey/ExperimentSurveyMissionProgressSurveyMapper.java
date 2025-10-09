package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveymissionprogresssurvey;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.*;

/**
 * 推进情况调查 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyMissionProgressSurveyMapper extends BaseMapperX<ExperimentSurveyMissionProgressSurveyDO> {

    default PageResult<ExperimentSurveyMissionProgressSurveyDO> selectPage(ExperimentSurveyMissionProgressSurveyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyMissionProgressSurveyDO>()
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getTransportationMode, reqVO.getTransportationMode())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getMissionPointAltitude, reqVO.getMissionPointAltitude())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getLocation, reqVO.getLocation())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getArrivalDate, reqVO.getArrivalDate())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getPlateauMissionDuration, reqVO.getPlateauMissionDuration())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getTravelDuration, reqVO.getTravelDuration())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getHasStopover, reqVO.getHasStopover())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getStopoverLocation, reqVO.getStopoverLocation())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getStopoverDuration, reqVO.getStopoverDuration())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getHasDiscomfortAfterArrival, reqVO.getHasDiscomfortAfterArrival())
                .eqIfPresent(ExperimentSurveyMissionProgressSurveyDO::getDiscomfortOccurrenceTime, reqVO.getDiscomfortOccurrenceTime())
                .betweenIfPresent(ExperimentSurveyMissionProgressSurveyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyMissionProgressSurveyDO::getId));
    }

}