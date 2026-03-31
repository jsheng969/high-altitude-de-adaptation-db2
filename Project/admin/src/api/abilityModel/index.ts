import { config } from '@/config/axios/config'
import { service } from '@/config/axios/service'

export type AbilityModelType = '脑力' | '体力' | '精确'

const JAVA_BACKEND_BASE_URL = config.base_url
const JAVA_API_PREFIX = import.meta.env.VITE_API_URL || ''

const isAbsoluteUrl = (url: string) => /^https?:\/\//i.test(url)

const startsWithJavaApiPrefix = (path: string) => {
  if (!JAVA_API_PREFIX) return false
  return path === JAVA_API_PREFIX || path.startsWith(`${JAVA_API_PREFIX}/`)
}

export const normalizeAbilityModelFileUrl = (url?: string) => {
  if (!url) return ''

  const rawUrl = url.trim()
  if (!rawUrl) return ''

  if (rawUrl.startsWith(JAVA_BACKEND_BASE_URL) || startsWithJavaApiPrefix(rawUrl)) {
    return rawUrl
  }

  if (isAbsoluteUrl(rawUrl)) {
    const parsedUrl = new URL(rawUrl)

    if (startsWithJavaApiPrefix(parsedUrl.pathname)) {
      return rawUrl
    }

    return `${JAVA_BACKEND_BASE_URL}${parsedUrl.pathname}${parsedUrl.search}${parsedUrl.hash}`
  }

  const normalizedPath = rawUrl.startsWith('/') ? rawUrl : `/${rawUrl.replace(/^\.?\//, '')}`
  return `${JAVA_BACKEND_BASE_URL}${normalizedPath}`
}

export const toAbilityModelPreviewUrl = (downloadUrl?: string) => {
  const normalizedUrl = normalizeAbilityModelFileUrl(downloadUrl)
  if (!normalizedUrl || !normalizedUrl.includes('/api/file/download/')) {
    return ''
  }

  const parsedUrl = new URL(normalizedUrl, window.location.origin)
  parsedUrl.pathname = parsedUrl.pathname.replace('/api/file/download/', '/api/file/preview/')
  parsedUrl.searchParams.delete('action')

  if (isAbsoluteUrl(normalizedUrl)) {
    return parsedUrl.toString()
  }

  return `${parsedUrl.pathname}${parsedUrl.search}${parsedUrl.hash}`
}

export const normalizeAbilityModelDetailUrls = <T extends Record<string, any> | null>(data: T): T => {
  if (!data) return data

  const normalizedData = { ...data } as Record<string, any>

  Object.keys(normalizedData).forEach((key) => {
    const value = normalizedData[key]
    if (
      typeof value === 'string' &&
      (key.endsWith('_download_url') || key.endsWith('_preview_url'))
    ) {
      normalizedData[key] = normalizeAbilityModelFileUrl(value)
    }
  })

  return normalizedData as T
}

const unwrapAbilityModelResponse = <T>(response: any): T => {
  if (response && typeof response === 'object' && 'code' in response && 'data' in response) {
    return response.data as T
  }
  return response as T
}

export const AbilityModelApi = {
  trainUploadUrl: `${JAVA_BACKEND_BASE_URL}/api/upload/brainexcel`,
  predictionUploadUrl: `${JAVA_BACKEND_BASE_URL}/api/upload/brainmodel`,

  getTrainRecordsPage: async (params: {
    page: number
    page_size: number
    altitude_group: AbilityModelType
  }) => {
    const response = await service({
      method: 'GET',
      url: '/api/analysis/records/page',
      params
    })
    return unwrapAbilityModelResponse<{
      records?: any[]
      pagination?: Record<string, any>
    }>(response)
  },

  getTrainRecordDetail: async (recordId: number | string) => {
    const response = await service({
      method: 'GET',
      url: `/api/train/record/${recordId}`
    })
    return unwrapAbilityModelResponse<Record<string, any> | null>(response)
  },

  getPredictionRecordsPage: async (params: {
    page: number
    page_size: number
    altitude_group: AbilityModelType
  }) => {
    const response = await service({
      method: 'GET',
      url: '/api/prediction/records/page',
      params
    })
    return unwrapAbilityModelResponse<{
      records?: any[]
      pagination?: Record<string, any>
    }>(response)
  },

  getPredictionRecordDetail: async (recordId: number | string) => {
    const response = await service({
      method: 'GET',
      url: `/api/prediction/record/${recordId}`
    })
    return unwrapAbilityModelResponse<Record<string, any> | null>(response)
  }
}
