package cn.iocoder.yudao.module.prospective.service.experimentsurveypostreturnsymptoms;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveypostreturnsymptoms.ProspectiveExperimentSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 实验组流调-退役后返回平原1月内症状 Service 接口
 *
 * @author 管理员
 */
public interface ProspectiveExperimentSurveyPostReturnSymptomsService {

    /**
     * 创建实验组流调-退役后返回平原1月内症状
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyPostReturnSymptoms(@Valid ExperimentSurveyPostReturnSymptomsSaveReqVO createReqVO);

    /**
     * 更新实验组流调-退役后返回平原1月内症状
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyPostReturnSymptoms(@Valid ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     */
    void deleteExperimentSurveyPostReturnSymptoms(Long id);

    /**
     * 获得实验组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     * @return 实验组流调-退役后返回平原1月内症状
     */
    ProspectiveExperimentSurveyPostReturnSymptomsDO getExperimentSurveyPostReturnSymptoms(Long id);

    /**
     * 获得实验组流调-退役后返回平原1月内症状分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-退役后返回平原1月内症状分页
     */
    PageResult<ProspectiveExperimentSurveyPostReturnSymptomsDO> getExperimentSurveyPostReturnSymptomsPage(ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO);

}