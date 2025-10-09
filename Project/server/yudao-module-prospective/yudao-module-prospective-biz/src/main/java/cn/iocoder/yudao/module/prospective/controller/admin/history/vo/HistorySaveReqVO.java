package cn.iocoder.yudao.module.prospective.controller.admin.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 预警历史记录新增/修改 Request VO")
@Data
public class HistorySaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11612")
    private Integer id;

    @Schema(description = "参数")
    private String parm;

    @Schema(description = "得分")
    private String socre;

}