<template>
  <div class="report-page">
    <div class="tab-row">
      <el-button
        :type="activeTab === 'acute' ? 'primary' : 'default'"
        class="tab-btn"
        @click="switchTab('acute')"
      >
        急性高原病预测
      </el-button>
      <el-button
        :type="activeTab === 'chronic' ? 'primary' : 'default'"
        class="tab-btn"
        @click="switchTab('chronic')"
      >
        慢性高原病预测
      </el-button>
    </div>

    <el-card shadow="never" class="panel-card">
      <div class="panel-tip">
        支持按需上传 .sav 训练集和验证集文件；如果不上传，系统会继续使用服务端
        <code>shared/defaults</code> 下的默认文件生成预测结果。
      </div>

      <el-row :gutter="16" class="upload-row">
        <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24">
          <div class="upload-panel">
            <div class="upload-panel__title">训练集</div>
            <div class="upload-panel__desc"> 可选上传，未上传时自动回退到默认训练集文件。 </div>
            <el-upload
              action=""
              drag
              :auto-upload="false"
              :multiple="false"
              accept=".sav"
              :file-list="trainFileList"
              :on-change="onTrainFileChange"
              :on-remove="onTrainFileRemove"
            >
              <div class="upload-trigger-text">将 .sav 文件拖到此处，或点击上传</div>
              <template #tip>
                <div class="el-upload__tip">
                  {{
                    trainFile ? `当前文件：${trainFile.name}` : '未上传，生成时将使用默认训练集文件'
                  }}
                </div>
              </template>
            </el-upload>
          </div>
        </el-col>

        <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24">
          <div class="upload-panel">
            <div class="upload-panel__title">验证集</div>
            <div class="upload-panel__desc"> 可选上传，未上传时自动回退到默认验证集文件。 </div>
            <el-upload
              action=""
              drag
              :auto-upload="false"
              :multiple="false"
              accept=".sav"
              :file-list="validFileList"
              :on-change="onValidFileChange"
              :on-remove="onValidFileRemove"
            >
              <div class="upload-trigger-text">将 .sav 文件拖到此处，或点击上传</div>
              <template #tip>
                <div class="el-upload__tip">
                  {{
                    validFile ? `当前文件：${validFile.name}` : '未上传，生成时将使用默认验证集文件'
                  }}
                </div>
              </template>
            </el-upload>
          </div>
        </el-col>
      </el-row>

      <div class="action-row">
        <el-button type="primary" :loading="loading" @click="runReport">显示预测结果</el-button>
      </div>
    </el-card>

    <el-card v-if="hasResult" shadow="never" class="panel-card">
      <div class="result-header">
        <div class="result-left">
          <span class="result-title">{{ reportTitle }}</span>
          <span class="result-time">{{ resultTime || '--' }}</span>
        </div>
        <div class="result-right">
          <el-button @click="refreshResult" :disabled="!currentTaskId">刷新结果</el-button>
          <el-button type="primary" :disabled="!pdfDisplayUrl" @click="openPdf">打开PDF</el-button>
        </div>
      </div>

      <el-row :gutter="20">
        <el-col
          v-for="item in charts"
          :key="item.key"
          :xl="8"
          :lg="12"
          :md="12"
          :sm="24"
          :xs="24"
          class="chart-col"
        >
          <div class="chart-panel">
            <!-- <div class="chart-title">{{ item.name }}</div> -->

            <div v-if="item.url" class="chart-img-wrap">
              <img
                :src="item.url"
                :alt="item.name"
                class="chart-img previewable-img"
                @click="previewImage(item)"
              />
            </div>

            <div v-else class="empty-preview">
              <el-empty description="图片地址为空" :image-size="80" />
            </div>
          </div>
        </el-col>
      </el-row>

      <el-dialog
        v-model="previewVisible"
        :title="previewTitle"
        width="70%"
        top="5vh"
        destroy-on-close
        class="image-preview-dialog"
      >
        <div class="preview-dialog-body">
          <img v-if="previewUrl" :src="previewUrl" :alt="previewTitle" class="preview-dialog-img" />
          <el-empty v-else description="图片地址为空" :image-size="80" />
        </div>
      </el-dialog>

      <!-- <div class="pdf-section">
        <div class="section-title">报告 PDF</div>
        <div v-if="pdfDisplayUrl" class="pdf-wrap">
          <iframe :src="pdfDisplayUrl" width="100%" height="620" frameborder="0"></iframe>
        </div>
        <div v-else class="empty-preview">
          <el-empty description="PDF 地址为空" :image-size="80" />
        </div>
      </div>

      <div v-if="metricCards.length" class="metric-section">
        <div class="section-title">模型指标</div>
        <el-row :gutter="16">
          <el-col
            v-for="item in metricCards"
            :key="item.label"
            :xl="6"
            :lg="8"
            :md="12"
            :sm="12"
            :xs="24"
            class="metric-col"
          >
            <div class="metric-card">
              <div class="metric-label">{{ item.label }}</div>
              <div class="metric-value">{{ item.value }}</div>
            </div>
          </el-col>
        </el-row>
      </div>

      <div v-if="modelFormula" class="formula-section">
        <div class="section-title">模型公式</div>
        <div class="formula-content">{{ modelFormula }}</div>
      </div> -->
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { computed, ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { UploadFile, UploadProps, UploadUserFile } from 'element-plus'
import { ReportApi } from '@/api/external/report'
import { config } from '@/config/axios/config'

type ReportType = 'acute' | 'chronic'
type DatasetFileField = 'train' | 'valid'

interface ChartViewItem {
  key: string
  name: string
  path?: string
  url?: string
}

const joinUrl = (path: string) => {
  if (!path) return ''
  if (/^https?:\/\//i.test(path)) return path
  return `${config.base_url.replace(/\/$/, '')}/${path.replace(/^\//, '')}`
}

const activeTab = ref<ReportType>('acute')
const loading = ref(false)

const trainFile = ref<File | null>(null)
const validFile = ref<File | null>(null)
const trainFileList = ref<UploadUserFile[]>([])
const validFileList = ref<UploadUserFile[]>([])

const currentTaskId = ref('')
const resultTime = ref('')
const pdfDisplayUrl = ref('')
const charts = ref<ChartViewItem[]>([])
const metrics = ref<Record<string, any>>({})
const modelFormula = ref('')

const previewVisible = ref(false)
const previewUrl = ref('')
const previewTitle = ref('')

const reportTitle = computed(() => {
  return activeTab.value === 'acute' ? '急性高原病预测结果' : '慢性高原病预测结果'
})

const hasResult = computed(() => {
  return !!pdfDisplayUrl.value || charts.value.length > 0
})

const metricCards = computed(() => {
  const m = metrics.value || {}

  if (activeTab.value === 'acute') {
    const cards = [
      { label: '训练集 AUC', value: normalizeMetricValue(m.train_auc) },
      { label: '训练集 AUC CI', value: normalizeRangeValue(m.train_auc_ci) },
      { label: '训练集最佳阈值', value: normalizeMetricValue(m.train_best_threshold) },
      { label: '训练集敏感度', value: normalizeMetricValue(m.train_sensitivity) },
      { label: '训练集特异度', value: normalizeMetricValue(m.train_specificity) },
      { label: '验证集 AUC', value: normalizeMetricValue(m.valid_auc) },
      { label: '验证集 AUC CI', value: normalizeRangeValue(m.valid_auc_ci) },
      { label: '验证集敏感度', value: normalizeMetricValue(m.valid_sensitivity) },
      { label: '验证集特异度', value: normalizeMetricValue(m.valid_specificity) }
    ]
    return cards.filter((item) => item.value !== '--')
  }

  const cards = [
    { label: '训练集 AUC', value: normalizeMetricValue(m.train_auc) },
    { label: '训练集 AUC CI', value: normalizeRangeValue(m.train_auc_ci) },
    { label: '训练集最佳阈值', value: normalizeMetricValue(m.train_best_threshold) },
    { label: '训练集敏感度', value: normalizeMetricValue(m.train_sensitivity) },
    { label: '训练集特异度', value: normalizeMetricValue(m.train_specificity) },
    { label: '训练集最大约登指数', value: normalizeMetricValue(m.train_max_youden) },
    { label: '测试集 AUC', value: normalizeMetricValue(m.valid_auc) },
    { label: '测试集 AUC CI', value: normalizeRangeValue(m.valid_auc_ci) },
    {
      label: '测试集敏感度(训练阈值)',
      value: normalizeMetricValue(m.valid_sensitivity_at_train_threshold)
    },
    {
      label: '测试集特异度(训练阈值)',
      value: normalizeMetricValue(m.valid_specificity_at_train_threshold)
    },
    {
      label: '测试集约登指数(训练阈值)',
      value: normalizeMetricValue(m.valid_youden_at_train_threshold)
    },
    {
      label: '测试集自身最大约登指数',
      value: normalizeMetricValue(m.valid_self_max_youden)
    }
  ]
  return cards.filter((item) => item.value !== '--')
})

const switchTab = (type: ReportType) => {
  if (activeTab.value === type) return
  activeTab.value = type
  currentTaskId.value = ''
  clearUploadedFiles()
  clearResult()
}

const previewImage = (item: ChartViewItem) => {
  if (!item.url) {
    ElMessage.warning('图片地址为空')
    return
  }
  previewUrl.value = item.url
  previewTitle.value = item.name || '图片预览'
  previewVisible.value = true
}

const setUploadedFile = (field: DatasetFileField, file: File | null, fileName = '') => {
  const nextFileList: UploadUserFile[] =
    file && fileName
      ? [
          {
            name: fileName,
            status: 'ready'
          }
        ]
      : []

  if (field === 'train') {
    trainFile.value = file
    trainFileList.value = nextFileList
    return
  }

  validFile.value = file
  validFileList.value = nextFileList
}

const clearUploadedFiles = () => {
  setUploadedFile('train', null)
  setUploadedFile('valid', null)
}

const validateSavFile = (field: DatasetFileField, fileName: string) => {
  const isSavFile = /\.sav$/i.test(fileName)
  if (!isSavFile) {
    const label = field === 'train' ? '训练集' : '验证集'
    ElMessage.error(`${label}仅支持上传 .sav 格式文件`)
  }
  return isSavFile
}

const handleDatasetFileChange = (field: DatasetFileField, uploadFile: UploadFile) => {
  const rawFile = uploadFile.raw ?? null
  const fileName = rawFile?.name || uploadFile.name || ''

  if (!fileName) {
    setUploadedFile(field, null)
    return
  }

  if (!validateSavFile(field, fileName)) {
    setUploadedFile(field, null)
    return
  }

  setUploadedFile(field, rawFile, fileName)
}

const handleDatasetFileRemove = (field: DatasetFileField) => {
  setUploadedFile(field, null)
  return true
}

const onTrainFileChange: UploadProps['onChange'] = (uploadFile) => {
  handleDatasetFileChange('train', uploadFile)
}

const onValidFileChange: UploadProps['onChange'] = (uploadFile) => {
  handleDatasetFileChange('valid', uploadFile)
}

const onTrainFileRemove: UploadProps['onRemove'] = () => {
  return handleDatasetFileRemove('train')
}

const onValidFileRemove: UploadProps['onRemove'] = () => {
  return handleDatasetFileRemove('valid')
}

const runReport = async () => {
  try {
    loading.value = true
    currentTaskId.value = ''
    clearResult()

    const formData = new FormData()
    if (trainFile.value) formData.append('trainFile', trainFile.value)
    if (validFile.value) formData.append('validFile', validFile.value)

    const res: any = await ReportApi.runReport(activeTab.value, formData)
    const data = res?.data || res || {}

    const taskId = normalizeValue(data.task_id || data.taskId)
    const success = normalizeBoolean(data.success)

    if (!taskId) {
      ElMessage.error('未获取到 taskId')
      return
    }

    if (!success) {
      const msg = normalizeValue(data.message) || '生成报告失败'
      ElMessage.error(msg)
      return
    }

    currentTaskId.value = taskId
    await loadResult(taskId)
    ElMessage.success('报告生成成功')
  } catch (error) {
    console.error(error)
    ElMessage.error('生成报告失败')
  } finally {
    loading.value = false
  }
}

const refreshResult = async () => {
  if (!currentTaskId.value) {
    ElMessage.warning('当前没有 taskId')
    return
  }
  try {
    loading.value = true
    await loadResult(currentTaskId.value)
    ElMessage.success('刷新成功')
  } catch (error) {
    console.error(error)
    ElMessage.error('刷新失败')
  } finally {
    loading.value = false
  }
}

const loadResult = async (taskId: string) => {
  const resp: any = await ReportApi.getReportResult(activeTab.value, taskId)
  const data = resp?.data || resp || {}

  resultTime.value = normalizeValue(data.generated_at)
  pdfDisplayUrl.value = joinUrl(normalizeValue(data.pdf))
  modelFormula.value = normalizeValue(data.model_formula)
  metrics.value = normalizeObject(data.metrics)

  const chartList = Array.isArray(data.charts) ? data.charts : []
  charts.value = chartList.map((item: any) => ({
    key: normalizeValue(item.key),
    name: normalizeValue(item.name),
    path: normalizeValue(item.path),
    url: joinUrl(normalizeValue(item.url))
  }))
}

const openPdf = () => {
  if (!pdfDisplayUrl.value) {
    ElMessage.warning('PDF 地址为空')
    return
  }
  window.open(pdfDisplayUrl.value, '_blank')
}

const clearResult = () => {
  resultTime.value = ''
  pdfDisplayUrl.value = ''
  charts.value = []
  metrics.value = {}
  modelFormula.value = ''
  previewVisible.value = false
  previewUrl.value = ''
  previewTitle.value = ''
}

const normalizeValue = (v: any): string => {
  if (v === null || v === undefined) return ''
  if (typeof v === 'string') return v
  if (typeof v === 'number' || typeof v === 'boolean') return String(v)
  if (Array.isArray(v)) {
    if (v.length === 0) return ''
    return normalizeValue(v[0])
  }
  if (typeof v === 'object') {
    if ('url' in v) return normalizeValue(v.url)
    if ('path' in v) return normalizeValue(v.path)
  }
  return String(v)
}

const normalizeBoolean = (v: any): boolean => {
  if (typeof v === 'boolean') return v
  if (Array.isArray(v)) return normalizeBoolean(v[0])
  if (typeof v === 'string') return v === 'true'
  return !!v
}

const normalizeObject = (obj: any): Record<string, any> => {
  if (!obj || typeof obj !== 'object' || Array.isArray(obj)) return {}
  const result: Record<string, any> = {}
  Object.keys(obj).forEach((key) => {
    const value = obj[key]
    if (Array.isArray(value)) {
      result[key] = value.map((item) => {
        if (item === null || item === undefined) return ''
        return typeof item === 'object' ? normalizeValue(item) : item
      })
    } else if (typeof value === 'object' && value !== null) {
      result[key] = normalizeObject(value)
    } else {
      result[key] = value
    }
  })
  return result
}

const normalizeMetricValue = (v: any): string => {
  const value = normalizeValue(v)
  return value || '--'
}

const normalizeRangeValue = (v: any): string => {
  if (Array.isArray(v)) {
    const arr = v.map((item) => normalizeValue(item)).filter(Boolean)
    return arr.length ? arr.join(' ~ ') : '--'
  }
  const value = normalizeValue(v)
  return value || '--'
}
</script>

<style scoped lang="scss">
.report-page {
  min-height: 100%;
  padding: 20px;
  background: #f5f7fa;
  box-sizing: border-box;
}

.tab-row {
  display: flex;
  gap: 12px;
  margin-bottom: 16px;
}

.tab-btn {
  min-width: 140px;
}

.panel-card {
  margin-bottom: 16px;
  border-radius: 8px;
}

.panel-tip {
  color: #606266;
  margin-bottom: 18px;
  font-size: 14px;
}

.sub-title {
  color: #606266;
  font-size: 14px;
  margin-bottom: 14px;
}

.filter-row {
  margin-bottom: 8px;
}

.upload-row {
  margin-top: 8px;
  margin-bottom: 16px;
}

.upload-panel {
  height: 100%;
  padding: 18px;
  border: 1px solid #ebeef5;
  border-radius: 10px;
  background: linear-gradient(180deg, #fcfdff 0%, #f8fbff 100%);
  box-sizing: border-box;
}

.upload-panel__title {
  color: #303133;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 8px;
}

.upload-panel__desc {
  color: #909399;
  font-size: 13px;
  line-height: 1.6;
  min-height: 42px;
  margin-bottom: 12px;
}

.upload-trigger-text {
  color: #606266;
  font-size: 14px;
  line-height: 1.7;
  text-align: center;
  padding: 6px 12px;
}

:deep(.upload-panel .el-upload) {
  width: 100%;
}

:deep(.upload-panel .el-upload-dragger) {
  width: 100%;
}

.action-row {
  margin-top: 8px;
}

.result-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 18px;
  gap: 12px;
  flex-wrap: wrap;
}

.result-left {
  display: flex;
  align-items: center;
  gap: 20px;
  flex-wrap: wrap;
}

.result-title {
  font-size: 16px;
  font-weight: 600;
  color: #303133;
}

.result-time {
  font-size: 14px;
  color: #909399;
}

.result-right {
  display: flex;
  gap: 12px;
}

.chart-col {
  margin-bottom: 20px;
}

.chart-panel {
  border: 1px solid #ebeef5;
  border-radius: 8px;
  background: #fff;
  padding: 14px;
  min-height: 340px;
  box-sizing: border-box;
}

.chart-title {
  font-size: 15px;
  font-weight: 600;
  color: #303133;
  text-align: center;
  margin-bottom: 12px;
}

.chart-img-wrap {
  width: 100%;
  min-height: 260px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.chart-img {
  width: 100%;
  display: block;
  object-fit: contain;
}

.pdf-section {
  margin-top: 8px;
}

.section-title {
  font-size: 15px;
  font-weight: 600;
  color: #303133;
  margin-bottom: 12px;
}

.pdf-wrap {
  border: 1px solid #ebeef5;
  border-radius: 8px;
  overflow: hidden;
  background: #fff;
}

.metric-section {
  margin-top: 20px;
}

.metric-col {
  margin-bottom: 16px;
}

.metric-card {
  border: 1px solid #ebeef5;
  border-radius: 8px;
  background: #fff;
  padding: 16px;
  text-align: center;
}

.metric-label {
  color: #909399;
  font-size: 13px;
  margin-bottom: 10px;
}

.metric-value {
  color: #303133;
  font-size: 20px;
  font-weight: 600;
  word-break: break-word;
}

.formula-section {
  margin-top: 20px;
}

.formula-content {
  background: #fff;
  border: 1px solid #ebeef5;
  border-radius: 8px;
  padding: 14px;
  color: #606266;
  line-height: 1.8;
  word-break: break-all;
}

.empty-preview {
  min-height: 240px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

.previewable-img {
  cursor: pointer;
  transition: transform 0.2s ease;
}

.previewable-img:hover {
  transform: scale(1.02);
}

.preview-dialog-body {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 400px;
}

.preview-dialog-img {
  max-width: 100%;
  max-height: 75vh;
  object-fit: contain;
  display: block;
}
</style>
