package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 驻训信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyStationTrainingInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "5519")
    private Long personId;

    @Schema(description = "任务点海拔")
    private Integer missionPointAltitude;

    @Schema(description = "地点")
    private String location;

    @Schema(description = "高原驻训次数", example = "20989")
    private Integer plateauTrainingCount;

    @Schema(description = "高原驻训总时长")
    private Integer plateauTrainingDuration;

    @Schema(description = "任务从事类型", example = "2")
    private String missionType;

    @Schema(description = "每日工作时间")
    private Integer dailyWorkHours;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "服役期间职务")
    private String servicePosition;
}