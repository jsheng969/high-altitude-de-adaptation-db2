import { ref } from 'vue'

export function useConditionManager() {
  const conditions = ref<any[]>([])
  const hasResidenceAreaCondition = ref(false)
  const residenceAreaOperatorText = ref('')

  const handleFieldSelect = (newConditions: any[]) => {
    conditions.value = newConditions
    const residenceAreaCondition = newConditions.find((c) => c.field === 'residenceArea')
    
    if (residenceAreaCondition) {
      hasResidenceAreaCondition.value = true
      residenceAreaOperatorText.value = residenceAreaCondition.displayText || ''
    } else {
      hasResidenceAreaCondition.value = false
      residenceAreaOperatorText.value = ''
    }
    
    const sqlConditions = normalizeConditions(newConditions)
    // 这里需要将条件设置到查询参数中
    // queryParams.advancedConditions = sqlConditions
  }

  const normalizeConditions = (conditions: any[]) => {
    // 实现条件规范化逻辑
    return conditions.map(condition => ({
      ...condition,
      normalized: true
    }))
  }

  return {
    conditions,
    hasResidenceAreaCondition,
    residenceAreaOperatorText,
    handleFieldSelect,
    normalizeConditions
  }
}