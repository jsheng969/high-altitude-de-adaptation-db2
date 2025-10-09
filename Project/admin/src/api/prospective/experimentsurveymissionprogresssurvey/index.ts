import request from '@/config/axios'

// 推进情况调查 VO
export interface ExperimentSurveyMissionProgressSurveyVO {
  id: number // 主键ID
  personId: number // 基础信息id
  transportationMode: string // 交通方式
  missionPointAltitude: string // 任务点海拔
  location: string // 地点
  arrivalDate: Date // 抵达任务地点日期
  plateauMissionDuration: string // 高原任务持续时间
  travelDuration: string // 推进途中耗费时间
  hasStopover: string // 途中经停
  stopoverLocation: string // 经停地点
  stopoverDuration: string // 经停时间
  hasDiscomfortAfterArrival: string // 抵达任务地后有无不适
  discomfortOccurrenceTime: string // 不适发生时间（抵达后）
  timePoint: number // 时相
}

// 推进情况调查 API
export const ExperimentSurveyMissionProgressSurveyApi = {
  // 查询推进情况调查分页
  getExperimentSurveyMissionProgressSurveyPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-mission-progress-survey/page`, params })
  },

  // 查询推进情况调查详情
  getExperimentSurveyMissionProgressSurvey: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-mission-progress-survey/get?id=` + id })
  },

  // 新增推进情况调查
  createExperimentSurveyMissionProgressSurvey: async (data: ExperimentSurveyMissionProgressSurveyVO) => {
    return await request.post({ url: `/prospective/experiment-survey-mission-progress-survey/create`, data })
  },

  // 修改推进情况调查
  updateExperimentSurveyMissionProgressSurvey: async (data: ExperimentSurveyMissionProgressSurveyVO) => {
    return await request.put({ url: `/prospective/experiment-survey-mission-progress-survey/update`, data })
  },

  // 删除推进情况调查
  deleteExperimentSurveyMissionProgressSurvey: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-mission-progress-survey/delete?id=` + id })
  },

  // 导出推进情况调查 Excel
  exportExperimentSurveyMissionProgressSurvey: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-mission-progress-survey/export-excel`, params })
  },
}