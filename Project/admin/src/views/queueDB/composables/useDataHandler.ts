import { ref, Ref } from 'vue'
import { BasicInfoApi } from '@/api/prospective/basicinfo'

export function useDataHandler(
  queryParams: any,
  list: Ref<any[]>,
  total: Ref<number>,
  average: Ref<any>,
  loading: Ref<boolean>
) {
  const getList = async () => {
    loading.value = true
    try {
      // 准备查询参数
      queryParams.reviewBasicInfoFields = prepareBasicInfoFields(queryParams.baseInfo)
      
      // 获取平均值和数据
      const [averageData, pageData] = await Promise.all([
        BasicInfoApi.getAverageByParam(queryParams),
        BasicInfoApi.getDataByParamPage(queryParams)
      ])

      average.value = averageData
      list.value = pageData.list
      total.value = pageData.total
    } finally {
      loading.value = false
    }
  }

  const loadPageData = async () => {
    const data = await BasicInfoApi.getDataByParamPage(queryParams)
    list.value = data.list
    total.value = data.total
    return data
  }

  const prepareBasicInfoFields = (baseInfo: string[]) => {
    // 这里需要根据实际的 basicInfoFields 来映射
    const fieldMap = {
      '编号': 'code',
      '实际年龄': 'actualAge',
      '性别': 'gender',
      // ... 其他字段映射
    }
    
    return baseInfo.map(label => fieldMap[label]).filter(Boolean)
  }

  return {
    getList,
    loadPageData
  }
}