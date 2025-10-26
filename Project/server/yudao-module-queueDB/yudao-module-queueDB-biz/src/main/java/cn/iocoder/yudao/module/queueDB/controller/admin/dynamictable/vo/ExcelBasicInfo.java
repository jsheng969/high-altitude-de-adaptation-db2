package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import lombok.Data;

@Data
public class ExcelBasicInfo {
    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 工作表数量
     */
    private Integer sheetCount;

    /**
     * 总行数
     */
    private Integer totalRows;

    /**
     * 总列数
     */
    private Integer totalColumns;

    /**
     * 配置模式
     */
    private String configMode;

    /**
     * 是否有数据
     */
    private Boolean hasData;
}
