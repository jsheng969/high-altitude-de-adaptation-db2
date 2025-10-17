package cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig;

import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.ModuleConfigTreeVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import org.springframework.data.annotation.Transient;

/**
 * 动态模块配置表（支持三级结构） DO
 *
 * @author 芋道源码
 */
@TableName("module_config")
@KeySequence("module_config_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleConfigDO extends BaseDO {

    /**
     * 模块ID
     */
    @TableId
    private Long id;
    /**
     * 父模块ID（支持三级）
     */
    private Long parentId;
    /**
     * 模块唯一标识
     */
    private String moduleCode;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 若为叶子节点，对应表名
     */
    private String tableName;
    /**
     * 模块层级（1=一级,2=二级,3=三级）
     */
    private Integer moduleLevel;
    /**
     * 模块归属类型（experiment/control）
     */
    private String groupType;
    /**
     * survey/exam等
     */
    private String moduleType;
    /**
     * 是否叶子模块（1=建表）
     */
    private Integer isLeaf;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 状态（1启用，0停用）
     */
    private Integer status;
    private String remark;

    @Schema(description = "子模块列表")
    @TableField(exist = false)
    private List<ModuleConfigDO> children;

}