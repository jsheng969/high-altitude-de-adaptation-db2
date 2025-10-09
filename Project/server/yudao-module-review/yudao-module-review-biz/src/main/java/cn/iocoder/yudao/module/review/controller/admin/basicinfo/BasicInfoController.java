package cn.iocoder.yudao.module.review.controller.admin.basicinfo;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.BasicOtherInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.BasicOtherInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.ControlDiseaseSpectrumRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.ControlDiseaseSpectrumSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.ControlExamAbdominalUltrasoundRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.ControlExamAbdominalUltrasoundSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.ControlExamBasicTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.ControlExamBasicTestsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.ControlExamBiochemicalTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.ControlExamBiochemicalTestsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.ControlExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.ControlExamBloodRoutineSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.ControlExamEcgSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.ControlExamPastMedicalHistoryRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.ControlExamPastMedicalHistorySaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.ControlFraminghamRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.ControlFraminghamSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.ControlSurveyDrinkingInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.ControlSurveyDrinkingInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.ControlSurveyPastDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.ControlSurveyPastDiseasesSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.ControlSurveyResidenceInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.ControlSurveyResidenceInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.ControlSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.ControlSurveySelfAssessmentSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.ControlSurveySmokingInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.ControlSurveySmokingInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.ExperimentDiseaseSpectrumRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.ExperimentDiseaseSpectrumSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.ExperimentExamAbdominalUltrasoundRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.ExperimentExamAbdominalUltrasoundSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.ExperimentExamBasicTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.ExperimentExamBasicTestsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.ExperimentExamBiochemicalTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.ExperimentExamBiochemicalTestsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.ExperimentExamEcgSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.ExperimentExamPastMedicalHistoryRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.ExperimentExamPastMedicalHistorySaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.ExperimentFraminghamRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.ExperimentFraminghamSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.ExperimentSurveyDietRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.ExperimentSurveyDietSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.ExperimentSurveyDrinkingRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.ExperimentSurveyDrinkingSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.ExperimentSurveyExerciseRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.ExperimentSurveyExerciseSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.ExperimentSurveyFamilyDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.ExperimentSurveyFamilyDiseasesSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.ExperimentSurveyHighlandDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.ExperimentSurveyHighlandDiseasesSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.ExperimentSurveyHighlandReactionRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.ExperimentSurveyHighlandReactionSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.ExperimentSurveyHighlandReactionSymptomsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.ExperimentSurveyHighlandReactionSymptomsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.ExperimentSurveyNewDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.ExperimentSurveyNewDiseasesSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.ExperimentSurveyNewDiseasesPostReturnRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.ExperimentSurveyNewDiseasesPostReturnSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.ExperimentSurveyPostReturnInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.ExperimentSurveyPostReturnInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.ExperimentSurveyServiceInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.ExperimentSurveyServiceInfoSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.ExperimentSurveySleepRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.ExperimentSurveySleepSaveReqVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.ExperimentSurveySmokingRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.ExperimentSurveySmokingSaveReqVO;
import cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo.BasicOtherInfoDO;
import cn.iocoder.yudao.module.review.service.basicotherinfo.BasicOtherInfoService;
import cn.iocoder.yudao.module.review.service.controldiseasespectrum.ControlDiseaseSpectrumService;
import cn.iocoder.yudao.module.review.service.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundService;
import cn.iocoder.yudao.module.review.service.controlexambasictests.ControlExamBasicTestsService;
import cn.iocoder.yudao.module.review.service.controlexambiochemicaltests.ControlExamBiochemicalTestsService;
import cn.iocoder.yudao.module.review.service.controlexambloodroutine.ControlExamBloodRoutineService;
import cn.iocoder.yudao.module.review.service.controlexamecg.ControlExamEcgService;
import cn.iocoder.yudao.module.review.service.controlexampastmedicalhistory.ControlExamPastMedicalHistoryService;
import cn.iocoder.yudao.module.review.service.controlframingham.ControlFraminghamService;
import cn.iocoder.yudao.module.review.service.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoService;
import cn.iocoder.yudao.module.review.service.controlsurveypastdiseases.ControlSurveyPastDiseasesService;
import cn.iocoder.yudao.module.review.service.controlsurveyresidenceinfo.ControlSurveyResidenceInfoService;
import cn.iocoder.yudao.module.review.service.controlsurveyselfassessment.ControlSurveySelfAssessmentService;
import cn.iocoder.yudao.module.review.service.controlsurveysmokinginfo.ControlSurveySmokingInfoService;
import cn.iocoder.yudao.module.review.service.experimentdiseasespectrum.ExperimentDiseaseSpectrumService;
import cn.iocoder.yudao.module.review.service.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundService;
import cn.iocoder.yudao.module.review.service.experimentexambasictests.ExperimentExamBasicTestsService;
import cn.iocoder.yudao.module.review.service.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsService;
import cn.iocoder.yudao.module.review.service.experimentexambloodroutine.ExperimentExamBloodRoutineService;
import cn.iocoder.yudao.module.review.service.experimentexamecg.ExperimentExamEcgService;
import cn.iocoder.yudao.module.review.service.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryService;
import cn.iocoder.yudao.module.review.service.experimentframingham.ExperimentFraminghamService;
import cn.iocoder.yudao.module.review.service.experimentsurveydiet.ExperimentSurveyDietService;
import cn.iocoder.yudao.module.review.service.experimentsurveydrinking.ExperimentSurveyDrinkingService;
import cn.iocoder.yudao.module.review.service.experimentsurveyexercise.ExperimentSurveyExerciseService;
import cn.iocoder.yudao.module.review.service.experimentsurveyfamilydiseases.ExperimentSurveyFamilyDiseasesService;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseases.ExperimentSurveyHighlandDiseasesService;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlanddiseasesduringservice.ExperimentSurveyHighlandDiseasesDuringServiceService;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreaction.ExperimentSurveyHighlandReactionService;
import cn.iocoder.yudao.module.review.service.experimentsurveyhighlandreactionsymptoms.ExperimentSurveyHighlandReactionSymptomsService;
import cn.iocoder.yudao.module.review.service.experimentsurveynewdiseases.ExperimentSurveyNewDiseasesService;
import cn.iocoder.yudao.module.review.service.experimentsurveynewdiseasespostreturn.ExperimentSurveyNewDiseasesPostReturnService;
import cn.iocoder.yudao.module.review.service.experimentsurveypostreturninfo.ExperimentSurveyPostReturnInfoService;
import cn.iocoder.yudao.module.review.service.experimentsurveypostreturnsymptoms.ExperimentSurveyPostReturnSymptomsService;
import cn.iocoder.yudao.module.review.service.experimentsurveyselfassessment.ExperimentSurveySelfAssessmentService;
import cn.iocoder.yudao.module.review.service.experimentsurveyserviceinfo.ExperimentSurveyServiceInfoService;
import cn.iocoder.yudao.module.review.service.experimentsurveysleep.ExperimentSurveySleepService;
import cn.iocoder.yudao.module.review.service.experimentsurveysmoking.ExperimentSurveySmokingService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;


import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;
import static java.lang.Integer.parseInt;

import cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicinfo.BasicInfoDO;
import cn.iocoder.yudao.module.review.service.basicinfo.BasicInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "管理后台 - 回顾性基础信息")
@RestController
@RequestMapping("/review/basic-info")
@Validated
public class BasicInfoController {

    @Resource
    private BasicInfoService basicInfoService;
    @Resource
    private BasicOtherInfoService basicOtherInfoService;
    @Resource
    private ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService;
    @Resource
    private ControlExamBasicTestsService controlExamBasicTestsService;
    @Resource
    private ControlExamBiochemicalTestsService controlExamBiochemicalTestsService;
    @Resource
    private ControlExamBloodRoutineService controlExamBloodRoutineService;
    @Resource
    private ControlExamEcgService controlExamEcgService;
    @Resource
    private ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService;
    @Resource
    private ControlSurveyDrinkingInfoService controlSurveyDrinkingInfoService;
    @Resource
    private ControlSurveyPastDiseasesService controlSurveyPastDiseasesService;
    @Resource
    private ControlSurveyResidenceInfoService controlSurveyResidenceInfoService;
    @Resource
    private ControlSurveySelfAssessmentService controlSurveySelfAssessmentService;
    @Resource
    private ControlSurveySmokingInfoService controlSurveySmokingInfoService;
    @Resource
    private ExperimentExamAbdominalUltrasoundService experimentExamAbdominalUltrasoundService;
    @Resource
    private ExperimentExamBasicTestsService experimentExamBasicTestsService;
    @Resource
    private ExperimentExamBiochemicalTestsService experimentExamBiochemicalTestsService;
    @Resource
    private ExperimentExamBloodRoutineService experimentExamBloodRoutineService;
    @Resource
    private ExperimentExamEcgService experimentExamEcgService;
    @Resource
    private ExperimentExamPastMedicalHistoryService experimentExamPastMedicalHistoryService;
    @Resource
    private ExperimentSurveyDietService experimentSurveyDietService;
    @Resource
    private ExperimentSurveyDrinkingService experimentSurveyDrinkingService;
    @Resource
    private ExperimentSurveyExerciseService experimentSurveyExerciseService;
    @Resource
    private ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService;
    @Resource
    private ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService;
    @Resource
    private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
    @Resource
    private ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService;
    @Resource
    private ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService;
    @Resource
    private ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService;
    @Resource
    private ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService;
    @Resource
    private ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService;
    @Resource
    private ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService;
    @Resource
    private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
    @Resource
    private ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService;
    @Resource
    private ExperimentSurveySleepService experimentSurveySleepService;
    @Resource
    private ExperimentSurveySmokingService experimentSurveySmokingService;
    @Resource
    private ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService;
    @Resource
    private ControlDiseaseSpectrumService controlDiseaseSpectrumService;
    @Resource
    private ExperimentFraminghamService experimentFraminghamService;
    @Resource
    private ControlFraminghamService controlFraminghamService;


    @PostMapping("/create")
    @Operation(summary = "创建基础信息")
    @PreAuthorize("@ss.hasPermission('review:basic-info:create')")
    public CommonResult<Long> createBasicInfo(@Valid @RequestBody BasicInfoSaveReqVO createReqVO) {
        return success(basicInfoService.createBasicInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础信息")
    @PreAuthorize("@ss.hasPermission('review:basic-info:update')")
    public CommonResult<Boolean> updateBasicInfo(@Valid @RequestBody BasicInfoSaveReqVO updateReqVO) {
        basicInfoService.updateBasicInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('review:basic-info:delete')")
    public CommonResult<Boolean> deleteBasicInfo(@RequestParam("id") Long id) {
        basicInfoService.deleteBasicInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('review:basic-info:query')")
    public CommonResult<BasicInfoRespVO> getBasicInfo(@RequestParam("id") Long id) {
        BasicInfoDO basicInfo = basicInfoService.getBasicInfo(id);
        return success(BeanUtils.toBean(basicInfo, BasicInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础信息分页")
    @PreAuthorize("@ss.hasPermission('review:basic-info:query')")
    public CommonResult<PageResult<BasicInfoRespVO>> getBasicInfoPage(@Valid BasicInfoPageReqVO pageReqVO) {
        PageResult<BasicInfoDO> pageResult = basicInfoService.getBasicInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础信息 Excel")
    @PreAuthorize("@ss.hasPermission('review:basic-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBasicInfoExcel(@Valid BasicInfoPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BasicInfoDO> list = basicInfoService.getBasicInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础信息.xls", "数据", BasicInfoRespVO.class,
                BeanUtils.toBean(list, BasicInfoRespVO.class));
    }

    @GetMapping("/importExcelExperimentSurvey")
    public String importExcelExperimentSurvey() {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/回顾性数据/汇总-实验组-流调.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\汇总-实验组-流调.xlsx";
        String fileName = "D:\\01.2 实验组-流调.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener(
                        basicInfoService
                        , basicOtherInfoService
                        , experimentSurveyDietService
                        , experimentSurveyDrinkingService
                        , experimentSurveyExerciseService
                        , experimentSurveyFamilyDiseasesService
                        , experimentSurveyHighlandDiseasesService
                        , experimentSurveyHighlandDiseasesDuringServiceService
                        , experimentSurveyHighlandReactionService
                        , experimentSurveyHighlandReactionSymptomsService
                        , experimentSurveyNewDiseasesService
                        , experimentSurveyNewDiseasesPostReturnService
                        , experimentSurveyPostReturnInfoService
                        , experimentSurveyPostReturnSymptomsService
                        , experimentSurveySelfAssessmentService
                        , experimentSurveyServiceInfoService
                        , experimentSurveySleepService
                        , experimentSurveySmokingService))
                .sheet()
                .doRead();

        return "实验组流调数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private BasicOtherInfoService basicOtherInfoService;
        private ExperimentSurveyDietService experimentSurveyDietService;
        private ExperimentSurveyDrinkingService experimentSurveyDrinkingService;
        private ExperimentSurveyExerciseService experimentSurveyExerciseService;
        private ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService;
        private ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService;
        private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
        private ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService;
        private ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService;
        private ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService;
        private ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService;
        private ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService;
        private ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService;
        private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
        private ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService;
        private ExperimentSurveySleepService experimentSurveySleepService;
        private ExperimentSurveySmokingService experimentSurveySmokingService;

        // 构造函数注入服务
        public IndexListener(BasicInfoService basicInfoService, BasicOtherInfoService basicOtherInfoService
                , ExperimentSurveyDietService experimentSurveyDietService
                , ExperimentSurveyDrinkingService experimentSurveyDrinkingService
                , ExperimentSurveyExerciseService experimentSurveyExerciseService
                , ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService
                , ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService
                , ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService
                , ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService
                , ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService
                , ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService
                , ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService
                , ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService
                , ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService
                , ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService
                , ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService
                , ExperimentSurveySleepService experimentSurveySleepService
                , ExperimentSurveySmokingService experimentSurveySmokingService) {
            this.basicInfoService = basicInfoService;
            this.basicOtherInfoService = basicOtherInfoService;
            this.experimentSurveyDietService = experimentSurveyDietService;
            this.experimentSurveyDrinkingService = experimentSurveyDrinkingService;
            this.experimentSurveyExerciseService = experimentSurveyExerciseService;
            this.experimentSurveyFamilyDiseasesService = experimentSurveyFamilyDiseasesService;
            this.experimentSurveyHighlandDiseasesService = experimentSurveyHighlandDiseasesService;
            this.experimentSurveyHighlandDiseasesDuringServiceService = experimentSurveyHighlandDiseasesDuringServiceService;
            this.experimentSurveyHighlandReactionService = experimentSurveyHighlandReactionService;
            this.experimentSurveyHighlandReactionSymptomsService = experimentSurveyHighlandReactionSymptomsService;
            this.experimentSurveyNewDiseasesService = experimentSurveyNewDiseasesService;
            this.experimentSurveyNewDiseasesPostReturnService = experimentSurveyNewDiseasesPostReturnService;
            this.experimentSurveyPostReturnInfoService = experimentSurveyPostReturnInfoService;
            this.experimentSurveyPostReturnSymptomsService = experimentSurveyPostReturnSymptomsService;
            this.experimentSurveySelfAssessmentService = experimentSurveySelfAssessmentService;
            this.experimentSurveyServiceInfoService = experimentSurveyServiceInfoService;
            this.experimentSurveySleepService = experimentSurveySleepService;
            this.experimentSurveySmokingService = experimentSurveySmokingService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyServiceInfoSaveReqVO experimentSurveyServiceInfo = new ExperimentSurveyServiceInfoSaveReqVO();
            ExperimentSurveySmokingSaveReqVO experimentSurveySmoking = new ExperimentSurveySmokingSaveReqVO();
            ExperimentSurveyDrinkingSaveReqVO experimentSurveyDrinking = new ExperimentSurveyDrinkingSaveReqVO();
            ExperimentSurveySelfAssessmentSaveReqVO experimentSurveySelfAssessment = new ExperimentSurveySelfAssessmentSaveReqVO();
            ExperimentSurveyFamilyDiseasesSaveReqVO experimentSurveyFamilyDiseases = new ExperimentSurveyFamilyDiseasesSaveReqVO();
            ExperimentSurveyHighlandReactionSaveReqVO experimentSurveyHighlandReaction = new ExperimentSurveyHighlandReactionSaveReqVO();
            ExperimentSurveyHighlandDiseasesSaveReqVO experimentSurveyHighlandDiseases = new ExperimentSurveyHighlandDiseasesSaveReqVO();
            ExperimentSurveyHighlandReactionSymptomsSaveReqVO experimentSurveyHighlandReactionSymptoms = new ExperimentSurveyHighlandReactionSymptomsSaveReqVO();
            ExperimentSurveyPostReturnSymptomsSaveReqVO experimentSurveyPostReturnSymptoms = new ExperimentSurveyPostReturnSymptomsSaveReqVO();
            ExperimentSurveyPostReturnInfoSaveReqVO experimentSurveyPostReturnInfo = new ExperimentSurveyPostReturnInfoSaveReqVO();
            ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO experimentSurveyHighlandDiseasesDuringService = new ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO();
            ExperimentSurveyNewDiseasesPostReturnSaveReqVO experimentSurveyNewDiseasesPostReturn = new ExperimentSurveyNewDiseasesPostReturnSaveReqVO();
            ExperimentSurveyNewDiseasesSaveReqVO experimentSurveyNewDiseases = new ExperimentSurveyNewDiseasesSaveReqVO();
            ExperimentSurveyExerciseSaveReqVO experimentSurveyExercise = new ExperimentSurveyExerciseSaveReqVO();
            ExperimentSurveyDietSaveReqVO experimentSurveyDiet = new ExperimentSurveyDietSaveReqVO();
            ExperimentSurveySleepSaveReqVO experimentSurveySleep = new ExperimentSurveySleepSaveReqVO();
            //表头
            //,姓名,性别,入伍年份,进入高原年份,退役年份,服役期间职务,最高学历,生育情况,民族,婚姻情况,身高,体重,退役体重,是否吸烟,每日抽烟数量,开始吸烟年龄,烟龄,是否尝试戒烟,高原/平原吸烟情况,烟龄,戒烟时间,高原/平原吸烟情况,饮酒经历,仍在饮酒,饮酒频率,是否过量饮酒,啤酒,白酒,红酒,鸡尾酒,烈酒,其他,与同龄人相比，您认为目前自己的身体健康状况如何,您认为自己身体健康状况能得________分,高血压,高血脂,先天性心脏病,肺心病,中风/脑溢血,冠心病/心绞痛,心肌梗塞,窦性心动过缓,窦性心动过速,窦性心律不齐,房颤,阵发性室上速,频发房性早搏,频发室性早搏,房室传导阻滞,室性心动过速,其他,慢性支气管炎,哮喘,肺结核,肺气肿,肺炎,慢性阻塞性肺疾病,其他,甲状腺疾病,糖尿病,"高尿酸血症（痛风）	",慢性肠胃炎,十二指肠溃疡,胃溃疡,胆结石,结肠息肉,乙型肝炎,胆囊炎,其他,老年痴呆,帕金森综合征,多发性硬化病,癫痫,肺癌,肝癌,胃癌,直/结肠癌,胰腺癌,食管癌,前列腺癌,乳腺癌,宫颈癌,其他,高原服役地点,海拔高度,年,月,高原服役地点,海拔高度,年,月,高原服役地点,海拔高度,年,月,高原服役地点,海拔高度,年,月,高原服役地点,海拔高度,年,月,高原服役地点,海拔高度,年,月,高原任务的类型,是否发生过高原反应,高原反应次数,高原反应次数记不清,多次高原反应，高原反应变化情况,急性高原反应,高原肺水肿,高原脑水肿,高原心脏病,高原红细胞增多症,其他,头痛,呕吐,头昏,恶心,心慌,食欲不振,胸闷,眼花,气短,腹胀,腹泻,疲倦,嗜睡,头昏,眩晕,精力不集中,反应迟钝,记忆减退,失眠,多梦,心前区痛,心慌,脉率减慢,紫绀,血压波动,皮肤出血,皮肤瘀斑,贫血,咽喉痛,咳嗽,多痰,气喘,胸闷,体重减轻,食欲增加,厌食,便秘,腹泻,腹痛,腹胀,黄疸,手足麻木,肢体水肿,面部水肿,脱发,夜尿增多,成都,成都居住时间,昆明,昆明居住时间,西宁,西宁居住时间,其他,其他居住时间,从高原返回后您的工作情况,每年体检/就诊次数,高血压 ,心肌梗死,冠心病,肺心病,四肢静脉血栓,窦性心动过缓,窦性心动过速,窦性心律不齐,房颤,阵发性室上速,频发房性早搏,频发室性早搏,房室传导阻滞,室性心动过速,其他,眩晕 ,短暂性脑缺血,脑梗死/脑血栓,脑出血,其他,高血脂,糖尿病,高尿酸血症（痛风）,甲状腺疾病,其他,失眠,肿瘤,其他,高血压 ,心肌梗死,冠心病,肺心病,四肢静脉血栓,窦性心动过缓,窦性心动过速,窦性心律不齐,房颤,阵发性室上速,频发房性早搏,频发室性早搏,房室传导阻滞,室性心动过速,其他,眩晕 ,短暂性脑缺血,脑梗死/脑血栓,脑出血,其他,高血脂,糖尿病,高尿酸血症（痛风）,甲状腺疾病,其他,失眠,肿瘤,其他,新发疾病1名称,该病是否在二级或二级以上医院被诊断,该病的诊断时间,是否因该病住院治疗,是否使用药物进行治疗,药物，治疗效果,新发疾病2名称,该病是否在二级或二级以上医院被诊断,该病的诊断时间,是否因该病住院治疗,是否使用药物进行治疗,药物，治疗效果,新发疾病3名称,该病是否在二级或二级以上医院被诊断,该病的诊断时间,是否因该病住院治疗,是否使用药物进行治疗,药物，治疗效果,新发疾病4名称,该病是否在二级或二级以上医院被诊断,该病的诊断时间,是否因该病住院治疗,是否使用药物进行治疗,药物，治疗效果,是否有规律的体育锻炼,参加体育锻炼的频率,参加体育锻炼的时长,哪种类型的体育锻炼,胸闷、气促,医生指导下体育锻炼,饮食习惯,饮用水,茶水,果汁,碳酸饮料,咖啡,牛奶 ,其他,晚上睡觉时间（点）,入睡需要时间（分钟）,起床时间（点）,实际睡眠时间（小时）,入睡困难,夜间易醒或早醒,夜间去厕所,呼吸不畅,咳嗽或鼾声高,感觉冷,感觉热,做恶梦,疼痛不适,其他影响睡眠的事情,催眠药,感到困倦,精力不足,自评睡眠情况
            //对应上面表头的示例数据
            //1,丁辉,男,1989,2018,2010,专业技术军官,大专,已生育，高原期间生育,汉族,已婚,174,61,61,吸烟,20,20,32,是,高原和平原期间均吸烟,0,0,0,是,是,偶尔,有时,0,是,0,0,0,0,一般,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,是,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,林芝,3000,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,重体力劳动,1,0,是,时重时轻，无规律,是,0,0,0,0,0,是,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,是,12,0,0,0,0,0,0,高原返回后在家休息 ,3年以上1次,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,是,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,肺气肿,肺气肿,是,不到1年,否,否,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,否,1-2次/每周,30-60分钟/次,低强度运动,偶尔,否,饮食不规律,0,是,0,0,0,0,0,11,30,7,8,0,0,0,0,0,0,0,0,0,0,0,1次,0,　较好


            basicInfo.setName(rowData.get(1)); // 姓名
            basicInfo.setGender(rowData.get(2)); // 性别
            basicInfo.setHighestEducation(rowData.get(7)); // 最高学历
            basicInfo.setEthnicity(rowData.get(9)); // 民族
            basicInfo.setMaritalStatus(rowData.get(10)); // 婚姻情况
            basicInfo.setHeight(extractNumber(rowData.get(11))); // 身高
            basicInfo.setWeight(extractNumber(rowData.get(12))); // 体重
            basicInfo.setType(1); // 1表示实验组

            // 保存 BasicInfoRespVO 到数据库
            Long generatedId = basicInfoService.createBasicInfo(basicInfo);

            basicOtherInfo.setPersonId(generatedId);
            basicOtherInfo.setFertilityStatus(rowData.get(8));              // 生育情况
            // 获取第13列的值
            String weightData = rowData.get(13).toString();  // 获取字段并转换为字符串
            BigDecimal retiredWeight = BigDecimal.ZERO;  // 默认值为0
            // 判断是否包含 "Kg"，并处理数值部分
            if (weightData != null) {
                // 如果包含 "Kg"，去掉 "Kg" 部分
                if (weightData.endsWith("Kg")) {
                    weightData = weightData.replaceAll("Kg", "");  // 去掉单位 "Kg"
                }
                // 判断剩余部分是否为有效数字
                if (weightData.matches("\\d+")) {  // 只有数字（整数）部分
                    retiredWeight = parseBigDecimal(weightData);  // 转换为BigDecimal
                } else {
                    // 如果不是有效的数字，默认为0
                    retiredWeight = BigDecimal.ZERO;
                }
            }
            basicOtherInfo.setRetiredWeight(retiredWeight);  // 设置退役体重  // 退役体重（第13列）

//            实验组流调-饮食习惯
            experimentSurveyDiet.setPersonId(generatedId);
            experimentSurveyDiet.setEatingHabits(rowData.get(261)); // 饮食习惯（第261列）
            experimentSurveyDiet.setDrinkingWater(rowData.get(262)); // 饮用水（第262列）
            experimentSurveyDiet.setTea(rowData.get(263)); // 茶水（第263列）
            experimentSurveyDiet.setFruitJuice(rowData.get(264)); // 果汁（第264列）
            experimentSurveyDiet.setCarbonatedDrinks(rowData.get(265)); // 碳酸饮料（第265列）
            experimentSurveyDiet.setCoffee(rowData.get(266)); // 咖啡（第266列）
            experimentSurveyDiet.setMilk(rowData.get(267)); // 牛奶（第267列）

//            实验组流调-饮酒情况
            experimentSurveyDrinking.setPersonId(generatedId);
            experimentSurveyDrinking.setDrinkingExperience(rowData.get(23));  // 饮酒经历（第23列）
            experimentSurveyDrinking.setStillDrinking(parseBoolean(rowData.get(24)));  // 仍在饮酒（第24列）
            experimentSurveyDrinking.setDrinkingFrequency(rowData.get(25));  // 饮酒频率（第25列）
            experimentSurveyDrinking.setOverDrinking(parseBoolean(rowData.get(26)));  // 是否过量饮酒（第26列）
            experimentSurveyDrinking.setBeer(parseBoolean(rowData.get(27)));  // 啤酒（第27列）
            experimentSurveyDrinking.setLiquor(parseBoolean(rowData.get(28)));  // 白酒（第28列）
            experimentSurveyDrinking.setRedWine(parseBoolean(rowData.get(29)));  // 红酒（第29列）
            experimentSurveyDrinking.setCocktails(parseBoolean(rowData.get(30)));  // 鸡尾酒（第30列）
            experimentSurveyDrinking.setSpirits(parseBoolean(rowData.get(31)));  // 烈酒（第31列）
            experimentSurveyDrinking.setOtherAlcohol(parseBoolean(rowData.get(32)));  // 其他（第32列）

//            实验组流调-体育锻炼信息
            experimentSurveyExercise.setPersonId(generatedId);
            experimentSurveyExercise.setRegularExercise(parseBoolean(rowData.get(255))); // 是否有规律的体育锻炼（第255列）
            experimentSurveyExercise.setExerciseFrequency(rowData.get(256)); // 参加体育锻炼的频率（第256列）
            experimentSurveyExercise.setExerciseDuration(rowData.get(257)); // 参加体育锻炼的时长（第257列）
            experimentSurveyExercise.setExerciseType(rowData.get(258)); // 哪种类型的体育锻炼（第258列）
            experimentSurveyExercise.setChestPainOrShortness(parseBoolean(rowData.get(259))); // 胸闷、气促（第259列）
            experimentSurveyExercise.setDoctorGuidedExercise(parseBoolean(rowData.get(260))); // 是否在医生指导下体育锻炼（第260列）

//            实验组流调-亲属既往疾病
            experimentSurveyFamilyDiseases.setPersonId(generatedId);
            experimentSurveyFamilyDiseases.setHypertension(parseBoolean(rowData.get(35))); // 高血压（第35列）
            experimentSurveyFamilyDiseases.setHyperlipidemia(parseBoolean(rowData.get(36))); // 高血脂（第36列）
            experimentSurveyFamilyDiseases.setCongenitalHeartDisease(parseBoolean(rowData.get(37))); // 先天性心脏病（第37列）
            experimentSurveyFamilyDiseases.setPulmonaryHeartDisease(parseBoolean(rowData.get(38))); // 肺心病（第38列）
            experimentSurveyFamilyDiseases.setStroke(parseBoolean(rowData.get(39))); // 中风/脑溢血（第39列）
            experimentSurveyFamilyDiseases.setCoronaryHeartDisease(parseBoolean(rowData.get(40))); // 冠心病/心绞痛（第40列）
            experimentSurveyFamilyDiseases.setMyocardialInfarction(parseBoolean(rowData.get(41))); // 心肌梗塞（第41列）
            experimentSurveyFamilyDiseases.setBradycardia(parseBoolean(rowData.get(42))); // 窦性心动过缓（第42列）
            experimentSurveyFamilyDiseases.setTachycardia(parseBoolean(rowData.get(43))); // 窦性心动过速（第43列）
            experimentSurveyFamilyDiseases.setArrhythmia(parseBoolean(rowData.get(44))); // 窦性心律不齐（第44列）
            experimentSurveyFamilyDiseases.setAtrialFibrillation(parseBoolean(rowData.get(45))); // 房颤（第45列）
            experimentSurveyFamilyDiseases.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(46))); // 阵发性室上速（第46列）
            experimentSurveyFamilyDiseases.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(47))); // 频发房性早搏（第47列）
            experimentSurveyFamilyDiseases.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(48))); // 频发室性早搏（第48列）
            experimentSurveyFamilyDiseases.setAvBlock(parseBoolean(rowData.get(49))); // 房室传导阻滞（第49列）
            experimentSurveyFamilyDiseases.setVentricularTachycardia(parseBoolean(rowData.get(50))); // 室性心动过速（第50列）
            experimentSurveyFamilyDiseases.setOtherDiseases1(parseBoolean(rowData.get(51))); // 其他 1（第51列）
            experimentSurveyFamilyDiseases.setChronicBronchitis(parseBoolean(rowData.get(52))); // 慢性支气管炎（第52列）
            experimentSurveyFamilyDiseases.setAsthma(parseBoolean(rowData.get(53))); // 哮喘（第53列）
            experimentSurveyFamilyDiseases.setTuberculosis(parseBoolean(rowData.get(54))); // 肺结核（第54列）
            experimentSurveyFamilyDiseases.setEmphysema(parseBoolean(rowData.get(55))); // 肺气肿（第55列）
            experimentSurveyFamilyDiseases.setPneumonia(parseBoolean(rowData.get(56))); // 肺炎（第56列）
            experimentSurveyFamilyDiseases.setCopd(parseBoolean(rowData.get(57))); // 慢性阻塞性肺疾病（第57列）
            experimentSurveyFamilyDiseases.setOtherDiseases2(parseBoolean(rowData.get(58))); // 其他 2（第58列）
            experimentSurveyFamilyDiseases.setThyroidDisease(parseBoolean(rowData.get(59))); // 甲状腺疾病（第59列）
            experimentSurveyFamilyDiseases.setDiabetes(parseBoolean(rowData.get(60))); // 糖尿病（第60列）
            experimentSurveyFamilyDiseases.setGout(parseBoolean(rowData.get(61))); // 高尿酸血症（痛风）（第61列）
            experimentSurveyFamilyDiseases.setChronicGastroenteritis(parseBoolean(rowData.get(62))); // 慢性肠胃炎（第62列）
            experimentSurveyFamilyDiseases.setDuodenalUlcer(parseBoolean(rowData.get(63))); // 十二指肠溃疡（第63列）
            experimentSurveyFamilyDiseases.setGastricUlcer(parseBoolean(rowData.get(64))); // 胃溃疡（第64列）
            experimentSurveyFamilyDiseases.setGallstones(parseBoolean(rowData.get(65))); // 胆结石（第65列）
            experimentSurveyFamilyDiseases.setColonPolyps(parseBoolean(rowData.get(66))); // 结肠息肉（第66列）
            experimentSurveyFamilyDiseases.setHepatitisB(parseBoolean(rowData.get(67))); // 乙型肝炎（第67列）
            experimentSurveyFamilyDiseases.setCholecystitis(parseBoolean(rowData.get(68))); // 胆囊炎（第68列）
            experimentSurveyFamilyDiseases.setOtherDiseases3(parseBoolean(rowData.get(69))); // 其他 3（第69列）
            experimentSurveyFamilyDiseases.setDementia(parseBoolean(rowData.get(70))); // 老年痴呆（第70列）
            experimentSurveyFamilyDiseases.setParkinsonsDisease(parseBoolean(rowData.get(71))); // 帕金森综合征（第71列）
            experimentSurveyFamilyDiseases.setMultipleSclerosis(parseBoolean(rowData.get(72))); // 多发性硬化病（第72列）
            experimentSurveyFamilyDiseases.setEpilepsy(parseBoolean(rowData.get(73))); // 癫痫（第73列）
            experimentSurveyFamilyDiseases.setLungCancer(parseBoolean(rowData.get(74))); // 肺癌（第74列）
            experimentSurveyFamilyDiseases.setLiverCancer(parseBoolean(rowData.get(75))); // 肝癌（第75列）
            experimentSurveyFamilyDiseases.setGastricCancer(parseBoolean(rowData.get(76))); // 胃癌（第76列）
            experimentSurveyFamilyDiseases.setColonCancer(parseBoolean(rowData.get(77))); // 直/结肠癌（第77列）
            experimentSurveyFamilyDiseases.setPancreaticCancer(parseBoolean(rowData.get(78))); // 胰腺癌（第78列）
            experimentSurveyFamilyDiseases.setEsophagealCancer(parseBoolean(rowData.get(79))); // 食管癌（第79列）
            experimentSurveyFamilyDiseases.setProstateCancer(parseBoolean(rowData.get(80))); // 前列腺癌（第80列）
            experimentSurveyFamilyDiseases.setBreastCancer(parseBoolean(rowData.get(81))); // 乳腺癌（第81列）
            experimentSurveyFamilyDiseases.setCervicalCancer(parseBoolean(rowData.get(82))); // 宫颈癌（第82列）
            experimentSurveyFamilyDiseases.setOtherDiseases4(parseBoolean(rowData.get(83))); // 其他 4（第83列）

//            实验组流调-高原疾病诊断
            experimentSurveyHighlandDiseases.setPersonId(generatedId);
            experimentSurveyHighlandDiseases.setAcuteHighlandReaction(parseBoolean(rowData.get(113))); // 急性高原反应（第113列）
            experimentSurveyHighlandDiseases.setHighlandPulmonaryEdema(parseBoolean(rowData.get(114))); // 高原肺水肿（第114列）
            experimentSurveyHighlandDiseases.setHighlandCerebralEdema(parseBoolean(rowData.get(115))); // 高原脑水肿（第115列）
            experimentSurveyHighlandDiseases.setHighlandHeartDisease(parseBoolean(rowData.get(116))); // 高原心脏病（第116列）
            experimentSurveyHighlandDiseases.setHighlandPolycythemia(parseBoolean(rowData.get(117))); // 高原红细胞增多症（第117列）
            experimentSurveyHighlandDiseases.setOtherDiseases(parseBoolean(rowData.get(118))); // 其他（第118列）       // 其他（第115列）

//            实验组流调-高原期间出现的疾病
            experimentSurveyHighlandDiseasesDuringService.setPersonId(generatedId);
            experimentSurveyHighlandDiseasesDuringService.setHypertension(parseBoolean(rowData.get(175))); // 高血压 1（第175列）
            experimentSurveyHighlandDiseasesDuringService.setMyocardialInfarction(parseBoolean(rowData.get(176))); // 心肌梗死 1（第176列）
            experimentSurveyHighlandDiseasesDuringService.setCoronaryHeartDisease(parseBoolean(rowData.get(177))); // 冠心病 1（第177列）
            experimentSurveyHighlandDiseasesDuringService.setPulmonaryHeartDisease(parseBoolean(rowData.get(178))); // 肺心病 1（第178列）
            experimentSurveyHighlandDiseasesDuringService.setLowerExtremityVenousThrombosis(parseBoolean(rowData.get(179))); // 四肢静脉血栓 1（第179列）
            experimentSurveyHighlandDiseasesDuringService.setBradycardia(parseBoolean(rowData.get(180))); // 窦性心动过缓 1（第180列）
            experimentSurveyHighlandDiseasesDuringService.setTachycardia(parseBoolean(rowData.get(181))); // 窦性心动过速 1（第181列）
            experimentSurveyHighlandDiseasesDuringService.setArrhythmia(parseBoolean(rowData.get(182))); // 窦性心律不齐 1（第182列）
            experimentSurveyHighlandDiseasesDuringService.setAtrialFibrillation(parseBoolean(rowData.get(183))); // 房颤 1（第183列）
            experimentSurveyHighlandDiseasesDuringService.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(184))); // 阵发性室上速 1（第184列）
            experimentSurveyHighlandDiseasesDuringService.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(185))); // 频发房性早搏 1（第185列）
            experimentSurveyHighlandDiseasesDuringService.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(186))); // 频发室性早搏 1（第186列）
            experimentSurveyHighlandDiseasesDuringService.setAvBlock(parseBoolean(rowData.get(187))); // 房室传导阻滞 1（第187列）
            experimentSurveyHighlandDiseasesDuringService.setVentricularTachycardia(parseBoolean(rowData.get(188))); // 室性心动过速 1（第188列）
            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases1(parseBoolean(rowData.get(189))); // 其他 1 1（第189列）
            experimentSurveyHighlandDiseasesDuringService.setDizziness(parseBoolean(rowData.get(190))); // 眩晕 1（第190列）
            experimentSurveyHighlandDiseasesDuringService.setTransientIschemicAttack(parseBoolean(rowData.get(191))); // 短暂性脑缺血 1（第191列）
            experimentSurveyHighlandDiseasesDuringService.setCerebralInfarction(parseBoolean(rowData.get(192))); // 脑梗死/脑血栓 1（第192列）
            experimentSurveyHighlandDiseasesDuringService.setCerebralHemorrhage(parseBoolean(rowData.get(193))); // 脑出血 1（第193列）
            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases2(parseBoolean(rowData.get(194))); // 其他 1 2（第194列）
            experimentSurveyHighlandDiseasesDuringService.setHyperlipidemia(parseBoolean(rowData.get(195))); // 高血脂 1（第195列）
            experimentSurveyHighlandDiseasesDuringService.setDiabetes(parseBoolean(rowData.get(196))); // 糖尿病 1（第196列）
            experimentSurveyHighlandDiseasesDuringService.setGout(parseBoolean(rowData.get(197))); // 高尿酸血症（痛风） 1（第197列）
            experimentSurveyHighlandDiseasesDuringService.setThyroidDisease(parseBoolean(rowData.get(198))); // 甲状腺疾病 1（第198列）
            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases3(parseBoolean(rowData.get(199))); // 其他 1 3（第199列）
            experimentSurveyHighlandDiseasesDuringService.setInsomnia(parseBoolean(rowData.get(200))); // 失眠 1（第200列）
            experimentSurveyHighlandDiseasesDuringService.setTumor(parseBoolean(rowData.get(201))); // 肿瘤 1（第201列）
            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases4(parseBoolean(rowData.get(202))); // 其他 1 4（第202列）

