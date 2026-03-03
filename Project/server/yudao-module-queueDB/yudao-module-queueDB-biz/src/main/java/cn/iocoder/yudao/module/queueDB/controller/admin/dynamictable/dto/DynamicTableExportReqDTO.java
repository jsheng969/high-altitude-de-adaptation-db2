// DynamicTableExportReqDTO.java
package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * 动态表导出请求
 */
@Data
public class DynamicTableExportReqDTO {

    @NotBlank(message = "模块编码不能为空")
    //模块编码
    private String moduleCode;

    //选中的子模块编码列表
    private List<String> selectedModules;

    //查询条件
    private Map<String, Object> conditions;

    //关联字段
    private String joinField;

    //是否导出所有数据
    private Boolean exportAll = true;

    //最大导出数量
    private Integer maxExport = 10000;
}