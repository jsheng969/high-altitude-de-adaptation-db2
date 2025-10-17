package cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 动态表注册 Response VO")
@Data
@ExcelIgnoreUnannotated
public class RegistryRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "24890")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "动态表名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("动态表名")
    private String tableName;

    @Schema(description = "模块编码")
    @ExcelProperty("模块编码")
    private String moduleCode;

    @Schema(description = "数据节点类型", example = "1")
    @ExcelProperty("数据节点类型")
    private String nodeType;

    @Schema(description = "状态：0=未创建，1=已创建，2=已删除", example = "2")
    @ExcelProperty("状态：0=未创建，1=已创建，2=已删除")
    private Integer status;

    @Schema(description = "字段数量", example = "2929")
    @ExcelProperty("字段数量")
    private Integer fieldCount;

    @Schema(description = "描述信息", example = "随便")
    @ExcelProperty("描述信息")
    private String description;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}