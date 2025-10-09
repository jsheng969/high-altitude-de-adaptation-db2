package cn.iocoder.yudao.module.review.service.experimentexamabdominalultrasound;

import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 实验组体检-腹部超声 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentExamAbdominalUltrasoundService {

    /**
     * 创建实验组体检-腹部超声
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamAbdominalUltrasound(@Valid ExperimentExamAbdominalUltrasoundSaveReqVO createReqVO);

    /**
     * 更新实验组体检-腹部超声
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamAbdominalUltrasound(@Valid ExperimentExamAbdominalUltrasoundSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-腹部超声
     *
     * @param id 编号
     */
    void deleteExperimentExamAbdominalUltrasound(Long id);

    /**
     * 获得实验组体检-腹部超声
     *
     * @param id 编号
     * @return 实验组体检-腹部超声
     */
    ExperimentExamAbdominalUltrasoundDO getExperimentExamAbdominalUltrasound(Long id);

    /**
     * 获得实验组体检-腹部超声分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-腹部超声分页
     */
    PageResult<ExperimentExamAbdominalUltrasoundDO> getExperimentExamAbdominalUltrasoundPage(ExperimentExamAbdominalUltrasoundPageReqVO pageReqVO);

}