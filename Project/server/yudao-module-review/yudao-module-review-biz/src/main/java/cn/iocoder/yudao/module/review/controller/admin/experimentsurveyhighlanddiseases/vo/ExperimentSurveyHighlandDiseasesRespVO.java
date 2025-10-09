package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-高原疾病诊断 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyHighlandDiseasesRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30251")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "26801")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "急性高原反应")
    @ExcelProperty("急性高原反应")
    private Boolean acuteHighlandReaction;

    @Schema(description = "高原肺水肿")
    @ExcelProperty("高原肺水肿")
    private Boolean highlandPulmonaryEdema;

    @Schema(description = "高原脑水肿")
    @ExcelProperty("高原脑水肿")
    private Boolean highlandCerebralEdema;

    @Schema(description = "高原心脏病")
    @ExcelProperty("高原心脏病")
    private Boolean highlandHeartDisease;

    @Schema(description = "高原红细胞增多症")
    @ExcelProperty("高原红细胞增多症")
    private Boolean highlandPolycythemia;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private Boolean otherDiseases;

}