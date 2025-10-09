package cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 生物样本库历史记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SampleHistoryRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15084")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "样品id", example = "17021")
    @ExcelProperty("样品id")
    private Long bioSampleId;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String creator;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String createBy;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "行为")
    @ExcelProperty("行为")
    private String action;

    private String tubeNo;

    private String boxNo;

    private String freezerNo;

}