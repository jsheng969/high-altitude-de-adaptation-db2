package cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsDO;
import cn.iocoder.yudao.module.review.service.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsService;

@Tag(name = "管理后台 - 实验组体检-生化")
@RestController
@RequestMapping("/review/experiment-exam-biochemical-tests")
@Validated
public class ExperimentExamBiochemicalTestsController {

    @Resource
    private ExperimentExamBiochemicalTestsService experimentExamBiochemicalTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-生化")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:create')")
    public CommonResult<Long> createExperimentExamBiochemicalTests(@Valid @RequestBody ExperimentExamBiochemicalTestsSaveReqVO createReqVO) {
        return success(experimentExamBiochemicalTestsService.createExperimentExamBiochemicalTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-生化")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:update')")
    public CommonResult<Boolean> updateExperimentExamBiochemicalTests(@Valid @RequestBody ExperimentExamBiochemicalTestsSaveReqVO updateReqVO) {
        experimentExamBiochemicalTestsService.updateExperimentExamBiochemicalTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-生化")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:delete')")
    public CommonResult<Boolean> deleteExperimentExamBiochemicalTests(@RequestParam("id") Long id) {
        experimentExamBiochemicalTestsService.deleteExperimentExamBiochemicalTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-生化")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:query')")
    public CommonResult<ExperimentExamBiochemicalTestsRespVO> getExperimentExamBiochemicalTests(@RequestParam("id") Long id) {
        ExperimentExamBiochemicalTestsDO experimentExamBiochemicalTests = experimentExamBiochemicalTestsService.getExperimentExamBiochemicalTests(id);
        return success(BeanUtils.toBean(experimentExamBiochemicalTests, ExperimentExamBiochemicalTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-生化分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:query')")
    public CommonResult<PageResult<ExperimentExamBiochemicalTestsRespVO>> getExperimentExamBiochemicalTestsPage(@Valid ExperimentExamBiochemicalTestsPageReqVO pageReqVO) {
        PageResult<ExperimentExamBiochemicalTestsDO> pageResult = experimentExamBiochemicalTestsService.getExperimentExamBiochemicalTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamBiochemicalTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-生化 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-biochemical-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamBiochemicalTestsExcel(@Valid ExperimentExamBiochemicalTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamBiochemicalTestsDO> list = experimentExamBiochemicalTestsService.getExperimentExamBiochemicalTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-生化.xls", "数据", ExperimentExamBiochemicalTestsRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamBiochemicalTestsRespVO.class));
    }

}