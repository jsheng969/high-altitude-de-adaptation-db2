package cn.iocoder.yudao.module.queueDB.controller.admin.registry;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.registry.RegistryDO;
import cn.iocoder.yudao.module.queueDB.service.registry.RegistryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "管理后台 - 动态表注册")
@RestController
@RequestMapping("/queueDB/registry")
@Validated
public class RegistryController {

    @Resource
    private RegistryService registryService;

    @PostMapping("/create")
    @Operation(summary = "创建动态表注册")
    @PreAuthorize("@ss.hasPermission('queueDB:registry:create')")
    public CommonResult<Long> createRegistry(@Valid @RequestBody RegistrySaveReqVO createReqVO) {
        return success(registryService.createRegistry(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新动态表注册")
    @PreAuthorize("@ss.hasPermission('queueDB:registry:update')")
    public CommonResult<Boolean> updateRegistry(@Valid @RequestBody RegistrySaveReqVO updateReqVO) {
        registryService.updateRegistry(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除动态表注册")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('queueDB:registry:delete')")
    public CommonResult<Boolean> deleteRegistry(@RequestParam("id") Long id) {
        registryService.deleteRegistry(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得动态表注册")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('queueDB:registry:query')")
    public CommonResult<RegistryRespVO> getRegistry(@RequestParam("id") Long id) {
        RegistryDO registry = registryService.getRegistry(id);
        return success(BeanUtils.toBean(registry, RegistryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得动态表注册分页")
    @PreAuthorize("@ss.hasPermission('queueDB:registry:query')")
    public CommonResult<PageResult<RegistryRespVO>> getRegistryPage(@Valid RegistryPageReqVO pageReqVO) {
        PageResult<RegistryDO> pageResult = registryService.getRegistryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RegistryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出动态表注册 Excel")
    @PreAuthorize("@ss.hasPermission('queueDB:registry:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRegistryExcel(@Valid RegistryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<RegistryDO> list = registryService.getRegistryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "动态表注册.xls", "数据", RegistryRespVO.class,
                        BeanUtils.toBean(list, RegistryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获取所有动态表注册信息")
    public CommonResult<List<RegistryRespVO>> listAll() {
        List<RegistryDO> list = registryService.listAll();
        return success(BeanUtils.toBean(list, RegistryRespVO.class));
    }

}