import request from '@/config/axios'

// 对照组流调-退役后返回平原1月内症状 VO
export interface ControlSurveyPostReturnSymptomsVO {
  id: number // id
  personId: number // 基础信息id
  fatigue: number // 疲倦
  fatigueDuration: string // 疲倦持续时间
  weakness: number // 乏力
  weaknessDuration: string // 乏力持续时间
  drowsiness: number // 嗜睡
  drowsinessDuration: string // 嗜睡持续时间
  dizziness: number // 头昏
  dizzinessDuration: string // 头昏持续时间
  vertigo: number // 眩晕
  vertigoDuration: string // 眩晕持续时间
  poorConcentration: number // 精力不集中
  poorConcentrationDuration: string // 精力不集中持续时间
  slowReaction: number // 反应迟钝
  slowReactionDuration: string // 反应迟钝持续时间
  memoryLoss: number // 记忆减退
  memoryLossDuration: string // 记忆减退持续时间
  insomnia: number // 失眠
  insomniaDuration: string // 失眠持续时间
  nightmares: number // 多梦
  nightmaresDuration: string // 多梦持续时间
  soreThroat: number // 咽喉痛
  soreThroatDuration: string // 咽喉痛持续时间
  cough: number // 咳嗽
  coughDuration: string // 咳嗽持续时间
  phlegm: number // 多痰
  phlegmDuration: string // 多痰持续时间
  wheezing: number // 气喘
  wheezingDuration: string // 气喘持续时间
  chestTightness: number // 胸闷
  chestTightnessDuration: string // 胸闷持续时间
  chestPain: number // 心前区痛
  chestPainDuration: string // 心前区痛持续时间
  palpitations: number // 心慌
  palpitationsDuration: string // 心慌持续时间
  bradycardia: number // 脉率减慢
  bradycardiaDuration: string // 脉率减慢持续时间
  cyanosis: number // 紫绀
  cyanosisDuration: string // 紫绀持续时间
  bloodPressureFluctuation: number // 血压波动
  bloodPressureFluctuationDuration: string // 血压波动持续时间
  skinBleeding: number // 皮肤出血
  skinBleedingDuration: string // 皮肤出血持续时间
  skinBruising: number // 皮肤瘀斑
  skinBruisingDuration: string // 皮肤瘀斑持续时间
  anemia: number // 贫血
  anemiaDuration: string // 贫血持续时间
  weightLoss: number // 体重减轻
  weightLossDuration: string // 体重减轻持续时间
  increasedAppetite: number // 食欲增加
  increasedAppetiteDuration: string // 食欲增加持续时间
  anorexia: number // 厌食
  anorexiaDuration: string // 厌食持续时间
  constipation: number // 便秘
  constipationDuration: string // 便秘持续时间
  diarrhea: number // 腹泻
  diarrheaDuration: string // 腹泻持续时间
  abdominalPain: number // 腹痛
  abdominalPainDuration: string // 腹痛持续时间
  abdominalDistension: number // 腹胀
  abdominalDistensionDuration: string // 腹胀持续时间
  jaundice: number // 黄疸
  jaundiceDuration: string // 黄疸持续时间
  numbness: number // 手足麻木
  numbnessDuration: string // 手足麻木持续时间
  limbEdema: number // 肢体水肿
  limbEdemaDuration: string // 肢体水肿持续时间
  facialEdema: number // 面部水肿
  facialEdemaDuration: string // 面部水肿持续时间
  hairLoss: number // 脱发
  hairLossDuration: string // 脱发持续时间
  increasedUrination: number // 夜尿增多
  increasedUrinationDuration: string // 夜尿增多持续时间
  otherSymptoms: string // 返回后有无其他症状
  timePoint: number // 时相点
}

// 对照组流调-退役后返回平原1月内症状 API
export const ControlSurveyPostReturnSymptomsApi = {
  // 查询对照组流调-退役后返回平原1月内症状分页
  getControlSurveyPostReturnSymptomsPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-survey-post-return-symptoms/page`, params })
  },

  // 查询对照组流调-退役后返回平原1月内症状详情
  getControlSurveyPostReturnSymptoms: async (id: number) => {
    return await request.get({ url: `/prospective/control-survey-post-return-symptoms/get?id=` + id })
  },

  // 新增对照组流调-退役后返回平原1月内症状
  createControlSurveyPostReturnSymptoms: async (data: ControlSurveyPostReturnSymptomsVO) => {
    return await request.post({ url: `/prospective/control-survey-post-return-symptoms/create`, data })
  },

  // 修改对照组流调-退役后返回平原1月内症状
  updateControlSurveyPostReturnSymptoms: async (data: ControlSurveyPostReturnSymptomsVO) => {
    return await request.put({ url: `/prospective/control-survey-post-return-symptoms/update`, data })
  },

  // 删除对照组流调-退役后返回平原1月内症状
  deleteControlSurveyPostReturnSymptoms: async (id: number) => {
    return await request.delete({ url: `/prospective/control-survey-post-return-symptoms/delete?id=` + id })
  },

  // 导出对照组流调-退役后返回平原1月内症状 Excel
  exportControlSurveyPostReturnSymptoms: async (params) => {
    return await request.download({ url: `/prospective/control-survey-post-return-symptoms/export-excel`, params })
  }
}