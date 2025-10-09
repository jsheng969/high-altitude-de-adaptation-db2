package cn.iocoder.yudao.module.prospective.service.controlsurveymissionprogresssurvey;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 对照组流调-推进情况调查 Service 接口
 *
 * @author 管理员
 */
public interface ControlSurveyMissionProgressSurveyService {

    /**
     * 创建对照组流调-推进情况调查
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyMissionProgressSurvey(@Valid ControlSurveyMissionProgressSurveySaveReqVO createReqVO);

    /**
     * 更新对照组流调-推进情况调查
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyMissionProgressSurvey(@Valid ControlSurveyMissionProgressSurveySaveReqVO updateReqVO);

    /**
     * 删除对照组流调-推进情况调查
     *
     * @param id 编号
     */
    void deleteControlSurveyMissionProgressSurvey(Long id);

    /**
     * 获得对照组流调-推进情况调查
     *
     * @param id 编号
     * @return 对照组流调-推进情况调查
     */
    ControlSurveyMissionProgressSurveyDO getControlSurveyMissionProgressSurvey(Long id);

    /**
     * 获得对照组流调-推进情况调查分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-推进情况调查分页
     */
    PageResult<ControlSurveyMissionProgressSurveyDO> getControlSurveyMissionProgressSurveyPage(ControlSurveyMissionProgressSurveyPageReqVO pageReqVO);

}