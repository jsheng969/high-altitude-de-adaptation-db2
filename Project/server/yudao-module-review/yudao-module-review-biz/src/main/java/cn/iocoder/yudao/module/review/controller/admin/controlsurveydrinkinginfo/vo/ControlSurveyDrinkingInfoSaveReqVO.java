package cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组流调-饮酒情况新增/修改 Request VO")
@Data
public class ControlSurveyDrinkingInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31630")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8865")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "饮酒经历")
    private String drinkingExperience;

    @Schema(description = "饮酒频率")
    private String drinkingFrequency;

}