package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysleep;

import lombok.*;

import java.time.LocalTime;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-睡眠信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_sleep")
@KeySequence("review_experiment_survey_sleep_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveySleepDO extends BaseDO {

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
     * 晚上睡觉时间
     */
    private String sleepTimeStart;
    /**
     * 入睡需要时间（分钟）
     */
    private String sleepOnsetTime;
    /**
     * 起床时间
     */
    private String wakeTime;
    /**
     * 实际睡眠时间（小时）
     */
    private String actualSleepDuration;
    /**
     * 入睡困难
     */
    private String sleepDifficulties;
    /**
     * 夜间易醒或早醒
     */
    private String nightAwakening;
    /**
     * 夜间去厕所
     */
    private String nightUrination;
    /**
     * 呼吸不畅
     */
    private String breathingDifficulties;
    /**
     * 咳嗽或鼾声高
     */
    private String coughOrSnore;
    /**
     * 感觉冷
     */
    private String feelingCold;
    /**
     * 感觉热
     */
    private String feelingHot;
    /**
     * 做恶梦
     */
    private String nightmares;
    /**
     * 疼痛不适
     */
    private String painOrDiscomfort;
    /**
     * 其他影响睡眠的事情
     */
    private String otherSleepIssues;
    /**
     * 催眠药
     */
    private String sleepAids;
    /**
     * 感到困倦
     */
    private String fatigue;
    /**
     * 精力不足
     */
    private String lackOfEnergy;
    /**
     * 自评睡眠情况
     */
    private String selfAssessmentSleep;

}