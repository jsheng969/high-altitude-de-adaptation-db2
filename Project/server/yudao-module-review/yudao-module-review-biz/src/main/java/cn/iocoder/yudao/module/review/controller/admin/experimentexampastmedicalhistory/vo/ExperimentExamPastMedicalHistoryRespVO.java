package cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-既往病史 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamPastMedicalHistoryRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32090")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6875")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "内科既往病史")
    @ExcelProperty("内科既往病史")
    private String internalDiseaseHistory;

    @Schema(description = "外科既往病史")
    @ExcelProperty("外科既往病史")
    private String externalDiseaseHistory;

}