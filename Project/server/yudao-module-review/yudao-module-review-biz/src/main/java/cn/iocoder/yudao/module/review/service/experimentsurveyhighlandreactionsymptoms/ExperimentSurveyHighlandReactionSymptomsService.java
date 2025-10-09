package cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreactionsymptoms;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-高原反应症状 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyHighlandReactionSymptomsService {

    /**
     * 创建实验组流调-高原反应症状
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyHighlandReactionSymptoms(@Valid ExperimentSurveyHighlandReactionSymptomsSaveReqVO createReqVO);

    /**
     * 更新实验组流调-高原反应症状
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyHighlandReactionSymptoms(@Valid ExperimentSurveyHighlandReactionSymptomsSaveReqVO updateReqVO);

    void updateExperimentSurveyHighlandReactionSymptomsByPersonId(@Valid ExperimentSurveyHighlandReactionSymptomsSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-高原反应症状
     *
     * @param id 编号
     */
    void deleteExperimentSurveyHighlandReactionSymptoms(Long id);

    /**
     * 获得实验组流调-高原反应症状
     *
     * @param id 编号
     * @return 实验组流调-高原反应症状
     */
    ExperimentSurveyHighlandReactionSymptomsDO getExperimentSurveyHighlandReactionSymptoms(Long id);

    /**
     * 获得实验组流调-高原反应症状分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-高原反应症状分页
     */
    PageResult<ExperimentSurveyHighlandReactionSymptomsDO> getExperimentSurveyHighlandReactionSymptomsPage(ExperimentSurveyHighlandReactionSymptomsPageReqVO pageReqVO);

}