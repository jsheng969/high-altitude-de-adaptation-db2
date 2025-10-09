package cn.iocoder.yudao.module.review.service.controlexamecg;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamecg.ControlExamEcgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-心电图 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamEcgService {

    /**
     * 创建对照组体检-心电图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamEcg(@Valid ControlExamEcgSaveReqVO createReqVO);

    /**
     * 更新对照组体检-心电图
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamEcg(@Valid ControlExamEcgSaveReqVO updateReqVO);

    /**
     * 删除对照组体检-心电图
     *
     * @param id 编号
     */
    void deleteControlExamEcg(Long id);

    /**
     * 获得对照组体检-心电图
     *
     * @param id 编号
     * @return 对照组体检-心电图
     */
    ControlExamEcgDO getControlExamEcg(Long id);

    /**
     * 获得对照组体检-心电图分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-心电图分页
     */
    PageResult<ControlExamEcgDO> getControlExamEcgPage(ControlExamEcgPageReqVO pageReqVO);

}