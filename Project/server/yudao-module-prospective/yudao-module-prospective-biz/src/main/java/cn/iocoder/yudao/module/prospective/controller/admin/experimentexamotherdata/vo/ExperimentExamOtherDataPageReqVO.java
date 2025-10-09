package cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组体检-其他数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamOtherDataPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "458")
    private Long personId;

    @Schema(description = "心肌肌钙蛋白I")
    private String cardiacTroponinI;

    @Schema(description = "血管超声结果")
    private String vascularUltrasoundResult;

    @Schema(description = "心电图分析结果")
    private String ecgAnalysisResult;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

}