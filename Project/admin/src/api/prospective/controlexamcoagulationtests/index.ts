import request from '@/config/axios'

// 实验组体检-凝血功能 VO
export interface ControlExamCoagulationTestsVO {
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
  ptdFbg: number // PTDF
}

// 实验组体检-凝血功能 API
export const ControlExamCoagulationTestsApi = {
  // 查询实验组体检-凝血功能分页
  getControlExamCoagulationTestsPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-exam-coagulation-tests/page`, params })
  },

  // 查询实验组体检-凝血功能详情
  getControlExamCoagulationTests: async (id: number) => {
    return await request.get({ url: `/prospective/control-exam-coagulation-tests/get?id=` + id })
  },

  // 新增实验组体检-凝血功能
  createControlExamCoagulationTests: async (data: ControlExamCoagulationTestsVO) => {
    return await request.post({ url: `/prospective/control-exam-coagulation-tests/create`, data })
  },

  // 修改实验组体检-凝血功能
  updateControlExamCoagulationTests: async (data: ControlExamCoagulationTestsVO) => {
    return await request.put({ url: `/prospective/control-exam-coagulation-tests/update`, data })
  },

  // 删除实验组体检-凝血功能
  deleteControlExamCoagulationTests: async (id: number) => {
    return await request.delete({ url: `/prospective/control-exam-coagulation-tests/delete?id=` + id })
  },

  // 导出实验组体检-凝血功能 Excel
  exportControlExamCoagulationTests: async (params) => {
    return await request.download({ url: `/prospective/control-exam-coagulation-tests/export-excel`, params })
  }
}