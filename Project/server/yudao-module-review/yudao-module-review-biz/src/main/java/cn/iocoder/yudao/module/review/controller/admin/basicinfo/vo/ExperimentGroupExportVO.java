package cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo;

import cn.iocoder.yudao.framework.excel.core.convert.BooleanConvert;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ExcelIgnoreUnannotated
public class ExperimentGroupExportVO {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty({"基础信息", "性别"})
    private String gender;

    @ExcelProperty({"基础信息", "年龄"})
    private Integer age;

    @ExcelProperty({"基础信息", "入伍年份"})
    private Integer enlistmentYear;

    @ExcelProperty({"基础信息", "进入高原年份"})
    private Integer highlandEntryYear;

    @ExcelProperty({"基础信息", "退役年份"})
    private Integer dischargeYear;

    @ExcelProperty({"基础信息", "服役时间"})
    private Integer serviceDuration;

    @ExcelProperty({"基础信息", "服役期间职务"})
    private String servicePosition;

    @ExcelProperty({"基础信息", "学历"})
    private String highestEducation;

    @ExcelProperty({"基础信息", "生育情况"})
    private String fertilityStatus;

    @ExcelProperty({"基础信息", "民族"})
    private String ethnicity;

    @ExcelProperty({"基础信息", "身高"})
    private BigDecimal height;

    @ExcelProperty({"基础信息", "体重"})
    private BigDecimal weight;

    @ExcelProperty({"基础信息", "退役体重"})
    private BigDecimal retiredWeight;

    @ExcelProperty(value = {"吸烟情况", "吸烟", "每天吸烟数（根）"})
    private String dailySmoking;

    @ExcelProperty(value = {"吸烟情况", "吸烟", "开始吸烟年龄"})
    private Integer smokingStartAge;

    @ExcelProperty(value = {"吸烟情况", "吸烟", "烟龄"})
    private Integer smokingYears;

    @ExcelProperty(value = {"吸烟情况", "吸烟", "尝试戒烟"}, converter = BooleanConvert.class)
    private Boolean triedQuit;

    @ExcelProperty(value = {"吸烟情况", "吸烟", "高原/平原吸烟情况"})
    private String highlandPlainSmokingStatus;

    @ExcelProperty(value = {"吸烟情况", "已戒烟", "烟龄"})
    private String smokingYears2;

    @ExcelProperty(value = {"吸烟情况", "已戒烟", "戒烟时长"})
    private String quitTime;

    @ExcelProperty(value = {"吸烟情况", "已戒烟", "高原/平原吸烟情况"})
    private String highlandPlainSmokingStatus2;

    @ExcelProperty(value = {"吸烟情况", "吸烟状态"})
    private String smokingStatus;

    @ExcelProperty(value = {"饮酒情况", "是否有饮酒经历"})
    private String drinkingExperience;

    @ExcelProperty(value = {"饮酒情况", "是否仍在饮酒"}, converter = BooleanConvert.class)
    private Boolean stillDrinking;

    @ExcelProperty(value = {"饮酒情况", "饮酒频率"})
    private String drinkingFrequency;

    @ExcelProperty(value = {"饮酒情况", "饮酒类型"})
    private String drinkType;

    @ExcelProperty(value = {"饮酒情况", "是否过量饮酒"}, converter = BooleanConvert.class)
    private Boolean overDrinking;

    @ExcelProperty(value = {"自我评价", "与同龄人相比，您认为目前自己的身体健康状况如何"})
    private String healthComparisonWithPeers;

    @ExcelProperty(value = {"自我评价", "您认为自己身体健康状况能得的分数"})
    private String healthScore;

    @ExcelProperty(value = {"亲属既往疾病", "心血管循环系统"})
    private String cardiovascularCirculatorySystem;

    @ExcelProperty(value = {"亲属既往疾病", "呼吸系统"})
    private String respiratorySystem;

    @ExcelProperty(value = {"亲属既往疾病", "代谢系统"})
    private String MetabolicSystem;

