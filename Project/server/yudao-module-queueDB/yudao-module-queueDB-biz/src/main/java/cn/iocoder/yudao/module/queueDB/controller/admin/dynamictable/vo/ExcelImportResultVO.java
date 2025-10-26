package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ExcelImportResultVO {
    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 结果消息
     */
    private String message;

    /**
     * 模块编码
     */
    private String moduleCode;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 总字段数
     */
    private Integer totalFields;

    /**
     * 成功字段数
     */
    private Integer successFields;

    /**
     * 总数据记录数
     */
    private Integer totalRecords;

    /**
     * 成功数据记录数
     */
    private Integer successRecords;

    /**
     * 错误信息列表
     */
    private List<String> errorMessages;

    /**
     * 导入耗时（毫秒）
     */
    private Long costTime;

    /**
     * 解析的配置模式
     */
    private String configMode;

    /**
     * 导入时间
     */
    private Date importTime;

    /**
     * 文件名称
     */
    private String fileName;

    public ExcelImportResultVO() {
        this.errorMessages = new ArrayList<>();
        this.importTime = new Date();
    }

    /**
     * 添加错误信息
     */
    public void addError(String error) {
        this.errorMessages.add(error);
    }

    /**
     * 是否有错误
     */
    public boolean hasErrors() {
        return !this.errorMessages.isEmpty();
    }

    /**
     * 获取成功消息
     */
    public String getSuccessMessage() {
        if (!success) {
            return message;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("导入成功！");
        sb.append("模块：").append(moduleCode);
        sb.append("，字段：").append(successFields).append("/").append(totalFields);

        if (totalRecords != null && totalRecords > 0) {
            sb.append("，数据：").append(successRecords).append("/").append(totalRecords);
        }

        if (costTime != null) {
            sb.append("，耗时：").append(costTime).append("ms");
        }

        return sb.toString();
    }
}
