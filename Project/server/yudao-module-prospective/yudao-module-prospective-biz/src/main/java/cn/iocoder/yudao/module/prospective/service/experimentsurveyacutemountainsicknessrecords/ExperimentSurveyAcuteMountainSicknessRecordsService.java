package cn.iocoder.yudao.module.prospective.service.experimentsurveyacutemountainsicknessrecords;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 高原急性高山病记录 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyAcuteMountainSicknessRecordsService {

    /**
     * 创建高原急性高山病记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyAcuteMountainSicknessRecords(@Valid ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO createReqVO);

    /**
     * 更新高原急性高山病记录
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyAcuteMountainSicknessRecords(@Valid ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO updateReqVO);

    /**
     * 删除高原急性高山病记录
     *
     * @param id 编号
     */
    void deleteExperimentSurveyAcuteMountainSicknessRecords(Long id);

    /**
     * 获得高原急性高山病记录
     *
     * @param id 编号
     * @return 高原急性高山病记录
     */
    ExperimentSurveyAcuteMountainSicknessRecordsDO getExperimentSurveyAcuteMountainSicknessRecords(Long id);

    /**
     * 获得高原急性高山病记录分页
     *
     * @param pageReqVO 分页查询
     * @return 高原急性高山病记录分页
     */
    PageResult<ExperimentSurveyAcuteMountainSicknessRecordsDO> getExperimentSurveyAcuteMountainSicknessRecordsPage(ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO pageReqVO);

}