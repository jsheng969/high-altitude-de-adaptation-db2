package cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveybasiccheckinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-基本检测信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_survey_basic_check_info")
@KeySequence("prospective_control_survey_basic_check_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyBasicCheckInfoDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 基础信息id
     */
    private Long personId;
    /**
     * 收缩压
     */
    private Integer systolicBloodPressure;
    /**
     * 舒张压
     */
    private Integer diastolicBloodPressure;
    /**
     * 氧饱和度
     */
    private Integer oxygenSaturation;
    /**
     * 心率
     */
    private Integer heartRate;
    /**
     * 基本身高
     */
    private Integer basicHeight;
    /**
     * 基本体重
     */
    private Integer basicWeight;
    /**
     * 调查身高
     */
    private String surveyHeight;
    /**
     * 调查体重
     */
    private String surveyWeight;
    /**
     * 时相
     */
    private Integer timePoint;

}