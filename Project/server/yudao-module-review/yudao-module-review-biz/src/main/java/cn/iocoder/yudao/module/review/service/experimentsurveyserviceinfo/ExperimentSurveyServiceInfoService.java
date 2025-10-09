package cn.iocoder.yudao.module.review.service.experimentsurveyserviceinfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-服役信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyServiceInfoService {

    /**
     * 创建实验组流调-服役信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyServiceInfo(@Valid ExperimentSurveyServiceInfoSaveReqVO createReqVO);

    /**
     * 更新实验组流调-服役信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyServiceInfo(@Valid ExperimentSurveyServiceInfoSaveReqVO updateReqVO);

    void updateExperimentSurveyServiceInfoByPersonId(@Valid ExperimentSurveyServiceInfoSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-服役信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyServiceInfo(Long id);

    /**
     * 获得实验组流调-服役信息
     *
     * @param id 编号
     * @return 实验组流调-服役信息
     */
    ExperimentSurveyServiceInfoDO getExperimentSurveyServiceInfo(Long id);

    /**
     * 获得实验组流调-服役信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-服役信息分页
     */
    PageResult<ExperimentSurveyServiceInfoDO> getExperimentSurveyServiceInfoPage(ExperimentSurveyServiceInfoPageReqVO pageReqVO);

}