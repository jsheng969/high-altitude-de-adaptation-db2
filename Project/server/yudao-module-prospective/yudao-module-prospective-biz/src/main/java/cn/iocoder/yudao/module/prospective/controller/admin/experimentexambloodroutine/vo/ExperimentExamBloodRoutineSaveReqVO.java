package cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组体检-血常规新增/修改 Request VO")
@Data
public class ExperimentExamBloodRoutineSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22245")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22805")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "白细胞计数", example = "3631")
    private BigDecimal wbcCount;

    @Schema(description = "淋巴细胞百分比")
    private BigDecimal lymphocytePercent;

    @Schema(description = "中间细胞百分比")
    private BigDecimal midCellPercent;

    @Schema(description = "粒细胞百分比")
    private BigDecimal granulocytePercent;

    @Schema(description = "淋巴细胞计数", example = "15209")
    private BigDecimal lymphocyteCount;

    @Schema(description = "中间细胞计数", example = "4343")
    private BigDecimal midCellCount;

    @Schema(description = "粒细胞计数", example = "30602")
    private BigDecimal granulocyteCount;

    @Schema(description = "红细胞计数", example = "15237")
    private BigDecimal rbcCount;

    @Schema(description = "血红蛋白")
    private BigDecimal hemoglobin;

    @Schema(description = "血细胞比容")
    private BigDecimal hematocrit;

    @Schema(description = "平均红细胞体积")
    private BigDecimal mcv;

    @Schema(description = "平均红细胞血红蛋白含量")
    private BigDecimal mch;

    @Schema(description = "平均红细胞血红蛋白浓度")
    private BigDecimal mchc;

    @Schema(description = "红细胞分布宽度变异系数")
    private BigDecimal rdwCv;

    @Schema(description = "红细胞分布宽度标准差")
    private BigDecimal rdwSd;

    @Schema(description = "血小板计数", example = "31990")
    private BigDecimal plateletCount;

    @Schema(description = "平均血小板体积")
    private BigDecimal mpv;

    @Schema(description = "血小板分布宽度")
    private BigDecimal pdw;

    @Schema(description = "血小板压积")
    private BigDecimal pct;

    @Schema(description = "大血小板比率")
    private BigDecimal largePlateletRatio;

    @Schema(description = "大血小板计数", example = "19025")
    private BigDecimal largePlateletCount;

    @Schema(description = "嗜碱性粒细胞计数", example = "8898")
    private BigDecimal basophilCount;

    @Schema(description = "嗜碱性粒细胞百分比")
    private BigDecimal basophilPercent;

    @Schema(description = "嗜酸性粒细胞计数", example = "27563")
    private BigDecimal eosinophilCount;

    @Schema(description = "嗜酸性粒细胞百分比")
    private BigDecimal eosinophilPercent;

    @Schema(description = "幼稚粒细胞计数", example = "23431")
    private BigDecimal immatureGranulocyteCount;

    @Schema(description = "幼稚粒细胞百分比")
    private BigDecimal immatureGranulocytePercent;

    @Schema(description = "单核细胞计数", example = "19323")
    private BigDecimal monocyteCount;

    @Schema(description = "单核细胞百分比")
    private BigDecimal monocytePercent;

    @Schema(description = "有核红细胞计数", example = "29173")
    private BigDecimal nucleatedRbcCount;

    @Schema(description = "有核红细胞百分比")
    private BigDecimal nucleatedRbcPercent;

    @Schema(description = "中性粒细胞计数", example = "29990")
    private BigDecimal neutrophilCount;

    @Schema(description = "中性粒细胞百分比")
    private BigDecimal neutrophilPercent;

    @Schema(description = "时相")
    private Integer timePoint;

}