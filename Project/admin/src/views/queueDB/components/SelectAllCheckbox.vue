<template>
  <div class="select-all-checkbox">
    <div class="select-all-bar">
      <el-checkbox
        :indeterminate="isIndeterminate"
        v-model="checkAll"
        @change="handleCheckAllChange"
      >
        全选
      </el-checkbox>
      <span class="selected-count">已选择 {{ checkedItems.length }} 个</span>
    </div>
    <el-checkbox-group v-model="checkedItems" @change="handleCheckedChange">
      <el-checkbox
        v-for="item in items"
        :key="item"
        :label="item"
        class="checkbox-item"
      >
        {{ item }}
      </el-checkbox>
    </el-checkbox-group>
  </div>
</template>

<script setup lang="ts">
import { ref, watch, computed } from 'vue'

interface Props {
  modelValue: string[]
  items: string[]
}

const props = defineProps<Props>()
const emit = defineEmits(['update:modelValue', 'change'])

const checkedItems = ref<string[]>(props.modelValue || [])
const checkAll = ref(false)
const isIndeterminate = computed(() => {
  return checkedItems.value.length > 0 && checkedItems.value.length < props.items.length
})

// 监听props变化
watch(() => props.modelValue, (newVal) => {
  checkedItems.value = newVal || []
  updateCheckAllState()
})

// 监听选中项变化
watch(checkedItems, (newVal) => {
  emit('update:modelValue', newVal)
  emit('change', newVal)
  updateCheckAllState()
})

const handleCheckAllChange = (val: boolean) => {
  checkedItems.value = val ? [...props.items] : []
}

const handleCheckedChange = (value: string[]) => {
  updateCheckAllState()
}

const updateCheckAllState = () => {
  checkAll.value = checkedItems.value.length === props.items.length
  isIndeterminate.value = checkedItems.value.length > 0 && checkedItems.value.length < props.items.length
}
</script>

<style scoped>
.select-all-checkbox {
  border: 1px solid #e8e8e8;
  border-radius: 4px;
  padding: 12px;
  background: #fafafa;
}

.select-all-bar {
  display: flex;
  align-items: center;
  margin-bottom: 12px;
  padding-bottom: 12px;
  border-bottom: 1px solid #e8e8e8;
}

.selected-count {
  margin-left: 16px;
  color: #666;
  font-size: 14px;
}

.checkbox-item {
  display: inline-block;
  margin-right: 16px;
  margin-bottom: 8px;
  min-width: 100px;
}

:deep(.el-checkbox__label) {
  font-size: 14px;
}
</style>