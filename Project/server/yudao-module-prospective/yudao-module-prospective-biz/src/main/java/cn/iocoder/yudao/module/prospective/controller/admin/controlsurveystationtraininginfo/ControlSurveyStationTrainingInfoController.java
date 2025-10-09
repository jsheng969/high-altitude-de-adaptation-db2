package cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.module.prospective.service.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoService;

@Tag(name = "管理后台 - 对照组流调-驻训信息")
@RestController
@RequestMapping("/prospective/control-survey-station-training-info")
@Validated
public class ControlSurveyStationTrainingInfoController {

    @Resource
    private ControlSurveyStationTrainingInfoService controlSurveyStationTrainingInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组流调-驻训信息")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:create')")
    public CommonResult<Long> createControlSurveyStationTrainingInfo(@Valid @RequestBody ControlSurveyStationTrainingInfoSaveReqVO createReqVO) {
        return success(controlSurveyStationTrainingInfoService.createControlSurveyStationTrainingInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组流调-驻训信息")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:update')")
    public CommonResult<Boolean> updateControlSurveyStationTrainingInfo(@Valid @RequestBody ControlSurveyStationTrainingInfoSaveReqVO updateReqVO) {
        controlSurveyStationTrainingInfoService.updateControlSurveyStationTrainingInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组流调-驻训信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:delete')")
    public CommonResult<Boolean> deleteControlSurveyStationTrainingInfo(@RequestParam("id") Long id) {
        controlSurveyStationTrainingInfoService.deleteControlSurveyStationTrainingInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组流调-驻训信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:query')")
    public CommonResult<ControlSurveyStationTrainingInfoRespVO> getControlSurveyStationTrainingInfo(@RequestParam("id") Long id) {
        ControlSurveyStationTrainingInfoDO controlSurveyStationTrainingInfo = controlSurveyStationTrainingInfoService.getControlSurveyStationTrainingInfo(id);
        return success(BeanUtils.toBean(controlSurveyStationTrainingInfo, ControlSurveyStationTrainingInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组流调-驻训信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:query')")
    public CommonResult<PageResult<ControlSurveyStationTrainingInfoRespVO>> getControlSurveyStationTrainingInfoPage(@Valid ControlSurveyStationTrainingInfoPageReqVO pageReqVO) {
        PageResult<ControlSurveyStationTrainingInfoDO> pageResult = controlSurveyStationTrainingInfoService.getControlSurveyStationTrainingInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlSurveyStationTrainingInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组流调-驻训信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-survey-station-training-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlSurveyStationTrainingInfoExcel(@Valid ControlSurveyStationTrainingInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlSurveyStationTrainingInfoDO> list = controlSurveyStationTrainingInfoService.getControlSurveyStationTrainingInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组流调-驻训信息.xls", "数据", ControlSurveyStationTrainingInfoRespVO.class,
                        BeanUtils.toBean(list, ControlSurveyStationTrainingInfoRespVO.class));
    }

}