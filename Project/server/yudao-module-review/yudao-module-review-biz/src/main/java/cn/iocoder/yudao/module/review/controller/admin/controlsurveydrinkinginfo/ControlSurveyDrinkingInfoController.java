package cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo;

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

import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoDO;
import cn.iocoder.yudao.module.review.service.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoService;

@Tag(name = "管理后台 - 对照组流调-饮酒情况")
@RestController
@RequestMapping("/review/control-survey-drinking-info")
@Validated
public class ControlSurveyDrinkingInfoController {

    @Resource
    private ControlSurveyDrinkingInfoService controlSurveyDrinkingInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-饮酒情况")
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:create')")
    public CommonResult<Long> createControlSurveyDrinkingInfo(@Valid @RequestBody ControlSurveyDrinkingInfoSaveReqVO createReqVO) {
        return success(controlSurveyDrinkingInfoService.createControlSurveyDrinkingInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-饮酒情况")
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:update')")
    public CommonResult<Boolean> updateControlSurveyDrinkingInfo(@Valid @RequestBody ControlSurveyDrinkingInfoSaveReqVO updateReqVO) {
        controlSurveyDrinkingInfoService.updateControlSurveyDrinkingInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-饮酒情况")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:delete')")
    public CommonResult<Boolean> deleteControlSurveyDrinkingInfo(@RequestParam("id") Long id) {
        controlSurveyDrinkingInfoService.deleteControlSurveyDrinkingInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-饮酒情况")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:query')")
    public CommonResult<ControlSurveyDrinkingInfoRespVO> getControlSurveyDrinkingInfo(@RequestParam("id") Long id) {
        ControlSurveyDrinkingInfoDO controlSurveyDrinkingInfo = controlSurveyDrinkingInfoService.getControlSurveyDrinkingInfo(id);
        return success(BeanUtils.toBean(controlSurveyDrinkingInfo, ControlSurveyDrinkingInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-饮酒情况分页")
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:query')")
    public CommonResult<PageResult<ControlSurveyDrinkingInfoRespVO>> getControlSurveyDrinkingInfoPage(@Valid ControlSurveyDrinkingInfoPageReqVO pageReqVO) {
        PageResult<ControlSurveyDrinkingInfoDO> pageResult = controlSurveyDrinkingInfoService.getControlSurveyDrinkingInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyDrinkingInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-饮酒情况 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-survey-drinking-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyDrinkingInfoExcel(@Valid ControlSurveyDrinkingInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyDrinkingInfoDO> list = controlSurveyDrinkingInfoService.getControlSurveyDrinkingInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-饮酒情况.xls", "数据", ControlSurveyDrinkingInfoRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyDrinkingInfoRespVO.class));
    }

}