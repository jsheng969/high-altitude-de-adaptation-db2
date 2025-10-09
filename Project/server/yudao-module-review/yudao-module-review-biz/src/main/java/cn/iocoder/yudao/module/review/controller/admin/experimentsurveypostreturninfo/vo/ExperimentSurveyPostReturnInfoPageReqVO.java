package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 实验组流调-返回后基础信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyPostReturnInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "16766")
    private Long personId;

    @Schema(description = "成都")
    private Integer chengdu;

    @Schema(description = "成都居住时间（年）")
    private Integer chengduResidenceTime;

    @Schema(description = "昆明")
    private Integer kunming;

    @Schema(description = "昆明居住时间（年）")
    private Integer kunmingResidenceTime;

    @Schema(description = "西宁")
    private Integer xining;

    @Schema(description = "西宁居住时间（年）")
    private Integer xiningResidenceTime;

    @Schema(description = "其他")
    private String otherArea;

    @Schema(description = "其他居住时间（年）")
    private String otherAreaResidenceTime;

    @Schema(description = "从高原返回后的工作情况", example = "1")
    private String postReturnWorkStatus;

    @Schema(description = "每年体检/就诊次数")
    private String annualCheckups;

}