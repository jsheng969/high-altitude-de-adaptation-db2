package cn.iocoder.yudao.module.prospective.service.experimentsurveybasiccheckinfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基本检测信息 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyBasicCheckInfoService {

    /**
     * 创建基本检测信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyBasicCheckInfo(@Valid ExperimentSurveyBasicCheckInfoSaveReqVO createReqVO);

    /**
     * 更新基本检测信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyBasicCheckInfo(@Valid ExperimentSurveyBasicCheckInfoSaveReqVO updateReqVO);

    /**
     * 删除基本检测信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyBasicCheckInfo(Long id);

    /**
     * 获得基本检测信息
     *
     * @param id 编号
     * @return 基本检测信息
     */
    ExperimentSurveyBasicCheckInfoDO getExperimentSurveyBasicCheckInfo(Long id);

    /**
     * 获得基本检测信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基本检测信息分页
     */
    PageResult<ExperimentSurveyBasicCheckInfoDO> getExperimentSurveyBasicCheckInfoPage(ExperimentSurveyBasicCheckInfoPageReqVO pageReqVO);

}