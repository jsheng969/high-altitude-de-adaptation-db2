package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyscoresummary;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.*;

/**
 * 评分总数统计 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyScoreSummaryMapper extends BaseMapperX<ExperimentSurveyScoreSummaryDO> {

    default PageResult<ExperimentSurveyScoreSummaryDO> selectPage(ExperimentSurveyScoreSummaryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyScoreSummaryDO>()
                .eqIfPresent(ExperimentSurveyScoreSummaryDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyScoreSummaryDO::getTotalScore, reqVO.getTotalScore())
                .betweenIfPresent(ExperimentSurveyScoreSummaryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyScoreSummaryDO::getId));
    }

}