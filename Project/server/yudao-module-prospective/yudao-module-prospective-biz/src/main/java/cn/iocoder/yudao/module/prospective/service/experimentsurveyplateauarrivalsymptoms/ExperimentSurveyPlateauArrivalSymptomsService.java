package cn.iocoder.yudao.module.prospective.service.experimentsurveyplateauarrivalsymptoms;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 抵达高原后症状记录 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyPlateauArrivalSymptomsService {

    /**
     * 创建抵达高原后症状记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyPlateauArrivalSymptoms(@Valid ExperimentSurveyPlateauArrivalSymptomsSaveReqVO createReqVO);

    /**
     * 更新抵达高原后症状记录
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyPlateauArrivalSymptoms(@Valid ExperimentSurveyPlateauArrivalSymptomsSaveReqVO updateReqVO);

    /**
     * 删除抵达高原后症状记录
     *
     * @param id 编号
     */
    void deleteExperimentSurveyPlateauArrivalSymptoms(Long id);

    /**
     * 获得抵达高原后症状记录
     *
     * @param id 编号
     * @return 抵达高原后症状记录
     */
    ExperimentSurveyPlateauArrivalSymptomsDO getExperimentSurveyPlateauArrivalSymptoms(Long id);

    /**
     * 获得抵达高原后症状记录分页
     *
     * @param pageReqVO 分页查询
     * @return 抵达高原后症状记录分页
     */
    PageResult<ExperimentSurveyPlateauArrivalSymptomsDO> getExperimentSurveyPlateauArrivalSymptomsPage(ExperimentSurveyPlateauArrivalSymptomsPageReqVO pageReqVO);

}