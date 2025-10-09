package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 抵达高原后症状记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyPlateauArrivalSymptomsPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "32096")
    private Long personId;

    @Schema(description = "抵达高原后症状.头痛")
    private String headache;

    @Schema(description = "头痛持续时间")
    private String headacheDuration;

    @Schema(description = "抵达高原后症状.消化道症状")
    private String digestiveSymptoms;

    @Schema(description = "消化道症状持续时间")
    private String digestiveSymptomsDuration;

    @Schema(description = "抵达高原后症状.疲惫和/或乏力")
    private String fatigue;

    @Schema(description = "疲惫乏力持续时间")
    private String fatigueDuration;

    @Schema(description = "抵达高原后症状.头晕")
    private String dizziness;

    @Schema(description = "头晕持续时间")
    private String dizzinessDuration;

    @Schema(description = "相关症状如何影响您的日常工作及生活")
    private String impactOnDailyLife;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;
}