package cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 对照组流调-自我评价新增/修改 Request VO")
@Data
public class ControlSurveySelfAssessmentSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22111")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23661")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "每年体检/就诊次数")
    private String annualCheckups;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    private String healthComparison;

    @Schema(description = "您认为自己身体健康状况能得________分")
    private Integer healthScore;

}