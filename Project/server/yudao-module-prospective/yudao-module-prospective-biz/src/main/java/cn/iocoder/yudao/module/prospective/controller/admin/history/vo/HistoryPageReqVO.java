package cn.iocoder.yudao.module.prospective.controller.admin.history.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 预警历史记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HistoryPageReqVO extends PageParam {

    @Schema(description = "参数")
    private String parm;

    @Schema(description = "得分")
    private String socre;

    @Schema(description = "时间")
    private LocalDateTime createTime;

}