import request from '@/config/axios'

// 对照组流调-驻训信息 VO
export interface ControlSurveyStationTrainingInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  missionPointAltitude: number // 任务点海拔
  location: string // 地点
  plateauTrainingCount: number // 高原驻训次数
  plateauTrainingDuration: number // 高原驻训总时长
  missionType: string // 任务从事类型
  dailyWorkHours: number // 每日工作时间
  timePoint: number // 时相
  servicePosition: string // 服役期间职务
}

// 对照组流调-驻训信息 API
export const ControlSurveyStationTrainingInfoApi = {
  // 查询对照组流调-驻训信息分页
  getControlSurveyStationTrainingInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-survey-station-training-info/page`, params })
  },

  // 查询对照组流调-驻训信息详情
  getControlSurveyStationTrainingInfo: async (id: number) => {
    return await request.get({ url: `/prospective/control-survey-station-training-info/get?id=` + id })
  },

  // 新增对照组流调-驻训信息
  createControlSurveyStationTrainingInfo: async (data: ControlSurveyStationTrainingInfoVO) => {
    return await request.post({ url: `/prospective/control-survey-station-training-info/create`, data })
  },

  // 修改对照组流调-驻训信息
  updateControlSurveyStationTrainingInfo: async (data: ControlSurveyStationTrainingInfoVO) => {
    return await request.put({ url: `/prospective/control-survey-station-training-info/update`, data })
  },

  // 删除对照组流调-驻训信息
  deleteControlSurveyStationTrainingInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/control-survey-station-training-info/delete?id=` + id })
  },

  // 导出对照组流调-驻训信息 Excel
  exportControlSurveyStationTrainingInfo: async (params) => {
    return await request.download({ url: `/prospective/control-survey-station-training-info/export-excel`, params })
  }
}