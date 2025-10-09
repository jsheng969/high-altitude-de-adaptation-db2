package cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.module.review.service.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundService;

@Tag(name = "管理后台 - 实验组体检-腹部超声")
@RestController
@RequestMapping("/review/experiment-exam-abdominal-ultrasound")
@Validated
public class ExperimentExamAbdominalUltrasoundController {

    @Resource
    private ExperimentExamAbdominalUltrasoundService experimentExamAbdominalUltrasoundService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-腹部超声")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:create')")
    public CommonResult<Long> createExperimentExamAbdominalUltrasound(@Valid @RequestBody ExperimentExamAbdominalUltrasoundSaveReqVO createReqVO) {
        return success(experimentExamAbdominalUltrasoundService.createExperimentExamAbdominalUltrasound(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-腹部超声")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:update')")
    public CommonResult<Boolean> updateExperimentExamAbdominalUltrasound(@Valid @RequestBody ExperimentExamAbdominalUltrasoundSaveReqVO updateReqVO) {
        experimentExamAbdominalUltrasoundService.updateExperimentExamAbdominalUltrasound(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-腹部超声")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:delete')")
    public CommonResult<Boolean> deleteExperimentExamAbdominalUltrasound(@RequestParam("id") Long id) {
        experimentExamAbdominalUltrasoundService.deleteExperimentExamAbdominalUltrasound(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-腹部超声")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:query')")
    public CommonResult<ExperimentExamAbdominalUltrasoundRespVO> getExperimentExamAbdominalUltrasound(@RequestParam("id") Long id) {
        ExperimentExamAbdominalUltrasoundDO experimentExamAbdominalUltrasound = experimentExamAbdominalUltrasoundService.getExperimentExamAbdominalUltrasound(id);
        return success(BeanUtils.toBean(experimentExamAbdominalUltrasound, ExperimentExamAbdominalUltrasoundRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-腹部超声分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:query')")
    public CommonResult<PageResult<ExperimentExamAbdominalUltrasoundRespVO>> getExperimentExamAbdominalUltrasoundPage(@Valid ExperimentExamAbdominalUltrasoundPageReqVO pageReqVO) {
        PageResult<ExperimentExamAbdominalUltrasoundDO> pageResult = experimentExamAbdominalUltrasoundService.getExperimentExamAbdominalUltrasoundPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamAbdominalUltrasoundRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-腹部超声 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-exam-abdominal-ultrasound:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamAbdominalUltrasoundExcel(@Valid ExperimentExamAbdominalUltrasoundPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamAbdominalUltrasoundDO> list = experimentExamAbdominalUltrasoundService.getExperimentExamAbdominalUltrasoundPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-腹部超声.xls", "数据", ExperimentExamAbdominalUltrasoundRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamAbdominalUltrasoundRespVO.class));
    }

}