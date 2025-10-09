package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 驻训信息新增/修改 Request VO")
@Data
public class ExperimentSurveyStationTrainingInfoSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "7833")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5519")
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

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "服役期间职务")
    private String servicePosition;

}