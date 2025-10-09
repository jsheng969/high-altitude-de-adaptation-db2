package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-退役后返回平原1月内症状分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyPostReturnSymptomsPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "13773")
    private Long personId;

    @Schema(description = "疲倦")
    private Boolean fatigue;

    @Schema(description = "嗜睡")
    private Boolean drowsiness;

    @Schema(description = "头昏")
    private Boolean dizziness;

    @Schema(description = "眩晕")
    private Boolean vertigo;

    @Schema(description = "精力不集中")
    private Boolean poorConcentration;

    @Schema(description = "反应迟钝")
    private Boolean slowReaction;

    @Schema(description = "记忆减退")
    private Boolean memoryLoss;

    @Schema(description = "失眠")
    private Boolean insomnia;

    @Schema(description = "多梦")
    private Boolean nightmares;

    @Schema(description = "心前区痛")
    private Boolean chestPain;

    @Schema(description = "心慌")
    private Boolean palpitations;

    @Schema(description = "脉率减慢")
    private Boolean bradycardia;

    @Schema(description = "紫绀")
    private Boolean cyanosis;

    @Schema(description = "血压波动")
    private Boolean bloodPressureFluctuation;

    @Schema(description = "皮肤出血")
    private Boolean skinBleeding;

    @Schema(description = "皮肤瘀斑")
    private Boolean skinBruising;

    @Schema(description = "贫血")
    private Boolean anemia;

    @Schema(description = "咽喉痛")
    private Boolean soreThroat;

    @Schema(description = "咳嗽")
    private Boolean cough;

    @Schema(description = "多痰")
    private Boolean phlegm;

    @Schema(description = "气喘")
    private Boolean wheezing;

    @Schema(description = "胸闷")
    private Boolean chestTightness;

    @Schema(description = "体重减轻")
    private Boolean weightLoss;

    @Schema(description = "食欲增加")
    private Boolean increasedAppetite;

    @Schema(description = "厌食")
    private Boolean anorexia;

    @Schema(description = "便秘")
    private Boolean constipation;

    @Schema(description = "腹泻")
    private Boolean diarrhea;

    @Schema(description = "腹痛")
    private Boolean abdominalPain;

    @Schema(description = "黄疸")
    private Boolean jaundice;

    @Schema(description = "手足麻木")
    private Boolean numbness;

    @Schema(description = "肢体水肿")
    private Boolean limbEdema;

    @Schema(description = "面部水肿")
    private Boolean facialEdema;

    @Schema(description = "脱发")
    private Boolean hairLoss;

    @Schema(description = "夜尿增多")
    private Boolean increasedUrination;

}