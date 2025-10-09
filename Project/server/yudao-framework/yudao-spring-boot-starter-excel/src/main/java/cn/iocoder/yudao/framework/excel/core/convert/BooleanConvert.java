package cn.iocoder.yudao.framework.excel.core.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class BooleanConvert implements Converter<Boolean> {
    @Override
    public Class<Boolean> supportJavaTypeKey() {
        throw new UnsupportedOperationException("暂不支持，也不需要");
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        throw new UnsupportedOperationException("暂不支持，也不需要");
    }

    @Override
    public WriteCellData<String> convertToExcelData(Boolean value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) {
        // true -> "是", false/null -> "否"
        return new WriteCellData<>(Boolean.TRUE.equals(value) ? "是" : "否");
    }
}
