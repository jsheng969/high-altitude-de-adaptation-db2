package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.FieldConfigRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 动态模块配置表（支持三级结构） Response VO")
@Data
@ExcelIgnoreUnannotated
public class ModuleConfigRespVO {

    @Schema(description = "模块ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "26005")
    @ExcelProperty("模块ID")
    private Long id;

    @Schema(description = "父模块ID（支持三级）", example = "7169")
    @ExcelProperty("父模块ID（支持三级）")
    private Long parentId;

    @Schema(description = "模块唯一标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模块唯一标识")
    private String moduleCode;

    @Schema(description = "模块名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("模块名称")
    private String moduleName;

    @Schema(description = "若为叶子节点，对应表名", example = "王五")
    @ExcelProperty("若为叶子节点，对应表名")
    private String tableName;

    @Schema(description = "模块层级（1=一级,2=二级,3=三级）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模块层级（1=一级,2=二级,3=三级）")
    private Integer moduleLevel;

    @Schema(description = "模块归属类型（experiment/control）", example = "1")
    @ExcelProperty("模块归属类型（experiment/control）")
    private String groupType;

    @Schema(description = "survey/exam等", example = "2")
    @ExcelProperty("survey/exam等")
    private String moduleType;

    @Schema(description = "是否叶子模块（1=建表）")
    @ExcelProperty("是否叶子模块（1=建表）")
    private Integer isLeaf;

    @Schema(description = "排序号")
    @ExcelProperty("排序号")
    private Integer orderNo;

    @Schema(description = "状态（1启用，0停用）", example = "1")
    @ExcelProperty("状态（1启用，0停用）")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
    private String remark;

    /**
     * 子模块列表
     */
    private List<ModuleConfigRespVO> children;

    /**
     * 字段列表
     */
    private List<FieldConfigRespVO> fields;
}