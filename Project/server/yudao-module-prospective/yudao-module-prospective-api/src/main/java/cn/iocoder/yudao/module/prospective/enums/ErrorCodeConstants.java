package cn.iocoder.yudao.module.prospective.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode TIME_POINT1_SURVEY_BASIC_INFO_NOT_EXISTS = new ErrorCode(1_001_203_000, "基础信息不存在");
    ErrorCode TIME_POINT1_SURVEY_BASIC_OTHER_INFO_NOT_EXISTS = new ErrorCode(1_001_203_001, "基础其他信息不存在");
    ErrorCode TIME_POINT1_SURVEY_BASIC_CHECK_INFO_NOT_EXISTS = new ErrorCode(1_001_203_002, "基础检查信息不存在");
    ErrorCode TIME_POINT1_SURVEY_STATION_TRAINING_INFO_NOT_EXISTS = new ErrorCode(1_001_203_003, "驻地培训信息不存在");
    ErrorCode TIME_POINT1_SURVEY_SMOKING_INFO_NOT_EXISTS = new ErrorCode(1_001_203_004, "吸烟信息不存在");
    ErrorCode TIME_POINT1_SURVEY_PLATEAU_FITNESS_INFO_NOT_EXISTS = new ErrorCode(1_001_203_005, "高原适应信息不存在");
    ErrorCode TIME_POINT1_SURVEY_MEDICAL_HISTORY_NOT_EXISTS = new ErrorCode(1_001_203_006, "病史信息不存在");
    ErrorCode TIME_POINT1_SURVEY_SELF_ASSESSMENT_NOT_EXISTS = new ErrorCode(1_001_203_007, "自我评估信息不存在");
    ErrorCode TIME_POINT1_SURVEY_MISSION_PROGRESS_SURVEY_NOT_EXISTS = new ErrorCode(1_001_203_008, "任务进度调查信息不存在");
    ErrorCode TIME_POINT1_SURVEY_PLATEAU_ARRIVAL_SYMPTOMS_NOT_EXISTS = new ErrorCode(1_001_203_009, "高原到达症状信息不存在");
    ErrorCode TIME_POINT1_SURVEY_ACUTE_MOUNTAIN_SICKNESS_RECORDS_NOT_EXISTS = new ErrorCode(1_001_203_010, "急性高山病记录不存在");
    ErrorCode TIME_POINT1_SURVEY_HIGHLAND_DISEASES_DURING_SERVICE_NOT_EXISTS = new ErrorCode(1_001_203_011, "服务期间高原疾病信息不存在");
    ErrorCode TIME_POINT1_SURVEY_SCORE_SUMMARY_NOT_EXISTS = new ErrorCode(1_001_203_012, "评分汇总信息不存在");
    ErrorCode EXPERIMENT_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS = new ErrorCode(1_001_203_013, "返回后症状信息不存在");

    ErrorCode EXPERMENT_EXAM_BIOCHEMICAL_TESTS_V2_NOT_EXISTS = new ErrorCode(1_001_203_014, "实验组体检-生化信息不存在");
    ErrorCode EXPERMENT_EXAM_BLOOD_ROUTINE_NOT_EXISTS = new ErrorCode(1_001_203_015, "实验组体检-血常规信息不存在");
    ErrorCode EXPERMENT_EXAM_COAGULATION_TESTS_NOT_EXISTS = new ErrorCode(1_001_203_016, "实验组体检-凝血功能信息不存在");

    ErrorCode EXPERIMENT_EXAM_OTHER_DATA_NOT_EXISTS = new ErrorCode(1_001_203_017, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_SURVEY_MISSION_PROGRESS_SURVEY_NOT_EXISTS = new ErrorCode(1_001_203_018, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS = new ErrorCode(1_001_203_019, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_SURVEY_SCORE_SUMMARY_NOT_EXISTS = new ErrorCode(1_001_203_020, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_SURVEY_STATION_TRAINING_INFO_NOT_EXISTS = new ErrorCode(1_001_203_021, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_SURVEY_BASIC_CHECK_INFO_NOT_EXISTS = new ErrorCode(1_001_203_022, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_EXAM_BLOOD_ROUTINE_NOT_EXISTS = new ErrorCode(1_001_203_023, "实验组体检-其他数据不存在");
    ErrorCode CONTROL_EXAM_BIOCHEMICAL_TESTS_V2_NOT_EXISTS = new ErrorCode(1_001_203_024, "实验组体检-生化信息不存在");
    ErrorCode CONTROL_EXAM_COAGULATION_TESTS_NOT_EXISTS = new ErrorCode(1_001_203_025, "实验组体检-凝血功能信息不存在");
    ErrorCode CONTROL_EXAM_OTHER_DATA_NOT_EXISTS = new ErrorCode(1_001_203_026, "实验组体检-其他数据不存在");

    ErrorCode HISTORY_NOT_EXISTS = new ErrorCode(1_001_203_027, "预警历史记录不存在");
    ErrorCode SAMPLE_NOT_EXISTS = new ErrorCode(1_001_203_028, "生物样本不存在");
    ErrorCode SAMPLE_HISTORY_NOT_EXISTS = new ErrorCode(1_001_203_029, "生物样本库历史记录不存在");
}
