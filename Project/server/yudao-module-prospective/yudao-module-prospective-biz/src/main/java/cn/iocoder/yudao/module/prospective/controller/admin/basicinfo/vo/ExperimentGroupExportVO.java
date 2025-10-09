package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ExcelIgnoreUnannotated
public class ExperimentGroupExportVO {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty({"基础信息", "编号"})
    private String code;
    @ExcelProperty({"基础信息", "实际年龄"})
    private Integer actualAge;
    @ExcelProperty({"基础信息", "性别"})
    private String gender;
    @ExcelProperty({"基础信息", "出生年月"})
    private String birthDate;
    @ExcelProperty({"基础信息", "部职别"})
    private String position;
    @ExcelProperty({"基础信息", "证件号"})
    private String idNumber;
    @ExcelProperty({"基础信息", "婚姻状况"})
    private String maritalStatus;
    @ExcelProperty({"基础信息", "身高"})
    private BigDecimal height;
    @ExcelProperty({"基础信息", "体重"})
    private BigDecimal weight;
    @ExcelProperty({"基础信息", "民族"})
    private String ethnicity;
    @ExcelProperty({"基础信息", "最高学历"})
    private String educationLevel;
    @ExcelProperty({"基础信息", "生育情况"})
    private String fertilityStatus;

    @ExcelProperty({"驻训信息", "任务点海拔(m)"})
    private Integer missionPointAltitude;

    @ExcelProperty({"驻训信息", "驻训地点"})
    private String location;

    @ExcelProperty({"驻训信息", "高原驻训次数"})
    private Integer plateauTrainingCount;

    @ExcelProperty({"驻训信息", "驻训总时长(月)"})
    private Integer plateauTrainingDuration;

    @ExcelProperty({"驻训信息", "任务类型"})
    private String missionType;

    @ExcelProperty({"驻训信息", "每日工作时长(h)"})
    private Integer dailyWorkHours;

    @ExcelProperty({"驻训信息", "服役期间职务"})
    private String servicePosition;

    @ExcelProperty({"吸烟信息","吸烟情况"})
    private String smokingStatus;

    @ExcelProperty({"吸烟信息","每天抽烟的数量"})
    private String dailyCigarettes;

    @ExcelProperty({"吸烟信息","开始吸烟时年龄"})
    private String smokingStartAge;

    @ExcelProperty({"吸烟信息","烟龄"})
    private String smokingYears;

    @ExcelProperty({"吸烟信息","之前尝试过戒烟吗"})
    private Boolean quitAttempted;

    @ExcelProperty({"吸烟信息","吸烟地区"})
    private String smokingRegion;

    @ExcelProperty({"吸烟信息","已戒烟.您的烟龄"})
    private String quitSmokingYears;

    @ExcelProperty({"吸烟信息","已戒烟.您已戒烟"})
    private String quitSmokingDuration;

    @ExcelProperty({"吸烟信息","已戒烟.吸烟地区"})
    private String quitSmokingRegion;


    @ExcelProperty({"自我评价","健康状况对比评价"})
    private String healthComparisonWithPeers;

    @ExcelProperty({"自我评价","健康自评分数"})
    private Integer healthScore;

    @ExcelProperty({"评分总数统计","评分类型"})
    private String totalScoreType;

    @ExcelProperty({"评分总数统计","评分总数"})
    private BigDecimal totalScore;

    @ExcelProperty({"评分总数统计","转归类型"})
    private String conversionType ;

    @ExcelProperty({"评分总数统计","第二时相点评分"})
    private BigDecimal totalScore2;

    @ExcelProperty({"退役后返回平原症状","疲倦"})
    private Integer fatigue;

    @ExcelProperty({"退役后返回平原症状","疲倦持续时间"})
    private String fatigueDuration;

    @ExcelProperty({"退役后返回平原症状","乏力"})
    private Integer weakness;

    @ExcelProperty({"退役后返回平原症状","乏力持续时间"})
    private String weaknessDuration;

    @ExcelProperty({"退役后返回平原症状","嗜睡"})
    private Integer drowsiness;

    @ExcelProperty({"退役后返回平原症状","嗜睡持续时间"})
    private String drowsinessDuration;

    @ExcelProperty({"退役后返回平原症状","头昏"})
    private Integer dizziness;

    @ExcelProperty({"退役后返回平原症状","头昏持续时间"})
    private String dizzinessDuration;

