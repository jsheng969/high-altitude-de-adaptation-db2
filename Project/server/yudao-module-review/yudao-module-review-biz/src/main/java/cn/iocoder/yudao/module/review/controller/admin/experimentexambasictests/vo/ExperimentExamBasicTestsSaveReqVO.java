package cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组体检-基本检测信息新增/修改 Request VO")
@Data
public class ExperimentExamBasicTestsSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25660")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11375")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "收缩压(mmHg)")
    private BigDecimal systolicPressure;

    @Schema(description = "舒张压(mmHg)")
    private BigDecimal diastolicPressure;

    @Schema(description = "脉搏(次/分)")
    private Integer pulse;

    @Schema(description = "身高(CM)")
    private BigDecimal height;

    @Schema(description = "体重(KG)")
    private BigDecimal weight;

    @Schema(description = "体重指数(kg/m^2)")
    private BigDecimal bmi;

}