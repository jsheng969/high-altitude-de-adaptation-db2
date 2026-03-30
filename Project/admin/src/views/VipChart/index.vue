<template>
  <div class="omics-page">

    <section class="panel-card">
      <div class="overview-layout">
        <div class="overview-block--transport">
          <div class="transport-layout">
            <div class="transport-legend">
              <div
                v-for="item in transportItems"
                :key="item.key"
                class="transport-legend__item"
              >
                <span class="transport-legend__dot" :style="{ backgroundColor: item.color }"></span>
                <span>{{ item.name }}：{{ item.display }}</span>
              </div>
            </div>
            <div class="chart-wrap">
              <Echart :height="220" :options="transportChartOptions" />
            </div>
          </div>
        </div>

        <div class="overview-block--legend">
          <div class="omics-legend-grid">
            <div v-for="item in omicsItems" :key="item.key" class="omics-legend-item">
              <span class="omics-legend-item__dot" :style="{ backgroundColor: item.color }"></span>
              <span>{{ item.name }}：{{ item.display }}</span>
            </div>
          </div>
        </div>

        <div class="overview-block--donut">
          <div class="chart-wrap">
            <Echart :height="220" :options="omicsChartOptions" />
          </div>
        </div>
      </div>
    </section>

    <section class="panel-card">
      <div class="section-head">
        <div>
          <div class="panel-card__title">测序报告</div>
        </div>
      </div>

      <div class="report-grid">
        <button
          v-for="report in reportItems"
          :key="report.key"
          type="button"
          class="report-card"
          :class="{ 'report-card--active': selectedReport?.key === report.key }"
          :style="{
            '--report-color': report.color,
            '--report-color-soft': report.softColor
          }"
          @click="selectReport(report)"
        >
          <span class="report-card__name">{{ report.name }}</span>
          <span class="report-card__meta">PDF 预览</span>
        </button>

        <button type="button" class="report-card report-card--search" @click="scrollToTools">
          <span class="report-card__name">数据检索</span>
          <span class="report-card__meta">跳转分析工具区</span>
        </button>
      </div>

    </section>

    <section ref="toolSectionRef" class="panel-card">
      <div class="section-head">
        <div>
          <div class="panel-card__title">分析工具</div>
        </div>
      </div>

      <div class="tool-links">
        <button
          v-for="tool in toolItems"
          :key="tool.key"
          type="button"
          class="tool-link"
          @click="openTool(tool)"
        >
          {{ tool.label }}
        </button>
      </div>
    </section>

    <el-dialog
      v-model="reportDialogVisible"
      :title="selectedReport?.name || 'PDF 预览'"
      width="min(1200px, 92vw)"
      destroy-on-close
      append-to-body
    >
      <div v-if="selectedReportPreviewUrl" class="report-dialog__body">
        <div class="report-dialog__path">{{ selectedReport?.pdfPath }}</div>
        <iframe
          :src="selectedReportPreviewUrl"
          title="omics-report-preview"
          class="embedded-frame embedded-frame--dialog"
          frameborder="0"
        ></iframe>
      </div>
      <div v-else class="viewer-panel__empty report-dialog__empty">
        当前报告 PDF 路径未配置。支持 `http(s)` 地址、服务器绝对路径、Linux 绝对路径和 Windows 盘符路径。
      </div>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import type { EChartsOption } from 'echarts'
import { ElMessage } from 'element-plus'

defineOptions({ name: 'VipChart' })

interface TransportItem {
  key: string
  name: string
  display: string
  value: number
  color: string
}

interface OmicsItem {
  key: string
  name: string
  display: string
  value: number
  color: string
  softColor: string
  pdfPath: string
}

interface ToolItem {
  key: string
  label: string
  url: string
}

const transportItems: TransportItem[] = [
  { key: 'urine', name: '尿液', display: '送样XXX份', value: 30, color: '#2f458c' },
  { key: 'blood', name: '血液', display: '送样XXX份', value: 42, color: '#f15b5a' },
  { key: 'feces', name: '粪便', display: '送样XXX份', value: 28, color: '#ffc857' }
]

