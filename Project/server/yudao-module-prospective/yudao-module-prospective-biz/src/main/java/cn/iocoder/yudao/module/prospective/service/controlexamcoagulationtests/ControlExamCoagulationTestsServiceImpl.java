package cn.iocoder.yudao.module.prospective.service.controlexamcoagulationtests;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamcoagulationtests.ControlExamCoagulationTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.controlexamcoagulationtests.ControlExamCoagulationTestsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-凝血功能 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlExamCoagulationTestsServiceImpl implements ControlExamCoagulationTestsService {

    @Resource
    private ControlExamCoagulationTestsMapper controlExamCoagulationTestsMapper;

    @Override
    public Long createControlExamCoagulationTests(ControlExamCoagulationTestsSaveReqVO createReqVO) {
        // 插入
        ControlExamCoagulationTestsDO controlExamCoagulationTests = BeanUtils.toBean(createReqVO, ControlExamCoagulationTestsDO.class);
        controlExamCoagulationTestsMapper.insert(controlExamCoagulationTests);
        // 返回
        return controlExamCoagulationTests.getId();
    }

    @Override
    public void updateControlExamCoagulationTests(ControlExamCoagulationTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamCoagulationTestsExists(updateReqVO.getId());
        // 更新
        ControlExamCoagulationTestsDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamCoagulationTestsDO.class);
        controlExamCoagulationTestsMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlExamCoagulationTests(Long id) {
        // 校验存在
        validateControlExamCoagulationTestsExists(id);
        // 删除
        controlExamCoagulationTestsMapper.deleteById(id);
    }

    private void validateControlExamCoagulationTestsExists(Long id) {
        if (controlExamCoagulationTestsMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_COAGULATION_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamCoagulationTestsDO getControlExamCoagulationTests(Long id) {
        return controlExamCoagulationTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamCoagulationTestsDO> getControlExamCoagulationTestsPage(ControlExamCoagulationTestsPageReqVO pageReqVO) {
        return controlExamCoagulationTestsMapper.selectPage(pageReqVO);
    }

}