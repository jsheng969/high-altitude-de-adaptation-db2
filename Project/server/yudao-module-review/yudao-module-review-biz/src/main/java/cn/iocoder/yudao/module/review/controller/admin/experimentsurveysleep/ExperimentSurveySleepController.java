package cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveysleep.ExperimentSurveySleepDO;
import cn.iocoder.yudao.module.review.service.experimentsurveysleep.ExperimentSurveySleepService;

@Tag(name = "管理后台 - 实验组流调-睡眠信息")
@RestController
@RequestMapping("/review/experiment-survey-sleep")
@Validated
public class ExperimentSurveySleepController {

    @Resource
    private ExperimentSurveySleepService experimentSurveySleepService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-睡眠信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:create')")
    public CommonResult<Long> createExperimentSurveySleep(@Valid @RequestBody ExperimentSurveySleepSaveReqVO createReqVO) {
        return success(experimentSurveySleepService.createExperimentSurveySleep(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-睡眠信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:update')")
    public CommonResult<Boolean> updateExperimentSurveySleep(@Valid @RequestBody ExperimentSurveySleepSaveReqVO updateReqVO) {
        experimentSurveySleepService.updateExperimentSurveySleep(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-睡眠信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:delete')")
    public CommonResult<Boolean> deleteExperimentSurveySleep(@RequestParam("id") Long id) {
        experimentSurveySleepService.deleteExperimentSurveySleep(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-睡眠信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:query')")
    public CommonResult<ExperimentSurveySleepRespVO> getExperimentSurveySleep(@RequestParam("id") Long id) {
        ExperimentSurveySleepDO experimentSurveySleep = experimentSurveySleepService.getExperimentSurveySleep(id);
        return success(BeanUtils.toBean(experimentSurveySleep, ExperimentSurveySleepRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-睡眠信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:query')")
    public CommonResult<PageResult<ExperimentSurveySleepRespVO>> getExperimentSurveySleepPage(@Valid ExperimentSurveySleepPageReqVO pageReqVO) {
        PageResult<ExperimentSurveySleepDO> pageResult = experimentSurveySleepService.getExperimentSurveySleepPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveySleepRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-睡眠信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-sleep:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveySleepExcel(@Valid ExperimentSurveySleepPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveySleepDO> list = experimentSurveySleepService.getExperimentSurveySleepPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-睡眠信息.xls", "数据", ExperimentSurveySleepRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveySleepRespVO.class));
    }

}