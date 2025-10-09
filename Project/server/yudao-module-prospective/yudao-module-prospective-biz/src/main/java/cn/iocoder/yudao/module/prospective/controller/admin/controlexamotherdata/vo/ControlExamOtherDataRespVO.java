package cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-其他数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlExamOtherDataRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28177")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24199")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "心肌肌钙蛋白I")
    @ExcelProperty("心肌肌钙蛋白I")
    private String cardiacTroponinI;

    @Schema(description = "血管超声结果")
    @ExcelProperty("血管超声结果")
    private String vascularUltrasoundResult;

    @Schema(description = "心电图分析结果")
    @ExcelProperty("心电图分析结果")
    private String ecgAnalysisResult;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

    @Schema(description = "ATNI-H")
    @ExcelProperty("ATNI-H")
    private BigDecimal atniH;

    @Schema(description = "MYOG")
    @ExcelProperty("MYOG")
    private BigDecimal myog;

    @Schema(description = "CK-MBG")
    @ExcelProperty("CK-MBG")
    private BigDecimal ckMbg;

}