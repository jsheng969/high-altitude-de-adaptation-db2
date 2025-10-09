package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组流调-评分总数统计 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlSurveyScoreSummaryRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "4797")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21791")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "评分总数")
    @ExcelProperty("评分总数")
    private BigDecimal totalScore;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

}