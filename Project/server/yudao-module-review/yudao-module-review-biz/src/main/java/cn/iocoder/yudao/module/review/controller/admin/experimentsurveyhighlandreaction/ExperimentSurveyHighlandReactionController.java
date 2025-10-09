package cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionDO;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionService;

@Tag(name = "管理后台 - 实验组流调-高原反应信息")
@RestController
@RequestMapping("/review/experiment-survey-highland-reaction")
@Validated
public class ExperimentSurveyHighlandReactionController {

    @Resource
    private ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-高原反应信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:create')")
    public CommonResult<Long> createExperimentSurveyHighlandReaction(@Valid @RequestBody ExperimentSurveyHighlandReactionSaveReqVO createReqVO) {
        return success(experimentSurveyHighlandReactionService.createExperimentSurveyHighlandReaction(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-高原反应信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:update')")
    public CommonResult<Boolean> updateExperimentSurveyHighlandReaction(@Valid @RequestBody ExperimentSurveyHighlandReactionSaveReqVO updateReqVO) {
        experimentSurveyHighlandReactionService.updateExperimentSurveyHighlandReaction(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-高原反应信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyHighlandReaction(@RequestParam("id") Long id) {
        experimentSurveyHighlandReactionService.deleteExperimentSurveyHighlandReaction(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-高原反应信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:query')")
    public CommonResult<ExperimentSurveyHighlandReactionRespVO> getExperimentSurveyHighlandReaction(@RequestParam("id") Long id) {
        ExperimentSurveyHighlandReactionDO experimentSurveyHighlandReaction = experimentSurveyHighlandReactionService.getExperimentSurveyHighlandReaction(id);
        return success(BeanUtils.toBean(experimentSurveyHighlandReaction, ExperimentSurveyHighlandReactionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-高原反应信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:query')")
    public CommonResult<PageResult<ExperimentSurveyHighlandReactionRespVO>> getExperimentSurveyHighlandReactionPage(@Valid ExperimentSurveyHighlandReactionPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyHighlandReactionDO> pageResult = experimentSurveyHighlandReactionService.getExperimentSurveyHighlandReactionPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyHighlandReactionRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-高原反应信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-highland-reaction:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyHighlandReactionExcel(@Valid ExperimentSurveyHighlandReactionPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyHighlandReactionDO> list = experimentSurveyHighlandReactionService.getExperimentSurveyHighlandReactionPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-高原反应信息.xls", "数据", ExperimentSurveyHighlandReactionRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyHighlandReactionRespVO.class));
    }

}