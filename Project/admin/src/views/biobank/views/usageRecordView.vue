<template>
  <el-dialog v-model="localShow" class="full-dialog" width="980px" @open="handleDialogOpen">
    <template #title>
      <div style="text-align: center">使用记录</div>
    </template>
    <div>
      <el-table :data="localData">
        <el-table-column label="序号" prop="id" />
        <el-table-column label="使用者" prop="createBy" />
        <el-table-column label="使用管号" prop="tubeNo" />
        <el-table-column label="所属盒号" prop="boxNo" />
        <el-table-column label="所属柜名"  prop="freezerNo"/>
        <el-table-column label="行为" prop="action" />
        <el-table-column prop="createTime" label="时间">
            <template #default="{ row }">
              {{ formatTime(row.createTime) }}
            </template>
          </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button
              size="mini"
              type="text"
              @click="handleView(scope.row, scope.index)"
              >查看试管</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <div style="display: flex; justify-content: center">
        <pagination
          :total="total"
          v-model:page="queryParams.pageNum"
          v-model:limit="queryParams.pageSize"
          @pagination="getList"
          layout="prev, pager, next"
        />
      </div>
    </div>
  </el-dialog>
  <!-- 使用提取的试管详情组件 -->
  <TubeDetailDialog 
    :show="tubeDetailDialog" 
    :tube="selectedTube"
    @update:show="tubeDetailDialog = $event"
    @refresh="handleDialogOpen" 
  />

</template>

<script setup lang="ts">
import { ref, watch, onMounted, PropType, toRef } from 'vue'
import { SampleApi } from '@/api/sample'
import TubeDetailDialog from './TubeDetailDialog.vue'

// 定义接口
interface QueryParams {
  pageNum?: number
  pageSize?: number
}

interface TableDataItem {
  id?: number
  // 根据实际情况添加其他字段
}

// 定义props
const props = defineProps({
  show: {
    type: Boolean,
    default: false
  },
  data: {
    type: Array as PropType<TableDataItem[]>,
    default: () => []
  }
})

// 定义emits
const emit = defineEmits(['update:show'])

// 响应式数据
const localData = ref<TableDataItem[]>([{ id: 1 }])
const localShow = ref(props.show)
const total = ref(0)
const queryParams = ref<QueryParams>({})

// 试管详情相关
const tubeDetailDialog = ref(false)
const selectedTube = ref<any>(null)

// 正确监听props.show的变化 - 方法1：使用toRef
const showRef = toRef(props, 'show')
watch(showRef, (val) => {
  localShow.value = val
})

// 方法2：使用getter函数（推荐）
watch(() => props.show, (val) => {
  localShow.value = val
})

// 监听localShow的变化
watch(localShow, (val) => {
  emit('update:show', val)
})

// 方法
const handleView = async (row: TableDataItem, index: number) => {
  try {
    // 根据使用记录获取试管详情
    const tubeDetail = await SampleApi.getSample(row.bioSampleId)
    selectedTube.value = tubeDetail
    tubeDetailDialog.value = true
  } catch (error) {
    console.error('获取试管详情失败:', error)
    ElMessage.error('获取试管详情失败')
  }
}
// 对话框打开事件
const handleDialogOpen = () => {
  getList()
  emit('refresh')
}

// 获取历史记录列表
const getList = async () => {
  try {
    const response = await SampleApi.getSampleHistoryPage()  
      localData.value = response.list
      total.value = response.total
  } catch (error) {
    console.error('获取样本历史记录失败:', error)
    ElMessage.error('获取历史记录失败')
  } finally {
  }
}

const formatTime = (time: string | number) => {
  if (!time) return ''
  const date = new Date(time)
  const y = date.getFullYear()
  const m = String(date.getMonth() + 1).padStart(2, '0')
  const d = String(date.getDate()).padStart(2, '0')
  const hh = String(date.getHours()).padStart(2, '0')
  const mm = String(date.getMinutes()).padStart(2, '0')
  const ss = String(date.getSeconds()).padStart(2, '0')
  return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
}
</script>

<style scoped>
.full-dialog {
  :deep(.centered-title .el-dialog__title) {
    text-align: center;
  }

  :deep(.el-dialog__body) {
    padding: 0px 0px 30px 0;
  }

  :deep(.pagination-container .el-pagination) {
    position: initial;
  }
}
</style>