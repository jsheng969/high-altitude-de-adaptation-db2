package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyexercise.ExperimentSurveyExerciseDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyexercise.ExperimentSurveyExerciseService;

@Tag(name = "管理后台 - 实验组流调-体育锻炼信息")
@RestController
@RequestMapping("/review/experiment-survey-exercise")
@Validated
public class ExperimentSurveyExerciseController {

    @Resource
    private ExperimentSurveyExerciseService experimentSurveyExerciseService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-体育锻炼信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:create')")
    public CommonResult<Long> createExperimentSurveyExercise(@Valid @RequestBody ExperimentSurveyExerciseSaveReqVO createReqVO) {
        return success(experimentSurveyExerciseService.createExperimentSurveyExercise(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-体育锻炼信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:update')")
    public CommonResult<Boolean> updateExperimentSurveyExercise(@Valid @RequestBody ExperimentSurveyExerciseSaveReqVO updateReqVO) {
        experimentSurveyExerciseService.updateExperimentSurveyExercise(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-体育锻炼信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyExercise(@RequestParam("id") Long id) {
        experimentSurveyExerciseService.deleteExperimentSurveyExercise(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-体育锻炼信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:query')")
    public CommonResult<ExperimentSurveyExerciseRespVO> getExperimentSurveyExercise(@RequestParam("id") Long id) {
        ExperimentSurveyExerciseDO experimentSurveyExercise = experimentSurveyExerciseService.getExperimentSurveyExercise(id);
        return success(BeanUtils.toBean(experimentSurveyExercise, ExperimentSurveyExerciseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-体育锻炼信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:query')")
    public CommonResult<PageResult<ExperimentSurveyExerciseRespVO>> getExperimentSurveyExercisePage(@Valid ExperimentSurveyExercisePageReqVO pageReqVO) {
        PageResult<ExperimentSurveyExerciseDO> pageResult = experimentSurveyExerciseService.getExperimentSurveyExercisePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyExerciseRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-体育锻炼信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-exercise:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyExerciseExcel(@Valid ExperimentSurveyExercisePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyExerciseDO> list = experimentSurveyExerciseService.getExperimentSurveyExercisePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-体育锻炼信息.xls", "数据", ExperimentSurveyExerciseRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyExerciseRespVO.class));
    }

}