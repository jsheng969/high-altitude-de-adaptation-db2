// src/api/dynamic/export.ts
import request from '@/config/axios'

export interface DynamicTableExportReqDTO {
  moduleCode: string
  selectedModules?: string[]
  conditions?: Record<string, any>
  joinField?: string
  exportAll?: boolean
  maxExport?: number
}

export const exportApi = {
  // 按条件导出数据 - 返回 blob 数据，让调用者处理下载
  exportData: (data: DynamicTableExportReqDTO) => {
    return request.download({
      url: '/dynamic/export/query',
      method: 'post',
      data
    })
  },

  // 导出单个模块所有数据（GET方式）
  exportModule: (moduleCode: string) => {
    return request.download({
      url: `/dynamic/export/${moduleCode}`,
      method: 'get'
    })
  }
}

export const exportData = exportApi.exportData
export const exportModule = exportApi.exportModule

export default exportApi