package cn.iocoder.yudao.module.review.service.experimentsurveyfamilydiseases;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-亲属既往疾病 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyFamilyDiseasesService {

    /**
     * 创建实验组流调-亲属既往疾病
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyFamilyDiseases(@Valid ExperimentSurveyFamilyDiseasesSaveReqVO createReqVO);

    /**
     * 更新实验组流调-亲属既往疾病
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyFamilyDiseases(@Valid ExperimentSurveyFamilyDiseasesSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-亲属既往疾病
     *
     * @param id 编号
     */
    void deleteExperimentSurveyFamilyDiseases(Long id);

    /**
     * 获得实验组流调-亲属既往疾病
     *
     * @param id 编号
     * @return 实验组流调-亲属既往疾病
     */
    ExperimentSurveyFamilyDiseasesDO getExperimentSurveyFamilyDiseases(Long id);

    /**
     * 获得实验组流调-亲属既往疾病分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-亲属既往疾病分页
     */
    PageResult<ExperimentSurveyFamilyDiseasesDO> getExperimentSurveyFamilyDiseasesPage(ExperimentSurveyFamilyDiseasesPageReqVO pageReqVO);

}