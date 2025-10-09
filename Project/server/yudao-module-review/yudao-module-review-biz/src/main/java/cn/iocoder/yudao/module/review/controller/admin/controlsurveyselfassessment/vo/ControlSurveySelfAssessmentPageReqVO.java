package cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 对照组流调-自我评价分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveySelfAssessmentPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "23661")
    private Long personId;

    @Schema(description = "每年体检/就诊次数")
    private String annualCheckups;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    private String healthComparison;

    @Schema(description = "您认为自己身体健康状况能得________分")
    private Integer healthScore;

}