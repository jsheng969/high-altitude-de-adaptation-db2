package cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组-framingham评分 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentFraminghamRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22126")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1699")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "分")
    @ExcelProperty("分")
    private Integer framinghamScore;

    @Schema(description = "概率")
    @ExcelProperty("概率")
    private BigDecimal framinghamRisk;

    @Schema(description = "分类", example = "2")
    @ExcelProperty("分类")
    private String framinghamRiskType;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}