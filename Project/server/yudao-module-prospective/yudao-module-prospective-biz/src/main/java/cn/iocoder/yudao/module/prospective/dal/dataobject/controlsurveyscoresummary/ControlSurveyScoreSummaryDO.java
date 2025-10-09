package cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveyscoresummary;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-评分总数统计 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_survey_score_summary")
@KeySequence("prospective_control_survey_score_summary_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyScoreSummaryDO extends BaseDO {

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
     * 评分总数
     */
    private BigDecimal totalScore;
    /**
     * 时相
     */
    private Integer timePoint;

}