// useExportHandler.ts
import { ref } from 'vue'
import { exportApi } from '@/api/dynamic/export'
import download from '@/utils/download' // 改为默认导入
import { ElMessage } from 'element-plus'

export function useExportHandler(
  queryParams: any, 
  mainModuleCode: string | Ref<string>,
  mainModuleName: string | Ref<string>,
  selectedModules?: string[] | Ref<string[]>
) {
  const exportLoading = ref(false)

  // 构建导出条件（从当前查询条件转换）
  const buildExportConditions = () => {
    const conditions: Record<string, any> = {}
    const params = queryParams.value || queryParams
    
    // 处理高级筛选条件
    if (params.advancedConditions?.length > 0) {
      params.advancedConditions.forEach((cond: any) => {
        if (cond.field && cond.value) {
          conditions[cond.field] = cond.value
        }
      })
    }
    
    return conditions
  }

  const getSelectedModules = () => {
    if (selectedModules) {
      const modules = selectedModules.value || selectedModules
      return modules.length > 0 ? modules : [getMainModuleCode()]
    }
    
    const params = queryParams.value || queryParams
    return params.baseInfo?.length > 0 
      ? params.baseInfo 
      : [getMainModuleCode()]
  }

  const getMainModuleCode = () => {
    return mainModuleCode.value || mainModuleCode
  }

  const getMainModuleName = () => {
    return mainModuleName.value || mainModuleName
  }

  const handleExport = async () => {
    console.log('开始导出数据...')
    
    try {
      exportLoading.value = true
      
      const exportParams = {
        moduleCode: getMainModuleCode(),
        selectedModules: getSelectedModules(),
        joinField: 'tjh',
        exportAll: true,
        maxExport: 10000,
        conditions: buildExportConditions()
      }
      
      console.log('导出参数:', exportParams)
      
      // 调用导出 API - 返回 blob 数据
      const response = await exportApi.exportData(exportParams)
      
      // 使用 download.excel 处理文件下载
      const fileName = `${getMainModuleName()}_导出数据_${new Date().getTime()}.xlsx`
      download.excel(response, fileName) // 这里使用默认导入的 download 对象
      
      ElMessage.success('导出成功')
      
    } catch (error: any) {
      console.error('导出失败:', error)
      ElMessage.error('导出失败：' + (error.message || '未知错误'))
    } finally {
      exportLoading.value = false
    }
  }

  return {
    handleExport,
    exportLoading
  }
}