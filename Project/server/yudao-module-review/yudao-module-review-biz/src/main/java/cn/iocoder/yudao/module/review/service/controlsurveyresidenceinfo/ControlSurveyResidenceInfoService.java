package cn.iocoder.yudao.module.review.service.controlsurveyresidenceinfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyresidenceinfo.ControlSurveyResidenceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组流调-旅居信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlSurveyResidenceInfoService {

    /**
     * 创建对照组流调-旅居信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyResidenceInfo(@Valid ControlSurveyResidenceInfoSaveReqVO createReqVO);

    /**
     * 更新对照组流调-旅居信息
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyResidenceInfo(@Valid ControlSurveyResidenceInfoSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-旅居信息
     *
     * @param id 编号
     */
    void deleteControlSurveyResidenceInfo(Long id);

    /**
     * 获得对照组流调-旅居信息
     *
     * @param id 编号
     * @return 对照组流调-旅居信息
     */
    ControlSurveyResidenceInfoDO getControlSurveyResidenceInfo(Long id);

    /**
     * 获得对照组流调-旅居信息分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-旅居信息分页
     */
    PageResult<ControlSurveyResidenceInfoDO> getControlSurveyResidenceInfoPage(ControlSurveyResidenceInfoPageReqVO pageReqVO);

}