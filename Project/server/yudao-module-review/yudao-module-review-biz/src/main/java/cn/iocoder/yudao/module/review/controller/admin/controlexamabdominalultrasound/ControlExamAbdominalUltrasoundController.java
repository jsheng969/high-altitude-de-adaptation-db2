package cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound;

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

import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundDO;
import cn.iocoder.yudao.module.review.service.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundService;

@Tag(name = "管理后台 - 对照组体检-腹部超声")
@RestController
@RequestMapping("/review/control-exam-abdominal-ultrasound")
@Validated
public class ControlExamAbdominalUltrasoundController {

    @Resource
    private ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-腹部超声")
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:create')")
    public CommonResult<Long> createControlExamAbdominalUltrasound(@Valid @RequestBody ControlExamAbdominalUltrasoundSaveReqVO createReqVO) {
        return success(controlExamAbdominalUltrasoundService.createControlExamAbdominalUltrasound(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-腹部超声")
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:update')")
    public CommonResult<Boolean> updateControlExamAbdominalUltrasound(@Valid @RequestBody ControlExamAbdominalUltrasoundSaveReqVO updateReqVO) {
        controlExamAbdominalUltrasoundService.updateControlExamAbdominalUltrasound(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-腹部超声")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:delete')")
    public CommonResult<Boolean> deleteControlExamAbdominalUltrasound(@RequestParam("id") Long id) {
        controlExamAbdominalUltrasoundService.deleteControlExamAbdominalUltrasound(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-腹部超声")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:query')")
    public CommonResult<ControlExamAbdominalUltrasoundRespVO> getControlExamAbdominalUltrasound(@RequestParam("id") Long id) {
        ControlExamAbdominalUltrasoundDO controlExamAbdominalUltrasound = controlExamAbdominalUltrasoundService.getControlExamAbdominalUltrasound(id);
        return success(BeanUtils.toBean(controlExamAbdominalUltrasound, ControlExamAbdominalUltrasoundRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-腹部超声分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:query')")
    public CommonResult<PageResult<ControlExamAbdominalUltrasoundRespVO>> getControlExamAbdominalUltrasoundPage(@Valid ControlExamAbdominalUltrasoundPageReqVO pageReqVO) {
        PageResult<ControlExamAbdominalUltrasoundDO> pageResult = controlExamAbdominalUltrasoundService.getControlExamAbdominalUltrasoundPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamAbdominalUltrasoundRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-腹部超声 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-abdominal-ultrasound:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamAbdominalUltrasoundExcel(@Valid ControlExamAbdominalUltrasoundPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamAbdominalUltrasoundDO> list = controlExamAbdominalUltrasoundService.getControlExamAbdominalUltrasoundPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-腹部超声.xls", "数据", ControlExamAbdominalUltrasoundRespVO.class,
                        BeanUtils.toBean(list, ControlExamAbdominalUltrasoundRespVO.class));
    }

}