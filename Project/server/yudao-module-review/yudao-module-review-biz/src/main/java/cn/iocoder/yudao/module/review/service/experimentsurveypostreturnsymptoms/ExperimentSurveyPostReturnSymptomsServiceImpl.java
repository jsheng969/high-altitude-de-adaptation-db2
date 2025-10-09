package cn.iocoder.yudao.module.review.service.experimentsurveypostreturnsymptoms;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.mapstruct.ap.internal.model.assignment.UpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-退役后返回平原1月内症状 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyPostReturnSymptomsServiceImpl implements ExperimentSurveyPostReturnSymptomsService {

    @Resource
    private ExperimentSurveyPostReturnSymptomsMapper experimentSurveyPostReturnSymptomsMapper;

    @Override
    public Long createExperimentSurveyPostReturnSymptoms(ExperimentSurveyPostReturnSymptomsSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyPostReturnSymptomsDO experimentSurveyPostReturnSymptoms = BeanUtils.toBean(createReqVO, ExperimentSurveyPostReturnSymptomsDO.class);
        experimentSurveyPostReturnSymptomsMapper.insert(experimentSurveyPostReturnSymptoms);
        // 返回
        return experimentSurveyPostReturnSymptoms.getId();
    }

    @Override
    public void updateExperimentSurveyPostReturnSymptoms(ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyPostReturnSymptomsExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyPostReturnSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPostReturnSymptomsDO.class);
        experimentSurveyPostReturnSymptomsMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyPostReturnSymptomsByPersonId(ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyPostReturnSymptomsDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyPostReturnSymptomsDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyPostReturnSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPostReturnSymptomsDO.class);
        experimentSurveyPostReturnSymptomsMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyPostReturnSymptoms(Long id) {
        // 校验存在
        validateExperimentSurveyPostReturnSymptomsExists(id);
        // 删除
        experimentSurveyPostReturnSymptomsMapper.deleteById(id);
    }

    private void validateExperimentSurveyPostReturnSymptomsExists(Long id) {
        if (experimentSurveyPostReturnSymptomsMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyPostReturnSymptomsDO getExperimentSurveyPostReturnSymptoms(Long id) {
        return experimentSurveyPostReturnSymptomsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyPostReturnSymptomsDO> getExperimentSurveyPostReturnSymptomsPage(ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO) {
        return experimentSurveyPostReturnSymptomsMapper.selectPage(pageReqVO);
    }

}