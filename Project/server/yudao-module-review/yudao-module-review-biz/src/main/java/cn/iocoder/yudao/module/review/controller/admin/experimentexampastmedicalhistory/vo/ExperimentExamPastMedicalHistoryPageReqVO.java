package cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组体检-既往病史分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamPastMedicalHistoryPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "6875")
    private Long personId;

    @Schema(description = "内科既往病史")
    private String internalDiseaseHistory;

    @Schema(description = "外科既往病史")
    private String externalDiseaseHistory;

}