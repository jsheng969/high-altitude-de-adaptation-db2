package cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoDO;
import cn.iocoder.yudao.module.prospective.service.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoService;

@Tag(name = "管理后台 - 吸烟信息")
@RestController
@RequestMapping("/prospective/experiment-survey-smoking-info")
@Validated
public class ExperimentSurveySmokingInfoController {

    @Resource
    private ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建吸烟信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:create')")
    public CommonResult<Long> createExperimentSurveySmokingInfo(@Valid @RequestBody ExperimentSurveySmokingInfoSaveReqVO createReqVO) {
        return success(experimentSurveySmokingInfoService.createExperimentSurveySmokingInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新吸烟信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:update')")
    public CommonResult<Boolean> updateExperimentSurveySmokingInfo(@Valid @RequestBody ExperimentSurveySmokingInfoSaveReqVO updateReqVO) {
        experimentSurveySmokingInfoService.updateExperimentSurveySmokingInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除吸烟信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveySmokingInfo(@RequestParam("id") Long id) {
        experimentSurveySmokingInfoService.deleteExperimentSurveySmokingInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得吸烟信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:query')")
    public CommonResult<ExperimentSurveySmokingInfoRespVO> getExperimentSurveySmokingInfo(@RequestParam("id") Long id) {
        ExperimentSurveySmokingInfoDO experimentSurveySmokingInfo = experimentSurveySmokingInfoService.getExperimentSurveySmokingInfo(id);
        return success(BeanUtils.toBean(experimentSurveySmokingInfo, ExperimentSurveySmokingInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得吸烟信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:query')")
    public CommonResult<PageResult<ExperimentSurveySmokingInfoRespVO>> getExperimentSurveySmokingInfoPage(@Valid ExperimentSurveySmokingInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveySmokingInfoDO> pageResult = experimentSurveySmokingInfoService.getExperimentSurveySmokingInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveySmokingInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出吸烟信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-smoking-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveySmokingInfoExcel(@Valid ExperimentSurveySmokingInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveySmokingInfoDO> list = experimentSurveySmokingInfoService.getExperimentSurveySmokingInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "吸烟信息.xls", "数据", ExperimentSurveySmokingInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveySmokingInfoRespVO.class));
    }

}