package cn.iocoder.yudao.module.review.dal.dataobject.controlexambasictests;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组体检-基本检测信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_exam_basic_tests")
@KeySequence("review_control_exam_basic_tests_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlExamBasicTestsDO extends BaseDO {

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
     * 收缩压(mmHg)
     */
    private BigDecimal systolicPressure;
    /**
     * 舒张压(mmHg)
     */
    private BigDecimal diastolicPressure;
    /**
     * 脉搏(次/分)
     */
    private Integer pulse;
    /**
     * 身高(CM)
     */
    private BigDecimal height;
    /**
     * 体重(KG)
     */
    private BigDecimal weight;
    /**
     * 体重指数(kg/m^2)
     */
    private BigDecimal bmi;

}