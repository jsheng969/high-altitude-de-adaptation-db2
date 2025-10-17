package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ModuleConfigTreeVO {
    @Schema(description = "模块ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "父模块ID", example = "0")
    private Long parentId;

    @Schema(description = "模块代码", requiredMode = Schema.RequiredMode.REQUIRED, example = "base_info")
    private String moduleCode;

    @Schema(description = "模块名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "基础信息")
    private String moduleName;

    @Schema(description = "模块层级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer moduleLevel;

    @Schema(description = "分组类型", example = "base")
    private String groupType;

    @Schema(description = "模块类型", example = "survey")
    private String moduleType;

    @Schema(description = "是否叶子节点", example = "1")
    private Integer isLeaf;

    @Schema(description = "排序号", example = "0")
    private Integer orderNo;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "字段数量", example = "10")
    private Long fieldCount;

    @Schema(description = "子模块列表")
    private List<ModuleConfigTreeVO> children;

}
