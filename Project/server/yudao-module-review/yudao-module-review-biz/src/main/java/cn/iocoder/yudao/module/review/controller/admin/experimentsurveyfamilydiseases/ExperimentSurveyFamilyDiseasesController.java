package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesService;

@Tag(name = "管理后台 - 实验组流调-亲属既往疾病")
@RestController
@RequestMapping("/review/experiment-survey-family-diseases")
@Validated
public class ExperimentSurveyFamilyDiseasesController {

    @Resource
    private ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-亲属既往疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:create')")
    public CommonResult<Long> createExperimentSurveyFamilyDiseases(@Valid @RequestBody ExperimentSurveyFamilyDiseasesSaveReqVO createReqVO) {
        return success(experimentSurveyFamilyDiseasesService.createExperimentSurveyFamilyDiseases(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-亲属既往疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:update')")
    public CommonResult<Boolean> updateExperimentSurveyFamilyDiseases(@Valid @RequestBody ExperimentSurveyFamilyDiseasesSaveReqVO updateReqVO) {
        experimentSurveyFamilyDiseasesService.updateExperimentSurveyFamilyDiseases(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-亲属既往疾病")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyFamilyDiseases(@RequestParam("id") Long id) {
        experimentSurveyFamilyDiseasesService.deleteExperimentSurveyFamilyDiseases(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-亲属既往疾病")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:query')")
    public CommonResult<ExperimentSurveyFamilyDiseasesRespVO> getExperimentSurveyFamilyDiseases(@RequestParam("id") Long id) {
        ExperimentSurveyFamilyDiseasesDO experimentSurveyFamilyDiseases = experimentSurveyFamilyDiseasesService.getExperimentSurveyFamilyDiseases(id);
        return success(BeanUtils.toBean(experimentSurveyFamilyDiseases, ExperimentSurveyFamilyDiseasesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-亲属既往疾病分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:query')")
    public CommonResult<PageResult<ExperimentSurveyFamilyDiseasesRespVO>> getExperimentSurveyFamilyDiseasesPage(@Valid ExperimentSurveyFamilyDiseasesPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyFamilyDiseasesDO> pageResult = experimentSurveyFamilyDiseasesService.getExperimentSurveyFamilyDiseasesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyFamilyDiseasesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-亲属既往疾病 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-family-diseases:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyFamilyDiseasesExcel(@Valid ExperimentSurveyFamilyDiseasesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyFamilyDiseasesDO> list = experimentSurveyFamilyDiseasesService.getExperimentSurveyFamilyDiseasesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-亲属既往疾病.xls", "数据", ExperimentSurveyFamilyDiseasesRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyFamilyDiseasesRespVO.class));
    }

}