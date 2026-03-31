import { config } from '@/config/axios/config'

export const OmicsReportApi = {
  getReportFileUrl: (fileName: string) => {
    const safeFileName = encodeURIComponent(fileName)
    return `${config.base_url}/external/omics-report/file/${safeFileName}`
  }
}
