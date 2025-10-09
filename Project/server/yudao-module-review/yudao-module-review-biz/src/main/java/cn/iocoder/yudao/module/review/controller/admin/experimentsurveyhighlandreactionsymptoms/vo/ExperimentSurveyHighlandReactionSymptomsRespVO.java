package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-高原反应症状 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyHighlandReactionSymptomsRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5111")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "12544")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "头痛")
    @ExcelProperty("头痛")
    private Boolean headache;

    @Schema(description = "呕吐")
    @ExcelProperty("呕吐")
    private Boolean vomiting;

    @Schema(description = "头昏")
    @ExcelProperty("头昏")
    private Boolean dizziness;

    @Schema(description = "恶心")
    @ExcelProperty("恶心")
    private Boolean nausea;

    @Schema(description = "心慌")
    @ExcelProperty("心慌")
    private Boolean palpitations;

    @Schema(description = "食欲不振")
    @ExcelProperty("食欲不振")
    private Boolean poorAppetite;

    @Schema(description = "胸闷")
    @ExcelProperty("胸闷")
    private Boolean chestTightness;

    @Schema(description = "眼花")
    @ExcelProperty("眼花")
    private Boolean blurredVision;

    @Schema(description = "气短")
    @ExcelProperty("气短")
    private Boolean shortnessOfBreath;

    @Schema(description = "腹胀")
    @ExcelProperty("腹胀")
    private Boolean abdominalBloating;

    @Schema(description = "腹泻")
    @ExcelProperty("腹泻")
    private Boolean diarrhea;

}