package cn.iocoder.yudao.module.prospective.service.experimentsurveymissionprogresssurvey;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

/**
 * 推进情况调查 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyMissionProgressSurveyService {

    /**
     * 创建推进情况调查
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyMissionProgressSurvey(@Valid ExperimentSurveyMissionProgressSurveySaveReqVO createReqVO);

    /**
     * 更新推进情况调查
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyMissionProgressSurvey(@Valid ExperimentSurveyMissionProgressSurveySaveReqVO updateReqVO);
    public void updateExperimentSurveyMissionProgressSurveyByWrapper(ExperimentSurveyMissionProgressSurveySaveReqVO updateReqVO, UpdateWrapper<ExperimentSurveyMissionProgressSurveyDO> updateWrapper);

    /**
     * 删除推进情况调查
     *
     * @param id 编号
     */
    void deleteExperimentSurveyMissionProgressSurvey(Long id);

    /**
     * 获得推进情况调查
     *
     * @param id 编号
     * @return 推进情况调查
     */
    ExperimentSurveyMissionProgressSurveyDO getExperimentSurveyMissionProgressSurvey(Long id);

    /**
     * 获得推进情况调查分页
     *
     * @param pageReqVO 分页查询
     * @return 推进情况调查分页
     */
    PageResult<ExperimentSurveyMissionProgressSurveyDO> getExperimentSurveyMissionProgressSurveyPage(ExperimentSurveyMissionProgressSurveyPageReqVO pageReqVO);

}