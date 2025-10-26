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
      :displayed-fields="displayedFields"
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

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const currentPage = ref(1)
const pageSize = ref(10)

// 本地数据管理
const localList = ref<any[]>([])
const localTotal = ref(0)
const localDisplayedFields = ref({})

// 执行查询
const executeQuery = async () => {
  if (!props.queryParams.baseInfo || props.queryParams.baseInfo.length === 0) {
    return
  }
  
  try {
    const queryData = {
      selectedModules: props.queryParams.baseInfo,
      conditions: null,
      // conditions: props.queryParams,
      pageNo: currentPage.value,
      pageSize: pageSize.value
    }
    
    const data = await queryDynamicTables(queryData)
    localList.value = data.list || []
    localTotal.value = data.total || 0
    console.log(localList.value);
    
    emit('update:list', data.list)
    emit('update:total', data.total)
    
    // 转换字段格式供前端显示
    const transformedFields = transformFieldsForDisplay(data.displayedFields)
    localDisplayedFields.value = transformedFields
    console.log('Transformed Fields:', transformedFields);
    
    emit('update:displayed-fields', transformedFields)
    
  } catch (error) {
    console.error('查询失败:', error)
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
    currentPage.value = 1 // 重置页码
    executeQuery()
  },
  { deep: true }
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