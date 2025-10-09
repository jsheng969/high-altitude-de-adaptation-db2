package cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 动态字段配置 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FieldConfigRespVO {

    @Schema(description = "字段ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16969")
    @ExcelProperty("字段ID")
    private Long id;

    @Schema(description = "所属模块code（对应module_config.module_code）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("所属模块code（对应module_config.module_code）")
    private String moduleCode;

    @Schema(description = "字段标识（用于数据库列名）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("字段标识（用于数据库列名）")
    private String fieldCode;

    @Schema(description = "字段显示名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("字段显示名")
    private String fieldLabel;

    @Schema(description = "字段类型（input/select/number/date/checkbox等）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("字段类型（input/select/number/date/checkbox等）")
    private String fieldType;

    @Schema(description = "数据库字段类型", example = "2")
    @ExcelProperty("数据库字段类型")
    private String dataType;

    @Schema(description = "选项配置（如下拉选项等）")
    @ExcelProperty("选项配置（如下拉选项等）")
    private String optionsJson;

    @Schema(description = "是否必填")
    @ExcelProperty("是否必填")
    private Integer isRequired;

    @Schema(description = "排序号")
    @ExcelProperty("排序号")
    private Integer orderNo;

    @Schema(description = "状态（1启用）", example = "1")
    @ExcelProperty("状态（1启用）")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
    private Integer fieldLength; // 对应 VARCHAR 长度等
    private String fieldName; // 对应数据库列名
}