package cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 动态字段配置新增/修改 Request VO")
@Data
public class FieldConfigSaveReqVO {

    @Schema(description = "字段ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16969")
    private Long id;

    @Schema(description = "所属模块code（对应module_config.module_code）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "所属模块code（对应module_config.module_code）不能为空")
    private String moduleCode;

    @Schema(description = "字段标识（用于数据库列名）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "字段标识（用于数据库列名）不能为空")
    private String fieldCode;

    @Schema(description = "字段显示名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "字段显示名不能为空")
    private String fieldLabel;

    @Schema(description = "字段类型（input/select/number/date/checkbox等）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "字段类型（input/select/number/date/checkbox等）不能为空")
    private String fieldType;

    @Schema(description = "数据库字段类型", example = "2")
    private String dataType;

    @Schema(description = "选项配置（如下拉选项等）")
    private String optionsJson;

    @Schema(description = "是否必填")
    private Integer isRequired;

    @Schema(description = "排序号")
    private Integer orderNo;

    @Schema(description = "状态（1启用）", example = "1")
    private Integer status;
    private Integer fieldLength; // 对应 VARCHAR 长度等
    @Schema(description = "是否默认显示", example = "1")
    private Integer isDefault;
    @Schema(description = "是否默认显示")
    private Integer displayOrder;

    @Schema(description = "模块类型", required = true, example = "baseline")
    private String moduleType;

}