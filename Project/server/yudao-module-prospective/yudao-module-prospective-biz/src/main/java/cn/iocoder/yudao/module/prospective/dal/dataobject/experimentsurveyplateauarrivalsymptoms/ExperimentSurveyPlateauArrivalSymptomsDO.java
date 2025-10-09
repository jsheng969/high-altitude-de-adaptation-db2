package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateauarrivalsymptoms;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 抵达高原后症状记录 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_plateau_arrival_symptoms")
@KeySequence("prospective_experiment_survey_plateau_arrival_symptoms_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyPlateauArrivalSymptomsDO extends BaseDO {

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
     * 抵达高原后症状.头痛
     */
    private String headache;
    /**
     * 头痛持续时间
     */
    private String headacheDuration;
    /**
     * 抵达高原后症状.消化道症状
     */
    private String digestiveSymptoms;
    /**
     * 消化道症状持续时间
     */
    private String digestiveSymptomsDuration;
    /**
     * 抵达高原后症状.疲惫和/或乏力
     */
    private String fatigue;
    /**
     * 疲惫乏力持续时间
     */
    private String fatigueDuration;
    /**
     * 抵达高原后症状.头晕
     */
    private String dizziness;
    /**
     * 头晕持续时间
     */
    private String dizzinessDuration;
    /**
     * 相关症状如何影响您的日常工作及生活
     */
    private String impactOnDailyLife;

    /**
     * 时相
     */
    private Integer timePoint;
}