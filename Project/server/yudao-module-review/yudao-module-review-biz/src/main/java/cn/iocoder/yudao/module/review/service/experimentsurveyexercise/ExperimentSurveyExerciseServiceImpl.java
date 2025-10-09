package cn.iocoder.yudao.module.review.service.experimentsurveyexercise;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyexercise.ExperimentSurveyExerciseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyexercise.ExperimentSurveyExerciseMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-体育锻炼信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyExerciseServiceImpl implements ExperimentSurveyExerciseService {

    @Resource
    private ExperimentSurveyExerciseMapper experimentSurveyExerciseMapper;

    @Override
    public Long createExperimentSurveyExercise(ExperimentSurveyExerciseSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyExerciseDO experimentSurveyExercise = BeanUtils.toBean(createReqVO, ExperimentSurveyExerciseDO.class);
        experimentSurveyExerciseMapper.insert(experimentSurveyExercise);
        // 返回
        return experimentSurveyExercise.getId();
    }

    @Override
    public void updateExperimentSurveyExercise(ExperimentSurveyExerciseSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyExerciseExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyExerciseDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyExerciseDO.class);
        experimentSurveyExerciseMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyExerciseByPersonId(ExperimentSurveyExerciseSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyExerciseDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyExerciseDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyExerciseDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyExerciseDO.class);
        experimentSurveyExerciseMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyExercise(Long id) {
        // 校验存在
        validateExperimentSurveyExerciseExists(id);
        // 删除
        experimentSurveyExerciseMapper.deleteById(id);
    }

    private void validateExperimentSurveyExerciseExists(Long id) {
        if (experimentSurveyExerciseMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_EXERCISE_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyExerciseDO getExperimentSurveyExercise(Long id) {
        return experimentSurveyExerciseMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyExerciseDO> getExperimentSurveyExercisePage(ExperimentSurveyExercisePageReqVO pageReqVO) {
        return experimentSurveyExerciseMapper.selectPage(pageReqVO);
    }

}