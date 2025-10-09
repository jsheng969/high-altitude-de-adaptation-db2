package cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases;

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

import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveypastdiseases.ControlSurveyPastDiseasesDO;
import cn.iocoder.yudao.module.review.service.controlsurveypastdiseases.ControlSurveyPastDiseasesService;

@Tag(name = "管理后台 - 对照组流调-既往疾病")
@RestController
@RequestMapping("/review/control-survey-past-diseases")
@Validated
public class ControlSurveyPastDiseasesController {

    @Resource
    private ControlSurveyPastDiseasesService controlSurveyPastDiseasesService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-既往疾病")
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:create')")
    public CommonResult<Long> createControlSurveyPastDiseases(@Valid @RequestBody ControlSurveyPastDiseasesSaveReqVO createReqVO) {
        return success(controlSurveyPastDiseasesService.createControlSurveyPastDiseases(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-既往疾病")
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:update')")
    public CommonResult<Boolean> updateControlSurveyPastDiseases(@Valid @RequestBody ControlSurveyPastDiseasesSaveReqVO updateReqVO) {
        controlSurveyPastDiseasesService.updateControlSurveyPastDiseases(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-既往疾病")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:delete')")
    public CommonResult<Boolean> deleteControlSurveyPastDiseases(@RequestParam("id") Long id) {
        controlSurveyPastDiseasesService.deleteControlSurveyPastDiseases(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-既往疾病")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:query')")
    public CommonResult<ControlSurveyPastDiseasesRespVO> getControlSurveyPastDiseases(@RequestParam("id") Long id) {
        ControlSurveyPastDiseasesDO controlSurveyPastDiseases = controlSurveyPastDiseasesService.getControlSurveyPastDiseases(id);
        return success(BeanUtils.toBean(controlSurveyPastDiseases, ControlSurveyPastDiseasesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-既往疾病分页")
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:query')")
    public CommonResult<PageResult<ControlSurveyPastDiseasesRespVO>> getControlSurveyPastDiseasesPage(@Valid ControlSurveyPastDiseasesPageReqVO pageReqVO) {
        PageResult<ControlSurveyPastDiseasesDO> pageResult = controlSurveyPastDiseasesService.getControlSurveyPastDiseasesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyPastDiseasesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-既往疾病 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-survey-past-diseases:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyPastDiseasesExcel(@Valid ControlSurveyPastDiseasesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyPastDiseasesDO> list = controlSurveyPastDiseasesService.getControlSurveyPastDiseasesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-既往疾病.xls", "数据", ControlSurveyPastDiseasesRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyPastDiseasesRespVO.class));
    }

}