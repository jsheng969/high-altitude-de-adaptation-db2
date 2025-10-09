package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoService;

@Tag(name = "管理后台 - 驻训信息")
@RestController
@RequestMapping("/prospective/experiment-survey-station-training-info")
@Validated
public class ExperimentSurveyStationTrainingInfoController {

    @Resource
    private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建驻训信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:create')")
    public CommonResult<Long> createExperimentSurveyStationTrainingInfo(@Valid @RequestBody ExperimentSurveyStationTrainingInfoSaveReqVO createReqVO) {
        return success(experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新驻训信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyStationTrainingInfo(@Valid @RequestBody ExperimentSurveyStationTrainingInfoSaveReqVO updateReqVO) {
        experimentSurveyStationTrainingInfoService.updateExperimentSurveyStationTrainingInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除驻训信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyStationTrainingInfo(@RequestParam("id") Long id) {
        experimentSurveyStationTrainingInfoService.deleteExperimentSurveyStationTrainingInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得驻训信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:query')")
    public CommonResult<ExperimentSurveyStationTrainingInfoRespVO> getExperimentSurveyStationTrainingInfo(@RequestParam("id") Long id) {
        ExperimentSurveyStationTrainingInfoDO experimentSurveyStationTrainingInfo = experimentSurveyStationTrainingInfoService.getExperimentSurveyStationTrainingInfo(id);
        return success(BeanUtils.toBean(experimentSurveyStationTrainingInfo, ExperimentSurveyStationTrainingInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得驻训信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:query')")
    public CommonResult<PageResult<ExperimentSurveyStationTrainingInfoRespVO>> getExperimentSurveyStationTrainingInfoPage(@Valid ExperimentSurveyStationTrainingInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyStationTrainingInfoDO> pageResult = experimentSurveyStationTrainingInfoService.getExperimentSurveyStationTrainingInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyStationTrainingInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出驻训信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-station-training-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyStationTrainingInfoExcel(@Valid ExperimentSurveyStationTrainingInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyStationTrainingInfoDO> list = experimentSurveyStationTrainingInfoService.getExperimentSurveyStationTrainingInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "驻训信息.xls", "数据", ExperimentSurveyStationTrainingInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyStationTrainingInfoRespVO.class));
    }

}