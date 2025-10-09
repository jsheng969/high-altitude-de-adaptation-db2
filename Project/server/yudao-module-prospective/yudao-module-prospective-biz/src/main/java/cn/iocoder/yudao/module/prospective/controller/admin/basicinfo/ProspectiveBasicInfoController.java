package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo;

import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.BasicOtherInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.BasicOtherInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.ControlExamBiochemicalTestsV2SaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo.ControlExamBloodRoutineSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.ControlExamCoagulationTestsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.ControlExamOtherDataSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.ControlSurveyBasicCheckInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.ControlSurveyMissionProgressSurveySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.ControlSurveyPostReturnSymptomsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.ControlSurveyScoreSummarySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo.vo.ControlSurveyStationTrainingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.ExperimentExamBiochemicalTestsV2RespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.ExperimentExamBiochemicalTestsV2SaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.ExperimentExamCoagulationTestsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.ExperimentExamCoagulationTestsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.ExperimentExamOtherDataRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.ExperimentExamOtherDataSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.ExperimentSurveyAcuteMountainSicknessRecordsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.ExperimentSurveyBasicCheckInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.ExperimentSurveyBasicCheckInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.ExperimentSurveyMedicalHistorySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.ExperimentSurveyMissionProgressSurveyRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.ExperimentSurveyMissionProgressSurveySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.ExperimentSurveyPlateauArrivalSymptomsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.ExperimentSurveyPlateauArrivalSymptomsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.ExperimentSurveyPlateauFitnessInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.ExperimentSurveyPlateauFitnessInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.ExperimentSurveyScoreSummaryRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.ExperimentSurveyScoreSummarySaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.ExperimentSurveySmokingInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.ExperimentSurveySmokingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoSaveReqVO;
import cn.iocoder.yudao.module.prospective.controller.admin.history.vo.HistorySaveReqVO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyDO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryDO;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoDO;
import cn.iocoder.yudao.module.prospective.service.controlexambiochemicaltestsv2.ControlExamBiochemicalTestsV2Service;
import cn.iocoder.yudao.module.prospective.service.controlexambloodroutine.ProspectiveControlExamBloodRoutineService;
import cn.iocoder.yudao.module.prospective.service.controlexamcoagulationtests.ControlExamCoagulationTestsService;
import cn.iocoder.yudao.module.prospective.service.controlexamotherdata.ControlExamOtherDataService;
import cn.iocoder.yudao.module.prospective.service.controlsurveybasiccheckinfo.ControlSurveyBasicCheckInfoService;
import cn.iocoder.yudao.module.prospective.service.controlsurveymissionprogresssurvey.ControlSurveyMissionProgressSurveyService;
import cn.iocoder.yudao.module.prospective.service.controlsurveypostreturnsymptoms.ControlSurveyPostReturnSymptomsService;
import cn.iocoder.yudao.module.prospective.service.controlsurveyscoresummary.ControlSurveyScoreSummaryService;
import cn.iocoder.yudao.module.prospective.service.controlsurveystationtraininginfo.ControlSurveyStationTrainingInfoService;
import cn.iocoder.yudao.module.prospective.service.experimentexambiochemicaltestsv2.ExperimentExamBiochemicalTestsV2Service;
import cn.iocoder.yudao.module.prospective.service.experimentexambloodroutine.ProspectiveExperimentExamBloodRoutineService;
import cn.iocoder.yudao.module.prospective.service.experimentexamcoagulationtests.ExperimentExamCoagulationTestsService;
import cn.iocoder.yudao.module.prospective.service.experimentexamotherdata.ExperimentExamOtherDataService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyacutemountainsicknessrecords.ExperimentSurveyAcuteMountainSicknessRecordsService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveybasiccheckinfo.ExperimentSurveyBasicCheckInfoService;
import cn.iocoder.yudao.module.prospective.service.basicotherinfo.ProspectiveBasicOtherInfoService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveymedicalhistory.ExperimentSurveyMedicalHistoryService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveymissionprogresssurvey.ExperimentSurveyMissionProgressSurveyService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyplateauarrivalsymptoms.ExperimentSurveyPlateauArrivalSymptomsService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyplateaufitnessinfo.ExperimentSurveyPlateauFitnessInfoService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveypostreturnsymptoms.ProspectiveExperimentSurveyPostReturnSymptomsService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyscoresummary.ExperimentSurveyScoreSummaryService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveysmokinginfo.ExperimentSurveySmokingInfoService;
import cn.iocoder.yudao.module.prospective.service.experimentsurveystationtraininginfo.ExperimentSurveyStationTrainingInfoService;
import cn.iocoder.yudao.module.prospective.service.history.HistoryService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicinfo.ProspectiveBasicInfoDO;
import cn.iocoder.yudao.module.prospective.service.basicinfo.ProspectiveBasicInfoService;
import cn.iocoder.yudao.framework.tenant.core.context.TenantContextHolder;
import org.springframework.web.client.RestTemplate;

@Tag(name = "管理后台 - 前瞻性基础信息")
@RestController
@RequestMapping("/prospective/basic-info")
@Validated
public class ProspectiveBasicInfoController {

    @Resource
    private ProspectiveBasicInfoService prospectiveBasicInfoService;

    @Resource
    private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;

    @Resource
    private ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService;

    @Resource
    private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;

    @Resource
    private ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService;

    @Resource
    private ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService;

    @Resource
    private ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService;

    @Resource
    private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;

    @Resource
    private ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService;

    @Resource
    private ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService;

    @Resource
    private ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService;

    @Resource
    private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;

    @Resource
    private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

    @Resource
    private ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService;

    @Resource
    private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;

    @Resource
    private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;

    @Resource
    private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;

    @Resource
    private ExperimentExamOtherDataService experimentExamOtherDataService;

    @Resource
    private ControlSurveyBasicCheckInfoService controlSurveyBasicCheckInfoService;

    @Resource
    private ControlSurveyStationTrainingInfoService controlSurveyStationTrainingInfoService;

    @Resource
    private ControlSurveyMissionProgressSurveyService controlSurveyMissionProgressSurveyService;

    @Resource
    private ControlSurveyScoreSummaryService controlSurveyScoreSummaryService;

    @Resource
    private ControlSurveyPostReturnSymptomsService controlSurveyPostReturnSymptomsService;

    @Resource
    private ControlExamBiochemicalTestsV2Service controlExamBiochemicalTestsV2Service;

    @Resource
    private ProspectiveControlExamBloodRoutineService prospectiveControlExamBloodRoutineService;

    @Resource
    private ControlExamCoagulationTestsService controlExamCoagulationTestsService;

    @Resource
    private ControlExamOtherDataService controlExamOtherDataService;

    @Resource
    private HistoryService historyService;

