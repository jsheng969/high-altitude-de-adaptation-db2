package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryService;

@Tag(name = "管理后台 - 评分总数统计")
@RestController
@RequestMapping("/prospective/experiment-survey-score-summary")
@Validated
public class ExperimentSurveyScoreSummaryController {

    @Resource
    private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

    @PostMapping("/create")
    @Operation(summary = "创建评分总数统计")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:create')")
    public CommonResult<Long> createExperimentSurveyScoreSummary(@Valid @RequestBody ExperimentSurveyScoreSummarySaveReqVO createReqVO) {
        return success(experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新评分总数统计")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:update')")
    public CommonResult<Boolean> updateExperimentSurveyScoreSummary(@Valid @RequestBody ExperimentSurveyScoreSummarySaveReqVO updateReqVO) {
        experimentSurveyScoreSummaryService.updateExperimentSurveyScoreSummary(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除评分总数统计")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyScoreSummary(@RequestParam("id") Long id) {
        experimentSurveyScoreSummaryService.deleteExperimentSurveyScoreSummary(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得评分总数统计")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:query')")
    public CommonResult<ExperimentSurveyScoreSummaryRespVO> getExperimentSurveyScoreSummary(@RequestParam("id") Long id) {
        ExperimentSurveyScoreSummaryDO experimentSurveyScoreSummary = experimentSurveyScoreSummaryService.getExperimentSurveyScoreSummary(id);
        return success(BeanUtils.toBean(experimentSurveyScoreSummary, ExperimentSurveyScoreSummaryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得评分总数统计分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:query')")
    public CommonResult<PageResult<ExperimentSurveyScoreSummaryRespVO>> getExperimentSurveyScoreSummaryPage(@Valid ExperimentSurveyScoreSummaryPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyScoreSummaryDO> pageResult = experimentSurveyScoreSummaryService.getExperimentSurveyScoreSummaryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyScoreSummaryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出评分总数统计 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-score-summary:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyScoreSummaryExcel(@Valid ExperimentSurveyScoreSummaryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyScoreSummaryDO> list = experimentSurveyScoreSummaryService.getExperimentSurveyScoreSummaryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "评分总数统计.xls", "数据", ExperimentSurveyScoreSummaryRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyScoreSummaryRespVO.class));
    }

}