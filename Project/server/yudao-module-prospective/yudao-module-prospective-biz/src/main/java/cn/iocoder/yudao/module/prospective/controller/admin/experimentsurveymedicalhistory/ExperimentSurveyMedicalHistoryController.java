package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryService;

@Tag(name = "管理后台 - 既往疾病史")
@RestController
@RequestMapping("/prospective/experiment-survey-medical-history")
@Validated
public class ExperimentSurveyMedicalHistoryController {

    @Resource
    private ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService;

    @PostMapping("/create")
    @Operation(summary = "创建既往疾病史")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:create')")
    public CommonResult<Long> createExperimentSurveyMedicalHistory(@Valid @RequestBody ExperimentSurveyMedicalHistorySaveReqVO createReqVO) {
        return success(experimentSurveyMedicalHistoryService.createExperimentSurveyMedicalHistory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新既往疾病史")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:update')")
    public CommonResult<Boolean> updateExperimentSurveyMedicalHistory(@Valid @RequestBody ExperimentSurveyMedicalHistorySaveReqVO updateReqVO) {
        experimentSurveyMedicalHistoryService.updateExperimentSurveyMedicalHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除既往疾病史")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyMedicalHistory(@RequestParam("id") Long id) {
        experimentSurveyMedicalHistoryService.deleteExperimentSurveyMedicalHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得既往疾病史")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:query')")
    public CommonResult<ExperimentSurveyMedicalHistoryRespVO> getExperimentSurveyMedicalHistory(@RequestParam("id") Long id) {
        ExperimentSurveyMedicalHistoryDO experimentSurveyMedicalHistory = experimentSurveyMedicalHistoryService.getExperimentSurveyMedicalHistory(id);
        return success(BeanUtils.toBean(experimentSurveyMedicalHistory, ExperimentSurveyMedicalHistoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得既往疾病史分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:query')")
    public CommonResult<PageResult<ExperimentSurveyMedicalHistoryRespVO>> getExperimentSurveyMedicalHistoryPage(@Valid ExperimentSurveyMedicalHistoryPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyMedicalHistoryDO> pageResult = experimentSurveyMedicalHistoryService.getExperimentSurveyMedicalHistoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyMedicalHistoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出既往疾病史 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-medical-history:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyMedicalHistoryExcel(@Valid ExperimentSurveyMedicalHistoryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyMedicalHistoryDO> list = experimentSurveyMedicalHistoryService.getExperimentSurveyMedicalHistoryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "既往疾病史.xls", "数据", ExperimentSurveyMedicalHistoryRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyMedicalHistoryRespVO.class));
    }

}