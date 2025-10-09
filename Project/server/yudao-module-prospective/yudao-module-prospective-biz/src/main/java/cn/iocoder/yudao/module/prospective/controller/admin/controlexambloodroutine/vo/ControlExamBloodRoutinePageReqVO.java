package cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组体检-血常规分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlExamBloodRoutinePageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "28397")
    private Long personId;

    @Schema(description = "白细胞计数", example = "31560")
    private BigDecimal wbcCount;

    @Schema(description = "淋巴细胞百分比")
    private BigDecimal lymphocytePercent;

    @Schema(description = "中间细胞百分比")
    private BigDecimal midCellPercent;

    @Schema(description = "粒细胞百分比")
    private BigDecimal granulocytePercent;

    @Schema(description = "淋巴细胞计数", example = "17124")
    private BigDecimal lymphocyteCount;

    @Schema(description = "中间细胞计数", example = "16465")
    private BigDecimal midCellCount;

    @Schema(description = "粒细胞计数", example = "12945")
    private BigDecimal granulocyteCount;

    @Schema(description = "红细胞计数", example = "7930")
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

    @Schema(description = "血小板计数", example = "18947")
    private BigDecimal plateletCount;

    @Schema(description = "平均血小板体积")
    private BigDecimal mpv;

    @Schema(description = "血小板分布宽度")
    private BigDecimal pdw;

    @Schema(description = "血小板压积")
    private BigDecimal pct;

    @Schema(description = "大血小板比率")
    private BigDecimal largePlateletRatio;

    @Schema(description = "大血小板计数", example = "19179")
    private BigDecimal largePlateletCount;

    @Schema(description = "嗜碱性粒细胞计数", example = "32705")
    private BigDecimal basophilCount;

    @Schema(description = "嗜碱性粒细胞百分比")
    private BigDecimal basophilPercent;

    @Schema(description = "嗜酸性粒细胞计数", example = "4387")
    private BigDecimal eosinophilCount;

    @Schema(description = "嗜酸性粒细胞百分比")
    private BigDecimal eosinophilPercent;

    @Schema(description = "幼稚粒细胞计数", example = "11603")
    private BigDecimal immatureGranulocyteCount;

    @Schema(description = "幼稚粒细胞百分比")
    private BigDecimal immatureGranulocytePercent;

    @Schema(description = "单核细胞计数", example = "22678")
    private BigDecimal monocyteCount;

    @Schema(description = "单核细胞百分比")
    private BigDecimal monocytePercent;

    @Schema(description = "有核红细胞计数", example = "2589")
    private BigDecimal nucleatedRbcCount;

    @Schema(description = "有核红细胞百分比")
    private BigDecimal nucleatedRbcPercent;

    @Schema(description = "中性粒细胞计数", example = "21927")
    private BigDecimal neutrophilCount;

    @Schema(description = "中性粒细胞百分比")
    private BigDecimal neutrophilPercent;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "NE%")
    private BigDecimal ne;

    @Schema(description = "LY%")
    private BigDecimal ly;

    @Schema(description = "MO%")
    private BigDecimal mo;

    @Schema(description = "Neut#")
    private BigDecimal neut;

    @Schema(description = "Lymph#")
    private BigDecimal lymph;

    @Schema(description = "Eos#")
    private BigDecimal eos;

    @Schema(description = "CREA")
    private BigDecimal crea;

    @Schema(description = "CYSC")
    private BigDecimal cysc;

    @Schema(description = "CLCR")
    private BigDecimal clcr;

    @Schema(description = "URIC")
    private BigDecimal uric;

}