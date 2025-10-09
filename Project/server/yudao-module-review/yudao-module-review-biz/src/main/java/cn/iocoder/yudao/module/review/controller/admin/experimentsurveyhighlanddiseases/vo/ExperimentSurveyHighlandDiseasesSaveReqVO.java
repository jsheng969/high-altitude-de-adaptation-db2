package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-高原疾病诊断新增/修改 Request VO")
@Data
public class ExperimentSurveyHighlandDiseasesSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30251")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "26801")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "急性高原反应")
    private Boolean acuteHighlandReaction;

    @Schema(description = "高原肺水肿")
    private Boolean highlandPulmonaryEdema;

    @Schema(description = "高原脑水肿")
    private Boolean highlandCerebralEdema;

    @Schema(description = "高原心脏病")
    private Boolean highlandHeartDisease;

    @Schema(description = "高原红细胞增多症")
    private Boolean highlandPolycythemia;

    @Schema(description = "其他")
    private Boolean otherDiseases;

}