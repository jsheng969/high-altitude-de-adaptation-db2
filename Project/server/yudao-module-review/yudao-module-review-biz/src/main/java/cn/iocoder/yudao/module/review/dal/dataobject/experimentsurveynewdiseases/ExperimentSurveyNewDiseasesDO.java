package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseases;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-新发的疾病 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_new_diseases")
@KeySequence("review_experiment_survey_new_diseases_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyNewDiseasesDO extends BaseDO {

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
     * 新发疾病 1 名称
     */
    private String newDisease1Name;
    /**
     * 该病是否在二级或二级以上医院被诊断
     */
    private Boolean diagnosed;
    /**
     * 该病的诊断时间
     */
    private String diagnosisDate;
    /**
     * 是否因该病住院治疗
     */
    private Boolean hospitalized;
    /**
     * 是否使用药物进行治疗
     */
    private Boolean medication;
    /**
     * 药物，治疗效果
     */
    private String medicationEffect;
    /**
     * 新发疾病 2 名称
     */
    private String newDisease2Name;
    /**
     * 该病是否在二级或二级以上医院被诊断
     */
    private Boolean diagnosed2;
    /**
     * 该病的诊断时间
     */
    private String diagnosisDate2;
    /**
     * 是否因该病住院治疗
     */
    private Boolean hospitalized2;
    /**
     * 是否使用药物进行治疗
     */
    private Boolean medication2;
    /**
     * 药物，治疗效果
     */
    private String medicationEffect2;
    /**
     * 新发疾病 3 名称
     */
    private String newDisease3Name;
    /**
     * 该病是否在二级或二级以上医院被诊断
     */
    private Boolean diagnosed3;
    /**
     * 该病的诊断时间
     */
    private String diagnosisDate3;
    /**
     * 是否因该病住院治疗
     */
    private Boolean hospitalized3;
    /**
     * 是否使用药物进行治疗
     */
    private Boolean medication3;
    /**
     * 药物，治疗效果
     */
    private String medicationEffect3;
    /**
     * 新发疾病 4 名称
     */
    private String newDisease4Name;
    /**
     * 该病是否在二级或二级以上医院被诊断
     */
    private Boolean diagnosed4;
    /**
     * 该病的诊断时间
     */
    private String diagnosisDate4;
    /**
     * 是否因该病住院治疗
     */
    private Boolean hospitalized4;
    /**
     * 是否使用药物进行治疗
     */
    private Boolean medication4;
    /**
     * 药物，治疗效果
     */
    private String medicationEffect4;

}