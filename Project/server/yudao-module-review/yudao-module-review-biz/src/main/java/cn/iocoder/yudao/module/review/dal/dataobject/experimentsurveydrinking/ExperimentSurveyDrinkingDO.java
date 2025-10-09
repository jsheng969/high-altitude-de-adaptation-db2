package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydrinking;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-饮酒情况 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_drinking")
@KeySequence("review_experiment_survey_drinking_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyDrinkingDO extends BaseDO {

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
     * 仍在饮酒
     */
    private Boolean stillDrinking;
    /**
     * 饮酒频率
     */
    private String drinkingFrequency;
    /**
     * 是否过量饮酒
     */
    private Boolean overDrinking;
    /**
     * 啤酒
     */
    private Boolean beer;
    /**
     * 白酒
     */
    private Boolean liquor;
    /**
     * 红酒
     */
    private Boolean redWine;
    /**
     * 鸡尾酒
     */
    private Boolean cocktails;
    /**
     * 烈酒
     */
    private Boolean spirits;
    /**
     * 其他
     */
    private Boolean otherAlcohol;

}