package cn.iocoder.yudao.module.review.controller.admin.basicotherinfo;

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

import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo.BasicOtherInfoDO;
import cn.iocoder.yudao.module.review.service.basicotherinfo.BasicOtherInfoService;

@Tag(name = "管理后台 - 基础其他信息")
@RestController
@RequestMapping("/review/basic-other-info")
@Validated
public class BasicOtherInfoController {

    @Resource
    private BasicOtherInfoService basicOtherInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建基础其他信息")
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:create')")
    public CommonResult<Long> createBasicOtherInfo(@Valid @RequestBody BasicOtherInfoSaveReqVO createReqVO) {
        return success(basicOtherInfoService.createBasicOtherInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础其他信息")
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:update')")
    public CommonResult<Boolean> updateBasicOtherInfo(@Valid @RequestBody BasicOtherInfoSaveReqVO updateReqVO) {
        basicOtherInfoService.updateBasicOtherInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础其他信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:delete')")
    public CommonResult<Boolean> deleteBasicOtherInfo(@RequestParam("id") Long id) {
        basicOtherInfoService.deleteBasicOtherInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础其他信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:query')")
    public CommonResult<BasicOtherInfoRespVO> getBasicOtherInfo(@RequestParam("id") Long id) {
        BasicOtherInfoDO basicOtherInfo = basicOtherInfoService.getBasicOtherInfo(id);
        return success(BeanUtils.toBean(basicOtherInfo, BasicOtherInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础其他信息分页")
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:query')")
    public CommonResult<PageResult<BasicOtherInfoRespVO>> getBasicOtherInfoPage(@Valid BasicOtherInfoPageReqVO pageReqVO) {
        PageResult<BasicOtherInfoDO> pageResult = basicOtherInfoService.getBasicOtherInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicOtherInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础其他信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:basic-other-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBasicOtherInfoExcel(@Valid BasicOtherInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BasicOtherInfoDO> list = basicOtherInfoService.getBasicOtherInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础其他信息.xls", "数据", BasicOtherInfoRespVO.class,
                        BeanUtils.toBean(list, BasicOtherInfoRespVO.class));
    }

}