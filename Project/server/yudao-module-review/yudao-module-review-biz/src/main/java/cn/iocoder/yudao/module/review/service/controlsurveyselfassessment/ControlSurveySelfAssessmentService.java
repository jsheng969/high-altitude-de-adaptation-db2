package cn.iocoder.yudao.module.review.service.controlsurveyselfassessment;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyselfassessment.ControlSurveySelfAssessmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组流调-自我评价 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlSurveySelfAssessmentService {

    /**
     * 创建对照组流调-自我评价
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveySelfAssessment(@Valid ControlSurveySelfAssessmentSaveReqVO createReqVO);

    /**
     * 更新对照组流调-自我评价
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveySelfAssessment(@Valid ControlSurveySelfAssessmentSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-自我评价
     *
     * @param id 编号
     */
    void deleteControlSurveySelfAssessment(Long id);

    /**
     * 获得对照组流调-自我评价
     *
     * @param id 编号
     * @return 对照组流调-自我评价
     */
    ControlSurveySelfAssessmentDO getControlSurveySelfAssessment(Long id);

    /**
     * 获得对照组流调-自我评价分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-自我评价分页
     */
    PageResult<ControlSurveySelfAssessmentDO> getControlSurveySelfAssessmentPage(ControlSurveySelfAssessmentPageReqVO pageReqVO);

}