package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyfamilydiseases;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-亲属既往疾病 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_family_diseases")
@KeySequence("review_experiment_survey_family_diseases_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyFamilyDiseasesDO extends BaseDO {

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
     * 冠心病/心绞痛
     */
    private Boolean coronaryHeartDisease;
    /**
     * 心肌梗塞
     */
    private Boolean myocardialInfarction;
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
     * 其他 1
     */
    private Boolean otherDiseases1;
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
     * 其他 2
     */
    private Boolean otherDiseases2;
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
     * 其他 3
     */
    private Boolean otherDiseases3;
    /**
     * 老年痴呆
     */
    private Boolean dementia;
    /**
     * 帕金森综合征
     */
    private Boolean parkinsonsDisease;
    /**
     * 多发性硬化病
     */
    private Boolean multipleSclerosis;
    /**
     * 癫痫
     */
    private Boolean epilepsy;
    /**
     * 肺癌
     */
    private Boolean lungCancer;
    /**
     * 肝癌
     */
    private Boolean liverCancer;
    /**
     * 胃癌
     */
    private Boolean gastricCancer;
    /**
     * 直/结肠癌
     */
    private Boolean colonCancer;
    /**
     * 胰腺癌
     */
    private Boolean pancreaticCancer;
    /**
     * 食管癌
     */
    private Boolean esophagealCancer;
    /**
     * 前列腺癌
     */
    private Boolean prostateCancer;
    /**
     * 乳腺癌
     */
    private Boolean breastCancer;
    /**
     * 宫颈癌
     */
    private Boolean cervicalCancer;
    /**
     * 其他 4
     */
    private Boolean otherDiseases4;

}