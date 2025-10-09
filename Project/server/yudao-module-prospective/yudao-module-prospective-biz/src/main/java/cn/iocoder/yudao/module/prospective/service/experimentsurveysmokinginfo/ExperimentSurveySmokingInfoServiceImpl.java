package cn.iocoder.yudao.module.prospective.service.experimentsurveysmokinginfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 吸烟信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveySmokingInfoServiceImpl implements ExperimentSurveySmokingInfoService {

    @Resource
    private ExperimentSurveySmokingInfoMapper experimentSurveySmokingInfoMapper;

    @Override
    public Long createExperimentSurveySmokingInfo(ExperimentSurveySmokingInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveySmokingInfoDO experimentSurveySmokingInfo = BeanUtils.toBean(createReqVO, ExperimentSurveySmokingInfoDO.class);
        experimentSurveySmokingInfoMapper.insert(experimentSurveySmokingInfo);
        // 返回
        return experimentSurveySmokingInfo.getId();
    }

    @Override
    public void updateExperimentSurveySmokingInfo(ExperimentSurveySmokingInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveySmokingInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveySmokingInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveySmokingInfoDO.class);
        experimentSurveySmokingInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveySmokingInfo(Long id) {
        // 校验存在
        validateExperimentSurveySmokingInfoExists(id);
        // 删除
        experimentSurveySmokingInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveySmokingInfoExists(Long id) {
        if (experimentSurveySmokingInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_SMOKING_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveySmokingInfoDO getExperimentSurveySmokingInfo(Long id) {
        return experimentSurveySmokingInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveySmokingInfoDO> getExperimentSurveySmokingInfoPage(ExperimentSurveySmokingInfoPageReqVO pageReqVO) {
        return experimentSurveySmokingInfoMapper.selectPage(pageReqVO);
    }

}