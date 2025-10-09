package cn.iocoder.yudao.module.review.service.experimentexamecg;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamecg.ExperimentExamEcgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentexamecg.ExperimentExamEcgMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组体检-心电图 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentExamEcgServiceImpl implements ExperimentExamEcgService {

    @Resource
    private ExperimentExamEcgMapper experimentExamEcgMapper;

    @Override
    public Long createExperimentExamEcg(ExperimentExamEcgSaveReqVO createReqVO) {
        // 插入
        ExperimentExamEcgDO experimentExamEcg = BeanUtils.toBean(createReqVO, ExperimentExamEcgDO.class);
        experimentExamEcgMapper.insert(experimentExamEcg);
        // 返回
        return experimentExamEcg.getId();
    }

    @Override
    public void updateExperimentExamEcg(ExperimentExamEcgSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamEcgExists(updateReqVO.getId());
        // 更新
        ExperimentExamEcgDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamEcgDO.class);
        experimentExamEcgMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamEcg(Long id) {
        // 校验存在
        validateExperimentExamEcgExists(id);
        // 删除
        experimentExamEcgMapper.deleteById(id);
    }

    private void validateExperimentExamEcgExists(Long id) {
        if (experimentExamEcgMapper.selectById(id) == null) {
            throw exception(EXPERIMENTAL_EXAM_ECG_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamEcgDO getExperimentExamEcg(Long id) {
        return experimentExamEcgMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamEcgDO> getExperimentExamEcgPage(ExperimentExamEcgPageReqVO pageReqVO) {
        return experimentExamEcgMapper.selectPage(pageReqVO);
    }

}