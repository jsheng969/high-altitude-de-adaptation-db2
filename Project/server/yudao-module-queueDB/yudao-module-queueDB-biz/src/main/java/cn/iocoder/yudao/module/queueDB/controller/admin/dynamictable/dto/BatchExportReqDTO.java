// 创建 BatchExportReqDTO.java
package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
@Schema(description = "批量导出请求")
public class BatchExportReqDTO {

    /**
     * 模块编码列表
     */
    @Schema(description = "模块编码列表", required = true)
    private List<String> moduleCodes;

    /**
     * 关联字段名（如：tjh）
     */
    @Schema(description = "关联字段名", example = "tjh")
    private String joinField;

    /**
     * 是否导出所有数据
     */
    @Schema(description = "是否导出所有数据", example = "true")
    private Boolean exportAll = true;

    /**
     * 每个模块的最大导出数量
     */
    @Schema(description = "每个模块的最大导出数量", example = "5000")
    private Integer maxExportPerModule = 5000;

    /**
     * 导出文件名
     */
    @Schema(description = "导出文件名", example = "批量导出数据")
    private String fileName;

    /**
     * 是否合并到一个Excel文件（否则导出为ZIP）
     */
    @Schema(description = "是否合并到一个Excel文件", example = "true")
    private Boolean mergeToSingleFile = true;

    /**
     * 导出格式：excel/csv
     */
    @Schema(description = "导出格式", example = "excel")
    private String exportFormat = "excel";

    /**
     * 是否包含系统字段
     */
    @Schema(description = "是否包含系统字段", example = "false")
    private Boolean includeSystemFields = false;
}