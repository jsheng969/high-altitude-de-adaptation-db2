package cn.iocoder.yudao.module.prospective.service.experimentsurveystationtraininginfo;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 驻训信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyStationTrainingInfoServiceImpl implements ExperimentSurveyStationTrainingInfoService {

    @Resource
    private ExperimentSurveyStationTrainingInfoMapper experimentSurveyStationTrainingInfoMapper;

    @Override
    public Long createExperimentSurveyStationTrainingInfo(ExperimentSurveyStationTrainingInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyStationTrainingInfoDO experimentSurveyStationTrainingInfo = BeanUtils.toBean(createReqVO, ExperimentSurveyStationTrainingInfoDO.class);
        experimentSurveyStationTrainingInfoMapper.insert(experimentSurveyStationTrainingInfo);
        // 返回
        return experimentSurveyStationTrainingInfo.getId();
    }

    @Override
    public void updateExperimentSurveyStationTrainingInfo(ExperimentSurveyStationTrainingInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyStationTrainingInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyStationTrainingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyStationTrainingInfoDO.class);
        experimentSurveyStationTrainingInfoMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyStationTrainingInfoByWrapper(ExperimentSurveyStationTrainingInfoSaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyStationTrainingInfoDO> updateWrapper) {
        // 更新
        ExperimentSurveyStationTrainingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyStationTrainingInfoDO.class);
        experimentSurveyStationTrainingInfoMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyStationTrainingInfo(Long id) {
        // 校验存在
        validateExperimentSurveyStationTrainingInfoExists(id);
        // 删除
        experimentSurveyStationTrainingInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyStationTrainingInfoExists(Long id) {
        if (experimentSurveyStationTrainingInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_STATION_TRAINING_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyStationTrainingInfoDO getExperimentSurveyStationTrainingInfo(Long id) {
        return experimentSurveyStationTrainingInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyStationTrainingInfoDO> getExperimentSurveyStationTrainingInfoPage(ExperimentSurveyStationTrainingInfoPageReqVO pageReqVO) {
        return experimentSurveyStationTrainingInfoMapper.selectPage(pageReqVO);
    }

}