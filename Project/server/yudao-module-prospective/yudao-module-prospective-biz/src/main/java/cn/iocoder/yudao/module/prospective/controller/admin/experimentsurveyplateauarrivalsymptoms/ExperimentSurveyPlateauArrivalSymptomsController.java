package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsService;

@Tag(name = "管理后台 - 抵达高原后症状记录")
@RestController
@RequestMapping("/prospective/experiment-survey-plateau-arrival-symptoms")
@Validated
public class ExperimentSurveyPlateauArrivalSymptomsController {

    @Resource
    private ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService;

    @PostMapping("/create")
    @Operation(summary = "创建抵达高原后症状记录")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:create')")
    public CommonResult<Long> createExperimentSurveyPlateauArrivalSymptoms(@Valid @RequestBody ExperimentSurveyPlateauArrivalSymptomsSaveReqVO createReqVO) {
        return success(experimentSurveyPlateauArrivalSymptomsService.createExperimentSurveyPlateauArrivalSymptoms(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新抵达高原后症状记录")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:update')")
    public CommonResult<Boolean> updateExperimentSurveyPlateauArrivalSymptoms(@Valid @RequestBody ExperimentSurveyPlateauArrivalSymptomsSaveReqVO updateReqVO) {
        experimentSurveyPlateauArrivalSymptomsService.updateExperimentSurveyPlateauArrivalSymptoms(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除抵达高原后症状记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyPlateauArrivalSymptoms(@RequestParam("id") Long id) {
        experimentSurveyPlateauArrivalSymptomsService.deleteExperimentSurveyPlateauArrivalSymptoms(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得抵达高原后症状记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:query')")
    public CommonResult<ExperimentSurveyPlateauArrivalSymptomsRespVO> getExperimentSurveyPlateauArrivalSymptoms(@RequestParam("id") Long id) {
        ExperimentSurveyPlateauArrivalSymptomsDO experimentSurveyPlateauArrivalSymptoms = experimentSurveyPlateauArrivalSymptomsService.getExperimentSurveyPlateauArrivalSymptoms(id);
        return success(BeanUtils.toBean(experimentSurveyPlateauArrivalSymptoms, ExperimentSurveyPlateauArrivalSymptomsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得抵达高原后症状记录分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:query')")
    public CommonResult<PageResult<ExperimentSurveyPlateauArrivalSymptomsRespVO>> getExperimentSurveyPlateauArrivalSymptomsPage(@Valid ExperimentSurveyPlateauArrivalSymptomsPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyPlateauArrivalSymptomsDO> pageResult = experimentSurveyPlateauArrivalSymptomsService.getExperimentSurveyPlateauArrivalSymptomsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyPlateauArrivalSymptomsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出抵达高原后症状记录 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-arrival-symptoms:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyPlateauArrivalSymptomsExcel(@Valid ExperimentSurveyPlateauArrivalSymptomsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyPlateauArrivalSymptomsDO> list = experimentSurveyPlateauArrivalSymptomsService.getExperimentSurveyPlateauArrivalSymptomsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "抵达高原后症状记录.xls", "数据", ExperimentSurveyPlateauArrivalSymptomsRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyPlateauArrivalSymptomsRespVO.class));
    }

}