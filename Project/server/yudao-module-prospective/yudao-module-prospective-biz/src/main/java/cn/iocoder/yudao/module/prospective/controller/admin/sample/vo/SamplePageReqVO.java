package cn.iocoder.yudao.module.prospective.controller.admin.sample.vo;

import cn.iocoder.yudao.framework.mybatis.core.type.EncryptTypeHandler;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 生物样本分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SamplePageReqVO extends PageParam {

    private Long id;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime createTime;

    @Schema(description = "层")
    private String layer;

    @Schema(description = "列")
    private String columnNum;

    @Schema(description = "冰箱编号")
    private String freezerNo;

    @Schema(description = "抽屉号")
    private String drawerNo;

    @Schema(description = "盒序号")
    private String boxSeq;

    @Schema(description = "盒号")
    private String boxNo;

    @Schema(description = "管序号")
    private Integer tubeSeq;

    @Schema(description = "位置编码(自动生成)")
    private String positionCode;

    @Schema(description = "管号")
    private String tubeNo;

    @Schema(description = "样本类型(血液/尿液/组织等)", example = "2")
    private String sampleType;

    @Schema(description = "操作人员ID")
    private String operatorId;

    @Schema(description = "样本状态(1=在库,2=出库,3=已用,4=废弃)", example = "1")
    private Integer status;

    @Schema(description = "入库时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime storageTime;

    @Schema(description = "出库时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime outTime;

    @Schema(description = "样本名称", example = "赵六")
    private String sampleName;

    @Schema(description = "样本来源")
    private String sampleSource;

    @Schema(description = "样本体积(ml)")
    private BigDecimal sampleVolume;

    @Schema(description = "样本浓度")
    private BigDecimal sampleConcentration;

    @Schema(description = "过期日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime expirationDate;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "总可用次数")
    private Integer totalCount;

    @Schema(description = "剩余可用次数")
    private Integer remainCount;

}