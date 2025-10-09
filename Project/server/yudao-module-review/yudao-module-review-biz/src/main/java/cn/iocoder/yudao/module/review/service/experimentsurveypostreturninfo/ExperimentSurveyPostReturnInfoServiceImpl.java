package cn.iocoder.yudao.module.review.service.experimentsurveypostreturninfo;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-返回后基础信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyPostReturnInfoServiceImpl implements ExperimentSurveyPostReturnInfoService {

    @Resource
    private ExperimentSurveyPostReturnInfoMapper experimentSurveyPostReturnInfoMapper;

    @Override
    public Long createExperimentSurveyPostReturnInfo(ExperimentSurveyPostReturnInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyPostReturnInfoDO experimentSurveyPostReturnInfo = BeanUtils.toBean(createReqVO, ExperimentSurveyPostReturnInfoDO.class);
        experimentSurveyPostReturnInfoMapper.insert(experimentSurveyPostReturnInfo);
        // 返回
        return experimentSurveyPostReturnInfo.getId();
    }

    @Override
    public void updateExperimentSurveyPostReturnInfo(ExperimentSurveyPostReturnInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyPostReturnInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyPostReturnInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPostReturnInfoDO.class);
        experimentSurveyPostReturnInfoMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyPostReturnInfoByPersonId(ExperimentSurveyPostReturnInfoSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyPostReturnInfoDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyPostReturnInfoDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyPostReturnInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPostReturnInfoDO.class);
        experimentSurveyPostReturnInfoMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyPostReturnInfo(Long id) {
        // 校验存在
        validateExperimentSurveyPostReturnInfoExists(id);
        // 删除
        experimentSurveyPostReturnInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyPostReturnInfoExists(Long id) {
        if (experimentSurveyPostReturnInfoMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_POST_RETURN_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyPostReturnInfoDO getExperimentSurveyPostReturnInfo(Long id) {
        return experimentSurveyPostReturnInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyPostReturnInfoDO> getExperimentSurveyPostReturnInfoPage(ExperimentSurveyPostReturnInfoPageReqVO pageReqVO) {
        return experimentSurveyPostReturnInfoMapper.selectPage(pageReqVO);
    }

}