//            实验组流调-高原反应信息
            experimentSurveyHighlandReaction.setPersonId(generatedId);
            experimentSurveyHighlandReaction.setReactionOccurred(parseBoolean(rowData.get(109))); // 是否发生过高原反应（第109列）
            experimentSurveyHighlandReaction.setReactionCount(parseBooleanToInteger(rowData.get(110))); // 高原反应次数（第110列）
            experimentSurveyHighlandReaction.setReactionCountText(rowData.get(110)); // 高原反应次数（第110列）
            experimentSurveyHighlandReaction.setUnclearReactionCount(parseBoolean(rowData.get(111))); // 高原反应次数记不清（第111列）
            experimentSurveyHighlandReaction.setMultipleReactionsChanges(rowData.get(112)); // 多次高原反应，高原反应变化情况（第112列）

//            实验组流调-高原反应症状
            experimentSurveyHighlandReactionSymptoms.setPersonId(generatedId);
            experimentSurveyHighlandReactionSymptoms.setHeadache(parseBoolean(rowData.get(119))); // 头痛（第119列）
            experimentSurveyHighlandReactionSymptoms.setVomiting(parseBoolean(rowData.get(120))); // 呕吐（第120列）
            experimentSurveyHighlandReactionSymptoms.setDizziness(parseBoolean(rowData.get(121))); // 头昏（第121列）
            experimentSurveyHighlandReactionSymptoms.setNausea(parseBoolean(rowData.get(122))); // 恶心（第122列）
            experimentSurveyHighlandReactionSymptoms.setPalpitations(parseBoolean(rowData.get(123))); // 心慌（第123列）
            experimentSurveyHighlandReactionSymptoms.setPoorAppetite(parseBoolean(rowData.get(124))); // 食欲不振（第124列）
            experimentSurveyHighlandReactionSymptoms.setChestTightness(parseBoolean(rowData.get(125))); // 胸闷（第125列）
            experimentSurveyHighlandReactionSymptoms.setBlurredVision(parseBoolean(rowData.get(126))); // 眼花（第126列）
            experimentSurveyHighlandReactionSymptoms.setShortnessOfBreath(parseBoolean(rowData.get(127))); // 气短（第127列）
            experimentSurveyHighlandReactionSymptoms.setAbdominalBloating(parseBoolean(rowData.get(128))); // 腹胀（第128列）
            experimentSurveyHighlandReactionSymptoms.setDiarrhea(parseBoolean(rowData.get(129))); // 腹泻（第129列）

//            实验组流调-新发的疾病
            experimentSurveyNewDiseases.setPersonId(generatedId);
            experimentSurveyNewDiseases.setNewDisease1Name(rowData.get(231)); // 新发疾病 1 名称（第231列）
            experimentSurveyNewDiseases.setDiagnosed(parseBoolean(rowData.get(232))); // 该病是否在二级或二级以上医院被诊断（第232列）
            experimentSurveyNewDiseases.setDiagnosisDate(rowData.get(233)); // 该病的诊断时间（第233列）
            experimentSurveyNewDiseases.setHospitalized(parseBoolean(rowData.get(234))); // 是否因该病住院治疗（第234列）
            experimentSurveyNewDiseases.setMedication(parseBoolean(rowData.get(235))); // 是否使用药物进行治疗（第235列）
            experimentSurveyNewDiseases.setMedicationEffect(rowData.get(236)); // 药物，治疗效果（第236列）

            experimentSurveyNewDiseases.setNewDisease2Name(rowData.get(237)); // 新发疾病 2 名称（第237列）
            experimentSurveyNewDiseases.setDiagnosed2(parseBoolean(rowData.get(238))); // 该病是否在二级或二级以上医院被诊断（第238列）
            experimentSurveyNewDiseases.setDiagnosisDate2(rowData.get(239)); // 该病的诊断时间（第239列）
            experimentSurveyNewDiseases.setHospitalized2(parseBoolean(rowData.get(240))); // 是否因该病住院治疗（第240列）
            experimentSurveyNewDiseases.setMedication2(parseBoolean(rowData.get(241))); // 是否使用药物进行治疗（第241列）
            experimentSurveyNewDiseases.setMedicationEffect2(rowData.get(242)); // 药物，治疗效果（第242列）

            experimentSurveyNewDiseases.setNewDisease3Name(rowData.get(243)); // 新发疾病 3 名称（第243列）
            experimentSurveyNewDiseases.setDiagnosed3(parseBoolean(rowData.get(244))); // 该病是否在二级或二级以上医院被诊断（第244列）
            experimentSurveyNewDiseases.setDiagnosisDate3(rowData.get(245)); // 该病的诊断时间（第245列）
            experimentSurveyNewDiseases.setHospitalized3(parseBoolean(rowData.get(246))); // 是否因该病住院治疗（第246列）
            experimentSurveyNewDiseases.setMedication3(parseBoolean(rowData.get(247))); // 是否使用药物进行治疗（第247列）
            experimentSurveyNewDiseases.setMedicationEffect3(rowData.get(248)); // 药物，治疗效果（第248列）

            experimentSurveyNewDiseases.setNewDisease4Name(rowData.get(249)); // 新发疾病 4 名称（第249列）
            experimentSurveyNewDiseases.setDiagnosed4(parseBoolean(rowData.get(250))); // 该病是否在二级或二级以上医院被诊断（第250列）
            experimentSurveyNewDiseases.setDiagnosisDate4(rowData.get(251)); // 该病的诊断时间（第251列）
            experimentSurveyNewDiseases.setHospitalized4(parseBoolean(rowData.get(252))); // 是否因该病住院治疗（第252列）
            experimentSurveyNewDiseases.setMedication4(parseBoolean(rowData.get(253))); // 是否使用药物进行治疗（第253列）
            experimentSurveyNewDiseases.setMedicationEffect4(rowData.get(254)); // 药物，治疗效果（第254列）

//            实验组流调-返回平原后新发的疾病
            experimentSurveyNewDiseasesPostReturn.setPersonId(generatedId);
            experimentSurveyNewDiseasesPostReturn.setHypertension(parseBoolean(rowData.get(203))); // 高血压 2（第203列）
            experimentSurveyNewDiseasesPostReturn.setMyocardialInfarction(parseBoolean(rowData.get(204))); // 心肌梗死 2（第204列）
            experimentSurveyNewDiseasesPostReturn.setCoronaryHeartDisease(parseBoolean(rowData.get(205))); // 冠心病 2（第205列）
            experimentSurveyNewDiseasesPostReturn.setPulmonaryHeartDisease(parseBoolean(rowData.get(206))); // 肺心病 2（第206列）
            experimentSurveyNewDiseasesPostReturn.setLowerExtremityVenousThrombosis(parseBoolean(rowData.get(207))); // 四肢静脉血栓 2（第207列）
            experimentSurveyNewDiseasesPostReturn.setBradycardia(parseBoolean(rowData.get(208))); // 窦性心动过缓 2（第208列）
            experimentSurveyNewDiseasesPostReturn.setTachycardia(parseBoolean(rowData.get(209))); // 窦性心动过速 2（第209列）
            experimentSurveyNewDiseasesPostReturn.setArrhythmia(parseBoolean(rowData.get(210))); // 窦性心律不齐 2（第210列）
            experimentSurveyNewDiseasesPostReturn.setAtrialFibrillation(parseBoolean(rowData.get(211))); // 房颤 2（第211列）
            experimentSurveyNewDiseasesPostReturn.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(212))); // 阵发性室上速 2（第212列）
            experimentSurveyNewDiseasesPostReturn.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(213))); // 频发房性早搏 2（第213列）
            experimentSurveyNewDiseasesPostReturn.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(214))); // 频发室性早搏 2（第214列）
            experimentSurveyNewDiseasesPostReturn.setAvBlock(parseBoolean(rowData.get(215))); // 房室传导阻滞 2（第215列）
            experimentSurveyNewDiseasesPostReturn.setVentricularTachycardia(parseBoolean(rowData.get(216))); // 室性心动过速 2（第216列）
            experimentSurveyNewDiseasesPostReturn.setOtherDiseases1(parseBoolean(rowData.get(217))); // 其他 2 1（第217列）
            experimentSurveyNewDiseasesPostReturn.setDizziness(parseBoolean(rowData.get(218))); // 眩晕 2（第218列）
            experimentSurveyNewDiseasesPostReturn.setTransientIschemicAttack(parseBoolean(rowData.get(219))); // 短暂性脑缺血 2（第219列）
            experimentSurveyNewDiseasesPostReturn.setCerebralInfarction(parseBoolean(rowData.get(220))); // 脑梗死/脑血栓 2（第220列）
            experimentSurveyNewDiseasesPostReturn.setCerebralHemorrhage(parseBoolean(rowData.get(221))); // 脑出血 2（第221列）
            experimentSurveyNewDiseasesPostReturn.setOtherDiseases2(parseBoolean(rowData.get(222))); // 其他 2 2（第222列）
            experimentSurveyNewDiseasesPostReturn.setHyperlipidemia(parseBoolean(rowData.get(223))); // 高血脂 2（第223列）
            experimentSurveyNewDiseasesPostReturn.setDiabetes(parseBoolean(rowData.get(224))); // 糖尿病 2（第224列）
            experimentSurveyNewDiseasesPostReturn.setGout(parseBoolean(rowData.get(225))); // 高尿酸血症（痛风） 2（第225列）
            experimentSurveyNewDiseasesPostReturn.setThyroidDisease(parseBoolean(rowData.get(226))); // 甲状腺疾病 2（第226列）
            experimentSurveyNewDiseasesPostReturn.setOtherDiseases3(parseBoolean(rowData.get(227))); // 其他 2 3（第227列）
            experimentSurveyNewDiseasesPostReturn.setInsomnia(parseBoolean(rowData.get(228))); // 失眠 2（第228列）
            experimentSurveyNewDiseasesPostReturn.setTumor(parseBoolean(rowData.get(229))); // 肿瘤 2（第229列）
            experimentSurveyNewDiseasesPostReturn.setOtherDiseases4(parseBoolean(rowData.get(230))); // 其他 2 4（第230列）

//            实验组流调-返回后基础信息
            experimentSurveyPostReturnInfo.setPersonId(generatedId);
            experimentSurveyPostReturnInfo.setChengdu(parseBooleanToInteger(rowData.get(165))); // 成都（第165列）
            experimentSurveyPostReturnInfo.setChengduResidenceTime(extractNumberOrZero(rowData.get(166))); // 成都居住时间（年）（第166列）
            experimentSurveyPostReturnInfo.setKunming(parseBooleanToInteger(rowData.get(167)));// 昆明（第167列）
            experimentSurveyPostReturnInfo.setKunmingResidenceTime(extractNumberOrZero(rowData.get(168)));// 昆明居住时间（年）（第168列）
            experimentSurveyPostReturnInfo.setXining(parseBooleanToInteger(rowData.get(169))); // 西宁（第169列）
            experimentSurveyPostReturnInfo.setXiningResidenceTime(extractNumberOrZero(rowData.get(170))); // 西宁居住时间（年）（第170列）
            experimentSurveyPostReturnInfo.setOtherArea(rowData.get(171)); // 其他（第171列）
            experimentSurveyPostReturnInfo.setOtherAreaResidenceTime(rowData.get(172)); // 其他居住时间（年）（第172列）
            experimentSurveyPostReturnInfo.setPostReturnWorkStatus(rowData.get(173)); // 从高原返回后的工作情况（第173列）
            experimentSurveyPostReturnInfo.setAnnualCheckups(rowData.get(174)); // 每年体检/就诊次数（第174列）

//            实验组流调-退役后返回平原1月内症状
            experimentSurveyPostReturnSymptoms.setPersonId(generatedId);
            experimentSurveyPostReturnSymptoms.setFatigue(parseBoolean(rowData.get(130))); // 疲倦（第130列）
            experimentSurveyPostReturnSymptoms.setDrowsiness(parseBoolean(rowData.get(131))); // 嗜睡（第131列）
            experimentSurveyPostReturnSymptoms.setDizziness(parseBoolean(rowData.get(132))); // 头昏（第132列）
            experimentSurveyPostReturnSymptoms.setVertigo(parseBoolean(rowData.get(133))); // 眩晕（第133列）
            experimentSurveyPostReturnSymptoms.setPoorConcentration(parseBoolean(rowData.get(134))); // 精力不集中（第134列）
            experimentSurveyPostReturnSymptoms.setSlowReaction(parseBoolean(rowData.get(135))); // 反应迟钝（第135列）
            experimentSurveyPostReturnSymptoms.setMemoryLoss(parseBoolean(rowData.get(136))); // 记忆减退（第136列）
            experimentSurveyPostReturnSymptoms.setInsomnia(parseBoolean(rowData.get(137))); // 失眠（第137列）
            experimentSurveyPostReturnSymptoms.setNightmares(parseBoolean(rowData.get(138))); // 多梦（第138列）
            experimentSurveyPostReturnSymptoms.setChestPain(parseBoolean(rowData.get(139))); // 心前区痛（第139列）
            experimentSurveyPostReturnSymptoms.setPalpitations(parseBoolean(rowData.get(140))); // 心慌（第140列）
            experimentSurveyPostReturnSymptoms.setBradycardia(parseBoolean(rowData.get(141))); // 脉率减慢（第141列）
            experimentSurveyPostReturnSymptoms.setCyanosis(parseBoolean(rowData.get(142))); // 紫绀（第142列）
            experimentSurveyPostReturnSymptoms.setBloodPressureFluctuation(parseBoolean(rowData.get(143))); // 血压波动（第143列）
            experimentSurveyPostReturnSymptoms.setSkinBleeding(parseBoolean(rowData.get(144))); // 皮肤出血（第144列）
            experimentSurveyPostReturnSymptoms.setSkinBruising(parseBoolean(rowData.get(145))); // 皮肤瘀斑（第145列）
            experimentSurveyPostReturnSymptoms.setAnemia(parseBoolean(rowData.get(146))); // 贫血（第146列）
            experimentSurveyPostReturnSymptoms.setSoreThroat(parseBoolean(rowData.get(147))); // 咽喉痛（第147列）
            experimentSurveyPostReturnSymptoms.setCough(parseBoolean(rowData.get(148))); // 咳嗽（第148列）
            experimentSurveyPostReturnSymptoms.setPhlegm(parseBoolean(rowData.get(149))); // 多痰（第149列）
            experimentSurveyPostReturnSymptoms.setWheezing(parseBoolean(rowData.get(150))); // 气喘（第150列）
            experimentSurveyPostReturnSymptoms.setChestTightness(parseBoolean(rowData.get(151))); // 胸闷（第151列）
            experimentSurveyPostReturnSymptoms.setWeightLoss(parseBoolean(rowData.get(152))); // 体重减轻（第152列）
            experimentSurveyPostReturnSymptoms.setIncreasedAppetite(parseBoolean(rowData.get(153))); // 食欲增加（第153列）
            experimentSurveyPostReturnSymptoms.setAnorexia(parseBoolean(rowData.get(154))); // 厌食（第154列）
            experimentSurveyPostReturnSymptoms.setConstipation(parseBoolean(rowData.get(155))); // 便秘（第155列）
            experimentSurveyPostReturnSymptoms.setDiarrhea(parseBoolean(rowData.get(156))); // 腹泻（第156列）
            experimentSurveyPostReturnSymptoms.setAbdominalPain(parseBoolean(rowData.get(157))); // 腹痛（第157列）
            experimentSurveyPostReturnSymptoms.setJaundice(parseBoolean(rowData.get(158))); // 黄疸（第158列）
            experimentSurveyPostReturnSymptoms.setNumbness(parseBoolean(rowData.get(159))); // 手足麻木（第159列）
            experimentSurveyPostReturnSymptoms.setLimbEdema(parseBoolean(rowData.get(160))); // 肢体水肿（第160列）
            experimentSurveyPostReturnSymptoms.setFacialEdema(parseBoolean(rowData.get(161))); // 面部水肿（第161列）
            experimentSurveyPostReturnSymptoms.setHairLoss(parseBoolean(rowData.get(162))); // 脱发（第162列）
            experimentSurveyPostReturnSymptoms.setIncreasedUrination(parseBoolean(rowData.get(164))); // 夜尿增多（第164列）

//            实验组流调-自我评价
            experimentSurveySelfAssessment.setPersonId(generatedId);
            experimentSurveySelfAssessment.setHealthComparisonWithPeers(rowData.get(33)); // 与同龄人相比，您认为目前自己的身体健康状况如何（第33列）
            experimentSurveySelfAssessment.setHealthScore(rowData.get(34)); // 您认为自己身体健康状况能得的分数（第34列）

//            实验组流调-服役信息
            experimentSurveyServiceInfo.setPersonId(generatedId);
            experimentSurveyServiceInfo.setEnlistmentYear(Integer.parseInt(rowData.get(3))); // 入伍年份（第3列）
            experimentSurveyServiceInfo.setHighlandEntryYear(Integer.parseInt(rowData.get(4))); // 进入高原年份（第4列）
            experimentSurveyServiceInfo.setDischargeYear(Integer.parseInt(rowData.get(5))); // 退役年份（第5列）
            experimentSurveyServiceInfo.setServicePosition(rowData.get(6)); // 服役期间职务（第6列）
            experimentSurveyServiceInfo.setHighlandServiceLocation1(rowData.get(84)); // 高原服役地点 1（第84列）
            experimentSurveyServiceInfo.setAltitude1(Integer.parseInt(rowData.get(85))); // 海拔高度 1（第85列）
            experimentSurveyServiceInfo.setYear1(Double.parseDouble(rowData.get(86))); // 高原服役地点 1 年（第86列）
            experimentSurveyServiceInfo.setMonth1(Integer.parseInt(rowData.get(87))); // 高原服役地点 1 月（第87列）
            experimentSurveyServiceInfo.setHighlandServiceLocation2(rowData.get(88)); // 高原服役地点 2（第88列）
            experimentSurveyServiceInfo.setAltitude2(Integer.parseInt(rowData.get(89))); // 海拔高度 2（第89列）
            experimentSurveyServiceInfo.setYear2(Double.parseDouble(rowData.get(90))); // 高原服役地点 2 年（第90列）
            experimentSurveyServiceInfo.setMonth2(Integer.parseInt(rowData.get(91))); // 高原服役地点 2 月（第91列）
            experimentSurveyServiceInfo.setHighlandServiceLocation3(rowData.get(92)); // 高原服役地点 3（第92列）
            experimentSurveyServiceInfo.setAltitude3(Integer.parseInt(rowData.get(93))); // 海拔高度 3（第93列）
            experimentSurveyServiceInfo.setYear3(Double.parseDouble(rowData.get(94))); // 高原服役地点 3 年（第94列）
            experimentSurveyServiceInfo.setMonth3(Integer.parseInt(rowData.get(95))); // 高原服役地点 3 月（第95列）
            experimentSurveyServiceInfo.setHighlandServiceLocation4(rowData.get(96)); // 高原服役地点 4（第96列）
            experimentSurveyServiceInfo.setAltitude4(Integer.parseInt(rowData.get(97))); // 海拔高度 4（第97列）
            experimentSurveyServiceInfo.setYear4(Double.parseDouble(rowData.get(98))); // 高原服役地点 4 年（第98列）
            experimentSurveyServiceInfo.setMonth4(Integer.parseInt(rowData.get(99))); // 高原服役地点 4 月（第99列）
            experimentSurveyServiceInfo.setHighlandServiceLocation5(rowData.get(100)); // 高原服役地点 5（第100列）
            experimentSurveyServiceInfo.setAltitude5(Integer.parseInt(rowData.get(101))); // 海拔高度 5（第101列）
            experimentSurveyServiceInfo.setYear5(Double.parseDouble(rowData.get(102))); // 高原服役地点 5 年（第102列）
            experimentSurveyServiceInfo.setMonth5(Integer.parseInt(rowData.get(103))); // 高原服役地点 5 月（第103列）
            experimentSurveyServiceInfo.setHighlandServiceLocation6(rowData.get(104)); // 高原服役地点 6（第104列）
            experimentSurveyServiceInfo.setAltitude6(Integer.parseInt(rowData.get(105))); // 海拔高度 6（第105列）
            experimentSurveyServiceInfo.setYear6(Double.parseDouble(rowData.get(106))); // 高原服役地点 6 年（第106列）
            experimentSurveyServiceInfo.setMonth6(Integer.parseInt(rowData.get(107))); // 高原服役地点 6 月（第107列）
            experimentSurveyServiceInfo.setHighlandTaskType(rowData.get(108)); // 高原任务的类型（第108列）

//            实验组流调-睡眠信息
            experimentSurveySleep.setPersonId(generatedId);
            experimentSurveySleep.setSleepTimeStart(rowData.get(269));  // 晚上睡觉时间（第269列）
            experimentSurveySleep.setSleepOnsetTime(rowData.get(270));  // 入睡需要时间（分钟）（第270列）
            experimentSurveySleep.setWakeTime(rowData.get(271));  // 起床时间（第271列）
            experimentSurveySleep.setActualSleepDuration(rowData.get(272));  // 实际睡眠时间（小时）（第272列）
            experimentSurveySleep.setSleepDifficulties(rowData.get(273));  // 入睡困难（第273列）
            experimentSurveySleep.setNightAwakening(rowData.get(274));  // 夜间易醒或早醒（第274列）
            experimentSurveySleep.setNightUrination(rowData.get(275));  // 夜间去厕所（第275列）
            experimentSurveySleep.setBreathingDifficulties(rowData.get(276));  // 呼吸不畅（第276列）
            experimentSurveySleep.setCoughOrSnore(rowData.get(277));  // 咳嗽或鼾声高（第277列）
            experimentSurveySleep.setFeelingCold(rowData.get(278));  // 感觉冷（第278列）
            experimentSurveySleep.setFeelingHot(rowData.get(279));  // 感觉热（第279列）
            experimentSurveySleep.setNightmares(rowData.get(280));  // 做恶梦（第280列）
            experimentSurveySleep.setPainOrDiscomfort(rowData.get(281));  // 疼痛不适（第281列）
            experimentSurveySleep.setOtherSleepIssues(rowData.get(282));  // 其他影响睡眠的事情（第282列），直接赋值为 String
            experimentSurveySleep.setSleepAids(rowData.get(283));  // 催眠药（第283列）
            experimentSurveySleep.setFatigue(rowData.get(284));  // 感到困倦（第284列）
            experimentSurveySleep.setLackOfEnergy(rowData.get(285));  // 精力不足（第285列）
            experimentSurveySleep.setSelfAssessmentSleep(rowData.get(286));  // 自评睡眠情况（第286列）

