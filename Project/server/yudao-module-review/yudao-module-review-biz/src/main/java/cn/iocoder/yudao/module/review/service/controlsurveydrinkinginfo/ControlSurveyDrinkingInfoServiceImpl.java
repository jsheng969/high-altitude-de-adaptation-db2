package cn.iocoder.yudao.module.review.service.controlsurveydrinkinginfo;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-饮酒情况 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlSurveyDrinkingInfoServiceImpl implements ControlSurveyDrinkingInfoService {

    @Resource
    private ControlSurveyDrinkingInfoMapper controlSurveyDrinkingInfoMapper;

    @Override
    public Long createControlSurveyDrinkingInfo(ControlSurveyDrinkingInfoSaveReqVO createReqVO) {
        // 插入
        ControlSurveyDrinkingInfoDO controlSurveyDrinkingInfo = BeanUtils.toBean(createReqVO, ControlSurveyDrinkingInfoDO.class);
        controlSurveyDrinkingInfoMapper.insert(controlSurveyDrinkingInfo);
        // 返回
        return controlSurveyDrinkingInfo.getId();
    }

    @Override
    public void updateControlSurveyDrinkingInfo(ControlSurveyDrinkingInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyDrinkingInfoExists(updateReqVO.getId());
        // 更新
        ControlSurveyDrinkingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyDrinkingInfoDO.class);
        controlSurveyDrinkingInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyDrinkingInfo(Long id) {
        // 校验存在
        validateControlSurveyDrinkingInfoExists(id);
        // 删除
        controlSurveyDrinkingInfoMapper.deleteById(id);
    }

    private void validateControlSurveyDrinkingInfoExists(Long id) {
        if (controlSurveyDrinkingInfoMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_DRINKING_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyDrinkingInfoDO getControlSurveyDrinkingInfo(Long id) {
        return controlSurveyDrinkingInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyDrinkingInfoDO> getControlSurveyDrinkingInfoPage(ControlSurveyDrinkingInfoPageReqVO pageReqVO) {
        return controlSurveyDrinkingInfoMapper.selectPage(pageReqVO);
    }

}