import request from '@/config/axios'

// 既往疾病史 VO
export interface ExperimentSurveyMedicalHistoryVO {
  id: number // 主键ID
  personId: number // 基础信息id
  hypertension: boolean // 高血压
  hyperlipidemia: boolean // 高血脂
  congenitalHeartDisease: boolean // 先天性心脏病
  pulmonaryHeartDisease: boolean // 肺心病
  stroke: boolean // 中风/脑溢血
  sinusTachycardia: boolean // 窦性心动过速
  frequentAtrialPremature: boolean // 频发房性早搏
  coronaryHeartDisease: boolean // 冠心病/心绞痛
  sinusArrhythmia: boolean // 窦性心律不齐
  frequentVentricularPremature: boolean // 频发室性早搏
  myocardialInfarction: boolean // 心肌梗塞
  atrialFibrillation: boolean // 房颤
  atrioventricularBlock: boolean // 房室传导阻滞
  sinusBradycardia: boolean // 窦性心动过缓
  paroxysmalSupraventricularTachycardia: boolean // 阵发性室上速
  ventricularTachycardia: boolean // 室性心动过速
  chronicBronchitis: boolean // 慢性支气管炎
  asthma: boolean // 哮喘
  tuberculosis: boolean // 肺结核
  emphysema: boolean // 肺气肿
  pneumonia: boolean // 肺炎
  copd: boolean // 慢性阻塞性肺疾病
  thyroidDisease: boolean // 甲状腺疾病
  diabetes: boolean // 糖尿病
  gout: boolean // 高尿酸血症（痛风）
  chronicGastroenteritis: boolean // 慢性肠胃炎
  duodenalUlcer: boolean // 十二指肠溃疡
  gastricUlcer: boolean // 胃溃疡
  gallstones: boolean // 胆结石
  colonPolyps: boolean // 结肠息肉
  hepatitisB: boolean // 乙型肝炎
  cholecystitis: boolean // 胆囊炎
  epilepsy: boolean // 癫痫
  timePoint: number // 时相
}

// 既往疾病史 API
export const ExperimentSurveyMedicalHistoryApi = {
  // 查询既往疾病史分页
  getExperimentSurveyMedicalHistoryPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-medical-history/page`, params })
  },

  // 查询既往疾病史详情
  getExperimentSurveyMedicalHistory: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-medical-history/get?id=` + id })
  },

  // 新增既往疾病史
  createExperimentSurveyMedicalHistory: async (data: ExperimentSurveyMedicalHistoryVO) => {
    return await request.post({ url: `/prospective/experiment-survey-medical-history/create`, data })
  },

  // 修改既往疾病史
  updateExperimentSurveyMedicalHistory: async (data: ExperimentSurveyMedicalHistoryVO) => {
    return await request.put({ url: `/prospective/experiment-survey-medical-history/update`, data })
  },

  // 删除既往疾病史
  deleteExperimentSurveyMedicalHistory: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-medical-history/delete?id=` + id })
  },

  // 导出既往疾病史 Excel
  exportExperimentSurveyMedicalHistory: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-medical-history/export-excel`, params })
  },
}