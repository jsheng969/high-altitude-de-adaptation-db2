package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveysleep;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysleep.ExperimentSurveySleepDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.*;

/**
 * 实验组流调-睡眠信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveySleepMapper extends BaseMapperX<ExperimentSurveySleepDO> {

    default PageResult<ExperimentSurveySleepDO> selectPage(ExperimentSurveySleepPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveySleepDO>()
                .eqIfPresent(ExperimentSurveySleepDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveySleepDO::getSleepTimeStart, reqVO.getSleepTimeStart())
                .eqIfPresent(ExperimentSurveySleepDO::getSleepOnsetTime, reqVO.getSleepOnsetTime())
                .eqIfPresent(ExperimentSurveySleepDO::getWakeTime, reqVO.getWakeTime())
                .eqIfPresent(ExperimentSurveySleepDO::getActualSleepDuration, reqVO.getActualSleepDuration())
                .eqIfPresent(ExperimentSurveySleepDO::getSleepDifficulties, reqVO.getSleepDifficulties())
                .eqIfPresent(ExperimentSurveySleepDO::getNightAwakening, reqVO.getNightAwakening())
                .eqIfPresent(ExperimentSurveySleepDO::getNightUrination, reqVO.getNightUrination())
                .eqIfPresent(ExperimentSurveySleepDO::getBreathingDifficulties, reqVO.getBreathingDifficulties())
                .eqIfPresent(ExperimentSurveySleepDO::getCoughOrSnore, reqVO.getCoughOrSnore())
                .eqIfPresent(ExperimentSurveySleepDO::getFeelingCold, reqVO.getFeelingCold())
                .eqIfPresent(ExperimentSurveySleepDO::getFeelingHot, reqVO.getFeelingHot())
                .eqIfPresent(ExperimentSurveySleepDO::getNightmares, reqVO.getNightmares())
                .eqIfPresent(ExperimentSurveySleepDO::getPainOrDiscomfort, reqVO.getPainOrDiscomfort())
                .eqIfPresent(ExperimentSurveySleepDO::getOtherSleepIssues, reqVO.getOtherSleepIssues())
                .eqIfPresent(ExperimentSurveySleepDO::getSleepAids, reqVO.getSleepAids())
                .eqIfPresent(ExperimentSurveySleepDO::getFatigue, reqVO.getFatigue())
                .eqIfPresent(ExperimentSurveySleepDO::getLackOfEnergy, reqVO.getLackOfEnergy())
                .eqIfPresent(ExperimentSurveySleepDO::getSelfAssessmentSleep, reqVO.getSelfAssessmentSleep())
                .orderByDesc(ExperimentSurveySleepDO::getId));
    }

}