package cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveystationtraininginfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-驻训信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_survey_station_training_info")
@KeySequence("prospective_control_survey_station_training_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyStationTrainingInfoDO extends BaseDO {

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
     * 任务点海拔
     */
    private Integer missionPointAltitude;
    /**
     * 地点
     */
    private String location;
    /**
     * 高原驻训次数
     */
    private Integer plateauTrainingCount;
    /**
     * 高原驻训总时长
     */
    private Integer plateauTrainingDuration;
    /**
     * 任务从事类型
     */
    private String missionType;
    /**
     * 每日工作时间
     */
    private Integer dailyWorkHours;
    /**
     * 时相
     */
    private Integer timePoint;
    /**
     * 服役期间职务
     */
    private String servicePosition;

}