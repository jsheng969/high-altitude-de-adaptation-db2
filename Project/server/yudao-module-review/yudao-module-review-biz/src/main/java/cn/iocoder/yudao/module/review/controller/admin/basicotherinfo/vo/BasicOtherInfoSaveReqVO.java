package cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 基础其他信息新增/修改 Request VO")
@Data
public class BasicOtherInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19812")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19096")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "生育情况", example = "2")
    private String fertilityStatus;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "退役体重")
    private BigDecimal retiredWeight;

    @Schema(description = "体检日期", example = "2")
    private Date medicalCheckDate;

    @Schema(description = "联系电话", example = "2")
    private String contactPhone;

}