import { fieldTypeMaps } from './fieldTypeMap'

/**
 * mapFieldConfigs 对象用于配置字段对应的映射关系、数据源和分隔符。
 * key为字段名，value包含：
 *  - map: 对应的类型映射表
 *  - source: 数据来源对象的字段名
 *  - separator: 多选项连接时使用的分隔符（可选）
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
 * 判断一个值是否为“真”，包括布尔 true、字符串 '是' 和数字 1。
 * @param val - 需要判断的值
 * @returns 如果值为 true、'是' 或 1，则返回 true，否则返回 false
 */
export function isTruthy(val: any): boolean {
  return val !== false && val !== '否' && val !== 0 && val !== '0' && val !== null && val !== undefined && val !== ''
}

/**
 * 根据给定的类型映射和数据对象，格式化选中的类型名称为字符串。
 * 只会选出数据对象中对应字段值为“真”的类型标签，最后用指定分隔符连接。
 * @param dataObj - 包含各类型布尔或标识值的数据对象
 * @param typeMap - key为字段名，value为对应显示的标签名称的映射表
 * @param separator - 连接多个标签的分隔符，默认为中文逗号 '，'
 * @returns 连接后的字符串，若无选中项则返回 '-'
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
 * 格式化服役时间，支持显示年和月两部分。
 * 如果年和月均有且非零，返回“X 年 Y 月”，否则只显示存在且非零的部分。
 * @param info - 包含年份和月份的对象
 * @param index - 表示具体哪个时间字段的索引，用于动态访问 yearX 和 monthX 字段
 * @returns 格式化后的字符串，如“2 年 5 月”，或“-”表示无数据
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
 * 格式化高原反应次数的显示。
 * 如果反应次数为“记不清”，则返回“记不清”，否则返回具体的次数描述或“-”。
 * @param info - 包含反应次数信息的对象
 * @returns 反应次数的文本描述，或“-”
 */
export function formatReactionCount(info: any): string {
  return isTruthy(info.unclearReactionCount) ? '记不清' : info.reactionCountText || '-'
}

/**
 * 格式化在不同城市的居住时间，支持多个城市同时显示。
 * 只选取居住过且居住时间存在的城市时间，用分号分隔。
 * @param info - 包含各城市居住信息的对象
 * @returns 格式化后的居住时间字符串，如“12 月; 8 月”，或“-”
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
 * 格式化实验组流调-体育锻炼形式，拼接类型和时长
 * * @param info - 包含 experimentSurveyExerciseRespVO 的数据对象
 * @returns 格式化字符串，或 '-' 表示无数据
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
 * 通用格式化将多个字段名与字段值拼接，通过分隔符分隔
 * @param info
 * @returns 连接后的字符串，若无选中项则返回 '-'
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

