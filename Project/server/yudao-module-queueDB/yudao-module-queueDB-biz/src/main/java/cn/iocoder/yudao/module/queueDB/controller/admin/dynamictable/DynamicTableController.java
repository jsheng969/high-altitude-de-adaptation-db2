package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable;

import cn.hutool.db.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelImportResultVO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.FieldDisplayVO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ImportHistoryVO;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dynamic")
@Tag(name = "动态表管理")
@Slf4j
public class DynamicTableController {

    @Resource
    private DynamicTableService dynamicTableService;

    @PostMapping("/generate/{moduleCode}")
    @Operation(summary = "根据模块生成表结构")
    public CommonResult<Boolean> generateTable(@PathVariable String moduleCode) {
        dynamicTableService.createOrUpdateTable(moduleCode);
        return success(true);
    }

    @DeleteMapping("/drop/{moduleCode}")
    @Operation(summary = "删除动态表")
    public CommonResult<Boolean> dropTable(@PathVariable String moduleCode) {
        dynamicTableService.dropTable(moduleCode);
        return success(true);
    }

    /**
     * 导入Excel文件创建动态模块
     */
    @PostMapping("/excel")
    public CommonResult<ExcelImportResultVO> importExcel(@Valid ExcelImportReqDTO importReq) {
        log.info("开始导入Excel文件: {}", importReq.getFile().getOriginalFilename());
        try {
            ExcelImportResultVO result = dynamicTableService.importExcel(importReq);
            if (result.getSuccess()) {
                log.info("Excel导入成功: {}", result.getMessage());
                return CommonResult.success(result);
            } else {
                log.warn("Excel导入失败: {}", result.getMessage());
                return CommonResult.error(500, result.getMessage());
            }
        } catch (Exception e) {
            log.error("Excel导入异常", e);
            return CommonResult.error(500, "导入异常: " + e.getMessage());
        }
    }

    /**
     * 批量导入Excel文件
     */
    @PostMapping("/batch")
    public CommonResult<List<ExcelImportResultVO>> batchImport(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam(value = "moduleType", defaultValue = "survey") String moduleType,
            @RequestParam(value = "groupType", defaultValue = "general") String groupType) {

        log.info("批量导入Excel文件, 数量: {}", files.length);

        if (files == null || files.length == 0) {
            return CommonResult.error(400, "请选择要导入的文件");
        }

        List<ExcelImportResultVO> results = new ArrayList<>();
        for (MultipartFile file : files) {
            ExcelImportReqDTO importReq = new ExcelImportReqDTO();
            importReq.setFile(file);
            importReq.setModuleType(moduleType);
            importReq.setGroupType(groupType);

            ExcelImportResultVO result = dynamicTableService.importExcel(importReq);
            results.add(result);
        }

        return CommonResult.success(results);
    }

    /**
     * 检查模块编码是否已存在
     */
    @GetMapping("/check-module")
    public CommonResult<Boolean> checkModuleExists(@RequestParam String moduleCode) {
        try {
            boolean exists = dynamicTableService.checkModuleExists(moduleCode);
            return CommonResult.success(exists);
        } catch (Exception e) {
            log.error("检查模块存在性失败", e);
            return CommonResult.error(500, "检查失败");
        }
    }

