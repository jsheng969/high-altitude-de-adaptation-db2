package cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.queueDB.service.dynamic.DynamicTableService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/dynamic-table")
@Tag(name = "动态表管理")
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
}
