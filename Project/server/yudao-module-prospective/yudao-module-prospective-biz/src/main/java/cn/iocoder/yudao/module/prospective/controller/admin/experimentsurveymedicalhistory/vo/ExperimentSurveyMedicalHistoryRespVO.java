package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 既往疾病史 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyMedicalHistoryRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19064")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "14594")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "高血压")
    private Boolean hypertension;

    @Schema(description = "高血脂")
    private Boolean hyperlipidemia;

    @Schema(description = "先天性心脏病")
    private Boolean congenitalHeartDisease;

    @Schema(description = "肺心病")
    private Boolean pulmonaryHeartDisease;

    @Schema(description = "中风/脑溢血")
    private Boolean stroke;

    @Schema(description = "窦性心动过速")
    private Boolean sinusTachycardia;

    @Schema(description = "频发房性早搏")
    private Boolean frequentAtrialPremature;

    @Schema(description = "冠心病/心绞痛")
    private Boolean coronaryHeartDisease;

    @Schema(description = "窦性心律不齐")
    private Boolean sinusArrhythmia;

    @Schema(description = "频发室性早搏")
    private Boolean frequentVentricularPremature;

    @Schema(description = "心肌梗塞")
    private Boolean myocardialInfarction;

    @Schema(description = "房颤")
    private Boolean atrialFibrillation;

    @Schema(description = "房室传导阻滞")
    private Boolean atrioventricularBlock;

    @Schema(description = "窦性心动过缓")
    private Boolean sinusBradycardia;

    @Schema(description = "阵发性室上速")
    private Boolean paroxysmalSupraventricularTachycardia;

    @Schema(description = "室性心动过速")
    private Boolean ventricularTachycardia;

    @Schema(description = "慢性支气管炎")
    private Boolean chronicBronchitis;

    @Schema(description = "哮喘")
    private Boolean asthma;

    @Schema(description = "肺结核")
    private Boolean tuberculosis;

    @Schema(description = "肺气肿")
    private Boolean emphysema;

    @Schema(description = "肺炎")
    private Boolean pneumonia;

    @Schema(description = "慢性阻塞性肺疾病")
    private Boolean copd;

    @Schema(description = "甲状腺疾病")
    private Boolean thyroidDisease;

    @Schema(description = "糖尿病")
    private Boolean diabetes;

    @Schema(description = "高尿酸血症（痛风）")
    private Boolean gout;

    @Schema(description = "慢性肠胃炎")
    private Boolean chronicGastroenteritis;

    @Schema(description = "十二指肠溃疡")
    private Boolean duodenalUlcer;

    @Schema(description = "胃溃疡")
    private Boolean gastricUlcer;

    @Schema(description = "胆结石")
    private Boolean gallstones;

    @Schema(description = "结肠息肉")
    private Boolean colonPolyps;

    @Schema(description = "乙型肝炎")
    private Boolean hepatitisB;

    @Schema(description = "胆囊炎")
    private Boolean cholecystitis;

    @Schema(description = "癫痫")
    private Boolean epilepsy;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

    @Schema(description = "既往疾病史")
    @ExcelProperty("既往疾病史")
    private String description;

}