package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyhighlanddiseasesduringservice.ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceService;

@Tag(name = "管理后台 - 抵达高原后有无新下疾病")
@RestController("prospectiveExperimentSurveyHighlandDiseasesDuringServiceController")
@RequestMapping("/prospective/experiment-survey-highland-diseases-during-service")
@Validated
public class ExperimentSurveyHighlandDiseasesDuringServiceController {

    @Resource
    private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;

    @PostMapping("/create")
    @Operation(summary = "创建抵达高原后有无新下疾病")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:create')")
    public CommonResult<Long> createExperimentSurveyHighlandDiseasesDuringService(@Valid @RequestBody ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO createReqVO) {
        return success(experimentSurveyHighlandDiseasesDuringServiceService.createExperimentSurveyHighlandDiseasesDuringService(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新抵达高原后有无新下疾病")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:update')")
    public CommonResult<Boolean> updateExperimentSurveyHighlandDiseasesDuringService(@Valid @RequestBody ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO updateReqVO) {
        experimentSurveyHighlandDiseasesDuringServiceService.updateExperimentSurveyHighlandDiseasesDuringService(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除抵达高原后有无新下疾病")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyHighlandDiseasesDuringService(@RequestParam("id") Long id) {
        experimentSurveyHighlandDiseasesDuringServiceService.deleteExperimentSurveyHighlandDiseasesDuringService(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得抵达高原后有无新下疾病")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:query')")
    public CommonResult<ExperimentSurveyHighlandDiseasesDuringServiceRespVO> getExperimentSurveyHighlandDiseasesDuringService(@RequestParam("id") Long id) {
        ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO experimentSurveyHighlandDiseasesDuringService = experimentSurveyHighlandDiseasesDuringServiceService.getExperimentSurveyHighlandDiseasesDuringService(id);
        return success(BeanUtils.toBean(experimentSurveyHighlandDiseasesDuringService, ExperimentSurveyHighlandDiseasesDuringServiceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得抵达高原后有无新下疾病分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:query')")
    public CommonResult<PageResult<ExperimentSurveyHighlandDiseasesDuringServiceRespVO>> getExperimentSurveyHighlandDiseasesDuringServicePage(@Valid ExperimentSurveyHighlandDiseasesDuringServicePageReqVO pageReqVO) {
        PageResult<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> pageResult = experimentSurveyHighlandDiseasesDuringServiceService.getExperimentSurveyHighlandDiseasesDuringServicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyHighlandDiseasesDuringServiceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出抵达高原后有无新下疾病 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-highland-diseases-during-service:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyHighlandDiseasesDuringServiceExcel(@Valid ExperimentSurveyHighlandDiseasesDuringServicePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProspectiveExperimentSurveyHighlandDiseasesDuringServiceDO> list = experimentSurveyHighlandDiseasesDuringServiceService.getExperimentSurveyHighlandDiseasesDuringServicePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "抵达高原后有无新下疾病.xls", "数据", ExperimentSurveyHighlandDiseasesDuringServiceRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyHighlandDiseasesDuringServiceRespVO.class));
    }

}