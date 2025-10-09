package cn.iocoder.yudao.module.prospective.service.experimentsurveyscoresummary;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 评分总数统计 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyScoreSummaryServiceImpl implements ExperimentSurveyScoreSummaryService {

    @Resource
    private ExperimentSurveyScoreSummaryMapper experimentSurveyScoreSummaryMapper;

    @Override
    public Long createExperimentSurveyScoreSummary(ExperimentSurveyScoreSummarySaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyScoreSummaryDO experimentSurveyScoreSummary = BeanUtils.toBean(createReqVO, ExperimentSurveyScoreSummaryDO.class);
        experimentSurveyScoreSummaryMapper.insert(experimentSurveyScoreSummary);
        // 返回
        return experimentSurveyScoreSummary.getId();
    }

    @Override
    public void updateExperimentSurveyScoreSummary(ExperimentSurveyScoreSummarySaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyScoreSummaryExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyScoreSummaryDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyScoreSummaryDO.class);
        experimentSurveyScoreSummaryMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyScoreSummaryByWrapper(ExperimentSurveyScoreSummarySaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyScoreSummaryDO> updateWrapper) {
        // 更新
        ExperimentSurveyScoreSummaryDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyScoreSummaryDO.class);
        experimentSurveyScoreSummaryMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyScoreSummary(Long id) {
        // 校验存在
        validateExperimentSurveyScoreSummaryExists(id);
        // 删除
        experimentSurveyScoreSummaryMapper.deleteById(id);
    }

    private void validateExperimentSurveyScoreSummaryExists(Long id) {
        if (experimentSurveyScoreSummaryMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_SCORE_SUMMARY_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyScoreSummaryDO getExperimentSurveyScoreSummary(Long id) {
        return experimentSurveyScoreSummaryMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyScoreSummaryDO> getExperimentSurveyScoreSummaryPage(ExperimentSurveyScoreSummaryPageReqVO pageReqVO) {
        return experimentSurveyScoreSummaryMapper.selectPage(pageReqVO);
    }

}