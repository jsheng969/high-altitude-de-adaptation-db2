package cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组体检-生化v2 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentExamBiochemicalTestsV2RespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "18169")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "20098")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "谷丙转氨酶")
    @ExcelProperty("谷丙转氨酶")
    private BigDecimal alt;

    @Schema(description = "谷草转氨酶")
    @ExcelProperty("谷草转氨酶")
    private BigDecimal ast;

    @Schema(description = "谷草转氨酶与谷丙转氨酶比值")
    @ExcelProperty("谷草转氨酶与谷丙转氨酶比值")
    private BigDecimal astAltRatio;

    @Schema(description = "总蛋白")
    @ExcelProperty("总蛋白")
    private BigDecimal totalProtein;

    @Schema(description = "白蛋白")
    @ExcelProperty("白蛋白")
    private BigDecimal albumin;

    @Schema(description = "球蛋白")
    @ExcelProperty("球蛋白")
    private BigDecimal globulin;

    @Schema(description = "白球比")
    @ExcelProperty("白球比")
    private BigDecimal albGlobRatio;

    @Schema(description = "总胆红素")
    @ExcelProperty("总胆红素")
    private BigDecimal totalBilirubin;

    @Schema(description = "直接胆红素")
    @ExcelProperty("直接胆红素")
    private BigDecimal directBilirubin;

    @Schema(description = "间接胆红素")
    @ExcelProperty("间接胆红素")
    private BigDecimal indirectBilirubin;

    @Schema(description = "碱性磷酸酶")
    @ExcelProperty("碱性磷酸酶")
    private BigDecimal alkalinePhosphatase;

    @Schema(description = "谷氨酰转肽酶")
    @ExcelProperty("谷氨酰转肽酶")
    private BigDecimal ggt;

    @Schema(description = "总胆汁酸", example = "31137")
    @ExcelProperty("总胆汁酸")
    private BigDecimal totalBileAcid;

    @Schema(description = "胆碱酯酶")
    @ExcelProperty("胆碱酯酶")
    private BigDecimal cholinesterase;

    @Schema(description = "前白蛋白")
    @ExcelProperty("前白蛋白")
    private BigDecimal prealbumin;

    @Schema(description = "尿素")
    @ExcelProperty("尿素")
    private BigDecimal urea;

    @Schema(description = "肌酐")
    @ExcelProperty("肌酐")
    private BigDecimal creatinine;

    @Schema(description = "尿酸", example = "10478")
    @ExcelProperty("尿酸")
    private BigDecimal uricAcid;

    @Schema(description = "甘油三酯")
    @ExcelProperty("甘油三酯")
    private BigDecimal triglycerides;

    @Schema(description = "胆固醇")
    @ExcelProperty("胆固醇")
    private BigDecimal cholesterol;

    @Schema(description = "高密度脂蛋白")
    @ExcelProperty("高密度脂蛋白")
    private BigDecimal hdlC;

    @Schema(description = "低密度脂蛋白")
    @ExcelProperty("低密度脂蛋白")
    private BigDecimal ldlC;

    @Schema(description = "载脂蛋白A")
    @ExcelProperty("载脂蛋白A")
    private BigDecimal apoa;

    @Schema(description = "载脂蛋白B")
    @ExcelProperty("载脂蛋白B")
    private BigDecimal apob;

    @Schema(description = "脂蛋白a")
    @ExcelProperty("脂蛋白a")
    private BigDecimal lpa;

    @Schema(description = "葡萄糖")
    @ExcelProperty("葡萄糖")
    private BigDecimal glucose;

    @Schema(description = "肌酸激酶")
    @ExcelProperty("肌酸激酶")
    private BigDecimal ck;

    @Schema(description = "肌酸激酶同工酶MB")
    @ExcelProperty("肌酸激酶同工酶MB")
    private BigDecimal ckMb;

    @Schema(description = "α-羟丁酸脱氢酶")
    @ExcelProperty("α-羟丁酸脱氢酶")
    private BigDecimal alphaHbdh;

    @Schema(description = "乳酸脱氢酶")
    @ExcelProperty("乳酸脱氢酶")
    private BigDecimal ldh;

    @Schema(description = "C-反应蛋白")
    @ExcelProperty("C-反应蛋白")
    private BigDecimal crp;

    @Schema(description = "免疫球蛋白G")
    @ExcelProperty("免疫球蛋白G")
    private BigDecimal igg;

    @Schema(description = "免疫球蛋白A")
    @ExcelProperty("免疫球蛋白A")
    private BigDecimal iga;

    @Schema(description = "免疫球蛋白M")
    @ExcelProperty("免疫球蛋白M")
    private BigDecimal igm;

    @Schema(description = "补体3")
    @ExcelProperty("补体3")
    private BigDecimal complement3;

    @Schema(description = "补体4")
    @ExcelProperty("补体4")
    private BigDecimal complement4;

    @Schema(description = "肌红蛋白")
    @ExcelProperty("肌红蛋白")
    private BigDecimal myoglobin;

    @Schema(description = "小而密低密度脂蛋白")
    @ExcelProperty("小而密低密度脂蛋白")
    private BigDecimal smallDenseLdl;

    @Schema(description = "同型半胱氨酸")
    @ExcelProperty("同型半胱氨酸")
    private BigDecimal homocysteine;

    @Schema(description = "5-核苷酸酶")
    @ExcelProperty("5-核苷酸酶")
    private BigDecimal nucleotidase;

    @Schema(description = "腺苷脱氨酶")
    @ExcelProperty("腺苷脱氨酶")
    private BigDecimal ada;

    @Schema(description = "淀粉酶")
    @ExcelProperty("淀粉酶")
    private BigDecimal amylase;

    @Schema(description = "阴离子间隙")
    @ExcelProperty("阴离子间隙")
    private BigDecimal anionGap;

    @Schema(description = "缓冲碱")
    @ExcelProperty("缓冲碱")
    private BigDecimal bufferBase;

    @Schema(description = "碳酸氢盐")
    @ExcelProperty("碳酸氢盐")
    private BigDecimal bicarbonate;

    @Schema(description = "碱剩余")
    @ExcelProperty("碱剩余")
    private BigDecimal baseExcess;

    @Schema(description = "细胞外液碱剩余")
    @ExcelProperty("细胞外液碱剩余")
    private BigDecimal extracellularBe;

    @Schema(description = "血尿素")
    @ExcelProperty("血尿素")
    private BigDecimal bloodUrea;

    @Schema(description = "血尿素氮")
    @ExcelProperty("血尿素氮")
    private BigDecimal bun;

    @Schema(description = "钙")
    @ExcelProperty("钙")
    private BigDecimal calcium;

    @Schema(description = "氯")
    @ExcelProperty("氯")
    private BigDecimal chloride;

    @Schema(description = "胱抑素C")
    @ExcelProperty("胱抑素C")
    private BigDecimal cystatinC;

    @Schema(description = "铁")
    @ExcelProperty("铁")
    private BigDecimal iron;

    @Schema(description = "实际碳酸氢盐")
    @ExcelProperty("实际碳酸氢盐")
    private BigDecimal actualBicarbonate;

    @Schema(description = "标准碳酸氢盐")
    @ExcelProperty("标准碳酸氢盐")
    private BigDecimal standardBicarbonate;

    @Schema(description = "钾")
    @ExcelProperty("钾")
    private BigDecimal potassium;

    @Schema(description = "镁")
    @ExcelProperty("镁")
    private BigDecimal magnesium;

    @Schema(description = "钠")
    @ExcelProperty("钠")
    private BigDecimal sodium;

    @Schema(description = "磷")
    @ExcelProperty("磷")
    private BigDecimal phosphorus;

    @Schema(description = "二氧化碳分压")
    @ExcelProperty("二氧化碳分压")
    private BigDecimal pco2;

    @Schema(description = "酸碱度")
    @ExcelProperty("酸碱度")
    private BigDecimal ph;

    @Schema(description = "氧分压")
    @ExcelProperty("氧分压")
    private BigDecimal po2;

    @Schema(description = "视黄醇结合蛋白")
    @ExcelProperty("视黄醇结合蛋白")
    private BigDecimal rbp;

    @Schema(description = "肾素活性")
    @ExcelProperty("肾素活性")
    private BigDecimal reninActivity;

    @Schema(description = "氢离子浓度")
    @ExcelProperty("氢离子浓度")
    private BigDecimal hydrogenIonConcentration;

    @Schema(description = "二氧化碳总量")
    @ExcelProperty("二氧化碳总量")
    private BigDecimal tco2;

    @Schema(description = "乳酸", example = "31906")
    @ExcelProperty("乳酸")
    private BigDecimal lacticAcid;

    @Schema(description = "微量白蛋白")
    @ExcelProperty("微量白蛋白")
    private BigDecimal microalbumin;

    @Schema(description = "血浆渗透压")
    @ExcelProperty("血浆渗透压")
    private BigDecimal plasmaOsmoticPressure;

    @Schema(description = "肺泡-动脉血氧分压差")
    @ExcelProperty("肺泡-动脉血氧分压差")
    private BigDecimal aAGradient;

    @Schema(description = "动脉-肺泡氧分压比值")
    @ExcelProperty("动脉-肺泡氧分压比值")
    private BigDecimal aARatio;

    @Schema(description = "氧合指数")
    @ExcelProperty("氧合指数")
    private BigDecimal oxygenationIndex;

    @Schema(description = "估计血氧饱和度")
    @ExcelProperty("估计血氧饱和度")
    private BigDecimal estimatedSpo2;

    @Schema(description = "估计总血红蛋白")
    @ExcelProperty("估计总血红蛋白")
    private BigDecimal estimatedHb;

    @Schema(description = "β2-微球蛋白")
    @ExcelProperty("β2-微球蛋白")
    private BigDecimal beta2Microglobulin;

    @Schema(description = "超敏C反应蛋白")
    @ExcelProperty("超敏C反应蛋白")
    private BigDecimal hsCrp;

    @Schema(description = "乙肝表面抗原")
    @ExcelProperty("乙肝表面抗原")
    private BigDecimal hbsag;

    @Schema(description = "乙肝表面抗体")
    @ExcelProperty("乙肝表面抗体")
    private BigDecimal antiHbs;

    @Schema(description = "乙肝e抗原")
    @ExcelProperty("乙肝e抗原")
    private BigDecimal hbeag;

    @Schema(description = "乙肝e抗体")
    @ExcelProperty("乙肝e抗体")
    private BigDecimal antiHbe;

    @Schema(description = "乙肝核心抗体")
    @ExcelProperty("乙肝核心抗体")
    private BigDecimal antiHbc;

    @Schema(description = "总胆固醇")
    @ExcelProperty("总胆固醇")
    private BigDecimal totalCholesterol;

    @Schema(description = "缺血修饰白蛋白")
    @ExcelProperty("缺血修饰白蛋白")
    private BigDecimal ima;

    @Schema(description = "α-L-岩藻糖苷酶")
    @ExcelProperty("α-L-岩藻糖苷酶")
    private BigDecimal afucosidase;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

}