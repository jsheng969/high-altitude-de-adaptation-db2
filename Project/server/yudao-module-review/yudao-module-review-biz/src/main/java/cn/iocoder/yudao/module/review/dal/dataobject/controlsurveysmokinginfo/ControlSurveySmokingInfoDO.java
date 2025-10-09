package cn.iocoder.yudao.module.review.dal.dataobject.controlsurveysmokinginfo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 对照组流调-吸烟情况 DO
 *
 * @author 芋道源码
 */
@TableName("review_control_survey_smoking_info")
@KeySequence("review_control_survey_smoking_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlSurveySmokingInfoDO extends BaseDO {

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
     * 是否吸烟
     */
    private String smokingStatus;
    /**
     * 烟龄
     */
    private Integer smokingYears;
    /**
     * 是否尝试戒烟
     */
    private String triedQuit;
    /**
     * 戒烟时间
     */
    private String quitTime;

}