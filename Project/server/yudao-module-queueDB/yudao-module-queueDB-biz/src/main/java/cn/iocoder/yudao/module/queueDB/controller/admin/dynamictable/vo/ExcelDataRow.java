package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class ExcelDataRow {
    /**
     * 行数据（字段编码 -> 值）
     */
    private Map<String, Object> data = new HashMap<>();

    /**
     * 行索引（从0开始）
     */
    private int rowIndex;

    /**
     * Excel中的行号（从1开始）
     */
    private int excelRowNumber;

    /**
     * 是否有效行
     */
    private boolean valid = true;

    /**
     * 行错误信息
     */
    private String errorMessage;

    public ExcelDataRow() {}

    public ExcelDataRow(int rowIndex) {
        this.rowIndex = rowIndex;
        this.excelRowNumber = rowIndex + 1;
    }

    /**
     * 设置字段值
     */
    public void put(String fieldCode, Object value) {
        this.data.put(fieldCode, value);
    }

    /**
     * 获取字段值
     */
    public Object get(String fieldCode) {
        return this.data.get(fieldCode);
    }

    /**
     * 获取字符串值
     */
    public String getString(String fieldCode) {
        Object value = this.data.get(fieldCode);
        return value != null ? value.toString() : null;
    }

    /**
     * 获取整数值
     */
    public Integer getInteger(String fieldCode) {
        Object value = this.data.get(fieldCode);
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 检查是否为空行
     */
    public boolean isEmpty() {
        return this.data.values().stream().allMatch(value ->
                value == null ||
                        (value instanceof String && StringUtils.isBlank((String) value))
        );
    }

    /**
     * 标记为无效行
     */
    public void markInvalid(String errorMessage) {
        this.valid = false;
        this.errorMessage = errorMessage;
    }
}
