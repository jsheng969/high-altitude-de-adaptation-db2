package cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组体检-心电图新增/修改 Request VO")
@Data
public class ControlExamEcgSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25609")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30170")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "心电图", example = "随便")
    private String ecgDescription;

}