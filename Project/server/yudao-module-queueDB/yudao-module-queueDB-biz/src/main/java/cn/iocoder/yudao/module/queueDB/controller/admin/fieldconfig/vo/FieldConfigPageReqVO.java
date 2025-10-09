package cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 动态字段配置分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FieldConfigPageReqVO extends PageParam {

    @Schema(description = "所属模块code（对应module_config.module_code）")
    private String moduleCode;

    @Schema(description = "字段标识（用于数据库列名）")
    private String fieldCode;

    @Schema(description = "字段显示名")
    private String fieldLabel;

    @Schema(description = "字段类型（input/select/number/date/checkbox等）", example = "1")
    private String fieldType;

    @Schema(description = "数据库字段类型", example = "2")
    private String dataType;

    @Schema(description = "选项配置（如下拉选项等）")
    private String optionsJson;

    @Schema(description = "是否必填")
    private Integer isRequired;

    @Schema(description = "排序号")
    private Integer orderNo;

    @Schema(description = "状态（1启用）", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
    private Integer fieldLength; // 对应 VARCHAR 长度等
    private String fieldName; // 对应数据库列名
}