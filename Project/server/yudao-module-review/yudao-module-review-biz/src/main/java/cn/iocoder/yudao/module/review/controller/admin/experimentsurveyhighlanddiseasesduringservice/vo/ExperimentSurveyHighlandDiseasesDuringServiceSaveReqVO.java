package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-高原期间出现的疾病新增/修改 Request VO")
@Data
public class ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "8097")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "18851")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "高血压 1")
    private Boolean hypertension;

    @Schema(description = "心肌梗死 1")
    private Boolean myocardialInfarction;

    @Schema(description = "冠心病 1")
    private Boolean coronaryHeartDisease;

    @Schema(description = "肺心病 1")
    private Boolean pulmonaryHeartDisease;

    @Schema(description = "四肢静脉血栓 1")
    private Boolean lowerExtremityVenousThrombosis;

    @Schema(description = "窦性心动过缓 1")
    private Boolean bradycardia;

    @Schema(description = "窦性心动过速 1")
    private Boolean tachycardia;

    @Schema(description = "窦性心律不齐 1")
    private Boolean arrhythmia;

    @Schema(description = "房颤 1")
    private Boolean atrialFibrillation;

    @Schema(description = "阵发性室上速 1")
    private Boolean paroxysmalAuricularTachycardia;

    @Schema(description = "频发房性早搏 1")
    private Boolean frequentPrematureAtrialContractions;

    @Schema(description = "频发室性早搏 1")
    private Boolean frequentPrematureVentricularContractions;

    @Schema(description = "房室传导阻滞 1")
    private Boolean avBlock;

    @Schema(description = "室性心动过速 1")
    private Boolean ventricularTachycardia;

    @Schema(description = "其他 1 1")
    private Boolean otherDiseases1;

    @Schema(description = "眩晕 1")
    private Boolean dizziness;

    @Schema(description = "短暂性脑缺血 1")
    private Boolean transientIschemicAttack;

    @Schema(description = "脑梗死/脑血栓 1")
    private Boolean cerebralInfarction;

    @Schema(description = "脑出血 1")
    private Boolean cerebralHemorrhage;

    @Schema(description = "其他 1 2")
    private Boolean otherDiseases2;

    @Schema(description = "高血脂 1")
    private Boolean hyperlipidemia;

    @Schema(description = "糖尿病 1")
    private Boolean diabetes;

    @Schema(description = "高尿酸血症（痛风） 1")
    private Boolean gout;

    @Schema(description = "甲状腺疾病 1")
    private Boolean thyroidDisease;

    @Schema(description = "其他 1 3")
    private Boolean otherDiseases3;

    @Schema(description = "失眠 1")
    private Boolean insomnia;

    @Schema(description = "肿瘤 1")
    private Boolean tumor;

    @Schema(description = "其他 1 4")
    private Boolean otherDiseases4;

}