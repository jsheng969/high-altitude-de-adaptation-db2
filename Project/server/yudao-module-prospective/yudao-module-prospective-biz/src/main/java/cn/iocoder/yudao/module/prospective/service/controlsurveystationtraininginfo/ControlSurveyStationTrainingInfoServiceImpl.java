package cn.iocoder.yudao.module.prospective.service.controlsurveystationtraininginfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-驻训信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlSurveyStationTrainingInfoServiceImpl implements ControlSurveyStationTrainingInfoService {

    @Resource
    private ControlSurveyStationTrainingInfoMapper controlSurveyStationTrainingInfoMapper;

    @Override
    public Long createControlSurveyStationTrainingInfo(ControlSurveyStationTrainingInfoSaveReqVO createReqVO) {
        // 插入
        ControlSurveyStationTrainingInfoDO controlSurveyStationTrainingInfo = BeanUtils.toBean(createReqVO, ControlSurveyStationTrainingInfoDO.class);
        controlSurveyStationTrainingInfoMapper.insert(controlSurveyStationTrainingInfo);
        // 返回
        return controlSurveyStationTrainingInfo.getId();
    }

    @Override
    public void updateControlSurveyStationTrainingInfo(ControlSurveyStationTrainingInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyStationTrainingInfoExists(updateReqVO.getId());
        // 更新
        ControlSurveyStationTrainingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyStationTrainingInfoDO.class);
        controlSurveyStationTrainingInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyStationTrainingInfo(Long id) {
        // 校验存在
        validateControlSurveyStationTrainingInfoExists(id);
        // 删除
        controlSurveyStationTrainingInfoMapper.deleteById(id);
    }

    private void validateControlSurveyStationTrainingInfoExists(Long id) {
        if (controlSurveyStationTrainingInfoMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_STATION_TRAINING_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyStationTrainingInfoDO getControlSurveyStationTrainingInfo(Long id) {
        return controlSurveyStationTrainingInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyStationTrainingInfoDO> getControlSurveyStationTrainingInfoPage(ControlSurveyStationTrainingInfoPageReqVO pageReqVO) {
        return controlSurveyStationTrainingInfoMapper.selectPage(pageReqVO);
    }

}