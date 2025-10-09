package cn.iocoder.yudao.module.review.service.controlsurveypastdiseases;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveypastdiseases.ControlSurveyPastDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlsurveypastdiseases.ControlSurveyPastDiseasesMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-既往疾病 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlSurveyPastDiseasesServiceImpl implements ControlSurveyPastDiseasesService {

    @Resource
    private ControlSurveyPastDiseasesMapper controlSurveyPastDiseasesMapper;

    @Override
    public Long createControlSurveyPastDiseases(ControlSurveyPastDiseasesSaveReqVO createReqVO) {
        // 插入
        ControlSurveyPastDiseasesDO controlSurveyPastDiseases = BeanUtils.toBean(createReqVO, ControlSurveyPastDiseasesDO.class);
        controlSurveyPastDiseasesMapper.insert(controlSurveyPastDiseases);
        // 返回
        return controlSurveyPastDiseases.getId();
    }

    @Override
    public void updateControlSurveyPastDiseases(ControlSurveyPastDiseasesSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyPastDiseasesExists(updateReqVO.getId());
        // 更新
        ControlSurveyPastDiseasesDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyPastDiseasesDO.class);
        controlSurveyPastDiseasesMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyPastDiseases(Long id) {
        // 校验存在
        validateControlSurveyPastDiseasesExists(id);
        // 删除
        controlSurveyPastDiseasesMapper.deleteById(id);
    }

    private void validateControlSurveyPastDiseasesExists(Long id) {
        if (controlSurveyPastDiseasesMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_PAST_DISEASES_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyPastDiseasesDO getControlSurveyPastDiseases(Long id) {
        return controlSurveyPastDiseasesMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyPastDiseasesDO> getControlSurveyPastDiseasesPage(ControlSurveyPastDiseasesPageReqVO pageReqVO) {
        return controlSurveyPastDiseasesMapper.selectPage(pageReqVO);
    }

}