    @ExcelProperty({"退役后返回平原症状","眩晕"})
    private Integer vertigo;

    @ExcelProperty({"退役后返回平原症状","眩晕持续时间"})
    private String vertigoDuration;

    @ExcelProperty({"退役后返回平原症状","精力不集中"})
    private Integer poorConcentration;

    @ExcelProperty({"退役后返回平原症状","精力不集中持续时间"})
    private String poorConcentrationDuration;

    @ExcelProperty({"退役后返回平原症状","反应迟钝"})
    private Integer slowReaction;

    @ExcelProperty({"退役后返回平原症状","反应迟钝持续时间"})
    private String slowReactionDuration;

    @ExcelProperty({"退役后返回平原症状","记忆减退"})
    private Integer memoryLoss;

    @ExcelProperty({"退役后返回平原症状","记忆减退持续时间"})
    private String memoryLossDuration;

    @ExcelProperty({"退役后返回平原症状","失眠"})
    private Integer insomnia;

    @ExcelProperty({"退役后返回平原症状","失眠持续时间"})
    private String insomniaDuration;

    @ExcelProperty({"退役后返回平原症状","多梦"})
    private Integer nightmares;

    @ExcelProperty({"退役后返回平原症状","多梦持续时间"})
    private String nightmaresDuration;

    @ExcelProperty({"退役后返回平原症状","咽喉痛"})
    private Integer soreThroat;

    @ExcelProperty({"退役后返回平原症状","咽喉痛持续时间"})
    private String soreThroatDuration;

    @ExcelProperty({"退役后返回平原症状","咳嗽"})
    private Integer cough;

    @ExcelProperty({"退役后返回平原症状","咳嗽持续时间"})
    private String coughDuration;

    @ExcelProperty({"退役后返回平原症状","多痰"})
    private Integer phlegm;

    @ExcelProperty({"退役后返回平原症状","多痰持续时间"})
    private String phlegmDuration;

    @ExcelProperty({"退役后返回平原症状","气喘"})
    private Integer wheezing;

    @ExcelProperty({"退役后返回平原症状","气喘持续时间"})
    private String wheezingDuration;

    @ExcelProperty({"退役后返回平原症状","胸闷"})
    private Integer chestTightness;

    @ExcelProperty({"退役后返回平原症状","胸闷持续时间"})
    private String chestTightnessDuration;

    @ExcelProperty({"退役后返回平原症状","心前区痛"})
    private Integer chestPain;

    @ExcelProperty({"退役后返回平原症状","心前区痛持续时间"})
    private String chestPainDuration;

    @ExcelProperty({"退役后返回平原症状","心慌"})
    private Integer palpitations;

    @ExcelProperty({"退役后返回平原症状","心慌持续时间"})
    private String palpitationsDuration;

    @ExcelProperty({"退役后返回平原症状","脉率减慢"})
    private Integer bradycardia;

    @ExcelProperty({"退役后返回平原症状","脉率减慢持续时间"})
    private String bradycardiaDuration;

    @ExcelProperty({"退役后返回平原症状","紫绀"})
    private Integer cyanosis;

    @ExcelProperty({"退役后返回平原症状","紫绀持续时间"})
    private String cyanosisDuration;

    @ExcelProperty({"退役后返回平原症状","血压波动"})
    private Integer bloodPressureFluctuation;

    @ExcelProperty({"退役后返回平原症状","血压波动持续时间"})
    private String bloodPressureFluctuationDuration;

    @ExcelProperty({"退役后返回平原症状","皮肤出血"})
    private Integer skinBleeding;

    @ExcelProperty({"退役后返回平原症状","皮肤出血持续时间"})
    private String skinBleedingDuration;

    @ExcelProperty({"退役后返回平原症状","皮肤瘀斑"})
    private Integer skinBruising;

    @ExcelProperty({"退役后返回平原症状","皮肤瘀斑持续时间"})
    private String skinBruisingDuration;

    @ExcelProperty({"退役后返回平原症状","贫血"})
    private Integer anemia;

    @ExcelProperty({"退役后返回平原症状","贫血持续时间"})
    private String anemiaDuration;

    @ExcelProperty({"退役后返回平原症状","体重减轻"})
    private Integer weightLoss;

    @ExcelProperty({"退役后返回平原症状","体重减轻持续时间"})
    private String weightLossDuration;

    @ExcelProperty({"退役后返回平原症状","食欲增加"})
    private Integer increasedAppetite;

