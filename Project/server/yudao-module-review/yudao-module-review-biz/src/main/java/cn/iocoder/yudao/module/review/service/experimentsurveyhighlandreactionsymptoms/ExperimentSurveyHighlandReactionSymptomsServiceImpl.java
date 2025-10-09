package cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreactionsymptoms;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-高原反应症状 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyHighlandReactionSymptomsServiceImpl implements ExperimentSurveyHighlandReactionSymptomsService {

    @Resource
    private ExperimentSurveyHighlandReactionSymptomsMapper experimentSurveyHighlandReactionSymptomsMapper;

    @Override
    public Long createExperimentSurveyHighlandReactionSymptoms(ExperimentSurveyHighlandReactionSymptomsSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyHighlandReactionSymptomsDO experimentSurveyHighlandReactionSymptoms = BeanUtils.toBean(createReqVO, ExperimentSurveyHighlandReactionSymptomsDO.class);
        experimentSurveyHighlandReactionSymptomsMapper.insert(experimentSurveyHighlandReactionSymptoms);
        // 返回
        return experimentSurveyHighlandReactionSymptoms.getId();
    }

    @Override
    public void updateExperimentSurveyHighlandReactionSymptoms(ExperimentSurveyHighlandReactionSymptomsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyHighlandReactionSymptomsExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyHighlandReactionSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandReactionSymptomsDO.class);
        experimentSurveyHighlandReactionSymptomsMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyHighlandReactionSymptomsByPersonId(ExperimentSurveyHighlandReactionSymptomsSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyHighlandReactionSymptomsDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyHighlandReactionSymptomsDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyHighlandReactionSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandReactionSymptomsDO.class);
        experimentSurveyHighlandReactionSymptomsMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyHighlandReactionSymptoms(Long id) {
        // 校验存在
        validateExperimentSurveyHighlandReactionSymptomsExists(id);
        // 删除
        experimentSurveyHighlandReactionSymptomsMapper.deleteById(id);
    }

    private void validateExperimentSurveyHighlandReactionSymptomsExists(Long id) {
        if (experimentSurveyHighlandReactionSymptomsMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_HIGHLAND_REACTION_SYMPTOMS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyHighlandReactionSymptomsDO getExperimentSurveyHighlandReactionSymptoms(Long id) {
        return experimentSurveyHighlandReactionSymptomsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyHighlandReactionSymptomsDO> getExperimentSurveyHighlandReactionSymptomsPage(ExperimentSurveyHighlandReactionSymptomsPageReqVO pageReqVO) {
        return experimentSurveyHighlandReactionSymptomsMapper.selectPage(pageReqVO);
    }

}