package cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;


@Schema(description = "管理后台 - 对照组流调-吸烟情况新增/修改 Request VO")
@Data
public class ControlSurveySmokingInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16343")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4222")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "是否吸烟", example = "2")
    private String smokingStatus;

    @Schema(description = "烟龄")
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    private String triedQuit;

    @Schema(description = "戒烟时间")
    private String quitTime;

}