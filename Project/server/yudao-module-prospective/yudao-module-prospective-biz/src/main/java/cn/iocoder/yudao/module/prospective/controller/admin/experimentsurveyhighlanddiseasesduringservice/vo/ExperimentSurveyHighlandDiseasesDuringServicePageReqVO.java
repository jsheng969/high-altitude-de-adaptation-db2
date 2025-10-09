package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 抵达高原后有无新下疾病分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyHighlandDiseasesDuringServicePageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "5082")
    private Long personId;

    @Schema(description = "疾病名称")
    private String diseases;

    @Schema(description = "高血压")
    private Boolean hypertension;

    @Schema(description = "心肌梗死")
    private Boolean myocardialInfarction;

    @Schema(description = "冠心病")
    private Boolean coronaryHeartDisease;

    @Schema(description = "肺心病")
    private Boolean pulmonaryHeartDisease;

    @Schema(description = "四肢静脉血栓")
    private Boolean lowerExtremityVenousThrombosis;

    @Schema(description = "窦性心动过缓")
    private Boolean bradycardia;

    @Schema(description = "窦性心动过速")
    private Boolean tachycardia;

    @Schema(description = "窦性心律不齐")
    private Boolean arrhythmia;

    @Schema(description = "房颤")
    private Boolean atrialFibrillation;

    @Schema(description = "阵发性室上速")
    private Boolean paroxysmalAuricularTachycardia;

    @Schema(description = "频发房性早搏")
    private Boolean frequentPrematureAtrialContractions;

    @Schema(description = "频发室性早搏")
    private Boolean frequentPrematureVentricularContractions;

    @Schema(description = "房室传导阻滞")
    private Boolean avBlock;

    @Schema(description = "室性心动过速")
    private Boolean ventricularTachycardia;

    @Schema(description = "其他")
    private Boolean otherDiseases11;

    @Schema(description = "眩晕")
    private Boolean dizziness;

    @Schema(description = "短暂性脑缺血")
    private Boolean transientIschemicAttack;

    @Schema(description = "脑梗死/脑血栓")
    private Boolean cerebralInfarction;

    @Schema(description = "脑出血")
    private Boolean cerebralHemorrhage;

    @Schema(description = "其他")
    private Boolean otherDiseases12;

    @Schema(description = "高血脂")
    private Boolean hyperlipidemia;

    @Schema(description = "糖尿病")
    private Boolean diabetes;

    @Schema(description = "高尿酸血症（痛风）")
    private Boolean gout;

    @Schema(description = "甲状腺疾病")
    private Boolean thyroidDisease;

    @Schema(description = "其他")
    private Boolean otherDiseases13;

    @Schema(description = "失眠")
    private Boolean insomnia;

    @Schema(description = "肿瘤")
    private Boolean tumor;

    @Schema(description = "其他")
    private Boolean otherDiseases14;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "时相")
    private Integer timePoint;
}