package cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

import javax.validation.constraints.NotBlank;

/**
 * 动态字段配置 DO
 *
 * @author 芋道源码
 */
@TableName("field_config")
@KeySequence("field_config_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldConfigDO extends BaseDO {

    /**
     * 字段ID
     */
    @TableId
    private Long id;
    /**
     * 所属模块code（对应module_config.module_code）
     */
    private String moduleCode;
    /**
     * 字段标识（用于数据库列名）
     */
    private String fieldCode;
    /**
     * 字段显示名
     */
    private String fieldLabel;
    /**
     * 字段类型（input/select/number/date/checkbox等）
     */
    private String fieldType;
    /**
     * 数据库字段类型
     */
    private String dataType;
    /**
     * 选项配置（如下拉选项等）
     */
    private String optionsJson;
    /**
     * 是否必填
     */
    private Integer isRequired;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 状态（1启用）
     */
    private Integer status;

    private Integer fieldLength; // 对应 VARCHAR 长度等
    @NotBlank
    private String fieldName; // 对应数据库列名

    private String fieldGroup; // 字段分组代码，如：station_training
    private String fieldGroupName; // 字段分组名称，如：驻训信息
    private Integer isDefault; //是否默认显示
    private Integer displayOrder; //显示顺序
}