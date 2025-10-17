export interface QueryParams {
  pageNo: number
  pageSize: number
  group: number
  type?: number
  year?: number
  vip?: number
  surveyOrExam: string
  groupType: number
  timePoint: number
  name?: string
  mobile?: string
  status?: string
  deptId?: number
  createTime: any[]
  baseInfo: string[]
  experimentGroupSurvey: string[]
  experimentGroupExam: string[]
  compareGroupSurvey: string[]
  compareGroupExam: string[]
  reviewBasicInfoFields: string[]
  advancedConditions: any[]
}

export interface TableField {
  label: string
  prop: string
}

export interface AverageData {
  dataRatio: number
  maleCount: number
  femaleCount: number
  averageAge: number
  minAge: number
  maxAge: number
  averagePlateauMissionDuration: number
  maxPlateauMissionDuration: number
  minPlateauMissionDuration: number
  scoreLt6: number
  score6To15: number
  score16To25: number
  scoreGt25: number
  scoreGte6: number
  [key: string]: any
}

export interface Condition {
  field: string
  operator: string
  value: any
  logic?: string
  displayText?: string
}