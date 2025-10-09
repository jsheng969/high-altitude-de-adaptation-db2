package cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamotherdata.ControlExamOtherDataDO;
import cn.iocoder.yudao.module.prospective.service.controlexamotherdata.ControlExamOtherDataService;

@Tag(name = "管理后台 - 实验组体检-其他数据")
@RestController
@RequestMapping("/prospective/control-exam-other-data")
@Validated
public class ControlExamOtherDataController {

    @Resource
    private ControlExamOtherDataService controlExamOtherDataService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-其他数据")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:create')")
    public CommonResult<Long> createControlExamOtherData(@Valid @RequestBody ControlExamOtherDataSaveReqVO createReqVO) {
        return success(controlExamOtherDataService.createControlExamOtherData(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-其他数据")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:update')")
    public CommonResult<Boolean> updateControlExamOtherData(@Valid @RequestBody ControlExamOtherDataSaveReqVO updateReqVO) {
        controlExamOtherDataService.updateControlExamOtherData(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-其他数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:delete')")
    public CommonResult<Boolean> deleteControlExamOtherData(@RequestParam("id") Long id) {
        controlExamOtherDataService.deleteControlExamOtherData(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-其他数据")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:query')")
    public CommonResult<ControlExamOtherDataRespVO> getControlExamOtherData(@RequestParam("id") Long id) {
        ControlExamOtherDataDO controlExamOtherData = controlExamOtherDataService.getControlExamOtherData(id);
        return success(BeanUtils.toBean(controlExamOtherData, ControlExamOtherDataRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-其他数据分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:query')")
    public CommonResult<PageResult<ControlExamOtherDataRespVO>> getControlExamOtherDataPage(@Valid ControlExamOtherDataPageReqVO pageReqVO) {
        PageResult<ControlExamOtherDataDO> pageResult = controlExamOtherDataService.getControlExamOtherDataPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamOtherDataRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-其他数据 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-other-data:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamOtherDataExcel(@Valid ControlExamOtherDataPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamOtherDataDO> list = controlExamOtherDataService.getControlExamOtherDataPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-其他数据.xls", "数据", ControlExamOtherDataRespVO.class,
                        BeanUtils.toBean(list, ControlExamOtherDataRespVO.class));
    }

}