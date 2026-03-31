<template>
  <div class="model-page">
    <div class="page-header">
      <div>
        <div class="page-title">{{ title }}</div>
        <div class="page-desc">上传 Excel 文件并查看预测记录</div>
      </div>
    </div>

    <el-card shadow="never" class="card-wrap mb-16px">
      <template #header>
        <div class="card-title">Excel 文件上传</div>
      </template>

      <div
        class="upload-area"
        @click="handleUploadAreaClick"
        @dragover.prevent="isDragover = true"
        @dragleave="isDragover = false"
        @drop.prevent="handleDrop"
        :class="{ 'is-dragover': isDragover }"
      >
        <input
          ref="fileInputRef"
          type="file"
          class="hidden-input"
          accept=".xlsx,.xls"
          @change="handleFileChange"
        />
        <el-icon class="upload-icon"><UploadFilled /></el-icon>
        <div class="upload-text">点击或拖拽 Excel 文件至此处上传</div>
        <div class="upload-tip">支持 .xlsx、.xls 格式文件，单个文件不超过 10MB</div>
        <el-button type="primary" class="mt-16px" @click.stop="triggerFileSelect">
          选择文件
        </el-button>
      </div>

      <div v-if="uploadStatusVisible" class="status-wrap">
        <div v-if="uploadState === 'uploading'">
          <div class="status-text primary-text">{{ uploadingText }}</div>
          <el-progress :percentage="uploadProgress" :stroke-width="8" />
        </div>

        <el-alert
          v-else-if="uploadState === 'success'"
          :title="successText"
          type="success"
          :closable="false"
          show-icon
        />

        <el-alert
          v-else-if="uploadState === 'error'"
          :title="errorText"
          type="error"
          :closable="false"
          show-icon
        />
      </div>
    </el-card>

    <el-card shadow="never" class="card-wrap">
      <template #header>
        <div class="list-header">
          <span class="card-title">{{ title }}记录</span>
          <span class="total-text">
            共 <span class="total-num">{{ total }}</span> 条记录
          </span>
        </div>
      </template>

      <el-table v-loading="tableLoading" :data="list" border>
        <el-table-column label="序号" width="80">
          <template #default="scope">
            {{ (currentPage - 1) * pageSize + scope.$index + 1 }}
          </template>
        </el-table-column>

        <el-table-column prop="original_filename" label="原文件名" min-width="240" show-overflow-tooltip />

        <el-table-column label="结果文件名" min-width="220" show-overflow-tooltip>
          <template #default="{ row }">
            {{ getFileName(row.file_result_path) || '-' }}
          </template>
        </el-table-column>

        <el-table-column prop="create_time" label="上传时间" min-width="180" />

        <el-table-column label="操作" width="140" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="handleViewDetail(row.id)">
              查看明细
            </el-button>
          </template>
        </el-table-column>

        <template #empty>
          <div class="table-empty">暂无预测记录</div>
        </template>
      </el-table>

      <div class="pagination-wrap" v-if="total > 0">
        <el-button :disabled="currentPage <= 1" @click="handlePrevPage">上一页</el-button>
        <el-button type="primary" plain disabled>{{ currentPage }}</el-button>
        <el-button :disabled="currentPage >= totalPages" @click="handleNextPage">下一页</el-button>
      </div>
    </el-card>

    <el-dialog
      v-model="detailVisible"
      :title="`${title}明细`"
      width="920px"
      destroy-on-close
      @close="handleDialogClose"
    >
      <div v-loading="detailLoading">
        <el-result
          v-if="detailError"
          icon="error"
          title="加载明细数据失败"
          sub-title="请稍后重试"
        />

        <template v-else-if="detailData">
          <el-card shadow="never" class="mb-16px">
            <template #header>
              <div class="dialog-card-title">基本信息</div>
            </template>

            <el-descriptions :column="1" border>
              <el-descriptions-item label="原文件名">
                {{ detailData.original_filename || '无' }}
              </el-descriptions-item>
              <el-descriptions-item label="上传时间">
                {{ detailData.create_time || '无' }}
              </el-descriptions-item>
            </el-descriptions>
          </el-card>

          <el-card shadow="never" class="mb-16px">
            <template #header>
              <div class="dialog-card-title">结果文件</div>
            </template>

            <div class="file-list">
              <div v-if="detailData.file_result_path" class="file-row">
                <div class="file-meta">
                  <div class="file-name-title">预测结果文件</div>
                  <!-- <div class="file-name">{{ detailData.file_result_path }}</div> -->
                </div>
                <el-button type="primary" plain @click="openDownload(detailData.file_result_download_url)">
                  下载
                </el-button>
              </div>

              <div v-if="detailData.type_path" class="file-row image-row">
                <div class="file-meta full-width">
                  <div class="file-name-title">预测结果图表</div>
                  <!-- <div class="file-name">{{ detailData.type_path }}</div> -->
                  <div class="image-wrap" v-if="detailData.type_preview_url">
                    <img :src="detailData.type_preview_url" alt="预测结果图表" />
                  </div>
                  <div v-else class="image-error-text">未获取到图表预览地址</div>
                </div>
              </div>
            </div>
          </el-card>
        </template>
      </div>

      <template #footer>
        <el-button @click="detailVisible = false">关闭</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { UploadFilled } from '@element-plus/icons-vue'
