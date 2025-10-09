package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-自我评价 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveySelfAssessmentRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "20090")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8094")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "与同龄人相比，您认为目前自己的身体健康状况如何")
    @ExcelProperty(value = {"自我评价", "与同龄人相比，您认为目前自己的身体健康状况如何"})
    private String healthComparisonWithPeers;

    @Schema(description = "您认为自己身体健康状况能得的分数")
    @ExcelProperty(value = {"自我评价", "您认为自己身体健康状况能得的分数"})
    private String healthScore;

}