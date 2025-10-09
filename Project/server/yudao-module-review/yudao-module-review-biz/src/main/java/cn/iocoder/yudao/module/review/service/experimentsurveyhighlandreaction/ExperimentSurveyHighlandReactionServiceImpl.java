package cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreaction;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-高原反应信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyHighlandReactionServiceImpl implements ExperimentSurveyHighlandReactionService {

    @Resource
    private ExperimentSurveyHighlandReactionMapper experimentSurveyHighlandReactionMapper;

    @Override
    public Long createExperimentSurveyHighlandReaction(ExperimentSurveyHighlandReactionSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyHighlandReactionDO experimentSurveyHighlandReaction = BeanUtils.toBean(createReqVO, ExperimentSurveyHighlandReactionDO.class);
        experimentSurveyHighlandReactionMapper.insert(experimentSurveyHighlandReaction);
        // 返回
        return experimentSurveyHighlandReaction.getId();
    }

    @Override
    public void updateExperimentSurveyHighlandReaction(ExperimentSurveyHighlandReactionSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyHighlandReactionExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyHighlandReactionDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandReactionDO.class);
        experimentSurveyHighlandReactionMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyHighlandReactionByPersonId(ExperimentSurveyHighlandReactionSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyHighlandReactionDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyHighlandReactionDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyHighlandReactionDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandReactionDO.class);
        experimentSurveyHighlandReactionMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyHighlandReaction(Long id) {
        // 校验存在
        validateExperimentSurveyHighlandReactionExists(id);
        // 删除
        experimentSurveyHighlandReactionMapper.deleteById(id);
    }

    private void validateExperimentSurveyHighlandReactionExists(Long id) {
        if (experimentSurveyHighlandReactionMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_HIGHLAND_REACTION_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyHighlandReactionDO getExperimentSurveyHighlandReaction(Long id) {
        return experimentSurveyHighlandReactionMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyHighlandReactionDO> getExperimentSurveyHighlandReactionPage(ExperimentSurveyHighlandReactionPageReqVO pageReqVO) {
        return experimentSurveyHighlandReactionMapper.selectPage(pageReqVO);
    }

}