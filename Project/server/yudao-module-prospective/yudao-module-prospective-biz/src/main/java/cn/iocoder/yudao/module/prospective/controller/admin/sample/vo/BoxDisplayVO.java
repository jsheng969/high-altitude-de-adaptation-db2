package cn.iocoder.yudao.module.prospective.controller.admin.sample.vo;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.mybatis.core.type.EncryptTypeHandler;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class BoxDisplayVO {

    @EncryptField
    private String freezerNo;
    private String layer;
    private String columnNum;
    private String drawerNo;
    @EncryptField
    private String boxNo;
    private Integer boxSeq;
    private String positionCode;
    private List<String> sampleTypes; // 盒中所有样本类型
    private String displayColor; // 可以在这里计算好颜色，也可以让前端处理
    private Integer totalCount;
    private Integer remainCount;

}
