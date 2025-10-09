package cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-腹部超声 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamAbdominalUltrasoundRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8132")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24453")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "随便")
    @ExcelProperty("腹部超声-描述")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    @ExcelProperty("腹部超声-小结")
    private String ultrasoundSummary;

}