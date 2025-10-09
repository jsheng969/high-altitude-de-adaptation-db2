package cn.iocoder.yudao.module.review.service.controlexambiochemicaltests;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambiochemicaltests.ControlExamBiochemicalTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-生化 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamBiochemicalTestsService {

    /**
     * 创建对照组体检-生化
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamBiochemicalTests(@Valid ControlExamBiochemicalTestsSaveReqVO createReqVO);

    /**
     * 更新对照组体检-生化
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamBiochemicalTests(@Valid ControlExamBiochemicalTestsSaveReqVO updateReqVO);

    void updateControlExamBiochemicalTestsByPersonId(@Valid ControlExamBiochemicalTestsSaveReqVO updateReqVO);

    /**
     * 删除对照组体检-生化
     *
     * @param id 编号
     */
    void deleteControlExamBiochemicalTests(Long id);

    /**
     * 获得对照组体检-生化
     *
     * @param id 编号
     * @return 对照组体检-生化
     */
    ControlExamBiochemicalTestsDO getControlExamBiochemicalTests(Long id);

    /**
     * 获得对照组体检-生化分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-生化分页
     */
    PageResult<ControlExamBiochemicalTestsDO> getControlExamBiochemicalTestsPage(ControlExamBiochemicalTestsPageReqVO pageReqVO);

}