package cn.iocoder.yudao.module.review.service.experimentexambiochemicaltests;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-生化 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamBiochemicalTestsServiceImpl implements ExperimentExamBiochemicalTestsService {

    @Resource
    private ExperimentExamBiochemicalTestsMapper experimentExamBiochemicalTestsMapper;

    @Override
    public Long createExperimentExamBiochemicalTests(ExperimentExamBiochemicalTestsSaveReqVO createReqVO) {
        // 插入
        ExperimentExamBiochemicalTestsDO experimentExamBiochemicalTests = BeanUtils.toBean(createReqVO, ExperimentExamBiochemicalTestsDO.class);
        experimentExamBiochemicalTestsMapper.insert(experimentExamBiochemicalTests);
        // 返回
        return experimentExamBiochemicalTests.getId();
    }

    @Override
    public void updateExperimentExamBiochemicalTests(ExperimentExamBiochemicalTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamBiochemicalTestsExists(updateReqVO.getId());
        // 更新
        ExperimentExamBiochemicalTestsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamBiochemicalTestsDO.class);
        experimentExamBiochemicalTestsMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamBiochemicalTests(Long id) {
        // 校验存在
        validateExperimentExamBiochemicalTestsExists(id);
        // 删除
        experimentExamBiochemicalTestsMapper.deleteById(id);
    }

    private void validateExperimentExamBiochemicalTestsExists(Long id) {
        if (experimentExamBiochemicalTestsMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_BIOCHEMICAL_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamBiochemicalTestsDO getExperimentExamBiochemicalTests(Long id) {
        return experimentExamBiochemicalTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamBiochemicalTestsDO> getExperimentExamBiochemicalTestsPage(ExperimentExamBiochemicalTestsPageReqVO pageReqVO) {
        return experimentExamBiochemicalTestsMapper.selectPage(pageReqVO);
    }

}