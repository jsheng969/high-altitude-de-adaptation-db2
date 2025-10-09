package cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组体检-腹部超声分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamAbdominalUltrasoundPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "24453")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "随便")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    private String ultrasoundSummary;

}