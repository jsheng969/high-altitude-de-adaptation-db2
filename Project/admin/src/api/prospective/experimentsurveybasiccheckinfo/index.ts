import request from '@/config/axios'

// 基本检测信息 VO
export interface ExperimentSurveyBasicCheckInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  systolicBloodPressure: string // 收缩压
  diastolicBloodPressure: string // 舒张压
  oxygenSaturation: string // 氧饱和度
  heartRate: string // 心率
  basicHeight: string // 基本身高
  basicWeight: string // 基本体重
  surveyHeight: string // 调查身高
  surveyWeight: string // 调查体重
  timePoint: number // 时相
}

// 基本检测信息 API
export const ExperimentSurveyBasicCheckInfoApi = {
  // 查询基本检测信息分页
  getExperimentSurveyBasicCheckInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-basic-check-info/page`, params })
  },

  // 查询基本检测信息详情
  getExperimentSurveyBasicCheckInfo: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-basic-check-info/get?id=` + id })
  },

  // 新增基本检测信息
  createExperimentSurveyBasicCheckInfo: async (data: ExperimentSurveyBasicCheckInfoVO) => {
    return await request.post({ url: `/prospective/experiment-survey-basic-check-info/create`, data })
  },

  // 修改基本检测信息
  updateExperimentSurveyBasicCheckInfo: async (data: ExperimentSurveyBasicCheckInfoVO) => {
    return await request.put({ url: `/prospective/experiment-survey-basic-check-info/update`, data })
  },

  // 删除基本检测信息
  deleteExperimentSurveyBasicCheckInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-basic-check-info/delete?id=` + id })
  },

  // 导出基本检测信息 Excel
  exportExperimentSurveyBasicCheckInfo: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-basic-check-info/export-excel`, params })
  },
}