package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesService;

@Tag(name = "管理后台 - 实验组流调-高原疾病诊断")
@RestController
@RequestMapping("/review/experiment-survey-highland-diseases")
@Validated
public class ExperimentSurveyHighlandDiseasesController {

    @Resource
    private ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-高原疾病诊断")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:create')")
    public CommonResult<Long> createExperimentSurveyHighlandDiseases(@Valid @RequestBody ExperimentSurveyHighlandDiseasesSaveReqVO createReqVO) {
        return success(experimentSurveyHighlandDiseasesService.createExperimentSurveyHighlandDiseases(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-高原疾病诊断")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:update')")
    public CommonResult<Boolean> updateExperimentSurveyHighlandDiseases(@Valid @RequestBody ExperimentSurveyHighlandDiseasesSaveReqVO updateReqVO) {
        experimentSurveyHighlandDiseasesService.updateExperimentSurveyHighlandDiseases(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-高原疾病诊断")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyHighlandDiseases(@RequestParam("id") Long id) {
        experimentSurveyHighlandDiseasesService.deleteExperimentSurveyHighlandDiseases(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-高原疾病诊断")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:query')")
    public CommonResult<ExperimentSurveyHighlandDiseasesRespVO> getExperimentSurveyHighlandDiseases(@RequestParam("id") Long id) {
        ExperimentSurveyHighlandDiseasesDO experimentSurveyHighlandDiseases = experimentSurveyHighlandDiseasesService.getExperimentSurveyHighlandDiseases(id);
        return success(BeanUtils.toBean(experimentSurveyHighlandDiseases, ExperimentSurveyHighlandDiseasesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-高原疾病诊断分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:query')")
    public CommonResult<PageResult<ExperimentSurveyHighlandDiseasesRespVO>> getExperimentSurveyHighlandDiseasesPage(@Valid ExperimentSurveyHighlandDiseasesPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyHighlandDiseasesDO> pageResult = experimentSurveyHighlandDiseasesService.getExperimentSurveyHighlandDiseasesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyHighlandDiseasesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-高原疾病诊断 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-diseases:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyHighlandDiseasesExcel(@Valid ExperimentSurveyHighlandDiseasesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyHighlandDiseasesDO> list = experimentSurveyHighlandDiseasesService.getExperimentSurveyHighlandDiseasesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-高原疾病诊断.xls", "数据", ExperimentSurveyHighlandDiseasesRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyHighlandDiseasesRespVO.class));
    }

}