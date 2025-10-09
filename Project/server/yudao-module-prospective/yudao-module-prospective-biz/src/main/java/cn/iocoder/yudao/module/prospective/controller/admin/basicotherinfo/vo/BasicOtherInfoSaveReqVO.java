package cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 基础其他信息新增/修改 Request VO")
@Data
public class BasicOtherInfoSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "15588")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13573")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "婚姻状况", example = "2")
    private String maritalStatus;

    @Schema(description = "生育情况", example = "1")
    private String fertilityStatus;

    @Schema(description = "身高")
    private BigDecimal height;

    @Schema(description = "体重")
    private BigDecimal weight;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "最高学历")
    private String educationLevel;

    @Schema(description = "时相")
    private Integer timePoint;

}