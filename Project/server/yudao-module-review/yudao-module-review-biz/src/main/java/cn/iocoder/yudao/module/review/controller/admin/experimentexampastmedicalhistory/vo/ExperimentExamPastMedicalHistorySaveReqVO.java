package cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;


@Schema(description = "管理后台 - 实验组体检-既往病史新增/修改 Request VO")
@Data
public class ExperimentExamPastMedicalHistorySaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32090")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6875")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "内科既往病史")
    private String internalDiseaseHistory;

    @Schema(description = "外科既往病史")
    private String externalDiseaseHistory;

}