package cn.iocoder.yudao.module.prospective.dal.dataobject.history;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 预警历史记录 DO
 *
 * @author 管理员
 */
@TableName("prospective_warning_history")
@KeySequence("prospective_warning_history_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 参数
     */
    private String parm;
    /**
     * 得分
     */
    private String socre;


}