    @ExcelProperty(value = {"亲属既往疾病", "消化系统"})
    private String digestiveSystem;

    @ExcelProperty(value = {"亲属既往疾病", "神经系统"})
    private String nervousSystem;

    @ExcelProperty(value = {"亲属既往疾病", "癌症"})
    private String cancer;

    @ExcelProperty(value = {"服役信息", "应用信息", "应用地点"})
    private String highlandServiceLocation;

    @ExcelProperty(value = {"服役信息", "应用信息", "应用海拔"})
    private Integer altitude;

    @ExcelProperty(value = {"服役信息", "应用信息", "应用服役时长"})
    private String serviceTime;

    @ExcelProperty(value = {"服役信息", "地点1", "服役地点"})
    private String highlandServiceLocation1;

    @ExcelProperty(value = {"服役信息", "地点1", "海拔高度"})
    private Integer altitude1;

    @ExcelProperty(value = {"服役信息", "地点1", "服役时长"})
    private String serviceTime1;

    @ExcelProperty(value = {"服役信息", "地点2", "服役地点"})
    private String highlandServiceLocation2;

    @ExcelProperty(value = {"服役信息", "地点2", "海拔高度"})
    private Integer altitude2;

    @ExcelProperty(value = {"服役信息", "地点2", "服役时长"})
    private String serviceTime2;

    @ExcelProperty(value = {"服役信息", "地点3", "服役地点"})
    private String highlandServiceLocation3;

    @ExcelProperty(value = {"服役信息", "地点3", "海拔高度"})
    private Integer altitude3;

    @ExcelProperty(value = {"服役信息", "地点3", "服役时长"})
    private String serviceTime3;

    @ExcelProperty(value = {"服役信息", "地点4", "服役地点"})
    private String highlandServiceLocation4;

    @ExcelProperty(value = {"服役信息", "地点4", "海拔高度"})
    private Integer altitude4;

    @ExcelProperty(value = {"服役信息", "地点4", "服役时长"})
    private String serviceTime4;

    @ExcelProperty(value = {"服役信息", "地点5", "服役地点"})
    private String highlandServiceLocation5;

    @ExcelProperty(value = {"服役信息", "地点5", "海拔高度"})
    private Integer altitude5;

    @ExcelProperty(value = {"服役信息", "地点5", "服役时长"})
    private String serviceTime5;

    @ExcelProperty(value = {"服役信息", "地点6", "服役地点"})
    private String highlandServiceLocation6;

    @ExcelProperty(value = {"服役信息", "地点6", "海拔高度"})
    private Integer altitude6;

