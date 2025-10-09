package cn.iocoder.yudao.module.review.controller.admin.experimentexamecg;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamecg.ExperimentExamEcgDO;
import cn.iocoder.yudao.module.review.service.experimentexamecg.ExperimentExamEcgService;

@Tag(name = "管理后台 - 实验组体检-心电图")
@RestController
@RequestMapping("/review/experiment-exam-ecg")
@Validated
public class ExperimentExamEcgController {

    @Resource
    private ExperimentExamEcgService experimentExamEcgService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-心电图")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:create')")
    public CommonResult<Long> createExperimentExamEcg(@Valid @RequestBody ExperimentExamEcgSaveReqVO createReqVO) {
        return success(experimentExamEcgService.createExperimentExamEcg(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-心电图")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:update')")
    public CommonResult<Boolean> updateExperimentExamEcg(@Valid @RequestBody ExperimentExamEcgSaveReqVO updateReqVO) {
        experimentExamEcgService.updateExperimentExamEcg(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-心电图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:delete')")
    public CommonResult<Boolean> deleteExperimentExamEcg(@RequestParam("id") Long id) {
        experimentExamEcgService.deleteExperimentExamEcg(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-心电图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:query')")
    public CommonResult<ExperimentExamEcgRespVO> getExperimentExamEcg(@RequestParam("id") Long id) {
        ExperimentExamEcgDO experimentExamEcg = experimentExamEcgService.getExperimentExamEcg(id);
        return success(BeanUtils.toBean(experimentExamEcg, ExperimentExamEcgRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-心电图分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:query')")
    public CommonResult<PageResult<ExperimentExamEcgRespVO>> getExperimentExamEcgPage(@Valid ExperimentExamEcgPageReqVO pageReqVO) {
        PageResult<ExperimentExamEcgDO> pageResult = experimentExamEcgService.getExperimentExamEcgPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamEcgRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-心电图 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-ecg:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamEcgExcel(@Valid ExperimentExamEcgPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamEcgDO> list = experimentExamEcgService.getExperimentExamEcgPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-心电图.xls", "数据", ExperimentExamEcgRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamEcgRespVO.class));
    }

}