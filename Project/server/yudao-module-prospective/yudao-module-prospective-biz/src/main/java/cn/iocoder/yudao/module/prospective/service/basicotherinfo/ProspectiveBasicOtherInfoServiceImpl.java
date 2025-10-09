package cn.iocoder.yudao.module.prospective.service.basicotherinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicotherinfo.ProspectiveBasicOtherInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.basicotherinfo.ProspectiveBasicOtherInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.TIME_POINT1_SURVEY_BASIC_OTHER_INFO_NOT_EXISTS;

/**
 * 基础其他信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ProspectiveBasicOtherInfoServiceImpl implements ProspectiveBasicOtherInfoService {

    @Resource
    private ProspectiveBasicOtherInfoMapper prospectiveBasicOtherInfoMapper;

    @Override
    public Long createExperimentSurveyBasicOtherInfo(BasicOtherInfoSaveReqVO createReqVO) {
        // 插入
        ProspectiveBasicOtherInfoDO experimentSurveyBasicOtherInfo = BeanUtils.toBean(createReqVO, ProspectiveBasicOtherInfoDO.class);
        prospectiveBasicOtherInfoMapper.insert(experimentSurveyBasicOtherInfo);
        // 返回
        return experimentSurveyBasicOtherInfo.getId();
    }

    @Override
    public void updateExperimentSurveyBasicOtherInfo(BasicOtherInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyBasicOtherInfoExists(updateReqVO.getId());
        // 更新
        ProspectiveBasicOtherInfoDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveBasicOtherInfoDO.class);
        prospectiveBasicOtherInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyBasicOtherInfo(Long id) {
        // 校验存在
        validateExperimentSurveyBasicOtherInfoExists(id);
        // 删除
        prospectiveBasicOtherInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyBasicOtherInfoExists(Long id) {
        if (prospectiveBasicOtherInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_BASIC_OTHER_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveBasicOtherInfoDO getExperimentSurveyBasicOtherInfo(Long id) {
        return prospectiveBasicOtherInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveBasicOtherInfoDO> getExperimentSurveyBasicOtherInfoPage(BasicOtherInfoPageReqVO pageReqVO) {
        return prospectiveBasicOtherInfoMapper.selectPage(pageReqVO);
    }

}