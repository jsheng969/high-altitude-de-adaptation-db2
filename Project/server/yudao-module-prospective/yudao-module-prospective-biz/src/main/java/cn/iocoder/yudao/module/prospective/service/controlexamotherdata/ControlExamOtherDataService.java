package cn.iocoder.yudao.module.prospective.service.controlexamotherdata;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamotherdata.ControlExamOtherDataDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组体检-其他数据 Service 接口
 *
 * @author 管理员
 */
public interface ControlExamOtherDataService {

    /**
     * 创建实验组体检-其他数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamOtherData(@Valid ControlExamOtherDataSaveReqVO createReqVO);

    /**
     * 更新实验组体检-其他数据
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamOtherData(@Valid ControlExamOtherDataSaveReqVO updateReqVO);

    /**
     * 删除实验组体检-其他数据
     *
     * @param id 编号
     */
    void deleteControlExamOtherData(Long id);

    /**
     * 获得实验组体检-其他数据
     *
     * @param id 编号
     * @return 实验组体检-其他数据
     */
    ControlExamOtherDataDO getControlExamOtherData(Long id);

    /**
     * 获得实验组体检-其他数据分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组体检-其他数据分页
     */
    PageResult<ControlExamOtherDataDO> getControlExamOtherDataPage(ControlExamOtherDataPageReqVO pageReqVO);

}