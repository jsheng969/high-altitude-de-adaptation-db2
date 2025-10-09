package cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambloodroutine.ExperimentExamBloodRoutineDO;
import cn.iocoder.yudao.module.review.service.experimentexambloodroutine.ExperimentExamBloodRoutineService;

@Tag(name = "管理后台 - 实验组体检-血常规")
@RestController
@RequestMapping("/review/experiment-exam-blood-routine")
@Validated
public class ExperimentExamBloodRoutineController {

    @Resource
    private ExperimentExamBloodRoutineService experimentExamBloodRoutineService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-血常规")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:create')")
    public CommonResult<Long> createExperimentExamBloodRoutine(@Valid @RequestBody ExperimentExamBloodRoutineSaveReqVO createReqVO) {
        return success(experimentExamBloodRoutineService.createExperimentExamBloodRoutine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-血常规")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:update')")
    public CommonResult<Boolean> updateExperimentExamBloodRoutine(@Valid @RequestBody ExperimentExamBloodRoutineSaveReqVO updateReqVO) {
        experimentExamBloodRoutineService.updateExperimentExamBloodRoutine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-血常规")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:delete')")
    public CommonResult<Boolean> deleteExperimentExamBloodRoutine(@RequestParam("id") Long id) {
        experimentExamBloodRoutineService.deleteExperimentExamBloodRoutine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-血常规")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:query')")
    public CommonResult<ExperimentExamBloodRoutineRespVO> getExperimentExamBloodRoutine(@RequestParam("id") Long id) {
        ExperimentExamBloodRoutineDO experimentExamBloodRoutine = experimentExamBloodRoutineService.getExperimentExamBloodRoutine(id);
        return success(BeanUtils.toBean(experimentExamBloodRoutine, ExperimentExamBloodRoutineRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-血常规分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:query')")
    public CommonResult<PageResult<ExperimentExamBloodRoutineRespVO>> getExperimentExamBloodRoutinePage(@Valid ExperimentExamBloodRoutinePageReqVO pageReqVO) {
        PageResult<ExperimentExamBloodRoutineDO> pageResult = experimentExamBloodRoutineService.getExperimentExamBloodRoutinePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamBloodRoutineRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-血常规 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-blood-routine:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamBloodRoutineExcel(@Valid ExperimentExamBloodRoutinePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamBloodRoutineDO> list = experimentExamBloodRoutineService.getExperimentExamBloodRoutinePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-血常规.xls", "数据", ExperimentExamBloodRoutineRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamBloodRoutineRespVO.class));
    }

}