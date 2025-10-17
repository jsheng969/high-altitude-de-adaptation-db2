import { ref, computed, watch } from 'vue'
import { 
  basicInfoFields, 
  experimentSurveyGroupFields, 
  experimentExamGroupFields 
} from '../fieldTypeMap'

export function useFieldManager(queryParams: any) {
  const displayedFields = ref({})

  const updateDisplayedFields = () => {
    const groupedFields: Record<string, any[]> = {}
    
    // 基础信息
    if (queryParams.baseInfo.length > 0) {
      groupedFields['基础信息'] = basicInfoFields.filter((field) =>
        queryParams.baseInfo.includes(field.label)
      )
    }

    // 实验组字段
    if ((queryParams.group === 1 || queryParams.group === 0) && queryParams.surveyOrExam === 'survey') {
      queryParams.experimentGroupSurvey.forEach((group: string) => {
        const filteredFields = getFilteredFields(queryParams.timePoint)
        if (filteredFields[group]) {
          groupedFields[group] = filteredFields[group]
        }
      })
    }

    if ((queryParams.group === 1 || queryParams.group === 0) && queryParams.surveyOrExam === 'exam') {
      queryParams.experimentGroupExam.forEach((group: string) => {
        if (experimentExamGroupFields[group]) {
          groupedFields[group] = experimentExamGroupFields[group]
        }
      })
    }

    displayedFields.value = groupedFields
  }

  const getFilteredFields = (timePoint?: number) => {
    const fields = { ...experimentSurveyGroupFields }
    
    if (timePoint !== 3) {
      fields['评分总数统计'] = fields['评分总数统计'].filter(
        (field) => field.prop !== 'experimentSurveyScoreSummaryRespVO.totalScore2'
      )
    }
    
    return fields
  }

  const fieldGroups = computed(() => {
    return convertToGroupedTree(displayedFields.value)
  })

  const convertToGroupedTree = (flatGroups: Record<string, any[]>) => {
    const tree: Record<string, Record<string, any[]>> = {}

    for (const [groupName, fields] of Object.entries(flatGroups)) {
      if (groupName === '基础信息') {
        tree['基础信息'] = { '基础信息字段': fields }
      } else if (experimentSurveyGroupFields[groupName]) {
        if (!tree['实验组流调']) tree['实验组流调'] = {}
        tree['实验组流调'][groupName] = fields
      } else if (experimentExamGroupFields[groupName]) {
        if (!tree['实验组体检']) tree['实验组体检'] = {}
        tree['实验组体检'][groupName] = fields
      } else {
        if (!tree['其他']) tree['其他'] = {}
        tree['其他'][groupName] = fields
      }
    }

    return tree
  }

  return {
    displayedFields,
    updateDisplayedFields,
    fieldGroups
  }
}