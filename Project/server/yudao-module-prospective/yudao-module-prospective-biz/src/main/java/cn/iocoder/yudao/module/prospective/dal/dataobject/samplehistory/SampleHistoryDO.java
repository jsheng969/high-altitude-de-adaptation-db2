package cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 生物样本库历史记录 DO
 *
 * @author 管理员
 */
@TableName("bio_sample_history")
@KeySequence("bio_sample_history_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleHistoryDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 样品id
     */
    private Long bioSampleId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 行为
     */
    private String action;

}