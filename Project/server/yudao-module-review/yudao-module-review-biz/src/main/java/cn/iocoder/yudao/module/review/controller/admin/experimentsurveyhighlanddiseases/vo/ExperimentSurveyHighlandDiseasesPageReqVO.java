package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 实验组流调-高原疾病诊断分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExperimentSurveyHighlandDiseasesPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "26801")
    private Long personId;

    @Schema(description = "急性高原反应")
    private Boolean acuteHighlandReaction;

    @Schema(description = "高原肺水肿")
    private Boolean highlandPulmonaryEdema;

    @Schema(description = "高原脑水肿")
    private Boolean highlandCerebralEdema;

    @Schema(description = "高原心脏病")
    private Boolean highlandHeartDisease;

    @Schema(description = "高原红细胞增多症")
    private Boolean highlandPolycythemia;

    @Schema(description = "其他")
    private Boolean otherDiseases;

}