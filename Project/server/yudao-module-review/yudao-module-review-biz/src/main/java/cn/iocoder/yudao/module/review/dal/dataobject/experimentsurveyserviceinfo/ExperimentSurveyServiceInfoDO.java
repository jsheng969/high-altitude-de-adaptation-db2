package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyserviceinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-服役信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_service_info")
@KeySequence("review_experiment_survey_service_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyServiceInfoDO extends BaseDO {

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
     * 入伍年份
     */
    private Integer enlistmentYear;
    /**
     * 进入高原年份
     */
    private Integer highlandEntryYear;
    /**
     * 退役年份
     */
    private Integer dischargeYear;
    /**
     * 服役期间职务
     */
    private String servicePosition;
    /**
     * 高原服役地点 1
     */
    private String highlandServiceLocation1;
    /**
     * 海拔高度 1
     */
    private Integer altitude1;
    /**
     * 高原服役地点 1 年
     */
    private Integer year1;
    /**
     * 高原服役地点 1 月
     */
    private Integer month1;
    /**
     * 高原服役地点 2
     */
    private String highlandServiceLocation2;
    /**
     * 海拔高度 2
     */
    private Integer altitude2;
    /**
     * 高原服役地点 2 年
     */
    private Integer year2;
    /**
     * 高原服役地点 2 月
     */
    private Integer month2;
    /**
     * 高原服役地点 3
     */
    private String highlandServiceLocation3;
    /**
     * 海拔高度 3
     */
    private Integer altitude3;
    /**
     * 高原服役地点 3 年
     */
    private Integer year3;
    /**
     * 高原服役地点 3 月
     */
    private Integer month3;
    /**
     * 高原服役地点 4
     */
    private String highlandServiceLocation4;
    /**
     * 海拔高度 4
     */
    private Integer altitude4;
    /**
     * 高原服役地点 4 年
     */
    private Integer year4;
    /**
     * 高原服役地点 4 月
     */
    private Integer month4;
    /**
     * 高原服役地点 5
     */
    private String highlandServiceLocation5;
    /**
     * 海拔高度 5
     */
    private Integer altitude5;
    /**
     * 高原服役地点 5 年
     */
    private Integer year5;
    /**
     * 高原服役地点 5 月
     */
    private Integer month5;
    /**
     * 高原服役地点 6
     */
    private String highlandServiceLocation6;
    /**
     * 海拔高度 6
     */
    private Integer altitude6;
    /**
     * 高原服役地点 6 年
     */
    private Integer year6;
    /**
     * 高原服役地点 6 月
     */
    private Integer month6;
    /**
     * 高原任务的类型
     */
    private String highlandTaskType;

    private Integer altitude;

    private Integer month;

    private String highlandServiceLocation;

    private Double plateauTotalDuration; // 高原总时长
    private Integer maxAltitude;         // 最长时间海拔
    private Double maxAltitudeDuration; // 最长时间海拔时间
    private String altitudeCategory;     // 海拔分类
    private Integer highestAltitude;     // 最高海拔

}