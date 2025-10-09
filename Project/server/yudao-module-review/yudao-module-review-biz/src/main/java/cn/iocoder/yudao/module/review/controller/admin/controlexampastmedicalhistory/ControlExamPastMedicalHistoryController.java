package cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory;

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

import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexampastmedicalhistory.ControlExamPastMedicalHistoryDO;
import cn.iocoder.yudao.module.review.service.controlexampastmedicalhistory.ControlExamPastMedicalHistoryService;

@Tag(name = "管理后台 - 对照组体检-既往病史")
@RestController
@RequestMapping("/review/control-exam-past-medical-history")
@Validated
public class ControlExamPastMedicalHistoryController {

    @Resource
    private ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-既往病史")
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:create')")
    public CommonResult<Long> createControlExamPastMedicalHistory(@Valid @RequestBody ControlExamPastMedicalHistorySaveReqVO createReqVO) {
        return success(controlExamPastMedicalHistoryService.createControlExamPastMedicalHistory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-既往病史")
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:update')")
    public CommonResult<Boolean> updateControlExamPastMedicalHistory(@Valid @RequestBody ControlExamPastMedicalHistorySaveReqVO updateReqVO) {
        controlExamPastMedicalHistoryService.updateControlExamPastMedicalHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-既往病史")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:delete')")
    public CommonResult<Boolean> deleteControlExamPastMedicalHistory(@RequestParam("id") Long id) {
        controlExamPastMedicalHistoryService.deleteControlExamPastMedicalHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-既往病史")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:query')")
    public CommonResult<ControlExamPastMedicalHistoryRespVO> getControlExamPastMedicalHistory(@RequestParam("id") Long id) {
        ControlExamPastMedicalHistoryDO controlExamPastMedicalHistory = controlExamPastMedicalHistoryService.getControlExamPastMedicalHistory(id);
        return success(BeanUtils.toBean(controlExamPastMedicalHistory, ControlExamPastMedicalHistoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-既往病史分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:query')")
    public CommonResult<PageResult<ControlExamPastMedicalHistoryRespVO>> getControlExamPastMedicalHistoryPage(@Valid ControlExamPastMedicalHistoryPageReqVO pageReqVO) {
        PageResult<ControlExamPastMedicalHistoryDO> pageResult = controlExamPastMedicalHistoryService.getControlExamPastMedicalHistoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamPastMedicalHistoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-既往病史 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-past-medical-history:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamPastMedicalHistoryExcel(@Valid ControlExamPastMedicalHistoryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamPastMedicalHistoryDO> list = controlExamPastMedicalHistoryService.getControlExamPastMedicalHistoryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-既往病史.xls", "数据", ControlExamPastMedicalHistoryRespVO.class,
                        BeanUtils.toBean(list, ControlExamPastMedicalHistoryRespVO.class));
    }

}