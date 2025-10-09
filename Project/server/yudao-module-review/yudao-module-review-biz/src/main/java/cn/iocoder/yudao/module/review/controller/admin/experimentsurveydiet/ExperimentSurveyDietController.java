package cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydiet.ExperimentSurveyDietDO;
import cn.iocoder.yudao.module.review.service.experimentsurveydiet.ExperimentSurveyDietService;

@Tag(name = "管理后台 - 实验组流调-饮食习惯")
@RestController
@RequestMapping("/review/experiment-survey-diet")
@Validated
public class ExperimentSurveyDietController {

    @Resource
    private ExperimentSurveyDietService experimentSurveyDietService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-饮食习惯")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:create')")
    public CommonResult<Long> createExperimentSurveyDiet(@Valid @RequestBody ExperimentSurveyDietSaveReqVO createReqVO) {
        return success(experimentSurveyDietService.createExperimentSurveyDiet(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-饮食习惯")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:update')")
    public CommonResult<Boolean> updateExperimentSurveyDiet(@Valid @RequestBody ExperimentSurveyDietSaveReqVO updateReqVO) {
        experimentSurveyDietService.updateExperimentSurveyDiet(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-饮食习惯")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyDiet(@RequestParam("id") Long id) {
        experimentSurveyDietService.deleteExperimentSurveyDiet(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-饮食习惯")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:query')")
    public CommonResult<ExperimentSurveyDietRespVO> getExperimentSurveyDiet(@RequestParam("id") Long id) {
        ExperimentSurveyDietDO experimentSurveyDiet = experimentSurveyDietService.getExperimentSurveyDiet(id);
        return success(BeanUtils.toBean(experimentSurveyDiet, ExperimentSurveyDietRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-饮食习惯分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:query')")
    public CommonResult<PageResult<ExperimentSurveyDietRespVO>> getExperimentSurveyDietPage(@Valid ExperimentSurveyDietPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyDietDO> pageResult = experimentSurveyDietService.getExperimentSurveyDietPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyDietRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-饮食习惯 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-diet:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyDietExcel(@Valid ExperimentSurveyDietPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyDietDO> list = experimentSurveyDietService.getExperimentSurveyDietPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-饮食习惯.xls", "数据", ExperimentSurveyDietRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyDietRespVO.class));
    }

}