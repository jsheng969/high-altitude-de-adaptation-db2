package cn.iocoder.yudao.module.review.service.controlsurveysmokinginfo;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveysmokinginfo.ControlSurveySmokingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlsurveysmokinginfo.ControlSurveySmokingInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-吸烟情况 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlSurveySmokingInfoServiceImpl implements ControlSurveySmokingInfoService {

    @Resource
    private ControlSurveySmokingInfoMapper controlSurveySmokingInfoMapper;

    @Override
    public Long createControlSurveySmokingInfo(ControlSurveySmokingInfoSaveReqVO createReqVO) {
        // 插入
        ControlSurveySmokingInfoDO controlSurveySmokingInfo = BeanUtils.toBean(createReqVO, ControlSurveySmokingInfoDO.class);
        controlSurveySmokingInfoMapper.insert(controlSurveySmokingInfo);
        // 返回
        return controlSurveySmokingInfo.getId();
    }

    @Override
    public void updateControlSurveySmokingInfo(ControlSurveySmokingInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveySmokingInfoExists(updateReqVO.getId());
        // 更新
        ControlSurveySmokingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveySmokingInfoDO.class);
        controlSurveySmokingInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveySmokingInfo(Long id) {
        // 校验存在
        validateControlSurveySmokingInfoExists(id);
        // 删除
        controlSurveySmokingInfoMapper.deleteById(id);
    }

    private void validateControlSurveySmokingInfoExists(Long id) {
        if (controlSurveySmokingInfoMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_SMOKING_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveySmokingInfoDO getControlSurveySmokingInfo(Long id) {
        return controlSurveySmokingInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveySmokingInfoDO> getControlSurveySmokingInfoPage(ControlSurveySmokingInfoPageReqVO pageReqVO) {
        return controlSurveySmokingInfoMapper.selectPage(pageReqVO);
    }

}