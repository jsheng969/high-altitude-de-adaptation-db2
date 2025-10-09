package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-高原反应症状分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyHighlandReactionSymptomsPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "12544")
    private Long personId;

    @Schema(description = "头痛")
    private Boolean headache;

    @Schema(description = "呕吐")
    private Boolean vomiting;

    @Schema(description = "头昏")
    private Boolean dizziness;

    @Schema(description = "恶心")
    private Boolean nausea;

    @Schema(description = "心慌")
    private Boolean palpitations;

    @Schema(description = "食欲不振")
    private Boolean poorAppetite;

    @Schema(description = "胸闷")
    private Boolean chestTightness;

    @Schema(description = "眼花")
    private Boolean blurredVision;

    @Schema(description = "气短")
    private Boolean shortnessOfBreath;

    @Schema(description = "腹胀")
    private Boolean abdominalBloating;

    @Schema(description = "腹泻")
    private Boolean diarrhea;

}