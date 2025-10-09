package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "管理后台 - 实验组流调-服役信息新增/修改 Request VO")
@Data
public class ExperimentSurveyServiceInfoSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "12485")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15199")
    @NotNull(message = "基础信息id不能为空")
    private Long personId;

    @Schema(description = "入伍年份")
    private Integer enlistmentYear;

    @Schema(description = "进入高原年份")
    private Integer highlandEntryYear;

    @Schema(description = "退役年份")
    private Integer dischargeYear;

    @Schema(description = "服役期间职务")
    private String servicePosition;

    @Schema(description = "高原服役地点 1")
    private String highlandServiceLocation1;

    @Schema(description = "海拔高度 1")
    private Integer altitude1;

    @Schema(description = "高原服役地点 1 年")
    private Double year1;

    @Schema(description = "高原服役地点 1 月")
    private Integer month1;

    @Schema(description = "高原服役地点 2")
    private String highlandServiceLocation2;

    @Schema(description = "海拔高度 2")
    private Integer altitude2;

    @Schema(description = "高原服役地点 2 年")
    private Double year2;

    @Schema(description = "高原服役地点 2 月")
    private Integer month2;

    @Schema(description = "高原服役地点 3")
    private String highlandServiceLocation3;

    @Schema(description = "海拔高度 3")
    private Integer altitude3;

    @Schema(description = "高原服役地点 3 年")
    private Double year3;

    @Schema(description = "高原服役地点 3 月")
    private Integer month3;

    @Schema(description = "高原服役地点 4")
    private String highlandServiceLocation4;

    @Schema(description = "海拔高度 4")
    private Integer altitude4;

    @Schema(description = "高原服役地点 4 年")
    private Double year4;

    @Schema(description = "高原服役地点 4 月")
    private Integer month4;

    @Schema(description = "高原服役地点 5")
    private String highlandServiceLocation5;

    @Schema(description = "海拔高度 5")
    private Integer altitude5;

    @Schema(description = "高原服役地点 5 年")
    private Double year5;

    @Schema(description = "高原服役地点 5 月")
    private Integer month5;

    @Schema(description = "高原服役地点 6")
    private String highlandServiceLocation6;

    @Schema(description = "海拔高度 6")
    private Integer altitude6;

    @Schema(description = "高原服役地点 6 年")
    private Double year6;

    @Schema(description = "高原服役地点 6 月")
    private Integer month6;

    @Schema(description = "高原任务的类型", example = "2")
    private String highlandTaskType;

    @Schema(description = "海拔高度")
    private Integer altitude;

    @Schema(description = "高原服役地点月")
    private Integer month;

    @Schema(description = "最长服役地点")
    private String highlandServiceLocation;

    private Double plateauTotalDuration; // 高原总时长
    private Integer maxAltitude;         // 最长时间海拔
    private Double maxAltitudeDuration; // 最长时间海拔时间
    private String altitudeCategory;     // 海拔分类
    private Integer highestAltitude;     // 最高海拔
}