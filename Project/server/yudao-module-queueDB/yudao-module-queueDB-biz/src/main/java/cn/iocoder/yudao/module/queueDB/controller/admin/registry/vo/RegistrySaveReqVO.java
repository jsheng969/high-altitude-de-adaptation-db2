package cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;

import javax.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 动态表注册新增/修改 Request VO")
@Data
public class RegistrySaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "24890")
    private Long id;

    @Schema(description = "动态表名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "动态表名不能为空")
    private String tableName;

    @Schema(description = "模块编码")
    private String moduleCode;

    @Schema(description = "数据节点类型", example = "1")
    private String nodeType;

    @Schema(description = "状态：0=未创建，1=已创建，2=已删除", example = "2")
    private Integer status;

    @Schema(description = "字段数量", example = "2929")
    private Integer fieldCount;

    @Schema(description = "描述信息", example = "随便")
    private String description;

}