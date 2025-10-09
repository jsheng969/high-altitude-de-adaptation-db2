package cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveystationtraininginfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo.vo.*;

/**
 * 对照组流调-驻训信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlSurveyStationTrainingInfoMapper extends BaseMapperX<ControlSurveyStationTrainingInfoDO> {

    default PageResult<ControlSurveyStationTrainingInfoDO> selectPage(ControlSurveyStationTrainingInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyStationTrainingInfoDO>()
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getMissionPointAltitude, reqVO.getMissionPointAltitude())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getLocation, reqVO.getLocation())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getPlateauTrainingCount, reqVO.getPlateauTrainingCount())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getPlateauTrainingDuration, reqVO.getPlateauTrainingDuration())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getMissionType, reqVO.getMissionType())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getDailyWorkHours, reqVO.getDailyWorkHours())
                .betweenIfPresent(ControlSurveyStationTrainingInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ControlSurveyStationTrainingInfoDO::getServicePosition, reqVO.getServicePosition())
                .orderByDesc(ControlSurveyStationTrainingInfoDO::getId));
    }

}