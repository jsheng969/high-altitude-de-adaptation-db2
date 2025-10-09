package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveystationtraininginfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.*;

/**
 * 驻训信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyStationTrainingInfoMapper extends BaseMapperX<ExperimentSurveyStationTrainingInfoDO> {

    default PageResult<ExperimentSurveyStationTrainingInfoDO> selectPage(ExperimentSurveyStationTrainingInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyStationTrainingInfoDO>()
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getMissionPointAltitude, reqVO.getMissionPointAltitude())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getLocation, reqVO.getLocation())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getPlateauTrainingCount, reqVO.getPlateauTrainingCount())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getPlateauTrainingDuration, reqVO.getPlateauTrainingDuration())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getMissionType, reqVO.getMissionType())
                .eqIfPresent(ExperimentSurveyStationTrainingInfoDO::getDailyWorkHours, reqVO.getDailyWorkHours())
                .betweenIfPresent(ExperimentSurveyStationTrainingInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyStationTrainingInfoDO::getId));
    }

}