package cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 对照组流调-旅居信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveyResidenceInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "17825")
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