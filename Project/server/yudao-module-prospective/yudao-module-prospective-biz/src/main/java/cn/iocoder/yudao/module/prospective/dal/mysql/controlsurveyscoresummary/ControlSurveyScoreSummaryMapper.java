package cn.iocoder.yudao.module.prospective.dal.mysql.controlsurveyscoresummary;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveyscoresummary.ControlSurveyScoreSummaryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.*;

/**
 * 对照组流调-评分总数统计 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlSurveyScoreSummaryMapper extends BaseMapperX<ControlSurveyScoreSummaryDO> {

    default PageResult<ControlSurveyScoreSummaryDO> selectPage(ControlSurveyScoreSummaryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyScoreSummaryDO>()
                .eqIfPresent(ControlSurveyScoreSummaryDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyScoreSummaryDO::getTotalScore, reqVO.getTotalScore())
                .betweenIfPresent(ControlSurveyScoreSummaryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlSurveyScoreSummaryDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ControlSurveyScoreSummaryDO::getId));
    }

}