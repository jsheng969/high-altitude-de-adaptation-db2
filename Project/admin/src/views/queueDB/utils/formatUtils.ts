import { fieldTypeMaps } from '../fieldTypeMap'

/**
 * mapFieldConfigs 对象用于配置字段对应的映射关系、数据源和分隔符。
 */
export const mapFieldConfigs: Record<
  string,
  { map: Record<string, string>; source: string; separator?: string }
> = {
  drinkingType: {
    map: fieldTypeMaps.drinkingTypeMap,
    source: 'experimentSurveyDrinkingRespVO'
  },
  cardiovascularCirculatorySystem: {
    map: fieldTypeMaps.cardiovascularCirculatorySystemMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  respiratorySystem: {
    map: fieldTypeMaps.respiratorySystemMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  metabolicSystem: {
    map: fieldTypeMaps.metabolicSystemMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  digestiveSystem: {
    map: fieldTypeMaps.digestiveSystemMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  nervousSystem: {
    map: fieldTypeMaps.nervousSystemMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  cancer: {
    map: fieldTypeMaps.cancerMap,
    source: 'experimentSurveyFamilyDiseasesRespVO'
  },
  highlandDiseases: {
    map: fieldTypeMaps.highlandDiseasesMap,
    source: 'experimentSurveyHighlandDiseasesRespVO'
  },
  highlandReactionSymptoms: {
    map: fieldTypeMaps.highlandReactionSymptomsMap,
    source: 'experimentSurveyHighlandReactionSymptomsRespVO'
  },
  residenceArea: {
    map: fieldTypeMaps.residenceAreaMap,
    source: 'experimentSurveyPostReturnInfoRespVO',
    separator: ';'
  },
  highlandDiseasesDuringService: {
    map: fieldTypeMaps.highlandDiseasesDuringServiceMap,
    source: 'experimentSurveyHighlandDiseasesDuringServiceRespVO'
  },
  newDiseasesPostReturn: {
    map: fieldTypeMaps.newDiseasesPostReturnMap,
    source: 'experimentSurveyNewDiseasesPostReturnRespVO'
  },
  dietType: {
    map: fieldTypeMaps.dietTypeMap,
    source: 'experimentSurveyDietRespVO'
  },
  diseaseSpectrumDigestiveSystem: {
    map: fieldTypeMaps.diseaseSpectrumDigestiveSystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumCardiovascularSystem: {
    map: fieldTypeMaps.diseaseSpectrumCardiovascularSystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumEndocrineSystem: {
    map: fieldTypeMaps.diseaseSpectrumEndocrineSystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumRespiratorySystem: {
    map: fieldTypeMaps.diseaseSpectrumRespiratorySystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumUrinarySystem: {
    map: fieldTypeMaps.diseaseSpectrumUrinarySystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumSkeletalSystem: {
    map: fieldTypeMaps.diseaseSpectrumSkeletalSystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumNervousSystem: {
    map: fieldTypeMaps.diseaseSpectrumNervousSystemMap,
    source: 'experimentDiseaseSpectrumRespVO'
  },
  diseaseSpectrumDigestiveSystemControl: {
    map: fieldTypeMaps.diseaseSpectrumDigestiveSystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumCardiovascularSystemControl: {
    map: fieldTypeMaps.diseaseSpectrumCardiovascularSystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumEndocrineSystemControl: {
    map: fieldTypeMaps.diseaseSpectrumEndocrineSystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumRespiratorySystemControl: {
    map: fieldTypeMaps.diseaseSpectrumRespiratorySystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumUrinarySystemControl: {
    map: fieldTypeMaps.diseaseSpectrumUrinarySystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumSkeletalSystemControl: {
    map: fieldTypeMaps.diseaseSpectrumSkeletalSystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  },
  diseaseSpectrumNervousSystemControl: {
    map: fieldTypeMaps.diseaseSpectrumNervousSystemMap,
    source: 'controlDiseaseSpectrumRespVO'
  }
}

/**
 * 判断一个值是否为"真"
 */
export function isTruthy(val: any): boolean {
  return val !== false && val !== '否' && val !== 0 && val !== '0' && val !== null && val !== undefined && val !== ''
}

/**
 * 格式化选中的类型名称为字符串
 */
export function formatSelectedTypes(
  dataObj: Record<string, any>,
  typeMap: Record<string, string>,
  separator = '，'
): string {
  return (
    Object.entries(typeMap)
      .filter(([key]) => isTruthy(dataObj[key]))
      .map(([, label]) => label)
      .join(separator) || '-'
  )
}

/**
 * 格式化服役时间
 */
export function formatServiceTime(info: any, index: string): string {
  const year = Number(info?.[`year${index}`])
  const month = Number(info?.[`month${index}`])
  if (!isNaN(year) && year !== 0) {
    return !isNaN(month) && month !== 0 ? `${year} 年 ${month} 月` : `${year} 年`
  }
  if (!isNaN(month) && month !== 0) return `${month} 月`
  return '-'
}

/**
 * 格式化总服役时间
 */
export function formatTotalServiceTime(info: any): string {
  let totalMonths = 0

  for (let i = 1; i <= 6; i++) {
    const year = Number(info?.[`year${i}`]) || 0
    const month = Number(info?.[`month${i}`]) || 0
    totalMonths += year * 12 + month
  }

  const finalYear = Math.floor(totalMonths / 12)
  const finalMonth = totalMonths % 12

  if (finalYear > 0 && finalMonth > 0) return `${finalYear} 年 ${finalMonth} 月`
  if (finalYear > 0) return `${finalYear} 年`
  if (finalMonth > 0) return `${finalMonth} 月`
  return '-'
}

/**
 * 格式化高原反应次数
 */
export function formatReactionCount(info: any): string {
  return isTruthy(info.unclearReactionCount) ? '记不清' : info.reactionCountText || '-'
}

/**
 * 格式化居住时间
 */
export function formatResidenceTime(info: any): string {
  const keys = ['chengdu', 'kunming', 'xining', 'otherArea']
  const result = keys
    .filter((key) => isTruthy(info[key]))
    .map((key) => info[`${key}ResidenceTime`])
    .filter(Boolean)
  return result.length > 0 ? result.join(';') : '-'
}

/**
 * 格式化体育锻炼形式
 */
export function formatExerciseType(info: any): string {
  const result: string[] = []
  if (info.exerciseType != 0 && info.exerciseType !== '0') {
    result.push(String(info.exerciseType))
  }
  if (info.exerciseDuration != 0 && info.exerciseDuration !== '0') {
    result.push(String(info.exerciseDuration))
  }
  return result.length > 0 ? result.join(',') : '-'
}

/**
 * 通用格式化将多个字段名与字段值拼接
 */
export function formatKeyAndValue(info: any): string {
  const typeMap = fieldTypeMaps.reasonsAffectingSleepMap
  const selectedTypes = Object.entries(typeMap)
    .filter(([key]) => {
      const val = info[key]
      return val !== undefined && val !== null && val !== '0' && val !== 0
    })
    .map(([key, label]) => `${label}${info[key]}`)

  return selectedTypes.length > 0 ? selectedTypes.join('；') : '-'
}

/**
 * 主要的字段格式化函数
 */
export const formatField = (row: any, column: any, cellValue: any) => {
  const prop = column.property

  // 处理 framingham 风险类型
  if (
    prop === 'experimentFraminghamRespVO.framinghamRiskType' ||
    prop === 'controlFraminghamRespVO.framinghamRiskType'
  ) {
    if (cellValue === 'low') {
      return '低风险'
    } else if (cellValue === 'medium') {
      return '中风险'
    } else if (cellValue === 'high') {
      return '高风险'
    }
  }

  // 处理布尔值
  if (typeof cellValue === 'boolean') {
    return cellValue ? '是' : '否'
  }

  // 处理字符串 '0'
  if (typeof cellValue === 'string' && cellValue === '0') {
    return '-'
  }

  // 处理服务时间差：退役年份 - 进入高原年份
  if (prop === 'serviceDuration') {
    const start = parseInt(row.experimentSurveyServiceInfoRespVO?.highlandEntryYear)
    const end = parseInt(row.experimentSurveyServiceInfoRespVO?.dischargeYear)
    return !isNaN(start) && !isNaN(end) ? `${end - start} 年` : '-'
  }

  // 处理 serviceTime1 ~ serviceTime6
  if (prop.startsWith('serviceTime')) {
    const match = prop.match(/serviceTime(\d)/)
    return match
      ? formatServiceTime(row.experimentSurveyServiceInfoRespVO, match[1])
      : formatTotalServiceTime(row.experimentSurveyServiceInfoRespVO)
  }

  // 单独处理饮酒类型
  if (prop === 'drinkingType') {
    return formatSelectedTypes(row.experimentSurveyDrinkingRespVO || {}, mapFieldConfigs[prop].map)
  }

  // 通用 map 字段处理
  if (mapFieldConfigs[prop]) {
    const { map, source, separator = '，' } = mapFieldConfigs[prop]
    const data = row[source] || {}
    return formatSelectedTypes(data, map, separator)
  }

  // 特殊字段处理：高原反应次数
  if (prop === 'reactionCount') {
    const info = row.experimentSurveyHighlandReactionRespVO || {}
    return formatReactionCount(info)
  }

  // 特殊字段处理：每年居住时间
  if (prop === 'residenceTime') {
    const info = row.experimentSurveyPostReturnInfoRespVO || {}
    return formatResidenceTime(info)
  }

  // 特殊字段处理：体育锻炼形式
  if (prop === 'exerciseType') {
    const info = row.experimentSurveyExerciseRespVO || {}
    return formatExerciseType(info)
  }

  // 特殊字段处理：实验组流调-影响睡眠烦恼原因
  if (prop === 'reasonsAffectingSleep') {
    const info = row.experimentSurveySleepRespVO || {}
    return formatKeyAndValue(info)
  }

  // 处理总分类型
  if (prop === 'totalScoreType') {
    if (row.experimentSurveyScoreSummaryRespVO?.totalScore < 6) {
      return '阴'
    } else if (
      row.experimentSurveyScoreSummaryRespVO?.totalScore >= 6 &&
      row.experimentSurveyScoreSummaryRespVO?.totalScore <= 15
    ) {
      return '轻'
    } else if (
      row.experimentSurveyScoreSummaryRespVO?.totalScore >= 16 &&
      row.experimentSurveyScoreSummaryRespVO?.totalScore <= 25
    ) {
      return '中'
    } else if (row.experimentSurveyScoreSummaryRespVO?.totalScore > 25) {
      return '重'
    }
  }

  // 处理转归类型
  if (prop === 'conversionType') {
    const baselineScore = row.experimentSurveyScoreSummaryRespVO?.totalScore2
    const followupScore = row.experimentSurveyScoreSummaryRespVO?.totalScore

    const getScoreCategory = (score: number) => {
      if (score == null) return null
      if (score < 6) return '阴'
      if (score <= 15) return '轻'
      if (score <= 25) return '中'
      return '重'
    }

    const baseline = getScoreCategory(baselineScore)
    const followup = getScoreCategory(followupScore)

    if (baseline == null || followup == null) return '数据缺失'
    if (baseline === '重' && followup === '重') return '持续重度'
    if (baseline === '阴' && followup === '阴') return '持续阴性'
    if (baseline !== '阴' && followup !== '阴' && baseline === followup) {
      return `持续阳性`
    }
    if (baseline === '阴' && followup !== '阴') return '阴性转阳性'
    if (baseline !== '阴' && followup === '阴') return '阳性转阴性'
    if (followup === '重' && baseline !== '重') return '转为重度'

    return '其他变化'
  }

  // 默认回退值
  return cellValue ?? '-'
}

/**
 * 计算表格列的自适应宽度
 */
export const getAutoMinWidth = (label: string, prop: any, list: any[]): string => {
  const maxDataLen = list.reduce((max, row) => {
    const cellValue = prop?.split('.').reduce((obj, key) => obj?.[key], row)
    const formatted = formatField(row, { property: prop }, cellValue)
    return Math.max(max, formatted?.length || 0)
  }, 0)

  const labelLen = label.length
  const maxLen = Math.max(labelLen, maxDataLen)
  return `${maxLen * 14 + 40}px`
}

/**
 * 格式化月份为年月格式
 */
export const formatToYearMonth = (months: number) => {
  const years = Math.floor(months / 12)
  const remainingMonths = Math.ceil(months % 12)
  if (remainingMonths === 12) {
    return `${years + 1}年0月`
  }
  return `${years}年${remainingMonths}月`
}