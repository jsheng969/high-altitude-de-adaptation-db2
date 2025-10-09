import request from '@/config/axios'

// 实验组体检-其他数据 VO
export interface ExperimentExamOtherDataVO {
  id: number // id
  personId: number // 基础信息id
  cardiacTroponinI: string // 心肌肌钙蛋白I
  vascularUltrasoundResult: string // 血管超声结果
  ecgAnalysisResult: string // 心电图分析结果
  timePoint: number // 时相
}

// 实验组体检-其他数据 API
export const ExperimentExamOtherDataApi = {
  // 查询实验组体检-其他数据分页
  getExperimentExamOtherDataPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-exam-other-data/page`, params })
  },

  // 查询实验组体检-其他数据详情
  getExperimentExamOtherData: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-exam-other-data/get?id=` + id })
  },

  // 新增实验组体检-其他数据
  createExperimentExamOtherData: async (data: ExperimentExamOtherDataVO) => {
    return await request.post({ url: `/prospective/experiment-exam-other-data/create`, data })
  },

  // 修改实验组体检-其他数据
  updateExperimentExamOtherData: async (data: ExperimentExamOtherDataVO) => {
    return await request.put({ url: `/prospective/experiment-exam-other-data/update`, data })
  },

  // 删除实验组体检-其他数据
  deleteExperimentExamOtherData: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-exam-other-data/delete?id=` + id })
  },

  // 导出实验组体检-其他数据 Excel
  exportExperimentExamOtherData: async (params) => {
    return await request.download({ url: `/prospective/experiment-exam-other-data/export-excel`, params })
  },
}