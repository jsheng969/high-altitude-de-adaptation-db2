package cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 动态表注册分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RegistryPageReqVO extends PageParam {

    @Schema(description = "动态表名", example = "王五")
    private String tableName;

    @Schema(description = "模块编码")
    private String moduleCode;

    @Schema(description = "数据节点类型", example = "1")
    private String nodeType;

    @Schema(description = "状态：0=未创建，1=已创建，2=已删除", example = "2")
    private Integer status;

    @Schema(description = "字段数量", example = "2929")
    private Integer fieldCount;

    @Schema(description = "描述信息", example = "随便")
    private String description;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}