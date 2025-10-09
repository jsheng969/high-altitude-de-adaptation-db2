package cn.iocoder.yudao.module.prospective.service.experimentsurveyplateaufitnessinfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 高原体能信息 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentSurveyPlateauFitnessInfoService {

    /**
     * 创建高原体能信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyPlateauFitnessInfo(@Valid ExperimentSurveyPlateauFitnessInfoSaveReqVO createReqVO);

    /**
     * 更新高原体能信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyPlateauFitnessInfo(@Valid ExperimentSurveyPlateauFitnessInfoSaveReqVO updateReqVO);

    /**
     * 删除高原体能信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyPlateauFitnessInfo(Long id);

    /**
     * 获得高原体能信息
     *
     * @param id 编号
     * @return 高原体能信息
     */
    ExperimentSurveyPlateauFitnessInfoDO getExperimentSurveyPlateauFitnessInfo(Long id);

    /**
     * 获得高原体能信息分页
     *
     * @param pageReqVO 分页查询
     * @return 高原体能信息分页
     */
    PageResult<ExperimentSurveyPlateauFitnessInfoDO> getExperimentSurveyPlateauFitnessInfoPage(ExperimentSurveyPlateauFitnessInfoPageReqVO pageReqVO);

}