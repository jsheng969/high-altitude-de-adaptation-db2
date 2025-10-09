package cn.iocoder.yudao.module.prospective.service.controlexamcoagulationtests;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamcoagulationtests.ControlExamCoagulationTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组体检-凝血功能 Service 接口
 *
 * @author 管理员
 */
public interface ControlExamCoagulationTestsService {

    /**
     * 创建实验组体检-凝血功能
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamCoagulationTests(@Valid ControlExamCoagulationTestsSaveReqVO createReqVO);

    /**
     * 更新实验组体检-凝血功能
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamCoagulationTests(@Valid ControlExamCoagulationTestsSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-凝血功能
     *
     * @param id 编号
     */
    void deleteControlExamCoagulationTests(Long id);

    /**
     * 获得实验组体检-凝血功能
     *
     * @param id 编号
     * @return 实验组体检-凝血功能
     */
    ControlExamCoagulationTestsDO getControlExamCoagulationTests(Long id);

    /**
     * 获得实验组体检-凝血功能分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-凝血功能分页
     */
    PageResult<ControlExamCoagulationTestsDO> getControlExamCoagulationTestsPage(ControlExamCoagulationTestsPageReqVO pageReqVO);

}