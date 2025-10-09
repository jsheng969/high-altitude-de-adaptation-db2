package cn.iocoder.yudao.module.review.service.experimentexambloodroutine;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambloodroutine.ExperimentExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexambloodroutine.ExperimentExamBloodRoutineMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-血常规 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamBloodRoutineServiceImpl implements ExperimentExamBloodRoutineService {

    @Resource
    private ExperimentExamBloodRoutineMapper experimentExamBloodRoutineMapper;

    @Override
    public Long createExperimentExamBloodRoutine(ExperimentExamBloodRoutineSaveReqVO createReqVO) {
        // 插入
        ExperimentExamBloodRoutineDO experimentExamBloodRoutine = BeanUtils.toBean(createReqVO, ExperimentExamBloodRoutineDO.class);
        experimentExamBloodRoutineMapper.insert(experimentExamBloodRoutine);
        // 返回
        return experimentExamBloodRoutine.getId();
    }

    @Override
    public void updateExperimentExamBloodRoutine(ExperimentExamBloodRoutineSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamBloodRoutineExists(updateReqVO.getId());
        // 更新
        ExperimentExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamBloodRoutineDO.class);
        experimentExamBloodRoutineMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamBloodRoutine(Long id) {
        // 校验存在
        validateExperimentExamBloodRoutineExists(id);
        // 删除
        experimentExamBloodRoutineMapper.deleteById(id);
    }

    private void validateExperimentExamBloodRoutineExists(Long id) {
        if (experimentExamBloodRoutineMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_BLOOD_ROUTINE_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamBloodRoutineDO getExperimentExamBloodRoutine(Long id) {
        return experimentExamBloodRoutineMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamBloodRoutineDO> getExperimentExamBloodRoutinePage(ExperimentExamBloodRoutinePageReqVO pageReqVO) {
        return experimentExamBloodRoutineMapper.selectPage(pageReqVO);
    }

}