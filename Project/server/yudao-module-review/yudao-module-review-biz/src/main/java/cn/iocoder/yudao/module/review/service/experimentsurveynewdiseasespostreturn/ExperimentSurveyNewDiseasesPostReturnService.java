package cn.iocoder.yudao.module.review.service.experimentsurveynewdiseasespostreturn;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 实验组流调-返回平原后新发的疾病 Service 接口
 *
 * @author 芋道源码
 */
public interface ExperimentSurveyNewDiseasesPostReturnService {

    /**
     * 创建实验组流调-返回平原后新发的疾病
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyNewDiseasesPostReturn(@Valid ExperimentSurveyNewDiseasesPostReturnSaveReqVO createReqVO);

    /**
     * 更新实验组流调-返回平原后新发的疾病
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyNewDiseasesPostReturn(@Valid ExperimentSurveyNewDiseasesPostReturnSaveReqVO updateReqVO);

    /**
     * 删除实验组流调-返回平原后新发的疾病
     *
     * @param id 编号
     */
    void deleteExperimentSurveyNewDiseasesPostReturn(Long id);

    /**
     * 获得实验组流调-返回平原后新发的疾病
     *
     * @param id 编号
     * @return 实验组流调-返回平原后新发的疾病
     */
    ExperimentSurveyNewDiseasesPostReturnDO getExperimentSurveyNewDiseasesPostReturn(Long id);

    /**
     * 获得实验组流调-返回平原后新发的疾病分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组流调-返回平原后新发的疾病分页
     */
    PageResult<ExperimentSurveyNewDiseasesPostReturnDO> getExperimentSurveyNewDiseasesPostReturnPage(ExperimentSurveyNewDiseasesPostReturnPageReqVO pageReqVO);

}