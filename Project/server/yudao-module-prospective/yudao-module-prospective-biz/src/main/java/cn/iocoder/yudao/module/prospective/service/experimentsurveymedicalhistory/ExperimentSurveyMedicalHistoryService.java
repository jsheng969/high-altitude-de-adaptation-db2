package cn.iocoder.yudao.module.prospective.service.experimentsurveymedicalhistory;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 既往疾病史 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyMedicalHistoryService {

    /**
     * 创建既往疾病史
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyMedicalHistory(@Valid ExperimentSurveyMedicalHistorySaveReqVO createReqVO);

    /**
     * 更新既往疾病史
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyMedicalHistory(@Valid ExperimentSurveyMedicalHistorySaveReqVO updateReqVO);

    /**
     * 删除既往疾病史
     *
     * @param id 编号
     */
    void deleteExperimentSurveyMedicalHistory(Long id);

    /**
     * 获得既往疾病史
     *
     * @param id 编号
     * @return 既往疾病史
     */
    ExperimentSurveyMedicalHistoryDO getExperimentSurveyMedicalHistory(Long id);

    /**
     * 获得既往疾病史分页
     *
     * @param pageReqVO 分页查询
     * @return 既往疾病史分页
     */
    PageResult<ExperimentSurveyMedicalHistoryDO> getExperimentSurveyMedicalHistoryPage(ExperimentSurveyMedicalHistoryPageReqVO pageReqVO);

}