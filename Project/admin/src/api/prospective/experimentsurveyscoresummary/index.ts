import request from '@/config/axios'

// 评分总数统计 VO
export interface ExperimentSurveyScoreSummaryVO {
  id: number // 主键ID
  personId: number // 基础信息id
  totalScore: number // 评分总数
  timePoint: number // 时相
}

// 评分总数统计 API
export const ExperimentSurveyScoreSummaryApi = {
  // 查询评分总数统计分页
  getExperimentSurveyScoreSummaryPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-score-summary/page`, params })
  },

  // 查询评分总数统计详情
  getExperimentSurveyScoreSummary: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-score-summary/get?id=` + id })
  },

  // 新增评分总数统计
  createExperimentSurveyScoreSummary: async (data: ExperimentSurveyScoreSummaryVO) => {
    return await request.post({ url: `/prospective/experiment-survey-score-summary/create`, data })
  },

  // 修改评分总数统计
  updateExperimentSurveyScoreSummary: async (data: ExperimentSurveyScoreSummaryVO) => {
    return await request.put({ url: `/prospective/experiment-survey-score-summary/update`, data })
  },

  // 删除评分总数统计
  deleteExperimentSurveyScoreSummary: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-score-summary/delete?id=` + id })
  },

  // 导出评分总数统计 Excel
  exportExperimentSurveyScoreSummary: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-score-summary/export-excel`, params })
  },
}