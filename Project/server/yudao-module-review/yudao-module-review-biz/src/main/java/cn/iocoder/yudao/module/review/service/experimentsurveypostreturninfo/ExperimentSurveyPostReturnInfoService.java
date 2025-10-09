package cn.iocoder.yudao.module.review.service.experimentsurveypostreturninfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-返回后基础信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyPostReturnInfoService {

    /**
     * 创建实验组流调-返回后基础信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyPostReturnInfo(@Valid ExperimentSurveyPostReturnInfoSaveReqVO createReqVO);

    /**
     * 更新实验组流调-返回后基础信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyPostReturnInfo(@Valid ExperimentSurveyPostReturnInfoSaveReqVO updateReqVO);

    void updateExperimentSurveyPostReturnInfoByPersonId(@Valid ExperimentSurveyPostReturnInfoSaveReqVO updateReqVO);


    /**
     * 删除实验组流调-返回后基础信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyPostReturnInfo(Long id);

    /**
     * 获得实验组流调-返回后基础信息
     *
     * @param id 编号
     * @return 实验组流调-返回后基础信息
     */
    ExperimentSurveyPostReturnInfoDO getExperimentSurveyPostReturnInfo(Long id);

    /**
     * 获得实验组流调-返回后基础信息分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-返回后基础信息分页
     */
    PageResult<ExperimentSurveyPostReturnInfoDO> getExperimentSurveyPostReturnInfoPage(ExperimentSurveyPostReturnInfoPageReqVO pageReqVO);

}