package cn.iocoder.yudao.module.review.controller.admin.controlexamecg;

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

import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamecg.ControlExamEcgDO;
import cn.iocoder.yudao.module.review.service.controlexamecg.ControlExamEcgService;

@Tag(name = "管理后台 - 对照组体检-心电图")
@RestController
@RequestMapping("/review/control-exam-ecg")
@Validated
public class ControlExamEcgController {

    @Resource
    private ControlExamEcgService controlExamEcgService;

    @PostMapping("/create")
    @Operation(summary = "创建对照组体检-心电图")
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:create')")
    public CommonResult<Long> createControlExamEcg(@Valid @RequestBody ControlExamEcgSaveReqVO createReqVO) {
        return success(controlExamEcgService.createControlExamEcg(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新对照组体检-心电图")
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:update')")
    public CommonResult<Boolean> updateControlExamEcg(@Valid @RequestBody ControlExamEcgSaveReqVO updateReqVO) {
        controlExamEcgService.updateControlExamEcg(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除对照组体检-心电图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:delete')")
    public CommonResult<Boolean> deleteControlExamEcg(@RequestParam("id") Long id) {
        controlExamEcgService.deleteControlExamEcg(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对照组体检-心电图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:query')")
    public CommonResult<ControlExamEcgRespVO> getControlExamEcg(@RequestParam("id") Long id) {
        ControlExamEcgDO controlExamEcg = controlExamEcgService.getControlExamEcg(id);
        return success(BeanUtils.toBean(controlExamEcg, ControlExamEcgRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得对照组体检-心电图分页")
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:query')")
    public CommonResult<PageResult<ControlExamEcgRespVO>> getControlExamEcgPage(@Valid ControlExamEcgPageReqVO pageReqVO) {
        PageResult<ControlExamEcgDO> pageResult = controlExamEcgService.getControlExamEcgPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ControlExamEcgRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出对照组体检-心电图 Excel")
    @PreAuthorize("@ss.hasPermission('review:control-exam-ecg:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportControlExamEcgExcel(@Valid ControlExamEcgPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ControlExamEcgDO> list = controlExamEcgService.getControlExamEcgPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "对照组体检-心电图.xls", "数据", ControlExamEcgRespVO.class,
                        BeanUtils.toBean(list, ControlExamEcgRespVO.class));
    }

}