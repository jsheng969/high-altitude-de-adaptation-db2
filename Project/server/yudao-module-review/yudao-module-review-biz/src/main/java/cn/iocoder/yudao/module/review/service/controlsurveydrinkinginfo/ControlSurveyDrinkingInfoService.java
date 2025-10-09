package cn.iocoder.yudao.module.review.service.controlsurveydrinkinginfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组流调-饮酒情况 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlSurveyDrinkingInfoService {

    /**
     * 创建对照组流调-饮酒情况
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyDrinkingInfo(@Valid ControlSurveyDrinkingInfoSaveReqVO createReqVO);

    /**
     * 更新对照组流调-饮酒情况
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyDrinkingInfo(@Valid ControlSurveyDrinkingInfoSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-饮酒情况
     *
     * @param id 编号
     */
    void deleteControlSurveyDrinkingInfo(Long id);

    /**
     * 获得对照组流调-饮酒情况
     *
     * @param id 编号
     * @return 对照组流调-饮酒情况
     */
    ControlSurveyDrinkingInfoDO getControlSurveyDrinkingInfo(Long id);

    /**
     * 获得对照组流调-饮酒情况分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-饮酒情况分页
     */
    PageResult<ControlSurveyDrinkingInfoDO> getControlSurveyDrinkingInfoPage(ControlSurveyDrinkingInfoPageReqVO pageReqVO);

}