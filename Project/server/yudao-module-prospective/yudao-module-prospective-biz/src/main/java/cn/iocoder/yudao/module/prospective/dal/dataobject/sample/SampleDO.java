package cn.iocoder.yudao.module.prospective.dal.dataobject.sample;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.mybatis.core.type.EncryptTypeHandler;
import lombok.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 生物样本 DO
 *
 * @author 管理员
 */
@TableName("bio_sample")
@KeySequence("bio_sample_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 层
     */
    private String layer;
    /**
     * 列
     */
    private String columnNum;
    /**
     * 冰箱编号
     */
//    @EncryptField
    private String freezerNo;
    /**
     * 抽屉号
     */
    private String drawerNo;
    /**
     * 盒序号
     */
    private String boxSeq;
    /**
     * 盒号
     */
//    @EncryptField
    private String boxNo;
    /**
     * 管序号
     */
    private Integer tubeSeq;
    /**
     * 位置编码(自动生成)
     */
    private String positionCode;
    /**
     * 管号
     */
//    @EncryptField
    private String tubeNo;
    /**
     * 样本类型(血液/尿液/组织等)
     */
    private String sampleType;
    /**
     * 操作人员ID
     */
    private String operatorId;
    /**
     * 样本状态(1=在库,2=出库,3=已用,4=废弃)
     */
    private Integer status;
    /**
     * 入库时间
     */
    private LocalDateTime storageTime;
    /**
     * 出库时间
     */
    private LocalDateTime outTime;
    /**
     * 样本名称
     */
    private String sampleName;
    /**
     * 样本来源
     */
    private String sampleSource;
    /**
     * 样本体积(ml)
     */
    private BigDecimal sampleVolume;
    /**
     * 样本浓度
     */
    private BigDecimal sampleConcentration;
    /**
     * 过期日期
     */
    private LocalDateTime expirationDate;
    /**
     * 备注
     */
    private String notes;
    /**
     * 时相
     */
    private Integer timePoint;
    /**
     * 总可用次数
     */
    private Integer totalCount;
    /**
     * 剩余可用次数
     */
    private Integer remainCount;

}