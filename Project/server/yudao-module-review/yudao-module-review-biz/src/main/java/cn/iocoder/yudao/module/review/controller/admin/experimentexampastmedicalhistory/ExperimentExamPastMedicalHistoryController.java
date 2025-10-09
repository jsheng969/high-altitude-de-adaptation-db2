package cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryDO;
import cn.iocoder.yudao.module.review.service.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryService;

@Tag(name = "管理后台 - 实验组体检-既往病史")
@RestController
@RequestMapping("/review/experiment-exam-past-medical-history")
@Validated
public class ExperimentExamPastMedicalHistoryController {

    @Resource
    private ExperimentExamPastMedicalHistoryService experimentExamPastMedicalHistoryService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-既往病史")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:create')")
    public CommonResult<Long> createExperimentExamPastMedicalHistory(@Valid @RequestBody ExperimentExamPastMedicalHistorySaveReqVO createReqVO) {
        return success(experimentExamPastMedicalHistoryService.createExperimentExamPastMedicalHistory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-既往病史")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:update')")
    public CommonResult<Boolean> updateExperimentExamPastMedicalHistory(@Valid @RequestBody ExperimentExamPastMedicalHistorySaveReqVO updateReqVO) {
        experimentExamPastMedicalHistoryService.updateExperimentExamPastMedicalHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-既往病史")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:delete')")
    public CommonResult<Boolean> deleteExperimentExamPastMedicalHistory(@RequestParam("id") Long id) {
        experimentExamPastMedicalHistoryService.deleteExperimentExamPastMedicalHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-既往病史")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:query')")
    public CommonResult<ExperimentExamPastMedicalHistoryRespVO> getExperimentExamPastMedicalHistory(@RequestParam("id") Long id) {
        ExperimentExamPastMedicalHistoryDO experimentExamPastMedicalHistory = experimentExamPastMedicalHistoryService.getExperimentExamPastMedicalHistory(id);
        return success(BeanUtils.toBean(experimentExamPastMedicalHistory, ExperimentExamPastMedicalHistoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-既往病史分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:query')")
    public CommonResult<PageResult<ExperimentExamPastMedicalHistoryRespVO>> getExperimentExamPastMedicalHistoryPage(@Valid ExperimentExamPastMedicalHistoryPageReqVO pageReqVO) {
        PageResult<ExperimentExamPastMedicalHistoryDO> pageResult = experimentExamPastMedicalHistoryService.getExperimentExamPastMedicalHistoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamPastMedicalHistoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-既往病史 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-past-medical-history:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamPastMedicalHistoryExcel(@Valid ExperimentExamPastMedicalHistoryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamPastMedicalHistoryDO> list = experimentExamPastMedicalHistoryService.getExperimentExamPastMedicalHistoryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-既往病史.xls", "数据", ExperimentExamPastMedicalHistoryRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamPastMedicalHistoryRespVO.class));
    }

}