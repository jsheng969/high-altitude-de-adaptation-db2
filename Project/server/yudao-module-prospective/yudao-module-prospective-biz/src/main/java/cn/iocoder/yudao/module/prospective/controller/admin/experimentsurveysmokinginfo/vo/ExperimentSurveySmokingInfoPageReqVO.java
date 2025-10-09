package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 吸烟信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveySmokingInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "3326")
    private Long personId;

    @Schema(description = "吸烟情况", example = "2")
    private String smokingStatus;

    @Schema(description = "每天抽烟的数量")
    private String dailyCigarettes;

    @Schema(description = "开始吸烟时年龄")
    private String smokingStartAge;

    @Schema(description = "烟龄")
    private String smokingYears;

    @Schema(description = "之前尝试过戒烟吗")
    private Boolean quitAttempted;

    @Schema(description = "吸烟地区")
    private String smokingRegion;

    @Schema(description = "已戒烟.您的烟龄")
    private String quitSmokingYears;

    @Schema(description = "已戒烟.您已戒烟")
    private String quitSmokingDuration;

    @Schema(description = "已戒烟.吸烟地区")
    private String quitSmokingRegion;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;
}