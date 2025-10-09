package cn.iocoder.yudao.module.review.service.controlexambiochemicaltests;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambiochemicaltests.ControlExamBiochemicalTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlexambiochemicaltests.ControlExamBiochemicalTestsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 对照组体检-生化 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ControlExamBiochemicalTestsServiceImpl implements ControlExamBiochemicalTestsService {

    @Resource
    private ControlExamBiochemicalTestsMapper controlExamBiochemicalTestsMapper;

    @Override
    public Long createControlExamBiochemicalTests(ControlExamBiochemicalTestsSaveReqVO createReqVO) {
        // 插入
        ControlExamBiochemicalTestsDO controlExamBiochemicalTests = BeanUtils.toBean(createReqVO, ControlExamBiochemicalTestsDO.class);
        controlExamBiochemicalTestsMapper.insert(controlExamBiochemicalTests);
        // 返回
        return controlExamBiochemicalTests.getId();
    }

    @Override
    public void updateControlExamBiochemicalTests(ControlExamBiochemicalTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateControlExamBiochemicalTestsExists(updateReqVO.getId());
        // 更新
        ControlExamBiochemicalTestsDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBiochemicalTestsDO.class);
        controlExamBiochemicalTestsMapper.updateById(updateObj);
    }

    @Override
    public void updateControlExamBiochemicalTestsByPersonId(ControlExamBiochemicalTestsSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ControlExamBiochemicalTestsDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ControlExamBiochemicalTestsDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ControlExamBiochemicalTestsDO updateObj = BeanUtils.toBean(updateReqVO, ControlExamBiochemicalTestsDO.class);
        controlExamBiochemicalTestsMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteControlExamBiochemicalTests(Long id) {
        // 校验存在
        validateControlExamBiochemicalTestsExists(id);
        // 删除
        controlExamBiochemicalTestsMapper.deleteById(id);
    }

    private void validateControlExamBiochemicalTestsExists(Long id) {
        if (controlExamBiochemicalTestsMapper.selectById(id) == null) {
            throw exception(CONTROL_EXAM_BIOCHEMICAL_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ControlExamBiochemicalTestsDO getControlExamBiochemicalTests(Long id) {
        return controlExamBiochemicalTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ControlExamBiochemicalTestsDO> getControlExamBiochemicalTestsPage(ControlExamBiochemicalTestsPageReqVO pageReqVO) {
        return controlExamBiochemicalTestsMapper.selectPage(pageReqVO);
    }

}