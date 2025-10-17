<template>
  <div class="prospective-data-view">
    <FilterCard 
      :query-params="queryParams"
      @update:query-params="handleQueryParamsUpdate"
      @query-change="handleQueryChange"
    />
    
    <ResultCard
      :list="list"
      :total="total"
      :average="average"
      :conditions="conditions"
      :loading="loading"
      :query-params="queryParams"
      :displayed-fields="displayedFields"
      :export-loading="exportLoading"
      @header-click="handleHeaderClick"
      @export="handleExport"
      @page-change="handlePageChange"
      @field-select="handleFieldSelect"
    />

    <!-- 高级筛选弹窗 -->
    <AdvancedSearch
      v-model="fieldSelectorVisible"
      :grouped-fields="fieldGroups"
      @confirm="handleFieldSelect"
    />
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, watch, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import FilterCard from './components/FilterCard.vue'
import ResultCard from './components/ResultCard.vue'
import AdvancedSearch from './AdvancedSearch.vue'
import { BasicInfoApi } from '@/api/prospective/basicinfo'
import { useDataHandler } from './composables/useDataHandler'
import { useFieldManager } from './composables/useFieldManager'
import { useExportHandler } from './composables/useExportHandler'
import { useConditionManager } from './composables/useConditionManager'

const route = useRoute()

// 响应式数据
const loading = ref(true)
const total = ref(0)
const list = ref([])
const average = ref({})
const fieldSelectorVisible = ref(false)

// 查询参数
const queryParams = reactive({
  pageNo: 1,
  pageSize: 10,
  group: 1,
  type: 181,
  year: 23,
  vip: 1,
  surveyOrExam: 'survey',
  groupType: 1,
  timePoint: 1,
  name: undefined,
  mobile: undefined,
  status: undefined,
  deptId: undefined,
  createTime: [],
  baseInfo: [
    '超声',
  '肺功能',
  '人体成分',
  '认知',
  '神经外科',
  '心电',
  '血液',
  '眼科',
  '血栓弹力图'
  ],
  experimentGroupSurvey: [],
  experimentGroupExam: [],
  compareGroupSurvey: [],
  compareGroupExam: [],
  reviewBasicInfoFields: [],
  advancedConditions: []
})

// 组合式函数
const { displayedFields, updateDisplayedFields, fieldGroups } = useFieldManager(queryParams)
const { conditions, handleFieldSelect } = useConditionManager()
const { handleExport, exportLoading } = useExportHandler(queryParams)
const { getList, loadPageData } = useDataHandler(
  queryParams, 
  list, 
  total, 
  average, 
  loading
)

// 事件处理
const handleQueryChange = () => {
  queryParams.pageNo = 1
  getList()
}

const handlePageChange = (page: number, pageSize: number) => {
  queryParams.pageNo = page
  queryParams.pageSize = pageSize
  loadPageData()
}

const handleHeaderClick = (column: any) => {
  // 处理表头点击逻辑
  console.log('Header clicked:', column)
}

const handleQueryParamsUpdate = (newQueryParams: any) => {
  Object.assign(queryParams, newQueryParams)
}

// 监听查询参数变化
watch(
  () => [
    queryParams.baseInfo,
    queryParams.experimentGroupSurvey,
    queryParams.experimentGroupExam,
    queryParams.compareGroupSurvey,
    queryParams.compareGroupExam,
    queryParams.group,
    queryParams.groupType,
    queryParams.surveyOrExam,
    queryParams.year,
    queryParams.type,
    queryParams.timePoint
  ],
  updateDisplayedFields,
  { deep: true, immediate: true }
)

// 初始化
onMounted(async () => {
  await getList()
})
</script>

<style scoped>
.prospective-data-view {
  padding: 20px;
  background-color: #f5f7fa;
}

.prospective-data-view > * {
  margin-bottom: 20px;
}
</style>