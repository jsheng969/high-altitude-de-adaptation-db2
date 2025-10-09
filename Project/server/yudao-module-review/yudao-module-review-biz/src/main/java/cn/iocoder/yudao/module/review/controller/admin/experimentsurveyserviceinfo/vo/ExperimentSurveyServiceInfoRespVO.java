package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-服役信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveyServiceInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "12485")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15199")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "入伍年份")
    @ExcelProperty("入伍年份")
    private Integer enlistmentYear;

    @Schema(description = "进入高原年份")
    @ExcelProperty("进入高原年份")
    private Integer highlandEntryYear;

    @Schema(description = "退役年份")
    @ExcelProperty("退役年份")
    private Integer dischargeYear;

    @Schema(description = "服役期间职务")
    @ExcelProperty("服役期间职务")
    private String servicePosition;

    @Schema(description = "高原服役地点 1")
    @ExcelProperty(value = {"服役信息", "地点1", "服役地点"})
    private String highlandServiceLocation1;

    @Schema(description = "海拔高度 1")
    @ExcelProperty(value = {"服役信息", "地点1", "海拔高度"})
    private Integer altitude1;

    @Schema(description = "高原服役地点 1 年")
    @ExcelProperty(value = {"服役信息", "地点1", "服役时长年"})
    private Integer year1;

    @Schema(description = "高原服役地点 1 月")
    @ExcelProperty(value = {"服役信息", "地点1", "服役时长月"})
    private Integer month1;

    @Schema(description = "高原服役地点 2")
    @ExcelProperty(value = {"服役信息", "地点2", "服役地点"})
    private String highlandServiceLocation2;

    @Schema(description = "海拔高度 2")
    @ExcelProperty(value = {"服役信息", "地点2", "海拔高度"})
    private Integer altitude2;

    @Schema(description = "高原服役地点 2 年")
    @ExcelProperty(value = {"服役信息", "地点2", "服役时长年"})
    private Integer year2;

    @Schema(description = "高原服役地点 2 月")
    @ExcelProperty(value = {"服役信息", "地点2", "服役时长月"})
    private Integer month2;

    @Schema(description = "高原服役地点 3")
    @ExcelProperty(value = {"服役信息", "地点3", "服役地点"})
    private String highlandServiceLocation3;

    @Schema(description = "海拔高度 3")
    @ExcelProperty(value = {"服役信息", "地点3", "海拔高度"})
    private Integer altitude3;

    @Schema(description = "高原服役地点 3 年")
    @ExcelProperty(value = {"服役信息", "地点3", "服役时长年"})
    private Integer year3;

    @Schema(description = "高原服役地点 3 月")
    @ExcelProperty(value = {"服役信息", "地点3", "服役时长月"})
    private Integer month3;

    @Schema(description = "高原服役地点 4")
    @ExcelProperty(value = {"服役信息", "地点4", "服役地点"})
    private String highlandServiceLocation4;

    @Schema(description = "海拔高度 4")
    @ExcelProperty(value = {"服役信息", "地点4", "海拔高度"})
    private Integer altitude4;

    @Schema(description = "高原服役地点 4 年")
    @ExcelProperty(value = {"服役信息", "地点4", "服役时长年"})
    private Integer year4;

    @Schema(description = "高原服役地点 4 月")
    @ExcelProperty(value = {"服役信息", "地点4", "服役时长月"})
    private Integer month4;

    @Schema(description = "高原服役地点 5")
    @ExcelProperty(value = {"服役信息", "地点5", "服役地点"})
    private String highlandServiceLocation5;

    @Schema(description = "海拔高度 5")
    @ExcelProperty(value = {"服役信息", "地点5", "海拔高度"})
    private Integer altitude5;

    @Schema(description = "高原服役地点 5 年")
    @ExcelProperty(value = {"服役信息", "地点5", "服役时长年"})
    private Integer year5;

    @Schema(description = "高原服役地点 5 月")
    @ExcelProperty(value = {"服役信息", "地点5", "服役时长月"})
    private Integer month5;

    @Schema(description = "高原服役地点 6")
    @ExcelProperty(value = {"服役信息", "地点6", "服役地点"})
    private String highlandServiceLocation6;

    @Schema(description = "海拔高度 6")
    @ExcelProperty(value = {"服役信息", "地点6", "海拔高度"})
    private Integer altitude6;

    @Schema(description = "高原服役地点 6 年")
    @ExcelProperty(value = {"服役信息", "地点6", "服役时长年"})
    private Integer year6;

    @Schema(description = "高原服役地点 6 月")
    @ExcelProperty(value = {"服役信息", "地点6", "服役时长月"})
    private Integer month6;

    @Schema(description = "高原任务的类型", example = "2")
    @ExcelProperty(value = {"高原服役期间高原反应信息", "从事高原任务类型"})
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