//            实验组流调-吸烟情况
            experimentSurveySmoking.setPersonId(generatedId);  // 设置基础信息id
            experimentSurveySmoking.setSmokingStatus(rowData.get(14) != null ? rowData.get(14).toString() : null);  // 是否吸烟（第14列）
            experimentSurveySmoking.setDailySmoking(rowData.get(15));  // 每日抽烟数量（第15列）
            experimentSurveySmoking.setSmokingStartAge(rowData.get(16) != null ? Integer.parseInt(rowData.get(16).toString()) : null);  // 开始吸烟年龄（第16列）
            experimentSurveySmoking.setSmokingYears(rowData.get(17) != null ? Integer.parseInt(rowData.get(17).toString()) : null);  // 烟龄（第17列）
            experimentSurveySmoking.setTriedQuit(rowData.get(18) != null ? parseBoolean(rowData.get(18).toString()) : null);  // 是否尝试戒烟（第18列）
            experimentSurveySmoking.setHighlandPlainSmokingStatus(rowData.get(19) != null ? rowData.get(19).toString() : null);  // 高原/平原吸烟情况（第19列）
            experimentSurveySmoking.setSmokingYears2(rowData.get(20));  // 烟龄 2（第20列）
            experimentSurveySmoking.setQuitTime(rowData.get(21)); // 戒烟时间（第21列）
            experimentSurveySmoking.setHighlandPlainSmokingStatus2(rowData.get(22) != null ? rowData.get(22).toString() : null);  // 高原/平原吸烟情况 2（第22列）
            // 保存 BasicOtherInfoRespVO 到数据库
            basicOtherInfoService.createBasicOtherInfo(basicOtherInfo);
            experimentSurveyDietService.createExperimentSurveyDiet(experimentSurveyDiet);
            experimentSurveyDrinkingService.createExperimentSurveyDrinking(experimentSurveyDrinking);
            experimentSurveyExerciseService.createExperimentSurveyExercise(experimentSurveyExercise);
            experimentSurveyFamilyDiseasesService.createExperimentSurveyFamilyDiseases(experimentSurveyFamilyDiseases);
            experimentSurveyHighlandDiseasesService.createExperimentSurveyHighlandDiseases(experimentSurveyHighlandDiseases);
            experimentSurveyHighlandDiseasesDuringServiceService.createExperimentSurveyHighlandDiseasesDuringService(experimentSurveyHighlandDiseasesDuringService);
            experimentSurveyHighlandReactionService.createExperimentSurveyHighlandReaction(experimentSurveyHighlandReaction);
            experimentSurveyHighlandReactionSymptomsService.createExperimentSurveyHighlandReactionSymptoms(experimentSurveyHighlandReactionSymptoms);
            experimentSurveyNewDiseasesService.createExperimentSurveyNewDiseases(experimentSurveyNewDiseases);
            experimentSurveyNewDiseasesPostReturnService.createExperimentSurveyNewDiseasesPostReturn(experimentSurveyNewDiseasesPostReturn);
            experimentSurveyPostReturnInfoService.createExperimentSurveyPostReturnInfo(experimentSurveyPostReturnInfo);
            experimentSurveyPostReturnSymptomsService.createExperimentSurveyPostReturnSymptoms(experimentSurveyPostReturnSymptoms);
            experimentSurveySelfAssessmentService.createExperimentSurveySelfAssessment(experimentSurveySelfAssessment);
            experimentSurveyServiceInfoService.createExperimentSurveyServiceInfo(experimentSurveyServiceInfo);
            experimentSurveySleepService.createExperimentSurveySleep(experimentSurveySleep);
            experimentSurveySmokingService.createExperimentSurveySmoking(experimentSurveySmoking);

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExcelExperimentExam")
    public String importExcelExperimentExam() {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/回顾性数据/汇总-实验组-体检.xlsx";
        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\汇总-实验组-体检.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener2(
                        basicInfoService
                        , basicOtherInfoService
                        , experimentExamAbdominalUltrasoundService
                        , experimentExamBasicTestsService
                        , experimentExamBiochemicalTestsService
                        , experimentExamBloodRoutineService
                        , experimentExamEcgService
                        , experimentExamPastMedicalHistoryService))
                .sheet()
                .doRead();

        return "实验组体检数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener2 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private BasicOtherInfoService basicOtherInfoService;
        private ExperimentExamAbdominalUltrasoundService experimentExamAbdominalUltrasoundService;
        private ExperimentExamBasicTestsService experimentExamBasicTestsService;
        private ExperimentExamBiochemicalTestsService experimentExamBiochemicalTestsService;
        private ExperimentExamBloodRoutineService experimentExamBloodRoutineService;
        private ExperimentExamEcgService experimentExamEcgService;
        private ExperimentExamPastMedicalHistoryService experimentExamPastMedicalHistoryService;

        // 构造函数注入服务
        public IndexListener2(
                BasicInfoService basicInfoService
                , BasicOtherInfoService basicOtherInfoService
                , ExperimentExamAbdominalUltrasoundService experimentExamAbdominalUltrasoundService
                , ExperimentExamBasicTestsService experimentExamBasicTestsService
                , ExperimentExamBiochemicalTestsService experimentExamBiochemicalTestsService
                , ExperimentExamBloodRoutineService experimentExamBloodRoutineService
                , ExperimentExamEcgService experimentExamEcgService
                , ExperimentExamPastMedicalHistoryService experimentExamPastMedicalHistoryService) {
            this.basicInfoService = basicInfoService;
            this.basicOtherInfoService = basicOtherInfoService;
            this.experimentExamAbdominalUltrasoundService = experimentExamAbdominalUltrasoundService;
            this.experimentExamBasicTestsService = experimentExamBasicTestsService;
            this.experimentExamBiochemicalTestsService = experimentExamBiochemicalTestsService;
            this.experimentExamBloodRoutineService = experimentExamBloodRoutineService;
            this.experimentExamEcgService = experimentExamEcgService;
            this.experimentExamPastMedicalHistoryService = experimentExamPastMedicalHistoryService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
                ExperimentExamAbdominalUltrasoundSaveReqVO experimentExamAbdominalUltrasoundSaveReqVO = new ExperimentExamAbdominalUltrasoundSaveReqVO();
                ExperimentExamBasicTestsSaveReqVO experimentExamBasicTestsSaveReqVO = new ExperimentExamBasicTestsSaveReqVO();
                ExperimentExamBiochemicalTestsSaveReqVO experimentExamBiochemicalTestsSaveReqVO = new ExperimentExamBiochemicalTestsSaveReqVO();
                ExperimentExamBloodRoutineSaveReqVO experimentExamBloodRoutineSaveReqVO = new ExperimentExamBloodRoutineSaveReqVO();
                ExperimentExamEcgSaveReqVO experimentExamEcgSaveReqVO = new ExperimentExamEcgSaveReqVO();
                ExperimentExamPastMedicalHistorySaveReqVO experimentExamPastMedicalHistorySaveReqVO = new ExperimentExamPastMedicalHistorySaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(1)); // 姓名
                basicInfoPageReqVO.setType(1); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(1)); // 姓名
                    basicInfo.setGender(rowData.get(2)); // 性别
                    basicInfo.setType(1); // 1：实验组，2：对照组
//                basicInfo.setHighestEducation(rowData.get(6)); // 最高学历
//                basicInfo.setEthnicity(rowData.get(7)); // 民族
//                basicInfo.setMaritalStatus(rowData.get(5)); // 婚姻情况
//                basicInfo.setHeight(extractNumber(rowData.get(8))); // 身高
//                basicInfo.setWeight(extractNumber(rowData.get(9))); // 体重

                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);

                    basicOtherInfo.setPersonId(generatedId);
                    basicOtherInfo.setAge(Integer.valueOf(rowData.get(3))); // 年龄
//                basicOtherInfo.setFertilityStatus(rowData.get(8));              // 生育情况
                    // 获取第13列的值
//                String weightData = rowData.get(13).toString();  // 获取字段并转换为字符串
//                BigDecimal retiredWeight = BigDecimal.ZERO;  // 默认值为0
//                // 判断是否包含 "Kg"，并处理数值部分
//                if (weightData != null) {
//                    // 如果包含 "Kg"，去掉 "Kg" 部分
//                    if (weightData.endsWith("Kg")) {
//                        weightData = weightData.replaceAll("Kg", "");  // 去掉单位 "Kg"
//                    }
//                    // 判断剩余部分是否为有效数字
//                    if (weightData.matches("\\d+")) {  // 只有数字（整数）部分
//                        retiredWeight = parseBigDecimal(weightData);  // 转换为BigDecimal
//                    } else {
//                        // 如果不是有效的数字，默认为0
//                        retiredWeight = BigDecimal.ZERO;
//                    }
//                }
//                basicOtherInfo.setRetiredWeight(retiredWeight);  // 设置退役体重  // 退役体重（第13列）
                    String dateStr = rowData.get(4);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    date = sdf.parse(dateStr);
                    basicOtherInfo.setMedicalCheckDate(date);// 体检日期
                    basicOtherInfo.setContactPhone(rowData.get(5)); // 联系电话
                    basicOtherInfoService.createBasicOtherInfo(basicOtherInfo);
                }
                UpdateWrapper<BasicOtherInfoDO> updateBasicOtherInfoWrapper = new UpdateWrapper<>();
                updateBasicOtherInfoWrapper.eq("person_id", generatedId);
                BasicOtherInfoSaveReqVO basicOtherInfoSaveReqVO = new BasicOtherInfoSaveReqVO();
                basicOtherInfoSaveReqVO.setPersonId(generatedId);
                basicOtherInfoSaveReqVO.setAge(Integer.valueOf(rowData.get(3))); // 年龄
                String dateStr = rowData.get(4);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                date = sdf.parse(dateStr);
                basicOtherInfoSaveReqVO.setMedicalCheckDate(date);// 体检日期
                basicOtherInfoSaveReqVO.setContactPhone(rowData.get(5)); // 联系电话
                basicOtherInfoService.updateBasicOtherInfoByWrapper(basicOtherInfoSaveReqVO,updateBasicOtherInfoWrapper);

                experimentExamAbdominalUltrasoundSaveReqVO.setPersonId(generatedId);
                experimentExamAbdominalUltrasoundSaveReqVO.setUltrasoundDescription(rowData.get(68)); // 超声描述（第68列）
                experimentExamAbdominalUltrasoundSaveReqVO.setUltrasoundSummary(rowData.get(69)); // 超声总结（第69列）

                experimentExamBasicTestsSaveReqVO.setPersonId(generatedId);
                experimentExamBasicTestsSaveReqVO.setSystolicPressure(parseBigDecimal(rowData.get(6))); // 收缩压（第6列）
                experimentExamBasicTestsSaveReqVO.setDiastolicPressure(parseBigDecimal(rowData.get(7))); // 舒张压（第7列）
                experimentExamBasicTestsSaveReqVO.setPulse(parseInteger(rowData.get(8))); // 脉搏（第8列）
                experimentExamBasicTestsSaveReqVO.setHeight(parseBigDecimal(rowData.get(9))); // 身高（第9列）
                experimentExamBasicTestsSaveReqVO.setWeight(parseBigDecimal(rowData.get(10))); // 体重（第10列）
                experimentExamBasicTestsSaveReqVO.setBmi(parseBigDecimal(rowData.get(11))); // 体重指数(kg/m^2)（第11列）


                experimentExamBiochemicalTestsSaveReqVO.setPersonId(generatedId);
                experimentExamBiochemicalTestsSaveReqVO.setUrea(parseBigDecimal(rowData.get(37))); // 尿素
                experimentExamBiochemicalTestsSaveReqVO.setCreatinine(parseBigDecimal(rowData.get(38))); // 肌酐
                experimentExamBiochemicalTestsSaveReqVO.setAlt(parseBigDecimal(rowData.get(39))); // 谷丙转氨酶
                experimentExamBiochemicalTestsSaveReqVO.setAst(parseBigDecimal(rowData.get(40))); // 谷草转氨酶
                experimentExamBiochemicalTestsSaveReqVO.setTotalCholesterol(parseBigDecimal(rowData.get(41))); // 总胆固醇
                experimentExamBiochemicalTestsSaveReqVO.setTriglycerides(parseBigDecimal(rowData.get(42))); // 甘油三酯
                experimentExamBiochemicalTestsSaveReqVO.setHdlC(parseBigDecimal(rowData.get(43))); // 高密度脂蛋白胆固醇
                experimentExamBiochemicalTestsSaveReqVO.setLdlC(parseBigDecimal(rowData.get(44))); // 低密度脂蛋白胆固醇
                experimentExamBiochemicalTestsSaveReqVO.setUricAcid(parseBigDecimal(rowData.get(45))); // 尿酸
                experimentExamBiochemicalTestsSaveReqVO.setTotalProtein(parseBigDecimal(rowData.get(46))); // 总蛋白
                experimentExamBiochemicalTestsSaveReqVO.setAlbumin(parseBigDecimal(rowData.get(47))); // 白蛋白
                experimentExamBiochemicalTestsSaveReqVO.setGlobulin(parseBigDecimal(rowData.get(48))); // 球蛋白
                experimentExamBiochemicalTestsSaveReqVO.setAlbGlobRatio(parseBigDecimal(rowData.get(49))); // 白球比例
                experimentExamBiochemicalTestsSaveReqVO.setTotalBilirubin(parseBigDecimal(rowData.get(50))); // 总胆红素
                experimentExamBiochemicalTestsSaveReqVO.setDirectBilirubin(parseBigDecimal(rowData.get(51))); // 直接胆红素
                experimentExamBiochemicalTestsSaveReqVO.setIndirectBilirubin(parseBigDecimal(rowData.get(52))); // 间接胆红素
                experimentExamBiochemicalTestsSaveReqVO.setGlycatedHemoglobin(parseBigDecimal(rowData.get(53))); // 糖化血红蛋白
                experimentExamBiochemicalTestsSaveReqVO.setPotassium(parseBigDecimal(rowData.get(54))); // 钾
                experimentExamBiochemicalTestsSaveReqVO.setSodium(parseBigDecimal(rowData.get(55))); // 钠
                experimentExamBiochemicalTestsSaveReqVO.setChloride(parseBigDecimal(rowData.get(56))); // 氯
                experimentExamBiochemicalTestsSaveReqVO.setCalcium(parseBigDecimal(rowData.get(57))); // 钙
                experimentExamBiochemicalTestsSaveReqVO.setPhosphorus(parseBigDecimal(rowData.get(58))); // 磷
                experimentExamBiochemicalTestsSaveReqVO.setMagnesium(parseBigDecimal(rowData.get(59))); // 镁
                experimentExamBiochemicalTestsSaveReqVO.setFastingGlucose(parseBigDecimal(rowData.get(60))); // 葡萄糖空腹
                experimentExamBiochemicalTestsSaveReqVO.setProthrombinTime(parseBigDecimal(rowData.get(61))); // 凝血酶原时间
                experimentExamBiochemicalTestsSaveReqVO.setProthrombinActivity(parseBigDecimal(rowData.get(62))); // 凝血酶原活动度
                experimentExamBiochemicalTestsSaveReqVO.setInr(parseBigDecimal(rowData.get(63))); // 国际标准化比率
                experimentExamBiochemicalTestsSaveReqVO.setFibrinogen(parseBigDecimal(rowData.get(64))); // 纤维蛋白原
                experimentExamBiochemicalTestsSaveReqVO.setAptt(parseBigDecimal(rowData.get(65))); // 活化部分凝血活酶时间
                experimentExamBiochemicalTestsSaveReqVO.setThrombinTime(parseBigDecimal(rowData.get(66))); // 凝血酶时间

                experimentExamBloodRoutineSaveReqVO.setPersonId(generatedId);
                experimentExamBloodRoutineSaveReqVO.setWbc(parseBigDecimal(rowData.get(14))); // 白细胞计数
                experimentExamBloodRoutineSaveReqVO.setRbc(parseBigDecimal(rowData.get(15))); // 红细胞计数
                experimentExamBloodRoutineSaveReqVO.setNeutrophils(parseBigDecimal(rowData.get(16))); // 中性粒细胞计数
                experimentExamBloodRoutineSaveReqVO.setLymphocytes(parseBigDecimal(rowData.get(17))); // 淋巴细胞计数
                experimentExamBloodRoutineSaveReqVO.setMonocytes(parseBigDecimal(rowData.get(18))); // 单核细胞计数
                experimentExamBloodRoutineSaveReqVO.setEosinophils(parseBigDecimal(rowData.get(19))); // 嗜酸性粒细胞计数
                experimentExamBloodRoutineSaveReqVO.setBasophils(parseBigDecimal(rowData.get(20))); // 嗜碱性粒细胞计数
                experimentExamBloodRoutineSaveReqVO.setMcv(parseBigDecimal(rowData.get(21))); // 平均红细胞容积
                experimentExamBloodRoutineSaveReqVO.setMch(parseBigDecimal(rowData.get(22))); // 平均红细胞血红蛋白含量
                experimentExamBloodRoutineSaveReqVO.setMchc(parseBigDecimal(rowData.get(23))); // 平均红细胞血红蛋白浓度
                experimentExamBloodRoutineSaveReqVO.setRdwCv(parseBigDecimal(rowData.get(24))); // RBC分布宽度CV值
                experimentExamBloodRoutineSaveReqVO.setRdwSd(parseBigDecimal(rowData.get(25))); // RBC分布宽度SD值
                experimentExamBloodRoutineSaveReqVO.setHemoglobin(parseBigDecimal(rowData.get(26))); // 血红蛋白浓度
                experimentExamBloodRoutineSaveReqVO.setPlateletCrit(parseBigDecimal(rowData.get(27))); // 血小板比容
                experimentExamBloodRoutineSaveReqVO.setMpv(parseBigDecimal(rowData.get(28))); // 平均血小板体积
                experimentExamBloodRoutineSaveReqVO.setPdw(parseBigDecimal(rowData.get(29))); // 血小板分布宽度
                experimentExamBloodRoutineSaveReqVO.setHematocrit(parseBigDecimal(rowData.get(30))); // 红细胞比容
                experimentExamBloodRoutineSaveReqVO.setPlateletCount(parseBigDecimal(rowData.get(31))); // 血小板计数
                experimentExamBloodRoutineSaveReqVO.setNeutrophilsPercentage(parseBigDecimal(rowData.get(32))); // 中性粒细胞百分率
                experimentExamBloodRoutineSaveReqVO.setLymphocytesPercentage(parseBigDecimal(rowData.get(33))); // 淋巴细胞百分率
                experimentExamBloodRoutineSaveReqVO.setMonocytesPercentage(parseBigDecimal(rowData.get(34))); // 单核细胞百分率
                experimentExamBloodRoutineSaveReqVO.setEosinophilsPercentage(parseBigDecimal(rowData.get(35))); // 嗜酸性粒细胞百分率
                experimentExamBloodRoutineSaveReqVO.setBasophilsPercentage(parseBigDecimal(rowData.get(36))); // 嗜碱性粒细胞百分率

                experimentExamEcgSaveReqVO.setPersonId(generatedId);
                experimentExamEcgSaveReqVO.setEcgDescription(rowData.get(67)); // 心电图描述（第67列）

                experimentExamPastMedicalHistorySaveReqVO.setPersonId(generatedId);
                experimentExamPastMedicalHistorySaveReqVO.setInternalDiseaseHistory(rowData.get(12)); // 内科疾病史（第12列）
                experimentExamPastMedicalHistorySaveReqVO.setExternalDiseaseHistory(rowData.get(13)); // 外科疾病史（第13列）

                // 保存 BasicOtherInfoRespVO 到数据库
                experimentExamAbdominalUltrasoundService.createExperimentExamAbdominalUltrasound(experimentExamAbdominalUltrasoundSaveReqVO);
                experimentExamBasicTestsService.createExperimentExamBasicTests(experimentExamBasicTestsSaveReqVO);
                experimentExamBiochemicalTestsService.createExperimentExamBiochemicalTests(experimentExamBiochemicalTestsSaveReqVO);
                experimentExamBloodRoutineService.createExperimentExamBloodRoutine(experimentExamBloodRoutineSaveReqVO);
                experimentExamEcgService.createExperimentExamEcg(experimentExamEcgSaveReqVO);
                experimentExamPastMedicalHistoryService.createExperimentExamPastMedicalHistory(experimentExamPastMedicalHistorySaveReqVO);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importControlSurvey")
    public String importControlSurvey() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/汇总-对照组-流调.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\汇总-对照组-流调.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener3(
                        basicInfoService
                        , basicOtherInfoService
                        , controlSurveyDrinkingInfoService
                        , controlSurveyPastDiseasesService
                        , controlSurveyResidenceInfoService
                        , controlSurveySelfAssessmentService
                        , controlSurveySmokingInfoService))
                .sheet()
                .doRead();

        return "对照组流调数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener3 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private BasicOtherInfoService basicOtherInfoService;
        private ControlSurveyDrinkingInfoService controlSurveyDrinkingInfoService;
        private ControlSurveyPastDiseasesService controlSurveyPastDiseasesService;
        private ControlSurveyResidenceInfoService controlSurveyResidenceInfoService;
        private ControlSurveySelfAssessmentService controlSurveySelfAssessmentService;
        private ControlSurveySmokingInfoService controlSurveySmokingInfoService;

        // 构造函数注入服务
        public IndexListener3(
                BasicInfoService basicInfoService
                , BasicOtherInfoService basicOtherInfoService
                , ControlSurveyDrinkingInfoService controlSurveyDrinkingInfoService
                , ControlSurveyPastDiseasesService controlSurveyPastDiseasesService
                , ControlSurveyResidenceInfoService controlSurveyResidenceInfoService
                , ControlSurveySelfAssessmentService controlSurveySelfAssessmentService
                , ControlSurveySmokingInfoService controlSurveySmokingInfoService) {
            this.basicInfoService = basicInfoService;
            this.basicOtherInfoService = basicOtherInfoService;
            this.controlSurveyDrinkingInfoService = controlSurveyDrinkingInfoService;
            this.controlSurveyPastDiseasesService = controlSurveyPastDiseasesService;
            this.controlSurveyResidenceInfoService = controlSurveyResidenceInfoService;
            this.controlSurveySelfAssessmentService = controlSurveySelfAssessmentService;
            this.controlSurveySmokingInfoService = controlSurveySmokingInfoService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
                ControlSurveyDrinkingInfoSaveReqVO controlSurveyDrinkingInfoSaveReqVO = new ControlSurveyDrinkingInfoSaveReqVO();
                ControlSurveyPastDiseasesSaveReqVO controlSurveyPastDiseasesSaveReqVO = new ControlSurveyPastDiseasesSaveReqVO();
                ControlSurveyResidenceInfoSaveReqVO controlSurveyResidenceInfoSaveReqVO = new ControlSurveyResidenceInfoSaveReqVO();
                ControlSurveySelfAssessmentSaveReqVO controlSurveySelfAssessmentSaveReqVO = new ControlSurveySelfAssessmentSaveReqVO();
                ControlSurveySmokingInfoSaveReqVO controlSurveySmokingInfoSaveReqVO = new ControlSurveySmokingInfoSaveReqVO();

                Long generatedId = 0L;

                basicInfo.setName(rowData.get(1)); // 姓名
                basicInfo.setGender(rowData.get(2)); // 性别
                basicInfo.setHighestEducation(rowData.get(6)); // 最高学历
                basicInfo.setEthnicity(rowData.get(7)); // 民族
                basicInfo.setMaritalStatus(rowData.get(5)); // 婚姻情况
                basicInfo.setHeight(extractNumber(rowData.get(8))); // 身高
                basicInfo.setWeight(extractNumber(rowData.get(9))); // 体重
                basicInfo.setType(2); // 1：实验组，2：对照组

                // 保存 BasicInfoRespVO 到数据库
                generatedId = basicInfoService.createBasicInfo(basicInfo);

                basicOtherInfo.setPersonId(generatedId);
//                basicOtherInfo.setFertilityStatus(rowData.get(8));              // 生育情况
                // 获取第13列的值
//                String weightData = rowData.get(13).toString();  // 获取字段并转换为字符串
//                BigDecimal retiredWeight = BigDecimal.ZERO;  // 默认值为0
//                // 判断是否包含 "Kg"，并处理数值部分
//                if (weightData != null) {
//                    // 如果包含 "Kg"，去掉 "Kg" 部分
//                    if (weightData.endsWith("Kg")) {
//                        weightData = weightData.replaceAll("Kg", "");  // 去掉单位 "Kg"
//                    }
//                    // 判断剩余部分是否为有效数字
//                    if (weightData.matches("\\d+")) {  // 只有数字（整数）部分
//                        retiredWeight = parseBigDecimal(weightData);  // 转换为BigDecimal
//                    } else {
//                        // 如果不是有效的数字，默认为0
//                        retiredWeight = BigDecimal.ZERO;
//                    }
//                }
//                basicOtherInfo.setRetiredWeight(retiredWeight);  // 设置退役体重  // 退役体重（第13列）
                basicOtherInfo.setContactPhone(rowData.get(4)); // 联系电话
                basicOtherInfoService.createBasicOtherInfo(basicOtherInfo);

                //对照组流调-饮酒情况
                controlSurveyDrinkingInfoSaveReqVO.setPersonId(generatedId);
                controlSurveyDrinkingInfoSaveReqVO.setDrinkingExperience(rowData.get(14));
                controlSurveyDrinkingInfoSaveReqVO.setDrinkingFrequency(rowData.get(15));


                //对照组流调-既往疾病
                controlSurveyPastDiseasesSaveReqVO.setPersonId(generatedId);
                controlSurveyPastDiseasesSaveReqVO.setDisease1Name(rowData.get(24));              // 24: 既往疾病1_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease1Diagnosed(parseBoolean(rowData.get(25)));         // 25: 既往疾病1_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease1DiagnosisDate(rowData.get(26));     // 26: 既往疾病1_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease1Hospitalized(parseBoolean(rowData.get(27)));      // 27: 既往疾病1_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease1Treated(parseBoolean(rowData.get(28)));           // 28: 既往疾病1_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease1TreatmentEffect(rowData.get(29));   // 29: 既往疾病1_治疗效果
                controlSurveyPastDiseasesSaveReqVO.setDisease2Name(rowData.get(30));              // 30: 既往疾病2_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease2Diagnosed(parseBoolean(rowData.get(31)));         // 31: 既往疾病2_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease2DiagnosisDate(rowData.get(32));     // 32: 既往疾病2_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease2Hospitalized(parseBoolean(rowData.get(33)));      // 33: 既往疾病2_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease2Treated(parseBoolean(rowData.get(34)));           // 34: 既往疾病2_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease2TreatmentEffect(rowData.get(35));   // 35: 既往疾病2_治疗效果
                controlSurveyPastDiseasesSaveReqVO.setDisease3Name(rowData.get(36));              // 36: 既往疾病3_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease3Diagnosed(parseBoolean(rowData.get(37)));         // 37: 既往疾病3_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease3DiagnosisDate(rowData.get(38));     // 38: 既往疾病3_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease3Hospitalized(parseBoolean(rowData.get(39)));      // 39: 既往疾病3_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease3Treated(parseBoolean(rowData.get(40)));           // 40: 既往疾病3_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease3TreatmentEffect(rowData.get(41));   // 41: 既往疾病3_治疗效果
                controlSurveyPastDiseasesSaveReqVO.setDisease4Name(rowData.get(42));              // 42: 既往疾病4_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease4Diagnosed(parseBoolean(rowData.get(43)));         // 43: 既往疾病4_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease4DiagnosisDate(rowData.get(44));     // 44: 既往疾病4_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease4Hospitalized(parseBoolean(rowData.get(45)));      // 45: 既往疾病4_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease4Treated(parseBoolean(rowData.get(46)));           // 46: 既往疾病4_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease4TreatmentEffect(rowData.get(47));   // 47: 既往疾病4_治疗效果
                controlSurveyPastDiseasesSaveReqVO.setDisease5Name(rowData.get(48));              // 48: 既往疾病5_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease5Diagnosed(parseBoolean(rowData.get(49)));         // 49: 既往疾病5_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease5DiagnosisDate(rowData.get(50));     // 50: 既往疾病5_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease5Hospitalized(parseBoolean(rowData.get(51)));      // 51: 既往疾病5_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease5Treated(parseBoolean(rowData.get(52)));           // 52: 既往疾病5_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease5TreatmentEffect(rowData.get(53));   // 53: 既往疾病5_治疗效果
                controlSurveyPastDiseasesSaveReqVO.setDisease6Name(rowData.get(54));              // 54: 既往疾病6_名称
                controlSurveyPastDiseasesSaveReqVO.setDisease6Diagnosed(parseBoolean(rowData.get(55)));         // 55: 既往疾病6_是否确诊
                controlSurveyPastDiseasesSaveReqVO.setDisease6DiagnosisDate(rowData.get(56));     // 56: 既往疾病6_确诊时间
                controlSurveyPastDiseasesSaveReqVO.setDisease6Hospitalized(parseBoolean(rowData.get(57)));      // 57: 既往疾病6_是否住院
                controlSurveyPastDiseasesSaveReqVO.setDisease6Treated(parseBoolean(rowData.get(58)));           // 58: 既往疾病6_是否治疗
                controlSurveyPastDiseasesSaveReqVO.setDisease6TreatmentEffect(rowData.get(59));   // 59: 既往疾病6_治疗效果

                //对照组流调-旅居信息
                controlSurveyResidenceInfoSaveReqVO.setPersonId(generatedId);
                controlSurveyResidenceInfoSaveReqVO.setHighlandExperience(rowData.get(16));         // 16: 是否有高原经历
                controlSurveyResidenceInfoSaveReqVO.setLongTermPlainExperience(rowData.get(17));    // 17: 是否有长期平原经历
                controlSurveyResidenceInfoSaveReqVO.setResidence1(rowData.get(18));                 // 18: 常住地1
                controlSurveyResidenceInfoSaveReqVO.setResidence2(rowData.get(19));                 // 19: 常住地2
                controlSurveyResidenceInfoSaveReqVO.setResidence3(rowData.get(20));                 // 20: 常住地3

                //对照组流调-自我评价
                controlSurveySelfAssessmentSaveReqVO.setPersonId(generatedId);
                controlSurveySelfAssessmentSaveReqVO.setAnnualCheckups(rowData.get(21)); // 年度体检（第21列）
                controlSurveySelfAssessmentSaveReqVO.setHealthComparison(rowData.get(22)); // 与同龄人相比，您认为目前自己的身体健康状况如何（第22列）
                controlSurveySelfAssessmentSaveReqVO.setHealthScore(rowData.get(23) != null ? Integer.valueOf(rowData.get(23)) : 0); // 您认为自己身体健康状况能得的分数（第23列）

                //对照组流调-吸烟情况
                controlSurveySmokingInfoSaveReqVO.setPersonId(generatedId);
                controlSurveySmokingInfoSaveReqVO.setSmokingStatus(rowData.get(10));  // 是否吸烟（第10列）
                controlSurveySmokingInfoSaveReqVO.setSmokingYears(rowData.get(11) != null ? Integer.valueOf(rowData.get(11)) : 0);  // 吸烟年限（第11列）
                controlSurveySmokingInfoSaveReqVO.setTriedQuit(rowData.get(12));  // 是否尝试戒烟（第12列）
                controlSurveySmokingInfoSaveReqVO.setQuitTime(rowData.get(13));  // 戒烟时间（第13列）

                // 保存 BasicOtherInfoRespVO 到数据库
                controlSurveyDrinkingInfoService.createControlSurveyDrinkingInfo(controlSurveyDrinkingInfoSaveReqVO);
                controlSurveyPastDiseasesService.createControlSurveyPastDiseases(controlSurveyPastDiseasesSaveReqVO);
                controlSurveyResidenceInfoService.createControlSurveyResidenceInfo(controlSurveyResidenceInfoSaveReqVO);
                controlSurveySelfAssessmentService.createControlSurveySelfAssessment(controlSurveySelfAssessmentSaveReqVO);
                controlSurveySmokingInfoService.createControlSurveySmokingInfo(controlSurveySmokingInfoSaveReqVO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importControlExam")
    public String importControlExam() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/汇总-对照组-体检.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\汇总-对照组-体检.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener4(
                        basicInfoService
                        , basicOtherInfoService
                        , controlExamAbdominalUltrasoundService
                        , controlExamBasicTestsService
                        , controlExamBiochemicalTestsService
                        , controlExamBloodRoutineService
                        , controlExamEcgService
                        , controlExamPastMedicalHistoryService))
                .sheet()
                .doRead();

        return "对照组体检数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener4 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private BasicOtherInfoService basicOtherInfoService;
        private ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService;
        private ControlExamBasicTestsService controlExamBasicTestsService;
        private ControlExamBiochemicalTestsService controlExamBiochemicalTestsService;
        private ControlExamBloodRoutineService controlExamBloodRoutineService;
        private ControlExamEcgService controlExamEcgService;
        private ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService;

        // 构造函数注入服务
        public IndexListener4(
                BasicInfoService basicInfoService
                , BasicOtherInfoService basicOtherInfoService
                , ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService
                , ControlExamBasicTestsService controlExamBasicTestsService
                , ControlExamBiochemicalTestsService controlExamBiochemicalTestsService
                , ControlExamBloodRoutineService controlExamBloodRoutineService
                , ControlExamEcgService controlExamEcgService
                , ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService) {
            this.basicInfoService = basicInfoService;
            this.basicOtherInfoService = basicOtherInfoService;
            this.controlExamAbdominalUltrasoundService = controlExamAbdominalUltrasoundService;
            this.controlExamBasicTestsService = controlExamBasicTestsService;
            this.controlExamBiochemicalTestsService = controlExamBiochemicalTestsService;
            this.controlExamBloodRoutineService = controlExamBloodRoutineService;
            this.controlExamEcgService = controlExamEcgService;
            this.controlExamPastMedicalHistoryService = controlExamPastMedicalHistoryService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
                ControlExamAbdominalUltrasoundSaveReqVO controlExamAbdominalUltrasoundSaveReqVO = new ControlExamAbdominalUltrasoundSaveReqVO();
                ControlExamBasicTestsSaveReqVO controlExamBasicTestsSaveReqVO = new ControlExamBasicTestsSaveReqVO();
                ControlExamBiochemicalTestsSaveReqVO controlExamBiochemicalTestsSaveReqVO = new ControlExamBiochemicalTestsSaveReqVO();
                ControlExamBloodRoutineSaveReqVO controlExamBloodRoutineSaveReqVO = new ControlExamBloodRoutineSaveReqVO();
                ControlExamEcgSaveReqVO controlExamEcgSaveReqVO = new ControlExamEcgSaveReqVO();
                ControlExamPastMedicalHistorySaveReqVO controlExamPastMedicalHistorySaveReqVO = new ControlExamPastMedicalHistorySaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(1)); // 姓名
                basicInfoPageReqVO.setType(2); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(1)); // 姓名
                    basicInfo.setGender(rowData.get(2)); // 性别
                    basicInfo.setType(2); // 1：实验组，2：对照组
//                basicInfo.setHighestEducation(rowData.get(6)); // 最高学历
//                basicInfo.setEthnicity(rowData.get(7)); // 民族
//                basicInfo.setMaritalStatus(rowData.get(5)); // 婚姻情况
//                basicInfo.setHeight(extractNumber(rowData.get(8))); // 身高
//                basicInfo.setWeight(extractNumber(rowData.get(9))); // 体重

                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);

                    basicOtherInfo.setPersonId(generatedId);
                    basicOtherInfo.setAge(Integer.valueOf(rowData.get(3))); // 年龄
//                basicOtherInfo.setFertilityStatus(rowData.get(8));              // 生育情况
                    // 获取第13列的值
