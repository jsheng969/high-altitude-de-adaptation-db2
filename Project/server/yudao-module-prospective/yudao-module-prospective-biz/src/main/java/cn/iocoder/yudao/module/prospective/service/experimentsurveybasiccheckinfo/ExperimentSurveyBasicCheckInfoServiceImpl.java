package cn.iocoder.yudao.module.prospective.service.experimentsurveybasiccheckinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 基本检测信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyBasicCheckInfoServiceImpl implements ExperimentSurveyBasicCheckInfoService {

    @Resource
    private ExperimentSurveyBasicCheckInfoMapper experimentSurveyBasicCheckInfoMapper;

    @Override
    public Long createExperimentSurveyBasicCheckInfo(ExperimentSurveyBasicCheckInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyBasicCheckInfoDO experimentSurveyBasicCheckInfo = BeanUtils.toBean(createReqVO, ExperimentSurveyBasicCheckInfoDO.class);
        experimentSurveyBasicCheckInfoMapper.insert(experimentSurveyBasicCheckInfo);
        // 返回
        return experimentSurveyBasicCheckInfo.getId();
    }

    @Override
    public void updateExperimentSurveyBasicCheckInfo(ExperimentSurveyBasicCheckInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyBasicCheckInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyBasicCheckInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyBasicCheckInfoDO.class);
        experimentSurveyBasicCheckInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyBasicCheckInfo(Long id) {
        // 校验存在
        validateExperimentSurveyBasicCheckInfoExists(id);
        // 删除
        experimentSurveyBasicCheckInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyBasicCheckInfoExists(Long id) {
        if (experimentSurveyBasicCheckInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_BASIC_CHECK_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyBasicCheckInfoDO getExperimentSurveyBasicCheckInfo(Long id) {
        return experimentSurveyBasicCheckInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyBasicCheckInfoDO> getExperimentSurveyBasicCheckInfoPage(ExperimentSurveyBasicCheckInfoPageReqVO pageReqVO) {
        return experimentSurveyBasicCheckInfoMapper.selectPage(pageReqVO);
    }

}