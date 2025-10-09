package cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

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

import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicotherinfo.ProspectiveBasicOtherInfoDO;
import cn.iocoder.yudao.module.prospective.service.basicotherinfo.ProspectiveBasicOtherInfoService;

@Tag(name = "管理后台 - 基础其他信息")
@RestController
@RequestMapping("/prospective/basic-other-info")
@Validated
public class ProspectiveBasicOtherInfoController {

    @Resource
    private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建基础其他信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:create')")
    public CommonResult<Long> createExperimentSurveyBasicOtherInfo(@Valid @RequestBody BasicOtherInfoSaveReqVO createReqVO) {
        return success(prospectiveBasicOtherInfoService.createExperimentSurveyBasicOtherInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础其他信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyBasicOtherInfo(@Valid @RequestBody BasicOtherInfoSaveReqVO updateReqVO) {
        prospectiveBasicOtherInfoService.updateExperimentSurveyBasicOtherInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础其他信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyBasicOtherInfo(@RequestParam("id") Long id) {
        prospectiveBasicOtherInfoService.deleteExperimentSurveyBasicOtherInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础其他信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:query')")
    public CommonResult<BasicOtherInfoRespVO> getExperimentSurveyBasicOtherInfo(@RequestParam("id") Long id) {
        ProspectiveBasicOtherInfoDO experimentSurveyBasicOtherInfo = prospectiveBasicOtherInfoService.getExperimentSurveyBasicOtherInfo(id);
        return success(BeanUtils.toBean(experimentSurveyBasicOtherInfo, BasicOtherInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础其他信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:query')")
    public CommonResult<PageResult<BasicOtherInfoRespVO>> getExperimentSurveyBasicOtherInfoPage(@Valid BasicOtherInfoPageReqVO pageReqVO) {
        PageResult<ProspectiveBasicOtherInfoDO> pageResult = prospectiveBasicOtherInfoService.getExperimentSurveyBasicOtherInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicOtherInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础其他信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-other-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyBasicOtherInfoExcel(@Valid BasicOtherInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProspectiveBasicOtherInfoDO> list = prospectiveBasicOtherInfoService.getExperimentSurveyBasicOtherInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础其他信息.xls", "数据", BasicOtherInfoRespVO.class,
                        BeanUtils.toBean(list, BasicOtherInfoRespVO.class));
    }

}