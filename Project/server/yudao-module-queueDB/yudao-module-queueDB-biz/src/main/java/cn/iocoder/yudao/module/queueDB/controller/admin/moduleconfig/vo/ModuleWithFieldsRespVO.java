package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import lombok.Data;

import java.util.List;

@Data
public class ModuleWithFieldsRespVO {
    private Long id;
    private String name;
    private List<FieldWithLabelRespVO> fields;
}
