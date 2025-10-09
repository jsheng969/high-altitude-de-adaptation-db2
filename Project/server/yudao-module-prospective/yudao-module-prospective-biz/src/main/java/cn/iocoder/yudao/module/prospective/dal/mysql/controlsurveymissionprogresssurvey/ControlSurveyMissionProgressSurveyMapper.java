package cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveymissionprogresssurvey;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.*;

/**
 * 对照组流调-推进情况调查 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlSurveyMissionProgressSurveyMapper extends BaseMapperX<ControlSurveyMissionProgressSurveyDO> {

    default PageResult<ControlSurveyMissionProgressSurveyDO> selectPage(ControlSurveyMissionProgressSurveyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyMissionProgressSurveyDO>()
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getTransportationMode, reqVO.getTransportationMode())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getMissionPointAltitude, reqVO.getMissionPointAltitude())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getLocation, reqVO.getLocation())
                .betweenIfPresent(ControlSurveyMissionProgressSurveyDO::getArrivalDate, reqVO.getArrivalDate())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getPlateauMissionDuration, reqVO.getPlateauMissionDuration())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getTravelDuration, reqVO.getTravelDuration())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getHasStopover, reqVO.getHasStopover())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getStopoverLocation, reqVO.getStopoverLocation())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getStopoverDuration, reqVO.getStopoverDuration())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getHasDiscomfortAfterArrival, reqVO.getHasDiscomfortAfterArrival())
                .betweenIfPresent(ControlSurveyMissionProgressSurveyDO::getDiscomfortOccurrenceTime, reqVO.getDiscomfortOccurrenceTime())
                .betweenIfPresent(ControlSurveyMissionProgressSurveyDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ControlSurveyMissionProgressSurveyDO::getReturnPurpose, reqVO.getReturnPurpose())
                .orderByDesc(ControlSurveyMissionProgressSurveyDO::getId));
    }

}