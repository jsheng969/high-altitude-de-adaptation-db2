package cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyresidenceinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-旅居信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_survey_residence_info")
@KeySequence("review_control_survey_residence_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyResidenceInfoDO extends BaseDO {

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
     * 高原经历
     */
    private String highlandExperience;
    /**
     * 长期平原经历
     */
    private String longTermPlainExperience;
    /**
     * 常住地1
     */
    private String residence1;
    /**
     * 常住地2
     */
    private String residence2;
    /**
     * 常住地3
     */
    private String residence3;

}