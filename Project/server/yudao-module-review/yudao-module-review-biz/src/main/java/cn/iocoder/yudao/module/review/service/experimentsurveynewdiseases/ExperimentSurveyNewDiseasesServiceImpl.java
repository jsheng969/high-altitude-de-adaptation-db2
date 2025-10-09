package cn.iocoder.yudao.module.review.service.experimentsurveynewdiseases;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-新发的疾病 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyNewDiseasesServiceImpl implements ExperimentSurveyNewDiseasesService {

    @Resource
    private ExperimentSurveyNewDiseasesMapper experimentSurveyNewDiseasesMapper;

    @Override
    public Long createExperimentSurveyNewDiseases(ExperimentSurveyNewDiseasesSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyNewDiseasesDO experimentSurveyNewDiseases = BeanUtils.toBean(createReqVO, ExperimentSurveyNewDiseasesDO.class);
        experimentSurveyNewDiseasesMapper.insert(experimentSurveyNewDiseases);
        // 返回
        return experimentSurveyNewDiseases.getId();
    }

    @Override
    public void updateExperimentSurveyNewDiseases(ExperimentSurveyNewDiseasesSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyNewDiseasesExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyNewDiseasesDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyNewDiseasesDO.class);
        experimentSurveyNewDiseasesMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyNewDiseases(Long id) {
        // 校验存在
        validateExperimentSurveyNewDiseasesExists(id);
        // 删除
        experimentSurveyNewDiseasesMapper.deleteById(id);
    }

    private void validateExperimentSurveyNewDiseasesExists(Long id) {
        if (experimentSurveyNewDiseasesMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_NEW_DISEASES_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyNewDiseasesDO getExperimentSurveyNewDiseases(Long id) {
        return experimentSurveyNewDiseasesMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyNewDiseasesDO> getExperimentSurveyNewDiseasesPage(ExperimentSurveyNewDiseasesPageReqVO pageReqVO) {
        return experimentSurveyNewDiseasesMapper.selectPage(pageReqVO);
    }

}