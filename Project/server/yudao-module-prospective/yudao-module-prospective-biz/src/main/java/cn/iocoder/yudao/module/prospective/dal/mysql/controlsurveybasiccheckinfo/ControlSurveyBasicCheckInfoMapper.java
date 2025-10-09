package cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveybasiccheckinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.*;

/**
 * 对照组流调-基本检测信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlSurveyBasicCheckInfoMapper extends BaseMapperX<ControlSurveyBasicCheckInfoDO> {

    default PageResult<ControlSurveyBasicCheckInfoDO> selectPage(ControlSurveyBasicCheckInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyBasicCheckInfoDO>()
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getSystolicBloodPressure, reqVO.getSystolicBloodPressure())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getDiastolicBloodPressure, reqVO.getDiastolicBloodPressure())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getOxygenSaturation, reqVO.getOxygenSaturation())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getHeartRate, reqVO.getHeartRate())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getBasicHeight, reqVO.getBasicHeight())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getBasicWeight, reqVO.getBasicWeight())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getSurveyHeight, reqVO.getSurveyHeight())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getSurveyWeight, reqVO.getSurveyWeight())
                .betweenIfPresent(ControlSurveyBasicCheckInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlSurveyBasicCheckInfoDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ControlSurveyBasicCheckInfoDO::getId));
    }

}