import { getAccessToken, getTenantId } from '@/utils/auth'
import {
  AbilityModelApi,
  normalizeAbilityModelDetailUrls,
  type AbilityModelType
} from '@/api/abilityModel'

type UploadState = 'idle' | 'uploading' | 'success' | 'error'

const props = defineProps<{
  title: string
  datatype: AbilityModelType
}>()

const fileInputRef = ref<HTMLInputElement | null>(null)
const isDragover = ref(false)

const uploadStatusVisible = ref(false)
const uploadState = ref<UploadState>('idle')
const uploadProgress = ref(0)
const uploadingText = ref('文件上传中，请稍候...')
const successText = ref('文件上传成功')
const errorText = ref('文件上传失败，请重试')

const tableLoading = ref(false)
const list = ref<any[]>([])
const total = ref(0)
const currentPage = ref(1)
const pageSize = ref(10)
const totalPages = ref(1)

const detailVisible = ref(false)
const detailLoading = ref(false)
const detailError = ref(false)
const detailData = ref<any>(null)

const showUploadStatus = (state: UploadState) => {
  uploadStatusVisible.value = true
  uploadState.value = state
  if (state !== 'uploading') uploadProgress.value = 0
}

const hideUploadStatusLater = (delay = 3000) => {
  window.setTimeout(() => {
    uploadStatusVisible.value = false
    uploadState.value = 'idle'
    uploadProgress.value = 0
  }, delay)
}

const triggerFileSelect = () => fileInputRef.value?.click()
const handleUploadAreaClick = () => triggerFileSelect()

const validateExcelFile = (file: File) => {
  const fileTypes = [
    'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
    'application/vnd.ms-excel'
  ]
  const fileExtensions = ['.xlsx', '.xls']
  const fileName = file.name.toLowerCase()
  const isExcel =
    fileTypes.includes(file.type) || fileExtensions.some((ext) => fileName.endsWith(ext))

  if (!isExcel) {
    ElMessage.error('请上传有效的 Excel 文件（.xlsx 或 .xls 格式）')
    return false
  }

  if (file.size > 10 * 1024 * 1024) {
    ElMessage.error('文件大小不能超过 10MB')
    return false
  }

  return true
}

const handleFileUpload = (file: File) => {
  if (!validateExcelFile(file)) return

  const formData = new FormData()
  formData.append('file', file)
  formData.append('datatype', props.datatype)

  showUploadStatus('uploading')
  uploadingText.value = `正在上传 ${file.name}...`

  const xhr = new XMLHttpRequest()
  xhr.open('POST', AbilityModelApi.predictionUploadUrl, true)
  const accessToken = getAccessToken()
  if (accessToken) {
    xhr.setRequestHeader('Authorization', `Bearer ${accessToken}`)
  }
  const tenantId = getTenantId()
  if (tenantId) {
    xhr.setRequestHeader('tenant-id', tenantId)
  }

  xhr.upload.addEventListener('progress', (e) => {
    if (e.lengthComputable) {
      const percent = Math.round((e.loaded / e.total) * 100)
      uploadProgress.value = percent
      if (percent < 100) {
        uploadingText.value = `正在上传 ${file.name} (${percent}%)...`
      } else {
        uploadingText.value = '文件上传完成，正在处理...'
      }
    }
  })

  xhr.addEventListener('load', async () => {
    if (xhr.status >= 200 && xhr.status < 300) {
      try {
        const response = JSON.parse(xhr.responseText)
        showUploadStatus('success')
        successText.value = `文件「${file.name}」上传成功！${response.msg || '预测完成'}`
      } catch {
        showUploadStatus('success')
        successText.value = `文件「${file.name}」上传成功`
      }
      await loadRecords()
      hideUploadStatusLater(3000)
    } else {
      showUploadStatus('error')
      errorText.value = `文件上传失败：${xhr.statusText || '服务器错误'} (${xhr.status})`
      hideUploadStatusLater(5000)
    }
  })

  xhr.addEventListener('error', () => {
    showUploadStatus('error')
    errorText.value = '文件上传失败：无法连接到服务器，请检查后端服务是否运行'
    hideUploadStatusLater(5000)
  })

  xhr.timeout = 30000
  xhr.addEventListener('timeout', () => {
    showUploadStatus('error')
    errorText.value = '文件上传失败：请求超时（30秒）'
    hideUploadStatusLater(5000)
  })

  xhr.send(formData)
}

