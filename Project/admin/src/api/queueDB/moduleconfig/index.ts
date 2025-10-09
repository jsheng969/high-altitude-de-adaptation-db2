import request from '@/config/axios'

// 动态模块配置表（支持三级结构） VO
export interface ModuleConfigVO {
  id: number // 模块ID
  parentId: number // 父模块ID（支持三级）
  moduleCode: string // 模块唯一标识
  moduleName: string // 模块名称
  tableName: string // 若为叶子节点，对应表名
  moduleLevel: number // 模块层级（1=一级,2=二级,3=三级）
  groupType: string // 模块归属类型（experiment/control）
  moduleType: string // survey/exam等
  isLeaf: number // 是否叶子模块（1=建表）
  orderNo: number // 排序号
  status: number // 状态（1启用，0停用）
}

// 动态模块配置表（支持三级结构） API
export const ModuleConfigApi = {
  // 查询动态模块配置表（支持三级结构）分页
  getModuleConfigPage: async (params: any) => {
    return await request.get({ url: `/queueDB/module-config/page`, params })
  },

  // 查询动态模块配置表（支持三级结构）详情
  getModuleConfig: async (id: number) => {
    return await request.get({ url: `/queueDB/module-config/get?id=` + id })
  },

  // 新增动态模块配置表（支持三级结构）
  createModuleConfig: async (data: ModuleConfigVO) => {
    return await request.post({ url: `/queueDB/module-config/create`, data })
  },

  // 修改动态模块配置表（支持三级结构）
  updateModuleConfig: async (data: ModuleConfigVO) => {
    return await request.put({ url: `/queueDB/module-config/update`, data })
  },

  // 删除动态模块配置表（支持三级结构）
  deleteModuleConfig: async (id: number) => {
    return await request.delete({ url: `/queueDB/module-config/delete?id=` + id })
  },

  // 导出动态模块配置表（支持三级结构） Excel
  exportModuleConfig: async (params) => {
    return await request.download({ url: `/queueDB/module-config/export-excel`, params })
  }
}