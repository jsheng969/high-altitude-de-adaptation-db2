package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyhighlandreaction;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.*;

/**
 * 实验组流调-高原反应信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyHighlandReactionMapper extends BaseMapperX<ExperimentSurveyHighlandReactionDO> {

    default PageResult<ExperimentSurveyHighlandReactionDO> selectPage(ExperimentSurveyHighlandReactionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyHighlandReactionDO>()
                .eqIfPresent(ExperimentSurveyHighlandReactionDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyHighlandReactionDO::getReactionOccurred, reqVO.getReactionOccurred())
                .eqIfPresent(ExperimentSurveyHighlandReactionDO::getReactionCount, reqVO.getReactionCount())
                .eqIfPresent(ExperimentSurveyHighlandReactionDO::getUnclearReactionCount, reqVO.getUnclearReactionCount())
                .eqIfPresent(ExperimentSurveyHighlandReactionDO::getMultipleReactionsChanges, reqVO.getMultipleReactionsChanges())
                .orderByDesc(ExperimentSurveyHighlandReactionDO::getId));
    }

}