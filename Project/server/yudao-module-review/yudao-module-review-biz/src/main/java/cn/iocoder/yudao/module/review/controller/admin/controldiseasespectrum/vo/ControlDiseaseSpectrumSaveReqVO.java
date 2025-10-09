package cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 实验组-疾病谱新增/修改 Request VO")
@Data
public class ControlDiseaseSpectrumSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16978")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2673")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "脂肪肝")
    private Boolean fattyLiver;

    @Schema(description = "肝囊肿")
    private Boolean hepaticCyst;

    @Schema(description = "胆囊息肉")
    private Boolean gallbladderPolyp;

    @Schema(description = "胆囊结石")
    private Boolean gallbladderStone;

    @Schema(description = "肝血管瘤")
    private Boolean hepaticHemangioma;

    @Schema(description = "脾大")
    private Boolean splenomegaly;

    @Schema(description = "慢性胃炎")
    private Boolean chronicGastritis;

    @Schema(description = "肠息肉")
    private Boolean intestinalPolyp;

    @Schema(description = "阑尾炎")
    private Boolean appendicitis;

    @Schema(description = "急性胰腺炎")
    private Boolean acutePancreatitis;

    @Schema(description = "消化道溃疡")
    private Boolean digestiveUlcer;

    @Schema(description = "消化道出血")
    private Boolean digestiveBleeding;

    @Schema(description = "高血压")
    private Boolean hypertension;

    @Schema(description = "窦性心动过缓")
    private Boolean bradycardia;

    @Schema(description = "短暂性脑缺血")
    private Boolean transientIschemicAttack;

    @Schema(description = "窦性心动过速")
    private Boolean tachycardia;

    @Schema(description = "脑梗死/脑血栓")
    private Boolean cerebralInfarction;

    @Schema(description = "频发房性早搏")
    private Boolean frequentPrematureAtrialContractions;

    @Schema(description = "频发室性早搏")
    private Boolean frequentPrematureVentricularContractions;

    @Schema(description = "冠心病")
    private Boolean coronaryHeartDisease;

    @Schema(description = "房颤")
    private Boolean atrialFibrillation;

    @Schema(description = "心肌梗死")
    private Boolean myocardialInfarction;

    @Schema(description = "高甘油三酯血症")
    private Boolean hypertriglyceridemia;

    @Schema(description = "低密度脂蛋白胆固醇增多症")
    private Boolean highLdl;

    @Schema(description = "高密度脂蛋白胆固醇增多症")
    private Boolean highHdl;

    @Schema(description = "高尿酸血症")
    private Boolean hyperuricemia;

    @Schema(description = "高胆固醇血症")
    private Boolean hypercholesterolemia;

    @Schema(description = "糖尿病")
    private Boolean diabetes;

    @Schema(description = "甲状腺疾病")
    private Boolean thyroidDisease;

    @Schema(description = "肺结节")
    private Boolean lungNodule;

    @Schema(description = "肺气肿")
    private Boolean pulmonaryEmphysema;

    @Schema(description = "慢阻肺")
    private Boolean copd;

    @Schema(description = "哮喘")
    private Boolean asthma;

    @Schema(description = "肾结石")
    private Boolean kidneyStone;

    @Schema(description = "肾囊肿")
    private Boolean renalCyst;

    @Schema(description = "前列腺炎")
    private Boolean prostatitis;

    @Schema(description = "腰椎病")
    private Boolean lumbarSpondylosis;

    @Schema(description = "颈椎病")
    private Boolean cervicalSpondylosis;

    @Schema(description = "失眠")
    private Boolean insomnia;

}