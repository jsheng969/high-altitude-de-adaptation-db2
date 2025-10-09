package cn.iocoder.yudao.module.review.service.controlexamabdominalultrasound;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-腹部超声 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamAbdominalUltrasoundServiceImpl implements ControlExamAbdominalUltrasoundService {

    @Resource
    private ControlExamAbdominalUltrasoundMapper controlExamAbdominalUltrasoundMapper;

    @Override
    public Long createControlExamAbdominalUltrasound(ControlExamAbdominalUltrasoundSaveReqVO createReqVO) {
        // 插入
        ControlExamAbdominalUltrasoundDO controlExamAbdominalUltrasound = BeanUtils.toBean(createReqVO, ControlExamAbdominalUltrasoundDO.class);
        controlExamAbdominalUltrasoundMapper.insert(controlExamAbdominalUltrasound);
        // 返回
        return controlExamAbdominalUltrasound.getId();
    }

    @Override
    public void updateControlExamAbdominalUltrasound(ControlExamAbdominalUltrasoundSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamAbdominalUltrasoundExists(updateReqVO.getId());
        // 更新
        ControlExamAbdominalUltrasoundDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamAbdominalUltrasoundDO.class);
        controlExamAbdominalUltrasoundMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamAbdominalUltrasound(Long id) {
        // 校验存在
        validateControlExamAbdominalUltrasoundExists(id);
        // 删除
        controlExamAbdominalUltrasoundMapper.deleteById(id);
    }

    private void validateControlExamAbdominalUltrasoundExists(Long id) {
        if (controlExamAbdominalUltrasoundMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_ABDOMINAL_ULTRASOUND_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamAbdominalUltrasoundDO getControlExamAbdominalUltrasound(Long id) {
        return controlExamAbdominalUltrasoundMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamAbdominalUltrasoundDO> getControlExamAbdominalUltrasoundPage(ControlExamAbdominalUltrasoundPageReqVO pageReqVO) {
        return controlExamAbdominalUltrasoundMapper.selectPage(pageReqVO);
    }

}