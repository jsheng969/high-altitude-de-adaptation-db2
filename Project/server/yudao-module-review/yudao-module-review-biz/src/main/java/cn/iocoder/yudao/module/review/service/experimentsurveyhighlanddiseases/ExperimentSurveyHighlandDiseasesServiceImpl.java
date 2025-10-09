package cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseases;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-高原疾病诊断 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyHighlandDiseasesServiceImpl implements ExperimentSurveyHighlandDiseasesService {

    @Resource
    private ExperimentSurveyHighlandDiseasesMapper experimentSurveyHighlandDiseasesMapper;

    @Override
    public Long createExperimentSurveyHighlandDiseases(ExperimentSurveyHighlandDiseasesSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyHighlandDiseasesDO experimentSurveyHighlandDiseases = BeanUtils.toBean(createReqVO, ExperimentSurveyHighlandDiseasesDO.class);
        experimentSurveyHighlandDiseasesMapper.insert(experimentSurveyHighlandDiseases);
        // 返回
        return experimentSurveyHighlandDiseases.getId();
    }

    @Override
    public void updateExperimentSurveyHighlandDiseases(ExperimentSurveyHighlandDiseasesSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyHighlandDiseasesDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandDiseasesDO.class);
        experimentSurveyHighlandDiseasesMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentSurveyHighlandDiseasesByPersonId(ExperimentSurveyHighlandDiseasesSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentSurveyHighlandDiseasesDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentSurveyHighlandDiseasesDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentSurveyHighlandDiseasesDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandDiseasesDO.class);
        experimentSurveyHighlandDiseasesMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentSurveyHighlandDiseases(Long id) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesExists(id);
        // 删除
        experimentSurveyHighlandDiseasesMapper.deleteById(id);
    }

    private void validateExperimentSurveyHighlandDiseasesExists(Long id) {
        if (experimentSurveyHighlandDiseasesMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_HIGHLAND_DISEASES_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyHighlandDiseasesDO getExperimentSurveyHighlandDiseases(Long id) {
        return experimentSurveyHighlandDiseasesMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyHighlandDiseasesDO> getExperimentSurveyHighlandDiseasesPage(ExperimentSurveyHighlandDiseasesPageReqVO pageReqVO) {
        return experimentSurveyHighlandDiseasesMapper.selectPage(pageReqVO);
    }

}