package cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 基础信息新增/修改 Request VO")
@Data
public class BasicInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17342")
    private Long id;

    @Schema(description = "姓名", example = "李四")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "最高学历")
    private String highestEducation;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "婚姻情况", example = "1")
    private String maritalStatus;

    @Schema(description = "身高")
    private BigDecimal height;

    @Schema(description = "体重")
    private BigDecimal weight;

    @Schema(description = "类型（1.实验组，2.流调组）")
    private Integer type;

}