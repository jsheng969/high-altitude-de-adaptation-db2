package cn.iocoder.yudao.module.queueDB.dal.dataobject.registry;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 动态表注册 DO
 *
 * @author 管理员
 */
@TableName("table_registry")
@KeySequence("table_registry_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistryDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 动态表名
     */
    private String tableName;
    /**
     * 模块编码
     */
    private String moduleCode;
    /**
     * 数据节点类型
     */
    private String nodeType;
    /**
     * 状态：0=未创建，1=已创建，2=已删除
     */
    private Integer status;
    /**
     * 字段数量
     */
    private Integer fieldCount;
    /**
     * 描述信息
     */
    private String description;

}