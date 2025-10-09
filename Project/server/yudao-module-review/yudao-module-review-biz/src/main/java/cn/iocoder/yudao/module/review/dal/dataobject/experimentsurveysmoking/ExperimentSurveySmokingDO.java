package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysmoking;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-吸烟情况 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_smoking")
@KeySequence("review_experiment_survey_smoking_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveySmokingDO extends BaseDO {

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
     * 是否吸烟
     */
    private String smokingStatus;
    /**
     * 每日抽烟数量
     */
    private String dailySmoking;
    /**
     * 开始吸烟年龄
     */
    private Integer smokingStartAge;
    /**
     * 烟龄
     */
    private Integer smokingYears;
    /**
     * 是否尝试戒烟
     */
    private Boolean triedQuit;
    /**
     * 高原/平原吸烟情况
     */
    private String highlandPlainSmokingStatus;
    /**
     * 烟龄 2
     */
    private String smokingYears2;
    /**
     * 戒烟时间
     */
    private String quitTime;
    /**
     * 高原/平原吸烟情况 2
     */
    private String highlandPlainSmokingStatus2;

}