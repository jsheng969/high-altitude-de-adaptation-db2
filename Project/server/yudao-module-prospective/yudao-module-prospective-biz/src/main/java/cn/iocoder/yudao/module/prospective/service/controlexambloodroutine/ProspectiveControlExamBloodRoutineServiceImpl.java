package cn.iocoder.yudao.module.prospective.service.controlexambloodroutine;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambloodroutine.ProspectiveControlExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlexambloodroutine.ProspectiveControlExamBloodRoutineMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-血常规 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ProspectiveControlExamBloodRoutineServiceImpl implements ProspectiveControlExamBloodRoutineService {

    @Resource
    private ProspectiveControlExamBloodRoutineMapper prospectiveControlExamBloodRoutineMapper;

    @Override
    public Long createControlExamBloodRoutine(ControlExamBloodRoutineSaveReqVO createReqVO) {
        // 插入
        ProspectiveControlExamBloodRoutineDO controlExamBloodRoutine = BeanUtils.toBean(createReqVO, ProspectiveControlExamBloodRoutineDO.class);
        prospectiveControlExamBloodRoutineMapper.insert(controlExamBloodRoutine);
        // 返回
        return controlExamBloodRoutine.getId();
    }

    @Override
    public void updateControlExamBloodRoutine(ControlExamBloodRoutineSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamBloodRoutineExists(updateReqVO.getId());
        // 更新
        ProspectiveControlExamBloodRoutineDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveControlExamBloodRoutineDO.class);
        prospectiveControlExamBloodRoutineMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamBloodRoutine(Long id) {
        // 校验存在
        validateControlExamBloodRoutineExists(id);
        // 删除
        prospectiveControlExamBloodRoutineMapper.deleteById(id);
    }

    private void validateControlExamBloodRoutineExists(Long id) {
        if (prospectiveControlExamBloodRoutineMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_BLOOD_ROUTINE_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveControlExamBloodRoutineDO getControlExamBloodRoutine(Long id) {
        return prospectiveControlExamBloodRoutineMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveControlExamBloodRoutineDO> getControlExamBloodRoutinePage(ControlExamBloodRoutinePageReqVO pageReqVO) {
        return prospectiveControlExamBloodRoutineMapper.selectPage(pageReqVO);
    }

}