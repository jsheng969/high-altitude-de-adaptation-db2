package cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentdiseasespectrum.ExperimentDiseaseSpectrumDO;
import cn.iocoder.yudao.module.review.service.experimentdiseasespectrum.ExperimentDiseaseSpectrumService;

@Tag(name = "管理后台 - 实验组-疾病谱")
@RestController
@RequestMapping("/review/experiment-disease-spectrum")
@Validated
public class ExperimentDiseaseSpectrumController {

    @Resource
    private ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组-疾病谱")
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:create')")
    public CommonResult<Long> createExperimentDiseaseSpectrum(@Valid @RequestBody ExperimentDiseaseSpectrumSaveReqVO createReqVO) {
        return success(experimentDiseaseSpectrumService.createExperimentDiseaseSpectrum(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组-疾病谱")
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:update')")
    public CommonResult<Boolean> updateExperimentDiseaseSpectrum(@Valid @RequestBody ExperimentDiseaseSpectrumSaveReqVO updateReqVO) {
        experimentDiseaseSpectrumService.updateExperimentDiseaseSpectrum(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组-疾病谱")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:delete')")
    public CommonResult<Boolean> deleteExperimentDiseaseSpectrum(@RequestParam("id") Long id) {
        experimentDiseaseSpectrumService.deleteExperimentDiseaseSpectrum(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组-疾病谱")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:query')")
    public CommonResult<ExperimentDiseaseSpectrumRespVO> getExperimentDiseaseSpectrum(@RequestParam("id") Long id) {
        ExperimentDiseaseSpectrumDO experimentDiseaseSpectrum = experimentDiseaseSpectrumService.getExperimentDiseaseSpectrum(id);
        return success(BeanUtils.toBean(experimentDiseaseSpectrum, ExperimentDiseaseSpectrumRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组-疾病谱分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:query')")
    public CommonResult<PageResult<ExperimentDiseaseSpectrumRespVO>> getExperimentDiseaseSpectrumPage(@Valid ExperimentDiseaseSpectrumPageReqVO pageReqVO) {
        PageResult<ExperimentDiseaseSpectrumDO> pageResult = experimentDiseaseSpectrumService.getExperimentDiseaseSpectrumPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentDiseaseSpectrumRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组-疾病谱 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-disease-spectrum:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentDiseaseSpectrumExcel(@Valid ExperimentDiseaseSpectrumPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentDiseaseSpectrumDO> list = experimentDiseaseSpectrumService.getExperimentDiseaseSpectrumPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组-疾病谱.xls", "数据", ExperimentDiseaseSpectrumRespVO.class,
                        BeanUtils.toBean(list, ExperimentDiseaseSpectrumRespVO.class));
    }

}