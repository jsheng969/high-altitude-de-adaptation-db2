package cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;


@Schema(description = "管理后台 - 实验组体检-腹部超声新增/修改 Request VO")
@Data
public class ExperimentExamAbdominalUltrasoundSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8132")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24453")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "随便")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    private String ultrasoundSummary;

}