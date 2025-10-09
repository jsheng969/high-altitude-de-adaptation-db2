package cn.iocoder.yudao.module.review.service.controlsurveysmokinginfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveysmokinginfo.ControlSurveySmokingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组流调-吸烟情况 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlSurveySmokingInfoService {

    /**
     * 创建对照组流调-吸烟情况
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveySmokingInfo(@Valid ControlSurveySmokingInfoSaveReqVO createReqVO);

    /**
     * 更新对照组流调-吸烟情况
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveySmokingInfo(@Valid ControlSurveySmokingInfoSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-吸烟情况
     *
     * @param id 编号
     */
    void deleteControlSurveySmokingInfo(Long id);

    /**
     * 获得对照组流调-吸烟情况
     *
     * @param id 编号
     * @return 对照组流调-吸烟情况
     */
    ControlSurveySmokingInfoDO getControlSurveySmokingInfo(Long id);

    /**
     * 获得对照组流调-吸烟情况分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-吸烟情况分页
     */
    PageResult<ControlSurveySmokingInfoDO> getControlSurveySmokingInfoPage(ControlSurveySmokingInfoPageReqVO pageReqVO);

}