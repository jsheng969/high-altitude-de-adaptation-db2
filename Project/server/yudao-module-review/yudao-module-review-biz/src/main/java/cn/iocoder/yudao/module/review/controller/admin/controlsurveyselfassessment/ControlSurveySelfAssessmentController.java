package cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment;

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

import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyselfassessment.ControlSurveySelfAssessmentDO;
import cn.iocoder.yudao.module.review.service.controlsurveyselfassessment.ControlSurveySelfAssessmentService;

@Tag(name = "管理后台 - 对照组流调-自我评价")
@RestController
@RequestMapping("/review/control-survey-self-assessment")
@Validated
public class ControlSurveySelfAssessmentController {

    @Resource
    private ControlSurveySelfAssessmentService controlSurveySelfAssessmentService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-自我评价")
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:create')")
    public CommonResult<Long> createControlSurveySelfAssessment(@Valid @RequestBody ControlSurveySelfAssessmentSaveReqVO createReqVO) {
        return success(controlSurveySelfAssessmentService.createControlSurveySelfAssessment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-自我评价")
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:update')")
    public CommonResult<Boolean> updateControlSurveySelfAssessment(@Valid @RequestBody ControlSurveySelfAssessmentSaveReqVO updateReqVO) {
        controlSurveySelfAssessmentService.updateControlSurveySelfAssessment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-自我评价")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:delete')")
    public CommonResult<Boolean> deleteControlSurveySelfAssessment(@RequestParam("id") Long id) {
        controlSurveySelfAssessmentService.deleteControlSurveySelfAssessment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-自我评价")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:query')")
    public CommonResult<ControlSurveySelfAssessmentRespVO> getControlSurveySelfAssessment(@RequestParam("id") Long id) {
        ControlSurveySelfAssessmentDO controlSurveySelfAssessment = controlSurveySelfAssessmentService.getControlSurveySelfAssessment(id);
        return success(BeanUtils.toBean(controlSurveySelfAssessment, ControlSurveySelfAssessmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-自我评价分页")
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:query')")
    public CommonResult<PageResult<ControlSurveySelfAssessmentRespVO>> getControlSurveySelfAssessmentPage(@Valid ControlSurveySelfAssessmentPageReqVO pageReqVO) {
        PageResult<ControlSurveySelfAssessmentDO> pageResult = controlSurveySelfAssessmentService.getControlSurveySelfAssessmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveySelfAssessmentRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-自我评价 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-survey-self-assessment:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveySelfAssessmentExcel(@Valid ControlSurveySelfAssessmentPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveySelfAssessmentDO> list = controlSurveySelfAssessmentService.getControlSurveySelfAssessmentPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-自我评价.xls", "数据", ControlSurveySelfAssessmentRespVO.class,
                        BeanUtils.toBean(list, ControlSurveySelfAssessmentRespVO.class));
    }

}