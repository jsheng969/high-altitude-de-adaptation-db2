package cn.iocoder.yudao.module.review.controller.admin.experimentframingham;

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

import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentframingham.ExperimentFraminghamDO;
import cn.iocoder.yudao.module.review.service.experimentframingham.ExperimentFraminghamService;

@Tag(name = "管理后台 - 实验组-framingham评分")
@RestController
@RequestMapping("/review/experiment-framingham")
@Validated
public class ExperimentFraminghamController {

    @Resource
    private ExperimentFraminghamService experimentFraminghamService;

    @PostMapping("/create")
    @Operation(summary = "创建实验组-framingham评分")
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:create')")
    public CommonResult<Long> createExperimentFramingham(@Valid @RequestBody ExperimentFraminghamSaveReqVO createReqVO) {
        return success(experimentFraminghamService.createExperimentFramingham(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新实验组-framingham评分")
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:update')")
    public CommonResult<Boolean> updateExperimentFramingham(@Valid @RequestBody ExperimentFraminghamSaveReqVO updateReqVO) {
        experimentFraminghamService.updateExperimentFramingham(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除实验组-framingham评分")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:delete')")
    public CommonResult<Boolean> deleteExperimentFramingham(@RequestParam("id") Long id) {
        experimentFraminghamService.deleteExperimentFramingham(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得实验组-framingham评分")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:query')")
    public CommonResult<ExperimentFraminghamRespVO> getExperimentFramingham(@RequestParam("id") Long id) {
        ExperimentFraminghamDO experimentFramingham = experimentFraminghamService.getExperimentFramingham(id);
        return success(BeanUtils.toBean(experimentFramingham, ExperimentFraminghamRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得实验组-framingham评分分页")
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:query')")
    public CommonResult<PageResult<ExperimentFraminghamRespVO>> getExperimentFraminghamPage(@Valid ExperimentFraminghamPageReqVO pageReqVO) {
        PageResult<ExperimentFraminghamDO> pageResult = experimentFraminghamService.getExperimentFraminghamPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ExperimentFraminghamRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出实验组-framingham评分 Excel")
    @PreAuthorize("@ss.hasPermission('review:experiment-framingham:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExperimentFraminghamExcel(@Valid ExperimentFraminghamPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ExperimentFraminghamDO> list = experimentFraminghamService.getExperimentFraminghamPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "实验组-framingham评分.xls", "数据", ExperimentFraminghamRespVO.class,
                        BeanUtils.toBean(list, ExperimentFraminghamRespVO.class));
    }

}