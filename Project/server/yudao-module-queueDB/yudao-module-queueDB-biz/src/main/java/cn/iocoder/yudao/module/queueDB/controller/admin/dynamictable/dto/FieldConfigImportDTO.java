package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class FieldConfigImportDTO {
    /**
     * 字段标识（数据库列名）
     */
    private String fieldCode;

    /**
     * 字段显示名
     */
    private String fieldLabel;

    /**
     * 字段类型
     */
    private String fieldType = "input";

    /**
     * 数据库类型
     */
    private String dataType;

    /**
     * 字段长度
     */
    private Integer fieldLength;

    /**
     * 是否必填
     */
    private Integer isRequired = 0;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 是否默认显示
     */
    private Integer isDefault = 1;

    /**
     * 字段分组编码
     */
    private String fieldGroup;

    /**
     * 字段分组名称
     */
    private String fieldGroupName;

    /**
     * 选项配置JSON
     */
    private String optionsJson;

    /**
     * 列索引
     */
    private Integer columnIndex;

    /**
     * 排序号
     */
    private Integer orderNo;

    /**
     * 状态（1启用）
     */
    private Integer status = 1;

    /**
     * 设置数据类型（根据字段类型智能设置）
     */
    public void setDataTypeFromFieldType() {
        if (StringUtils.isNotBlank(this.dataType)) {
            return;
        }

        switch (this.fieldType) {
            case "input":
            case "select":
            case "checkbox":
                this.dataType = "VARCHAR(255)";
                this.fieldLength = 255;
                break;
            case "textarea":
            case "richtext":
                this.dataType = "TEXT";
                break;
            case "number":
            case "integer":
                this.dataType = "INT";
                break;
            case "bigint":
                this.dataType = "BIGINT";
                break;
            case "decimal":
            case "float":
                this.dataType = "DECIMAL(10,2)";
                break;
            case "date":
                this.dataType = "DATE";
                break;
            case "datetime":
                this.dataType = "DATETIME";
                break;
            case "boolean":
            case "switch":
                this.dataType = "TINYINT(1)";
                break;
            case "json":
                this.dataType = "JSON";
                break;
            default:
                this.dataType = "VARCHAR(255)";
                this.fieldLength = 255;
        }
    }

    /**
     * 根据数据库类型推断字段类型
     */
    public void setFieldTypeFromDataType() {
        if (StringUtils.isBlank(this.dataType)) {
            return;
        }

        String lowerDataType = this.dataType.toLowerCase();
        if (lowerDataType.contains("int") || lowerDataType.contains("number")) {
            this.fieldType = "number";
        } else if (lowerDataType.contains("decimal") || lowerDataType.contains("float") || lowerDataType.contains("double")) {
            this.fieldType = "decimal";
        } else if (lowerDataType.contains("date")) {
            this.fieldType = "date";
        } else if (lowerDataType.contains("datetime") || lowerDataType.contains("timestamp")) {
            this.fieldType = "datetime";
        } else if (lowerDataType.contains("text")) {
            this.fieldType = "textarea";
        } else if (lowerDataType.contains("boolean") || lowerDataType.contains("tinyint")) {
            this.fieldType = "boolean";
        } else {
            this.fieldType = "input";
        }
    }

    /**
     * 验证字段配置是否有效
     */
    public boolean isValid() {
        return StringUtils.isNotBlank(fieldCode) &&
                StringUtils.isNotBlank(fieldLabel) &&
                StringUtils.isNotBlank(fieldType);
    }

    /**
     * 获取完整的字段信息（用于日志和调试）
     */
    public String getFieldInfo() {
        return String.format("Field[code=%s, label=%s, type=%s, group=%s]",
                fieldCode, fieldLabel, fieldType, fieldGroup);
    }
}