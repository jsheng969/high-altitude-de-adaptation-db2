package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;


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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoService;

@Tag(name = "管理后台 - 实验组流调-服役信息")
@RestController
@RequestMapping("/review/experiment-survey-service-info")
@Validated
public class ExperimentSurveyServiceInfoController {

    @Resource
    private ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-服役信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:create')")
    public CommonResult<Long> createExperimentSurveyServiceInfo(@Valid @RequestBody ExperimentSurveyServiceInfoSaveReqVO createReqVO) {
        return success(experimentSurveyServiceInfoService.createExperimentSurveyServiceInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-服役信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyServiceInfo(@Valid @RequestBody ExperimentSurveyServiceInfoSaveReqVO updateReqVO) {
        experimentSurveyServiceInfoService.updateExperimentSurveyServiceInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-服役信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyServiceInfo(@RequestParam("id") Long id) {
        experimentSurveyServiceInfoService.deleteExperimentSurveyServiceInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-服役信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:query')")
    public CommonResult<ExperimentSurveyServiceInfoRespVO> getExperimentSurveyServiceInfo(@RequestParam("id") Long id) {
        ExperimentSurveyServiceInfoDO experimentSurveyServiceInfo = experimentSurveyServiceInfoService.getExperimentSurveyServiceInfo(id);
        return success(BeanUtils.toBean(experimentSurveyServiceInfo, ExperimentSurveyServiceInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-服役信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:query')")
    public CommonResult<PageResult<ExperimentSurveyServiceInfoRespVO>> getExperimentSurveyServiceInfoPage(@Valid ExperimentSurveyServiceInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyServiceInfoDO> pageResult = experimentSurveyServiceInfoService.getExperimentSurveyServiceInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyServiceInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-服役信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-service-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyServiceInfoExcel(@Valid ExperimentSurveyServiceInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyServiceInfoDO> list = experimentSurveyServiceInfoService.getExperimentSurveyServiceInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-服役信息.xls", "数据", ExperimentSurveyServiceInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyServiceInfoRespVO.class));
    }

}