package cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 对照组流调-饮酒情况分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveyDrinkingInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "8865")
    private Long personId;

    @Schema(description = "饮酒经历")
    private String drinkingExperience;

    @Schema(description = "饮酒频率")
    private String drinkingFrequency;

}