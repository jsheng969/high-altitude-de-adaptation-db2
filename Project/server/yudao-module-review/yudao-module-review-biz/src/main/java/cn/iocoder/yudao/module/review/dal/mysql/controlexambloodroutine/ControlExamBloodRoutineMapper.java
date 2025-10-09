package cn.iocoder.yudao.module.review.dal.mysql.controlexambloodroutine;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambloodroutine.ControlExamBloodRoutineDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.*;

/**
 * 对照组体检-血常规 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamBloodRoutineMapper extends BaseMapperX<ControlExamBloodRoutineDO> {

    default PageResult<ControlExamBloodRoutineDO> selectPage(ControlExamBloodRoutinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamBloodRoutineDO>()
                .eqIfPresent(ControlExamBloodRoutineDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamBloodRoutineDO::getWbc, reqVO.getWbc())
                .eqIfPresent(ControlExamBloodRoutineDO::getRbc, reqVO.getRbc())
                .eqIfPresent(ControlExamBloodRoutineDO::getNeutrophils, reqVO.getNeutrophils())
                .eqIfPresent(ControlExamBloodRoutineDO::getLymphocytes, reqVO.getLymphocytes())
                .eqIfPresent(ControlExamBloodRoutineDO::getMonocytes, reqVO.getMonocytes())
                .eqIfPresent(ControlExamBloodRoutineDO::getEosinophils, reqVO.getEosinophils())
                .eqIfPresent(ControlExamBloodRoutineDO::getBasophils, reqVO.getBasophils())
                .eqIfPresent(ControlExamBloodRoutineDO::getMcv, reqVO.getMcv())
                .eqIfPresent(ControlExamBloodRoutineDO::getMch, reqVO.getMch())
                .eqIfPresent(ControlExamBloodRoutineDO::getMchc, reqVO.getMchc())
                .eqIfPresent(ControlExamBloodRoutineDO::getRdwCv, reqVO.getRdwCv())
                .eqIfPresent(ControlExamBloodRoutineDO::getRdwSd, reqVO.getRdwSd())
                .eqIfPresent(ControlExamBloodRoutineDO::getHemoglobin, reqVO.getHemoglobin())
                .eqIfPresent(ControlExamBloodRoutineDO::getPlateletCrit, reqVO.getPlateletCrit())
                .eqIfPresent(ControlExamBloodRoutineDO::getMpv, reqVO.getMpv())
                .eqIfPresent(ControlExamBloodRoutineDO::getPdw, reqVO.getPdw())
                .eqIfPresent(ControlExamBloodRoutineDO::getHematocrit, reqVO.getHematocrit())
                .eqIfPresent(ControlExamBloodRoutineDO::getPlateletCount, reqVO.getPlateletCount())
                .eqIfPresent(ControlExamBloodRoutineDO::getNeutrophilsPercentage, reqVO.getNeutrophilsPercentage())
                .eqIfPresent(ControlExamBloodRoutineDO::getLymphocytesPercentage, reqVO.getLymphocytesPercentage())
                .eqIfPresent(ControlExamBloodRoutineDO::getMonocytesPercentage, reqVO.getMonocytesPercentage())
                .eqIfPresent(ControlExamBloodRoutineDO::getEosinophilsPercentage, reqVO.getEosinophilsPercentage())
                .eqIfPresent(ControlExamBloodRoutineDO::getBasophilsPercentage, reqVO.getBasophilsPercentage())
                .orderByDesc(ControlExamBloodRoutineDO::getId));
    }

}