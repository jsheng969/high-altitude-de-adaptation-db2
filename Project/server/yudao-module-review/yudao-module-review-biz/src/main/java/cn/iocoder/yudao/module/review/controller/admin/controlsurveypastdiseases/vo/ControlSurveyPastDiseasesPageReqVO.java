package cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Schema(description = "管理后台 - 对照组流调-既往疾病分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ControlSurveyPastDiseasesPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "21174")
    private Long personId;

    @Schema(description = "既往疾病1名称", example = "张三")
    private String disease1Name;

    @Schema(description = "既往疾病1是否确诊")
    private Boolean disease1Diagnosed;

    @Schema(description = "既往疾病1确诊时间")
    private String disease1DiagnosisDate;

    @Schema(description = "既往疾病1是否住院")
    private Boolean disease1Hospitalized;

    @Schema(description = "既往疾病1是否治疗")
    private Boolean disease1Treated;

    @Schema(description = "既往疾病1治疗效果")
    private String disease1TreatmentEffect;

    @Schema(description = "既往疾病2名称", example = "李四")
    private String disease2Name;

    @Schema(description = "既往疾病2是否确诊")
    private Boolean disease2Diagnosed;

    @Schema(description = "既往疾病2确诊时间")
    private String disease2DiagnosisDate;

    @Schema(description = "既往疾病2是否住院")
    private Boolean disease2Hospitalized;

    @Schema(description = "既往疾病2是否治疗")
    private Boolean disease2Treated;

    @Schema(description = "既往疾病2治疗效果")
    private String disease2TreatmentEffect;

    @Schema(description = "既往疾病3名称", example = "王五")
    private String disease3Name;

    @Schema(description = "既往疾病3是否确诊")
    private Boolean disease3Diagnosed;

    @Schema(description = "既往疾病3确诊时间")
    private String disease3DiagnosisDate;

    @Schema(description = "既往疾病3是否住院")
    private Boolean disease3Hospitalized;

    @Schema(description = "既往疾病3是否治疗")
    private Boolean disease3Treated;

    @Schema(description = "既往疾病3治疗效果")
    private String disease3TreatmentEffect;

    @Schema(description = "既往疾病4名称", example = "李四")
    private String disease4Name;

    @Schema(description = "既往疾病4是否确诊")
    private Boolean disease4Diagnosed;

    @Schema(description = "既往疾病4确诊时间")
    private String disease4DiagnosisDate;

    @Schema(description = "既往疾病4是否住院")
    private Boolean disease4Hospitalized;

    @Schema(description = "既往疾病4是否治疗")
    private Boolean disease4Treated;

    @Schema(description = "既往疾病4治疗效果")
    private String disease4TreatmentEffect;

    @Schema(description = "既往疾病5名称", example = "张三")
    private String disease5Name;

    @Schema(description = "既往疾病5是否确诊")
    private Boolean disease5Diagnosed;

    @Schema(description = "既往疾病5确诊时间")
    private String disease5DiagnosisDate;

    @Schema(description = "既往疾病5是否住院")
    private Boolean disease5Hospitalized;

    @Schema(description = "既往疾病5是否治疗")
    private Boolean disease5Treated;

    @Schema(description = "既往疾病5治疗效果")
    private String disease5TreatmentEffect;

    @Schema(description = "既往疾病6名称", example = "李四")
    private String disease6Name;

    @Schema(description = "既往疾病6是否确诊")
    private Boolean disease6Diagnosed;

    @Schema(description = "既往疾病6确诊时间")
    private String disease6DiagnosisDate;

    @Schema(description = "既往疾病6是否住院")
    private Boolean disease6Hospitalized;

    @Schema(description = "既往疾病6是否治疗")
    private Boolean disease6Treated;

    @Schema(description = "既往疾病6治疗效果")
    private String disease6TreatmentEffect;

}