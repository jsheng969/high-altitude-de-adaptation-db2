package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveyacutemountainsicknessrecords;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.*;

/**
 * 高原急性高山病记录 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyAcuteMountainSicknessRecordsMapper extends BaseMapperX<ExperimentSurveyAcuteMountainSicknessRecordsDO> {

    default PageResult<ExperimentSurveyAcuteMountainSicknessRecordsDO> selectPage(ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyAcuteMountainSicknessRecordsDO>()
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getAcuteMountainReaction, reqVO.getAcuteMountainReaction())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getPulmonaryEdema, reqVO.getPulmonaryEdema())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getCerebralEdema, reqVO.getCerebralEdema())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getHighAltitudeHeartDisease, reqVO.getHighAltitudeHeartDisease())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getPolycythemia, reqVO.getPolycythemia())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getOtherDiseases, reqVO.getOtherDiseases())
                .eqIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getOtherDiseasesDesc, reqVO.getOtherDiseasesDesc())
                .betweenIfPresent(ExperimentSurveyAcuteMountainSicknessRecordsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyAcuteMountainSicknessRecordsDO::getId));
    }

}