package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateaufitnessinfo;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 高原体能信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_plateau_fitness_info")
@KeySequence("prospective_experiment_survey_plateau_fitness_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyPlateauFitnessInfoDO extends BaseDO {

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
     * 高原期间您是否有规律的体能训练
     */
    private Boolean hasRegularTraining;
    /**
     * 参加体能训练的频率
     */
    private String trainingFrequency;
    /**
     * 每次参加体育锻炼的时长
     */
    private String trainingDuration;
    /**
     * 通常进行哪种类型的体能训练
     */
    private String trainingType;
    /**
     * 是否在体能训练时感觉胸闷、气促等不适症状
     */
    private String hasChestDiscomfort;
    /**
     * 适应高原环境后，行体能训练后上述症状是否缓解
     */
    private Boolean symptomReliefAfterAdaptation;
    /**
     * 进入高原后是否存在失眠情况
     */
    private String hasInsomnia;
    /**
     * 平均每天大约能睡几小时
     */
    private String dailySleepHours;
    /**
     * 适应高原环境后，失眠情况是否改善
     */
    private Boolean insomniaImprovement;
    /**
     * 高原期间饮食情况及饮食习惯
     */
    private String dietHabits;

    /**
     * 时相
     */
    private Integer timePoint;
}