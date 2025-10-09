package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 高原急性高山病记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyAcuteMountainSicknessRecordsRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "8643")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16475")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "急性高原反应")
    @ExcelProperty("急性高原反应")
    private Boolean acuteMountainReaction;

    @Schema(description = "肺水肿")
    @ExcelProperty("肺水肿")
    private Boolean pulmonaryEdema;

    @Schema(description = "脑水肿")
    @ExcelProperty("脑水肿")
    private Boolean cerebralEdema;

    @Schema(description = "高原心脏病")
    @ExcelProperty("高原心脏病")
    private Boolean highAltitudeHeartDisease;

    @Schema(description = "高原红细胞增多症")
    @ExcelProperty("高原红细胞增多症")
    private Boolean polycythemia;

    @Schema(description = "高原期间有无发生以下疾病")
    @ExcelProperty("高原期间有无发生以下疾病")
    private String otherDiseases;

    @Schema(description = "其他疾病描述")
    @ExcelProperty("其他疾病描述")
    private String otherDiseasesDesc;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

}