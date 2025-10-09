package cn.iocoder.yudao.module.review.dal.mysql.experimentexambloodroutine;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambloodroutine.ExperimentExamBloodRoutineDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.*;

/**
 * 实验组体检-血常规 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamBloodRoutineMapper extends BaseMapperX<ExperimentExamBloodRoutineDO> {

    default PageResult<ExperimentExamBloodRoutineDO> selectPage(ExperimentExamBloodRoutinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamBloodRoutineDO>()
                .eqIfPresent(ExperimentExamBloodRoutineDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getWbc, reqVO.getWbc())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getRbc, reqVO.getRbc())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getNeutrophils, reqVO.getNeutrophils())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getLymphocytes, reqVO.getLymphocytes())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMonocytes, reqVO.getMonocytes())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getEosinophils, reqVO.getEosinophils())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getBasophils, reqVO.getBasophils())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMcv, reqVO.getMcv())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMch, reqVO.getMch())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMchc, reqVO.getMchc())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getRdwCv, reqVO.getRdwCv())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getRdwSd, reqVO.getRdwSd())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getHemoglobin, reqVO.getHemoglobin())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getPlateletCrit, reqVO.getPlateletCrit())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMpv, reqVO.getMpv())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getPdw, reqVO.getPdw())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getHematocrit, reqVO.getHematocrit())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getPlateletCount, reqVO.getPlateletCount())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getNeutrophilsPercentage, reqVO.getNeutrophilsPercentage())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getLymphocytesPercentage, reqVO.getLymphocytesPercentage())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getMonocytesPercentage, reqVO.getMonocytesPercentage())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getEosinophilsPercentage, reqVO.getEosinophilsPercentage())
                .eqIfPresent(ExperimentExamBloodRoutineDO::getBasophilsPercentage, reqVO.getBasophilsPercentage())
                .orderByDesc(ExperimentExamBloodRoutineDO::getId));
    }

}