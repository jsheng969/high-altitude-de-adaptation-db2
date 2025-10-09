package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreactionsymptoms;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-高原反应症状 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_highland_reaction_symptoms")
@KeySequence("review_experiment_survey_highland_reaction_symptoms_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyHighlandReactionSymptomsDO extends BaseDO {

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
     * 头痛
     */
    private Boolean headache;
    /**
     * 呕吐
     */
    private Boolean vomiting;
    /**
     * 头昏
     */
    private Boolean dizziness;
    /**
     * 恶心
     */
    private Boolean nausea;
    /**
     * 心慌
     */
    private Boolean palpitations;
    /**
     * 食欲不振
     */
    private Boolean poorAppetite;
    /**
     * 胸闷
     */
    private Boolean chestTightness;
    /**
     * 眼花
     */
    private Boolean blurredVision;
    /**
     * 气短
     */
    private Boolean shortnessOfBreath;
    /**
     * 腹胀
     */
    private Boolean abdominalBloating;
    /**
     * 腹泻
     */
    private Boolean diarrhea;

}