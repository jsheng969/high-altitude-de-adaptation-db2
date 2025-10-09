package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseasesduringservice;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-高原期间出现的疾病 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_highland_diseases_during_service")
@KeySequence("review_experiment_survey_highland_diseases_during_service_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyHighlandDiseasesDuringServiceDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 基础信息id
     */
    private Long personId;
    /**
     * 高血压 1
     */
    private Boolean hypertension;
    /**
     * 心肌梗死 1
     */
    private Boolean myocardialInfarction;
    /**
     * 冠心病 1
     */
    private Boolean coronaryHeartDisease;
    /**
     * 肺心病 1
     */
    private Boolean pulmonaryHeartDisease;
    /**
     * 四肢静脉血栓 1
     */
    private Boolean lowerExtremityVenousThrombosis;
    /**
     * 窦性心动过缓 1
     */
    private Boolean bradycardia;
    /**
     * 窦性心动过速 1
     */
    private Boolean tachycardia;
    /**
     * 窦性心律不齐 1
     */
    private Boolean arrhythmia;
    /**
     * 房颤 1
     */
    private Boolean atrialFibrillation;
    /**
     * 阵发性室上速 1
     */
    private Boolean paroxysmalAuricularTachycardia;
    /**
     * 频发房性早搏 1
     */
    private Boolean frequentPrematureAtrialContractions;
    /**
     * 频发室性早搏 1
     */
    private Boolean frequentPrematureVentricularContractions;
    /**
     * 房室传导阻滞 1
     */
    private Boolean avBlock;
    /**
     * 室性心动过速 1
     */
    private Boolean ventricularTachycardia;
    /**
     * 其他 1 1
     */
    private Boolean otherDiseases1;
    /**
     * 眩晕 1
     */
    private Boolean dizziness;
    /**
     * 短暂性脑缺血 1
     */
    private Boolean transientIschemicAttack;
    /**
     * 脑梗死/脑血栓 1
     */
    private Boolean cerebralInfarction;
    /**
     * 脑出血 1
     */
    private Boolean cerebralHemorrhage;
    /**
     * 其他 1 2
     */
    private Boolean otherDiseases2;
    /**
     * 高血脂 1
     */
    private Boolean hyperlipidemia;
    /**
     * 糖尿病 1
     */
    private Boolean diabetes;
    /**
     * 高尿酸血症（痛风） 1
     */
    private Boolean gout;
    /**
     * 甲状腺疾病 1
     */
    private Boolean thyroidDisease;
    /**
     * 其他 1 3
     */
    private Boolean otherDiseases3;
    /**
     * 失眠 1
     */
    private Boolean insomnia;
    /**
     * 肿瘤 1
     */
    private Boolean tumor;
    /**
     * 其他 1 4
     */
    private Boolean otherDiseases4;

}