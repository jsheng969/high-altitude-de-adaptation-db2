package cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组体检-心电图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlExamEcgRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25609")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30170")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "心电图", example = "随便")
    @ExcelProperty("心电图")
    private String ecgDescription;

}