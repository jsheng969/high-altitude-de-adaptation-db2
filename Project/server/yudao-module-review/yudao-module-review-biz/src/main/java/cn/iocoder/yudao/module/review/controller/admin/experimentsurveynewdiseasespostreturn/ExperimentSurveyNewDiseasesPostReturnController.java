package cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnDO;
import cn.iocoder.yudao.module.review.service.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnService;

@Tag(name = "管理后台 - 实验组流调-返回平原后新发的疾病")
@RestController
@RequestMapping("/review/experiment-survey-new-diseases-post-return")
@Validated
public class ExperimentSurveyNewDiseasesPostReturnController {

    @Resource
    private ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组流调-返回平原后新发的疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:create')")
    public CommonResult<Long> createExperimentSurveyNewDiseasesPostReturn(@Valid @RequestBody ExperimentSurveyNewDiseasesPostReturnSaveReqVO createReqVO) {
        return success(experimentSurveyNewDiseasesPostReturnService.createExperimentSurveyNewDiseasesPostReturn(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组流调-返回平原后新发的疾病")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:update')")
    public CommonResult<Boolean> updateExperimentSurveyNewDiseasesPostReturn(@Valid @RequestBody ExperimentSurveyNewDiseasesPostReturnSaveReqVO updateReqVO) {
        experimentSurveyNewDiseasesPostReturnService.updateExperimentSurveyNewDiseasesPostReturn(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组流调-返回平原后新发的疾病")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:delete')")
    public CommonResult<Boolean> deleteExperimentSurveyNewDiseasesPostReturn(@RequestParam("id") Long id) {
        experimentSurveyNewDiseasesPostReturnService.deleteExperimentSurveyNewDiseasesPostReturn(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组流调-返回平原后新发的疾病")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:query')")
    public CommonResult<ExperimentSurveyNewDiseasesPostReturnRespVO> getExperimentSurveyNewDiseasesPostReturn(@RequestParam("id") Long id) {
        ExperimentSurveyNewDiseasesPostReturnDO experimentSurveyNewDiseasesPostReturn = experimentSurveyNewDiseasesPostReturnService.getExperimentSurveyNewDiseasesPostReturn(id);
        return success(BeanUtils.toBean(experimentSurveyNewDiseasesPostReturn, ExperimentSurveyNewDiseasesPostReturnRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组流调-返回平原后新发的疾病分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:query')")
    public CommonResult<PageResult<ExperimentSurveyNewDiseasesPostReturnRespVO>> getExperimentSurveyNewDiseasesPostReturnPage(@Valid ExperimentSurveyNewDiseasesPostReturnPageReqVO pageReqVO) {
        PageResult<ExperimentSurveyNewDiseasesPostReturnDO> pageResult = experimentSurveyNewDiseasesPostReturnService.getExperimentSurveyNewDiseasesPostReturnPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentSurveyNewDiseasesPostReturnRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组流调-返回平原后新发的疾病 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-survey-new-diseases-post-return:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentSurveyNewDiseasesPostReturnExcel(@Valid ExperimentSurveyNewDiseasesPostReturnPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentSurveyNewDiseasesPostReturnDO> list = experimentSurveyNewDiseasesPostReturnService.getExperimentSurveyNewDiseasesPostReturnPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组流调-返回平原后新发的疾病.xls", "数据", ExperimentSurveyNewDiseasesPostReturnRespVO.class,
                        BeanUtils.toBean(list, ExperimentSurveyNewDiseasesPostReturnRespVO.class));
    }

}