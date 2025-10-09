package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-高原反应信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyHighlandReactionRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31381")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7215")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "是否发生过高原反应")
    @ExcelProperty("是否发生过高原反应")
    private Boolean reactionOccurred;

    @Schema(description = "高原反应次数", example = "5639")
    @ExcelProperty("高原反应次数")
    private Integer reactionCount;

    @Schema(description = "高原反应次数字符串", example = "5639")
    private String reactionCountText;

    @Schema(description = "高原反应次数记不清", example = "32388")
    @ExcelProperty("高原反应次数记不清")
    private Boolean unclearReactionCount;

    @Schema(description = "多次高原反应，高原反应变化情况")
    @ExcelProperty("多次高原反应，高原反应变化情况")
    private String multipleReactionsChanges;

}