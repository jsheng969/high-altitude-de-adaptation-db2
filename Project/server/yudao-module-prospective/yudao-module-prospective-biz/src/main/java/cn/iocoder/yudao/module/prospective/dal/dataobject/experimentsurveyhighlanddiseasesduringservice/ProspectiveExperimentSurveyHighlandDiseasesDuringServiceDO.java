package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyhighlanddiseasesduringservice;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 抵达高原后有无新下疾病 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_highland_diseases_during_service")
@KeySequence("prospective_experiment_survey_highland_diseases_during_service_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 基础信息id
     */
    private Long personId;

    /**
     * 疾病名称
     */
    private String diseases;
    /**
     * 高血压
     */
    private Boolean hypertension;
    /**
     * 心肌梗死
     */
    private Boolean myocardialInfarction;
    /**
     * 冠心病
     */
    private Boolean coronaryHeartDisease;
    /**
     * 肺心病
     */
    private Boolean pulmonaryHeartDisease;
    /**
     * 四肢静脉血栓
     */
    private Boolean lowerExtremityVenousThrombosis;
    /**
     * 窦性心动过缓
     */
    private Boolean bradycardia;
    /**
     * 窦性心动过速
     */
    private Boolean tachycardia;
    /**
     * 窦性心律不齐
     */
    private Boolean arrhythmia;
    /**
     * 房颤
     */
    private Boolean atrialFibrillation;
    /**
     * 阵发性室上速
     */
    private Boolean paroxysmalAuricularTachycardia;
    /**
     * 频发房性早搏
     */
    private Boolean frequentPrematureAtrialContractions;
    /**
     * 频发室性早搏
     */
    private Boolean frequentPrematureVentricularContractions;
    /**
     * 房室传导阻滞
     */
    private Boolean avBlock;
    /**
     * 室性心动过速
     */
    private Boolean ventricularTachycardia;
    /**
     * 其他
     */
    private Boolean otherDiseases11;
    /**
     * 眩晕
     */
    private Boolean dizziness;
    /**
     * 短暂性脑缺血
     */
    private Boolean transientIschemicAttack;
    /**
     * 脑梗死/脑血栓
     */
    private Boolean cerebralInfarction;
    /**
     * 脑出血
     */
    private Boolean cerebralHemorrhage;
    /**
     * 其他
     */
    private Boolean otherDiseases12;
    /**
     * 高血脂
     */
    private Boolean hyperlipidemia;
    /**
     * 糖尿病
     */
    private Boolean diabetes;
    /**
     * 高尿酸血症（痛风）
     */
    private Boolean gout;
    /**
     * 甲状腺疾病
     */
    private Boolean thyroidDisease;
    /**
     * 其他
     */
    private Boolean otherDiseases13;
    /**
     * 失眠
     */
    private Boolean insomnia;
    /**
     * 肿瘤
     */
    private Boolean tumor;
    /**
     * 其他
     */
    private Boolean otherDiseases14;

    /**
     * 时相
     */
    private Integer timePoint;
}