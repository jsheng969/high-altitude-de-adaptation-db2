package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveyfamilydiseases;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.*;

/**
 * 实验组流调-亲属既往疾病 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyFamilyDiseasesMapper extends BaseMapperX<ExperimentSurveyFamilyDiseasesDO> {

    default PageResult<ExperimentSurveyFamilyDiseasesDO> selectPage(ExperimentSurveyFamilyDiseasesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyFamilyDiseasesDO>()
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getHyperlipidemia, reqVO.getHyperlipidemia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getCongenitalHeartDisease, reqVO.getCongenitalHeartDisease())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getPulmonaryHeartDisease, reqVO.getPulmonaryHeartDisease())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getStroke, reqVO.getStroke())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getArrhythmia, reqVO.getArrhythmia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getParoxysmalAuricularTachycardia, reqVO.getParoxysmalAuricularTachycardia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getAvBlock, reqVO.getAvBlock())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getVentricularTachycardia, reqVO.getVentricularTachycardia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getOtherDiseases1, reqVO.getOtherDiseases1())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getChronicBronchitis, reqVO.getChronicBronchitis())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getAsthma, reqVO.getAsthma())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getTuberculosis, reqVO.getTuberculosis())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getEmphysema, reqVO.getEmphysema())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getPneumonia, reqVO.getPneumonia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getCopd, reqVO.getCopd())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getOtherDiseases2, reqVO.getOtherDiseases2())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getGout, reqVO.getGout())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getChronicGastroenteritis, reqVO.getChronicGastroenteritis())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getDuodenalUlcer, reqVO.getDuodenalUlcer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getGastricUlcer, reqVO.getGastricUlcer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getGallstones, reqVO.getGallstones())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getColonPolyps, reqVO.getColonPolyps())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getHepatitisB, reqVO.getHepatitisB())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getCholecystitis, reqVO.getCholecystitis())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getOtherDiseases3, reqVO.getOtherDiseases3())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getDementia, reqVO.getDementia())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getParkinsonsDisease, reqVO.getParkinsonsDisease())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getMultipleSclerosis, reqVO.getMultipleSclerosis())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getEpilepsy, reqVO.getEpilepsy())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getLungCancer, reqVO.getLungCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getLiverCancer, reqVO.getLiverCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getGastricCancer, reqVO.getGastricCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getColonCancer, reqVO.getColonCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getPancreaticCancer, reqVO.getPancreaticCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getEsophagealCancer, reqVO.getEsophagealCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getProstateCancer, reqVO.getProstateCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getBreastCancer, reqVO.getBreastCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getCervicalCancer, reqVO.getCervicalCancer())
                .eqIfPresent(ExperimentSurveyFamilyDiseasesDO::getOtherDiseases4, reqVO.getOtherDiseases4())
                .orderByDesc(ExperimentSurveyFamilyDiseasesDO::getId));
    }

}