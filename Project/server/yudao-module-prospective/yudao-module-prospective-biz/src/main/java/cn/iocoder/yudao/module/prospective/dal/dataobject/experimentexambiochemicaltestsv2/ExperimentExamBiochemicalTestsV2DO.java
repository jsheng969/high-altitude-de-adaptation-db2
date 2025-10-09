package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambiochemicaltestsv2;

import lombok.*;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组体检-生化v2 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_exam_biochemical_tests_v2")
@KeySequence("prospective_experiment_exam_biochemical_tests_v2_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentExamBiochemicalTestsV2DO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 基础信息id
     */
    private Long personId;
    /**
     * 谷丙转氨酶
     */
    private BigDecimal alt;
    /**
     * 谷草转氨酶
     */
    private BigDecimal ast;
    /**
     * 谷草转氨酶与谷丙转氨酶比值
     */
    private BigDecimal astAltRatio;
    /**
     * 总蛋白
     */
    private BigDecimal totalProtein;
    /**
     * 白蛋白
     */
    private BigDecimal albumin;
    /**
     * 球蛋白
     */
    private BigDecimal globulin;
    /**
     * 白球比
     */
    private BigDecimal albGlobRatio;
    /**
     * 总胆红素
     */
    private BigDecimal totalBilirubin;
    /**
     * 直接胆红素
     */
    private BigDecimal directBilirubin;
    /**
     * 间接胆红素
     */
    private BigDecimal indirectBilirubin;
    /**
     * 碱性磷酸酶
     */
    private BigDecimal alkalinePhosphatase;
    /**
     * 谷氨酰转肽酶
     */
    private BigDecimal ggt;
    /**
     * 总胆汁酸
     */
    private BigDecimal totalBileAcid;
    /**
     * 胆碱酯酶
     */
    private BigDecimal cholinesterase;
    /**
     * 前白蛋白
     */
    private BigDecimal prealbumin;
    /**
     * 尿素
     */
    private BigDecimal urea;
    /**
     * 肌酐
     */
    private BigDecimal creatinine;
    /**
     * 尿酸
     */
    private BigDecimal uricAcid;
    /**
     * 甘油三酯
     */
    private BigDecimal triglycerides;
    /**
     * 胆固醇
     */
    private BigDecimal cholesterol;
    /**
     * 高密度脂蛋白
     */
    private BigDecimal hdlC;
    /**
     * 低密度脂蛋白
     */
    private BigDecimal ldlC;
    /**
     * 载脂蛋白A
     */
    private BigDecimal apoa;
    /**
     * 载脂蛋白B
     */
    private BigDecimal apob;
    /**
     * 脂蛋白a
     */
    private BigDecimal lpa;
    /**
     * 葡萄糖
     */
    private BigDecimal glucose;
    /**
     * 肌酸激酶
     */
    private BigDecimal ck;
    /**
     * 肌酸激酶同工酶MB
     */
    private BigDecimal ckMb;
    /**
     * α-羟丁酸脱氢酶
     */
    private BigDecimal alphaHbdh;
    /**
     * 乳酸脱氢酶
     */
    private BigDecimal ldh;
    /**
     * C-反应蛋白
     */
    private BigDecimal crp;
    /**
     * 免疫球蛋白G
     */
    private BigDecimal igg;
    /**
     * 免疫球蛋白A
     */
    private BigDecimal iga;
    /**
     * 免疫球蛋白M
     */
    private BigDecimal igm;
    /**
     * 补体3
     */
    private BigDecimal complement3;
    /**
     * 补体4
     */
    private BigDecimal complement4;
    /**
     * 肌红蛋白
     */
    private BigDecimal myoglobin;
    /**
     * 小而密低密度脂蛋白
     */
    private BigDecimal smallDenseLdl;
    /**
     * 同型半胱氨酸
     */
    private BigDecimal homocysteine;
    /**
     * 5-核苷酸酶
     */
    private BigDecimal nucleotidase;
    /**
     * 腺苷脱氨酶
     */
    private BigDecimal ada;
    /**
     * 淀粉酶
     */
    private BigDecimal amylase;
    /**
     * 阴离子间隙
     */
    private BigDecimal anionGap;
    /**
     * 缓冲碱
     */
    private BigDecimal bufferBase;
    /**
     * 碳酸氢盐
     */
    private BigDecimal bicarbonate;
    /**
     * 碱剩余
     */
    private BigDecimal baseExcess;
    /**
     * 细胞外液碱剩余
     */
    private BigDecimal extracellularBe;
    /**
     * 血尿素
     */
    private BigDecimal bloodUrea;
    /**
     * 血尿素氮
     */
    private BigDecimal bun;
    /**
     * 钙
     */
    private BigDecimal calcium;
    /**
     * 氯
     */
    private BigDecimal chloride;
    /**
     * 胱抑素C
     */
    private BigDecimal cystatinC;
    /**
     * 铁
     */
    private BigDecimal iron;
    /**
     * 实际碳酸氢盐
     */
    private BigDecimal actualBicarbonate;
    /**
     * 标准碳酸氢盐
     */
    private BigDecimal standardBicarbonate;
    /**
     * 钾
     */
    private BigDecimal potassium;
    /**
     * 镁
     */
    private BigDecimal magnesium;
    /**
     * 钠
     */
    private BigDecimal sodium;
    /**
     * 磷
     */
    private BigDecimal phosphorus;
    /**
     * 二氧化碳分压
     */
    private BigDecimal pco2;
    /**
     * 酸碱度
     */
    private BigDecimal ph;
    /**
     * 氧分压
     */
    private BigDecimal po2;
    /**
     * 视黄醇结合蛋白
     */
    private BigDecimal rbp;
    /**
     * 肾素活性
     */
    private BigDecimal reninActivity;
    /**
     * 氢离子浓度
     */
    private BigDecimal hydrogenIonConcentration;
    /**
     * 二氧化碳总量
     */
    private BigDecimal tco2;
    /**
     * 乳酸
     */
    private BigDecimal lacticAcid;
    /**
     * 微量白蛋白
     */
    private BigDecimal microalbumin;
    /**
     * 血浆渗透压
     */
    private BigDecimal plasmaOsmoticPressure;
    /**
     * 肺泡-动脉血氧分压差
     */
    private BigDecimal aAGradient;
    /**
     * 动脉-肺泡氧分压比值
     */
    private BigDecimal aARatio;
    /**
     * 氧合指数
     */
    private BigDecimal oxygenationIndex;
    /**
     * 估计血氧饱和度
     */
    private BigDecimal estimatedSpo2;
    /**
     * 估计总血红蛋白
     */
    private BigDecimal estimatedHb;
    /**
     * β2-微球蛋白
     */
    private BigDecimal beta2Microglobulin;
    /**
     * 超敏C反应蛋白
     */
    private BigDecimal hsCrp;
    /**
     * 乙肝表面抗原
     */
    private BigDecimal hbsag;
    /**
     * 乙肝表面抗体
     */
    private BigDecimal antiHbs;
    /**
     * 乙肝e抗原
     */
    private BigDecimal hbeag;
    /**
     * 乙肝e抗体
     */
    private BigDecimal antiHbe;
    /**
     * 乙肝核心抗体
     */
    private BigDecimal antiHbc;
    /**
     * 总胆固醇
     */
    private BigDecimal totalCholesterol;
    /**
     * 缺血修饰白蛋白
     */
    private BigDecimal ima;
    /**
     * α-L-岩藻糖苷酶
     */
    private BigDecimal afucosidase;
    /**
     * 时相
     */
    private Integer timePoint;

}