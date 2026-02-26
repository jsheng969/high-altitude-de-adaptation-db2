package cn.iocoder.yudao.module.prospective.controller.admin.sample.vo;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.mybatis.core.type.EncryptTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 生物样本 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SampleRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "640")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "层")
    @ExcelProperty("层")
    private String layer;

    @Schema(description = "列")
    @ExcelProperty("列")
    private String columnNum;

    @Schema(description = "冰箱编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("冰箱编号")
//    @EncryptField
    private String freezerNo;

    @Schema(description = "抽屉号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("抽屉号")
    private String drawerNo;

    @Schema(description = "盒序号")
    @ExcelProperty("盒序号")
    private String boxSeq;

    @Schema(description = "盒号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("盒号")
//    @EncryptField
    private String boxNo;

    @Schema(description = "管序号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("管序号")
    private Integer tubeSeq;

    @Schema(description = "位置编码(自动生成)", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("位置编码(自动生成)")
    private String positionCode;

    @Schema(description = "管号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("管号")
//    @EncryptField
    private String tubeNo;

    @Schema(description = "样本类型(血液/尿液/组织等)", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("样本类型(血液/尿液/组织等)")
    private String sampleType;

    @Schema(description = "操作人员ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30588")
    @ExcelProperty("操作人员ID")
    private String operatorId;

    @Schema(description = "样本状态(1=在库,2=出库,3=已用,4=废弃)", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("样本状态(1=在库,2=出库,3=已用,4=废弃)")
    private Integer status;

    @Schema(description = "入库时间")
    @ExcelProperty("入库时间")
    private LocalDateTime storageTime;

    @Schema(description = "出库时间")
    @ExcelProperty("出库时间")
    private LocalDateTime outTime;

    @Schema(description = "样本名称", example = "赵六")
    @ExcelProperty("样本名称")
    private String sampleName;

    @Schema(description = "样本来源")
    @ExcelProperty("样本来源")
    private String sampleSource;

    @Schema(description = "样本体积(ml)")
    @ExcelProperty("样本体积(ml)")
    private BigDecimal sampleVolume;

    @Schema(description = "样本浓度")
    @ExcelProperty("样本浓度")
    private BigDecimal sampleConcentration;

    @Schema(description = "过期日期")
    @ExcelProperty("过期日期")
    private LocalDateTime expirationDate;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String notes;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

    @Schema(description = "总可用次数")
    @ExcelProperty("总可用次数")
    private Integer totalCount;

    @Schema(description = "剩余可用次数")
    @ExcelProperty("剩余可用次数")
    private Integer remainCount;

}