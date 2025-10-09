package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 对照组流调-评分总数统计新增/修改 Request VO")
@Data
public class ControlSurveyScoreSummarySaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "4797")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21791")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "评分总数")
    private BigDecimal totalScore;

    @Schema(description = "时相")
    private Integer timePoint;

}