// 这里的 PDF 路径是页面内写死的静态示例值，后续你可以直接替换成真实服务器路径或 URL。
const omicsItems: OmicsItem[] = [
  {
    key: 'proteomics',
    name: '蛋白组',
    display: 'XXX份',
    value: 180,
    color: '#ff6b6b',
    softColor: '#ffe4e4',
    pdfPath: '/data/multi-omics/reports/proteomics-report.pdf'
  },
  {
    key: 'macro-genome',
    name: '宏基因组',
    display: 'XXX份',
    value: 160,
    color: '#50c9c3',
    softColor: '#dff8f6',
    pdfPath: '/data/multi-omics/reports/metagenomics-report.pdf'
  },
  {
    key: 'genome',
    name: '全基因组',
    display: 'XXX份',
    value: 155,
    color: '#4cb3d4',
    softColor: '#dff4fa',
    pdfPath: '/data/multi-omics/reports/genome-report.pdf'
  },
  {
    key: 'transcriptome',
    name: '转录组',
    display: 'XXX份',
    value: 120,
    color: '#9be7be',
    softColor: '#e8fbf0',
    pdfPath: '/data/multi-omics/reports/transcriptome-report.pdf'
  },
  {
    key: 'metabolome',
    name: '代谢组',
    display: 'XXX份',
    value: 110,
    color: '#ffe28a',
    softColor: '#fff5d1',
    pdfPath: '/data/multi-omics/reports/metabolome-report.pdf'
  },
  {
    key: 'epigenome',
    name: '表观组',
    display: 'XXX份',
    value: 130,
    color: '#ffb28f',
    softColor: '#ffe8dc',
    pdfPath: '/data/multi-omics/reports/epigenome-report.pdf'
  },
  {
    key: 'immunome',
    name: '免疫组',
    display: 'XXX份',
    value: 145,
    color: '#c06cf0',
    softColor: '#f1e1fc',
    pdfPath: 'D:\\multi-omics\\reports\\immunome-report.pdf'
  }
]

const toolItems: ToolItem[] = [
  { key: 'ldviewer', label: '序列比对', url: 'http://www.baidu.com/' },
  {
    key: 'gene_fetch',
    label: '上下游基因提取',
    url: 'http://lzy.cngb.org:8000/plah/api/tools/sequence-fetch/'
  },
  { key: 'blast', label: '共表达', url: 'http://lzy.cngb.org:8000/blast/' },
  {
    key: 'jbrowse',
    label: '引物设计',
    url: 'http://lzy.cngb.org:8000/union_jbrowse/?config=data%2Fjbrowse%2Fcorynebacterium.json'
  },
  { key: 'GO', label: '序列获取', url: 'http://lzy.cngb.org:8000/plah/go/' },
  { key: 'KEGG', label: 'KEGG/GO提取', url: 'http://lzy.cngb.org:8000/plah/kegg/' },
  {
    key: 'PhylogeneticTree',
    label: '蛋白互作网络分析',
    url: 'http://lzy.cngb.org:8000/plah/phylogenetic_tree'
  },
  {
    key: 'OrthologousGene',
    label: '其他工具',
    url: 'http://lzy.cngb.org:8000/plah/orthologous_gene'
  }
]

const reportItems = omicsItems
const selectedReportKey = ref(reportItems[0].key)
const reportDialogVisible = ref(false)
const toolSectionRef = ref<HTMLElement | null>(null)

const selectedReport = computed(() =>
  reportItems.find((item) => item.key === selectedReportKey.value) || reportItems[0]
)

const transportChartOptions = computed<EChartsOption>(() => ({
  tooltip: {
    trigger: 'item',
    formatter: '{b}<br/>{c} ({d}%)'
  },
  series: [
    {
      type: 'pie',
      radius: ['0%', '68%'],
      center: ['50%', '50%'],
      itemStyle: {
        borderRadius: 8,
        borderColor: '#fff',
        borderWidth: 4
      },
      label: {
        show: true,
        position: 'inside',
        formatter: '{d}%',
        color: '#fff',
        fontSize: 14,
        fontWeight: 700
      },
      labelLine: {
        show: false
      },
      data: transportItems.map((item) => ({
        name: item.name,
        value: item.value,
        itemStyle: { color: item.color }
      }))
    }
  ]
}))

const omicsChartOptions = computed<EChartsOption>(() => ({
  tooltip: {
    trigger: 'item',
    formatter: '{b}<br/>{c} ({d}%)'
  },
  graphic: [
    {
      type: 'text',
      left: 'center',
      top: '43%',
      style: {
        text: '多组学',
        textAlign: 'center',
        fill: '#56627a',
        fontSize: 16,
        fontWeight: 700
      }
    },
    {
      type: 'text',
      left: 'center',
      top: '53%',
      style: {
        text: 'XXX份',
        textAlign: 'center',
        fill: '#8a93a6',
        fontSize: 14
      }
    }
  ],
  series: [
    {
      type: 'pie',
      radius: ['42%', '72%'],
      center: ['50%', '50%'],
      itemStyle: {
        borderRadius: 8,
        borderColor: '#fff',
        borderWidth: 4
      },
      label: {
        show: false
      },
      labelLine: {
        show: false
      },
      data: omicsItems.map((item) => ({
        name: item.name,
        value: item.value,
        itemStyle: { color: item.color }
      }))
    }
  ]
}))

