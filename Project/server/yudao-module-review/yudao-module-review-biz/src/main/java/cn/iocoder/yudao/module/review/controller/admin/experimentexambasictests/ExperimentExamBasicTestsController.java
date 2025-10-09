package cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambasictests.ExperimentExamBasicTestsDO;
import cn.iocoder.yudao.module.review.service.experimentexambasictests.ExperimentExamBasicTestsService;

@Tag(name = "管理后台 - 实验组体检-基本检测信息")
@RestController
@RequestMapping("/review/experiment-exam-basic-tests")
@Validated
public class ExperimentExamBasicTestsController {

    @Resource
    private ExperimentExamBasicTestsService experimentExamBasicTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-基本检测信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:create')")
    public CommonResult<Long> createExperimentExamBasicTests(@Valid @RequestBody ExperimentExamBasicTestsSaveReqVO createReqVO) {
        return success(experimentExamBasicTestsService.createExperimentExamBasicTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-基本检测信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:update')")
    public CommonResult<Boolean> updateExperimentExamBasicTests(@Valid @RequestBody ExperimentExamBasicTestsSaveReqVO updateReqVO) {
        experimentExamBasicTestsService.updateExperimentExamBasicTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:delete')")
    public CommonResult<Boolean> deleteExperimentExamBasicTests(@RequestParam("id") Long id) {
        experimentExamBasicTestsService.deleteExperimentExamBasicTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:query')")
    public CommonResult<ExperimentExamBasicTestsRespVO> getExperimentExamBasicTests(@RequestParam("id") Long id) {
        ExperimentExamBasicTestsDO experimentExamBasicTests = experimentExamBasicTestsService.getExperimentExamBasicTests(id);
        return success(BeanUtils.toBean(experimentExamBasicTests, ExperimentExamBasicTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-基本检测信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:query')")
    public CommonResult<PageResult<ExperimentExamBasicTestsRespVO>> getExperimentExamBasicTestsPage(@Valid ExperimentExamBasicTestsPageReqVO pageReqVO) {
        PageResult<ExperimentExamBasicTestsDO> pageResult = experimentExamBasicTestsService.getExperimentExamBasicTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamBasicTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-基本检测信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-basic-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamBasicTestsExcel(@Valid ExperimentExamBasicTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamBasicTestsDO> list = experimentExamBasicTestsService.getExperimentExamBasicTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-基本检测信息.xls", "数据", ExperimentExamBasicTestsRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamBasicTestsRespVO.class));
    }

}