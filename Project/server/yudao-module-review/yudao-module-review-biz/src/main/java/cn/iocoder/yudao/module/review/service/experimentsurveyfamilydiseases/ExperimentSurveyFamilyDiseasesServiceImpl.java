package cn.iocoder.yudao.module.review.service.experimentsurveyfamilydiseases;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-亲属既往疾病 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyFamilyDiseasesServiceImpl implements ExperimentSurveyFamilyDiseasesService {

    @Resource
    private ExperimentSurveyFamilyDiseasesMapper experimentSurveyFamilyDiseasesMapper;

    @Override
    public Long createExperimentSurveyFamilyDiseases(ExperimentSurveyFamilyDiseasesSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyFamilyDiseasesDO experimentSurveyFamilyDiseases = BeanUtils.toBean(createReqVO, ExperimentSurveyFamilyDiseasesDO.class);
        experimentSurveyFamilyDiseasesMapper.insert(experimentSurveyFamilyDiseases);
        // 返回
        return experimentSurveyFamilyDiseases.getId();
    }

    @Override
    public void updateExperimentSurveyFamilyDiseases(ExperimentSurveyFamilyDiseasesSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyFamilyDiseasesExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyFamilyDiseasesDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyFamilyDiseasesDO.class);
        experimentSurveyFamilyDiseasesMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyFamilyDiseases(Long id) {
        // 校验存在
        validateExperimentSurveyFamilyDiseasesExists(id);
        // 删除
        experimentSurveyFamilyDiseasesMapper.deleteById(id);
    }

    private void validateExperimentSurveyFamilyDiseasesExists(Long id) {
        if (experimentSurveyFamilyDiseasesMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_FAMILY_DISEASES_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyFamilyDiseasesDO getExperimentSurveyFamilyDiseases(Long id) {
        return experimentSurveyFamilyDiseasesMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyFamilyDiseasesDO> getExperimentSurveyFamilyDiseasesPage(ExperimentSurveyFamilyDiseasesPageReqVO pageReqVO) {
        return experimentSurveyFamilyDiseasesMapper.selectPage(pageReqVO);
    }

}