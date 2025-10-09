package cn.iocoder.yudao.module.prospective.dal.mysql.controlexambiochemicaltestsv2;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2DO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.*;

/**
 * 实验组体检-生化v2 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlExamBiochemicalTestsV2Mapper extends BaseMapperX<ControlExamBiochemicalTestsV2DO> {

    default PageResult<ControlExamBiochemicalTestsV2DO> selectPage(ControlExamBiochemicalTestsV2PageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamBiochemicalTestsV2DO>()
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAlt, reqVO.getAlt())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAst, reqVO.getAst())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAstAltRatio, reqVO.getAstAltRatio())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTotalProtein, reqVO.getTotalProtein())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAlbumin, reqVO.getAlbumin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getGlobulin, reqVO.getGlobulin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAlbGlobRatio, reqVO.getAlbGlobRatio())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTotalBilirubin, reqVO.getTotalBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getDirectBilirubin, reqVO.getDirectBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIndirectBilirubin, reqVO.getIndirectBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAlkalinePhosphatase, reqVO.getAlkalinePhosphatase())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getGgt, reqVO.getGgt())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTotalBileAcid, reqVO.getTotalBileAcid())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCholinesterase, reqVO.getCholinesterase())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPrealbumin, reqVO.getPrealbumin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getUrea, reqVO.getUrea())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCreatinine, reqVO.getCreatinine())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getUricAcid, reqVO.getUricAcid())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTriglycerides, reqVO.getTriglycerides())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCholesterol, reqVO.getCholesterol())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHdlC, reqVO.getHdlC())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getLdlC, reqVO.getLdlC())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getApoa, reqVO.getApoa())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getApob, reqVO.getApob())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getLpa, reqVO.getLpa())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getGlucose, reqVO.getGlucose())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCk, reqVO.getCk())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCkMb, reqVO.getCkMb())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAlphaHbdh, reqVO.getAlphaHbdh())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getLdh, reqVO.getLdh())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCrp, reqVO.getCrp())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIgg, reqVO.getIgg())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIga, reqVO.getIga())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIgm, reqVO.getIgm())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getComplement3, reqVO.getComplement3())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getComplement4, reqVO.getComplement4())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getMyoglobin, reqVO.getMyoglobin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getSmallDenseLdl, reqVO.getSmallDenseLdl())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHomocysteine, reqVO.getHomocysteine())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getNucleotidase, reqVO.getNucleotidase())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAda, reqVO.getAda())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAmylase, reqVO.getAmylase())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAnionGap, reqVO.getAnionGap())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBufferBase, reqVO.getBufferBase())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBicarbonate, reqVO.getBicarbonate())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBaseExcess, reqVO.getBaseExcess())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getExtracellularBe, reqVO.getExtracellularBe())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBloodUrea, reqVO.getBloodUrea())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBun, reqVO.getBun())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCalcium, reqVO.getCalcium())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getChloride, reqVO.getChloride())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getCystatinC, reqVO.getCystatinC())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIron, reqVO.getIron())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getActualBicarbonate, reqVO.getActualBicarbonate())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getStandardBicarbonate, reqVO.getStandardBicarbonate())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPotassium, reqVO.getPotassium())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getMagnesium, reqVO.getMagnesium())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getSodium, reqVO.getSodium())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPhosphorus, reqVO.getPhosphorus())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPco2, reqVO.getPco2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPh, reqVO.getPh())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPo2, reqVO.getPo2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getRbp, reqVO.getRbp())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getReninActivity, reqVO.getReninActivity())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHydrogenIonConcentration, reqVO.getHydrogenIonConcentration())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTco2, reqVO.getTco2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getLacticAcid, reqVO.getLacticAcid())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getMicroalbumin, reqVO.getMicroalbumin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPlasmaOsmoticPressure, reqVO.getPlasmaOsmoticPressure())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAAGradient, reqVO.getAAGradient())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAARatio, reqVO.getAARatio())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getOxygenationIndex, reqVO.getOxygenationIndex())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getEstimatedSpo2, reqVO.getEstimatedSpo2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getEstimatedHb, reqVO.getEstimatedHb())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getBeta2Microglobulin, reqVO.getBeta2Microglobulin())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHsCrp, reqVO.getHsCrp())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHbsag, reqVO.getHbsag())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAntiHbs, reqVO.getAntiHbs())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHbeag, reqVO.getHbeag())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAntiHbe, reqVO.getAntiHbe())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAntiHbc, reqVO.getAntiHbc())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTotalCholesterol, reqVO.getTotalCholesterol())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getIma, reqVO.getIma())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getAfucosidase, reqVO.getAfucosidase())
                .betweenIfPresent(ControlExamBiochemicalTestsV2DO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getPalb, reqVO.getPalb())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTbil, reqVO.getTbil())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getDbil, reqVO.getDbil())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getTg, reqVO.getTg())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getHdlc2, reqVO.getHdlc2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getApoA2, reqVO.getApoA2())
                .eqIfPresent(ControlExamBiochemicalTestsV2DO::getApoB2, reqVO.getApoB2())
                .orderByDesc(ControlExamBiochemicalTestsV2DO::getId));
    }

}