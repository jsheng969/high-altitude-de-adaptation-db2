package cn.iocoder.yudao.module.review.service.controlsurveypastdiseases;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveypastdiseases.ControlSurveyPastDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组流调-既往疾病 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlSurveyPastDiseasesService {

    /**
     * 创建对照组流调-既往疾病
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyPastDiseases(@Valid ControlSurveyPastDiseasesSaveReqVO createReqVO);

    /**
     * 更新对照组流调-既往疾病
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyPastDiseases(@Valid ControlSurveyPastDiseasesSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-既往疾病
     *
     * @param id 编号
     */
    void deleteControlSurveyPastDiseases(Long id);

    /**
     * 获得对照组流调-既往疾病
     *
     * @param id 编号
     * @return 对照组流调-既往疾病
     */
    ControlSurveyPastDiseasesDO getControlSurveyPastDiseases(Long id);

    /**
     * 获得对照组流调-既往疾病分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-既往疾病分页
     */
    PageResult<ControlSurveyPastDiseasesDO> getControlSurveyPastDiseasesPage(ControlSurveyPastDiseasesPageReqVO pageReqVO);

}