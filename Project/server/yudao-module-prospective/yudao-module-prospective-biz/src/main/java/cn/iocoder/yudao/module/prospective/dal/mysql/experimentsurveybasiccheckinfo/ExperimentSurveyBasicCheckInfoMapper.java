package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveybasiccheckinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.*;

/**
 * 基本检测信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyBasicCheckInfoMapper extends BaseMapperX<ExperimentSurveyBasicCheckInfoDO> {

    default PageResult<ExperimentSurveyBasicCheckInfoDO> selectPage(ExperimentSurveyBasicCheckInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyBasicCheckInfoDO>()
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getSystolicBloodPressure, reqVO.getSystolicBloodPressure())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getDiastolicBloodPressure, reqVO.getDiastolicBloodPressure())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getOxygenSaturation, reqVO.getOxygenSaturation())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getHeartRate, reqVO.getHeartRate())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getBasicHeight, reqVO.getBasicHeight())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getBasicWeight, reqVO.getBasicWeight())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getSurveyHeight, reqVO.getSurveyHeight())
                .eqIfPresent(ExperimentSurveyBasicCheckInfoDO::getSurveyWeight, reqVO.getSurveyWeight())
                .betweenIfPresent(ExperimentSurveyBasicCheckInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyBasicCheckInfoDO::getId));
    }

}