//                String weightData = rowData.get(13).toString();  // 获取字段并转换为字符串
//                BigDecimal retiredWeight = BigDecimal.ZERO;  // 默认值为0
//                // 判断是否包含 "Kg"，并处理数值部分
//                if (weightData != null) {
//                    // 如果包含 "Kg"，去掉 "Kg" 部分
//                    if (weightData.endsWith("Kg")) {
//                        weightData = weightData.replaceAll("Kg", "");  // 去掉单位 "Kg"
//                    }
//                    // 判断剩余部分是否为有效数字
//                    if (weightData.matches("\\d+")) {  // 只有数字（整数）部分
//                        retiredWeight = parseBigDecimal(weightData);  // 转换为BigDecimal
//                    } else {
//                        // 如果不是有效的数字，默认为0
//                        retiredWeight = BigDecimal.ZERO;
//                    }
//                }
//                basicOtherInfo.setRetiredWeight(retiredWeight);  // 设置退役体重  // 退役体重（第13列）
                    String dateStr = rowData.get(4);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    date = sdf.parse(dateStr);
                    basicOtherInfo.setMedicalCheckDate(date);// 体检日期
                    basicOtherInfo.setContactPhone(rowData.get(5)); // 联系电话
                    basicOtherInfoService.createBasicOtherInfo(basicOtherInfo);
                }

                UpdateWrapper<BasicOtherInfoDO> updateBasicOtherInfoWrapper = new UpdateWrapper<>();
                updateBasicOtherInfoWrapper.eq("person_id", generatedId);
                BasicOtherInfoSaveReqVO basicOtherInfoSaveReqVO = new BasicOtherInfoSaveReqVO();
                basicOtherInfoSaveReqVO.setPersonId(generatedId);
                basicOtherInfoSaveReqVO.setAge(Integer.valueOf(rowData.get(3))); // 年龄
                String dateStr = rowData.get(4);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                date = sdf.parse(dateStr);
                basicOtherInfoSaveReqVO.setMedicalCheckDate(date);// 体检日期
                basicOtherInfoSaveReqVO.setContactPhone(rowData.get(5)); // 联系电话
                basicOtherInfoService.updateBasicOtherInfoByWrapper(basicOtherInfoSaveReqVO,updateBasicOtherInfoWrapper);

                controlExamAbdominalUltrasoundSaveReqVO.setPersonId(generatedId);
                controlExamAbdominalUltrasoundSaveReqVO.setUltrasoundDescription(rowData.get(68)); // 超声描述（第68列）
                controlExamAbdominalUltrasoundSaveReqVO.setUltrasoundSummary(rowData.get(69)); // 超声总结（第69列）

                controlExamBasicTestsSaveReqVO.setPersonId(generatedId);
                controlExamBasicTestsSaveReqVO.setSystolicPressure(parseBigDecimal(rowData.get(6))); // 收缩压（第6列）
                controlExamBasicTestsSaveReqVO.setDiastolicPressure(parseBigDecimal(rowData.get(7))); // 舒张压（第7列）
                controlExamBasicTestsSaveReqVO.setPulse(parseInteger(rowData.get(8))); // 脉搏（第8列）
                controlExamBasicTestsSaveReqVO.setHeight(parseBigDecimal(rowData.get(9))); // 身高（第9列）
                controlExamBasicTestsSaveReqVO.setWeight(parseBigDecimal(rowData.get(10))); // 体重（第10列）
                controlExamBasicTestsSaveReqVO.setBmi(parseBigDecimal(rowData.get(11))); // 体重指数(kg/m^2)（第11列）


                controlExamBiochemicalTestsSaveReqVO.setPersonId(generatedId);
                controlExamBiochemicalTestsSaveReqVO.setUrea(parseBigDecimal(rowData.get(37))); // 尿素
                controlExamBiochemicalTestsSaveReqVO.setCreatinine(parseBigDecimal(rowData.get(38))); // 肌酐
                controlExamBiochemicalTestsSaveReqVO.setAlt(parseBigDecimal(rowData.get(39))); // 谷丙转氨酶
                controlExamBiochemicalTestsSaveReqVO.setAst(parseBigDecimal(rowData.get(40))); // 谷草转氨酶
                controlExamBiochemicalTestsSaveReqVO.setTotalCholesterol(parseBigDecimal(rowData.get(41))); // 总胆固醇
                controlExamBiochemicalTestsSaveReqVO.setTriglycerides(parseBigDecimal(rowData.get(42))); // 甘油三酯
                controlExamBiochemicalTestsSaveReqVO.setHdlC(parseBigDecimal(rowData.get(43))); // 高密度脂蛋白胆固醇
                controlExamBiochemicalTestsSaveReqVO.setLdlC(parseBigDecimal(rowData.get(44))); // 低密度脂蛋白胆固醇
                controlExamBiochemicalTestsSaveReqVO.setUricAcid(parseBigDecimal(rowData.get(45))); // 尿酸
                controlExamBiochemicalTestsSaveReqVO.setTotalProtein(parseBigDecimal(rowData.get(46))); // 总蛋白
                controlExamBiochemicalTestsSaveReqVO.setAlbumin(parseBigDecimal(rowData.get(47))); // 白蛋白
                controlExamBiochemicalTestsSaveReqVO.setGlobulin(parseBigDecimal(rowData.get(48))); // 球蛋白
                controlExamBiochemicalTestsSaveReqVO.setAlbGlobRatio(parseBigDecimal(rowData.get(49))); // 白球比例
                controlExamBiochemicalTestsSaveReqVO.setTotalBilirubin(parseBigDecimal(rowData.get(50))); // 总胆红素
                controlExamBiochemicalTestsSaveReqVO.setDirectBilirubin(parseBigDecimal(rowData.get(51))); // 直接胆红素
                controlExamBiochemicalTestsSaveReqVO.setIndirectBilirubin(parseBigDecimal(rowData.get(52))); // 间接胆红素
                controlExamBiochemicalTestsSaveReqVO.setGlycatedHemoglobin(parseBigDecimal(rowData.get(53))); // 糖化血红蛋白
                controlExamBiochemicalTestsSaveReqVO.setPotassium(parseBigDecimal(rowData.get(54))); // 钾
                controlExamBiochemicalTestsSaveReqVO.setSodium(parseBigDecimal(rowData.get(55))); // 钠
                controlExamBiochemicalTestsSaveReqVO.setChloride(parseBigDecimal(rowData.get(56))); // 氯
                controlExamBiochemicalTestsSaveReqVO.setCalcium(parseBigDecimal(rowData.get(57))); // 钙
                controlExamBiochemicalTestsSaveReqVO.setPhosphorus(parseBigDecimal(rowData.get(58))); // 磷
                controlExamBiochemicalTestsSaveReqVO.setMagnesium(parseBigDecimal(rowData.get(59))); // 镁
                controlExamBiochemicalTestsSaveReqVO.setFastingGlucose(parseBigDecimal(rowData.get(60))); // 葡萄糖空腹
                controlExamBiochemicalTestsSaveReqVO.setProthrombinTime(parseBigDecimal(rowData.get(61))); // 凝血酶原时间
                controlExamBiochemicalTestsSaveReqVO.setProthrombinActivity(parseBigDecimal(rowData.get(62))); // 凝血酶原活动度
                controlExamBiochemicalTestsSaveReqVO.setInr(parseBigDecimal(rowData.get(63))); // 国际标准化比率
                controlExamBiochemicalTestsSaveReqVO.setFibrinogen(parseBigDecimal(rowData.get(64))); // 纤维蛋白原
                controlExamBiochemicalTestsSaveReqVO.setAptt(parseBigDecimal(rowData.get(65))); // 活化部分凝血活酶时间
                controlExamBiochemicalTestsSaveReqVO.setThrombinTime(parseBigDecimal(rowData.get(66))); // 凝血酶时间

                controlExamBloodRoutineSaveReqVO.setPersonId(generatedId);
                controlExamBloodRoutineSaveReqVO.setWbc(parseBigDecimal(rowData.get(14))); // 白细胞计数
                controlExamBloodRoutineSaveReqVO.setRbc(parseBigDecimal(rowData.get(15))); // 红细胞计数
                controlExamBloodRoutineSaveReqVO.setNeutrophils(parseBigDecimal(rowData.get(16))); // 中性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setLymphocytes(parseBigDecimal(rowData.get(17))); // 淋巴细胞计数
                controlExamBloodRoutineSaveReqVO.setMonocytes(parseBigDecimal(rowData.get(18))); // 单核细胞计数
                controlExamBloodRoutineSaveReqVO.setEosinophils(parseBigDecimal(rowData.get(19))); // 嗜酸性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setBasophils(parseBigDecimal(rowData.get(20))); // 嗜碱性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setMcv(parseBigDecimal(rowData.get(21))); // 平均红细胞容积
                controlExamBloodRoutineSaveReqVO.setMch(parseBigDecimal(rowData.get(22))); // 平均红细胞血红蛋白含量
                controlExamBloodRoutineSaveReqVO.setMchc(parseBigDecimal(rowData.get(23))); // 平均红细胞血红蛋白浓度
                controlExamBloodRoutineSaveReqVO.setRdwCv(parseBigDecimal(rowData.get(24))); // RBC分布宽度CV值
                controlExamBloodRoutineSaveReqVO.setRdwSd(parseBigDecimal(rowData.get(25))); // RBC分布宽度SD值
                controlExamBloodRoutineSaveReqVO.setHemoglobin(parseBigDecimal(rowData.get(26))); // 血红蛋白浓度
                controlExamBloodRoutineSaveReqVO.setPlateletCrit(parseBigDecimal(rowData.get(27))); // 血小板比容
                controlExamBloodRoutineSaveReqVO.setMpv(parseBigDecimal(rowData.get(28))); // 平均血小板体积
                controlExamBloodRoutineSaveReqVO.setPdw(parseBigDecimal(rowData.get(29))); // 血小板分布宽度
                controlExamBloodRoutineSaveReqVO.setHematocrit(parseBigDecimal(rowData.get(30))); // 红细胞比容
                controlExamBloodRoutineSaveReqVO.setPlateletCount(parseBigDecimal(rowData.get(31))); // 血小板计数
                controlExamBloodRoutineSaveReqVO.setNeutrophilsPercentage(parseBigDecimal(rowData.get(32))); // 中性粒细胞百分率
                controlExamBloodRoutineSaveReqVO.setLymphocytesPercentage(parseBigDecimal(rowData.get(33))); // 淋巴细胞百分率
                controlExamBloodRoutineSaveReqVO.setMonocytesPercentage(parseBigDecimal(rowData.get(34))); // 单核细胞百分率
                controlExamBloodRoutineSaveReqVO.setEosinophilsPercentage(parseBigDecimal(rowData.get(35))); // 嗜酸性粒细胞百分率
                controlExamBloodRoutineSaveReqVO.setBasophilsPercentage(parseBigDecimal(rowData.get(36))); // 嗜碱性粒细胞百分率

                controlExamEcgSaveReqVO.setPersonId(generatedId);
                controlExamEcgSaveReqVO.setEcgDescription(rowData.get(67)); // 心电图描述（第67列）

                controlExamPastMedicalHistorySaveReqVO.setPersonId(generatedId);
                controlExamPastMedicalHistorySaveReqVO.setInternalDiseaseHistory(rowData.get(12)); // 内科疾病史（第12列）
                controlExamPastMedicalHistorySaveReqVO.setExternalDiseaseHistory(rowData.get(13)); // 外科疾病史（第13列）

                // 保存 BasicOtherInfoRespVO 到数据库
                controlExamAbdominalUltrasoundService.createControlExamAbdominalUltrasound(controlExamAbdominalUltrasoundSaveReqVO);
                controlExamBasicTestsService.createControlExamBasicTests(controlExamBasicTestsSaveReqVO);
                controlExamBiochemicalTestsService.createControlExamBiochemicalTests(controlExamBiochemicalTestsSaveReqVO);
                controlExamBloodRoutineService.createControlExamBloodRoutine(controlExamBloodRoutineSaveReqVO);
                controlExamEcgService.createControlExamEcg(controlExamEcgSaveReqVO);
                controlExamPastMedicalHistoryService.createControlExamPastMedicalHistory(controlExamPastMedicalHistorySaveReqVO);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/getDataByParamPage")
    @Operation(summary = "获得回顾性基础信息分页")
    @PreAuthorize("@ss.hasPermission('review:basic-info:query')")
    public CommonResult<PageResult<BasicInfoRespVO>> getDataByParamPage(@Valid BasicInfoPageReqVO pageReqVO) {
        PageResult<BasicInfoDO> pageResult = basicInfoService.getDataByParamPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BasicInfoRespVO.class));
    }

    @GetMapping("/getAverageByParam")
    @Operation(summary = "获得回顾性平均值")
    public CommonResult<BasicInfoAverageVO> getAverageByParam(@Valid BasicInfoPageReqVO pageReqVO) {
        BasicInfoAverageVO basicInfoAverage = basicInfoService.getAverageByParam(pageReqVO);
        return success(BeanUtils.toBean(basicInfoAverage, BasicInfoAverageVO.class));
    }

    // 工具方法：从字符串中提取数字（包括小数点）
    private static BigDecimal extractNumber(String value) {
        if (value == null) return null;
        // 提取字符串中的数字和小数点
        String numericStr = value.replaceAll("[^\\d.]", "");
        if (numericStr.isEmpty()) return null;
        try {
            return parseBigDecimal(numericStr);
        } catch (NumberFormatException e) {
            return null;
        }
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
     * 将布尔类型表示的字符串转换为 Integer（1 表示 true，0 表示 false）。
     */
    public static Integer parseBooleanToInteger(String value) {
        if (value == null) {
            return 0;
        }
        String val = value.trim().toLowerCase();
        return ("true".equals(val) || "1".equals(val) || "是".equals(val) || "yes".equals(val)) ? 1 : 0;
    }

    public static Integer parseReactionCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        input = input.replaceAll("[^0-9\\-+]", ""); // 只保留数字、-、+
        if (input.contains("-")) {
            // 情况三和四：范围，如 "4-5" 或 "5-6次"
            String[] parts = input.split("-");
            try {
                return Math.max(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (input.contains("+")) {
            // 情况五：如 "12+"
            input = input.replace("+", "");
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            // 情况一和二：纯数字或带单位的数字，如 "16次"
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    //提取数字，如果没有数字则返回 0
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

    //    http://localhost:48080/admin-api/review/basic-info/importExcelExperimentSurvey
    //    http://localhost:48080/admin-api/review/basic-info/importExcelExperimentExam
    //    http://localhost:48080/admin-api/review/basic-info/importControlSurvey
    //    http://localhost:48080/admin-api/review/basic-info/importControlExam

//    http://localhost:48080/admin-api/review/basic-info/importExcelExperimentDiseaseSpectrum
//    http://localhost:48080/admin-api/review/basic-info/importExcelControlDiseaseSpectrum
//    http://localhost:48080/admin-api/review/basic-info/importExcelExperimentFramingham
//    http://localhost:48080/admin-api/review/basic-info/importExcelControlFramingham


    @GetMapping("/importExcelExperimentDiseaseSpectrum")
    public String importExcelExperimentDiseaseSpectrum() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/04.2 实验组疾-病谱标记.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\04.2 实验组疾-病谱标记.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener5(
                        basicInfoService
                        , experimentDiseaseSpectrumService))
                .sheet()
                .doRead();

        return "实验组疾病谱数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener5 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService;

        // 构造函数注入服务
        public IndexListener5(
                BasicInfoService basicInfoService
                , ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService) {
            this.basicInfoService = basicInfoService;
            this.experimentDiseaseSpectrumService = experimentDiseaseSpectrumService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                ExperimentDiseaseSpectrumSaveReqVO experimentDiseaseSpectrumSaveReqVO = new ExperimentDiseaseSpectrumSaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(0)); // 姓名
                basicInfoPageReqVO.setType(1); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(0)); // 姓名
                    basicInfo.setType(1); // 1：实验组，2：对照组
                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);
                }


                experimentDiseaseSpectrumSaveReqVO.setPersonId(generatedId);
                experimentDiseaseSpectrumSaveReqVO.setFattyLiver(parseBoolean(rowData.get(1)));
                experimentDiseaseSpectrumSaveReqVO.setHepaticCyst(parseBoolean(rowData.get(2)));
                experimentDiseaseSpectrumSaveReqVO.setGallbladderPolyp(parseBoolean(rowData.get(3)));
                experimentDiseaseSpectrumSaveReqVO.setGallbladderStone(parseBoolean(rowData.get(4)));
                experimentDiseaseSpectrumSaveReqVO.setHepaticHemangioma(parseBoolean(rowData.get(5)));
                experimentDiseaseSpectrumSaveReqVO.setSplenomegaly(parseBoolean(rowData.get(6)));
                experimentDiseaseSpectrumSaveReqVO.setChronicGastritis(parseBoolean(rowData.get(7)));
                experimentDiseaseSpectrumSaveReqVO.setIntestinalPolyp(parseBoolean(rowData.get(8)));
                experimentDiseaseSpectrumSaveReqVO.setAppendicitis(parseBoolean(rowData.get(9)));
                experimentDiseaseSpectrumSaveReqVO.setAcutePancreatitis(parseBoolean(rowData.get(10)));
                experimentDiseaseSpectrumSaveReqVO.setDigestiveUlcer(parseBoolean(rowData.get(11)));
                experimentDiseaseSpectrumSaveReqVO.setDigestiveBleeding(parseBoolean(rowData.get(12)));
                experimentDiseaseSpectrumSaveReqVO.setHypertension(parseBoolean(rowData.get(13)));
                experimentDiseaseSpectrumSaveReqVO.setBradycardia(parseBoolean(rowData.get(14)));
                experimentDiseaseSpectrumSaveReqVO.setTransientIschemicAttack(parseBoolean(rowData.get(15)));
                experimentDiseaseSpectrumSaveReqVO.setTachycardia(parseBoolean(rowData.get(16)));
                experimentDiseaseSpectrumSaveReqVO.setCerebralInfarction(parseBoolean(rowData.get(17)));
                experimentDiseaseSpectrumSaveReqVO.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(18)));
                experimentDiseaseSpectrumSaveReqVO.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(19)));
                experimentDiseaseSpectrumSaveReqVO.setCoronaryHeartDisease(parseBoolean(rowData.get(20)));
                experimentDiseaseSpectrumSaveReqVO.setAtrialFibrillation(parseBoolean(rowData.get(21)));
                experimentDiseaseSpectrumSaveReqVO.setMyocardialInfarction(parseBoolean(rowData.get(22)));
                experimentDiseaseSpectrumSaveReqVO.setHypertriglyceridemia(parseBoolean(rowData.get(23)));
                experimentDiseaseSpectrumSaveReqVO.setHighLdl(parseBoolean(rowData.get(24)));
                experimentDiseaseSpectrumSaveReqVO.setHighHdl(parseBoolean(rowData.get(25)));
                experimentDiseaseSpectrumSaveReqVO.setHyperuricemia(parseBoolean(rowData.get(26)));
                experimentDiseaseSpectrumSaveReqVO.setHypercholesterolemia(parseBoolean(rowData.get(27)));
                experimentDiseaseSpectrumSaveReqVO.setDiabetes(parseBoolean(rowData.get(28)));
                experimentDiseaseSpectrumSaveReqVO.setThyroidDisease(parseBoolean(rowData.get(29)));
                experimentDiseaseSpectrumSaveReqVO.setLungNodule(parseBoolean(rowData.get(30)));
                experimentDiseaseSpectrumSaveReqVO.setPulmonaryEmphysema(parseBoolean(rowData.get(31)));
                experimentDiseaseSpectrumSaveReqVO.setCopd(parseBoolean(rowData.get(32)));
                experimentDiseaseSpectrumSaveReqVO.setAsthma(parseBoolean(rowData.get(33)));
                experimentDiseaseSpectrumSaveReqVO.setKidneyStone(parseBoolean(rowData.get(34)));
                experimentDiseaseSpectrumSaveReqVO.setRenalCyst(parseBoolean(rowData.get(35)));
                experimentDiseaseSpectrumSaveReqVO.setProstatitis(parseBoolean(rowData.get(36)));
                experimentDiseaseSpectrumSaveReqVO.setLumbarSpondylosis(parseBoolean(rowData.get(37)));
                experimentDiseaseSpectrumSaveReqVO.setCervicalSpondylosis(parseBoolean(rowData.get(38)));
                experimentDiseaseSpectrumSaveReqVO.setInsomnia(parseBoolean(rowData.get(39)));

                experimentDiseaseSpectrumService.createExperimentDiseaseSpectrum(experimentDiseaseSpectrumSaveReqVO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExcelControlDiseaseSpectrum")
    public String importExcelControlDiseaseSpectrum() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/04.1 对照组-疾病谱标记.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\04.1 对照组-疾病谱标记.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener6(
                        basicInfoService
                        , controlDiseaseSpectrumService))
                .sheet()
                .doRead();

        return "对照组疾病谱数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener6 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private ControlDiseaseSpectrumService controlDiseaseSpectrumService;

        // 构造函数注入服务
        public IndexListener6(
                BasicInfoService basicInfoService
                , ControlDiseaseSpectrumService controlDiseaseSpectrumService) {
            this.basicInfoService = basicInfoService;
            this.controlDiseaseSpectrumService = controlDiseaseSpectrumService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                ControlDiseaseSpectrumSaveReqVO controlDiseaseSpectrumSaveReqVO = new ControlDiseaseSpectrumSaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(0)); // 姓名
                basicInfoPageReqVO.setType(2); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(0)); // 姓名
                    basicInfo.setType(2); // 1：实验组，2：对照组
                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);
                }


                controlDiseaseSpectrumSaveReqVO.setPersonId(generatedId);
                controlDiseaseSpectrumSaveReqVO.setFattyLiver(parseBoolean(rowData.get(1)));
                controlDiseaseSpectrumSaveReqVO.setHepaticCyst(parseBoolean(rowData.get(2)));
                controlDiseaseSpectrumSaveReqVO.setGallbladderPolyp(parseBoolean(rowData.get(3)));
                controlDiseaseSpectrumSaveReqVO.setGallbladderStone(parseBoolean(rowData.get(4)));
                controlDiseaseSpectrumSaveReqVO.setHepaticHemangioma(parseBoolean(rowData.get(5)));
                controlDiseaseSpectrumSaveReqVO.setSplenomegaly(parseBoolean(rowData.get(6)));
                controlDiseaseSpectrumSaveReqVO.setChronicGastritis(parseBoolean(rowData.get(7)));
                controlDiseaseSpectrumSaveReqVO.setIntestinalPolyp(parseBoolean(rowData.get(8)));
                controlDiseaseSpectrumSaveReqVO.setAppendicitis(parseBoolean(rowData.get(9)));
                controlDiseaseSpectrumSaveReqVO.setAcutePancreatitis(parseBoolean(rowData.get(10)));
                controlDiseaseSpectrumSaveReqVO.setDigestiveUlcer(parseBoolean(rowData.get(11)));
                controlDiseaseSpectrumSaveReqVO.setDigestiveBleeding(parseBoolean(rowData.get(12)));
                controlDiseaseSpectrumSaveReqVO.setHypertension(parseBoolean(rowData.get(13)));
                controlDiseaseSpectrumSaveReqVO.setBradycardia(parseBoolean(rowData.get(14)));
                controlDiseaseSpectrumSaveReqVO.setTransientIschemicAttack(parseBoolean(rowData.get(15)));
                controlDiseaseSpectrumSaveReqVO.setTachycardia(parseBoolean(rowData.get(16)));
                controlDiseaseSpectrumSaveReqVO.setCerebralInfarction(parseBoolean(rowData.get(17)));
                controlDiseaseSpectrumSaveReqVO.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(18)));
                controlDiseaseSpectrumSaveReqVO.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(19)));
                controlDiseaseSpectrumSaveReqVO.setCoronaryHeartDisease(parseBoolean(rowData.get(20)));
                controlDiseaseSpectrumSaveReqVO.setAtrialFibrillation(parseBoolean(rowData.get(21)));
                controlDiseaseSpectrumSaveReqVO.setMyocardialInfarction(parseBoolean(rowData.get(22)));
                controlDiseaseSpectrumSaveReqVO.setHypertriglyceridemia(parseBoolean(rowData.get(23)));
                controlDiseaseSpectrumSaveReqVO.setHighLdl(parseBoolean(rowData.get(24)));
                controlDiseaseSpectrumSaveReqVO.setHighHdl(parseBoolean(rowData.get(25)));
                controlDiseaseSpectrumSaveReqVO.setHyperuricemia(parseBoolean(rowData.get(26)));
                controlDiseaseSpectrumSaveReqVO.setHypercholesterolemia(parseBoolean(rowData.get(27)));
                controlDiseaseSpectrumSaveReqVO.setDiabetes(parseBoolean(rowData.get(28)));
                controlDiseaseSpectrumSaveReqVO.setThyroidDisease(parseBoolean(rowData.get(29)));
                controlDiseaseSpectrumSaveReqVO.setLungNodule(parseBoolean(rowData.get(30)));
                controlDiseaseSpectrumSaveReqVO.setPulmonaryEmphysema(parseBoolean(rowData.get(31)));
                controlDiseaseSpectrumSaveReqVO.setCopd(parseBoolean(rowData.get(32)));
                controlDiseaseSpectrumSaveReqVO.setAsthma(parseBoolean(rowData.get(33)));
                controlDiseaseSpectrumSaveReqVO.setKidneyStone(parseBoolean(rowData.get(34)));
                controlDiseaseSpectrumSaveReqVO.setRenalCyst(parseBoolean(rowData.get(35)));
                controlDiseaseSpectrumSaveReqVO.setProstatitis(parseBoolean(rowData.get(36)));
                controlDiseaseSpectrumSaveReqVO.setLumbarSpondylosis(parseBoolean(rowData.get(37)));
                controlDiseaseSpectrumSaveReqVO.setCervicalSpondylosis(parseBoolean(rowData.get(38)));
                controlDiseaseSpectrumSaveReqVO.setInsomnia(parseBoolean(rowData.get(39)));

                controlDiseaseSpectrumService.createControlDiseaseSpectrum(controlDiseaseSpectrumSaveReqVO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExcelExperimentFramingham")
    public String importExcelExperimentFramingham() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/03.2 实验组-framingham评分.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\03.2 实验组-framingham评分.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener7(
                        basicInfoService
                        , experimentFraminghamService))
                .sheet()
                .doRead();

        return "实验组framingham评分数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener7 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private ExperimentFraminghamService experimentFraminghamService;

        // 构造函数注入服务
        public IndexListener7(
                BasicInfoService basicInfoService
                , ExperimentFraminghamService experimentFraminghamService) {
            this.basicInfoService = basicInfoService;
            this.experimentFraminghamService = experimentFraminghamService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                ExperimentFraminghamSaveReqVO experimentFraminghamSaveReqVO = new ExperimentFraminghamSaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(0)); // 姓名
                basicInfoPageReqVO.setType(1); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(0)); // 姓名
                    basicInfo.setType(1); // 1：实验组，2：对照组
                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);
                }

                experimentFraminghamSaveReqVO.setPersonId(generatedId);
                experimentFraminghamSaveReqVO.setFraminghamScore(parseInteger(rowData.get(1))); // Framingham评分
                experimentFraminghamSaveReqVO.setFraminghamRisk(parseBigDecimal(rowData.get(2))); // Framingham风险
                experimentFraminghamSaveReqVO.setFraminghamRiskType(rowData.get(3)); // Framingham风险类型


                experimentFraminghamService.createExperimentFramingham(experimentFraminghamSaveReqVO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    @GetMapping("/importExcelControlFramingham")
    public String importExcelControlFramingham() {
        // Excel文件路径，您可以根据需要动态传入路径
        String fileName = "/Users/jsheng/Downloads/回顾性数据/03.1 对照组-framingham评分.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\03.1 对照组-framingham评分.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListener8(
                        basicInfoService
                        , controlFraminghamService))
                .sheet()
                .doRead();

        return "对照组framingham评分数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListener8 extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private ControlFraminghamService controlFraminghamService;

        // 构造函数注入服务
        public IndexListener8(
                BasicInfoService basicInfoService
                , ControlFraminghamService controlFraminghamService) {
            this.basicInfoService = basicInfoService;
            this.controlFraminghamService = controlFraminghamService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            try {
                BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
                ControlFraminghamSaveReqVO controlFraminghamSaveReqVO = new ControlFraminghamSaveReqVO();

                Long generatedId = 0L;

                BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
                basicInfoPageReqVO.setName(rowData.get(0)); // 姓名
                basicInfoPageReqVO.setType(2); // 1：实验组，2：对照组
                List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
                if (basicInfoDOS.size() > 0) {
                    generatedId = basicInfoDOS.get(0).getId();
                } else {
                    basicInfo.setName(rowData.get(0)); // 姓名
                    basicInfo.setType(2); // 1：实验组，2：对照组
                    // 保存 BasicInfoRespVO 到数据库
                    generatedId = basicInfoService.createBasicInfo(basicInfo);
                }

                controlFraminghamSaveReqVO.setPersonId(generatedId);
                controlFraminghamSaveReqVO.setFraminghamScore(parseInteger(rowData.get(1))); // Framingham评分
                controlFraminghamSaveReqVO.setFraminghamRisk(parseBigDecimal(rowData.get(2))); // Framingham风险
                controlFraminghamSaveReqVO.setFraminghamRiskType(rowData.get(3)); // Framingham风险类型


                controlFraminghamService.createControlFramingham(controlFraminghamSaveReqVO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

    // 辅助方法：拼接年限字符串（如：1年3月）
    private String formatServiceTime(Integer years, Integer months) {
        if (years == null && months == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (years != null && years > 0) {
            sb.append(years).append("年");
        }
        if (months != null && months > 0) {
            sb.append(months).append("月");
        }
        return sb.length() > 0 ? sb.toString() : null;
    }

    // 辅助方法：移除末尾的逗号
    private String removeTrailingComma(StringBuilder builder) {
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }

    public ExperimentGroupExportVO convertToExperimentExportVO(BasicInfoRespVO source) {
        ExperimentGroupExportVO vo = new ExperimentGroupExportVO();
        vo.setName(source.getName());
        vo.setGender(source.getGender());
        vo.setHighestEducation(source.getHighestEducation());
        vo.setEthnicity(source.getEthnicity());
        vo.setHeight(source.getHeight());
        vo.setWeight(source.getWeight());

        if (source.getBasicOtherInfoRespVO() != null) {
            BasicOtherInfoRespVO otherInfo = source.getBasicOtherInfoRespVO();
            vo.setAge(otherInfo.getAge());
            vo.setFertilityStatus(otherInfo.getFertilityStatus());
            vo.setRetiredWeight(otherInfo.getRetiredWeight());
        }

        if (source.getExperimentSurveyServiceInfoRespVO() != null) {
            ExperimentSurveyServiceInfoRespVO serviceInfo = source.getExperimentSurveyServiceInfoRespVO();
            vo.setEnlistmentYear(serviceInfo.getEnlistmentYear());
            vo.setHighlandEntryYear(serviceInfo.getHighlandEntryYear());
            vo.setDischargeYear(serviceInfo.getDischargeYear());
            vo.setServiceDuration(serviceInfo.getDischargeYear() - serviceInfo.getHighlandEntryYear());
            vo.setServicePosition(serviceInfo.getServicePosition());

            // 应用信息
            vo.setHighlandServiceLocation(serviceInfo.getHighlandServiceLocation());
            vo.setAltitude(serviceInfo.getAltitude());
            vo.setServiceTime(formatServiceTime(null, serviceInfo.getMonth()));

            // 地点1-6
            vo.setHighlandServiceLocation1(serviceInfo.getHighlandServiceLocation1());
            vo.setAltitude1(serviceInfo.getAltitude1());
            vo.setServiceTime1(formatServiceTime(serviceInfo.getYear1(), serviceInfo.getMonth1()));

            vo.setHighlandServiceLocation2(serviceInfo.getHighlandServiceLocation2());
            vo.setAltitude2(serviceInfo.getAltitude2());
            vo.setServiceTime2(formatServiceTime(serviceInfo.getYear2(), serviceInfo.getMonth2()));

            vo.setHighlandServiceLocation3(serviceInfo.getHighlandServiceLocation3());
            vo.setAltitude3(serviceInfo.getAltitude3());
            vo.setServiceTime3(formatServiceTime(serviceInfo.getYear3(), serviceInfo.getMonth3()));

            vo.setHighlandServiceLocation4(serviceInfo.getHighlandServiceLocation4());
            vo.setAltitude4(serviceInfo.getAltitude4());
            vo.setServiceTime4(formatServiceTime(serviceInfo.getYear4(), serviceInfo.getMonth4()));

            vo.setHighlandServiceLocation5(serviceInfo.getHighlandServiceLocation5());
            vo.setAltitude5(serviceInfo.getAltitude5());
            vo.setServiceTime5(formatServiceTime(serviceInfo.getYear5(), serviceInfo.getMonth5()));

            vo.setHighlandServiceLocation6(serviceInfo.getHighlandServiceLocation6());
            vo.setAltitude6(serviceInfo.getAltitude6());
            vo.setServiceTime6(formatServiceTime(serviceInfo.getYear6(), serviceInfo.getMonth6()));

            // 高原反应信息
            vo.setHighlandTaskType(serviceInfo.getHighlandTaskType());
        }

        if (source.getExperimentSurveyPostReturnSymptomsRespVO() != null) {
            ExperimentSurveyPostReturnSymptomsRespVO symptoms = source.getExperimentSurveyPostReturnSymptomsRespVO();

            // ========== 精神及全身症状 ==========
            vo.setFatigue(symptoms.getFatigue());
            vo.setDrowsiness(symptoms.getDrowsiness());
            vo.setDizziness(symptoms.getDizziness());
            vo.setVertigo(symptoms.getVertigo());
            vo.setPoorConcentration(symptoms.getPoorConcentration());
            vo.setSlowReaction(symptoms.getSlowReaction());
            vo.setMemoryLoss(symptoms.getMemoryLoss());
            vo.setInsomnia(symptoms.getInsomnia());
            vo.setNightmares(symptoms.getNightmares());

            // ========== 循环症状 ==========
            vo.setChestPain(symptoms.getChestPain());
            vo.setPalpitations(symptoms.getPalpitations());
            vo.setBradycardia(symptoms.getBradycardia());
            vo.setCyanosis(symptoms.getCyanosis());
            vo.setBloodPressureFluctuation(symptoms.getBloodPressureFluctuation());
            vo.setSkinBleeding(symptoms.getSkinBleeding());
            vo.setSkinBruising(symptoms.getSkinBruising());
            vo.setAnemia(symptoms.getAnemia());

            // ========== 呼吸症状 ==========
            vo.setSoreThroat(symptoms.getSoreThroat());
            vo.setCough(symptoms.getCough());
            vo.setPhlegm(symptoms.getPhlegm());
            vo.setWheezing(symptoms.getWheezing());
            vo.setChestTightness(symptoms.getChestTightness());

            // ========== 消化症状 ==========
            vo.setWeightLoss(symptoms.getWeightLoss());
            vo.setIncreasedAppetite(symptoms.getIncreasedAppetite());
            vo.setAnorexia(symptoms.getAnorexia());
            vo.setConstipation(symptoms.getConstipation());
            vo.setDiarrhea(symptoms.getDiarrhea());
            vo.setAbdominalPain(symptoms.getAbdominalPain());
            vo.setJaundice(symptoms.getJaundice());

            // ========== 其他症状 ==========
            vo.setNumbness(symptoms.getNumbness());
            vo.setLimbEdema(symptoms.getLimbEdema());
            vo.setFacialEdema(symptoms.getFacialEdema());
            vo.setHairLoss(symptoms.getHairLoss());
            vo.setIncreasedUrination(symptoms.getIncreasedUrination());
        }

        if (source.getExperimentSurveySmokingRespVO() != null) {
            ExperimentSurveySmokingRespVO smokingInfo = source.getExperimentSurveySmokingRespVO();
            // 吸烟情况
            vo.setSmokingStatus(smokingInfo.getSmokingStatus());
            vo.setDailySmoking(smokingInfo.getDailySmoking());
            vo.setSmokingStartAge(smokingInfo.getSmokingStartAge());
            vo.setSmokingYears(smokingInfo.getSmokingYears());
            vo.setTriedQuit(smokingInfo.getTriedQuit());
            vo.setHighlandPlainSmokingStatus(smokingInfo.getHighlandPlainSmokingStatus());

            // 已戒烟情况
            vo.setSmokingYears2(smokingInfo.getSmokingYears2());
            vo.setQuitTime(smokingInfo.getQuitTime());
            vo.setHighlandPlainSmokingStatus2(smokingInfo.getHighlandPlainSmokingStatus2());
        }

        if (source.getExperimentSurveyDrinkingRespVO() != null) {
            ExperimentSurveyDrinkingRespVO drinking = source.getExperimentSurveyDrinkingRespVO();
            vo.setDrinkingExperience(drinking.getDrinkingExperience());
            vo.setStillDrinking(drinking.getStillDrinking());
            vo.setDrinkingFrequency(drinking.getDrinkingFrequency());

            // 拼接 drinkType
            List<String> drinkTypes = new ArrayList<>();
            if (Boolean.TRUE.equals(drinking.getBeer())) drinkTypes.add("啤酒");
            if (Boolean.TRUE.equals(drinking.getLiquor())) drinkTypes.add("白酒");
            if (Boolean.TRUE.equals(drinking.getRedWine())) drinkTypes.add("红酒");
            if (Boolean.TRUE.equals(drinking.getCocktails())) drinkTypes.add("鸡尾酒");
            if (Boolean.TRUE.equals(drinking.getSpirits())) drinkTypes.add("烈酒");
            if (Boolean.TRUE.equals(drinking.getOtherAlcohol())) drinkTypes.add("其他");

            vo.setDrinkType(String.join(",", drinkTypes)); // 用逗号拼接

            vo.setOverDrinking(drinking.getOverDrinking());
        }

        if (source.getExperimentSurveySelfAssessmentRespVO() != null){
            ExperimentSurveySelfAssessmentRespVO selfAssessment = source.getExperimentSurveySelfAssessmentRespVO();
            vo.setHealthComparisonWithPeers(selfAssessment.getHealthComparisonWithPeers());
            vo.setHealthScore(selfAssessment.getHealthScore());
        }

        if (source.getExperimentSurveyFamilyDiseasesRespVO() != null) {
            ExperimentSurveyFamilyDiseasesRespVO familyDiseases = source.getExperimentSurveyFamilyDiseasesRespVO();
            // 1. 心血管循环系统疾病拼接
            List<String> cardiovascularDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getHypertension())) cardiovascularDiseases.add("高血压");
            if (Boolean.TRUE.equals(familyDiseases.getHyperlipidemia())) cardiovascularDiseases.add("高血脂");
            if (Boolean.TRUE.equals(familyDiseases.getCongenitalHeartDisease())) cardiovascularDiseases.add("先天性心脏病");
            if (Boolean.TRUE.equals(familyDiseases.getPulmonaryHeartDisease())) cardiovascularDiseases.add("肺心病");
            if (Boolean.TRUE.equals(familyDiseases.getStroke())) cardiovascularDiseases.add("中风/脑溢血");
            if (Boolean.TRUE.equals(familyDiseases.getCoronaryHeartDisease())) cardiovascularDiseases.add("冠心病/心绞痛");
            if (Boolean.TRUE.equals(familyDiseases.getMyocardialInfarction())) cardiovascularDiseases.add("心肌梗塞");
            if (Boolean.TRUE.equals(familyDiseases.getBradycardia())) cardiovascularDiseases.add("窦性心动过缓");
            if (Boolean.TRUE.equals(familyDiseases.getTachycardia())) cardiovascularDiseases.add("窦性心动过速");
            if (Boolean.TRUE.equals(familyDiseases.getArrhythmia())) cardiovascularDiseases.add("窦性心律不齐");
            if (Boolean.TRUE.equals(familyDiseases.getAtrialFibrillation())) cardiovascularDiseases.add("房颤");
            if (Boolean.TRUE.equals(familyDiseases.getParoxysmalAuricularTachycardia())) cardiovascularDiseases.add("阵发性室上速");
            if (Boolean.TRUE.equals(familyDiseases.getFrequentPrematureAtrialContractions())) cardiovascularDiseases.add("频发房性早搏");
            if (Boolean.TRUE.equals(familyDiseases.getFrequentPrematureVentricularContractions())) cardiovascularDiseases.add("频发室性早搏");
            if (Boolean.TRUE.equals(familyDiseases.getAvBlock())) cardiovascularDiseases.add("房室传导阻滞");
            if (Boolean.TRUE.equals(familyDiseases.getVentricularTachycardia())) cardiovascularDiseases.add("室性心动过速");
            if (Boolean.TRUE.equals(familyDiseases.getOtherDiseases1())) cardiovascularDiseases.add("其他");
            vo.setCardiovascularCirculatorySystem(String.join(",", cardiovascularDiseases));
            //2. 呼吸系统疾病拼接
            List<String> respiratoryDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getChronicBronchitis())) respiratoryDiseases.add("慢性支气管炎");
            if (Boolean.TRUE.equals(familyDiseases.getAsthma())) respiratoryDiseases.add("哮喘");
            if (Boolean.TRUE.equals(familyDiseases.getTuberculosis())) respiratoryDiseases.add("肺结核");
            if (Boolean.TRUE.equals(familyDiseases.getEmphysema())) respiratoryDiseases.add("肺气肿");
            if (Boolean.TRUE.equals(familyDiseases.getPneumonia())) respiratoryDiseases.add("肺炎");
            if (Boolean.TRUE.equals(familyDiseases.getCopd())) respiratoryDiseases.add("慢性阻塞性肺疾病");
            if (Boolean.TRUE.equals(familyDiseases.getOtherDiseases2())) respiratoryDiseases.add("其他");
            vo.setRespiratorySystem(String.join(",", respiratoryDiseases));
            //3. 代谢系统疾病拼接
            List<String> metabolicDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getThyroidDisease())) metabolicDiseases.add("甲状腺疾病");
            if (Boolean.TRUE.equals(familyDiseases.getDiabetes())) metabolicDiseases.add("糖尿病");
            if (Boolean.TRUE.equals(familyDiseases.getGout())) metabolicDiseases.add("高尿酸血症（痛风）");
            vo.setMetabolicSystem(String.join(",", metabolicDiseases));
            //4. 消化系统疾病拼接
            List<String> digestiveDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getChronicGastroenteritis())) digestiveDiseases.add("慢性肠胃炎");
            if (Boolean.TRUE.equals(familyDiseases.getDuodenalUlcer())) digestiveDiseases.add("十二指肠溃疡");
            if (Boolean.TRUE.equals(familyDiseases.getGastricUlcer())) digestiveDiseases.add("胃溃疡");
            if (Boolean.TRUE.equals(familyDiseases.getGallstones())) digestiveDiseases.add("胆结石");
            if (Boolean.TRUE.equals(familyDiseases.getColonPolyps())) digestiveDiseases.add("结肠息肉");
            if (Boolean.TRUE.equals(familyDiseases.getHepatitisB())) digestiveDiseases.add("乙型肝炎");
            if (Boolean.TRUE.equals(familyDiseases.getCholecystitis())) digestiveDiseases.add("胆囊炎");
            if (Boolean.TRUE.equals(familyDiseases.getOtherDiseases3())) digestiveDiseases.add("其他");
            vo.setDigestiveSystem(String.join(",", digestiveDiseases));
            //5. 神经系统疾病拼接
            List<String> nervousDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getDementia())) nervousDiseases.add("老年痴呆");
            if (Boolean.TRUE.equals(familyDiseases.getParkinsonsDisease())) nervousDiseases.add("帕金森综合征");
            if (Boolean.TRUE.equals(familyDiseases.getMultipleSclerosis())) nervousDiseases.add("多发性硬化病");
            if (Boolean.TRUE.equals(familyDiseases.getEpilepsy())) nervousDiseases.add("癫痫");
            vo.setNervousSystem(String.join(",", nervousDiseases));
            //6. 癌症疾病拼接
            List<String> cancerDiseases = new ArrayList<>();
            if (Boolean.TRUE.equals(familyDiseases.getLungCancer())) cancerDiseases.add("肺癌");
            if (Boolean.TRUE.equals(familyDiseases.getLiverCancer())) cancerDiseases.add("肝癌");
            if (Boolean.TRUE.equals(familyDiseases.getGastricCancer())) cancerDiseases.add("胃癌");
            if (Boolean.TRUE.equals(familyDiseases.getColonCancer())) cancerDiseases.add("直/结肠癌");
            if (Boolean.TRUE.equals(familyDiseases.getPancreaticCancer())) cancerDiseases.add("胰腺癌");
            if (Boolean.TRUE.equals(familyDiseases.getEsophagealCancer())) cancerDiseases.add("食管癌");
            if (Boolean.TRUE.equals(familyDiseases.getProstateCancer())) cancerDiseases.add("前列腺癌");
            if (Boolean.TRUE.equals(familyDiseases.getBreastCancer())) cancerDiseases.add("乳腺癌");
            if (Boolean.TRUE.equals(familyDiseases.getCervicalCancer())) cancerDiseases.add("宫颈癌");
            if (Boolean.TRUE.equals(familyDiseases.getOtherDiseases4())) cancerDiseases.add("其他");
            vo.setCancer(String.join(",", cancerDiseases));
        }

        if (source.getExperimentSurveyHighlandDiseasesRespVO() != null) {
            ExperimentSurveyHighlandDiseasesRespVO highlandDiseases = source.getExperimentSurveyHighlandDiseasesRespVO();
            // 高原疾病名称拼接
            List<String> diseaseNames = new ArrayList<>();
            if (Boolean.TRUE.equals(highlandDiseases.getAcuteHighlandReaction())) {
                diseaseNames.add("急性高原反应");
            }
            if (Boolean.TRUE.equals(highlandDiseases.getHighlandPulmonaryEdema())) {
                diseaseNames.add("高原肺水肿");
            }
            if (Boolean.TRUE.equals(highlandDiseases.getHighlandCerebralEdema())) {
                diseaseNames.add("高原脑水肿");
            }
            if (Boolean.TRUE.equals(highlandDiseases.getHighlandHeartDisease())) {
                diseaseNames.add("高原心脏病");
            }
            if (Boolean.TRUE.equals(highlandDiseases.getHighlandPolycythemia())) {
                diseaseNames.add("高原红细胞增多症");
            }
            if (Boolean.TRUE.equals(highlandDiseases.getOtherDiseases())) {
                diseaseNames.add("其他");
            }
            vo.setHighlandDiseases(String.join(",", diseaseNames));
        }

        if (source.getExperimentSurveyHighlandReactionRespVO() != null) {
            ExperimentSurveyHighlandReactionRespVO highlandReaction = source.getExperimentSurveyHighlandReactionRespVO();
            vo.setReactionOccurred(highlandReaction.getReactionOccurred());
            vo.setReactionCountText(highlandReaction.getReactionCountText());
            vo.setMultipleReactionsChanges(highlandReaction.getMultipleReactionsChanges());
        }

        if (source.getExperimentSurveyHighlandReactionSymptomsRespVO() != null) {
            ExperimentSurveyHighlandReactionSymptomsRespVO highlandReactionSymptoms = source.getExperimentSurveyHighlandReactionSymptomsRespVO();
            // 在转换逻辑中添加症状拼接
            List<String> symptomNames = new ArrayList<>();

            if (Boolean.TRUE.equals(highlandReactionSymptoms.getHeadache())) symptomNames.add("头痛");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getVomiting())) symptomNames.add("呕吐");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getDizziness())) symptomNames.add("头昏");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getNausea())) symptomNames.add("恶心");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getPalpitations())) symptomNames.add("心慌");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getPoorAppetite())) symptomNames.add("食欲不振");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getChestTightness())) symptomNames.add("胸闷");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getBlurredVision())) symptomNames.add("眼花");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getShortnessOfBreath())) symptomNames.add("气短");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getAbdominalBloating())) symptomNames.add("腹胀");
            if (Boolean.TRUE.equals(highlandReactionSymptoms.getDiarrhea())) symptomNames.add("腹泻");

            vo.setHighlandReactionSymptoms(symptomNames.isEmpty() ? null : String.join(",", symptomNames));
        }

        if (source.getExperimentSurveyPostReturnInfoRespVO() != null) {
            ExperimentSurveyPostReturnInfoRespVO postReturnInfo = source.getExperimentSurveyPostReturnInfoRespVO();
            vo.setPostReturnWorkStatus(postReturnInfo.getPostReturnWorkStatus());
            vo.setAnnualCheckups(postReturnInfo.getAnnualCheckups());
        }

        if (source.getExperimentSurveyPostReturnInfoRespVO() != null) {
            ExperimentSurveyPostReturnInfoRespVO postReturnInfo = source.getExperimentSurveyPostReturnInfoRespVO();
            // 初始化拼接字符串
            StringBuilder areaBuilder = new StringBuilder();
            StringBuilder timeBuilder = new StringBuilder();
            //处理成都信息
            if (Boolean.TRUE.equals(postReturnInfo.getChengdu() != null && postReturnInfo.getChengdu() == 1)) {
                areaBuilder.append("成都");
                if (postReturnInfo.getChengduResidenceTime() != null) {
                    timeBuilder.append("成都").append(postReturnInfo.getChengduResidenceTime()).append("年");
                }
            }
            //处理昆明信息
            if (Boolean.TRUE.equals(postReturnInfo.getKunming() != null && postReturnInfo.getKunming() == 1)) {
                if (areaBuilder.length() > 0) areaBuilder.append("、");
                areaBuilder.append("昆明");

                if (timeBuilder.length() > 0) timeBuilder.append("、");
                if (postReturnInfo.getKunmingResidenceTime() != null) {
                    timeBuilder.append("昆明").append(postReturnInfo.getKunmingResidenceTime()).append("年");
                }
            }
            //处理西宁信息
            if (Boolean.TRUE.equals(postReturnInfo.getXining() != null && postReturnInfo.getXining() == 1)) {
                if (areaBuilder.length() > 0) areaBuilder.append("、");
                areaBuilder.append("西宁");

                if (timeBuilder.length() > 0) timeBuilder.append("、");
                if (postReturnInfo.getXiningResidenceTime() != null) {
                    timeBuilder.append("西宁").append(postReturnInfo.getXiningResidenceTime()).append("年");
                }
            }
            //处理其他地区信息
            if (StringUtils.isNotBlank(postReturnInfo.getOtherArea())) {
                if (areaBuilder.length() > 0) areaBuilder.append("、");
                areaBuilder.append(postReturnInfo.getOtherArea());

                if (timeBuilder.length() > 0) timeBuilder.append("、");
                if (StringUtils.isNotBlank(postReturnInfo.getOtherAreaResidenceTime())) {
                    timeBuilder.append(postReturnInfo.getOtherArea()).append(postReturnInfo.getOtherAreaResidenceTime()).append("年");
                }
            }
            //设置最终值
            vo.setResidenceArea(areaBuilder.length() > 0 ? areaBuilder.toString() : null);
            vo.setResidenceTime(timeBuilder.length() > 0 ? timeBuilder.toString() : null);
        }

        if (source.getExperimentSurveyHighlandDiseasesDuringServiceRespVO() != null) {
            ExperimentSurveyHighlandDiseasesDuringServiceRespVO highlandDiseasesDuringService = source.getExperimentSurveyHighlandDiseasesDuringServiceRespVO();
            //创建疾病名称列表
            List<String> diseaseNames = new ArrayList<>();
            //心血管疾病类
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getHypertension())) diseaseNames.add("高血压");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getMyocardialInfarction())) diseaseNames.add("心肌梗死");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getCoronaryHeartDisease())) diseaseNames.add("冠心病");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getPulmonaryHeartDisease())) diseaseNames.add("肺心病");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getLowerExtremityVenousThrombosis())) diseaseNames.add("四肢静脉血栓");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getBradycardia())) diseaseNames.add("窦性心动过缓");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getTachycardia())) diseaseNames.add("窦性心动过速");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getArrhythmia())) diseaseNames.add("窦性心律不齐");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getAtrialFibrillation())) diseaseNames.add("房颤");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getParoxysmalAuricularTachycardia())) diseaseNames.add("阵发性室上速");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getFrequentPrematureAtrialContractions())) diseaseNames.add("频发房性早搏");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getFrequentPrematureVentricularContractions())) diseaseNames.add("频发室性早搏");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getAvBlock())) diseaseNames.add("房室传导阻滞");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getVentricularTachycardia())) diseaseNames.add("室性心动过速");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getOtherDiseases1())) diseaseNames.add("其他心血管疾病");
            //脑血管疾病类
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getDizziness())) diseaseNames.add("眩晕");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getTransientIschemicAttack())) diseaseNames.add("短暂性脑缺血");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getCerebralInfarction())) diseaseNames.add("脑梗死/脑血栓");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getCerebralHemorrhage())) diseaseNames.add("脑出血");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getOtherDiseases2())) diseaseNames.add("其他脑血管疾病");
            //代谢性疾病类
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getHyperlipidemia())) diseaseNames.add("高血脂");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getDiabetes())) diseaseNames.add("糖尿病");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getGout())) diseaseNames.add("高尿酸血症(痛风)");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getThyroidDisease())) diseaseNames.add("甲状腺疾病");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getOtherDiseases3())) diseaseNames.add("其他代谢疾病");
            //其他疾病类
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getInsomnia())) diseaseNames.add("失眠");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getTumor())) diseaseNames.add("肿瘤");
            if (Boolean.TRUE.equals(highlandDiseasesDuringService.getOtherDiseases4())) diseaseNames.add("其他疾病");
            //拼接疾病名称字符串
            String diseases = diseaseNames.isEmpty() ? null : String.join("、", diseaseNames);
            //设置到VO对象
            vo.setHighlandDiseasesDuringService(diseases);
        }

        if (source.getExperimentSurveyNewDiseasesPostReturnRespVO() != null) {
            ExperimentSurveyNewDiseasesPostReturnRespVO newDiseasesPostReturn = source.getExperimentSurveyNewDiseasesPostReturnRespVO();

            // 创建疾病名称列表
            List<String> newDiseaseNames = new ArrayList<>();
            //心血管疾病类
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getHypertension())) newDiseaseNames.add("高血压");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getMyocardialInfarction())) newDiseaseNames.add("心肌梗死");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getCoronaryHeartDisease())) newDiseaseNames.add("冠心病");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getPulmonaryHeartDisease())) newDiseaseNames.add("肺心病");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getLowerExtremityVenousThrombosis())) newDiseaseNames.add("四肢静脉血栓");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getBradycardia())) newDiseaseNames.add("窦性心动过缓");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getTachycardia())) newDiseaseNames.add("窦性心动过速");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getArrhythmia())) newDiseaseNames.add("窦性心律不齐");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getAtrialFibrillation())) newDiseaseNames.add("房颤");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getParoxysmalAuricularTachycardia())) newDiseaseNames.add("阵发性室上速");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getFrequentPrematureAtrialContractions())) newDiseaseNames.add("频发房性早搏");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getFrequentPrematureVentricularContractions())) newDiseaseNames.add("频发室性早搏");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getAvBlock())) newDiseaseNames.add("房室传导阻滞");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getVentricularTachycardia())) newDiseaseNames.add("室性心动过速");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getOtherDiseases1())) newDiseaseNames.add("其他心血管疾病");
            //脑血管疾病类
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getDizziness())) newDiseaseNames.add("眩晕");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getTransientIschemicAttack())) newDiseaseNames.add("短暂性脑缺血");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getCerebralInfarction())) newDiseaseNames.add("脑梗死/脑血栓");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getCerebralHemorrhage())) newDiseaseNames.add("脑出血");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getOtherDiseases2())) newDiseaseNames.add("其他脑血管疾病");
            //代谢性疾病类
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getHyperlipidemia())) newDiseaseNames.add("高血脂");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getDiabetes())) newDiseaseNames.add("糖尿病");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getGout())) newDiseaseNames.add("高尿酸血症(痛风)");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getThyroidDisease())) newDiseaseNames.add("甲状腺疾病");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getOtherDiseases3())) newDiseaseNames.add("其他代谢疾病");
            //其他疾病类
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getInsomnia())) newDiseaseNames.add("失眠");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getTumor())) newDiseaseNames.add("肿瘤");
            if (Boolean.TRUE.equals(newDiseasesPostReturn.getOtherDiseases4())) newDiseaseNames.add("其他疾病");
            //拼接疾病名称字符串
            String newDiseases = newDiseaseNames.isEmpty() ? null : String.join("、", newDiseaseNames);
            //设置到VO对象
            vo.setNewDiseasesPostReturn(newDiseases);
        }

        if (source.getExperimentSurveyNewDiseasesRespVO() != null) {
            ExperimentSurveyNewDiseasesRespVO newDiseases = source.getExperimentSurveyNewDiseasesRespVO();
                // 处理新发疾病
                vo.setNewDisease1Name(newDiseases.getNewDisease1Name());
                vo.setDiagnosed(newDiseases.getDiagnosed());
                vo.setDiagnosisDate(newDiseases.getDiagnosisDate());
                vo.setHospitalized(newDiseases.getHospitalized());
                vo.setMedication(newDiseases.getMedication());
                vo.setMedicationEffect(newDiseases.getMedicationEffect());

                // 处理新发疾病2
                vo.setNewDisease2Name(newDiseases.getNewDisease2Name());
                vo.setDiagnosed2(newDiseases.getDiagnosed2());
                vo.setDiagnosisDate2(newDiseases.getDiagnosisDate2());
                vo.setHospitalized2(newDiseases.getHospitalized2());
                vo.setMedication2(newDiseases.getMedication2());
                vo.setMedicationEffect2(newDiseases.getMedicationEffect2());

                // 处理新发疾病3
                vo.setNewDisease3Name(newDiseases.getNewDisease3Name());
                vo.setDiagnosed3(newDiseases.getDiagnosed3());
                vo.setDiagnosisDate3(newDiseases.getDiagnosisDate3());
                vo.setHospitalized3(newDiseases.getHospitalized3());
                vo.setMedication3(newDiseases.getMedication3());
                vo.setMedicationEffect3(newDiseases.getMedicationEffect3());

                // 处理新发疾病4
                vo.setNewDisease4Name(newDiseases.getNewDisease4Name());
                vo.setDiagnosed4(newDiseases.getDiagnosed4());
                vo.setDiagnosisDate4(newDiseases.getDiagnosisDate4());
                vo.setHospitalized4(newDiseases.getHospitalized4());
                vo.setMedication4(newDiseases.getMedication4());
                vo.setMedicationEffect4(newDiseases.getMedicationEffect4());
        }

        if (source.getExperimentSurveyExerciseRespVO() != null) {
            ExperimentSurveyExerciseRespVO exercise = source.getExperimentSurveyExerciseRespVO();
            vo.setRegularExercise(exercise.getRegularExercise());
            vo.setExerciseFrequency(exercise.getExerciseFrequency());
            vo.setExerciseDuration(exercise.getExerciseDuration());
            vo.setExerciseType(exercise.getExerciseType());
            vo.setChestPainOrShortness(exercise.getChestPainOrShortness());
            vo.setDoctorGuidedExercise(exercise.getDoctorGuidedExercise());
        }

        if(source.getExperimentSurveyDietRespVO() != null){
            ExperimentSurveyDietRespVO diet = source.getExperimentSurveyDietRespVO();
            vo.setEatingHabits(diet.getEatingHabits());
            // Build dietType by checking each field
            StringBuilder dietTypeBuilder = new StringBuilder();

            if(!"0".equals(diet.getDrinkingWater())) {
                dietTypeBuilder.append("饮用水").append(",");
            }
            if(!"0".equals(diet.getTea())) {
                dietTypeBuilder.append("茶水").append(",");
            }
            if(!"0".equals(diet.getFruitJuice())) {
                dietTypeBuilder.append("果汁").append(",");
            }
            if(!"0".equals(diet.getCarbonatedDrinks())) {
                dietTypeBuilder.append("碳酸饮料").append(",");
            }
            if(!"0".equals(diet.getCoffee())) {
                dietTypeBuilder.append("咖啡").append(",");
            }
            if(!"0".equals(diet.getMilk())) {
                dietTypeBuilder.append("牛奶").append(",");
            }

            // Remove the trailing comma if exists
            if(dietTypeBuilder.length() > 0) {
                dietTypeBuilder.setLength(dietTypeBuilder.length() - 1);
            }

            vo.setDietType(dietTypeBuilder.toString());
        }

        if(source.getExperimentSurveySleepRespVO() != null){
            ExperimentSurveySleepRespVO sleep = source.getExperimentSurveySleepRespVO();
            vo.setSleepTimeStart(sleep.getSleepTimeStart());
            vo.setSleepOnsetTime(sleep.getSleepOnsetTime());
            vo.setWakeTime(sleep.getWakeTime());
            vo.setActualSleepDuration(sleep.getActualSleepDuration());
            StringBuilder reasonsBuilder = new StringBuilder();

            // Check each sleep-related field
            if (!"0".equals(sleep.getSleepDifficulties())) {
                reasonsBuilder.append("入睡困难").append(",");
            }
            if (!"0".equals(sleep.getNightAwakening())) {
                reasonsBuilder.append("夜间易醒或早醒").append(",");
            }
            if (!"0".equals(sleep.getNightUrination())) {
                reasonsBuilder.append("夜间去厕所").append(",");
            }
            if (!"0".equals(sleep.getBreathingDifficulties())) {
                reasonsBuilder.append("呼吸不畅").append(",");
            }
            if (!"0".equals(sleep.getCoughOrSnore())) {
                reasonsBuilder.append("咳嗽或鼾声高").append(",");
            }
            if (!"0".equals(sleep.getFeelingCold())) {
                reasonsBuilder.append("感觉冷").append(",");
            }
            if (!"0".equals(sleep.getFeelingHot())) {
                reasonsBuilder.append("感觉热").append(",");
            }
            if (!"0".equals(sleep.getNightmares())) {
                reasonsBuilder.append("做恶梦").append(",");
            }
            if (!"0".equals(sleep.getPainOrDiscomfort())) {
                reasonsBuilder.append("疼痛不适").append(",");
            }
            if (!"0".equals(sleep.getOtherSleepIssues())) {
                reasonsBuilder.append("其他影响睡眠的事情").append(",");
            }
            if (!"0".equals(sleep.getSleepAids())) {
                reasonsBuilder.append("催眠药").append(",");
            }

            // Remove the trailing comma if exists
            if (reasonsBuilder.length() > 0) {
                reasonsBuilder.setLength(reasonsBuilder.length() - 1);
            }

            vo.setReasonsAffectingSleep(reasonsBuilder.toString());
            vo.setSleepAids(sleep.getSleepAids());
            vo.setSleepFatigue(sleep.getFatigue());
            vo.setLackOfEnergy(sleep.getLackOfEnergy());
            vo.setSelfAssessmentSleep(sleep.getSelfAssessmentSleep());
        }

        if(source.getExperimentDiseaseSpectrumRespVO() != null){
            ExperimentDiseaseSpectrumRespVO diseaseSpectrum = source.getExperimentDiseaseSpectrumRespVO();
            // 消化系统疾病拼接
            StringBuilder digestiveBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getFattyLiver())) digestiveBuilder.append("脂肪肝").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHepaticCyst())) digestiveBuilder.append("肝囊肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getGallbladderPolyp())) digestiveBuilder.append("胆囊息肉").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getGallbladderStone())) digestiveBuilder.append("胆囊结石").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHepaticHemangioma())) digestiveBuilder.append("肝血管瘤").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getSplenomegaly())) digestiveBuilder.append("脾大").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getChronicGastritis())) digestiveBuilder.append("慢性胃炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getIntestinalPolyp())) digestiveBuilder.append("肠息肉").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAppendicitis())) digestiveBuilder.append("阑尾炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAcutePancreatitis())) digestiveBuilder.append("急性胰腺炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDigestiveUlcer())) digestiveBuilder.append("消化道溃疡").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDigestiveBleeding())) digestiveBuilder.append("消化道出血").append(",");
            vo.setDiseaseSpectrumDigestiveSystem(removeTrailingComma(digestiveBuilder));
            //心血管系统疾病拼接
            StringBuilder cardiovascularBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypertension())) cardiovascularBuilder.append("高血压").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getBradycardia())) cardiovascularBuilder.append("窦性心动过缓").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getTransientIschemicAttack())) cardiovascularBuilder.append("短暂性脑缺血").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getTachycardia())) cardiovascularBuilder.append("窦性心动过速").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCerebralInfarction())) cardiovascularBuilder.append("脑梗死/脑血栓").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getFrequentPrematureAtrialContractions())) cardiovascularBuilder.append("频发房性早搏").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getFrequentPrematureVentricularContractions())) cardiovascularBuilder.append("频发室性早搏").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCoronaryHeartDisease())) cardiovascularBuilder.append("冠心病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAtrialFibrillation())) cardiovascularBuilder.append("房颤").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getMyocardialInfarction())) cardiovascularBuilder.append("心肌梗死").append(",");
            vo.setDiseaseSpectrumCardiovascularSystem(removeTrailingComma(cardiovascularBuilder));
            //内分泌系统疾病拼接
            StringBuilder endocrineBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypertriglyceridemia())) endocrineBuilder.append("高甘油三酯血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHighLdl())) endocrineBuilder.append("低密度脂蛋白胆固醇增多症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHighHdl())) endocrineBuilder.append("高密度脂蛋白胆固醇增多症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHyperuricemia())) endocrineBuilder.append("高尿酸血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypercholesterolemia())) endocrineBuilder.append("高胆固醇血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDiabetes())) endocrineBuilder.append("糖尿病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getThyroidDisease())) endocrineBuilder.append("甲状腺疾病").append(",");
            vo.setDiseaseSpectrumEndocrineSystem(removeTrailingComma(endocrineBuilder));
            //呼吸系统疾病拼接
            StringBuilder respiratoryBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getLungNodule())) respiratoryBuilder.append("肺结节").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getPulmonaryEmphysema())) respiratoryBuilder.append("肺气肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCopd())) respiratoryBuilder.append("慢阻肺").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAsthma())) respiratoryBuilder.append("哮喘").append(",");
            vo.setDiseaseSpectrumRespiratorySystem(removeTrailingComma(respiratoryBuilder));
            //泌尿系统疾病拼接
            StringBuilder urinaryBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getKidneyStone())) urinaryBuilder.append("肾结石").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getRenalCyst())) urinaryBuilder.append("肾囊肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getProstatitis())) urinaryBuilder.append("前列腺炎").append(",");
            vo.setDiseaseSpectrumUrinarySystem(removeTrailingComma(urinaryBuilder));
            //骨骼系统疾病拼接
            StringBuilder skeletalBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getLumbarSpondylosis())) skeletalBuilder.append("腰椎病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCervicalSpondylosis())) skeletalBuilder.append("颈椎病").append(",");
            vo.setDiseaseSpectrumSkeletalSystem(removeTrailingComma(skeletalBuilder));
            //神经系统疾病拼接
            StringBuilder nervousBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getInsomnia())) nervousBuilder.append("失眠").append(",");
            vo.setDiseaseSpectrumNervousSystem(removeTrailingComma(nervousBuilder));
        }

        if(source.getExperimentFraminghamRespVO() != null){
            ExperimentFraminghamRespVO framingham = source.getExperimentFraminghamRespVO();
            vo.setFraminghamScore(framingham.getFraminghamScore());
            vo.setFraminghamRisk(framingham.getFraminghamRisk());
            vo.setFraminghamRiskType(framingham.getFraminghamRiskType());
        }

        // 服役信息（通过ExperimentSurveyServiceInfoRespVO）
        if (source.getExperimentSurveyServiceInfoRespVO() != null) {
            ExperimentSurveyServiceInfoRespVO serviceInfo = source.getExperimentSurveyServiceInfoRespVO();
            vo.setEnlistmentYear(serviceInfo.getEnlistmentYear());
            vo.setHighlandEntryYear(serviceInfo.getHighlandEntryYear());
            vo.setDischargeYear(serviceInfo.getDischargeYear());
            vo.setServiceDuration(serviceInfo.getDischargeYear() - serviceInfo.getHighlandEntryYear());
            vo.setServicePosition(serviceInfo.getServicePosition());
        }

        // 腹部超声信息
        if (source.getExperimentExamAbdominalUltrasoundRespVO() != null) {
            ExperimentExamAbdominalUltrasoundRespVO ultrasound = source.getExperimentExamAbdominalUltrasoundRespVO();
            vo.setUltrasoundDescription(ultrasound.getUltrasoundDescription());
            vo.setUltrasoundSummary(ultrasound.getUltrasoundSummary());
        }

        // 基本检测信息
        if (source.getExperimentExamBasicTestsRespVO() != null) {
            ExperimentExamBasicTestsRespVO basicTests = source.getExperimentExamBasicTestsRespVO();
            vo.setSystolicPressure(basicTests.getSystolicPressure());
            vo.setDiastolicPressure(basicTests.getDiastolicPressure());
            vo.setPulse(basicTests.getPulse());
            vo.setTestsHeight(basicTests.getHeight());
            vo.setTestsWeight(basicTests.getWeight());
            vo.setBmi(basicTests.getBmi());
        }

        // 生化检测信息
        if (source.getExperimentExamBiochemicalTestsRespVO() != null) {
            ExperimentExamBiochemicalTestsRespVO biochemicalTests = source.getExperimentExamBiochemicalTestsRespVO();
            vo.setUrea(biochemicalTests.getUrea());
            vo.setCreatinine(biochemicalTests.getCreatinine());
            vo.setAlt(biochemicalTests.getAlt());
            vo.setAst(biochemicalTests.getAst());
            vo.setTotalCholesterol(biochemicalTests.getTotalCholesterol());
            vo.setTriglycerides(biochemicalTests.getTriglycerides());
            vo.setHdlC(biochemicalTests.getHdlC());
            vo.setLdlC(biochemicalTests.getLdlC());
            vo.setUricAcid(biochemicalTests.getUricAcid());
            vo.setTotalProtein(biochemicalTests.getTotalProtein());
            vo.setAlbumin(biochemicalTests.getAlbumin());
            vo.setGlobulin(biochemicalTests.getGlobulin());
            vo.setAlbGlobRatio(biochemicalTests.getAlbGlobRatio());
            vo.setTotalBilirubin(biochemicalTests.getTotalBilirubin());
            vo.setDirectBilirubin(biochemicalTests.getDirectBilirubin());
            vo.setIndirectBilirubin(biochemicalTests.getIndirectBilirubin());
            vo.setGlycatedHemoglobin(biochemicalTests.getGlycatedHemoglobin());
            vo.setPotassium(biochemicalTests.getPotassium());
            vo.setSodium(biochemicalTests.getSodium());
            vo.setChloride(biochemicalTests.getChloride());
            vo.setCalcium(biochemicalTests.getCalcium());
            vo.setPhosphorus(biochemicalTests.getPhosphorus());
            vo.setMagnesium(biochemicalTests.getMagnesium());
            vo.setFastingGlucose(biochemicalTests.getFastingGlucose());
            vo.setProthrombinTime(biochemicalTests.getProthrombinTime());
            vo.setProthrombinActivity(biochemicalTests.getProthrombinActivity());
            vo.setInr(biochemicalTests.getInr());
            vo.setFibrinogen(biochemicalTests.getFibrinogen());
            vo.setAptt(biochemicalTests.getAptt());
            vo.setThrombinTime(biochemicalTests.getThrombinTime());
        }

        // 血常规信息
        if (source.getExperimentExamBloodRoutineRespVO() != null) {
            ExperimentExamBloodRoutineRespVO bloodRoutine = source.getExperimentExamBloodRoutineRespVO();
            vo.setWbc(bloodRoutine.getWbc());
            vo.setRbc(bloodRoutine.getRbc());
            vo.setHemoglobin(bloodRoutine.getHemoglobin());
            vo.setHematocrit(bloodRoutine.getHematocrit());
            vo.setMcv(bloodRoutine.getMcv());
            vo.setMch(bloodRoutine.getMch());
            vo.setMchc(bloodRoutine.getMchc());
            vo.setRdwCv(bloodRoutine.getRdwCv());
            vo.setRdwSd(bloodRoutine.getRdwSd());
            vo.setPlateletCount(bloodRoutine.getPlateletCount());
            vo.setPlateletCrit(bloodRoutine.getPlateletCrit());
            vo.setMpv(bloodRoutine.getMpv());
            vo.setPdw(bloodRoutine.getPdw());
            vo.setNeutrophils(bloodRoutine.getNeutrophils());
            vo.setLymphocytes(bloodRoutine.getLymphocytes());
            vo.setMonocytes(bloodRoutine.getMonocytes());
            vo.setEosinophils(bloodRoutine.getEosinophils());
            vo.setBasophils(bloodRoutine.getBasophils());
            vo.setNeutrophilsPercentage(bloodRoutine.getNeutrophilsPercentage());
            vo.setLymphocytesPercentage(bloodRoutine.getLymphocytesPercentage());
            vo.setMonocytesPercentage(bloodRoutine.getMonocytesPercentage());
            vo.setEosinophilsPercentage(bloodRoutine.getEosinophilsPercentage());
            vo.setBasophilsPercentage(bloodRoutine.getBasophilsPercentage());
        }

        // 心电图信息
        if (source.getExperimentExamEcgRespVO() != null) {
            vo.setEcgDescription(source.getExperimentExamEcgRespVO().getEcgDescription());
        }

        // 既往病史信息
        if (source.getExperimentExamPastMedicalHistoryRespVO() != null) {
            ExperimentExamPastMedicalHistoryRespVO medicalHistory = source.getExperimentExamPastMedicalHistoryRespVO();
            vo.setInternalDiseaseHistory(medicalHistory.getInternalDiseaseHistory());
            vo.setExternalDiseaseHistory(medicalHistory.getExternalDiseaseHistory());
        }

        return vo;
    }

    public ControlGroupExportVO convertToControlExportVO(BasicInfoRespVO source) {
        ControlGroupExportVO vo = new ControlGroupExportVO();

        // 基础信息
        vo.setName(source.getName());
        vo.setGender(source.getGender());
        vo.setHighestEducation(source.getHighestEducation());
        vo.setEthnicity(source.getEthnicity());
        vo.setHeight(source.getHeight());
        vo.setWeight(source.getWeight());

        // 基础其他信息
        if (source.getBasicOtherInfoRespVO() != null) {
            BasicOtherInfoRespVO otherInfo = source.getBasicOtherInfoRespVO();
            vo.setAge(otherInfo.getAge());
            vo.setFertilityStatus(otherInfo.getFertilityStatus());
            vo.setRetiredWeight(otherInfo.getRetiredWeight());
        }

        // 服役信息
//        if (source.getExperimentSurveyServiceInfoRespVO() != null) {
//            ExperimentSurveyServiceInfoRespVO serviceInfo = source.getExperimentSurveyServiceInfoRespVO();
//            vo.setEnlistmentYear(serviceInfo.getEnlistmentYear());
//            vo.setHighlandEntryYear(serviceInfo.getHighlandEntryYear());
//            vo.setDischargeYear(serviceInfo.getDischargeYear());
//            vo.setServiceDuration(serviceInfo.getDischargeYear() - serviceInfo.getHighlandEntryYear());
//            vo.setServicePosition(serviceInfo.getServicePosition());
//        }

        // 饮酒情况
        if (source.getControlSurveyDrinkingInfoRespVO() != null) {
            ControlSurveyDrinkingInfoRespVO drinkingInfo = source.getControlSurveyDrinkingInfoRespVO();
            vo.setDrinkingExperience(drinkingInfo.getDrinkingExperience());
            vo.setDrinkingFrequency(drinkingInfo.getDrinkingFrequency());
        }

        // 既往疾病
        if (source.getControlSurveyPastDiseasesRespVO() != null) {
            ControlSurveyPastDiseasesRespVO diseasesInfo = source.getControlSurveyPastDiseasesRespVO();
            // 疾病1
            vo.setDisease1Name(diseasesInfo.getDisease1Name());
            vo.setDisease1Diagnosed(diseasesInfo.getDisease1Diagnosed());
            vo.setDisease1DiagnosisDate(diseasesInfo.getDisease1DiagnosisDate());
            vo.setDisease1Hospitalized(diseasesInfo.getDisease1Hospitalized());
            vo.setDisease1Treated(diseasesInfo.getDisease1Treated());
            vo.setDisease1TreatmentEffect(diseasesInfo.getDisease1TreatmentEffect());

            // 疾病2
            vo.setDisease2Name(diseasesInfo.getDisease2Name());
            vo.setDisease2Diagnosed(diseasesInfo.getDisease2Diagnosed());
            vo.setDisease2DiagnosisDate(diseasesInfo.getDisease2DiagnosisDate());
            vo.setDisease2Hospitalized(diseasesInfo.getDisease2Hospitalized());
            vo.setDisease2Treated(diseasesInfo.getDisease2Treated());
            vo.setDisease2TreatmentEffect(diseasesInfo.getDisease2TreatmentEffect());

            // 疾病3-6 (省略部分代码，实际实现类似)
            vo.setDisease3Name(diseasesInfo.getDisease3Name());
            vo.setDisease3Diagnosed(diseasesInfo.getDisease3Diagnosed());
            vo.setDisease3DiagnosisDate(diseasesInfo.getDisease3DiagnosisDate());
            vo.setDisease3Hospitalized(diseasesInfo.getDisease3Hospitalized());
            vo.setDisease3Treated(diseasesInfo.getDisease3Treated());
            vo.setDisease3TreatmentEffect(diseasesInfo.getDisease3TreatmentEffect());

            vo.setDisease4Name(diseasesInfo.getDisease4Name());
            vo.setDisease4Diagnosed(diseasesInfo.getDisease4Diagnosed());
            vo.setDisease4DiagnosisDate(diseasesInfo.getDisease4DiagnosisDate());
            vo.setDisease4Hospitalized(diseasesInfo.getDisease4Hospitalized());
            vo.setDisease4Treated(diseasesInfo.getDisease4Treated());
            vo.setDisease4TreatmentEffect(diseasesInfo.getDisease4TreatmentEffect());

            vo.setDisease5Name(diseasesInfo.getDisease5Name());
            vo.setDisease5Diagnosed(diseasesInfo.getDisease5Diagnosed());
            vo.setDisease5DiagnosisDate(diseasesInfo.getDisease5DiagnosisDate());
            vo.setDisease5Hospitalized(diseasesInfo.getDisease5Hospitalized());
            vo.setDisease5Treated(diseasesInfo.getDisease5Treated());
            vo.setDisease5TreatmentEffect(diseasesInfo.getDisease5TreatmentEffect());

            vo.setDisease6Name(diseasesInfo.getDisease6Name());
            vo.setDisease6Diagnosed(diseasesInfo.getDisease6Diagnosed());
            vo.setDisease6DiagnosisDate(diseasesInfo.getDisease6DiagnosisDate());
            vo.setDisease6Hospitalized(diseasesInfo.getDisease6Hospitalized());
            vo.setDisease6Treated(diseasesInfo.getDisease6Treated());
            vo.setDisease6TreatmentEffect(diseasesInfo.getDisease6TreatmentEffect());
        }

        // 旅居信息
        if (source.getControlSurveyResidenceInfoRespVO() != null) {
            ControlSurveyResidenceInfoRespVO residenceInfo = source.getControlSurveyResidenceInfoRespVO();
            vo.setHighlandExperience(residenceInfo.getHighlandExperience());
            vo.setLongTermPlainExperience(residenceInfo.getLongTermPlainExperience());
            vo.setResidence1(residenceInfo.getResidence1());
            vo.setResidence2(residenceInfo.getResidence2());
            vo.setResidence3(residenceInfo.getResidence3());
        }

        // 自我评价
        if (source.getControlSurveySelfAssessmentRespVO() != null) {
            ControlSurveySelfAssessmentRespVO assessment = source.getControlSurveySelfAssessmentRespVO();
            vo.setAnnualCheckups(assessment.getAnnualCheckups());
            vo.setHealthComparison(assessment.getHealthComparison());
            vo.setHealthScore(assessment.getHealthScore());
        }

        // 吸烟情况
        if (source.getControlSurveySmokingInfoRespVO() != null) {
            ControlSurveySmokingInfoRespVO smokingInfo = source.getControlSurveySmokingInfoRespVO();
            vo.setSmokingStatus(smokingInfo.getSmokingStatus());
            vo.setSmokingYears(smokingInfo.getSmokingYears());
            vo.setTriedQuit(smokingInfo.getTriedQuit());
            vo.setQuitTime(smokingInfo.getQuitTime());
        }

        if (source.getControlDiseaseSpectrumRespVO() != null) {
            ControlDiseaseSpectrumRespVO diseaseSpectrum = source.getControlDiseaseSpectrumRespVO();
            // 消化系统疾病拼接
            StringBuilder digestiveBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getFattyLiver())) digestiveBuilder.append("脂肪肝").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHepaticCyst())) digestiveBuilder.append("肝囊肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getGallbladderPolyp())) digestiveBuilder.append("胆囊息肉").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getGallbladderStone())) digestiveBuilder.append("胆囊结石").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHepaticHemangioma())) digestiveBuilder.append("肝血管瘤").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getSplenomegaly())) digestiveBuilder.append("脾大").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getChronicGastritis())) digestiveBuilder.append("慢性胃炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getIntestinalPolyp())) digestiveBuilder.append("肠息肉").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAppendicitis())) digestiveBuilder.append("阑尾炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAcutePancreatitis())) digestiveBuilder.append("急性胰腺炎").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDigestiveUlcer())) digestiveBuilder.append("消化道溃疡").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDigestiveBleeding())) digestiveBuilder.append("消化道出血").append(",");
            vo.setDiseaseSpectrumDigestiveSystem(removeTrailingComma(digestiveBuilder));
            //心血管系统疾病拼接
            StringBuilder cardiovascularBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypertension())) cardiovascularBuilder.append("高血压").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getBradycardia())) cardiovascularBuilder.append("窦性心动过缓").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getTransientIschemicAttack())) cardiovascularBuilder.append("短暂性脑缺血").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getTachycardia())) cardiovascularBuilder.append("窦性心动过速").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCerebralInfarction())) cardiovascularBuilder.append("脑梗死/脑血栓").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getFrequentPrematureAtrialContractions())) cardiovascularBuilder.append("频发房性早搏").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getFrequentPrematureVentricularContractions())) cardiovascularBuilder.append("频发室性早搏").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCoronaryHeartDisease())) cardiovascularBuilder.append("冠心病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAtrialFibrillation())) cardiovascularBuilder.append("房颤").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getMyocardialInfarction())) cardiovascularBuilder.append("心肌梗死").append(",");
            vo.setDiseaseSpectrumCardiovascularSystem(removeTrailingComma(cardiovascularBuilder));
            //内分泌系统疾病拼接
            StringBuilder endocrineBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypertriglyceridemia())) endocrineBuilder.append("高甘油三酯血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHighLdl())) endocrineBuilder.append("低密度脂蛋白胆固醇增多症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHighHdl())) endocrineBuilder.append("高密度脂蛋白胆固醇增多症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHyperuricemia())) endocrineBuilder.append("高尿酸血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getHypercholesterolemia())) endocrineBuilder.append("高胆固醇血症").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getDiabetes())) endocrineBuilder.append("糖尿病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getThyroidDisease())) endocrineBuilder.append("甲状腺疾病").append(",");
            vo.setDiseaseSpectrumEndocrineSystem(removeTrailingComma(endocrineBuilder));
            //呼吸系统疾病拼接
            StringBuilder respiratoryBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getLungNodule())) respiratoryBuilder.append("肺结节").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getPulmonaryEmphysema())) respiratoryBuilder.append("肺气肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCopd())) respiratoryBuilder.append("慢阻肺").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getAsthma())) respiratoryBuilder.append("哮喘").append(",");
            vo.setDiseaseSpectrumRespiratorySystem(removeTrailingComma(respiratoryBuilder));
            //泌尿系统疾病拼接
            StringBuilder urinaryBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getKidneyStone())) urinaryBuilder.append("肾结石").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getRenalCyst())) urinaryBuilder.append("肾囊肿").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getProstatitis())) urinaryBuilder.append("前列腺炎").append(",");
            vo.setDiseaseSpectrumUrinarySystem(removeTrailingComma(urinaryBuilder));
            //骨骼系统疾病拼接
            StringBuilder skeletalBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getLumbarSpondylosis())) skeletalBuilder.append("腰椎病").append(",");
            if (Boolean.TRUE.equals(diseaseSpectrum.getCervicalSpondylosis())) skeletalBuilder.append("颈椎病").append(",");
            vo.setDiseaseSpectrumSkeletalSystem(removeTrailingComma(skeletalBuilder));
            //神经系统疾病拼接
            StringBuilder nervousBuilder = new StringBuilder();
            if (Boolean.TRUE.equals(diseaseSpectrum.getInsomnia())) nervousBuilder.append("失眠").append(",");
            vo.setDiseaseSpectrumNervousSystem(removeTrailingComma(nervousBuilder));
        }

        // Framingham评分
        if (source.getControlFraminghamRespVO() != null) {
            ControlFraminghamRespVO framingham = source.getControlFraminghamRespVO();
            vo.setFraminghamScore(framingham.getFraminghamScore());
            vo.setFraminghamRisk(framingham.getFraminghamRisk());
            vo.setFraminghamRiskType(framingham.getFraminghamRiskType());
        }

        // 体检部分 - 腹部超声
        if (source.getControlExamAbdominalUltrasoundRespVO() != null) {
            ControlExamAbdominalUltrasoundRespVO ultrasound = source.getControlExamAbdominalUltrasoundRespVO();
            vo.setUltrasoundDescription(ultrasound.getUltrasoundDescription());
            vo.setUltrasoundSummary(ultrasound.getUltrasoundSummary());
        }

        // 基本检测信息
        if (source.getControlExamBasicTestsRespVO() != null) {
            ControlExamBasicTestsRespVO basicTests = source.getControlExamBasicTestsRespVO();
            vo.setSystolicPressure(basicTests.getSystolicPressure());
            vo.setDiastolicPressure(basicTests.getDiastolicPressure());
            vo.setPulse(basicTests.getPulse());
            vo.setTestsHeight(basicTests.getHeight());
            vo.setTestsWeight(basicTests.getWeight());
            vo.setBmi(basicTests.getBmi());
        }

        // 生化检测
        if (source.getControlExamBiochemicalTestsRespVO() != null) {
            ControlExamBiochemicalTestsRespVO bioTests = source.getControlExamBiochemicalTestsRespVO();
            vo.setUrea(bioTests.getUrea());
            vo.setCreatinine(bioTests.getCreatinine());
            vo.setAlt(bioTests.getAlt());
            vo.setAst(bioTests.getAst());
            vo.setTotalCholesterol(bioTests.getTotalCholesterol());
            vo.setTriglycerides(bioTests.getTriglycerides());
            vo.setHdlC(bioTests.getHdlC());
            vo.setLdlC(bioTests.getLdlC());
            vo.setUricAcid(bioTests.getUricAcid());
            vo.setTotalProtein(bioTests.getTotalProtein());
            vo.setAlbumin(bioTests.getAlbumin());
            vo.setGlobulin(bioTests.getGlobulin());
            vo.setAlbGlobRatio(bioTests.getAlbGlobRatio());
            vo.setTotalBilirubin(bioTests.getTotalBilirubin());
            vo.setDirectBilirubin(bioTests.getDirectBilirubin());
            vo.setIndirectBilirubin(bioTests.getIndirectBilirubin());
            vo.setGlycatedHemoglobin(bioTests.getGlycatedHemoglobin());
            vo.setPotassium(bioTests.getPotassium());
            vo.setSodium(bioTests.getSodium());
            vo.setChloride(bioTests.getChloride());
            vo.setCalcium(bioTests.getCalcium());
            vo.setPhosphorus(bioTests.getPhosphorus());
            vo.setMagnesium(bioTests.getMagnesium());
            vo.setFastingGlucose(bioTests.getFastingGlucose());
            vo.setProthrombinTime(bioTests.getProthrombinTime());
            vo.setProthrombinActivity(bioTests.getProthrombinActivity());
            vo.setInr(bioTests.getInr());
            vo.setFibrinogen(bioTests.getFibrinogen());
            vo.setAptt(bioTests.getAptt());
            vo.setThrombinTime(bioTests.getThrombinTime());
        }

        // 血常规
        if (source.getControlExamBloodRoutineRespVO() != null) {
            ControlExamBloodRoutineRespVO bloodRoutine = source.getControlExamBloodRoutineRespVO();
            vo.setWbc(bloodRoutine.getWbc());
            vo.setRbc(bloodRoutine.getRbc());
            vo.setHemoglobin(bloodRoutine.getHemoglobin());
            vo.setNeutrophils(bloodRoutine.getNeutrophils());
            vo.setLymphocytes(bloodRoutine.getLymphocytes());
            vo.setMonocytes(bloodRoutine.getMonocytes());
            vo.setEosinophils(bloodRoutine.getEosinophils());
            vo.setBasophils(bloodRoutine.getBasophils());
            vo.setMcv(bloodRoutine.getMcv());
            vo.setMch(bloodRoutine.getMch());
            vo.setMchc(bloodRoutine.getMchc());
            vo.setRdwCv(bloodRoutine.getRdwCv());
            vo.setRdwSd(bloodRoutine.getRdwSd());
            vo.setPlateletCrit(bloodRoutine.getPlateletCrit());
            vo.setMpv(bloodRoutine.getMpv());
            vo.setPdw(bloodRoutine.getPdw());
            vo.setHematocrit(bloodRoutine.getHematocrit());
            vo.setPlateletCount(bloodRoutine.getPlateletCount());
            vo.setNeutrophilsPercentage(bloodRoutine.getNeutrophilsPercentage());
            vo.setLymphocytesPercentage(bloodRoutine.getLymphocytesPercentage());
            vo.setMonocytesPercentage(bloodRoutine.getMonocytesPercentage());
            vo.setEosinophilsPercentage(bloodRoutine.getEosinophilsPercentage());
            vo.setBasophilsPercentage(bloodRoutine.getBasophilsPercentage());
        }

        // 心电图
        if (source.getControlExamEcgRespVO() != null) {
            vo.setEcgDescription(source.getControlExamEcgRespVO().getEcgDescription());
        }

        // 既往病史
        if (source.getControlExamPastMedicalHistoryRespVO() != null) {
            ControlExamPastMedicalHistoryRespVO medicalHistory = source.getControlExamPastMedicalHistoryRespVO();
            vo.setInternalDiseaseHistory(medicalHistory.getInternalDiseaseHistory());
            vo.setExternalDiseaseHistory(medicalHistory.getExternalDiseaseHistory());
        }

        return vo;
    }


    @GetMapping("/exportReview")
    @Operation(summary = "导出基础信息数据")
    @PreAuthorize("@ss.hasPermission('review:basic-info:export')")
    public void exportReview(@Valid BasicInfoPageReqVO pageReqVO, HttpServletResponse response) throws IOException {
        // 1. 查询数据（不分页，获取全部数据）
        pageReqVO.setPageSize(Integer.MAX_VALUE); // 设置为最大数量，获取所有数据
        PageResult<BasicInfoDO> pageResult = basicInfoService.getDataByParamPage(pageReqVO);
        List<BasicInfoRespVO> dataList = BeanUtils.toBean(pageResult, BasicInfoRespVO.class).getList();

        if("1".equals(pageReqVO.getGroup())){
            // 2. 转换为导出VO
            List<ExperimentGroupExportVO> exportList = dataList.stream()
                    .map(this::convertToExperimentExportVO)
                    .collect(Collectors.toList());

            // 3. 设置响应头
            String fileName = URLEncoder.encode("回顾性实验组数据.xlsx", "UTF-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), ExperimentGroupExportVO.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("基础信息").build();
            excelWriter.write(exportList, writeSheet);
            excelWriter.finish();
        }else{
            // 2. 转换为导出VO
            List<ControlGroupExportVO> exportList = dataList.stream()
                    .map(this::convertToControlExportVO)
                    .collect(Collectors.toList());

            // 3. 设置响应头
            String fileName = URLEncoder.encode("回顾性对照组数据.xlsx", "UTF-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), ControlGroupExportVO.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("基础信息").build();
            excelWriter.write(exportList, writeSheet);
            excelWriter.finish();
        }
    }


    @GetMapping("/importExcelExperimentSurveyZuizhong")
    public String importExcelExperimentSurveyZuizhong() {
        // Excel文件路径，您可以根据需要动态传入路径
//        String fileName = "/Users/jsheng/Downloads/回顾性数据/汇总-实验组-流调.xlsx";
//        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\汇总-实验组-流调.xlsx";
        String fileName = "E:\\项目\\西部战区医院\\回顾性数据\\数据0728\\建模用汇总表.xlsx";

        // 使用 EasyExcel 读取文件
        EasyExcel.read(fileName, new IndexListenerZuizhong(
                        basicInfoService
                        , basicOtherInfoService
                        , experimentSurveyDietService
                        , experimentSurveyDrinkingService
                        , experimentSurveyExerciseService
                        , experimentSurveyFamilyDiseasesService
                        , experimentSurveyHighlandDiseasesService
                        , experimentSurveyHighlandDiseasesDuringServiceService
                        , experimentSurveyHighlandReactionService
                        , experimentSurveyHighlandReactionSymptomsService
                        , experimentSurveyNewDiseasesService
                        , experimentSurveyNewDiseasesPostReturnService
                        , experimentSurveyPostReturnInfoService
                        , experimentSurveyPostReturnSymptomsService
                        , experimentSurveySelfAssessmentService
                        , experimentSurveyServiceInfoService
                        , experimentSurveySleepService
                        , experimentSurveySmokingService
                        , controlExamAbdominalUltrasoundService
                        , controlExamBasicTestsService
                        , controlExamBiochemicalTestsService
                        , controlExamBloodRoutineService
                        , controlExamEcgService
                        , controlExamPastMedicalHistoryService
                        , experimentFraminghamService
                        , experimentDiseaseSpectrumService))
                .sheet()
                .doRead();

        return "实验组流调数据导入完成";
    }

    // 监听器，用于读取每行数据
    static class IndexListenerZuizhong extends AnalysisEventListener<Map<Integer, String>> {

        // 使用构造函数注入 BasicInfoService 和 BasicOtherInfoService
        private BasicInfoService basicInfoService;
        private BasicOtherInfoService basicOtherInfoService;
        private ExperimentSurveyDietService experimentSurveyDietService;
        private ExperimentSurveyDrinkingService experimentSurveyDrinkingService;
        private ExperimentSurveyExerciseService experimentSurveyExerciseService;
        private ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService;
        private ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService;
        private ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService;
        private ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService;
        private ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService;
        private ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService;
        private ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService;
        private ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService;
        private ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService;
        private ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService;
        private ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService;
        private ExperimentSurveySleepService experimentSurveySleepService;
        private ExperimentSurveySmokingService experimentSurveySmokingService;

        private ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService;
        private ControlExamBasicTestsService controlExamBasicTestsService;
        private ControlExamBiochemicalTestsService controlExamBiochemicalTestsService;
        private ControlExamBloodRoutineService controlExamBloodRoutineService;
        private ControlExamEcgService controlExamEcgService;
        private ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService;

        private ExperimentFraminghamService experimentFraminghamService;

        private ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService;
        // 构造函数注入服务
        public IndexListenerZuizhong(BasicInfoService basicInfoService, BasicOtherInfoService basicOtherInfoService
                , ExperimentSurveyDietService experimentSurveyDietService
                , ExperimentSurveyDrinkingService experimentSurveyDrinkingService
                , ExperimentSurveyExerciseService experimentSurveyExerciseService
                , ExperimentSurveyFamilyDiseasesService experimentSurveyFamilyDiseasesService
                , ExperimentSurveyHighlandDiseasesService experimentSurveyHighlandDiseasesService
                , ExperimentSurveyHighlandDiseasesDuringServiceService experimentSurveyHighlandDiseasesDuringServiceService
                , ExperimentSurveyHighlandReactionService experimentSurveyHighlandReactionService
                , ExperimentSurveyHighlandReactionSymptomsService experimentSurveyHighlandReactionSymptomsService
                , ExperimentSurveyNewDiseasesService experimentSurveyNewDiseasesService
                , ExperimentSurveyNewDiseasesPostReturnService experimentSurveyNewDiseasesPostReturnService
                , ExperimentSurveyPostReturnInfoService experimentSurveyPostReturnInfoService
                , ExperimentSurveyPostReturnSymptomsService experimentSurveyPostReturnSymptomsService
                , ExperimentSurveySelfAssessmentService experimentSurveySelfAssessmentService
                , ExperimentSurveyServiceInfoService experimentSurveyServiceInfoService
                , ExperimentSurveySleepService experimentSurveySleepService
                , ExperimentSurveySmokingService experimentSurveySmokingService
                , ControlExamAbdominalUltrasoundService controlExamAbdominalUltrasoundService
                , ControlExamBasicTestsService controlExamBasicTestsService
                , ControlExamBiochemicalTestsService controlExamBiochemicalTestsService
                , ControlExamBloodRoutineService controlExamBloodRoutineService
                , ControlExamEcgService controlExamEcgService
                , ControlExamPastMedicalHistoryService controlExamPastMedicalHistoryService
                , ExperimentFraminghamService experimentFraminghamService
                , ExperimentDiseaseSpectrumService experimentDiseaseSpectrumService) {
            this.basicInfoService = basicInfoService;
            this.basicOtherInfoService = basicOtherInfoService;
            this.experimentSurveyDietService = experimentSurveyDietService;
            this.experimentSurveyDrinkingService = experimentSurveyDrinkingService;
            this.experimentSurveyExerciseService = experimentSurveyExerciseService;
            this.experimentSurveyFamilyDiseasesService = experimentSurveyFamilyDiseasesService;
            this.experimentSurveyHighlandDiseasesService = experimentSurveyHighlandDiseasesService;
            this.experimentSurveyHighlandDiseasesDuringServiceService = experimentSurveyHighlandDiseasesDuringServiceService;
            this.experimentSurveyHighlandReactionService = experimentSurveyHighlandReactionService;
            this.experimentSurveyHighlandReactionSymptomsService = experimentSurveyHighlandReactionSymptomsService;
            this.experimentSurveyNewDiseasesService = experimentSurveyNewDiseasesService;
            this.experimentSurveyNewDiseasesPostReturnService = experimentSurveyNewDiseasesPostReturnService;
            this.experimentSurveyPostReturnInfoService = experimentSurveyPostReturnInfoService;
            this.experimentSurveyPostReturnSymptomsService = experimentSurveyPostReturnSymptomsService;
            this.experimentSurveySelfAssessmentService = experimentSurveySelfAssessmentService;
            this.experimentSurveyServiceInfoService = experimentSurveyServiceInfoService;
            this.experimentSurveySleepService = experimentSurveySleepService;
            this.experimentSurveySmokingService = experimentSurveySmokingService;
            this.controlExamAbdominalUltrasoundService = controlExamAbdominalUltrasoundService;
            this.controlExamBasicTestsService = controlExamBasicTestsService;
            this.controlExamBiochemicalTestsService = controlExamBiochemicalTestsService;
            this.controlExamBloodRoutineService = controlExamBloodRoutineService;
            this.controlExamEcgService = controlExamEcgService;
            this.controlExamPastMedicalHistoryService = controlExamPastMedicalHistoryService;
            this.experimentFraminghamService = experimentFraminghamService;
            this.experimentDiseaseSpectrumService = experimentDiseaseSpectrumService;
        }

        @Override
        public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
            BasicInfoSaveReqVO basicInfo = new BasicInfoSaveReqVO();
            BasicOtherInfoSaveReqVO basicOtherInfo = new BasicOtherInfoSaveReqVO();
            ExperimentSurveyServiceInfoSaveReqVO experimentSurveyServiceInfo = new ExperimentSurveyServiceInfoSaveReqVO();
            ExperimentSurveySmokingSaveReqVO experimentSurveySmoking = new ExperimentSurveySmokingSaveReqVO();
            ExperimentSurveyDrinkingSaveReqVO experimentSurveyDrinking = new ExperimentSurveyDrinkingSaveReqVO();
            ExperimentSurveySelfAssessmentSaveReqVO experimentSurveySelfAssessment = new ExperimentSurveySelfAssessmentSaveReqVO();
            ExperimentSurveyFamilyDiseasesSaveReqVO experimentSurveyFamilyDiseases = new ExperimentSurveyFamilyDiseasesSaveReqVO();
            ExperimentSurveyHighlandReactionSaveReqVO experimentSurveyHighlandReaction = new ExperimentSurveyHighlandReactionSaveReqVO();
            ExperimentSurveyHighlandDiseasesSaveReqVO experimentSurveyHighlandDiseases = new ExperimentSurveyHighlandDiseasesSaveReqVO();
            ExperimentSurveyHighlandReactionSymptomsSaveReqVO experimentSurveyHighlandReactionSymptoms = new ExperimentSurveyHighlandReactionSymptomsSaveReqVO();
            ExperimentSurveyPostReturnSymptomsSaveReqVO experimentSurveyPostReturnSymptoms = new ExperimentSurveyPostReturnSymptomsSaveReqVO();
            ExperimentSurveyPostReturnInfoSaveReqVO experimentSurveyPostReturnInfo = new ExperimentSurveyPostReturnInfoSaveReqVO();
            ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO experimentSurveyHighlandDiseasesDuringService = new ExperimentSurveyHighlandDiseasesDuringServiceSaveReqVO();
            ExperimentSurveyNewDiseasesPostReturnSaveReqVO experimentSurveyNewDiseasesPostReturn = new ExperimentSurveyNewDiseasesPostReturnSaveReqVO();
            ExperimentSurveyNewDiseasesSaveReqVO experimentSurveyNewDiseases = new ExperimentSurveyNewDiseasesSaveReqVO();
            ExperimentSurveyExerciseSaveReqVO experimentSurveyExercise = new ExperimentSurveyExerciseSaveReqVO();
            ExperimentSurveyDietSaveReqVO experimentSurveyDiet = new ExperimentSurveyDietSaveReqVO();
            ExperimentSurveySleepSaveReqVO experimentSurveySleep = new ExperimentSurveySleepSaveReqVO();
            ControlExamAbdominalUltrasoundSaveReqVO controlExamAbdominalUltrasoundSaveReqVO = new ControlExamAbdominalUltrasoundSaveReqVO();
            ControlExamBasicTestsSaveReqVO controlExamBasicTestsSaveReqVO = new ControlExamBasicTestsSaveReqVO();
            ControlExamBiochemicalTestsSaveReqVO controlExamBiochemicalTestsSaveReqVO = new ControlExamBiochemicalTestsSaveReqVO();
            ControlExamBloodRoutineSaveReqVO controlExamBloodRoutineSaveReqVO = new ControlExamBloodRoutineSaveReqVO();
            ControlExamEcgSaveReqVO controlExamEcgSaveReqVO = new ControlExamEcgSaveReqVO();
            ControlExamPastMedicalHistorySaveReqVO controlExamPastMedicalHistorySaveReqVO = new ControlExamPastMedicalHistorySaveReqVO();
            ExperimentFraminghamSaveReqVO experimentFraminghamSaveReqVO = new ExperimentFraminghamSaveReqVO();
            ExperimentDiseaseSpectrumSaveReqVO experimentDiseaseSpectrumSaveReqVO = new ExperimentDiseaseSpectrumSaveReqVO();


            Long generatedId = 0L;

            BasicInfoPageReqVO basicInfoPageReqVO = new BasicInfoPageReqVO();
            basicInfoPageReqVO.setName(rowData.get(1)); // 姓名
            basicInfoPageReqVO.setType(1); // 1：实验组，2：对照组
            List<BasicInfoDO> basicInfoDOS = basicInfoService.selectBasicInfoList(basicInfoPageReqVO);
            if (basicInfoDOS.size() > 0) {
                generatedId = basicInfoDOS.get(0).getId();

                basicInfo.setId(generatedId);
                basicInfo.setName(rowData.get(1)); // 姓名
                basicInfo.setGender(rowData.get(2)); // 性别
                //实验组流调-服役信息
                experimentSurveyServiceInfo.setPersonId(generatedId);
                experimentSurveyServiceInfo.setEnlistmentYear(Integer.parseInt(rowData.get(3))); // 入伍年份（第3列）
                experimentSurveyServiceInfo.setHighlandEntryYear(Integer.parseInt(rowData.get(4))); // 进入高原年份（第4列）
                experimentSurveyServiceInfo.setDischargeYear(Integer.parseInt(rowData.get(5))); // 退役年份（第5列）
                experimentSurveyServiceInfo.setServicePosition(rowData.get(6)); // 服役期间职务（第6列）
                basicInfo.setHighestEducation(rowData.get(7)); // 最高学历
                basicOtherInfo.setPersonId(generatedId);
                basicOtherInfo.setFertilityStatus(rowData.get(8)); // 生育情况
                basicInfo.setEthnicity(rowData.get(9)); // 民族
                basicInfo.setMaritalStatus(rowData.get(10)); // 婚姻情况
//            basicInfo.setHeight(extractNumber(rowData.get(11))); // 身高
//            basicInfo.setWeight(extractNumber(rowData.get(12))); // 体重
                basicInfo.setType(1); // 1表示实验组

                // 保存 BasicInfoRespVO 到数据库
                basicInfoService.updateBasicInfo(basicInfo);

                // 获取第13列的值
//            String weightData = rowData.get(13).toString();  // 获取字段并转换为字符串
//            BigDecimal retiredWeight = BigDecimal.ZERO;  // 默认值为0
//            // 判断是否包含 "Kg"，并处理数值部分
//            if (weightData != null) {
//                // 如果包含 "Kg"，去掉 "Kg" 部分
//                if (weightData.endsWith("Kg")) {
//                    weightData = weightData.replaceAll("Kg", "");  // 去掉单位 "Kg"
//                }
//                // 判断剩余部分是否为有效数字
//                if (weightData.matches("\\d+")) {  // 只有数字（整数）部分
//                    retiredWeight = parseBigDecimal(weightData);  // 转换为BigDecimal
//                } else {
//                    // 如果不是有效的数字，默认为0
//                    retiredWeight = BigDecimal.ZERO;
//                }
//            }
//            basicOtherInfo.setRetiredWeight(retiredWeight);  // 设置退役体重  // 退役体重（第13列）


                //            实验组流调-吸烟情况
                experimentSurveySmoking.setPersonId(generatedId);  // 设置基础信息id
                experimentSurveySmoking.setSmokingStatus(rowData.get(14) != null ? rowData.get(14).toString() : null);  // 是否吸烟（第14列）
                experimentSurveySmoking.setDailySmoking(rowData.get(15));  // 每日抽烟数量（第15列）
                experimentSurveySmoking.setSmokingStartAge(rowData.get(16) != null ? Integer.parseInt(rowData.get(16).toString()) : null);  // 开始吸烟年龄（第16列）
                experimentSurveySmoking.setSmokingYears(rowData.get(17) != null ? Integer.parseInt(rowData.get(17).toString()) : null);  // 烟龄（第17列）
                experimentSurveySmoking.setTriedQuit(rowData.get(18) != null ? parseBoolean(rowData.get(18).toString()) : null);  // 是否尝试戒烟（第18列）
                experimentSurveySmoking.setHighlandPlainSmokingStatus(rowData.get(19) != null ? rowData.get(19).toString() : null);  // 高原/平原吸烟情况（第19列）
                experimentSurveySmoking.setSmokingYears2(rowData.get(20));  // 烟龄 2（第20列）
                experimentSurveySmoking.setQuitTime(rowData.get(21)); // 戒烟时间（第21列）
                experimentSurveySmoking.setHighlandPlainSmokingStatus2(rowData.get(22) != null ? rowData.get(22).toString() : null);  // 高原/平原吸烟情况 2（第22列）

                //            实验组流调-饮酒情况
                experimentSurveyDrinking.setPersonId(generatedId);
                experimentSurveyDrinking.setDrinkingExperience(rowData.get(23));  // 饮酒经历（第23列）
                experimentSurveyDrinking.setStillDrinking(parseBoolean(rowData.get(24)));  // 仍在饮酒（第24列）
//            experimentSurveyDrinking.setDrinkingFrequency(rowData.get(25));  // 饮酒频率（第25列）
//            experimentSurveyDrinking.setOverDrinking(parseBoolean(rowData.get(26)));  // 是否过量饮酒（第26列）
//            experimentSurveyDrinking.setBeer(parseBoolean(rowData.get(27)));  // 啤酒（第27列）
//            experimentSurveyDrinking.setLiquor(parseBoolean(rowData.get(28)));  // 白酒（第28列）
//            experimentSurveyDrinking.setRedWine(parseBoolean(rowData.get(29)));  // 红酒（第29列）
//            experimentSurveyDrinking.setCocktails(parseBoolean(rowData.get(30)));  // 鸡尾酒（第30列）
//            experimentSurveyDrinking.setSpirits(parseBoolean(rowData.get(31)));  // 烈酒（第31列）
//            experimentSurveyDrinking.setOtherAlcohol(parseBoolean(rowData.get(32)));  // 其他（第32列）

                //            实验组流调-自我评价
                experimentSurveySelfAssessment.setPersonId(generatedId);
                experimentSurveySelfAssessment.setHealthComparisonWithPeers(rowData.get(33)); // 与同龄人相比，您认为目前自己的身体健康状况如何（第33列）
//            experimentSurveySelfAssessment.setHealthScore(rowData.get(34)); // 您认为自己身体健康状况能得的分数（第34列）

                //            实验组流调-服役信息
                experimentSurveyServiceInfo.setHighlandTaskType(rowData.get(34)); // 高原任务的类型（第108列）

                //            实验组流调-高原反应信息
                experimentSurveyHighlandReaction.setPersonId(generatedId);
                experimentSurveyHighlandReaction.setReactionOccurred(parseBoolean(rowData.get(35))); // 是否发生过高原反应（第109列）
//            experimentSurveyHighlandReaction.setReactionCount(parseBooleanToInteger(rowData.get(110))); // 高原反应次数（第110列）
//            experimentSurveyHighlandReaction.setReactionCountText(rowData.get(110)); // 高原反应次数（第110列）
//            experimentSurveyHighlandReaction.setUnclearReactionCount(parseBoolean(rowData.get(111))); // 高原反应次数记不清（第111列）
                experimentSurveyHighlandReaction.setMultipleReactionsChanges(rowData.get(36)); // 多次高原反应，高原反应变化情况（第112列）

                //            实验组流调-高原疾病诊断
                experimentSurveyHighlandDiseases.setPersonId(generatedId);
                experimentSurveyHighlandDiseases.setAcuteHighlandReaction(parseBoolean(rowData.get(37))); // 急性高原反应（第113列）
                experimentSurveyHighlandDiseases.setHighlandPulmonaryEdema(parseBoolean(rowData.get(38))); // 高原肺水肿（第114列）
                experimentSurveyHighlandDiseases.setHighlandCerebralEdema(parseBoolean(rowData.get(39))); // 高原脑水肿（第115列）
                experimentSurveyHighlandDiseases.setHighlandHeartDisease(parseBoolean(rowData.get(40))); // 高原心脏病（第116列）
                experimentSurveyHighlandDiseases.setHighlandPolycythemia(parseBoolean(rowData.get(41))); // 高原红细胞增多症（第117列）
//            experimentSurveyHighlandDiseases.setOtherDiseases(parseBoolean(rowData.get(118))); // 其他（第118列）       // 其他（第115列）

                //            实验组流调-高原反应症状
                experimentSurveyHighlandReactionSymptoms.setPersonId(generatedId);
                experimentSurveyHighlandReactionSymptoms.setHeadache(parseBoolean(rowData.get(42))); // 头痛（第119列）
                experimentSurveyHighlandReactionSymptoms.setVomiting(parseBoolean(rowData.get(43))); // 呕吐（第120列）
                experimentSurveyHighlandReactionSymptoms.setDizziness(parseBoolean(rowData.get(44))); // 头昏（第121列）
                experimentSurveyHighlandReactionSymptoms.setNausea(parseBoolean(rowData.get(45))); // 恶心（第122列）
                experimentSurveyHighlandReactionSymptoms.setPalpitations(parseBoolean(rowData.get(46))); // 心慌（第123列）
                experimentSurveyHighlandReactionSymptoms.setPoorAppetite(parseBoolean(rowData.get(47))); // 食欲不振（第124列）
                experimentSurveyHighlandReactionSymptoms.setChestTightness(parseBoolean(rowData.get(48))); // 胸闷（第125列）
                experimentSurveyHighlandReactionSymptoms.setBlurredVision(parseBoolean(rowData.get(49))); // 眼花（第126列）
                experimentSurveyHighlandReactionSymptoms.setShortnessOfBreath(parseBoolean(rowData.get(50))); // 气短（第127列）
                experimentSurveyHighlandReactionSymptoms.setAbdominalBloating(parseBoolean(rowData.get(51))); // 腹胀（第128列）
                experimentSurveyHighlandReactionSymptoms.setDiarrhea(parseBoolean(rowData.get(52))); // 腹泻（第129列）


//            实验组流调-退役后返回平原1月内症状
                experimentSurveyPostReturnSymptoms.setPersonId(generatedId);
                experimentSurveyPostReturnSymptoms.setFatigue(parseBoolean(rowData.get(53))); // 疲倦（第130列）
                experimentSurveyPostReturnSymptoms.setDrowsiness(parseBoolean(rowData.get(54))); // 嗜睡（第131列）
                experimentSurveyPostReturnSymptoms.setDizziness(parseBoolean(rowData.get(55))); // 头昏（第132列）
                experimentSurveyPostReturnSymptoms.setVertigo(parseBoolean(rowData.get(56))); // 眩晕（第133列）
                experimentSurveyPostReturnSymptoms.setPoorConcentration(parseBoolean(rowData.get(57))); // 精力不集中（第134列）
                experimentSurveyPostReturnSymptoms.setSlowReaction(parseBoolean(rowData.get(58))); // 反应迟钝（第135列）
                experimentSurveyPostReturnSymptoms.setMemoryLoss(parseBoolean(rowData.get(59))); // 记忆减退（第136列）
                experimentSurveyPostReturnSymptoms.setInsomnia(parseBoolean(rowData.get(60))); // 失眠（第137列）
                experimentSurveyPostReturnSymptoms.setNightmares(parseBoolean(rowData.get(61))); // 多梦（第138列）
                experimentSurveyPostReturnSymptoms.setChestPain(parseBoolean(rowData.get(62))); // 心前区痛（第139列）
                experimentSurveyPostReturnSymptoms.setPalpitations(parseBoolean(rowData.get(63))); // 心慌（第140列）
                experimentSurveyPostReturnSymptoms.setBradycardia(parseBoolean(rowData.get(64))); // 脉率减慢（第141列）
                experimentSurveyPostReturnSymptoms.setCyanosis(parseBoolean(rowData.get(65))); // 紫绀（第142列）
                experimentSurveyPostReturnSymptoms.setBloodPressureFluctuation(parseBoolean(rowData.get(66))); // 血压波动（第143列）
                experimentSurveyPostReturnSymptoms.setSkinBleeding(parseBoolean(rowData.get(67))); // 皮肤出血（第144列）
                experimentSurveyPostReturnSymptoms.setSkinBruising(parseBoolean(rowData.get(68))); // 皮肤瘀斑（第145列）
                experimentSurveyPostReturnSymptoms.setAnemia(parseBoolean(rowData.get(69))); // 贫血（第146列）
                experimentSurveyPostReturnSymptoms.setSoreThroat(parseBoolean(rowData.get(70))); // 咽喉痛（第147列）
                experimentSurveyPostReturnSymptoms.setCough(parseBoolean(rowData.get(71))); // 咳嗽（第148列）
                experimentSurveyPostReturnSymptoms.setPhlegm(parseBoolean(rowData.get(72))); // 多痰（第149列）
                experimentSurveyPostReturnSymptoms.setWheezing(parseBoolean(rowData.get(73))); // 气喘（第150列）
                experimentSurveyPostReturnSymptoms.setChestTightness(parseBoolean(rowData.get(74))); // 胸闷（第151列）
                experimentSurveyPostReturnSymptoms.setWeightLoss(parseBoolean(rowData.get(75))); // 体重减轻（第152列）
                experimentSurveyPostReturnSymptoms.setIncreasedAppetite(parseBoolean(rowData.get(76))); // 食欲增加（第153列）
                experimentSurveyPostReturnSymptoms.setAnorexia(parseBoolean(rowData.get(77))); // 厌食（第154列）
                experimentSurveyPostReturnSymptoms.setConstipation(parseBoolean(rowData.get(78))); // 便秘（第155列）
                experimentSurveyPostReturnSymptoms.setDiarrhea(parseBoolean(rowData.get(79))); // 腹泻（第156列）
                experimentSurveyPostReturnSymptoms.setAbdominalPain(parseBoolean(rowData.get(80))); // 腹痛（第157列）
                experimentSurveyPostReturnSymptoms.setAbdominalDistension(parseBoolean(rowData.get(81))); // 腹胀（第158列）
                experimentSurveyPostReturnSymptoms.setJaundice(parseBoolean(rowData.get(82))); // 黄疸（第158列）
                experimentSurveyPostReturnSymptoms.setNumbness(parseBoolean(rowData.get(83))); // 手足麻木（第159列）
                experimentSurveyPostReturnSymptoms.setLimbEdema(parseBoolean(rowData.get(84))); // 肢体水肿（第160列）
                experimentSurveyPostReturnSymptoms.setFacialEdema(parseBoolean(rowData.get(85))); // 面部水肿（第161列）
                experimentSurveyPostReturnSymptoms.setHairLoss(parseBoolean(rowData.get(86))); // 脱发（第162列）
                experimentSurveyPostReturnSymptoms.setIncreasedUrination(parseBoolean(rowData.get(87))); // 夜尿增多

                //            实验组流调-返回后基础信息
                experimentSurveyPostReturnInfo.setPersonId(generatedId);
//            experimentSurveyPostReturnInfo.setChengdu(parseBooleanToInteger(rowData.get(165))); // 成都（第165列）
//            experimentSurveyPostReturnInfo.setChengduResidenceTime(extractNumberOrZero(rowData.get(166))); // 成都居住时间（年）（第166列）
//            experimentSurveyPostReturnInfo.setKunming(parseBooleanToInteger(rowData.get(167)));// 昆明（第167列）
//            experimentSurveyPostReturnInfo.setKunmingResidenceTime(extractNumberOrZero(rowData.get(168)));// 昆明居住时间（年）（第168列）
//            experimentSurveyPostReturnInfo.setXining(parseBooleanToInteger(rowData.get(169))); // 西宁（第169列）
//            experimentSurveyPostReturnInfo.setXiningResidenceTime(extractNumberOrZero(rowData.get(170))); // 西宁居住时间（年）（第170列）
//            experimentSurveyPostReturnInfo.setOtherArea(rowData.get(171)); // 其他（第171列）
//            experimentSurveyPostReturnInfo.setOtherAreaResidenceTime(rowData.get(172)); // 其他居住时间（年）（第172列）
                experimentSurveyPostReturnInfo.setPostReturnWorkStatus(rowData.get(88)); // 从高原返回后的工作情况（第173列）
                experimentSurveyPostReturnInfo.setAnnualCheckups(rowData.get(89)); // 每年体检/就诊次数（第174列）

                //            实验组流调-体育锻炼信息
                experimentSurveyExercise.setPersonId(generatedId);
                experimentSurveyExercise.setRegularExercise(parseBoolean(rowData.get(90))); // 是否有规律的体育锻炼（第255列）
                experimentSurveyExercise.setExerciseFrequency(rowData.get(91)); // 参加体育锻炼的频率（第256列）
                experimentSurveyExercise.setExerciseDuration(rowData.get(92)); // 参加体育锻炼的时长（第257列）
                experimentSurveyExercise.setExerciseType(rowData.get(93)); // 哪种类型的体育锻炼（第258列）
                experimentSurveyExercise.setChestPainOrShortness(parseBoolean(rowData.get(94))); // 胸闷、气促（第259列）
                experimentSurveyExercise.setDoctorGuidedExercise(parseBoolean(rowData.get(95))); // 是否在医生指导下体育锻炼（第260列）

//            实验组流调-饮食习惯
                experimentSurveyDiet.setPersonId(generatedId);
                experimentSurveyDiet.setEatingHabits(rowData.get(96)); // 饮食习惯（第261列）
//            experimentSurveyDiet.setDrinkingWater(rowData.get(262)); // 饮用水（第262列）
//            experimentSurveyDiet.setTea(rowData.get(263)); // 茶水（第263列）
//            experimentSurveyDiet.setFruitJuice(rowData.get(264)); // 果汁（第264列）
//            experimentSurveyDiet.setCarbonatedDrinks(rowData.get(265)); // 碳酸饮料（第265列）
//            experimentSurveyDiet.setCoffee(rowData.get(266)); // 咖啡（第266列）
//            experimentSurveyDiet.setMilk(rowData.get(267)); // 牛奶（第267列）

//            实验组流调-睡眠信息
                experimentSurveySleep.setPersonId(generatedId);
//            experimentSurveySleep.setSleepTimeStart(rowData.get(269));  // 晚上睡觉时间（第269列）
//            experimentSurveySleep.setSleepOnsetTime(rowData.get(270));  // 入睡需要时间（分钟）（第270列）
//            experimentSurveySleep.setWakeTime(rowData.get(271));  // 起床时间（第271列）
//            experimentSurveySleep.setActualSleepDuration(rowData.get(272));  // 实际睡眠时间（小时）（第272列）
//            experimentSurveySleep.setSleepDifficulties(rowData.get(273));  // 入睡困难（第273列）
//            experimentSurveySleep.setNightAwakening(rowData.get(274));  // 夜间易醒或早醒（第274列）
//            experimentSurveySleep.setNightUrination(rowData.get(275));  // 夜间去厕所（第275列）
//            experimentSurveySleep.setBreathingDifficulties(rowData.get(276));  // 呼吸不畅（第276列）
//            experimentSurveySleep.setCoughOrSnore(rowData.get(277));  // 咳嗽或鼾声高（第277列）
//            experimentSurveySleep.setFeelingCold(rowData.get(278));  // 感觉冷（第278列）
//            experimentSurveySleep.setFeelingHot(rowData.get(279));  // 感觉热（第279列）
//            experimentSurveySleep.setNightmares(rowData.get(280));  // 做恶梦（第280列）
//            experimentSurveySleep.setPainOrDiscomfort(rowData.get(281));  // 疼痛不适（第281列）
//            experimentSurveySleep.setOtherSleepIssues(rowData.get(282));  // 其他影响睡眠的事情（第282列），直接赋值为 String
//            experimentSurveySleep.setSleepAids(rowData.get(283));  // 催眠药（第283列）
//            experimentSurveySleep.setFatigue(rowData.get(284));  // 感到困倦（第284列）
//            experimentSurveySleep.setLackOfEnergy(rowData.get(285));  // 精力不足（第285列）
                experimentSurveySleep.setSelfAssessmentSleep(rowData.get(97));  // 自评睡眠情况（第286列）


                controlExamBasicTestsSaveReqVO.setPersonId(generatedId);
                controlExamBasicTestsSaveReqVO.setSystolicPressure(parseBigDecimal(rowData.get(98))); // 收缩压（第6列）
                controlExamBasicTestsSaveReqVO.setDiastolicPressure(parseBigDecimal(rowData.get(99))); // 舒张压（第7列）
                controlExamBasicTestsSaveReqVO.setPulse(parseInteger(rowData.get(100))); // 脉搏（第8列）
                controlExamBasicTestsSaveReqVO.setHeight(parseBigDecimal(rowData.get(101))); // 身高（第9列）
                controlExamBasicTestsSaveReqVO.setWeight(parseBigDecimal(rowData.get(102))); // 体重（第10列）
                controlExamBasicTestsSaveReqVO.setBmi(parseBigDecimal(rowData.get(103))); // 体重指数(kg/m^2)（第11列）

                controlExamBloodRoutineSaveReqVO.setPersonId(generatedId);
                controlExamBloodRoutineSaveReqVO.setWbc(parseBigDecimal(rowData.get(104))); // 白细胞计数
                controlExamBloodRoutineSaveReqVO.setRbc(parseBigDecimal(rowData.get(105))); // 红细胞计数
                controlExamBloodRoutineSaveReqVO.setNeutrophils(parseBigDecimal(rowData.get(106))); // 中性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setLymphocytes(parseBigDecimal(rowData.get(107))); // 淋巴细胞计数
                controlExamBloodRoutineSaveReqVO.setMonocytes(parseBigDecimal(rowData.get(108))); // 单核细胞计数
                controlExamBloodRoutineSaveReqVO.setEosinophils(parseBigDecimal(rowData.get(109))); // 嗜酸性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setBasophils(parseBigDecimal(rowData.get(110))); // 嗜碱性粒细胞计数
                controlExamBloodRoutineSaveReqVO.setMcv(parseBigDecimal(rowData.get(111))); // 平均红细胞容积
                controlExamBloodRoutineSaveReqVO.setMch(parseBigDecimal(rowData.get(112))); // 平均红细胞血红蛋白含量
                controlExamBloodRoutineSaveReqVO.setMchc(parseBigDecimal(rowData.get(113))); // 平均红细胞血红蛋白浓度
                controlExamBloodRoutineSaveReqVO.setRdwCv(parseBigDecimal(rowData.get(114))); // RBC分布宽度CV值
                controlExamBloodRoutineSaveReqVO.setRdwSd(parseBigDecimal(rowData.get(115))); // RBC分布宽度SD值
                controlExamBloodRoutineSaveReqVO.setHemoglobin(parseBigDecimal(rowData.get(116))); // 血红蛋白浓度
                controlExamBloodRoutineSaveReqVO.setPlateletCrit(parseBigDecimal(rowData.get(117))); // 血小板比容
                controlExamBloodRoutineSaveReqVO.setMpv(parseBigDecimal(rowData.get(118))); // 平均血小板体积
                controlExamBloodRoutineSaveReqVO.setPdw(parseBigDecimal(rowData.get(119))); // 血小板分布宽度
                controlExamBloodRoutineSaveReqVO.setHematocrit(parseBigDecimal(rowData.get(120))); // 红细胞比容
                controlExamBloodRoutineSaveReqVO.setPlateletCount(parseBigDecimal(rowData.get(121))); // 血小板计数
                controlExamBloodRoutineSaveReqVO.setNeutrophilsPercentage(parseBigDecimal(rowData.get(122))); // 中性粒细胞百分率
                controlExamBloodRoutineSaveReqVO.setLymphocytesPercentage(parseBigDecimal(rowData.get(123))); // 淋巴细胞百分率
                controlExamBloodRoutineSaveReqVO.setMonocytesPercentage(parseBigDecimal(rowData.get(124))); // 单核细胞百分率
                controlExamBloodRoutineSaveReqVO.setEosinophilsPercentage(parseBigDecimal(rowData.get(125))); // 嗜酸性粒细胞百分率
                controlExamBloodRoutineSaveReqVO.setBasophilsPercentage(parseBigDecimal(rowData.get(126))); // 嗜碱性粒细胞百分率

                controlExamBiochemicalTestsSaveReqVO.setPersonId(generatedId);
                controlExamBiochemicalTestsSaveReqVO.setUrea(parseBigDecimal(rowData.get(127))); // 尿素
                controlExamBiochemicalTestsSaveReqVO.setCreatinine(parseBigDecimal(rowData.get(128))); // 肌酐
                controlExamBiochemicalTestsSaveReqVO.setAlt(parseBigDecimal(rowData.get(129))); // 谷丙转氨酶
                controlExamBiochemicalTestsSaveReqVO.setAst(parseBigDecimal(rowData.get(130))); // 谷草转氨酶
                controlExamBiochemicalTestsSaveReqVO.setTotalCholesterol(parseBigDecimal(rowData.get(131))); // 总胆固醇
                controlExamBiochemicalTestsSaveReqVO.setTriglycerides(parseBigDecimal(rowData.get(132))); // 甘油三酯
                controlExamBiochemicalTestsSaveReqVO.setHdlC(parseBigDecimal(rowData.get(133))); // 高密度脂蛋白胆固醇
                controlExamBiochemicalTestsSaveReqVO.setLdlC(parseBigDecimal(rowData.get(134))); // 低密度脂蛋白胆固醇
                controlExamBiochemicalTestsSaveReqVO.setUricAcid(parseBigDecimal(rowData.get(135))); // 尿酸
                controlExamBiochemicalTestsSaveReqVO.setTotalProtein(parseBigDecimal(rowData.get(136))); // 总蛋白
                controlExamBiochemicalTestsSaveReqVO.setAlbumin(parseBigDecimal(rowData.get(137))); // 白蛋白
                controlExamBiochemicalTestsSaveReqVO.setGlobulin(parseBigDecimal(rowData.get(138))); // 球蛋白
                controlExamBiochemicalTestsSaveReqVO.setAlbGlobRatio(parseBigDecimal(rowData.get(139))); // 白球比例
                controlExamBiochemicalTestsSaveReqVO.setTotalBilirubin(parseBigDecimal(rowData.get(140))); // 总胆红素
                controlExamBiochemicalTestsSaveReqVO.setDirectBilirubin(parseBigDecimal(rowData.get(141))); // 直接胆红素
                controlExamBiochemicalTestsSaveReqVO.setIndirectBilirubin(parseBigDecimal(rowData.get(142))); // 间接胆红素
                controlExamBiochemicalTestsSaveReqVO.setGlycatedHemoglobin(parseBigDecimal(rowData.get(143))); // 糖化血红蛋白
//            controlExamBiochemicalTestsSaveReqVO.setPotassium(parseBigDecimal(rowData.get(144))); // 钾
//            controlExamBiochemicalTestsSaveReqVO.setSodium(parseBigDecimal(rowData.get(145))); // 钠
//            controlExamBiochemicalTestsSaveReqVO.setChloride(parseBigDecimal(rowData.get(146))); // 氯
//            controlExamBiochemicalTestsSaveReqVO.setCalcium(parseBigDecimal(rowData.get(147))); // 钙
//            controlExamBiochemicalTestsSaveReqVO.setPhosphorus(parseBigDecimal(rowData.get(148))); // 磷
//            controlExamBiochemicalTestsSaveReqVO.setMagnesium(parseBigDecimal(rowData.get(149))); // 镁
//            controlExamBiochemicalTestsSaveReqVO.setFastingGlucose(parseBigDecimal(rowData.get(150))); // 葡萄糖空腹
                controlExamBiochemicalTestsSaveReqVO.setProthrombinTime(parseBigDecimal(rowData.get(144))); // 凝血酶原时间
                controlExamBiochemicalTestsSaveReqVO.setProthrombinActivity(parseBigDecimal(rowData.get(145))); // 凝血酶原活动度
                controlExamBiochemicalTestsSaveReqVO.setInr(parseBigDecimal(rowData.get(146))); // 国际标准化比率
                controlExamBiochemicalTestsSaveReqVO.setFibrinogen(parseBigDecimal(rowData.get(147))); // 纤维蛋白原
                controlExamBiochemicalTestsSaveReqVO.setAptt(parseBigDecimal(rowData.get(148))); // 活化部分凝血活酶时间
                controlExamBiochemicalTestsSaveReqVO.setThrombinTime(parseBigDecimal(rowData.get(149))); // 凝血酶时间

                experimentFraminghamSaveReqVO.setPersonId(generatedId);
                experimentFraminghamSaveReqVO.setFraminghamScore(parseInteger(rowData.get(150))); // Framingham评分
                experimentFraminghamSaveReqVO.setFraminghamRisk(parseBigDecimal(rowData.get(151))); // Framingham风险
                experimentFraminghamSaveReqVO.setFraminghamRiskType(rowData.get(152)); // Framingham风险类型

                experimentDiseaseSpectrumSaveReqVO.setPersonId(generatedId);
                experimentDiseaseSpectrumSaveReqVO.setFattyLiver(parseBoolean(rowData.get(153))); // 脂肪肝
                experimentDiseaseSpectrumSaveReqVO.setHepaticCyst(parseBoolean(rowData.get(154))); // 肝囊肿
                experimentDiseaseSpectrumSaveReqVO.setGallbladderPolyp(parseBoolean(rowData.get(155))); // 胆囊息肉
                experimentDiseaseSpectrumSaveReqVO.setGallbladderStone(parseBoolean(rowData.get(156))); // 胆结石
                experimentDiseaseSpectrumSaveReqVO.setHepaticHemangioma(parseBoolean(rowData.get(157))); // 肝血管瘤
                experimentDiseaseSpectrumSaveReqVO.setSplenomegaly(parseBoolean(rowData.get(158))); // 脾肿大
                experimentDiseaseSpectrumSaveReqVO.setChronicGastritis(parseBoolean(rowData.get(159))); // 慢性胃炎
                experimentDiseaseSpectrumSaveReqVO.setIntestinalPolyp(parseBoolean(rowData.get(160))); // 肠息肉
                experimentDiseaseSpectrumSaveReqVO.setAppendicitis(parseBoolean(rowData.get(161))); // 阑尾炎
                experimentDiseaseSpectrumSaveReqVO.setAcutePancreatitis(parseBoolean(rowData.get(162))); // 急性胰腺炎
                experimentDiseaseSpectrumSaveReqVO.setDigestiveUlcer(parseBoolean(rowData.get(163))); // 消化道溃疡
                experimentDiseaseSpectrumSaveReqVO.setDigestiveBleeding(parseBoolean(rowData.get(164))); // 消化道出血
                experimentDiseaseSpectrumSaveReqVO.setHypertension(parseBoolean(rowData.get(165))); // 高血压
                experimentDiseaseSpectrumSaveReqVO.setBradycardia(parseBoolean(rowData.get(166))); // 心动过缓
                experimentDiseaseSpectrumSaveReqVO.setTransientIschemicAttack(parseBoolean(rowData.get(167))); // 短暂性脑缺血发作
                experimentDiseaseSpectrumSaveReqVO.setTachycardia(parseBoolean(rowData.get(168))); // 心动过速
                experimentDiseaseSpectrumSaveReqVO.setCerebralInfarction(parseBoolean(rowData.get(169))); // 脑梗死
                experimentDiseaseSpectrumSaveReqVO.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(170))); // 频发房性早搏
                experimentDiseaseSpectrumSaveReqVO.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(171))); // 频发室性早搏
                experimentDiseaseSpectrumSaveReqVO.setCoronaryHeartDisease(parseBoolean(rowData.get(172))); // 冠心病
                experimentDiseaseSpectrumSaveReqVO.setAtrialFibrillation(parseBoolean(rowData.get(173))); // 房颤
                experimentDiseaseSpectrumSaveReqVO.setMyocardialInfarction(parseBoolean(rowData.get(174))); // 心肌梗死
                experimentDiseaseSpectrumSaveReqVO.setHypertriglyceridemia(parseBoolean(rowData.get(175))); // 高甘油三酯血症
                experimentDiseaseSpectrumSaveReqVO.setHighLdl(parseBoolean(rowData.get(176))); // 高LDL
                experimentDiseaseSpectrumSaveReqVO.setHighHdl(parseBoolean(rowData.get(177))); // 高HDL
                experimentDiseaseSpectrumSaveReqVO.setHyperuricemia(parseBoolean(rowData.get(178))); // 高尿酸血症
                experimentDiseaseSpectrumSaveReqVO.setHypercholesterolemia(parseBoolean(rowData.get(179))); // 高胆固醇血症
                experimentDiseaseSpectrumSaveReqVO.setDiabetes(parseBoolean(rowData.get(180))); // 糖尿病
                experimentDiseaseSpectrumSaveReqVO.setThyroidDisease(parseBoolean(rowData.get(181))); // 甲状腺疾病
                experimentDiseaseSpectrumSaveReqVO.setLungNodule(parseBoolean(rowData.get(182))); // 肺结节
                experimentDiseaseSpectrumSaveReqVO.setPulmonaryEmphysema(parseBoolean(rowData.get(183))); // 肺气肿
                experimentDiseaseSpectrumSaveReqVO.setCopd(parseBoolean(rowData.get(184))); // 慢性阻塞性肺病
                experimentDiseaseSpectrumSaveReqVO.setAsthma(parseBoolean(rowData.get(185))); // 哮喘
                experimentDiseaseSpectrumSaveReqVO.setKidneyStone(parseBoolean(rowData.get(186))); // 肾结石
                experimentDiseaseSpectrumSaveReqVO.setRenalCyst(parseBoolean(rowData.get(187))); // 肾囊肿
                experimentDiseaseSpectrumSaveReqVO.setProstatitis(parseBoolean(rowData.get(188))); // 前列腺炎
                experimentDiseaseSpectrumSaveReqVO.setLumbarSpondylosis(parseBoolean(rowData.get(189))); // 腰椎病
                experimentDiseaseSpectrumSaveReqVO.setCervicalSpondylosis(parseBoolean(rowData.get(190))); // 颈椎病
                experimentDiseaseSpectrumSaveReqVO.setInsomnia(parseBoolean(rowData.get(191))); // 失眠

                //            实验组流调-服役信息
