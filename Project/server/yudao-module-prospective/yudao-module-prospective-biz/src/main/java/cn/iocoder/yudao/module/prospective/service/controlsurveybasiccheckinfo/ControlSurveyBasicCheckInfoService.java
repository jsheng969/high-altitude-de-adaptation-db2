package cn.iocoder.yudao.module.prospective.service.controlsurveybasiccheckinfo;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 对照组流调-基本检测信息 Service 接口
 *
 * @author 管理员
 */
public interface ControlSurveyBasicCheckInfoService {

    /**
     * 创建对照组流调-基本检测信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyBasicCheckInfo(@Valid ControlSurveyBasicCheckInfoSaveReqVO createReqVO);

    /**
     * 更新对照组流调-基本检测信息
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyBasicCheckInfo(@Valid ControlSurveyBasicCheckInfoSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-基本检测信息
     *
     * @param id 编号
     */
    void deleteControlSurveyBasicCheckInfo(Long id);

    /**
     * 获得对照组流调-基本检测信息
     *
     * @param id 编号
     * @return 对照组流调-基本检测信息
     */
    ControlSurveyBasicCheckInfoDO getControlSurveyBasicCheckInfo(Long id);

    /**
     * 获得对照组流调-基本检测信息分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-基本检测信息分页
     */
    PageResult<ControlSurveyBasicCheckInfoDO> getControlSurveyBasicCheckInfoPage(ControlSurveyBasicCheckInfoPageReqVO pageReqVO);

}