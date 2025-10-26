<template>
  <el-dialog
    :model-value="visible"
    @update:model-value="handleVisibleChange"
    title="选择显示字段"
    width="800px"
    :close-on-click-modal="false"
  >
    <div class="field-select-dialog">
      <div class="dialog-header">
        <el-checkbox
          :indeterminate="isIndeterminate"
          v-model="checkAll"
          @change="handleCheckAllChange"
        >
          全选
        </el-checkbox>
        <span class="selected-count">已选择 {{ localSelectedFields.length }} 个字段</span>
      </div>
      
      <div class="fields-container">
        <div
          v-for="group in fieldGroups"
          :key="group.groupName"
          class="field-group"
        >
          <div class="group-title">{{ group.groupName }}</div>
          <div class="group-fields">
            <el-checkbox
              v-for="field in group.fields"
              :key="field.prop"
              v-model="localSelectedFields"
              :label="field.prop"
            >
              {{ field.label }}
            </el-checkbox>
          </div>
        </div>
      </div>
    </div>
    
    <template #footer>
      <el-button @click="handleCancel">取消</el-button>
      <el-button type="primary" @click="handleConfirm">确定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ref, watch, computed } from 'vue'

interface Props {
  visible: boolean
  selectedFields: string[]
  availableFields: any[]
}

interface Emits {
  (e: 'update:visible', value: boolean): void
  (e: 'confirm', fields: string[]): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

// 使用本地响应式数据
const localSelectedFields = ref<string[]>([])

// 计算属性
const fieldGroups = computed(() => {
  const groups: any = {}
  
  props.availableFields.forEach(field => {
    if (!groups[field.groupName]) {
      groups[field.groupName] = []
    }
    groups[field.groupName].push(field)
  })
  
  return Object.keys(groups).map(groupName => ({
    groupName,
    fields: groups[groupName]
  }))
})

const checkAll = computed({
  get: () => localSelectedFields.value.length === props.availableFields.length,
  set: (val: boolean) => {
    localSelectedFields.value = val ? props.availableFields.map(f => f.prop) : []
  }
})

const isIndeterminate = computed(() => {
  return localSelectedFields.value.length > 0 && localSelectedFields.value.length < props.availableFields.length
})

// 监听props变化
watch(() => props.visible, (newVal) => {
  // 当对话框打开时，初始化选中字段
  if (newVal) {
    localSelectedFields.value = [...props.selectedFields]
  }
})

watch(() => props.selectedFields, (newVal) => {
  localSelectedFields.value = [...newVal]
})

// 事件处理
const handleVisibleChange = (value: boolean) => {
  emit('update:visible', value)
}

const handleCheckAllChange = (val: boolean) => {
  localSelectedFields.value = val ? props.availableFields.map(f => f.prop) : []
}

const handleConfirm = () => {
  emit('confirm', localSelectedFields.value)
  emit('update:visible', false)
}

const handleCancel = () => {
  emit('update:visible', false)
}
</script>

<style scoped>
.field-select-dialog {
  max-height: 60vh;
  overflow-y: auto;
}

.dialog-header {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  padding-bottom: 15px;
  border-bottom: 1px solid #e8e8e8;
}

.selected-count {
  margin-left: 16px;
  color: #666;
  font-size: 14px;
}

.field-group {
  margin-bottom: 20px;
}

.group-title {
  font-weight: 600;
  margin-bottom: 10px;
  padding: 8px 12px;
  background-color: #f5f7fa;
  border-radius: 4px;
  color: #303133;
}

.group-fields {
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  padding: 0 12px;
}

:deep(.el-checkbox) {
  margin-right: 0;
}
</style>