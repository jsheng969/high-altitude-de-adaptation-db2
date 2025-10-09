package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组流调-饮酒情况新增/修改 Request VO")
@Data
public class ExperimentSurveyDrinkingSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15402")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4823")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "饮酒经历")
    private String drinkingExperience;

    @Schema(description = "仍在饮酒")
    private Boolean stillDrinking;

    @Schema(description = "饮酒频率")
    private String drinkingFrequency;

    @Schema(description = "是否过量饮酒")
    private Boolean overDrinking;

    @Schema(description = "啤酒")
    private Boolean beer;

    @Schema(description = "白酒")
    private Boolean liquor;

    @Schema(description = "红酒")
    private Boolean redWine;

    @Schema(description = "鸡尾酒")
    private Boolean cocktails;

    @Schema(description = "烈酒")
    private Boolean spirits;

    @Schema(description = "其他")
    private Boolean otherAlcohol;

}