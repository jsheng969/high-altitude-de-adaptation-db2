package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldWithLabelRespVO {
    private Long id;
    private String label;
    private String prop;
}
