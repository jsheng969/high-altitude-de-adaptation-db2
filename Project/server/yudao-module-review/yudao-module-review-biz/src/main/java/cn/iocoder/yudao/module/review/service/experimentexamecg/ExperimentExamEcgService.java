package cn.iocoder.yudao.module.review.service.experimentexamecg;

import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamecg.ExperimentExamEcgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-心电图 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamEcgService {

    /**
     * 创建实验组体检-心电图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamEcg(@Valid ExperimentExamEcgSaveReqVO createReqVO);

    /**
     * 更新实验组体检-心电图
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamEcg(@Valid ExperimentExamEcgSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-心电图
     *
     * @param id 编号
     */
    void deleteExperimentExamEcg(Long id);

    /**
     * 获得实验组体检-心电图
     *
     * @param id 编号
     * @return 实验组体检-心电图
     */
    ExperimentExamEcgDO getExperimentExamEcg(Long id);

    /**
     * 获得实验组体检-心电图分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-心电图分页
     */
    PageResult<ExperimentExamEcgDO> getExperimentExamEcgPage(ExperimentExamEcgPageReqVO pageReqVO);

}