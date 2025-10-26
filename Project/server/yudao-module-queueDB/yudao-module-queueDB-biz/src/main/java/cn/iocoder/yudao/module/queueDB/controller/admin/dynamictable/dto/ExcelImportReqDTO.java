package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class ExcelImportReqDTO {
    /**
     * Excel文件
     */
    @NotNull(message = "文件不能为空")
    private MultipartFile file;

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
     * 模块编码（如果为空则从文件名生成）
     */
    private String moduleCode;

    /**
     * 模块名称（如果为空则从文件名生成）
     */
    private String moduleName;

    /**
     * 配置模式：simple（简单模式）/full（完整模式）/auto（自动检测）
     */
    private String configMode = "auto";

    /**
     * 是否导入数据
     */
    private Boolean importData = true;

    /**
     * 是否覆盖已存在的模块
     */
    private Boolean overwrite = false;

    /**
     * 数据起始行（0-based）
     */
    private Integer dataStartRow;

    /**
     * 表头行数
     */
    private Integer headerRows;
}
