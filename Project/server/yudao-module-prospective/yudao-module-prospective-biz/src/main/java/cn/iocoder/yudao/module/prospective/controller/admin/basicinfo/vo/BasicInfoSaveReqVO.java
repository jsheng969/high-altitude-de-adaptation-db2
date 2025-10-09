package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "管理后台 - 基础信息新增/修改 Request VO")
@Data
public class BasicInfoSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13493")
    private Long id;

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

    @Schema(description = "编号")
    private String code;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "组")
    private String groupType;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "实际年龄")
    private Integer actualAge;

    private Integer timePoint;

    @Schema(description = "调查或体检")
    private String surveyOrExam; // 调查或体检

    @Schema(description = "是否vip")
    @ExcelProperty("是否vip")
    private String isVip; // 是否vip
}