package cn.iocoder.yudao.module.prospective.service.controlsurveyscoresummary;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveyscoresummary.ControlSurveyScoreSummaryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveyscoresummary.ControlSurveyScoreSummaryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-评分总数统计 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlSurveyScoreSummaryServiceImpl implements ControlSurveyScoreSummaryService {

    @Resource
    private ControlSurveyScoreSummaryMapper controlSurveyScoreSummaryMapper;

    @Override
    public Long createControlSurveyScoreSummary(ControlSurveyScoreSummarySaveReqVO createReqVO) {
        // 插入
        ControlSurveyScoreSummaryDO controlSurveyScoreSummary = BeanUtils.toBean(createReqVO, ControlSurveyScoreSummaryDO.class);
        controlSurveyScoreSummaryMapper.insert(controlSurveyScoreSummary);
        // 返回
        return controlSurveyScoreSummary.getId();
    }

    @Override
    public void updateControlSurveyScoreSummary(ControlSurveyScoreSummarySaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyScoreSummaryExists(updateReqVO.getId());
        // 更新
        ControlSurveyScoreSummaryDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyScoreSummaryDO.class);
        controlSurveyScoreSummaryMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyScoreSummary(Long id) {
        // 校验存在
        validateControlSurveyScoreSummaryExists(id);
        // 删除
        controlSurveyScoreSummaryMapper.deleteById(id);
    }

    private void validateControlSurveyScoreSummaryExists(Long id) {
        if (controlSurveyScoreSummaryMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_SCORE_SUMMARY_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyScoreSummaryDO getControlSurveyScoreSummary(Long id) {
        return controlSurveyScoreSummaryMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyScoreSummaryDO> getControlSurveyScoreSummaryPage(ControlSurveyScoreSummaryPageReqVO pageReqVO) {
        return controlSurveyScoreSummaryMapper.selectPage(pageReqVO);
    }

}