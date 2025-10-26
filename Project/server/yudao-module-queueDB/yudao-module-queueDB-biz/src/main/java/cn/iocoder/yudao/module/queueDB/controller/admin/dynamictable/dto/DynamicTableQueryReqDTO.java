package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DynamicTableQueryReqDTO extends PageParam {

    /**
     * 选择的模块名称列表（对应前端选择的表）
     */
    private List<String> selectedModules;

    /**
     * 查询条件
     */
    private Map<String, Object> conditions;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序方式：ASC/DESC
     */
    private String orderDirection;

    /**
     * 是否关联查询所有表
     */
    private Boolean joinAllTables = false;

    /**
     * 指定关联字段（默认为 tjh）
     */
    private String joinField = "tjh";
}
