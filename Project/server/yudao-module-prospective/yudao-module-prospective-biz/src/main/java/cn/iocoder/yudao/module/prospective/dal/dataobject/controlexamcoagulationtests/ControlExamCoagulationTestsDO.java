package cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamcoagulationtests;

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
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组体检-凝血功能 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_exam_coagulation_tests")
@KeySequence("prospective_control_exam_coagulation_tests_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlExamCoagulationTestsDO extends BaseDO {

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
     * 活化部分凝血活酶时间
     */
    private BigDecimal aptt;
    /**
     * 抗凝血酶Ⅲ活性百分比
     */
    private BigDecimal antithrombinIiiActivityPercent;
    /**
     * 抗凝血酶Ⅲ活性（吸光度变化速率检测）
     */
    private BigDecimal antithrombinIiiActivityRate;
    /**
     * D-二聚体（光密度差值检测）
     */
    private BigDecimal dDimerOptDensity;
    /**
     * D-二聚体浓度
     */
    private BigDecimal dDimerConcentration;
    /**
     * 纤维蛋白降解产物（光密度差值检测）
     */
    private BigDecimal fibrinDegradationProductsDensity;
    /**
     * 纤维蛋白降解产物浓度
     */
    private BigDecimal fibrinDegradationProductsConcentration;
    /**
     * 纤维蛋白原浓度
     */
    private BigDecimal fibrinogenConcentration;
    /**
     * 纤维蛋白原凝固时间
     */
    private BigDecimal fibrinogenClottingTime;
    /**
     * 凝血酶原时间(百分比活动度)
     */
    private BigDecimal prothrombinTimePercent;
    /**
     * 凝血酶原时间-国际标准化比值
     */
    private BigDecimal ptInr;
    /**
     * 凝血酶原时间比值
     */
    private BigDecimal prothrombinTimeRatio;
    /**
     * 凝血酶原时间
     */
    private BigDecimal prothrombinTime;
    /**
     * 凝血酶时间
     */
    private BigDecimal thrombinTime;
    /**
     * 凝血酶时间(1)
     */
    private BigDecimal thrombinTime1;
    /**
     * 活化部分凝血活酶时间(1)
     */
    private BigDecimal aptt1;
    /**
     * 活化部分凝血活酶时间(2)
     */
    private BigDecimal aptt2;
    /**
     * 凝血酶原活动度
     */
    private BigDecimal prothrombinActivity;
    /**
     * 国际标准化比值
     */
    private BigDecimal inr;
    /**
     * 时相
     */
    private Integer timePoint;
    /**
     * PTDF
     */
    private BigDecimal ptdFbg;

}