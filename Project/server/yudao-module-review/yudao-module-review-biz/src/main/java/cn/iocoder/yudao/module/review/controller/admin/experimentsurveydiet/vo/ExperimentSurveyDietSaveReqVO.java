package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-饮食习惯新增/修改 Request VO")
@Data
public class ExperimentSurveyDietSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24346")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31460")
    @NotNull(message = "基础信息id不能为空")
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