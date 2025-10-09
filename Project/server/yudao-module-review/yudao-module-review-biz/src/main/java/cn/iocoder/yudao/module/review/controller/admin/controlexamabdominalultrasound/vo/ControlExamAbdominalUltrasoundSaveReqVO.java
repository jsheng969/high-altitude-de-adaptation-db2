package cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组体检-腹部超声新增/修改 Request VO")
@Data
public class ControlExamAbdominalUltrasoundSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15005")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19067")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "你猜")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    private String ultrasoundSummary;

}