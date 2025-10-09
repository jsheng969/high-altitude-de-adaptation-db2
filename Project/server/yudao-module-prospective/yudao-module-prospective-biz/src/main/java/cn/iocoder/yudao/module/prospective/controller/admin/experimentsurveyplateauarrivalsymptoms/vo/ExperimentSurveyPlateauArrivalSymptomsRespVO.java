package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 抵达高原后症状记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyPlateauArrivalSymptomsRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "24942")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32096")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "抵达高原后症状.头痛")
    @ExcelProperty("抵达高原后症状.头痛")
    private String headache;

    @Schema(description = "头痛持续时间")
    @ExcelProperty("头痛持续时间")
    private String headacheDuration;

    @Schema(description = "抵达高原后症状.消化道症状")
    @ExcelProperty("抵达高原后症状.消化道症状")
    private String digestiveSymptoms;

    @Schema(description = "消化道症状持续时间")
    @ExcelProperty("消化道症状持续时间")
    private String digestiveSymptomsDuration;

    @Schema(description = "抵达高原后症状.疲惫和/或乏力")
    @ExcelProperty("抵达高原后症状.疲惫和/或乏力")
    private String fatigue;

    @Schema(description = "疲惫乏力持续时间")
    @ExcelProperty("疲惫乏力持续时间")
    private String fatigueDuration;

    @Schema(description = "抵达高原后症状.头晕")
    @ExcelProperty("抵达高原后症状.头晕")
    private String dizziness;

    @Schema(description = "头晕持续时间")
    @ExcelProperty("头晕持续时间")
    private String dizzinessDuration;

    @Schema(description = "相关症状如何影响您的日常工作及生活")
    @ExcelProperty("相关症状如何影响您的日常工作及生活")
    private String impactOnDailyLife;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;
}