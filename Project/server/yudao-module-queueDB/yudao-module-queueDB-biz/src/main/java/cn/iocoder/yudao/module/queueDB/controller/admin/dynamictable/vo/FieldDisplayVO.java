package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import lombok.Data;

import java.util.List;

@Data
public class FieldDisplayVO {

    /**
     * 字段组名（模块名称）
     */
    private String groupName;

    /**
     * 字段列表
     */
    private List<FieldInfo> fields;

    @Data
    public static class FieldInfo {
        /**
         * 字段标识
         */
        private String fieldCode;

        /**
         * 字段显示名称
         */
        private String fieldLabel;

        /**
         * 字段类型
         */
        private String fieldType;

        /**
         * 表名
         */
        private String tableName;

        /**
         * 在表格中的属性名（用于前端绑定）
         */
        private String prop;
    }
}
