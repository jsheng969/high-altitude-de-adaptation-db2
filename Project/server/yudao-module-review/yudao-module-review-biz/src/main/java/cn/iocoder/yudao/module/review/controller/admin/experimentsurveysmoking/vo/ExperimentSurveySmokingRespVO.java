package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 实验组流调-吸烟情况 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ExperimentSurveySmokingRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22011")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16046")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "是否吸烟", example = "1")
    @ExcelProperty(value = {"吸烟情况", "吸烟状态"})
    private String smokingStatus;

    @Schema(description = "每日抽烟数量")
    @ExcelProperty(value = {"吸烟情况", "吸烟", "每天吸烟数（根）"})
    private String dailySmoking;

    @Schema(description = "开始吸烟年龄")
    @ExcelProperty(value = {"吸烟情况", "吸烟", "开始吸烟年龄"})
    private Integer smokingStartAge;

    @Schema(description = "烟龄")
    @ExcelProperty(value = {"吸烟情况", "吸烟", "烟龄"})
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    @ExcelProperty(value = {"吸烟情况", "吸烟", "尝试戒烟"})
    private Boolean triedQuit;

    @Schema(description = "高原/平原吸烟情况", example = "2")
    @ExcelProperty(value = {"吸烟情况", "吸烟", "高原/平原吸烟情况"})
    private String highlandPlainSmokingStatus;

    @Schema(description = "烟龄 2")
    @ExcelProperty(value = {"吸烟情况", "已戒烟", "烟龄"})
    private String smokingYears2;

    @Schema(description = "戒烟时间")
    @ExcelProperty(value = {"吸烟情况", "已戒烟", "戒烟时长"})
    private String quitTime;

    @Schema(description = "平原吸烟情况 2")
    @ExcelProperty(value = {"吸烟情况", "已戒烟", "高原/平原吸烟情况"})
    private String highlandPlainSmokingStatus2;

}