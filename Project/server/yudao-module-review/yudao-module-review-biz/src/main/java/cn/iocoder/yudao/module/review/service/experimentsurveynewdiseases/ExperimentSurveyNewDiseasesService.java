package cn.iocoder.yudao.module.review.service.experimentsurveynewdiseases;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-新发的疾病 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyNewDiseasesService {

    /**
     * 创建实验组流调-新发的疾病
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyNewDiseases(@Valid ExperimentSurveyNewDiseasesSaveReqVO createReqVO);

    /**
     * 更新实验组流调-新发的疾病
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyNewDiseases(@Valid ExperimentSurveyNewDiseasesSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-新发的疾病
     *
     * @param id 编号
     */
    void deleteExperimentSurveyNewDiseases(Long id);

    /**
     * 获得实验组流调-新发的疾病
     *
     * @param id 编号
     * @return 实验组流调-新发的疾病
     */
    ExperimentSurveyNewDiseasesDO getExperimentSurveyNewDiseases(Long id);

    /**
     * 获得实验组流调-新发的疾病分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-新发的疾病分页
     */
    PageResult<ExperimentSurveyNewDiseasesDO> getExperimentSurveyNewDiseasesPage(ExperimentSurveyNewDiseasesPageReqVO pageReqVO);

}