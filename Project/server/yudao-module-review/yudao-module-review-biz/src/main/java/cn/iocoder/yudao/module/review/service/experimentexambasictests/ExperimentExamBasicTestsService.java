package cn.iocoder.yudao.module.review.service.experimentexambasictests;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambasictests.ExperimentExamBasicTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-基本检测信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamBasicTestsService {

    /**
     * 创建实验组体检-基本检测信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamBasicTests(@Valid ExperimentExamBasicTestsSaveReqVO createReqVO);

    /**
     * 更新实验组体检-基本检测信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamBasicTests(@Valid ExperimentExamBasicTestsSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-基本检测信息
     *
     * @param id 编号
     */
    void deleteExperimentExamBasicTests(Long id);

    /**
     * 获得实验组体检-基本检测信息
     *
     * @param id 编号
     * @return 实验组体检-基本检测信息
     */
    ExperimentExamBasicTestsDO getExperimentExamBasicTests(Long id);

    /**
     * 获得实验组体检-基本检测信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-基本检测信息分页
     */
    PageResult<ExperimentExamBasicTestsDO> getExperimentExamBasicTestsPage(ExperimentExamBasicTestsPageReqVO pageReqVO);

}