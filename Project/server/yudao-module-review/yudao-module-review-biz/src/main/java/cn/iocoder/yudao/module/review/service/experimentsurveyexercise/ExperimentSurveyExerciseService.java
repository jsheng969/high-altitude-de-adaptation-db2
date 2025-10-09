package cn.iocoder.yudao.module.review.service.experimentsurveyexercise;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyexercise.ExperimentSurveyExerciseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-体育锻炼信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyExerciseService {

    /**
     * 创建实验组流调-体育锻炼信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyExercise(@Valid ExperimentSurveyExerciseSaveReqVO createReqVO);

    /**
     * 更新实验组流调-体育锻炼信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyExercise(@Valid ExperimentSurveyExerciseSaveReqVO updateReqVO);

    void updateExperimentSurveyExerciseByPersonId(@Valid ExperimentSurveyExerciseSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-体育锻炼信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyExercise(Long id);

    /**
     * 获得实验组流调-体育锻炼信息
     *
     * @param id 编号
     * @return 实验组流调-体育锻炼信息
     */
    ExperimentSurveyExerciseDO getExperimentSurveyExercise(Long id);

    /**
     * 获得实验组流调-体育锻炼信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-体育锻炼信息分页
     */
    PageResult<ExperimentSurveyExerciseDO> getExperimentSurveyExercisePage(ExperimentSurveyExercisePageReqVO pageReqVO);

}