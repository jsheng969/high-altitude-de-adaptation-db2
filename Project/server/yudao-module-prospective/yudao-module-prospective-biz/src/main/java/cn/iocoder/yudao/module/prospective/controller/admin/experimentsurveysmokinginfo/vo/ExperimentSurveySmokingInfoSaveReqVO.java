package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 吸烟信息新增/修改 Request VO")
@Data
public class ExperimentSurveySmokingInfoSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "18389")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3326")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "吸烟情况", example = "2")
    private String smokingStatus;

    @Schema(description = "每天抽烟的数量")
    private String dailyCigarettes;

    @Schema(description = "开始吸烟时年龄")
    private String smokingStartAge;

    @Schema(description = "烟龄")
    private String smokingYears;

    @Schema(description = "之前尝试过戒烟吗")
    private Boolean quitAttempted;

    @Schema(description = "吸烟地区")
    private String smokingRegion;

    @Schema(description = "已戒烟.您的烟龄")
    private String quitSmokingYears;

    @Schema(description = "已戒烟.您已戒烟")
    private String quitSmokingDuration;

    @Schema(description = "已戒烟.吸烟地区")
    private String quitSmokingRegion;

    @Schema(description = "时相")
    private Integer timePoint;
}