package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveysmoking;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysmoking.ExperimentSurveySmokingDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.*;

/**
 * 实验组流调-吸烟情况 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveySmokingMapper extends BaseMapperX<ExperimentSurveySmokingDO> {

    default PageResult<ExperimentSurveySmokingDO> selectPage(ExperimentSurveySmokingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveySmokingDO>()
                .eqIfPresent(ExperimentSurveySmokingDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveySmokingDO::getSmokingStatus, reqVO.getSmokingStatus())
                .eqIfPresent(ExperimentSurveySmokingDO::getDailySmoking, reqVO.getDailySmoking())
                .eqIfPresent(ExperimentSurveySmokingDO::getSmokingStartAge, reqVO.getSmokingStartAge())
                .eqIfPresent(ExperimentSurveySmokingDO::getSmokingYears, reqVO.getSmokingYears())
                .eqIfPresent(ExperimentSurveySmokingDO::getTriedQuit, reqVO.getTriedQuit())
                .eqIfPresent(ExperimentSurveySmokingDO::getHighlandPlainSmokingStatus, reqVO.getHighlandPlainSmokingStatus())
                .eqIfPresent(ExperimentSurveySmokingDO::getSmokingYears2, reqVO.getSmokingYears2())
                .eqIfPresent(ExperimentSurveySmokingDO::getQuitTime, reqVO.getQuitTime())
                .eqIfPresent(ExperimentSurveySmokingDO::getHighlandPlainSmokingStatus2, reqVO.getHighlandPlainSmokingStatus2())
                .orderByDesc(ExperimentSurveySmokingDO::getId));
    }

}