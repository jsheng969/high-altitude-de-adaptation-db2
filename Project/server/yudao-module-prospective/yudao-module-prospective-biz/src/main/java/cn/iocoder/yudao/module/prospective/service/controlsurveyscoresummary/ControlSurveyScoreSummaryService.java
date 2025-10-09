package cn.iocoder.yudao.module.prospective.service.controlsurveyscoresummary;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveyscoresummary.ControlSurveyScoreSummaryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 对照组流调-评分总数统计 Service 接口
 *
 * @author 管理员
 */
public interface ControlSurveyScoreSummaryService {

    /**
     * 创建对照组流调-评分总数统计
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyScoreSummary(@Valid ControlSurveyScoreSummarySaveReqVO createReqVO);

    /**
     * 更新对照组流调-评分总数统计
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyScoreSummary(@Valid ControlSurveyScoreSummarySaveReqVO updateReqVO);

    /**
     * 删除对照组流调-评分总数统计
     *
     * @param id 编号
     */
    void deleteControlSurveyScoreSummary(Long id);

    /**
     * 获得对照组流调-评分总数统计
     *
     * @param id 编号
     * @return 对照组流调-评分总数统计
     */
    ControlSurveyScoreSummaryDO getControlSurveyScoreSummary(Long id);

    /**
     * 获得对照组流调-评分总数统计分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-评分总数统计分页
     */
    PageResult<ControlSurveyScoreSummaryDO> getControlSurveyScoreSummaryPage(ControlSurveyScoreSummaryPageReqVO pageReqVO);

}