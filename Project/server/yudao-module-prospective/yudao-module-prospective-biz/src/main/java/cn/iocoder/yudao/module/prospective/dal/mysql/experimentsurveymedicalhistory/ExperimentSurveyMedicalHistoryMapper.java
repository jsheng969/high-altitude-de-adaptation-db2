package cn.iocoder.yudao.module.prospective.dal.mysql.experimentsurveymedicalhistory;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.*;

/**
 * 既往疾病史 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentSurveyMedicalHistoryMapper extends BaseMapperX<ExperimentSurveyMedicalHistoryDO> {

    default PageResult<ExperimentSurveyMedicalHistoryDO> selectPage(ExperimentSurveyMedicalHistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyMedicalHistoryDO>()
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getHyperlipidemia, reqVO.getHyperlipidemia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getCongenitalHeartDisease, reqVO.getCongenitalHeartDisease())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getPulmonaryHeartDisease, reqVO.getPulmonaryHeartDisease())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getStroke, reqVO.getStroke())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getSinusTachycardia, reqVO.getSinusTachycardia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getFrequentAtrialPremature, reqVO.getFrequentAtrialPremature())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getSinusArrhythmia, reqVO.getSinusArrhythmia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getFrequentVentricularPremature, reqVO.getFrequentVentricularPremature())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getAtrioventricularBlock, reqVO.getAtrioventricularBlock())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getSinusBradycardia, reqVO.getSinusBradycardia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getParoxysmalSupraventricularTachycardia, reqVO.getParoxysmalSupraventricularTachycardia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getVentricularTachycardia, reqVO.getVentricularTachycardia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getChronicBronchitis, reqVO.getChronicBronchitis())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getAsthma, reqVO.getAsthma())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getTuberculosis, reqVO.getTuberculosis())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getEmphysema, reqVO.getEmphysema())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getPneumonia, reqVO.getPneumonia())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getCopd, reqVO.getCopd())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getGout, reqVO.getGout())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getChronicGastroenteritis, reqVO.getChronicGastroenteritis())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getDuodenalUlcer, reqVO.getDuodenalUlcer())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getGastricUlcer, reqVO.getGastricUlcer())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getGallstones, reqVO.getGallstones())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getColonPolyps, reqVO.getColonPolyps())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getHepatitisB, reqVO.getHepatitisB())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getCholecystitis, reqVO.getCholecystitis())
                .eqIfPresent(ExperimentSurveyMedicalHistoryDO::getEpilepsy, reqVO.getEpilepsy())
                .betweenIfPresent(ExperimentSurveyMedicalHistoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentSurveyMedicalHistoryDO::getId));
    }

}