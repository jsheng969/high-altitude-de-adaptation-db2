package cn.iocoder.yudao.module.review.service.experimentsurveysleep;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysleep.ExperimentSurveySleepDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveysleep.ExperimentSurveySleepMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-睡眠信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveySleepServiceImpl implements ExperimentSurveySleepService {

    @Resource
    private ExperimentSurveySleepMapper experimentSurveySleepMapper;

    @Override
    public Long createExperimentSurveySleep(ExperimentSurveySleepSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveySleepDO experimentSurveySleep = BeanUtils.toBean(createReqVO, ExperimentSurveySleepDO.class);
        experimentSurveySleepMapper.insert(experimentSurveySleep);
        // 返回
        return experimentSurveySleep.getId();
    }

    @Override
    public void updateExperimentSurveySleep(ExperimentSurveySleepSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveySleepExists(updateReqVO.getId());
        // 更新
        ExperimentSurveySleepDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySleepDO.class);
        experimentSurveySleepMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveySleepByPersonId(ExperimentSurveySleepSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveySleepDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveySleepDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveySleepDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySleepDO.class);
        experimentSurveySleepMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveySleep(Long id) {
        // 校验存在
        validateExperimentSurveySleepExists(id);
        // 删除
        experimentSurveySleepMapper.deleteById(id);
    }

    private void validateExperimentSurveySleepExists(Long id) {
        if (experimentSurveySleepMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_SLEEP_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveySleepDO getExperimentSurveySleep(Long id) {
        return experimentSurveySleepMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveySleepDO> getExperimentSurveySleepPage(ExperimentSurveySleepPageReqVO pageReqVO) {
        return experimentSurveySleepMapper.selectPage(pageReqVO);
    }

}