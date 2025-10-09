package cn.iocoder.yudao.module.review.service.experimentsurveysleep;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysleep.ExperimentSurveySleepDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-睡眠信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveySleepService {

    /**
     * 创建实验组流调-睡眠信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveySleep(@Valid ExperimentSurveySleepSaveReqVO createReqVO);

    /**
     * 更新实验组流调-睡眠信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveySleep(@Valid ExperimentSurveySleepSaveReqVO updateReqVO);

    void updateExperimentSurveySleepByPersonId(@Valid ExperimentSurveySleepSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-睡眠信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveySleep(Long id);

    /**
     * 获得实验组流调-睡眠信息
     *
     * @param id 编号
     * @return 实验组流调-睡眠信息
     */
    ExperimentSurveySleepDO getExperimentSurveySleep(Long id);

    /**
     * 获得实验组流调-睡眠信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-睡眠信息分页
     */
    PageResult<ExperimentSurveySleepDO> getExperimentSurveySleepPage(ExperimentSurveySleepPageReqVO pageReqVO);

}