package cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseases;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组流调-高原疾病诊断 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_survey_highland_diseases")
@KeySequence("review_experiment_survey_highland_diseases_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyHighlandDiseasesDO extends BaseDO {

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
     * 急性高原反应
     */
    private Boolean acuteHighlandReaction;
    /**
     * 高原肺水肿
     */
    private Boolean highlandPulmonaryEdema;
    /**
     * 高原脑水肿
     */
    private Boolean highlandCerebralEdema;
    /**
     * 高原心脏病
     */
    private Boolean highlandHeartDisease;
    /**
     * 高原红细胞增多症
     */
    private Boolean highlandPolycythemia;
    /**
     * 其他
     */
    private Boolean otherDiseases;

}