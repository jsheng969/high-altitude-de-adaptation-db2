package cn.iocoder.yudao.module.review.dal.dataobject.controlexambloodroutine;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组体检-血常规 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_exam_blood_routine")
@KeySequence("review_control_exam_blood_routine_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlExamBloodRoutineDO extends BaseDO {

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
    private BigDecimal wbc;
    /**
     * 红细胞计数
     */
    private BigDecimal rbc;
    /**
     * 中性粒细胞计数
     */
    private BigDecimal neutrophils;
    /**
     * 淋巴细胞计数
     */
    private BigDecimal lymphocytes;
    /**
     * 单核细胞计数
     */
    private BigDecimal monocytes;
    /**
     * 嗜酸性粒细胞计数
     */
    private BigDecimal eosinophils;
    /**
     * 嗜碱性粒细胞计数
     */
    private BigDecimal basophils;
    /**
     * 平均红细胞容积
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
     * RBC分布宽度CV值
     */
    private BigDecimal rdwCv;
    /**
     * RBC分布宽度SD值
     */
    private BigDecimal rdwSd;
    /**
     * 血红蛋白浓度
     */
    private BigDecimal hemoglobin;
    /**
     * 血小板比容
     */
    private BigDecimal plateletCrit;
    /**
     * 平均血小板体积
     */
    private BigDecimal mpv;
    /**
     * 血小板分布宽度
     */
    private BigDecimal pdw;
    /**
     * 红细胞比容
     */
    private BigDecimal hematocrit;
    /**
     * 血小板计数
     */
    private BigDecimal plateletCount;
    /**
     * 中性粒细胞百分率
     */
    private BigDecimal neutrophilsPercentage;
    /**
     * 淋巴细胞百分率
     */
    private BigDecimal lymphocytesPercentage;
    /**
     * 单核细胞百分率
     */
    private BigDecimal monocytesPercentage;
    /**
     * 嗜酸性粒细胞百分率
     */
    private BigDecimal eosinophilsPercentage;
    /**
     * 嗜碱性粒细胞百分率
     */
    private BigDecimal basophilsPercentage;

}