package cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基础其他信息 DO
 *
 * @author 芋道源码
 */
@TableName("review_basic_other_info")
@KeySequence("review_basic_other_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicOtherInfoDO extends BaseDO {

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
     * 生育情况
     */
    private String fertilityStatus;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 退役体重
     */
    private BigDecimal retiredWeight;

    /**
     * 体检日期
     */
    private Date medicalCheckDate;

    /**
     * 联系电话
     */
    private String contactPhone;

}