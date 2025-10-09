package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组流调-推进情况调查 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlSurveyMissionProgressSurveyRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "2296")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5132")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "交通方式")
    @ExcelProperty("交通方式")
    private String transportationMode;

    @Schema(description = "任务点海拔")
    @ExcelProperty("任务点海拔")
    private Integer missionPointAltitude;

    @Schema(description = "地点")
    @ExcelProperty("地点")
    private String location;

    @Schema(description = "抵达任务地点日期")
    @ExcelProperty("抵达任务地点日期")
    private String arrivalDate;

    @Schema(description = "高原任务持续时间")
    @ExcelProperty("高原任务持续时间")
    private Integer plateauMissionDuration;

    @Schema(description = "推进途中耗费时间")
    @ExcelProperty("推进途中耗费时间")
    private String travelDuration;

    @Schema(description = "途中经停")
    @ExcelProperty("途中经停")
    private Boolean hasStopover;

    @Schema(description = "经停地点")
    @ExcelProperty("经停地点")
    private String stopoverLocation;

    @Schema(description = "经停时间")
    @ExcelProperty("经停时间")
    private String stopoverDuration;

    @Schema(description = "抵达任务地后有无不适")
    @ExcelProperty("抵达任务地后有无不适")
    private Boolean hasDiscomfortAfterArrival;

    @Schema(description = "不适发生时间（抵达后）")
    @ExcelProperty("不适发生时间（抵达后）")
    private String discomfortOccurrenceTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

    @Schema(description = "返回目的")
    @ExcelProperty("返回目的")
    private String returnPurpose;

}