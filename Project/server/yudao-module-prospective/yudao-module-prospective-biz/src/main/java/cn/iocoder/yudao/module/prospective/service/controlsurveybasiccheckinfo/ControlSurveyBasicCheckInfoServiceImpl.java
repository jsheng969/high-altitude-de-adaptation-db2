package cn.iocoder.yudao.module.prospective.service.controlsurveybasiccheckinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 对照组流调-基本检测信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlSurveyBasicCheckInfoServiceImpl implements ControlSurveyBasicCheckInfoService {

    @Resource
    private ControlSurveyBasicCheckInfoMapper controlSurveyBasicCheckInfoMapper;

    @Override
    public Long createControlSurveyBasicCheckInfo(ControlSurveyBasicCheckInfoSaveReqVO createReqVO) {
        // 插入
        ControlSurveyBasicCheckInfoDO controlSurveyBasicCheckInfo = BeanUtils.toBean(createReqVO, ControlSurveyBasicCheckInfoDO.class);
        controlSurveyBasicCheckInfoMapper.insert(controlSurveyBasicCheckInfo);
        // 返回
        return controlSurveyBasicCheckInfo.getId();
    }

    @Override
    public void updateControlSurveyBasicCheckInfo(ControlSurveyBasicCheckInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateControlSurveyBasicCheckInfoExists(updateReqVO.getId());
        // 更新
        ControlSurveyBasicCheckInfoDO updateObj = BeanUtils.toBean(updateReqVO, ControlSurveyBasicCheckInfoDO.class);
        controlSurveyBasicCheckInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlSurveyBasicCheckInfo(Long id) {
        // 校验存在
        validateControlSurveyBasicCheckInfoExists(id);
        // 删除
        controlSurveyBasicCheckInfoMapper.deleteById(id);
    }

    private void validateControlSurveyBasicCheckInfoExists(Long id) {
        if (controlSurveyBasicCheckInfoMapper.selectById(id) == null) {
            throw exception(CONTROL_SURVEY_BASIC_CHECK_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ControlSurveyBasicCheckInfoDO getControlSurveyBasicCheckInfo(Long id) {
        return controlSurveyBasicCheckInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ControlSurveyBasicCheckInfoDO> getControlSurveyBasicCheckInfoPage(ControlSurveyBasicCheckInfoPageReqVO pageReqVO) {
        return controlSurveyBasicCheckInfoMapper.selectPage(pageReqVO);
    }

}