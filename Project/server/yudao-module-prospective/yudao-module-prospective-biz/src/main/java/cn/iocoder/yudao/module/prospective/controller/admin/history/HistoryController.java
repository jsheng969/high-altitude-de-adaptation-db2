package cn.iocoder.yudao.module.prospective.controller.admin.history;

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

import cn.iocoder.yudao.module.prospective.controller.admin.history.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.history.HistoryDO;
import cn.iocoder.yudao.module.prospective.service.history.HistoryService;

@Tag(name = "管理后台 - 预警历史记录")
@RestController
@RequestMapping("/warning/history")
@Validated
public class HistoryController {

    @Resource
    private HistoryService historyService;

    @PostMapping("/create")
    @Operation(summary = "创建预警历史记录")
    @PreAuthorize("@ss.hasPermission('warning:history:create')")
    public CommonResult<Integer> createHistory(@Valid @RequestBody HistorySaveReqVO createReqVO) {
        return success(historyService.createHistory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新预警历史记录")
    @PreAuthorize("@ss.hasPermission('warning:history:update')")
    public CommonResult<Boolean> updateHistory(@Valid @RequestBody HistorySaveReqVO updateReqVO) {
        historyService.updateHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除预警历史记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('warning:history:delete')")
    public CommonResult<Boolean> deleteHistory(@RequestParam("id") Integer id) {
        historyService.deleteHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得预警历史记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('warning:history:query')")
    public CommonResult<HistoryRespVO> getHistory(@RequestParam("id") Integer id) {
        HistoryDO history = historyService.getHistory(id);
        return success(BeanUtils.toBean(history, HistoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得预警历史记录分页")
    @PreAuthorize("@ss.hasPermission('warning:history:query')")
    public CommonResult<PageResult<HistoryRespVO>> getHistoryPage(@Valid HistoryPageReqVO pageReqVO) {
        PageResult<HistoryDO> pageResult = historyService.getHistoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, HistoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出预警历史记录 Excel")
    @PreAuthorize("@ss.hasPermission('warning:history:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportHistoryExcel(@Valid HistoryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<HistoryDO> list = historyService.getHistoryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "预警历史记录.xls", "数据", HistoryRespVO.class,
                        BeanUtils.toBean(list, HistoryRespVO.class));
    }

}