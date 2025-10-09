package cn.iocoder.yudao.module.review.service.experimentexampastmedicalhistory;

import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-既往病史 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamPastMedicalHistoryService {

    /**
     * 创建实验组体检-既往病史
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamPastMedicalHistory(@Valid ExperimentExamPastMedicalHistorySaveReqVO createReqVO);

    /**
     * 更新实验组体检-既往病史
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamPastMedicalHistory(@Valid ExperimentExamPastMedicalHistorySaveReqVO updateReqVO);

    /**
     * 删除实验组体检-既往病史
     *
     * @param id 编号
     */
    void deleteExperimentExamPastMedicalHistory(Long id);

    /**
     * 获得实验组体检-既往病史
     *
     * @param id 编号
     * @return 实验组体检-既往病史
     */
    ExperimentExamPastMedicalHistoryDO getExperimentExamPastMedicalHistory(Long id);

    /**
     * 获得实验组体检-既往病史分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-既往病史分页
     */
    PageResult<ExperimentExamPastMedicalHistoryDO> getExperimentExamPastMedicalHistoryPage(ExperimentExamPastMedicalHistoryPageReqVO pageReqVO);

}