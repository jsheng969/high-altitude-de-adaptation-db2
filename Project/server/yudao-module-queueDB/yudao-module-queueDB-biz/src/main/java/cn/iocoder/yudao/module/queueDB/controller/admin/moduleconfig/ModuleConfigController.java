package cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig;

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

import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import cn.iocoder.yudao.module.queueDB.service.moduleconfig.ModuleConfigService;

@Tag(name = "管理后台 - 动态模块配置表（支持三级结构）")
@RestController
@RequestMapping("/queueDB/module-config")
@Validated
public class ModuleConfigController {

    @Resource
    private ModuleConfigService moduleConfigService;

    @PostMapping("/create")
    @Operation(summary = "创建动态模块配置表（支持三级结构）")
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:create')")
    public CommonResult<Long> createModuleConfig(@Valid @RequestBody ModuleConfigSaveReqVO createReqVO) {
        return success(moduleConfigService.createModuleConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新动态模块配置表（支持三级结构）")
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:update')")
    public CommonResult<Boolean> updateModuleConfig(@Valid @RequestBody ModuleConfigSaveReqVO updateReqVO) {
        moduleConfigService.updateModuleConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除动态模块配置表（支持三级结构）")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:delete')")
    public CommonResult<Boolean> deleteModuleConfig(@RequestParam("id") Long id) {
        moduleConfigService.deleteModuleConfig(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得动态模块配置表（支持三级结构）")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:query')")
    public CommonResult<ModuleConfigRespVO> getModuleConfig(@RequestParam("id") Long id) {
        ModuleConfigDO moduleConfig = moduleConfigService.getModuleConfig(id);
        return success(BeanUtils.toBean(moduleConfig, ModuleConfigRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得动态模块配置表（支持三级结构）分页")
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:query')")
    public CommonResult<PageResult<ModuleConfigRespVO>> getModuleConfigPage(@Valid ModuleConfigPageReqVO pageReqVO) {
        PageResult<ModuleConfigDO> pageResult = moduleConfigService.getModuleConfigPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ModuleConfigRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出动态模块配置表（支持三级结构） Excel")
    @PreAuthorize("@ss.hasPermission('queueDB:module-config:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportModuleConfigExcel(@Valid ModuleConfigPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ModuleConfigDO> list = moduleConfigService.getModuleConfigPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "动态模块配置表（支持三级结构）.xls", "数据", ModuleConfigRespVO.class,
                        BeanUtils.toBean(list, ModuleConfigRespVO.class));
    }

    @GetMapping("/tree")
    @Operation(summary = "获取模块树结构")
    public CommonResult<List<ModuleConfigDO>> tree() {
        return success(moduleConfigService.getModuleTree());
    }

    @GetMapping("/tree-with-stats")
    @Operation(summary = "获取模块树（包含字段统计）")
    public CommonResult<List<ModuleConfigTreeVO>> getModuleTreeWithStats() {
        return success(moduleConfigService.getModuleTreeWithStats());
    }

    @GetMapping("/check-code")
    @Operation(summary = "检查模块代码是否可用")
    public CommonResult<Boolean> checkModuleCode(@RequestParam("moduleCode") String moduleCode) {
        return success(moduleConfigService.checkModuleCodeAvailable(moduleCode));
    }

    /**
     * 获取模块及其字段列表（用于前端动态展示）
     */
    @GetMapping("with-fields")
    public CommonResult<List<ModuleWithFieldsRespVO>> getModulesWithFields() {
        return CommonResult.success(moduleConfigService.getModulesWithFields());
    }

    @GetMapping("/tree-with-fields")
    @Operation(summary = "获取模块树（包含字段）")
    public CommonResult<List<ModuleConfigRespVO>> getModuleTreeWithFields() {
        List<ModuleConfigRespVO> tree = moduleConfigService.getModuleTreeWithFields();
        return success(tree);
    }

    @GetMapping("/base-modules")
    @Operation(summary = "获取基础信息模块（一级模块）")
    public CommonResult<List<ModuleConfigRespVO>> getBaseModules() {
        List<ModuleConfigDO> modules = moduleConfigService.getBaseModules();
        return success(BeanUtils.toBean(modules, ModuleConfigRespVO.class));
    }

    @GetMapping("/detail/{moduleCode}")
    @Operation(summary = "根据模块编码获取模块详情（包含子模块和字段）")
    public CommonResult<ModuleConfigRespVO> getModuleDetail(@PathVariable String moduleCode) {
        // 这里需要实现根据moduleCode获取模块详情的方法
        ModuleConfigRespVO detail = moduleConfigService.getModuleDetailByCode(moduleCode);
        return success(detail);
    }
}