import request from '@/config/axios'

// 实验组体检-其他数据 VO
export interface ControlExamOtherDataVO {
  id: number // id
  personId: number // 基础信息id
  cardiacTroponinI: string // 心肌肌钙蛋白I
  vascularUltrasoundResult: string // 血管超声结果
  ecgAnalysisResult: string // 心电图分析结果
  timePoint: number // 时相
  atniH: string // ATNI-H
  myog: string // MYOG
  ckMbg: string // CK-MBG
}

// 实验组体检-其他数据 API
export const ControlExamOtherDataApi = {
  // 查询实验组体检-其他数据分页
  getControlExamOtherDataPage: async (params: any) => {
    return await request.get({ url: `/prospective/control-exam-other-data/page`, params })
  },

  // 查询实验组体检-其他数据详情
  getControlExamOtherData: async (id: number) => {
    return await request.get({ url: `/prospective/control-exam-other-data/get?id=` + id })
  },

  // 新增实验组体检-其他数据
  createControlExamOtherData: async (data: ControlExamOtherDataVO) => {
    return await request.post({ url: `/prospective/control-exam-other-data/create`, data })
  },

  // 修改实验组体检-其他数据
  updateControlExamOtherData: async (data: ControlExamOtherDataVO) => {
    return await request.put({ url: `/prospective/control-exam-other-data/update`, data })
  },

  // 删除实验组体检-其他数据
  deleteControlExamOtherData: async (id: number) => {
    return await request.delete({ url: `/prospective/control-exam-other-data/delete?id=` + id })
  },

  // 导出实验组体检-其他数据 Excel
  exportControlExamOtherData: async (params) => {
    return await request.download({ url: `/prospective/control-exam-other-data/export-excel`, params })
  }
}