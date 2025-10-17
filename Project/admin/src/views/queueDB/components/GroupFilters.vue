<template>
  <!-- 实验组流调 -->
  <el-form-item
    label="实验组："
    v-if="showExperimentSurvey"
  >
    <div class="checkbox-container">
      <el-checkbox
        :indeterminate="isIndeterminateSurvey"
        v-model="checkAllSurvey"
        @change="handleCheckAllSurveyChange"
        class="check-all"
      >
        全选
      </el-checkbox>
      <el-checkbox-group 
        v-model="localExperimentSurvey" 
        @change="handleExperimentSurveyChange"
        class="checkbox-group"
      >
        <el-checkbox
          v-for="item in experimentSurveyItems"
          :key="item"
          :label="item"
        >
          {{ item }}
        </el-checkbox>
      </el-checkbox-group>
    </div>
  </el-form-item>

  <!-- 实验组体检 -->
  <el-form-item
    label="实验组："
    v-if="showExperimentExam"
  >
    <div class="checkbox-container">
      <el-checkbox
        :indeterminate="isIndeterminateExam"
        v-model="checkAllExam"
        @change="handleCheckAllExamChange"
        class="check-all"
      >
        全选
      </el-checkbox>
      <el-checkbox-group 
        v-model="localExperimentExam" 
        @change="handleExperimentExamChange"
        class="checkbox-group"
      >
        <el-checkbox
          v-for="item in experimentExamItems"
          :key="item"
          :label="item"
        >
          {{ item }}
        </el-checkbox>
      </el-checkbox-group>
    </div>
  </el-form-item>

  <!-- 对照组 -->
  <el-form-item 
    label="对照组：" 
    v-if="showControlGroup"
  >
    <div class="checkbox-container">
      <el-checkbox
        :indeterminate="isIndeterminateControl"
        v-model="checkAllControl"
        @change="handleCheckAllControlChange"
        class="check-all"
      >
        全选
      </el-checkbox>
      <el-checkbox-group 
        v-model="localControlSurvey" 
        @change="handleControlGroupChange"
        class="checkbox-group"
      >
        <el-checkbox
          v-for="item in controlSurveyItems"
          :key="item"
          :label="item"
        >
          {{ item }}
        </el-checkbox>
      </el-checkbox-group>
    </div>
  </el-form-item>
</template>

<script lang="ts" setup>
import { computed, ref, watch } from 'vue'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

// 本地响应式数据
const localExperimentSurvey = ref<string[]>(props.queryParams.experimentGroupSurvey || [])
const localExperimentExam = ref<string[]>(props.queryParams.experimentGroupExam || [])
const localControlSurvey = ref<string[]>(props.queryParams.experimentGroupSurvey || [])

// 全选状态
const checkAllSurvey = ref(false)
const isIndeterminateSurvey = ref(true)
const checkAllExam = ref(false)
const isIndeterminateExam = ref(true)
const checkAllControl = ref(false)
const isIndeterminateControl = ref(true)

// 计算属性
const showExperimentSurvey = computed(() => {
  return (props.queryParams.group == 1 || props.queryParams.group == 0) && 
         props.queryParams.timePoint != 1 && 
         props.queryParams.surveyOrExam == 'survey'
})

const showExperimentExam = computed(() => {
  return (props.queryParams.group == 1 || props.queryParams.group == 0) && 
         props.queryParams.surveyOrExam == 'exam'
})

const showControlGroup = computed(() => {
  return props.queryParams.group == 2 || props.queryParams.group == 0
})

// 选项列表
const experimentSurveyItems = [
  '驻训信息', '吸烟信息', '自我评价', '评分总数统计', '退役后返回平原症状',
  '高原体能信息', '抵达高原后症状记录', '推进情况调查', '既往疾病史',
  '抵达高原后有无新下疾病', '基本检测信息', '高原急性高山病记录'
]

const experimentExamItems = [
  '生化', '血常规', '凝血功能', '心肌肌钙蛋白I', '血管超声结果', '心电图分析结果'
]

const controlSurveyItems = [
  '驻训信息', '吸烟信息', '自我评价', '评分总数统计', '退役后返回平原症状',
  '高原体能信息', '抵达高原后症状记录', '推进情况调查', '既往疾病史',
  '抵达高原后有无新下疾病', '基本检测信息', '高原急性高山病记录'
]

// 更新全选状态的方法
const updateSurveyCheckAllState = () => {
  const checkedCount = localExperimentSurvey.value.length
  checkAllSurvey.value = checkedCount === experimentSurveyItems.length
  isIndeterminateSurvey.value = checkedCount > 0 && checkedCount < experimentSurveyItems.length
}

const updateExamCheckAllState = () => {
  const checkedCount = localExperimentExam.value.length
  checkAllExam.value = checkedCount === experimentExamItems.length
  isIndeterminateExam.value = checkedCount > 0 && checkedCount < experimentExamItems.length
}

const updateControlCheckAllState = () => {
  const checkedCount = localControlSurvey.value.length
  checkAllControl.value = checkedCount === controlSurveyItems.length
  isIndeterminateControl.value = checkedCount > 0 && checkedCount < controlSurveyItems.length
}

// 全选处理
const handleCheckAllSurveyChange = (val: boolean) => {
  localExperimentSurvey.value = val ? [...experimentSurveyItems] : []
  isIndeterminateSurvey.value = false
  handleExperimentSurveyChange(localExperimentSurvey.value)
}

const handleCheckAllExamChange = (val: boolean) => {
  localExperimentExam.value = val ? [...experimentExamItems] : []
  isIndeterminateExam.value = false
  handleExperimentExamChange(localExperimentExam.value)
}

const handleCheckAllControlChange = (val: boolean) => {
  localControlSurvey.value = val ? [...controlSurveyItems] : []
  isIndeterminateControl.value = false
  handleControlGroupChange(localControlSurvey.value)
}

// 变化处理
const handleExperimentSurveyChange = (value: string[]) => {
  updateSurveyCheckAllState()
  emit('update:queryParams', {
    ...props.queryParams,
    experimentGroupSurvey: value
  })
  emit('change')
}

const handleExperimentExamChange = (value: string[]) => {
  updateExamCheckAllState()
  emit('update:queryParams', {
    ...props.queryParams,
    experimentGroupExam: value
  })
  emit('change')
}

const handleControlGroupChange = (value: string[]) => {
  updateControlCheckAllState()
  emit('update:queryParams', {
    ...props.queryParams,
    experimentGroupSurvey: value
  })
  emit('change')
}

// 监听 props 变化
watch(
  () => props.queryParams.experimentGroupSurvey,
  (newValue) => {
    localExperimentSurvey.value = newValue || []
    updateSurveyCheckAllState()
  },
  { immediate: true }
)

watch(
  () => props.queryParams.experimentGroupExam,
  (newValue) => {
    localExperimentExam.value = newValue || []
    updateExamCheckAllState()
  },
  { immediate: true }
)
</script>

<style scoped>
.checkbox-container {
  display: flex;
  align-items: center;
  gap: 20px;
  flex-wrap: wrap;
}

.check-all {
  margin-right: 20px;
  flex-shrink: 0;
}

.checkbox-group {
  display: flex;
  flex-wrap: wrap;
  gap: 12px 24px;
  align-items: center;
}

:deep(.el-checkbox) {
  margin-right: 0;
}
</style>