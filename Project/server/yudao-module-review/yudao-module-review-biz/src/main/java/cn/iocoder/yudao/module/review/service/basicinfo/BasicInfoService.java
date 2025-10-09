package cn.iocoder.yudao.module.review.service.basicinfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicinfo.BasicInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 基础信息 Service 接口
 *
 * @author 芋道源码
 */
public interface BasicInfoService {

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
    BasicInfoDO getBasicInfo(Long id);

    /**
     * 获得基础信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基础信息分页
     */
    PageResult<BasicInfoDO> getBasicInfoPage(BasicInfoPageReqVO pageReqVO);

    PageResult<BasicInfoDO> getDataByParamPage(BasicInfoPageReqVO pageReqVO);

    List<BasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO);

    public BasicInfoAverageVO getAverageByParam(BasicInfoPageReqVO pageReqVO);
}