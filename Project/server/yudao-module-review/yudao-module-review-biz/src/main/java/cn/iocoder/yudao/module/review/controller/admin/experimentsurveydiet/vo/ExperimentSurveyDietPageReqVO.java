package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-饮食习惯分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyDietPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "31460")
    private Long personId;

    @Schema(description = "饮食习惯")
    private String eatingHabits;

    @Schema(description = "饮用水")
    private String drinkingWater;

    @Schema(description = "茶水")
    private String tea;

    @Schema(description = "果汁")
    private String fruitJuice;

    @Schema(description = "碳酸饮料")
    private String carbonatedDrinks;

    @Schema(description = "咖啡")
    private String coffee;

    @Schema(description = "牛奶 ")
    private String milk;

}