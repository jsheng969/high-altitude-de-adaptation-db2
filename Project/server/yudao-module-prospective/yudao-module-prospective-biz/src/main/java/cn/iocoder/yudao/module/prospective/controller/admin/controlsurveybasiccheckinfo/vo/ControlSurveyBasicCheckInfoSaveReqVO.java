package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 对照组流调-基本检测信息新增/修改 Request VO")
@Data
public class ControlSurveyBasicCheckInfoSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1945")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8143")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "收缩压")
    private Integer systolicBloodPressure;

    @Schema(description = "舒张压")
    private Integer diastolicBloodPressure;

    @Schema(description = "氧饱和度")
    private Integer oxygenSaturation;

    @Schema(description = "心率")
    private Integer heartRate;

    @Schema(description = "基本身高")
    private Integer basicHeight;

    @Schema(description = "基本体重")
    private Integer basicWeight;

    @Schema(description = "调查身高")
    private String surveyHeight;

    @Schema(description = "调查体重")
    private String surveyWeight;

    @Schema(description = "时相")
    private Integer timePoint;

}