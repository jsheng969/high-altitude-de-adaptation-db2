package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 抵达高原后有无新下疾病新增/修改 Request VO")
@Data
public class ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "7286")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5082")
    @NotNull(message = "基础信息id不能为空")
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

    @Schema(description = "时相")
    private Integer timePoint;
}