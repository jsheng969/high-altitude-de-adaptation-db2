package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ExcelIgnoreUnannotated
public class ControlGroupExportVO {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty({"基础信息", "编号"})
    private String code;
    @ExcelProperty({"基础信息", "实际年龄"})
    private Integer actualAge;
    @ExcelProperty({"基础信息", "性别"})
    private String gender;
    @ExcelProperty({"基础信息", "出生年月"})
    private String birthDate;
    @ExcelProperty({"基础信息", "部职别"})
    private String position;
    @ExcelProperty({"基础信息", "证件号"})
    private String idNumber;
    @ExcelProperty({"基础信息", "婚姻状况"})
    private String maritalStatus;
    @ExcelProperty({"基础信息", "身高"})
    private BigDecimal height;
    @ExcelProperty({"基础信息", "体重"})
    private BigDecimal weight;
    @ExcelProperty({"基础信息", "民族"})
    private String ethnicity;
    @ExcelProperty({"基础信息", "最高学历"})
    private String educationLevel;
    @ExcelProperty({"基础信息", "生育情况"})
    private String fertilityStatus;
}
