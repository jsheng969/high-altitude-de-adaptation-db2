package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 高原体能信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyPlateauFitnessInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "32314")
    private Long personId;

    @Schema(description = "高原期间您是否有规律的体能训练")
    private Boolean hasRegularTraining;

    @Schema(description = "参加体能训练的频率")
    private String trainingFrequency;

    @Schema(description = "每次参加体育锻炼的时长")
    private String trainingDuration;

    @Schema(description = "通常进行哪种类型的体能训练", example = "2")
    private String trainingType;

    @Schema(description = "是否在体能训练时感觉胸闷、气促等不适症状")
    private String hasChestDiscomfort;

    @Schema(description = "适应高原环境后，行体能训练后上述症状是否缓解")
    private Boolean symptomReliefAfterAdaptation;

    @Schema(description = "进入高原后是否存在失眠情况")
    private String hasInsomnia;

    @Schema(description = "平均每天大约能睡几小时")
    private String dailySleepHours;

    @Schema(description = "适应高原环境后，失眠情况是否改善")
    private Boolean insomniaImprovement;

    @Schema(description = "高原期间饮食情况及饮食习惯")
    private String dietHabits;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;
}