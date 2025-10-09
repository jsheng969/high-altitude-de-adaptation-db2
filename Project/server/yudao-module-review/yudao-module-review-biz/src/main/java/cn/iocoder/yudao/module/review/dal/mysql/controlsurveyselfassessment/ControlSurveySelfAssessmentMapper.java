package cn.iocoder.yudao.module.review.dal.mysql.controlsurveyselfassessment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyselfassessment.ControlSurveySelfAssessmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.*;

/**
 * 对照组流调-自我评价 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlSurveySelfAssessmentMapper extends BaseMapperX<ControlSurveySelfAssessmentDO> {

    default PageResult<ControlSurveySelfAssessmentDO> selectPage(ControlSurveySelfAssessmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveySelfAssessmentDO>()
                .eqIfPresent(ControlSurveySelfAssessmentDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveySelfAssessmentDO::getAnnualCheckups, reqVO.getAnnualCheckups())
                .eqIfPresent(ControlSurveySelfAssessmentDO::getHealthComparison, reqVO.getHealthComparison())
                .eqIfPresent(ControlSurveySelfAssessmentDO::getHealthScore, reqVO.getHealthScore())
                .orderByDesc(ControlSurveySelfAssessmentDO::getId));
    }

}