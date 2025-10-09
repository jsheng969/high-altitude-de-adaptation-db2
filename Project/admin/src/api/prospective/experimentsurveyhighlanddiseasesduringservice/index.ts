import request from '@/config/axios'

// 抵达高原后有无新下疾病 VO
export interface ExperimentSurveyHighlandDiseasesDuringServiceVO {
  id: number // 主键ID
  personId: number // 基础信息id
  hypertension: boolean // 高血压
  myocardialInfarction: boolean // 心肌梗死
  coronaryHeartDisease: boolean // 冠心病
  pulmonaryHeartDisease: boolean // 肺心病
  lowerExtremityVenousThrombosis: boolean // 四肢静脉血栓
  bradycardia: boolean // 窦性心动过缓
  tachycardia: boolean // 窦性心动过速
  arrhythmia: boolean // 窦性心律不齐
  atrialFibrillation: boolean // 房颤
  paroxysmalAuricularTachycardia: boolean // 阵发性室上速
  frequentPrematureAtrialContractions: boolean // 频发房性早搏
  frequentPrematureVentricularContractions: boolean // 频发室性早搏
  avBlock: boolean // 房室传导阻滞
  ventricularTachycardia: boolean // 室性心动过速
  otherDiseases11: boolean // 其他
  dizziness: boolean // 眩晕
  transientIschemicAttack: boolean // 短暂性脑缺血
  cerebralInfarction: boolean // 脑梗死/脑血栓
  cerebralHemorrhage: boolean // 脑出血
  otherDiseases12: boolean // 其他
  hyperlipidemia: boolean // 高血脂
  diabetes: boolean // 糖尿病
  gout: boolean // 高尿酸血症（痛风）
  thyroidDisease: boolean // 甲状腺疾病
  otherDiseases13: boolean // 其他
  insomnia: boolean // 失眠
  tumor: boolean // 肿瘤
  otherDiseases14: boolean // 其他
  timePoint: number // 时相
}

// 抵达高原后有无新下疾病 API
export const ExperimentSurveyHighlandDiseasesDuringServiceApi = {
  // 查询抵达高原后有无新下疾病分页
  getExperimentSurveyHighlandDiseasesDuringServicePage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-highland-diseases-during-service/page`, params })
  },

  // 查询抵达高原后有无新下疾病详情
  getExperimentSurveyHighlandDiseasesDuringService: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-highland-diseases-during-service/get?id=` + id })
  },

  // 新增抵达高原后有无新下疾病
  createExperimentSurveyHighlandDiseasesDuringService: async (data: ExperimentSurveyHighlandDiseasesDuringServiceVO) => {
    return await request.post({ url: `/prospective/experiment-survey-highland-diseases-during-service/create`, data })
  },

  // 修改抵达高原后有无新下疾病
  updateExperimentSurveyHighlandDiseasesDuringService: async (data: ExperimentSurveyHighlandDiseasesDuringServiceVO) => {
    return await request.put({ url: `/prospective/experiment-survey-highland-diseases-during-service/update`, data })
  },

  // 删除抵达高原后有无新下疾病
  deleteExperimentSurveyHighlandDiseasesDuringService: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-highland-diseases-during-service/delete?id=` + id })
  },

  // 导出抵达高原后有无新下疾病 Excel
  exportExperimentSurveyHighlandDiseasesDuringService: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-highland-diseases-during-service/export-excel`, params })
  },
}