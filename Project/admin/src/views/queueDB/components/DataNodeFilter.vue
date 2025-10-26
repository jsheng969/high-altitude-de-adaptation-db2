<template>
  <el-form-item label="数据节点：">
    <div class="select-bar">
      <!-- 动态渲染所有数据节点类型 -->
      <template v-for="nodeType in dataNodeTypes" :key="nodeType.value">
        <!-- 组别选择 -->
        <el-select
          v-if="nodeType.value === 'data_node'"
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.group"
          placeholder="请选择组"
          @update:model-value="handleChange('group', $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <!-- 类型选择 -->
        <el-select
          v-else-if="nodeType.value === 'type_node' && showExperimentFields"
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.type"
          placeholder="请选择类"
          @update:model-value="handleChange('type', $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <!-- 年份选择 -->
        <el-select
          v-else-if="nodeType.value === 'year_node' && showExperimentFields"
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.year"
          placeholder="请选择年份"
          @update:model-value="handleChange('year', $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <!-- 时相选择 -->
        <el-select
          v-else-if="nodeType.value === 'time_point_node' && showExperimentFields"
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.timePoint"
          placeholder="请选择时相"
          @update:model-value="handleChange('timePoint', $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <!-- 调查/体检选择 -->
        <el-select
          v-else-if="nodeType.value === 'survey_exam_node'"
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.surveyOrExam"
          placeholder="请选择类"
          @update:model-value="handleChange('surveyOrExam', $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>

        <!-- 其他未知类型的默认渲染 -->
        <el-select
          v-else
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams[nodeType.value]"
          :placeholder="`请选择${nodeType.label}`"
          @update:model-value="handleGenericChange(nodeType.value, $event)"
        >
          <el-option 
            v-for="dict in getNodeOptions(nodeType.value)" 
            :key="dict.value"
            :label="dict.label" 
            :value="dict.value" 
          />
        </el-select>
      </template>
    </div>
  </el-form-item>
</template>

<script lang="ts" setup>
import { ref, computed, onMounted } from 'vue'
import { getStrDictOptions, getIntDictOptions } from '@/utils/dict'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

// 数据节点类型列表
const dataNodeTypes = ref<any[]>([])

// 计算属性
const showExperimentFields = computed(() => props.queryParams.group === 1)

// 加载数据节点类型
const loadDataNodeTypes = () => {
  // 从字典获取数据节点类型
  dataNodeTypes.value = getStrDictOptions('prospective_queue_db_condition')
  console.log('数据节点类型:', dataNodeTypes.value)
}

// 获取具体节点的选项
const getNodeOptions = (nodeType: string) => {
  const options = getIntDictOptions(nodeType)
  console.log(`节点 ${nodeType} 选项:`, options)
  return options
}

// 统一处理已知字段变化
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

// 处理未知字段的变化
const handleGenericChange = (field: string, value: any) => {
  const newParams = {
    ...props.queryParams,
    [field]: value
  }
  
  emit('update:queryParams', newParams)
  emit('change')
}

// 组件挂载时加载数据节点类型
onMounted(() => {
  loadDataNodeTypes()
})
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