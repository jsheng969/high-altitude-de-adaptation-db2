package cn.iocoder.yudao.module.prospective.service.experimentexambloodroutine;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.mapstruct.ap.internal.model.assignment.UpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambloodroutine.ProspectiveExperimentExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentexambloodroutine.ProspectiveExperimentExamBloodRoutineMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-血常规 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ProspectiveExperimentExamBloodRoutineServiceImpl implements ProspectiveExperimentExamBloodRoutineService {

    @Resource
    private ProspectiveExperimentExamBloodRoutineMapper prospectiveExperimentExamBloodRoutineMapper;

    @Override
    public Long createExperimentExamBloodRoutine(ExperimentExamBloodRoutineSaveReqVO createReqVO) {
        // 插入
        ProspectiveExperimentExamBloodRoutineDO experimentExamBloodRoutine = BeanUtils.toBean(createReqVO, ProspectiveExperimentExamBloodRoutineDO.class);
        prospectiveExperimentExamBloodRoutineMapper.insert(experimentExamBloodRoutine);
        // 返回
        return experimentExamBloodRoutine.getId();
    }

    @Override
    public void updateExperimentExamBloodRoutine(ExperimentExamBloodRoutineSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamBloodRoutineExists(updateReqVO.getId());
        // 更新
        ProspectiveExperimentExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveExperimentExamBloodRoutineDO.class);
        prospectiveExperimentExamBloodRoutineMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentExamBloodRoutineByPersonId(ExperimentExamBloodRoutineSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ProspectiveExperimentExamBloodRoutineDO> updateWrapper = new LambdaUpdateWrapper<ProspectiveExperimentExamBloodRoutineDO>();
        updateWrapper.eq(ProspectiveExperimentExamBloodRoutineDO::getPersonId, updateReqVO.getPersonId());
        updateWrapper.eq(ProspectiveExperimentExamBloodRoutineDO::getTimePoint, updateReqVO.getTimePoint());
        // 更新
        ProspectiveExperimentExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveExperimentExamBloodRoutineDO.class);
        prospectiveExperimentExamBloodRoutineMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentExamBloodRoutine(Long id) {
        // 校验存在
        validateExperimentExamBloodRoutineExists(id);
        // 删除
        prospectiveExperimentExamBloodRoutineMapper.deleteById(id);
    }

    private void validateExperimentExamBloodRoutineExists(Long id) {
        if (prospectiveExperimentExamBloodRoutineMapper.selectById(id) == null) {
            throw exception(EXPERMENT_EXAM_BLOOD_ROUTINE_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveExperimentExamBloodRoutineDO getExperimentExamBloodRoutine(Long id) {
        return prospectiveExperimentExamBloodRoutineMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveExperimentExamBloodRoutineDO> getExperimentExamBloodRoutinePage(ExperimentExamBloodRoutinePageReqVO pageReqVO) {
        return prospectiveExperimentExamBloodRoutineMapper.selectPage(pageReqVO);
    }

}