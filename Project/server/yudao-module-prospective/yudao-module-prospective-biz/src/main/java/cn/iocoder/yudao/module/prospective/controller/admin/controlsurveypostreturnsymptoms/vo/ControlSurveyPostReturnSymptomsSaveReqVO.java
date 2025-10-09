package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 对照组流调-退役后返回平原1月内症状新增/修改 Request VO")
@Data
public class ControlSurveyPostReturnSymptomsSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "29796")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6356")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "疲倦")
    private Integer fatigue;

    @Schema(description = "疲倦持续时间")
    private String fatigueDuration;

    @Schema(description = "乏力")
    private Integer weakness;

    @Schema(description = "乏力持续时间")
    private String weaknessDuration;

    @Schema(description = "嗜睡")
    private Integer drowsiness;

    @Schema(description = "嗜睡持续时间")
    private String drowsinessDuration;

    @Schema(description = "头昏")
    private Integer dizziness;

    @Schema(description = "头昏持续时间")
    private String dizzinessDuration;

    @Schema(description = "眩晕")
    private Integer vertigo;

    @Schema(description = "眩晕持续时间")
    private String vertigoDuration;

    @Schema(description = "精力不集中")
    private Integer poorConcentration;

    @Schema(description = "精力不集中持续时间")
    private String poorConcentrationDuration;

    @Schema(description = "反应迟钝")
    private Integer slowReaction;

    @Schema(description = "反应迟钝持续时间")
    private String slowReactionDuration;

    @Schema(description = "记忆减退")
    private Integer memoryLoss;

    @Schema(description = "记忆减退持续时间")
    private String memoryLossDuration;

    @Schema(description = "失眠")
    private Integer insomnia;

    @Schema(description = "失眠持续时间")
    private String insomniaDuration;

    @Schema(description = "多梦")
    private Integer nightmares;

    @Schema(description = "多梦持续时间")
    private String nightmaresDuration;

    @Schema(description = "咽喉痛")
    private Integer soreThroat;

    @Schema(description = "咽喉痛持续时间")
    private String soreThroatDuration;

    @Schema(description = "咳嗽")
    private Integer cough;

    @Schema(description = "咳嗽持续时间")
    private String coughDuration;

    @Schema(description = "多痰")
    private Integer phlegm;

    @Schema(description = "多痰持续时间")
    private String phlegmDuration;

    @Schema(description = "气喘")
    private Integer wheezing;

    @Schema(description = "气喘持续时间")
    private String wheezingDuration;

    @Schema(description = "胸闷")
    private Integer chestTightness;

    @Schema(description = "胸闷持续时间")
    private String chestTightnessDuration;

    @Schema(description = "心前区痛")
    private Integer chestPain;

    @Schema(description = "心前区痛持续时间")
    private String chestPainDuration;

    @Schema(description = "心慌")
    private Integer palpitations;

    @Schema(description = "心慌持续时间")
    private String palpitationsDuration;

    @Schema(description = "脉率减慢")
    private Integer bradycardia;

    @Schema(description = "脉率减慢持续时间")
    private String bradycardiaDuration;

    @Schema(description = "紫绀")
    private Integer cyanosis;

    @Schema(description = "紫绀持续时间")
    private String cyanosisDuration;

    @Schema(description = "血压波动")
    private Integer bloodPressureFluctuation;

    @Schema(description = "血压波动持续时间")
    private String bloodPressureFluctuationDuration;

    @Schema(description = "皮肤出血")
    private Integer skinBleeding;

    @Schema(description = "皮肤出血持续时间")
    private String skinBleedingDuration;

    @Schema(description = "皮肤瘀斑")
    private Integer skinBruising;

    @Schema(description = "皮肤瘀斑持续时间")
    private String skinBruisingDuration;

    @Schema(description = "贫血")
    private Integer anemia;

    @Schema(description = "贫血持续时间")
    private String anemiaDuration;

    @Schema(description = "体重减轻")
    private Integer weightLoss;

    @Schema(description = "体重减轻持续时间")
    private String weightLossDuration;

    @Schema(description = "食欲增加")
    private Integer increasedAppetite;

    @Schema(description = "食欲增加持续时间")
    private String increasedAppetiteDuration;

    @Schema(description = "厌食")
    private Integer anorexia;

    @Schema(description = "厌食持续时间")
    private String anorexiaDuration;

    @Schema(description = "便秘")
    private Integer constipation;

    @Schema(description = "便秘持续时间")
    private String constipationDuration;

    @Schema(description = "腹泻")
    private Integer diarrhea;

    @Schema(description = "腹泻持续时间")
    private String diarrheaDuration;

    @Schema(description = "腹痛")
    private Integer abdominalPain;

    @Schema(description = "腹痛持续时间")
    private String abdominalPainDuration;

    @Schema(description = "腹胀")
    private Integer abdominalDistension;

    @Schema(description = "腹胀持续时间")
    private String abdominalDistensionDuration;

    @Schema(description = "黄疸")
    private Integer jaundice;

    @Schema(description = "黄疸持续时间")
    private String jaundiceDuration;

    @Schema(description = "手足麻木")
    private Integer numbness;

    @Schema(description = "手足麻木持续时间")
    private String numbnessDuration;

    @Schema(description = "肢体水肿")
    private Integer limbEdema;

    @Schema(description = "肢体水肿持续时间")
    private String limbEdemaDuration;

    @Schema(description = "面部水肿")
    private Integer facialEdema;

    @Schema(description = "面部水肿持续时间")
    private String facialEdemaDuration;

    @Schema(description = "脱发")
    private Integer hairLoss;

    @Schema(description = "脱发持续时间")
    private String hairLossDuration;

    @Schema(description = "夜尿增多")
    private Integer increasedUrination;

    @Schema(description = "夜尿增多持续时间")
    private String increasedUrinationDuration;

    @Schema(description = "返回后有无其他症状")
    private String otherSymptoms;

    @Schema(description = "时相点")
    private Integer timePoint;

}