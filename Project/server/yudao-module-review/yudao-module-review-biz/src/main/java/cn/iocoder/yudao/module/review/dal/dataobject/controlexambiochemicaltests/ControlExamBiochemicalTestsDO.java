package cn.iocoder.yudao.module.review.dal.dataobject.controlexambiochemicaltests;

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
 * 对照组体检-生化 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_exam_biochemical_tests")
@KeySequence("review_control_exam_biochemical_tests_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlExamBiochemicalTestsDO extends BaseDO {

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
     * 尿素
     */
    private BigDecimal urea;
    /**
     * 肌酐
     */
    private BigDecimal creatinine;
    /**
     * 谷丙转氨酶
     */
    private BigDecimal alt;
    /**
     * 谷草转氨酶
     */
    private BigDecimal ast;
    /**
     * 总胆固醇
     */
    private BigDecimal totalCholesterol;
    /**
     * 甘油三酯
     */
    private BigDecimal triglycerides;
    /**
     * 高密度脂蛋白胆固醇
     */
    private BigDecimal hdlC;
    /**
     * 低密度脂蛋白胆固醇
     */
    private BigDecimal ldlC;
    /**
     * 尿酸
     */
    private BigDecimal uricAcid;
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
     * 白球比例
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
     * 糖化血红蛋白
     */
    private BigDecimal glycatedHemoglobin;
    /**
     * 钾
     */
    private BigDecimal potassium;
    /**
     * 钠
     */
    private BigDecimal sodium;
    /**
     * 氯
     */
    private BigDecimal chloride;
    /**
     * 钙
     */
    private BigDecimal calcium;
    /**
     * 磷
     */
    private BigDecimal phosphorus;
    /**
     * 镁
     */
    private BigDecimal magnesium;
    /**
     * 葡萄糖空腹
     */
    private BigDecimal fastingGlucose;
    /**
     * 凝血酶原时间
     */
    private BigDecimal prothrombinTime;
    /**
     * 凝血酶原活动度
     */
    private BigDecimal prothrombinActivity;
    /**
     * 国际标准化比率
     */
    private BigDecimal inr;
    /**
     * 纤维蛋白原
     */
    private BigDecimal fibrinogen;
    /**
     * 活化部分凝血活酶时间
     */
    private BigDecimal aptt;
    /**
     * 凝血酶时间
     */
    private BigDecimal thrombinTime;

}