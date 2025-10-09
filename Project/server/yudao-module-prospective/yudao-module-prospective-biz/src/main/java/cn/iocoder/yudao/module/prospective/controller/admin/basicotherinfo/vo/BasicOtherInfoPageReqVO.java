package cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 基础其他信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BasicOtherInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "13573")
    private Long personId;

    @Schema(description = "婚姻状况", example = "2")
    private String maritalStatus;

    @Schema(description = "生育情况", example = "1")
    private String fertilityStatus;

    @Schema(description = "身高")
    private BigDecimal height;

    @Schema(description = "体重")
    private BigDecimal weight;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "最高学历")
    private String educationLevel;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

}