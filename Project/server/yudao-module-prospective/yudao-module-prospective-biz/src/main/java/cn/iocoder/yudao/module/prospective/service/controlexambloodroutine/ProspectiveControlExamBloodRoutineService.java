package cn.iocoder.yudao.module.prospective.service.controlexambloodroutine;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambloodroutine.ProspectiveControlExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 实验组体检-血常规 Service 接口
 *
 * @author 管理员
 */
public interface ProspectiveControlExamBloodRoutineService {

    /**
     * 创建实验组体检-血常规
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamBloodRoutine(@Valid ControlExamBloodRoutineSaveReqVO createReqVO);

    /**
     * 更新实验组体检-血常规
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamBloodRoutine(@Valid ControlExamBloodRoutineSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-血常规
     *
     * @param id 编号
     */
    void deleteControlExamBloodRoutine(Long id);

    /**
     * 获得实验组体检-血常规
     *
     * @param id 编号
     * @return 实验组体检-血常规
     */
    ProspectiveControlExamBloodRoutineDO getControlExamBloodRoutine(Long id);

    /**
     * 获得实验组体检-血常规分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-血常规分页
     */
    PageResult<ProspectiveControlExamBloodRoutineDO> getControlExamBloodRoutinePage(ControlExamBloodRoutinePageReqVO pageReqVO);

}