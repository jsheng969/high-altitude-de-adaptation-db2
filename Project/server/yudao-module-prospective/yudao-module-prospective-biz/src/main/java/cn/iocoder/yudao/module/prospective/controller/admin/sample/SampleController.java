package cn.iocoder.yudao.module.prospective.controller.admin.sample;

import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;
import cn.iocoder.yudao.framework.mybatis.core.factory.EncryptorFactory;
import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.ProspectiveBasicInfoController;
import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo.BasicInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.BasicOtherInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.ExperimentSurveyScoreSummarySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.SampleHistoryRespVO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory.SampleHistoryDO;
import cn.iocoder.yudao.module.prospective.service.basicinfo.ProspectiveBasicInfoService;
import cn.iocoder.yudao.module.prospective.service.basicotherinfo.ProspectiveBasicOtherInfoService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoService;
import cn.iocoder.yudao.module.prospective.service.samplehistory.SampleHistoryService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import org.springframework.beans.factory.annotation.Autowired;
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

import cn.iocoder.yudao.module.prospective.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.module.prospective.service.sample.SampleService;

@Tag(name = "管理后台 - 生物样本")
@RestController
@RequestMapping("/prospective/sample")
@Validated
public class SampleController {

    @Resource
    private SampleService sampleService;

    @Resource
    private SampleHistoryService sampleHistoryService;

    @Resource
    private AdminUserApi adminUserApi;


    @PostMapping("/create")
    @Operation(summary = "创建生物样本")
    @PreAuthorize("@ss.hasPermission('prospective:sample:create')")
    public CommonResult<Long> createSample(@Valid @RequestBody SampleSaveReqVO createReqVO) {
        return success(sampleService.createSample(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新生物样本")
    @PreAuthorize("@ss.hasPermission('prospective:sample:update')")
    public CommonResult<Boolean> updateSample(@Valid @RequestBody SampleSaveReqVO updateReqVO) {
        sampleService.updateSample(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除生物样本")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:sample:delete')")
    public CommonResult<Boolean> deleteSample(@RequestParam("id") Long id) {
        sampleService.deleteSample(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得生物样本")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:sample:query')")
    public CommonResult<SampleRespVO> getSample(@RequestParam("id") Long id) {
        SampleDO sample = sampleService.getSample(id);
        return success(BeanUtils.toBean(sample, SampleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得生物样本分页")
    @PreAuthorize("@ss.hasPermission('prospective:sample:query')")
    public CommonResult<PageResult<SampleRespVO>> getSamplePage(@Valid SamplePageReqVO pageReqVO) {
        PageResult<SampleDO> pageResult = sampleService.getSamplePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SampleRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出生物样本 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:sample:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSampleExcel(@Valid SamplePageReqVO pageReqVO,
                                  HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SampleDO> list = sampleService.getSamplePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "生物样本.xls", "数据", SampleRespVO.class,
                BeanUtils.toBean(list, SampleRespVO.class));
    }

    @GetMapping("/import")
    public String importBioSamples() {
        String fileName = "E:\\项目\\西部战区医院\\前瞻性\\样本库\\人员对应管表.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new SampleController.IndexListener(sampleService))
                .sheet()
                .doRead();

        return "样本库数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private SampleService sampleService;

        // 构造函数注入服务
        public IndexListener(SampleService sampleService) {
            this.sampleService = sampleService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            SampleSaveReqVO bioSample = new SampleSaveReqVO();
            bioSample.setFreezerNo(rowData.get(2));// 冰箱编号
            bioSample.setLayer(rowData.get(3));// 层号
            bioSample.setColumnNum(rowData.get(4));// 列号
            bioSample.setDrawerNo(rowData.get(5));// 抽屉号
            bioSample.setBoxSeq(rowData.get(6));// 盒序号
            bioSample.setBoxNo(rowData.get(7));// 盒号
            bioSample.setTubeSeq(Integer.valueOf(rowData.get(8)));// 管序号
            bioSample.setPositionCode(rowData.get(9));// 位置编码

            bioSample.setStatus(0); // 1=在库

            if (rowData.get(10) != null && !"".equals(rowData.get(10))) {
                bioSample.setOperatorId(rowData.get(0));//人员id
                if (rowData.get(0) != null && !rowData.get(0).contains("DZQ") && rowData.get(1) != null && !"".equals(rowData.get(1))) {
                    bioSample.setTimePoint(Integer.valueOf(rowData.get(1)));
                }
                bioSample.setTubeNo(rowData.get(10));//管号
                bioSample.setSampleType(rowData.get(13));// 样本类型
                bioSample.setStatus(1); // 1=在库
            }
            sampleService.createSample(bioSample);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据存储完成。");
        }
    }

    @GetMapping("/getBoxesWithSampleTypes")
    public CommonResult<List<BoxDisplayVO>> getBoxesWithSampleTypes(SampleRespVO sampleRespVO) {
        List<BoxDisplayVO> boxDisplayVOList = sampleService.getBoxesWithSampleTypes(sampleRespVO);
//                    .stream().map(item ->{
//                if (item.get)
//            }).collect(Collectors.toList());
        return success(boxDisplayVOList);
    }

    @GetMapping("/getDataByBoxNo")
    public CommonResult<List<SampleRespVO>> getDataByBoxNo(SampleRespVO sampleRespVO) {
        List<SampleRespVO> boxDisplayVOList = sampleService.getDataByBoxNo(sampleRespVO);
        return success(boxDisplayVOList);
    }

    @GetMapping("/getSampleTypeCount")
    public CommonResult<List<SampleTypeCountVO>> getSampleTypeCount() {
        List<SampleTypeCountVO> countList = sampleService.getSampleTypeCount();
        return success(countList);
    }


    @GetMapping("/takeOut")
    @Operation(summary = "取出")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> takeOut(@RequestParam("id") Long id) {
        sampleService.takeOut(id);
        return success(true);
    }

    @GetMapping("/putBack")
    @Operation(summary = "放回")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> putBack(SamplePageReqVO pageReqVO) {
        sampleService.putBack(pageReqVO);
        return success(true);
    }

    @GetMapping("/getUseRecords")
    @Operation(summary = "获得生物样本历史记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<List<SampleHistoryRespVO>> getUseRecords(@RequestParam("id") Long id) {
        List<SampleHistoryDO> SampleHistoryList = sampleHistoryService.getSampleHistoryBySampleId(id).stream().map(item -> {
            AdminUserRespDTO user = adminUserApi.getUser(Long.valueOf(item.getCreator()));
            if (user != null) {
                item.setCreateBy(user.getNickname());
            }
            return item;
        }).collect(Collectors.toList());
        return success(BeanUtils.toBean(SampleHistoryList, SampleHistoryRespVO.class));
    }

    @GetMapping("/takeOutByTubeNo")
    @Operation(summary = "取出")
    @Parameter(name = "tubeNo", description = "管号", required = true, example = "1024")
    public CommonResult<Boolean> takeOutByTubeNo(@RequestParam("tubeNo") String tubeNo) {
        sampleService.takeOutByTubeNo(tubeNo);
        return success(true);
    }

    @GetMapping("/encryptAllAnnotatedFields")
    public void encryptAllAnnotatedFields() throws IllegalAccessException {
        sampleService.encryptAllAnnotatedFields();
    }

}