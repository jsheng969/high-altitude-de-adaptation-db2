package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydrinking.ExperimentSurveyDrinkingDO;
import cn.iocoder.yudao.module.review.service.experimentsurveydrinking.ExperimentSurveyDrinkingService;

@Tag(name = "管理后台 - 实验组流调-饮酒情况")
@RestController
@RequestMapping("/review/experiment-survey-drinking")
@Validated
public class ExperimentSurveyDrinkingController {

    @Resource
    private ExperimentSurveyDrinkingService experimentSurveyDrinkingService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-饮酒情况")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:create')")
    public CommonResult<Long> createExperimentSurveyDrinking(@Valid @RequestBody ExperimentSurveyDrinkingSaveReqVO createReqVO) {
        return success(experimentSurveyDrinkingService.createExperimentSurveyDrinking(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-饮酒情况")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:update')")
    public CommonResult<Boolean> updateExperimentSurveyDrinking(@Valid @RequestBody ExperimentSurveyDrinkingSaveReqVO updateReqVO) {
        experimentSurveyDrinkingService.updateExperimentSurveyDrinking(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-饮酒情况")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyDrinking(@RequestParam("id") Long id) {
        experimentSurveyDrinkingService.deleteExperimentSurveyDrinking(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-饮酒情况")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:query')")
    public CommonResult<ExperimentSurveyDrinkingRespVO> getExperimentSurveyDrinking(@RequestParam("id") Long id) {
        ExperimentSurveyDrinkingDO experimentSurveyDrinking = experimentSurveyDrinkingService.getExperimentSurveyDrinking(id);
        return success(BeanUtils.toBean(experimentSurveyDrinking, ExperimentSurveyDrinkingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-饮酒情况分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:query')")
    public CommonResult<PageResult<ExperimentSurveyDrinkingRespVO>> getExperimentSurveyDrinkingPage(@Valid ExperimentSurveyDrinkingPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyDrinkingDO> pageResult = experimentSurveyDrinkingService.getExperimentSurveyDrinkingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyDrinkingRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-饮酒情况 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-drinking:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyDrinkingExcel(@Valid ExperimentSurveyDrinkingPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyDrinkingDO> list = experimentSurveyDrinkingService.getExperimentSurveyDrinkingPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-饮酒情况.xls", "数据", ExperimentSurveyDrinkingRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyDrinkingRespVO.class));
    }

}