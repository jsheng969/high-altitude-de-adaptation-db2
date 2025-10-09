package cn.iocoder.yudao.module.review.service.experimentsurveydrinking;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydrinking.ExperimentSurveyDrinkingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveydrinking.ExperimentSurveyDrinkingMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-饮酒情况 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyDrinkingServiceImpl implements ExperimentSurveyDrinkingService {

    @Resource
    private ExperimentSurveyDrinkingMapper experimentSurveyDrinkingMapper;

    @Override
    public Long createExperimentSurveyDrinking(ExperimentSurveyDrinkingSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyDrinkingDO experimentSurveyDrinking = BeanUtils.toBean(createReqVO, ExperimentSurveyDrinkingDO.class);
        experimentSurveyDrinkingMapper.insert(experimentSurveyDrinking);
        // 返回
        return experimentSurveyDrinking.getId();
    }

    @Override
    public void updateExperimentSurveyDrinking(ExperimentSurveyDrinkingSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyDrinkingExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyDrinkingDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyDrinkingDO.class);
        experimentSurveyDrinkingMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyDrinkingByPersonId(ExperimentSurveyDrinkingSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyDrinkingDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyDrinkingDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyDrinkingDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyDrinkingDO.class);
        experimentSurveyDrinkingMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyDrinking(Long id) {
        // 校验存在
        validateExperimentSurveyDrinkingExists(id);
        // 删除
        experimentSurveyDrinkingMapper.deleteById(id);
    }

    private void validateExperimentSurveyDrinkingExists(Long id) {
        if (experimentSurveyDrinkingMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_DRINKING_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyDrinkingDO getExperimentSurveyDrinking(Long id) {
        return experimentSurveyDrinkingMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyDrinkingDO> getExperimentSurveyDrinkingPage(ExperimentSurveyDrinkingPageReqVO pageReqVO) {
        return experimentSurveyDrinkingMapper.selectPage(pageReqVO);
    }

}