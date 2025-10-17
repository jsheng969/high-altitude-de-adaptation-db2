import { ref } from 'vue'
import { BasicInfoApi } from '@/api/prospective/basicinfo'
import download from '@/utils/download'
// import { useMessage } from '@/hooks/useMessage'

export function useExportHandler(queryParams: any) {
  const exportLoading = ref(false)
  const { message } = useMessage()

  const handleExport = async () => {
    try {
      await message.exportConfirm()
      exportLoading.value = true
      
      const data = await BasicInfoApi.exportProspective(queryParams)
      const fileName = queryParams.group == 1 ? '前瞻性-实验组.xls' : '前瞻性-对照组.xls'
      
      download.excel(data, fileName)
    } catch (error) {
      console.error('导出失败:', error)
    } finally {
      exportLoading.value = false
    }
  }

  return {
    handleExport,
    exportLoading
  }
}