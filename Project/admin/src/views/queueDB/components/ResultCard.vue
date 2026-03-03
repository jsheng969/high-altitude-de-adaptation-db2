<template>
  <el-card class="result-card">
    <template #header>
      <div class="result-header">
        <span>筛选结果</span>
        <div class="header-actions">
          <el-button @click="$emit('field-select')">高级筛选字段</el-button>
          <el-button 
            type="success" 
            plain 
            @click="$emit('export')" 
            :loading="exportLoading"
          >
            <Icon icon="ep:download" class="mr-5px" /> 导出
          </el-button>
        </div>
      </div>
      
      <!-- 筛选条件显示 -->
      <ConditionDisplay 
        :conditions="conditions"
        :total="total"
        :average="average"
        :query-params="queryParams"
      />
    </template>

    <!-- 数据表格 -->
    <DataTable
      :list="localList"
      :loading="loading"
      :displayed-fields="localDisplayedFields"
      @header-click="$emit('header-click', $event)"
    />

    <!-- 分页 -->
    <Pagination
      :total="localTotal"
      v-model:page="currentPage"
      v-model:limit="pageSize"
      :page-sizes="[10, 20, 30, 50, 100, 600]"
      @update:page="handlePageChange"
      @update:limit="handleSizeChange"
    />
  </el-card>
</template>

<script lang="ts" setup>
import { ref, watch } from 'vue'
import { queryDynamicTables } from '@/api/dynamic/query'
import ConditionDisplay from './ConditionDisplay.vue'
import DataTable from './DataTable.vue'

interface Props {
  list: any[]
  total: number
  average: any
  conditions: any[]
  loading: boolean
  queryParams: any
  displayedFields: any
  exportLoading?: boolean
  // 新增：主表模块编码
  mainModuleCode: string
  // 新增：默认选中的模块（可选）
  defaultSelectedModules?: string[]
}

interface Emits {
  (e: 'header-click', column: any): void
  (e: 'export'): void
  (e: 'field-select'): void
  (e: 'page-change', page: number, pageSize: number): void
  (e: 'update:list', list: any[]): void
  (e: 'update:total', total: number): void
  (e: 'update:displayed-fields', fields: any): void
}

const props = withDefaults(defineProps<Props>(), {
  defaultSelectedModules: () => [],
  exportLoading: false,
  list: () => [],
  total: 0,
  conditions: () => [],
  displayedFields: () => ({})
})

const emit = defineEmits<Emits>()

const currentPage = ref(1)
const pageSize = ref(10)

// 本地数据管理
const localList = ref<any[]>([])
const localTotal = ref(0)
const localDisplayedFields = ref({})

// 执行查询
const executeQuery = async () => {
  
  console.log('=== 开始执行查询 ===')
  console.log('查询参数:', JSON.stringify(props.queryParams, null, 2))
  console.log('当前页码:', currentPage.value)
  console.log('每页大小:', pageSize.value)
  console.log('主表模块编码:', props.mainModuleCode)
  
  try {
    // 构建查询参数
    const queryData = {
      // 主表模块编码（从props传入）
      mainModuleCode: props.mainModuleCode,
      
      // 选中的模块（子模块名称列表）
      selectedModules: props.queryParams.baseInfo && props.queryParams.baseInfo.length > 0
        ? props.queryParams.baseInfo
        : (props.defaultSelectedModules.length > 0 ? props.defaultSelectedModules : [props.mainModuleCode]),
      
      // 分页参数
      pageNo: currentPage.value,
      pageSize: pageSize.value,
      
      // 过滤条件
      conditions: props.queryParams.advancedConditions && props.queryParams.advancedConditions.length > 0 
        ? { conditions: props.queryParams.advancedConditions }
        : {},
      
      // 其他筛选条件
      group: props.queryParams.group,
      type: props.queryParams.type,
      year: props.queryParams.year,
      vip: props.queryParams.vip,
      surveyOrExam: props.queryParams.surveyOrExam,
      groupType: props.queryParams.groupType,
      timePoint: props.queryParams.timePoint,
      name: props.queryParams.name,
      mobile: props.queryParams.mobile,
      status: props.queryParams.status,
      deptId: props.queryParams.deptId,
      createTime: props.queryParams.createTime
    }
    
    console.log('发送的查询数据:', JSON.stringify(queryData, null, 2))
    
    const data = await queryDynamicTables(queryData)
    console.log('API返回的原始数据:', JSON.stringify(data, null, 2))
    
    // 处理返回的数据
    if (data && data.list) {
      localList.value = data.list || []
      localTotal.value = data.total || 0
      
      console.log('处理后的列表数据:', localList.value)
      console.log('第一条数据示例:', localList.value[0])
      
      emit('update:list', localList.value)
      emit('update:total', localTotal.value)
    } else {
      console.log('API返回的数据格式异常:', data)
      localList.value = []
      localTotal.value = 0
    }
    
    // 转换字段格式供前端显示
    if (data && data.displayedFields) {
      const transformedFields = transformFieldsForDisplay(data.displayedFields)
      localDisplayedFields.value = transformedFields
      console.log('转换后的字段结构:', JSON.stringify(transformedFields, null, 2))
      
      emit('update:displayed-fields', transformedFields)
    } else if (props.displayedFields) {
      // 如果没有返回字段结构，使用传入的
      localDisplayedFields.value = props.displayedFields
      console.log('使用传入的字段结构:', JSON.stringify(props.displayedFields, null, 2))
    }
    
  } catch (error) {
    console.error('查询失败:', error)
    localList.value = []
    localTotal.value = 0
  }
}

// 字段格式转换（适配前端表格）
const transformFieldsForDisplay = (fieldGroups: any[]) => {
  const result: any = {}
  
  fieldGroups.forEach((group: any) => {
    result[group.groupName] = group.fields.map((field: any) => ({
      label: field.fieldLabel,
      prop: field.prop,
      fieldCode: field.fieldCode,
      fieldType: field.fieldType
    }))
  })
  
  return result
}

const handlePageChange = (page: number) => {
  currentPage.value = page
  emit('page-change', page, pageSize.value)
  executeQuery()
}

const handleSizeChange = (size: number) => {
  pageSize.value = size
  emit('page-change', 1, size)
  executeQuery()
}

// 监听查询参数变化
watch(
  () => props.queryParams,
  () => {
    currentPage.value = 1
    executeQuery()
  },
  { deep: true, immediate: true }
)

// 监听外部queryParams变化同步分页
watch(
  () => props.queryParams.pageNo,
  (newPage) => {
    currentPage.value = newPage
  }
)

watch(
  () => props.queryParams.pageSize,
  (newSize) => {
    pageSize.value = newSize
  }
)

// 监听主表模块编码变化
watch(
  () => props.mainModuleCode,
  () => {
    // 当主表模块编码变化时，重新查询
    currentPage.value = 1
    executeQuery()
  }
)
</script>

<style scoped>
.result-card {
  margin-bottom: 20px;
}

.result-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header-actions {
  display: flex;
  gap: 12px;
}
</style>