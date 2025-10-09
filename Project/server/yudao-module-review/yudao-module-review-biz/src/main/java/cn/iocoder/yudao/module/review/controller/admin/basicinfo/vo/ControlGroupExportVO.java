package cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo;

import cn.iocoder.yudao.framework.excel.core.convert.BooleanConvert;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ExcelIgnoreUnannotated
public class ControlGroupExportVO {

    // 基础信息
    @ExcelProperty(value = {"基础信息", "姓名"})
    private String name;

    @ExcelProperty(value = {"基础信息", "性别"})
    private String gender;

    @ExcelProperty(value = {"基础信息", "年龄"})
    private Integer age;

//    @ExcelProperty(value = {"基础信息", "入伍年份"})
//    private Integer enlistmentYear;
//
//    @ExcelProperty(value = {"基础信息", "进入高原年份"})
//    private Integer highlandEntryYear;
//
//    @ExcelProperty(value = {"基础信息", "退役年份"})
//    private Integer dischargeYear;
//
//    @ExcelProperty(value = {"基础信息", "服役时间"})
//    private Integer serviceDuration;
//
//    @ExcelProperty(value = {"基础信息", "服役期间职务"})
//    private String servicePosition;

    @ExcelProperty(value = {"基础信息", "学历"})
    private String highestEducation;

    @ExcelProperty(value = {"基础信息", "生育情况"})
    private String fertilityStatus;

    @ExcelProperty(value = {"基础信息", "民族"})
    private String ethnicity;

    @ExcelProperty(value = {"基础信息", "身高"})
    private BigDecimal height;

    @ExcelProperty(value = {"基础信息", "体重"})
    private BigDecimal weight;

    @ExcelProperty(value = {"基础信息", "退役体重"})
    private BigDecimal retiredWeight;

    // 饮酒情况
    @ExcelProperty(value = {"饮酒情况", "饮酒经历"})
    private String drinkingExperience;

    @ExcelProperty(value = {"饮酒情况", "饮酒频率"})
    private String drinkingFrequency;

    // 既往疾病 - 疾病1
    @ExcelProperty(value = {"既往疾病", "疾病1名称"})
    private String disease1Name;

    @ExcelProperty(value = {"既往疾病", "疾病1是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease1Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病1确诊时间"})
    private String disease1DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病1是否住院"}, converter = BooleanConvert.class)
    private Boolean disease1Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病1是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease1Treated;

    @ExcelProperty(value = {"既往疾病", "疾病1治疗效果"})
    private String disease1TreatmentEffect;

    // 疾病2
    @ExcelProperty(value = {"既往疾病", "疾病2名称"})
    private String disease2Name;

    @ExcelProperty(value = {"既往疾病", "疾病2是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease2Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病2确诊时间"})
    private String disease2DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病2是否住院"}, converter = BooleanConvert.class)
    private Boolean disease2Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病2是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease2Treated;

    @ExcelProperty(value = {"既往疾病", "疾病2治疗效果"})
    private String disease2TreatmentEffect;

    // 疾病3
    @ExcelProperty(value = {"既往疾病", "疾病3名称"})
    private String disease3Name;

    @ExcelProperty(value = {"既往疾病", "疾病3是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease3Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病3确诊时间"})
    private String disease3DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病3是否住院"}, converter = BooleanConvert.class)
    private Boolean disease3Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病3是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease3Treated;

    @ExcelProperty(value = {"既往疾病", "疾病3治疗效果"})
    private String disease3TreatmentEffect;

    // 疾病4
    @ExcelProperty(value = {"既往疾病", "疾病4名称"})
    private String disease4Name;

    @ExcelProperty(value = {"既往疾病", "疾病4是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease4Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病4确诊时间"})
    private String disease4DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病4是否住院"}, converter = BooleanConvert.class)
    private Boolean disease4Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病4是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease4Treated;

    @ExcelProperty(value = {"既往疾病", "疾病4治疗效果"})
    private String disease4TreatmentEffect;

    // 疾病5
    @ExcelProperty(value = {"既往疾病", "疾病5名称"})
    private String disease5Name;

    @ExcelProperty(value = {"既往疾病", "疾病5是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease5Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病5确诊时间"})
    private String disease5DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病5是否住院"}, converter = BooleanConvert.class)
    private Boolean disease5Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病5是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease5Treated;

    @ExcelProperty(value = {"既往疾病", "疾病5治疗效果"})
    private String disease5TreatmentEffect;

    // 疾病6
    @ExcelProperty(value = {"既往疾病", "疾病6名称"})
    private String disease6Name;

    @ExcelProperty(value = {"既往疾病", "疾病6是否确诊"}, converter = BooleanConvert.class)
    private Boolean disease6Diagnosed;

    @ExcelProperty(value = {"既往疾病", "疾病6确诊时间"})
    private String disease6DiagnosisDate;

    @ExcelProperty(value = {"既往疾病", "疾病6是否住院"}, converter = BooleanConvert.class)
    private Boolean disease6Hospitalized;

    @ExcelProperty(value = {"既往疾病", "疾病6是否治疗"}, converter = BooleanConvert.class)
    private Boolean disease6Treated;

    @ExcelProperty(value = {"既往疾病", "疾病6治疗效果"})
    private String disease6TreatmentEffect;

    // 旅居信息
    @ExcelProperty(value = {"旅居信息", "高原经历"})
    private String highlandExperience;

    @ExcelProperty(value = {"旅居信息", "长期平原经历"})
    private String longTermPlainExperience;

    @ExcelProperty(value = {"旅居信息", "常住地1"})
    private String residence1;

    @ExcelProperty(value = {"旅居信息", "常住地2"})
    private String residence2;

    @ExcelProperty(value = {"旅居信息", "常住地3"})
    private String residence3;

    // 自我评价
    @ExcelProperty(value = {"自我评价", "每年体检/就诊次数"})
    private String annualCheckups;

    @ExcelProperty(value = {"自我评价", "与同龄人相比，您认为目前自己的身体健康状况如何"})
    private String healthComparison;

    @ExcelProperty(value = {"自我评价", "您认为自己身体健康状况能得________分"})
    private Integer healthScore;

    // 吸烟情况
    @ExcelProperty(value = {"吸烟情况", "是否吸烟"})
    private String smokingStatus;

    @ExcelProperty(value = {"吸烟情况", "烟龄"})
    private Integer smokingYears;

    @ExcelProperty(value = {"吸烟情况", "是否尝试戒烟"})
    private String triedQuit;

    @ExcelProperty(value = {"吸烟情况", "戒烟时间"})
    private String quitTime;

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
