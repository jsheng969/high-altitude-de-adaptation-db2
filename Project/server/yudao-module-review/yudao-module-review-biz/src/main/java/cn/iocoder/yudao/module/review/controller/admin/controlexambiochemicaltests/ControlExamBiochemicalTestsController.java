package cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;


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

import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambiochemicaltests.ControlExamBiochemicalTestsDO;
import cn.iocoder.yudao.module.review.service.controlexambiochemicaltests.ControlExamBiochemicalTestsService;

@Tag(name = "管理后台 - 对照组体检-生化")
@RestController
@RequestMapping("/review/control-exam-biochemical-tests")
@Validated
public class ControlExamBiochemicalTestsController {

    @Resource
    private ControlExamBiochemicalTestsService controlExamBiochemicalTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-生化")
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:create')")
    public CommonResult<Long> createControlExamBiochemicalTests(@Valid @RequestBody ControlExamBiochemicalTestsSaveReqVO createReqVO) {
        return success(controlExamBiochemicalTestsService.createControlExamBiochemicalTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-生化")
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:update')")
    public CommonResult<Boolean> updateControlExamBiochemicalTests(@Valid @RequestBody ControlExamBiochemicalTestsSaveReqVO updateReqVO) {
        controlExamBiochemicalTestsService.updateControlExamBiochemicalTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-生化")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:delete')")
    public CommonResult<Boolean> deleteControlExamBiochemicalTests(@RequestParam("id") Long id) {
        controlExamBiochemicalTestsService.deleteControlExamBiochemicalTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-生化")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:query')")
    public CommonResult<ControlExamBiochemicalTestsRespVO> getControlExamBiochemicalTests(@RequestParam("id") Long id) {
        ControlExamBiochemicalTestsDO controlExamBiochemicalTests = controlExamBiochemicalTestsService.getControlExamBiochemicalTests(id);
        return success(BeanUtils.toBean(controlExamBiochemicalTests, ControlExamBiochemicalTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-生化分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:query')")
    public CommonResult<PageResult<ControlExamBiochemicalTestsRespVO>> getControlExamBiochemicalTestsPage(@Valid ControlExamBiochemicalTestsPageReqVO pageReqVO) {
        PageResult<ControlExamBiochemicalTestsDO> pageResult = controlExamBiochemicalTestsService.getControlExamBiochemicalTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamBiochemicalTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-生化 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-biochemical-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamBiochemicalTestsExcel(@Valid ControlExamBiochemicalTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamBiochemicalTestsDO> list = controlExamBiochemicalTestsService.getControlExamBiochemicalTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-生化.xls", "数据", ControlExamBiochemicalTestsRespVO.class,
                        BeanUtils.toBean(list, ControlExamBiochemicalTestsRespVO.class));
    }

}