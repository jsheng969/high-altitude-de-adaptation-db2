package cn.iocoder.yudao.module.review.service.experimentexambloodroutine;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambloodroutine.ExperimentExamBloodRoutineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-血常规 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamBloodRoutineService {

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
    ExperimentExamBloodRoutineDO getExperimentExamBloodRoutine(Long id);

    /**
     * 获得实验组体检-血常规分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-血常规分页
     */
    PageResult<ExperimentExamBloodRoutineDO> getExperimentExamBloodRoutinePage(ExperimentExamBloodRoutinePageReqVO pageReqVO);

}