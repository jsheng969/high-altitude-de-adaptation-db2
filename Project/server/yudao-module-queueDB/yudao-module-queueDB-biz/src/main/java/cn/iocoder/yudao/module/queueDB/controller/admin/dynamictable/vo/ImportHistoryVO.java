package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ImportHistoryVO {
    private Long id;
    private String fileName;
    private String moduleCode;
    private String moduleName;
    private Integer fieldCount;
    private Integer dataCount;
    private Boolean success;
    private String errorMessage;
    private Date importTime;
}
