package cn.iocoder.yudao.module.review.service.controlexampastmedicalhistory;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexampastmedicalhistory.ControlExamPastMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-既往病史 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamPastMedicalHistoryService {

    /**
     * 创建对照组体检-既往病史
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamPastMedicalHistory(@Valid ControlExamPastMedicalHistorySaveReqVO createReqVO);

    /**
     * 更新对照组体检-既往病史
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamPastMedicalHistory(@Valid ControlExamPastMedicalHistorySaveReqVO updateReqVO);

    /**
     * 删除对照组体检-既往病史
     *
     * @param id 编号
     */
    void deleteControlExamPastMedicalHistory(Long id);

    /**
     * 获得对照组体检-既往病史
     *
     * @param id 编号
     * @return 对照组体检-既往病史
     */
    ControlExamPastMedicalHistoryDO getControlExamPastMedicalHistory(Long id);

    /**
     * 获得对照组体检-既往病史分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-既往病史分页
     */
    PageResult<ControlExamPastMedicalHistoryDO> getControlExamPastMedicalHistoryPage(ControlExamPastMedicalHistoryPageReqVO pageReqVO);

}