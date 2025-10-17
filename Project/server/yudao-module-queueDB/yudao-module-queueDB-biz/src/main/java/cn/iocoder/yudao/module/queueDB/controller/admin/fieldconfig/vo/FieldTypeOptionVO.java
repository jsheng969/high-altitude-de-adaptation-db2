package cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FieldTypeOptionVO {
    @Schema(description = "字段类型值", requiredMode = Schema.RequiredMode.REQUIRED, example = "input")
    private String value;

    @Schema(description = "字段类型显示名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "单行文本")
    private String label;

    @Schema(description = "对应的数据库类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "VARCHAR(255)")
    private String dataType;

    @Schema(description = "字段类型描述", example = "用于输入单行文本内容")
    private String description;

    public FieldTypeOptionVO() {
    }

    public FieldTypeOptionVO(String value, String label, String dataType) {
        this.value = value;
        this.label = label;
        this.dataType = dataType;
    }

    public FieldTypeOptionVO(String value, String label, String dataType, String description) {
        this.value = value;
        this.label = label;
        this.dataType = dataType;
        this.description = description;
    }
}