const normalizeResourceUrl = (value?: string) => {
  const raw = value?.trim()
  if (!raw) return ''

  if (/^(https?:|file:|blob:|data:)/i.test(raw)) {
    return raw
  }

  if (/^[A-Za-z]:[\\/]/.test(raw)) {
    return `file:///${raw.replace(/\\/g, '/')}`
  }

  if (/^\\\\/.test(raw)) {
    return `file:${raw.replace(/\\/g, '/')}`
  }

  return raw
}

const buildPdfPreviewUrl = (value?: string) => {
  const resolved = normalizeResourceUrl(value)
  if (!resolved) return ''
  return resolved.includes('#')
    ? resolved
    : `${resolved}#toolbar=1&navpanes=0&statusbar=0&view=FitH`
}

const selectedReportPreviewUrl = computed(() => buildPdfPreviewUrl(selectedReport.value?.pdfPath))

const selectReport = (report: OmicsItem) => {
  selectedReportKey.value = report.key
  if (!selectedReportPreviewUrl.value) {
    ElMessage.warning('当前报告 PDF 路径未配置')
    return
  }
  reportDialogVisible.value = true
}

const openTool = (tool: ToolItem) => {
  if (!tool.url) {
    ElMessage.warning('当前工具地址为空')
    return
  }
  window.open(tool.url, '_blank', 'noopener,noreferrer')
}

const scrollToTools = () => {
  toolSectionRef.value?.scrollIntoView({ behavior: 'smooth', block: 'start' })
}
</script>

