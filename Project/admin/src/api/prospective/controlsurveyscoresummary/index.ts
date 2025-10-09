import request from '@/config/axios'

// 对照组流调-评分总数统计 VO
export interface ControlSurveyScoreSummaryVO {
  id: number // 主键ID
  personId: number // 基础信息id
  totalScore: number // 评分总数
  timePoint: number // 时相
}

// 对照组流调-评分总数统计 API
export const ControlSurveyScoreSummaryApi = {
  // 查询对照组流调-评分总数统计分页
  getControlSurveyScoreSummaryPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-survey-score-summary/page`, params })
  },

  // 查询对照组流调-评分总数统计详情
  getControlSurveyScoreSummary: async (id: number) => {
    return await request.get({ url: `/prospective/control-survey-score-summary/get?id=` + id })
  },

  // 新增对照组流调-评分总数统计
  createControlSurveyScoreSummary: async (data: ControlSurveyScoreSummaryVO) => {
    return await request.post({ url: `/prospective/control-survey-score-summary/create`, data })
  },

  // 修改对照组流调-评分总数统计
  updateControlSurveyScoreSummary: async (data: ControlSurveyScoreSummaryVO) => {
    return await request.put({ url: `/prospective/control-survey-score-summary/update`, data })
  },

  // 删除对照组流调-评分总数统计
  deleteControlSurveyScoreSummary: async (id: number) => {
    return await request.delete({ url: `/prospective/control-survey-score-summary/delete?id=` + id })
  },

  // 导出对照组流调-评分总数统计 Excel
  exportControlSurveyScoreSummary: async (params) => {
    return await request.download({ url: `/prospective/control-survey-score-summary/export-excel`, params })
  }
}