<template>
  <el-form-item label="数据节点：">
    <div class="select-bar">
      <!-- 组别选择 -->
      <el-select
        class="select-width"
        size="small"
        clearable
        :model-value="queryParams.group"
        placeholder="请选择组"
        @update:model-value="handleChange('group', $event)"
      >
        <el-option 
          v-for="dict in getDictOptions('data_node')" 
          :key="dict.value"
          :label="dict.label" 
          :value="dict.value" 
        />
      </el-select>

      <!-- 实验组特有字段 -->
      <template v-if="showExperimentFields">
        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.type"
          placeholder="请选择类"
          @update:model-value="handleChange('type', $event)"
        >
          <el-option 
            v-for="dict in getDictOptions('type_node')" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.year"
          placeholder="请选择年份"
          @update:model-value="handleChange('year', $event)"
        >
          <el-option 
            v-for="dict in getDictOptions('year_node')" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.timePoint"
          placeholder="请选择时相"
          @update:model-value="handleChange('timePoint', $event)"
        >
          <el-option 
            v-for="dict in getDictOptions('time_point_node')" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>
      </template>

      <!-- 调查/体检选择 -->
      <el-select
        class="select-width"
        size="small"
        clearable
        :model-value="queryParams.surveyOrExam"
        placeholder="请选择类"
        @update:model-value="handleChange('surveyOrExam', $event)"
      >
        <el-option 
          v-for="dict in getDictOptions('survey_exam_node')" 
          :key="dict.value"
          :label="dict.label" 
          :value="dict.value" 
        />
      </el-select>
    </div>
  </el-form-item>
</template>

<script lang="ts" setup>
import { computed } from 'vue'
import { getIntDictOptions, DICT_TYPE } from '@/utils/dict'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

// 字典类型映射配置
const dictConfig = {
  group: 'data_node', // 组别
  type: 'type_node', // 类型
  year: 'year_node', // 年份
  timePoint: 'time_point_node', // 时相
  surveyOrExam: 'survey_exam_node' // 调查/体检
} as const

// 获取字典选项的方法
const getDictOptions = (dictType: string) => {
  return getIntDictOptions(DICT_TYPE.PROSPECTIVE_QUEUE_DB_CONDITION[dictType])
}

// 计算属性
const showExperimentFields = computed(() => props.queryParams.group === 1)

// 统一处理变化
const handleChange = (field: string, value: any) => {
  let newParams = { ...props.queryParams }
  
  if (field === 'group') {
    newParams.group = value
    // 如果切换到对照组，重置实验组特有字段
    if (value === 2) {
      newParams.type = undefined
      newParams.year = undefined
      newParams.timePoint = undefined
    }
  } else {
    newParams[field] = value
  }
  
  emit('update:queryParams', newParams)
  emit('change')
}
</script>

<style scoped>
.select-bar {
  display: flex;
  gap: 12px;
  flex-wrap: wrap;
  align-items: center;
}

.select-width {
  width: 200px;
  min-width: 200px;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .select-bar {
    gap: 8px;
  }
  
  .select-width {
    width: 100%;
    min-width: auto;
  }
}
</style>