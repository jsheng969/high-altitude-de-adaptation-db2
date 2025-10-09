package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyacutemountainsicknessrecords;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 高原急性高山病记录 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_acute_mountain_sickness_records")
@KeySequence("prospective_experiment_survey_acute_mountain_sickness_records_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveyAcuteMountainSicknessRecordsDO extends BaseDO {

    /**
     * 主键ID
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
    private Boolean acuteMountainReaction;
    /**
     * 肺水肿
     */
    private Boolean pulmonaryEdema;
    /**
     * 脑水肿
     */
    private Boolean cerebralEdema;
    /**
     * 高原心脏病
     */
    private Boolean highAltitudeHeartDisease;
    /**
     * 高原红细胞增多症
     */
    private Boolean polycythemia;
    /**
     * 高原期间有无发生以下疾病
     */
    private String otherDiseases;
    /**
     * 其他疾病描述
     */
    private String otherDiseasesDesc;

    /**
     * 时相
     */
    private Integer timePoint;
}