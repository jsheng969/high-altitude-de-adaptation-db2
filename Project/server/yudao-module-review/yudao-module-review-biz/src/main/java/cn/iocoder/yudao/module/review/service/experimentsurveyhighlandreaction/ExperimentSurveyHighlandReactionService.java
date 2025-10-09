package cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreaction;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-高原反应信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyHighlandReactionService {

    /**
     * 创建实验组流调-高原反应信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyHighlandReaction(@Valid ExperimentSurveyHighlandReactionSaveReqVO createReqVO);

    /**
     * 更新实验组流调-高原反应信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyHighlandReaction(@Valid ExperimentSurveyHighlandReactionSaveReqVO updateReqVO);

    void updateExperimentSurveyHighlandReactionByPersonId(@Valid ExperimentSurveyHighlandReactionSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-高原反应信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyHighlandReaction(Long id);

    /**
     * 获得实验组流调-高原反应信息
     *
     * @param id 编号
     * @return 实验组流调-高原反应信息
     */
    ExperimentSurveyHighlandReactionDO getExperimentSurveyHighlandReaction(Long id);

    /**
     * 获得实验组流调-高原反应信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-高原反应信息分页
     */
    PageResult<ExperimentSurveyHighlandReactionDO> getExperimentSurveyHighlandReactionPage(ExperimentSurveyHighlandReactionPageReqVO pageReqVO);

}