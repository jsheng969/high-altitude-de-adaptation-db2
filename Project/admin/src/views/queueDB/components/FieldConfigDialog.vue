<template>
  <el-dialog
    v-model="visible"
    title="字段显示配置"
    width="1000px"
    :before-close="handleClose"
  >
    <div class="field-config-dialog">
      <!-- 配置头部 -->
      <div class="config-header">
        <el-form :inline="true" :model="configParams">
          <el-form-item label="模块类型">
            <el-select v-model="configParams.moduleType" @change="loadFieldGroups">
              <el-option label="基线数据" value="baseline" />
              <el-option label="基础信息" value="base" />
            </el-select>
          </el-form-item>
          <el-form-item label="海拔">
            <el-select v-model="configParams.altitude" @change="loadFieldGroups">
              <el-option 
                v-for="option in altitudeOptions" 
                :key="option.value" 
                :label="option.label" 
                :value="option.value" 
              />
            </el-select>
          </el-form-item>
          <el-form-item label="编号范围">
            <el-select v-model="configParams.codeRange" @change="loadFieldGroups">
              <el-option 
                v-for="option in codeRangeOptions" 
                :key="option.value" 
                :label="option.label" 
                :value="option.value" 
              />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="loadFieldGroups">
              <Icon icon="ep:refresh" />刷新
            </el-button>
          </el-form-item>
        </el-form>
        
        <div class="selection-info">
          <span>已选择 {{ selectedFieldsCount }} 个字段</span>
          <el-button link type="primary" @click="selectAll">全选</el-button>
          <el-button link type="primary" @click="clearAll">清空</el-button>
        </div>
      </div>

      <!-- 字段组列表 -->
      <div class="field-groups-container">
        <el-card 
          v-for="group in fieldGroups" 
          :key="group.groupCode"
          class="field-group-card"
          shadow="never"
        >
          <template #header>
            <div class="group-header">
              <el-checkbox 
                v-model="group.selected" 
                :indeterminate="isGroupPartiallySelected(group)"
                @change="handleGroupSelect(group)"
              >
                <span class="group-name">{{ group.groupName }}</span>
                <span class="field-count">({{ getSelectedFieldCount(group) }}/{{ group.fields.length }})</span>
              </el-checkbox>
              <div class="group-actions">
                <el-button link type="primary" @click="selectGroup(group)">全选</el-button>
                <el-button link type="primary" @click="deselectGroup(group)">清空</el-button>
              </div>
            </div>
          </template>
          
          <div class="field-list">
            <el-checkbox
              v-for="field in group.fields"
              :key="field.fieldCode"
              v-model="field.selected"
              :disabled="!group.selected"
              class="field-checkbox"
            >
              <span class="field-label">{{ field.fieldLabel }}</span>
              <span class="field-type">{{ field.fieldType }}</span>
            </el-checkbox>
          </div>
        </el-card>

        <!-- 空状态 -->
        <el-empty v-if="fieldGroups.length === 0" description="暂无字段配置" />
      </div>
    </div>

    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="handleSave" :loading="loading">
        保存配置并应用
      </el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref, reactive, computed, watch } from 'vue'
import { ElMessage } from 'element-plus'
import { 
  FieldDisplayApi, 
  getSelectedFields,
  toggleGroupSelection,
  isGroupPartiallySelected,
  DEFAULT_ALTITUDE_OPTIONS,
  DEFAULT_CODE_RANGE_OPTIONS
} from '@/api/queueDB/fieldDisplay'

interface Props {
  modelValue: boolean
  moduleType?: string
  altitude?: number
  codeRange?: number
}

interface FieldGroup {
  groupCode: string
  groupName: string
  selected: boolean
  fields: FieldItem[]
}

interface FieldItem {
  fieldCode: string
  fieldLabel: string
  selected: boolean
  tableName?: string
  fieldType?: string
  dataType?: string
}

const props = defineProps<Props>()
const emit = defineEmits(['update:modelValue', 'config-change'])

