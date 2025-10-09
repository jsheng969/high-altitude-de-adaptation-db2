package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.module.prospective.service.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyService;

@Tag(name = "管理后台 - 对照组流调-推进情况调查")
@RestController
@RequestMapping("/prospective/control-survey-mission-progress-survey")
@Validated
public class ControlSurveyMissionProgressSurveyController {

    @Resource
    private ControlSurveyMissionProgressSurveyService controlSurveyMissionProgressSurveyService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-推进情况调查")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:create')")
    public CommonResult<Long> createControlSurveyMissionProgressSurvey(@Valid @RequestBody ControlSurveyMissionProgressSurveySaveReqVO createReqVO) {
        return success(controlSurveyMissionProgressSurveyService.createControlSurveyMissionProgressSurvey(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-推进情况调查")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:update')")
    public CommonResult<Boolean> updateControlSurveyMissionProgressSurvey(@Valid @RequestBody ControlSurveyMissionProgressSurveySaveReqVO updateReqVO) {
        controlSurveyMissionProgressSurveyService.updateControlSurveyMissionProgressSurvey(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-推进情况调查")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:delete')")
    public CommonResult<Boolean> deleteControlSurveyMissionProgressSurvey(@RequestParam("id") Long id) {
        controlSurveyMissionProgressSurveyService.deleteControlSurveyMissionProgressSurvey(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-推进情况调查")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:query')")
    public CommonResult<ControlSurveyMissionProgressSurveyRespVO> getControlSurveyMissionProgressSurvey(@RequestParam("id") Long id) {
        ControlSurveyMissionProgressSurveyDO controlSurveyMissionProgressSurvey = controlSurveyMissionProgressSurveyService.getControlSurveyMissionProgressSurvey(id);
        return success(BeanUtils.toBean(controlSurveyMissionProgressSurvey, ControlSurveyMissionProgressSurveyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-推进情况调查分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:query')")
    public CommonResult<PageResult<ControlSurveyMissionProgressSurveyRespVO>> getControlSurveyMissionProgressSurveyPage(@Valid ControlSurveyMissionProgressSurveyPageReqVO pageReqVO) {
        PageResult<ControlSurveyMissionProgressSurveyDO> pageResult = controlSurveyMissionProgressSurveyService.getControlSurveyMissionProgressSurveyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyMissionProgressSurveyRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-推进情况调查 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-mission-progress-survey:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyMissionProgressSurveyExcel(@Valid ControlSurveyMissionProgressSurveyPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyMissionProgressSurveyDO> list = controlSurveyMissionProgressSurveyService.getControlSurveyMissionProgressSurveyPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-推进情况调查.xls", "数据", ControlSurveyMissionProgressSurveyRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyMissionProgressSurveyRespVO.class));
    }

}