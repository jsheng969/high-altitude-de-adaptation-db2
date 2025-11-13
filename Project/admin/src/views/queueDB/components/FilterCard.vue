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
        @update:query-params="$emit('update:queryParams', $event)"
        @change="$emit('query-change')"
      />
      
      <!-- 基础信息 -->
      <BaseInfoFilter 
        :query-params="queryParams"
        :base-modules="baseModules"
        :loading="loading"
        @update:query-params="$emit('update:queryParams', $event)"
        @change="$emit('query-change')"
      />
      
      <!-- 实验组和对照组 -->
      <!-- <GroupFilters 
        :query-params="queryParams"
        @update:query-params="$emit('update:queryParams', $event)"
        @change="$emit('query-change')"
      /> -->
    </el-form>
  </el-card>
</template>

<script lang="ts" setup>
import DataNodeFilter from './DataNodeFilter.vue'
import BaseInfoFilter from './BaseInfoFilter.vue'
import GroupFilters from './GroupFilters.vue'

interface Props {
  queryParams: any
  baseModules: any[]
  loading: boolean
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'query-change'): void
}

defineProps<Props>()
defineEmits<Emits>()
</script>