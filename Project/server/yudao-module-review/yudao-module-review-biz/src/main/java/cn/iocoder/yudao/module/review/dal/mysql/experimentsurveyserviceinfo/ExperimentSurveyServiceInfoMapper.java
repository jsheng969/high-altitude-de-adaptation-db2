package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyserviceinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.*;

/**
 * 实验组流调-服役信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyServiceInfoMapper extends BaseMapperX<ExperimentSurveyServiceInfoDO> {

    default PageResult<ExperimentSurveyServiceInfoDO> selectPage(ExperimentSurveyServiceInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyServiceInfoDO>()
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getEnlistmentYear, reqVO.getEnlistmentYear())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandEntryYear, reqVO.getHighlandEntryYear())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getDischargeYear, reqVO.getDischargeYear())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getServicePosition, reqVO.getServicePosition())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation1, reqVO.getHighlandServiceLocation1())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude1, reqVO.getAltitude1())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear1, reqVO.getYear1())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth1, reqVO.getMonth1())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation2, reqVO.getHighlandServiceLocation2())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude2, reqVO.getAltitude2())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear2, reqVO.getYear2())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth2, reqVO.getMonth2())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation3, reqVO.getHighlandServiceLocation3())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude3, reqVO.getAltitude3())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear3, reqVO.getYear3())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth3, reqVO.getMonth3())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation4, reqVO.getHighlandServiceLocation4())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude4, reqVO.getAltitude4())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear4, reqVO.getYear4())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth4, reqVO.getMonth4())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation5, reqVO.getHighlandServiceLocation5())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude5, reqVO.getAltitude5())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear5, reqVO.getYear5())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth5, reqVO.getMonth5())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandServiceLocation6, reqVO.getHighlandServiceLocation6())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getAltitude6, reqVO.getAltitude6())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getYear6, reqVO.getYear6())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getMonth6, reqVO.getMonth6())
                .eqIfPresent(ExperimentSurveyServiceInfoDO::getHighlandTaskType, reqVO.getHighlandTaskType())
                .orderByDesc(ExperimentSurveyServiceInfoDO::getId));
    }

}