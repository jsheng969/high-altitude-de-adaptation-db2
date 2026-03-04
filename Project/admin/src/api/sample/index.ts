import request from '@/config/axios'

// 生物样本 VO
export interface SampleVO {
  id: number // 主键ID
  layer: string // 层
  columnNum: string // 列
  freezerNo: string // 冰箱编号
  drawerNo: string // 抽屉号
  boxNo: string // 盒号
  tubeSeq: number // 管序号
  positionCode: string // 位置编码(自动生成)
  tubeNo: string // 管号
  sampleType: string // 样本类型(血液/尿液/组织等)
  operatorId: number // 操作人员ID
  status: number // 样本状态(1=在库,2=出库,3=已用,4=废弃)
  storageTime: Date // 入库时间
  outTime: Date // 出库时间
  sampleName: string // 样本名称
  sampleSource: string // 样本来源
  sampleVolume: number // 样本体积(ml)
  sampleConcentration: number // 样本浓度
  expirationDate: Date // 过期日期
  notes: string // 备注
}

// 生物样本 API
export const SampleApi = {
  // 查询生物样本分页
  getSamplePage: async (params: any) => {
    return await request.get({ url: `/prospective/sample/page`, params })
  },

  // 查询生物样本详情
  getSample: async (id: number) => {
    return await request.get({ url: `/prospective/sample/get?id=` + id })
  },

  // 新增生物样本
  createSample: async (data: SampleVO) => {
    return await request.post({ url: `/prospective/sample/create`, data })
  },

  // 修改生物样本
  updateSample: async (data: SampleVO) => {
    return await request.put({ url: `/prospective/sample/update`, data })
  },

  // 删除生物样本
  deleteSample: async (id: number) => {
    return await request.delete({ url: `/prospective/sample/delete?id=` + id })
  },

  // 导出生物样本 Excel
  exportSample: async (params) => {
    return await request.download({ url: `/prospective/sample/export-excel`, params })
  },

  getBoxesWithSampleTypes: async (params) => {
    return await request.get({ url: `/prospective/sample/getBoxesWithSampleTypes`, params })
  },

  getDataByBoxNo: async (params) => {
    return await request.get({ url: `/prospective/sample/getDataByBoxNo`, params })
  },

  getSampleTypeCount: async () => {
    return await request.get({ url: `/prospective/sample/getSampleTypeCount` })
  },

  getSampleTypeCount2: async () => {
    return await request.get({ url: `/prospective/sample/getSampleTypeCount2` })
  },


    takeOut: async (id: number) => {
      return await request.get({ url: `/prospective/sample/takeOut?id=` + id })
    },
    putBack: async (params) => {
      return await request.get({ url: `/prospective/sample/putBack`, params })
    },
    getUseRecords: async (id: number) => {
      return await request.get({ url: `/prospective/sample/getUseRecords?id=` + id })
    },
    takeOutByTubeNo: async (tubeNo: number) => {
      return await request.get({ url: `/prospective/sample/takeOutByTubeNo?tubeNo=` + tubeNo })
    },

    // 查询生物样本分页
  getSampleHistoryPage: async (params: any) => {
    return await request.get({ url: `/samplehistory/sample-history/page`, params })
  },

  // 新增生物样本
  importSamples: async (data: any) => {
    return await request.upload({ url: `/prospective/sample/importUpdate`, data })
  },

}
