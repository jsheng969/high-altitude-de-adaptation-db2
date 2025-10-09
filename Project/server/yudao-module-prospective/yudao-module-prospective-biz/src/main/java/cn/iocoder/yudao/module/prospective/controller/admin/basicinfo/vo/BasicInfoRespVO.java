package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.BasicOtherInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambiochemicaltestsv2.vo.ControlExamBiochemicalTestsV2RespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexambloodroutine.vo.ControlExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.ControlExamCoagulationTestsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.ControlExamOtherDataRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveybasiccheckinfo.vo.ControlSurveyBasicCheckInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveymissionprogresssurvey.vo.ControlSurveyMissionProgressSurveyRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveypostreturnsymptoms.vo.ControlSurveyPostReturnSymptomsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveyscoresummary.vo.ControlSurveyScoreSummaryRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.controlsurveystationtraininginfo.vo.ControlSurveyStationTrainingInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambiochemicaltestsv2.vo.ExperimentExamBiochemicalTestsV2RespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexambloodroutine.vo.ExperimentExamBloodRoutineRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.ExperimentExamCoagulationTestsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.ExperimentExamOtherDataRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyacutemountainsicknessrecords.vo.ExperimentSurveyAcuteMountainSicknessRecordsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveybasiccheckinfo.vo.ExperimentSurveyBasicCheckInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyhighlanddiseasesduringservice.vo.ExperimentSurveyHighlandDiseasesDuringServiceRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymedicalhistory.vo.ExperimentSurveyMedicalHistoryRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveymissionprogresssurvey.vo.ExperimentSurveyMissionProgressSurveyRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateauarrivalsymptoms.vo.ExperimentSurveyPlateauArrivalSymptomsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyplateaufitnessinfo.vo.ExperimentSurveyPlateauFitnessInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveypostreturnsymptoms.vo.ExperimentSurveyPostReturnSymptomsRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyscoresummary.vo.ExperimentSurveyScoreSummaryRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveyselfassessment.vo.ExperimentSurveySelfAssessmentRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveysmokinginfo.vo.ExperimentSurveySmokingInfoRespVO;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentsurveystationtraininginfo.vo.ExperimentSurveyStationTrainingInfoRespVO;
import cn.iocoder.yudao.module.prospective.util.SurveyOrExamConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 基础信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BasicInfoRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13493")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "姓名")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "性别")
    @ExcelProperty("性别")
    private String gender;

    @Schema(description = "出生年月")
    @ExcelProperty("出生年月")
    private String birthDate;

    @Schema(description = "部职别")
    @ExcelProperty("部职别")
    private String position;

    @Schema(description = "证件号")
    @ExcelProperty("证件号")
    private String idNumber;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "编号")
    @ExcelProperty("编号")
    private String code;

    @Schema(description = "类型")
    @ExcelProperty("类型")
    private String type;

    @Schema(description = "组")
    @ExcelProperty("组")
    private String groupType;

    @Schema(description = "年龄")
    @ExcelProperty("年龄")
    private Integer age;

    @Schema(description = "实际年龄")
    @ExcelProperty("实际年龄")
    private Integer actualAge;

    @Schema(description = "时相")
    @ExcelProperty("时相")
    private Integer timePoint;

    @Schema(description = "调查或体检")
    @ExcelProperty(value = "调查或体检", converter = SurveyOrExamConverter.class)
    private String surveyOrExam; // 调查或体检

    @Schema(description = "是否vip")
    @ExcelProperty("是否vip")
    private String isVip; // 是否vip

    private BasicOtherInfoRespVO basicOtherInfoRespVO;
    private ExperimentSurveyAcuteMountainSicknessRecordsRespVO experimentSurveyAcuteMountainSicknessRecordsRespVO;
    private ExperimentSurveyBasicCheckInfoRespVO experimentSurveyBasicCheckInfoRespVO;
    private ExperimentSurveyHighlandDiseasesDuringServiceRespVO experimentSurveyHighlandDiseasesDuringServiceRespVO;
    private ExperimentSurveyStationTrainingInfoRespVO experimentSurveyStationTrainingInfoRespVO;
    private ExperimentSurveyMissionProgressSurveyRespVO experimentSurveyMissionProgressSurveyRespVO;
    private ExperimentSurveyScoreSummaryRespVO experimentSurveyScoreSummaryRespVO;
    private ExperimentSurveyMedicalHistoryRespVO experimentSurveyMedicalHistoryRespVO;
    private ExperimentSurveyPlateauArrivalSymptomsRespVO experimentSurveyPlateauArrivalSymptomsRespVO;
    private ExperimentSurveyPlateauFitnessInfoRespVO experimentSurveyPlateauFitnessInfoRespVO;
    private ExperimentSurveyPostReturnSymptomsRespVO experimentSurveyPostReturnSymptomsRespVO;
    private ExperimentSurveySelfAssessmentRespVO experimentSurveySelfAssessmentRespVO;
    private ExperimentSurveySmokingInfoRespVO experimentSurveySmokingInfoRespVO;

    private ExperimentExamBiochemicalTestsV2RespVO experimentExamBiochemicalTestsV2RespVO;
    private ExperimentExamBloodRoutineRespVO experimentExamBloodRoutineRespVO;
    private ExperimentExamCoagulationTestsRespVO experimentExamCoagulationTestsRespVO;
    private ExperimentExamOtherDataRespVO experimentExamOtherDataRespVO;

    private ControlExamBiochemicalTestsV2RespVO controlExamBiochemicalTestsV2RespVO;
    private ControlExamBloodRoutineRespVO controlExamBloodRoutineRespVO;
    private ControlExamCoagulationTestsRespVO controlExamCoagulationTestsRespVO;
    private ControlExamOtherDataRespVO controlExamOtherDataRespVO;
    private ControlSurveyBasicCheckInfoRespVO controlSurveyBasicCheckInfoRespVO;
    private ControlSurveyMissionProgressSurveyRespVO controlSurveyMissionProgressSurveyRespVO;
    private ControlSurveyPostReturnSymptomsRespVO controlSurveyPostReturnSymptomsRespVO;
    private ControlSurveyScoreSummaryRespVO controlSurveyScoreSummaryRespVO;
    private ControlSurveyStationTrainingInfoRespVO controlSurveyStationTrainingInfoRespVO;

}