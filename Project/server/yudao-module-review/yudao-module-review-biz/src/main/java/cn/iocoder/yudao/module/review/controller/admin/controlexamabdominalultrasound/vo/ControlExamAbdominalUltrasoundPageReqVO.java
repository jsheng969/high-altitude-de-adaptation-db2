package cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 对照组体检-腹部超声分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlExamAbdominalUltrasoundPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "19067")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "你猜")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    private String ultrasoundSummary;

}