package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveysmokinginfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.*;

/**
 * 吸烟信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveySmokingInfoMapper extends BaseMapperX<ExperimentSurveySmokingInfoDO> {

    default PageResult<ExperimentSurveySmokingInfoDO> selectPage(ExperimentSurveySmokingInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveySmokingInfoDO>()
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getSmokingStatus, reqVO.getSmokingStatus())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getDailyCigarettes, reqVO.getDailyCigarettes())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getSmokingStartAge, reqVO.getSmokingStartAge())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getSmokingYears, reqVO.getSmokingYears())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getQuitAttempted, reqVO.getQuitAttempted())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getSmokingRegion, reqVO.getSmokingRegion())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getQuitSmokingYears, reqVO.getQuitSmokingYears())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getQuitSmokingDuration, reqVO.getQuitSmokingDuration())
                .eqIfPresent(ExperimentSurveySmokingInfoDO::getQuitSmokingRegion, reqVO.getQuitSmokingRegion())
                .betweenIfPresent(ExperimentSurveySmokingInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveySmokingInfoDO::getId));
    }

}