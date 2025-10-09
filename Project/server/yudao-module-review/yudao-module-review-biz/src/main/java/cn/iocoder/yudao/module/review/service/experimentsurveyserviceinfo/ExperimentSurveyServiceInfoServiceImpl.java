package cn.iocoder.yudao.module.review.service.experimentsurveyserviceinfo;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-服役信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyServiceInfoServiceImpl implements ExperimentSurveyServiceInfoService {

    @Resource
    private ExperimentSurveyServiceInfoMapper experimentSurveyServiceInfoMapper;

    @Override
    public Long createExperimentSurveyServiceInfo(ExperimentSurveyServiceInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyServiceInfoDO experimentSurveyServiceInfo = BeanUtils.toBean(createReqVO, ExperimentSurveyServiceInfoDO.class);
        experimentSurveyServiceInfoMapper.insert(experimentSurveyServiceInfo);
        // 返回
        return experimentSurveyServiceInfo.getId();
    }

    @Override
    public void updateExperimentSurveyServiceInfo(ExperimentSurveyServiceInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyServiceInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyServiceInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyServiceInfoDO.class);
        experimentSurveyServiceInfoMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyServiceInfoByPersonId(ExperimentSurveyServiceInfoSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyServiceInfoDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyServiceInfoDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyServiceInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyServiceInfoDO.class);
        experimentSurveyServiceInfoMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyServiceInfo(Long id) {
        // 校验存在
        validateExperimentSurveyServiceInfoExists(id);
        // 删除
        experimentSurveyServiceInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyServiceInfoExists(Long id) {
        if (experimentSurveyServiceInfoMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_SERVICE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyServiceInfoDO getExperimentSurveyServiceInfo(Long id) {
        return experimentSurveyServiceInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyServiceInfoDO> getExperimentSurveyServiceInfoPage(ExperimentSurveyServiceInfoPageReqVO pageReqVO) {
        return experimentSurveyServiceInfoMapper.selectPage(pageReqVO);
    }

}