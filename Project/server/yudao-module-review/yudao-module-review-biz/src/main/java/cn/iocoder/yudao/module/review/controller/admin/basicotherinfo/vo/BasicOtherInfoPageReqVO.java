package cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 基础其他信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BasicOtherInfoPageReqVO extends PageParam {

    @Schema(description = "基础信息id", example = "19096")
    private Long personId;

    @Schema(description = "生育情况", example = "2")
    private String fertilityStatus;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "退役体重")
    private BigDecimal retiredWeight;

    @Schema(description = "体检日期", example = "2")
    private Date medicalCheckDate;

    @Schema(description = "联系电话", example = "2")
    private String contactPhone;

}