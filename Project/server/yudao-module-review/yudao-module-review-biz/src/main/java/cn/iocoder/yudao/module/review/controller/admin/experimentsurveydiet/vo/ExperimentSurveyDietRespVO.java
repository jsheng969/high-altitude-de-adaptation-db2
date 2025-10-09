package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-饮食习惯 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyDietRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24346")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31460")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "饮食习惯")
    @ExcelProperty("饮食习惯")
    private String eatingHabits;

    @Schema(description = "饮用水")
    @ExcelProperty("饮用水")
    private String drinkingWater;

    @Schema(description = "茶水")
    @ExcelProperty("茶水")
    private String tea;

    @Schema(description = "果汁")
    @ExcelProperty("果汁")
    private String fruitJuice;

    @Schema(description = "碳酸饮料")
    @ExcelProperty("碳酸饮料")
    private String carbonatedDrinks;

    @Schema(description = "咖啡")
    @ExcelProperty("咖啡")
    private String coffee;

    @Schema(description = "牛奶 ")
    @ExcelProperty("牛奶 ")
    private String milk;

}