import request from '@/config/axios'

// 抵达高原后症状记录 VO
export interface ExperimentSurveyPlateauArrivalSymptomsVO {
  id: number // 主键ID
  personId: number // 基础信息id
  headache: string // 抵达高原后症状.头痛
  headacheDuration: string // 头痛持续时间
  digestiveSymptoms: string // 抵达高原后症状.消化道症状
  digestiveSymptomsDuration: string // 消化道症状持续时间
  fatigue: string // 抵达高原后症状.疲惫和/或乏力
  fatigueDuration: string // 疲惫乏力持续时间
  dizziness: string // 抵达高原后症状.头晕
  dizzinessDuration: string // 头晕持续时间
  impactOnDailyLife: string // 相关症状如何影响您的日常工作及生活
  timePoint: number // 时相
}

// 抵达高原后症状记录 API
export const ExperimentSurveyPlateauArrivalSymptomsApi = {
  // 查询抵达高原后症状记录分页
  getExperimentSurveyPlateauArrivalSymptomsPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/page`, params })
  },

  // 查询抵达高原后症状记录详情
  getExperimentSurveyPlateauArrivalSymptoms: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/get?id=` + id })
  },

  // 新增抵达高原后症状记录
  createExperimentSurveyPlateauArrivalSymptoms: async (data: ExperimentSurveyPlateauArrivalSymptomsVO) => {
    return await request.post({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/create`, data })
  },

  // 修改抵达高原后症状记录
  updateExperimentSurveyPlateauArrivalSymptoms: async (data: ExperimentSurveyPlateauArrivalSymptomsVO) => {
    return await request.put({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/update`, data })
  },

  // 删除抵达高原后症状记录
  deleteExperimentSurveyPlateauArrivalSymptoms: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/delete?id=` + id })
  },

  // 导出抵达高原后症状记录 Excel
  exportExperimentSurveyPlateauArrivalSymptoms: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-plateau-arrival-symptoms/export-excel`, params })
  },
}