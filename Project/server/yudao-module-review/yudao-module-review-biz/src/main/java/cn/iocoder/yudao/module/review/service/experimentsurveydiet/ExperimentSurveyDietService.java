package cn.iocoder.yudao.module.review.service.experimentsurveydiet;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydiet.ExperimentSurveyDietDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-饮食习惯 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyDietService {

    /**
     * 创建实验组流调-饮食习惯
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyDiet(@Valid ExperimentSurveyDietSaveReqVO createReqVO);

    /**
     * 更新实验组流调-饮食习惯
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyDiet(@Valid ExperimentSurveyDietSaveReqVO updateReqVO);

    void updateExperimentSurveyDietByPersonId(@Valid ExperimentSurveyDietSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-饮食习惯
     *
     * @param id 编号
     */
    void deleteExperimentSurveyDiet(Long id);

    /**
     * 获得实验组流调-饮食习惯
     *
     * @param id 编号
     * @return 实验组流调-饮食习惯
     */
    ExperimentSurveyDietDO getExperimentSurveyDiet(Long id);

    /**
     * 获得实验组流调-饮食习惯分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-饮食习惯分页
     */
    PageResult<ExperimentSurveyDietDO> getExperimentSurveyDietPage(ExperimentSurveyDietPageReqVO pageReqVO);

}