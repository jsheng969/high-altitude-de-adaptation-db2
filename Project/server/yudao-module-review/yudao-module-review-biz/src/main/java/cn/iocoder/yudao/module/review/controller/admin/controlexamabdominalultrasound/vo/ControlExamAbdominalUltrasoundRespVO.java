package cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组体检-腹部超声 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlExamAbdominalUltrasoundRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15005")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19067")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "腹部超声-描述", example = "你猜")
    @ExcelProperty("腹部超声-描述")
    private String ultrasoundDescription;

    @Schema(description = "腹部超声-小结")
    @ExcelProperty("腹部超声-小结")
    private String ultrasoundSummary;

}