package cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine;

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

import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambloodroutine.ControlExamBloodRoutineDO;
import cn.iocoder.yudao.module.review.service.controlexambloodroutine.ControlExamBloodRoutineService;

@Tag(name = "管理后台 - 对照组体检-血常规")
@RestController
@RequestMapping("/review/control-exam-blood-routine")
@Validated
public class ControlExamBloodRoutineController {

    @Resource
    private ControlExamBloodRoutineService controlExamBloodRoutineService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-血常规")
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:create')")
    public CommonResult<Long> createControlExamBloodRoutine(@Valid @RequestBody ControlExamBloodRoutineSaveReqVO createReqVO) {
        return success(controlExamBloodRoutineService.createControlExamBloodRoutine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-血常规")
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:update')")
    public CommonResult<Boolean> updateControlExamBloodRoutine(@Valid @RequestBody ControlExamBloodRoutineSaveReqVO updateReqVO) {
        controlExamBloodRoutineService.updateControlExamBloodRoutine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-血常规")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:delete')")
    public CommonResult<Boolean> deleteControlExamBloodRoutine(@RequestParam("id") Long id) {
        controlExamBloodRoutineService.deleteControlExamBloodRoutine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-血常规")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:query')")
    public CommonResult<ControlExamBloodRoutineRespVO> getControlExamBloodRoutine(@RequestParam("id") Long id) {
        ControlExamBloodRoutineDO controlExamBloodRoutine = controlExamBloodRoutineService.getControlExamBloodRoutine(id);
        return success(BeanUtils.toBean(controlExamBloodRoutine, ControlExamBloodRoutineRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-血常规分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:query')")
    public CommonResult<PageResult<ControlExamBloodRoutineRespVO>> getControlExamBloodRoutinePage(@Valid ControlExamBloodRoutinePageReqVO pageReqVO) {
        PageResult<ControlExamBloodRoutineDO> pageResult = controlExamBloodRoutineService.getControlExamBloodRoutinePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamBloodRoutineRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-血常规 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-blood-routine:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamBloodRoutineExcel(@Valid ControlExamBloodRoutinePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamBloodRoutineDO> list = controlExamBloodRoutineService.getControlExamBloodRoutinePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-血常规.xls", "数据", ControlExamBloodRoutineRespVO.class,
                        BeanUtils.toBean(list, ControlExamBloodRoutineRespVO.class));
    }

}