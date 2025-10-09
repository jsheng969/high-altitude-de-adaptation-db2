package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveysmokinginfo;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 吸烟信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_survey_smoking_info")
@KeySequence("prospective_experiment_survey_smoking_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentSurveySmokingInfoDO extends BaseDO {

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
     * 吸烟情况
     */
    private String smokingStatus;
    /**
     * 每天抽烟的数量
     */
    private String dailyCigarettes;
    /**
     * 开始吸烟时年龄
     */
    private String smokingStartAge;
    /**
     * 烟龄
     */
    private String smokingYears;
    /**
     * 之前尝试过戒烟吗
     */
    private Boolean quitAttempted;
    /**
     * 吸烟地区
     */
    private String smokingRegion;
    /**
     * 已戒烟.您的烟龄
     */
    private String quitSmokingYears;
    /**
     * 已戒烟.您已戒烟
     */
    private String quitSmokingDuration;
    /**
     * 已戒烟.吸烟地区
     */
    private String quitSmokingRegion;

    /**
     * 时相
     */
    private Integer timePoint;
}