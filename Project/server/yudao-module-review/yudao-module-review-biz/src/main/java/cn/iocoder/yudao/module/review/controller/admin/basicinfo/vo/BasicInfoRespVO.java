package cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo;

import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.BasicOtherInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.ControlDiseaseSpectrumRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.ControlExamAbdominalUltrasoundRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.ControlExamBasicTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.ControlExamBiochemicalTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexambloodroutine.vo.ControlExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.ControlExamEcgRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.ControlExamPastMedicalHistoryRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.ControlFraminghamRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.ControlSurveyDrinkingInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveypastdiseases.vo.ControlSurveyPastDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.ControlSurveyResidenceInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyselfassessment.vo.ControlSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.ControlSurveySmokingInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.ExperimentDiseaseSpectrumRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.ExperimentExamAbdominalUltrasoundRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.ExperimentExamBasicTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.ExperimentExamBiochemicalTestsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.ExperimentExamEcgRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.ExperimentExamPastMedicalHistoryRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.ExperimentFraminghamRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.ExperimentSurveyDietRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.ExperimentSurveyDrinkingRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyexercise.vo.ExperimentSurveyExerciseRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyfamilydiseases.vo.ExperimentSurveyFamilyDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseases.vo.ExperimentSurveyHighlandDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreaction.vo.ExperimentSurveyHighlandReactionRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyhighlandreactionsymptoms.vo.ExperimentSurveyHighlandReactionSymptomsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseases.vo.ExperimentSurveyNewDiseasesRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveynewdiseasespostreturn.vo.ExperimentSurveyNewDiseasesPostReturnRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturninfo.vo.ExperimentSurveyPostReturnInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveyserviceinfo.vo.ExperimentSurveyServiceInfoRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysleep.vo.ExperimentSurveySleepRespVO;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveysmoking.vo.ExperimentSurveySmokingRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 基础信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BasicInfoRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17342")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "姓名", example = "李四")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "性别")
    @ExcelProperty("性别")
    private String gender;

    @Schema(description = "最高学历")
    @ExcelProperty("最高学历")
    private String highestEducation;

    @Schema(description = "民族")
    @ExcelProperty("民族")
    private String ethnicity;

    @Schema(description = "婚姻情况", example = "1")
    @ExcelProperty("婚姻情况")
    private String maritalStatus;

    @Schema(description = "身高")
    @ExcelProperty("身高")
    private BigDecimal height;

    @Schema(description = "体重")
    @ExcelProperty("体重")
    private BigDecimal weight;

    @Schema(description = "类型（1.实验组，2.流调组）")
    private Integer type;

    private BasicOtherInfoRespVO basicOtherInfoRespVO; // 基础信息-其他信息

    private ExperimentSurveyHighlandDiseasesRespVO experimentSurveyHighlandDiseasesRespVO; // 实验组流调-高原疾病诊断
    private ExperimentSurveyHighlandDiseasesDuringServiceRespVO experimentSurveyHighlandDiseasesDuringServiceRespVO; // 实验组流调-高原期间出现的疾病
    private ExperimentSurveyHighlandReactionRespVO experimentSurveyHighlandReactionRespVO; // 实验组流调-高原反应信息
    private ExperimentSurveyHighlandReactionSymptomsRespVO experimentSurveyHighlandReactionSymptomsRespVO; // 实验组流调-高原反应症状
    private ExperimentSurveyNewDiseasesRespVO experimentSurveyNewDiseasesRespVO; // 实验组流调-新发疾病
    private ExperimentSurveyNewDiseasesPostReturnRespVO experimentSurveyNewDiseasesPostReturnRespVO; // 实验组流调-返回平原后新发的疾病
    private ExperimentSurveyPostReturnInfoRespVO experimentSurveyPostReturnInfoRespVO; // 实验组流调-返回后基础信息
    private ExperimentSurveyPostReturnSymptomsRespVO experimentSurveyPostReturnSymptomsRespVO; // 实验组流调-退役后返回平原1月内症状
    private ExperimentSurveySelfAssessmentRespVO experimentSurveySelfAssessmentRespVO; // 实验组流调-自我评价
    private ExperimentSurveySleepRespVO experimentSurveySleepRespVO; // 实验组流调-睡眠信息
    private ExperimentSurveySmokingRespVO experimentSurveySmokingRespVO; // 实验组流调-吸烟情况
    private ExperimentSurveyServiceInfoRespVO experimentSurveyServiceInfoRespVO; // 实验组流调-服役信息
    private ExperimentSurveyDietRespVO experimentSurveyDietRespVO; // 实验组流调-饮食习惯
    private ExperimentSurveyDrinkingRespVO experimentSurveyDrinkingRespVO; // 实验组流调-饮酒情况
    private ExperimentSurveyExerciseRespVO experimentSurveyExerciseRespVO; // 实验组流调-体育锻炼信息
    private ExperimentSurveyFamilyDiseasesRespVO experimentSurveyFamilyDiseasesRespVO; // 实验组流调-亲属既往疾病

    private ExperimentExamAbdominalUltrasoundRespVO experimentExamAbdominalUltrasoundRespVO; // 实验组检查-腹部超声检查
    private ExperimentExamBasicTestsRespVO experimentExamBasicTestsRespVO; // 实验组检查-基础检查
    private ExperimentExamBiochemicalTestsRespVO experimentExamBiochemicalTestsRespVO; // 实验组检查-生化检查
    private ExperimentExamBloodRoutineRespVO experimentExamBloodRoutineRespVO; // 实验组检查-血常规检查
    private ExperimentExamEcgRespVO experimentExamEcgRespVO; // 实验组检查-心电图检查
    private ExperimentExamPastMedicalHistoryRespVO experimentExamPastMedicalHistoryRespVO; // 实验组检查-既往病史

    private ControlSurveyDrinkingInfoRespVO controlSurveyDrinkingInfoRespVO; // 对照组流调-饮酒情况
    private ControlSurveyPastDiseasesRespVO controlSurveyPastDiseasesRespVO; // 对照组流调-既往疾病
    private ControlSurveyResidenceInfoRespVO controlSurveyResidenceInfoRespVO; // 对照组流调-居住地信息
    private ControlSurveySelfAssessmentRespVO controlSurveySelfAssessmentRespVO; // 对照组流调-自我评价
    private ControlSurveySmokingInfoRespVO controlSurveySmokingInfoRespVO; // 对照组流调-吸烟情况

    private ControlExamAbdominalUltrasoundRespVO controlExamAbdominalUltrasoundRespVO; // 对照组检查-腹部超声检查
    private ControlExamBasicTestsRespVO controlExamBasicTestsRespVO; // 对照组检查-基础检查
    private ControlExamBiochemicalTestsRespVO controlExamBiochemicalTestsRespVO; // 对照组检查-生化检查
    private ControlExamBloodRoutineRespVO controlExamBloodRoutineRespVO; // 对照组检查-血常规检查
    private ControlExamEcgRespVO controlExamEcgRespVO; // 对照组检查-心电图检查
    private ControlExamPastMedicalHistoryRespVO controlExamPastMedicalHistoryRespVO; // 对照组检查-既往病史

    private ExperimentDiseaseSpectrumRespVO experimentDiseaseSpectrumRespVO; // 实验组流调-疾病谱
    private ControlDiseaseSpectrumRespVO controlDiseaseSpectrumRespVO; // 对照组流调-疾病谱
    private ExperimentFraminghamRespVO experimentFraminghamRespVO; // 实验组流调-framingham评分
    private ControlFraminghamRespVO controlFraminghamRespVO; // 对照组流调-framingham评分
}