//            experimentSurveyServiceInfo.setHighlandServiceLocation1(rowData.get(84)); // 高原服役地点 1（第84列）
                experimentSurveyServiceInfo.setAltitude1(Integer.parseInt(rowData.get(192))); // 海拔高度 1（第85列）
                experimentSurveyServiceInfo.setYear1(Double.parseDouble(rowData.get(193))); // 高原服役地点 1 年（第86列）
//            experimentSurveyServiceInfo.setMonth1(Integer.parseInt(rowData.get(87))); // 高原服役地点 1 月（第87列）
//            experimentSurveyServiceInfo.setHighlandServiceLocation2(rowData.get(88)); // 高原服役地点 2（第88列）
                experimentSurveyServiceInfo.setAltitude2(Integer.parseInt(rowData.get(194))); // 海拔高度 2（第89列）
                experimentSurveyServiceInfo.setYear2(Double.parseDouble(rowData.get(195))); // 高原服役地点 2 年（第90列）
//            experimentSurveyServiceInfo.setMonth2(Integer.parseInt(rowData.get(91))); // 高原服役地点 2 月（第91列）
//            experimentSurveyServiceInfo.setHighlandServiceLocation3(rowData.get(92)); // 高原服役地点 3（第92列）
                experimentSurveyServiceInfo.setAltitude3(Integer.parseInt(rowData.get(196))); // 海拔高度 3（第93列）
                experimentSurveyServiceInfo.setYear3(Double.parseDouble(rowData.get(197))); // 高原服役地点 3 年（第94列）
