package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo;

import lombok.*;

import java.time.LocalTime;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组流调-睡眠信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveySleepPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "3331")
    private Long personId;

    @Schema(description = "晚上睡觉时间")
    private String sleepTimeStart;

    @Schema(description = "入睡需要时间（分钟）")
    private String sleepOnsetTime;

    @Schema(description = "起床时间")
    private String wakeTime;

    @Schema(description = "实际睡眠时间（小时）")
    private String actualSleepDuration;

    @Schema(description = "入睡困难")
    private String sleepDifficulties;

    @Schema(description = "夜间易醒或早醒")
    private String nightAwakening;

    @Schema(description = "夜间去厕所")
    private String nightUrination;

    @Schema(description = "呼吸不畅")
    private String breathingDifficulties;

    @Schema(description = "咳嗽或鼾声高")
    private String coughOrSnore;

    @Schema(description = "感觉冷")
    private String feelingCold;

    @Schema(description = "感觉热")
    private String feelingHot;

    @Schema(description = "做恶梦")
    private String nightmares;

    @Schema(description = "疼痛不适")
    private String painOrDiscomfort;

    @Schema(description = "其他影响睡眠的事情")
    private String otherSleepIssues;

    @Schema(description = "催眠药")
    private String sleepAids;

    @Schema(description = "感到困倦")
    private String fatigue;

    @Schema(description = "精力不足")
    private String lackOfEnergy;

    @Schema(description = "自评睡眠情况")
    private String selfAssessmentSleep;

}