    @ExcelProperty(value = {"服役信息", "地点6", "服役时长"})
    private String serviceTime6;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "从事高原任务类型"})
    private String highlandTaskType;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "诊断过高原性疾病"})
    private String highlandDiseases;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "是否发生过高原反应"}, converter = BooleanConvert.class)
    private Boolean reactionOccurred;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "高原反应次数"})
    private String reactionCountText;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "高原反应症状"})
    private String highlandReactionSymptoms;

    @ExcelProperty(value = {"高原服役期间高原反应信息", "高原反应变化情况"})
    private String multipleReactionsChanges;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "疲倦"}, converter = BooleanConvert.class)
    private Boolean fatigue;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "嗜睡"}, converter = BooleanConvert.class)
    private Boolean drowsiness;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "头昏"}, converter = BooleanConvert.class)
    private Boolean dizziness;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "眩晕"}, converter = BooleanConvert.class)
    private Boolean vertigo;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "精力不集中"}, converter = BooleanConvert.class)
    private Boolean poorConcentration;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "反应迟钝"}, converter = BooleanConvert.class)
    private Boolean slowReaction;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "记忆减退"}, converter = BooleanConvert.class)
    private Boolean memoryLoss;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "失眠"}, converter = BooleanConvert.class)
    private Boolean insomnia;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "精神及全身症状", "多梦"}, converter = BooleanConvert.class)
    private Boolean nightmares;

    // ========== 循环症状 ==========
    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "心前区痛"}, converter = BooleanConvert.class)
    private Boolean chestPain;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "心慌"}, converter = BooleanConvert.class)
    private Boolean palpitations;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "脉率减慢"}, converter = BooleanConvert.class)
    private Boolean bradycardia;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "紫绀"}, converter = BooleanConvert.class)
    private Boolean cyanosis;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "血压波动"}, converter = BooleanConvert.class)
    private Boolean bloodPressureFluctuation;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "皮肤出血"}, converter = BooleanConvert.class)
    private Boolean skinBleeding;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "皮肤瘀斑"}, converter = BooleanConvert.class)
    private Boolean skinBruising;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "循环症状", "贫血"}, converter = BooleanConvert.class)
    private Boolean anemia;

    // ========== 呼吸症状 ==========
    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "咽喉痛"}, converter = BooleanConvert.class)
    private Boolean soreThroat;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "咳嗽"}, converter = BooleanConvert.class)
    private Boolean cough;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "多痰"}, converter = BooleanConvert.class)
    private Boolean phlegm;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "气喘"}, converter = BooleanConvert.class)
    private Boolean wheezing;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "呼吸症状", "胸闷"}, converter = BooleanConvert.class)
    private Boolean chestTightness;

    // ========== 消化症状 ==========
    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "体重减轻"}, converter = BooleanConvert.class)
    private Boolean weightLoss;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "食欲增加"}, converter = BooleanConvert.class)
    private Boolean increasedAppetite;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "厌食"}, converter = BooleanConvert.class)
    private Boolean anorexia;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "便秘"}, converter = BooleanConvert.class)
    private Boolean constipation;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "腹泻"}, converter = BooleanConvert.class)
    private Boolean diarrhea;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "腹痛"}, converter = BooleanConvert.class)
    private Boolean abdominalPain;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "消化症状", "黄疸"}, converter = BooleanConvert.class)
    private Boolean jaundice;

    // ========== 其他症状 ==========
    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "手足麻木"}, converter = BooleanConvert.class)
    private Boolean numbness;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "肢体水肿"}, converter = BooleanConvert.class)
    private Boolean limbEdema;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "面部水肿"}, converter = BooleanConvert.class)
    private Boolean facialEdema;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "脱发"}, converter = BooleanConvert.class)
    private Boolean hairLoss;

    @ExcelProperty(value = {"退役后返回平原1月内症状", "其他症状", "夜尿增多"}, converter = BooleanConvert.class)
    private Boolean increasedUrination;

    @ExcelProperty(value = {"高原返回平原后基本信息", "常住地区"})
    private String residenceArea;

    @ExcelProperty(value = {"高原返回平原后基本信息", "每年居住时间"})
    private String residenceTime;

    @ExcelProperty(value = {"高原返回平原后基本信息", "工作情况"})
    private String postReturnWorkStatus;

    @ExcelProperty(value = {"高原返回平原后基本信息", "体检或就诊次数"})
    private String annualCheckups;

    @ExcelProperty(value = {"新发疾病诊断情况", "高原期间出现疾病"})
    private String highlandDiseasesDuringService;

    @ExcelProperty(value = {"新发疾病诊断情况", "返回平原后新发疾病"})
    private String newDiseasesPostReturn;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "疾病名称"})
    private String newDisease1Name;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "该病是否在二级或二级以上医院被诊断"}, converter = BooleanConvert.class)
    private Boolean diagnosed;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "诊断时间"})
    private String diagnosisDate;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "是否住院"}, converter = BooleanConvert.class)
    private Boolean hospitalized;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "是否药物治疗"}, converter = BooleanConvert.class)
    private Boolean medication;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病1", "药物治疗效果"})
    private String medicationEffect;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "疾病名称"})
    private String newDisease2Name;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "该病是否在二级或二级以上医院被诊断"}, converter = BooleanConvert.class)
    private Boolean diagnosed2;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "诊断时间"})
    private String diagnosisDate2;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "是否住院"}, converter = BooleanConvert.class)
    private Boolean hospitalized2;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "是否药物治疗"}, converter = BooleanConvert.class)
    private Boolean medication2;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病2", "药物治疗效果"})
    private String medicationEffect2;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "疾病名称"})
    private String newDisease3Name;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "该病是否在二级或二级以上医院被诊断"}, converter = BooleanConvert.class)
    private Boolean diagnosed3;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "诊断时间"})
    private String diagnosisDate3;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "是否住院"}, converter = BooleanConvert.class)
    private Boolean hospitalized3;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "是否药物治疗"}, converter = BooleanConvert.class)
    private Boolean medication3;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病3", "药物治疗效果"})
    private String medicationEffect3;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "疾病名称"})
    private String newDisease4Name;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "该病是否在二级或二级以上医院被诊断"}, converter = BooleanConvert.class)
    private Boolean diagnosed4;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "诊断时间"})
    private String diagnosisDate4;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "是否住院"}, converter = BooleanConvert.class)
    private Boolean hospitalized4;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "是否药物治疗"}, converter = BooleanConvert.class)
    private Boolean medication4;

    @ExcelProperty(value = {"新发疾病诊断情况", "新发疾病4", "药物治疗效果"})
    private String medicationEffect4;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "是否有规律锻炼"}, converter = BooleanConvert.class)
    private Boolean regularExercise;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "锻炼频率"})
    private String exerciseFrequency;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "每次锻炼时长"})
    private String exerciseDuration;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "体育锻炼形式"})
    private String exerciseType;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "胸闷、气促"}, converter = BooleanConvert.class)
    private Boolean chestPainOrShortness;

    @ExcelProperty(value = {"返回平原后体育锻炼情况", "医生指导下体育锻炼"}, converter = BooleanConvert.class)
    private Boolean doctorGuidedExercise;

    @ExcelProperty(value = {"返回平原后饮食习惯", "饮食情况"})
    private String eatingHabits;

    @ExcelProperty(value = {"返回平原后饮食习惯", "平时饮用饮料"})
    private String dietType;

    @ExcelProperty(value = {"近一周睡眠情况", "晚上睡觉时间(点)"})
    private String sleepTimeStart;

    @ExcelProperty(value = {"近一周睡眠情况", "入睡需要时间（分钟）"})
    private String sleepOnsetTime;

    @ExcelProperty(value = {"近一周睡眠情况", "起床时间(点)"})
    private String wakeTime;

    @ExcelProperty(value = {"近一周睡眠情况", "实际睡眠时间（小时）"})
    private String actualSleepDuration;

    @ExcelProperty(value = {"近一周睡眠情况", "影响睡眠烦恼原因"})
    private String reasonsAffectingSleep;

    @ExcelProperty(value = {"近一周睡眠情况", "催眠药使用情况"})
    private String sleepAids;

    @ExcelProperty(value = {"近一周睡眠情况", "感到困倦"})
    private String sleepFatigue;

    @ExcelProperty(value = {"近一周睡眠情况", "精力不足"})
    private String lackOfEnergy;

    @ExcelProperty(value = {"近一周睡眠情况", "自评睡眠情况"})
    private String selfAssessmentSleep;

    // 疾病谱
    @ExcelProperty(value = {"疾病谱", "消化系统"})
    private String diseaseSpectrumDigestiveSystem;

    @ExcelProperty(value = {"疾病谱", "心血管系统"})
    private String diseaseSpectrumCardiovascularSystem;

    @ExcelProperty(value = {"疾病谱", "内分泌系统"})
    private String diseaseSpectrumEndocrineSystem;

    @ExcelProperty(value = {"疾病谱", "呼吸系统"})
    private String diseaseSpectrumRespiratorySystem;

    @ExcelProperty(value = {"疾病谱", "泌尿系统"})
    private String diseaseSpectrumUrinarySystem;

    @ExcelProperty(value = {"疾病谱", "骨骼系统"})
    private String diseaseSpectrumSkeletalSystem;

    @ExcelProperty(value = {"疾病谱", "神经系统"})
    private String diseaseSpectrumNervousSystem;

    // Framingham评分
    @ExcelProperty(value = {"Framingham评分", "Framingham评分（分）"})
    private Integer framinghamScore;

    @ExcelProperty(value = {"Framingham评分", "Framingham概率"})
    private BigDecimal framinghamRisk;

    @ExcelProperty(value = {"Framingham评分", "Framingham分类"})
    private String framinghamRiskType;

    // 腹部超声
    @ExcelProperty(value = {"腹部超声", "腹部超声-描述"})
    private String ultrasoundDescription;

    @ExcelProperty(value = {"腹部超声", "腹部超声-小结"})
    private String ultrasoundSummary;

    // 基本检测信息
    @ExcelProperty(value = {"基本检测信息", "收缩压(mmHg)"})
    private BigDecimal systolicPressure;

    @ExcelProperty(value = {"基本检测信息", "舒张压(mmHg)"})
    private BigDecimal diastolicPressure;

    @ExcelProperty(value = {"基本检测信息", "脉搏(次/分)"})
    private Integer pulse;

    @ExcelProperty(value = {"基本检测信息", "身高(CM)"})
    private BigDecimal testsHeight;

    @ExcelProperty(value = {"基本检测信息", "体重(KG)"})
    private BigDecimal testsWeight;

    @ExcelProperty(value = {"基本检测信息", "体重指数(kg/m^2)"})
    private BigDecimal bmi;

    // 生化
    @ExcelProperty(value = {"生化", "尿素"})
    private BigDecimal urea;

    @ExcelProperty(value = {"生化", "肌酐"})
    private BigDecimal creatinine;

    @ExcelProperty(value = {"生化", "谷丙转氨酶"})
    private BigDecimal alt;

    @ExcelProperty(value = {"生化", "谷草转氨酶"})
    private BigDecimal ast;

    @ExcelProperty(value = {"生化", "总胆固醇"})
    private BigDecimal totalCholesterol;

    @ExcelProperty(value = {"生化", "甘油三酯"})
    private BigDecimal triglycerides;

    @ExcelProperty(value = {"生化", "高密度脂蛋白胆固醇"})
    private BigDecimal hdlC;

    @ExcelProperty(value = {"生化", "低密度脂蛋白胆固醇"})
    private BigDecimal ldlC;

    @ExcelProperty(value = {"生化", "尿酸"})
    private BigDecimal uricAcid;

    @ExcelProperty(value = {"生化", "总蛋白"})
    private BigDecimal totalProtein;

    @ExcelProperty(value = {"生化", "白蛋白"})
    private BigDecimal albumin;

    @ExcelProperty(value = {"生化", "球蛋白"})
    private BigDecimal globulin;

    @ExcelProperty(value = {"生化", "白球比例"})
    private BigDecimal albGlobRatio;

    @ExcelProperty(value = {"生化", "总胆红素"})
    private BigDecimal totalBilirubin;

    @ExcelProperty(value = {"生化", "直接胆红素"})
    private BigDecimal directBilirubin;

    @ExcelProperty(value = {"生化", "间接胆红素"})
    private BigDecimal indirectBilirubin;

    @ExcelProperty(value = {"生化", "糖化血红蛋白"})
    private BigDecimal glycatedHemoglobin;

    @ExcelProperty(value = {"生化", "钾"})
    private BigDecimal potassium;

    @ExcelProperty(value = {"生化", "钠"})
    private BigDecimal sodium;

    @ExcelProperty(value = {"生化", "氯"})
    private BigDecimal chloride;

    @ExcelProperty(value = {"生化", "钙"})
    private BigDecimal calcium;

    @ExcelProperty(value = {"生化", "磷"})
    private BigDecimal phosphorus;

    @ExcelProperty(value = {"生化", "镁"})
    private BigDecimal magnesium;

    @ExcelProperty(value = {"生化", "葡萄糖空腹"})
    private BigDecimal fastingGlucose;

    @ExcelProperty(value = {"生化", "凝血酶原时间"})
    private BigDecimal prothrombinTime;

    @ExcelProperty(value = {"生化", "凝血酶原活动度"})
    private BigDecimal prothrombinActivity;

    @ExcelProperty(value = {"生化", "国际标准化比率"})
    private BigDecimal inr;

    @ExcelProperty(value = {"生化", "纤维蛋白原"})
    private BigDecimal fibrinogen;

    @ExcelProperty(value = {"生化", "活化部分凝血活酶时间"})
    private BigDecimal aptt;

    @ExcelProperty(value = {"生化", "凝血酶时间"})
    private BigDecimal thrombinTime;

    // 血常规
    @ExcelProperty(value = {"血常规", "白细胞计数"})
    private BigDecimal wbc;

    @ExcelProperty(value = {"血常规", "红细胞计数"})
    private BigDecimal rbc;

    @ExcelProperty(value = {"血常规", "血红蛋白浓度"})
    private BigDecimal hemoglobin;

    @ExcelProperty(value = {"血常规", "红细胞比容"})
    private BigDecimal hematocrit;

    @ExcelProperty(value = {"血常规", "平均红细胞容积"})
    private BigDecimal mcv;

    @ExcelProperty(value = {"血常规", "平均红细胞血红蛋白含量"})
    private BigDecimal mch;

    @ExcelProperty(value = {"血常规", "平均红细胞血红蛋白浓度"})
    private BigDecimal mchc;

    @ExcelProperty(value = {"血常规", "RBC分布宽度CV值"})
    private BigDecimal rdwCv;

    @ExcelProperty(value = {"血常规", "RBC分布宽度SD值"})
    private BigDecimal rdwSd;

    @ExcelProperty(value = {"血常规", "血小板计数"})
    private BigDecimal plateletCount;

    @ExcelProperty(value = {"血常规", "血小板比容"})
    private BigDecimal plateletCrit;

    @ExcelProperty(value = {"血常规", "平均血小板体积"})
    private BigDecimal mpv;

    @ExcelProperty(value = {"血常规", "血小板分布宽度"})
    private BigDecimal pdw;

    @ExcelProperty(value = {"血常规", "中性粒细胞计数"})
    private BigDecimal neutrophils;

    @ExcelProperty(value = {"血常规", "淋巴细胞计数"})
    private BigDecimal lymphocytes;

    @ExcelProperty(value = {"血常规", "单核细胞计数"})
    private BigDecimal monocytes;

    @ExcelProperty(value = {"血常规", "嗜酸性粒细胞计数"})
    private BigDecimal eosinophils;

    @ExcelProperty(value = {"血常规", "嗜碱性粒细胞计数"})
    private BigDecimal basophils;

    @ExcelProperty(value = {"血常规", "中性粒细胞百分率"})
    private BigDecimal neutrophilsPercentage;

    @ExcelProperty(value = {"血常规", "淋巴细胞百分率"})
    private BigDecimal lymphocytesPercentage;

    @ExcelProperty(value = {"血常规", "单核细胞百分率"})
    private BigDecimal monocytesPercentage;

    @ExcelProperty(value = {"血常规", "嗜酸性粒细胞百分率"})
    private BigDecimal eosinophilsPercentage;

    @ExcelProperty(value = {"血常规", "嗜碱性粒细胞百分率"})
    private BigDecimal basophilsPercentage;

    // 心电图
    @ExcelProperty(value = {"心电图", "心电图描述"})
    private String ecgDescription;

    // 既往病史
    @ExcelProperty(value = {"既往病史", "内科既往病史"})
    private String internalDiseaseHistory;

    @ExcelProperty(value = {"既往病史", "外科既往病史"})
    private String externalDiseaseHistory;
}
