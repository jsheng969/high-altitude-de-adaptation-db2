package cn.iocoder.yudao.module.review.dal.dataobject.controlsurveypastdiseases;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-既往疾病 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_survey_past_diseases")
@KeySequence("review_control_survey_past_diseases_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyPastDiseasesDO extends BaseDO {

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
     * 既往疾病1名称
     */
    private String disease1Name;
    /**
     * 既往疾病1是否确诊
     */
    private Boolean disease1Diagnosed;
    /**
     * 既往疾病1确诊时间
     */
    private String disease1DiagnosisDate;
    /**
     * 既往疾病1是否住院
     */
    private Boolean disease1Hospitalized;
    /**
     * 既往疾病1是否治疗
     */
    private Boolean disease1Treated;
    /**
     * 既往疾病1治疗效果
     */
    private String disease1TreatmentEffect;
    /**
     * 既往疾病2名称
     */
    private String disease2Name;
    /**
     * 既往疾病2是否确诊
     */
    private Boolean disease2Diagnosed;
    /**
     * 既往疾病2确诊时间
     */
    private String disease2DiagnosisDate;
    /**
     * 既往疾病2是否住院
     */
    private Boolean disease2Hospitalized;
    /**
     * 既往疾病2是否治疗
     */
    private Boolean disease2Treated;
    /**
     * 既往疾病2治疗效果
     */
    private String disease2TreatmentEffect;
    /**
     * 既往疾病3名称
     */
    private String disease3Name;
    /**
     * 既往疾病3是否确诊
     */
    private Boolean disease3Diagnosed;
    /**
     * 既往疾病3确诊时间
     */
    private String disease3DiagnosisDate;
    /**
     * 既往疾病3是否住院
     */
    private Boolean disease3Hospitalized;
    /**
     * 既往疾病3是否治疗
     */
    private Boolean disease3Treated;
    /**
     * 既往疾病3治疗效果
     */
    private String disease3TreatmentEffect;
    /**
     * 既往疾病4名称
     */
    private String disease4Name;
    /**
     * 既往疾病4是否确诊
     */
    private Boolean disease4Diagnosed;
    /**
     * 既往疾病4确诊时间
     */
    private String disease4DiagnosisDate;
    /**
     * 既往疾病4是否住院
     */
    private Boolean disease4Hospitalized;
    /**
     * 既往疾病4是否治疗
     */
    private Boolean disease4Treated;
    /**
     * 既往疾病4治疗效果
     */
    private String disease4TreatmentEffect;
    /**
     * 既往疾病5名称
     */
    private String disease5Name;
    /**
     * 既往疾病5是否确诊
     */
    private Boolean disease5Diagnosed;
    /**
     * 既往疾病5确诊时间
     */
    private String disease5DiagnosisDate;
    /**
     * 既往疾病5是否住院
     */
    private Boolean disease5Hospitalized;
    /**
     * 既往疾病5是否治疗
     */
    private Boolean disease5Treated;
    /**
     * 既往疾病5治疗效果
     */
    private String disease5TreatmentEffect;
    /**
     * 既往疾病6名称
     */
    private String disease6Name;
    /**
     * 既往疾病6是否确诊
     */
    private Boolean disease6Diagnosed;
    /**
     * 既往疾病6确诊时间
     */
    private String disease6DiagnosisDate;
    /**
     * 既往疾病6是否住院
     */
    private Boolean disease6Hospitalized;
    /**
     * 既往疾病6是否治疗
     */
    private Boolean disease6Treated;
    /**
     * 既往疾病6治疗效果
     */
    private String disease6TreatmentEffect;

}