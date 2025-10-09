package cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 基础其他信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BasicOtherInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19812")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19096")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "生育情况", example = "2")
    @ExcelProperty("生育情况")
    private String fertilityStatus;

    @Schema(description = "年龄")
    @ExcelProperty("年龄")
    private Integer age;

    @Schema(description = "退役体重")
    @ExcelProperty("退役体重")
    private BigDecimal retiredWeight;

    @Schema(description = "体检日期", example = "2")
    private Date medicalCheckDate;

    @Schema(description = "联系电话", example = "2")
    private String contactPhone;

}