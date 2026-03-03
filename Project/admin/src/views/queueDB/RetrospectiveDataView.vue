<template>
  <div class="prospective-data-view">
    <FilterCard 
      :query-params="queryParams"
      :base-modules="baseModules"
      :loading="moduleLoading"
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
      :main-module-code="mainModuleCode"
      :default-selected-modules="defaultSelectedModules"
      @header-click="handleHeaderClick"
      @export="handleExport"
      @page-change="handlePageChange"
      @field-select="handleFieldSelect"
      @update:list="handleListUpdate"
      @update:total="handleTotalUpdate"
      @update:displayed-fields="handleDisplayedFieldsUpdate"
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
const moduleLoading = ref(false)
const total = ref(0)
const list = ref([])
const average = ref({})
const fieldSelectorVisible = ref(false)

// 模块配置 - 可以根据需要动态设置或从路由获取
const mainModuleCode = ref('retrospective') // 主表模块编码
const mainModuleName = ref('回顾性队列') // 主表模块编码
const defaultSelectedModules = ref(['retrospective']) // 默认选中的模块

// 查询参数
const queryParams = reactive({
  pageNo: 1,
  pageSize: 10,
  name: undefined,
  mobile: undefined,
  status: undefined,
  deptId: undefined,
  createTime: [],
  baseInfo: [], // 初始为空，从服务器获取
  experimentGroupSurvey: [],
  experimentGroupExam: [],
  compareGroupSurvey: [],
  compareGroupExam: [],
  reviewBasicInfoFields: [],
  advancedConditions: []
})

// 模块类型 - 从路由或配置中获取
const moduleType = 'retrospective' // 这里可以根据需要动态设置

// 组合式函数
const { 
  displayedFields, 
  updateDisplayedFields, 
  fieldGroups, 
  baseModules, 
  loadModuleTree,
  loading: fieldLoading 
} = useFieldManager(queryParams, moduleType, mainModuleCode.value) // 传入主表模块编码

const { conditions, handleFieldSelect } = useConditionManager()
const { handleExport, exportLoading } = useExportHandler(queryParams, mainModuleCode.value,mainModuleName.value) // 传入主表模块编码
const { getList, loadPageData } = useDataHandler(
  queryParams, 
  list, 
  total, 
  average, 
  loading,
  mainModuleCode.value // 传入主表模块编码
)

// 数据处理回调
const handleListUpdate = (newList: any[]) => {
  list.value = newList
}

const handleTotalUpdate = (newTotal: number) => {
  total.value = newTotal
}

const handleDisplayedFieldsUpdate = (fields: any) => {
  // 可以在这里处理字段更新的逻辑
  console.log('Displayed fields updated:', fields)
}

// 初始化加载模块树
onMounted(async () => {
  moduleLoading.value = true
  await loadModuleTree()
  moduleLoading.value = false
  await getList()
})

// 事件处理
const handleQueryChange = () => {
  queryParams.pageNo = 1
  getList()
}

const handleQueryParamsUpdate = (newQueryParams: any) => {
  Object.assign(queryParams, newQueryParams)
}

const handlePageChange = (page: number, pageSize: number) => {
  queryParams.pageNo = page
  queryParams.pageSize = pageSize
  loadPageData()
}

const handleHeaderClick = (column: any) => {
  console.log('Header clicked:', column)
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

</script>