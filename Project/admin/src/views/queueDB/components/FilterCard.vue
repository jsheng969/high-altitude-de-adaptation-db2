<template>
  <el-card class="filter-card">
    <template #header>
      <div class="card-title">
        <span>筛选条件</span>
      </div>
    </template>

    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      class="query-form"
      label-width="100px"
    >
      <!-- 数据节点 -->
      <DataNodeFilter 
        :query-params="queryParams"
        @update:query-params="handleQueryParamsUpdate"
        @change="$emit('query-change')"
      />
      
      <!-- 基础信息 -->
      <BaseInfoFilter 
        :query-params="queryParams"
        @update:query-params="handleQueryParamsUpdate"
        @change="$emit('query-change')"
      />
      
      <!-- 实验组和对照组 -->
      <GroupFilters 
        :query-params="queryParams"
        @update:query-params="handleQueryParamsUpdate"
        @change="$emit('query-change')"
      />
    </el-form>
  </el-card>
</template>

<script lang="ts" setup>
import DataNodeFilter from './DataNodeFilter.vue'
import BaseInfoFilter from './BaseInfoFilter.vue'
import GroupFilters from './GroupFilters.vue'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'query-change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const handleQueryParamsUpdate = (newQueryParams: any) => {
  emit('update:queryParams', newQueryParams)
}
</script>