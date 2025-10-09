package cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambloodroutine;

import lombok.*;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组体检-血常规 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_exam_blood_routine")
@KeySequence("prospective_control_exam_blood_routine_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProspectiveControlExamBloodRoutineDO extends BaseDO {

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
     * 白细胞计数
     */
    private BigDecimal wbcCount;
    /**
     * 淋巴细胞百分比
     */
    private BigDecimal lymphocytePercent;
    /**
     * 中间细胞百分比
     */
    private BigDecimal midCellPercent;
    /**
     * 粒细胞百分比
     */
    private BigDecimal granulocytePercent;
    /**
     * 淋巴细胞计数
     */
    private BigDecimal lymphocyteCount;
    /**
     * 中间细胞计数
     */
    private BigDecimal midCellCount;
    /**
     * 粒细胞计数
     */
    private BigDecimal granulocyteCount;
    /**
     * 红细胞计数
     */
    private BigDecimal rbcCount;
    /**
     * 血红蛋白
     */
    private BigDecimal hemoglobin;
    /**
     * 血细胞比容
     */
    private BigDecimal hematocrit;
    /**
     * 平均红细胞体积
     */
    private BigDecimal mcv;
    /**
     * 平均红细胞血红蛋白含量
     */
    private BigDecimal mch;
    /**
     * 平均红细胞血红蛋白浓度
     */
    private BigDecimal mchc;
    /**
     * 红细胞分布宽度变异系数
     */
    private BigDecimal rdwCv;
    /**
     * 红细胞分布宽度标准差
     */
    private BigDecimal rdwSd;
    /**
     * 血小板计数
     */
    private BigDecimal plateletCount;
    /**
     * 平均血小板体积
     */
    private BigDecimal mpv;
    /**
     * 血小板分布宽度
     */
    private BigDecimal pdw;
    /**
     * 血小板压积
     */
    private BigDecimal pct;
    /**
     * 大血小板比率
     */
    private BigDecimal largePlateletRatio;
    /**
     * 大血小板计数
     */
    private BigDecimal largePlateletCount;
    /**
     * 嗜碱性粒细胞计数
     */
    private BigDecimal basophilCount;
    /**
     * 嗜碱性粒细胞百分比
     */
    private BigDecimal basophilPercent;
    /**
     * 嗜酸性粒细胞计数
     */
    private BigDecimal eosinophilCount;
    /**
     * 嗜酸性粒细胞百分比
     */
    private BigDecimal eosinophilPercent;
    /**
     * 幼稚粒细胞计数
     */
    private BigDecimal immatureGranulocyteCount;
    /**
     * 幼稚粒细胞百分比
     */
    private BigDecimal immatureGranulocytePercent;
    /**
     * 单核细胞计数
     */
    private BigDecimal monocyteCount;
    /**
     * 单核细胞百分比
     */
    private BigDecimal monocytePercent;
    /**
     * 有核红细胞计数
     */
    private BigDecimal nucleatedRbcCount;
    /**
     * 有核红细胞百分比
     */
    private BigDecimal nucleatedRbcPercent;
    /**
     * 中性粒细胞计数
     */
    private BigDecimal neutrophilCount;
    /**
     * 中性粒细胞百分比
     */
    private BigDecimal neutrophilPercent;
    /**
     * 时相
     */
    private Integer timePoint;
    /**
     * NE%
     */
    private BigDecimal ne;
    /**
     * LY%
     */
    private BigDecimal ly;
    /**
     * MO%
     */
    private BigDecimal mo;
    /**
     * BA%
     */
    private BigDecimal ba;
    /**
     * Neut#
     */
    private BigDecimal neut;
    /**
     * Lymph#
     */
    private BigDecimal lymph;
    /**
     * Eos#
     */
    private BigDecimal eos;
    /**
     * CREA
     */
    private BigDecimal crea;
    /**
     * CYSC
     */
    private BigDecimal cysc;
    /**
     * CLCR
     */
    private BigDecimal clcr;
    /**
     * URIC
     */
    private BigDecimal uric;

}