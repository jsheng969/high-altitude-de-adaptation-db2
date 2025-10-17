 <template>
  <el-form-item label="数据节点：">
    <div class="select-bar">
      <el-select
        class="select-width"
        size="small"
        clearable
        :model-value="queryParams.group"
        placeholder="请选择组"
        @update:model-value="handleGroupChange"
      >
        <el-option label="实验组" :value="1" />
        <el-option label="对照组" :value="2" />
      </el-select>

      <template v-if="showExperimentFields">
        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.type"
          placeholder="请选择类"
          @update:model-value="handleTypeChange"
        >
          <el-option label="181" :value="181" />
          <el-option label="363" :value="363" />
          <el-option label="全部" :value="0" />
        </el-select>

        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.year"
          placeholder="请选择年份"
          @update:model-value="handleYearChange"
        >
          <el-option label="23年" :value="23" />
          <el-option label="24年" :value="24" />
          <el-option label="全部" :value="0" />
        </el-select>

        <el-select
          class="select-width"
          size="small"
          clearable
          :model-value="queryParams.timePoint"
          placeholder="请选择时相"
          @update:model-value="handleTimePointChange"
        >
          <el-option label="第一时相点" :value="1" />
          <el-option label="第二时相点" :value="2" />
          <el-option label="第三时相点" :value="3" />
        </el-select>
      </template>

      <el-select
        class="select-width"
        size="small"
        clearable
        :model-value="queryParams.surveyOrExam"
        placeholder="请选择类"
        @update:model-value="handleSurveyOrExamChange"
      >
        <el-option label="流调" value="survey" />
        <el-option label="体检" value="exam" />
      </el-select>
    </div>
  </el-form-item>
</template>

<script lang="ts" setup>
import { computed } from 'vue'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const showExperimentFields = computed(() => props.queryParams.group === 1)

const handleGroupChange = (value: number) => {
  const newParams = { ...props.queryParams, group: value }
  
  // 如果是对照组，重置相关字段
  if (value === 2) {
    newParams.type = undefined
    newParams.year = undefined
    newParams.timePoint = undefined
  }
  
  emit('update:queryParams', newParams)
  emit('change')
}

const handleTypeChange = (value: number) => {
  emit('update:queryParams', {
    ...props.queryParams,
    type: value
  })
  emit('change')
}

const handleYearChange = (value: number) => {
  emit('update:queryParams', {
    ...props.queryParams,
    year: value
  })
  emit('change')
}

const handleTimePointChange = (value: number) => {
  emit('update:queryParams', {
    ...props.queryParams,
    timePoint: value
  })
  emit('change')
}

const handleSurveyOrExamChange = (value: string) => {
  emit('update:queryParams', {
    ...props.queryParams,
    surveyOrExam: value
  })
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
</style>