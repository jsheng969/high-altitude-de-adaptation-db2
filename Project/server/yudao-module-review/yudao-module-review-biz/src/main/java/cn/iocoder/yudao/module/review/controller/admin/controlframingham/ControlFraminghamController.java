package cn.iocoder.yudao.module.review.controller.admin.controlframingham;

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

import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlframingham.ControlFraminghamDO;
import cn.iocoder.yudao.module.review.service.controlframingham.ControlFraminghamService;

@Tag(name = "管理后台 - 对照组-framingham评分")
@RestController
@RequestMapping("/review/control-framingham")
@Validated
public class ControlFraminghamController {

    @Resource
    private ControlFraminghamService controlFraminghamService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组-framingham评分")
    @PreAuthorize("@ss.hasPermission('review:control-framingham:create')")
    public CommonResult<Long> createControlFramingham(@Valid @RequestBody ControlFraminghamSaveReqVO createReqVO) {
        return success(controlFraminghamService.createControlFramingham(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组-framingham评分")
    @PreAuthorize("@ss.hasPermission('review:control-framingham:update')")
    public CommonResult<Boolean> updateControlFramingham(@Valid @RequestBody ControlFraminghamSaveReqVO updateReqVO) {
        controlFraminghamService.updateControlFramingham(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组-framingham评分")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-framingham:delete')")
    public CommonResult<Boolean> deleteControlFramingham(@RequestParam("id") Long id) {
        controlFraminghamService.deleteControlFramingham(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组-framingham评分")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-framingham:query')")
    public CommonResult<ControlFraminghamRespVO> getControlFramingham(@RequestParam("id") Long id) {
        ControlFraminghamDO controlFramingham = controlFraminghamService.getControlFramingham(id);
        return success(BeanUtils.toBean(controlFramingham, ControlFraminghamRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组-framingham评分分页")
    @PreAuthorize("@ss.hasPermission('review:control-framingham:query')")
    public CommonResult<PageResult<ControlFraminghamRespVO>> getControlFraminghamPage(@Valid ControlFraminghamPageReqVO pageReqVO) {
        PageResult<ControlFraminghamDO> pageResult = controlFraminghamService.getControlFraminghamPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlFraminghamRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组-framingham评分 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-framingham:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlFraminghamExcel(@Valid ControlFraminghamPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlFraminghamDO> list = controlFraminghamService.getControlFraminghamPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组-framingham评分.xls", "数据", ControlFraminghamRespVO.class,
                        BeanUtils.toBean(list, ControlFraminghamRespVO.class));
    }

}