import request from '@/config/axios'

// 高原急性高山病记录 VO
export interface ExperimentSurveyAcuteMountainSicknessRecordsVO {
  id: number // 主键ID
  personId: number // 基础信息id
  acuteMountainReaction: boolean // 急性高原反应
  pulmonaryEdema: boolean // 肺水肿
  cerebralEdema: boolean // 脑水肿
  highAltitudeHeartDisease: boolean // 高原心脏病
  polycythemia: boolean // 高原红细胞增多症
  otherDiseases: string // 高原期间有无发生以下疾病
  otherDiseasesDesc: string // 其他疾病描述
  timePoint: number // 时相
}

// 高原急性高山病记录 API
export const ExperimentSurveyAcuteMountainSicknessRecordsApi = {
  // 查询高原急性高山病记录分页
  getExperimentSurveyAcuteMountainSicknessRecordsPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/page`, params })
  },

  // 查询高原急性高山病记录详情
  getExperimentSurveyAcuteMountainSicknessRecords: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/get?id=` + id })
  },

  // 新增高原急性高山病记录
  createExperimentSurveyAcuteMountainSicknessRecords: async (data: ExperimentSurveyAcuteMountainSicknessRecordsVO) => {
    return await request.post({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/create`, data })
  },

  // 修改高原急性高山病记录
  updateExperimentSurveyAcuteMountainSicknessRecords: async (data: ExperimentSurveyAcuteMountainSicknessRecordsVO) => {
    return await request.put({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/update`, data })
  },

  // 删除高原急性高山病记录
  deleteExperimentSurveyAcuteMountainSicknessRecords: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/delete?id=` + id })
  },

  // 导出高原急性高山病记录 Excel
  exportExperimentSurveyAcuteMountainSicknessRecords: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-acute-mountain-sickness-records/export-excel`, params })
  },
}