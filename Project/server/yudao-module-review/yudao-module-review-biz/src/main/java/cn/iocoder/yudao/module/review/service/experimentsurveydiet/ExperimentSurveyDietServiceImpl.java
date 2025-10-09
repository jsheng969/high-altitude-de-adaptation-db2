package cn.iocoder.yudao.module.review.service.experimentsurveydiet;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydiet.ExperimentSurveyDietDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveydiet.ExperimentSurveyDietMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-饮食习惯 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyDietServiceImpl implements ExperimentSurveyDietService {

    @Resource
    private ExperimentSurveyDietMapper experimentSurveyDietMapper;

    @Override
    public Long createExperimentSurveyDiet(ExperimentSurveyDietSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyDietDO experimentSurveyDiet = BeanUtils.toBean(createReqVO, ExperimentSurveyDietDO.class);
        experimentSurveyDietMapper.insert(experimentSurveyDiet);
        // 返回
        return experimentSurveyDiet.getId();
    }

    @Override
    public void updateExperimentSurveyDiet(ExperimentSurveyDietSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyDietExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyDietDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyDietDO.class);
        experimentSurveyDietMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyDietByPersonId(ExperimentSurveyDietSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyDietDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyDietDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyDietDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyDietDO.class);
        experimentSurveyDietMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyDiet(Long id) {
        // 校验存在
        validateExperimentSurveyDietExists(id);
        // 删除
        experimentSurveyDietMapper.deleteById(id);
    }

    private void validateExperimentSurveyDietExists(Long id) {
        if (experimentSurveyDietMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_DIET_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyDietDO getExperimentSurveyDiet(Long id) {
        return experimentSurveyDietMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyDietDO> getExperimentSurveyDietPage(ExperimentSurveyDietPageReqVO pageReqVO) {
        return experimentSurveyDietMapper.selectPage(pageReqVO);
    }

}