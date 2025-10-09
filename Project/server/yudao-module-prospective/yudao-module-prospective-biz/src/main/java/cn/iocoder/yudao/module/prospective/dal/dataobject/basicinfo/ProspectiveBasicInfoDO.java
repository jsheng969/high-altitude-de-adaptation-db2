package cn.iocoder.yudao.module.prospective.dal.dataobject.basicinfo;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基础信息 DO
 *
 * @author 管理员
 */
@TableName("prospective_basic_info")
@KeySequence("prospective_basic_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProspectiveBasicInfoDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    @EncryptField
    private String name;
    /**
     * 性别
     */
    @EncryptField
    private String gender;
    /**
     * 出生年月
     */
    @EncryptField
    private String birthDate;
    /**
     * 部职别
     */
    @EncryptField
    private String position;
    /**
     * 证件号
     */
    @EncryptField
    private String idNumber;

    @EncryptField
    private String code;

    /**
     * 类型
     */
    @EncryptField
    private String type;

    /**
     * 组
     */
    @EncryptField
    private String groupType;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 实际年龄
     */
    private Integer actualAge;

    private Integer timePoint;

    private String surveyOrExam; // 调查或体检

    private String isVip; // 是否vip

}