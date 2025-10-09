package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-体育锻炼信息新增/修改 Request VO")
@Data
public class ExperimentSurveyExerciseSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24446")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30786")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "是否有规律的体育锻炼")
    private Boolean regularExercise;

    @Schema(description = "参加体育锻炼的频率")
    private String exerciseFrequency;

    @Schema(description = "参加体育锻炼的时长")
    private String exerciseDuration;

    @Schema(description = "哪种类型的体育锻炼", example = "1")
    private String exerciseType;

    @Schema(description = "胸闷、气促")
    private Boolean chestPainOrShortness;

    @Schema(description = "是否在医生指导下体育锻炼")
    private Boolean doctorGuidedExercise;

}