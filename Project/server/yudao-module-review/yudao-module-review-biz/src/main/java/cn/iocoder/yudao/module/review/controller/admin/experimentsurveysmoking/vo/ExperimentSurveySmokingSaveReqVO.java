package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-吸烟情况新增/修改 Request VO")
@Data
public class ExperimentSurveySmokingSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22011")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16046")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "是否吸烟", example = "1")
    private String smokingStatus;

    @Schema(description = "每日抽烟数量")
    private String dailySmoking;

    @Schema(description = "开始吸烟年龄")
    private Integer smokingStartAge;

    @Schema(description = "烟龄")
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    private Boolean triedQuit;

    @Schema(description = "高原/平原吸烟情况", example = "2")
    private String highlandPlainSmokingStatus;

    @Schema(description = "烟龄 2")
    private String smokingYears2;

    @Schema(description = "戒烟时间")
    private String quitTime;

    @Schema(description = "高原/平原吸烟情况 2")
    private String highlandPlainSmokingStatus2;

}