    @PostMapping("/create")
    @Operation(summary = "创建基础信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:create')")
    public CommonResult<Long> createBasicInfo(@Valid @RequestBody BasicInfoSaveReqVO createReqVO) {
        return success(prospectiveBasicInfoService.createBasicInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础信息")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:update')")
    public CommonResult<Boolean> updateBasicInfo(@Valid @RequestBody BasicInfoSaveReqVO updateReqVO) {
        prospectiveBasicInfoService.updateBasicInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:delete')")
    public CommonResult<Boolean> deleteBasicInfo(@RequestParam("id") Long id) {
        prospectiveBasicInfoService.deleteBasicInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:query')")
    public CommonResult<BasicInfoRespVO> getBasicInfo(@RequestParam("id") Long id) {
        ProspectiveBasicInfoDO basicInfo = prospectiveBasicInfoService.getBasicInfo(id);
        return success(BeanUtils.toBean(basicInfo, BasicInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础信息分页")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:query')")
    public CommonResult<PageResult<BasicInfoRespVO>> getBasicInfoPage(@Valid BasicInfoPageReqVO pageReqVO) {
        PageResult<ProspectiveBasicInfoDO> pageResult = prospectiveBasicInfoService.getBasicInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础信息 Excel")
    @PreAuthorize("@ss.hasPermission('prospective:time-point1-survey-basic-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBasicInfoExcel(@Valid BasicInfoPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProspectiveBasicInfoDO> list = prospectiveBasicInfoService.getBasicInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础信息.xls", "数据", BasicInfoRespVO.class,
                BeanUtils.toBean(list, BasicInfoRespVO.class));
    }


    @Operation(summary = "导入VIP数据")
    @GetMapping("/importExperimentVip")
    public String importExperimentVip() {
        String fileName = "E:\\项目\\西部战区医院\\前瞻性\\VIP详细数据.xlsx";
        importExperimentSurveyVipBasicInfo(fileName);
        //流调分值
        importExperimentSurveyVipPostReturnSymptoms(fileName, 1, 2);
        importExperimentSurveyVipPostReturnSymptoms(fileName, 2, 3);
        //血常规
        importExperimentExamVipBloodRoutine(fileName, 3, 1);
        importExperimentExamVipBloodRoutine(fileName, 4, 2);
        importExperimentExamVipBloodRoutine(fileName, 5, 3);
        //生化
        importExperimentExamVipBiochemicalTests(fileName, 6, 1);
        importExperimentExamVipBiochemicalTests(fileName, 7, 2);
        importExperimentExamVipBiochemicalTests(fileName, 8, 3);
        //凝血
        importExperimentExamVipCoagulationTests(fileName, 9, 1);
        importExperimentExamVipCoagulationTests(fileName, 10, 2);
        importExperimentExamVipCoagulationTests(fileName, 11, 3);
        return "vip实验组数据导入完成";
    }

    @GetMapping("/importExperimentSurveyVipBasicInfo")
    public String importExperimentSurveyVipBasicInfo(@RequestParam String fileName) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipBasicInfo(
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentSurveyStationTrainingInfoService
                        , experimentSurveyScoreSummaryService))
                .sheet(0)
                .doRead();

        return "vip基本信息数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipBasicInfo extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;
        private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

        // 构造函数注入服务
        public IndexListenerVipBasicInfo(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService
                , ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentSurveyStationTrainingInfoService = experimentSurveyStationTrainingInfoService;
            this.experimentSurveyScoreSummaryService = experimentSurveyScoreSummaryService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyStationTrainingInfoSaveReqVO experimentSurveyStationTrainingInfo = new ExperimentSurveyStationTrainingInfoSaveReqVO();
            ExperimentSurveyScoreSummarySaveReqVO experimentSurveyScoreSummary = new ExperimentSurveyScoreSummarySaveReqVO();

            basicInfo.setCode(rowData.get(0));
            basicInfo.setName(rowData.get(1)); // 姓名
            basicInfo.setGender(rowData.get(2)); // 性别
            basicInfo.setAge(extractNumberOrZero(rowData.get(3)));
            basicInfo.setActualAge(extractNumberOrZero(rowData.get(3)));
            String original = rowData.get(0);
            String formatted = original.length() >= 6
                    ? original.substring(1, 4) + "-" + original.substring(4, 6)
                    : "";  // 或者处理错误情况
            basicInfo.setType(formatted); // 类型181-23、181-24、363-23
            basicInfo.setGroupType("1"); // 实验组、对照组
            basicInfo.setTimePoint(0); //时相点
//            basicInfo.setSurveyOrExam("survey"); //流调或检查
            basicInfo.setIsVip("vip"); //是否vip

            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            basicOtherInfo.setPersonId(generatedId);
            basicOtherInfo.setEthnicity(rowData.get(4)); // 民族
            basicOtherInfo.setTimePoint(0);
            prospectiveBasicOtherInfoService.createExperimentSurveyBasicOtherInfo(basicOtherInfo);

            experimentSurveyStationTrainingInfo.setPersonId(generatedId);
            experimentSurveyStationTrainingInfo.setMissionPointAltitude(extractNumberOrZero(rowData.get(5))); // 任务点海拔
            experimentSurveyStationTrainingInfo.setPlateauTrainingDuration(extractNumberOrZero(rowData.get(7))); // 高原训练时长
            experimentSurveyStationTrainingInfo.setTimePoint(1); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);
            experimentSurveyStationTrainingInfo.setTimePoint(2); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);
            experimentSurveyStationTrainingInfo.setTimePoint(3); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);

            experimentSurveyScoreSummary.setPersonId(generatedId);
            experimentSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(9))); // 总分
            experimentSurveyScoreSummary.setTimePoint(2); // 时相类型
            experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(experimentSurveyScoreSummary);
            experimentSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(11))); // 总分
            experimentSurveyScoreSummary.setTimePoint(3); // 时相类型
            experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(experimentSurveyScoreSummary);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentSurveyVipPostReturnSymptoms")
    public String importExperimentSurveyVipPostReturnSymptoms(@RequestParam String fileName, @RequestParam Integer sheetNo, @RequestParam Integer timePoint) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipPostReturnSymptoms(
                        prospectiveBasicInfoService
                        , prospectiveExperimentSurveyPostReturnSymptomsService
                        , timePoint))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(sheetNo)
                .doRead();

        return "流调分值-第" + timePoint + "时相点数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipPostReturnSymptoms extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService;

        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipPostReturnSymptoms(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveExperimentSurveyPostReturnSymptomsService = prospectiveExperimentSurveyPostReturnSymptomsService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentSurveyPostReturnSymptomsSaveReqVO experimentSurveyPostReturnSymptoms = new ExperimentSurveyPostReturnSymptomsSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentSurveyPostReturnSymptoms.setPersonId(generatedId);
                experimentSurveyPostReturnSymptoms.setFatigue(extractNumberOrZero(rowData.get(2))); // 疲倦（原24 → 2）
                experimentSurveyPostReturnSymptoms.setWeakness(extractNumberOrZero(rowData.get(3))); // 乏力（原25 → 3）
                experimentSurveyPostReturnSymptoms.setDrowsiness(extractNumberOrZero(rowData.get(4))); // 嗜睡（原26 → 4）
                experimentSurveyPostReturnSymptoms.setDizziness(extractNumberOrZero(rowData.get(5))); // 头昏（原27 → 5）
                experimentSurveyPostReturnSymptoms.setVertigo(extractNumberOrZero(rowData.get(6))); // 眩晕（原28 → 6）
                experimentSurveyPostReturnSymptoms.setPoorConcentration(extractNumberOrZero(rowData.get(7))); // 精力不集中（原29 → 7）
                experimentSurveyPostReturnSymptoms.setSlowReaction(extractNumberOrZero(rowData.get(8))); // 反应迟钝（原30 → 8）
                experimentSurveyPostReturnSymptoms.setMemoryLoss(extractNumberOrZero(rowData.get(9))); // 记忆减退（原31 → 9）
                experimentSurveyPostReturnSymptoms.setInsomnia(extractNumberOrZero(rowData.get(10))); // 失眠（原32 → 10）
                experimentSurveyPostReturnSymptoms.setNightmares(extractNumberOrZero(rowData.get(11))); // 多梦（原33 → 11）

                experimentSurveyPostReturnSymptoms.setChestPain(extractNumberOrZero(rowData.get(12))); // 心前区痛（原39 → 17）
                experimentSurveyPostReturnSymptoms.setPalpitations(extractNumberOrZero(rowData.get(13))); // 心慌（原40 → 18）
                experimentSurveyPostReturnSymptoms.setBradycardia(extractNumberOrZero(rowData.get(14))); // 脉率减慢（原41 → 19）
                experimentSurveyPostReturnSymptoms.setCyanosis(extractNumberOrZero(rowData.get(15))); // 紫绀（原42 → 20）
                experimentSurveyPostReturnSymptoms.setBloodPressureFluctuation(extractNumberOrZero(rowData.get(16))); // 血压波动（原43 → 21）
                experimentSurveyPostReturnSymptoms.setSkinBleeding(extractNumberOrZero(rowData.get(17))); // 皮肤出血（原44 → 22）
                experimentSurveyPostReturnSymptoms.setSkinBruising(extractNumberOrZero(rowData.get(18))); // 皮肤瘀斑（原45 → 23）
                experimentSurveyPostReturnSymptoms.setAnemia(extractNumberOrZero(rowData.get(19))); // 贫血（原46 → 24）

                experimentSurveyPostReturnSymptoms.setSoreThroat(extractNumberOrZero(rowData.get(20))); // 咽喉痛（原34 → 12）
                experimentSurveyPostReturnSymptoms.setCough(extractNumberOrZero(rowData.get(21))); // 咳嗽（原35 → 13）
                experimentSurveyPostReturnSymptoms.setPhlegm(extractNumberOrZero(rowData.get(22))); // 多痰（原36 → 14）
                experimentSurveyPostReturnSymptoms.setWheezing(extractNumberOrZero(rowData.get(23))); // 气喘（原37 → 15）
                experimentSurveyPostReturnSymptoms.setChestTightness(extractNumberOrZero(rowData.get(24))); // 胸闷（原38 → 16）

                experimentSurveyPostReturnSymptoms.setWeightLoss(extractNumberOrZero(rowData.get(25))); // 体重减轻（原47 → 25）
                experimentSurveyPostReturnSymptoms.setIncreasedAppetite(extractNumberOrZero(rowData.get(26))); // 食欲增加（原48 → 26）
                experimentSurveyPostReturnSymptoms.setAnorexia(extractNumberOrZero(rowData.get(27))); // 厌食（原49 → 27）
                experimentSurveyPostReturnSymptoms.setConstipation(extractNumberOrZero(rowData.get(28))); // 便秘（原50 → 28）
                experimentSurveyPostReturnSymptoms.setDiarrhea(extractNumberOrZero(rowData.get(29))); // 腹泻（原51 → 29）
                experimentSurveyPostReturnSymptoms.setAbdominalPain(extractNumberOrZero(rowData.get(30))); // 腹痛（原52 → 30）
                experimentSurveyPostReturnSymptoms.setAbdominalDistension(extractNumberOrZero(rowData.get(31))); // 腹胀（原53 → 31）
                experimentSurveyPostReturnSymptoms.setJaundice(extractNumberOrZero(rowData.get(32))); // 黄疸（原54 → 32）
                experimentSurveyPostReturnSymptoms.setNumbness(extractNumberOrZero(rowData.get(33))); // 手足麻木（原55 → 33）
                experimentSurveyPostReturnSymptoms.setLimbEdema(extractNumberOrZero(rowData.get(34))); // 肢体水肿（原56 → 34）
                experimentSurveyPostReturnSymptoms.setFacialEdema(extractNumberOrZero(rowData.get(35))); // 面部水肿（原57 → 35）
                experimentSurveyPostReturnSymptoms.setHairLoss(extractNumberOrZero(rowData.get(36))); // 脱发（原58 → 36）
                experimentSurveyPostReturnSymptoms.setIncreasedUrination(extractNumberOrZero(rowData.get(37))); // 夜尿增多（原59 → 37）
//            experimentSurveyPostReturnSymptoms.setOtherSymptoms(rowData.get(60)); // 返回后有无其他症状
                experimentSurveyPostReturnSymptoms.setTimePoint(timePoint); // 时相类型
                prospectiveExperimentSurveyPostReturnSymptomsService.createExperimentSurveyPostReturnSymptoms(experimentSurveyPostReturnSymptoms);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentExamVipBloodRoutine")
    public String importExperimentExamVipBloodRoutine(@RequestParam String fileName, @RequestParam Integer sheetNo, @RequestParam Integer timePoint) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipBloodRoutine(
                        prospectiveBasicInfoService
                        , prospectiveExperimentExamBloodRoutineService
                        , timePoint))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(sheetNo)
                .doRead();

        return "血常规-第" + timePoint + "时相点数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipBloodRoutine extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;

        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipBloodRoutine(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveExperimentExamBloodRoutineService = prospectiveExperimentExamBloodRoutineService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamBloodRoutineSaveReqVO prospectiveExperimentExamBloodRoutine = new ExperimentExamBloodRoutineSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                prospectiveExperimentExamBloodRoutine.setPersonId(generatedId);
                prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(2))); // 白细胞计数
                prospectiveExperimentExamBloodRoutine.setLymphocytePercent(parseBigDecimal(rowData.get(3))); // 淋巴细胞百分比
                prospectiveExperimentExamBloodRoutine.setMidCellPercent(parseBigDecimal(rowData.get(4))); // 中间细胞百分比
                prospectiveExperimentExamBloodRoutine.setGranulocytePercent(parseBigDecimal(rowData.get(5))); // 粒细胞百分比
                prospectiveExperimentExamBloodRoutine.setLymphocyteCount(parseBigDecimal(rowData.get(6))); // 淋巴细胞计数
                prospectiveExperimentExamBloodRoutine.setMidCellCount(parseBigDecimal(rowData.get(7))); // 中间细胞计数
                prospectiveExperimentExamBloodRoutine.setGranulocyteCount(parseBigDecimal(rowData.get(8))); // 粒细胞计数
                prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(9))); // 红细胞计数
                prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(10))); // 血红蛋白

                prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(11))); // 血细胞比容
                prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(12))); // 平均红细胞体积
                prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(13))); // 平均红细胞血红蛋白含量
                prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(14))); // 平均红细胞血红蛋白浓度
                prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(15))); // 红细胞分布宽度变异系数
                prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(16))); // 红细胞分布宽度标准差
                prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(17))); // 血小板计数
                prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(18))); // 平均血小板体积
                prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(19))); // 血小板分布宽度
                prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(20))); // 血小板压积
                prospectiveExperimentExamBloodRoutine.setLargePlateletRatio(parseBigDecimal(rowData.get(21))); // 大血小板比率
                prospectiveExperimentExamBloodRoutine.setLargePlateletCount(parseBigDecimal(rowData.get(22))); // 大血小板计数

                prospectiveExperimentExamBloodRoutine.setBasophilCount(parseBigDecimal(rowData.get(23))); // 嗜碱性粒细胞计数
                prospectiveExperimentExamBloodRoutine.setBasophilPercent(parseBigDecimal(rowData.get(24))); // 嗜碱性粒细胞百分比
                prospectiveExperimentExamBloodRoutine.setEosinophilCount(parseBigDecimal(rowData.get(25))); // 嗜酸性粒细胞计数
                prospectiveExperimentExamBloodRoutine.setEosinophilPercent(parseBigDecimal(rowData.get(26))); // 嗜酸性粒细胞百分比
                prospectiveExperimentExamBloodRoutine.setImmatureGranulocyteCount(parseBigDecimal(rowData.get(27))); // 幼稚粒细胞计数
                prospectiveExperimentExamBloodRoutine.setImmatureGranulocytePercent(parseBigDecimal(rowData.get(28))); // 幼稚粒细胞百分比
                prospectiveExperimentExamBloodRoutine.setMonocyteCount(parseBigDecimal(rowData.get(29))); // 单核细胞计数
                prospectiveExperimentExamBloodRoutine.setMonocytePercent(parseBigDecimal(rowData.get(30))); // 单核细胞百分比
                prospectiveExperimentExamBloodRoutine.setNucleatedRbcCount(parseBigDecimal(rowData.get(31))); // 有核红细胞计数
                prospectiveExperimentExamBloodRoutine.setNucleatedRbcPercent(parseBigDecimal(rowData.get(32))); // 有核红细胞百分比
                prospectiveExperimentExamBloodRoutine.setNeutrophilCount(parseBigDecimal(rowData.get(33))); // 中性粒细胞计数
                prospectiveExperimentExamBloodRoutine.setNeutrophilPercent(parseBigDecimal(rowData.get(34))); // 中性粒细胞百分比

                prospectiveExperimentExamBloodRoutine.setTimePoint(timePoint); // 时相
                prospectiveExperimentExamBloodRoutineService.createExperimentExamBloodRoutine(prospectiveExperimentExamBloodRoutine);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/updateExperimentExamVipBloodRoutine")
    public String updateExperimentExamVipBloodRoutine() {

        String fileName = "E:\\项目\\西部战区医院\\前瞻性\\检验检查数据721.xlsm";
        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipUpdateBloodRoutine(
                        prospectiveBasicInfoService
                        , prospectiveExperimentExamBloodRoutineService
                        , 1))
                .headRowNumber(3) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(2)
                .doRead();

        return "血常规" + "数据更新完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipUpdateBloodRoutine extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;

        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipUpdateBloodRoutine(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveExperimentExamBloodRoutineService = prospectiveExperimentExamBloodRoutineService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamBloodRoutineSaveReqVO prospectiveExperimentExamBloodRoutine = new ExperimentExamBloodRoutineSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                ProspectiveBasicInfoDO prospectiveBasicInfoDO = prospectiveBasicInfoDOList.get(0);
                generatedId = prospectiveBasicInfoDO.getId();
                prospectiveExperimentExamBloodRoutine.setPersonId(generatedId);
                prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(2))); // 白细胞计数
                prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(4))); // 红细胞计数
                prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(6))); // 血红蛋白

                prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(8))); // 血细胞比容
                prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(10))); // 平均红细胞体积
                prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(12))); // 平均红细胞血红蛋白含量
                prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(14))); // 平均红细胞血红蛋白浓度
                prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(16))); // 红细胞分布宽度变异系数
                prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(18))); // 红细胞分布宽度标准差
                prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(20))); // 血小板计数
                prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(22))); // 平均血小板体积
                prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(24))); // 血小板分布宽度
                prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(26))); // 血小板压积

                prospectiveExperimentExamBloodRoutine.setTimePoint(1); // 时相
                prospectiveExperimentExamBloodRoutineService.updateExperimentExamBloodRoutineByPersonId(prospectiveExperimentExamBloodRoutine);

                prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(28))); // 白细胞计数
                prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(30))); // 红细胞计数
                prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(32))); // 血红蛋白

                prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(34))); // 血细胞比容
                prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(36))); // 平均红细胞体积
                prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(38))); // 平均红细胞血红蛋白含量
                prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(40))); // 平均红细胞血红蛋白浓度
                prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(42))); // 红细胞分布宽度变异系数
                prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(44))); // 红细胞分布宽度标准差
                prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(46))); // 血小板计数
                prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(48))); // 平均血小板体积
                prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(50))); // 血小板分布宽度
                prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(52))); // 血小板压积

                prospectiveExperimentExamBloodRoutine.setTimePoint(2); // 时相
                prospectiveExperimentExamBloodRoutineService.updateExperimentExamBloodRoutineByPersonId(prospectiveExperimentExamBloodRoutine);

                prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(54))); // 白细胞计数
                prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(56))); // 红细胞计数
                prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(58))); // 血红蛋白

                prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(60))); // 血细胞比容
                prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(62))); // 平均红细胞体积
                prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(64))); // 平均红细胞血红蛋白含量
                prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(66))); // 平均红细胞血红蛋白浓度
                prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(68))); // 红细胞分布宽度变异系数
                prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(70))); // 红细胞分布宽度标准差
                prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(72))); // 血小板计数
                prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(74))); // 平均血小板体积
                prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(76))); // 血小板分布宽度
                prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(78))); // 血小板压积

                prospectiveExperimentExamBloodRoutine.setTimePoint(3); // 时相
                prospectiveExperimentExamBloodRoutineService.updateExperimentExamBloodRoutineByPersonId(prospectiveExperimentExamBloodRoutine);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentExamVipBiochemicalTests")
    public String importExperimentExamVipBiochemicalTests(@RequestParam String fileName, @RequestParam Integer sheetNo, @RequestParam Integer timePoint) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipBiochemicalTests(
                        prospectiveBasicInfoService
                        , experimentExamBiochemicalTestsV2Service
                        , timePoint))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(sheetNo)
                .doRead();

        return "生化-第" + timePoint + "时相点数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipBiochemicalTests extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;
        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipBiochemicalTests(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.experimentExamBiochemicalTestsV2Service = experimentExamBiochemicalTestsV2Service;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamBiochemicalTestsV2SaveReqVO experimentExamBiochemicalTestsV2 = new ExperimentExamBiochemicalTestsV2SaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentExamBiochemicalTestsV2.setPersonId(generatedId);
                experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(2))); // ALT (67→2)
                experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(3))); // AST (68→3)
                experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(4))); // 谷草转氨酶与谷丙转氨酶比值 (69→4)
                experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(5))); // 总蛋白 (70→5)
                experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(6))); // 白蛋白 (71→6)
                experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(7))); // 球蛋白 (72→7)

                experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(9))); // 白球比 (74→9)
                experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(10))); // 总胆红素 (75→10)
                experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(12))); // 直接胆红素 (77→12)
                experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(13))); // 间接胆红素 (78→13)
                experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(15))); // 碱性磷酸酶 (80→15)
                experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(16))); // 谷氨酰转肽酶 (81→16)
                experimentExamBiochemicalTestsV2.setTotalBileAcid(parseBigDecimal(rowData.get(17))); // 总胆汁酸 (82→17)
                experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(18))); // 胆碱酯酶 (83→18)
                experimentExamBiochemicalTestsV2.setPrealbumin(parseBigDecimal(rowData.get(19))); // 前白蛋白 (84→19)
                experimentExamBiochemicalTestsV2.setUrea(parseBigDecimal(rowData.get(20))); // 尿素 (85→20)
                experimentExamBiochemicalTestsV2.setCreatinine(parseBigDecimal(rowData.get(22))); // 肌酐 (87→22)
                experimentExamBiochemicalTestsV2.setUricAcid(parseBigDecimal(rowData.get(24))); // 尿酸 (89→24)
                experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(25))); // 甘油三酯 (90→25)
                experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(26))); // 胆固醇 (91→26)
                experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(27))); // 高密度脂蛋白 (92→27)
                experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(28))); // 低密度脂蛋白 (93→28)
                experimentExamBiochemicalTestsV2.setApoa(parseBigDecimal(rowData.get(29))); // 载脂蛋白A (94→29)
                experimentExamBiochemicalTestsV2.setApob(parseBigDecimal(rowData.get(30))); // 载脂蛋白B (95→30)
                experimentExamBiochemicalTestsV2.setLpa(parseBigDecimal(rowData.get(31))); // 脂蛋白a (96→31)
                experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(32))); // 葡萄糖 (97→32)
                experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(33))); // 肌酸激酶 (98→33)
                experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(34))); // 肌酸激酶同工酶MB (99→34)
                experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(35))); // α-羟丁酸脱氢酶 (100→35)
                experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(36))); // 乳酸脱氢酶 (101→36)
                experimentExamBiochemicalTestsV2.setCrp(parseBigDecimal(rowData.get(37))); // C-反应蛋白 (102→37)
                experimentExamBiochemicalTestsV2.setIgg(parseBigDecimal(rowData.get(38))); // 免疫球蛋白G (103→38)
                experimentExamBiochemicalTestsV2.setIga(parseBigDecimal(rowData.get(39))); // 免疫球蛋白A (104→39)
                experimentExamBiochemicalTestsV2.setIgm(parseBigDecimal(rowData.get(40))); // 免疫球蛋白M (105→40)
                experimentExamBiochemicalTestsV2.setComplement3(parseBigDecimal(rowData.get(41))); // 补体3 (106→41)
                experimentExamBiochemicalTestsV2.setComplement4(parseBigDecimal(rowData.get(42))); // 补体4 (107→42)
                experimentExamBiochemicalTestsV2.setMyoglobin(parseBigDecimal(rowData.get(43))); // 肌红蛋白 (108→43)
                experimentExamBiochemicalTestsV2.setSmallDenseLdl(parseBigDecimal(rowData.get(44))); // 小而密低密度脂蛋白 (109→44)
                experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(45))); // 同型半胱氨酸 (110→45)
                experimentExamBiochemicalTestsV2.setNucleotidase(parseBigDecimal(rowData.get(47))); // 5-核苷酸酶 (112→47)
                experimentExamBiochemicalTestsV2.setAda(parseBigDecimal(rowData.get(48))); // 腺苷脱氨酶 (113→48)
                experimentExamBiochemicalTestsV2.setAmylase(parseBigDecimal(rowData.get(49))); // 淀粉酶 (114→49)
                experimentExamBiochemicalTestsV2.setAnionGap(parseBigDecimal(rowData.get(50))); // 阴离子间隙 (115→50)
                experimentExamBiochemicalTestsV2.setBufferBase(parseBigDecimal(rowData.get(51))); // 缓冲碱 (116→51)
                experimentExamBiochemicalTestsV2.setBicarbonate(parseBigDecimal(rowData.get(52))); // 碳酸氢盐 (117→52)
                experimentExamBiochemicalTestsV2.setBaseExcess(parseBigDecimal(rowData.get(53))); // 碱剩余 (118→53)
                experimentExamBiochemicalTestsV2.setExtracellularBe(parseBigDecimal(rowData.get(54))); // 细胞外液碱剩余 (119→54)
                experimentExamBiochemicalTestsV2.setBloodUrea(parseBigDecimal(rowData.get(55))); // 血尿素 (120→55)
                experimentExamBiochemicalTestsV2.setBun(parseBigDecimal(rowData.get(56))); // 血尿素氮 (121→56)
                experimentExamBiochemicalTestsV2.setCalcium(parseBigDecimal(rowData.get(57))); // 钙 (122→57)
                experimentExamBiochemicalTestsV2.setChloride(parseBigDecimal(rowData.get(58))); // 氯 (123→58)
                experimentExamBiochemicalTestsV2.setCystatinC(parseBigDecimal(rowData.get(59))); // 胱抑素C (124→59)
                experimentExamBiochemicalTestsV2.setIron(parseBigDecimal(rowData.get(60))); // 铁 (125→60)
                experimentExamBiochemicalTestsV2.setActualBicarbonate(parseBigDecimal(rowData.get(61))); // 实际碳酸氢盐 (126→61)
                experimentExamBiochemicalTestsV2.setStandardBicarbonate(parseBigDecimal(rowData.get(62))); // 标准碳酸氢盐 (127→62)
                experimentExamBiochemicalTestsV2.setPotassium(parseBigDecimal(rowData.get(63))); // 钾 (128→63)
                experimentExamBiochemicalTestsV2.setMagnesium(parseBigDecimal(rowData.get(64))); // 镁 (129→64)
                experimentExamBiochemicalTestsV2.setSodium(parseBigDecimal(rowData.get(65))); // 钠 (130→65)
                experimentExamBiochemicalTestsV2.setPhosphorus(parseBigDecimal(rowData.get(66))); // 磷 (131→66)
                experimentExamBiochemicalTestsV2.setPco2(parseBigDecimal(rowData.get(67))); // 二氧化碳分压 (132→67)
                experimentExamBiochemicalTestsV2.setPh(parseBigDecimal(rowData.get(69))); // 酸碱度 (134→69)
                experimentExamBiochemicalTestsV2.setPo2(parseBigDecimal(rowData.get(71))); // 氧分压 (136→71)
                experimentExamBiochemicalTestsV2.setRbp(parseBigDecimal(rowData.get(72))); // 视黄醇结合蛋白 (137→72)
                experimentExamBiochemicalTestsV2.setReninActivity(parseBigDecimal(rowData.get(73))); // 肾素活性 (138→73)
                experimentExamBiochemicalTestsV2.setHydrogenIonConcentration(parseBigDecimal(rowData.get(74))); // 氢离子浓度 (139→74)
                experimentExamBiochemicalTestsV2.setTco2(parseBigDecimal(rowData.get(75))); // 二氧化碳总量 (140→75)
                experimentExamBiochemicalTestsV2.setLacticAcid(parseBigDecimal(rowData.get(76))); // 乳酸 (141→76)
                experimentExamBiochemicalTestsV2.setMicroalbumin(parseBigDecimal(rowData.get(77))); // 微量白蛋白 (142→77)
                experimentExamBiochemicalTestsV2.setPlasmaOsmoticPressure(parseBigDecimal(rowData.get(78))); // 血浆渗透压 (143→78)
                experimentExamBiochemicalTestsV2.setAAGradient(parseBigDecimal(rowData.get(79))); // 肺泡-动脉血氧分压差 (144→79)
                experimentExamBiochemicalTestsV2.setAARatio(parseBigDecimal(rowData.get(80))); // 动脉-肺泡氧分压比值 (145→80)
                experimentExamBiochemicalTestsV2.setOxygenationIndex(parseBigDecimal(rowData.get(81))); // 氧合指数 (146→81)
                experimentExamBiochemicalTestsV2.setEstimatedSpo2(parseBigDecimal(rowData.get(82))); // 估计血氧饱和度 (147→82)
                experimentExamBiochemicalTestsV2.setEstimatedHb(parseBigDecimal(rowData.get(83))); // 估计总血红蛋白 (148→83)
                experimentExamBiochemicalTestsV2.setBeta2Microglobulin(parseBigDecimal(rowData.get(84))); // β2-微球蛋白 (149→84)
                experimentExamBiochemicalTestsV2.setHsCrp(parseBigDecimal(rowData.get(85))); // 超敏C反应蛋白 (150→85)
                experimentExamBiochemicalTestsV2.setHbsag(parseBigDecimal(rowData.get(86))); // 乙肝表面抗原 (151→86)
                experimentExamBiochemicalTestsV2.setAntiHbs(parseBigDecimal(rowData.get(87))); // 乙肝表面抗体 (152→87)
                experimentExamBiochemicalTestsV2.setHbeag(parseBigDecimal(rowData.get(88))); // 乙肝e抗原 (153→88)
                experimentExamBiochemicalTestsV2.setAntiHbe(parseBigDecimal(rowData.get(89))); // 乙肝e抗体 (154→89)
                experimentExamBiochemicalTestsV2.setAntiHbc(parseBigDecimal(rowData.get(90))); // 乙肝核心抗体 (155→90)
                experimentExamBiochemicalTestsV2.setTotalCholesterol(parseBigDecimal(rowData.get(91))); // 总胆固醇 (156→91)
                experimentExamBiochemicalTestsV2.setIma(parseBigDecimal(rowData.get(92))); // 缺血修饰白蛋白 (157→92)
                experimentExamBiochemicalTestsV2.setAfucosidase(parseBigDecimal(rowData.get(93))); // α-L-岩藻糖苷酶 (158→93)
                experimentExamBiochemicalTestsV2.setTimePoint(timePoint); // 时相
                experimentExamBiochemicalTestsV2Service.createExperimentExamBiochemicalTestsV2(experimentExamBiochemicalTestsV2);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/updateExperimentExamVipBiochemicalTests")
    public String updateExperimentExamVipBiochemicalTests() {
        String fileName = "E:\\项目\\西部战区医院\\前瞻性\\检验检查数据721.xlsm";
        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipUpdateBiochemicalTests(
                        prospectiveBasicInfoService
                        , experimentExamBiochemicalTestsV2Service
                        , 1))
                .headRowNumber(3) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(3)
                .doRead();

        return "生化数据更新完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipUpdateBiochemicalTests extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;
        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipUpdateBiochemicalTests(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.experimentExamBiochemicalTestsV2Service = experimentExamBiochemicalTestsV2Service;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamBiochemicalTestsV2SaveReqVO experimentExamBiochemicalTestsV2 = new ExperimentExamBiochemicalTestsV2SaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentExamBiochemicalTestsV2.setPersonId(generatedId);
                experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(2))); // ALT (67→2)
                experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(4))); // AST (68→3)
                experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(6))); // 谷草转氨酶与谷丙转氨酶比值 (69→4)
                experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(8))); // 总蛋白 (70→5)
                experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(10))); // 白蛋白 (71→6)
                experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(12))); // 球蛋白 (72→7)
                experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(14))); // 白球比 (74→9)
                experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(16))); // 总胆红素 (75→10)
                experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(18))); // 直接胆红素 (77→12)
                experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(20))); // 间接胆红素 (78→13)
                experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(22))); // 碱性磷酸酶 (80→15)
                experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(24))); // 谷氨酰转肽酶 (81→16)
                experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(26))); // 胆碱酯酶 (83→18)
                experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(28))); // 甘油三酯 (90→25)
                experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(30))); // 胆固醇 (91→26)
                experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(32))); // 高密度脂蛋白 (92→27)
                experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(34))); // 低密度脂蛋白 (93→28)
                experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(36))); // 葡萄糖 (97→32)
                experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(38))); // 肌酸激酶 (98→33)
                experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(40))); // 肌酸激酶同工酶MB (99→34)
                experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(42))); // α-羟丁酸脱氢酶 (100→35)
                experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(44))); // 乳酸脱氢酶 (101→36)
                experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(46))); // 同型半胱氨酸 (110→45)
                experimentExamBiochemicalTestsV2.setTimePoint(1); // 时相
                experimentExamBiochemicalTestsV2Service.updateExperimentExamBiochemicalTestsV2ByPersionId(experimentExamBiochemicalTestsV2);

                experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(48))); // ALT (67→2)
                experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(50))); // AST (68→3)
                experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(52))); // 谷草转氨酶与谷丙转氨酶比值 (69→4)
                experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(54))); // 总蛋白 (70→5)
                experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(56))); // 白蛋白 (71→6)
                experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(58))); // 球蛋白 (72→7)
                experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(60))); // 白球比 (74→9)
                experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(62))); // 总胆红素 (75→10)
                experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(64))); // 直接胆红素 (77→12)
                experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(66))); // 间接胆红素 (78→13)
                experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(68))); // 碱性磷酸酶 (80→15)
                experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(70))); // 谷氨酰转肽酶 (81→16)
                experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(72))); // 胆碱酯酶 (83→18)
                experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(74))); // 甘油三酯 (90→25)
                experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(76))); // 胆固醇 (91→26)
                experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(78))); // 高密度脂蛋白 (92→27)
                experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(80))); // 低密度脂蛋白 (93→28)
                experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(82))); // 葡萄糖 (97→32)
                experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(84))); // 肌酸激酶 (98→33)
                experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(86))); // 肌酸激酶同工酶MB (99→34)
                experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(88))); // α-羟丁酸脱氢酶 (100→35)
                experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(90))); // 乳酸脱氢酶 (101→36)
                experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(92))); // 同型半胱氨酸 (110→45)
                experimentExamBiochemicalTestsV2.setTimePoint(2); // 时相
                experimentExamBiochemicalTestsV2Service.updateExperimentExamBiochemicalTestsV2ByPersionId(experimentExamBiochemicalTestsV2);

                experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(94))); // ALT (67→2)
                experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(96))); // AST (68→3)
                experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(98))); // 谷草转氨酶与谷丙转氨酶比值 (69→4)
                experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(100))); // 总蛋白 (70→5)
                experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(102))); // 白蛋白 (71→6)
                experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(104))); // 球蛋白 (72→7)
                experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(106))); // 白球比 (74→9)
                experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(108))); // 总胆红素 (75→10)
                experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(110))); // 直接胆红素 (77→12)
                experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(112))); // 间接胆红素 (78→13)
                experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(114))); // 碱性磷酸酶 (80→15)
                experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(116))); // 谷氨酰转肽酶 (81→16)
                experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(118))); // 胆碱酯酶 (83→18)
                experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(120))); // 甘油三酯 (90→25)
                experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(122))); // 胆固醇 (91→26)
                experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(124))); // 高密度脂蛋白 (92→27)
                experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(126))); // 低密度脂蛋白 (93→28)
                experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(128))); // 葡萄糖 (97→32)
                experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(130))); // 肌酸激酶 (98→33)
                experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(132))); // 肌酸激酶同工酶MB (99→34)
                experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(134))); // α-羟丁酸脱氢酶 (100→35)
                experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(136))); // 乳酸脱氢酶 (101→36)
                experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(138))); // 同型半胱氨酸 (110→45)
                experimentExamBiochemicalTestsV2.setTimePoint(3); // 时相
                experimentExamBiochemicalTestsV2Service.updateExperimentExamBiochemicalTestsV2ByPersionId(experimentExamBiochemicalTestsV2);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentExamVipCoagulationTests")
    public String importExperimentExamVipCoagulationTests(@RequestParam String fileName, @RequestParam Integer sheetNo, @RequestParam Integer timePoint) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipCoagulationTests(
                        prospectiveBasicInfoService
                        , experimentExamCoagulationTestsService
                        , timePoint))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(sheetNo)
                .doRead();

        return "凝血-第" + timePoint + "时相点数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipCoagulationTests extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;
        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipCoagulationTests(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.experimentExamCoagulationTestsService = experimentExamCoagulationTestsService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamCoagulationTestsSaveReqVO experimentExamCoagulationTests = new ExperimentExamCoagulationTestsSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentExamCoagulationTests.setPersonId(generatedId);
                experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(2))); // 活化部分凝血活酶时间
                experimentExamCoagulationTests.setAntithrombinIiiActivityPercent(parseBigDecimal(rowData.get(3))); // 抗凝血酶Ⅲ活性百分比
                experimentExamCoagulationTests.setAntithrombinIiiActivityRate(parseBigDecimal(rowData.get(4))); // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
                experimentExamCoagulationTests.setDDimerOptDensity(parseBigDecimal(rowData.get(5))); // D-二聚体（光密度差值检测）
                experimentExamCoagulationTests.setDDimerConcentration(parseBigDecimal(rowData.get(6))); // D-二聚体浓度
                experimentExamCoagulationTests.setFibrinDegradationProductsDensity(parseBigDecimal(rowData.get(7))); // 纤维蛋白降解产物（光密度差值检测）
                experimentExamCoagulationTests.setFibrinDegradationProductsConcentration(parseBigDecimal(rowData.get(8))); // 纤维蛋白降解产物浓度
                experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(9))); // 纤维蛋白原浓度
                experimentExamCoagulationTests.setFibrinogenClottingTime(parseBigDecimal(rowData.get(10))); // 纤维蛋白原凝固时间
                experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(11))); // 凝血酶原时间(百分比活动度)
                experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(12))); // 凝血酶原时间-国际标准化比值
                experimentExamCoagulationTests.setProthrombinTimeRatio(parseBigDecimal(rowData.get(13))); // 凝血酶原时间比值
                experimentExamCoagulationTests.setProthrombinTime(parseBigDecimal(rowData.get(14))); // 凝血酶原时间
                experimentExamCoagulationTests.setThrombinTime(parseBigDecimal(rowData.get(15))); // 凝血酶时间
                experimentExamCoagulationTests.setThrombinTime1(parseBigDecimal(rowData.get(16))); // 凝血酶时间(1)
                experimentExamCoagulationTests.setAptt1(parseBigDecimal(rowData.get(17))); // 活化部分凝血活酶时间(1)
                experimentExamCoagulationTests.setAptt2(parseBigDecimal(rowData.get(18))); // 活化部分凝血活酶时间(2)
                experimentExamCoagulationTests.setProthrombinActivity(parseBigDecimal(rowData.get(19))); // 凝血酶原活动度
                experimentExamCoagulationTests.setInr(parseBigDecimal(rowData.get(20))); // 国际标准化比值
                experimentExamCoagulationTests.setTimePoint(timePoint); // 时相
                experimentExamCoagulationTestsService.createExperimentExamCoagulationTests(experimentExamCoagulationTests);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/updateExperimentExamVipCoagulationTests")
    public String updateExperimentExamVipCoagulationTests() {
        String fileName = "E:\\项目\\西部战区医院\\前瞻性\\检验检查数据721.xlsm";
        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipUpdateCoagulationTests(
                        prospectiveBasicInfoService
                        , experimentExamCoagulationTestsService
                        , 1))
                .headRowNumber(3) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(4)
                .doRead();

        return "凝血数据更新完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipUpdateCoagulationTests extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;
        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipUpdateCoagulationTests(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.experimentExamCoagulationTestsService = experimentExamCoagulationTestsService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamCoagulationTestsSaveReqVO experimentExamCoagulationTests = new ExperimentExamCoagulationTestsSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentExamCoagulationTests.setPersonId(generatedId);
                experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(2))); // 活化部分凝血活酶时间
                experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(4))); // 纤维蛋白原浓度
                experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(6))); // 凝血酶原时间(百分比活动度)
                experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(8))); // 凝血酶原时间-国际标准化比值
                experimentExamCoagulationTests.setTimePoint(1); // 时相
                experimentExamCoagulationTestsService.updateExperimentExamCoagulationTestsByPersionId(experimentExamCoagulationTests);

                experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(2))); // 活化部分凝血活酶时间
                experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(4))); // 纤维蛋白原浓度
                experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(6))); // 凝血酶原时间(百分比活动度)
                experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(8))); // 凝血酶原时间-国际标准化比值
                experimentExamCoagulationTests.setTimePoint(2); // 时相
                experimentExamCoagulationTestsService.updateExperimentExamCoagulationTestsByPersionId(experimentExamCoagulationTests);

                experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(2))); // 活化部分凝血活酶时间
                experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(4))); // 纤维蛋白原浓度
                experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(6))); // 凝血酶原时间(百分比活动度)
                experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(8))); // 凝血酶原时间-国际标准化比值
                experimentExamCoagulationTests.setTimePoint(3); // 时相
                experimentExamCoagulationTestsService.updateExperimentExamCoagulationTestsByPersionId(experimentExamCoagulationTests);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }


    // 工具方法：从字符串中提取数字（包括小数点）
    private static BigDecimal extractNumber(String value) {
        if (value == null) return null;
        // 提取字符串中的数字和小数点
        String numericStr = value.replaceAll("[^\\d.]", "");
        if (numericStr.isEmpty()) return null;
        try {
            return new BigDecimal(numericStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer parseDurationToMonths(String durationStr) {
        if (durationStr == null || durationStr.trim().isEmpty()) {
            return null;
        }
        durationStr = durationStr.trim().replace("．", ".").replace("，", ",").replace("。", ".");

        // 特殊情况“至今”处理
        if (durationStr.contains("至今")) {
            return 36;
        }

        // 统一成小写方便处理
        durationStr = durationStr.replaceAll("个月", "月")
                .replaceAll("个月份", "月")
                .replaceAll("年半", "年6月")   // 1年半 = 1年6月
                .replaceAll("半年", "6月")
                .replaceAll("半月", "1月");

        int totalMonths = 0;

        // 匹配“X年Y月”或“X年”或“Y月”
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(?:(\\d+(\\.\\d+)?)年)?(?:\\s*(\\d+)月)?").matcher(durationStr);
        if (matcher.find()) {
            // 年部分
            String yearStr = matcher.group(1);
            if (yearStr != null) {
                try {
                    double years = Double.parseDouble(yearStr);
                    totalMonths += (int) Math.ceil(years * 12);
                } catch (NumberFormatException ignored) {
                }
            }

            // 月部分
            String monthStr = matcher.group(3);
            if (monthStr != null) {
                try {
                    totalMonths += Integer.parseInt(monthStr);
                } catch (NumberFormatException ignored) {
                }
            }
        }

        // 如果只包含“天”
        if (totalMonths == 0 && durationStr.contains("天")) {
            java.util.regex.Matcher dayMatcher = java.util.regex.Pattern.compile("(\\d+)天").matcher(durationStr);
            if (dayMatcher.find()) {
                int days = Integer.parseInt(dayMatcher.group(1));
                totalMonths = Math.max(1, (int) Math.ceil(days / 30.0)); // 不足1个月按1个月
            }
        }

        // 如果还是无法解析，尝试直接转换为整数（月）
        if (totalMonths == 0) {
            java.util.regex.Matcher monthMatcher = java.util.regex.Pattern.compile("(\\d+)").matcher(durationStr);
            if (monthMatcher.find()) {
                totalMonths = Integer.parseInt(monthMatcher.group(1));
            } else {
                totalMonths = 1; // 最后兜底，未知情况按 1 个月处理
            }
        }

        return totalMonths;
    }

    public static Integer extractNumberOrZero(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return 0; // 没有数字则返回 0
    }

    // 工具方法：解析 BigDecimal
    public static BigDecimal parseBigDecimal(Object value) {
        if (value == null) {
            return null;
        }

        String str = value.toString().trim();

        // 判断是否为合法数字（包含正负号、小数）
        if (!str.matches("^-?\\d+(\\.\\d+)?$")) {
            return null;
        }

        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Boolean parseBoolean(String value) {
        if (value == null) {
            return false;
        }
        String normalized = value.trim().toLowerCase();
        return normalized.equals("true") ||
                normalized.equals("1") ||
                normalized.equals("是") ||
                normalized.equals("y") ||
                normalized.equals("yes");
    }

    /**
     * 将字符串安全转换为 Integer
     * 支持跳过“弃检”“无效”等非数字情况，返回 null 或默认值
     */
    public static Integer parseInteger(Object value) {
        if (value == null) {
            return null;
        }

        String str = value.toString().trim();

        // 判断是否是纯数字
        if (str.matches("^\\d+$")) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        // 其他无法识别的汉字，统一视为 null
        return null;
    }

    @GetMapping("/getDataByParamPage")
    @Operation(summary = "获得基础信息分页")
    public CommonResult<PageResult<BasicInfoRespVO>> getDataByParamPage(@Valid BasicInfoPageReqVO pageReqVO) {
        if ("2".equals(pageReqVO.getGroup())) {
            pageReqVO.setType(null);
            pageReqVO.setYear(null);
            pageReqVO.setTimePoint(0);
        }
        PageResult<ProspectiveBasicInfoDO> pageResult = prospectiveBasicInfoService.getDataByParamPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicInfoRespVO.class));
    }

    @GetMapping("/getAverageByParam")
    @Operation(summary = "获得平均值")
    public CommonResult<BasicInfoAverageVO> getAverageByParam(@Valid BasicInfoPageReqVO pageReqVO) {
        if ("2".equals(pageReqVO.getGroup())) {
            pageReqVO.setType(null);
            pageReqVO.setYear(null);
            pageReqVO.setTimePoint(0);
        }
        BasicInfoAverageVO basicInfoAverage = prospectiveBasicInfoService.getAverageByParam(pageReqVO);
        return success(BeanUtils.toBean(basicInfoAverage, BasicInfoAverageVO.class));
    }

    //前面是临时第一版
    //下面开始是所有数据
    //实验组流调-------------------------------------------------------------------------------------------------------
    @GetMapping("/importExperimentSurvey1")
    public String importExperimentSurvey1(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/整理导入/实验组/18123.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener1(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentSurveyBasicCheckInfoService
                        , experimentSurveyStationTrainingInfoService
                        , experimentSurveySmokingInfoService
                        , experimentSurveyPlateauFitnessInfoService
                        , experimentSurveyMedicalHistoryService
                        , experimentSurveySelfAssessmentService
                        , experimentSurveyMissionProgressSurveyService
                        , experimentSurveyPlateauArrivalSymptomsService
                        , experimentSurveyAcuteMountainSicknessRecordsService
                        , experimentSurveyHighlandDiseasesDuringServiceService
                        , experimentSurveyScoreSummaryService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet()
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener1 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService;
        private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;
        private ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService;
        private ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService;
        private ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService;
        private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
        private ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService;
        private ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService;
        private ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService;
        private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
        private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

        // 构造函数注入服务
        public IndexListener1(String type, // 新增参数
                              ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService
                , ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService
                , ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService
                , ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService
                , ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService
                , ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService
                , ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService
                , ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService
                , ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService
                , ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService
                , ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService) {
            this.type = type; // 初始化
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentSurveyBasicCheckInfoService = experimentSurveyBasicCheckInfoService;
            this.experimentSurveyStationTrainingInfoService = experimentSurveyStationTrainingInfoService;
            this.experimentSurveySmokingInfoService = experimentSurveySmokingInfoService;
            this.experimentSurveyPlateauFitnessInfoService = experimentSurveyPlateauFitnessInfoService;
            this.experimentSurveyMedicalHistoryService = experimentSurveyMedicalHistoryService;
            this.experimentSurveySelfAssessmentService = experimentSurveySelfAssessmentService;
            this.experimentSurveyMissionProgressSurveyService = experimentSurveyMissionProgressSurveyService;
            this.experimentSurveyPlateauArrivalSymptomsService = experimentSurveyPlateauArrivalSymptomsService;
            this.experimentSurveyAcuteMountainSicknessRecordsService = experimentSurveyAcuteMountainSicknessRecordsService;
            this.experimentSurveyHighlandDiseasesDuringServiceService = experimentSurveyHighlandDiseasesDuringServiceService;
            this.experimentSurveyScoreSummaryService = experimentSurveyScoreSummaryService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyBasicCheckInfoSaveReqVO experimentSurveyBasicCheckInfo = new ExperimentSurveyBasicCheckInfoSaveReqVO();
            ExperimentSurveyStationTrainingInfoSaveReqVO experimentSurveyStationTrainingInfo = new ExperimentSurveyStationTrainingInfoSaveReqVO();
            ExperimentSurveySmokingInfoSaveReqVO experimentSurveySmokingInfo = new ExperimentSurveySmokingInfoSaveReqVO();
            ExperimentSurveyPlateauFitnessInfoSaveReqVO experimentSurveyPlateauFitnessInfo = new ExperimentSurveyPlateauFitnessInfoSaveReqVO();
            ExperimentSurveyMedicalHistorySaveReqVO experimentSurveyMedicalHistory = new ExperimentSurveyMedicalHistorySaveReqVO();
            ExperimentSurveySelfAssessmentSaveReqVO experimentSurveySelfAssessment = new ExperimentSurveySelfAssessmentSaveReqVO();
            ExperimentSurveyMissionProgressSurveySaveReqVO experimentSurveyMissionProgressSurvey = new ExperimentSurveyMissionProgressSurveySaveReqVO();
            ExperimentSurveyPlateauArrivalSymptomsSaveReqVO experimentSurveyPlateauArrivalSymptoms = new ExperimentSurveyPlateauArrivalSymptomsSaveReqVO();
            ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO experimentSurveyAcuteMountainSicknessRecords = new ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO();
            ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO experimentSurveyHighlandDiseasesDuringService = new ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO();
            ExperimentSurveyScoreSummarySaveReqVO experimentSurveyScoreSummary = new ExperimentSurveyScoreSummarySaveReqVO();

            basicInfo.setCode(rowData.get(2)); // 编号
            basicInfo.setName(rowData.get(0)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("survey"); // 流调或体检
            basicInfo.setAge(extractNumberOrZero(rowData.get(3))); // 年龄
            basicInfo.setActualAge(extractNumberOrZero(rowData.get(4))); // 实际年龄
            basicInfo.setGender(rowData.get(5)); // 性别
            basicInfo.setBirthDate(rowData.get(6)); // 出生年月
            basicInfo.setPosition(rowData.get(7)); // 部职别
            basicInfo.setIdNumber(rowData.get(9)); // 证件号
            basicInfo.setTimePoint(1); // 时相类型

            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            basicOtherInfo.setPersonId(generatedId);
            basicOtherInfo.setMaritalStatus(rowData.get(12)); // 婚姻状况
            basicOtherInfo.setHeight(parseBigDecimal(rowData.get(14))); // 身高
            basicOtherInfo.setWeight(parseBigDecimal(rowData.get(15))); // 体重
            basicOtherInfo.setEthnicity(rowData.get(16)); // 民族
            basicOtherInfo.setEducationLevel(rowData.get(17)); // 最高学历
            basicOtherInfo.setFertilityStatus(rowData.get(18)); // 生育情况
            basicOtherInfo.setTimePoint(1); // 时相类型
            prospectiveBasicOtherInfoService.createExperimentSurveyBasicOtherInfo(basicOtherInfo);

            experimentSurveyStationTrainingInfo.setPersonId(generatedId);
            experimentSurveyStationTrainingInfo.setMissionPointAltitude(extractNumberOrZero(rowData.get(8))); // 任务点海拔
            experimentSurveyStationTrainingInfo.setPlateauTrainingCount(extractNumberOrZero(rowData.get(10))); // 高原驻训次数
            experimentSurveyStationTrainingInfo.setPlateauTrainingDuration(extractNumberOrZero(rowData.get(11))); // 高原驻训总时长
            experimentSurveyStationTrainingInfo.setServicePosition(rowData.get(13)); // 服役期间职务
            experimentSurveyStationTrainingInfo.setMissionType(rowData.get(19)); // 任务从事类型
            experimentSurveyStationTrainingInfo.setDailyWorkHours(extractNumberOrZero(rowData.get(20))); // 每日工作时间
            experimentSurveyStationTrainingInfo.setTimePoint(1); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);

            experimentSurveySmokingInfo.setPersonId(generatedId);
            experimentSurveySmokingInfo.setSmokingStatus(rowData.get(21)); // 吸烟情况
            experimentSurveySmokingInfo.setDailyCigarettes(rowData.get(22)); // 每日吸烟支数
            experimentSurveySmokingInfo.setSmokingStartAge(rowData.get(23)); // 吸烟开始年龄
            experimentSurveySmokingInfo.setSmokingYears(rowData.get(24)); // 吸烟年限
            experimentSurveySmokingInfo.setQuitAttempted(parseBoolean(rowData.get(25))); // 是否尝试戒烟
            experimentSurveySmokingInfo.setSmokingRegion(rowData.get(26)); // 吸烟地区
            experimentSurveySmokingInfo.setQuitSmokingYears(rowData.get(27)); // 戒烟年限
            experimentSurveySmokingInfo.setQuitSmokingDuration(rowData.get(28)); // 戒烟持续时长
            experimentSurveySmokingInfo.setQuitSmokingRegion(rowData.get(29)); // 戒烟地区
            experimentSurveySmokingInfo.setTimePoint(1); // 时相类型
            experimentSurveySmokingInfoService.createExperimentSurveySmokingInfo(experimentSurveySmokingInfo);

            experimentSurveySelfAssessment.setPersonId(generatedId);
            experimentSurveySelfAssessment.setHealthComparisonWithPeers(rowData.get(30)); // 健康状况与同龄人比较
            experimentSurveySelfAssessment.setHealthScore(extractNumberOrZero(rowData.get(31))); // 健康评分
            experimentSurveySelfAssessment.setTimePoint(1); // 时相类型
            experimentSurveySelfAssessmentService.createExperimentSurveySelfAssessment(experimentSurveySelfAssessment);

            experimentSurveyMedicalHistory.setPersonId(generatedId);
            experimentSurveyMedicalHistory.setDescription(rowData.get(32)); // 既往是否患有下列疾病总描述
            experimentSurveyMedicalHistory.setTimePoint(1); // 时相类型
            experimentSurveyMedicalHistoryService.createExperimentSurveyMedicalHistory(experimentSurveyMedicalHistory);

            experimentSurveyPlateauFitnessInfo.setPersonId(generatedId);
            experimentSurveyPlateauFitnessInfo.setHasRegularTraining(parseBoolean(rowData.get(33))); // 是否有规律的体能训练
            experimentSurveyPlateauFitnessInfo.setTrainingFrequency(rowData.get(34)); // 训练频率
            experimentSurveyPlateauFitnessInfo.setTrainingDuration(rowData.get(35)); // 训练时长
            experimentSurveyPlateauFitnessInfo.setTrainingType(rowData.get(36)); // 训练类型
            experimentSurveyPlateauFitnessInfo.setHasChestDiscomfort(rowData.get(37)); // 是否有胸部不适
            experimentSurveyPlateauFitnessInfo.setSymptomReliefAfterAdaptation(parseBoolean(rowData.get(38))); // 适应后症状是否缓解
            experimentSurveyPlateauFitnessInfo.setHasInsomnia(rowData.get(39)); // 是否有失眠
            experimentSurveyPlateauFitnessInfo.setDailySleepHours(rowData.get(40));
            experimentSurveyPlateauFitnessInfo.setInsomniaImprovement(parseBoolean(rowData.get(41))); // 失眠症状改善
            experimentSurveyPlateauFitnessInfo.setDietHabits(rowData.get(42)); // 高原期间饮食情况及饮食习惯
            experimentSurveyPlateauFitnessInfo.setTimePoint(1); // 时相类型
            experimentSurveyPlateauFitnessInfoService.createExperimentSurveyPlateauFitnessInfo(experimentSurveyPlateauFitnessInfo);

            experimentSurveyBasicCheckInfo.setPersonId(generatedId);
            experimentSurveyBasicCheckInfo.setSystolicBloodPressure(extractNumberOrZero(rowData.get(43))); // 收缩压
            experimentSurveyBasicCheckInfo.setDiastolicBloodPressure(extractNumberOrZero(rowData.get(44))); // 舒张压
            experimentSurveyBasicCheckInfo.setOxygenSaturation(extractNumberOrZero(rowData.get(45))); // 血氧饱和度
            experimentSurveyBasicCheckInfo.setHeartRate(extractNumberOrZero(rowData.get(46))); // 心率
            experimentSurveyBasicCheckInfo.setBasicHeight(extractNumberOrZero(rowData.get(47))); // 身高
            experimentSurveyBasicCheckInfo.setBasicWeight(extractNumberOrZero(rowData.get(48))); // 体重
            experimentSurveyBasicCheckInfo.setTimePoint(1); // 时相类型
            experimentSurveyBasicCheckInfoService.createExperimentSurveyBasicCheckInfo(experimentSurveyBasicCheckInfo);

            experimentSurveyMissionProgressSurvey.setPersonId(generatedId);
            experimentSurveyMissionProgressSurvey.setTransportationMode(rowData.get(49)); // 交通方式
            experimentSurveyMissionProgressSurvey.setMissionPointAltitude(extractNumberOrZero(rowData.get(50))); // 任务点海拔
            experimentSurveyMissionProgressSurvey.setArrivalDate(rowData.get(51)); // 到达日期
            experimentSurveyMissionProgressSurvey.setPlateauMissionDuration(parseDurationToMonths(rowData.get(52))); // 高原任务持续时间
            experimentSurveyMissionProgressSurvey.setTravelDuration(rowData.get(53)); // 推进途中耗费时间
            experimentSurveyMissionProgressSurvey.setHasStopover(parseBoolean(rowData.get(54))); // 是否有中途停留
            experimentSurveyMissionProgressSurvey.setStopoverLocation(rowData.get(55)); // 中途停留地点
            experimentSurveyMissionProgressSurvey.setHasDiscomfortAfterArrival(parseBoolean(rowData.get(56))); // 到达后是否有不适
            experimentSurveyMissionProgressSurvey.setDiscomfortOccurrenceTime(rowData.get(57)); // 不适发生时间
            experimentSurveyMissionProgressSurvey.setTimePoint(1); // 时相类型
            experimentSurveyMissionProgressSurveyService.createExperimentSurveyMissionProgressSurvey(experimentSurveyMissionProgressSurvey);

            experimentSurveyPlateauArrivalSymptoms.setPersonId(generatedId);
            experimentSurveyPlateauArrivalSymptoms.setHeadache(rowData.get(58)); // 头痛
            experimentSurveyPlateauArrivalSymptoms.setHeadacheDuration(rowData.get(59)); // 头痛持续时间
            experimentSurveyPlateauArrivalSymptoms.setDigestiveSymptoms(rowData.get(60)); // 消化道症状
            experimentSurveyPlateauArrivalSymptoms.setDigestiveSymptomsDuration(rowData.get(61)); // 消化道症状持续时间
            experimentSurveyPlateauArrivalSymptoms.setFatigue(rowData.get(62)); // 疲劳
            experimentSurveyPlateauArrivalSymptoms.setFatigueDuration(rowData.get(63)); // 疲劳持续时间
            experimentSurveyPlateauArrivalSymptoms.setDizziness(rowData.get(64)); // 睡眠障碍
            experimentSurveyPlateauArrivalSymptoms.setDizzinessDuration(rowData.get(65)); // 睡眠障碍持续时间
            experimentSurveyPlateauArrivalSymptoms.setImpactOnDailyLife(rowData.get(66)); // 对日常生活的影响
            experimentSurveyPlateauArrivalSymptoms.setTimePoint(1); // 时相类型
            experimentSurveyPlateauArrivalSymptomsService.createExperimentSurveyPlateauArrivalSymptoms(experimentSurveyPlateauArrivalSymptoms);

            experimentSurveyAcuteMountainSicknessRecords.setPersonId(generatedId);
            experimentSurveyAcuteMountainSicknessRecords.setOtherDiseases(rowData.get(67)); // 其他疾病
            experimentSurveyAcuteMountainSicknessRecords.setTimePoint(1); // 时相类型
            experimentSurveyAcuteMountainSicknessRecordsService.createExperimentSurveyAcuteMountainSicknessRecords(experimentSurveyAcuteMountainSicknessRecords);

            experimentSurveyHighlandDiseasesDuringService.setPersonId(generatedId);
            experimentSurveyHighlandDiseasesDuringService.setDiseases(rowData.get(68)); // 高原病史
            experimentSurveyHighlandDiseasesDuringService.setTimePoint(1); // 时相类型
            experimentSurveyHighlandDiseasesDuringServiceService.createExperimentSurveyHighlandDiseasesDuringService(experimentSurveyHighlandDiseasesDuringService);

            experimentSurveyScoreSummary.setPersonId(generatedId);
            experimentSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(69))); // 总分
            experimentSurveyScoreSummary.setTimePoint(1); // 时相类型
            experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(experimentSurveyScoreSummary);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentSurvey2")
    public String importExperimentSurvey2(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/整理导入/实验组/18123.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener2(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentSurveyBasicCheckInfoService
                        , experimentSurveyStationTrainingInfoService
                        , experimentSurveySmokingInfoService
                        , experimentSurveyPlateauFitnessInfoService
                        , experimentSurveyMedicalHistoryService
                        , experimentSurveySelfAssessmentService
                        , experimentSurveyMissionProgressSurveyService
                        , experimentSurveyPlateauArrivalSymptomsService
                        , experimentSurveyAcuteMountainSicknessRecordsService
                        , experimentSurveyHighlandDiseasesDuringServiceService
                        , experimentSurveyScoreSummaryService
                        , prospectiveExperimentSurveyPostReturnSymptomsService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(1)
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener2 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService;
        private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;
        private ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService;
        private ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService;
        private ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService;
        private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
        private ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService;
        private ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService;
        private ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService;
        private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
        private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

        private ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService;

        // 构造函数注入服务
        public IndexListener2(String type,
                              ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService
                , ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService
                , ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService
                , ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService
                , ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService
                , ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService
                , ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService
                , ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService
                , ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService
                , ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService
                , ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService
                , ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentSurveyBasicCheckInfoService = experimentSurveyBasicCheckInfoService;
            this.experimentSurveyStationTrainingInfoService = experimentSurveyStationTrainingInfoService;
            this.experimentSurveySmokingInfoService = experimentSurveySmokingInfoService;
            this.experimentSurveyPlateauFitnessInfoService = experimentSurveyPlateauFitnessInfoService;
            this.experimentSurveyMedicalHistoryService = experimentSurveyMedicalHistoryService;
            this.experimentSurveySelfAssessmentService = experimentSurveySelfAssessmentService;
            this.experimentSurveyMissionProgressSurveyService = experimentSurveyMissionProgressSurveyService;
            this.experimentSurveyPlateauArrivalSymptomsService = experimentSurveyPlateauArrivalSymptomsService;
            this.experimentSurveyAcuteMountainSicknessRecordsService = experimentSurveyAcuteMountainSicknessRecordsService;
            this.experimentSurveyHighlandDiseasesDuringServiceService = experimentSurveyHighlandDiseasesDuringServiceService;
            this.experimentSurveyScoreSummaryService = experimentSurveyScoreSummaryService;
            this.prospectiveExperimentSurveyPostReturnSymptomsService = prospectiveExperimentSurveyPostReturnSymptomsService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyBasicCheckInfoSaveReqVO experimentSurveyBasicCheckInfo = new ExperimentSurveyBasicCheckInfoSaveReqVO();
            ExperimentSurveyStationTrainingInfoSaveReqVO experimentSurveyStationTrainingInfo = new ExperimentSurveyStationTrainingInfoSaveReqVO();
            ExperimentSurveySmokingInfoSaveReqVO experimentSurveySmokingInfo = new ExperimentSurveySmokingInfoSaveReqVO();
            ExperimentSurveyPlateauFitnessInfoSaveReqVO experimentSurveyPlateauFitnessInfo = new ExperimentSurveyPlateauFitnessInfoSaveReqVO();
            ExperimentSurveyMedicalHistorySaveReqVO experimentSurveyMedicalHistory = new ExperimentSurveyMedicalHistorySaveReqVO();
            ExperimentSurveySelfAssessmentSaveReqVO experimentSurveySelfAssessment = new ExperimentSurveySelfAssessmentSaveReqVO();
            ExperimentSurveyMissionProgressSurveySaveReqVO experimentSurveyMissionProgressSurvey = new ExperimentSurveyMissionProgressSurveySaveReqVO();
            ExperimentSurveyPlateauArrivalSymptomsSaveReqVO experimentSurveyPlateauArrivalSymptoms = new ExperimentSurveyPlateauArrivalSymptomsSaveReqVO();
            ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO experimentSurveyAcuteMountainSicknessRecords = new ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO();
            ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO experimentSurveyHighlandDiseasesDuringService = new ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO();
            ExperimentSurveyScoreSummarySaveReqVO experimentSurveyScoreSummary = new ExperimentSurveyScoreSummarySaveReqVO();
            ExperimentSurveyPostReturnSymptomsSaveReqVO experimentSurveyPostReturnSymptoms = new ExperimentSurveyPostReturnSymptomsSaveReqVO();

            basicInfo.setCode(rowData.get(2)); // 编号
            basicInfo.setName(rowData.get(0)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("survey"); // 流调或体检
            basicInfo.setAge(extractNumberOrZero(rowData.get(3))); // 年龄
            basicInfo.setActualAge(extractNumberOrZero(rowData.get(4))); // 实际年龄
            basicInfo.setGender(rowData.get(5)); // 性别
            basicInfo.setBirthDate(rowData.get(12)); // 出生年月
            basicInfo.setPosition(rowData.get(13)); // 部职别
            basicInfo.setIdNumber(rowData.get(15)); // 证件号
            basicInfo.setTimePoint(2); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            experimentSurveyBasicCheckInfo.setPersonId(generatedId);
            experimentSurveyBasicCheckInfo.setSystolicBloodPressure(extractNumberOrZero(rowData.get(6))); // 收缩压
            experimentSurveyBasicCheckInfo.setDiastolicBloodPressure(extractNumberOrZero(rowData.get(7))); // 舒张压
            experimentSurveyBasicCheckInfo.setOxygenSaturation(extractNumberOrZero(rowData.get(8))); // 血氧饱和度
            experimentSurveyBasicCheckInfo.setHeartRate(extractNumberOrZero(rowData.get(9))); // 心率
            experimentSurveyBasicCheckInfo.setBasicHeight(extractNumberOrZero(rowData.get(10))); // 身高
            experimentSurveyBasicCheckInfo.setBasicWeight(extractNumberOrZero(rowData.get(11))); // 体重
            experimentSurveyBasicCheckInfo.setTimePoint(2); // 时相类型
            experimentSurveyBasicCheckInfoService.createExperimentSurveyBasicCheckInfo(experimentSurveyBasicCheckInfo);


            experimentSurveyStationTrainingInfo.setPersonId(generatedId);
            experimentSurveyStationTrainingInfo.setMissionPointAltitude(extractNumberOrZero(rowData.get(14))); // 任务点海拔
            experimentSurveyStationTrainingInfo.setPlateauTrainingDuration(extractNumberOrZero(rowData.get(16))); // 高原驻训总时长
            experimentSurveyStationTrainingInfo.setTimePoint(2); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);

            experimentSurveyMissionProgressSurvey.setPersonId(generatedId);
            experimentSurveyMissionProgressSurvey.setTransportationMode(rowData.get(17)); // 交通方式
            experimentSurveyMissionProgressSurvey.setReturnPurpose(rowData.get(18)); // 返回目的
            experimentSurveyMissionProgressSurvey.setArrivalDate(rowData.get(19)); // 到达日期
            experimentSurveyMissionProgressSurvey.setPlateauMissionDuration(parseDurationToMonths(rowData.get(20))); // 高原任务持续时间
            experimentSurveyMissionProgressSurvey.setTravelDuration(rowData.get(21)); // 推进途中耗费时间
            experimentSurveyMissionProgressSurvey.setHasStopover(parseBoolean(rowData.get(22))); // 是否有中途停留
            experimentSurveyMissionProgressSurvey.setStopoverLocation(rowData.get(23)); // 中途停留地点
            experimentSurveyMissionProgressSurvey.setHasDiscomfortAfterArrival(parseBoolean(rowData.get(24))); // 到达后是否有不适
            experimentSurveyMissionProgressSurvey.setTimePoint(2); // 时相类型
            experimentSurveyMissionProgressSurveyService.createExperimentSurveyMissionProgressSurvey(experimentSurveyMissionProgressSurvey);

            experimentSurveyPostReturnSymptoms.setPersonId(generatedId);
            experimentSurveyPostReturnSymptoms.setFatigue(parseInteger(rowData.get(25))); // 疲倦
            experimentSurveyPostReturnSymptoms.setFatigueDuration(rowData.get(26)); // 疲倦持续时间
            experimentSurveyPostReturnSymptoms.setWeakness(parseInteger(rowData.get(27))); // 乏力
            experimentSurveyPostReturnSymptoms.setWeaknessDuration(rowData.get(28)); // 乏力持续时间
            experimentSurveyPostReturnSymptoms.setDrowsiness(parseInteger(rowData.get(29))); // 嗜睡
            experimentSurveyPostReturnSymptoms.setDrowsinessDuration(rowData.get(30)); // 嗜睡持续时间
            experimentSurveyPostReturnSymptoms.setDizziness(parseInteger(rowData.get(31))); // 头昏
            experimentSurveyPostReturnSymptoms.setDizzinessDuration(rowData.get(32)); // 头昏持续时间
            experimentSurveyPostReturnSymptoms.setVertigo(parseInteger(rowData.get(33))); // 眩晕
            experimentSurveyPostReturnSymptoms.setVertigoDuration(rowData.get(34)); // 眩晕持续时间
            experimentSurveyPostReturnSymptoms.setPoorConcentration(parseInteger(rowData.get(35))); // 精力不集中
            experimentSurveyPostReturnSymptoms.setPoorConcentrationDuration(rowData.get(36)); // 精力不集中持续时间
            experimentSurveyPostReturnSymptoms.setSlowReaction(parseInteger(rowData.get(37))); // 反应迟钝
            experimentSurveyPostReturnSymptoms.setSlowReactionDuration(rowData.get(38)); // 反应迟钝持续时间
            experimentSurveyPostReturnSymptoms.setMemoryLoss(parseInteger(rowData.get(39))); // 记忆减退
            experimentSurveyPostReturnSymptoms.setMemoryLossDuration(rowData.get(40)); // 记忆减退持续时间
            experimentSurveyPostReturnSymptoms.setInsomnia(parseInteger(rowData.get(41))); // 失眠
            experimentSurveyPostReturnSymptoms.setInsomniaDuration(rowData.get(42)); // 失眠持续时间
            experimentSurveyPostReturnSymptoms.setNightmares(parseInteger(rowData.get(43))); // 多梦
            experimentSurveyPostReturnSymptoms.setNightmaresDuration(rowData.get(44)); // 多梦持续时间
            experimentSurveyPostReturnSymptoms.setSoreThroat(parseInteger(rowData.get(45))); // 咽喉痛
            experimentSurveyPostReturnSymptoms.setSoreThroatDuration(rowData.get(46)); // 咽喉痛持续时间
            experimentSurveyPostReturnSymptoms.setCough(parseInteger(rowData.get(47))); // 咳嗽
            experimentSurveyPostReturnSymptoms.setCoughDuration(rowData.get(48)); // 咳嗽持续时间
            experimentSurveyPostReturnSymptoms.setPhlegm(parseInteger(rowData.get(49))); // 多痰
            experimentSurveyPostReturnSymptoms.setPhlegmDuration(rowData.get(50)); // 多痰持续时间
            experimentSurveyPostReturnSymptoms.setWheezing(parseInteger(rowData.get(51))); // 气喘
            experimentSurveyPostReturnSymptoms.setWheezingDuration(rowData.get(52)); // 气喘持续时间
            experimentSurveyPostReturnSymptoms.setChestTightness(parseInteger(rowData.get(53))); // 胸闷
            experimentSurveyPostReturnSymptoms.setChestTightnessDuration(rowData.get(54)); // 胸闷持续时间
            experimentSurveyPostReturnSymptoms.setChestPain(parseInteger(rowData.get(55))); // 心前区痛
            experimentSurveyPostReturnSymptoms.setChestPainDuration(rowData.get(56)); // 心前区痛持续时间
            experimentSurveyPostReturnSymptoms.setPalpitations(parseInteger(rowData.get(57))); // 心慌
            experimentSurveyPostReturnSymptoms.setPalpitationsDuration(rowData.get(58)); // 心慌持续时间
            experimentSurveyPostReturnSymptoms.setBradycardia(parseInteger(rowData.get(59))); // 脉率减慢
            experimentSurveyPostReturnSymptoms.setBradycardiaDuration(rowData.get(60)); // 脉率减慢持续时间
            experimentSurveyPostReturnSymptoms.setCyanosis(parseInteger(rowData.get(61))); // 紫绀
            experimentSurveyPostReturnSymptoms.setCyanosisDuration(rowData.get(62)); // 紫绀持续时间
            experimentSurveyPostReturnSymptoms.setBloodPressureFluctuation(parseInteger(rowData.get(63))); // 血压波动
            experimentSurveyPostReturnSymptoms.setBloodPressureFluctuationDuration(rowData.get(64)); // 血压波动持续时间
            experimentSurveyPostReturnSymptoms.setSkinBleeding(parseInteger(rowData.get(65))); // 皮肤出血
            experimentSurveyPostReturnSymptoms.setSkinBleedingDuration(rowData.get(66)); // 皮肤出血持续时间
            experimentSurveyPostReturnSymptoms.setSkinBruising(parseInteger(rowData.get(67))); // 皮肤瘀斑
            experimentSurveyPostReturnSymptoms.setSkinBruisingDuration(rowData.get(68)); // 皮肤瘀斑持续时间
            experimentSurveyPostReturnSymptoms.setAnemia(parseInteger(rowData.get(69))); // 贫血
            experimentSurveyPostReturnSymptoms.setAnemiaDuration(rowData.get(70)); // 贫血持续时间
            experimentSurveyPostReturnSymptoms.setWeightLoss(parseInteger(rowData.get(71))); // 体重减轻
            experimentSurveyPostReturnSymptoms.setWeightLossDuration(rowData.get(72)); // 体重减轻持续时间
            experimentSurveyPostReturnSymptoms.setIncreasedAppetite(parseInteger(rowData.get(73))); // 食欲增加
            experimentSurveyPostReturnSymptoms.setIncreasedAppetiteDuration(rowData.get(74)); // 食欲增加持续时间
            experimentSurveyPostReturnSymptoms.setAnorexia(parseInteger(rowData.get(75))); // 厌食
            experimentSurveyPostReturnSymptoms.setAnorexiaDuration(rowData.get(76)); // 厌食持续时间
            experimentSurveyPostReturnSymptoms.setConstipation(parseInteger(rowData.get(77))); // 便秘
            experimentSurveyPostReturnSymptoms.setConstipationDuration(rowData.get(78)); // 便秘持续时间
            experimentSurveyPostReturnSymptoms.setDiarrhea(parseInteger(rowData.get(79))); // 腹泻
            experimentSurveyPostReturnSymptoms.setDiarrheaDuration(rowData.get(80)); // 腹泻持续时间
            experimentSurveyPostReturnSymptoms.setAbdominalPain(parseInteger(rowData.get(81))); // 腹痛
            experimentSurveyPostReturnSymptoms.setAbdominalPainDuration(rowData.get(82)); // 腹痛持续时间
            experimentSurveyPostReturnSymptoms.setAbdominalDistension(parseInteger(rowData.get(83))); // 腹胀
            experimentSurveyPostReturnSymptoms.setAbdominalDistensionDuration(rowData.get(84)); // 腹胀持续时间
            experimentSurveyPostReturnSymptoms.setJaundice(parseInteger(rowData.get(85))); // 黄疸
            experimentSurveyPostReturnSymptoms.setJaundiceDuration(rowData.get(86)); // 黄疸持续时间
            experimentSurveyPostReturnSymptoms.setNumbness(parseInteger(rowData.get(87))); // 手足麻木
            experimentSurveyPostReturnSymptoms.setNumbnessDuration(rowData.get(88)); // 手足麻木持续时间
            experimentSurveyPostReturnSymptoms.setLimbEdema(parseInteger(rowData.get(89))); // 肢体水肿
            experimentSurveyPostReturnSymptoms.setLimbEdemaDuration(rowData.get(90)); // 肢体水肿持续时间
            experimentSurveyPostReturnSymptoms.setFacialEdema(parseInteger(rowData.get(91))); // 面部水肿
            experimentSurveyPostReturnSymptoms.setFacialEdemaDuration(rowData.get(92)); // 面部水肿持续时间
            experimentSurveyPostReturnSymptoms.setHairLoss(parseInteger(rowData.get(93))); // 脱发
            experimentSurveyPostReturnSymptoms.setHairLossDuration(rowData.get(94)); // 脱发持续时间
            experimentSurveyPostReturnSymptoms.setIncreasedUrination(parseInteger(rowData.get(95))); // 夜尿增多
            experimentSurveyPostReturnSymptoms.setIncreasedUrinationDuration(rowData.get(96)); // 夜尿增多持续时间
            experimentSurveyPostReturnSymptoms.setOtherSymptoms(rowData.get(97)); // 返回后有无其他症状
            experimentSurveyPostReturnSymptoms.setTimePoint(2); // 时相类型
            prospectiveExperimentSurveyPostReturnSymptomsService.createExperimentSurveyPostReturnSymptoms(experimentSurveyPostReturnSymptoms);

            experimentSurveyScoreSummary.setPersonId(generatedId);
            experimentSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(99))); // 总分
            experimentSurveyScoreSummary.setTimePoint(2); // 时相类型
            experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(experimentSurveyScoreSummary);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentSurvey3")
    public String importExperimentSurvey3(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/整理导入/实验组/18123.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener3(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentSurveyBasicCheckInfoService
                        , experimentSurveyStationTrainingInfoService
                        , experimentSurveySmokingInfoService
                        , experimentSurveyPlateauFitnessInfoService
                        , experimentSurveyMedicalHistoryService
                        , experimentSurveySelfAssessmentService
                        , experimentSurveyMissionProgressSurveyService
                        , experimentSurveyPlateauArrivalSymptomsService
                        , experimentSurveyAcuteMountainSicknessRecordsService
                        , experimentSurveyHighlandDiseasesDuringServiceService
                        , experimentSurveyScoreSummaryService
                        , prospectiveExperimentSurveyPostReturnSymptomsService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(2)
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener3 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService;
        private ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService;
        private ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService;
        private ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService;
        private ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService;
        private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
        private ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService;
        private ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService;
        private ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService;
        private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
        private ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService;

        private ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService;

        // 构造函数注入服务
        public IndexListener3(String type,
                              ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentSurveyBasicCheckInfoService experimentSurveyBasicCheckInfoService
                , ExperimentSurveyStationTrainingInfoService experimentSurveyStationTrainingInfoService
                , ExperimentSurveySmokingInfoService experimentSurveySmokingInfoService
                , ExperimentSurveyPlateauFitnessInfoService experimentSurveyPlateauFitnessInfoService
                , ExperimentSurveyMedicalHistoryService experimentSurveyMedicalHistoryService
                , ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService
                , ExperimentSurveyMissionProgressSurveyService experimentSurveyMissionProgressSurveyService
                , ExperimentSurveyPlateauArrivalSymptomsService experimentSurveyPlateauArrivalSymptomsService
                , ExperimentSurveyAcuteMountainSicknessRecordsService experimentSurveyAcuteMountainSicknessRecordsService
                , ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService
                , ExperimentSurveyScoreSummaryService experimentSurveyScoreSummaryService
                , ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentSurveyBasicCheckInfoService = experimentSurveyBasicCheckInfoService;
            this.experimentSurveyStationTrainingInfoService = experimentSurveyStationTrainingInfoService;
            this.experimentSurveySmokingInfoService = experimentSurveySmokingInfoService;
            this.experimentSurveyPlateauFitnessInfoService = experimentSurveyPlateauFitnessInfoService;
            this.experimentSurveyMedicalHistoryService = experimentSurveyMedicalHistoryService;
            this.experimentSurveySelfAssessmentService = experimentSurveySelfAssessmentService;
            this.experimentSurveyMissionProgressSurveyService = experimentSurveyMissionProgressSurveyService;
            this.experimentSurveyPlateauArrivalSymptomsService = experimentSurveyPlateauArrivalSymptomsService;
            this.experimentSurveyAcuteMountainSicknessRecordsService = experimentSurveyAcuteMountainSicknessRecordsService;
            this.experimentSurveyHighlandDiseasesDuringServiceService = experimentSurveyHighlandDiseasesDuringServiceService;
            this.experimentSurveyScoreSummaryService = experimentSurveyScoreSummaryService;
            this.prospectiveExperimentSurveyPostReturnSymptomsService = prospectiveExperimentSurveyPostReturnSymptomsService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyBasicCheckInfoSaveReqVO experimentSurveyBasicCheckInfo = new ExperimentSurveyBasicCheckInfoSaveReqVO();
            ExperimentSurveyStationTrainingInfoSaveReqVO experimentSurveyStationTrainingInfo = new ExperimentSurveyStationTrainingInfoSaveReqVO();
            ExperimentSurveySmokingInfoSaveReqVO experimentSurveySmokingInfo = new ExperimentSurveySmokingInfoSaveReqVO();
            ExperimentSurveyPlateauFitnessInfoSaveReqVO experimentSurveyPlateauFitnessInfo = new ExperimentSurveyPlateauFitnessInfoSaveReqVO();
            ExperimentSurveyMedicalHistorySaveReqVO experimentSurveyMedicalHistory = new ExperimentSurveyMedicalHistorySaveReqVO();
            ExperimentSurveySelfAssessmentSaveReqVO experimentSurveySelfAssessment = new ExperimentSurveySelfAssessmentSaveReqVO();
            ExperimentSurveyMissionProgressSurveySaveReqVO experimentSurveyMissionProgressSurvey = new ExperimentSurveyMissionProgressSurveySaveReqVO();
            ExperimentSurveyPlateauArrivalSymptomsSaveReqVO experimentSurveyPlateauArrivalSymptoms = new ExperimentSurveyPlateauArrivalSymptomsSaveReqVO();
            ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO experimentSurveyAcuteMountainSicknessRecords = new ExperimentSurveyAcuteMountainSicknessRecordsSaveReqVO();
            ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO experimentSurveyHighlandDiseasesDuringService = new ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO();
            ExperimentSurveyScoreSummarySaveReqVO experimentSurveyScoreSummary = new ExperimentSurveyScoreSummarySaveReqVO();
            ExperimentSurveyPostReturnSymptomsSaveReqVO experimentSurveyPostReturnSymptoms = new ExperimentSurveyPostReturnSymptomsSaveReqVO();

            basicInfo.setCode(rowData.get(2)); // 编号
            basicInfo.setName(rowData.get(0)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("survey"); // 流调或体检
            basicInfo.setAge(extractNumberOrZero(rowData.get(3))); // 年龄
            basicInfo.setActualAge(extractNumberOrZero(rowData.get(4))); // 实际年龄
            basicInfo.setGender(rowData.get(5)); // 性别
            basicInfo.setBirthDate(rowData.get(12)); // 出生年月
            basicInfo.setPosition(rowData.get(13)); // 部职别
            basicInfo.setIdNumber(rowData.get(15)); // 证件号
            basicInfo.setTimePoint(3); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            experimentSurveyBasicCheckInfo.setPersonId(generatedId);
            experimentSurveyBasicCheckInfo.setSystolicBloodPressure(extractNumberOrZero(rowData.get(6))); // 收缩压
            experimentSurveyBasicCheckInfo.setDiastolicBloodPressure(extractNumberOrZero(rowData.get(7))); // 舒张压
            experimentSurveyBasicCheckInfo.setOxygenSaturation(extractNumberOrZero(rowData.get(8))); // 血氧饱和度
            experimentSurveyBasicCheckInfo.setHeartRate(extractNumberOrZero(rowData.get(9))); // 心率
            experimentSurveyBasicCheckInfo.setBasicHeight(extractNumberOrZero(rowData.get(10))); // 身高
            experimentSurveyBasicCheckInfo.setBasicWeight(extractNumberOrZero(rowData.get(11))); // 体重
            experimentSurveyBasicCheckInfo.setTimePoint(3); // 时相类型
            experimentSurveyBasicCheckInfoService.createExperimentSurveyBasicCheckInfo(experimentSurveyBasicCheckInfo);


            experimentSurveyStationTrainingInfo.setPersonId(generatedId);
            experimentSurveyStationTrainingInfo.setMissionPointAltitude(extractNumberOrZero(rowData.get(14))); // 任务点海拔
            experimentSurveyStationTrainingInfo.setPlateauTrainingDuration(extractNumberOrZero(rowData.get(16))); // 高原驻训总时长
            experimentSurveyStationTrainingInfo.setTimePoint(3); // 时相类型
            experimentSurveyStationTrainingInfoService.createExperimentSurveyStationTrainingInfo(experimentSurveyStationTrainingInfo);

            experimentSurveyMissionProgressSurvey.setPersonId(generatedId);
            experimentSurveyMissionProgressSurvey.setTransportationMode(rowData.get(17)); // 交通方式
            experimentSurveyMissionProgressSurvey.setReturnPurpose(rowData.get(18)); // 返回目的
            experimentSurveyMissionProgressSurvey.setArrivalDate(rowData.get(19)); // 到达日期
            experimentSurveyMissionProgressSurvey.setPlateauMissionDuration(parseDurationToMonths(rowData.get(20))); // 高原任务持续时间
            experimentSurveyMissionProgressSurvey.setTravelDuration(rowData.get(21)); // 推进途中耗费时间
            experimentSurveyMissionProgressSurvey.setHasStopover(parseBoolean(rowData.get(22))); // 是否有中途停留
            experimentSurveyMissionProgressSurvey.setStopoverLocation(rowData.get(23)); // 中途停留地点
            experimentSurveyMissionProgressSurvey.setHasDiscomfortAfterArrival(parseBoolean(rowData.get(24))); // 到达后是否有不适
            experimentSurveyMissionProgressSurvey.setTimePoint(3); // 时相类型
            experimentSurveyMissionProgressSurveyService.createExperimentSurveyMissionProgressSurvey(experimentSurveyMissionProgressSurvey);

            experimentSurveyPostReturnSymptoms.setPersonId(generatedId);
            experimentSurveyPostReturnSymptoms.setFatigue(parseInteger(rowData.get(25))); // 疲倦
            experimentSurveyPostReturnSymptoms.setFatigueDuration(rowData.get(26)); // 疲倦持续时间
            experimentSurveyPostReturnSymptoms.setWeakness(parseInteger(rowData.get(27))); // 乏力
            experimentSurveyPostReturnSymptoms.setWeaknessDuration(rowData.get(28)); // 乏力持续时间
            experimentSurveyPostReturnSymptoms.setDrowsiness(parseInteger(rowData.get(29))); // 嗜睡
            experimentSurveyPostReturnSymptoms.setDrowsinessDuration(rowData.get(30)); // 嗜睡持续时间
            experimentSurveyPostReturnSymptoms.setDizziness(parseInteger(rowData.get(31))); // 头昏
            experimentSurveyPostReturnSymptoms.setDizzinessDuration(rowData.get(32)); // 头昏持续时间
            experimentSurveyPostReturnSymptoms.setVertigo(parseInteger(rowData.get(33))); // 眩晕
            experimentSurveyPostReturnSymptoms.setVertigoDuration(rowData.get(34)); // 眩晕持续时间
            experimentSurveyPostReturnSymptoms.setPoorConcentration(parseInteger(rowData.get(35))); // 精力不集中
            experimentSurveyPostReturnSymptoms.setPoorConcentrationDuration(rowData.get(36)); // 精力不集中持续时间
            experimentSurveyPostReturnSymptoms.setSlowReaction(parseInteger(rowData.get(37))); // 反应迟钝
            experimentSurveyPostReturnSymptoms.setSlowReactionDuration(rowData.get(38)); // 反应迟钝持续时间
            experimentSurveyPostReturnSymptoms.setMemoryLoss(parseInteger(rowData.get(39))); // 记忆减退
            experimentSurveyPostReturnSymptoms.setMemoryLossDuration(rowData.get(40)); // 记忆减退持续时间
            experimentSurveyPostReturnSymptoms.setInsomnia(parseInteger(rowData.get(41))); // 失眠
            experimentSurveyPostReturnSymptoms.setInsomniaDuration(rowData.get(42)); // 失眠持续时间
            experimentSurveyPostReturnSymptoms.setNightmares(parseInteger(rowData.get(43))); // 多梦
            experimentSurveyPostReturnSymptoms.setNightmaresDuration(rowData.get(44)); // 多梦持续时间
            experimentSurveyPostReturnSymptoms.setSoreThroat(parseInteger(rowData.get(45))); // 咽喉痛
            experimentSurveyPostReturnSymptoms.setSoreThroatDuration(rowData.get(46)); // 咽喉痛持续时间
            experimentSurveyPostReturnSymptoms.setCough(parseInteger(rowData.get(47))); // 咳嗽
            experimentSurveyPostReturnSymptoms.setCoughDuration(rowData.get(48)); // 咳嗽持续时间
            experimentSurveyPostReturnSymptoms.setPhlegm(parseInteger(rowData.get(49))); // 多痰
            experimentSurveyPostReturnSymptoms.setPhlegmDuration(rowData.get(50)); // 多痰持续时间
            experimentSurveyPostReturnSymptoms.setWheezing(parseInteger(rowData.get(51))); // 气喘
            experimentSurveyPostReturnSymptoms.setWheezingDuration(rowData.get(52)); // 气喘持续时间
            experimentSurveyPostReturnSymptoms.setChestTightness(parseInteger(rowData.get(53))); // 胸闷
            experimentSurveyPostReturnSymptoms.setChestTightnessDuration(rowData.get(54)); // 胸闷持续时间
            experimentSurveyPostReturnSymptoms.setChestPain(parseInteger(rowData.get(55))); // 心前区痛
            experimentSurveyPostReturnSymptoms.setChestPainDuration(rowData.get(56)); // 心前区痛持续时间
            experimentSurveyPostReturnSymptoms.setPalpitations(parseInteger(rowData.get(57))); // 心慌
            experimentSurveyPostReturnSymptoms.setPalpitationsDuration(rowData.get(58)); // 心慌持续时间
            experimentSurveyPostReturnSymptoms.setBradycardia(parseInteger(rowData.get(59))); // 脉率减慢
            experimentSurveyPostReturnSymptoms.setBradycardiaDuration(rowData.get(60)); // 脉率减慢持续时间
            experimentSurveyPostReturnSymptoms.setCyanosis(parseInteger(rowData.get(61))); // 紫绀
            experimentSurveyPostReturnSymptoms.setCyanosisDuration(rowData.get(62)); // 紫绀持续时间
            experimentSurveyPostReturnSymptoms.setBloodPressureFluctuation(parseInteger(rowData.get(63))); // 血压波动
            experimentSurveyPostReturnSymptoms.setBloodPressureFluctuationDuration(rowData.get(64)); // 血压波动持续时间
            experimentSurveyPostReturnSymptoms.setSkinBleeding(parseInteger(rowData.get(65))); // 皮肤出血
            experimentSurveyPostReturnSymptoms.setSkinBleedingDuration(rowData.get(66)); // 皮肤出血持续时间
            experimentSurveyPostReturnSymptoms.setSkinBruising(parseInteger(rowData.get(67))); // 皮肤瘀斑
            experimentSurveyPostReturnSymptoms.setSkinBruisingDuration(rowData.get(68)); // 皮肤瘀斑持续时间
            experimentSurveyPostReturnSymptoms.setAnemia(parseInteger(rowData.get(69))); // 贫血
            experimentSurveyPostReturnSymptoms.setAnemiaDuration(rowData.get(70)); // 贫血持续时间
            experimentSurveyPostReturnSymptoms.setWeightLoss(parseInteger(rowData.get(71))); // 体重减轻
            experimentSurveyPostReturnSymptoms.setWeightLossDuration(rowData.get(72)); // 体重减轻持续时间
            experimentSurveyPostReturnSymptoms.setIncreasedAppetite(parseInteger(rowData.get(73))); // 食欲增加
            experimentSurveyPostReturnSymptoms.setIncreasedAppetiteDuration(rowData.get(74)); // 食欲增加持续时间
            experimentSurveyPostReturnSymptoms.setAnorexia(parseInteger(rowData.get(75))); // 厌食
            experimentSurveyPostReturnSymptoms.setAnorexiaDuration(rowData.get(76)); // 厌食持续时间
            experimentSurveyPostReturnSymptoms.setConstipation(parseInteger(rowData.get(77))); // 便秘
            experimentSurveyPostReturnSymptoms.setConstipationDuration(rowData.get(78)); // 便秘持续时间
            experimentSurveyPostReturnSymptoms.setDiarrhea(parseInteger(rowData.get(79))); // 腹泻
            experimentSurveyPostReturnSymptoms.setDiarrheaDuration(rowData.get(80)); // 腹泻持续时间
            experimentSurveyPostReturnSymptoms.setAbdominalPain(parseInteger(rowData.get(81))); // 腹痛
            experimentSurveyPostReturnSymptoms.setAbdominalPainDuration(rowData.get(82)); // 腹痛持续时间
            experimentSurveyPostReturnSymptoms.setAbdominalDistension(parseInteger(rowData.get(83))); // 腹胀
            experimentSurveyPostReturnSymptoms.setAbdominalDistensionDuration(rowData.get(84)); // 腹胀持续时间
            experimentSurveyPostReturnSymptoms.setJaundice(parseInteger(rowData.get(85))); // 黄疸
            experimentSurveyPostReturnSymptoms.setJaundiceDuration(rowData.get(86)); // 黄疸持续时间
            experimentSurveyPostReturnSymptoms.setNumbness(parseInteger(rowData.get(87))); // 手足麻木
            experimentSurveyPostReturnSymptoms.setNumbnessDuration(rowData.get(88)); // 手足麻木持续时间
            experimentSurveyPostReturnSymptoms.setLimbEdema(parseInteger(rowData.get(89))); // 肢体水肿
            experimentSurveyPostReturnSymptoms.setLimbEdemaDuration(rowData.get(90)); // 肢体水肿持续时间
            experimentSurveyPostReturnSymptoms.setFacialEdema(parseInteger(rowData.get(91))); // 面部水肿
            experimentSurveyPostReturnSymptoms.setFacialEdemaDuration(rowData.get(92)); // 面部水肿持续时间
            experimentSurveyPostReturnSymptoms.setHairLoss(parseInteger(rowData.get(93))); // 脱发
            experimentSurveyPostReturnSymptoms.setHairLossDuration(rowData.get(94)); // 脱发持续时间
            experimentSurveyPostReturnSymptoms.setIncreasedUrination(parseInteger(rowData.get(95))); // 夜尿增多
            experimentSurveyPostReturnSymptoms.setIncreasedUrinationDuration(rowData.get(96)); // 夜尿增多持续时间
            experimentSurveyPostReturnSymptoms.setOtherSymptoms(rowData.get(97)); // 返回后有无其他症状
            experimentSurveyPostReturnSymptoms.setTimePoint(3); // 时相类型
            prospectiveExperimentSurveyPostReturnSymptomsService.createExperimentSurveyPostReturnSymptoms(experimentSurveyPostReturnSymptoms);

            experimentSurveyScoreSummary.setPersonId(generatedId);
            experimentSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(98))); // 总分
            experimentSurveyScoreSummary.setTimePoint(3); // 时相类型
            experimentSurveyScoreSummaryService.createExperimentSurveyScoreSummary(experimentSurveyScoreSummary);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    //实验组体检---------------------------------------------------------------------------------------------------------
    @GetMapping("/importExperimentExam1")
    public String importExperimentExam1(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "D:\\Downloads\\检查-数据3\\36324-检查.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerExam1(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentExamBiochemicalTestsV2Service
                        , prospectiveExperimentExamBloodRoutineService
                        , experimentExamCoagulationTestsService
                        , experimentExamOtherDataService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet()
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerExam1 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;
        private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;
        private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;
        private ExperimentExamOtherDataService experimentExamOtherDataService;

        // 构造函数注入服务
        public IndexListenerExam1(String type,
                                  ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service
                , ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService
                , ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService
                , ExperimentExamOtherDataService experimentExamOtherDataService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentExamBiochemicalTestsV2Service = experimentExamBiochemicalTestsV2Service;
            this.prospectiveExperimentExamBloodRoutineService = prospectiveExperimentExamBloodRoutineService;
            this.experimentExamCoagulationTestsService = experimentExamCoagulationTestsService;
            this.experimentExamOtherDataService = experimentExamOtherDataService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentExamBiochemicalTestsV2SaveReqVO experimentExamBiochemicalTestsV2 = new ExperimentExamBiochemicalTestsV2SaveReqVO();
            ExperimentExamBloodRoutineSaveReqVO prospectiveExperimentExamBloodRoutine = new ExperimentExamBloodRoutineSaveReqVO();
            ExperimentExamCoagulationTestsSaveReqVO experimentExamCoagulationTests = new ExperimentExamCoagulationTestsSaveReqVO();
            ExperimentExamOtherDataSaveReqVO experimentExamOtherData = new ExperimentExamOtherDataSaveReqVO();

            basicInfo.setCode(rowData.get(1)); // 编号
            basicInfo.setName(rowData.get(2)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("exam"); // 流调或体检
            basicInfo.setTimePoint(1); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            experimentExamBiochemicalTestsV2.setPersonId(generatedId);
            experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(55))); // ALT
            experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(56))); // AST
            experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(57))); // 谷草转氨酶与谷丙转氨酶比值
            experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(58))); // 总蛋白
            experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(59))); // 白蛋白
            experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(60))); // 球蛋白
            experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(61))); // 白球比
            experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(62))); // 总胆红素
            experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(63))); // 直接胆红素
            experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(64))); // 间接胆红素
            experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(65))); // 碱性磷酸酶
            experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(66))); // 谷氨酰转肽酶
            experimentExamBiochemicalTestsV2.setTotalBileAcid(parseBigDecimal(rowData.get(67))); // 总胆汁酸
            experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(68))); // 胆碱酯酶
            experimentExamBiochemicalTestsV2.setPrealbumin(parseBigDecimal(rowData.get(69))); // 前白蛋白
            experimentExamBiochemicalTestsV2.setUrea(parseBigDecimal(rowData.get(70))); // 尿素
            experimentExamBiochemicalTestsV2.setCreatinine(parseBigDecimal(rowData.get(71))); // 肌酐
            experimentExamBiochemicalTestsV2.setUricAcid(parseBigDecimal(rowData.get(72))); // 尿酸
            experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(73))); // 甘油三酯
            experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(74))); // 胆固醇
            experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(75))); // 高密度脂蛋白
            experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(76))); // 低密度脂蛋白
            experimentExamBiochemicalTestsV2.setApoa(parseBigDecimal(rowData.get(77))); // 载脂蛋白A
            experimentExamBiochemicalTestsV2.setApob(parseBigDecimal(rowData.get(78))); // 载脂蛋白B
            experimentExamBiochemicalTestsV2.setLpa(parseBigDecimal(rowData.get(79))); // 脂蛋白a
            experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(80))); // 葡萄糖
            experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(81))); // 肌酸激酶
            experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(82))); // 肌酸激酶同工酶MB
            experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(83))); // α-羟丁酸脱氢酶
            experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(84))); // 乳酸脱氢酶
            experimentExamBiochemicalTestsV2.setCrp(parseBigDecimal(rowData.get(85))); // C-反应蛋白
            experimentExamBiochemicalTestsV2.setIgg(parseBigDecimal(rowData.get(86))); // 免疫球蛋白G
            experimentExamBiochemicalTestsV2.setIga(parseBigDecimal(rowData.get(87))); // 免疫球蛋白A
            experimentExamBiochemicalTestsV2.setIgm(parseBigDecimal(rowData.get(88))); // 免疫球蛋白M
            experimentExamBiochemicalTestsV2.setComplement3(parseBigDecimal(rowData.get(89))); // 补体3
            experimentExamBiochemicalTestsV2.setComplement4(parseBigDecimal(rowData.get(90))); // 补体4
            experimentExamBiochemicalTestsV2.setMyoglobin(parseBigDecimal(rowData.get(91))); // 肌红蛋白
            experimentExamBiochemicalTestsV2.setSmallDenseLdl(parseBigDecimal(rowData.get(92))); // 小而密低密度脂蛋白
            experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(93))); // 同型半胱氨酸
            experimentExamBiochemicalTestsV2.setNucleotidase(parseBigDecimal(rowData.get(94))); // 5-核苷酸酶
            experimentExamBiochemicalTestsV2.setAda(parseBigDecimal(rowData.get(95))); // 腺苷脱氨酶
            experimentExamBiochemicalTestsV2.setAmylase(parseBigDecimal(rowData.get(96))); // 淀粉酶
            experimentExamBiochemicalTestsV2.setAnionGap(parseBigDecimal(rowData.get(97))); // 阴离子间隙
            experimentExamBiochemicalTestsV2.setBufferBase(parseBigDecimal(rowData.get(98))); // 缓冲碱
            experimentExamBiochemicalTestsV2.setBicarbonate(parseBigDecimal(rowData.get(99))); // 碳酸氢盐
            experimentExamBiochemicalTestsV2.setBaseExcess(parseBigDecimal(rowData.get(100))); // 碱剩余
            experimentExamBiochemicalTestsV2.setExtracellularBe(parseBigDecimal(rowData.get(101))); // 细胞外液碱剩余
            experimentExamBiochemicalTestsV2.setBloodUrea(parseBigDecimal(rowData.get(102))); // 血尿素
            experimentExamBiochemicalTestsV2.setBun(parseBigDecimal(rowData.get(103))); // 血尿素氮
            experimentExamBiochemicalTestsV2.setCalcium(parseBigDecimal(rowData.get(104))); // 钙
            experimentExamBiochemicalTestsV2.setChloride(parseBigDecimal(rowData.get(105))); // 氯
            experimentExamBiochemicalTestsV2.setCystatinC(parseBigDecimal(rowData.get(106))); // 胱抑素C
            experimentExamBiochemicalTestsV2.setIron(parseBigDecimal(rowData.get(107))); // 铁
            experimentExamBiochemicalTestsV2.setActualBicarbonate(parseBigDecimal(rowData.get(108))); // 实际碳酸氢盐
            experimentExamBiochemicalTestsV2.setStandardBicarbonate(parseBigDecimal(rowData.get(109))); // 标准碳酸氢盐
            experimentExamBiochemicalTestsV2.setPotassium(parseBigDecimal(rowData.get(110))); // 钾
            experimentExamBiochemicalTestsV2.setMagnesium(parseBigDecimal(rowData.get(111))); // 镁
            experimentExamBiochemicalTestsV2.setSodium(parseBigDecimal(rowData.get(112))); // 钠
            experimentExamBiochemicalTestsV2.setPhosphorus(parseBigDecimal(rowData.get(113))); // 磷
            experimentExamBiochemicalTestsV2.setPco2(parseBigDecimal(rowData.get(114))); // 二氧化碳分压
            experimentExamBiochemicalTestsV2.setPh(parseBigDecimal(rowData.get(115))); // 酸碱度
            experimentExamBiochemicalTestsV2.setPo2(parseBigDecimal(rowData.get(116))); // 氧分压
            experimentExamBiochemicalTestsV2.setRbp(parseBigDecimal(rowData.get(117))); // 视黄醇结合蛋白
            experimentExamBiochemicalTestsV2.setReninActivity(parseBigDecimal(rowData.get(118))); // 肾素活性
            experimentExamBiochemicalTestsV2.setHydrogenIonConcentration(parseBigDecimal(rowData.get(119))); // 氢离子浓度
            experimentExamBiochemicalTestsV2.setTco2(parseBigDecimal(rowData.get(120))); // 二氧化碳总量
            experimentExamBiochemicalTestsV2.setLacticAcid(parseBigDecimal(rowData.get(121))); // 乳酸
            experimentExamBiochemicalTestsV2.setMicroalbumin(parseBigDecimal(rowData.get(122))); // 微量白蛋白
            experimentExamBiochemicalTestsV2.setPlasmaOsmoticPressure(parseBigDecimal(rowData.get(123))); // 血浆渗透压
            experimentExamBiochemicalTestsV2.setAAGradient(parseBigDecimal(rowData.get(124))); // 肺泡-动脉血氧分压差
            experimentExamBiochemicalTestsV2.setAARatio(parseBigDecimal(rowData.get(125))); // 动脉-肺泡氧分压比值
            experimentExamBiochemicalTestsV2.setOxygenationIndex(parseBigDecimal(rowData.get(126))); // 氧合指数
            experimentExamBiochemicalTestsV2.setEstimatedSpo2(parseBigDecimal(rowData.get(127))); // 估计血氧饱和度
            experimentExamBiochemicalTestsV2.setEstimatedHb(parseBigDecimal(rowData.get(128))); // 估计总血红蛋白
            experimentExamBiochemicalTestsV2.setBeta2Microglobulin(parseBigDecimal(rowData.get(129))); // β2-微球蛋白
            experimentExamBiochemicalTestsV2.setHsCrp(parseBigDecimal(rowData.get(130))); // 超敏C反应蛋白
            experimentExamBiochemicalTestsV2.setHbsag(parseBigDecimal(rowData.get(131))); // 乙肝表面抗原
            experimentExamBiochemicalTestsV2.setAntiHbs(parseBigDecimal(rowData.get(132))); // 乙肝表面抗体
            experimentExamBiochemicalTestsV2.setHbeag(parseBigDecimal(rowData.get(133))); // 乙肝e抗原
            experimentExamBiochemicalTestsV2.setAntiHbe(parseBigDecimal(rowData.get(134))); // 乙肝e抗体
            experimentExamBiochemicalTestsV2.setAntiHbc(parseBigDecimal(rowData.get(135))); // 乙肝核心抗体
            experimentExamBiochemicalTestsV2.setTotalCholesterol(parseBigDecimal(rowData.get(136))); // 总胆固醇
            experimentExamBiochemicalTestsV2.setIma(parseBigDecimal(rowData.get(137))); // 缺血修饰白蛋白
            experimentExamBiochemicalTestsV2.setAfucosidase(parseBigDecimal(rowData.get(138))); // α-L-岩藻糖苷酶
            experimentExamBiochemicalTestsV2.setTimePoint(1); // 时相
            experimentExamBiochemicalTestsV2Service.createExperimentExamBiochemicalTestsV2(experimentExamBiochemicalTestsV2);

            prospectiveExperimentExamBloodRoutine.setPersonId(generatedId);
            prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(22))); // 白细胞计数
            prospectiveExperimentExamBloodRoutine.setLymphocytePercent(parseBigDecimal(rowData.get(23))); // 淋巴细胞百分比
            prospectiveExperimentExamBloodRoutine.setMidCellPercent(parseBigDecimal(rowData.get(24))); // 中间细胞百分比
            prospectiveExperimentExamBloodRoutine.setGranulocytePercent(parseBigDecimal(rowData.get(25))); // 粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setLymphocyteCount(parseBigDecimal(rowData.get(26))); // 淋巴细胞计数
            prospectiveExperimentExamBloodRoutine.setMidCellCount(parseBigDecimal(rowData.get(27))); // 中间细胞计数
            prospectiveExperimentExamBloodRoutine.setGranulocyteCount(parseBigDecimal(rowData.get(28))); // 粒细胞计数
            prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(29))); // 红细胞计数
            prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(30))); // 血红蛋白
            prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(31))); // 血细胞比容
            prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(32))); // 平均红细胞体积
            prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(33))); // 平均红细胞血红蛋白含量
            prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(34))); // 平均红细胞血红蛋白浓度
            prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(35))); // 红细胞分布宽度变异系数
            prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(36))); // 红细胞分布宽度标准差
            prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(37))); // 血小板计数
            prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(38))); // 平均血小板体积
            prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(39))); // 血小板分布宽度
            prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(40))); // 血小板压积
            prospectiveExperimentExamBloodRoutine.setLargePlateletRatio(parseBigDecimal(rowData.get(41))); // 大血小板比率
            prospectiveExperimentExamBloodRoutine.setLargePlateletCount(parseBigDecimal(rowData.get(42))); // 大血小板计数
            prospectiveExperimentExamBloodRoutine.setBasophilCount(parseBigDecimal(rowData.get(43))); // 嗜碱性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setBasophilPercent(parseBigDecimal(rowData.get(44))); // 嗜碱性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setEosinophilCount(parseBigDecimal(rowData.get(45))); // 嗜酸性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setEosinophilPercent(parseBigDecimal(rowData.get(46))); // 嗜酸性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocyteCount(parseBigDecimal(rowData.get(47))); // 幼稚粒细胞计数
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocytePercent(parseBigDecimal(rowData.get(48))); // 幼稚粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setMonocyteCount(parseBigDecimal(rowData.get(49))); // 单核细胞计数
            prospectiveExperimentExamBloodRoutine.setMonocytePercent(parseBigDecimal(rowData.get(50))); // 单核细胞百分比
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcCount(parseBigDecimal(rowData.get(51))); // 有核红细胞计数
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcPercent(parseBigDecimal(rowData.get(52))); // 有核红细胞百分比
            prospectiveExperimentExamBloodRoutine.setNeutrophilCount(parseBigDecimal(rowData.get(53))); // 中性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setNeutrophilPercent(parseBigDecimal(rowData.get(54))); // 中性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setTimePoint(1); // 时相
            prospectiveExperimentExamBloodRoutineService.createExperimentExamBloodRoutine(prospectiveExperimentExamBloodRoutine);

            experimentExamCoagulationTests.setPersonId(generatedId);
            experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(3))); // 活化部分凝血活酶时间
            experimentExamCoagulationTests.setAntithrombinIiiActivityPercent(parseBigDecimal(rowData.get(4))); // 抗凝血酶Ⅲ活性百分比
            experimentExamCoagulationTests.setAntithrombinIiiActivityRate(parseBigDecimal(rowData.get(5))); // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
            experimentExamCoagulationTests.setDDimerOptDensity(parseBigDecimal(rowData.get(6))); // D-二聚体（光密度差值检测）
            experimentExamCoagulationTests.setDDimerConcentration(parseBigDecimal(rowData.get(7))); // D-二聚体浓度
            experimentExamCoagulationTests.setFibrinDegradationProductsDensity(parseBigDecimal(rowData.get(8))); // 纤维蛋白降解产物（光密度差值检测）
            experimentExamCoagulationTests.setFibrinDegradationProductsConcentration(parseBigDecimal(rowData.get(9))); // 纤维蛋白降解产物浓度
            experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(10))); // 纤维蛋白原浓度
            experimentExamCoagulationTests.setFibrinogenClottingTime(parseBigDecimal(rowData.get(11))); // 纤维蛋白原凝固时间
            experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(12))); // 凝血酶原时间(百分比活动度)
            experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(13))); // 凝血酶原时间-国际标准化比值
            experimentExamCoagulationTests.setProthrombinTimeRatio(parseBigDecimal(rowData.get(14))); // 凝血酶原时间比值
            experimentExamCoagulationTests.setProthrombinTime(parseBigDecimal(rowData.get(15))); // 凝血酶原时间
            experimentExamCoagulationTests.setThrombinTime(parseBigDecimal(rowData.get(16))); // 凝血酶时间
            experimentExamCoagulationTests.setThrombinTime1(parseBigDecimal(rowData.get(17))); // 凝血酶时间(1)
            experimentExamCoagulationTests.setAptt1(parseBigDecimal(rowData.get(18))); // 活化部分凝血活酶时间(1)
            experimentExamCoagulationTests.setAptt2(parseBigDecimal(rowData.get(19))); // 活化部分凝血活酶时间(2)
            experimentExamCoagulationTests.setProthrombinActivity(parseBigDecimal(rowData.get(20))); // 凝血酶原活动度
            experimentExamCoagulationTests.setInr(parseBigDecimal(rowData.get(21))); // 国际标准化比值
            experimentExamCoagulationTests.setTimePoint(1); // 时相
            experimentExamCoagulationTestsService.createExperimentExamCoagulationTests(experimentExamCoagulationTests);

            experimentExamOtherData.setPersonId(generatedId);
            experimentExamOtherData.setCardiacTroponinI(rowData.get(139));
            experimentExamOtherData.setTimePoint(1);
            experimentExamOtherDataService.createExperimentExamOtherData(experimentExamOtherData);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentExam2")
    public String importExperimentExam2(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "D:\\Downloads\\检查-数据3\\36324-检查.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerExam2(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentExamBiochemicalTestsV2Service
                        , prospectiveExperimentExamBloodRoutineService
                        , experimentExamCoagulationTestsService
                        , experimentExamOtherDataService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(1)
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerExam2 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;
        private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;
        private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;
        private ExperimentExamOtherDataService experimentExamOtherDataService;

        // 构造函数注入服务
        public IndexListenerExam2(String type,
                                  ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service
                , ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService
                , ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService
                , ExperimentExamOtherDataService experimentExamOtherDataService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentExamBiochemicalTestsV2Service = experimentExamBiochemicalTestsV2Service;
            this.prospectiveExperimentExamBloodRoutineService = prospectiveExperimentExamBloodRoutineService;
            this.experimentExamCoagulationTestsService = experimentExamCoagulationTestsService;
            this.experimentExamOtherDataService = experimentExamOtherDataService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentExamBiochemicalTestsV2SaveReqVO experimentExamBiochemicalTestsV2 = new ExperimentExamBiochemicalTestsV2SaveReqVO();
            ExperimentExamBloodRoutineSaveReqVO prospectiveExperimentExamBloodRoutine = new ExperimentExamBloodRoutineSaveReqVO();
            ExperimentExamCoagulationTestsSaveReqVO experimentExamCoagulationTests = new ExperimentExamCoagulationTestsSaveReqVO();
            ExperimentExamOtherDataSaveReqVO experimentExamOtherData = new ExperimentExamOtherDataSaveReqVO();

            basicInfo.setCode(rowData.get(1)); // 编号
            basicInfo.setName(rowData.get(2)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组, vip:VIP组)
            basicInfo.setSurveyOrExam("exam"); // 流调或体检
            basicInfo.setTimePoint(2); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            experimentExamBiochemicalTestsV2.setPersonId(generatedId);
            experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(55))); // ALT
            experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(56))); // AST
            experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(57))); // 谷草转氨酶与谷丙转氨酶比值
            experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(58))); // 总蛋白
            experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(59))); // 白蛋白
            experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(60))); // 球蛋白
            experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(61))); // 白球比
            experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(62))); // 总胆红素
            experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(63))); // 直接胆红素
            experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(64))); // 间接胆红素
            experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(65))); // 碱性磷酸酶
            experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(66))); // 谷氨酰转肽酶
            experimentExamBiochemicalTestsV2.setTotalBileAcid(parseBigDecimal(rowData.get(67))); // 总胆汁酸
            experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(68))); // 胆碱酯酶
            experimentExamBiochemicalTestsV2.setPrealbumin(parseBigDecimal(rowData.get(69))); // 前白蛋白
            experimentExamBiochemicalTestsV2.setUrea(parseBigDecimal(rowData.get(70))); // 尿素
            experimentExamBiochemicalTestsV2.setCreatinine(parseBigDecimal(rowData.get(71))); // 肌酐
            experimentExamBiochemicalTestsV2.setUricAcid(parseBigDecimal(rowData.get(72))); // 尿酸
            experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(73))); // 甘油三酯
            experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(74))); // 胆固醇
            experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(75))); // 高密度脂蛋白
            experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(76))); // 低密度脂蛋白
            experimentExamBiochemicalTestsV2.setApoa(parseBigDecimal(rowData.get(77))); // 载脂蛋白A
            experimentExamBiochemicalTestsV2.setApob(parseBigDecimal(rowData.get(78))); // 载脂蛋白B
            experimentExamBiochemicalTestsV2.setLpa(parseBigDecimal(rowData.get(79))); // 脂蛋白a
            experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(80))); // 葡萄糖
            experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(81))); // 肌酸激酶
            experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(82))); // 肌酸激酶同工酶MB
            experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(83))); // α-羟丁酸脱氢酶
            experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(84))); // 乳酸脱氢酶
            experimentExamBiochemicalTestsV2.setCrp(parseBigDecimal(rowData.get(85))); // C-反应蛋白
            experimentExamBiochemicalTestsV2.setIgg(parseBigDecimal(rowData.get(86))); // 免疫球蛋白G
            experimentExamBiochemicalTestsV2.setIga(parseBigDecimal(rowData.get(87))); // 免疫球蛋白A
            experimentExamBiochemicalTestsV2.setIgm(parseBigDecimal(rowData.get(88))); // 免疫球蛋白M
            experimentExamBiochemicalTestsV2.setComplement3(parseBigDecimal(rowData.get(89))); // 补体3
            experimentExamBiochemicalTestsV2.setComplement4(parseBigDecimal(rowData.get(90))); // 补体4
            experimentExamBiochemicalTestsV2.setMyoglobin(parseBigDecimal(rowData.get(91))); // 肌红蛋白
            experimentExamBiochemicalTestsV2.setSmallDenseLdl(parseBigDecimal(rowData.get(92))); // 小而密低密度脂蛋白
            experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(93))); // 同型半胱氨酸
            experimentExamBiochemicalTestsV2.setNucleotidase(parseBigDecimal(rowData.get(94))); // 5-核苷酸酶
            experimentExamBiochemicalTestsV2.setAda(parseBigDecimal(rowData.get(95))); // 腺苷脱氨酶
            experimentExamBiochemicalTestsV2.setAmylase(parseBigDecimal(rowData.get(96))); // 淀粉酶
            experimentExamBiochemicalTestsV2.setAnionGap(parseBigDecimal(rowData.get(97))); // 阴离子间隙
            experimentExamBiochemicalTestsV2.setBufferBase(parseBigDecimal(rowData.get(98))); // 缓冲碱
            experimentExamBiochemicalTestsV2.setBicarbonate(parseBigDecimal(rowData.get(99))); // 碳酸氢盐
            experimentExamBiochemicalTestsV2.setBaseExcess(parseBigDecimal(rowData.get(100))); // 碱剩余
            experimentExamBiochemicalTestsV2.setExtracellularBe(parseBigDecimal(rowData.get(101))); // 细胞外液碱剩余
            experimentExamBiochemicalTestsV2.setBloodUrea(parseBigDecimal(rowData.get(102))); // 血尿素
            experimentExamBiochemicalTestsV2.setBun(parseBigDecimal(rowData.get(103))); // 血尿素氮
            experimentExamBiochemicalTestsV2.setCalcium(parseBigDecimal(rowData.get(104))); // 钙
            experimentExamBiochemicalTestsV2.setChloride(parseBigDecimal(rowData.get(105))); // 氯
            experimentExamBiochemicalTestsV2.setCystatinC(parseBigDecimal(rowData.get(106))); // 胱抑素C
            experimentExamBiochemicalTestsV2.setIron(parseBigDecimal(rowData.get(107))); // 铁
            experimentExamBiochemicalTestsV2.setActualBicarbonate(parseBigDecimal(rowData.get(108))); // 实际碳酸氢盐
            experimentExamBiochemicalTestsV2.setStandardBicarbonate(parseBigDecimal(rowData.get(109))); // 标准碳酸氢盐
            experimentExamBiochemicalTestsV2.setPotassium(parseBigDecimal(rowData.get(110))); // 钾
            experimentExamBiochemicalTestsV2.setMagnesium(parseBigDecimal(rowData.get(111))); // 镁
            experimentExamBiochemicalTestsV2.setSodium(parseBigDecimal(rowData.get(112))); // 钠
            experimentExamBiochemicalTestsV2.setPhosphorus(parseBigDecimal(rowData.get(113))); // 磷
            experimentExamBiochemicalTestsV2.setPco2(parseBigDecimal(rowData.get(114))); // 二氧化碳分压
            experimentExamBiochemicalTestsV2.setPh(parseBigDecimal(rowData.get(115))); // 酸碱度
            experimentExamBiochemicalTestsV2.setPo2(parseBigDecimal(rowData.get(116))); // 氧分压
            experimentExamBiochemicalTestsV2.setRbp(parseBigDecimal(rowData.get(117))); // 视黄醇结合蛋白
            experimentExamBiochemicalTestsV2.setReninActivity(parseBigDecimal(rowData.get(118))); // 肾素活性
            experimentExamBiochemicalTestsV2.setHydrogenIonConcentration(parseBigDecimal(rowData.get(119))); // 氢离子浓度
            experimentExamBiochemicalTestsV2.setTco2(parseBigDecimal(rowData.get(120))); // 二氧化碳总量
            experimentExamBiochemicalTestsV2.setLacticAcid(parseBigDecimal(rowData.get(121))); // 乳酸
            experimentExamBiochemicalTestsV2.setMicroalbumin(parseBigDecimal(rowData.get(122))); // 微量白蛋白
            experimentExamBiochemicalTestsV2.setPlasmaOsmoticPressure(parseBigDecimal(rowData.get(123))); // 血浆渗透压
            experimentExamBiochemicalTestsV2.setAAGradient(parseBigDecimal(rowData.get(124))); // 肺泡-动脉血氧分压差
            experimentExamBiochemicalTestsV2.setAARatio(parseBigDecimal(rowData.get(125))); // 动脉-肺泡氧分压比值
            experimentExamBiochemicalTestsV2.setOxygenationIndex(parseBigDecimal(rowData.get(126))); // 氧合指数
            experimentExamBiochemicalTestsV2.setEstimatedSpo2(parseBigDecimal(rowData.get(127))); // 估计血氧饱和度
            experimentExamBiochemicalTestsV2.setEstimatedHb(parseBigDecimal(rowData.get(128))); // 估计总血红蛋白
            experimentExamBiochemicalTestsV2.setBeta2Microglobulin(parseBigDecimal(rowData.get(129))); // β2-微球蛋白
            experimentExamBiochemicalTestsV2.setHsCrp(parseBigDecimal(rowData.get(130))); // 超敏C反应蛋白
            experimentExamBiochemicalTestsV2.setHbsag(parseBigDecimal(rowData.get(131))); // 乙肝表面抗原
            experimentExamBiochemicalTestsV2.setAntiHbs(parseBigDecimal(rowData.get(132))); // 乙肝表面抗体
            experimentExamBiochemicalTestsV2.setHbeag(parseBigDecimal(rowData.get(133))); // 乙肝e抗原
            experimentExamBiochemicalTestsV2.setAntiHbe(parseBigDecimal(rowData.get(134))); // 乙肝e抗体
            experimentExamBiochemicalTestsV2.setAntiHbc(parseBigDecimal(rowData.get(135))); // 乙肝核心抗体
            experimentExamBiochemicalTestsV2.setTotalCholesterol(parseBigDecimal(rowData.get(136))); // 总胆固醇
            experimentExamBiochemicalTestsV2.setIma(parseBigDecimal(rowData.get(137))); // 缺血修饰白蛋白
            experimentExamBiochemicalTestsV2.setAfucosidase(parseBigDecimal(rowData.get(138))); // α-L-岩藻糖苷酶
            experimentExamBiochemicalTestsV2.setTimePoint(2); // 时相
            experimentExamBiochemicalTestsV2Service.createExperimentExamBiochemicalTestsV2(experimentExamBiochemicalTestsV2);

            prospectiveExperimentExamBloodRoutine.setPersonId(generatedId);
            prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(22))); // 白细胞计数
            prospectiveExperimentExamBloodRoutine.setLymphocytePercent(parseBigDecimal(rowData.get(23))); // 淋巴细胞百分比
            prospectiveExperimentExamBloodRoutine.setMidCellPercent(parseBigDecimal(rowData.get(24))); // 中间细胞百分比
            prospectiveExperimentExamBloodRoutine.setGranulocytePercent(parseBigDecimal(rowData.get(25))); // 粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setLymphocyteCount(parseBigDecimal(rowData.get(26))); // 淋巴细胞计数
            prospectiveExperimentExamBloodRoutine.setMidCellCount(parseBigDecimal(rowData.get(27))); // 中间细胞计数
            prospectiveExperimentExamBloodRoutine.setGranulocyteCount(parseBigDecimal(rowData.get(28))); // 粒细胞计数
            prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(29))); // 红细胞计数
            prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(30))); // 血红蛋白
            prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(31))); // 血细胞比容
            prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(32))); // 平均红细胞体积
            prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(33))); // 平均红细胞血红蛋白含量
            prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(34))); // 平均红细胞血红蛋白浓度
            prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(35))); // 红细胞分布宽度变异系数
            prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(36))); // 红细胞分布宽度标准差
            prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(37))); // 血小板计数
            prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(38))); // 平均血小板体积
            prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(39))); // 血小板分布宽度
            prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(40))); // 血小板压积
            prospectiveExperimentExamBloodRoutine.setLargePlateletRatio(parseBigDecimal(rowData.get(41))); // 大血小板比率
            prospectiveExperimentExamBloodRoutine.setLargePlateletCount(parseBigDecimal(rowData.get(42))); // 大血小板计数
            prospectiveExperimentExamBloodRoutine.setBasophilCount(parseBigDecimal(rowData.get(43))); // 嗜碱性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setBasophilPercent(parseBigDecimal(rowData.get(44))); // 嗜碱性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setEosinophilCount(parseBigDecimal(rowData.get(45))); // 嗜酸性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setEosinophilPercent(parseBigDecimal(rowData.get(46))); // 嗜酸性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocyteCount(parseBigDecimal(rowData.get(47))); // 幼稚粒细胞计数
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocytePercent(parseBigDecimal(rowData.get(48))); // 幼稚粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setMonocyteCount(parseBigDecimal(rowData.get(49))); // 单核细胞计数
            prospectiveExperimentExamBloodRoutine.setMonocytePercent(parseBigDecimal(rowData.get(50))); // 单核细胞百分比
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcCount(parseBigDecimal(rowData.get(51))); // 有核红细胞计数
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcPercent(parseBigDecimal(rowData.get(52))); // 有核红细胞百分比
            prospectiveExperimentExamBloodRoutine.setNeutrophilCount(parseBigDecimal(rowData.get(53))); // 中性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setNeutrophilPercent(parseBigDecimal(rowData.get(54))); // 中性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setTimePoint(2); // 时相
            prospectiveExperimentExamBloodRoutineService.createExperimentExamBloodRoutine(prospectiveExperimentExamBloodRoutine);

            experimentExamCoagulationTests.setPersonId(generatedId);
            experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(3))); // 活化部分凝血活酶时间
            experimentExamCoagulationTests.setAntithrombinIiiActivityPercent(parseBigDecimal(rowData.get(4))); // 抗凝血酶Ⅲ活性百分比
            experimentExamCoagulationTests.setAntithrombinIiiActivityRate(parseBigDecimal(rowData.get(5))); // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
            experimentExamCoagulationTests.setDDimerOptDensity(parseBigDecimal(rowData.get(6))); // D-二聚体（光密度差值检测）
            experimentExamCoagulationTests.setDDimerConcentration(parseBigDecimal(rowData.get(7))); // D-二聚体浓度
            experimentExamCoagulationTests.setFibrinDegradationProductsDensity(parseBigDecimal(rowData.get(8))); // 纤维蛋白降解产物（光密度差值检测）
            experimentExamCoagulationTests.setFibrinDegradationProductsConcentration(parseBigDecimal(rowData.get(9))); // 纤维蛋白降解产物浓度
            experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(10))); // 纤维蛋白原浓度
            experimentExamCoagulationTests.setFibrinogenClottingTime(parseBigDecimal(rowData.get(11))); // 纤维蛋白原凝固时间
            experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(12))); // 凝血酶原时间(百分比活动度)
            experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(13))); // 凝血酶原时间-国际标准化比值
            experimentExamCoagulationTests.setProthrombinTimeRatio(parseBigDecimal(rowData.get(14))); // 凝血酶原时间比值
            experimentExamCoagulationTests.setProthrombinTime(parseBigDecimal(rowData.get(15))); // 凝血酶原时间
            experimentExamCoagulationTests.setThrombinTime(parseBigDecimal(rowData.get(16))); // 凝血酶时间
            experimentExamCoagulationTests.setThrombinTime1(parseBigDecimal(rowData.get(17))); // 凝血酶时间(1)
            experimentExamCoagulationTests.setAptt1(parseBigDecimal(rowData.get(18))); // 活化部分凝血活酶时间(1)
            experimentExamCoagulationTests.setAptt2(parseBigDecimal(rowData.get(19))); // 活化部分凝血活酶时间(2)
            experimentExamCoagulationTests.setProthrombinActivity(parseBigDecimal(rowData.get(20))); // 凝血酶原活动度
            experimentExamCoagulationTests.setInr(parseBigDecimal(rowData.get(21))); // 国际标准化比值
            experimentExamCoagulationTests.setTimePoint(2); // 时相
            experimentExamCoagulationTestsService.createExperimentExamCoagulationTests(experimentExamCoagulationTests);

            experimentExamOtherData.setPersonId(generatedId);
            experimentExamOtherData.setCardiacTroponinI(rowData.get(139));
            experimentExamOtherData.setVascularUltrasoundResult(rowData.get(140));
            experimentExamOtherData.setTimePoint(2);
            experimentExamOtherDataService.createExperimentExamOtherData(experimentExamOtherData);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExperimentExam3")
    public String importExperimentExam3(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "D:\\Downloads\\检查-数据3\\36324-检查.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerExam3(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , experimentExamBiochemicalTestsV2Service
                        , prospectiveExperimentExamBloodRoutineService
                        , experimentExamCoagulationTestsService
                        , experimentExamOtherDataService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(2)
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerExam3 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service;
        private ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService;
        private ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService;
        private ExperimentExamOtherDataService experimentExamOtherDataService;

        // 构造函数注入服务
        public IndexListenerExam3(String type,
                                  ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ExperimentExamBiochemicalTestsV2Service experimentExamBiochemicalTestsV2Service
                , ProspectiveExperimentExamBloodRoutineService prospectiveExperimentExamBloodRoutineService
                , ExperimentExamCoagulationTestsService experimentExamCoagulationTestsService
                , ExperimentExamOtherDataService experimentExamOtherDataService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.experimentExamBiochemicalTestsV2Service = experimentExamBiochemicalTestsV2Service;
            this.prospectiveExperimentExamBloodRoutineService = prospectiveExperimentExamBloodRoutineService;
            this.experimentExamCoagulationTestsService = experimentExamCoagulationTestsService;
            this.experimentExamOtherDataService = experimentExamOtherDataService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentExamBiochemicalTestsV2SaveReqVO experimentExamBiochemicalTestsV2 = new ExperimentExamBiochemicalTestsV2SaveReqVO();
            ExperimentExamBloodRoutineSaveReqVO prospectiveExperimentExamBloodRoutine = new ExperimentExamBloodRoutineSaveReqVO();
            ExperimentExamCoagulationTestsSaveReqVO experimentExamCoagulationTests = new ExperimentExamCoagulationTestsSaveReqVO();
            ExperimentExamOtherDataSaveReqVO experimentExamOtherData = new ExperimentExamOtherDataSaveReqVO();

            basicInfo.setCode(rowData.get(1)); // 编号
            basicInfo.setName(rowData.get(2)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("1"); // 组别类型(1:实验组, 2:对照组, vip:VIP组)
            basicInfo.setSurveyOrExam("exam"); // 流调或体检
            basicInfo.setTimePoint(3); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            experimentExamBiochemicalTestsV2.setPersonId(generatedId);
            experimentExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(55))); // ALT
            experimentExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(56))); // AST
            experimentExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(57))); // 谷草转氨酶与谷丙转氨酶比值
            experimentExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(58))); // 总蛋白
            experimentExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(59))); // 白蛋白
            experimentExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(60))); // 球蛋白
            experimentExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(61))); // 白球比
            experimentExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(62))); // 总胆红素
            experimentExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(63))); // 直接胆红素
            experimentExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(64))); // 间接胆红素
            experimentExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(65))); // 碱性磷酸酶
            experimentExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(66))); // 谷氨酰转肽酶
            experimentExamBiochemicalTestsV2.setTotalBileAcid(parseBigDecimal(rowData.get(67))); // 总胆汁酸
            experimentExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(68))); // 胆碱酯酶
            experimentExamBiochemicalTestsV2.setPrealbumin(parseBigDecimal(rowData.get(69))); // 前白蛋白
            experimentExamBiochemicalTestsV2.setUrea(parseBigDecimal(rowData.get(70))); // 尿素
            experimentExamBiochemicalTestsV2.setCreatinine(parseBigDecimal(rowData.get(71))); // 肌酐
            experimentExamBiochemicalTestsV2.setUricAcid(parseBigDecimal(rowData.get(72))); // 尿酸
            experimentExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(73))); // 甘油三酯
            experimentExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(74))); // 胆固醇
            experimentExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(75))); // 高密度脂蛋白
            experimentExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(76))); // 低密度脂蛋白
            experimentExamBiochemicalTestsV2.setApoa(parseBigDecimal(rowData.get(77))); // 载脂蛋白A
            experimentExamBiochemicalTestsV2.setApob(parseBigDecimal(rowData.get(78))); // 载脂蛋白B
            experimentExamBiochemicalTestsV2.setLpa(parseBigDecimal(rowData.get(79))); // 脂蛋白a
            experimentExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(80))); // 葡萄糖
            experimentExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(81))); // 肌酸激酶
            experimentExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(82))); // 肌酸激酶同工酶MB
            experimentExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(83))); // α-羟丁酸脱氢酶
            experimentExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(84))); // 乳酸脱氢酶
            experimentExamBiochemicalTestsV2.setCrp(parseBigDecimal(rowData.get(85))); // C-反应蛋白
            experimentExamBiochemicalTestsV2.setIgg(parseBigDecimal(rowData.get(86))); // 免疫球蛋白G
            experimentExamBiochemicalTestsV2.setIga(parseBigDecimal(rowData.get(87))); // 免疫球蛋白A
            experimentExamBiochemicalTestsV2.setIgm(parseBigDecimal(rowData.get(88))); // 免疫球蛋白M
            experimentExamBiochemicalTestsV2.setComplement3(parseBigDecimal(rowData.get(89))); // 补体3
            experimentExamBiochemicalTestsV2.setComplement4(parseBigDecimal(rowData.get(90))); // 补体4
            experimentExamBiochemicalTestsV2.setMyoglobin(parseBigDecimal(rowData.get(91))); // 肌红蛋白
            experimentExamBiochemicalTestsV2.setSmallDenseLdl(parseBigDecimal(rowData.get(92))); // 小而密低密度脂蛋白
            experimentExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(93))); // 同型半胱氨酸
            experimentExamBiochemicalTestsV2.setNucleotidase(parseBigDecimal(rowData.get(94))); // 5-核苷酸酶
            experimentExamBiochemicalTestsV2.setAda(parseBigDecimal(rowData.get(95))); // 腺苷脱氨酶
            experimentExamBiochemicalTestsV2.setAmylase(parseBigDecimal(rowData.get(96))); // 淀粉酶
            experimentExamBiochemicalTestsV2.setAnionGap(parseBigDecimal(rowData.get(97))); // 阴离子间隙
            experimentExamBiochemicalTestsV2.setBufferBase(parseBigDecimal(rowData.get(98))); // 缓冲碱
            experimentExamBiochemicalTestsV2.setBicarbonate(parseBigDecimal(rowData.get(99))); // 碳酸氢盐
            experimentExamBiochemicalTestsV2.setBaseExcess(parseBigDecimal(rowData.get(100))); // 碱剩余
            experimentExamBiochemicalTestsV2.setExtracellularBe(parseBigDecimal(rowData.get(101))); // 细胞外液碱剩余
            experimentExamBiochemicalTestsV2.setBloodUrea(parseBigDecimal(rowData.get(102))); // 血尿素
            experimentExamBiochemicalTestsV2.setBun(parseBigDecimal(rowData.get(103))); // 血尿素氮
            experimentExamBiochemicalTestsV2.setCalcium(parseBigDecimal(rowData.get(104))); // 钙
            experimentExamBiochemicalTestsV2.setChloride(parseBigDecimal(rowData.get(105))); // 氯
            experimentExamBiochemicalTestsV2.setCystatinC(parseBigDecimal(rowData.get(106))); // 胱抑素C
            experimentExamBiochemicalTestsV2.setIron(parseBigDecimal(rowData.get(107))); // 铁
            experimentExamBiochemicalTestsV2.setActualBicarbonate(parseBigDecimal(rowData.get(108))); // 实际碳酸氢盐
            experimentExamBiochemicalTestsV2.setStandardBicarbonate(parseBigDecimal(rowData.get(109))); // 标准碳酸氢盐
            experimentExamBiochemicalTestsV2.setPotassium(parseBigDecimal(rowData.get(110))); // 钾
            experimentExamBiochemicalTestsV2.setMagnesium(parseBigDecimal(rowData.get(111))); // 镁
            experimentExamBiochemicalTestsV2.setSodium(parseBigDecimal(rowData.get(112))); // 钠
            experimentExamBiochemicalTestsV2.setPhosphorus(parseBigDecimal(rowData.get(113))); // 磷
            experimentExamBiochemicalTestsV2.setPco2(parseBigDecimal(rowData.get(114))); // 二氧化碳分压
            experimentExamBiochemicalTestsV2.setPh(parseBigDecimal(rowData.get(115))); // 酸碱度
            experimentExamBiochemicalTestsV2.setPo2(parseBigDecimal(rowData.get(116))); // 氧分压
            experimentExamBiochemicalTestsV2.setRbp(parseBigDecimal(rowData.get(117))); // 视黄醇结合蛋白
            experimentExamBiochemicalTestsV2.setReninActivity(parseBigDecimal(rowData.get(118))); // 肾素活性
            experimentExamBiochemicalTestsV2.setHydrogenIonConcentration(parseBigDecimal(rowData.get(119))); // 氢离子浓度
            experimentExamBiochemicalTestsV2.setTco2(parseBigDecimal(rowData.get(120))); // 二氧化碳总量
            experimentExamBiochemicalTestsV2.setLacticAcid(parseBigDecimal(rowData.get(121))); // 乳酸
            experimentExamBiochemicalTestsV2.setMicroalbumin(parseBigDecimal(rowData.get(122))); // 微量白蛋白
            experimentExamBiochemicalTestsV2.setPlasmaOsmoticPressure(parseBigDecimal(rowData.get(123))); // 血浆渗透压
            experimentExamBiochemicalTestsV2.setAAGradient(parseBigDecimal(rowData.get(124))); // 肺泡-动脉血氧分压差
            experimentExamBiochemicalTestsV2.setAARatio(parseBigDecimal(rowData.get(125))); // 动脉-肺泡氧分压比值
            experimentExamBiochemicalTestsV2.setOxygenationIndex(parseBigDecimal(rowData.get(126))); // 氧合指数
            experimentExamBiochemicalTestsV2.setEstimatedSpo2(parseBigDecimal(rowData.get(127))); // 估计血氧饱和度
            experimentExamBiochemicalTestsV2.setEstimatedHb(parseBigDecimal(rowData.get(128))); // 估计总血红蛋白
            experimentExamBiochemicalTestsV2.setBeta2Microglobulin(parseBigDecimal(rowData.get(129))); // β2-微球蛋白
            experimentExamBiochemicalTestsV2.setHsCrp(parseBigDecimal(rowData.get(130))); // 超敏C反应蛋白
            experimentExamBiochemicalTestsV2.setHbsag(parseBigDecimal(rowData.get(131))); // 乙肝表面抗原
            experimentExamBiochemicalTestsV2.setAntiHbs(parseBigDecimal(rowData.get(132))); // 乙肝表面抗体
            experimentExamBiochemicalTestsV2.setHbeag(parseBigDecimal(rowData.get(133))); // 乙肝e抗原
            experimentExamBiochemicalTestsV2.setAntiHbe(parseBigDecimal(rowData.get(134))); // 乙肝e抗体
            experimentExamBiochemicalTestsV2.setAntiHbc(parseBigDecimal(rowData.get(135))); // 乙肝核心抗体
            experimentExamBiochemicalTestsV2.setTotalCholesterol(parseBigDecimal(rowData.get(136))); // 总胆固醇
            experimentExamBiochemicalTestsV2.setIma(parseBigDecimal(rowData.get(137))); // 缺血修饰白蛋白
            experimentExamBiochemicalTestsV2.setAfucosidase(parseBigDecimal(rowData.get(138))); // α-L-岩藻糖苷酶
            experimentExamBiochemicalTestsV2.setTimePoint(3); // 时相
            experimentExamBiochemicalTestsV2Service.createExperimentExamBiochemicalTestsV2(experimentExamBiochemicalTestsV2);

            prospectiveExperimentExamBloodRoutine.setPersonId(generatedId);
            prospectiveExperimentExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(22))); // 白细胞计数
            prospectiveExperimentExamBloodRoutine.setLymphocytePercent(parseBigDecimal(rowData.get(23))); // 淋巴细胞百分比
            prospectiveExperimentExamBloodRoutine.setMidCellPercent(parseBigDecimal(rowData.get(24))); // 中间细胞百分比
            prospectiveExperimentExamBloodRoutine.setGranulocytePercent(parseBigDecimal(rowData.get(25))); // 粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setLymphocyteCount(parseBigDecimal(rowData.get(26))); // 淋巴细胞计数
            prospectiveExperimentExamBloodRoutine.setMidCellCount(parseBigDecimal(rowData.get(27))); // 中间细胞计数
            prospectiveExperimentExamBloodRoutine.setGranulocyteCount(parseBigDecimal(rowData.get(28))); // 粒细胞计数
            prospectiveExperimentExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(29))); // 红细胞计数
            prospectiveExperimentExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(30))); // 血红蛋白
            prospectiveExperimentExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(31))); // 血细胞比容
            prospectiveExperimentExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(32))); // 平均红细胞体积
            prospectiveExperimentExamBloodRoutine.setMch(parseBigDecimal(rowData.get(33))); // 平均红细胞血红蛋白含量
            prospectiveExperimentExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(34))); // 平均红细胞血红蛋白浓度
            prospectiveExperimentExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(35))); // 红细胞分布宽度变异系数
            prospectiveExperimentExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(36))); // 红细胞分布宽度标准差
            prospectiveExperimentExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(37))); // 血小板计数
            prospectiveExperimentExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(38))); // 平均血小板体积
            prospectiveExperimentExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(39))); // 血小板分布宽度
            prospectiveExperimentExamBloodRoutine.setPct(parseBigDecimal(rowData.get(40))); // 血小板压积
            prospectiveExperimentExamBloodRoutine.setLargePlateletRatio(parseBigDecimal(rowData.get(41))); // 大血小板比率
            prospectiveExperimentExamBloodRoutine.setLargePlateletCount(parseBigDecimal(rowData.get(42))); // 大血小板计数
            prospectiveExperimentExamBloodRoutine.setBasophilCount(parseBigDecimal(rowData.get(43))); // 嗜碱性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setBasophilPercent(parseBigDecimal(rowData.get(44))); // 嗜碱性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setEosinophilCount(parseBigDecimal(rowData.get(45))); // 嗜酸性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setEosinophilPercent(parseBigDecimal(rowData.get(46))); // 嗜酸性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocyteCount(parseBigDecimal(rowData.get(47))); // 幼稚粒细胞计数
            prospectiveExperimentExamBloodRoutine.setImmatureGranulocytePercent(parseBigDecimal(rowData.get(48))); // 幼稚粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setMonocyteCount(parseBigDecimal(rowData.get(49))); // 单核细胞计数
            prospectiveExperimentExamBloodRoutine.setMonocytePercent(parseBigDecimal(rowData.get(50))); // 单核细胞百分比
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcCount(parseBigDecimal(rowData.get(51))); // 有核红细胞计数
            prospectiveExperimentExamBloodRoutine.setNucleatedRbcPercent(parseBigDecimal(rowData.get(52))); // 有核红细胞百分比
            prospectiveExperimentExamBloodRoutine.setNeutrophilCount(parseBigDecimal(rowData.get(53))); // 中性粒细胞计数
            prospectiveExperimentExamBloodRoutine.setNeutrophilPercent(parseBigDecimal(rowData.get(54))); // 中性粒细胞百分比
            prospectiveExperimentExamBloodRoutine.setTimePoint(3); // 时相
            prospectiveExperimentExamBloodRoutineService.createExperimentExamBloodRoutine(prospectiveExperimentExamBloodRoutine);

            experimentExamCoagulationTests.setPersonId(generatedId);
            experimentExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(3))); // 活化部分凝血活酶时间
            experimentExamCoagulationTests.setAntithrombinIiiActivityPercent(parseBigDecimal(rowData.get(4))); // 抗凝血酶Ⅲ活性百分比
            experimentExamCoagulationTests.setAntithrombinIiiActivityRate(parseBigDecimal(rowData.get(5))); // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
            experimentExamCoagulationTests.setDDimerOptDensity(parseBigDecimal(rowData.get(6))); // D-二聚体（光密度差值检测）
            experimentExamCoagulationTests.setDDimerConcentration(parseBigDecimal(rowData.get(7))); // D-二聚体浓度
            experimentExamCoagulationTests.setFibrinDegradationProductsDensity(parseBigDecimal(rowData.get(8))); // 纤维蛋白降解产物（光密度差值检测）
            experimentExamCoagulationTests.setFibrinDegradationProductsConcentration(parseBigDecimal(rowData.get(9))); // 纤维蛋白降解产物浓度
            experimentExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(10))); // 纤维蛋白原浓度
            experimentExamCoagulationTests.setFibrinogenClottingTime(parseBigDecimal(rowData.get(11))); // 纤维蛋白原凝固时间
            experimentExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(12))); // 凝血酶原时间(百分比活动度)
            experimentExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(13))); // 凝血酶原时间-国际标准化比值
            experimentExamCoagulationTests.setProthrombinTimeRatio(parseBigDecimal(rowData.get(14))); // 凝血酶原时间比值
            experimentExamCoagulationTests.setProthrombinTime(parseBigDecimal(rowData.get(15))); // 凝血酶原时间
            experimentExamCoagulationTests.setThrombinTime(parseBigDecimal(rowData.get(16))); // 凝血酶时间
            experimentExamCoagulationTests.setThrombinTime1(parseBigDecimal(rowData.get(17))); // 凝血酶时间(1)
            experimentExamCoagulationTests.setAptt1(parseBigDecimal(rowData.get(18))); // 活化部分凝血活酶时间(1)
            experimentExamCoagulationTests.setAptt2(parseBigDecimal(rowData.get(19))); // 活化部分凝血活酶时间(2)
            experimentExamCoagulationTests.setProthrombinActivity(parseBigDecimal(rowData.get(20))); // 凝血酶原活动度
            experimentExamCoagulationTests.setInr(parseBigDecimal(rowData.get(21))); // 国际标准化比值
            experimentExamCoagulationTests.setTimePoint(3); // 时相
            experimentExamCoagulationTestsService.createExperimentExamCoagulationTests(experimentExamCoagulationTests);

            experimentExamOtherData.setPersonId(generatedId);
            experimentExamOtherData.setCardiacTroponinI(rowData.get(139));
            experimentExamOtherData.setEcgAnalysisResult(rowData.get(140));
            experimentExamOtherData.setTimePoint(3);
            experimentExamOtherDataService.createExperimentExamOtherData(experimentExamOtherData);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    //    对照组--------------------------------------------------------------------------------------------------------
    @GetMapping("/importControlSurvey")
    public String importControlSurvey(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//    String fileName = "/Users/jsheng/Downloads/对照组前瞻.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerControlSurvey(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , controlSurveyBasicCheckInfoService
                        , controlSurveyStationTrainingInfoService
                        , controlSurveyMissionProgressSurveyService
                        , controlSurveyScoreSummaryService
                        , controlSurveyPostReturnSymptomsService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet()
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerControlSurvey extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ControlSurveyBasicCheckInfoService controlSurveyBasicCheckInfoService;
        private ControlSurveyStationTrainingInfoService controlSurveyStationTrainingInfoService;
        private ControlSurveyMissionProgressSurveyService controlSurveyMissionProgressSurveyService;
        private ControlSurveyScoreSummaryService controlSurveyScoreSummaryService;
        private ControlSurveyPostReturnSymptomsService controlSurveyPostReturnSymptomsService;

        private ProspectiveExperimentSurveyPostReturnSymptomsService prospectiveExperimentSurveyPostReturnSymptomsService;

        // 构造函数注入服务
        public IndexListenerControlSurvey(String type,
                                          ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ControlSurveyBasicCheckInfoService controlSurveyBasicCheckInfoService
                , ControlSurveyStationTrainingInfoService controlSurveyStationTrainingInfoService
                , ControlSurveyMissionProgressSurveyService controlSurveyMissionProgressSurveyService
                , ControlSurveyScoreSummaryService controlSurveyScoreSummaryService
                , ControlSurveyPostReturnSymptomsService controlSurveyPostReturnSymptomsService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.controlSurveyBasicCheckInfoService = controlSurveyBasicCheckInfoService;
            this.controlSurveyStationTrainingInfoService = controlSurveyStationTrainingInfoService;
            this.controlSurveyMissionProgressSurveyService = controlSurveyMissionProgressSurveyService;
            this.controlSurveyScoreSummaryService = controlSurveyScoreSummaryService;
            this.controlSurveyPostReturnSymptomsService = controlSurveyPostReturnSymptomsService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ControlSurveyBasicCheckInfoSaveReqVO controlSurveyBasicCheckInfo = new ControlSurveyBasicCheckInfoSaveReqVO();
            ControlSurveyStationTrainingInfoSaveReqVO controlSurveyStationTrainingInfo = new ControlSurveyStationTrainingInfoSaveReqVO();
            ControlSurveyMissionProgressSurveySaveReqVO controlSurveyMissionProgressSurvey = new ControlSurveyMissionProgressSurveySaveReqVO();
            ControlSurveyPostReturnSymptomsSaveReqVO controlSurveyPostReturnSymptoms = new ControlSurveyPostReturnSymptomsSaveReqVO();
            ControlSurveyScoreSummarySaveReqVO controlSurveyScoreSummary = new ControlSurveyScoreSummarySaveReqVO();

            basicInfo.setCode(rowData.get(2)); // 编号
            basicInfo.setName(rowData.get(0)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("2"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("survey"); // 流调或体检
            basicInfo.setAge(extractNumberOrZero(rowData.get(3))); // 年龄
            basicInfo.setActualAge(extractNumberOrZero(rowData.get(4))); // 实际年龄
            basicInfo.setGender(rowData.get(5)); // 性别
            basicInfo.setBirthDate(rowData.get(12)); // 出生年月
            basicInfo.setPosition(rowData.get(13)); // 部职别
            basicInfo.setIdNumber(rowData.get(15)); // 证件号
            basicInfo.setTimePoint(0); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            controlSurveyBasicCheckInfo.setPersonId(generatedId);
            controlSurveyBasicCheckInfo.setSystolicBloodPressure(extractNumberOrZero(rowData.get(6))); // 收缩压
            controlSurveyBasicCheckInfo.setDiastolicBloodPressure(extractNumberOrZero(rowData.get(7))); // 舒张压
            controlSurveyBasicCheckInfo.setOxygenSaturation(extractNumberOrZero(rowData.get(8))); // 血氧饱和度
            controlSurveyBasicCheckInfo.setHeartRate(extractNumberOrZero(rowData.get(9))); // 心率
            controlSurveyBasicCheckInfo.setBasicHeight(extractNumberOrZero(rowData.get(10))); // 身高
            controlSurveyBasicCheckInfo.setBasicWeight(extractNumberOrZero(rowData.get(11))); // 体重
            controlSurveyBasicCheckInfo.setTimePoint(0); // 时相类型
            controlSurveyBasicCheckInfoService.createControlSurveyBasicCheckInfo(controlSurveyBasicCheckInfo);


            controlSurveyStationTrainingInfo.setPersonId(generatedId);
            controlSurveyStationTrainingInfo.setMissionPointAltitude(extractNumberOrZero(rowData.get(14))); // 任务点海拔
            controlSurveyStationTrainingInfo.setPlateauTrainingDuration(extractNumberOrZero(rowData.get(16))); // 高原驻训总时长
            controlSurveyStationTrainingInfo.setTimePoint(0); // 时相类型
            controlSurveyStationTrainingInfoService.createControlSurveyStationTrainingInfo(controlSurveyStationTrainingInfo);

            controlSurveyMissionProgressSurvey.setPersonId(generatedId);
            controlSurveyMissionProgressSurvey.setTransportationMode(rowData.get(17)); // 交通方式
            controlSurveyMissionProgressSurvey.setReturnPurpose(rowData.get(18)); // 返回目的
            controlSurveyMissionProgressSurvey.setArrivalDate(rowData.get(19)); // 到达日期
            controlSurveyMissionProgressSurvey.setPlateauMissionDuration(parseDurationToMonths(rowData.get(20))); // 高原任务持续时间
            controlSurveyMissionProgressSurvey.setTravelDuration(rowData.get(21)); // 推进途中耗费时间
            controlSurveyMissionProgressSurvey.setHasStopover(parseBoolean(rowData.get(22))); // 是否有中途停留
            controlSurveyMissionProgressSurvey.setStopoverLocation(rowData.get(23)); // 中途停留地点
            controlSurveyMissionProgressSurvey.setHasDiscomfortAfterArrival(parseBoolean(rowData.get(24))); // 到达后是否有不适
            controlSurveyMissionProgressSurvey.setTimePoint(0); // 时相类型
            controlSurveyMissionProgressSurveyService.createControlSurveyMissionProgressSurvey(controlSurveyMissionProgressSurvey);

            controlSurveyPostReturnSymptoms.setPersonId(generatedId);
            controlSurveyPostReturnSymptoms.setFatigue(parseInteger(rowData.get(25))); // 疲倦
            controlSurveyPostReturnSymptoms.setFatigueDuration(rowData.get(26)); // 疲倦持续时间
            controlSurveyPostReturnSymptoms.setWeakness(parseInteger(rowData.get(27))); // 乏力
            controlSurveyPostReturnSymptoms.setWeaknessDuration(rowData.get(28)); // 乏力持续时间
            controlSurveyPostReturnSymptoms.setDrowsiness(parseInteger(rowData.get(29))); // 嗜睡
            controlSurveyPostReturnSymptoms.setDrowsinessDuration(rowData.get(30)); // 嗜睡持续时间
            controlSurveyPostReturnSymptoms.setDizziness(parseInteger(rowData.get(31))); // 头昏
            controlSurveyPostReturnSymptoms.setDizzinessDuration(rowData.get(32)); // 头昏持续时间
            controlSurveyPostReturnSymptoms.setVertigo(parseInteger(rowData.get(33))); // 眩晕
            controlSurveyPostReturnSymptoms.setVertigoDuration(rowData.get(34)); // 眩晕持续时间
            controlSurveyPostReturnSymptoms.setPoorConcentration(parseInteger(rowData.get(35))); // 精力不集中
            controlSurveyPostReturnSymptoms.setPoorConcentrationDuration(rowData.get(36)); // 精力不集中持续时间
            controlSurveyPostReturnSymptoms.setSlowReaction(parseInteger(rowData.get(37))); // 反应迟钝
            controlSurveyPostReturnSymptoms.setSlowReactionDuration(rowData.get(38)); // 反应迟钝持续时间
            controlSurveyPostReturnSymptoms.setMemoryLoss(parseInteger(rowData.get(39))); // 记忆减退
            controlSurveyPostReturnSymptoms.setMemoryLossDuration(rowData.get(40)); // 记忆减退持续时间
            controlSurveyPostReturnSymptoms.setInsomnia(parseInteger(rowData.get(41))); // 失眠
            controlSurveyPostReturnSymptoms.setInsomniaDuration(rowData.get(42)); // 失眠持续时间
            controlSurveyPostReturnSymptoms.setNightmares(parseInteger(rowData.get(43))); // 多梦
            controlSurveyPostReturnSymptoms.setNightmaresDuration(rowData.get(44)); // 多梦持续时间
            controlSurveyPostReturnSymptoms.setSoreThroat(parseInteger(rowData.get(45))); // 咽喉痛
            controlSurveyPostReturnSymptoms.setSoreThroatDuration(rowData.get(46)); // 咽喉痛持续时间
            controlSurveyPostReturnSymptoms.setCough(parseInteger(rowData.get(47))); // 咳嗽
            controlSurveyPostReturnSymptoms.setCoughDuration(rowData.get(48)); // 咳嗽持续时间
            controlSurveyPostReturnSymptoms.setPhlegm(parseInteger(rowData.get(49))); // 多痰
            controlSurveyPostReturnSymptoms.setPhlegmDuration(rowData.get(50)); // 多痰持续时间
            controlSurveyPostReturnSymptoms.setWheezing(parseInteger(rowData.get(51))); // 气喘
            controlSurveyPostReturnSymptoms.setWheezingDuration(rowData.get(52)); // 气喘持续时间
            controlSurveyPostReturnSymptoms.setChestTightness(parseInteger(rowData.get(53))); // 胸闷
            controlSurveyPostReturnSymptoms.setChestTightnessDuration(rowData.get(54)); // 胸闷持续时间
            controlSurveyPostReturnSymptoms.setChestPain(parseInteger(rowData.get(55))); // 心前区痛
            controlSurveyPostReturnSymptoms.setChestPainDuration(rowData.get(56)); // 心前区痛持续时间
            controlSurveyPostReturnSymptoms.setPalpitations(parseInteger(rowData.get(57))); // 心慌
            controlSurveyPostReturnSymptoms.setPalpitationsDuration(rowData.get(58)); // 心慌持续时间
            controlSurveyPostReturnSymptoms.setBradycardia(parseInteger(rowData.get(59))); // 脉率减慢
            controlSurveyPostReturnSymptoms.setBradycardiaDuration(rowData.get(60)); // 脉率减慢持续时间
            controlSurveyPostReturnSymptoms.setCyanosis(parseInteger(rowData.get(61))); // 紫绀
            controlSurveyPostReturnSymptoms.setCyanosisDuration(rowData.get(62)); // 紫绀持续时间
            controlSurveyPostReturnSymptoms.setBloodPressureFluctuation(parseInteger(rowData.get(63))); // 血压波动
            controlSurveyPostReturnSymptoms.setBloodPressureFluctuationDuration(rowData.get(64)); // 血压波动持续时间
            controlSurveyPostReturnSymptoms.setSkinBleeding(parseInteger(rowData.get(65))); // 皮肤出血
            controlSurveyPostReturnSymptoms.setSkinBleedingDuration(rowData.get(66)); // 皮肤出血持续时间
            controlSurveyPostReturnSymptoms.setSkinBruising(parseInteger(rowData.get(67))); // 皮肤瘀斑
            controlSurveyPostReturnSymptoms.setSkinBruisingDuration(rowData.get(68)); // 皮肤瘀斑持续时间
            controlSurveyPostReturnSymptoms.setAnemia(parseInteger(rowData.get(69))); // 贫血
            controlSurveyPostReturnSymptoms.setAnemiaDuration(rowData.get(70)); // 贫血持续时间
            controlSurveyPostReturnSymptoms.setWeightLoss(parseInteger(rowData.get(71))); // 体重减轻
            controlSurveyPostReturnSymptoms.setWeightLossDuration(rowData.get(72)); // 体重减轻持续时间
            controlSurveyPostReturnSymptoms.setIncreasedAppetite(parseInteger(rowData.get(73))); // 食欲增加
            controlSurveyPostReturnSymptoms.setIncreasedAppetiteDuration(rowData.get(74)); // 食欲增加持续时间
            controlSurveyPostReturnSymptoms.setAnorexia(parseInteger(rowData.get(75))); // 厌食
            controlSurveyPostReturnSymptoms.setAnorexiaDuration(rowData.get(76)); // 厌食持续时间
            controlSurveyPostReturnSymptoms.setConstipation(parseInteger(rowData.get(77))); // 便秘
            controlSurveyPostReturnSymptoms.setConstipationDuration(rowData.get(78)); // 便秘持续时间
            controlSurveyPostReturnSymptoms.setDiarrhea(parseInteger(rowData.get(79))); // 腹泻
            controlSurveyPostReturnSymptoms.setDiarrheaDuration(rowData.get(80)); // 腹泻持续时间
            controlSurveyPostReturnSymptoms.setAbdominalPain(parseInteger(rowData.get(81))); // 腹痛
            controlSurveyPostReturnSymptoms.setAbdominalPainDuration(rowData.get(82)); // 腹痛持续时间
            controlSurveyPostReturnSymptoms.setAbdominalDistension(parseInteger(rowData.get(83))); // 腹胀
            controlSurveyPostReturnSymptoms.setAbdominalDistensionDuration(rowData.get(84)); // 腹胀持续时间
            controlSurveyPostReturnSymptoms.setJaundice(parseInteger(rowData.get(85))); // 黄疸
            controlSurveyPostReturnSymptoms.setJaundiceDuration(rowData.get(86)); // 黄疸持续时间
            controlSurveyPostReturnSymptoms.setNumbness(parseInteger(rowData.get(87))); // 手足麻木
            controlSurveyPostReturnSymptoms.setNumbnessDuration(rowData.get(88)); // 手足麻木持续时间
            controlSurveyPostReturnSymptoms.setLimbEdema(parseInteger(rowData.get(89))); // 肢体水肿
            controlSurveyPostReturnSymptoms.setLimbEdemaDuration(rowData.get(90)); // 肢体水肿持续时间
            controlSurveyPostReturnSymptoms.setFacialEdema(parseInteger(rowData.get(91))); // 面部水肿
            controlSurveyPostReturnSymptoms.setFacialEdemaDuration(rowData.get(92)); // 面部水肿持续时间
            controlSurveyPostReturnSymptoms.setHairLoss(parseInteger(rowData.get(93))); // 脱发
            controlSurveyPostReturnSymptoms.setHairLossDuration(rowData.get(94)); // 脱发持续时间
            controlSurveyPostReturnSymptoms.setIncreasedUrination(parseInteger(rowData.get(95))); // 夜尿增多
            controlSurveyPostReturnSymptoms.setIncreasedUrinationDuration(rowData.get(96)); // 夜尿增多持续时间
            controlSurveyPostReturnSymptoms.setOtherSymptoms(rowData.get(97)); // 返回后有无其他症状
            controlSurveyPostReturnSymptoms.setTimePoint(0); // 时相类型
            controlSurveyPostReturnSymptomsService.createControlSurveyPostReturnSymptoms(controlSurveyPostReturnSymptoms);

            controlSurveyScoreSummary.setPersonId(generatedId);
            controlSurveyScoreSummary.setTotalScore(extractNumber(rowData.get(98))); // 总分
            controlSurveyScoreSummary.setTimePoint(0); // 时相类型
            controlSurveyScoreSummaryService.createControlSurveyScoreSummary(controlSurveyScoreSummary);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }


    @GetMapping("/importControlExam")
    public String importControlExam(@RequestParam String fileName, @RequestParam String type) {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/对照组-检查前瞻.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerControlExam(
                        type,
                        prospectiveBasicInfoService
                        , prospectiveBasicOtherInfoService
                        , controlExamBiochemicalTestsV2Service
                        , prospectiveControlExamBloodRoutineService
                        , controlExamCoagulationTestsService
                        , controlExamOtherDataService))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet()
                .doRead();

        return "Excel数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerControlExam extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private final String type; // 新增字段
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService;
        private ControlExamBiochemicalTestsV2Service controlExamBiochemicalTestsV2Service;
        private ProspectiveControlExamBloodRoutineService prospectiveControlExamBloodRoutineService;
        private ControlExamCoagulationTestsService controlExamCoagulationTestsService;
        private ControlExamOtherDataService controlExamOtherDataService;

        // 构造函数注入服务
        public IndexListenerControlExam(String type,
                                        ProspectiveBasicInfoService prospectiveBasicInfoService
                , ProspectiveBasicOtherInfoService prospectiveBasicOtherInfoService
                , ControlExamBiochemicalTestsV2Service controlExamBiochemicalTestsV2Service
                , ProspectiveControlExamBloodRoutineService prospectiveControlExamBloodRoutineService
                , ControlExamCoagulationTestsService controlExamCoagulationTestsService
                , ControlExamOtherDataService controlExamOtherDataService) {
            this.type = type;
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.prospectiveBasicOtherInfoService = prospectiveBasicOtherInfoService;
            this.controlExamBiochemicalTestsV2Service = controlExamBiochemicalTestsV2Service;
            this.prospectiveControlExamBloodRoutineService = prospectiveControlExamBloodRoutineService;
            this.controlExamCoagulationTestsService = controlExamCoagulationTestsService;
            this.controlExamOtherDataService = controlExamOtherDataService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ControlExamBiochemicalTestsV2SaveReqVO controlExamBiochemicalTestsV2 = new ControlExamBiochemicalTestsV2SaveReqVO();
            ControlExamBloodRoutineSaveReqVO controlExamBloodRoutine = new ControlExamBloodRoutineSaveReqVO();
            ControlExamCoagulationTestsSaveReqVO controlExamCoagulationTests = new ControlExamCoagulationTestsSaveReqVO();
            ControlExamOtherDataSaveReqVO controlExamOtherData = new ControlExamOtherDataSaveReqVO();

            basicInfo.setCode(rowData.get(1)); // 编号
            basicInfo.setName(rowData.get(2)); // 姓名
            basicInfo.setType(type); // 任务类型
            basicInfo.setGroupType("2"); // 组别类型(1:实验组, 2:对照组)
            basicInfo.setSurveyOrExam("exam"); // 流调或体检
            basicInfo.setTimePoint(0); // 时相类型
            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = prospectiveBasicInfoService.createBasicInfo(basicInfo);

            controlExamBiochemicalTestsV2.setPersonId(generatedId);
            controlExamBiochemicalTestsV2.setAlt(parseBigDecimal(rowData.get(67))); // ALT (67)
            controlExamBiochemicalTestsV2.setAst(parseBigDecimal(rowData.get(68))); // AST (68)
            controlExamBiochemicalTestsV2.setAstAltRatio(parseBigDecimal(rowData.get(69))); // 谷草转氨酶与谷丙转氨酶比值 (69)
            controlExamBiochemicalTestsV2.setTotalProtein(parseBigDecimal(rowData.get(70))); // 总蛋白 (70)
            controlExamBiochemicalTestsV2.setAlbumin(parseBigDecimal(rowData.get(71))); // 白蛋白 (71)
            controlExamBiochemicalTestsV2.setGlobulin(parseBigDecimal(rowData.get(72))); // 球蛋白 (72)
            controlExamBiochemicalTestsV2.setAlbGlobRatio(parseBigDecimal(rowData.get(73))); // 白球比 (73)
            controlExamBiochemicalTestsV2.setTotalBilirubin(parseBigDecimal(rowData.get(74))); // 总胆红素 (74)
            controlExamBiochemicalTestsV2.setDirectBilirubin(parseBigDecimal(rowData.get(75))); // 直接胆红素 (75)
            controlExamBiochemicalTestsV2.setIndirectBilirubin(parseBigDecimal(rowData.get(76))); // 间接胆红素 (76)
            controlExamBiochemicalTestsV2.setAlkalinePhosphatase(parseBigDecimal(rowData.get(77))); // 碱性磷酸酶 (77)
            controlExamBiochemicalTestsV2.setGgt(parseBigDecimal(rowData.get(78))); // 谷氨酰转肽酶 (78)
            controlExamBiochemicalTestsV2.setTotalBileAcid(parseBigDecimal(rowData.get(79))); // 总胆汁酸 (79)
            controlExamBiochemicalTestsV2.setCholinesterase(parseBigDecimal(rowData.get(80))); // 胆碱酯酶 (80)
            controlExamBiochemicalTestsV2.setPrealbumin(parseBigDecimal(rowData.get(81))); // 前白蛋白 (81)
            controlExamBiochemicalTestsV2.setUrea(parseBigDecimal(rowData.get(82))); // 尿素 (82)
            controlExamBiochemicalTestsV2.setCreatinine(parseBigDecimal(rowData.get(83))); // 肌酐 (83)
            controlExamBiochemicalTestsV2.setUricAcid(parseBigDecimal(rowData.get(84))); // 尿酸 (84)
            controlExamBiochemicalTestsV2.setTriglycerides(parseBigDecimal(rowData.get(85))); // 甘油三酯 (85)
            controlExamBiochemicalTestsV2.setCholesterol(parseBigDecimal(rowData.get(86))); // 胆固醇 (86)
            controlExamBiochemicalTestsV2.setHdlC(parseBigDecimal(rowData.get(87))); // 高密度脂蛋白 (87)
            controlExamBiochemicalTestsV2.setLdlC(parseBigDecimal(rowData.get(88))); // 低密度脂蛋白 (88)
            controlExamBiochemicalTestsV2.setApoa(parseBigDecimal(rowData.get(89))); // 载脂蛋白A (89)
            controlExamBiochemicalTestsV2.setApob(parseBigDecimal(rowData.get(90))); // 载脂蛋白B (90)
            controlExamBiochemicalTestsV2.setLpa(parseBigDecimal(rowData.get(91))); // 脂蛋白a (91)
            controlExamBiochemicalTestsV2.setGlucose(parseBigDecimal(rowData.get(92))); // 葡萄糖 (92)
            controlExamBiochemicalTestsV2.setCk(parseBigDecimal(rowData.get(93))); // 肌酸激酶 (93)
            controlExamBiochemicalTestsV2.setCkMb(parseBigDecimal(rowData.get(94))); // 肌酸激酶同工酶MB (94)
            controlExamBiochemicalTestsV2.setAlphaHbdh(parseBigDecimal(rowData.get(95))); // α-羟丁酸脱氢酶 (95)
            controlExamBiochemicalTestsV2.setLdh(parseBigDecimal(rowData.get(96))); // 乳酸脱氢酶 (96)
            controlExamBiochemicalTestsV2.setCrp(parseBigDecimal(rowData.get(97))); // C-反应蛋白 (97)
            controlExamBiochemicalTestsV2.setIgg(parseBigDecimal(rowData.get(98))); // 免疫球蛋白G (98)
            controlExamBiochemicalTestsV2.setIga(parseBigDecimal(rowData.get(99))); // 免疫球蛋白A (99)
            controlExamBiochemicalTestsV2.setIgm(parseBigDecimal(rowData.get(100))); // 免疫球蛋白M (100)
            controlExamBiochemicalTestsV2.setComplement3(parseBigDecimal(rowData.get(101))); // 补体3 (101)
            controlExamBiochemicalTestsV2.setComplement4(parseBigDecimal(rowData.get(102))); // 补体4 (102)
            controlExamBiochemicalTestsV2.setMyoglobin(parseBigDecimal(rowData.get(103))); // 肌红蛋白 (103)
            controlExamBiochemicalTestsV2.setSmallDenseLdl(parseBigDecimal(rowData.get(104))); // 小而密低密度脂蛋白 (104)
            controlExamBiochemicalTestsV2.setHomocysteine(parseBigDecimal(rowData.get(105))); // 同型半胱氨酸 (105)
            controlExamBiochemicalTestsV2.setNucleotidase(parseBigDecimal(rowData.get(106))); // 5-核苷酸酶 (106)
            controlExamBiochemicalTestsV2.setAda(parseBigDecimal(rowData.get(107))); // 腺苷脱氨酶 (107)
            controlExamBiochemicalTestsV2.setAmylase(parseBigDecimal(rowData.get(108))); // 淀粉酶 (108)
            controlExamBiochemicalTestsV2.setAnionGap(parseBigDecimal(rowData.get(109))); // 阴离子间隙 (109)
            controlExamBiochemicalTestsV2.setBufferBase(parseBigDecimal(rowData.get(110))); // 缓冲碱 (110)
            controlExamBiochemicalTestsV2.setBicarbonate(parseBigDecimal(rowData.get(111))); // 碳酸氢盐 (111)
            controlExamBiochemicalTestsV2.setBaseExcess(parseBigDecimal(rowData.get(112))); // 碱剩余 (112)
            controlExamBiochemicalTestsV2.setExtracellularBe(parseBigDecimal(rowData.get(113))); // 细胞外液碱剩余 (113)
            controlExamBiochemicalTestsV2.setBloodUrea(parseBigDecimal(rowData.get(114))); // 血尿素 (114)
            controlExamBiochemicalTestsV2.setBun(parseBigDecimal(rowData.get(115))); // 血尿素氮 (115)
            controlExamBiochemicalTestsV2.setCalcium(parseBigDecimal(rowData.get(116))); // 钙 (116)
            controlExamBiochemicalTestsV2.setChloride(parseBigDecimal(rowData.get(117))); // 氯 (117)
            controlExamBiochemicalTestsV2.setCystatinC(parseBigDecimal(rowData.get(118))); // 胱抑素C (118)
            controlExamBiochemicalTestsV2.setIron(parseBigDecimal(rowData.get(119))); // 铁 (119)
            controlExamBiochemicalTestsV2.setActualBicarbonate(parseBigDecimal(rowData.get(120))); // 实际碳酸氢盐 (120)
            controlExamBiochemicalTestsV2.setStandardBicarbonate(parseBigDecimal(rowData.get(121))); // 标准碳酸氢盐 (121)
            controlExamBiochemicalTestsV2.setPotassium(parseBigDecimal(rowData.get(122))); // 钾 (122)
            controlExamBiochemicalTestsV2.setMagnesium(parseBigDecimal(rowData.get(123))); // 镁 (123)
            controlExamBiochemicalTestsV2.setSodium(parseBigDecimal(rowData.get(124))); // 钠 (124)
            controlExamBiochemicalTestsV2.setPhosphorus(parseBigDecimal(rowData.get(125))); // 磷 (125)
            controlExamBiochemicalTestsV2.setPco2(parseBigDecimal(rowData.get(126))); // 二氧化碳分压 (126)
            controlExamBiochemicalTestsV2.setPh(parseBigDecimal(rowData.get(127))); // 酸碱度 (127)
            controlExamBiochemicalTestsV2.setPo2(parseBigDecimal(rowData.get(128))); // 氧分压 (128)
            controlExamBiochemicalTestsV2.setRbp(parseBigDecimal(rowData.get(129))); // 视黄醇结合蛋白 (129)
            controlExamBiochemicalTestsV2.setReninActivity(parseBigDecimal(rowData.get(130))); // 肾素活性 (130)
            controlExamBiochemicalTestsV2.setHydrogenIonConcentration(parseBigDecimal(rowData.get(131))); // 氢离子浓度 (131)
            controlExamBiochemicalTestsV2.setTco2(parseBigDecimal(rowData.get(132))); // 二氧化碳总量 (132)
            controlExamBiochemicalTestsV2.setLacticAcid(parseBigDecimal(rowData.get(133))); // 乳酸 (133)
            controlExamBiochemicalTestsV2.setMicroalbumin(parseBigDecimal(rowData.get(134))); // 微量白蛋白 (134)
            controlExamBiochemicalTestsV2.setPlasmaOsmoticPressure(parseBigDecimal(rowData.get(135))); // 血浆渗透压 (135)
            controlExamBiochemicalTestsV2.setAAGradient(parseBigDecimal(rowData.get(136))); // 肺泡-动脉血氧分压差 (136)
            controlExamBiochemicalTestsV2.setAARatio(parseBigDecimal(rowData.get(137))); // 动脉-肺泡氧分压比值 (137)
            controlExamBiochemicalTestsV2.setOxygenationIndex(parseBigDecimal(rowData.get(138))); // 氧合指数 (138)
            controlExamBiochemicalTestsV2.setEstimatedSpo2(parseBigDecimal(rowData.get(139))); // 估计血氧饱和度 (139)
            controlExamBiochemicalTestsV2.setEstimatedHb(parseBigDecimal(rowData.get(140))); // 估计总血红蛋白 (140)
            controlExamBiochemicalTestsV2.setBeta2Microglobulin(parseBigDecimal(rowData.get(141))); // β2-微球蛋白 (141)
            controlExamBiochemicalTestsV2.setHsCrp(parseBigDecimal(rowData.get(142))); // 超敏C反应蛋白 (142)
            controlExamBiochemicalTestsV2.setHbsag(parseBigDecimal(rowData.get(143))); // 乙肝表面抗原 (143)
            controlExamBiochemicalTestsV2.setAntiHbs(parseBigDecimal(rowData.get(144))); // 乙肝表面抗体 (144)
            controlExamBiochemicalTestsV2.setHbeag(parseBigDecimal(rowData.get(145))); // 乙肝e抗原 (145)
            controlExamBiochemicalTestsV2.setAntiHbe(parseBigDecimal(rowData.get(146))); // 乙肝e抗体 (146)
            controlExamBiochemicalTestsV2.setAntiHbc(parseBigDecimal(rowData.get(147))); // 乙肝核心抗体 (147)
            controlExamBiochemicalTestsV2.setTotalCholesterol(parseBigDecimal(rowData.get(148))); // 总胆固醇 (148)
            controlExamBiochemicalTestsV2.setIma(parseBigDecimal(rowData.get(149))); // 缺血修饰白蛋白 (149)
            controlExamBiochemicalTestsV2.setAfucosidase(parseBigDecimal(rowData.get(150))); // α-L-岩藻糖苷酶 (150)
            controlExamBiochemicalTestsV2.setPalb(parseBigDecimal(rowData.get(151))); // PALB
            controlExamBiochemicalTestsV2.setTbil(parseBigDecimal(rowData.get(152))); // TBIL
            controlExamBiochemicalTestsV2.setDbil(parseBigDecimal(rowData.get(153))); // DBIL
            controlExamBiochemicalTestsV2.setTg(parseBigDecimal(rowData.get(177))); // (177)TG
            controlExamBiochemicalTestsV2.setHdlc2(parseBigDecimal(rowData.get(184))); // (178)HDL-C
            controlExamBiochemicalTestsV2.setApoA2(parseBigDecimal(rowData.get(185))); // (179)ApoA
            controlExamBiochemicalTestsV2.setApoB2(parseBigDecimal(rowData.get(186))); // (180)ApoB
            controlExamBiochemicalTestsV2.setTimePoint(0); // 时相
            controlExamBiochemicalTestsV2Service.createControlExamBiochemicalTestsV2(controlExamBiochemicalTestsV2);

            controlExamBloodRoutine.setPersonId(generatedId);
            controlExamBloodRoutine.setWbcCount(parseBigDecimal(rowData.get(23))); // 白细胞计数
            controlExamBloodRoutine.setLymphocytePercent(parseBigDecimal(rowData.get(24))); // 淋巴细胞百分比
            controlExamBloodRoutine.setMidCellPercent(parseBigDecimal(rowData.get(25))); // 中间细胞百分比
            controlExamBloodRoutine.setGranulocytePercent(parseBigDecimal(rowData.get(26))); // 粒细胞百分比
            controlExamBloodRoutine.setLymphocyteCount(parseBigDecimal(rowData.get(27))); // 淋巴细胞计数
            controlExamBloodRoutine.setMidCellCount(parseBigDecimal(rowData.get(28))); // 中间细胞计数
            controlExamBloodRoutine.setGranulocyteCount(parseBigDecimal(rowData.get(29))); // 粒细胞计数
            controlExamBloodRoutine.setRbcCount(parseBigDecimal(rowData.get(30))); // 红细胞计数
            controlExamBloodRoutine.setHemoglobin(parseBigDecimal(rowData.get(31))); // 血红蛋白
            controlExamBloodRoutine.setHematocrit(parseBigDecimal(rowData.get(32))); // 血细胞比容
            controlExamBloodRoutine.setMcv(parseBigDecimal(rowData.get(33))); // 平均红细胞体积
            controlExamBloodRoutine.setMch(parseBigDecimal(rowData.get(34))); // 平均红细胞血红蛋白含量
            controlExamBloodRoutine.setMchc(parseBigDecimal(rowData.get(35))); // 平均红细胞血红蛋白浓度
            controlExamBloodRoutine.setRdwCv(parseBigDecimal(rowData.get(36))); // 红细胞分布宽度变异系数
            controlExamBloodRoutine.setRdwSd(parseBigDecimal(rowData.get(37))); // 红细胞分布宽度标准差
            controlExamBloodRoutine.setPlateletCount(parseBigDecimal(rowData.get(38))); // 血小板计数
            controlExamBloodRoutine.setMpv(parseBigDecimal(rowData.get(39))); // 平均血小板体积
            controlExamBloodRoutine.setPdw(parseBigDecimal(rowData.get(40))); // 血小板分布宽度
            controlExamBloodRoutine.setPct(parseBigDecimal(rowData.get(41))); // 血小板压积
            controlExamBloodRoutine.setLargePlateletRatio(parseBigDecimal(rowData.get(42))); // 大血小板比率
            controlExamBloodRoutine.setLargePlateletCount(parseBigDecimal(rowData.get(43))); // 大血小板计数
            controlExamBloodRoutine.setNe(parseBigDecimal(rowData.get(44))); // NE%
            controlExamBloodRoutine.setLy(parseBigDecimal(rowData.get(45))); //LY%
            controlExamBloodRoutine.setMo(parseBigDecimal(rowData.get(46))); // MO%
            controlExamBloodRoutine.setBa(parseBigDecimal(rowData.get(47))); // BA%
            controlExamBloodRoutine.setNeut(parseBigDecimal(rowData.get(48))); // Neut#
            controlExamBloodRoutine.setLymph(parseBigDecimal(rowData.get(49))); // Lymph#
            controlExamBloodRoutine.setEos(parseBigDecimal(rowData.get(50))); // Eos#
            controlExamBloodRoutine.setBasophilCount(parseBigDecimal(rowData.get(51))); // 嗜碱性粒细胞计数
            controlExamBloodRoutine.setBasophilPercent(parseBigDecimal(rowData.get(52))); // 嗜碱性粒细胞百分比
            controlExamBloodRoutine.setEosinophilCount(parseBigDecimal(rowData.get(53))); // 嗜酸性粒细胞计数
            controlExamBloodRoutine.setEosinophilPercent(parseBigDecimal(rowData.get(54))); // 嗜酸性粒细胞百分比
            controlExamBloodRoutine.setImmatureGranulocyteCount(parseBigDecimal(rowData.get(55))); // 幼稚粒细胞计数
            controlExamBloodRoutine.setImmatureGranulocytePercent(parseBigDecimal(rowData.get(56))); // 幼稚粒细胞百分比
            controlExamBloodRoutine.setMonocyteCount(parseBigDecimal(rowData.get(57))); // 单核细胞计数
            controlExamBloodRoutine.setMonocytePercent(parseBigDecimal(rowData.get(58))); // 单核细胞百分比
            controlExamBloodRoutine.setNucleatedRbcCount(parseBigDecimal(rowData.get(59))); // 有核红细胞计数
            controlExamBloodRoutine.setNucleatedRbcPercent(parseBigDecimal(rowData.get(60))); // 有核红细胞百分比
            controlExamBloodRoutine.setNeutrophilCount(parseBigDecimal(rowData.get(61))); // 中性粒细胞计数
            controlExamBloodRoutine.setNeutrophilPercent(parseBigDecimal(rowData.get(62))); // 中性粒细胞百分比
            controlExamBloodRoutine.setCrea(parseBigDecimal(rowData.get(63))); // CREA
            controlExamBloodRoutine.setCysc(parseBigDecimal(rowData.get(64))); // CYSC
            controlExamBloodRoutine.setClcr(parseBigDecimal(rowData.get(65))); // CLCR
            controlExamBloodRoutine.setUric(parseBigDecimal(rowData.get(66))); // URIC
            controlExamBloodRoutine.setTimePoint(0); // 时相
            prospectiveControlExamBloodRoutineService.createControlExamBloodRoutine(controlExamBloodRoutine);

            controlExamCoagulationTests.setPersonId(generatedId);
            controlExamCoagulationTests.setAptt(parseBigDecimal(rowData.get(3))); // 活化部分凝血活酶时间
            controlExamCoagulationTests.setAntithrombinIiiActivityPercent(parseBigDecimal(rowData.get(4))); // 抗凝血酶Ⅲ活性百分比
            controlExamCoagulationTests.setAntithrombinIiiActivityRate(parseBigDecimal(rowData.get(5))); // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
            controlExamCoagulationTests.setDDimerOptDensity(parseBigDecimal(rowData.get(6))); // D-二聚体（光密度差值检测）
            controlExamCoagulationTests.setDDimerConcentration(parseBigDecimal(rowData.get(7))); // D-二聚体浓度
            controlExamCoagulationTests.setFibrinDegradationProductsDensity(parseBigDecimal(rowData.get(8))); // 纤维蛋白降解产物（光密度差值检测）
            controlExamCoagulationTests.setFibrinDegradationProductsConcentration(parseBigDecimal(rowData.get(9))); // 纤维蛋白降解产物浓度
            controlExamCoagulationTests.setFibrinogenConcentration(parseBigDecimal(rowData.get(10))); // 纤维蛋白原浓度
            controlExamCoagulationTests.setFibrinogenClottingTime(parseBigDecimal(rowData.get(11))); // 纤维蛋白原凝固时间
            controlExamCoagulationTests.setProthrombinTimePercent(parseBigDecimal(rowData.get(12))); // 凝血酶原时间(百分比活动度)
            controlExamCoagulationTests.setPtInr(parseBigDecimal(rowData.get(13))); // 凝血酶原时间-国际标准化比值
            controlExamCoagulationTests.setProthrombinTimeRatio(parseBigDecimal(rowData.get(14))); // 凝血酶原时间比值
            controlExamCoagulationTests.setProthrombinTime(parseBigDecimal(rowData.get(15))); // 凝血酶原时间
            controlExamCoagulationTests.setThrombinTime(parseBigDecimal(rowData.get(16))); // 凝血酶时间
            controlExamCoagulationTests.setThrombinTime1(parseBigDecimal(rowData.get(17))); // 凝血酶时间(1)
            controlExamCoagulationTests.setAptt1(parseBigDecimal(rowData.get(18))); // 活化部分凝血活酶时间(1)
            controlExamCoagulationTests.setAptt2(parseBigDecimal(rowData.get(19))); // 活化部分凝血活酶时间(2)
            controlExamCoagulationTests.setProthrombinActivity(parseBigDecimal(rowData.get(20))); // 凝血酶原活动度
            controlExamCoagulationTests.setInr(parseBigDecimal(rowData.get(21))); // 国际标准化比值
            controlExamCoagulationTests.setPtdFbg(parseBigDecimal(rowData.get(22))); // PTDFbg
            controlExamCoagulationTests.setTimePoint(0); // 时相
            controlExamCoagulationTestsService.createControlExamCoagulationTests(controlExamCoagulationTests);

            controlExamOtherData.setPersonId(generatedId);
            controlExamOtherData.setCardiacTroponinI(rowData.get(154));
            controlExamOtherData.setAtniH(parseBigDecimal(rowData.get(187))); // ATNI-H
            controlExamOtherData.setMyog(parseBigDecimal(rowData.get(188))); // MYOG
            controlExamOtherData.setCkMbg(parseBigDecimal(rowData.get(189))); // CK-MBG
            controlExamOtherData.setEcgAnalysisResult(rowData.get(190)); // 心电图分析结果
            controlExamOtherData.setTimePoint(0);
            controlExamOtherDataService.createControlExamOtherData(controlExamOtherData);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @Operation(summary = "获取vip队列人数")
    @GetMapping("/getVipChartData")
    public CommonResult<Map<String, Object>> getVipChartData() {
        Integer memberCount1 = prospectiveBasicInfoService.getVipNumber1();
        Integer memberCount2 = prospectiveBasicInfoService.getVipNumber2();
        Integer memberCount3 = prospectiveBasicInfoService.getVipNumber3();

        Map<String, Object> data = new HashMap<>();
        data.put("memberCount1", memberCount1);
        data.put("memberCount2", memberCount2);
        data.put("memberCount3", memberCount3);
        return CommonResult.success(data);
    }

    @Operation(summary = "获取vip队列数据")
    @GetMapping("/getVipQueue")
    public CommonResult<Map<String, Object>> getVipQueue() {
        BasicInfoAverageVO queue1 = prospectiveBasicInfoService.getQueue1();
        BasicInfoAverageVO queue2 = prospectiveBasicInfoService.getQueue2();
        BasicInfoAverageVO queue3 = prospectiveBasicInfoService.getQueue3();
        List<Map<String, Object>> ethnicityCount1 = prospectiveBasicInfoService.getQueue1EthnicityCount();
        List<Map<String, Object>> ethnicityCount2 = prospectiveBasicInfoService.getQueue2EthnicityCount();

        Map<String, Object> data = new HashMap<>();
        data.put("queue1", queue1);
        data.put("queue2", queue2);
        data.put("queue3", queue3);
        data.put("ethnicityCount1", ethnicityCount1);
        data.put("ethnicityCount2", ethnicityCount2);
        return CommonResult.success(data);
    }

    @Operation(summary = "获取vip时相点得分")
    @GetMapping("/getVipTimePointScore")
    public CommonResult<Map<String, Object>> getVipTimePointScore(@Valid BasicInfoPageReqVO basicInfoReqVO) {
        BasicInfoAverageVO timePointScore = prospectiveBasicInfoService.getTimePoint(basicInfoReqVO);
        Map<String, Object> data = new HashMap<>();
        data.put("timePointScore", timePointScore);
        return CommonResult.success(data);
    }

    @Operation(summary = "获取vip高原数据")
    @GetMapping("/getMissionPointAltitudeCount")
    public CommonResult<Map<String, Object>> getMissionPointAltitudeCount() {
        BasicInfoAverageVO missionPointAltitudeCount = prospectiveBasicInfoService.getMissionPointAltitudeCount();
        Map<String, Object> data = new HashMap<>();
        data.put("missionPointAltitudeCount", missionPointAltitudeCount);
        return CommonResult.success(data);
    }

    @Operation(summary = "获得vip临床数据")
    @GetMapping("/getClinicalSymptomsData")
    public CommonResult<Map<String, Object>> getClinicalSymptomsData(@Valid BasicInfoPageReqVO basicInfoReqVO) {
        BasicInfoAverageVO clinicalSymptomsData = prospectiveBasicInfoService.getClinicalSymptomsData(basicInfoReqVO);
        Map<String, Object> data = new HashMap<>();
        data.put("clinicalSymptomsData", clinicalSymptomsData);
        return CommonResult.success(data);
    }

    @Operation(summary = "获得vip检查数据")
    @GetMapping("/getExamData")
    public CommonResult<Map<String, Object>> getExamData(@Valid BasicInfoPageReqVO basicInfoReqVO) {
        BasicInfoAverageVO examData = prospectiveBasicInfoService.getExamData(basicInfoReqVO);
        Map<String, Object> data = new HashMap<>();
        data.put("examData", examData);
        return CommonResult.success(data);
    }

    public ExperimentGroupExportVO convertToExperimentExportVO(BasicInfoRespVO source) {
        ExperimentGroupExportVO vo = new ExperimentGroupExportVO();
        vo.setName(source.getName());
        vo.setCode(source.getCode());
        vo.setActualAge(source.getActualAge());
        vo.setGender(source.getGender());
        vo.setBirthDate(source.getBirthDate());
        vo.setIdNumber(source.getIdNumber());

        if (source.getBasicOtherInfoRespVO() != null) {
            BasicOtherInfoRespVO otherInfo = source.getBasicOtherInfoRespVO();
            vo.setMaritalStatus(otherInfo.getMaritalStatus());
            vo.setHeight(otherInfo.getHeight());
            vo.setWeight(otherInfo.getWeight());
            vo.setEthnicity(otherInfo.getEthnicity());
            vo.setEducationLevel(otherInfo.getEducationLevel());
            vo.setFertilityStatus(otherInfo.getFertilityStatus());
        }

        if (source.getExperimentSurveyStationTrainingInfoRespVO() != null) {
            ExperimentSurveyStationTrainingInfoRespVO trainingInfo = source.getExperimentSurveyStationTrainingInfoRespVO();
            vo.setMissionPointAltitude(trainingInfo.getMissionPointAltitude());
            vo.setLocation(trainingInfo.getLocation());
            vo.setPlateauTrainingCount(trainingInfo.getPlateauTrainingCount());
            vo.setPlateauTrainingDuration(trainingInfo.getPlateauTrainingDuration());
            vo.setMissionType(trainingInfo.getMissionType());
            vo.setDailyWorkHours(trainingInfo.getDailyWorkHours());
            vo.setServicePosition(trainingInfo.getServicePosition());
        }

        if (source.getExperimentSurveySmokingInfoRespVO() != null) {
            ExperimentSurveySmokingInfoRespVO smokingInfo = source.getExperimentSurveySmokingInfoRespVO();
            vo.setSmokingStatus(smokingInfo.getSmokingStatus());
            vo.setDailyCigarettes(smokingInfo.getDailyCigarettes());
            vo.setSmokingStartAge(smokingInfo.getSmokingStartAge());
            vo.setSmokingYears(smokingInfo.getSmokingYears());
            vo.setQuitAttempted(smokingInfo.getQuitAttempted());
            vo.setSmokingYears(smokingInfo.getSmokingYears());
            vo.setQuitSmokingYears(smokingInfo.getQuitSmokingYears());
            vo.setQuitSmokingDuration(smokingInfo.getQuitSmokingDuration());
            vo.setQuitSmokingRegion(smokingInfo.getQuitSmokingRegion());
        }

        if (source.getExperimentSurveySelfAssessmentRespVO() != null) {
            ExperimentSurveySelfAssessmentRespVO selfAssessment = source.getExperimentSurveySelfAssessmentRespVO();
            vo.setHealthComparisonWithPeers(selfAssessment.getHealthComparisonWithPeers());
            vo.setHealthScore(selfAssessment.getHealthScore());
        }

        if (source.getExperimentSurveyScoreSummaryRespVO() != null) {
            ExperimentSurveyScoreSummaryRespVO scoreSummary = source.getExperimentSurveyScoreSummaryRespVO();
            BigDecimal totalScore = scoreSummary.getTotalScore();
            if (totalScore.compareTo(BigDecimal.valueOf(6)) < 0) {
                vo.setTotalScoreType("阴");
            } else if (totalScore.compareTo(BigDecimal.valueOf(6)) >= 0
                    && totalScore.compareTo(BigDecimal.valueOf(15)) <= 0) {
                vo.setTotalScoreType("轻");
            } else if (totalScore.compareTo(BigDecimal.valueOf(16)) >= 0
                    && totalScore.compareTo(BigDecimal.valueOf(25)) <= 0) {
                vo.setTotalScoreType("中");
            } else if (totalScore.compareTo(BigDecimal.valueOf(25)) > 0) {
                vo.setTotalScoreType("重");
            }
            vo.setTotalScore(scoreSummary.getTotalScore());

            if (scoreSummary.getTotalScore2() != null) {
// 获取基线评分和随访评分
                BigDecimal baselineScore = scoreSummary.getTotalScore2(); // 基线
                BigDecimal followupScore = scoreSummary.getTotalScore();  // 随访

                // 2. 获取基线/随访的分级结果
                String baseline = getScoreCategory(baselineScore);
                String followup = getScoreCategory(followupScore);

                // 3. 核心转归判断逻辑
                if (baseline == null || followup == null) {
                    vo.setConversionType("数据缺失"); // 处理数据不完整
                }

                // 持续类判断
                if ("重".equals(baseline) && "重".equals(followup)) {
                    vo.setConversionType("持续重度");
                } else if ("阴".equals(baseline) && "阴".equals(followup)) {
                    vo.setConversionType("持续阴性");
                } else if (!"阴".equals(baseline) && !"阴".equals(followup) && baseline.equals(followup)) {
                    vo.setConversionType("持续阳性"); // 持续轻/中/重均归类为"持续阳性"
                }
                // 转化类判断
                else if ("阴".equals(baseline) && !"阴".equals(followup)) {
                    vo.setConversionType("阴性转阳性");
                } else if (!"阴".equals(baseline) && "阴".equals(followup)) {
                    vo.setConversionType("阳性转阴性");
                } else if ("重".equals(followup) && !"重".equals(baseline)) {
                    vo.setConversionType("转为重度");
                }
                // 兜底逻辑
                else {
                    vo.setConversionType("其他变化");
                }
            }

            vo.setTotalScore2(scoreSummary.getTotalScore2());
        }

        if (source.getExperimentSurveyPostReturnSymptomsRespVO() != null) {
            ExperimentSurveyPostReturnSymptomsRespVO postReturnSymptoms = source.getExperimentSurveyPostReturnSymptomsRespVO();
            vo.setFatigue(postReturnSymptoms.getFatigue());
            vo.setFatigueDuration(postReturnSymptoms.getFatigueDuration());
            vo.setWeakness(postReturnSymptoms.getWeakness());
            vo.setWeaknessDuration(postReturnSymptoms.getWeaknessDuration());
            vo.setDrowsiness(postReturnSymptoms.getDrowsiness());
            vo.setDrowsinessDuration(postReturnSymptoms.getDrowsinessDuration());
            vo.setDizziness(postReturnSymptoms.getDizziness());
            vo.setDizzinessDuration(postReturnSymptoms.getDizzinessDuration());
            vo.setVertigo(postReturnSymptoms.getVertigo());
            vo.setVertigoDuration(postReturnSymptoms.getVertigoDuration());
            vo.setPoorConcentration(postReturnSymptoms.getPoorConcentration());
            vo.setPoorConcentrationDuration(postReturnSymptoms.getPoorConcentrationDuration());
            vo.setSlowReaction(postReturnSymptoms.getSlowReaction());
            vo.setSlowReactionDuration(postReturnSymptoms.getSlowReactionDuration());
            vo.setMemoryLoss(postReturnSymptoms.getMemoryLoss());
            vo.setMemoryLossDuration(postReturnSymptoms.getMemoryLossDuration());
            vo.setInsomnia(postReturnSymptoms.getInsomnia());
            vo.setInsomniaDuration(postReturnSymptoms.getInsomniaDuration());
            vo.setNightmares(postReturnSymptoms.getNightmares());
            vo.setNightmaresDuration(postReturnSymptoms.getNightmaresDuration());
            vo.setSoreThroat(postReturnSymptoms.getSoreThroat());
            vo.setSoreThroatDuration(postReturnSymptoms.getSoreThroatDuration());
            vo.setCough(postReturnSymptoms.getCough());
            vo.setCoughDuration(postReturnSymptoms.getCoughDuration());
            vo.setPhlegm(postReturnSymptoms.getPhlegm());
            vo.setPhlegmDuration(postReturnSymptoms.getPhlegmDuration());
            vo.setWheezing(postReturnSymptoms.getWheezing());
            vo.setWheezingDuration(postReturnSymptoms.getWheezingDuration());
            vo.setChestTightness(postReturnSymptoms.getChestTightness());
            vo.setChestTightnessDuration(postReturnSymptoms.getChestTightnessDuration());
            vo.setChestPain(postReturnSymptoms.getChestPain());
            vo.setChestPainDuration(postReturnSymptoms.getChestPainDuration());
            vo.setPalpitations(postReturnSymptoms.getPalpitations());
            vo.setPalpitationsDuration(postReturnSymptoms.getPalpitationsDuration());
            vo.setBradycardia(postReturnSymptoms.getBradycardia());
            vo.setBradycardiaDuration(postReturnSymptoms.getBradycardiaDuration());
            vo.setCyanosis(postReturnSymptoms.getCyanosis());
            vo.setCyanosisDuration(postReturnSymptoms.getCyanosisDuration());
            vo.setBloodPressureFluctuation(postReturnSymptoms.getBloodPressureFluctuation());
            vo.setBloodPressureFluctuationDuration(postReturnSymptoms.getBloodPressureFluctuationDuration());
            vo.setSkinBleeding(postReturnSymptoms.getSkinBleeding());
            vo.setSkinBleedingDuration(postReturnSymptoms.getSkinBleedingDuration());
            vo.setSkinBruising(postReturnSymptoms.getSkinBruising());
            vo.setSkinBruisingDuration(postReturnSymptoms.getSkinBruisingDuration());
            vo.setAnemia(postReturnSymptoms.getAnemia());
            vo.setAnemiaDuration(postReturnSymptoms.getAnemiaDuration());
            vo.setWeightLoss(postReturnSymptoms.getWeightLoss());
            vo.setWeightLossDuration(postReturnSymptoms.getWeightLossDuration());
            vo.setIncreasedAppetite(postReturnSymptoms.getIncreasedAppetite());
            vo.setIncreasedAppetiteDuration(postReturnSymptoms.getIncreasedAppetiteDuration());
            vo.setAnorexia(postReturnSymptoms.getAnorexia());
            vo.setAnorexiaDuration(postReturnSymptoms.getAnorexiaDuration());
            vo.setConstipation(postReturnSymptoms.getConstipation());
            vo.setConstipationDuration(postReturnSymptoms.getConstipationDuration());
            vo.setDiarrhea(postReturnSymptoms.getDiarrhea());
            vo.setDiarrheaDuration(postReturnSymptoms.getDiarrheaDuration());
            vo.setAbdominalPain(postReturnSymptoms.getAbdominalPain());
            vo.setAbdominalPainDuration(postReturnSymptoms.getAbdominalPainDuration());
            vo.setAbdominalDistension(postReturnSymptoms.getAbdominalDistension());
            vo.setAbdominalDistensionDuration(postReturnSymptoms.getAbdominalDistensionDuration());
            vo.setJaundice(postReturnSymptoms.getJaundice());
            vo.setJaundiceDuration(postReturnSymptoms.getJaundiceDuration());
            vo.setNumbness(postReturnSymptoms.getNumbness());
            vo.setNumbnessDuration(postReturnSymptoms.getNumbnessDuration());
            vo.setLimbEdema(postReturnSymptoms.getLimbEdema());
            vo.setLimbEdemaDuration(postReturnSymptoms.getLimbEdemaDuration());
            vo.setFacialEdema(postReturnSymptoms.getFacialEdema());
            vo.setFacialEdemaDuration(postReturnSymptoms.getFacialEdemaDuration());
            vo.setHairLoss(postReturnSymptoms.getHairLoss());
            vo.setHairLossDuration(postReturnSymptoms.getHairLossDuration());
            vo.setIncreasedUrination(postReturnSymptoms.getIncreasedUrination());
            vo.setIncreasedUrinationDuration(postReturnSymptoms.getIncreasedUrinationDuration());
            vo.setOtherSymptoms(postReturnSymptoms.getOtherSymptoms());
        }

        if (source.getExperimentSurveyPlateauFitnessInfoRespVO() != null) {
            ExperimentSurveyPlateauFitnessInfoRespVO plateauFitnessInfo = source.getExperimentSurveyPlateauFitnessInfoRespVO();
            vo.setHasRegularTraining(plateauFitnessInfo.getHasRegularTraining());
            vo.setTrainingFrequency(plateauFitnessInfo.getTrainingFrequency());
            vo.setTrainingDuration(plateauFitnessInfo.getTrainingDuration());
            vo.setTrainingType(plateauFitnessInfo.getTrainingType());
            vo.setHasChestDiscomfort(plateauFitnessInfo.getHasChestDiscomfort());
            vo.setSymptomReliefAfterAdaptation(plateauFitnessInfo.getSymptomReliefAfterAdaptation());
            vo.setHasInsomnia(plateauFitnessInfo.getHasInsomnia());
            vo.setDailySleepHours(plateauFitnessInfo.getDailySleepHours());
            vo.setInsomniaImprovement(plateauFitnessInfo.getInsomniaImprovement());
            vo.setDietHabits(plateauFitnessInfo.getDietHabits());
        }

        // 抵达高原后症状记录
        if (source.getExperimentSurveyPlateauArrivalSymptomsRespVO() != null) {
            ExperimentSurveyPlateauArrivalSymptomsRespVO arrivalSymptoms = source.getExperimentSurveyPlateauArrivalSymptomsRespVO();
            vo.setHeadache(arrivalSymptoms.getHeadache());
            vo.setHeadacheDuration(arrivalSymptoms.getHeadacheDuration());
            vo.setDigestiveSymptoms(arrivalSymptoms.getDigestiveSymptoms());
            vo.setDigestiveSymptomsDuration(arrivalSymptoms.getDigestiveSymptomsDuration());
            vo.setFatigueArrival(arrivalSymptoms.getFatigue());
            vo.setFatigueDurationArrival(arrivalSymptoms.getFatigueDuration());
            vo.setDizzinessArrival(arrivalSymptoms.getDizziness());
            vo.setDizzinessDurationArrival(arrivalSymptoms.getDizzinessDuration());
            vo.setImpactOnDailyLife(arrivalSymptoms.getImpactOnDailyLife());
        }

        // 推进情况调查
        if (source.getExperimentSurveyMissionProgressSurveyRespVO() != null) {
            ExperimentSurveyMissionProgressSurveyRespVO progressSurvey = source.getExperimentSurveyMissionProgressSurveyRespVO();
            vo.setTransportationMode(progressSurvey.getTransportationMode());
            vo.setMissionPointAltitudeProgress(progressSurvey.getMissionPointAltitude());
            vo.setLocationProgress(progressSurvey.getLocation());
            vo.setArrivalDate(progressSurvey.getArrivalDate());
            vo.setPlateauMissionDuration(progressSurvey.getPlateauMissionDuration());
            vo.setTravelDuration(progressSurvey.getTravelDuration());
            vo.setHasStopover(progressSurvey.getHasStopover());
            vo.setStopoverLocation(progressSurvey.getStopoverLocation());
            vo.setStopoverDuration(progressSurvey.getStopoverDuration());
            vo.setHasDiscomfortAfterArrival(progressSurvey.getHasDiscomfortAfterArrival());
            vo.setDiscomfortOccurrenceTime(progressSurvey.getDiscomfortOccurrenceTime());
            vo.setReturnPurpose(progressSurvey.getReturnPurpose());
        }

        // 既往疾病史
        if (source.getExperimentSurveyMedicalHistoryRespVO() != null) {
            vo.setDescription(source.getExperimentSurveyMedicalHistoryRespVO().getDescription());
        }

        // 抵达高原后有无新发疾病
        if (source.getExperimentSurveyHighlandDiseasesDuringServiceRespVO() != null) {
            ExperimentSurveyHighlandDiseasesDuringServiceRespVO diseases = source.getExperimentSurveyHighlandDiseasesDuringServiceRespVO();
            vo.setDiseases(diseases.getDiseases());
            vo.setHypertension(diseases.getHypertension());
            vo.setMyocardialInfarction(diseases.getMyocardialInfarction());
            vo.setCoronaryHeartDisease(diseases.getCoronaryHeartDisease());
            vo.setPulmonaryHeartDisease(diseases.getPulmonaryHeartDisease());
            vo.setLowerExtremityVenousThrombosis(diseases.getLowerExtremityVenousThrombosis());
            vo.setBradycardiaDiseases(diseases.getBradycardia());
            vo.setTachycardia(diseases.getTachycardia());
            vo.setArrhythmia(diseases.getArrhythmia());
            vo.setAtrialFibrillation(diseases.getAtrialFibrillation());
            vo.setParoxysmalAuricularTachycardia(diseases.getParoxysmalAuricularTachycardia());
            vo.setFrequentPrematureAtrialContractions(diseases.getFrequentPrematureAtrialContractions());
            vo.setFrequentPrematureVentricularContractions(diseases.getFrequentPrematureVentricularContractions());
            vo.setAvBlock(diseases.getAvBlock());
            vo.setVentricularTachycardia(diseases.getVentricularTachycardia());
            vo.setOtherDiseases11(diseases.getOtherDiseases11());
            vo.setDizzinessDiseases(diseases.getDizziness());
            vo.setTransientIschemicAttack(diseases.getTransientIschemicAttack());
            vo.setCerebralInfarction(diseases.getCerebralInfarction());
            vo.setCerebralHemorrhage(diseases.getCerebralHemorrhage());
            vo.setOtherDiseases12(diseases.getOtherDiseases12());
            vo.setHyperlipidemia(diseases.getHyperlipidemia());
            vo.setDiabetes(diseases.getDiabetes());
            vo.setGout(diseases.getGout());
            vo.setThyroidDisease(diseases.getThyroidDisease());
            vo.setOtherDiseases13(diseases.getOtherDiseases13());
            vo.setInsomniaDiseases(diseases.getInsomnia());
            vo.setTumor(diseases.getTumor());
            vo.setOtherDiseases14(diseases.getOtherDiseases14());
        }

        // 基本检测信息
        if (source.getExperimentSurveyBasicCheckInfoRespVO() != null) {
            ExperimentSurveyBasicCheckInfoRespVO checkInfo = source.getExperimentSurveyBasicCheckInfoRespVO();
            vo.setSystolicBloodPressure(checkInfo.getSystolicBloodPressure());
            vo.setDiastolicBloodPressure(checkInfo.getDiastolicBloodPressure());
            vo.setOxygenSaturation(checkInfo.getOxygenSaturation());
            vo.setHeartRate(checkInfo.getHeartRate());
            vo.setBasicHeight(checkInfo.getBasicHeight());
            vo.setBasicWeight(checkInfo.getBasicWeight());
            vo.setSurveyHeight(checkInfo.getSurveyHeight());
            vo.setSurveyWeight(checkInfo.getSurveyWeight());
        }

        // 高原急性高山病记录
        if (source.getExperimentSurveyAcuteMountainSicknessRecordsRespVO() != null) {
            ExperimentSurveyAcuteMountainSicknessRecordsRespVO sicknessRecords = source.getExperimentSurveyAcuteMountainSicknessRecordsRespVO();
            vo.setAcuteMountainReaction(sicknessRecords.getAcuteMountainReaction());
            vo.setPulmonaryEdema(sicknessRecords.getPulmonaryEdema());
            vo.setCerebralEdema(sicknessRecords.getCerebralEdema());
            vo.setHighAltitudeHeartDisease(sicknessRecords.getHighAltitudeHeartDisease());
            vo.setPolycythemia(sicknessRecords.getPolycythemia());
            vo.setOtherDiseases(sicknessRecords.getOtherDiseases());
            vo.setOtherDiseasesDesc(sicknessRecords.getOtherDiseasesDesc());
        }

        // ========== 生化检查赋值 ==========
        if (source.getExperimentExamBiochemicalTestsV2RespVO() != null) {
            ExperimentExamBiochemicalTestsV2RespVO bioTests = source.getExperimentExamBiochemicalTestsV2RespVO();
            vo.setAlt(bioTests.getAlt());
            vo.setAst(bioTests.getAst());
            vo.setAstAltRatio(bioTests.getAstAltRatio());
            vo.setTotalProtein(bioTests.getTotalProtein());
            vo.setAlbumin(bioTests.getAlbumin());
            vo.setGlobulin(bioTests.getGlobulin());
            vo.setAlbGlobRatio(bioTests.getAlbGlobRatio());
            vo.setTotalBilirubin(bioTests.getTotalBilirubin());
            vo.setDirectBilirubin(bioTests.getDirectBilirubin());
            vo.setIndirectBilirubin(bioTests.getIndirectBilirubin());
            vo.setAlkalinePhosphatase(bioTests.getAlkalinePhosphatase());
            vo.setGgt(bioTests.getGgt());
            vo.setTotalBileAcid(bioTests.getTotalBileAcid());
            vo.setCholinesterase(bioTests.getCholinesterase());
            vo.setPrealbumin(bioTests.getPrealbumin());
            vo.setUrea(bioTests.getUrea());
            vo.setCreatinine(bioTests.getCreatinine());
            vo.setUricAcid(bioTests.getUricAcid());
            vo.setTriglycerides(bioTests.getTriglycerides());
            vo.setCholesterol(bioTests.getCholesterol());
            vo.setHdlC(bioTests.getHdlC());
            vo.setLdlC(bioTests.getLdlC());
            vo.setApoa(bioTests.getApoa());
            vo.setApob(bioTests.getApob());
            vo.setLpa(bioTests.getLpa());
            vo.setGlucose(bioTests.getGlucose());
            vo.setCk(bioTests.getCk());
            vo.setCkMb(bioTests.getCkMb());
            vo.setAlphaHbdh(bioTests.getAlphaHbdh());
            vo.setLdh(bioTests.getLdh());
            vo.setCrp(bioTests.getCrp());
            vo.setIgg(bioTests.getIgg());
            vo.setIga(bioTests.getIga());
            vo.setIgm(bioTests.getIgm());
            vo.setComplement3(bioTests.getComplement3());
            vo.setComplement4(bioTests.getComplement4());
            vo.setMyoglobin(bioTests.getMyoglobin());
            vo.setSmallDenseLdl(bioTests.getSmallDenseLdl());
            vo.setHomocysteine(bioTests.getHomocysteine());
            vo.setNucleotidase(bioTests.getNucleotidase());
            vo.setAda(bioTests.getAda());
            vo.setAmylase(bioTests.getAmylase());
            vo.setAnionGap(bioTests.getAnionGap());
            vo.setBufferBase(bioTests.getBufferBase());
            vo.setBicarbonate(bioTests.getBicarbonate());
            vo.setBaseExcess(bioTests.getBaseExcess());
            vo.setExtracellularBe(bioTests.getExtracellularBe());
            vo.setBloodUrea(bioTests.getBloodUrea());
            vo.setBun(bioTests.getBun());
            vo.setCalcium(bioTests.getCalcium());
            vo.setChloride(bioTests.getChloride());
            vo.setCystatinC(bioTests.getCystatinC());
            vo.setIron(bioTests.getIron());
            vo.setActualBicarbonate(bioTests.getActualBicarbonate());
            vo.setStandardBicarbonate(bioTests.getStandardBicarbonate());
            vo.setPotassium(bioTests.getPotassium());
            vo.setMagnesium(bioTests.getMagnesium());
            vo.setSodium(bioTests.getSodium());
            vo.setPhosphorus(bioTests.getPhosphorus());
            vo.setPco2(bioTests.getPco2());
            vo.setPh(bioTests.getPh());
            vo.setPo2(bioTests.getPo2());
            vo.setRbp(bioTests.getRbp());
            vo.setReninActivity(bioTests.getReninActivity());
            vo.setHydrogenIonConcentration(bioTests.getHydrogenIonConcentration());
            vo.setTco2(bioTests.getTco2());
            vo.setLacticAcid(bioTests.getLacticAcid());
            vo.setMicroalbumin(bioTests.getMicroalbumin());
            vo.setPlasmaOsmoticPressure(bioTests.getPlasmaOsmoticPressure());
            vo.setAAGradient(bioTests.getAAGradient());
            vo.setAARatio(bioTests.getAARatio());
            vo.setOxygenationIndex(bioTests.getOxygenationIndex());
            vo.setEstimatedSpo2(bioTests.getEstimatedSpo2());
            vo.setEstimatedHb(bioTests.getEstimatedHb());
            vo.setBeta2Microglobulin(bioTests.getBeta2Microglobulin());
            vo.setHsCrp(bioTests.getHsCrp());
            vo.setHbsag(bioTests.getHbsag());
            vo.setAntiHbs(bioTests.getAntiHbs());
            vo.setHbeag(bioTests.getHbeag());
            vo.setAntiHbe(bioTests.getAntiHbe());
            vo.setAntiHbc(bioTests.getAntiHbc());
            vo.setTotalCholesterol(bioTests.getTotalCholesterol());
            vo.setIma(bioTests.getIma());
            vo.setAfucosidase(bioTests.getAfucosidase());
        }

        // ========== 血常规赋值 ==========
        if (source.getExperimentExamBloodRoutineRespVO() != null) {
            ExperimentExamBloodRoutineRespVO bloodRoutine = source.getExperimentExamBloodRoutineRespVO();
            vo.setWbcCount(bloodRoutine.getWbcCount());
            vo.setLymphocytePercent(bloodRoutine.getLymphocytePercent());
            vo.setMidCellPercent(bloodRoutine.getMidCellPercent());
            vo.setGranulocytePercent(bloodRoutine.getGranulocytePercent());
            vo.setLymphocyteCount(bloodRoutine.getLymphocyteCount());
            vo.setMidCellCount(bloodRoutine.getMidCellCount());
            vo.setGranulocyteCount(bloodRoutine.getGranulocyteCount());
            vo.setRbcCount(bloodRoutine.getRbcCount());
            vo.setHemoglobin(bloodRoutine.getHemoglobin());
            vo.setHematocrit(bloodRoutine.getHematocrit());
            vo.setMcv(bloodRoutine.getMcv());
            vo.setMch(bloodRoutine.getMch());
            vo.setMchc(bloodRoutine.getMchc());
            vo.setRdwCv(bloodRoutine.getRdwCv());
            vo.setRdwSd(bloodRoutine.getRdwSd());
            vo.setPlateletCount(bloodRoutine.getPlateletCount());
            vo.setMpv(bloodRoutine.getMpv());
            vo.setPdw(bloodRoutine.getPdw());
            vo.setPct(bloodRoutine.getPct());
            vo.setLargePlateletRatio(bloodRoutine.getLargePlateletRatio());
            vo.setLargePlateletCount(bloodRoutine.getLargePlateletCount());
            vo.setBasophilCount(bloodRoutine.getBasophilCount());
            vo.setBasophilPercent(bloodRoutine.getBasophilPercent());
            vo.setEosinophilCount(bloodRoutine.getEosinophilCount());
            vo.setEosinophilPercent(bloodRoutine.getEosinophilPercent());
            vo.setImmatureGranulocyteCount(bloodRoutine.getImmatureGranulocyteCount());
            vo.setImmatureGranulocytePercent(bloodRoutine.getImmatureGranulocytePercent());
            vo.setMonocyteCount(bloodRoutine.getMonocyteCount());
            vo.setMonocytePercent(bloodRoutine.getMonocytePercent());
            vo.setNucleatedRbcCount(bloodRoutine.getNucleatedRbcCount());
            vo.setNucleatedRbcPercent(bloodRoutine.getNucleatedRbcPercent());
            vo.setNeutrophilCount(bloodRoutine.getNeutrophilCount());
            vo.setNeutrophilPercent(bloodRoutine.getNeutrophilPercent());
        }

        // ========== 凝血功能赋值 ==========
        if (source.getExperimentExamCoagulationTestsRespVO() != null) {
            ExperimentExamCoagulationTestsRespVO coagulation = source.getExperimentExamCoagulationTestsRespVO();
            vo.setAptt(coagulation.getAptt());
            vo.setAntithrombinIiiActivityPercent(coagulation.getAntithrombinIiiActivityPercent());
            vo.setAntithrombinIiiActivityRate(coagulation.getAntithrombinIiiActivityRate());
            vo.setDDimerOptDensity(coagulation.getDDimerOptDensity());
            vo.setDDimerConcentration(coagulation.getDDimerConcentration());
            vo.setFibrinDegradationProductsDensity(coagulation.getFibrinDegradationProductsDensity());
            vo.setFibrinDegradationProductsConcentration(coagulation.getFibrinDegradationProductsConcentration());
            vo.setFibrinogenConcentration(coagulation.getFibrinogenConcentration());
            vo.setFibrinogenClottingTime(coagulation.getFibrinogenClottingTime());
            vo.setProthrombinTimePercent(coagulation.getProthrombinTimePercent());
            vo.setPtInr(coagulation.getPtInr());
            vo.setProthrombinTimeRatio(coagulation.getProthrombinTimeRatio());
            vo.setProthrombinTime(coagulation.getProthrombinTime());
            vo.setThrombinTime(coagulation.getThrombinTime());
            vo.setThrombinTime1(coagulation.getThrombinTime1());
            vo.setAptt1(coagulation.getAptt1());
            vo.setAptt2(coagulation.getAptt2());
            vo.setProthrombinActivity(coagulation.getProthrombinActivity());
            vo.setInr(coagulation.getInr());
        }

        // ========== 其他检查赋值 ==========
        if (source.getExperimentExamOtherDataRespVO() != null) {
            ExperimentExamOtherDataRespVO otherData = source.getExperimentExamOtherDataRespVO();
            vo.setCardiacTroponinI(otherData.getCardiacTroponinI());
            vo.setVascularUltrasoundResult(otherData.getVascularUltrasoundResult());
            vo.setEcgAnalysisResult(otherData.getEcgAnalysisResult());
        }
        return vo;
    }

//    public ControlGroupExportVO convertToControlExportVO(BasicInfoRespVO source) {
//        ControlGroupExportVO vo = new ControlGroupExportVO();
//        vo.setName(source.getName());
//        vo.setCode(source.getCode());
//        vo.setActualAge(source.getActualAge());
//        vo.setGender(source.getGender());
//        vo.setBirthDate(source.getBirthDate());
//        vo.setIdNumber(source.getIdNumber());
//
//        if (source.getBasicOtherInfoRespVO() != null) {
//            BasicOtherInfoRespVO otherInfo = source.getBasicOtherInfoRespVO();
//            vo.setMaritalStatus(otherInfo.getMaritalStatus());
//            vo.setHeight(otherInfo.getHeight());
//            vo.setWeight(otherInfo.getWeight());
//            vo.setEthnicity(otherInfo.getEthnicity());
//            vo.setEducationLevel(otherInfo.getEducationLevel());
//            vo.setFertilityStatus(otherInfo.getFertilityStatus());
//        }
//
//// 对照组流调
//        if (source.getControlSurveyDrinkingInfoRespVO() != null) {
//            ControlSurveyDrinkingInfoRespVO drinkingInfo = source.getControlSurveyDrinkingInfoRespVO();
//            vo.setDrinkingExperience(drinkingInfo.getDrinkingExperience());
//            vo.setDrinkingFrequency(drinkingInfo.getDrinkingFrequency());
//        }
//
//        if (source.getControlSurveyPastDiseasesRespVO() != null) {
//            ControlSurveyPastDiseasesRespVO pastDiseases = source.getControlSurveyPastDiseasesRespVO();
//            vo.setDisease1Name(pastDiseases.getDisease1Name());
//            vo.setDisease1Diagnosed(pastDiseases.getDisease1Diagnosed());
//            vo.setDisease1DiagnosisDate(pastDiseases.getDisease1DiagnosisDate());
//            vo.setDisease1Hospitalized(pastDiseases.getDisease1Hospitalized());
//            vo.setDisease1Treated(pastDiseases.getDisease1Treated());
//            vo.setDisease1TreatmentEffect(pastDiseases.getDisease1TreatmentEffect());
//
//            vo.setDisease2Name(pastDiseases.getDisease2Name());
//            vo.setDisease2Diagnosed(pastDiseases.getDisease2Diagnosed());
//            vo.setDisease2DiagnosisDate(pastDiseases.getDisease2DiagnosisDate());
//            vo.setDisease2Hospitalized(pastDiseases.getDisease2Hospitalized());
//            vo.setDisease2Treated(pastDiseases.getDisease2Treated());
//            vo.setDisease2TreatmentEffect(pastDiseases.getDisease2TreatmentEffect());
//
//            vo.setDisease3Name(pastDiseases.getDisease3Name());
//            vo.setDisease3Diagnosed(pastDiseases.getDisease3Diagnosed());
//            vo.setDisease3DiagnosisDate(pastDiseases.getDisease3DiagnosisDate());
//            vo.setDisease3Hospitalized(pastDiseases.getDisease3Hospitalized());
//            vo.setDisease3Treated(pastDiseases.getDisease3Treated());
//            vo.setDisease3TreatmentEffect(pastDiseases.getDisease3TreatmentEffect());
//
//            vo.setDisease4Name(pastDiseases.getDisease4Name());
//            vo.setDisease4Diagnosed(pastDiseases.getDisease4Diagnosed());
//            vo.setDisease4DiagnosisDate(pastDiseases.getDisease4DiagnosisDate());
//            vo.setDisease4Hospitalized(pastDiseases.getDisease4Hospitalized());
//            vo.setDisease4Treated(pastDiseases.getDisease4Treated());
//            vo.setDisease4TreatmentEffect(pastDiseases.getDisease4TreatmentEffect());
//
//            vo.setDisease5Name(pastDiseases.getDisease5Name());
//            vo.setDisease5Diagnosed(pastDiseases.getDisease5Diagnosed());
//            vo.setDisease5DiagnosisDate(pastDiseases.getDisease5DiagnosisDate());
//            vo.setDisease5Hospitalized(pastDiseases.getDisease5Hospitalized());
//            vo.setDisease5Treated(pastDiseases.getDisease5Treated());
//            vo.setDisease5TreatmentEffect(pastDiseases.getDisease5TreatmentEffect());
//
//            vo.setDisease6Name(pastDiseases.getDisease6Name());
//            vo.setDisease6Diagnosed(pastDiseases.getDisease6Diagnosed());
//            vo.setDisease6DiagnosisDate(pastDiseases.getDisease6DiagnosisDate());
//            vo.setDisease6Hospitalized(pastDiseases.getDisease6Hospitalized());
//            vo.setDisease6Treated(pastDiseases.getDisease6Treated());
//            vo.setDisease6TreatmentEffect(pastDiseases.getDisease6TreatmentEffect());
//        }
//
//        if (source.getControlSurveyResidenceInfoRespVO() != null) {
//            ControlSurveyResidenceInfoRespVO residenceInfo = source.getControlSurveyResidenceInfoRespVO();
//            vo.setHighlandExperience(residenceInfo.getHighlandExperience());
//            vo.setLongTermPlainExperience(residenceInfo.getLongTermPlainExperience());
//            vo.setResidence1(residenceInfo.getResidence1());
//            vo.setResidence2(residenceInfo.getResidence2());
//            vo.setResidence3(residenceInfo.getResidence3());
//        }
//
//        if (source.getControlSurveySelfAssessmentRespVO() != null) {
//            ControlSurveySelfAssessmentRespVO selfAssessment = source.getControlSurveySelfAssessmentRespVO();
//            vo.setAnnualCheckups(selfAssessment.getAnnualCheckups());
//            vo.setHealthComparison(selfAssessment.getHealthComparison());
//            vo.setHealthScore(selfAssessment.getHealthScore());
//        }
//
//        if (source.getControlSurveySmokingInfoRespVO() != null) {
//            ControlSurveySmokingInfoRespVO smokingInfo = source.getControlSurveySmokingInfoRespVO();
//            vo.setSmokingStatus(smokingInfo.getSmokingStatus());
//            vo.setSmokingYears(smokingInfo.getSmokingYears());
//            vo.setTriedQuit(smokingInfo.getTriedQuit());
//            vo.setQuitTime(smokingInfo.getQuitTime());
//        }
//
//        if (source.getControlFraminghamRespVO() != null) {
//            ControlFraminghamRespVO framingham = source.getControlFraminghamRespVO();
//            vo.setFraminghamScore(framingham.getFraminghamScore());
//            vo.setFraminghamRisk(framingham.getFraminghamRisk());
//            vo.setFraminghamRiskType(framingham.getFraminghamRiskType());
//        }
//
//// 对照组体检
//        if (source.getControlExamAbdominalUltrasoundRespVO() != null) {
//            ControlExamAbdominalUltrasoundRespVO abdominalUltrasound = source.getControlExamAbdominalUltrasoundRespVO();
//            vo.setUltrasoundDescription(abdominalUltrasound.getUltrasoundDescription());
//            vo.setUltrasoundSummary(abdominalUltrasound.getUltrasoundSummary());
//        }
//
//        if (source.getControlExamBasicTestsRespVO() != null) {
//            ControlExamBasicTestsRespVO basicTests = source.getControlExamBasicTestsRespVO();
//            vo.setSystolicPressure(basicTests.getSystolicPressure());
//            vo.setDiastolicPressure(basicTests.getDiastolicPressure());
//            vo.setPulse(basicTests.getPulse());
//            vo.setHeight(basicTests.getHeight());
//            vo.setWeight(basicTests.getWeight());
//            vo.setBmi(basicTests.getBmi());
//        }
//
//        if (source.getControlExamBiochemicalTestsRespVO() != null) {
//            ControlExamBiochemicalTestsRespVO biochemicalTests = source.getControlExamBiochemicalTestsRespVO();
//            vo.setUrea(biochemicalTests.getUrea());
//            vo.setCreatinine(biochemicalTests.getCreatinine());
//            vo.setAlt(biochemicalTests.getAlt());
//            vo.setAst(biochemicalTests.getAst());
//            vo.setTotalCholesterol(biochemicalTests.getTotalCholesterol());
//            vo.setTriglycerides(biochemicalTests.getTriglycerides());
//            vo.setHdlC(biochemicalTests.getHdlC());
//            vo.setLdlC(biochemicalTests.getLdlC());
//            vo.setUricAcid(biochemicalTests.getUricAcid());
//            vo.setTotalProtein(biochemicalTests.getTotalProtein());
//            vo.setAlbumin(biochemicalTests.getAlbumin());
//            vo.setGlobulin(biochemicalTests.getGlobulin());
//            vo.setAlbGlobRatio(biochemicalTests.getAlbGlobRatio());
//            vo.setTotalBilirubin(biochemicalTests.getTotalBilirubin());
//            vo.setDirectBilirubin(biochemicalTests.getDirectBilirubin());
//            vo.setIndirectBilirubin(biochemicalTests.getIndirectBilirubin());
//            vo.setGlycatedHemoglobin(biochemicalTests.getGlycatedHemoglobin());
//            vo.setPotassium(biochemicalTests.getPotassium());
//            vo.setSodium(biochemicalTests.getSodium());
//            vo.setChloride(biochemicalTests.getChloride());
//            vo.setCalcium(biochemicalTests.getCalcium());
//            vo.setPhosphorus(biochemicalTests.getPhosphorus());
//            vo.setMagnesium(biochemicalTests.getMagnesium());
//            vo.setFastingGlucose(biochemicalTests.getFastingGlucose());
//            vo.setProthrombinTime(biochemicalTests.getProthrombinTime());
//            vo.setProthrombinActivity(biochemicalTests.getProthrombinActivity());
//            vo.setInr(biochemicalTests.getInr());
//            vo.setFibrinogen(biochemicalTests.getFibrinogen());
//            vo.setAptt(biochemicalTests.getAptt());
//            vo.setThrombinTime(biochemicalTests.getThrombinTime());
//        }
//
//        if (source.getControlExamBloodRoutineRespVO() != null) {
//            ControlExamBloodRoutineRespVO bloodRoutine = source.getControlExamBloodRoutineRespVO();
//            vo.setWbc(bloodRoutine.getWbc());
//            vo.setRbc(bloodRoutine.getRbc());
//            vo.setHemoglobin(bloodRoutine.getHemoglobin());
//            vo.setHematocrit(bloodRoutine.getHematocrit());
//            vo.setMcv(bloodRoutine.getMcv());
//            vo.setMch(bloodRoutine.getMch());
//            vo.setMchc(bloodRoutine.getMchc());
//            vo.setRdwCv(bloodRoutine.getRdwCv());
//            vo.setRdwSd(bloodRoutine.getRdwSd());
//            vo.setPlateletCount(bloodRoutine.getPlateletCount());
//            vo.setPlateletCrit(bloodRoutine.getPlateletCrit());
//            vo.setMpv(bloodRoutine.getMpv());
//            vo.setPdw(bloodRoutine.getPdw());
//            vo.setNeutrophils(bloodRoutine.getNeutrophils());
//            vo.setLymphocytes(bloodRoutine.getLymphocytes());
//            vo.setMonocytes(bloodRoutine.getMonocytes());
//            vo.setEosinophils(bloodRoutine.getEosinophils());
//            vo.setBasophils(bloodRoutine.getBasophils());
//            vo.setNeutrophilsPercentage(bloodRoutine.getNeutrophilsPercentage());
//            vo.setLymphocytesPercentage(bloodRoutine.getLymphocytesPercentage());
//            vo.setMonocytesPercentage(bloodRoutine.getMonocytesPercentage());
//            vo.setEosinophilsPercentage(bloodRoutine.getEosinophilsPercentage());
//            vo.setBasophilsPercentage(bloodRoutine.getBasophilsPercentage());
//        }
//
//        if (source.getControlExamEcgRespVO() != null) {
//            ControlExamEcgRespVO ecg = source.getControlExamEcgRespVO();
//            vo.setEcgDescription(ecg.getEcgDescription());
//        }
//
//        if (source.getControlExamPastMedicalHistoryRespVO() != null) {
//            ControlExamPastMedicalHistoryRespVO pastMedicalHistory = source.getControlExamPastMedicalHistoryRespVO();
//            vo.setInternalDiseaseHistory(pastMedicalHistory.getInternalDiseaseHistory());
//            vo.setExternalDiseaseHistory(pastMedicalHistory.getExternalDiseaseHistory());
//        }
//        return vo;
//    }

    // 1. 评分分级函数
    public String getScoreCategory(BigDecimal score) {
        if (score == null) {
            return null;
        }
        if (score.compareTo(BigDecimal.valueOf(6)) < 0) {
            return "阴";
        } else if (score.compareTo(BigDecimal.valueOf(15)) <= 0) {
            return "轻";
        } else if (score.compareTo(BigDecimal.valueOf(25)) <= 0) {
            return "中";
        } else {
            return "重"; // >25
        }
    }

    @GetMapping("/exportProspective")
    @Operation(summary = "导出基础信息数据")
    @PreAuthorize("@ss.hasPermission('review:basic-info:export')")
    public void exportProspective(@Valid BasicInfoPageReqVO pageReqVO, HttpServletResponse response) throws IOException {
        // 1. 查询数据（不分页，获取全部数据）
        pageReqVO.setPageSize(Integer.MAX_VALUE); // 设置为最大数量，获取所有数据
        PageResult<ProspectiveBasicInfoDO> pageResult = prospectiveBasicInfoService.getDataByParamPage(pageReqVO);
        List<BasicInfoRespVO> dataList = BeanUtils.toBean(pageResult, BasicInfoRespVO.class).getList();

        if ("1".equals(pageReqVO.getGroup())) {
            // 2. 转换为导出VO
            List<ExperimentGroupExportVO> exportList = dataList.stream()
                    .map(this::convertToExperimentExportVO)
                    .collect(Collectors.toList());

            // 3. 设置响应头
            String fileName = URLEncoder.encode("前瞻性性实验组数据.xlsx", "UTF-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), ExperimentGroupExportVO.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("基础信息").build();
            excelWriter.write(exportList, writeSheet);
            excelWriter.finish();
        } else {
//            // 2. 转换为导出VO
//            List<ControlGroupExportVO> exportList = dataList.stream()
//                    .map(this::convertToControlExportVO)
//                    .collect(Collectors.toList());
//
//            // 3. 设置响应头
//            String fileName = URLEncoder.encode("前瞻性对照组数据.xlsx", "UTF-8");
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//
//            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), ControlGroupExportVO.class).build();
//            WriteSheet writeSheet = EasyExcel.writerSheet("基础信息").build();
//            excelWriter.write(exportList, writeSheet);
//            excelWriter.finish();
        }
    }

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/predict")
    public ResponseEntity<?> forwardPredict(@RequestBody Map<String, Object> frontParams) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // === 构造请求参数（去掉“姓名”字段） ===
            Map<String, Object> requestMap = new HashMap<>(frontParams);
            requestMap.remove("姓名");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestMap, headers);

            // === 调用目标接口 ===
            String targetUrl = "http://127.0.0.1:45000/api/predict";
            ResponseEntity<String> response = restTemplate.postForEntity(targetUrl, requestEntity, String.class);

            // === 构造历史记录对象 ===
            HistorySaveReqVO historySaveReqVO = new HistorySaveReqVO();

            // 使用 LinkedHashMap 保留顺序
            Map<String, Object> savedParams = new LinkedHashMap<>(frontParams);

            // 替换高血压字段
//            if (savedParams.containsKey("高血压_y")) {
//                Object val = savedParams.remove("高血压_y");
//                savedParams.put("高血压", "1".equals(val.toString()) || "true".equalsIgnoreCase(val.toString()) ? "是" : "否");
//            }

            // 替换“时间_1”为“驻扎时间”
//            if (savedParams.containsKey("时间_1")) {
//                Object timeVal = savedParams.remove("时间_1");
//                savedParams.put("驻扎时间", timeVal);
//            }

            // 转换为 JSON 字符串保存
            String paramsStr = objectMapper.writeValueAsString(savedParams);
            historySaveReqVO.setParm(paramsStr);

            // 获取评分并保存
            String responseBody = response.getBody();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            String score = rootNode.path("data").path("score").asText();
            historySaveReqVO.setSocre(score);

            historyService.createHistory(historySaveReqVO);
            return ResponseEntity.ok(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("调用预警服务失败：" + e.getMessage());
        }
    }

    @GetMapping("/importExperimentExamecgAnalysisResult")
    public String importExperimentExamecgAnalysisResult(@RequestParam String fileName, @RequestParam Integer sheetNo, @RequestParam Integer timePoint) {

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerVipAnalysisResult(
                        prospectiveBasicInfoService
                        , experimentExamOtherDataService
                        , timePoint))
                .headRowNumber(1) //设置表头所在行，索引从 0 开始，数据开始行
                .sheet(sheetNo)
                .doRead();

        return "心电-第" + timePoint + "时相点数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerVipAnalysisResult extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService
        private ProspectiveBasicInfoService prospectiveBasicInfoService;
        private ExperimentExamOtherDataService experimentExamOtherDataService;
        private Integer timePoint;

        // 构造函数注入服务
        public IndexListenerVipAnalysisResult(
                ProspectiveBasicInfoService prospectiveBasicInfoService
                , ExperimentExamOtherDataService experimentExamOtherDataService
                , Integer timePoint) {
            this.prospectiveBasicInfoService = prospectiveBasicInfoService;
            this.experimentExamOtherDataService = experimentExamOtherDataService;
            this.timePoint = timePoint;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            ExperimentExamOtherDataSaveReqVO experimentExamOtherDataSaveReqVO = new ExperimentExamOtherDataSaveReqVO();

            Long generatedId = 0L;
            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setCode(rowData.get(0));
            List<ProspectiveBasicInfoDO> prospectiveBasicInfoDOList = prospectiveBasicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (prospectiveBasicInfoDOList != null && prospectiveBasicInfoDOList.size() == 1) {
                generatedId = prospectiveBasicInfoDOList.get(0).getId();
                experimentExamOtherDataSaveReqVO.setPersonId(generatedId);
                // 使用StringBuilder合并数据
                StringBuilder combinedResult = new StringBuilder();
                for (int i = 10; i <= 14; i++) {
                    String value = rowData.get(i);
                    if (value != null && !value.trim().isEmpty()) {
                        if (combinedResult.length() > 0) {
                            combinedResult.append("，");
                        }
                        combinedResult.append(value);
                    }
                }
                experimentExamOtherDataSaveReqVO.setEcgAnalysisResult(combinedResult.toString());
                experimentExamOtherDataSaveReqVO.setTimePoint(timePoint); // 时相
                experimentExamOtherDataService.createExperimentExamOtherData(experimentExamOtherDataSaveReqVO);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }
}

//http://localhost:48080/admin-api/prospective/basic-info/importExperimentSurvey1
//http://localhost:48080/admin-api/prospective/basic-info/importExperimentSurvey2
//http://localhost:48080/admin-api/prospective/basic-info/importExperimentSurvey3
//fileName = /Users/jsheng/Downloads/整理导入/实验组/36324.xlsx
//type = 181-23

//http://localhost:48080/admin-api/prospective/basic-info/importExperimentExam1
//http://localhost:48080/admin-api/prospective/basic-info/importExperimentExam2
//http://localhost:48080/admin-api/prospective/basic-info/importExperimentExam3
//fileName = /Users/jsheng/Downloads/整理导入/实验组/18123-检查.xlsx
//type = 181-23

//http://localhost:48080/admin-api/prospective/basic-info/importControlSurvey
//fileName = /Users/jsheng/Downloads/整理导入/对照组/对照组前瞻.xlsx
//type = 对照组

//http://localhost:48080/admin-api/prospective/basic-info/importControlExam
//fileName = /Users/jsheng/Downloads/整理导入/对照组/对照组-检查前瞻.xlsx
//type = 对照组