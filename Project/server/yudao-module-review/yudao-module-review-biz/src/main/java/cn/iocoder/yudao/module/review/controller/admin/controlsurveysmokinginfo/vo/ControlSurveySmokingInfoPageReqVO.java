package cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 对照组流调-吸烟情况分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveySmokingInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "4222")
    private Long personId;

    @Schema(description = "是否吸烟", example = "2")
    private String smokingStatus;

    @Schema(description = "烟龄")
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    private String triedQuit;

    @Schema(description = "戒烟时间")
    private String quitTime;

}