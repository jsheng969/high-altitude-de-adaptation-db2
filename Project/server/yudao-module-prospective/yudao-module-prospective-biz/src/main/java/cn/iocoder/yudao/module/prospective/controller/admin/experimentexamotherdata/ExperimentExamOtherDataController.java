package cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata;

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

import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamotherdata.ExperimentExamOtherDataDO;
import cn.iocoder.yudao.module.prospective.service.experimentexamotherdata.ExperimentExamOtherDataService;

@Tag(name = "管理后台 - 实验组体检-其他数据")
@RestController
@RequestMapping("/prospective/experiment-exam-other-data")
@Validated
public class ExperimentExamOtherDataController {

    @Resource
    private ExperimentExamOtherDataService experimentExamOtherDataService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-其他数据")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:create')")
    public CommonResult<Long> createExperimentExamOtherData(@Valid @RequestBody ExperimentExamOtherDataSaveReqVO createReqVO) {
        return success(experimentExamOtherDataService.createExperimentExamOtherData(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-其他数据")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:update')")
    public CommonResult<Boolean> updateExperimentExamOtherData(@Valid @RequestBody ExperimentExamOtherDataSaveReqVO updateReqVO) {
        experimentExamOtherDataService.updateExperimentExamOtherData(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-其他数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:delete')")
    public CommonResult<Boolean> deleteExperimentExamOtherData(@RequestParam("id") Long id) {
        experimentExamOtherDataService.deleteExperimentExamOtherData(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-其他数据")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:query')")
    public CommonResult<ExperimentExamOtherDataRespVO> getExperimentExamOtherData(@RequestParam("id") Long id) {
        ExperimentExamOtherDataDO experimentExamOtherData = experimentExamOtherDataService.getExperimentExamOtherData(id);
        return success(BeanUtils.toBean(experimentExamOtherData, ExperimentExamOtherDataRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-其他数据分页")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:query')")
    public CommonResult<PageResult<ExperimentExamOtherDataRespVO>> getExperimentExamOtherDataPage(@Valid ExperimentExamOtherDataPageReqVO pageReqVO) {
        PageResult<ExperimentExamOtherDataDO> pageResult = experimentExamOtherDataService.getExperimentExamOtherDataPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentExamOtherDataRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-其他数据 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:experiment-exam-other-data:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentExamOtherDataExcel(@Valid ExperimentExamOtherDataPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentExamOtherDataDO> list = experimentExamOtherDataService.getExperimentExamOtherDataPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-其他数据.xls", "数据", ExperimentExamOtherDataRespVO.class,
                        BeanUtils.toBean(list, ExperimentExamOtherDataRespVO.class));
    }

}