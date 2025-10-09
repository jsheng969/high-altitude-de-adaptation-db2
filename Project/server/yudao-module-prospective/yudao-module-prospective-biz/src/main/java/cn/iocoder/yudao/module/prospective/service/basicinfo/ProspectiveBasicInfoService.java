package cn.iocoder.yudao.module.prospective.service.basicinfo;

import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicinfo.ProspectiveBasicInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 基础信息 Service 接口
 *
 * @author 管理员
 */
public interface ProspectiveBasicInfoService {

    /**
     * 创建基础信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBasicInfo(@Valid BasicInfoSaveReqVO createReqVO);

    /**
     * 更新基础信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBasicInfo(@Valid BasicInfoSaveReqVO updateReqVO);

    /**
     * 删除基础信息
     *
     * @param id 编号
     */
    void deleteBasicInfo(Long id);

    /**
     * 获得基础信息
     *
     * @param id 编号
     * @return 基础信息
     */
    ProspectiveBasicInfoDO getBasicInfo(Long id);

    /**
     * 获得基础信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基础信息分页
     */
    PageResult<ProspectiveBasicInfoDO> getBasicInfoPage(BasicInfoPageReqVO pageReqVO);

    public List<ProspectiveBasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO);

    PageResult<ProspectiveBasicInfoDO> getDataByParamPage(BasicInfoPageReqVO pageReqVO);

    BasicInfoAverageVO getAverageByParam(BasicInfoPageReqVO pageReqVO);

    Integer getVipNumber1();

    Integer getVipNumber2();

    Integer getVipNumber3();

    BasicInfoAverageVO getQueue1();

    BasicInfoAverageVO getQueue2();

    BasicInfoAverageVO getQueue3();

    BasicInfoAverageVO getTimePoint(BasicInfoPageReqVO basicInfoReqVO);

    List<Map<String, Object>> getQueue1EthnicityCount();

    List<Map<String, Object>> getQueue2EthnicityCount();

    BasicInfoAverageVO getMissionPointAltitudeCount();

    BasicInfoAverageVO getClinicalSymptomsData(BasicInfoPageReqVO basicInfoReqVO);

    BasicInfoAverageVO getExamData(BasicInfoPageReqVO basicInfoReqVO);

}