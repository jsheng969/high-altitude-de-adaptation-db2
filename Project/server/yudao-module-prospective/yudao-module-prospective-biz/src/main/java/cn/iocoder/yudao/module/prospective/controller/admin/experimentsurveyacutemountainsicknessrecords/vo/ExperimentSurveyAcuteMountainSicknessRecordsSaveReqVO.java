package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 高原急性高山病记录新增/修改 Request VO")
@Data
public class ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "8643")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16475")
    @NotNull(message = "基础信息id不能为空")
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

    @Schema(description = "时相")
    private Integer timePoint;

}