const visible = ref(props.modelValue)
const loading = ref(false)
const fieldGroups = ref<FieldGroup[]>([])
const altitudeOptions = ref(DEFAULT_ALTITUDE_OPTIONS)
const codeRangeOptions = ref(DEFAULT_CODE_RANGE_OPTIONS)

const configParams = reactive({
  moduleType: props.moduleType || 'baseline',
  altitude: props.altitude,
  codeRange: props.codeRange
})

// 计算属性
const selectedFieldsCount = computed(() => {
  return getSelectedFields(fieldGroups.value).length
})

// 方法
const loadFieldGroups = async () => {
  try {
    loading.value = true
    const response = await FieldDisplayApi.getFieldDisplayConfig({
      moduleType: configParams.moduleType,
      altitude: configParams.altitude,
      codeRange: configParams.codeRange?.toString()
    })
    fieldGroups.value = response.data
  } catch (error: any) {
    console.error('加载字段组失败:', error)
    ElMessage.error(error.message || '加载字段组失败')
  } finally {
    loading.value = false
  }
}

const handleGroupSelect = (group: FieldGroup) => {
  toggleGroupSelection(group, group.selected)
}

const selectGroup = (group: FieldGroup) => {
  toggleGroupSelection(group, true)
}

const deselectGroup = (group: FieldGroup) => {
  toggleGroupSelection(group, false)
}

const getSelectedFieldCount = (group: FieldGroup): number => {
  return group.fields.filter(field => field.selected).length
}

const selectAll = () => {
  fieldGroups.value.forEach(group => {
    toggleGroupSelection(group, true)
  })
}

const clearAll = () => {
  fieldGroups.value.forEach(group => {
    toggleGroupSelection(group, false)
  })
}

const handleSave = async () => {
  try {
    loading.value = true
    
    if (selectedFieldsCount.value === 0) {
      ElMessage.warning('请至少选择一个字段')
      return
    }
    
    // 保存配置到后端
    await FieldDisplayApi.saveFieldDisplayConfig({
      moduleType: configParams.moduleType,
      altitude: configParams.altitude,
      codeRange: configParams.codeRange?.toString(),
      fieldGroups: fieldGroups.value
    })
    
    ElMessage.success('配置保存成功')
    emit('config-change', fieldGroups.value)
    handleClose()
  } catch (error: any) {
    console.error('保存配置失败:', error)
    ElMessage.error(error.message || '保存配置失败')
  } finally {
    loading.value = false
  }
}

const handleClose = () => {
  visible.value = false
}

// 监听显示状态
watch(visible, (val) => {
  emit('update:modelValue', val)
})

watch(() => props.modelValue, (val) => {
  visible.value = val
  if (val) {
    loadFieldGroups()
  }
})

// 监听props变化
watch(() => props.moduleType, (val) => {
  if (val) {
    configParams.moduleType = val
    loadFieldGroups()
  }
})

watch(() => props.altitude, (val) => {
  configParams.altitude = val
  loadFieldGroups()
})

watch(() => props.codeRange, (val) => {
  configParams.codeRange = val
  loadFieldGroups()
})
</script>

<style scoped>
.field-config-dialog {
  max-height: 70vh;
  overflow-y: auto;
}

.config-header {
  margin-bottom: 16px;
  padding-bottom: 16px;
  border-bottom: 1px solid #e8e8e8;
}

.selection-info {
  margin-top: 12px;
  color: #666;
  font-size: 14px;
}

.selection-info .el-button {
  margin-left: 12px;
}

.field-groups-container {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.field-group-card {
  :deep(.el-card__header) {
    padding: 12px 16px;
    background-color: #f8f9fa;
  }
}

.group-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.group-name {
  font-weight: bold;
  margin-right: 8px;
}

.field-count {
  color: #666;
  font-size: 12px;
}

.group-actions {
  display: flex;
  gap: 8px;
}

.field-list {
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
}

.field-checkbox {
  display: flex;
  align-items: center;
  min-width: 180px;
  margin-right: 0;
}

.field-label {
  margin-right: 8px;
}

.field-type {
  color: #999;
  font-size: 12px;
  background: #f5f5f5;
  padding: 2px 6px;
  border-radius: 4px;
}
</style>