package cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 对照组体检-心电图分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlExamEcgPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "30170")
    private Long personId;

    @Schema(description = "心电图", example = "随便")
    private String ecgDescription;

}