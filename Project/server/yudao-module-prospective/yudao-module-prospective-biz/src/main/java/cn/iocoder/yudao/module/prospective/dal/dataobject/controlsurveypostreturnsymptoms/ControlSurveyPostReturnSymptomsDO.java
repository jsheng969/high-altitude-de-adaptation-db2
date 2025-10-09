package cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveypostreturnsymptoms;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-退役后返回平原1月内症状 DO
 *
 * @author 管理员
 */
@TableName("prospective_control_survey_post_return_symptoms")
@KeySequence("prospective_control_survey_post_return_symptoms_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveyPostReturnSymptomsDO extends BaseDO {

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
    private Integer fatigue;
    /**
     * 疲倦持续时间
     */
    private String fatigueDuration;
    /**
     * 乏力
     */
    private Integer weakness;
    /**
     * 乏力持续时间
     */
    private String weaknessDuration;
    /**
     * 嗜睡
     */
    private Integer drowsiness;
    /**
     * 嗜睡持续时间
     */
    private String drowsinessDuration;
    /**
     * 头昏
     */
    private Integer dizziness;
    /**
     * 头昏持续时间
     */
    private String dizzinessDuration;
    /**
     * 眩晕
     */
    private Integer vertigo;
    /**
     * 眩晕持续时间
     */
    private String vertigoDuration;
    /**
     * 精力不集中
     */
    private Integer poorConcentration;
    /**
     * 精力不集中持续时间
     */
    private String poorConcentrationDuration;
    /**
     * 反应迟钝
     */
    private Integer slowReaction;
    /**
     * 反应迟钝持续时间
     */
    private String slowReactionDuration;
    /**
     * 记忆减退
     */
    private Integer memoryLoss;
    /**
     * 记忆减退持续时间
     */
    private String memoryLossDuration;
    /**
     * 失眠
     */
    private Integer insomnia;
    /**
     * 失眠持续时间
     */
    private String insomniaDuration;
    /**
     * 多梦
     */
    private Integer nightmares;
    /**
     * 多梦持续时间
     */
    private String nightmaresDuration;
    /**
     * 咽喉痛
     */
    private Integer soreThroat;
    /**
     * 咽喉痛持续时间
     */
    private String soreThroatDuration;
    /**
     * 咳嗽
     */
    private Integer cough;
    /**
     * 咳嗽持续时间
     */
    private String coughDuration;
    /**
     * 多痰
     */
    private Integer phlegm;
    /**
     * 多痰持续时间
     */
    private String phlegmDuration;
    /**
     * 气喘
     */
    private Integer wheezing;
    /**
     * 气喘持续时间
     */
    private String wheezingDuration;
    /**
     * 胸闷
     */
    private Integer chestTightness;
    /**
     * 胸闷持续时间
     */
    private String chestTightnessDuration;
    /**
     * 心前区痛
     */
    private Integer chestPain;
    /**
     * 心前区痛持续时间
     */
    private String chestPainDuration;
    /**
     * 心慌
     */
    private Integer palpitations;
    /**
     * 心慌持续时间
     */
    private String palpitationsDuration;
    /**
     * 脉率减慢
     */
    private Integer bradycardia;
    /**
     * 脉率减慢持续时间
     */
    private String bradycardiaDuration;
    /**
     * 紫绀
     */
    private Integer cyanosis;
    /**
     * 紫绀持续时间
     */
    private String cyanosisDuration;
    /**
     * 血压波动
     */
    private Integer bloodPressureFluctuation;
    /**
     * 血压波动持续时间
     */
    private String bloodPressureFluctuationDuration;
    /**
     * 皮肤出血
     */
    private Integer skinBleeding;
    /**
     * 皮肤出血持续时间
     */
    private String skinBleedingDuration;
    /**
     * 皮肤瘀斑
     */
    private Integer skinBruising;
    /**
     * 皮肤瘀斑持续时间
     */
    private String skinBruisingDuration;
    /**
     * 贫血
     */
    private Integer anemia;
    /**
     * 贫血持续时间
     */
    private String anemiaDuration;
    /**
     * 体重减轻
     */
    private Integer weightLoss;
    /**
     * 体重减轻持续时间
     */
    private String weightLossDuration;
    /**
     * 食欲增加
     */
    private Integer increasedAppetite;
    /**
     * 食欲增加持续时间
     */
    private String increasedAppetiteDuration;
    /**
     * 厌食
     */
    private Integer anorexia;
    /**
     * 厌食持续时间
     */
    private String anorexiaDuration;
    /**
     * 便秘
     */
    private Integer constipation;
    /**
     * 便秘持续时间
     */
    private String constipationDuration;
    /**
     * 腹泻
     */
    private Integer diarrhea;
    /**
     * 腹泻持续时间
     */
    private String diarrheaDuration;
    /**
     * 腹痛
     */
    private Integer abdominalPain;
    /**
     * 腹痛持续时间
     */
    private String abdominalPainDuration;
    /**
     * 腹胀
     */
    private Integer abdominalDistension;
    /**
     * 腹胀持续时间
     */
    private String abdominalDistensionDuration;
    /**
     * 黄疸
     */
    private Integer jaundice;
    /**
     * 黄疸持续时间
     */
    private String jaundiceDuration;
    /**
     * 手足麻木
     */
    private Integer numbness;
    /**
     * 手足麻木持续时间
     */
    private String numbnessDuration;
    /**
     * 肢体水肿
     */
    private Integer limbEdema;
    /**
     * 肢体水肿持续时间
     */
    private String limbEdemaDuration;
    /**
     * 面部水肿
     */
    private Integer facialEdema;
    /**
     * 面部水肿持续时间
     */
    private String facialEdemaDuration;
    /**
     * 脱发
     */
    private Integer hairLoss;
    /**
     * 脱发持续时间
     */
    private String hairLossDuration;
    /**
     * 夜尿增多
     */
    private Integer increasedUrination;
    /**
     * 夜尿增多持续时间
     */
    private String increasedUrinationDuration;
    /**
     * 返回后有无其他症状
     */
    private String otherSymptoms;
    /**
     * 时相点
     */
    private Integer timePoint;

}