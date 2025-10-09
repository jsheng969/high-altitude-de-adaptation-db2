package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-体育锻炼信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyExercisePageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "30786")
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