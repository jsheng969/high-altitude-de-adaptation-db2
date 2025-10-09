package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoService;

@Tag(name = "管理后台 - 基本检测信息")
@RestController
@RequestMapping("/prospective/experiment-survey-basic-check-info")
@Validated
public class ExperimentSurveyBasicCheckInfoController {

    @Resource
    private ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建基本检测信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:create')")
    public CommonResult<Long> createExperimentSurveyBasicCheckInfo(@Valid @RequestBody ExperimentSurveyBasicCheckInfoSaveReqVO createReqVO) {
        return success(experimentSurveyBasicCheckInfoService.createExperimentSurveyBasicCheckInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基本检测信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyBasicCheckInfo(@Valid @RequestBody ExperimentSurveyBasicCheckInfoSaveReqVO updateReqVO) {
        experimentSurveyBasicCheckInfoService.updateExperimentSurveyBasicCheckInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基本检测信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyBasicCheckInfo(@RequestParam("id") Long id) {
        experimentSurveyBasicCheckInfoService.deleteExperimentSurveyBasicCheckInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基本检测信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:query')")
    public CommonResult<ExperimentSurveyBasicCheckInfoRespVO> getExperimentSurveyBasicCheckInfo(@RequestParam("id") Long id) {
        ExperimentSurveyBasicCheckInfoDO experimentSurveyBasicCheckInfo = experimentSurveyBasicCheckInfoService.getExperimentSurveyBasicCheckInfo(id);
        return success(BeanUtils.toBean(experimentSurveyBasicCheckInfo, ExperimentSurveyBasicCheckInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基本检测信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:query')")
    public CommonResult<PageResult<ExperimentSurveyBasicCheckInfoRespVO>> getExperimentSurveyBasicCheckInfoPage(@Valid ExperimentSurveyBasicCheckInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyBasicCheckInfoDO> pageResult = experimentSurveyBasicCheckInfoService.getExperimentSurveyBasicCheckInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyBasicCheckInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基本检测信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-check-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyBasicCheckInfoExcel(@Valid ExperimentSurveyBasicCheckInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyBasicCheckInfoDO> list = experimentSurveyBasicCheckInfoService.getExperimentSurveyBasicCheckInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基本检测信息.xls", "数据", ExperimentSurveyBasicCheckInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyBasicCheckInfoRespVO.class));
    }

}