    /**
     * 获取导入历史
     */
    @GetMapping("/history")
    public CommonResult<PageResult<ImportHistoryVO>> getImportHistory(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            PageResult<ImportHistoryVO> history = dynamicTableService.getImportHistory(pageNo, pageSize);
            return CommonResult.success(history);
        } catch (Exception e) {
            log.error("获取导入历史失败", e);
            return CommonResult.error(500, "获取历史失败");
        }
    }

    /**
     * 下载Excel导入模板
     */
    @GetMapping("/template")
    public void downloadTemplate(
            @RequestParam(value = "type", defaultValue = "simple") String templateType,
            HttpServletResponse response) {
        log.info("下载Excel模板, 类型: {}", templateType);
        try {
            dynamicTableService.downloadTemplate(response, templateType);
        } catch (Exception e) {
            log.error("下载模板失败", e);
            throw new RuntimeException("下载模板失败", e);
        }
    }

    /**
     * 查询动态表数据
     */
    @PostMapping("/query")
    public CommonResult<DynamicTableQueryRespDTO> queryDynamicTables(@RequestBody DynamicTableQueryReqDTO reqDTO) {
        DynamicTableQueryRespDTO result = dynamicTableService.queryDynamicTables(reqDTO);
        return CommonResult.success(result);
    }

    /**
     * 获取可查询的模块列表
     */
    @GetMapping("/queryable-modules")
    public CommonResult<List<ModuleConfigDO>> getQueryableModules() {
        List<ModuleConfigDO> modules = dynamicTableService.getQueryableModules();
        return CommonResult.success(modules);
    }

    /**
     * 根据模块名称获取字段配置
     */
    @PostMapping("/module-fields")
    public CommonResult<List<FieldDisplayVO>> getModuleFields(@RequestBody List<String> moduleNames) {
        List<FieldDisplayVO> fields = dynamicTableService.getModuleFields(moduleNames);
        return CommonResult.success(fields);
    }

    /**
     * 导出模块数据（按导入模板格式）
     */
    @GetMapping("/export/{moduleCode}")
    @Operation(summary = "导出模块数据")
    public void exportData(@PathVariable String moduleCode, HttpServletResponse response) {
        log.info("开始导出模块数据: {}", moduleCode);
        try {
            DynamicTableExportReqDTO exportReq = new DynamicTableExportReqDTO();
            exportReq.setModuleCode(moduleCode);
            exportReq.setExportAll(true);
            exportReq.setMaxExport(10000);
            dynamicTableService.exportDataByQuery(exportReq, response);
        } catch (Exception e) {
            log.error("导出数据失败", e);
            throw new RuntimeException("导出失败: " + e.getMessage());
        }
    }

    /**
     * 按条件导出数据
     */
    @PostMapping("/export/query")
    @Operation(summary = "按条件导出数据")
    public void exportDataByQuery(@RequestBody DynamicTableExportReqDTO exportReq,
                                  HttpServletResponse response) {
        log.info("开始按条件导出数据: {}", exportReq.getModuleCode());
        try {
            dynamicTableService.exportDataByQuery(exportReq, response);
        } catch (Exception e) {
            log.error("按条件导出数据失败", e);
            throw new RuntimeException("导出失败: " + e.getMessage());
        }
    }

    /**
     * 批量导出多个模块数据
     */
    @PostMapping("/export/batch")
    @Operation(summary = "批量导出多个模块数据")
    public void batchExportData(@RequestBody BatchExportReqDTO batchExportReq,
                                HttpServletResponse response) {
        log.info("开始批量导出数据: 模块数量={}", batchExportReq.getModuleCodes().size());
        try {
            dynamicTableService.batchExportData(batchExportReq, response);
        } catch (Exception e) {
            log.error("批量导出数据失败", e);
            throw new RuntimeException("批量导出失败: " + e.getMessage());
        }
    }

    /**
     * 导出当前查询结果（配合前端表格导出）
     */
    @PostMapping("/export/current")
    @Operation(summary = "导出当前查询结果")
    public void exportCurrentQuery(@RequestBody DynamicTableExportReqDTO exportReq,
                                   HttpServletResponse response) {
        log.info("开始导出当前查询结果: {}", exportReq.getModuleCode());
        try {
            // 限制导出数量，避免导出过多
            exportReq.setExportAll(false);
            if (exportReq.getMaxExport() == null) {
                exportReq.setMaxExport(10000);
            }
            dynamicTableService.exportDataByQuery(exportReq, response);
        } catch (Exception e) {
            log.error("导出当前查询结果失败", e);
            throw new RuntimeException("导出失败: " + e.getMessage());
        }
    }

}
