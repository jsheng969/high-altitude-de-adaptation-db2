package cn.iocoder.yudao.module.prospective.dal.mysql.experimentexambiochemicaltestsv2;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2DO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.*;

/**
 * 实验组体检-生化v2 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentExamBiochemicalTestsV2Mapper extends BaseMapperX<ExperimentExamBiochemicalTestsV2DO> {

    default PageResult<ExperimentExamBiochemicalTestsV2DO> selectPage(ExperimentExamBiochemicalTestsV2PageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamBiochemicalTestsV2DO>()
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAlt, reqVO.getAlt())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAst, reqVO.getAst())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAstAltRatio, reqVO.getAstAltRatio())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTotalProtein, reqVO.getTotalProtein())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAlbumin, reqVO.getAlbumin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getGlobulin, reqVO.getGlobulin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAlbGlobRatio, reqVO.getAlbGlobRatio())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTotalBilirubin, reqVO.getTotalBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getDirectBilirubin, reqVO.getDirectBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIndirectBilirubin, reqVO.getIndirectBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAlkalinePhosphatase, reqVO.getAlkalinePhosphatase())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getGgt, reqVO.getGgt())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTotalBileAcid, reqVO.getTotalBileAcid())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCholinesterase, reqVO.getCholinesterase())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPrealbumin, reqVO.getPrealbumin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getUrea, reqVO.getUrea())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCreatinine, reqVO.getCreatinine())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getUricAcid, reqVO.getUricAcid())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTriglycerides, reqVO.getTriglycerides())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCholesterol, reqVO.getCholesterol())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHdlC, reqVO.getHdlC())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getLdlC, reqVO.getLdlC())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getApoa, reqVO.getApoa())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getApob, reqVO.getApob())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getLpa, reqVO.getLpa())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getGlucose, reqVO.getGlucose())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCk, reqVO.getCk())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCkMb, reqVO.getCkMb())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAlphaHbdh, reqVO.getAlphaHbdh())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getLdh, reqVO.getLdh())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCrp, reqVO.getCrp())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIgg, reqVO.getIgg())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIga, reqVO.getIga())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIgm, reqVO.getIgm())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getComplement3, reqVO.getComplement3())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getComplement4, reqVO.getComplement4())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getMyoglobin, reqVO.getMyoglobin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getSmallDenseLdl, reqVO.getSmallDenseLdl())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHomocysteine, reqVO.getHomocysteine())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getNucleotidase, reqVO.getNucleotidase())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAda, reqVO.getAda())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAmylase, reqVO.getAmylase())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAnionGap, reqVO.getAnionGap())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBufferBase, reqVO.getBufferBase())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBicarbonate, reqVO.getBicarbonate())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBaseExcess, reqVO.getBaseExcess())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getExtracellularBe, reqVO.getExtracellularBe())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBloodUrea, reqVO.getBloodUrea())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBun, reqVO.getBun())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCalcium, reqVO.getCalcium())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getChloride, reqVO.getChloride())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getCystatinC, reqVO.getCystatinC())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIron, reqVO.getIron())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getActualBicarbonate, reqVO.getActualBicarbonate())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getStandardBicarbonate, reqVO.getStandardBicarbonate())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPotassium, reqVO.getPotassium())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getMagnesium, reqVO.getMagnesium())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getSodium, reqVO.getSodium())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPhosphorus, reqVO.getPhosphorus())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPco2, reqVO.getPco2())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPh, reqVO.getPh())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPo2, reqVO.getPo2())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getRbp, reqVO.getRbp())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getReninActivity, reqVO.getReninActivity())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHydrogenIonConcentration, reqVO.getHydrogenIonConcentration())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTco2, reqVO.getTco2())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getLacticAcid, reqVO.getLacticAcid())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getMicroalbumin, reqVO.getMicroalbumin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getPlasmaOsmoticPressure, reqVO.getPlasmaOsmoticPressure())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAAGradient, reqVO.getAAGradient())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAARatio, reqVO.getAARatio())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getOxygenationIndex, reqVO.getOxygenationIndex())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getEstimatedSpo2, reqVO.getEstimatedSpo2())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getEstimatedHb, reqVO.getEstimatedHb())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getBeta2Microglobulin, reqVO.getBeta2Microglobulin())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHsCrp, reqVO.getHsCrp())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHbsag, reqVO.getHbsag())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAntiHbs, reqVO.getAntiHbs())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getHbeag, reqVO.getHbeag())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAntiHbe, reqVO.getAntiHbe())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAntiHbc, reqVO.getAntiHbc())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTotalCholesterol, reqVO.getTotalCholesterol())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getIma, reqVO.getIma())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getAfucosidase, reqVO.getAfucosidase())
                .betweenIfPresent(ExperimentExamBiochemicalTestsV2DO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExperimentExamBiochemicalTestsV2DO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ExperimentExamBiochemicalTestsV2DO::getId));
    }

}