<style scoped lang="scss">
.omics-page {
  min-height: calc(100vh - 50px);
  padding: 20px;
  background:
    radial-gradient(circle at top left, rgba(109, 182, 255, 0.2), transparent 26%),
    linear-gradient(180deg, #eef4fb 0%, #f5f8fc 55%, #f0f3f9 100%);
}

.hero-card,
.panel-card {
  border: 1px solid rgba(126, 157, 204, 0.18);
  background: rgba(255, 255, 255, 0.9);
  border-radius: 24px;
  box-shadow: 0 14px 40px rgba(48, 85, 154, 0.08);
  backdrop-filter: blur(10px);
}

.hero-card {
  margin-bottom: 20px;
  padding: 28px 32px;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 20px;
}

.hero-card__eyebrow {
  font-size: 13px;
  letter-spacing: 0.12em;
  text-transform: uppercase;
  color: #6a84b7;
}

.hero-card__title {
  margin: 10px 0 8px;
  font-size: 30px;
  line-height: 1.1;
  color: #22304e;
}

.hero-card__desc {
  max-width: 760px;
  margin: 0;
  font-size: 14px;
  line-height: 1.7;
  color: #69778f;
}

.hero-card__badge {
  flex-shrink: 0;
  padding: 10px 14px;
  border-radius: 999px;
  background: linear-gradient(135deg, #eff4ff 0%, #dbe7ff 100%);
  color: #4872d8;
  font-size: 12px;
  font-weight: 700;
  letter-spacing: 0.08em;
}

.panel-card {
  margin-bottom: 20px;
  padding: 24px 24px 26px;
}

.panel-card__title {
  font-size: 16px;
  font-weight: 700;
  color: #2d3b58;
}

.overview-layout {
  margin-top: 18px;
  display: grid;
  grid-template-columns: minmax(280px, 1.05fr) minmax(280px, 1.25fr) minmax(260px, 0.95fr);
  gap: 18px;
  align-items: stretch;
}

.overview-block {
  border-radius: 20px;
  background: linear-gradient(180deg, #fbfdff 0%, #f4f8fe 100%);
  border: 1px solid rgba(122, 155, 204, 0.16);
  padding: 18px;
}

.overview-block__title {
  margin-bottom: 14px;
  font-size: 14px;
  font-weight: 700;
  color: #475672;
}

.transport-layout {
  display: grid;
  grid-template-columns: minmax(140px, 1fr) minmax(180px, 1.1fr);
  gap: 10px;
  align-items: center;
}

.transport-legend {
  display: flex;
  flex-direction: column;
  gap: 14px;
}

.transport-legend__item,
.omics-legend-item {
  display: flex;
  align-items: center;
  gap: 10px;
  min-height: 34px;
  color: #53627d;
  font-size: 14px;
}

.transport-legend__dot,
.omics-legend-item__dot {
  width: 22px;
  height: 22px;
  border-radius: 6px;
  flex-shrink: 0;
  box-shadow: inset 0 0 0 1px rgba(255, 255, 255, 0.35);
}

.chart-wrap {
  min-height: 220px;
}

.omics-legend-grid {
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 10px 18px;
}

.section-head {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 16px;
}

.section-head__desc {
  margin-top: 6px;
  color: #7d899f;
  font-size: 13px;
  line-height: 1.6;
}

.ghost-btn {
  min-width: 132px;
  padding: 10px 14px;
  border: 1px solid rgba(84, 111, 164, 0.18);
  border-radius: 12px;
  background: #fff;
  color: #47608f;
  font-size: 13px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s ease;
}

.ghost-btn:hover {
  border-color: rgba(84, 111, 164, 0.36);
  background: #f5f9ff;
}

.report-grid {
  margin-top: 20px;
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  gap: 14px 18px;
}

.report-card {
  min-height: 92px;
  padding: 16px 18px;
  border: 1px solid transparent;
  border-radius: 16px;
  background: linear-gradient(135deg, var(--report-color-soft), var(--report-color));
  color: #32404f;
  text-align: center;
  cursor: pointer;
  transition: transform 0.2s ease, box-shadow 0.2s ease, border-color 0.2s ease;
  box-shadow: 0 10px 22px rgba(69, 96, 145, 0.12);
}

.report-card:hover {
  transform: translateY(-2px);
}

.report-card--active {
  border-color: rgba(58, 84, 137, 0.22);
  box-shadow: 0 14px 28px rgba(69, 96, 145, 0.18);
}

.report-card--search {
  background: linear-gradient(135deg, #ffffff 0%, #f5f7fb 100%);
  border-color: rgba(84, 111, 164, 0.12);
}

.report-card__name {
  display: block;
  font-size: 18px;
  font-weight: 700;
}

.report-card__meta {
  display: block;
  margin-top: 8px;
  font-size: 12px;
  opacity: 0.82;
}

.viewer-panel {
  margin-top: 20px;
  border-radius: 20px;
  border: 1px solid rgba(122, 155, 204, 0.16);
  background: linear-gradient(180deg, #fcfdff 0%, #f4f7fc 100%);
  overflow: hidden;
}

.viewer-panel__header {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 16px;
  padding: 18px 20px;
  border-bottom: 1px solid rgba(122, 155, 204, 0.14);
}

.viewer-panel__title {
  font-size: 16px;
  font-weight: 700;
  color: #2b3a56;
}

.viewer-panel__subtitle {
  margin-top: 6px;
  color: #8390a4;
  font-size: 12px;
  line-height: 1.6;
  word-break: break-all;
}

.viewer-panel__notice {
  padding: 12px 20px 0;
  color: #7a869c;
  font-size: 13px;
  line-height: 1.6;
}

.viewer-panel__body {
  padding: 0;
}

.viewer-panel__body--tool {
  padding-top: 12px;
}

.viewer-panel__empty {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 240px;
  padding: 24px;
  text-align: center;
  color: #7d899f;
  font-size: 14px;
  line-height: 1.8;
}

.report-dialog__body {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.report-dialog__path {
  color: #8390a4;
  font-size: 12px;
  line-height: 1.6;
  word-break: break-all;
}

.report-dialog__empty {
  min-height: 220px;
}

.embedded-frame {
  display: block;
  width: 100%;
  min-height: 700px;
  background: #fff;
}

.embedded-frame--dialog {
  min-height: 72vh;
}

.tool-links {
  margin-top: 18px;
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  gap: 16px 32px;
}

.tool-link {
  padding: 0;
  border: none;
  background: transparent;
  color: #2f8cff;
  font-size: 16px;
  font-weight: 500;
  line-height: 1.7;
  text-align: left;
  text-decoration: underline;
  text-underline-offset: 4px;
  cursor: pointer;
  transition: color 0.2s ease, transform 0.2s ease;
}

.tool-link:hover {
  color: #176fe6;
  transform: translateX(2px);
}

@media (max-width: 1280px) {
  .overview-layout {
    grid-template-columns: 1fr;
  }

  .report-grid {
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }

  .tool-links {
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }
}

@media (max-width: 900px) {
  .omics-page {
    padding: 14px;
  }

  .hero-card,
  .section-head,
  .transport-layout {
    grid-template-columns: 1fr;
  }

  .hero-card,
  .section-head {
    display: flex;
    flex-direction: column;
  }

  .overview-layout,
  .report-grid,
  .omics-legend-grid {
    grid-template-columns: 1fr;
  }

  .tool-links {
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 14px 20px;
  }

  .report-card {
    min-height: 82px;
  }

  .embedded-frame {
    min-height: 520px;
  }
}
</style>
