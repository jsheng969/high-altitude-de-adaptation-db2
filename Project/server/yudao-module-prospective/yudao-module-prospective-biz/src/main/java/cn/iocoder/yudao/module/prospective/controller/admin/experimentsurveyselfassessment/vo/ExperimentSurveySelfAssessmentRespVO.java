package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 自我评价 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveySelfAssessmentRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20449")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16970")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    @ExcelProperty("与同龄人相比，您认为目前自己的身体健康状况如何")
    private String healthComparisonWithPeers;

    @Schema(description = "您认为自己身体健康状况能得的分数")
    @ExcelProperty("您认为自己身体健康状况能得的分数")
    private Integer healthScore;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;
}