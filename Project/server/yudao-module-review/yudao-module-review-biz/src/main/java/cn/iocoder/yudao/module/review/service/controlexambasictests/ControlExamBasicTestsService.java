package cn.iocoder.yudao.module.review.service.controlexambasictests;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambasictests.ControlExamBasicTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-基本检测信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamBasicTestsService {

    /**
     * 创建对照组体检-基本检测信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamBasicTests(@Valid ControlExamBasicTestsSaveReqVO createReqVO);

    /**
     * 更新对照组体检-基本检测信息
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamBasicTests(@Valid ControlExamBasicTestsSaveReqVO updateReqVO);

    void updateControlExamBasicTestsByPersonId(@Valid ControlExamBasicTestsSaveReqVO updateReqVO);

    /**
     * 删除对照组体检-基本检测信息
     *
     * @param id 编号
     */
    void deleteControlExamBasicTests(Long id);

    /**
     * 获得对照组体检-基本检测信息
     *
     * @param id 编号
     * @return 对照组体检-基本检测信息
     */
    ControlExamBasicTestsDO getControlExamBasicTests(Long id);

    /**
     * 获得对照组体检-基本检测信息分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-基本检测信息分页
     */
    PageResult<ControlExamBasicTestsDO> getControlExamBasicTestsPage(ControlExamBasicTestsPageReqVO pageReqVO);

}