package cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-新发的疾病 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyNewDiseasesRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "10079")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27063")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "新发疾病 1 名称", example = "芋艿")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "疾病名称"})
    private String newDisease1Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "该病是否在二级或二级以上医院被诊断"})
    private Boolean diagnosed;

    @Schema(description = "该病的诊断时间")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "诊断时间"})
    private String diagnosisDate;

    @Schema(description = "是否因该病住院治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "是否住院"})
    private Boolean hospitalized;

    @Schema(description = "是否使用药物进行治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "是否药物治疗"})
    private Boolean medication;

    @Schema(description = "药物，治疗效果")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病1", "药物治疗效果"})
    private String medicationEffect;

    @Schema(description = "新发疾病 2 名称", example = "王五")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "疾病名称"})
    private String newDisease2Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "该病是否在二级或二级以上医院被诊断"})
    private Boolean diagnosed2;

    @Schema(description = "该病的诊断时间")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "诊断时间"})
    private String diagnosisDate2;

    @Schema(description = "是否因该病住院治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "是否住院"})
    private Boolean hospitalized2;

    @Schema(description = "是否使用药物进行治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "是否药物治疗"})
    private Boolean medication2;

    @Schema(description = "药物，治疗效果")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病2", "药物治疗效果"})
    private String medicationEffect2;

    @Schema(description = "新发疾病 3 名称", example = "芋艿")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "疾病名称"})
    private String newDisease3Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "该病是否在二级或二级以上医院被诊断"})
    private Boolean diagnosed3;

    @Schema(description = "该病的诊断时间")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "诊断时间"})
    private String diagnosisDate3;

    @Schema(description = "是否因该病住院治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "是否住院"})
    private Boolean hospitalized3;

    @Schema(description = "是否使用药物进行治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "是否药物治疗"})
    private Boolean medication3;

    @Schema(description = "药物，治疗效果")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病3", "药物治疗效果"})
    private String medicationEffect3;

    @Schema(description = "新发疾病 4 名称", example = "王五")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "疾病名称"})
    private String newDisease4Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "该病是否在二级或二级以上医院被诊断"})
    private Boolean diagnosed4;

    @Schema(description = "该病的诊断时间")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "诊断时间"})
    private String diagnosisDate4;

    @Schema(description = "是否因该病住院治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "是否住院"})
    private Boolean hospitalized4;

    @Schema(description = "是否使用药物进行治疗")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "是否药物治疗"})
    private Boolean medication4;

    @Schema(description = "药物，治疗效果")
    @ExcelProperty(value = {"高原返回平原后基本信息", "新发疾病4", "药物治疗效果"})
    private String medicationEffect4;

}