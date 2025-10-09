import request from '@/config/axios'

// 吸烟信息 VO
export interface ExperimentSurveySmokingInfoVO {
  id: number // 主键ID
  personId: number // 基础信息id
  smokingStatus: string // 吸烟情况
  dailyCigarettes: string // 每天抽烟的数量
  smokingStartAge: number // 开始吸烟时年龄
  smokingYears: string // 烟龄
  quitAttempted: string // 之前尝试过戒烟吗
  smokingRegion: string // 吸烟地区
  quitSmokingYears: string // 已戒烟.您的烟龄
  quitSmokingDuration: string // 已戒烟.您已戒烟
  quitSmokingRegion: string // 已戒烟.吸烟地区
  timePoint: number // 时相
}

// 吸烟信息 API
export const ExperimentSurveySmokingInfoApi = {
  // 查询吸烟信息分页
  getExperimentSurveySmokingInfoPage: async (params: any) => {
    return await request.get({ url: `/prospective/experiment-survey-smoking-info/page`, params })
  },

  // 查询吸烟信息详情
  getExperimentSurveySmokingInfo: async (id: number) => {
    return await request.get({ url: `/prospective/experiment-survey-smoking-info/get?id=` + id })
  },

  // 新增吸烟信息
  createExperimentSurveySmokingInfo: async (data: ExperimentSurveySmokingInfoVO) => {
    return await request.post({ url: `/prospective/experiment-survey-smoking-info/create`, data })
  },

  // 修改吸烟信息
  updateExperimentSurveySmokingInfo: async (data: ExperimentSurveySmokingInfoVO) => {
    return await request.put({ url: `/prospective/experiment-survey-smoking-info/update`, data })
  },

  // 删除吸烟信息
  deleteExperimentSurveySmokingInfo: async (id: number) => {
    return await request.delete({ url: `/prospective/experiment-survey-smoking-info/delete?id=` + id })
  },

  // 导出吸烟信息 Excel
  exportExperimentSurveySmokingInfo: async (params) => {
    return await request.download({ url: `/prospective/experiment-survey-smoking-info/export-excel`, params })
  },
}