package cn.iocoder.yudao.module.review.service.experimentsurveysmoking;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysmoking.ExperimentSurveySmokingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveysmoking.ExperimentSurveySmokingMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-吸烟情况 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveySmokingServiceImpl implements ExperimentSurveySmokingService {

    @Resource
    private ExperimentSurveySmokingMapper experimentSurveySmokingMapper;

    @Override
    public Long createExperimentSurveySmoking(ExperimentSurveySmokingSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveySmokingDO experimentSurveySmoking = BeanUtils.toBean(createReqVO, ExperimentSurveySmokingDO.class);
        experimentSurveySmokingMapper.insert(experimentSurveySmoking);
        // 返回
        return experimentSurveySmoking.getId();
    }

    @Override
    public void updateExperimentSurveySmoking(ExperimentSurveySmokingSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveySmokingExists(updateReqVO.getId());
        // 更新
        ExperimentSurveySmokingDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySmokingDO.class);
        experimentSurveySmokingMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveySmokingByPersonId(ExperimentSurveySmokingSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveySmokingDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveySmokingDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveySmokingDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySmokingDO.class);
        experimentSurveySmokingMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveySmoking(Long id) {
        // 校验存在
        validateExperimentSurveySmokingExists(id);
        // 删除
        experimentSurveySmokingMapper.deleteById(id);
    }

    private void validateExperimentSurveySmokingExists(Long id) {
        if (experimentSurveySmokingMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_SMOKING_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveySmokingDO getExperimentSurveySmoking(Long id) {
        return experimentSurveySmokingMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveySmokingDO> getExperimentSurveySmokingPage(ExperimentSurveySmokingPageReqVO pageReqVO) {
        return experimentSurveySmokingMapper.selectPage(pageReqVO);
    }

}