import request from '@/config/axios'

// 对照组体检-凝血功能 VO
export interface ExperimentExamCoagulationTestsVO {
  id: number // id
  personId: number // 基础信息id
  aptt: number // 活化部分凝血活酶时间
  antithrombinIiiActivityPercent: number // 抗凝血酶Ⅲ活性百分比
  antithrombinIiiActivityRate: number // 抗凝血酶Ⅲ活性（吸光度变化速率检测）
  dDimerOptDensity: number // D-二聚体（光密度差值检测）
  dDimerConcentration: number // D-二聚体浓度
  fibrinDegradationProductsDensity: number // 纤维蛋白降解产物（光密度差值检测）
  fibrinDegradationProductsConcentration: number // 纤维蛋白降解产物浓度
  fibrinogenConcentration: number // 纤维蛋白原浓度
  fibrinogenClottingTime: number // 纤维蛋白原凝固时间
  prothrombinTimePercent: number // 凝血酶原时间(百分比活动度)
  ptInr: number // 凝血酶原时间-国际标准化比值
  prothrombinTimeRatio: number // 凝血酶原时间比值
  prothrombinTime: number // 凝血酶原时间
  thrombinTime: number // 凝血酶时间
  thrombinTime1: number // 凝血酶时间(1)
  aptt1: number // 活化部分凝血活酶时间(1)
  aptt2: number // 活化部分凝血活酶时间(2)
  prothrombinActivity: number // 凝血酶原活动度
  inr: number // 国际标准化比值
  timePoint: number // 时相
}

// 对照组体检-凝血功能 API
export const ExperimentExamCoagulationTestsApi = {
  // 查询对照组体检-凝血功能分页
  getExperimentExamCoagulationTestsPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-exam-coagulation-tests/page`, params })
  },

  // 查询对照组体检-凝血功能详情
  getExperimentExamCoagulationTests: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-exam-coagulation-tests/get?id=` + id })
  },

  // 新增对照组体检-凝血功能
  createExperimentExamCoagulationTests: async (data: ExperimentExamCoagulationTestsVO) => {
    return await request.post({ url: `/prospective/experiment-exam-coagulation-tests/create`, data })
  },

  // 修改对照组体检-凝血功能
  updateExperimentExamCoagulationTests: async (data: ExperimentExamCoagulationTestsVO) => {
    return await request.put({ url: `/prospective/experiment-exam-coagulation-tests/update`, data })
  },

  // 删除对照组体检-凝血功能
  deleteExperimentExamCoagulationTests: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-exam-coagulation-tests/delete?id=` + id })
  },

  // 导出对照组体检-凝血功能 Excel
  exportExperimentExamCoagulationTests: async (params) => {
    return await request.download({ url: `/prospective/experiment-exam-coagulation-tests/export-excel`, params })
  },
}
