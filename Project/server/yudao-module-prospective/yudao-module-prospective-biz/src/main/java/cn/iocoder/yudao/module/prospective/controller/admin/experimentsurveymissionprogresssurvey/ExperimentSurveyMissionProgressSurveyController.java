package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyService;

@Tag(name = "管理后台 - 推进情况调查")
@RestController
@RequestMapping("/prospective/experiment-survey-mission-progress-survey")
@Validated
public class ExperimentSurveyMissionProgressSurveyController {

    @Resource
    private ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService;

    @PostMapping("/create")
    @Operation(summary = "创建推进情况调查")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:create')")
    public CommonResult<Long> createExperimentSurveyMissionProgressSurvey(@Valid @RequestBody ExperimentSurveyMissionProgressSurveySaveReqVO createReqVO) {
        return success(experimentSurveyMissionProgressSurveyService.createExperimentSurveyMissionProgressSurvey(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新推进情况调查")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:update')")
    public CommonResult<Boolean> updateExperimentSurveyMissionProgressSurvey(@Valid @RequestBody ExperimentSurveyMissionProgressSurveySaveReqVO updateReqVO) {
        experimentSurveyMissionProgressSurveyService.updateExperimentSurveyMissionProgressSurvey(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除推进情况调查")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyMissionProgressSurvey(@RequestParam("id") Long id) {
        experimentSurveyMissionProgressSurveyService.deleteExperimentSurveyMissionProgressSurvey(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得推进情况调查")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:query')")
    public CommonResult<ExperimentSurveyMissionProgressSurveyRespVO> getExperimentSurveyMissionProgressSurvey(@RequestParam("id") Long id) {
        ExperimentSurveyMissionProgressSurveyDO experimentSurveyMissionProgressSurvey = experimentSurveyMissionProgressSurveyService.getExperimentSurveyMissionProgressSurvey(id);
        return success(BeanUtils.toBean(experimentSurveyMissionProgressSurvey, ExperimentSurveyMissionProgressSurveyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得推进情况调查分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:query')")
    public CommonResult<PageResult<ExperimentSurveyMissionProgressSurveyRespVO>> getExperimentSurveyMissionProgressSurveyPage(@Valid ExperimentSurveyMissionProgressSurveyPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyMissionProgressSurveyDO> pageResult = experimentSurveyMissionProgressSurveyService.getExperimentSurveyMissionProgressSurveyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyMissionProgressSurveyRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出推进情况调查 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-mission-progress-survey:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyMissionProgressSurveyExcel(@Valid ExperimentSurveyMissionProgressSurveyPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyMissionProgressSurveyDO> list = experimentSurveyMissionProgressSurveyService.getExperimentSurveyMissionProgressSurveyPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "推进情况调查.xls", "数据", ExperimentSurveyMissionProgressSurveyRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyMissionProgressSurveyRespVO.class));
    }

}