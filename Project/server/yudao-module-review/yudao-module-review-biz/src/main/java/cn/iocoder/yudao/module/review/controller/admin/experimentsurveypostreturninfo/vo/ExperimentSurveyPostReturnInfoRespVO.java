package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-返回后基础信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyPostReturnInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13186")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16766")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "成都")
    @ExcelProperty("成都")
    private Integer chengdu;

    @Schema(description = "成都居住时间（年）")
    @ExcelProperty("成都居住时间（年）")
    private Integer chengduResidenceTime;

    @Schema(description = "昆明")
    @ExcelProperty("昆明")
    private Integer kunming;

    @Schema(description = "昆明居住时间（年）")
    @ExcelProperty("昆明居住时间（年）")
    private Integer kunmingResidenceTime;

    @Schema(description = "西宁")
    @ExcelProperty("西宁")
    private Integer xining;

    @Schema(description = "西宁居住时间（年）")
    @ExcelProperty("西宁居住时间（年）")
    private Integer xiningResidenceTime;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private String otherArea;

    @Schema(description = "其他居住时间（年）")
    @ExcelProperty("其他居住时间（年）")
    private String otherAreaResidenceTime;

    @Schema(description = "从高原返回后的工作情况", example = "1")
    @ExcelProperty("从高原返回后的工作情况")
    private String postReturnWorkStatus;

    @Schema(description = "每年体检/就诊次数")
    @ExcelProperty("每年体检/就诊次数")
    private String annualCheckups;

}