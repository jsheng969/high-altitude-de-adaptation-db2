package cn.iocoder.yudao.module.prospective.service.controlexambiochemicaltestsv2;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2Mapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-生化v2 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlExamBiochemicalTestsV2ServiceImpl implements ControlExamBiochemicalTestsV2Service {

    @Resource
    private ControlExamBiochemicalTestsV2Mapper controlExamBiochemicalTestsV2Mapper;

    @Override
    public Long createControlExamBiochemicalTestsV2(ControlExamBiochemicalTestsV2SaveReqVO createReqVO) {
        // 插入
        ControlExamBiochemicalTestsV2DO controlExamBiochemicalTestsV2 = BeanUtils.toBean(createReqVO, ControlExamBiochemicalTestsV2DO.class);
        controlExamBiochemicalTestsV2Mapper.insert(controlExamBiochemicalTestsV2);
        // 返回
        return controlExamBiochemicalTestsV2.getId();
    }

    @Override
    public void updateControlExamBiochemicalTestsV2(ControlExamBiochemicalTestsV2SaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamBiochemicalTestsV2Exists(updateReqVO.getId());
        // 更新
        ControlExamBiochemicalTestsV2DO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBiochemicalTestsV2DO.class);
        controlExamBiochemicalTestsV2Mapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamBiochemicalTestsV2(Long id) {
        // 校验存在
        validateControlExamBiochemicalTestsV2Exists(id);
        // 删除
        controlExamBiochemicalTestsV2Mapper.deleteById(id);
    }

    private void validateControlExamBiochemicalTestsV2Exists(Long id) {
        if (controlExamBiochemicalTestsV2Mapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_BIOCHEMICAL_TESTS_V2_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamBiochemicalTestsV2DO getControlExamBiochemicalTestsV2(Long id) {
        return controlExamBiochemicalTestsV2Mapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamBiochemicalTestsV2DO> getControlExamBiochemicalTestsV2Page(ControlExamBiochemicalTestsV2PageReqVO pageReqVO) {
        return controlExamBiochemicalTestsV2Mapper.selectPage(pageReqVO);
    }

}