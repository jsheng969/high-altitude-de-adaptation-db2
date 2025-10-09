package cn.iocoder.yudao.module.review.service.experimentsurveysmoking;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysmoking.ExperimentSurveySmokingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-吸烟情况 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveySmokingService {

    /**
     * 创建实验组流调-吸烟情况
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveySmoking(@Valid ExperimentSurveySmokingSaveReqVO createReqVO);

    /**
     * 更新实验组流调-吸烟情况
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveySmoking(@Valid ExperimentSurveySmokingSaveReqVO updateReqVO);

    void updateExperimentSurveySmokingByPersonId(@Valid ExperimentSurveySmokingSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-吸烟情况
     *
     * @param id 编号
     */
    void deleteExperimentSurveySmoking(Long id);

    /**
     * 获得实验组流调-吸烟情况
     *
     * @param id 编号
     * @return 实验组流调-吸烟情况
     */
    ExperimentSurveySmokingDO getExperimentSurveySmoking(Long id);

    /**
     * 获得实验组流调-吸烟情况分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-吸烟情况分页
     */
    PageResult<ExperimentSurveySmokingDO> getExperimentSurveySmokingPage(ExperimentSurveySmokingPageReqVO pageReqVO);

}