//            experimentSurveyServiceInfo.setMonth3(Integer.parseInt(rowData.get(95))); // 高原服役地点 3 月（第95列）
//            experimentSurveyServiceInfo.setHighlandServiceLocation4(rowData.get(96)); // 高原服役地点 4（第96列）
                experimentSurveyServiceInfo.setAltitude4(Integer.parseInt(rowData.get(198))); // 海拔高度 4（第97列）
                experimentSurveyServiceInfo.setYear4(Double.parseDouble(rowData.get(199))); // 高原服役地点 4 年（第98列）
//            experimentSurveyServiceInfo.setMonth4(Integer.parseInt(rowData.get(99))); // 高原服役地点 4 月（第99列）
//            experimentSurveyServiceInfo.setHighlandServiceLocation5(rowData.get(100)); // 高原服役地点 5（第100列）
                experimentSurveyServiceInfo.setAltitude5(Integer.parseInt(rowData.get(200))); // 海拔高度 5（第101列）
                experimentSurveyServiceInfo.setYear5(Double.parseDouble(rowData.get(201))); // 高原服役地点 5 年（第102列）
//            experimentSurveyServiceInfo.setMonth5(Integer.parseInt(rowData.get(103))); // 高原服役地点 5 月（第103列）
//            experimentSurveyServiceInfo.setHighlandServiceLocation6(rowData.get(104)); // 高原服役地点 6（第104列）
                experimentSurveyServiceInfo.setAltitude6(Integer.parseInt(rowData.get(202))); // 海拔高度 6（第105列）
                experimentSurveyServiceInfo.setYear6(Double.parseDouble(rowData.get(203))); // 高原服役地点 6 年（第106列）
