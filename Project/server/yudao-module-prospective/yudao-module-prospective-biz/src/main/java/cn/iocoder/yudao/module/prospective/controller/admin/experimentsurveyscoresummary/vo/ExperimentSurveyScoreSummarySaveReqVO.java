package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 评分总数统计新增/修改 Request VO")
@Data
public class ExperimentSurveyScoreSummarySaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "4592")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13934")
    private Long personId;

    @Schema(description = "评分总数", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal totalScore;

    @Schema(description = "时相")
    private Integer timePoint;
}