package cn.iocoder.yudao.module.review.service.experimentexambasictests;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambasictests.ExperimentExamBasicTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexambasictests.ExperimentExamBasicTestsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-基本检测信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamBasicTestsServiceImpl implements ExperimentExamBasicTestsService {

    @Resource
    private ExperimentExamBasicTestsMapper experimentExamBasicTestsMapper;

    @Override
    public Long createExperimentExamBasicTests(ExperimentExamBasicTestsSaveReqVO createReqVO) {
        // 插入
        ExperimentExamBasicTestsDO experimentExamBasicTests = BeanUtils.toBean(createReqVO, ExperimentExamBasicTestsDO.class);
        experimentExamBasicTestsMapper.insert(experimentExamBasicTests);
        // 返回
        return experimentExamBasicTests.getId();
    }

    @Override
    public void updateExperimentExamBasicTests(ExperimentExamBasicTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamBasicTestsExists(updateReqVO.getId());
        // 更新
        ExperimentExamBasicTestsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamBasicTestsDO.class);
        experimentExamBasicTestsMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamBasicTests(Long id) {
        // 校验存在
        validateExperimentExamBasicTestsExists(id);
        // 删除
        experimentExamBasicTestsMapper.deleteById(id);
    }

    private void validateExperimentExamBasicTestsExists(Long id) {
        if (experimentExamBasicTestsMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_BASIC_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamBasicTestsDO getExperimentExamBasicTests(Long id) {
        return experimentExamBasicTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamBasicTestsDO> getExperimentExamBasicTestsPage(ExperimentExamBasicTestsPageReqVO pageReqVO) {
        return experimentExamBasicTestsMapper.selectPage(pageReqVO);
    }

}