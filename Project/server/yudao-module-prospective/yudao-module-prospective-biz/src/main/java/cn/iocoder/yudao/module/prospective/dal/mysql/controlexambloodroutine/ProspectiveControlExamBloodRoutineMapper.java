package cn.iocoder.yudao.module.prospective.dal.mysql.controlexambloodroutine;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambloodroutine.ProspectiveControlExamBloodRoutineDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo.*;

/**
 * 实验组体检-血常规 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveControlExamBloodRoutineMapper extends BaseMapperX<ProspectiveControlExamBloodRoutineDO> {

    default PageResult<ProspectiveControlExamBloodRoutineDO> selectPage(ControlExamBloodRoutinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveControlExamBloodRoutineDO>()
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getWbcCount, reqVO.getWbcCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLymphocytePercent, reqVO.getLymphocytePercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMidCellPercent, reqVO.getMidCellPercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getGranulocytePercent, reqVO.getGranulocytePercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLymphocyteCount, reqVO.getLymphocyteCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMidCellCount, reqVO.getMidCellCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getGranulocyteCount, reqVO.getGranulocyteCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getRbcCount, reqVO.getRbcCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getHemoglobin, reqVO.getHemoglobin())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getHematocrit, reqVO.getHematocrit())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMcv, reqVO.getMcv())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMch, reqVO.getMch())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMchc, reqVO.getMchc())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getRdwCv, reqVO.getRdwCv())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getRdwSd, reqVO.getRdwSd())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getPlateletCount, reqVO.getPlateletCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMpv, reqVO.getMpv())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getPdw, reqVO.getPdw())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getPct, reqVO.getPct())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLargePlateletRatio, reqVO.getLargePlateletRatio())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLargePlateletCount, reqVO.getLargePlateletCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getBasophilCount, reqVO.getBasophilCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getBasophilPercent, reqVO.getBasophilPercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getEosinophilCount, reqVO.getEosinophilCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getEosinophilPercent, reqVO.getEosinophilPercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getImmatureGranulocyteCount, reqVO.getImmatureGranulocyteCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getImmatureGranulocytePercent, reqVO.getImmatureGranulocytePercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMonocyteCount, reqVO.getMonocyteCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMonocytePercent, reqVO.getMonocytePercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNucleatedRbcCount, reqVO.getNucleatedRbcCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNucleatedRbcPercent, reqVO.getNucleatedRbcPercent())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNeutrophilCount, reqVO.getNeutrophilCount())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNeutrophilPercent, reqVO.getNeutrophilPercent())
                .betweenIfPresent(ProspectiveControlExamBloodRoutineDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNe, reqVO.getNe())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLy, reqVO.getLy())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getMo, reqVO.getMo())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getNeut, reqVO.getNeut())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getLymph, reqVO.getLymph())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getEos, reqVO.getEos())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getCrea, reqVO.getCrea())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getCysc, reqVO.getCysc())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getClcr, reqVO.getClcr())
                .eqIfPresent(ProspectiveControlExamBloodRoutineDO::getUric, reqVO.getUric())
                .orderByDesc(ProspectiveControlExamBloodRoutineDO::getId));
    }

}