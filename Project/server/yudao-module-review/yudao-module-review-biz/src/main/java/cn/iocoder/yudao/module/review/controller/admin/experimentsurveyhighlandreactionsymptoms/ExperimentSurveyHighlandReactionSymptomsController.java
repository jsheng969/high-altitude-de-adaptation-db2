package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsService;

@Tag(name = "管理后台 - 实验组流调-高原反应症状")
@RestController
@RequestMapping("/review/experiment-survey-highland-reaction-symptoms")
@Validated
public class ExperimentSurveyHighlandReactionSymptomsController {

    @Resource
    private ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-高原反应症状")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:create')")
    public CommonResult<Long> createExperimentSurveyHighlandReactionSymptoms(@Valid @RequestBody ExperimentSurveyHighlandReactionSymptomsSaveReqVO createReqVO) {
        return success(experimentSurveyHighlandReactionSymptomsService.createExperimentSurveyHighlandReactionSymptoms(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-高原反应症状")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:update')")
    public CommonResult<Boolean> updateExperimentSurveyHighlandReactionSymptoms(@Valid @RequestBody ExperimentSurveyHighlandReactionSymptomsSaveReqVO updateReqVO) {
        experimentSurveyHighlandReactionSymptomsService.updateExperimentSurveyHighlandReactionSymptoms(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-高原反应症状")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyHighlandReactionSymptoms(@RequestParam("id") Long id) {
        experimentSurveyHighlandReactionSymptomsService.deleteExperimentSurveyHighlandReactionSymptoms(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-高原反应症状")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:query')")
    public CommonResult<ExperimentSurveyHighlandReactionSymptomsRespVO> getExperimentSurveyHighlandReactionSymptoms(@RequestParam("id") Long id) {
        ExperimentSurveyHighlandReactionSymptomsDO experimentSurveyHighlandReactionSymptoms = experimentSurveyHighlandReactionSymptomsService.getExperimentSurveyHighlandReactionSymptoms(id);
        return success(BeanUtils.toBean(experimentSurveyHighlandReactionSymptoms, ExperimentSurveyHighlandReactionSymptomsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-高原反应症状分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:query')")
    public CommonResult<PageResult<ExperimentSurveyHighlandReactionSymptomsRespVO>> getExperimentSurveyHighlandReactionSymptomsPage(@Valid ExperimentSurveyHighlandReactionSymptomsPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyHighlandReactionSymptomsDO> pageResult = experimentSurveyHighlandReactionSymptomsService.getExperimentSurveyHighlandReactionSymptomsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyHighlandReactionSymptomsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-高原反应症状 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction-symptoms:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyHighlandReactionSymptomsExcel(@Valid ExperimentSurveyHighlandReactionSymptomsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyHighlandReactionSymptomsDO> list = experimentSurveyHighlandReactionSymptomsService.getExperimentSurveyHighlandReactionSymptomsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-高原反应症状.xls", "数据", ExperimentSurveyHighlandReactionSymptomsRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyHighlandReactionSymptomsRespVO.class));
    }

}