import request from '@/config/axios'

// 对照组体检-血常规 VO
export interface ExperimentExamBloodRoutineVO {
  id: number // id
  personId: number // 基础信息id
  wbcCount: number // 白细胞计数
  lymphocytePercent: number // 淋巴细胞百分比
  midCellPercent: number // 中间细胞百分比
  granulocytePercent: number // 粒细胞百分比
  lymphocyteCount: number // 淋巴细胞计数
  midCellCount: number // 中间细胞计数
  granulocyteCount: number // 粒细胞计数
  rbcCount: number // 红细胞计数
  hemoglobin: number // 血红蛋白
  hematocrit: number // 血细胞比容
  mcv: number // 平均红细胞体积
  mch: number // 平均红细胞血红蛋白含量
  mchc: number // 平均红细胞血红蛋白浓度
  rdwCv: number // 红细胞分布宽度变异系数
  rdwSd: number // 红细胞分布宽度标准差
  plateletCount: number // 血小板计数
  mpv: number // 平均血小板体积
  pdw: number // 血小板分布宽度
  pct: number // 血小板压积
  largePlateletRatio: number // 大血小板比率
  largePlateletCount: number // 大血小板计数
  basophilCount: number // 嗜碱性粒细胞计数
  basophilPercent: number // 嗜碱性粒细胞百分比
  eosinophilCount: number // 嗜酸性粒细胞计数
  eosinophilPercent: number // 嗜酸性粒细胞百分比
  immatureGranulocyteCount: number // 幼稚粒细胞计数
  immatureGranulocytePercent: number // 幼稚粒细胞百分比
  monocyteCount: number // 单核细胞计数
  monocytePercent: number // 单核细胞百分比
  nucleatedRbcCount: number // 有核红细胞计数
  nucleatedRbcPercent: number // 有核红细胞百分比
  neutrophilCount: number // 中性粒细胞计数
  neutrophilPercent: number // 中性粒细胞百分比
  timePoint: number // 时相
}

// 对照组体检-血常规 API
export const ExperimentExamBloodRoutineApi = {
  // 查询对照组体检-血常规分页
  getExperimentExamBloodRoutinePage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-exam-blood-routine/page`, params })
  },

  // 查询对照组体检-血常规详情
  getExperimentExamBloodRoutine: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-exam-blood-routine/get?id=` + id })
  },

  // 新增对照组体检-血常规
  createExperimentExamBloodRoutine: async (data: ExperimentExamBloodRoutineVO) => {
    return await request.post({ url: `/prospective/experiment-exam-blood-routine/create`, data })
  },

  // 修改对照组体检-血常规
  updateExperimentExamBloodRoutine: async (data: ExperimentExamBloodRoutineVO) => {
    return await request.put({ url: `/prospective/experiment-exam-blood-routine/update`, data })
  },

  // 删除对照组体检-血常规
  deleteExperimentExamBloodRoutine: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-exam-blood-routine/delete?id=` + id })
  },

  // 导出对照组体检-血常规 Excel
  exportExperimentExamBloodRoutine: async (params) => {
    return await request.download({ url: `/prospective/experiment-exam-blood-routine/export-excel`, params })
  },
}
