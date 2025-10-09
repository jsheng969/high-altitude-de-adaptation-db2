package cn.iocoder.yudao.module.review.service.controlexamecg;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamecg.ControlExamEcgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexamecg.ControlExamEcgMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-心电图 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamEcgServiceImpl implements ControlExamEcgService {

    @Resource
    private ControlExamEcgMapper controlExamEcgMapper;

    @Override
    public Long createControlExamEcg(ControlExamEcgSaveReqVO createReqVO) {
        // 插入
        ControlExamEcgDO controlExamEcg = BeanUtils.toBean(createReqVO, ControlExamEcgDO.class);
        controlExamEcgMapper.insert(controlExamEcg);
        // 返回
        return controlExamEcg.getId();
    }

    @Override
    public void updateControlExamEcg(ControlExamEcgSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamEcgExists(updateReqVO.getId());
        // 更新
        ControlExamEcgDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamEcgDO.class);
        controlExamEcgMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamEcg(Long id) {
        // 校验存在
        validateControlExamEcgExists(id);
        // 删除
        controlExamEcgMapper.deleteById(id);
    }

    private void validateControlExamEcgExists(Long id) {
        if (controlExamEcgMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_ECG_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamEcgDO getControlExamEcg(Long id) {
        return controlExamEcgMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamEcgDO> getControlExamEcgPage(ControlExamEcgPageReqVO pageReqVO) {
        return controlExamEcgMapper.selectPage(pageReqVO);
    }

}