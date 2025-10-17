package cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.module.queueDB.service.fieldconfig.FieldConfigService;

@Tag(name = "管理后台 - 动态字段配置")
@RestController
@RequestMapping("/queueDB/field-config")
@Validated
public class FieldConfigController {

    @Resource
    private FieldConfigService fieldConfigService;

    @PostMapping("/create")
    @Operation(summary = "创建动态字段配置")
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:create')")
    public CommonResult<Long> createFieldConfig(@Valid @RequestBody FieldConfigSaveReqVO createReqVO) {
        return success(fieldConfigService.createFieldConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新动态字段配置")
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:update')")
    public CommonResult<Boolean> updateFieldConfig(@Valid @RequestBody FieldConfigSaveReqVO updateReqVO) {
        fieldConfigService.updateFieldConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除动态字段配置")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:delete')")
    public CommonResult<Boolean> deleteFieldConfig(@RequestParam("id") Long id) {
        fieldConfigService.deleteFieldConfig(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得动态字段配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:query')")
    public CommonResult<FieldConfigRespVO> getFieldConfig(@RequestParam("id") Long id) {
        FieldConfigDO fieldConfig = fieldConfigService.getFieldConfig(id);
        return success(BeanUtils.toBean(fieldConfig, FieldConfigRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得动态字段配置分页")
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:query')")
    public CommonResult<PageResult<FieldConfigRespVO>> getFieldConfigPage(@Valid FieldConfigPageReqVO pageReqVO) {
        PageResult<FieldConfigDO> pageResult = fieldConfigService.getFieldConfigPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FieldConfigRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出动态字段配置 Excel")
    @PreAuthorize("@ss.hasPermission('queueDB:field-config:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFieldConfigExcel(@Valid FieldConfigPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FieldConfigDO> list = fieldConfigService.getFieldConfigPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "动态字段配置.xls", "数据", FieldConfigRespVO.class,
                        BeanUtils.toBean(list, FieldConfigRespVO.class));
    }

    @GetMapping("/list")
    public CommonResult<List<FieldConfigRespVO>> listByModuleCode(@RequestParam("moduleCode") String moduleCode) {
        List<FieldConfigDO> fieldConfigDOS = fieldConfigService.listByModuleCode(moduleCode);
        List<FieldConfigRespVO> bean = BeanUtils.toBean(fieldConfigDOS, FieldConfigRespVO.class);
        return success(bean);
    }

    @GetMapping("/field-type-options")
    @Operation(summary = "获取字段类型选项列表")
    public CommonResult<List<FieldTypeOptionVO>> getFieldTypeOptions() {
        return success(fieldConfigService.getFieldTypeOptions());
    }

//    @GetMapping("/data-type-by-field-type")
//    @Operation(summary = "根据字段类型获取数据库类型")
//    public CommonResult<String> getDataTypeByFieldType(
//            @RequestParam("fieldType") String fieldType,
//            @RequestParam(value = "fieldLength", required = false) Integer fieldLength) {
//        return success(fieldConfigService.getDataTypeByFieldType(fieldType, fieldLength));
//    }

    @GetMapping("/check-code")
    @Operation(summary = "获取字段类型选项列表")
    public CommonResult<Boolean> checkFieldCodeAvailable(String moduleCode,String fieldCode) {
        return success(fieldConfigService.checkFieldCodeAvailable(moduleCode,fieldCode));
    }

}