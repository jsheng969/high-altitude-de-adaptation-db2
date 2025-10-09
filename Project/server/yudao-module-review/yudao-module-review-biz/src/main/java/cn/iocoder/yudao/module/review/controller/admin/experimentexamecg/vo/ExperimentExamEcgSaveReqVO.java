package cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;


@Schema(description = "管理后台 - 实验组体检-心电图新增/修改 Request VO")
@Data
public class ExperimentExamEcgSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6436")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4243")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "心电图", example = "你说的对")
    private String ecgDescription;

}