package cn.iocoder.yudao.module.prospective.service.experimentsurveymissionprogresssurvey;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 推进情况调查 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyMissionProgressSurveyServiceImpl implements ExperimentSurveyMissionProgressSurveyService {

    @Resource
    private ExperimentSurveyMissionProgressSurveyMapper experimentSurveyMissionProgressSurveyMapper;

    @Override
    public Long createExperimentSurveyMissionProgressSurvey(ExperimentSurveyMissionProgressSurveySaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyMissionProgressSurveyDO experimentSurveyMissionProgressSurvey = BeanUtils.toBean(createReqVO, ExperimentSurveyMissionProgressSurveyDO.class);
        experimentSurveyMissionProgressSurveyMapper.insert(experimentSurveyMissionProgressSurvey);
        // 返回
        return experimentSurveyMissionProgressSurvey.getId();
    }

    @Override
    public void updateExperimentSurveyMissionProgressSurvey(ExperimentSurveyMissionProgressSurveySaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyMissionProgressSurveyExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyMissionProgressSurveyDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyMissionProgressSurveyDO.class);
        experimentSurveyMissionProgressSurveyMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyMissionProgressSurveyByWrapper(ExperimentSurveyMissionProgressSurveySaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyMissionProgressSurveyDO> updateWrapper) {
        // 更新
        ExperimentSurveyMissionProgressSurveyDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyMissionProgressSurveyDO.class);
        experimentSurveyMissionProgressSurveyMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyMissionProgressSurvey(Long id) {
        // 校验存在
        validateExperimentSurveyMissionProgressSurveyExists(id);
        // 删除
        experimentSurveyMissionProgressSurveyMapper.deleteById(id);
    }

    private void validateExperimentSurveyMissionProgressSurveyExists(Long id) {
        if (experimentSurveyMissionProgressSurveyMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_MISSION_PROGRESS_SURVEY_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyMissionProgressSurveyDO getExperimentSurveyMissionProgressSurvey(Long id) {
        return experimentSurveyMissionProgressSurveyMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyMissionProgressSurveyDO> getExperimentSurveyMissionProgressSurveyPage(ExperimentSurveyMissionProgressSurveyPageReqVO pageReqVO) {
        return experimentSurveyMissionProgressSurveyMapper.selectPage(pageReqVO);
    }

}