import request from '@/config/axios'

// 对照组流调-推进情况调查 VO
export interface ControlSurveyMissionProgressSurveyVO {
  id: number // 主键ID
  personId: number // 基础信息id
  transportationMode: string // 交通方式
  missionPointAltitude: number // 任务点海拔
  location: string // 地点
  arrivalDate: string // 抵达任务地点日期
  plateauMissionDuration: number // 高原任务持续时间
  travelDuration: string // 推进途中耗费时间
  hasStopover: number // 途中经停
  stopoverLocation: string // 经停地点
  stopoverDuration: string // 经停时间
  hasDiscomfortAfterArrival: number // 抵达任务地后有无不适
  discomfortOccurrenceTime: string // 不适发生时间（抵达后）
  timePoint: number // 时相
  returnPurpose: string // 返回目的
}

// 对照组流调-推进情况调查 API
export const ControlSurveyMissionProgressSurveyApi = {
  // 查询对照组流调-推进情况调查分页
  getControlSurveyMissionProgressSurveyPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-survey-mission-progress-survey/page`, params })
  },

  // 查询对照组流调-推进情况调查详情
  getControlSurveyMissionProgressSurvey: async (id: number) => {
    return await request.get({ url: `/prospective/control-survey-mission-progress-survey/get?id=` + id })
  },

  // 新增对照组流调-推进情况调查
  createControlSurveyMissionProgressSurvey: async (data: ControlSurveyMissionProgressSurveyVO) => {
    return await request.post({ url: `/prospective/control-survey-mission-progress-survey/create`, data })
  },

  // 修改对照组流调-推进情况调查
  updateControlSurveyMissionProgressSurvey: async (data: ControlSurveyMissionProgressSurveyVO) => {
    return await request.put({ url: `/prospective/control-survey-mission-progress-survey/update`, data })
  },

  // 删除对照组流调-推进情况调查
  deleteControlSurveyMissionProgressSurvey: async (id: number) => {
    return await request.delete({ url: `/prospective/control-survey-mission-progress-survey/delete?id=` + id })
  },

  // 导出对照组流调-推进情况调查 Excel
  exportControlSurveyMissionProgressSurvey: async (params) => {
    return await request.download({ url: `/prospective/control-survey-mission-progress-survey/export-excel`, params })
  }
}