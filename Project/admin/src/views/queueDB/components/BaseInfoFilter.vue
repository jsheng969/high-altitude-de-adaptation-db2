<template>
  <el-form-item label="基础信息：">
    <div class="checkbox-container">
      <el-checkbox
        :indeterminate="isIndeterminateBase"
        v-model="checkAllBase"
        @change="handleCheckAllBaseChange"
        class="check-all"
      >
        全选
      </el-checkbox>
      <el-checkbox-group 
        v-model="localBaseInfo" 
        @change="handleBaseInfoChange"
        class="checkbox-group"
      >
        <el-checkbox
          v-for="item in baseInfoItems"
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
import { ref, watch } from 'vue'

interface Props {
  queryParams: any
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const baseInfoItems = [
  '超声',
  '肺功能',
  '人体成分',
  '认知',
  '神经外科',
  '心电',
  '血液',
  '眼科',
  '血栓弹力图'
]

// 本地响应式数据
const localBaseInfo = ref<string[]>(props.queryParams.baseInfo || [])
const checkAllBase = ref(false)
const isIndeterminateBase = ref(true)

// 更新全选状态
const updateCheckAllState = () => {
  const checkedCount = localBaseInfo.value.length
  checkAllBase.value = checkedCount === baseInfoItems.length
  isIndeterminateBase.value = checkedCount > 0 && checkedCount < baseInfoItems.length
}

// 全选处理
const handleCheckAllBaseChange = (val: boolean) => {
  localBaseInfo.value = val ? [...baseInfoItems] : []
  isIndeterminateBase.value = false
  handleBaseInfoChange(localBaseInfo.value)
}

// 基础信息变化处理
const handleBaseInfoChange = (value: string[]) => {
  updateCheckAllState()
  emit('update:queryParams', {
    ...props.queryParams,
    baseInfo: value
  })
  emit('change')
}

// 监听 props 变化
watch(
  () => props.queryParams.baseInfo,
  (newValue) => {
    localBaseInfo.value = newValue || []
    updateCheckAllState()
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