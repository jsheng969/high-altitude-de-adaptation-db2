package cn.iocoder.yudao.module.prospective.service.basicotherinfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicotherinfo.ProspectiveBasicOtherInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基础其他信息 Service 接口
 *
 * @author 管理员
 */
public interface ProspectiveBasicOtherInfoService {

    /**
     * 创建基础其他信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentSurveyBasicOtherInfo(@Valid BasicOtherInfoSaveReqVO createReqVO);

    /**
     * 更新基础其他信息
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentSurveyBasicOtherInfo(@Valid BasicOtherInfoSaveReqVO updateReqVO);

    /**
     * 删除基础其他信息
     *
     * @param id 编号
     */
    void deleteExperimentSurveyBasicOtherInfo(Long id);

    /**
     * 获得基础其他信息
     *
     * @param id 编号
     * @return 基础其他信息
     */
    ProspectiveBasicOtherInfoDO getExperimentSurveyBasicOtherInfo(Long id);

    /**
     * 获得基础其他信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基础其他信息分页
     */
    PageResult<ProspectiveBasicOtherInfoDO> getExperimentSurveyBasicOtherInfoPage(BasicOtherInfoPageReqVO pageReqVO);

}