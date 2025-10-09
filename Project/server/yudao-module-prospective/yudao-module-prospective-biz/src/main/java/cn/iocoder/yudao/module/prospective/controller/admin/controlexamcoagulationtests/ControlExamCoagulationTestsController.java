package cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamcoagulationtests.ControlExamCoagulationTestsDO;
import cn.iocoder.yudao.module.prospective.service.controlexamcoagulationtests.ControlExamCoagulationTestsService;

@Tag(name = "管理后台 - 实验组体检-凝血功能")
@RestController
@RequestMapping("/prospective/control-exam-coagulation-tests")
@Validated
public class ControlExamCoagulationTestsController {

    @Resource
    private ControlExamCoagulationTestsService controlExamCoagulationTestsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-凝血功能")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:create')")
    public CommonResult<Long> createControlExamCoagulationTests(@Valid @RequestBody ControlExamCoagulationTestsSaveReqVO createReqVO) {
        return success(controlExamCoagulationTestsService.createControlExamCoagulationTests(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-凝血功能")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:update')")
    public CommonResult<Boolean> updateControlExamCoagulationTests(@Valid @RequestBody ControlExamCoagulationTestsSaveReqVO updateReqVO) {
        controlExamCoagulationTestsService.updateControlExamCoagulationTests(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-凝血功能")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:delete')")
    public CommonResult<Boolean> deleteControlExamCoagulationTests(@RequestParam("id") Long id) {
        controlExamCoagulationTestsService.deleteControlExamCoagulationTests(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-凝血功能")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:query')")
    public CommonResult<ControlExamCoagulationTestsRespVO> getControlExamCoagulationTests(@RequestParam("id") Long id) {
        ControlExamCoagulationTestsDO controlExamCoagulationTests = controlExamCoagulationTestsService.getControlExamCoagulationTests(id);
        return success(BeanUtils.toBean(controlExamCoagulationTests, ControlExamCoagulationTestsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-凝血功能分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:query')")
    public CommonResult<PageResult<ControlExamCoagulationTestsRespVO>> getControlExamCoagulationTestsPage(@Valid ControlExamCoagulationTestsPageReqVO pageReqVO) {
        PageResult<ControlExamCoagulationTestsDO> pageResult = controlExamCoagulationTestsService.getControlExamCoagulationTestsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamCoagulationTestsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-凝血功能 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-coagulation-tests:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamCoagulationTestsExcel(@Valid ControlExamCoagulationTestsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamCoagulationTestsDO> list = controlExamCoagulationTestsService.getControlExamCoagulationTestsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-凝血功能.xls", "数据", ControlExamCoagulationTestsRespVO.class,
                        BeanUtils.toBean(list, ControlExamCoagulationTestsRespVO.class));
    }

}