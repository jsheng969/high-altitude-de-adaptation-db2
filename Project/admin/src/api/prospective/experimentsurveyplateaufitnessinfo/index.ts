import request from '@/config/axios'

// 高原体能信息 VO
export interface ExperimentSurveyPlateauFitnessInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  hasRegularTraining: string // 高原期间您是否有规律的体能训练
  trainingFrequency: string // 参加体能训练的频率
  trainingDuration: string // 每次参加体育锻炼的时长
  trainingType: string // 通常进行哪种类型的体能训练
  hasChestDiscomfort: string // 是否在体能训练时感觉胸闷、气促等不适症状
  symptomReliefAfterAdaptation: string // 适应高原环境后，行体能训练后上述症状是否缓解
  hasInsomnia: string // 进入高原后是否存在失眠情况
  dailySleepHours: string // 平均每天大约能睡几小时
  insomniaImprovement: string // 适应高原环境后，失眠情况是否改善
  dietHabits: string // 高原期间饮食情况及饮食习惯
  timePoint: number // 时相
}

// 高原体能信息 API
export const ExperimentSurveyPlateauFitnessInfoApi = {
  // 查询高原体能信息分页
  getExperimentSurveyPlateauFitnessInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-plateau-fitness-info/page`, params })
  },

  // 查询高原体能信息详情
  getExperimentSurveyPlateauFitnessInfo: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-plateau-fitness-info/get?id=` + id })
  },

  // 新增高原体能信息
  createExperimentSurveyPlateauFitnessInfo: async (data: ExperimentSurveyPlateauFitnessInfoVO) => {
    return await request.post({ url: `/prospective/experiment-survey-plateau-fitness-info/create`, data })
  },

  // 修改高原体能信息
  updateExperimentSurveyPlateauFitnessInfo: async (data: ExperimentSurveyPlateauFitnessInfoVO) => {
    return await request.put({ url: `/prospective/experiment-survey-plateau-fitness-info/update`, data })
  },

  // 删除高原体能信息
  deleteExperimentSurveyPlateauFitnessInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-plateau-fitness-info/delete?id=` + id })
  },

  // 导出高原体能信息 Excel
  exportExperimentSurveyPlateauFitnessInfo: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-plateau-fitness-info/export-excel`, params })
  },
}