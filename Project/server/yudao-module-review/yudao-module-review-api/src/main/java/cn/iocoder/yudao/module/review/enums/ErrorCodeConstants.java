package cn.iocoder.yudao.module.review.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    ErrorCode BASIC_INFO_NOT_EXISTS = new ErrorCode(1_001_202_000, "基础信息不存在");
    ErrorCode BASIC_OTHER_INFO_NOT_EXISTS = new ErrorCode(1_001_202_001, "基础其他信息不存在");
    ErrorCode EXPERIMENT_SURVEY_SERVICE_INFO_NOT_EXISTS = new ErrorCode(1_001_202_002, "服役信息不存在");
    ErrorCode EXPERIMENT_SURVEY_SMOKING_NOT_EXISTS = new ErrorCode(1_001_202_003, "吸烟调查信息不存在");
    ErrorCode EXPERIMENT_SURVEY_DRINKING_NOT_EXISTS = new ErrorCode(1_001_202_004, "饮酒调查信息不存在");
    ErrorCode EXPERIMENT_SURVEY_SELF_ASSESSMENT_NOT_EXISTS = new ErrorCode(1_001_202_005, "自评信息不存在");
    ErrorCode EXPERIMENT_SURVEY_FAMILY_DISEASES_NOT_EXISTS = new ErrorCode(1_001_202_006, "家族疾病史信息不存在");
    ErrorCode EXPERIMENT_SURVEY_HIGHLAND_REACTION_NOT_EXISTS = new ErrorCode(1_001_202_007, "高原反应调查信息不存在");
    ErrorCode EXPERIMENT_SURVEY_HIGHLAND_DISEASES_NOT_EXISTS = new ErrorCode(1_001_202_008, "高原病史信息不存在");
    ErrorCode EXPERIMENT_SURVEY_HIGHLAND_REACTION_SYMPTOMS_NOT_EXISTS = new ErrorCode(1_001_202_009, "高原反应症状信息不存在");
    ErrorCode EXPERIMENT_SURVEY_POST_RETURN_SYMPTOMS_NOT_EXISTS = new ErrorCode(1_001_202_010, "回乡后症状信息不存在");
    ErrorCode EXPERIMENT_SURVEY_POST_RETURN_INFO_NOT_EXISTS = new ErrorCode(1_001_202_011, "回乡后情况信息不存在");
    ErrorCode EXPERIMENT_SURVEY_HIGHLAND_DISEASES_DURING_SERVICE_NOT_EXISTS = new ErrorCode(1_001_202_012, "服役期间高原病信息不存在");
    ErrorCode EXPERIMENT_SURVEY_NEW_DISEASES_POST_RETURN_NOT_EXISTS = new ErrorCode(1_001_202_013, "回乡后新发疾病信息不存在");
    ErrorCode EXPERIMENT_SURVEY_NEW_DISEASES_NOT_EXISTS = new ErrorCode(1_001_202_014, "新发疾病信息不存在");
    ErrorCode EXPERIMENT_SURVEY_EXERCISE_NOT_EXISTS = new ErrorCode(1_001_202_015, "锻炼信息不存在");
    ErrorCode EXPERIMENT_SURVEY_DIET_NOT_EXISTS = new ErrorCode(1_001_202_016, "饮食信息不存在");
    ErrorCode EXPERIMENT_SURVEY_SLEEP_NOT_EXISTS = new ErrorCode(1_001_202_017, "睡眠信息不存在");
    ErrorCode CONTROL_SURVEY_SMOKING_INFO_NOT_EXISTS = new ErrorCode(1_001_202_018, "对照组吸烟信息不存在");
    ErrorCode CONTROL_SURVEY_DRINKING_INFO_NOT_EXISTS = new ErrorCode(1_001_202_019, "对照组饮酒信息不存在");
    ErrorCode CONTROL_SURVEY_RESIDENCE_INFO_NOT_EXISTS = new ErrorCode(1_001_202_020, "对照组居住地信息不存在");
    ErrorCode CONTROL_SURVEY_SELF_ASSESSMENT_NOT_EXISTS = new ErrorCode(1_001_202_021, "对照组自评信息不存在");
    ErrorCode CONTROL_SURVEY_PAST_DISEASES_NOT_EXISTS = new ErrorCode(1_001_202_022, "对照组既往疾病信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_BASIC_TESTS_NOT_EXISTS = new ErrorCode(1_001_202_023, "实验组基础检查信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_PAST_MEDICAL_HISTORY_NOT_EXISTS = new ErrorCode(1_001_202_024, "实验组既往病史信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_BLOOD_ROUTINE_NOT_EXISTS = new ErrorCode(1_001_202_025, "实验组血常规信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_BIOCHEMICAL_TESTS_NOT_EXISTS = new ErrorCode(1_001_202_026, "实验组生化检查信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_ECG_NOT_EXISTS = new ErrorCode(1_001_202_027, "实验组心电图信息不存在");
    ErrorCode EXPERIMENTAL_EXAM_ABDOMINAL_ULTRASOUND_NOT_EXISTS = new ErrorCode(1_001_202_028, "实验组腹部彩超信息不存在");
    ErrorCode CONTROL_EXAM_BASIC_TESTS_NOT_EXISTS = new ErrorCode(1_001_202_029, "对照组基础检查信息不存在");
    ErrorCode CONTROL_EXAM_PAST_MEDICAL_HISTORY_NOT_EXISTS = new ErrorCode(1_001_202_030, "对照组既往病史信息不存在");
    ErrorCode CONTROL_EXAM_BLOOD_ROUTINE_NOT_EXISTS = new ErrorCode(1_001_202_031, "对照组血常规信息不存在");
    ErrorCode CONTROL_EXAM_BIOCHEMICAL_TESTS_NOT_EXISTS = new ErrorCode(1_001_202_032, "对照组生化检查信息不存在");
    ErrorCode CONTROL_EXAM_ECG_NOT_EXISTS = new ErrorCode(1_001_202_033, "对照组心电图信息不存在");
    ErrorCode CONTROL_EXAM_ABDOMINAL_ULTRASOUND_NOT_EXISTS = new ErrorCode(1_001_202_034, "对照组腹部彩超信息不存在");

    ErrorCode CONTROL_FRAMINGHAM_NOT_EXISTS = new ErrorCode(1_001_202_035, "对照组framingham评分不存在");
    ErrorCode EXPERIMENT_FRAMINGHAM_NOT_EXISTS = new ErrorCode(1_001_202_036, "实验组framingham评分不存在");
    ErrorCode CONTROL_DISEASE_SPECTRUM_NOT_EXISTS = new ErrorCode(1_001_202_037, "对照组疾病谱不存在");
    ErrorCode EXPERIMENT_DISEASE_SPECTRUM_NOT_EXISTS = new ErrorCode(1_001_202_038, "实验组疾病谱不存在");

}
