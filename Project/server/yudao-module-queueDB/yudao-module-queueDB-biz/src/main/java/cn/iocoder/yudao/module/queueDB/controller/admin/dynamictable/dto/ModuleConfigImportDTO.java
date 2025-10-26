package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ModuleConfigImportDTO {
    /**
     * 模块编码
     */
    private String moduleCode;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 模块类型
     */
    private String moduleType = "survey";

    /**
     * 分组类型
     */
    private String groupType = "general";

    /**
     * 备注
     */
    private String remark;

    /**
     * 表名（自动生成）
     */
    private String tableName;

    public ModuleConfigImportDTO() {}

    public ModuleConfigImportDTO(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.tableName = "dyn_" + moduleCode;
    }
}
