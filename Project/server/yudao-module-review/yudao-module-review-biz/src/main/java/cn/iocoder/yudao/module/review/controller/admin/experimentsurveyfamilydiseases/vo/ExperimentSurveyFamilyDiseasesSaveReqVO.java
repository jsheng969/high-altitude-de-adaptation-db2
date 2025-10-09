package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-亲属既往疾病新增/修改 Request VO")
@Data
public class ExperimentSurveyFamilyDiseasesSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3307")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "29820")
    @NotNull(message = "基础信息id不能为空")
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

    @Schema(description = "冠心病/心绞痛")
    private Boolean coronaryHeartDisease;

    @Schema(description = "心肌梗塞")
    private Boolean myocardialInfarction;

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

    @Schema(description = "其他 1")
    private Boolean otherDiseases1;

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

    @Schema(description = "其他 2")
    private Boolean otherDiseases2;

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

    @Schema(description = "其他 3")
    private Boolean otherDiseases3;

    @Schema(description = "老年痴呆")
    private Boolean dementia;

    @Schema(description = "帕金森综合征")
    private Boolean parkinsonsDisease;

    @Schema(description = "多发性硬化病")
    private Boolean multipleSclerosis;

    @Schema(description = "癫痫")
    private Boolean epilepsy;

    @Schema(description = "肺癌")
    private Boolean lungCancer;

    @Schema(description = "肝癌")
    private Boolean liverCancer;

    @Schema(description = "胃癌")
    private Boolean gastricCancer;

    @Schema(description = "直/结肠癌")
    private Boolean colonCancer;

    @Schema(description = "胰腺癌")
    private Boolean pancreaticCancer;

    @Schema(description = "食管癌")
    private Boolean esophagealCancer;

    @Schema(description = "前列腺癌")
    private Boolean prostateCancer;

    @Schema(description = "乳腺癌")
    private Boolean breastCancer;

    @Schema(description = "宫颈癌")
    private Boolean cervicalCancer;

    @Schema(description = "其他 4")
    private Boolean otherDiseases4;

}