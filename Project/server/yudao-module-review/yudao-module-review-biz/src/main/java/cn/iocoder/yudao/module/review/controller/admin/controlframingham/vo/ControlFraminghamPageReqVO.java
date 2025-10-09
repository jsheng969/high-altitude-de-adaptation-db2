package cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组-framingham评分分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlFraminghamPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "32712")
    private Long personId;

    @Schema(description = "分")
    private Integer framinghamScore;

    @Schema(description = "概率")
    private BigDecimal framinghamRisk;

    @Schema(description = "分类", example = "2")
    private String framinghamRiskType;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}