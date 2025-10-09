package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyselfassessment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.*;

/**
 * 实验组流调-自我评价 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveySelfAssessmentMapper extends BaseMapperX<ExperimentSurveySelfAssessmentDO> {

    default PageResult<ExperimentSurveySelfAssessmentDO> selectPage(ExperimentSurveySelfAssessmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveySelfAssessmentDO>()
                .eqIfPresent(ExperimentSurveySelfAssessmentDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveySelfAssessmentDO::getHealthComparisonWithPeers, reqVO.getHealthComparisonWithPeers())
                .eqIfPresent(ExperimentSurveySelfAssessmentDO::getHealthScore, reqVO.getHealthScore())
                .orderByDesc(ExperimentSurveySelfAssessmentDO::getId));
    }

}