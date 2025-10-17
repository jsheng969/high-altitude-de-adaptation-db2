// 条件显示逻辑工具
export const conditionUtils = {
  // 获取可见条件
  getVisibleConditions(queryParams: any) {
    const { group, timePoint, surveyOrExam } = queryParams
    
    return {
      // 实验组相关条件显示逻辑
      showExperimentGroup: group === 1 || group === 0,
      showExperimentSurvey: (group === 1 || group === 0) && surveyOrExam === 'survey',
      showExperimentExam: (group === 1 || group === 0) && surveyOrExam === 'exam',
      
      // 对照组显示逻辑
      showControlGroup: group === 2 || group === 0,
      
      // 时相点相关显示逻辑
      showTimePoint1: timePoint === 1,
      showTimePointOther: timePoint !== 1 && timePoint != null
    }
  },

  // 获取实验组流调选项
  getExperimentSurveyOptions(timePoint?: number) {
    const { EXPERIMENT_SURVEY_OPTIONS } = FILTER_CONFIG
    return timePoint === 1 ? EXPERIMENT_SURVEY_OPTIONS.timePoint1 : EXPERIMENT_SURVEY_OPTIONS.timePointOther
  }
}