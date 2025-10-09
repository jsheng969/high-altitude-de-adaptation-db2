package cn.iocoder.yudao.module.prospective.service.controlsurveymissionprogresssurvey;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-推进情况调查 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlSurveyMissionProgressSurveyServiceImpl implements ControlSurveyMissionProgressSurveyService {

    @Resource
    private ControlSurveyMissionProgressSurveyMapper controlSurveyMissionProgressSurveyMapper;

    @Override
    public Long createControlSurveyMissionProgressSurvey(ControlSurveyMissionProgressSurveySaveReqVO createReqVO) {
        // 插入
        ControlSurveyMissionProgressSurveyDO controlSurveyMissionProgressSurvey = BeanUtils.toBean(createReqVO, ControlSurveyMissionProgressSurveyDO.class);
        controlSurveyMissionProgressSurveyMapper.insert(controlSurveyMissionProgressSurvey);
        // 返回
        return controlSurveyMissionProgressSurvey.getId();
    }

    @Override
    public void updateControlSurveyMissionProgressSurvey(ControlSurveyMissionProgressSurveySaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyMissionProgressSurveyExists(updateReqVO.getId());
        // 更新
        ControlSurveyMissionProgressSurveyDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyMissionProgressSurveyDO.class);
        controlSurveyMissionProgressSurveyMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyMissionProgressSurvey(Long id) {
        // 校验存在
        validateControlSurveyMissionProgressSurveyExists(id);
        // 删除
        controlSurveyMissionProgressSurveyMapper.deleteById(id);
    }

    private void validateControlSurveyMissionProgressSurveyExists(Long id) {
        if (controlSurveyMissionProgressSurveyMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_MISSION_PROGRESS_SURVEY_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyMissionProgressSurveyDO getControlSurveyMissionProgressSurvey(Long id) {
        return controlSurveyMissionProgressSurveyMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyMissionProgressSurveyDO> getControlSurveyMissionProgressSurveyPage(ControlSurveyMissionProgressSurveyPageReqVO pageReqVO) {
        return controlSurveyMissionProgressSurveyMapper.selectPage(pageReqVO);
    }

}