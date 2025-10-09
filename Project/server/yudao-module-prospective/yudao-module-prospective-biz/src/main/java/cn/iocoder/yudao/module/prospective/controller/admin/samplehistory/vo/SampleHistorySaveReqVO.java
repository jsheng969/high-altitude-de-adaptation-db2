package cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 生物样本库历史记录新增/修改 Request VO")
@Data
public class SampleHistorySaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15084")
    private Long id;

    @Schema(description = "样品id", example = "17021")
    private Long bioSampleId;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "行为")
    private String action;

    private LocalDateTime createTime;

}