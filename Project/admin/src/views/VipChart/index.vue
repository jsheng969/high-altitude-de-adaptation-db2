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
                <span>{{ item.name }}: {{ item.display }}</span>
              </div>
            </div>
            <div class="chart-wrap">
              <Echart :height="220" :options="transportChartOptions" />
            </div>
          </div>
        </div>

        <div class="overview-block--legend">
          <div class="omics-legend-grid">
            <div v-for="item in overviewOmicsItems" :key="item.key" class="omics-legend-item">
              <span class="omics-legend-item__dot" :style="{ backgroundColor: item.color }"></span>
              <span>{{ item.name }}: {{ item.display }}</span>
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
        <div class="panel-card__title">测序报告</div>
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
        </button>

        <button type="button" class="report-card report-card--search" @click="scrollToTools">
          <span class="report-card__name">数据检索</span>
          <span class="report-card__meta">跳转分析工具区</span>
        </button>
      </div>
    </section>

    <section ref="toolSectionRef" class="panel-card">
      <div class="section-head">
        <div class="panel-card__title">分析工具</div>
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

  </div>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import type { EChartsOption } from 'echarts'
import { ElMessage } from 'element-plus'
import { OmicsReportApi } from '@/api/external/omicsReport'

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
  reportFileName: string
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

// 当前页面里仍然使用写死的演示数据。
// PDF 预览只传 reportFileName，后端会基于 application 中的 pluginsDir 拼出真实文件路径。
const omicsItems: OmicsItem[] = [
  {
    key: 'proteomics',
    name: '蛋白组',
    display: 'XXX份',
    value: 180,
    color: '#ff6b6b',
    softColor: '#ffe4e4',
    reportFileName: '蛋白组学结题报告.pdf'
  },
  {
    key: 'macro-genome',
    name: '宏基因组',
    display: 'XXX份',
    value: 160,
    color: '#50c9c3',
    softColor: '#dff8f6',
    reportFileName: 'Metagenomics_Report_F23A040006333_HOMumznM_base_short_report_zh.pdf'
  },
  {
    key: 'genome',
    name: '全基因组',
    display: 'XXX份',
    value: 155,
    color: '#4cb3d4',
    softColor: '#dff4fa',
    reportFileName: 'Report_F23A040016059_HOMdlaxR_report_cn.pdf'
  },
  {
    key: 'transcriptome',
    name: '转录组',
    display: 'XXX份',
    value: 120,
    color: '#9be7be',
    softColor: '#e8fbf0',
    reportFileName: 'BGI_F25A610004138_HOMiolvzT_short_report_cn.pdf'
  },
  {
    key: 'metabolome',
    name: '代谢组',
    display: 'XXX份',
    value: 110,
    color: '#ffe28a',
    softColor: '#fff5d1',
    reportFileName: '非靶向代谢结题报告.pdf'
  },
  {
    key: 'epigenome',
    name: '表观组',
    display: 'XXX份',
    value: 130,
    color: '#ffb28f',
    softColor: '#ffe8dc',
    reportFileName: 'BGI_Demo_WGBS_report_cn.pdf'
  },
  {
    key: 'immunome',
    name: '免疫组',
    display: 'XXX份',
    value: 145,
    color: '#c06cf0',
    softColor: '#f1e1fc',
    reportFileName: 'F25A610004138_HOMuqghjR.report_en.pdf'
  },
  {
    key: 'transcriptome-proteomics-association',
    name: '转录和蛋白关联分析',
    display: 'XXX份',
    value: 108,
    color: '#5b8ff9',
    softColor: '#e3edff',
    reportFileName: '转录和蛋白关联分析报告.pdf'
  },
  {
    key: 'metabolome-proteomics-association',
    name: '代谢和蛋白关联分析',
    display: 'XXX份',
    value: 102,
    color: '#36cfc9',
    softColor: '#def8f6',
    reportFileName: '代谢和蛋白关联分析报告.pdf'
  },
  {
    key: 'metabolome-transcriptome-association',
    name: '代谢和转录关联分析结题',
    display: 'XXX份',
    value: 96,
    color: '#9254de',
    softColor: '#efe2ff',
    reportFileName: '代谢和转录关联分析结题报告.pdf'
  }
]

