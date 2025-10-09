package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 推进情况调查 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_mission_progress_survey")
@KeySequence("prospective_experiment_survey_mission_progress_survey_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyMissionProgressSurveyDO extends BaseDO {

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
     * 交通方式
     */
    private String transportationMode;
    /**
     * 任务点海拔
     */
    private Integer missionPointAltitude;
    /**
     * 地点
     */
    private String location;
    /**
     * 抵达任务地点日期
     */
    private String arrivalDate;
    /**
     * 高原任务持续时间
     */
    private Integer plateauMissionDuration;
    /**
     * 推进途中耗费时间
     */
    private Boolean travelDuration;
    /**
     * 途中经停
     */
    private Boolean hasStopover;
    /**
     * 经停地点
     */
    private String stopoverLocation;
    /**
     * 经停时间
     */
    private String stopoverDuration;
    /**
     * 抵达任务地后有无不适
     */
    private Boolean hasDiscomfortAfterArrival;
    /**
     * 不适发生时间（抵达后）
     */
    private String discomfortOccurrenceTime;

    /**
     * 时相
     */
    private Integer timePoint;

    /**
     * 返回目的
     */
    private String returnPurpose;
}