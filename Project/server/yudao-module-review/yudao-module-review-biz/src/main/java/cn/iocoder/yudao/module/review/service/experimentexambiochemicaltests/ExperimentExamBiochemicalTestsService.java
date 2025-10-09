package cn.iocoder.yudao.module.review.service.experimentexambiochemicaltests;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-生化 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamBiochemicalTestsService {

    /**
     * 创建实验组体检-生化
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamBiochemicalTests(@Valid ExperimentExamBiochemicalTestsSaveReqVO createReqVO);

    /**
     * 更新实验组体检-生化
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamBiochemicalTests(@Valid ExperimentExamBiochemicalTestsSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-生化
     *
     * @param id 编号
     */
    void deleteExperimentExamBiochemicalTests(Long id);

    /**
     * 获得实验组体检-生化
     *
     * @param id 编号
     * @return 实验组体检-生化
     */
    ExperimentExamBiochemicalTestsDO getExperimentExamBiochemicalTests(Long id);

    /**
     * 获得实验组体检-生化分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-生化分页
     */
    PageResult<ExperimentExamBiochemicalTestsDO> getExperimentExamBiochemicalTestsPage(ExperimentExamBiochemicalTestsPageReqVO pageReqVO);

}