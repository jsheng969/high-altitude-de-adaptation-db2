package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-高原反应信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyHighlandReactionPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "7215")
    private Long personId;

    @Schema(description = "是否发生过高原反应")
    private Boolean reactionOccurred;

    @Schema(description = "高原反应次数", example = "5639")
    private Integer reactionCount;

    @Schema(description = "高原反应次数字符串", example = "5639")
    private String reactionCountText;

    @Schema(description = "高原反应次数记不清", example = "32388")
    private Boolean unclearReactionCount;

    @Schema(description = "多次高原反应，高原反应变化情况")
    private String multipleReactionsChanges;

}