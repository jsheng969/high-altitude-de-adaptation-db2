package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturnsymptoms;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-退役后返回平原1月内症状 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_post_return_symptoms")
@KeySequence("review_experiment_survey_post_return_symptoms_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyPostReturnSymptomsDO extends BaseDO {

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
     * 疲倦
     */
    private Boolean fatigue;
    /**
     * 嗜睡
     */
    private Boolean drowsiness;
    /**
     * 头昏
     */
    private Boolean dizziness;
    /**
     * 眩晕
     */
    private Boolean vertigo;
    /**
     * 精力不集中
     */
    private Boolean poorConcentration;
    /**
     * 反应迟钝
     */
    private Boolean slowReaction;
    /**
     * 记忆减退
     */
    private Boolean memoryLoss;
    /**
     * 失眠
     */
    private Boolean insomnia;
    /**
     * 多梦
     */
    private Boolean nightmares;
    /**
     * 心前区痛
     */
    private Boolean chestPain;
    /**
     * 心慌
     */
    private Boolean palpitations;
    /**
     * 脉率减慢
     */
    private Boolean bradycardia;
    /**
     * 紫绀
     */
    private Boolean cyanosis;
    /**
     * 血压波动
     */
    private Boolean bloodPressureFluctuation;
    /**
     * 皮肤出血
     */
    private Boolean skinBleeding;
    /**
     * 皮肤瘀斑
     */
    private Boolean skinBruising;
    /**
     * 贫血
     */
    private Boolean anemia;
    /**
     * 咽喉痛
     */
    private Boolean soreThroat;
    /**
     * 咳嗽
     */
    private Boolean cough;
    /**
     * 多痰
     */
    private Boolean phlegm;
    /**
     * 气喘
     */
    private Boolean wheezing;
    /**
     * 胸闷
     */
    private Boolean chestTightness;
    /**
     * 体重减轻
     */
    private Boolean weightLoss;
    /**
     * 食欲增加
     */
    private Boolean increasedAppetite;
    /**
     * 厌食
     */
    private Boolean anorexia;
    /**
     * 便秘
     */
    private Boolean constipation;
    /**
     * 腹泻
     */
    private Boolean diarrhea;
    /**
     * 腹痛
     */
    private Boolean abdominalPain;
    /**
     * 黄疸
     */
    private Boolean jaundice;
    /**
     * 手足麻木
     */
    private Boolean numbness;
    /**
     * 肢体水肿
     */
    private Boolean limbEdema;
    /**
     * 面部水肿
     */
    private Boolean facialEdema;
    /**
     * 脱发
     */
    private Boolean hairLoss;
    /**
     * 夜尿增多
     */
    private Boolean increasedUrination;

}