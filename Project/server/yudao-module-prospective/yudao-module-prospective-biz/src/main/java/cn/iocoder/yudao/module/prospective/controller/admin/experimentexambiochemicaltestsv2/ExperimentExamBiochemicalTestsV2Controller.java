package cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.module.prospective.service.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2Service;

@Tag(name = "管理后台 - 实验组体检-生化v2")
@RestController
@RequestMapping("/prospective/experiment-exam-biochemical-tests-v2")
@Validated
public class ExperimentExamBiochemicalTestsV2Controller {

    @Resource
    private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-生化v2")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:create')")
    public CommonResult<Long> createExperimentExamBiochemicalTestsV2(@Valid @RequestBody ExperimentExamBiochemicalTestsV2SaveReqVO createReqVO) {
        return success(experimentExamBiochemicalTestsV2Service.createExperimentExamBiochemicalTestsV2(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-生化v2")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:update')")
    public CommonResult<Boolean> updateExperimentExamBiochemicalTestsV2(@Valid @RequestBody ExperimentExamBiochemicalTestsV2SaveReqVO updateReqVO) {
        experimentExamBiochemicalTestsV2Service.updateExperimentExamBiochemicalTestsV2(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-生化v2")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:delete')")
    public CommonResult<Boolean> deleteExperimentExamBiochemicalTestsV2(@RequestParam("id") Long id) {
        experimentExamBiochemicalTestsV2Service.deleteExperimentExamBiochemicalTestsV2(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-生化v2")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:query')")
    public CommonResult<ExperimentExamBiochemicalTestsV2RespVO> getExperimentExamBiochemicalTestsV2(@RequestParam("id") Long id) {
        ExperimentExamBiochemicalTestsV2DO experimentExamBiochemicalTestsV2 = experimentExamBiochemicalTestsV2Service.getExperimentExamBiochemicalTestsV2(id);
        return success(BeanUtils.toBean(experimentExamBiochemicalTestsV2, ExperimentExamBiochemicalTestsV2RespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-生化v2分页")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:query')")
    public CommonResult<PageResult<ExperimentExamBiochemicalTestsV2RespVO>> getExperimentExamBiochemicalTestsV2Page(@Valid ExperimentExamBiochemicalTestsV2PageReqVO pageReqVO) {
        PageResult<ExperimentExamBiochemicalTestsV2DO> pageResult = experimentExamBiochemicalTestsV2Service.getExperimentExamBiochemicalTestsV2Page(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamBiochemicalTestsV2RespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-生化v2 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-biochemical-tests-v2:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamBiochemicalTestsV2Excel(@Valid ExperimentExamBiochemicalTestsV2PageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamBiochemicalTestsV2DO> list = experimentExamBiochemicalTestsV2Service.getExperimentExamBiochemicalTestsV2Page(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-生化v2.xls", "数据", ExperimentExamBiochemicalTestsV2RespVO.class,
                        BeanUtils.toBean(list, ExperimentExamBiochemicalTestsV2RespVO.class));
    }

}