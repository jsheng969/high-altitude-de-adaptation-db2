package cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组流调-旅居信息新增/修改 Request VO")
@Data
public class ControlSurveyResidenceInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "215")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17825")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "高原经历")
    private String highlandExperience;

    @Schema(description = "长期平原经历")
    private String longTermPlainExperience;

    @Schema(description = "常住地1")
    private String residence1;

    @Schema(description = "常住地2")
    private String residence2;

    @Schema(description = "常住地3")
    private String residence3;

}