package cn.iocoder.yudao.module.review.service.experimentsurveyselfassessment;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-自我评价 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveySelfAssessmentService {

    /**
     * 创建实验组流调-自我评价
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveySelfAssessment(@Valid ExperimentSurveySelfAssessmentSaveReqVO createReqVO);

    /**
     * 更新实验组流调-自我评价
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveySelfAssessment(@Valid ExperimentSurveySelfAssessmentSaveReqVO updateReqVO);

    void updateExperimentSurveySelfAssessmentByPersonId(@Valid ExperimentSurveySelfAssessmentSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-自我评价
     *
     * @param id 编号
     */
    void deleteExperimentSurveySelfAssessment(Long id);

    /**
     * 获得实验组流调-自我评价
     *
     * @param id 编号
     * @return 实验组流调-自我评价
     */
    ExperimentSurveySelfAssessmentDO getExperimentSurveySelfAssessment(Long id);

    /**
     * 获得实验组流调-自我评价分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-自我评价分页
     */
    PageResult<ExperimentSurveySelfAssessmentDO> getExperimentSurveySelfAssessmentPage(ExperimentSurveySelfAssessmentPageReqVO pageReqVO);

}