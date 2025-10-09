package cn.iocoder.yudao.module.prospective.service.experimentexamcoagulationtests;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamcoagulationtests.ExperimentExamCoagulationTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 实验组体检-凝血功能 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentExamCoagulationTestsService {

    /**
     * 创建实验组体检-凝血功能
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamCoagulationTests(@Valid ExperimentExamCoagulationTestsSaveReqVO createReqVO);

    /**
     * 更新实验组体检-凝血功能
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamCoagulationTests(@Valid ExperimentExamCoagulationTestsSaveReqVO updateReqVO);

    void updateExperimentExamCoagulationTestsByPersionId(@Valid ExperimentExamCoagulationTestsSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-凝血功能
     *
     * @param id 编号
     */
    void deleteExperimentExamCoagulationTests(Long id);

    /**
     * 获得实验组体检-凝血功能
     *
     * @param id 编号
     * @return 实验组体检-凝血功能
     */
    ExperimentExamCoagulationTestsDO getExperimentExamCoagulationTests(Long id);

    /**
     * 获得实验组体检-凝血功能分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-凝血功能分页
     */
    PageResult<ExperimentExamCoagulationTestsDO> getExperimentExamCoagulationTestsPage(ExperimentExamCoagulationTestsPageReqVO pageReqVO);

}