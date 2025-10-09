package cn.iocoder.yudao.module.prospective.controller.admin.samplehistory;

import cn.iocoder.yudao.module.prospective.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.module.prospective.service.sample.SampleService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
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
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory.SampleHistoryDO;
import cn.iocoder.yudao.module.prospective.service.samplehistory.SampleHistoryService;

@Tag(name = "管理后台 - 生物样本库历史记录")
@RestController
@RequestMapping("/samplehistory/sample-history")
@Validated
public class SampleHistoryController {

    @Resource
    private SampleHistoryService sampleHistoryService;

    @Resource
    private SampleService sampleService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "创建生物样本库历史记录")
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:create')")
    public CommonResult<Long> createSampleHistory(@Valid @RequestBody SampleHistorySaveReqVO createReqVO) {
        return success(sampleHistoryService.createSampleHistory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新生物样本库历史记录")
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:update')")
    public CommonResult<Boolean> updateSampleHistory(@Valid @RequestBody SampleHistorySaveReqVO updateReqVO) {
        sampleHistoryService.updateSampleHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除生物样本库历史记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:delete')")
    public CommonResult<Boolean> deleteSampleHistory(@RequestParam("id") Long id) {
        sampleHistoryService.deleteSampleHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得生物样本库历史记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:query')")
    public CommonResult<SampleHistoryRespVO> getSampleHistory(@RequestParam("id") Integer id) {
        SampleHistoryDO sampleHistory = sampleHistoryService.getSampleHistory(id);
        return success(BeanUtils.toBean(sampleHistory, SampleHistoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得生物样本库历史记录分页")
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:query')")
    public CommonResult<PageResult<SampleHistoryRespVO>> getSampleHistoryPage(@Valid SampleHistoryPageReqVO pageReqVO) {
        PageResult<SampleHistoryDO> pageResult = sampleHistoryService.getSampleHistoryPage(pageReqVO);
        PageResult<SampleHistoryRespVO> historyRespVOPageResult = BeanUtils.toBean(pageResult, SampleHistoryRespVO.class);
        historyRespVOPageResult.setList(historyRespVOPageResult.getList().stream().map(item -> {
            SampleDO sample = sampleService.getSample(item.getBioSampleId());
            if (sample != null) {
                item.setTubeNo(sample.getTubeNo());
                item.setBoxNo(sample.getBoxNo());
                item.setFreezerNo(sample.getFreezerNo());
                AdminUserRespDTO user = adminUserApi.getUser(Long.parseLong(item.getCreator()));
                if (user != null){
                    item.setCreateBy(user.getNickname());
                }
            }
            return item;
        }).collect(Collectors.toList()));
        return success(historyRespVOPageResult);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出生物样本库历史记录 Excel")
    @PreAuthorize("@ss.hasPermission('samplehistory:sample-history:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSampleHistoryExcel(@Valid SampleHistoryPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SampleHistoryDO> list = sampleHistoryService.getSampleHistoryPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "生物样本库历史记录.xls", "数据", SampleHistoryRespVO.class,
                        BeanUtils.toBean(list, SampleHistoryRespVO.class));
    }

}