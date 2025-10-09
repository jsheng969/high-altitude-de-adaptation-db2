package cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseasesduringservice;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-高原期间出现的疾病 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyHighlandDiseasesDuringServiceServiceImpl implements ExperimentSurveyHighlandDiseasesDuringServiceService {

    @Resource
    private ExperimentSurveyHighlandDiseasesDuringServiceMapper experimentSurveyHighlandDiseasesDuringServiceMapper;

    @Override
    public Long createExperimentSurveyHighlandDiseasesDuringService(ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyHighlandDiseasesDuringServiceDO experimentSurveyHighlandDiseasesDuringService = BeanUtils.toBean(createReqVO, ExperimentSurveyHighlandDiseasesDuringServiceDO.class);
        experimentSurveyHighlandDiseasesDuringServiceMapper.insert(experimentSurveyHighlandDiseasesDuringService);
        // 返回
        return experimentSurveyHighlandDiseasesDuringService.getId();
    }

    @Override
    public void updateExperimentSurveyHighlandDiseasesDuringService(ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesDuringServiceExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyHighlandDiseasesDuringServiceDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyHighlandDiseasesDuringServiceDO.class);
        experimentSurveyHighlandDiseasesDuringServiceMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyHighlandDiseasesDuringService(Long id) {
        // 校验存在
        validateExperimentSurveyHighlandDiseasesDuringServiceExists(id);
        // 删除
        experimentSurveyHighlandDiseasesDuringServiceMapper.deleteById(id);
    }

    private void validateExperimentSurveyHighlandDiseasesDuringServiceExists(Long id) {
        if (experimentSurveyHighlandDiseasesDuringServiceMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_HIGHLAND_DISEASES_DURING_SERVICE_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyHighlandDiseasesDuringServiceDO getExperimentSurveyHighlandDiseasesDuringService(Long id) {
        return experimentSurveyHighlandDiseasesDuringServiceMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyHighlandDiseasesDuringServiceDO> getExperimentSurveyHighlandDiseasesDuringServicePage(ExperimentSurveyHighlandDiseasesDuringServicePageReqVO pageReqVO) {
        return experimentSurveyHighlandDiseasesDuringServiceMapper.selectPage(pageReqVO);
    }

}