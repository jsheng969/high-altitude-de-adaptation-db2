package cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组体检-血常规分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamBloodRoutinePageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "27315")
    private Long personId;

    @Schema(description = "白细胞计数")
    private BigDecimal wbc;

    @Schema(description = "红细胞计数")
    private BigDecimal rbc;

    @Schema(description = "中性粒细胞计数")
    private BigDecimal neutrophils;

    @Schema(description = "淋巴细胞计数")
    private BigDecimal lymphocytes;

    @Schema(description = "单核细胞计数")
    private BigDecimal monocytes;

    @Schema(description = "嗜酸性粒细胞计数")
    private BigDecimal eosinophils;

    @Schema(description = "嗜碱性粒细胞计数")
    private BigDecimal basophils;

    @Schema(description = "平均红细胞容积")
    private BigDecimal mcv;

    @Schema(description = "平均红细胞血红蛋白含量")
    private BigDecimal mch;

    @Schema(description = "平均红细胞血红蛋白浓度")
    private BigDecimal mchc;

    @Schema(description = "RBC分布宽度CV值")
    private BigDecimal rdwCv;

    @Schema(description = "RBC分布宽度SD值")
    private BigDecimal rdwSd;

    @Schema(description = "血红蛋白浓度")
    private BigDecimal hemoglobin;

    @Schema(description = "血小板比容")
    private BigDecimal plateletCrit;

    @Schema(description = "平均血小板体积")
    private BigDecimal mpv;

    @Schema(description = "血小板分布宽度")
    private BigDecimal pdw;

    @Schema(description = "红细胞比容")
    private BigDecimal hematocrit;

    @Schema(description = "血小板计数", example = "12777")
    private BigDecimal plateletCount;

    @Schema(description = "中性粒细胞百分率")
    private BigDecimal neutrophilsPercentage;

    @Schema(description = "淋巴细胞百分率")
    private BigDecimal lymphocytesPercentage;

    @Schema(description = "单核细胞百分率")
    private BigDecimal monocytesPercentage;

    @Schema(description = "嗜酸性粒细胞百分率")
    private BigDecimal eosinophilsPercentage;

    @Schema(description = "嗜碱性粒细胞百分率")
    private BigDecimal basophilsPercentage;

}