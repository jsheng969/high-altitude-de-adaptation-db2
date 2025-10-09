package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 动态模块配置表（支持三级结构）分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ModuleConfigPageReqVO extends PageParam {

    @Schema(description = "父模块ID（支持三级）", example = "7169")
    private Long parentId;

    @Schema(description = "模块唯一标识")
    private String moduleCode;

    @Schema(description = "模块名称", example = "芋艿")
    private String moduleName;

    @Schema(description = "若为叶子节点，对应表名", example = "王五")
    private String tableName;

    @Schema(description = "模块层级（1=一级,2=二级,3=三级）")
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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
    private String remark;
}