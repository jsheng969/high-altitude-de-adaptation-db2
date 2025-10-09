import request from '@/config/axios'

// 对照组流调-基本检测信息 VO
export interface ControlSurveyBasicCheckInfoVO {
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

// 对照组流调-基本检测信息 API
export const ControlSurveyBasicCheckInfoApi = {
  // 查询对照组流调-基本检测信息分页
  getControlSurveyBasicCheckInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-survey-basic-check-info/page`, params })
  },

  // 查询对照组流调-基本检测信息详情
  getControlSurveyBasicCheckInfo: async (id: number) => {
    return await request.get({ url: `/prospective/control-survey-basic-check-info/get?id=` + id })
  },

  // 新增对照组流调-基本检测信息
  createControlSurveyBasicCheckInfo: async (data: ControlSurveyBasicCheckInfoVO) => {
    return await request.post({ url: `/prospective/control-survey-basic-check-info/create`, data })
  },

  // 修改对照组流调-基本检测信息
  updateControlSurveyBasicCheckInfo: async (data: ControlSurveyBasicCheckInfoVO) => {
    return await request.put({ url: `/prospective/control-survey-basic-check-info/update`, data })
  },

  // 删除对照组流调-基本检测信息
  deleteControlSurveyBasicCheckInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/control-survey-basic-check-info/delete?id=` + id })
  },

  // 导出对照组流调-基本检测信息 Excel
  exportControlSurveyBasicCheckInfo: async (params) => {
    return await request.download({ url: `/prospective/control-survey-basic-check-info/export-excel`, params })
  }
}