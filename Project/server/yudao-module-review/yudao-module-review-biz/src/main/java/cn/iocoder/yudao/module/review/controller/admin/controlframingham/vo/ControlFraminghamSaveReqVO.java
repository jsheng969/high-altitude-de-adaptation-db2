package cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组-framingham评分新增/修改 Request VO")
@Data
public class ControlFraminghamSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17173")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32712")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "分")
    private Integer framinghamScore;

    @Schema(description = "概率")
    private BigDecimal framinghamRisk;

    @Schema(description = "分类", example = "2")
    private String framinghamRiskType;

}