package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturninfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-返回后基础信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_post_return_info")
@KeySequence("review_experiment_survey_post_return_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyPostReturnInfoDO extends BaseDO {

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
     * 成都
     */
    private Integer chengdu;
    /**
     * 成都居住时间（年）
     */
    private Integer chengduResidenceTime;
    /**
     * 昆明
     */
    private Integer kunming;
    /**
     * 昆明居住时间（年）
     */
    private Integer kunmingResidenceTime;
    /**
     * 西宁
     */
    private Integer xining;
    /**
     * 西宁居住时间（年）
     */
    private Integer xiningResidenceTime;
    /**
     * 其他
     */
    private String otherArea;
    /**
     * 其他居住时间（年）
     */
    private String otherAreaResidenceTime;
    /**
     * 从高原返回后的工作情况
     */
    private String postReturnWorkStatus;
    /**
     * 每年体检/就诊次数
     */
    private String annualCheckups;

}