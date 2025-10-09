package cn.iocoder.yudao.module.review.dal.dataobject.basicinfo;

import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.BasicOtherInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.ExperimentSurveyDietRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.ExperimentSurveyDrinkingRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基础信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_basic_info")
@KeySequence("review_basic_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 最高学历
     */
    private String highestEducation;
    /**
     * 民族
     */
    private String ethnicity;
    /**
     * 婚姻情况
     */
    private String maritalStatus;
    /**
     * 身高
     */
    private BigDecimal height;
    /**
     * 体重
     */
    private BigDecimal weight;

    /**
     * 类型（1.实验组，2.流调组）
     */
    private Integer type;

//    @TableField(exist = false)
//    private BasicOtherInfoRespVO basicOtherInfoRespVO; // 基础其他信息
//    @TableField(exist = false)
//    private ExperimentSurveyDietRespVO experimentSurveyDietRespVO; // 实验室调查问卷及饮食记录
//    @TableField(exist = false)
//    private ExperimentSurveyDrinkingRespVO experimentSurveyDrinkingRespVO; // 实验室调查问卷及饮酒记录

}