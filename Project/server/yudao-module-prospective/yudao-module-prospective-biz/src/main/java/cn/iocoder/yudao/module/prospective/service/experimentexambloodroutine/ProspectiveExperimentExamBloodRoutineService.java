package cn.iocoder.yudao.module.prospective.service.experimentexambloodroutine;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambloodroutine.ProspectiveExperimentExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 实验组体检-血常规 Service 接口
 *
 * @author 管理员
 */
public interface ProspectiveExperimentExamBloodRoutineService {

    /**
     * 创建实验组体检-血常规
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamBloodRoutine(@Valid ExperimentExamBloodRoutineSaveReqVO createReqVO);

    /**
     * 更新实验组体检-血常规
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamBloodRoutine(@Valid ExperimentExamBloodRoutineSaveReqVO updateReqVO);

    void updateExperimentExamBloodRoutineByPersonId(@Valid ExperimentExamBloodRoutineSaveReqVO updateReqVO);


    /**
     * 删除实验组体检-血常规
     *
     * @param id 编号
     */
    void deleteExperimentExamBloodRoutine(Long id);

    /**
     * 获得实验组体检-血常规
     *
     * @param id 编号
     * @return 实验组体检-血常规
     */
    ProspectiveExperimentExamBloodRoutineDO getExperimentExamBloodRoutine(Long id);

    /**
     * 获得实验组体检-血常规分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-血常规分页
     */
    PageResult<ProspectiveExperimentExamBloodRoutineDO> getExperimentExamBloodRoutinePage(ExperimentExamBloodRoutinePageReqVO pageReqVO);

}