package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-体育锻炼信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyExerciseRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24446")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30786")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "是否有规律的体育锻炼")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "是否有规律锻炼"})
    private Boolean regularExercise;

    @Schema(description = "参加体育锻炼的频率")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "锻炼频率"})
    private String exerciseFrequency;

    @Schema(description = "参加体育锻炼的时长")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "每次锻炼时长"})
    private String exerciseDuration;

    @Schema(description = "哪种类型的体育锻炼", example = "1")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "体育锻炼形式"})
    private String exerciseType;

    @Schema(description = "胸闷、气促")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "胸闷、气促"})
    private Boolean chestPainOrShortness;

    @Schema(description = "是否在医生指导下体育锻炼")
    @ExcelProperty(value = {"返回平原后体育锻炼情况", "医生指导下体育锻炼"})
    private Boolean doctorGuidedExercise;

}