package cn.iocoder.yudao.module.review.service.controlsurveyresidenceinfo;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyresidenceinfo.ControlSurveyResidenceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlsurveyresidenceinfo.ControlSurveyResidenceInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-旅居信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlSurveyResidenceInfoServiceImpl implements ControlSurveyResidenceInfoService {

    @Resource
    private ControlSurveyResidenceInfoMapper controlSurveyResidenceInfoMapper;

    @Override
    public Long createControlSurveyResidenceInfo(ControlSurveyResidenceInfoSaveReqVO createReqVO) {
        // 插入
        ControlSurveyResidenceInfoDO controlSurveyResidenceInfo = BeanUtils.toBean(createReqVO, ControlSurveyResidenceInfoDO.class);
        controlSurveyResidenceInfoMapper.insert(controlSurveyResidenceInfo);
        // 返回
        return controlSurveyResidenceInfo.getId();
    }

    @Override
    public void updateControlSurveyResidenceInfo(ControlSurveyResidenceInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyResidenceInfoExists(updateReqVO.getId());
        // 更新
        ControlSurveyResidenceInfoDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyResidenceInfoDO.class);
        controlSurveyResidenceInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyResidenceInfo(Long id) {
        // 校验存在
        validateControlSurveyResidenceInfoExists(id);
        // 删除
        controlSurveyResidenceInfoMapper.deleteById(id);
    }

    private void validateControlSurveyResidenceInfoExists(Long id) {
        if (controlSurveyResidenceInfoMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_RESIDENCE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyResidenceInfoDO getControlSurveyResidenceInfo(Long id) {
        return controlSurveyResidenceInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyResidenceInfoDO> getControlSurveyResidenceInfoPage(ControlSurveyResidenceInfoPageReqVO pageReqVO) {
        return controlSurveyResidenceInfoMapper.selectPage(pageReqVO);
    }

}