package cn.iocoder.yudao.module.review.service.basicotherinfo;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo.BasicOtherInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import javax.validation.Valid;

/**
 * 基础其他信息 Service 接口
 *
 * @author 芋道源码
 */
public interface BasicOtherInfoService {

    /**
     * 创建基础其他信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBasicOtherInfo(@Valid BasicOtherInfoSaveReqVO createReqVO);

    /**
     * 更新基础其他信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBasicOtherInfo(@Valid BasicOtherInfoSaveReqVO updateReqVO);

    void updateBasicOtherInfoByPersonId(@Valid BasicOtherInfoSaveReqVO updateReqVO);

    /**
     * 通过条件更新基础其他信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBasicOtherInfoByWrapper(@Valid BasicOtherInfoSaveReqVO updateReqVO, UpdateWrapper<BasicOtherInfoDO> updateWrapper);

    /**
     * 删除基础其他信息
     *
     * @param id 编号
     */
    void deleteBasicOtherInfo(Long id);

    /**
     * 获得基础其他信息
     *
     * @param id 编号
     * @return 基础其他信息
     */
    BasicOtherInfoDO getBasicOtherInfo(Long id);

    /**
     * 获得基础其他信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基础其他信息分页
     */
    PageResult<BasicOtherInfoDO> getBasicOtherInfoPage(BasicOtherInfoPageReqVO pageReqVO);

}