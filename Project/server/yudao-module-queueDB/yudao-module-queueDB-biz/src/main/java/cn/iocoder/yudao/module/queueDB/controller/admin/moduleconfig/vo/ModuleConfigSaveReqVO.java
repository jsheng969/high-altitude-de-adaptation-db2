package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 动态模块配置表（支持三级结构）新增/修改 Request VO")
@Data
public class ModuleConfigSaveReqVO {

    @Schema(description = "模块ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "26005")
    private Long id;

    @Schema(description = "父模块ID（支持三级）", example = "7169")
    private Long parentId;

    @Schema(description = "模块唯一标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "模块唯一标识不能为空")
    private String moduleCode;

    @Schema(description = "模块名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "模块名称不能为空")
    private String moduleName;

    @Schema(description = "若为叶子节点，对应表名", example = "王五")
    private String tableName;

    @Schema(description = "模块层级（1=一级,2=二级,3=三级）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "模块层级（1=一级,2=二级,3=三级）不能为空")
    private Integer moduleLevel;

    @Schema(description = "模块归属类型（experiment/control）", example = "1")
    private String groupType;

    @Schema(description = "survey/exam等", example = "2")
    private String moduleType;

    @Schema(description = "是否叶子模块（1=建表）")
    private Integer isLeaf;

    @Schema(description = "排序号")
    private Integer orderNo;

    @Schema(description = "状态（1启用，0停用）", example = "1")
    private Integer status;
    private String remark;
}