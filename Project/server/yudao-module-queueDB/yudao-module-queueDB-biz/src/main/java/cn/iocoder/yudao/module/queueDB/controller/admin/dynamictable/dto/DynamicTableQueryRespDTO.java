package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto;

import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.FieldDisplayVO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DynamicTableQueryRespDTO {
    /**
     * 数据列表
     */
    private List<Map<String, Object>> list;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 显示的字段配置
     */
    private List<FieldDisplayVO> displayedFields;

    /**
     * 统计信息
     */
    private Map<String, Object> statistics;
}
