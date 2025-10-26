<template>
  <div class="data-table">
    <el-table
      :key="tableKey"
      :data="list"
      style="width: 100%"
      v-loading="loading"
      @header-click="$emit('header-click', $event)"
      :header-cell-class-name="getHeaderCellClass"
    >
      <!-- 可按需保留/删除固定列 -->
      <!-- 固定列 -->
      <!-- <el-table-column
        label="编号"
        align="center"
        key="idNumber"
        prop="idNumber"
        width="120"
        class-name="level-1-header"
      /> -->
      <el-table-column
        label="姓名"
        align="center"
        key="name"
        prop="name"
        class-name="level-1-header"
      />

      <!-- 动态字段：用规范化后的 groups 渲染 -->
      <template v-for="group in groups" :key="group.groupKey">
        <!-- 一级表头列（group） -->
        <el-table-column :label="group.groupName" align="center" class-name="level-1-header">
          
          <!-- 如果 group.type === 'array'：直接渲染二级列 -->
          <template v-if="group.type === 'array'">
            <el-table-column
              v-for="field in group.fields"
              :key="field.prop"
              :label="field.label"
              :prop="field.prop"
              :min-width="getAutoMinWidth(field.label, field.prop, list)"
              align="center"
              class-name="level-2-header"
              :formatter="safeFormatter"
            />
          </template>

          <!-- 如果 group.type === 'object'：渲染子组（子组下再渲染字段） -->
          <template v-else>
            <template v-for="sub in group.subGroups" :key="sub.subKey">
              <el-table-column :label="sub.subName" align="center">
                <el-table-column
                  v-for="field in sub.fields"
                  :key="field.prop"
                  :label="field.label"
                  :prop="field.prop"
                  :min-width="getAutoMinWidth(field.label, field.prop, list)"
                  align="center"
                  class-name="level-3-header"
                  :formatter="safeFormatter"
                />
              </el-table-column>
            </template>
          </template>

        </el-table-column>
      </template>
    </el-table>
  </div>
</template>

<script lang="ts" setup>
import { computed, onMounted } from 'vue'
import { formatField, getAutoMinWidth } from '../utils/formatUtils'

interface Props {
  list: any[]
  loading: boolean
  displayedFields: any
}

interface Emits {
  (e: 'header-click', column: any): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

/**
 * safeFormatter：调试期间会打印 row 和 column.property（prop）。
 * 确认后你可以把它换回原始的 formatField 调用（并调整参数）。
 */
const safeFormatter = (row: any, column: any) => {
  const prop = column.property.replace(/\./g, '_')
  const value = row[prop]
  console.log('格式化单元格:', { label: column.label, prop, rowValue: value })
  return value ?? ''
}

/**
 * 规范化 displayedFields 为 groups 数组形式，结构清晰，便于渲染
 * 支持两种后端结构：
 * 1) groupName -> Array(fields)
 * 2) groupName -> Object { subGroupName -> Array(fields) }
 */
const groups = computed(() => {
  const df = props.displayedFields || {}
  const out: any[] = []

  Object.keys(df).forEach((groupName) => {
    const groupData = df[groupName]
    const groupKey = groupName ? String(groupName).replace(/\s+/g, '_') : 'group_' + Math.random().toString(36).slice(2, 8)

    if (Array.isArray(groupData)) {
      out.push({
        type: 'array',
        groupName,
        groupKey,
        fields: groupData.map((f: any) => ({
          label: f.label,
          prop: f.prop,
          fieldCode: f.fieldCode,
          fieldType: f.fieldType
        }))
      })
    } else if (groupData && typeof groupData === 'object') {
      const subGroups = Object.keys(groupData).map((subName) => {
        const subKey = subName ? String(subName).replace(/\s+/g, '_') : 'sub_' + Math.random().toString(36).slice(2, 6)
        const fields = Array.isArray(groupData[subName]) ? groupData[subName].map((f: any) => ({
          label: f.label,
          prop: f.prop,
          fieldCode: f.fieldCode,
          fieldType: f.fieldType
        })) : []
        return {
          subName,
          subKey,
          fields
        }
      })
      out.push({
        type: 'object',
        groupName,
        groupKey,
        subGroups
      })
    }
  })

  return out
})

// tableKey 用于在 displayedFields 或 list 结构改变时强制刷新表格
const tableKey = computed(() => {
  try {
    const dfKeys = Object.keys(props.displayedFields || {}).sort()
    const listKey = (props.list && props.list.length) ? props.list.length + '-' + JSON.stringify(Object.keys(props.list[0] || {}).sort()) : '0'
    return dfKeys.join('|') + '||' + listKey
  } catch (e) {
    return String(Date.now())
  }
})

// header 样式类
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

// 调试：子组件挂载时打印收到的 props（确认子组件确实拿到数据）
onMounted(() => {
  // eslint-disable-next-line no-console
  console.log('[DataTable mounted] props.list length=', props.list ? props.list.length : 0)
  // eslint-disable-next-line no-console
  console.log('[DataTable mounted] props.displayedFields=', props.displayedFields)
  // eslint-disable-next-line no-console
  console.log('[DataTable mounted] computed groups=', groups.value)
})
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
