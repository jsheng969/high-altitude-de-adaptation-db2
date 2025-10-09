package cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo;

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

import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyresidenceinfo.ControlSurveyResidenceInfoDO;
import cn.iocoder.yudao.module.review.service.controlsurveyresidenceinfo.ControlSurveyResidenceInfoService;

@Tag(name = "管理后台 - 对照组流调-旅居信息")
@RestController
@RequestMapping("/review/control-survey-residence-info")
@Validated
public class ControlSurveyResidenceInfoController {

    @Resource
    private ControlSurveyResidenceInfoService controlSurveyResidenceInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-旅居信息")
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:create')")
    public CommonResult<Long> createControlSurveyResidenceInfo(@Valid @RequestBody ControlSurveyResidenceInfoSaveReqVO createReqVO) {
        return success(controlSurveyResidenceInfoService.createControlSurveyResidenceInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-旅居信息")
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:update')")
    public CommonResult<Boolean> updateControlSurveyResidenceInfo(@Valid @RequestBody ControlSurveyResidenceInfoSaveReqVO updateReqVO) {
        controlSurveyResidenceInfoService.updateControlSurveyResidenceInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-旅居信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:delete')")
    public CommonResult<Boolean> deleteControlSurveyResidenceInfo(@RequestParam("id") Long id) {
        controlSurveyResidenceInfoService.deleteControlSurveyResidenceInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-旅居信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:query')")
    public CommonResult<ControlSurveyResidenceInfoRespVO> getControlSurveyResidenceInfo(@RequestParam("id") Long id) {
        ControlSurveyResidenceInfoDO controlSurveyResidenceInfo = controlSurveyResidenceInfoService.getControlSurveyResidenceInfo(id);
        return success(BeanUtils.toBean(controlSurveyResidenceInfo, ControlSurveyResidenceInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-旅居信息分页")
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:query')")
    public CommonResult<PageResult<ControlSurveyResidenceInfoRespVO>> getControlSurveyResidenceInfoPage(@Valid ControlSurveyResidenceInfoPageReqVO pageReqVO) {
        PageResult<ControlSurveyResidenceInfoDO> pageResult = controlSurveyResidenceInfoService.getControlSurveyResidenceInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyResidenceInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-旅居信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-survey-residence-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyResidenceInfoExcel(@Valid ControlSurveyResidenceInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyResidenceInfoDO> list = controlSurveyResidenceInfoService.getControlSurveyResidenceInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-旅居信息.xls", "数据", ControlSurveyResidenceInfoRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyResidenceInfoRespVO.class));
    }

}