package cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组体检-凝血功能新增/修改 Request VO")
@Data
public class ControlExamCoagulationTestsSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1867")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7773")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "活化部分凝血活酶时间")
    private BigDecimal aptt;

    @Schema(description = "抗凝血酶Ⅲ活性百分比")
    private BigDecimal antithrombinIiiActivityPercent;

    @Schema(description = "抗凝血酶Ⅲ活性（吸光度变化速率检测）")
    private BigDecimal antithrombinIiiActivityRate;

    @Schema(description = "D-二聚体（光密度差值检测）")
    private BigDecimal dDimerOptDensity;

    @Schema(description = "D-二聚体浓度")
    private BigDecimal dDimerConcentration;

    @Schema(description = "纤维蛋白降解产物（光密度差值检测）")
    private BigDecimal fibrinDegradationProductsDensity;

    @Schema(description = "纤维蛋白降解产物浓度")
    private BigDecimal fibrinDegradationProductsConcentration;

    @Schema(description = "纤维蛋白原浓度")
    private BigDecimal fibrinogenConcentration;

    @Schema(description = "纤维蛋白原凝固时间")
    private BigDecimal fibrinogenClottingTime;

    @Schema(description = "凝血酶原时间(百分比活动度)")
    private BigDecimal prothrombinTimePercent;

    @Schema(description = "凝血酶原时间-国际标准化比值")
    private BigDecimal ptInr;

    @Schema(description = "凝血酶原时间比值")
    private BigDecimal prothrombinTimeRatio;

    @Schema(description = "凝血酶原时间")
    private BigDecimal prothrombinTime;

    @Schema(description = "凝血酶时间")
    private BigDecimal thrombinTime;

    @Schema(description = "凝血酶时间(1)")
    private BigDecimal thrombinTime1;

    @Schema(description = "活化部分凝血活酶时间(1)")
    private BigDecimal aptt1;

    @Schema(description = "活化部分凝血活酶时间(2)")
    private BigDecimal aptt2;

    @Schema(description = "凝血酶原活动度")
    private BigDecimal prothrombinActivity;

    @Schema(description = "国际标准化比值")
    private BigDecimal inr;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "PTDF")
    private BigDecimal ptdFbg;

}