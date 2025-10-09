package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
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

import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveyscoresummary.ControlSurveyScoreSummaryDO;
import cn.iocoder.yudao.module.prospective.service.controlsurveyscoresummary.ControlSurveyScoreSummaryService;

@Tag(name = "管理后台 - 对照组流调-评分总数统计")
@RestController
@RequestMapping("/prospective/control-survey-score-summary")
@Validated
public class ControlSurveyScoreSummaryController {

    @Resource
    private ControlSurveyScoreSummaryService controlSurveyScoreSummaryService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-评分总数统计")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:create')")
    public CommonResult<Long> createControlSurveyScoreSummary(@Valid @RequestBody ControlSurveyScoreSummarySaveReqVO createReqVO) {
        return success(controlSurveyScoreSummaryService.createControlSurveyScoreSummary(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-评分总数统计")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:update')")
    public CommonResult<Boolean> updateControlSurveyScoreSummary(@Valid @RequestBody ControlSurveyScoreSummarySaveReqVO updateReqVO) {
        controlSurveyScoreSummaryService.updateControlSurveyScoreSummary(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-评分总数统计")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:delete')")
    public CommonResult<Boolean> deleteControlSurveyScoreSummary(@RequestParam("id") Long id) {
        controlSurveyScoreSummaryService.deleteControlSurveyScoreSummary(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-评分总数统计")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:query')")
    public CommonResult<ControlSurveyScoreSummaryRespVO> getControlSurveyScoreSummary(@RequestParam("id") Long id) {
        ControlSurveyScoreSummaryDO controlSurveyScoreSummary = controlSurveyScoreSummaryService.getControlSurveyScoreSummary(id);
        return success(BeanUtils.toBean(controlSurveyScoreSummary, ControlSurveyScoreSummaryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-评分总数统计分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:query')")
    public CommonResult<PageResult<ControlSurveyScoreSummaryRespVO>> getControlSurveyScoreSummaryPage(@Valid ControlSurveyScoreSummaryPageReqVO pageReqVO) {
        PageResult<ControlSurveyScoreSummaryDO> pageResult = controlSurveyScoreSummaryService.getControlSurveyScoreSummaryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyScoreSummaryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-评分总数统计 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-score-summary:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyScoreSummaryExcel(@Valid ControlSurveyScoreSummaryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyScoreSummaryDO> list = controlSurveyScoreSummaryService.getControlSurveyScoreSummaryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-评分总数统计.xls", "数据", ControlSurveyScoreSummaryRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyScoreSummaryRespVO.class));
    }

}