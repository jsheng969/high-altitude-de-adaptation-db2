package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-饮酒情况 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyDrinkingRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15402")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4823")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "饮酒经历")
    @ExcelProperty(value = {"饮酒情况", "是否有饮酒经历"})
    private String drinkingExperience;

    @Schema(description = "仍在饮酒")
    @ExcelProperty(value = {"饮酒情况", "是否仍在饮酒"})
    private Boolean stillDrinking;

    @Schema(description = "饮酒频率")
    @ExcelProperty(value = {"饮酒情况", "饮酒频率"})
    private String drinkingFrequency;

    @Schema(description = "是否过量饮酒")
    @ExcelProperty(value = {"饮酒情况", "是否过量饮酒"})
    private Boolean overDrinking;

    @Schema(description = "啤酒")
    @ExcelProperty(value = {"饮酒情况", "啤酒"})
    private Boolean beer;

    @Schema(description = "白酒")
    @ExcelProperty(value = {"饮酒情况", "白酒"})
    private Boolean liquor;

    @Schema(description = "红酒")
    @ExcelProperty(value = {"饮酒情况", "红酒"})
    private Boolean redWine;

    @Schema(description = "鸡尾酒")
    @ExcelProperty(value = {"饮酒情况", "鸡尾酒"})
    private Boolean cocktails;

    @Schema(description = "烈酒")
    @ExcelProperty(value = {"饮酒情况", "烈酒"})
    private Boolean spirits;

    @Schema(description = "其他")
    @ExcelProperty(value = {"饮酒情况", "其他"})
    private Boolean otherAlcohol;

}