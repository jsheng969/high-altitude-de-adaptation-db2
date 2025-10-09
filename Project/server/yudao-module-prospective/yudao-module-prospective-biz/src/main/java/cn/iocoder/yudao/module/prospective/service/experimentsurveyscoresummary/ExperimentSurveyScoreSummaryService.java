package cn.iocoder.yudao.module.prospective.service.experimentsurveyscoresummary;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

/**
 * 评分总数统计 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyScoreSummaryService {

    /**
     * 创建评分总数统计
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyScoreSummary(@Valid ExperimentSurveyScoreSummarySaveReqVO createReqVO);

    /**
     * 更新评分总数统计
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyScoreSummary(@Valid ExperimentSurveyScoreSummarySaveReqVO updateReqVO);
    void updateExperimentSurveyScoreSummaryByWrapper(@Valid ExperimentSurveyScoreSummarySaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyScoreSummaryDO> updateWrapper);

    /**
     * 删除评分总数统计
     *
     * @param id 编号
     */
    void deleteExperimentSurveyScoreSummary(Long id);

    /**
     * 获得评分总数统计
     *
     * @param id 编号
     * @return 评分总数统计
     */
    ExperimentSurveyScoreSummaryDO getExperimentSurveyScoreSummary(Long id);

    /**
     * 获得评分总数统计分页
     *
     * @param pageReqVO 分页查询
     * @return 评分总数统计分页
     */
    PageResult<ExperimentSurveyScoreSummaryDO> getExperimentSurveyScoreSummaryPage(ExperimentSurveyScoreSummaryPageReqVO pageReqVO);

}