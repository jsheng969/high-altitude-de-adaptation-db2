package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsService;

@Tag(name = "管理后台 - 高原急性高山病记录")
@RestController
@RequestMapping("/prospective/experiment-survey-acute-mountain-sickness-records")
@Validated
public class ExperimentSurveyAcuteMountainSicknessRecordsController {

    @Resource
    private ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService;

    @PostMapping("/create")
    @Operation(summary = "创建高原急性高山病记录")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:create')")
    public CommonResult<Long> createExperimentSurveyAcuteMountainSicknessRecords(@Valid @RequestBody ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO createReqVO) {
        return success(experimentSurveyAcuteMountainSicknessRecordsService.createExperimentSurveyAcuteMountainSicknessRecords(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新高原急性高山病记录")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:update')")
    public CommonResult<Boolean> updateExperimentSurveyAcuteMountainSicknessRecords(@Valid @RequestBody ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO updateReqVO) {
        experimentSurveyAcuteMountainSicknessRecordsService.updateExperimentSurveyAcuteMountainSicknessRecords(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除高原急性高山病记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyAcuteMountainSicknessRecords(@RequestParam("id") Long id) {
        experimentSurveyAcuteMountainSicknessRecordsService.deleteExperimentSurveyAcuteMountainSicknessRecords(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得高原急性高山病记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:query')")
    public CommonResult<ExperimentSurveyAcuteMountainSicknessRecordsRespVO> getExperimentSurveyAcuteMountainSicknessRecords(@RequestParam("id") Long id) {
        ExperimentSurveyAcuteMountainSicknessRecordsDO experimentSurveyAcuteMountainSicknessRecords = experimentSurveyAcuteMountainSicknessRecordsService.getExperimentSurveyAcuteMountainSicknessRecords(id);
        return success(BeanUtils.toBean(experimentSurveyAcuteMountainSicknessRecords, ExperimentSurveyAcuteMountainSicknessRecordsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得高原急性高山病记录分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:query')")
    public CommonResult<PageResult<ExperimentSurveyAcuteMountainSicknessRecordsRespVO>> getExperimentSurveyAcuteMountainSicknessRecordsPage(@Valid ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyAcuteMountainSicknessRecordsDO> pageResult = experimentSurveyAcuteMountainSicknessRecordsService.getExperimentSurveyAcuteMountainSicknessRecordsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyAcuteMountainSicknessRecordsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出高原急性高山病记录 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-acute-mountain-sickness-records:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyAcuteMountainSicknessRecordsExcel(@Valid ExperimentSurveyAcuteMountainSicknessRecordsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyAcuteMountainSicknessRecordsDO> list = experimentSurveyAcuteMountainSicknessRecordsService.getExperimentSurveyAcuteMountainSicknessRecordsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "高原急性高山病记录.xls", "数据", ExperimentSurveyAcuteMountainSicknessRecordsRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyAcuteMountainSicknessRecordsRespVO.class));
    }

}