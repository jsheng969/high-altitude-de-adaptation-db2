package cn.iocoder.yudao.module.prospective.service.controlexambiochemicaltestsv2;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组体检-生化v2 Service 接口
 *
 * @author 管理员
 */
public interface ControlExamBiochemicalTestsV2Service {

    /**
     * 创建实验组体检-生化v2
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamBiochemicalTestsV2(@Valid ControlExamBiochemicalTestsV2SaveReqVO createReqVO);

    /**
     * 更新实验组体检-生化v2
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamBiochemicalTestsV2(@Valid ControlExamBiochemicalTestsV2SaveReqVO updateReqVO);

    /**
     * 删除实验组体检-生化v2
     *
     * @param id 编号
     */
    void deleteControlExamBiochemicalTestsV2(Long id);

    /**
     * 获得实验组体检-生化v2
     *
     * @param id 编号
     * @return 实验组体检-生化v2
     */
    ControlExamBiochemicalTestsV2DO getControlExamBiochemicalTestsV2(Long id);

    /**
     * 获得实验组体检-生化v2分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-生化v2分页
     */
    PageResult<ControlExamBiochemicalTestsV2DO> getControlExamBiochemicalTestsV2Page(ControlExamBiochemicalTestsV2PageReqVO pageReqVO);

}