package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymedicalhistory;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 既往疾病史 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_medical_history")
@KeySequence("prospective_experiment_survey_medical_history_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyMedicalHistoryDO extends BaseDO {

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
     * 高血压
     */
    private Boolean hypertension;
    /**
     * 高血脂
     */
    private Boolean hyperlipidemia;
    /**
     * 先天性心脏病
     */
    private Boolean congenitalHeartDisease;
    /**
     * 肺心病
     */
    private Boolean pulmonaryHeartDisease;
    /**
     * 中风/脑溢血
     */
    private Boolean stroke;
    /**
     * 窦性心动过速
     */
    private Boolean sinusTachycardia;
    /**
     * 频发房性早搏
     */
    private Boolean frequentAtrialPremature;
    /**
     * 冠心病/心绞痛
     */
    private Boolean coronaryHeartDisease;
    /**
     * 窦性心律不齐
     */
    private Boolean sinusArrhythmia;
    /**
     * 频发室性早搏
     */
    private Boolean frequentVentricularPremature;
    /**
     * 心肌梗塞
     */
    private Boolean myocardialInfarction;
    /**
     * 房颤
     */
    private Boolean atrialFibrillation;
    /**
     * 房室传导阻滞
     */
    private Boolean atrioventricularBlock;
    /**
     * 窦性心动过缓
     */
    private Boolean sinusBradycardia;
    /**
     * 阵发性室上速
     */
    private Boolean paroxysmalSupraventricularTachycardia;
    /**
     * 室性心动过速
     */
    private Boolean ventricularTachycardia;
    /**
     * 慢性支气管炎
     */
    private Boolean chronicBronchitis;
    /**
     * 哮喘
     */
    private Boolean asthma;
    /**
     * 肺结核
     */
    private Boolean tuberculosis;
    /**
     * 肺气肿
     */
    private Boolean emphysema;
    /**
     * 肺炎
     */
    private Boolean pneumonia;
    /**
     * 慢性阻塞性肺疾病
     */
    private Boolean copd;
    /**
     * 甲状腺疾病
     */
    private Boolean thyroidDisease;
    /**
     * 糖尿病
     */
    private Boolean diabetes;
    /**
     * 高尿酸血症（痛风）
     */
    private Boolean gout;
    /**
     * 慢性肠胃炎
     */
    private Boolean chronicGastroenteritis;
    /**
     * 十二指肠溃疡
     */
    private Boolean duodenalUlcer;
    /**
     * 胃溃疡
     */
    private Boolean gastricUlcer;
    /**
     * 胆结石
     */
    private Boolean gallstones;
    /**
     * 结肠息肉
     */
    private Boolean colonPolyps;
    /**
     * 乙型肝炎
     */
    private Boolean hepatitisB;
    /**
     * 胆囊炎
     */
    private Boolean cholecystitis;
    /**
     * 癫痫
     */
    private Boolean epilepsy;

    /**
     * 时相
     */
    private Integer timePoint;

    /**
     * 总描述
     */
    private String description;
}