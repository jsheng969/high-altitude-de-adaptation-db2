package cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-基本检测信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamBasicTestsRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25660")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11375")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "收缩压(mmHg)")
    @ExcelProperty("收缩压(mmHg)")
    private BigDecimal systolicPressure;

    @Schema(description = "舒张压(mmHg)")
    @ExcelProperty("舒张压(mmHg)")
    private BigDecimal diastolicPressure;

    @Schema(description = "脉搏(次/分)")
    @ExcelProperty("脉搏(次/分)")
    private Integer pulse;

    @Schema(description = "身高(CM)")
    @ExcelProperty("身高(CM)")
    private BigDecimal height;

    @Schema(description = "体重(KG)")
    @ExcelProperty("体重(KG)")
    private BigDecimal weight;

    @Schema(description = "体重指数(kg/m^2)")
    @ExcelProperty("体重指数(kg/m^2)")
    private BigDecimal bmi;

}