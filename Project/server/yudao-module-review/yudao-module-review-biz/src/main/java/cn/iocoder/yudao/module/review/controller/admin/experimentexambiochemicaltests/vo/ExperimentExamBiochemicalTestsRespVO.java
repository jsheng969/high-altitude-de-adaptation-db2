package cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-生化 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamBiochemicalTestsRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17714")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30318")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "尿素")
    @ExcelProperty("尿素")
    private BigDecimal urea;

    @Schema(description = "肌酐")
    @ExcelProperty("肌酐")
    private BigDecimal creatinine;

    @Schema(description = "谷丙转氨酶")
    @ExcelProperty("谷丙转氨酶")
    private BigDecimal alt;

    @Schema(description = "谷草转氨酶")
    @ExcelProperty("谷草转氨酶")
    private BigDecimal ast;

    @Schema(description = "总胆固醇")
    @ExcelProperty("总胆固醇")
    private BigDecimal totalCholesterol;

    @Schema(description = "甘油三酯")
    @ExcelProperty("甘油三酯")
    private BigDecimal triglycerides;

    @Schema(description = "高密度脂蛋白胆固醇")
    @ExcelProperty("高密度脂蛋白胆固醇")
    private BigDecimal hdlC;

    @Schema(description = "低密度脂蛋白胆固醇")
    @ExcelProperty("低密度脂蛋白胆固醇")
    private BigDecimal ldlC;

    @Schema(description = "尿酸", example = "776")
    @ExcelProperty("尿酸")
    private BigDecimal uricAcid;

    @Schema(description = "总蛋白")
    @ExcelProperty("总蛋白")
    private BigDecimal totalProtein;

    @Schema(description = "白蛋白")
    @ExcelProperty("白蛋白")
    private BigDecimal albumin;

    @Schema(description = "球蛋白")
    @ExcelProperty("球蛋白")
    private BigDecimal globulin;

    @Schema(description = "白球比例")
    @ExcelProperty("白球比例")
    private BigDecimal albGlobRatio;

    @Schema(description = "总胆红素")
    @ExcelProperty("总胆红素")
    private BigDecimal totalBilirubin;

    @Schema(description = "直接胆红素")
    @ExcelProperty("直接胆红素")
    private BigDecimal directBilirubin;

    @Schema(description = "间接胆红素")
    @ExcelProperty("间接胆红素")
    private BigDecimal indirectBilirubin;

    @Schema(description = "糖化血红蛋白")
    @ExcelProperty("糖化血红蛋白")
    private BigDecimal glycatedHemoglobin;

    @Schema(description = "钾")
    @ExcelProperty("钾")
    private BigDecimal potassium;

    @Schema(description = "钠")
    @ExcelProperty("钠")
    private BigDecimal sodium;

    @Schema(description = "氯")
    @ExcelProperty("氯")
    private BigDecimal chloride;

    @Schema(description = "钙")
    @ExcelProperty("钙")
    private BigDecimal calcium;

    @Schema(description = "磷")
    @ExcelProperty("磷")
    private BigDecimal phosphorus;

    @Schema(description = "镁")
    @ExcelProperty("镁")
    private BigDecimal magnesium;

    @Schema(description = "葡萄糖空腹")
    @ExcelProperty("葡萄糖空腹")
    private BigDecimal fastingGlucose;

    @Schema(description = "凝血酶原时间")
    @ExcelProperty("凝血酶原时间")
    private BigDecimal prothrombinTime;

    @Schema(description = "凝血酶原活动度")
    @ExcelProperty("凝血酶原活动度")
    private BigDecimal prothrombinActivity;

    @Schema(description = "国际标准化比率")
    @ExcelProperty("国际标准化比率")
    private BigDecimal inr;

    @Schema(description = "纤维蛋白原")
    @ExcelProperty("纤维蛋白原")
    private BigDecimal fibrinogen;

    @Schema(description = "活化部分凝血活酶时间")
    @ExcelProperty("活化部分凝血活酶时间")
    private BigDecimal aptt;

    @Schema(description = "凝血酶时间")
    @ExcelProperty("凝血酶时间")
    private BigDecimal thrombinTime;

}