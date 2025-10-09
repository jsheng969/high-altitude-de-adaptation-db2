package cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesDO;
import cn.iocoder.yudao.module.review.service.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesService;

@Tag(name = "管理后台 - 实验组流调-新发的疾病")
@RestController
@RequestMapping("/review/experiment-survey-new-diseases")
@Validated
public class ExperimentSurveyNewDiseasesController {

    @Resource
    private ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-新发的疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:create')")
    public CommonResult<Long> createExperimentSurveyNewDiseases(@Valid @RequestBody ExperimentSurveyNewDiseasesSaveReqVO createReqVO) {
        return success(experimentSurveyNewDiseasesService.createExperimentSurveyNewDiseases(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-新发的疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:update')")
    public CommonResult<Boolean> updateExperimentSurveyNewDiseases(@Valid @RequestBody ExperimentSurveyNewDiseasesSaveReqVO updateReqVO) {
        experimentSurveyNewDiseasesService.updateExperimentSurveyNewDiseases(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-新发的疾病")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyNewDiseases(@RequestParam("id") Long id) {
        experimentSurveyNewDiseasesService.deleteExperimentSurveyNewDiseases(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-新发的疾病")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:query')")
    public CommonResult<ExperimentSurveyNewDiseasesRespVO> getExperimentSurveyNewDiseases(@RequestParam("id") Long id) {
        ExperimentSurveyNewDiseasesDO experimentSurveyNewDiseases = experimentSurveyNewDiseasesService.getExperimentSurveyNewDiseases(id);
        return success(BeanUtils.toBean(experimentSurveyNewDiseases, ExperimentSurveyNewDiseasesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-新发的疾病分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:query')")
    public CommonResult<PageResult<ExperimentSurveyNewDiseasesRespVO>> getExperimentSurveyNewDiseasesPage(@Valid ExperimentSurveyNewDiseasesPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyNewDiseasesDO> pageResult = experimentSurveyNewDiseasesService.getExperimentSurveyNewDiseasesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyNewDiseasesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-新发的疾病 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyNewDiseasesExcel(@Valid ExperimentSurveyNewDiseasesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyNewDiseasesDO> list = experimentSurveyNewDiseasesService.getExperimentSurveyNewDiseasesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-新发的疾病.xls", "数据", ExperimentSurveyNewDiseasesRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyNewDiseasesRespVO.class));
    }

}