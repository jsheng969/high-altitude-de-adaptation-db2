package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 对照组流调-推进情况调查分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveyMissionProgressSurveyPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "5132")
    private Long personId;

    @Schema(description = "交通方式")
    private String transportationMode;

    @Schema(description = "任务点海拔")
    private Integer missionPointAltitude;

    @Schema(description = "地点")
    private String location;

    @Schema(description = "抵达任务地点日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] arrivalDate;

    @Schema(description = "高原任务持续时间")
    private Integer plateauMissionDuration;

    @Schema(description = "推进途中耗费时间")
    private String travelDuration;

    @Schema(description = "途中经停")
    private Boolean hasStopover;

    @Schema(description = "经停地点")
    private String stopoverLocation;

    @Schema(description = "经停时间")
    private String stopoverDuration;

    @Schema(description = "抵达任务地后有无不适")
    private Boolean hasDiscomfortAfterArrival;

    @Schema(description = "不适发生时间（抵达后）")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] discomfortOccurrenceTime;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "返回目的")
    private String returnPurpose;

}