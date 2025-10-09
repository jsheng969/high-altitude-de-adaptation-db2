package cn.iocoder.yudao.module.review.service.controlexambloodroutine;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambloodroutine.ControlExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexambloodroutine.ControlExamBloodRoutineMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-血常规 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamBloodRoutineServiceImpl implements ControlExamBloodRoutineService {

    @Resource
    private ControlExamBloodRoutineMapper controlExamBloodRoutineMapper;

    @Override
    public Long createControlExamBloodRoutine(ControlExamBloodRoutineSaveReqVO createReqVO) {
        // 插入
        ControlExamBloodRoutineDO controlExamBloodRoutine = BeanUtils.toBean(createReqVO, ControlExamBloodRoutineDO.class);
        controlExamBloodRoutineMapper.insert(controlExamBloodRoutine);
        // 返回
        return controlExamBloodRoutine.getId();
    }

    @Override
    public void updateControlExamBloodRoutine(ControlExamBloodRoutineSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamBloodRoutineExists(updateReqVO.getId());
        // 更新
        ControlExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBloodRoutineDO.class);
        controlExamBloodRoutineMapper.updateById(updateObj);
    }

    @Override
    public void updateControlExamBloodRoutineByPersonId(ControlExamBloodRoutineSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ControlExamBloodRoutineDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ControlExamBloodRoutineDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ControlExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBloodRoutineDO.class);
        controlExamBloodRoutineMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteControlExamBloodRoutine(Long id) {
        // 校验存在
        validateControlExamBloodRoutineExists(id);
        // 删除
        controlExamBloodRoutineMapper.deleteById(id);
    }

    private void validateControlExamBloodRoutineExists(Long id) {
        if (controlExamBloodRoutineMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_BLOOD_ROUTINE_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamBloodRoutineDO getControlExamBloodRoutine(Long id) {
        return controlExamBloodRoutineMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamBloodRoutineDO> getControlExamBloodRoutinePage(ControlExamBloodRoutinePageReqVO pageReqVO) {
        return controlExamBloodRoutineMapper.selectPage(pageReqVO);
    }

}