package cn.iocoder.yudao.module.prospective.service.experimentexamcoagulationtests;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamcoagulationtests.ExperimentExamCoagulationTestsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentexamcoagulationtests.ExperimentExamCoagulationTestsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-凝血功能 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentExamCoagulationTestsServiceImpl implements ExperimentExamCoagulationTestsService {

    @Resource
    private ExperimentExamCoagulationTestsMapper experimentExamCoagulationTestsMapper;

    @Override
    public Long createExperimentExamCoagulationTests(ExperimentExamCoagulationTestsSaveReqVO createReqVO) {
        // 插入
        ExperimentExamCoagulationTestsDO experimentExamCoagulationTests = BeanUtils.toBean(createReqVO, ExperimentExamCoagulationTestsDO.class);
        experimentExamCoagulationTestsMapper.insert(experimentExamCoagulationTests);
        // 返回
        return experimentExamCoagulationTests.getId();
    }

    @Override
    public void updateExperimentExamCoagulationTests(ExperimentExamCoagulationTestsSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamCoagulationTestsExists(updateReqVO.getId());
        // 更新
        ExperimentExamCoagulationTestsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamCoagulationTestsDO.class);
        experimentExamCoagulationTestsMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentExamCoagulationTestsByPersionId(ExperimentExamCoagulationTestsSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentExamCoagulationTestsDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentExamCoagulationTestsDO::getPersonId, updateReqVO.getPersonId());
        updateWrapper.eq(ExperimentExamCoagulationTestsDO::getTimePoint, updateReqVO.getTimePoint());
        // 更新
        ExperimentExamCoagulationTestsDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamCoagulationTestsDO.class);
        experimentExamCoagulationTestsMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentExamCoagulationTests(Long id) {
        // 校验存在
        validateExperimentExamCoagulationTestsExists(id);
        // 删除
        experimentExamCoagulationTestsMapper.deleteById(id);
    }

    private void validateExperimentExamCoagulationTestsExists(Long id) {
        if (experimentExamCoagulationTestsMapper.selectById(id) == null) {
            throw exception(EXPERMENT_EXAM_COAGULATION_TESTS_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamCoagulationTestsDO getExperimentExamCoagulationTests(Long id) {
        return experimentExamCoagulationTestsMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamCoagulationTestsDO> getExperimentExamCoagulationTestsPage(ExperimentExamCoagulationTestsPageReqVO pageReqVO) {
        return experimentExamCoagulationTestsMapper.selectPage(pageReqVO);
    }

}