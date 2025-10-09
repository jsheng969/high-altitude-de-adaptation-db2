package cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组体检-既往病史新增/修改 Request VO")
@Data
public class ControlExamPastMedicalHistorySaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15042")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24686")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "内科既往病史")
    private String internalDiseaseHistory;

    @Schema(description = "外科既往病史")
    private String externalDiseaseHistory;

}