package cn.iocoder.yudao.module.review.controller.admin.controlexambasictests;

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

import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambasictests.ControlExamBasicTestsDO;
import cn.iocoder.yudao.module.review.service.controlexambasictests.ControlExamBasicTestsService;

@Tag(name = "管理后台 - 对照组体检-基本检测信息")
@RestController
@RequestMapping("/review/control-exam-basic-tests")
@Validated
public class ControlExamBasicTestsController {

    @Resource
    private ControlExamBasicTestsService controlExamBasicTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-基本检测信息")
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:create')")
    public CommonResult<Long> createControlExamBasicTests(@Valid @RequestBody ControlExamBasicTestsSaveReqVO createReqVO) {
        return success(controlExamBasicTestsService.createControlExamBasicTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-基本检测信息")
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:update')")
    public CommonResult<Boolean> updateControlExamBasicTests(@Valid @RequestBody ControlExamBasicTestsSaveReqVO updateReqVO) {
        controlExamBasicTestsService.updateControlExamBasicTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:delete')")
    public CommonResult<Boolean> deleteControlExamBasicTests(@RequestParam("id") Long id) {
        controlExamBasicTestsService.deleteControlExamBasicTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:query')")
    public CommonResult<ControlExamBasicTestsRespVO> getControlExamBasicTests(@RequestParam("id") Long id) {
        ControlExamBasicTestsDO controlExamBasicTests = controlExamBasicTestsService.getControlExamBasicTests(id);
        return success(BeanUtils.toBean(controlExamBasicTests, ControlExamBasicTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-基本检测信息分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:query')")
    public CommonResult<PageResult<ControlExamBasicTestsRespVO>> getControlExamBasicTestsPage(@Valid ControlExamBasicTestsPageReqVO pageReqVO) {
        PageResult<ControlExamBasicTestsDO> pageResult = controlExamBasicTestsService.getControlExamBasicTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamBasicTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-基本检测信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-basic-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamBasicTestsExcel(@Valid ControlExamBasicTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamBasicTestsDO> list = controlExamBasicTestsService.getControlExamBasicTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-基本检测信息.xls", "数据", ControlExamBasicTestsRespVO.class,
                        BeanUtils.toBean(list, ControlExamBasicTestsRespVO.class));
    }

}