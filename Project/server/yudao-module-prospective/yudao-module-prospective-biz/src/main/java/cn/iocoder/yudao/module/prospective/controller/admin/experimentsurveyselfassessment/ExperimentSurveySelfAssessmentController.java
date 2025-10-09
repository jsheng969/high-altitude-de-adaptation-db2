package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyselfassessment.ProspectiveExperimentSurveySelfAssessmentDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentService;

@Tag(name = "管理后台 - 自我评价")
@RestController("prospectiveExperimentSurveySelfAssessmentController")
@RequestMapping("/prospective/experiment-survey-self-assessment")
@Validated
public class ExperimentSurveySelfAssessmentController {

    @Resource
    private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;

    @PostMapping("/create")
    @Operation(summary = "创建自我评价")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:create')")
    public CommonResult<Long> createExperimentSurveySelfAssessment(@Valid @RequestBody ExperimentSurveySelfAssessmentSaveReqVO createReqVO) {
        return success(experimentSurveySelfAssessmentService.createExperimentSurveySelfAssessment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新自我评价")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:update')")
    public CommonResult<Boolean> updateExperimentSurveySelfAssessment(@Valid @RequestBody ExperimentSurveySelfAssessmentSaveReqVO updateReqVO) {
        experimentSurveySelfAssessmentService.updateExperimentSurveySelfAssessment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除自我评价")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:delete')")
    public CommonResult<Boolean> deleteExperimentSurveySelfAssessment(@RequestParam("id") Long id) {
        experimentSurveySelfAssessmentService.deleteExperimentSurveySelfAssessment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得自我评价")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:query')")
    public CommonResult<ExperimentSurveySelfAssessmentRespVO> getExperimentSurveySelfAssessment(@RequestParam("id") Long id) {
        ProspectiveExperimentSurveySelfAssessmentDO experimentSurveySelfAssessment = experimentSurveySelfAssessmentService.getExperimentSurveySelfAssessment(id);
        return success(BeanUtils.toBean(experimentSurveySelfAssessment, ExperimentSurveySelfAssessmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得自我评价分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:query')")
    public CommonResult<PageResult<ExperimentSurveySelfAssessmentRespVO>> getExperimentSurveySelfAssessmentPage(@Valid ExperimentSurveySelfAssessmentPageReqVO pageReqVO) {
        PageResult<ProspectiveExperimentSurveySelfAssessmentDO> pageResult = experimentSurveySelfAssessmentService.getExperimentSurveySelfAssessmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveySelfAssessmentRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出自我评价 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-self-assessment:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveySelfAssessmentExcel(@Valid ExperimentSurveySelfAssessmentPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProspectiveExperimentSurveySelfAssessmentDO> list = experimentSurveySelfAssessmentService.getExperimentSurveySelfAssessmentPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "自我评价.xls", "数据", ExperimentSurveySelfAssessmentRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveySelfAssessmentRespVO.class));
    }

}