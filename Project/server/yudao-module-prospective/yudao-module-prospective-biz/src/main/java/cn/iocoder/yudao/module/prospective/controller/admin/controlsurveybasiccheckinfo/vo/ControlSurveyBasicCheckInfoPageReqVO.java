package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 对照组流调-基本检测信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveyBasicCheckInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "8143")
    private Long personId;

    @Schema(description = "收缩压")
    private String systolicBloodPressure;

    @Schema(description = "舒张压")
    private Integer diastolicBloodPressure;

    @Schema(description = "氧饱和度")
    private Integer oxygenSaturation;

    @Schema(description = "心率")
    private Integer heartRate;

    @Schema(description = "基本身高")
    private Integer basicHeight;

    @Schema(description = "基本体重")
    private Integer basicWeight;

    @Schema(description = "调查身高")
    private String surveyHeight;

    @Schema(description = "调查体重")
    private String surveyWeight;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

}