    @ExcelProperty({"退役后返回平原症状","食欲增加持续时间"})
    private String increasedAppetiteDuration;

    @ExcelProperty({"退役后返回平原症状","厌食"})
    private Integer anorexia;

    @ExcelProperty({"退役后返回平原症状","厌食持续时间"})
    private String anorexiaDuration;

    @ExcelProperty({"退役后返回平原症状","便秘"})
    private Integer constipation;

    @ExcelProperty({"退役后返回平原症状","便秘持续时间"})
    private String constipationDuration;

    @ExcelProperty({"退役后返回平原症状","腹泻"})
    private Integer diarrhea;

    @ExcelProperty({"退役后返回平原症状","腹泻持续时间"})
    private String diarrheaDuration;

    @ExcelProperty({"退役后返回平原症状","腹痛"})
    private Integer abdominalPain;

    @ExcelProperty({"退役后返回平原症状","腹痛持续时间"})
    private String abdominalPainDuration;

    @ExcelProperty({"退役后返回平原症状","腹胀"})
    private Integer abdominalDistension;

    @ExcelProperty({"退役后返回平原症状","腹胀持续时间"})
    private String abdominalDistensionDuration;

    @ExcelProperty({"退役后返回平原症状","黄疸"})
    private Integer jaundice;

    @ExcelProperty({"退役后返回平原症状","黄疸持续时间"})
    private String jaundiceDuration;

    @ExcelProperty({"退役后返回平原症状","手足麻木"})
    private Integer numbness;

    @ExcelProperty({"退役后返回平原症状","手足麻木持续时间"})
    private String numbnessDuration;

    @ExcelProperty({"退役后返回平原症状","肢体水肿"})
    private Integer limbEdema;

    @ExcelProperty({"退役后返回平原症状","肢体水肿持续时间"})
    private String limbEdemaDuration;

    @ExcelProperty({"退役后返回平原症状","面部水肿"})
    private Integer facialEdema;

    @ExcelProperty({"退役后返回平原症状","面部水肿持续时间"})
    private String facialEdemaDuration;

    @ExcelProperty({"退役后返回平原症状","脱发"})
    private Integer hairLoss;

    @ExcelProperty({"退役后返回平原症状","脱发持续时间"})
    private String hairLossDuration;

    @ExcelProperty({"退役后返回平原症状","夜尿增多"})
    private Integer increasedUrination;

    @ExcelProperty({"退役后返回平原症状","夜尿增多持续时间"})
    private String increasedUrinationDuration;

    @ExcelProperty({"退役后返回平原症状","返回后有无其他症状"})
    private String otherSymptoms;

