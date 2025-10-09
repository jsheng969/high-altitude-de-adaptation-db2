package cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组体检-基本检测信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamBasicTestsPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "11375")
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