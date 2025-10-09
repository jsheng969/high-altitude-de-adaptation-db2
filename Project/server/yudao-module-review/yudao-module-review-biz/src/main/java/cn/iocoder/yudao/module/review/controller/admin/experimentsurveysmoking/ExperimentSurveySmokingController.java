package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysmoking.ExperimentSurveySmokingDO;
import cn.iocoder.yudao.module.review.service.experimentsurveysmoking.ExperimentSurveySmokingService;

@Tag(name = "管理后台 - 实验组流调-吸烟情况")
@RestController
@RequestMapping("/review/experiment-survey-smoking")
@Validated
public class ExperimentSurveySmokingController {

    @Resource
    private ExperimentSurveySmokingService experimentSurveySmokingService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-吸烟情况")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:create')")
    public CommonResult<Long> createExperimentSurveySmoking(@Valid @RequestBody ExperimentSurveySmokingSaveReqVO createReqVO) {
        return success(experimentSurveySmokingService.createExperimentSurveySmoking(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-吸烟情况")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:update')")
    public CommonResult<Boolean> updateExperimentSurveySmoking(@Valid @RequestBody ExperimentSurveySmokingSaveReqVO updateReqVO) {
        experimentSurveySmokingService.updateExperimentSurveySmoking(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-吸烟情况")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:delete')")
    public CommonResult<Boolean> deleteExperimentSurveySmoking(@RequestParam("id") Long id) {
        experimentSurveySmokingService.deleteExperimentSurveySmoking(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-吸烟情况")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:query')")
    public CommonResult<ExperimentSurveySmokingRespVO> getExperimentSurveySmoking(@RequestParam("id") Long id) {
        ExperimentSurveySmokingDO experimentSurveySmoking = experimentSurveySmokingService.getExperimentSurveySmoking(id);
        return success(BeanUtils.toBean(experimentSurveySmoking, ExperimentSurveySmokingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-吸烟情况分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:query')")
    public CommonResult<PageResult<ExperimentSurveySmokingRespVO>> getExperimentSurveySmokingPage(@Valid ExperimentSurveySmokingPageReqVO pageReqVO) {
        PageResult<ExperimentSurveySmokingDO> pageResult = experimentSurveySmokingService.getExperimentSurveySmokingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveySmokingRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-吸烟情况 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-smoking:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveySmokingExcel(@Valid ExperimentSurveySmokingPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveySmokingDO> list = experimentSurveySmokingService.getExperimentSurveySmokingPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-吸烟情况.xls", "数据", ExperimentSurveySmokingRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveySmokingRespVO.class));
    }

}