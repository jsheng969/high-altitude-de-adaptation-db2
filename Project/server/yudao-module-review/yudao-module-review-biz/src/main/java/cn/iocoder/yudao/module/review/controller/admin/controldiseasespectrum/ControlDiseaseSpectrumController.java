package cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum;

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

import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controldiseasespectrum.ControlDiseaseSpectrumDO;
import cn.iocoder.yudao.module.review.service.controldiseasespectrum.ControlDiseaseSpectrumService;

@Tag(name = "管理后台 - 实验组-疾病谱")
@RestController
@RequestMapping("/review/control-disease-spectrum")
@Validated
public class ControlDiseaseSpectrumController {

    @Resource
    private ControlDiseaseSpectrumService controlDiseaseSpectrumService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组-疾病谱")
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:create')")
    public CommonResult<Long> createControlDiseaseSpectrum(@Valid @RequestBody ControlDiseaseSpectrumSaveReqVO createReqVO) {
        return success(controlDiseaseSpectrumService.createControlDiseaseSpectrum(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组-疾病谱")
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:update')")
    public CommonResult<Boolean> updateControlDiseaseSpectrum(@Valid @RequestBody ControlDiseaseSpectrumSaveReqVO updateReqVO) {
        controlDiseaseSpectrumService.updateControlDiseaseSpectrum(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组-疾病谱")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:delete')")
    public CommonResult<Boolean> deleteControlDiseaseSpectrum(@RequestParam("id") Long id) {
        controlDiseaseSpectrumService.deleteControlDiseaseSpectrum(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组-疾病谱")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:query')")
    public CommonResult<ControlDiseaseSpectrumRespVO> getControlDiseaseSpectrum(@RequestParam("id") Long id) {
        ControlDiseaseSpectrumDO controlDiseaseSpectrum = controlDiseaseSpectrumService.getControlDiseaseSpectrum(id);
        return success(BeanUtils.toBean(controlDiseaseSpectrum, ControlDiseaseSpectrumRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组-疾病谱分页")
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:query')")
    public CommonResult<PageResult<ControlDiseaseSpectrumRespVO>> getControlDiseaseSpectrumPage(@Valid ControlDiseaseSpectrumPageReqVO pageReqVO) {
        PageResult<ControlDiseaseSpectrumDO> pageResult = controlDiseaseSpectrumService.getControlDiseaseSpectrumPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlDiseaseSpectrumRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组-疾病谱 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-disease-spectrum:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlDiseaseSpectrumExcel(@Valid ControlDiseaseSpectrumPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlDiseaseSpectrumDO> list = controlDiseaseSpectrumService.getControlDiseaseSpectrumPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组-疾病谱.xls", "数据", ControlDiseaseSpectrumRespVO.class,
                        BeanUtils.toBean(list, ControlDiseaseSpectrumRespVO.class));
    }

}