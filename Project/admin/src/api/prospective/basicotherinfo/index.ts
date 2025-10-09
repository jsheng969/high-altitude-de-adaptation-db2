import request from '@/config/axios'

// 基础其他信息 VO
export interface BasicOtherInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  maritalStatus: string // 婚姻状况
  fertilityStatus: string // 生育情况
  ethnicity: string // 民族
  educationLevel: string // 最高学历
  timePoint: number // 时相
}

// 基础其他信息 API
export const BasicOtherInfoApi = {
  // 查询基础其他信息分页
  getBasicOtherInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/basic-other-info/page`, params })
  },

  // 查询基础其他信息详情
  getBasicOtherInfo: async (id: number) => {
    return await request.get({ url: `/prospective/basic-other-info/get?id=` + id })
  },

  // 新增基础其他信息
  createBasicOtherInfo: async (data: BasicOtherInfoVO) => {
    return await request.post({ url: `/prospective/basic-other-info/create`, data })
  },

  // 修改基础其他信息
  updateBasicOtherInfo: async (data: BasicOtherInfoVO) => {
    return await request.put({ url: `/prospective/basic-other-info/update`, data })
  },

  // 删除基础其他信息
  deleteBasicOtherInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/basic-other-info/delete?id=` + id })
  },

  // 导出基础其他信息 Excel
  exportBasicOtherInfo: async (params) => {
    return await request.download({ url: `/prospective/basic-other-info/export-excel`, params })
  },
}