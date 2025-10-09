package cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyselfassessment;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-自我评价 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_survey_self_assessment")
@KeySequence("review_control_survey_self_assessment_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveySelfAssessmentDO extends BaseDO {

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
     * 每年体检/就诊次数
     */
    private String annualCheckups;
    /**
     * 与同龄人相比，您认为目前自己的身体健康状况如何
     */
    private String healthComparison;
    /**
     * 您认为自己身体健康状况能得________分
     */
    private Integer healthScore;

}