const toolItems: ToolItem[] = [
  { key: 'ldviewer', label: '连锁不平衡可视化热图', url: '/vip-chart/plah/api/tools/ldviewer/' },
  {
    key: 'gene_fetch',
    label: '序列提取',
    url: '/vip-chart/plah/api/tools/sequence-fetch/'
  },
  { key: 'blast', label: '序列比对', url: '/vip-chart/blast/' },
  {
    key: 'jbrowse',
    label: '基因组浏览器',
    url: '/vip-chart/union_jbrowse/?config=data%2Fjbrowse%2Fcorynebacterium.json'
  },
  { key: 'GO', label: 'Gene Ontology（基因本体论）分析', url: '/vip-chart/plah/go/' },
  { key: 'KEGG', label: 'KEGG Pathway 富集分析', url: '/vip-chart/plah/kegg/' },
  {
    key: 'PhylogeneticTree',
    label: '物种进化树分析',
    url: '/vip-chart/plah/phylogenetic_tree'
  },
  {
    key: 'OrthologousGene',
    label: '直系同源基因分析',
    url: '/vip-chart/plah/orthologous_gene'
  }
]

const reportItems = omicsItems
const selectedReportKey = ref(reportItems[0].key)
const toolSectionRef = ref<HTMLElement | null>(null)

const overviewOmicsItems = computed(() =>
  omicsItems.filter(
    (item) =>
      ![
        'transcriptome-proteomics-association',
        'metabolome-proteomics-association',
        'metabolome-transcriptome-association'
      ].includes(item.key)
  )
)

const selectedReport = computed(
  () => reportItems.find((item) => item.key === selectedReportKey.value) || reportItems[0]
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

const buildPdfPreviewUrl = (report?: OmicsItem) => {
  if (!report?.reportFileName) return ''
  const rawUrl = OmicsReportApi.getReportFileUrl(report.reportFileName)
  return rawUrl.includes('#')
    ? rawUrl
    : `${rawUrl}#toolbar=0&navpanes=0&statusbar=0&view=FitH`
}

const selectedReportPreviewUrl = computed(() => buildPdfPreviewUrl(selectedReport.value))

const selectReport = (report: OmicsItem) => {
  selectedReportKey.value = report.key
  if (!selectedReportPreviewUrl.value) {
    ElMessage.warning('当前报告文件名未配置')
    return
  }
  window.open(selectedReportPreviewUrl.value, '_blank', 'noopener,noreferrer')
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

.panel-card {
  margin-bottom: 20px;
  padding: 24px 24px 26px;
  border: 1px solid rgba(126, 157, 204, 0.18);
  background: rgba(255, 255, 255, 0.9);
  border-radius: 24px;
  box-shadow: 0 14px 40px rgba(48, 85, 154, 0.08);
  backdrop-filter: blur(10px);
}

.panel-card__title {
  font-size: 16px;
  font-weight: 700;
  color: #2d3b58;
}

.overview-layout {
  display: grid;
  grid-template-columns: minmax(280px, 1.05fr) minmax(280px, 1.25fr) minmax(260px, 0.95fr);
  gap: 18px;
  align-items: stretch;
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

.overview-block--legend {
  display: flex;
  align-items: center;
}

.omics-legend-grid {
  display: flex;
  flex-wrap: wrap;
  gap: 10px 18px;
  align-content: center;
}

.omics-legend-item {
  flex: 1 1 calc(50% - 9px);
  min-width: 180px;
}

.section-head {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 16px;
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

  .transport-layout,
  .overview-layout,
  .report-grid,
  .omics-legend-grid {
    grid-template-columns: 1fr;
  }

  .tool-links {
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 14px 20px;
  }

  .overview-block--legend {
    align-items: flex-start;
  }

  .omics-legend-grid {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }

  .omics-legend-item {
    flex-basis: 100%;
    min-width: 0;
  }

  .report-card {
    min-height: 82px;
  }

  .embedded-frame {
    min-height: 520px;
  }
}
</style>
