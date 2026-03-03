<template>
  <el-form-item label="基础信息：">
    <div class="checkbox-container" v-loading="loading">
      <div class="checkbox-row">
        <el-checkbox
          :indeterminate="isIndeterminateBase"
          v-model="checkAllBase"
          @change="handleCheckAllBaseChange"
          class="check-all"
          :disabled="childModules.length === 0"
        >
          全选
        </el-checkbox>
        
        <el-checkbox-group 
          v-model="localBaseInfo" 
          @change="handleBaseInfoChange"
          class="checkbox-group"
        >
          <el-checkbox
            v-for="module in childModules"
            :key="module.id"
            :label="module.moduleCode"
            :disabled="loading"
            class="module-checkbox"
          >
            {{ module.moduleName }}
          </el-checkbox>
        </el-checkbox-group>
      </div>
    </div>
  </el-form-item>
</template>

<script lang="ts" setup>
import { ref, watch, computed } from 'vue'

interface Props {
  queryParams: any
  baseModules: any[]
  loading: boolean
}

interface Emits {
  (e: 'update:queryParams', value: any): void
  (e: 'change'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

// 计算属性：获取所有子模块（排除一级模块）
const childModules = computed(() => {
  const children: any[] = []
  
  // 确保 baseModules 存在且有值
  if (!props.baseModules || !Array.isArray(props.baseModules)) {
    console.log('baseModules 不存在或不是数组:', props.baseModules)
    return children
  }
  
  // 遍历所有一级模块，获取它们的子模块
  props.baseModules.forEach(module => {
    // 确保 module 存在且 children 是数组
    if (module && module.children && Array.isArray(module.children) && module.children.length > 0) {
      module.children.forEach((child: any) => {
        if (child && child.status === 1) {
          children.push(child)
        }
      })
    }
  })
  
  console.log('子模块列表:', children)
  return children
})

// 本地响应式数据
const localBaseInfo = ref<string[]>([])
const checkAllBase = ref(false)
const isIndeterminateBase = ref(false)

// 初始化 localBaseInfo
const initLocalBaseInfo = () => {
  if (props.queryParams && props.queryParams.baseInfo) {
    localBaseInfo.value = props.queryParams.baseInfo || []
  } else {
    localBaseInfo.value = []
  }
  updateCheckAllState()
}

// 更新全选状态
const updateCheckAllState = () => {
  const totalCount = childModules.value.length
  const checkedCount = localBaseInfo.value.length
  
  if (totalCount === 0) {
    checkAllBase.value = false
    isIndeterminateBase.value = false
    return
  }
  
  checkAllBase.value = checkedCount === totalCount
  isIndeterminateBase.value = checkedCount > 0 && checkedCount < totalCount
}

// 全选处理
const handleCheckAllBaseChange = (val: boolean) => {
  localBaseInfo.value = val ? childModules.value.map(module => module.moduleName) : []
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
  () => props.queryParams?.baseInfo,
  (newValue) => {
    localBaseInfo.value = newValue || []
    updateCheckAllState()
  },
  { immediate: true }
)

// 监听基础模块变化
watch(
  () => props.baseModules,
  (newModules) => {
    console.log('baseModules 变化:', newModules)
    updateCheckAllState()
  },
  { deep: true, immediate: true }
)

// 初始化
initLocalBaseInfo()
</script>

<style scoped>
.checkbox-container {
  width: 100%;
}

.checkbox-row {
  display: flex;
  align-items: center;
  gap: 20px;
  flex-wrap: nowrap;
  width: 100%;
}

.check-all {
  flex-shrink: 0;
  white-space: nowrap;
  margin-right: 0;
}

.checkbox-group {
  display: flex;
  flex-wrap: wrap;
  gap: 12px 24px;
  align-items: center;
  flex: 1;
  min-width: 0;
}

.module-checkbox {
  white-space: nowrap;
}

:deep(.el-checkbox) {
  margin-right: 0;
  white-space: nowrap;
}

/* 确保在小屏幕上也能正常显示 */
@media (max-width: 1200px) {
  .checkbox-row {
    gap: 15px;
  }
  
  .checkbox-group {
    gap: 10px 20px;
  }
}
</style>