//            experimentSurveyServiceInfo.setMonth6(Integer.parseInt(rowData.get(107))); // 高原服役地点 6 月（第107列）
                experimentSurveyServiceInfo.setPlateauTotalDuration(Double.parseDouble(rowData.get(204))); // 高原总时长（第108列）
                experimentSurveyServiceInfo.setMaxAltitude(Integer.parseInt(rowData.get(205))); // 最长时间海拔（第109列）
                experimentSurveyServiceInfo.setMaxAltitudeDuration(Double.parseDouble(rowData.get(206))); // 最长时间海拔时间（第110列）
                experimentSurveyServiceInfo.setAltitudeCategory(rowData.get(207)); // 海拔分类（第111列）
                experimentSurveyServiceInfo.setHighestAltitude(Integer.parseInt(rowData.get(208))); // 最高海拔（第112列）// )

//            实验组流调-亲属既往疾病
//            experimentSurveyFamilyDiseases.setPersonId(generatedId);
//            experimentSurveyFamilyDiseases.setHypertension(parseBoolean(rowData.get(35))); // 高血压（第35列）
//            experimentSurveyFamilyDiseases.setHyperlipidemia(parseBoolean(rowData.get(36))); // 高血脂（第36列）
//            experimentSurveyFamilyDiseases.setCongenitalHeartDisease(parseBoolean(rowData.get(37))); // 先天性心脏病（第37列）
//            experimentSurveyFamilyDiseases.setPulmonaryHeartDisease(parseBoolean(rowData.get(38))); // 肺心病（第38列）
//            experimentSurveyFamilyDiseases.setStroke(parseBoolean(rowData.get(39))); // 中风/脑溢血（第39列）
//            experimentSurveyFamilyDiseases.setCoronaryHeartDisease(parseBoolean(rowData.get(40))); // 冠心病/心绞痛（第40列）
//            experimentSurveyFamilyDiseases.setMyocardialInfarction(parseBoolean(rowData.get(41))); // 心肌梗塞（第41列）
//            experimentSurveyFamilyDiseases.setBradycardia(parseBoolean(rowData.get(42))); // 窦性心动过缓（第42列）
//            experimentSurveyFamilyDiseases.setTachycardia(parseBoolean(rowData.get(43))); // 窦性心动过速（第43列）
//            experimentSurveyFamilyDiseases.setArrhythmia(parseBoolean(rowData.get(44))); // 窦性心律不齐（第44列）
//            experimentSurveyFamilyDiseases.setAtrialFibrillation(parseBoolean(rowData.get(45))); // 房颤（第45列）
//            experimentSurveyFamilyDiseases.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(46))); // 阵发性室上速（第46列）
//            experimentSurveyFamilyDiseases.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(47))); // 频发房性早搏（第47列）
//            experimentSurveyFamilyDiseases.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(48))); // 频发室性早搏（第48列）
//            experimentSurveyFamilyDiseases.setAvBlock(parseBoolean(rowData.get(49))); // 房室传导阻滞（第49列）
//            experimentSurveyFamilyDiseases.setVentricularTachycardia(parseBoolean(rowData.get(50))); // 室性心动过速（第50列）
//            experimentSurveyFamilyDiseases.setOtherDiseases1(parseBoolean(rowData.get(51))); // 其他 1（第51列）
//            experimentSurveyFamilyDiseases.setChronicBronchitis(parseBoolean(rowData.get(52))); // 慢性支气管炎（第52列）
//            experimentSurveyFamilyDiseases.setAsthma(parseBoolean(rowData.get(53))); // 哮喘（第53列）
//            experimentSurveyFamilyDiseases.setTuberculosis(parseBoolean(rowData.get(54))); // 肺结核（第54列）
//            experimentSurveyFamilyDiseases.setEmphysema(parseBoolean(rowData.get(55))); // 肺气肿（第55列）
//            experimentSurveyFamilyDiseases.setPneumonia(parseBoolean(rowData.get(56))); // 肺炎（第56列）
//            experimentSurveyFamilyDiseases.setCopd(parseBoolean(rowData.get(57))); // 慢性阻塞性肺疾病（第57列）
//            experimentSurveyFamilyDiseases.setOtherDiseases2(parseBoolean(rowData.get(58))); // 其他 2（第58列）
//            experimentSurveyFamilyDiseases.setThyroidDisease(parseBoolean(rowData.get(59))); // 甲状腺疾病（第59列）
//            experimentSurveyFamilyDiseases.setDiabetes(parseBoolean(rowData.get(60))); // 糖尿病（第60列）
//            experimentSurveyFamilyDiseases.setGout(parseBoolean(rowData.get(61))); // 高尿酸血症（痛风）（第61列）
//            experimentSurveyFamilyDiseases.setChronicGastroenteritis(parseBoolean(rowData.get(62))); // 慢性肠胃炎（第62列）
//            experimentSurveyFamilyDiseases.setDuodenalUlcer(parseBoolean(rowData.get(63))); // 十二指肠溃疡（第63列）
//            experimentSurveyFamilyDiseases.setGastricUlcer(parseBoolean(rowData.get(64))); // 胃溃疡（第64列）
//            experimentSurveyFamilyDiseases.setGallstones(parseBoolean(rowData.get(65))); // 胆结石（第65列）
//            experimentSurveyFamilyDiseases.setColonPolyps(parseBoolean(rowData.get(66))); // 结肠息肉（第66列）
//            experimentSurveyFamilyDiseases.setHepatitisB(parseBoolean(rowData.get(67))); // 乙型肝炎（第67列）
//            experimentSurveyFamilyDiseases.setCholecystitis(parseBoolean(rowData.get(68))); // 胆囊炎（第68列）
//            experimentSurveyFamilyDiseases.setOtherDiseases3(parseBoolean(rowData.get(69))); // 其他 3（第69列）
//            experimentSurveyFamilyDiseases.setDementia(parseBoolean(rowData.get(70))); // 老年痴呆（第70列）
//            experimentSurveyFamilyDiseases.setParkinsonsDisease(parseBoolean(rowData.get(71))); // 帕金森综合征（第71列）
//            experimentSurveyFamilyDiseases.setMultipleSclerosis(parseBoolean(rowData.get(72))); // 多发性硬化病（第72列）
//            experimentSurveyFamilyDiseases.setEpilepsy(parseBoolean(rowData.get(73))); // 癫痫（第73列）
//            experimentSurveyFamilyDiseases.setLungCancer(parseBoolean(rowData.get(74))); // 肺癌（第74列）
//            experimentSurveyFamilyDiseases.setLiverCancer(parseBoolean(rowData.get(75))); // 肝癌（第75列）
//            experimentSurveyFamilyDiseases.setGastricCancer(parseBoolean(rowData.get(76))); // 胃癌（第76列）
//            experimentSurveyFamilyDiseases.setColonCancer(parseBoolean(rowData.get(77))); // 直/结肠癌（第77列）
//            experimentSurveyFamilyDiseases.setPancreaticCancer(parseBoolean(rowData.get(78))); // 胰腺癌（第78列）
//            experimentSurveyFamilyDiseases.setEsophagealCancer(parseBoolean(rowData.get(79))); // 食管癌（第79列）
//            experimentSurveyFamilyDiseases.setProstateCancer(parseBoolean(rowData.get(80))); // 前列腺癌（第80列）
//            experimentSurveyFamilyDiseases.setBreastCancer(parseBoolean(rowData.get(81))); // 乳腺癌（第81列）
//            experimentSurveyFamilyDiseases.setCervicalCancer(parseBoolean(rowData.get(82))); // 宫颈癌（第82列）
//            experimentSurveyFamilyDiseases.setOtherDiseases4(parseBoolean(rowData.get(83))); // 其他 4（第83列）

