package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoDO;
import cn.iocoder.yudao.module.prospective.service.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoService;

@Tag(name = "管理后台 - 对照组流调-基本检测信息")
@RestController
@RequestMapping("/prospective/control-survey-basic-check-info")
@Validated
public class ControlSurveyBasicCheckInfoController {

    @Resource
    private ControlSurveyBasicCheckInfoService controlSurveyBasicCheckInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-基本检测信息")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:create')")
    public CommonResult<Long> createControlSurveyBasicCheckInfo(@Valid @RequestBody ControlSurveyBasicCheckInfoSaveReqVO createReqVO) {
        return success(controlSurveyBasicCheckInfoService.createControlSurveyBasicCheckInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-基本检测信息")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:update')")
    public CommonResult<Boolean> updateControlSurveyBasicCheckInfo(@Valid @RequestBody ControlSurveyBasicCheckInfoSaveReqVO updateReqVO) {
        controlSurveyBasicCheckInfoService.updateControlSurveyBasicCheckInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:delete')")
    public CommonResult<Boolean> deleteControlSurveyBasicCheckInfo(@RequestParam("id") Long id) {
        controlSurveyBasicCheckInfoService.deleteControlSurveyBasicCheckInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-基本检测信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:query')")
    public CommonResult<ControlSurveyBasicCheckInfoRespVO> getControlSurveyBasicCheckInfo(@RequestParam("id") Long id) {
        ControlSurveyBasicCheckInfoDO controlSurveyBasicCheckInfo = controlSurveyBasicCheckInfoService.getControlSurveyBasicCheckInfo(id);
        return success(BeanUtils.toBean(controlSurveyBasicCheckInfo, ControlSurveyBasicCheckInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-基本检测信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:query')")
    public CommonResult<PageResult<ControlSurveyBasicCheckInfoRespVO>> getControlSurveyBasicCheckInfoPage(@Valid ControlSurveyBasicCheckInfoPageReqVO pageReqVO) {
        PageResult<ControlSurveyBasicCheckInfoDO> pageResult = controlSurveyBasicCheckInfoService.getControlSurveyBasicCheckInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyBasicCheckInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-基本检测信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-basic-check-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyBasicCheckInfoExcel(@Valid ControlSurveyBasicCheckInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyBasicCheckInfoDO> list = controlSurveyBasicCheckInfoService.getControlSurveyBasicCheckInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-基本检测信息.xls", "数据", ControlSurveyBasicCheckInfoRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyBasicCheckInfoRespVO.class));
    }

}