package cn.iocoder.yudao.module.review.service.experimentsurveypostreturnsymptoms;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-退役后返回平原1月内症状 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyPostReturnSymptomsService {

    /**
     * 创建实验组流调-退役后返回平原1月内症状
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyPostReturnSymptoms(@Valid ExperimentSurveyPostReturnSymptomsSaveReqVO createReqVO);

    /**
     * 更新实验组流调-退役后返回平原1月内症状
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyPostReturnSymptoms(@Valid ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO);

    void updateExperimentSurveyPostReturnSymptomsByPersonId(@Valid ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     */
    void deleteExperimentSurveyPostReturnSymptoms(Long id);

    /**
     * 获得实验组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     * @return 实验组流调-退役后返回平原1月内症状
     */
    ExperimentSurveyPostReturnSymptomsDO getExperimentSurveyPostReturnSymptoms(Long id);

    /**
     * 获得实验组流调-退役后返回平原1月内症状分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-退役后返回平原1月内症状分页
     */
    PageResult<ExperimentSurveyPostReturnSymptomsDO> getExperimentSurveyPostReturnSymptomsPage(ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO);

}