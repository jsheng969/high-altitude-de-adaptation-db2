import request from '@/config/axios'

// 自我评价 VO
export interface ExperimentSurveySelfAssessmentVO {
  id: number // 主键ID
  personId: number // 基础信息id
  healthComparisonWithPeers: string // 与同龄人相比，您认为目前自己的身体健康状况如何
  healthScore: string // 您认为自己身体健康状况能得的分数
  timePoint: number // 时相
}

// 自我评价 API
export const ExperimentSurveySelfAssessmentApi = {
  // 查询自我评价分页
  getExperimentSurveySelfAssessmentPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-self-assessment/page`, params })
  },

  // 查询自我评价详情
  getExperimentSurveySelfAssessment: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-self-assessment/get?id=` + id })
  },

  // 新增自我评价
  createExperimentSurveySelfAssessment: async (data: ExperimentSurveySelfAssessmentVO) => {
    return await request.post({ url: `/prospective/experiment-survey-self-assessment/create`, data })
  },

  // 修改自我评价
  updateExperimentSurveySelfAssessment: async (data: ExperimentSurveySelfAssessmentVO) => {
    return await request.put({ url: `/prospective/experiment-survey-self-assessment/update`, data })
  },

  // 删除自我评价
  deleteExperimentSurveySelfAssessment: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-self-assessment/delete?id=` + id })
  },

  // 导出自我评价 Excel
  exportExperimentSurveySelfAssessment: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-self-assessment/export-excel`, params })
  },
}