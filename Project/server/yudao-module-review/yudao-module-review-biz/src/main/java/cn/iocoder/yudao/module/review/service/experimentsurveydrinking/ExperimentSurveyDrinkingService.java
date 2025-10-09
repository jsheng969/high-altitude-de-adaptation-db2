package cn.iocoder.yudao.module.review.service.experimentsurveydrinking;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydrinking.ExperimentSurveyDrinkingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-饮酒情况 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyDrinkingService {

    /**
     * 创建实验组流调-饮酒情况
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyDrinking(@Valid ExperimentSurveyDrinkingSaveReqVO createReqVO);

    /**
     * 更新实验组流调-饮酒情况
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyDrinking(@Valid ExperimentSurveyDrinkingSaveReqVO updateReqVO);

    void updateExperimentSurveyDrinkingByPersonId(@Valid ExperimentSurveyDrinkingSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-饮酒情况
     *
     * @param id 编号
     */
    void deleteExperimentSurveyDrinking(Long id);

    /**
     * 获得实验组流调-饮酒情况
     *
     * @param id 编号
     * @return 实验组流调-饮酒情况
     */
    ExperimentSurveyDrinkingDO getExperimentSurveyDrinking(Long id);

    /**
     * 获得实验组流调-饮酒情况分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-饮酒情况分页
     */
    PageResult<ExperimentSurveyDrinkingDO> getExperimentSurveyDrinkingPage(ExperimentSurveyDrinkingPageReqVO pageReqVO);

}