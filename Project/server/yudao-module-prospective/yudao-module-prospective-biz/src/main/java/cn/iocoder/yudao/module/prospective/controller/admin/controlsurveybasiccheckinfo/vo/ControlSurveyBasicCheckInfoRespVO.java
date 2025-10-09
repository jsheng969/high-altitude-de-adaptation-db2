package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组流调-基本检测信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlSurveyBasicCheckInfoRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1945")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8143")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "收缩压")
    @ExcelProperty("收缩压")
    private Integer systolicBloodPressure;

    @Schema(description = "舒张压")
    @ExcelProperty("舒张压")
    private Integer diastolicBloodPressure;

    @Schema(description = "氧饱和度")
    @ExcelProperty("氧饱和度")
    private Integer oxygenSaturation;

    @Schema(description = "心率")
    @ExcelProperty("心率")
    private Integer heartRate;

    @Schema(description = "基本身高")
    @ExcelProperty("基本身高")
    private Integer basicHeight;

    @Schema(description = "基本体重")
    @ExcelProperty("基本体重")
    private Integer basicWeight;

    @Schema(description = "调查身高")
    @ExcelProperty("调查身高")
    private String surveyHeight;

    @Schema(description = "调查体重")
    @ExcelProperty("调查体重")
    private String surveyWeight;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

}