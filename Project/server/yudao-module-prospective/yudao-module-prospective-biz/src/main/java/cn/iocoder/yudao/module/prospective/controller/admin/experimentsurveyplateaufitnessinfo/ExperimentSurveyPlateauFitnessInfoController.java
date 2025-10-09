package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoService;

@Tag(name = "管理后台 - 高原体能信息")
@RestController
@RequestMapping("/prospective/experiment-survey-plateau-fitness-info")
@Validated
public class ExperimentSurveyPlateauFitnessInfoController {

    @Resource
    private ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建高原体能信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:create')")
    public CommonResult<Long> createExperimentSurveyPlateauFitnessInfo(@Valid @RequestBody ExperimentSurveyPlateauFitnessInfoSaveReqVO createReqVO) {
        return success(experimentSurveyPlateauFitnessInfoService.createExperimentSurveyPlateauFitnessInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新高原体能信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyPlateauFitnessInfo(@Valid @RequestBody ExperimentSurveyPlateauFitnessInfoSaveReqVO updateReqVO) {
        experimentSurveyPlateauFitnessInfoService.updateExperimentSurveyPlateauFitnessInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除高原体能信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyPlateauFitnessInfo(@RequestParam("id") Long id) {
        experimentSurveyPlateauFitnessInfoService.deleteExperimentSurveyPlateauFitnessInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得高原体能信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:query')")
    public CommonResult<ExperimentSurveyPlateauFitnessInfoRespVO> getExperimentSurveyPlateauFitnessInfo(@RequestParam("id") Long id) {
        ExperimentSurveyPlateauFitnessInfoDO experimentSurveyPlateauFitnessInfo = experimentSurveyPlateauFitnessInfoService.getExperimentSurveyPlateauFitnessInfo(id);
        return success(BeanUtils.toBean(experimentSurveyPlateauFitnessInfo, ExperimentSurveyPlateauFitnessInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得高原体能信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:query')")
    public CommonResult<PageResult<ExperimentSurveyPlateauFitnessInfoRespVO>> getExperimentSurveyPlateauFitnessInfoPage(@Valid ExperimentSurveyPlateauFitnessInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyPlateauFitnessInfoDO> pageResult = experimentSurveyPlateauFitnessInfoService.getExperimentSurveyPlateauFitnessInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyPlateauFitnessInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出高原体能信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-plateau-fitness-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyPlateauFitnessInfoExcel(@Valid ExperimentSurveyPlateauFitnessInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyPlateauFitnessInfoDO> list = experimentSurveyPlateauFitnessInfoService.getExperimentSurveyPlateauFitnessInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "高原体能信息.xls", "数据", ExperimentSurveyPlateauFitnessInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyPlateauFitnessInfoRespVO.class));
    }

}