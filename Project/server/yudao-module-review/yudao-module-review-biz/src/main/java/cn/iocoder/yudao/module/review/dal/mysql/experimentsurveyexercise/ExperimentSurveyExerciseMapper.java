package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyexercise;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyexercise.ExperimentSurveyExerciseDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.*;

/**
 * 实验组流调-体育锻炼信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyExerciseMapper extends BaseMapperX<ExperimentSurveyExerciseDO> {

    default PageResult<ExperimentSurveyExerciseDO> selectPage(ExperimentSurveyExercisePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyExerciseDO>()
                .eqIfPresent(ExperimentSurveyExerciseDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyExerciseDO::getRegularExercise, reqVO.getRegularExercise())
                .eqIfPresent(ExperimentSurveyExerciseDO::getExerciseFrequency, reqVO.getExerciseFrequency())
                .eqIfPresent(ExperimentSurveyExerciseDO::getExerciseDuration, reqVO.getExerciseDuration())
                .eqIfPresent(ExperimentSurveyExerciseDO::getExerciseType, reqVO.getExerciseType())
                .eqIfPresent(ExperimentSurveyExerciseDO::getChestPainOrShortness, reqVO.getChestPainOrShortness())
                .eqIfPresent(ExperimentSurveyExerciseDO::getDoctorGuidedExercise, reqVO.getDoctorGuidedExercise())
                .orderByDesc(ExperimentSurveyExerciseDO::getId));
    }

}