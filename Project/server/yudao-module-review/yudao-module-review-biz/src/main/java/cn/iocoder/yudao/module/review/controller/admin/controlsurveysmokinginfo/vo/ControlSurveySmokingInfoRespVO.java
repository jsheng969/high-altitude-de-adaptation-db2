package cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 对照组流调-吸烟情况 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ControlSurveySmokingInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16343")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "基础信息id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4222")
    @ExcelProperty("基础信息id")
    private Long personId;

    @Schema(description = "是否吸烟", example = "2")
    @ExcelProperty("是否吸烟")
    private String smokingStatus;

    @Schema(description = "烟龄")
    @ExcelProperty("烟龄")
    private Integer smokingYears;

    @Schema(description = "是否尝试戒烟")
    @ExcelProperty("是否尝试戒烟")
    private String triedQuit;

    @Schema(description = "戒烟时间")
    @ExcelProperty("戒烟时间")
    private String quitTime;

}