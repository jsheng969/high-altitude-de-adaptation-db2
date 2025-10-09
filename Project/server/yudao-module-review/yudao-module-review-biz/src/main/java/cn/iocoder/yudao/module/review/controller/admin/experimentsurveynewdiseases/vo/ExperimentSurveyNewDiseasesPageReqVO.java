package cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组流调-新发的疾病分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyNewDiseasesPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "27063")
    private Long personId;

    @Schema(description = "新发疾病 1 名称", example = "芋艿")
    private String newDisease1Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    private Boolean diagnosed;

    @Schema(description = "该病的诊断时间")
    private String diagnosisDate;

    @Schema(description = "是否因该病住院治疗")
    private Boolean hospitalized;

    @Schema(description = "是否使用药物进行治疗")
    private Boolean medication;

    @Schema(description = "药物，治疗效果")
    private String medicationEffect;

    @Schema(description = "新发疾病 2 名称", example = "王五")
    private String newDisease2Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    private Boolean diagnosed2;

    @Schema(description = "该病的诊断时间")
    private String diagnosisDate2;

    @Schema(description = "是否因该病住院治疗")
    private Boolean hospitalized2;

    @Schema(description = "是否使用药物进行治疗")
    private Boolean medication2;

    @Schema(description = "药物，治疗效果")
    private String medicationEffect2;

    @Schema(description = "新发疾病 3 名称", example = "芋艿")
    private String newDisease3Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    private Boolean diagnosed3;

    @Schema(description = "该病的诊断时间")
    private String diagnosisDate3;

    @Schema(description = "是否因该病住院治疗")
    private Boolean hospitalized3;

    @Schema(description = "是否使用药物进行治疗")
    private Boolean medication3;

    @Schema(description = "药物，治疗效果")
    private String medicationEffect3;

    @Schema(description = "新发疾病 4 名称", example = "王五")
    private String newDisease4Name;

    @Schema(description = "该病是否在二级或二级以上医院被诊断")
    private Boolean diagnosed4;

    @Schema(description = "该病的诊断时间")
    private String diagnosisDate4;

    @Schema(description = "是否因该病住院治疗")
    private Boolean hospitalized4;

    @Schema(description = "是否使用药物进行治疗")
    private Boolean medication4;

    @Schema(description = "药物，治疗效果")
    private String medicationEffect4;

}