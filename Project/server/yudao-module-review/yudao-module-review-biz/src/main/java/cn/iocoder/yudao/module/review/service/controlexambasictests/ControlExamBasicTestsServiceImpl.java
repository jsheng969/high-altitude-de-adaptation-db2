package cn.iocoder.yudao.module.review.service.controlexambasictests;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambasictests.ControlExamBasicTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexambasictests.ControlExamBasicTestsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-基本检测信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamBasicTestsServiceImpl implements ControlExamBasicTestsService {

    @Resource
    private ControlExamBasicTestsMapper controlExamBasicTestsMapper;

    @Override
    public Long createControlExamBasicTests(ControlExamBasicTestsSaveReqVO createReqVO) {
        // 插入
        ControlExamBasicTestsDO controlExamBasicTests = BeanUtils.toBean(createReqVO, ControlExamBasicTestsDO.class);
        controlExamBasicTestsMapper.insert(controlExamBasicTests);
        // 返回
        return controlExamBasicTests.getId();
    }

    @Override
    public void updateControlExamBasicTests(ControlExamBasicTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamBasicTestsExists(updateReqVO.getId());
        // 更新
        ControlExamBasicTestsDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBasicTestsDO.class);
        controlExamBasicTestsMapper.updateById(updateObj);
    }

    @Override
    public void updateControlExamBasicTestsByPersonId(ControlExamBasicTestsSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ControlExamBasicTestsDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ControlExamBasicTestsDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ControlExamBasicTestsDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBasicTestsDO.class);
        controlExamBasicTestsMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteControlExamBasicTests(Long id) {
        // 校验存在
        validateControlExamBasicTestsExists(id);
        // 删除
        controlExamBasicTestsMapper.deleteById(id);
    }

    private void validateControlExamBasicTestsExists(Long id) {
        if (controlExamBasicTestsMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_BASIC_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamBasicTestsDO getControlExamBasicTests(Long id) {
        return controlExamBasicTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamBasicTestsDO> getControlExamBasicTestsPage(ControlExamBasicTestsPageReqVO pageReqVO) {
        return controlExamBasicTestsMapper.selectPage(pageReqVO);
    }

}