const handleDrop = (e: DragEvent) => {
  isDragover.value = false
  const files = e.dataTransfer?.files
  if (files && files.length > 0) handleFileUpload(files[0])
}

const handleFileChange = (e: Event) => {
  const target = e.target as HTMLInputElement
  const file = target.files?.[0]
  if (file) handleFileUpload(file)
  target.value = ''
}

const loadRecords = async () => {
  tableLoading.value = true
  try {
    const result = await AbilityModelApi.getPredictionRecordsPage({
      page: currentPage.value,
      page_size: pageSize.value,
      altitude_group: props.datatype
    })
    const pagination = result?.pagination || {}
    list.value = result?.records || []
    total.value = pagination.total || 0
    currentPage.value = pagination.page || 1
    pageSize.value = pagination.page_size || 10
    totalPages.value = pagination.total_pages || 1
  } catch (error: any) {
    list.value = []
    total.value = 0
    totalPages.value = 1
    ElMessage.error(error?.message || '加载预测记录失败')
  } finally {
    tableLoading.value = false
  }
}

const handlePrevPage = async () => {
  if (currentPage.value > 1) {
    currentPage.value--
    await loadRecords()
  }
}

const handleNextPage = async () => {
  if (currentPage.value < totalPages.value) {
    currentPage.value++
    await loadRecords()
  }
}

const handleViewDetail = async (recordId: number | string) => {
  detailVisible.value = true
  detailLoading.value = true
  detailError.value = false
  detailData.value = null

  try {
    const result = await AbilityModelApi.getPredictionRecordDetail(recordId)
    detailData.value = normalizeAbilityModelDetailUrls(result || null)
  } catch {
    detailError.value = true
  } finally {
    detailLoading.value = false
  }
}

const openDownload = (url?: string) => {
  if (!url) {
    ElMessage.warning('文件不存在')
    return
  }
  window.open(url, '_blank', 'noopener,noreferrer')
}

const getFileName = (path?: string) => {
  if (!path) return ''
  return path.split(/[\\/]/).pop() || ''
}

const handleDialogClose = () => {
  detailLoading.value = false
  detailError.value = false
  detailData.value = null
}

onMounted(() => {
  loadRecords()
})
</script>

<style scoped lang="scss">
.model-page {
  padding: 16px;
  background: #f5f7fa;
  min-height: calc(100vh - 50px);
}
.page-header {
  margin-bottom: 16px;
}
.page-title {
  font-size: 22px;
  font-weight: 600;
  color: #303133;
}
.page-desc {
  margin-top: 4px;
  font-size: 14px;
  color: #909399;
}
.card-wrap {
  border-radius: 8px;
}
.card-title,
.dialog-card-title {
  font-size: 16px;
  font-weight: 600;
  color: #303133;
}
.upload-area {
  border: 2px dashed #dcdfe6;
  border-radius: 8px;
  padding: 32px 16px;
  text-align: center;
  cursor: pointer;
  transition: all 0.3s;
  background: #fff;
}
.upload-area:hover,
.upload-area.is-dragover {
  border-color: #409eff;
  background: #ecf5ff;
}
.hidden-input {
  display: none;
}
.upload-icon {
  font-size: 48px;
  color: #409eff;
}
.upload-text {
  margin-top: 12px;
  font-size: 15px;
  color: #606266;
}
.upload-tip {
  margin-top: 8px;
  font-size: 13px;
  color: #909399;
}
.status-wrap {
  margin-top: 16px;
}
.primary-text {
  color: #409eff;
  margin-bottom: 8px;
}
.list-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.total-text {
  font-size: 14px;
  color: #909399;
}
.total-num {
  color: #409eff;
  font-weight: 600;
}
.table-empty {
  padding: 24px 0;
  color: #909399;
}
.pagination-wrap {
  margin-top: 16px;
  display: flex;
  justify-content: center;
  gap: 8px;
}
.file-list {
  display: flex;
  flex-direction: column;
  gap: 12px;
}
.file-row {
  border: 1px solid #ebeef5;
  border-radius: 8px;
  padding: 16px;
  display: flex;
  justify-content: space-between;
  gap: 16px;
  align-items: flex-start;
}
.file-meta {
  flex: 1;
  min-width: 0;
}
.file-name-title {
  font-weight: 600;
  color: #303133;
  margin-bottom: 6px;
}
.file-name {
  color: #909399;
  word-break: break-all;
}
.full-width {
  width: 100%;
}
.image-wrap {
  margin-top: 12px;
  display: flex;
  justify-content: center;
}
.image-wrap img {
  max-width: 100%;
  max-height: 420px;
  border: 1px solid #ebeef5;
  border-radius: 6px;
}
.image-error-text {
  margin-top: 12px;
  color: #f56c6c;
}
</style>
