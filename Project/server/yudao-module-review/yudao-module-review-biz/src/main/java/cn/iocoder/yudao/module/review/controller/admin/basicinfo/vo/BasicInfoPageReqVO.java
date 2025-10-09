package cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 基础信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BasicInfoPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "李四")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "最高学历")
    private String highestEducation;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "婚姻情况", example = "1")
    private String maritalStatus;

    @Schema(description = "身高")
    private BigDecimal height;

    @Schema(description = "体重")
    private BigDecimal weight;

    private List<String> reviewBasicInfoFields; // ["id", "name"]

    private List<String> reviewBasicOtherInfoFields; // ["id", "name"]

    private Integer serviceDurationRange;
    private Integer altitudeMin;
    private Integer altitudeMax;

    // 要关联的表名，如 ["review_basic_info", "review_experiment_survey_diet"]
    private List<String> joinTables;

    private Integer type;


    @Schema(description = "类型（1.实验组，2.流调组）")
    private Integer group;

    @Schema(description = "高级查询条件")
    private List<AdvancedCondition> advancedConditions;

    @Data
    public static class AdvancedCondition {
        private String logic;     // AND、OR
        private String field;     // 如 gender、basicOtherInfoRespVO.age
        private String operator;  // =, >, <, etc.
        private String value;     // 值（字符串）
    }
}