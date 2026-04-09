package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.ExcelImportReqDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.FieldConfigImportDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.ModuleConfigImportDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelBasicInfo;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelDataRow;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelParseResult;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ExcelParseServiceImpl implements ExcelParseService {

    private static final Pattern SQL_TYPE_WITH_PARAMS = Pattern.compile("^([a-zA-Z]+)\\s*\\(([^)]*)\\)$");

    @Override
    public ExcelParseResult parseExcel(MultipartFile file, ExcelImportReqDTO importReq) {
        ExcelParseResult result = new ExcelParseResult();
        long startTime = System.currentTimeMillis();

        try {
            log.info("开始解析Excel文件: {}", file.getOriginalFilename());

            // 1. 验证文件格式
            if (!validateExcelFormat(file)) {
                result.addError("文件格式不支持，请上传.xlsx格式的Excel文件");
                return result;
            }

            // 2. 读取原始Excel数据
            List<Map<Integer, String>> sheetData = readRawExcelData(file);
            if (sheetData.isEmpty()) {
                result.addError("Excel文件为空或没有数据");
                return result;
            }

            result.setTotalRows(sheetData.size());
            result.setTotalColumns(getMaxColumns(sheetData));

            // 3. 解析模块配置（从表单参数获取）
            ModuleConfigImportDTO moduleConfig = parseModuleConfig(importReq);
            result.setModuleConfig(moduleConfig);

            // 4. 解析字段配置 - 使用新的横向结构
            List<FieldConfigImportDTO> fieldConfigs = parseFieldConfigsHorizontal(sheetData);
            result.setFieldConfigs(fieldConfigs);

            if (fieldConfigs.isEmpty()) {
                result.addError("未解析到有效的字段配置，请检查Excel格式是否符合模板要求");
                return result;
            }

            // 5. 解析数据行 - 使用新的横向结构
            List<ExcelDataRow> dataRows = parseDataRowsHorizontal(sheetData, fieldConfigs);
            result.setDataRows(dataRows);

            long costTime = System.currentTimeMillis() - startTime;
            log.info("Excel解析完成，字段数: {}, 数据行: {}, 耗时: {}ms",
                    fieldConfigs.size(), dataRows.size(), costTime);

        } catch (Exception e) {
            log.error("解析Excel文件失败", e);
            result.addError("解析Excel文件失败: " + e.getMessage());
        }

        return result;
    }

    @Override
    public String generateFieldCode(String chineseName, String parentGroup) {
        if (StringUtils.isBlank(chineseName)) {
            return "field_" + System.currentTimeMillis();
        }

        // 清理非法字符，用下划线连接
        String cleanCode = chineseName.replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", "_")
                .replaceAll("_+", "_")
                .replaceAll("^_|_$", "")
                .toLowerCase();

        // 添加父分组前缀
        if (StringUtils.isNotBlank(parentGroup)) {
            String parentCode = generateFieldCode(parentGroup, null);
            cleanCode = parentCode + "_" + cleanCode;
        }

        // 确保不以数字开头
        if (cleanCode.matches("^[0-9].*")) {
            cleanCode = "f_" + cleanCode;
        }

        return cleanCode;
    }

    @Override
    public String detectConfigMode(MultipartFile file) {
        return "simple"; // 现在我们只有一种模板结构
    }

    @Override
    public boolean validateExcelFormat(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return false;
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            return false;
        }

        return fileName.toLowerCase().endsWith(".xlsx") ||
                fileName.toLowerCase().endsWith(".xls");
    }

    @Override
    public ExcelBasicInfo getExcelBasicInfo(MultipartFile file) {
        ExcelBasicInfo info = new ExcelBasicInfo();
        info.setFileName(file.getOriginalFilename());
        info.setFileSize(file.getSize());

        try {
            List<Map<Integer, String>> sheetData = readRawExcelData(file);
            info.setTotalRows(sheetData.size());
            info.setTotalColumns(getMaxColumns(sheetData));
            info.setConfigMode("simple");
            info.setHasData(!sheetData.isEmpty());
            info.setSheetCount(1);
        } catch (Exception e) {
            log.error("获取Excel基本信息失败", e);
        }

        return info;
    }

    // ================= 私有方法 =================

    /**
     * 解析模块配置 - 从表单参数获取
     */
    private ModuleConfigImportDTO parseModuleConfig(ExcelImportReqDTO importReq) {
        ModuleConfigImportDTO moduleConfig = new ModuleConfigImportDTO();

        // 从导入请求中获取模块配置
        moduleConfig.setModuleCode(importReq.getModuleCode());
        moduleConfig.setModuleName(importReq.getModuleName());
        moduleConfig.setModuleType(importReq.getModuleType());
        moduleConfig.setGroupType(importReq.getGroupType());
        moduleConfig.setRemark(importReq.getRemark());

        // 如果未指定模块编码，从文件名生成
        if (StringUtils.isBlank(moduleConfig.getModuleCode())) {
            String fileName = importReq.getFile().getOriginalFilename();
            String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
            moduleConfig.setModuleCode(generateModuleCode(baseName));
        }

        // 如果未指定模块名称，从文件名生成
        if (StringUtils.isBlank(moduleConfig.getModuleName())) {
            String fileName = importReq.getFile().getOriginalFilename();
            moduleConfig.setModuleName(fileName.substring(0, fileName.lastIndexOf('.')));
        }

        log.info("模块配置解析完成: {}", moduleConfig.getModuleCode());
        return moduleConfig;
    }

    /**
     * 解析横向字段配置
     */
    private List<FieldConfigImportDTO> parseFieldConfigsHorizontal(List<Map<Integer, String>> sheetData) {
        List<FieldConfigImportDTO> fieldConfigs = new ArrayList<>();

        try {
            // 检查是否有足够的行来解析字段配置（至少需要5行配置）
            if (sheetData.size() < 5) {
                log.warn("Excel行数不足，无法解析字段配置");
                return fieldConfigs;
            }

            // 读取配置行（前5行）
            Map<Integer, String> groupRow = sheetData.get(0);     // 第1行：字段分组
            Map<Integer, String> groupCodeRow = sheetData.get(1); // 第2行：分组标识
            Map<Integer, String> labelRow = sheetData.get(2);     // 第3行：字段名称
            Map<Integer, String> codeRow = sheetData.get(3);      // 第4行：字段标识
            Map<Integer, String> typeRow = sheetData.get(4);      // 第5行：字段类型

            log.debug("开始解析字段配置，列数: groupRow={}, groupCodeRow={}, labelRow={}, codeRow={}, typeRow={}",
                    groupRow.size(), groupCodeRow.size(), labelRow.size(), codeRow.size(), typeRow.size());

            // 确定最大列数
            int maxColumns = getMinColumnSize(Arrays.asList(groupRow, groupCodeRow, labelRow, codeRow, typeRow));

            // 从第1列开始解析（跳过第0列的标题）
            for (int colIndex = 1; colIndex < maxColumns; colIndex++) {
                String fieldGroup = getCellValueSafe(groupRow, colIndex);
                String groupCode = getCellValueSafe(groupCodeRow, colIndex);
                String fieldLabel = getCellValueSafe(labelRow, colIndex);
                String fieldCode = getCellValueSafe(codeRow, colIndex);
                String fieldType = getCellValueSafe(typeRow, colIndex);

                // 跳过空字段（字段名称和字段标识都为空）
                if (StringUtils.isBlank(fieldLabel) && StringUtils.isBlank(fieldCode)) {
                    continue;
                }

                // 如果字段名称为空但字段标识存在，使用字段标识作为字段名称
                if (StringUtils.isBlank(fieldLabel) && StringUtils.isNotBlank(fieldCode)) {
                    fieldLabel = fieldCode;
                }

                // 如果字段标识为空但字段名称存在，生成字段标识
                if (StringUtils.isBlank(fieldCode) && StringUtils.isNotBlank(fieldLabel)) {
                    fieldCode = generateFieldCode(fieldLabel, fieldGroup);
                }

                FieldConfigImportDTO fieldConfig = new FieldConfigImportDTO();
                fieldConfig.setFieldGroup(StringUtils.isNotBlank(groupCode) ? groupCode : "default");
                fieldConfig.setFieldGroupName(StringUtils.isNotBlank(fieldGroup) ? fieldGroup : "默认分组");
                fieldConfig.setFieldLabel(fieldLabel);
                fieldConfig.setFieldCode(fieldCode);
                String dataType = getDataType(fieldType);
                fieldConfig.setFieldType(mapDataTypeToFieldType(dataType));
                fieldConfig.setDataType(dataType);
                fieldConfig.setFieldLength(extractFieldLength(dataType));
                fieldConfig.setDisplayOrder(colIndex * 10);
                fieldConfig.setIsRequired(0); // 默认非必填
                fieldConfig.setStatus(1); // 默认启用

                fieldConfigs.add(fieldConfig);

                log.debug("解析字段配置: group={}, code={}, label={}, type={}",
                        fieldGroup, fieldCode, fieldLabel, fieldType);
            }

            log.info("字段配置解析完成，共 {} 个字段", fieldConfigs.size());

        } catch (Exception e) {
            log.error("解析字段配置失败", e);
            throw new RuntimeException("解析字段配置失败: " + e.getMessage(), e);
        }

        return fieldConfigs;
    }

    /**
     * 解析横向数据行
     */
    private List<ExcelDataRow> parseDataRowsHorizontal(List<Map<Integer, String>> sheetData,
                                                       List<FieldConfigImportDTO> fieldConfigs) {
        List<ExcelDataRow> dataRows = new ArrayList<>();

        try {
            // 数据从第7行开始（跳过前5行配置和1行空行/说明行）
            int dataStartRow = 6;

            for (int rowIndex = dataStartRow; rowIndex < sheetData.size(); rowIndex++) {
                Map<Integer, String> rawRow = sheetData.get(rowIndex);

                // 跳过空行和说明行
                if (isEmptyRow(rawRow) || isDescriptionRow(rawRow)) {
                    continue;
                }

                ExcelDataRow dataRow = new ExcelDataRow();
                dataRow.setRowIndex(rowIndex + 1); // Excel行号从1开始

                boolean hasData = false;

                // 从第1列开始映射数据（跳过第0列）
                for (int colIndex = 1; colIndex <= fieldConfigs.size(); colIndex++) {
                    if (colIndex - 1 < fieldConfigs.size()) {
                        FieldConfigImportDTO fieldConfig = fieldConfigs.get(colIndex - 1);
                        String cellValue = getCellValueSafe(rawRow, colIndex);

                        // 如果单元格有值，才添加到数据行
                        if (StringUtils.isNotBlank(cellValue)) {
                            Object convertedValue = convertCellValue(cellValue, fieldConfig.getFieldType());
                            dataRow.put(fieldConfig.getFieldCode(), convertedValue);
                            hasData = true;
                        }
                    }
                }

                if (hasData && !dataRow.isEmpty()) {
                    dataRows.add(dataRow);
                }
            }

            log.info("数据行解析完成，共 {} 行有效数据", dataRows.size());

        } catch (Exception e) {
            log.error("解析数据行失败", e);
            throw new RuntimeException("解析数据行失败: " + e.getMessage(), e);
        }

        return dataRows;
    }

    /**
     * 读取原始Excel数据
     */
    private List<Map<Integer, String>> readRawExcelData(MultipartFile file) throws IOException {
        return readRawExcelData(file, Integer.MAX_VALUE);
    }

    /**
     * 读取原始Excel数据（限制行数）
     */
    private List<Map<Integer, String>> readRawExcelData(MultipartFile file, int maxRows) throws IOException {
        List<Map<Integer, String>> rawData = new ArrayList<>();

        EasyExcel.read(file.getInputStream(), new AnalysisEventListener<Map<Integer, String>>() {
            private int rowCount = 0;

            @Override
            public void invoke(Map<Integer, String> data, AnalysisContext context) {
                if (rowCount < maxRows) {
                    rawData.add(new HashMap<>(data)); // 创建副本
                    rowCount++;
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 完成解析
            }
        }).sheet().doRead();

        log.debug("读取Excel数据完成，共 {} 行", rawData.size());
        return rawData;
    }

    /**
     * 安全获取单元格值
     */
    private String getCellValueSafe(Map<Integer, String> row, int colIndex) {
        if (row == null) {
            return "";
        }
        String value = row.get(colIndex);
        return value != null ? value.trim() : "";
    }

    /**
     * 检查是否为空行
     */
    private boolean isEmptyRow(Map<Integer, String> row) {
        if (row == null || row.isEmpty()) {
            return true;
        }
        return row.values().stream().allMatch(value ->
                value == null || value.trim().isEmpty()
        );
    }

    /**
     * 检查是否为说明行
     */
    private boolean isDescriptionRow(Map<Integer, String> row) {
        if (row == null || row.isEmpty()) {
            return false;
        }
        String firstCell = getCellValueSafe(row, 0);
        return firstCell.contains("↓↓↓") || firstCell.contains("使用说明");
    }

    /**
     * 获取最小列数
     */
    private int getMinColumnSize(List<Map<Integer, String>> rows) {
        return rows.stream()
                .mapToInt(Map::size)
                .min()
                .orElse(0);
    }

    /**
     * 获取最大列数
     */
    private int getMaxColumns(List<Map<Integer, String>> sheetData) {
        return sheetData.stream()
                .mapToInt(Map::size)
                .max()
                .orElse(0);
    }

    /**
     * 映射数据类型到字段类型
     */
    private String mapDataTypeToFieldType(String dataType) {
        if (StringUtils.isBlank(dataType)) {
            return "input";
        }

        String lowerType = dataType.toLowerCase();
        if (lowerType.contains("datetime") || lowerType.contains("timestamp")) {
            return "datetime";
        } else if (lowerType.contains("json")) {
            return "json";
        } else if (lowerType.contains("boolean")
                || "tinyint(1)".equals(lowerType)
                || "tinyint".equals(lowerType)
                || "bool".equals(lowerType)) {
            return "boolean";
        } else if (lowerType.contains("decimal") || lowerType.contains("numeric")
                || lowerType.contains("float") || lowerType.contains("double")) {
            return "decimal";
        } else if (lowerType.contains("bigint")) {
            return "bigint";
        } else if (lowerType.contains("int") || lowerType.contains("number")) {
            return "number";
        } else if (lowerType.contains("date")) {
            return "date";
        } else if (lowerType.contains("text")) {
            return "textarea";
        } else {
            return "input";
        }
    }

    /**
     * 获取数据类型
     */
    private String getDataType(String fieldType) {
        if (StringUtils.isBlank(fieldType)) {
            return "VARCHAR(255)";
        }

        String trimmedType = fieldType.trim();
        Matcher matcher = SQL_TYPE_WITH_PARAMS.matcher(trimmedType);
        if (matcher.matches()) {
            String baseType = matcher.group(1).toUpperCase(Locale.ROOT);
            String params = matcher.group(2).replaceAll("\\s+", "");
            switch (baseType) {
                case "VARCHAR":
                case "CHAR":
                case "DECIMAL":
                case "NUMERIC":
                case "INT":
                case "INTEGER":
                case "BIGINT":
                case "TINYINT":
                    return ("INTEGER".equals(baseType) ? "INT" : baseType) + "(" + params + ")";
                default:
                    break;
            }
        }

        String lowerType = trimmedType.toLowerCase(Locale.ROOT);
        switch (lowerType) {
            case "input":
            case "select":
            case "checkbox":
            case "varchar":
            case "char":
                return "VARCHAR(255)";
            case "int":
            case "integer":
            case "number":
                return "INT";
            case "bigint":
                return "BIGINT";
            case "decimal":
            case "numeric":
            case "float":
            case "double":
                return "DECIMAL(10,2)";
            case "date":
                return "DATE";
            case "datetime":
            case "timestamp":
                return "DATETIME";
            case "text":
            case "textarea":
            case "richtext":
                return "TEXT";
            case "boolean":
            case "bool":
            case "switch":
                return "TINYINT(1)";
            case "json":
                return "JSON";
            default:
                return "VARCHAR(255)";
        }
    }

    private Integer extractFieldLength(String dataType) {
        if (StringUtils.isBlank(dataType)) {
            return null;
        }

        Matcher matcher = SQL_TYPE_WITH_PARAMS.matcher(dataType.trim());
        if (!matcher.matches()) {
            return null;
        }

        String baseType = matcher.group(1).toUpperCase(Locale.ROOT);
        if (!Arrays.asList("VARCHAR", "CHAR", "DECIMAL", "NUMERIC", "INT", "INTEGER", "BIGINT").contains(baseType)) {
            return null;
        }

        String[] params = matcher.group(2).split(",");
        if (params.length == 0 || !StringUtils.isNumeric(params[0].trim())) {
            return null;
        }
        return Integer.parseInt(params[0].trim());
    }

    /**
     * 转换单元格值
     */
    private Object convertCellValue(String cellValue, String fieldType) {
        if (StringUtils.isBlank(cellValue)) {
            return null;
        }

        String trimmedValue = cellValue.trim();
        try {
            switch (fieldType) {
                case "number":
                    return Integer.parseInt(trimmedValue);
                case "decimal":
                    return new BigDecimal(trimmedValue);
                case "boolean":
                    return "是".equals(trimmedValue) || "true".equalsIgnoreCase(trimmedValue) ||
                            "1".equals(trimmedValue) ? 1 : 0;
                case "date":
                case "datetime":
                    // 日期类型暂时返回字符串，后续可以添加日期解析逻辑
                    return trimmedValue;
                default:
                    return trimmedValue;
            }
        } catch (Exception e) {
            log.warn("单元格值转换失败: {} -> {}, 使用原始值", cellValue, fieldType);
            return trimmedValue; // 转换失败返回原始字符串
        }
    }

    /**
     * 生成模块编码
     */
    private String generateModuleCode(String baseName) {
        String cleanName = baseName.replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", "_")
                .replaceAll("_+", "_")
                .toLowerCase();

        if (cleanName.length() > 50) {
            cleanName = cleanName.substring(0, 50);
        }

        return cleanName + "_module";
    }
}
