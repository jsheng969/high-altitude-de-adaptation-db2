import request from '@/config/axios'

export interface DynamicTableQueryReqDTO {
  selectedModules: string[]
  conditions?: any
  orderBy?: string
  orderDirection?: 'ASC' | 'DESC'
  joinAllTables?: boolean
  joinField?: string
  pageNo?: number
  pageSize?: number
}

export interface DynamicTableQueryRespDTO {
  list: any[]
  total: number
  displayedFields: FieldDisplayVO[]
  statistics: any
}

export interface FieldDisplayVO {
  groupName: string
  fields: FieldInfo[]
}

export interface FieldInfo {
  fieldCode: string
  fieldLabel: string
  fieldType: string
  tableName: string
  prop: string
}

// 动态表查询相关接口
export const queryApi = {
  // 查询动态表数据
  queryDynamicTables: (data: DynamicTableQueryReqDTO) => {
    return request.post({
      url: '/dynamic/query',
      data
    })
  },

  // 获取可查询的模块列表
  getQueryableModules: () => {
    return request.get({
      url: '/dynamic/queryable-modules'
    })
  },

  // 根据模块名称获取字段配置
  getModuleFields: (moduleNames: string[]) => {
    return request.post({
      url: '/dynamic/module-fields',
      data: moduleNames
    })
  }
}

// 导出单独的函数
export const queryDynamicTables = queryApi.queryDynamicTables
export const getQueryableModules = queryApi.getQueryableModules
export const getModuleFields = queryApi.getModuleFields