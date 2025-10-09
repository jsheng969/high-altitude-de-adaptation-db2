package cn.iocoder.yudao.module.prospective.service.controlsurveypostreturnsymptoms;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 对照组流调-退役后返回平原1月内症状 Service 接口
 *
 * @author 管理员
 */
public interface ControlSurveyPostReturnSymptomsService {

    /**
     * 创建对照组流调-退役后返回平原1月内症状
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlSurveyPostReturnSymptoms(@Valid ControlSurveyPostReturnSymptomsSaveReqVO createReqVO);

    /**
     * 更新对照组流调-退役后返回平原1月内症状
     *
     * @param updateReqVO 更新信息
     */
    void updateControlSurveyPostReturnSymptoms(@Valid ControlSurveyPostReturnSymptomsSaveReqVO updateReqVO);

    /**
     * 删除对照组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     */
    void deleteControlSurveyPostReturnSymptoms(Long id);

    /**
     * 获得对照组流调-退役后返回平原1月内症状
     *
     * @param id 编号
     * @return 对照组流调-退役后返回平原1月内症状
     */
    ControlSurveyPostReturnSymptomsDO getControlSurveyPostReturnSymptoms(Long id);

    /**
     * 获得对照组流调-退役后返回平原1月内症状分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组流调-退役后返回平原1月内症状分页
     */
    PageResult<ControlSurveyPostReturnSymptomsDO> getControlSurveyPostReturnSymptomsPage(ControlSurveyPostReturnSymptomsPageReqVO pageReqVO);

}