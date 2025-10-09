import request from '@/config/axios'

// 对照组体检-生化v2 VO
export interface ExperimentExamBiochemicalTestsV2VO {
  id: number // id
  personId: number // 基础信息id
  alt: number // 谷丙转氨酶
  ast: number // 谷草转氨酶
  astAltRatio: number // 谷草转氨酶与谷丙转氨酶比值
  totalProtein: number // 总蛋白
  albumin: number // 白蛋白
  globulin: number // 球蛋白
  albGlobRatio: number // 白球比
  totalBilirubin: number // 总胆红素
  directBilirubin: number // 直接胆红素
  indirectBilirubin: number // 间接胆红素
  alkalinePhosphatase: number // 碱性磷酸酶
  ggt: number // 谷氨酰转肽酶
  totalBileAcid: number // 总胆汁酸
  cholinesterase: number // 胆碱酯酶
  prealbumin: number // 前白蛋白
  urea: number // 尿素
  creatinine: number // 肌酐
  uricAcid: number // 尿酸
  triglycerides: number // 甘油三酯
  cholesterol: number // 胆固醇
  hdlC: number // 高密度脂蛋白
  ldlC: number // 低密度脂蛋白
  apoa: number // 载脂蛋白A
  apob: number // 载脂蛋白B
  lpa: number // 脂蛋白a
  glucose: number // 葡萄糖
  ck: number // 肌酸激酶
  ckMb: number // 肌酸激酶同工酶MB
  alphaHbdh: number // α-羟丁酸脱氢酶
  ldh: number // 乳酸脱氢酶
  crp: number // C-反应蛋白
  igg: number // 免疫球蛋白G
  iga: number // 免疫球蛋白A
  igm: number // 免疫球蛋白M
  complement3: number // 补体3
  complement4: number // 补体4
  myoglobin: number // 肌红蛋白
  smallDenseLdl: number // 小而密低密度脂蛋白
  homocysteine: number // 同型半胱氨酸
  nucleotidase: number // 5-核苷酸酶
  ada: number // 腺苷脱氨酶
  amylase: number // 淀粉酶
  anionGap: number // 阴离子间隙
  bufferBase: number // 缓冲碱
  bicarbonate: number // 碳酸氢盐
  baseExcess: number // 碱剩余
  extracellularBe: number // 细胞外液碱剩余
  bloodUrea: number // 血尿素
  bun: number // 血尿素氮
  calcium: number // 钙
  chloride: number // 氯
  cystatinC: number // 胱抑素C
  iron: number // 铁
  actualBicarbonate: number // 实际碳酸氢盐
  standardBicarbonate: number // 标准碳酸氢盐
  potassium: number // 钾
  magnesium: number // 镁
  sodium: number // 钠
  phosphorus: number // 磷
  pco2: number // 二氧化碳分压
  ph: number // 酸碱度
  po2: number // 氧分压
  rbp: number // 视黄醇结合蛋白
  reninActivity: number // 肾素活性
  hydrogenIonConcentration: number // 氢离子浓度
  tco2: number // 二氧化碳总量
  lacticAcid: number // 乳酸
  microalbumin: number // 微量白蛋白
  plasmaOsmoticPressure: number // 血浆渗透压
  aAGradient: number // 肺泡-动脉血氧分压差
  aARatio: number // 动脉-肺泡氧分压比值
  oxygenationIndex: number // 氧合指数
  estimatedSpo2: number // 估计血氧饱和度
  estimatedHb: number // 估计总血红蛋白
  beta2Microglobulin: number // β2-微球蛋白
  hsCrp: number // 超敏C反应蛋白
  hbsag: number // 乙肝表面抗原
  antiHbs: number // 乙肝表面抗体
  hbeag: number // 乙肝e抗原
  antiHbe: number // 乙肝e抗体
  antiHbc: number // 乙肝核心抗体
  totalCholesterol: number // 总胆固醇
  ima: number // 缺血修饰白蛋白
  afucosidase: number // α-L-岩藻糖苷酶
  timePoint: number // 时相
}

// 对照组体检-生化v2 API
export const ExperimentExamBiochemicalTestsV2Api = {
  // 查询对照组体检-生化v2分页
  getExperimentExamBiochemicalTestsV2Page: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-exam-biochemical-tests-v2/page`, params })
  },

  // 查询对照组体检-生化v2详情
  getExperimentExamBiochemicalTestsV2: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-exam-biochemical-tests-v2/get?id=` + id })
  },

  // 新增对照组体检-生化v2
  createExperimentExamBiochemicalTestsV2: async (data: ExperimentExamBiochemicalTestsV2VO) => {
    return await request.post({ url: `/prospective/experiment-exam-biochemical-tests-v2/create`, data })
  },

  // 修改对照组体检-生化v2
  updateExperimentExamBiochemicalTestsV2: async (data: ExperimentExamBiochemicalTestsV2VO) => {
    return await request.put({ url: `/prospective/experiment-exam-biochemical-tests-v2/update`, data })
  },

  // 删除对照组体检-生化v2
  deleteExperimentExamBiochemicalTestsV2: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-exam-biochemical-tests-v2/delete?id=` + id })
  },

  // 导出对照组体检-生化v2 Excel
  exportExperimentExamBiochemicalTestsV2: async (params) => {
    return await request.download({ url: `/prospective/experiment-exam-biochemical-tests-v2/export-excel`, params })
  },
}
