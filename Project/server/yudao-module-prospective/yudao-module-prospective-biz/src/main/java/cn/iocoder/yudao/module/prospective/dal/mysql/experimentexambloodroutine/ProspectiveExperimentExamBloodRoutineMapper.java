package cn.iocoder.yudao.module.prospective.dal.mysql.experimentexambloodroutine;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambloodroutine.ProspectiveExperimentExamBloodRoutineDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.*;

/**
 * 实验组体检-血常规 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveExperimentExamBloodRoutineMapper extends BaseMapperX<ProspectiveExperimentExamBloodRoutineDO> {

    default PageResult<ProspectiveExperimentExamBloodRoutineDO> selectPage(ExperimentExamBloodRoutinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveExperimentExamBloodRoutineDO>()
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getWbcCount, reqVO.getWbcCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getLymphocytePercent, reqVO.getLymphocytePercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMidCellPercent, reqVO.getMidCellPercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getGranulocytePercent, reqVO.getGranulocytePercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getLymphocyteCount, reqVO.getLymphocyteCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMidCellCount, reqVO.getMidCellCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getGranulocyteCount, reqVO.getGranulocyteCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getRbcCount, reqVO.getRbcCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getHemoglobin, reqVO.getHemoglobin())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getHematocrit, reqVO.getHematocrit())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMcv, reqVO.getMcv())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMch, reqVO.getMch())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMchc, reqVO.getMchc())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getRdwCv, reqVO.getRdwCv())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getRdwSd, reqVO.getRdwSd())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getPlateletCount, reqVO.getPlateletCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMpv, reqVO.getMpv())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getPdw, reqVO.getPdw())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getPct, reqVO.getPct())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getLargePlateletRatio, reqVO.getLargePlateletRatio())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getLargePlateletCount, reqVO.getLargePlateletCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getBasophilCount, reqVO.getBasophilCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getBasophilPercent, reqVO.getBasophilPercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getEosinophilCount, reqVO.getEosinophilCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getEosinophilPercent, reqVO.getEosinophilPercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getImmatureGranulocyteCount, reqVO.getImmatureGranulocyteCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getImmatureGranulocytePercent, reqVO.getImmatureGranulocytePercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMonocyteCount, reqVO.getMonocyteCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getMonocytePercent, reqVO.getMonocytePercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getNucleatedRbcCount, reqVO.getNucleatedRbcCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getNucleatedRbcPercent, reqVO.getNucleatedRbcPercent())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getNeutrophilCount, reqVO.getNeutrophilCount())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getNeutrophilPercent, reqVO.getNeutrophilPercent())
                .betweenIfPresent(ProspectiveExperimentExamBloodRoutineDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProspectiveExperimentExamBloodRoutineDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ProspectiveExperimentExamBloodRoutineDO::getId));
    }

}