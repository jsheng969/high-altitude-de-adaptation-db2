package cn.iocoder.yudao.module.prospective.service.experimentsurveystationtraininginfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

/**
 * 驻训信息 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyStationTrainingInfoService {

    /**
     * 创建驻训信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyStationTrainingInfo(@Valid ExperimentSurveyStationTrainingInfoSaveReqVO createReqVO);

    /**
     * 更新驻训信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyStationTrainingInfo(@Valid ExperimentSurveyStationTrainingInfoSaveReqVO updateReqVO);

    public void updateExperimentSurveyStationTrainingInfoByWrapper(ExperimentSurveyStationTrainingInfoSaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyStationTrainingInfoDO> updateWrapper);
    /**
     * 删除驻训信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyStationTrainingInfo(Long id);

    /**
     * 获得驻训信息
     *
     * @param id 编号
     * @return 驻训信息
     */
    ExperimentSurveyStationTrainingInfoDO getExperimentSurveyStationTrainingInfo(Long id);

    /**
     * 获得驻训信息分页
     *
     * @param pageReqVO 分页查询
     * @return 驻训信息分页
     */
    PageResult<ExperimentSurveyStationTrainingInfoDO> getExperimentSurveyStationTrainingInfoPage(ExperimentSurveyStationTrainingInfoPageReqVO pageReqVO);

}