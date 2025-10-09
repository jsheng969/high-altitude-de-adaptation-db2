package cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseases;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-高原疾病诊断 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyHighlandDiseasesService {

    /**
     * 创建实验组流调-高原疾病诊断
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyHighlandDiseases(@Valid ExperimentSurveyHighlandDiseasesSaveReqVO createReqVO);

    /**
     * 更新实验组流调-高原疾病诊断
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyHighlandDiseases(@Valid ExperimentSurveyHighlandDiseasesSaveReqVO updateReqVO);

    void updateExperimentSurveyHighlandDiseasesByPersonId(@Valid ExperimentSurveyHighlandDiseasesSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-高原疾病诊断
     *
     * @param id 编号
     */
    void deleteExperimentSurveyHighlandDiseases(Long id);

    /**
     * 获得实验组流调-高原疾病诊断
     *
     * @param id 编号
     * @return 实验组流调-高原疾病诊断
     */
    ExperimentSurveyHighlandDiseasesDO getExperimentSurveyHighlandDiseases(Long id);

    /**
     * 获得实验组流调-高原疾病诊断分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-高原疾病诊断分页
     */
    PageResult<ExperimentSurveyHighlandDiseasesDO> getExperimentSurveyHighlandDiseasesPage(ExperimentSurveyHighlandDiseasesPageReqVO pageReqVO);

}