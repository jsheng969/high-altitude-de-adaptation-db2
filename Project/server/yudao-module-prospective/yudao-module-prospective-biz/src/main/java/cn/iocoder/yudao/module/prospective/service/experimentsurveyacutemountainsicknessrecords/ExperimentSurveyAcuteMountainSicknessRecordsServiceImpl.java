package cn.iocoder.yudao.module.prospective.service.experimentsurveyacutemountainsicknessrecords;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 高原急性高山病记录 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyAcuteMountainSicknessRecordsServiceImpl implements ExperimentSurveyAcuteMountainSicknessRecordsService {

    @Resource
    private ExperimentSurveyAcuteMountainSicknessRecordsMapper experimentSurveyAcuteMountainSicknessRecordsMapper;

    @Override
    public Long createExperimentSurveyAcuteMountainSicknessRecords(ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyAcuteMountainSicknessRecordsDO experimentSurveyAcuteMountainSicknessRecords = BeanUtils.toBean(createReqVO, ExperimentSurveyAcuteMountainSicknessRecordsDO.class);
        experimentSurveyAcuteMountainSicknessRecordsMapper.insert(experimentSurveyAcuteMountainSicknessRecords);
        // 返回
        return experimentSurveyAcuteMountainSicknessRecords.getId();
    }

    @Override
    public void updateExperimentSurveyAcuteMountainSicknessRecords(ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyAcuteMountainSicknessRecordsExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyAcuteMountainSicknessRecordsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyAcuteMountainSicknessRecordsDO.class);
        experimentSurveyAcuteMountainSicknessRecordsMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyAcuteMountainSicknessRecords(Long id) {
        // 校验存在
        validateExperimentSurveyAcuteMountainSicknessRecordsExists(id);
        // 删除
        experimentSurveyAcuteMountainSicknessRecordsMapper.deleteById(id);
    }

    private void validateExperimentSurveyAcuteMountainSicknessRecordsExists(Long id) {
        if (experimentSurveyAcuteMountainSicknessRecordsMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_ACUTE_MOUNTAIN_SICKNESS_RECORDS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyAcuteMountainSicknessRecordsDO getExperimentSurveyAcuteMountainSicknessRecords(Long id) {
        return experimentSurveyAcuteMountainSicknessRecordsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyAcuteMountainSicknessRecordsDO> getExperimentSurveyAcuteMountainSicknessRecordsPage(ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO pageReqVO) {
        return experimentSurveyAcuteMountainSicknessRecordsMapper.selectPage(pageReqVO);
    }

}