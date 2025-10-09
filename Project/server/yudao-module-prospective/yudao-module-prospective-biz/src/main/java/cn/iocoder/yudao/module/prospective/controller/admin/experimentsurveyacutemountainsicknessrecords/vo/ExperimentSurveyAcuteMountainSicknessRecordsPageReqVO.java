package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 高原急性高山病记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "16475")
    private Long personId;

    @Schema(description = "急性高原反应")
    private Boolean acuteMountainReaction;

    @Schema(description = "肺水肿")
    private Boolean pulmonaryEdema;

    @Schema(description = "脑水肿")
    private Boolean cerebralEdema;

    @Schema(description = "高原心脏病")
    private Boolean highAltitudeHeartDisease;

    @Schema(description = "高原红细胞增多症")
    private Boolean polycythemia;

    @Schema(description = "高原期间有无发生以下疾病")
    private String otherDiseases;

    @Schema(description = "其他疾病描述")
    private String otherDiseasesDesc;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;

}