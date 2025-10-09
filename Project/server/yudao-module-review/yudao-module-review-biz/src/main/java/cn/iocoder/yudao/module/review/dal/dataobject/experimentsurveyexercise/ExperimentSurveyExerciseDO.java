package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyexercise;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-体育锻炼信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_exercise")
@KeySequence("review_experiment_survey_exercise_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyExerciseDO extends BaseDO {

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
     * 是否有规律的体育锻炼
     */
    private Boolean regularExercise;
    /**
     * 参加体育锻炼的频率
     */
    private String exerciseFrequency;
    /**
     * 参加体育锻炼的时长
     */
    private String exerciseDuration;
    /**
     * 哪种类型的体育锻炼
     */
    private String exerciseType;
    /**
     * 胸闷、气促
     */
    private Boolean chestPainOrShortness;
    /**
     * 是否在医生指导下体育锻炼
     */
    private Boolean doctorGuidedExercise;

}