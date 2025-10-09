package cn.iocoder.yudao.module.prospective.service.experimentsurveyselfassessment;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyselfassessment.ProspectiveExperimentSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 自我评价 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveySelfAssessmentService {

    /**
     * 创建自我评价
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveySelfAssessment(@Valid ExperimentSurveySelfAssessmentSaveReqVO createReqVO);

    /**
     * 更新自我评价
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveySelfAssessment(@Valid ExperimentSurveySelfAssessmentSaveReqVO updateReqVO);

    /**
     * 删除自我评价
     *
     * @param id 编号
     */
    void deleteExperimentSurveySelfAssessment(Long id);

    /**
     * 获得自我评价
     *
     * @param id 编号
     * @return 自我评价
     */
    ProspectiveExperimentSurveySelfAssessmentDO getExperimentSurveySelfAssessment(Long id);

    /**
     * 获得自我评价分页
     *
     * @param pageReqVO 分页查询
     * @return 自我评价分页
     */
    PageResult<ProspectiveExperimentSurveySelfAssessmentDO> getExperimentSurveySelfAssessmentPage(ExperimentSurveySelfAssessmentPageReqVO pageReqVO);

}