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
      :list="list"
      :loading="loading"
      :displayed-fields="displayedFields"
      @header-click="$emit('header-click', $event)"
    />

    <!-- 分页 -->
    <Pagination
      :total="total"
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
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const currentPage = ref(1)
const pageSize = ref(10)

const handlePageChange = (page: number) => {
  emit('page-change', page, pageSize.value)
}

const handleSizeChange = (size: number) => {
  pageSize.value = size
  emit('page-change', 1, size)
}

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