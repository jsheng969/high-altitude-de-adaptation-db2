package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 评分总数统计 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyScoreSummaryRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "4592")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13934")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "评分总数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评分总数")
    private BigDecimal totalScore;

    @Schema(description = "评分总数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评分总数")
    private BigDecimal totalScore2;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;
}