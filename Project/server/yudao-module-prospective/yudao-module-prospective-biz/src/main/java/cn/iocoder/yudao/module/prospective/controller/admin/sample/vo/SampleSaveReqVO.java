package cn.iocoder.yudao.module.prospective.controller.admin.sample.vo;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.mybatis.core.type.EncryptTypeHandler;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 生物样本新增/修改 Request VO")
@Data
public class SampleSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "640")
    private Long id;

    @Schema(description = "层")
    private String layer;

    @Schema(description = "列")
    private String columnNum;

    @Schema(description = "冰箱编号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String freezerNo;

    @Schema(description = "抽屉号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String drawerNo;

    @Schema(description = "盒序号")
    private String boxSeq;

    @Schema(description = "盒号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String boxNo;

    @Schema(description = "管序号", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer tubeSeq;

    @Schema(description = "位置编码(自动生成)", requiredMode = Schema.RequiredMode.REQUIRED)
    private String positionCode;

    @Schema(description = "管号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tubeNo;

    @Schema(description = "样本类型(血液/尿液/组织等)", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private String sampleType;

    @Schema(description = "操作人员ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30588")
    private String operatorId;

    @Schema(description = "样本状态(1=在库,2=出库,3=已用,4=废弃)", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "入库时间")
    private LocalDateTime storageTime;

    @Schema(description = "出库时间")
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