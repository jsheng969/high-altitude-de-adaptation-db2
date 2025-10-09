package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyselfassessment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyselfassessment.ProspectiveExperimentSurveySelfAssessmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.*;

/**
 * 自我评价 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveExperimentSurveySelfAssessmentMapper extends BaseMapperX<ProspectiveExperimentSurveySelfAssessmentDO> {

    default PageResult<ProspectiveExperimentSurveySelfAssessmentDO> selectPage(ExperimentSurveySelfAssessmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveExperimentSurveySelfAssessmentDO>()
                .eqIfPresent(ProspectiveExperimentSurveySelfAssessmentDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveExperimentSurveySelfAssessmentDO::getHealthComparisonWithPeers, reqVO.getHealthComparisonWithPeers())
                .eqIfPresent(ProspectiveExperimentSurveySelfAssessmentDO::getHealthScore, reqVO.getHealthScore())
                .betweenIfPresent(ProspectiveExperimentSurveySelfAssessmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProspectiveExperimentSurveySelfAssessmentDO::getId));
    }

}