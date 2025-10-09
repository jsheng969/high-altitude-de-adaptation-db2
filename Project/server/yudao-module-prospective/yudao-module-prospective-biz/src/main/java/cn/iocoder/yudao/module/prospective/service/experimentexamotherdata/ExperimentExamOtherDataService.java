package cn.iocoder.yudao.module.prospective.service.experimentexamotherdata;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamotherdata.ExperimentExamOtherDataDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组体检-其他数据 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentExamOtherDataService {

    /**
     * 创建实验组体检-其他数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentExamOtherData(@Valid ExperimentExamOtherDataSaveReqVO createReqVO);

    /**
     * 更新实验组体检-其他数据
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentExamOtherData(@Valid ExperimentExamOtherDataSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-其他数据
     *
     * @param id 编号
     */
    void deleteExperimentExamOtherData(Long id);

    /**
     * 获得实验组体检-其他数据
     *
     * @param id 编号
     * @return 实验组体检-其他数据
     */
    ExperimentExamOtherDataDO getExperimentExamOtherData(Long id);

    /**
     * 获得实验组体检-其他数据分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-其他数据分页
     */
    PageResult<ExperimentExamOtherDataDO> getExperimentExamOtherDataPage(ExperimentExamOtherDataPageReqVO pageReqVO);

}