package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveypostreturninfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.*;

/**
 * 实验组流调-返回后基础信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyPostReturnInfoMapper extends BaseMapperX<ExperimentSurveyPostReturnInfoDO> {

    default PageResult<ExperimentSurveyPostReturnInfoDO> selectPage(ExperimentSurveyPostReturnInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyPostReturnInfoDO>()
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getChengdu, reqVO.getChengdu())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getChengduResidenceTime, reqVO.getChengduResidenceTime())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getKunming, reqVO.getKunming())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getKunmingResidenceTime, reqVO.getKunmingResidenceTime())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getXining, reqVO.getXining())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getXiningResidenceTime, reqVO.getXiningResidenceTime())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getOtherArea, reqVO.getOtherArea())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getOtherAreaResidenceTime, reqVO.getOtherAreaResidenceTime())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getPostReturnWorkStatus, reqVO.getPostReturnWorkStatus())
                .eqIfPresent(ExperimentSurveyPostReturnInfoDO::getAnnualCheckups, reqVO.getAnnualCheckups())
                .orderByDesc(ExperimentSurveyPostReturnInfoDO::getId));
    }

}