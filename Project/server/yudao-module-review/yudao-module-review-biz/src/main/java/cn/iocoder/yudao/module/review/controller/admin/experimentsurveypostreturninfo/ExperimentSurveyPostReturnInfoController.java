package cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoDO;
import cn.iocoder.yudao.module.review.service.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoService;

@Tag(name = "管理后台 - 实验组流调-返回后基础信息")
@RestController
@RequestMapping("/review/experiment-survey-post-return-info")
@Validated
public class ExperimentSurveyPostReturnInfoController {

    @Resource
    private ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-返回后基础信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:create')")
    public CommonResult<Long> createExperimentSurveyPostReturnInfo(@Valid @RequestBody ExperimentSurveyPostReturnInfoSaveReqVO createReqVO) {
        return success(experimentSurveyPostReturnInfoService.createExperimentSurveyPostReturnInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-返回后基础信息")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:update')")
    public CommonResult<Boolean> updateExperimentSurveyPostReturnInfo(@Valid @RequestBody ExperimentSurveyPostReturnInfoSaveReqVO updateReqVO) {
        experimentSurveyPostReturnInfoService.updateExperimentSurveyPostReturnInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-返回后基础信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyPostReturnInfo(@RequestParam("id") Long id) {
        experimentSurveyPostReturnInfoService.deleteExperimentSurveyPostReturnInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-返回后基础信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:query')")
    public CommonResult<ExperimentSurveyPostReturnInfoRespVO> getExperimentSurveyPostReturnInfo(@RequestParam("id") Long id) {
        ExperimentSurveyPostReturnInfoDO experimentSurveyPostReturnInfo = experimentSurveyPostReturnInfoService.getExperimentSurveyPostReturnInfo(id);
        return success(BeanUtils.toBean(experimentSurveyPostReturnInfo, ExperimentSurveyPostReturnInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-返回后基础信息分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:query')")
    public CommonResult<PageResult<ExperimentSurveyPostReturnInfoRespVO>> getExperimentSurveyPostReturnInfoPage(@Valid ExperimentSurveyPostReturnInfoPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyPostReturnInfoDO> pageResult = experimentSurveyPostReturnInfoService.getExperimentSurveyPostReturnInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyPostReturnInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-返回后基础信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-post-return-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyPostReturnInfoExcel(@Valid ExperimentSurveyPostReturnInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyPostReturnInfoDO> list = experimentSurveyPostReturnInfoService.getExperimentSurveyPostReturnInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-返回后基础信息.xls", "数据", ExperimentSurveyPostReturnInfoRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyPostReturnInfoRespVO.class));
    }

}