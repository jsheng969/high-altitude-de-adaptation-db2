package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsDO;
import cn.iocoder.yudao.module.prospective.service.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsService;

@Tag(name = "管理后台 - 对照组流调-退役后返回平原1月内症状")
@RestController
@RequestMapping("/prospective/control-survey-post-return-symptoms")
@Validated
public class ControlSurveyPostReturnSymptomsController {

    @Resource
    private ControlSurveyPostReturnSymptomsService controlSurveyPostReturnSymptomsService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-退役后返回平原1月内症状")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:create')")
    public CommonResult<Long> createControlSurveyPostReturnSymptoms(@Valid @RequestBody ControlSurveyPostReturnSymptomsSaveReqVO createReqVO) {
        return success(controlSurveyPostReturnSymptomsService.createControlSurveyPostReturnSymptoms(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-退役后返回平原1月内症状")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:update')")
    public CommonResult<Boolean> updateControlSurveyPostReturnSymptoms(@Valid @RequestBody ControlSurveyPostReturnSymptomsSaveReqVO updateReqVO) {
        controlSurveyPostReturnSymptomsService.updateControlSurveyPostReturnSymptoms(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-退役后返回平原1月内症状")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:delete')")
    public CommonResult<Boolean> deleteControlSurveyPostReturnSymptoms(@RequestParam("id") Long id) {
        controlSurveyPostReturnSymptomsService.deleteControlSurveyPostReturnSymptoms(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-退役后返回平原1月内症状")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:query')")
    public CommonResult<ControlSurveyPostReturnSymptomsRespVO> getControlSurveyPostReturnSymptoms(@RequestParam("id") Long id) {
        ControlSurveyPostReturnSymptomsDO controlSurveyPostReturnSymptoms = controlSurveyPostReturnSymptomsService.getControlSurveyPostReturnSymptoms(id);
        return success(BeanUtils.toBean(controlSurveyPostReturnSymptoms, ControlSurveyPostReturnSymptomsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-退役后返回平原1月内症状分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:query')")
    public CommonResult<PageResult<ControlSurveyPostReturnSymptomsRespVO>> getControlSurveyPostReturnSymptomsPage(@Valid ControlSurveyPostReturnSymptomsPageReqVO pageReqVO) {
        PageResult<ControlSurveyPostReturnSymptomsDO> pageResult = controlSurveyPostReturnSymptomsService.getControlSurveyPostReturnSymptomsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyPostReturnSymptomsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-退役后返回平原1月内症状 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-post-return-symptoms:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyPostReturnSymptomsExcel(@Valid ControlSurveyPostReturnSymptomsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyPostReturnSymptomsDO> list = controlSurveyPostReturnSymptomsService.getControlSurveyPostReturnSymptomsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-退役后返回平原1月内症状.xls", "数据", ControlSurveyPostReturnSymptomsRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyPostReturnSymptomsRespVO.class));
    }

}