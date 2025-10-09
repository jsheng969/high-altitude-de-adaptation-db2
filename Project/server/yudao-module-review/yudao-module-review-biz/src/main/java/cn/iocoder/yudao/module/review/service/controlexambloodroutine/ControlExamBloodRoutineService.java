package cn.iocoder.yudao.module.review.service.controlexambloodroutine;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambloodroutine.ControlExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-血常规 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamBloodRoutineService {

    /**
     * 创建对照组体检-血常规
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamBloodRoutine(@Valid ControlExamBloodRoutineSaveReqVO createReqVO);

    /**
     * 更新对照组体检-血常规
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamBloodRoutine(@Valid ControlExamBloodRoutineSaveReqVO updateReqVO);

    void updateControlExamBloodRoutineByPersonId(@Valid ControlExamBloodRoutineSaveReqVO updateReqVO);

    /**
     * 删除对照组体检-血常规
     *
     * @param id 编号
     */
    void deleteControlExamBloodRoutine(Long id);

    /**
     * 获得对照组体检-血常规
     *
     * @param id 编号
     * @return 对照组体检-血常规
     */
    ControlExamBloodRoutineDO getControlExamBloodRoutine(Long id);

    /**
     * 获得对照组体检-血常规分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-血常规分页
     */
    PageResult<ControlExamBloodRoutineDO> getControlExamBloodRoutinePage(ControlExamBloodRoutinePageReqVO pageReqVO);

}