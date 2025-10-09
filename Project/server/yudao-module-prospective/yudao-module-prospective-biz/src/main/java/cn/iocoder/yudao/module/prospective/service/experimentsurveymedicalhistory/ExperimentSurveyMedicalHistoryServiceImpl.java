package cn.iocoder.yudao.module.prospective.service.experimentsurveymedicalhistory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 既往疾病史 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentSurveyMedicalHistoryServiceImpl implements ExperimentSurveyMedicalHistoryService {

    @Resource
    private ExperimentSurveyMedicalHistoryMapper experimentSurveyMedicalHistoryMapper;

    @Override
    public Long createExperimentSurveyMedicalHistory(ExperimentSurveyMedicalHistorySaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyMedicalHistoryDO experimentSurveyMedicalHistory = BeanUtils.toBean(createReqVO, ExperimentSurveyMedicalHistoryDO.class);
        experimentSurveyMedicalHistoryMapper.insert(experimentSurveyMedicalHistory);
        // 返回
        return experimentSurveyMedicalHistory.getId();
    }

    @Override
    public void updateExperimentSurveyMedicalHistory(ExperimentSurveyMedicalHistorySaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyMedicalHistoryExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyMedicalHistoryDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyMedicalHistoryDO.class);
        experimentSurveyMedicalHistoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyMedicalHistory(Long id) {
        // 校验存在
        validateExperimentSurveyMedicalHistoryExists(id);
        // 删除
        experimentSurveyMedicalHistoryMapper.deleteById(id);
    }

    private void validateExperimentSurveyMedicalHistoryExists(Long id) {
        if (experimentSurveyMedicalHistoryMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_MEDICAL_HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyMedicalHistoryDO getExperimentSurveyMedicalHistory(Long id) {
        return experimentSurveyMedicalHistoryMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyMedicalHistoryDO> getExperimentSurveyMedicalHistoryPage(ExperimentSurveyMedicalHistoryPageReqVO pageReqVO) {
        return experimentSurveyMedicalHistoryMapper.selectPage(pageReqVO);
    }

}