package cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2;

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

import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2DO;
import cn.iocoder.yudao.module.prospective.service.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2Service;

@Tag(name = "管理后台 - 实验组体检-生化v2")
@RestController
@RequestMapping("/prospective/control-exam-biochemical-tests-v2")
@Validated
public class ControlExamBiochemicalTestsV2Controller {

    @Resource
    private ControlExamBiochemicalTestsV2Service controlExamBiochemicalTestsV2Service;

    @PostMapping("/create")
    @Operation(summary = "创建实验组体检-生化v2")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:create')")
    public CommonResult<Long> createControlExamBiochemicalTestsV2(@Valid @RequestBody ControlExamBiochemicalTestsV2SaveReqVO createReqVO) {
        return success(controlExamBiochemicalTestsV2Service.createControlExamBiochemicalTestsV2(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组体检-生化v2")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:update')")
    public CommonResult<Boolean> updateControlExamBiochemicalTestsV2(@Valid @RequestBody ControlExamBiochemicalTestsV2SaveReqVO updateReqVO) {
        controlExamBiochemicalTestsV2Service.updateControlExamBiochemicalTestsV2(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组体检-生化v2")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:delete')")
    public CommonResult<Boolean> deleteControlExamBiochemicalTestsV2(@RequestParam("id") Long id) {
        controlExamBiochemicalTestsV2Service.deleteControlExamBiochemicalTestsV2(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组体检-生化v2")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:query')")
    public CommonResult<ControlExamBiochemicalTestsV2RespVO> getControlExamBiochemicalTestsV2(@RequestParam("id") Long id) {
        ControlExamBiochemicalTestsV2DO controlExamBiochemicalTestsV2 = controlExamBiochemicalTestsV2Service.getControlExamBiochemicalTestsV2(id);
        return success(BeanUtils.toBean(controlExamBiochemicalTestsV2, ControlExamBiochemicalTestsV2RespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组体检-生化v2分页")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:query')")
    public CommonResult<PageResult<ControlExamBiochemicalTestsV2RespVO>> getControlExamBiochemicalTestsV2Page(@Valid ControlExamBiochemicalTestsV2PageReqVO pageReqVO) {
        PageResult<ControlExamBiochemicalTestsV2DO> pageResult = controlExamBiochemicalTestsV2Service.getControlExamBiochemicalTestsV2Page(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamBiochemicalTestsV2RespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组体检-生化v2 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:control-exam-biochemical-tests-v2:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamBiochemicalTestsV2Excel(@Valid ControlExamBiochemicalTestsV2PageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamBiochemicalTestsV2DO> list = controlExamBiochemicalTestsV2Service.getControlExamBiochemicalTestsV2Page(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组体检-生化v2.xls", "数据", ControlExamBiochemicalTestsV2RespVO.class,
                        BeanUtils.toBean(list, ControlExamBiochemicalTestsV2RespVO.class));
    }

}