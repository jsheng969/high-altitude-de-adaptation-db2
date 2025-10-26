// src/api/dynamic.ts
import request from '@/config/axios'

export interface ModuleTreeVO {
  id: number
  parentId: number | null
  moduleCode: string
  moduleName: string
  tableName: string | null
  moduleLevel: number
  groupType: string | null
  moduleType: string | null
  isLeaf: number
  orderNo: number
  status: number
  children?: ModuleTreeVO[]
  fields?: FieldConfigVO[]
}

export interface FieldConfigVO {
  id: number
  moduleCode: string
  fieldCode: string
  fieldLabel: string
  fieldType: string
  dataType: string
  optionsJson: any
  isRequired: number
  orderNo: number
  status: number
  fieldLength: number | null
  isDefault: number
  displayOrder: number
  fieldName: string | null
  fieldGroup: string | null
  fieldGroupName: string | null
}

export interface ExcelImportReqDTO {
  file: File
  moduleType?: string
  groupType?: string
  remark?: string
  moduleCode?: string
  moduleName?: string
  configMode?: string
  importData?: boolean
  overwrite?: boolean
}

export interface ExcelImportResultVO {
  success: boolean
  message: string
  moduleCode: string
  tableName: string
  totalFields: number
  successFields: number
  totalRecords: number
  successRecords: number
  errorMessages: string[]
  costTime: number
  configMode: string
  importTime: string
  fileName: string
}

export interface ImportHistoryVO {
  id: number
  fileName: string
  moduleCode: string
  moduleName: string
  fieldCount: number
  dataCount: number
  success: boolean
  errorMessage: string
  importTime: string
}

// Excel导入相关接口
export const importApi = {
  // 下载模板 - 使用 request.download
  downloadTemplate: (type: string = 'simple') => {
    return request.download({ 
      url: '/dynamic/template', 
      params: { type } 
    })
  },

  // Excel导入
  importExcel: (data: FormData) => {
    return request.post({
      url: '/dynamic/excel',
      data,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
  },

  // 批量导入
  batchImport: (files: File[], moduleType: string = 'survey', groupType: string = 'general') => {
    const formData = new FormData()
    files.forEach(file => {
      formData.append('files', file)
    })
    formData.append('moduleType', moduleType)
    formData.append('groupType', groupType)
    
    return request.post({
      url: '/dynamic/batch',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
  },

  // 检查模块是否存在
  checkModuleExists: (moduleCode: string) => {
    return request.get({
      url: '/dynamic/check-module',
      params: { moduleCode }
    })
  },

  // 获取导入历史
  getImportHistory: (params: { pageNo?: number; pageSize?: number }) => {
    return request.get({
      url: '/dynamic/history',
      params
    })
  },

  // 重新同步表结构
  resyncTable: (moduleCode: string) => {
    return request.post({
      url: '/dynamic/resync',
      data: { moduleCode }
    })
  },

  // 删除模块
  deleteModule: (moduleCode: string) => {
    return request.delete({
      url: '/dynamic/delete',
      params: { moduleCode }
    })
  },

  // 获取导入统计信息
  getImportStatistics: () => {
    return request.get({
      url: '/dynamic/statistics'
    })
  },

  // 清空导入历史
  clearImportHistory: () => {
    return request.delete({
      url: '/dynamic/history'
    })
  }
}

// 为了兼容旧代码，也导出单独的函数
export const importExcel = importApi.importExcel
export const downloadTemplate = importApi.downloadTemplate
export const batchImport = importApi.batchImport
export const checkModuleExists = importApi.checkModuleExists
export const getImportHistory = importApi.getImportHistory
export const resyncTable = importApi.resyncTable
export const deleteModule = importApi.deleteModule
export const getImportStatistics = importApi.getImportStatistics
export const clearImportHistory = importApi.clearImportHistory

// 模块配置相关接口
export const moduleApi = {
  // 获取完整的模块树（包含字段）
  getModuleTree: () => {
    return request.get({
      url: '/queueDB/module-config/tree-with-fields'
    })
  },

  // 获取基础信息模块（parent_id为null的模块）
  getBaseModules: () => {
    return request.get({
      url: '/queueDB/module-config/base-modules'
    })
  }
}

// 导出模块配置相关函数
export const getModuleTree = moduleApi.getModuleTree
export const getBaseModules = moduleApi.getBaseModules