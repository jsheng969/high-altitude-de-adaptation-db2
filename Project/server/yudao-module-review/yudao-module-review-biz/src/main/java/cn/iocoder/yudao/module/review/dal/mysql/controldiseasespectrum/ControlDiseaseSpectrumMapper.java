package cn.iocoder.yudao.module.review.dal.mysql.controldiseasespectrum;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controldiseasespectrum.ControlDiseaseSpectrumDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.*;

/**
 * 实验组-疾病谱 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlDiseaseSpectrumMapper extends BaseMapperX<ControlDiseaseSpectrumDO> {

    default PageResult<ControlDiseaseSpectrumDO> selectPage(ControlDiseaseSpectrumPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlDiseaseSpectrumDO>()
                .eqIfPresent(ControlDiseaseSpectrumDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlDiseaseSpectrumDO::getFattyLiver, reqVO.getFattyLiver())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHepaticCyst, reqVO.getHepaticCyst())
                .eqIfPresent(ControlDiseaseSpectrumDO::getGallbladderPolyp, reqVO.getGallbladderPolyp())
                .eqIfPresent(ControlDiseaseSpectrumDO::getGallbladderStone, reqVO.getGallbladderStone())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHepaticHemangioma, reqVO.getHepaticHemangioma())
                .eqIfPresent(ControlDiseaseSpectrumDO::getSplenomegaly, reqVO.getSplenomegaly())
                .eqIfPresent(ControlDiseaseSpectrumDO::getChronicGastritis, reqVO.getChronicGastritis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getIntestinalPolyp, reqVO.getIntestinalPolyp())
                .eqIfPresent(ControlDiseaseSpectrumDO::getAppendicitis, reqVO.getAppendicitis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getAcutePancreatitis, reqVO.getAcutePancreatitis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getDigestiveUlcer, reqVO.getDigestiveUlcer())
                .eqIfPresent(ControlDiseaseSpectrumDO::getDigestiveBleeding, reqVO.getDigestiveBleeding())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHypertension, reqVO.getHypertension())
                .eqIfPresent(ControlDiseaseSpectrumDO::getBradycardia, reqVO.getBradycardia())
                .eqIfPresent(ControlDiseaseSpectrumDO::getTransientIschemicAttack, reqVO.getTransientIschemicAttack())
                .eqIfPresent(ControlDiseaseSpectrumDO::getTachycardia, reqVO.getTachycardia())
                .eqIfPresent(ControlDiseaseSpectrumDO::getCerebralInfarction, reqVO.getCerebralInfarction())
                .eqIfPresent(ControlDiseaseSpectrumDO::getFrequentPrematureAtrialContractions, reqVO.getFrequentPrematureAtrialContractions())
                .eqIfPresent(ControlDiseaseSpectrumDO::getFrequentPrematureVentricularContractions, reqVO.getFrequentPrematureVentricularContractions())
                .eqIfPresent(ControlDiseaseSpectrumDO::getCoronaryHeartDisease, reqVO.getCoronaryHeartDisease())
                .eqIfPresent(ControlDiseaseSpectrumDO::getAtrialFibrillation, reqVO.getAtrialFibrillation())
                .eqIfPresent(ControlDiseaseSpectrumDO::getMyocardialInfarction, reqVO.getMyocardialInfarction())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHypertriglyceridemia, reqVO.getHypertriglyceridemia())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHighLdl, reqVO.getHighLdl())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHighHdl, reqVO.getHighHdl())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHyperuricemia, reqVO.getHyperuricemia())
                .eqIfPresent(ControlDiseaseSpectrumDO::getHypercholesterolemia, reqVO.getHypercholesterolemia())
                .eqIfPresent(ControlDiseaseSpectrumDO::getDiabetes, reqVO.getDiabetes())
                .eqIfPresent(ControlDiseaseSpectrumDO::getThyroidDisease, reqVO.getThyroidDisease())
                .eqIfPresent(ControlDiseaseSpectrumDO::getLungNodule, reqVO.getLungNodule())
                .eqIfPresent(ControlDiseaseSpectrumDO::getPulmonaryEmphysema, reqVO.getPulmonaryEmphysema())
                .eqIfPresent(ControlDiseaseSpectrumDO::getCopd, reqVO.getCopd())
                .eqIfPresent(ControlDiseaseSpectrumDO::getAsthma, reqVO.getAsthma())
                .eqIfPresent(ControlDiseaseSpectrumDO::getKidneyStone, reqVO.getKidneyStone())
                .eqIfPresent(ControlDiseaseSpectrumDO::getRenalCyst, reqVO.getRenalCyst())
                .eqIfPresent(ControlDiseaseSpectrumDO::getProstatitis, reqVO.getProstatitis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getLumbarSpondylosis, reqVO.getLumbarSpondylosis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getCervicalSpondylosis, reqVO.getCervicalSpondylosis())
                .eqIfPresent(ControlDiseaseSpectrumDO::getInsomnia, reqVO.getInsomnia())
                .betweenIfPresent(ControlDiseaseSpectrumDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ControlDiseaseSpectrumDO::getId));
    }

}