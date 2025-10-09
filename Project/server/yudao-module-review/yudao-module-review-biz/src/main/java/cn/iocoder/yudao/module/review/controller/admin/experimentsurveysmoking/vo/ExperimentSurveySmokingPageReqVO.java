package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组流调-吸烟情况分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveySmokingPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "16046")
    private Long personId;

    @Schema(description = "是否吸烟", example = "1")
    private String smokingStatus;

    @Schema(description = "每日抽烟数量")
    private String dailySmoking;

    @Schema(description = "开始吸烟年龄")
    private Integer smokingStartAge;

    @Schema(description = "烟龄")
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    private Boolean triedQuit;

    @Schema(description = "高原/平原吸烟情况", example = "2")
    private String highlandPlainSmokingStatus;

    @Schema(description = "烟龄 2")
    private String smokingYears2;

    @Schema(description = "戒烟时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String quitTime;

    @Schema(description = "高原/平原吸烟情况 2")
    private String highlandPlainSmokingStatus2;

}