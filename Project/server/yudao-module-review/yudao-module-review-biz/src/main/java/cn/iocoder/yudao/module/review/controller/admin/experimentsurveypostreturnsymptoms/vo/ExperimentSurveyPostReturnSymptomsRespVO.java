package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo;

import cn.iocoder.yudao.framework.excel.core.convert.BooleanConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-退役后返回平原1月内症状 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyPostReturnSymptomsRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "9020")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13773")
    @ExcelProperty("基础信息id")
    private Long personId;

    // ========== 精神及全身症状 ==========
    @Schema(description = "疲倦")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "疲倦"}, converter = BooleanConvert.class)
    private Boolean fatigue;

    @Schema(description = "嗜睡")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "嗜睡"}, converter = BooleanConvert.class)
    private Boolean drowsiness;

    @Schema(description = "头昏")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "头昏"}, converter = BooleanConvert.class)
    private Boolean dizziness;

    @Schema(description = "眩晕")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "眩晕"}, converter = BooleanConvert.class)
    private Boolean vertigo;

    @Schema(description = "精力不集中")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "精力不集中"}, converter = BooleanConvert.class)
    private Boolean poorConcentration;

    @Schema(description = "反应迟钝")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "反应迟钝"}, converter = BooleanConvert.class)
    private Boolean slowReaction;

    @Schema(description = "记忆减退")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "记忆减退"}, converter = BooleanConvert.class)
    private Boolean memoryLoss;

    @Schema(description = "失眠")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "失眠"}, converter = BooleanConvert.class)
    private Boolean insomnia;

    @Schema(description = "多梦")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "多梦"}, converter = BooleanConvert.class)
    private Boolean nightmares;

    // ========== 循环症状 ==========
    @Schema(description = "心前区痛")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "心前区痛"}, converter = BooleanConvert.class)
    private Boolean chestPain;

    @Schema(description = "心慌")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "心慌"}, converter = BooleanConvert.class)
    private Boolean palpitations;

    @Schema(description = "脉率减慢")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "脉率减慢"}, converter = BooleanConvert.class)
    private Boolean bradycardia;

    @Schema(description = "紫绀")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "紫绀"}, converter = BooleanConvert.class)
    private Boolean cyanosis;

    @Schema(description = "血压波动")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "血压波动"}, converter = BooleanConvert.class)
    private Boolean bloodPressureFluctuation;

    @Schema(description = "皮肤出血")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "皮肤出血"}, converter = BooleanConvert.class)
    private Boolean skinBleeding;

    @Schema(description = "皮肤瘀斑")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "皮肤瘀斑"}, converter = BooleanConvert.class)
    private Boolean skinBruising;

    @Schema(description = "贫血")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "贫血"}, converter = BooleanConvert.class)
    private Boolean anemia;

    // ========== 呼吸症状 ==========
    @Schema(description = "咽喉痛")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "咽喉痛"}, converter = BooleanConvert.class)
    private Boolean soreThroat;

    @Schema(description = "咳嗽")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "咳嗽"}, converter = BooleanConvert.class)
    private Boolean cough;

    @Schema(description = "多痰")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "多痰"}, converter = BooleanConvert.class)
    private Boolean phlegm;

    @Schema(description = "气喘")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "气喘"}, converter = BooleanConvert.class)
    private Boolean wheezing;

    @Schema(description = "胸闷")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "胸闷"}, converter = BooleanConvert.class)
    private Boolean chestTightness;

    // ========== 消化症状 ==========
    @Schema(description = "体重减轻")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "体重减轻"}, converter = BooleanConvert.class)
    private Boolean weightLoss;

    @Schema(description = "食欲增加")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "食欲增加"}, converter = BooleanConvert.class)
    private Boolean increasedAppetite;

    @Schema(description = "厌食")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "厌食"}, converter = BooleanConvert.class)
    private Boolean anorexia;

    @Schema(description = "便秘")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "便秘"}, converter = BooleanConvert.class)
    private Boolean constipation;

    @Schema(description = "腹泻")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "腹泻"}, converter = BooleanConvert.class)
    private Boolean diarrhea;

    @Schema(description = "腹痛")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "腹痛"}, converter = BooleanConvert.class)
    private Boolean abdominalPain;

    @Schema(description = "黄疸")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "黄疸"}, converter = BooleanConvert.class)
    private Boolean jaundice;

    // ========== 其他症状 ==========
    @Schema(description = "手足麻木")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "手足麻木"}, converter = BooleanConvert.class)
    private Boolean numbness;

    @Schema(description = "肢体水肿")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "肢体水肿"}, converter = BooleanConvert.class)
    private Boolean limbEdema;

    @Schema(description = "面部水肿")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "面部水肿"}, converter = BooleanConvert.class)
    private Boolean facialEdema;

    @Schema(description = "脱发")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "脱发"}, converter = BooleanConvert.class)
    private Boolean hairLoss;

    @Schema(description = "夜尿增多")
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "夜尿增多"}, converter = BooleanConvert.class)
    private Boolean increasedUrination;

}