import request from '@/config/axios'

// 基础信息 VO
export interface BasicInfoVO {
  id: number // 主键ID
  name: string // 姓名
  gender: string // 性别
  birthDate: string // 出生年月
  position: string // 部职别
  idNumber: string // 证件号
  code: string // 编号
  type: string // 类型181-23、181-24、363-23
  groupType: string // 实验组、对照组
}

// 基础信息 API
export const BasicInfoApi = {
  // 查询基础信息分页
  getBasicInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/basic-info/page`, params })
  },

  // 查询基础信息详情
  getBasicInfo: async (id: number) => {
    return await request.get({ url: `/prospective/basic-info/get?id=` + id })
  },

  // 新增基础信息
  createBasicInfo: async (data: BasicInfoVO) => {
    return await request.post({ url: `/prospective/basic-info/create`, data })
  },

  // 修改基础信息
  updateBasicInfo: async (data: BasicInfoVO) => {
    return await request.put({ url: `/prospective/basic-info/update`, data })
  },

  // 删除基础信息
  deleteBasicInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/basic-info/delete?id=` + id })
  },

  // 导出基础信息 Excel
  exportBasicInfo: async (params) => {
    return await request.download({ url: `/prospective/basic-info/export-excel`, params })
  },

  getDataByParamPage: async (params: any) => {
    return await request.get({ url: `/prospective/basic-info/getDataByParamPage`, params })
  },

  getAverageByParam: async (params: any) => {
    return await request.get({ url: `/prospective/basic-info/getAverageByParam`, params })
  },

  exportProspective: async (params) => {
    return await request.download({ url: `/prospective/basic-info/exportProspective`, params })
  },

  predict: async (data: BasicInfoVO) => {
    return await request.post({ url: `/prospective/basic-info/predict`, data })
  },
}
