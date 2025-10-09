package cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组体检-心电图分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentExamEcgPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "4243")
    private Long personId;

    @Schema(description = "心电图", example = "你说的对")
    private String ecgDescription;

}