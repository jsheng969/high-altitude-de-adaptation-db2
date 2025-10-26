<template>
  <div class="data-table">
    <el-table
      :data="list"
      style="width: 100%"
      v-loading="loading"
      @header-click="$emit('header-click', $event)"
      :header-cell-class-name="getHeaderCellClass"
    >
      <!-- 固定列 -->
      <el-table-column
        label="编号"
        align="center"
        key="code"
        prop="code"
        width="120"
        class-name="level-1-header"
      />
      <el-table-column
        label="姓名"
        align="center"
        key="name"
        prop="name"
        class-name="level-1-header"
      />

      <!-- 动态字段 - 支持多级表头 -->
      <template v-for="(fieldGroup, groupName) in displayedFields" :key="groupName">
        <!-- 情况1: 字段组是数组，显示为一级表头 + 二级表头（如超声） -->
        <template v-if="Array.isArray(fieldGroup)">
          <el-table-column :label="groupName" align="center" class-name="level-1-header">
            <el-table-column
              v-for="field in fieldGroup"
              :key="field.prop"
              :label="field.label"
              :prop="field.prop"
              :formatter="formatField"
              :min-width="getAutoMinWidth(field.label, field.prop, list)"
              align="center"
              class-name="level-2-header"
            />
          </el-table-column>
        </template>
        
        <!-- 情况2: 字段组是对象，显示多级表头（如吸烟情况） -->
        <template v-else>
          <el-table-column :label="groupName" align="center" class-name="level-1-header">
            <template v-for="(subFields, subGroupName) in fieldGroup" :key="subGroupName">
              <!-- 子组是数组，显示为二级表头 + 三级表头 -->
              <template v-if="Array.isArray(subFields)">
                <el-table-column
                  :label="subGroupName"
                  align="center"
                  class-name="level-2-header"
                >
                  <el-table-column
                    v-for="field in subFields"
                    :key="field.prop"
                    :label="field.label"
                    :prop="field.prop"
                    :formatter="formatField"
                    :min-width="getAutoMinWidth(field.label, field.prop, list)"
                    align="center"
                    class-name="level-3-header"
                  />
                </el-table-column>
              </template>
            </template>
          </el-table-column>
        </template>
      </template>
    </el-table>
  </div>
</template>

<script lang="ts" setup>
import { formatField, getAutoMinWidth } from '../utils/formatUtils'

interface Props {
  list: any[]
  loading: boolean
  displayedFields: any
}

interface Emits {
  (e: 'header-click', column: any): void
}

defineProps<Props>()
defineEmits<Emits>()

const getHeaderCellClass = ({ column }: { column: any }) => {
  const clickableFields = [
    '性别', '实际年龄', '任务点海拔(m)', '驻训总时长(月)', 
    '第二时相评分总数', '第三时相评分总数', '退役年份'
  ]
  
  if (clickableFields.includes(column.label)) {
    return 'clickable-header'
  }
  return ''
}
</script>

<style scoped>
.data-table {
  margin: 20px 0;
}

/* 表头样式 */
:deep(.el-table__header .level-1-header) {
  background-color: #f0f9ff !important;
}

:deep(.el-table__header .level-2-header) {
  background-color: #e0f7fa !important;
}

:deep(.el-table__header .level-3-header) {
  background-color: #fff3e0 !important;
}

:deep(.clickable-header) {
  cursor: pointer;
  color: #409eff;
  font-weight: bold;
}
</style>