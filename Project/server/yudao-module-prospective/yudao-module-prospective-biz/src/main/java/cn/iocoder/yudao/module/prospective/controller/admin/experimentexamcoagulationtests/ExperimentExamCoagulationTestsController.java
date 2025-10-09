package cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamcoagulationtests.ExperimentExamCoagulationTestsDO;
import cn.iocoder.yudao.module.prospective.service.experimentexamcoagulationtests.ExperimentExamCoagulationTestsService;

@Tag(name = "管理后台 - 实验组体检-凝血功能")
@RestController
@RequestMapping("/prospective/experiment-exam-coagulation-tests")
@Validated
public class ExperimentExamCoagulationTestsController {

    @Resource
    private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-凝血功能")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:create')")
    public CommonResult<Long> createExperimentExamCoagulationTests(@Valid @RequestBody ExperimentExamCoagulationTestsSaveReqVO createReqVO) {
        return success(experimentExamCoagulationTestsService.createExperimentExamCoagulationTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-凝血功能")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:update')")
    public CommonResult<Boolean> updateExperimentExamCoagulationTests(@Valid @RequestBody ExperimentExamCoagulationTestsSaveReqVO updateReqVO) {
        experimentExamCoagulationTestsService.updateExperimentExamCoagulationTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-凝血功能")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:delete')")
    public CommonResult<Boolean> deleteExperimentExamCoagulationTests(@RequestParam("id") Long id) {
        experimentExamCoagulationTestsService.deleteExperimentExamCoagulationTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-凝血功能")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:query')")
    public CommonResult<ExperimentExamCoagulationTestsRespVO> getExperimentExamCoagulationTests(@RequestParam("id") Long id) {
        ExperimentExamCoagulationTestsDO experimentExamCoagulationTests = experimentExamCoagulationTestsService.getExperimentExamCoagulationTests(id);
        return success(BeanUtils.toBean(experimentExamCoagulationTests, ExperimentExamCoagulationTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-凝血功能分页")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:query')")
    public CommonResult<PageResult<ExperimentExamCoagulationTestsRespVO>> getExperimentExamCoagulationTestsPage(@Valid ExperimentExamCoagulationTestsPageReqVO pageReqVO) {
        PageResult<ExperimentExamCoagulationTestsDO> pageResult = experimentExamCoagulationTestsService.getExperimentExamCoagulationTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamCoagulationTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-凝血功能 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-coagulation-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamCoagulationTestsExcel(@Valid ExperimentExamCoagulationTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamCoagulationTestsDO> list = experimentExamCoagulationTestsService.getExperimentExamCoagulationTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-凝血功能.xls", "数据", ExperimentExamCoagulationTestsRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamCoagulationTestsRespVO.class));
    }

}