package cn.iocoder.yudao.module.prospective.dal.dataobject.basicotherinfo;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

import java.math.BigDecimal;

/**
 * 基础其他信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_basic_other_info")
@KeySequence("prospective_experiment_survey_basic_other_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProspectiveBasicOtherInfoDO extends BaseDO {

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
     * 婚姻状况
     */
    @EncryptField
    private String maritalStatus;
    /**
     * 生育情况
     */
    @EncryptField
    private String fertilityStatus;
    /**
     * 身高
     */
    private BigDecimal height;
    /**
     * 体重
     */
    private BigDecimal weight;
    /**
     * 民族
     */
    @EncryptField
    private String ethnicity;
    /**
     * 最高学历
     */
    @EncryptField
    private String educationLevel;

    /**
     * 时相
     */
    private Integer timePoint;

}