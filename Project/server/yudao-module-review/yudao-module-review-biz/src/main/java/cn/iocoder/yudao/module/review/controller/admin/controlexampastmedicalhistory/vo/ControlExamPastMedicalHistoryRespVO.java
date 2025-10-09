package cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组体检-既往病史 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlExamPastMedicalHistoryRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15042")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24686")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "内科既往病史")
    @ExcelProperty("内科既往病史")
    private String internalDiseaseHistory;

    @Schema(description = "外科既往病史")
    @ExcelProperty("外科既往病史")
    private String externalDiseaseHistory;

}