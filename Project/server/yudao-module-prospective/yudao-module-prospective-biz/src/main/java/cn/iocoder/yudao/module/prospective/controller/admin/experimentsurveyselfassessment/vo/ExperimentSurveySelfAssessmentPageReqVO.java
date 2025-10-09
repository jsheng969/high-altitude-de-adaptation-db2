package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 自我评价分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveySelfAssessmentPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "16970")
    private Long personId;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    private String healthComparisonWithPeers;

    @Schema(description = "您认为自己身体健康状况能得的分数")
    private Integer healthScore;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;
}