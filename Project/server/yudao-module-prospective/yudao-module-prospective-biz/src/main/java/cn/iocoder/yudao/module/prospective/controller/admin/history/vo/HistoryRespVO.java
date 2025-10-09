package cn.iocoder.yudao.module.prospective.controller.admin.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 预警历史记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class HistoryRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11612")
    @ExcelProperty("id")
    private Integer id;

    @Schema(description = "参数")
    @ExcelProperty("参数")
    private String parm;

    @Schema(description = "得分")
    @ExcelProperty("得分")
    private String socre;

    private LocalDateTime createTime;

}