package cn.iocoder.yudao.module.review.service.controlexampastmedicalhistory;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexampastmedicalhistory.ControlExamPastMedicalHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexampastmedicalhistory.ControlExamPastMedicalHistoryMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-既往病史 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamPastMedicalHistoryServiceImpl implements ControlExamPastMedicalHistoryService {

    @Resource
    private ControlExamPastMedicalHistoryMapper controlExamPastMedicalHistoryMapper;

    @Override
    public Long createControlExamPastMedicalHistory(ControlExamPastMedicalHistorySaveReqVO createReqVO) {
        // 插入
        ControlExamPastMedicalHistoryDO controlExamPastMedicalHistory = BeanUtils.toBean(createReqVO, ControlExamPastMedicalHistoryDO.class);
        controlExamPastMedicalHistoryMapper.insert(controlExamPastMedicalHistory);
        // 返回
        return controlExamPastMedicalHistory.getId();
    }

    @Override
    public void updateControlExamPastMedicalHistory(ControlExamPastMedicalHistorySaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamPastMedicalHistoryExists(updateReqVO.getId());
        // 更新
        ControlExamPastMedicalHistoryDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamPastMedicalHistoryDO.class);
        controlExamPastMedicalHistoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamPastMedicalHistory(Long id) {
        // 校验存在
        validateControlExamPastMedicalHistoryExists(id);
        // 删除
        controlExamPastMedicalHistoryMapper.deleteById(id);
    }

    private void validateControlExamPastMedicalHistoryExists(Long id) {
        if (controlExamPastMedicalHistoryMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_PAST_MEDICAL_HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamPastMedicalHistoryDO getControlExamPastMedicalHistory(Long id) {
        return controlExamPastMedicalHistoryMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamPastMedicalHistoryDO> getControlExamPastMedicalHistoryPage(ControlExamPastMedicalHistoryPageReqVO pageReqVO) {
        return controlExamPastMedicalHistoryMapper.selectPage(pageReqVO);
    }

}