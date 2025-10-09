package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 抵达高原后有无新下疾病 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyHighlandDiseasesDuringServiceRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "7286")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "5082")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "疾病名称")
    private String diseases;

    @Schema(description = "高血压")
    @ExcelProperty("高血压")
    private Boolean hypertension;

    @Schema(description = "心肌梗死")
    @ExcelProperty("心肌梗死")
    private Boolean myocardialInfarction;

    @Schema(description = "冠心病")
    @ExcelProperty("冠心病")
    private Boolean coronaryHeartDisease;

    @Schema(description = "肺心病")
    @ExcelProperty("肺心病")
    private Boolean pulmonaryHeartDisease;

    @Schema(description = "四肢静脉血栓")
    @ExcelProperty("四肢静脉血栓")
    private Boolean lowerExtremityVenousThrombosis;

    @Schema(description = "窦性心动过缓")
    @ExcelProperty("窦性心动过缓")
    private Boolean bradycardia;

    @Schema(description = "窦性心动过速")
    @ExcelProperty("窦性心动过速")
    private Boolean tachycardia;

    @Schema(description = "窦性心律不齐")
    @ExcelProperty("窦性心律不齐")
    private Boolean arrhythmia;

    @Schema(description = "房颤")
    @ExcelProperty("房颤")
    private Boolean atrialFibrillation;

    @Schema(description = "阵发性室上速")
    @ExcelProperty("阵发性室上速")
    private Boolean paroxysmalAuricularTachycardia;

    @Schema(description = "频发房性早搏")
    @ExcelProperty("频发房性早搏")
    private Boolean frequentPrematureAtrialContractions;

    @Schema(description = "频发室性早搏")
    @ExcelProperty("频发室性早搏")
    private Boolean frequentPrematureVentricularContractions;

    @Schema(description = "房室传导阻滞")
    @ExcelProperty("房室传导阻滞")
    private Boolean avBlock;

    @Schema(description = "室性心动过速")
    @ExcelProperty("室性心动过速")
    private Boolean ventricularTachycardia;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private Boolean otherDiseases11;

    @Schema(description = "眩晕")
    @ExcelProperty("眩晕")
    private Boolean dizziness;

    @Schema(description = "短暂性脑缺血")
    @ExcelProperty("短暂性脑缺血")
    private Boolean transientIschemicAttack;

    @Schema(description = "脑梗死/脑血栓")
    @ExcelProperty("脑梗死/脑血栓")
    private Boolean cerebralInfarction;

    @Schema(description = "脑出血")
    @ExcelProperty("脑出血")
    private Boolean cerebralHemorrhage;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private Boolean otherDiseases12;

    @Schema(description = "高血脂")
    @ExcelProperty("高血脂")
    private Boolean hyperlipidemia;

    @Schema(description = "糖尿病")
    @ExcelProperty("糖尿病")
    private Boolean diabetes;

    @Schema(description = "高尿酸血症（痛风）")
    @ExcelProperty("高尿酸血症（痛风）")
    private Boolean gout;

    @Schema(description = "甲状腺疾病")
    @ExcelProperty("甲状腺疾病")
    private Boolean thyroidDisease;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private Boolean otherDiseases13;

    @Schema(description = "失眠")
    @ExcelProperty("失眠")
    private Boolean insomnia;

    @Schema(description = "肿瘤")
    @ExcelProperty("肿瘤")
    private Boolean tumor;

    @Schema(description = "其他")
    @ExcelProperty("其他")
    private Boolean otherDiseases14;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;
}