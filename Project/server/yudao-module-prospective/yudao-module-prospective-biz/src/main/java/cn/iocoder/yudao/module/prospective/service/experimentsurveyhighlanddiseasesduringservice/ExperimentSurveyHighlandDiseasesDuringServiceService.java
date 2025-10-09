package cn.iocoder.yudao.module.prospective.service.experimentsurveyhighlanddiseasesduringservice;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 抵达高原后有无新下疾病 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyHighlandDiseasesDuringServiceService {

    /**
     * 创建抵达高原后有无新下疾病
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyHighlandDiseasesDuringService(@Valid ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO createReqVO);

    /**
     * 更新抵达高原后有无新下疾病
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyHighlandDiseasesDuringService(@Valid ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO updateReqVO);

    /**
     * 删除抵达高原后有无新下疾病
     *
     * @param id 编号
     */
    void deleteExperimentSurveyHighlandDiseasesDuringService(Long id);

    /**
     * 获得抵达高原后有无新下疾病
     *
     * @param id 编号
     * @return 抵达高原后有无新下疾病
     */
    ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO getExperimentSurveyHighlandDiseasesDuringService(Long id);

    /**
     * 获得抵达高原后有无新下疾病分页
     *
     * @param pageReqVO 分页查询
     * @return 抵达高原后有无新下疾病分页
     */
    PageResult<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> getExperimentSurveyHighlandDiseasesDuringServicePage(ExperimentSurveyHighlandDiseasesDuringServicePageReqVO pageReqVO);

}