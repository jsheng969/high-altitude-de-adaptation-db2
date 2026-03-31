import request from '@/config/axios'
import { config } from '@/config/axios/config'

export const ReportApi = {
  // 生成报告
  runReport: async (type: 'acute' | 'chronic', data: FormData) => {
    return await request.post({
      url: '/external/report/run',
      params: {
        type
      },
      data,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
  },

  // 查询结果
  getReportResult: async (type: 'acute' | 'chronic', taskId: string) => {
    return await request.get({
      url: `/external/report/result/${taskId}`,
      params: {
        type
      }
    })
  },

  // 任务列表
  getTaskList: async (type: 'acute' | 'chronic') => {
    return await request.get({
      url: '/external/report/tasks',
      params: {
        type
      }
    })
  },

  getReportFileUrl: (type: string, taskId: string, fileName: string) => {
    const safeType = encodeURIComponent(type)
    const safeTaskId = encodeURIComponent(taskId)
    const safeFileName = encodeURIComponent(fileName)
    return `${config.base_url}/external/report/file/${safeType}/${safeTaskId}/${safeFileName}`
  }
}
