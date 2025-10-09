package cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-心电图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamEcgRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6436")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4243")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "心电图", example = "你说的对")
    @ExcelProperty("心电图")
    private String ecgDescription;

}