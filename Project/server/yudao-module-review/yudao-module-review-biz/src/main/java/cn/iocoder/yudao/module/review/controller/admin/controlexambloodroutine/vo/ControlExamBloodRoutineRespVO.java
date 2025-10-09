package cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组体检-血常规 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlExamBloodRoutineRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "20591")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "10436")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "白细胞计数")
    @ExcelProperty("白细胞计数")
    private BigDecimal wbc;

    @Schema(description = "红细胞计数")
    @ExcelProperty("红细胞计数")
    private BigDecimal rbc;

    @Schema(description = "中性粒细胞计数")
    @ExcelProperty("中性粒细胞计数")
    private BigDecimal neutrophils;

    @Schema(description = "淋巴细胞计数")
    @ExcelProperty("淋巴细胞计数")
    private BigDecimal lymphocytes;

    @Schema(description = "单核细胞计数")
    @ExcelProperty("单核细胞计数")
    private BigDecimal monocytes;

    @Schema(description = "嗜酸性粒细胞计数")
    @ExcelProperty("嗜酸性粒细胞计数")
    private BigDecimal eosinophils;

    @Schema(description = "嗜碱性粒细胞计数")
    @ExcelProperty("嗜碱性粒细胞计数")
    private BigDecimal basophils;

    @Schema(description = "平均红细胞容积")
    @ExcelProperty("平均红细胞容积")
    private BigDecimal mcv;

    @Schema(description = "平均红细胞血红蛋白含量")
    @ExcelProperty("平均红细胞血红蛋白含量")
    private BigDecimal mch;

    @Schema(description = "平均红细胞血红蛋白浓度")
    @ExcelProperty("平均红细胞血红蛋白浓度")
    private BigDecimal mchc;

    @Schema(description = "RBC分布宽度CV值")
    @ExcelProperty("RBC分布宽度CV值")
    private BigDecimal rdwCv;

    @Schema(description = "RBC分布宽度SD值")
    @ExcelProperty("RBC分布宽度SD值")
    private BigDecimal rdwSd;

    @Schema(description = "血红蛋白浓度")
    @ExcelProperty("血红蛋白浓度")
    private BigDecimal hemoglobin;

    @Schema(description = "血小板比容")
    @ExcelProperty("血小板比容")
    private BigDecimal plateletCrit;

    @Schema(description = "平均血小板体积")
    @ExcelProperty("平均血小板体积")
    private BigDecimal mpv;

    @Schema(description = "血小板分布宽度")
    @ExcelProperty("血小板分布宽度")
    private BigDecimal pdw;

    @Schema(description = "红细胞比容")
    @ExcelProperty("红细胞比容")
    private BigDecimal hematocrit;

    @Schema(description = "血小板计数", example = "32399")
    @ExcelProperty("血小板计数")
    private BigDecimal plateletCount;

    @Schema(description = "中性粒细胞百分率")
    @ExcelProperty("中性粒细胞百分率")
    private BigDecimal neutrophilsPercentage;

    @Schema(description = "淋巴细胞百分率")
    @ExcelProperty("淋巴细胞百分率")
    private BigDecimal lymphocytesPercentage;

    @Schema(description = "单核细胞百分率")
    @ExcelProperty("单核细胞百分率")
    private BigDecimal monocytesPercentage;

    @Schema(description = "嗜酸性粒细胞百分率")
    @ExcelProperty("嗜酸性粒细胞百分率")
    private BigDecimal eosinophilsPercentage;

    @Schema(description = "嗜碱性粒细胞百分率")
    @ExcelProperty("嗜碱性粒细胞百分率")
    private BigDecimal basophilsPercentage;

}