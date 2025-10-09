package cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 基础其他信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BasicOtherInfoRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "15588")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13573")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "婚姻状况", example = "2")
    @ExcelProperty("婚姻状况")
    private String maritalStatus;

    @Schema(description = "生育情况", example = "1")
    @ExcelProperty("生育情况")
    private String fertilityStatus;

    @Schema(description = "身高")
    private BigDecimal height;

    @Schema(description = "体重")
    private BigDecimal weight;

    @Schema(description = "民族")
    @ExcelProperty("民族")
    private String ethnicity;

    @Schema(description = "最高学历")
    @ExcelProperty("最高学历")
    private String educationLevel;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

}