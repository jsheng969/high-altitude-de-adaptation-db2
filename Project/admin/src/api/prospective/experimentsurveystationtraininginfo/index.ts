import request from '@/config/axios'

// 驻训信息 VO
export interface ExperimentSurveyStationTrainingInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  missionPointAltitude: string // 任务点海拔
  location: string // 地点
  plateauTrainingCount: number // 高原驻训次数
  plateauTrainingDuration: string // 高原驻训总时长
  missionType: string // 任务从事类型
  dailyWorkHours: string // 每日工作时间
  timePoint: number // 时相
}

// 驻训信息 API
export const ExperimentSurveyStationTrainingInfoApi = {
  // 查询驻训信息分页
  getExperimentSurveyStationTrainingInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-station-training-info/page`, params })
  },

  // 查询驻训信息详情
  getExperimentSurveyStationTrainingInfo: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-station-training-info/get?id=` + id })
  },

  // 新增驻训信息
  createExperimentSurveyStationTrainingInfo: async (data: ExperimentSurveyStationTrainingInfoVO) => {
    return await request.post({ url: `/prospective/experiment-survey-station-training-info/create`, data })
  },

  // 修改驻训信息
  updateExperimentSurveyStationTrainingInfo: async (data: ExperimentSurveyStationTrainingInfoVO) => {
    return await request.put({ url: `/prospective/experiment-survey-station-training-info/update`, data })
  },

  // 删除驻训信息
  deleteExperimentSurveyStationTrainingInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-station-training-info/delete?id=` + id })
  },

  // 导出驻训信息 Excel
  exportExperimentSurveyStationTrainingInfo: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-station-training-info/export-excel`, params })
  },
}