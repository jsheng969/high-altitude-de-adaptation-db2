package cn.iocoder.yudao.module.review.service.controlexamabdominalultrasound;

import java.util.*;

import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 对照组体检-腹部超声 Service 接口
 *
 * @author 芋道源码
 */
public interface ControlExamAbdominalUltrasoundService {

    /**
     * 创建对照组体检-腹部超声
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlExamAbdominalUltrasound(@Valid ControlExamAbdominalUltrasoundSaveReqVO createReqVO);

    /**
     * 更新对照组体检-腹部超声
     *
     * @param updateReqVO 更新信息
     */
    void updateControlExamAbdominalUltrasound(@Valid ControlExamAbdominalUltrasoundSaveReqVO updateReqVO);

    /**
     * 删除对照组体检-腹部超声
     *
     * @param id 编号
     */
    void deleteControlExamAbdominalUltrasound(Long id);

    /**
     * 获得对照组体检-腹部超声
     *
     * @param id 编号
     * @return 对照组体检-腹部超声
     */
    ControlExamAbdominalUltrasoundDO getControlExamAbdominalUltrasound(Long id);

    /**
     * 获得对照组体检-腹部超声分页
     *
     * @param pageReqVO 分页查询
     * @return 对照组体检-腹部超声分页
     */
    PageResult<ControlExamAbdominalUltrasoundDO> getControlExamAbdominalUltrasoundPage(ControlExamAbdominalUltrasoundPageReqVO pageReqVO);

}