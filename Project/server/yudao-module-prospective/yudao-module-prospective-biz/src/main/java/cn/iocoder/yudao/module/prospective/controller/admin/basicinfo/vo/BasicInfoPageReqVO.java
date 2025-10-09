package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 基础信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BasicInfoPageReqVO extends PageParam {

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "出生年月")
    private String birthDate;

    @Schema(description = "部职别")
    private String position;

    @Schema(description = "证件号")
    private String idNumber;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "组")
    private String groupType;

    @Schema(description = "时相")
    private Integer timePoint;

    @Schema(description = "年份")
    private Integer year;

    @Schema(description = "组")
    private String group;

    @Schema(description = "高级查询条件")
    private List<AdvancedCondition> advancedConditions;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "实际年龄")
    private Integer actualAge;

    @Schema(description = "vip")
    private Integer vip;

    @Schema(description = "调查或体检")
    private String surveyOrExam; // 调查或体检

    @Schema(description = "是否vip")
    @ExcelProperty("是否vip")
    private String isVip; // 是否vip

    @Data
    public static class AdvancedCondition {
        private String logic;     // AND、OR
        private String field;     // 如 gender、basicOtherInfoRespVO.age
        private String operator;  // =, >, <, etc.
        private String value;     // 值（字符串）
    }

    @Schema(description = "队列选项")
    private String queueOption;

    @Schema(description = "海拔选项")
    private String altitudeOption;

    @Schema(description = "临床症状字段")
    private String pesprs;

    @Schema(description = "血常规字段")
    private String peebr;

    @Schema(description = "生化字段")
    private String peebtv;

    @Schema(description = "凝血字段")
    private String peect;

}