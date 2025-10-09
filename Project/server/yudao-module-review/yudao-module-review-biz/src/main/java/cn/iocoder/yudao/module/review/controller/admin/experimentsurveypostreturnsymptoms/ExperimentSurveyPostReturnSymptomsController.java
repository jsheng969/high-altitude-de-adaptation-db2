package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.module.review.service.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsService;

@Tag(name = "管理后台 - 实验组流调-退役后返回平原1月内症状")
@RestController
@RequestMapping("/review/experiment-survey-post-return-symptoms")
@Validated
public class ExperimentSurveyPostReturnSymptomsController {

    @Resource
    private ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-退役后返回平原1月内症状")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:create')")
    public CommonResult<Long> createExperimentSurveyPostReturnSymptoms(@Valid @RequestBody ExperimentSurveyPostReturnSymptomsSaveReqVO createReqVO) {
        return success(experimentSurveyPostReturnSymptomsService.createExperimentSurveyPostReturnSymptoms(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-退役后返回平原1月内症状")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:update')")
    public CommonResult<Boolean> updateExperimentSurveyPostReturnSymptoms(@Valid @RequestBody ExperimentSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        experimentSurveyPostReturnSymptomsService.updateExperimentSurveyPostReturnSymptoms(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-退役后返回平原1月内症状")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyPostReturnSymptoms(@RequestParam("id") Long id) {
        experimentSurveyPostReturnSymptomsService.deleteExperimentSurveyPostReturnSymptoms(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-退役后返回平原1月内症状")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:query')")
    public CommonResult<ExperimentSurveyPostReturnSymptomsRespVO> getExperimentSurveyPostReturnSymptoms(@RequestParam("id") Long id) {
        ExperimentSurveyPostReturnSymptomsDO experimentSurveyPostReturnSymptoms = experimentSurveyPostReturnSymptomsService.getExperimentSurveyPostReturnSymptoms(id);
        return success(BeanUtils.toBean(experimentSurveyPostReturnSymptoms, ExperimentSurveyPostReturnSymptomsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-退役后返回平原1月内症状分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:query')")
    public CommonResult<PageResult<ExperimentSurveyPostReturnSymptomsRespVO>> getExperimentSurveyPostReturnSymptomsPage(@Valid ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyPostReturnSymptomsDO> pageResult = experimentSurveyPostReturnSymptomsService.getExperimentSurveyPostReturnSymptomsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyPostReturnSymptomsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-退役后返回平原1月内症状 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-symptoms:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyPostReturnSymptomsExcel(@Valid ExperimentSurveyPostReturnSymptomsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyPostReturnSymptomsDO> list = experimentSurveyPostReturnSymptomsService.getExperimentSurveyPostReturnSymptomsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-退役后返回平原1月内症状.xls", "数据", ExperimentSurveyPostReturnSymptomsRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyPostReturnSymptomsRespVO.class));
    }

}