package cn.iocoder.yudao.module.prospective.service.experimentsurveysmokinginfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 吸烟信息 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveySmokingInfoService {

    /**
     * 创建吸烟信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveySmokingInfo(@Valid ExperimentSurveySmokingInfoSaveReqVO createReqVO);

    /**
     * 更新吸烟信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveySmokingInfo(@Valid ExperimentSurveySmokingInfoSaveReqVO updateReqVO);

    /**
     * 删除吸烟信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveySmokingInfo(Long id);

    /**
     * 获得吸烟信息
     *
     * @param id 编号
     * @return 吸烟信息
     */
    ExperimentSurveySmokingInfoDO getExperimentSurveySmokingInfo(Long id);

    /**
     * 获得吸烟信息分页
     *
     * @param pageReqVO 分页查询
     * @return 吸烟信息分页
     */
    PageResult<ExperimentSurveySmokingInfoDO> getExperimentSurveySmokingInfoPage(ExperimentSurveySmokingInfoPageReqVO pageReqVO);

}