package cn.iocoder.yudao.module.review.dal.mysql.experimentdiseasespectrum;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentdiseasespectrum.ExperimentDiseaseSpectrumDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.*;

/**
 * 实验组-疾病谱 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentDiseaseSpectrumMapper extends BaseMapperX<ExperimentDiseaseSpectrumDO> {

    default PageResult<ExperimentDiseaseSpectrumDO> selectPage(ExperimentDiseaseSpectrumPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentDiseaseSpectrumDO>()
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getFattyLiver, reqVO.getFattyLiver())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHepaticCyst, reqVO.getHepaticCyst())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getGallbladderPolyp, reqVO.getGallbladderPolyp())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getGallbladderStone, reqVO.getGallbladderStone())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHepaticHemangioma, reqVO.getHepaticHemangioma())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getSplenomegaly, reqVO.getSplenomegaly())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getChronicGastritis, reqVO.getChronicGastritis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getIntestinalPolyp, reqVO.getIntestinalPolyp())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getAppendicitis, reqVO.getAppendicitis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getAcutePancreatitis, reqVO.getAcutePancreatitis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getDigestiveUlcer, reqVO.getDigestiveUlcer())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getDigestiveBleeding, reqVO.getDigestiveBleeding())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getTransientIschemicAttack, reqVO.getTransientIschemicAttack())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getCerebralInfarction, reqVO.getCerebralInfarction())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHypertriglyceridemia, reqVO.getHypertriglyceridemia())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHighLdl, reqVO.getHighLdl())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHighHdl, reqVO.getHighHdl())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHyperuricemia, reqVO.getHyperuricemia())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getHypercholesterolemia, reqVO.getHypercholesterolemia())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getLungNodule, reqVO.getLungNodule())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getPulmonaryEmphysema, reqVO.getPulmonaryEmphysema())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getCopd, reqVO.getCopd())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getAsthma, reqVO.getAsthma())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getKidneyStone, reqVO.getKidneyStone())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getRenalCyst, reqVO.getRenalCyst())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getProstatitis, reqVO.getProstatitis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getLumbarSpondylosis, reqVO.getLumbarSpondylosis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getCervicalSpondylosis, reqVO.getCervicalSpondylosis())
                .eqIfPresent(ExperimentDiseaseSpectrumDO::getInsomnia, reqVO.getInsomnia())
                .betweenIfPresent(ExperimentDiseaseSpectrumDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentDiseaseSpectrumDO::getId));
    }

}