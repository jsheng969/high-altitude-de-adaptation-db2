package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-高原反应信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_highland_reaction")
@KeySequence("review_experiment_survey_highland_reaction_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyHighlandReactionDO extends BaseDO {

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
     * 是否发生过高原反应
     */
    private Boolean reactionOccurred;
    /**
     * 高原反应次数
     */
    private Integer reactionCount;

    /**
     * 高原反应次数字符串
     */
    private String reactionCountText;
    /**
     * 高原反应次数记不清
     */
    private Boolean unclearReactionCount;
    /**
     * 多次高原反应，高原反应变化情况
     */
    private String multipleReactionsChanges;

}