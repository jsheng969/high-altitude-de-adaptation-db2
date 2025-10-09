package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 实验组流调-饮酒情况分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyDrinkingPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "4823")
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