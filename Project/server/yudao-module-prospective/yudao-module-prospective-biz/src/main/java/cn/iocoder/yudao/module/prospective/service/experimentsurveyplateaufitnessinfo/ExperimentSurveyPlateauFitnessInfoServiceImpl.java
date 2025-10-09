package cn.iocoder.yudao.module.prospective.service.experimentsurveyplateaufitnessinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 高原体能信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyPlateauFitnessInfoServiceImpl implements ExperimentSurveyPlateauFitnessInfoService {

    @Resource
    private ExperimentSurveyPlateauFitnessInfoMapper experimentSurveyPlateauFitnessInfoMapper;

    @Override
    public Long createExperimentSurveyPlateauFitnessInfo(ExperimentSurveyPlateauFitnessInfoSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyPlateauFitnessInfoDO experimentSurveyPlateauFitnessInfo = BeanUtils.toBean(createReqVO, ExperimentSurveyPlateauFitnessInfoDO.class);
        experimentSurveyPlateauFitnessInfoMapper.insert(experimentSurveyPlateauFitnessInfo);
        // 返回
        return experimentSurveyPlateauFitnessInfo.getId();
    }

    @Override
    public void updateExperimentSurveyPlateauFitnessInfo(ExperimentSurveyPlateauFitnessInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyPlateauFitnessInfoExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyPlateauFitnessInfoDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyPlateauFitnessInfoDO.class);
        experimentSurveyPlateauFitnessInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyPlateauFitnessInfo(Long id) {
        // 校验存在
        validateExperimentSurveyPlateauFitnessInfoExists(id);
        // 删除
        experimentSurveyPlateauFitnessInfoMapper.deleteById(id);
    }

    private void validateExperimentSurveyPlateauFitnessInfoExists(Long id) {
        if (experimentSurveyPlateauFitnessInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_PLATEAU_FITNESS_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyPlateauFitnessInfoDO getExperimentSurveyPlateauFitnessInfo(Long id) {
        return experimentSurveyPlateauFitnessInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyPlateauFitnessInfoDO> getExperimentSurveyPlateauFitnessInfoPage(ExperimentSurveyPlateauFitnessInfoPageReqVO pageReqVO) {
        return experimentSurveyPlateauFitnessInfoMapper.selectPage(pageReqVO);
    }

}