//            实验组流调-高原期间出现的疾病
//            experimentSurveyHighlandDiseasesDuringService.setPersonId(generatedId);
//            experimentSurveyHighlandDiseasesDuringService.setHypertension(parseBoolean(rowData.get(175))); // 高血压 1（第175列）
//            experimentSurveyHighlandDiseasesDuringService.setMyocardialInfarction(parseBoolean(rowData.get(176))); // 心肌梗死 1（第176列）
//            experimentSurveyHighlandDiseasesDuringService.setCoronaryHeartDisease(parseBoolean(rowData.get(177))); // 冠心病 1（第177列）
//            experimentSurveyHighlandDiseasesDuringService.setPulmonaryHeartDisease(parseBoolean(rowData.get(178))); // 肺心病 1（第178列）
//            experimentSurveyHighlandDiseasesDuringService.setLowerExtremityVenousThrombosis(parseBoolean(rowData.get(179))); // 四肢静脉血栓 1（第179列）
//            experimentSurveyHighlandDiseasesDuringService.setBradycardia(parseBoolean(rowData.get(180))); // 窦性心动过缓 1（第180列）
//            experimentSurveyHighlandDiseasesDuringService.setTachycardia(parseBoolean(rowData.get(181))); // 窦性心动过速 1（第181列）
//            experimentSurveyHighlandDiseasesDuringService.setArrhythmia(parseBoolean(rowData.get(182))); // 窦性心律不齐 1（第182列）
//            experimentSurveyHighlandDiseasesDuringService.setAtrialFibrillation(parseBoolean(rowData.get(183))); // 房颤 1（第183列）
//            experimentSurveyHighlandDiseasesDuringService.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(184))); // 阵发性室上速 1（第184列）
//            experimentSurveyHighlandDiseasesDuringService.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(185))); // 频发房性早搏 1（第185列）
//            experimentSurveyHighlandDiseasesDuringService.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(186))); // 频发室性早搏 1（第186列）
//            experimentSurveyHighlandDiseasesDuringService.setAvBlock(parseBoolean(rowData.get(187))); // 房室传导阻滞 1（第187列）
//            experimentSurveyHighlandDiseasesDuringService.setVentricularTachycardia(parseBoolean(rowData.get(188))); // 室性心动过速 1（第188列）
//            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases1(parseBoolean(rowData.get(189))); // 其他 1 1（第189列）
//            experimentSurveyHighlandDiseasesDuringService.setDizziness(parseBoolean(rowData.get(190))); // 眩晕 1（第190列）
//            experimentSurveyHighlandDiseasesDuringService.setTransientIschemicAttack(parseBoolean(rowData.get(191))); // 短暂性脑缺血 1（第191列）
//            experimentSurveyHighlandDiseasesDuringService.setCerebralInfarction(parseBoolean(rowData.get(192))); // 脑梗死/脑血栓 1（第192列）
//            experimentSurveyHighlandDiseasesDuringService.setCerebralHemorrhage(parseBoolean(rowData.get(193))); // 脑出血 1（第193列）
//            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases2(parseBoolean(rowData.get(194))); // 其他 1 2（第194列）
//            experimentSurveyHighlandDiseasesDuringService.setHyperlipidemia(parseBoolean(rowData.get(195))); // 高血脂 1（第195列）
//            experimentSurveyHighlandDiseasesDuringService.setDiabetes(parseBoolean(rowData.get(196))); // 糖尿病 1（第196列）
//            experimentSurveyHighlandDiseasesDuringService.setGout(parseBoolean(rowData.get(197))); // 高尿酸血症（痛风） 1（第197列）
//            experimentSurveyHighlandDiseasesDuringService.setThyroidDisease(parseBoolean(rowData.get(198))); // 甲状腺疾病 1（第198列）
//            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases3(parseBoolean(rowData.get(199))); // 其他 1 3（第199列）
//            experimentSurveyHighlandDiseasesDuringService.setInsomnia(parseBoolean(rowData.get(200))); // 失眠 1（第200列）
//            experimentSurveyHighlandDiseasesDuringService.setTumor(parseBoolean(rowData.get(201))); // 肿瘤 1（第201列）
//            experimentSurveyHighlandDiseasesDuringService.setOtherDiseases4(parseBoolean(rowData.get(202))); // 其他 1 4（第202列）

//            实验组流调-新发的疾病
//            experimentSurveyNewDiseases.setPersonId(generatedId);
//            experimentSurveyNewDiseases.setNewDisease1Name(rowData.get(231)); // 新发疾病 1 名称（第231列）
//            experimentSurveyNewDiseases.setDiagnosed(parseBoolean(rowData.get(232))); // 该病是否在二级或二级以上医院被诊断（第232列）
//            experimentSurveyNewDiseases.setDiagnosisDate(rowData.get(233)); // 该病的诊断时间（第233列）
//            experimentSurveyNewDiseases.setHospitalized(parseBoolean(rowData.get(234))); // 是否因该病住院治疗（第234列）
//            experimentSurveyNewDiseases.setMedication(parseBoolean(rowData.get(235))); // 是否使用药物进行治疗（第235列）
//            experimentSurveyNewDiseases.setMedicationEffect(rowData.get(236)); // 药物，治疗效果（第236列）
//
//            experimentSurveyNewDiseases.setNewDisease2Name(rowData.get(237)); // 新发疾病 2 名称（第237列）
//            experimentSurveyNewDiseases.setDiagnosed2(parseBoolean(rowData.get(238))); // 该病是否在二级或二级以上医院被诊断（第238列）
//            experimentSurveyNewDiseases.setDiagnosisDate2(rowData.get(239)); // 该病的诊断时间（第239列）
//            experimentSurveyNewDiseases.setHospitalized2(parseBoolean(rowData.get(240))); // 是否因该病住院治疗（第240列）
//            experimentSurveyNewDiseases.setMedication2(parseBoolean(rowData.get(241))); // 是否使用药物进行治疗（第241列）
//            experimentSurveyNewDiseases.setMedicationEffect2(rowData.get(242)); // 药物，治疗效果（第242列）
//
//            experimentSurveyNewDiseases.setNewDisease3Name(rowData.get(243)); // 新发疾病 3 名称（第243列）
//            experimentSurveyNewDiseases.setDiagnosed3(parseBoolean(rowData.get(244))); // 该病是否在二级或二级以上医院被诊断（第244列）
//            experimentSurveyNewDiseases.setDiagnosisDate3(rowData.get(245)); // 该病的诊断时间（第245列）
//            experimentSurveyNewDiseases.setHospitalized3(parseBoolean(rowData.get(246))); // 是否因该病住院治疗（第246列）
//            experimentSurveyNewDiseases.setMedication3(parseBoolean(rowData.get(247))); // 是否使用药物进行治疗（第247列）
//            experimentSurveyNewDiseases.setMedicationEffect3(rowData.get(248)); // 药物，治疗效果（第248列）
//
//            experimentSurveyNewDiseases.setNewDisease4Name(rowData.get(249)); // 新发疾病 4 名称（第249列）
//            experimentSurveyNewDiseases.setDiagnosed4(parseBoolean(rowData.get(250))); // 该病是否在二级或二级以上医院被诊断（第250列）
//            experimentSurveyNewDiseases.setDiagnosisDate4(rowData.get(251)); // 该病的诊断时间（第251列）
//            experimentSurveyNewDiseases.setHospitalized4(parseBoolean(rowData.get(252))); // 是否因该病住院治疗（第252列）
//            experimentSurveyNewDiseases.setMedication4(parseBoolean(rowData.get(253))); // 是否使用药物进行治疗（第253列）
//            experimentSurveyNewDiseases.setMedicationEffect4(rowData.get(254)); // 药物，治疗效果（第254列）

//            实验组流调-返回平原后新发的疾病
//            experimentSurveyNewDiseasesPostReturn.setPersonId(generatedId);
//            experimentSurveyNewDiseasesPostReturn.setHypertension(parseBoolean(rowData.get(203))); // 高血压 2（第203列）
//            experimentSurveyNewDiseasesPostReturn.setMyocardialInfarction(parseBoolean(rowData.get(204))); // 心肌梗死 2（第204列）
//            experimentSurveyNewDiseasesPostReturn.setCoronaryHeartDisease(parseBoolean(rowData.get(205))); // 冠心病 2（第205列）
//            experimentSurveyNewDiseasesPostReturn.setPulmonaryHeartDisease(parseBoolean(rowData.get(206))); // 肺心病 2（第206列）
//            experimentSurveyNewDiseasesPostReturn.setLowerExtremityVenousThrombosis(parseBoolean(rowData.get(207))); // 四肢静脉血栓 2（第207列）
//            experimentSurveyNewDiseasesPostReturn.setBradycardia(parseBoolean(rowData.get(208))); // 窦性心动过缓 2（第208列）
//            experimentSurveyNewDiseasesPostReturn.setTachycardia(parseBoolean(rowData.get(209))); // 窦性心动过速 2（第209列）
//            experimentSurveyNewDiseasesPostReturn.setArrhythmia(parseBoolean(rowData.get(210))); // 窦性心律不齐 2（第210列）
//            experimentSurveyNewDiseasesPostReturn.setAtrialFibrillation(parseBoolean(rowData.get(211))); // 房颤 2（第211列）
//            experimentSurveyNewDiseasesPostReturn.setParoxysmalAuricularTachycardia(parseBoolean(rowData.get(212))); // 阵发性室上速 2（第212列）
//            experimentSurveyNewDiseasesPostReturn.setFrequentPrematureAtrialContractions(parseBoolean(rowData.get(213))); // 频发房性早搏 2（第213列）
//            experimentSurveyNewDiseasesPostReturn.setFrequentPrematureVentricularContractions(parseBoolean(rowData.get(214))); // 频发室性早搏 2（第214列）
//            experimentSurveyNewDiseasesPostReturn.setAvBlock(parseBoolean(rowData.get(215))); // 房室传导阻滞 2（第215列）
//            experimentSurveyNewDiseasesPostReturn.setVentricularTachycardia(parseBoolean(rowData.get(216))); // 室性心动过速 2（第216列）
//            experimentSurveyNewDiseasesPostReturn.setOtherDiseases1(parseBoolean(rowData.get(217))); // 其他 2 1（第217列）
//            experimentSurveyNewDiseasesPostReturn.setDizziness(parseBoolean(rowData.get(218))); // 眩晕 2（第218列）
//            experimentSurveyNewDiseasesPostReturn.setTransientIschemicAttack(parseBoolean(rowData.get(219))); // 短暂性脑缺血 2（第219列）
//            experimentSurveyNewDiseasesPostReturn.setCerebralInfarction(parseBoolean(rowData.get(220))); // 脑梗死/脑血栓 2（第220列）
//            experimentSurveyNewDiseasesPostReturn.setCerebralHemorrhage(parseBoolean(rowData.get(221))); // 脑出血 2（第221列）
//            experimentSurveyNewDiseasesPostReturn.setOtherDiseases2(parseBoolean(rowData.get(222))); // 其他 2 2（第222列）
//            experimentSurveyNewDiseasesPostReturn.setHyperlipidemia(parseBoolean(rowData.get(223))); // 高血脂 2（第223列）
//            experimentSurveyNewDiseasesPostReturn.setDiabetes(parseBoolean(rowData.get(224))); // 糖尿病 2（第224列）
//            experimentSurveyNewDiseasesPostReturn.setGout(parseBoolean(rowData.get(225))); // 高尿酸血症（痛风） 2（第225列）
//            experimentSurveyNewDiseasesPostReturn.setThyroidDisease(parseBoolean(rowData.get(226))); // 甲状腺疾病 2（第226列）
//            experimentSurveyNewDiseasesPostReturn.setOtherDiseases3(parseBoolean(rowData.get(227))); // 其他 2 3（第227列）
//            experimentSurveyNewDiseasesPostReturn.setInsomnia(parseBoolean(rowData.get(228))); // 失眠 2（第228列）
//            experimentSurveyNewDiseasesPostReturn.setTumor(parseBoolean(rowData.get(229))); // 肿瘤 2（第229列）
//            experimentSurveyNewDiseasesPostReturn.setOtherDiseases4(parseBoolean(rowData.get(230))); // 其他 2 4（第230列）

//            controlExamAbdominalUltrasoundSaveReqVO.setPersonId(generatedId);
//            controlExamAbdominalUltrasoundSaveReqVO.setUltrasoundDescription(rowData.get(68)); // 超声描述（第68列）
//            controlExamAbdominalUltrasoundSaveReqVO.setUltrasoundSummary(rowData.get(69)); // 超声总结（第69列）

//            controlExamEcgSaveReqVO.setPersonId(generatedId);
//            controlExamEcgSaveReqVO.setEcgDescription(rowData.get(67)); // 心电图描述（第67列）

//            controlExamPastMedicalHistorySaveReqVO.setPersonId(generatedId);
//            controlExamPastMedicalHistorySaveReqVO.setInternalDiseaseHistory(rowData.get(12)); // 内科疾病史（第12列）
//            controlExamPastMedicalHistorySaveReqVO.setExternalDiseaseHistory(rowData.get(13)); // 外科疾病史（第13列）

                // 保存 BasicOtherInfoRespVO 到数据库
                basicOtherInfoService.updateBasicOtherInfoByPersonId(basicOtherInfo);
                experimentSurveyDietService.updateExperimentSurveyDietByPersonId(experimentSurveyDiet);
                experimentSurveyDrinkingService.updateExperimentSurveyDrinkingByPersonId(experimentSurveyDrinking);
                experimentSurveyExerciseService.updateExperimentSurveyExerciseByPersonId(experimentSurveyExercise);
//            experimentSurveyFamilyDiseasesService.updateExperimentSurveyFamilyDiseasesByPersonId(experimentSurveyFamilyDiseases);
                experimentSurveyHighlandDiseasesService.updateExperimentSurveyHighlandDiseasesByPersonId(experimentSurveyHighlandDiseases);
//            experimentSurveyHighlandDiseasesDuringServiceService.updateExperimentSurveyHighlandDiseasesDuringServiceByPersonId(experimentSurveyHighlandDiseasesDuringService);
                experimentSurveyHighlandReactionService.updateExperimentSurveyHighlandReactionByPersonId(experimentSurveyHighlandReaction);
                experimentSurveyHighlandReactionSymptomsService.updateExperimentSurveyHighlandReactionSymptomsByPersonId(experimentSurveyHighlandReactionSymptoms);
//            experimentSurveyNewDiseasesService.updateExperimentSurveyNewDiseasesByPersonId(experimentSurveyNewDiseases);
//            experimentSurveyNewDiseasesPostReturnService.updateExperimentSurveyNewDiseasesPostReturnByPersonId(experimentSurveyNewDiseasesPostReturn);
                experimentSurveyPostReturnInfoService.updateExperimentSurveyPostReturnInfoByPersonId(experimentSurveyPostReturnInfo);
                experimentSurveyPostReturnSymptomsService.updateExperimentSurveyPostReturnSymptomsByPersonId(experimentSurveyPostReturnSymptoms);
                experimentSurveySelfAssessmentService.updateExperimentSurveySelfAssessmentByPersonId(experimentSurveySelfAssessment);
                experimentSurveyServiceInfoService.updateExperimentSurveyServiceInfoByPersonId(experimentSurveyServiceInfo);
                experimentSurveySleepService.updateExperimentSurveySleepByPersonId(experimentSurveySleep);
                experimentSurveySmokingService.updateExperimentSurveySmokingByPersonId(experimentSurveySmoking);
//            controlExamAbdominalUltrasoundService.updateControlExamAbdominalUltrasoundByPersonId(controlExamAbdominalUltrasoundSaveReqVO);
                controlExamBasicTestsService.updateControlExamBasicTestsByPersonId(controlExamBasicTestsSaveReqVO);
                controlExamBiochemicalTestsService.updateControlExamBiochemicalTestsByPersonId(controlExamBiochemicalTestsSaveReqVO);
                controlExamBloodRoutineService.updateControlExamBloodRoutineByPersonId(controlExamBloodRoutineSaveReqVO);
//            controlExamEcgService.updateControlExamEcgByPersonId(controlExamEcgSaveReqVO);
//            controlExamPastMedicalHistoryService.updateControlExamPastMedicalHistoryByPersonId(controlExamPastMedicalHistorySaveReqVO);
                experimentFraminghamService.updateExperimentFraminghamByPersonId(experimentFraminghamSaveReqVO);
                experimentDiseaseSpectrumService.updateExperimentDiseaseSpectrumByPersonId(experimentDiseaseSpectrumSaveReqVO);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("所有数据读取完成。");
        }
    }

}