    // 高原适应调查-体能训练和睡眠信息
    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "是否有规律的体能训练"})
    private Boolean hasRegularTraining;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "体能训练频率"})
    private String trainingFrequency;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "每次锻炼时长"})
    private String trainingDuration;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "体能训练类型"})
    private String trainingType;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "训练时是否胸闷气促"})
    private String hasChestDiscomfort;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "适应后症状是否缓解"})
    private Boolean symptomReliefAfterAdaptation;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "是否存在失眠"})
    private String hasInsomnia;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "日均睡眠小时数"})
    private String dailySleepHours;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "失眠是否改善"})
    private Boolean insomniaImprovement;

    @ExcelProperty({"高原适应调查-体能训练和睡眠信息", "饮食情况及习惯"})
    private String dietHabits;

    // 抵达高原后症状记录
    @ExcelProperty({"抵达高原后症状记录", "头痛"})
    private String headache;

    @ExcelProperty({"抵达高原后症状记录", "头痛持续时间"})
    private String headacheDuration;

    @ExcelProperty({"抵达高原后症状记录", "消化道症状"})
    private String digestiveSymptoms;

    @ExcelProperty({"抵达高原后症状记录", "消化道症状持续时间"})
    private String digestiveSymptomsDuration;

    @ExcelProperty({"抵达高原后症状记录", "疲惫和/或乏力"})
    private String fatigueArrival;

    @ExcelProperty({"抵达高原后症状记录", "疲惫乏力持续时间"})
    private String fatigueDurationArrival;

    @ExcelProperty({"抵达高原后症状记录", "头晕"})
    private String dizzinessArrival;

    @ExcelProperty({"抵达高原后症状记录", "头晕持续时间"})
    private String dizzinessDurationArrival;

    @ExcelProperty({"抵达高原后症状记录", "相关症状如何影响您的日常工作及生活"})
    private String impactOnDailyLife;

    // 推进情况调查
    @ExcelProperty({"推进情况调查", "交通方式"})
    private String transportationMode;

    @ExcelProperty({"推进情况调查", "任务点海拔"})
    private Integer missionPointAltitudeProgress;

    @ExcelProperty({"推进情况调查", "地点"})
    private String locationProgress;

    @ExcelProperty({"推进情况调查", "抵达任务地点日期"})
    private String arrivalDate;

    @ExcelProperty({"推进情况调查", "高原任务持续时间"})
    private Integer plateauMissionDuration;

    @ExcelProperty({"推进情况调查", "推进途中耗费时间"})
    private String travelDuration;

    @ExcelProperty({"推进情况调查", "途中经停"})
    private Boolean hasStopover;

    @ExcelProperty({"推进情况调查", "经停地点"})
    private String stopoverLocation;

    @ExcelProperty({"推进情况调查", "经停时间"})
    private String stopoverDuration;

    @ExcelProperty({"推进情况调查", "抵达任务地后有无不适"})
    private Boolean hasDiscomfortAfterArrival;

    @ExcelProperty({"推进情况调查", "不适发生时间（抵达后）"})
    private String discomfortOccurrenceTime;

    @ExcelProperty({"推进情况调查", "返回目的"})
    private String returnPurpose;

    // 既往疾病史
    @ExcelProperty({"既往疾病史", "既往是否患有下列疾病"})
    private String description;

    // 抵达高原后有无新发疾病
    @ExcelProperty({"抵达高原后有无新发疾病", "疾病名称"})
    private String diseases;

    @ExcelProperty({"抵达高原后有无新发疾病", "高血压"})
    private Boolean hypertension;

    @ExcelProperty({"抵达高原后有无新发疾病", "心肌梗死"})
    private Boolean myocardialInfarction;

    @ExcelProperty({"抵达高原后有无新发疾病", "冠心病"})
    private Boolean coronaryHeartDisease;

    @ExcelProperty({"抵达高原后有无新发疾病", "肺心病"})
    private Boolean pulmonaryHeartDisease;

    @ExcelProperty({"抵达高原后有无新发疾病", "四肢静脉血栓"})
    private Boolean lowerExtremityVenousThrombosis;

    @ExcelProperty({"抵达高原后有无新发疾病", "窦性心动过缓"})
    private Boolean bradycardiaDiseases;

    @ExcelProperty({"抵达高原后有无新发疾病", "窦性心动过速"})
    private Boolean tachycardia;

    @ExcelProperty({"抵达高原后有无新发疾病", "窦性心律不齐"})
    private Boolean arrhythmia;

    @ExcelProperty({"抵达高原后有无新发疾病", "房颤"})
    private Boolean atrialFibrillation;

    @ExcelProperty({"抵达高原后有无新发疾病", "阵发性室上速"})
    private Boolean paroxysmalAuricularTachycardia;

    @ExcelProperty({"抵达高原后有无新发疾病", "频发房性早搏"})
    private Boolean frequentPrematureAtrialContractions;

    @ExcelProperty({"抵达高原后有无新发疾病", "频发室性早搏"})
    private Boolean frequentPrematureVentricularContractions;

    @ExcelProperty({"抵达高原后有无新发疾病", "房室传导阻滞"})
    private Boolean avBlock;

    @ExcelProperty({"抵达高原后有无新发疾病", "室性心动过速"})
    private Boolean ventricularTachycardia;

    @ExcelProperty({"抵达高原后有无新发疾病", "其他(心血管疾病)"})
    private Boolean otherDiseases11;

    @ExcelProperty({"抵达高原后有无新发疾病", "眩晕"})
    private Boolean dizzinessDiseases;

    @ExcelProperty({"抵达高原后有无新发疾病", "短暂性脑缺血"})
    private Boolean transientIschemicAttack;

    @ExcelProperty({"抵达高原后有无新发疾病", "脑梗死/脑血栓"})
    private Boolean cerebralInfarction;

    @ExcelProperty({"抵达高原后有无新发疾病", "脑出血"})
    private Boolean cerebralHemorrhage;

    @ExcelProperty({"抵达高原后有无新发疾病", "其他(脑血管疾病)"})
    private Boolean otherDiseases12;

    @ExcelProperty({"抵达高原后有无新发疾病", "高血脂"})
    private Boolean hyperlipidemia;

    @ExcelProperty({"抵达高原后有无新发疾病", "糖尿病"})
    private Boolean diabetes;

    @ExcelProperty({"抵达高原后有无新发疾病", "高尿酸血症(痛风)"})
    private Boolean gout;

    @ExcelProperty({"抵达高原后有无新发疾病", "甲状腺疾病"})
    private Boolean thyroidDisease;

    @ExcelProperty({"抵达高原后有无新发疾病", "其他(代谢内分泌疾病)"})
    private Boolean otherDiseases13;

    @ExcelProperty({"抵达高原后有无新发疾病", "失眠"})
    private Boolean insomniaDiseases;

    @ExcelProperty({"抵达高原后有无新发疾病", "肿瘤"})
    private Boolean tumor;

    @ExcelProperty({"抵达高原后有无新发疾病", "其他"})
    private Boolean otherDiseases14;

    // 基本检测信息
    @ExcelProperty({"基本检测信息", "收缩压"})
    private Integer systolicBloodPressure;

    @ExcelProperty({"基本检测信息", "舒张压"})
    private Integer diastolicBloodPressure;

    @ExcelProperty({"基本检测信息", "氧饱和度"})
    private Integer oxygenSaturation;

    @ExcelProperty({"基本检测信息", "心率"})
    private Integer heartRate;

    @ExcelProperty({"基本检测信息", "基本身高"})
    private Integer basicHeight;

    @ExcelProperty({"基本检测信息", "基本体重"})
    private Integer basicWeight;

    @ExcelProperty({"基本检测信息", "调查身高"})
    private Integer surveyHeight;

    @ExcelProperty({"基本检测信息", "调查体重"})
    private Integer surveyWeight;

    // 高原急性高山病记录
    @ExcelProperty({"高原急性高山病记录", "急性高原反应"})
    private Boolean acuteMountainReaction;

    @ExcelProperty({"高原急性高山病记录", "肺水肿"})
    private Boolean pulmonaryEdema;

    @ExcelProperty({"高原急性高山病记录", "脑水肿"})
    private Boolean cerebralEdema;

    @ExcelProperty({"高原急性高山病记录", "高原心脏病"})
    private Boolean highAltitudeHeartDisease;

    @ExcelProperty({"高原急性高山病记录", "高原红细胞增多症"})
    private Boolean polycythemia;

    @ExcelProperty({"高原急性高山病记录", "高原期间有无发生以下疾病"})
    private String otherDiseases;

    @ExcelProperty({"高原急性高山病记录", "其他疾病描述"})
    private String otherDiseasesDesc;














    // ========== 生化检查 ==========
    @ExcelProperty({"生化", "谷丙转氨酶"})
    private BigDecimal alt;

    @ExcelProperty({"生化", "谷草转氨酶"})
    private BigDecimal ast;

    @ExcelProperty({"生化", "谷草转氨酶与谷丙转氨酶比值"})
    private BigDecimal astAltRatio;

    @ExcelProperty({"生化", "总蛋白"})
    private BigDecimal totalProtein;

    @ExcelProperty({"生化", "白蛋白"})
    private BigDecimal albumin;

    @ExcelProperty({"生化", "球蛋白"})
    private BigDecimal globulin;

    @ExcelProperty({"生化", "白球比"})
    private BigDecimal albGlobRatio;

    @ExcelProperty({"生化", "总胆红素"})
    private BigDecimal totalBilirubin;

    @ExcelProperty({"生化", "直接胆红素"})
    private BigDecimal directBilirubin;

    @ExcelProperty({"生化", "间接胆红素"})
    private BigDecimal indirectBilirubin;

    @ExcelProperty({"生化", "碱性磷酸酶"})
    private BigDecimal alkalinePhosphatase;

    @ExcelProperty({"生化", "谷氨酰转肽酶"})
    private BigDecimal ggt;

    @ExcelProperty({"生化", "总胆汁酸"})
    private BigDecimal totalBileAcid;

    @ExcelProperty({"生化", "胆碱酯酶"})
    private BigDecimal cholinesterase;

    @ExcelProperty({"生化", "前白蛋白"})
    private BigDecimal prealbumin;

    @ExcelProperty({"生化", "尿素"})
    private BigDecimal urea;

    @ExcelProperty({"生化", "肌酐"})
    private BigDecimal creatinine;

    @ExcelProperty({"生化", "尿酸"})
    private BigDecimal uricAcid;

    @ExcelProperty({"生化", "甘油三酯"})
    private BigDecimal triglycerides;

    @ExcelProperty({"生化", "胆固醇"})
    private BigDecimal cholesterol;

    @ExcelProperty({"生化", "高密度脂蛋白"})
    private BigDecimal hdlC;

    @ExcelProperty({"生化", "低密度脂蛋白"})
    private BigDecimal ldlC;

    @ExcelProperty({"生化", "载脂蛋白A"})
    private BigDecimal apoa;

    @ExcelProperty({"生化", "载脂蛋白B"})
    private BigDecimal apob;

    @ExcelProperty({"生化", "脂蛋白a"})
    private BigDecimal lpa;

    @ExcelProperty({"生化", "葡萄糖"})
    private BigDecimal glucose;

    @ExcelProperty({"生化", "肌酸激酶"})
    private BigDecimal ck;

    @ExcelProperty({"生化", "肌酸激酶同工酶MB"})
    private BigDecimal ckMb;

    @ExcelProperty({"生化", "α-羟丁酸脱氢酶"})
    private BigDecimal alphaHbdh;

    @ExcelProperty({"生化", "乳酸脱氢酶"})
    private BigDecimal ldh;

    @ExcelProperty({"生化", "C-反应蛋白"})
    private BigDecimal crp;

    @ExcelProperty({"生化", "免疫球蛋白G"})
    private BigDecimal igg;

    @ExcelProperty({"生化", "免疫球蛋白A"})
    private BigDecimal iga;

    @ExcelProperty({"生化", "免疫球蛋白M"})
    private BigDecimal igm;

    @ExcelProperty({"生化", "补体3"})
    private BigDecimal complement3;

    @ExcelProperty({"生化", "补体4"})
    private BigDecimal complement4;

    @ExcelProperty({"生化", "肌红蛋白"})
    private BigDecimal myoglobin;

    @ExcelProperty({"生化", "小而密低密度脂蛋白"})
    private BigDecimal smallDenseLdl;

    @ExcelProperty({"生化", "同型半胱氨酸"})
    private BigDecimal homocysteine;

    @ExcelProperty({"生化", "5-核苷酸酶"})
    private BigDecimal nucleotidase;

    @ExcelProperty({"生化", "腺苷脱氨酶"})
    private BigDecimal ada;

    @ExcelProperty({"生化", "淀粉酶"})
    private BigDecimal amylase;

    @ExcelProperty({"生化", "阴离子间隙"})
    private BigDecimal anionGap;

    @ExcelProperty({"生化", "缓冲碱"})
    private BigDecimal bufferBase;

    @ExcelProperty({"生化", "碳酸氢盐"})
    private BigDecimal bicarbonate;

    @ExcelProperty({"生化", "碱剩余"})
    private BigDecimal baseExcess;

    @ExcelProperty({"生化", "细胞外液碱剩余"})
    private BigDecimal extracellularBe;

    @ExcelProperty({"生化", "血尿素"})
    private BigDecimal bloodUrea;

    @ExcelProperty({"生化", "血尿素氮"})
    private BigDecimal bun;

    @ExcelProperty({"生化", "钙"})
    private BigDecimal calcium;

    @ExcelProperty({"生化", "氯"})
    private BigDecimal chloride;

    @ExcelProperty({"生化", "胱抑素C"})
    private BigDecimal cystatinC;

    @ExcelProperty({"生化", "铁"})
    private BigDecimal iron;

    @ExcelProperty({"生化", "实际碳酸氢盐"})
    private BigDecimal actualBicarbonate;

    @ExcelProperty({"生化", "标准碳酸氢盐"})
    private BigDecimal standardBicarbonate;

    @ExcelProperty({"生化", "钾"})
    private BigDecimal potassium;

    @ExcelProperty({"生化", "镁"})
    private BigDecimal magnesium;

    @ExcelProperty({"生化", "钠"})
    private BigDecimal sodium;

    @ExcelProperty({"生化", "磷"})
    private BigDecimal phosphorus;

    @ExcelProperty({"生化", "二氧化碳分压"})
    private BigDecimal pco2;

    @ExcelProperty({"生化", "酸碱度"})
    private BigDecimal ph;

    @ExcelProperty({"生化", "氧分压"})
    private BigDecimal po2;

    @ExcelProperty({"生化", "视黄醇结合蛋白"})
    private BigDecimal rbp;

    @ExcelProperty({"生化", "肾素活性"})
    private BigDecimal reninActivity;

    @ExcelProperty({"生化", "氢离子浓度"})
    private BigDecimal hydrogenIonConcentration;

    @ExcelProperty({"生化", "二氧化碳总量"})
    private BigDecimal tco2;

    @ExcelProperty({"生化", "乳酸"})
    private BigDecimal lacticAcid;

    @ExcelProperty({"生化", "微量白蛋白"})
    private BigDecimal microalbumin;

    @ExcelProperty({"生化", "血浆渗透压"})
    private BigDecimal plasmaOsmoticPressure;

    @ExcelProperty({"生化", "肺泡-动脉血氧分压差"})
    private BigDecimal aAGradient;

    @ExcelProperty({"生化", "动脉-肺泡氧分压比值"})
    private BigDecimal aARatio;

    @ExcelProperty({"生化", "氧合指数"})
    private BigDecimal oxygenationIndex;

    @ExcelProperty({"生化", "估计血氧饱和度"})
    private BigDecimal estimatedSpo2;

    @ExcelProperty({"生化", "估计总血红蛋白"})
    private BigDecimal estimatedHb;

    @ExcelProperty({"生化", "β2-微球蛋白"})
    private BigDecimal beta2Microglobulin;

    @ExcelProperty({"生化", "超敏C反应蛋白"})
    private BigDecimal hsCrp;

    @ExcelProperty({"生化", "乙肝表面抗原"})
    private BigDecimal hbsag;

    @ExcelProperty({"生化", "乙肝表面抗体"})
    private BigDecimal antiHbs;

    @ExcelProperty({"生化", "乙肝e抗原"})
    private BigDecimal hbeag;

    @ExcelProperty({"生化", "乙肝e抗体"})
    private BigDecimal antiHbe;

    @ExcelProperty({"生化", "乙肝核心抗体"})
    private BigDecimal antiHbc;

    @ExcelProperty({"生化", "总胆固醇"})
    private BigDecimal totalCholesterol;

    @ExcelProperty({"生化", "缺血修饰白蛋白"})
    private BigDecimal ima;

    @ExcelProperty({"生化", "α-L-岩藻糖苷酶"})
    private BigDecimal afucosidase;

    // ========== 血常规 ==========
    @ExcelProperty({"血常规", "白细胞计数"})
    private BigDecimal wbcCount;

    @ExcelProperty({"血常规", "淋巴细胞百分比"})
    private BigDecimal lymphocytePercent;

    @ExcelProperty({"血常规", "中间细胞百分比"})
    private BigDecimal midCellPercent;

    @ExcelProperty({"血常规", "粒细胞百分比"})
    private BigDecimal granulocytePercent;

    @ExcelProperty({"血常规", "淋巴细胞计数"})
    private BigDecimal lymphocyteCount;

    @ExcelProperty({"血常规", "中间细胞计数"})
    private BigDecimal midCellCount;

    @ExcelProperty({"血常规", "粒细胞计数"})
    private BigDecimal granulocyteCount;

    @ExcelProperty({"血常规", "红细胞计数"})
    private BigDecimal rbcCount;

    @ExcelProperty({"血常规", "血红蛋白"})
    private BigDecimal hemoglobin;

    @ExcelProperty({"血常规", "血细胞比容"})
    private BigDecimal hematocrit;

    @ExcelProperty({"血常规", "平均红细胞体积"})
    private BigDecimal mcv;

    @ExcelProperty({"血常规", "平均红细胞血红蛋白含量"})
    private BigDecimal mch;

    @ExcelProperty({"血常规", "平均红细胞血红蛋白浓度"})
    private BigDecimal mchc;

    @ExcelProperty({"血常规", "红细胞分布宽度变异系数"})
    private BigDecimal rdwCv;

    @ExcelProperty({"血常规", "红细胞分布宽度标准差"})
    private BigDecimal rdwSd;

    @ExcelProperty({"血常规", "血小板计数"})
    private BigDecimal plateletCount;

    @ExcelProperty({"血常规", "平均血小板体积"})
    private BigDecimal mpv;

    @ExcelProperty({"血常规", "血小板分布宽度"})
    private BigDecimal pdw;

    @ExcelProperty({"血常规", "血小板压积"})
    private BigDecimal pct;

    @ExcelProperty({"血常规", "大血小板比率"})
    private BigDecimal largePlateletRatio;

    @ExcelProperty({"血常规", "大血小板计数"})
    private BigDecimal largePlateletCount;

    @ExcelProperty({"血常规", "嗜碱性粒细胞计数"})
    private BigDecimal basophilCount;

    @ExcelProperty({"血常规", "嗜碱性粒细胞百分比"})
    private BigDecimal basophilPercent;

    @ExcelProperty({"血常规", "嗜酸性粒细胞计数"})
    private BigDecimal eosinophilCount;

    @ExcelProperty({"血常规", "嗜酸性粒细胞百分比"})
    private BigDecimal eosinophilPercent;

    @ExcelProperty({"血常规", "幼稚粒细胞计数"})
    private BigDecimal immatureGranulocyteCount;

    @ExcelProperty({"血常规", "幼稚粒细胞百分比"})
    private BigDecimal immatureGranulocytePercent;

    @ExcelProperty({"血常规", "单核细胞计数"})
    private BigDecimal monocyteCount;

    @ExcelProperty({"血常规", "单核细胞百分比"})
    private BigDecimal monocytePercent;

    @ExcelProperty({"血常规", "有核红细胞计数"})
    private BigDecimal nucleatedRbcCount;

    @ExcelProperty({"血常规", "有核红细胞百分比"})
    private BigDecimal nucleatedRbcPercent;

    @ExcelProperty({"血常规", "中性粒细胞计数"})
    private BigDecimal neutrophilCount;

    @ExcelProperty({"血常规", "中性粒细胞百分比"})
    private BigDecimal neutrophilPercent;

    // ========== 凝血功能 ==========
    @ExcelProperty({"凝血功能", "活化部分凝血活酶时间"})
    private BigDecimal aptt;

    @ExcelProperty({"凝血功能", "抗凝血酶Ⅲ活性百分比"})
    private BigDecimal antithrombinIiiActivityPercent;

    @ExcelProperty({"凝血功能", "抗凝血酶Ⅲ活性（吸光度变化速率检测）"})
    private BigDecimal antithrombinIiiActivityRate;

    @ExcelProperty({"凝血功能", "D-二聚体（光密度差值检测）"})
    private BigDecimal dDimerOptDensity;

    @ExcelProperty({"凝血功能", "D-二聚体浓度"})
    private BigDecimal dDimerConcentration;

    @ExcelProperty({"凝血功能", "纤维蛋白降解产物（光密度差值检测）"})
    private BigDecimal fibrinDegradationProductsDensity;

    @ExcelProperty({"凝血功能", "纤维蛋白降解产物浓度"})
    private BigDecimal fibrinDegradationProductsConcentration;

    @ExcelProperty({"凝血功能", "纤维蛋白原浓度"})
    private BigDecimal fibrinogenConcentration;

    @ExcelProperty({"凝血功能", "纤维蛋白原凝固时间"})
    private BigDecimal fibrinogenClottingTime;

    @ExcelProperty({"凝血功能", "凝血酶原时间(百分比活动度)"})
    private BigDecimal prothrombinTimePercent;

    @ExcelProperty({"凝血功能", "凝血酶原时间-国际标准化比值"})
    private BigDecimal ptInr;

    @ExcelProperty({"凝血功能", "凝血酶原时间比值"})
    private BigDecimal prothrombinTimeRatio;

    @ExcelProperty({"凝血功能", "凝血酶原时间"})
    private BigDecimal prothrombinTime;

    @ExcelProperty({"凝血功能", "凝血酶时间"})
    private BigDecimal thrombinTime;

    @ExcelProperty({"凝血功能", "凝血酶时间(1)"})
    private BigDecimal thrombinTime1;

    @ExcelProperty({"凝血功能", "活化部分凝血活酶时间(1)"})
    private BigDecimal aptt1;

    @ExcelProperty({"凝血功能", "活化部分凝血活酶时间(2)"})
    private BigDecimal aptt2;

    @ExcelProperty({"凝血功能", "凝血酶原活动度"})
    private BigDecimal prothrombinActivity;

    @ExcelProperty({"凝血功能", "国际标准化比值"})
    private BigDecimal inr;

    // ========== 其他检查 ==========
    @ExcelProperty({"心肌肌钙蛋白I", "心肌肌钙蛋白I"})
    private String cardiacTroponinI;

    @ExcelProperty({"血管超声结果", "血管超声结果"})
    private String vascularUltrasoundResult;

    @ExcelProperty({"心电图分析结果", "心电图分析结果"})
    private String ecgAnalysisResult;

}
