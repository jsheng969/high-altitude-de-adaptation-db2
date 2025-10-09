package cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 实验组体检-其他数据新增/修改 Request VO")
@Data
public class ControlExamOtherDataSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28177")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "24199")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "心肌肌钙蛋白I")
    private String cardiacTroponinI;

    @Schema(description = "血管超声结果")
    private String vascularUltrasoundResult;

    @Schema(description = "心电图分析结果")
    private String ecgAnalysisResult;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "ATNI-H")
    private BigDecimal atniH;

    @Schema(description = "MYOG")
    private BigDecimal myog;

    @Schema(description = "CK-MBG")
    private BigDecimal ckMbg;

}