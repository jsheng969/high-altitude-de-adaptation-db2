package cn.iocoder.yudao.module.review.dal.dataobject.controlframingham;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组-framingham评分 DO
 *
 * @author 管理员
 */
@TableName("review_control_framingham")
@KeySequence("review_control_framingham_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlFraminghamDO extends BaseDO {

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
     * 分
     */
    private Integer framinghamScore;
    /**
     * 概率
     */
    private BigDecimal framinghamRisk;
    /**
     * 分类
     */
    private String framinghamRiskType;

}