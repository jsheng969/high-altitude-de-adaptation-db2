package cn.iocoder.yudao.module.prospective.util;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class SurveyOrExamConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public WriteCellData<?> convertToExcelData(
            String value,
            ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration
    ) {
        String exportValue = "survey".equals(value) ? "流调" : "检查";
        return new WriteCellData<>(exportValue);
    }
}
