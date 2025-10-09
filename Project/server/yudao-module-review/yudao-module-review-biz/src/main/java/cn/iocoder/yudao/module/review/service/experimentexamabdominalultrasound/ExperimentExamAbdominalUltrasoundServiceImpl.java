package cn.iocoder.yudao.module.review.service.experimentexamabdominalultrasound;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-腹部超声 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamAbdominalUltrasoundServiceImpl implements ExperimentExamAbdominalUltrasoundService {

    @Resource
    private ExperimentExamAbdominalUltrasoundMapper experimentExamAbdominalUltrasoundMapper;

    @Override
    public Long createExperimentExamAbdominalUltrasound(ExperimentExamAbdominalUltrasoundSaveReqVO createReqVO) {
        // 插入
        ExperimentExamAbdominalUltrasoundDO experimentExamAbdominalUltrasound = BeanUtils.toBean(createReqVO, ExperimentExamAbdominalUltrasoundDO.class);
        experimentExamAbdominalUltrasoundMapper.insert(experimentExamAbdominalUltrasound);
        // 返回
        return experimentExamAbdominalUltrasound.getId();
    }

    @Override
    public void updateExperimentExamAbdominalUltrasound(ExperimentExamAbdominalUltrasoundSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamAbdominalUltrasoundExists(updateReqVO.getId());
        // 更新
        ExperimentExamAbdominalUltrasoundDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamAbdominalUltrasoundDO.class);
        experimentExamAbdominalUltrasoundMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamAbdominalUltrasound(Long id) {
        // 校验存在
        validateExperimentExamAbdominalUltrasoundExists(id);
        // 删除
        experimentExamAbdominalUltrasoundMapper.deleteById(id);
    }

    private void validateExperimentExamAbdominalUltrasoundExists(Long id) {
        if (experimentExamAbdominalUltrasoundMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_ABDOMINAL_ULTRASOUND_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamAbdominalUltrasoundDO getExperimentExamAbdominalUltrasound(Long id) {
        return experimentExamAbdominalUltrasoundMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamAbdominalUltrasoundDO> getExperimentExamAbdominalUltrasoundPage(ExperimentExamAbdominalUltrasoundPageReqVO pageReqVO) {
        return experimentExamAbdominalUltrasoundMapper.selectPage(pageReqVO);
    }

}