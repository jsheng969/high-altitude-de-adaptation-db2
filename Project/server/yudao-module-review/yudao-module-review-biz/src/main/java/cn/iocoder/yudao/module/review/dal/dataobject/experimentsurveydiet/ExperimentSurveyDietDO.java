package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydiet;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-饮食习惯 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_diet")
@KeySequence("review_experiment_survey_diet_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyDietDO extends BaseDO {

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
     * 饮食习惯
     */
    private String eatingHabits;
    /**
     * 饮用水
     */
    private String drinkingWater;
    /**
     * 茶水
     */
    private String tea;
    /**
     * 果汁
     */
    private String fruitJuice;
    /**
     * 碳酸饮料
     */
    private String carbonatedDrinks;
    /**
     * 咖啡
     */
    private String coffee;
    /**
     * 牛奶 
     */
    private String milk;

}