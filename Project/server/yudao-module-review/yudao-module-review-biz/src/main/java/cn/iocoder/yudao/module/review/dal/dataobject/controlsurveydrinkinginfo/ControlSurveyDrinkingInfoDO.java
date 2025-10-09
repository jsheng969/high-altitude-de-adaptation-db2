package cn.iocoder.yudao.module.review.dal.dataobject.controlsurveydrinkinginfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-饮酒情况 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_survey_drinking_info")
@KeySequence("review_control_survey_drinking_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyDrinkingInfoDO extends BaseDO {

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
     * 饮酒经历
     */
    private String drinkingExperience;
    /**
     * 饮酒频率
     */
    private String drinkingFrequency;

}