package cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo;

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

import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveysmokinginfo.ControlSurveySmokingInfoDO;
import cn.iocoder.yudao.module.review.service.controlsurveysmokinginfo.ControlSurveySmokingInfoService;

@Tag(name = "管理后台 - 对照组流调-吸烟情况")
@RestController
@RequestMapping("/review/control-survey-smoking-info")
@Validated
public class ControlSurveySmokingInfoController {

    @Resource
    private ControlSurveySmokingInfoService controlSurveySmokingInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-吸烟情况")
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:create')")
    public CommonResult<Long> createControlSurveySmokingInfo(@Valid @RequestBody ControlSurveySmokingInfoSaveReqVO createReqVO) {
        return success(controlSurveySmokingInfoService.createControlSurveySmokingInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-吸烟情况")
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:update')")
    public CommonResult<Boolean> updateControlSurveySmokingInfo(@Valid @RequestBody ControlSurveySmokingInfoSaveReqVO updateReqVO) {
        controlSurveySmokingInfoService.updateControlSurveySmokingInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-吸烟情况")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:delete')")
    public CommonResult<Boolean> deleteControlSurveySmokingInfo(@RequestParam("id") Long id) {
        controlSurveySmokingInfoService.deleteControlSurveySmokingInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-吸烟情况")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:query')")
    public CommonResult<ControlSurveySmokingInfoRespVO> getControlSurveySmokingInfo(@RequestParam("id") Long id) {
        ControlSurveySmokingInfoDO controlSurveySmokingInfo = controlSurveySmokingInfoService.getControlSurveySmokingInfo(id);
        return success(BeanUtils.toBean(controlSurveySmokingInfo, ControlSurveySmokingInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-吸烟情况分页")
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:query')")
    public CommonResult<PageResult<ControlSurveySmokingInfoRespVO>> getControlSurveySmokingInfoPage(@Valid ControlSurveySmokingInfoPageReqVO pageReqVO) {
        PageResult<ControlSurveySmokingInfoDO> pageResult = controlSurveySmokingInfoService.getControlSurveySmokingInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveySmokingInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-吸烟情况 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-survey-smoking-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveySmokingInfoExcel(@Valid ControlSurveySmokingInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveySmokingInfoDO> list = controlSurveySmokingInfoService.getControlSurveySmokingInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-吸烟情况.xls", "数据", ControlSurveySmokingInfoRespVO.class,
                        BeanUtils.toBean(list, ControlSurveySmokingInfoRespVO.class));
    }

}