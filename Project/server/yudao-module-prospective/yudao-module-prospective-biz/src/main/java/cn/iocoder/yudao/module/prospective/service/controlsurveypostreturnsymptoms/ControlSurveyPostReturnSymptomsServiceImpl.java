package cn.iocoder.yudao.module.prospective.service.controlsurveypostreturnsymptoms;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-退役后返回平原1月内症状 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlSurveyPostReturnSymptomsServiceImpl implements ControlSurveyPostReturnSymptomsService {

    @Resource
    private ControlSurveyPostReturnSymptomsMapper controlSurveyPostReturnSymptomsMapper;

    @Override
    public Long createControlSurveyPostReturnSymptoms(ControlSurveyPostReturnSymptomsSaveReqVO createReqVO) {
        // 插入
        ControlSurveyPostReturnSymptomsDO controlSurveyPostReturnSymptoms = BeanUtils.toBean(createReqVO, ControlSurveyPostReturnSymptomsDO.class);
        controlSurveyPostReturnSymptomsMapper.insert(controlSurveyPostReturnSymptoms);
        // 返回
        return controlSurveyPostReturnSymptoms.getId();
    }

    @Override
    public void updateControlSurveyPostReturnSymptoms(ControlSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyPostReturnSymptomsExists(updateReqVO.getId());
        // 更新
        ControlSurveyPostReturnSymptomsDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyPostReturnSymptomsDO.class);
        controlSurveyPostReturnSymptomsMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyPostReturnSymptoms(Long id) {
        // 校验存在
        validateControlSurveyPostReturnSymptomsExists(id);
        // 删除
        controlSurveyPostReturnSymptomsMapper.deleteById(id);
    }

    private void validateControlSurveyPostReturnSymptomsExists(Long id) {
        if (controlSurveyPostReturnSymptomsMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyPostReturnSymptomsDO getControlSurveyPostReturnSymptoms(Long id) {
        return controlSurveyPostReturnSymptomsMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyPostReturnSymptomsDO> getControlSurveyPostReturnSymptomsPage(ControlSurveyPostReturnSymptomsPageReqVO pageReqVO) {
        return controlSurveyPostReturnSymptomsMapper.selectPage(pageReqVO);
    }

}