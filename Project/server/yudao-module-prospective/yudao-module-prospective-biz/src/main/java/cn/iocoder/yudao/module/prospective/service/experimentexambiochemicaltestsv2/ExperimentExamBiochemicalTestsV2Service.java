package cn.iocoder.yudao.module.prospective.service.experimentexambiochemicaltestsv2;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 实验组体检-生化v2 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentExamBiochemicalTestsV2Service {

    /**
     * 创建实验组体检-生化v2
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamBiochemicalTestsV2(@Valid ExperimentExamBiochemicalTestsV2SaveReqVO createReqVO);

    /**
     * 更新实验组体检-生化v2
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamBiochemicalTestsV2(@Valid ExperimentExamBiochemicalTestsV2SaveReqVO updateReqVO);

    void updateExperimentExamBiochemicalTestsV2ByPersionId(@Valid ExperimentExamBiochemicalTestsV2SaveReqVO updateReqVO);

    /**
     * 删除实验组体检-生化v2
     *
     * @param id 编号
     */
    void deleteExperimentExamBiochemicalTestsV2(Long id);

    /**
     * 获得实验组体检-生化v2
     *
     * @param id 编号
     * @return 实验组体检-生化v2
     */
    ExperimentExamBiochemicalTestsV2DO getExperimentExamBiochemicalTestsV2(Long id);

    /**
     * 获得实验组体检-生化v2分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-生化v2分页
     */
    PageResult<ExperimentExamBiochemicalTestsV2DO> getExperimentExamBiochemicalTestsV2Page(ExperimentExamBiochemicalTestsV2PageReqVO pageReqVO);

}