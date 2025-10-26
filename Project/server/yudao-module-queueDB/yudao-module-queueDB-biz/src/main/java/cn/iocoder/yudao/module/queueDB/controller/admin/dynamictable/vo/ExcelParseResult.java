package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.FieldConfigImportDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.ModuleConfigImportDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExcelParseResult {
    /**
     * 模块配置信息
     */
    private ModuleConfigImportDTO moduleConfig;

    /**
     * 字段配置列表
     */
    private List<FieldConfigImportDTO> fieldConfigs;

    /**
     * 数据行列表
     */
    private List<ExcelDataRow> dataRows;

    /**
     * 解析错误信息
     */
    private List<String> parseErrors;

    /**
     * 解析的配置模式
     */
    private String configMode;

    /**
     * 总行数
     */
    private Integer totalRows;

    /**
     * 总列数
     */
    private Integer totalColumns;

    public ExcelParseResult() {
        this.fieldConfigs = new ArrayList<>();
        this.dataRows = new ArrayList<>();
        this.parseErrors = new ArrayList<>();
    }

    /**
     * 添加解析错误
     */
    public void addError(String error) {
        this.parseErrors.add(error);
    }

    /**
     * 是否有错误
     */
    public boolean hasErrors() {
        return !this.parseErrors.isEmpty();
    }

    /**
     * 是否解析成功
     */
    public boolean isSuccess() {
        return this.parseErrors.isEmpty() && this.moduleConfig != null && !this.fieldConfigs.isEmpty();
    }
}
