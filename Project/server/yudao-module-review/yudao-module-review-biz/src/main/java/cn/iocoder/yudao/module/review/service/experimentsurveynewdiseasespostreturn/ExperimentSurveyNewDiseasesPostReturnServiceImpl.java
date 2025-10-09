package cn.iocoder.yudao.module.review.service.experimentsurveynewdiseasespostreturn;

import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组流调-返回平原后新发的疾病 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ExperimentSurveyNewDiseasesPostReturnServiceImpl implements ExperimentSurveyNewDiseasesPostReturnService {

    @Resource
    private ExperimentSurveyNewDiseasesPostReturnMapper experimentSurveyNewDiseasesPostReturnMapper;

    @Override
    public Long createExperimentSurveyNewDiseasesPostReturn(ExperimentSurveyNewDiseasesPostReturnSaveReqVO createReqVO) {
        // 插入
        ExperimentSurveyNewDiseasesPostReturnDO experimentSurveyNewDiseasesPostReturn = BeanUtils.toBean(createReqVO, ExperimentSurveyNewDiseasesPostReturnDO.class);
        experimentSurveyNewDiseasesPostReturnMapper.insert(experimentSurveyNewDiseasesPostReturn);
        // 返回
        return experimentSurveyNewDiseasesPostReturn.getId();
    }

    @Override
    public void updateExperimentSurveyNewDiseasesPostReturn(ExperimentSurveyNewDiseasesPostReturnSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentSurveyNewDiseasesPostReturnExists(updateReqVO.getId());
        // 更新
        ExperimentSurveyNewDiseasesPostReturnDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentSurveyNewDiseasesPostReturnDO.class);
        experimentSurveyNewDiseasesPostReturnMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentSurveyNewDiseasesPostReturn(Long id) {
        // 校验存在
        validateExperimentSurveyNewDiseasesPostReturnExists(id);
        // 删除
        experimentSurveyNewDiseasesPostReturnMapper.deleteById(id);
    }

    private void validateExperimentSurveyNewDiseasesPostReturnExists(Long id) {
        if (experimentSurveyNewDiseasesPostReturnMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_SURVEY_NEW_DISEASES_POST_RETURN_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentSurveyNewDiseasesPostReturnDO getExperimentSurveyNewDiseasesPostReturn(Long id) {
        return experimentSurveyNewDiseasesPostReturnMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentSurveyNewDiseasesPostReturnDO> getExperimentSurveyNewDiseasesPostReturnPage(ExperimentSurveyNewDiseasesPostReturnPageReqVO pageReqVO) {
        return experimentSurveyNewDiseasesPostReturnMapper.selectPage(pageReqVO);
    }

}