package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 吸烟信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveySmokingInfoRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "18389")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3326")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "吸烟情况", example = "2")
    @ExcelProperty("吸烟情况")
    private String smokingStatus;

    @Schema(description = "每天抽烟的数量")
    @ExcelProperty("每天抽烟的数量")
    private String dailyCigarettes;

    @Schema(description = "开始吸烟时年龄")
    @ExcelProperty("开始吸烟时年龄")
    private String smokingStartAge;

    @Schema(description = "烟龄")
    @ExcelProperty("烟龄")
    private String smokingYears;

    @Schema(description = "之前尝试过戒烟吗")
    @ExcelProperty("之前尝试过戒烟吗")
    private Boolean quitAttempted;

    @Schema(description = "吸烟地区")
    @ExcelProperty("吸烟地区")
    private String smokingRegion;

    @Schema(description = "已戒烟.您的烟龄")
    @ExcelProperty("已戒烟.您的烟龄")
    private String quitSmokingYears;

    @Schema(description = "已戒烟.您已戒烟")
    @ExcelProperty("已戒烟.您已戒烟")
    private String quitSmokingDuration;

    @Schema(description = "已戒烟.吸烟地区")
    @ExcelProperty("已戒烟.吸烟地区")
    private String quitSmokingRegion;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;
}