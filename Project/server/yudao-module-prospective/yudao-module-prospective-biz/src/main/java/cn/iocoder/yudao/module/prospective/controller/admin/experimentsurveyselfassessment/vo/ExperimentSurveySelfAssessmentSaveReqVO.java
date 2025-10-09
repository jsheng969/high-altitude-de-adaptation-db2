package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 自我评价新增/修改 Request VO")
@Data
public class ExperimentSurveySelfAssessmentSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20449")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16970")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    private String healthComparisonWithPeers;

    @Schema(description = "您认为自己身体健康状况能得的分数")
    private Integer healthScore;

    @Schema(description = "时相")
    private Integer timePoint;
}