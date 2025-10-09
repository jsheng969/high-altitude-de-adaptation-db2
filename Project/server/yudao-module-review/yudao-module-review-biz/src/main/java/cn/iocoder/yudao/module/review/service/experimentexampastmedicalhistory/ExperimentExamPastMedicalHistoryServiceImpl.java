package cn.iocoder.yudao.module.review.service.experimentexampastmedicalhistory;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-既往病史 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamPastMedicalHistoryServiceImpl implements ExperimentExamPastMedicalHistoryService {

    @Resource
    private ExperimentExamPastMedicalHistoryMapper experimentExamPastMedicalHistoryMapper;

    @Override
    public Long createExperimentExamPastMedicalHistory(ExperimentExamPastMedicalHistorySaveReqVO createReqVO) {
        // 插入
        ExperimentExamPastMedicalHistoryDO experimentExamPastMedicalHistory = BeanUtils.toBean(createReqVO, ExperimentExamPastMedicalHistoryDO.class);
        experimentExamPastMedicalHistoryMapper.insert(experimentExamPastMedicalHistory);
        // 返回
        return experimentExamPastMedicalHistory.getId();
    }

    @Override
    public void updateExperimentExamPastMedicalHistory(ExperimentExamPastMedicalHistorySaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamPastMedicalHistoryExists(updateReqVO.getId());
        // 更新
        ExperimentExamPastMedicalHistoryDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamPastMedicalHistoryDO.class);
        experimentExamPastMedicalHistoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamPastMedicalHistory(Long id) {
        // 校验存在
        validateExperimentExamPastMedicalHistoryExists(id);
        // 删除
        experimentExamPastMedicalHistoryMapper.deleteById(id);
    }

    private void validateExperimentExamPastMedicalHistoryExists(Long id) {
        if (experimentExamPastMedicalHistoryMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_PAST_MEDICAL_HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamPastMedicalHistoryDO getExperimentExamPastMedicalHistory(Long id) {
        return experimentExamPastMedicalHistoryMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamPastMedicalHistoryDO> getExperimentExamPastMedicalHistoryPage(ExperimentExamPastMedicalHistoryPageReqVO pageReqVO) {
        return experimentExamPastMedicalHistoryMapper.selectPage(pageReqVO);
    }

}