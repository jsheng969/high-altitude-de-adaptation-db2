package cn.iocoder.yudao.module.prospective.service.experimentexambiochemicaltestsv2;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2Mapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-生化v2 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentExamBiochemicalTestsV2ServiceImpl implements ExperimentExamBiochemicalTestsV2Service {

    @Resource
    private ExperimentExamBiochemicalTestsV2Mapper experimentExamBiochemicalTestsV2Mapper;

    @Override
    public Long createExperimentExamBiochemicalTestsV2(ExperimentExamBiochemicalTestsV2SaveReqVO createReqVO) {
        // 插入
        ExperimentExamBiochemicalTestsV2DO experimentExamBiochemicalTestsV2 = BeanUtils.toBean(createReqVO, ExperimentExamBiochemicalTestsV2DO.class);
        experimentExamBiochemicalTestsV2Mapper.insert(experimentExamBiochemicalTestsV2);
        // 返回
        return experimentExamBiochemicalTestsV2.getId();
    }

    @Override
    public void updateExperimentExamBiochemicalTestsV2(ExperimentExamBiochemicalTestsV2SaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamBiochemicalTestsV2Exists(updateReqVO.getId());
        // 更新
        ExperimentExamBiochemicalTestsV2DO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamBiochemicalTestsV2DO.class);
        experimentExamBiochemicalTestsV2Mapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentExamBiochemicalTestsV2ByPersionId(ExperimentExamBiochemicalTestsV2SaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentExamBiochemicalTestsV2DO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentExamBiochemicalTestsV2DO::getPersonId, updateReqVO.getPersonId());
        updateWrapper.eq(ExperimentExamBiochemicalTestsV2DO::getTimePoint, updateReqVO.getTimePoint());
        // 更新
        ExperimentExamBiochemicalTestsV2DO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamBiochemicalTestsV2DO.class);
        experimentExamBiochemicalTestsV2Mapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentExamBiochemicalTestsV2(Long id) {
        // 校验存在
        validateExperimentExamBiochemicalTestsV2Exists(id);
        // 删除
        experimentExamBiochemicalTestsV2Mapper.deleteById(id);
    }

    private void validateExperimentExamBiochemicalTestsV2Exists(Long id) {
        if (experimentExamBiochemicalTestsV2Mapper.selectById(id) == null) {
            throw exception(EXPERMENT_EXAM_BIOCHEMICAL_TESTS_V2_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamBiochemicalTestsV2DO getExperimentExamBiochemicalTestsV2(Long id) {
        return experimentExamBiochemicalTestsV2Mapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamBiochemicalTestsV2DO> getExperimentExamBiochemicalTestsV2Page(ExperimentExamBiochemicalTestsV2PageReqVO pageReqVO) {
        return experimentExamBiochemicalTestsV2Mapper.selectPage(pageReqVO);
    }

}