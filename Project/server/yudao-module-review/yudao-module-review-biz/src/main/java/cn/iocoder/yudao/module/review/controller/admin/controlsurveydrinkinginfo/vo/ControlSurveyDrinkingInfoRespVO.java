package cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组流调-饮酒情况 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlSurveyDrinkingInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31630")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8865")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "饮酒经历")
    @ExcelProperty("饮酒经历")
    private String drinkingExperience;

    @Schema(description = "饮酒频率")
    @ExcelProperty("饮酒频率")
    private String drinkingFrequency;

}